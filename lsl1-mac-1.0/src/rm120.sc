;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm120 0
)

(local
	drunkMessage
	seenTPmsg
	nutsMessage
	whichMessage
	[RATPTS 33] = [2 0 249 128 2 1 225 119 2 2 202 130 2 3 196 136 2 4 188 134 2 5 167 117 2 6 142 87 2 7 121 63 -32768]
)

(instance rm120 of LLRoom
	(properties
		picture 120
		east 130
		south 110
	)

	(method (init)
		(LoadMany rsSOUND 111 110 801 802 121)
		(LoadMany rsVIEW 120 122 808)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 313 189 259 152 213 149 210 145 240 142 240 140 213 140 211 136 242 135 227 128 215 128 192 118 140 118 137 133 100 146 85 146 85 153 107 158 107 163 77 174 81 182 81 189
					yourself:
				)
		)
		(gEgo init:)
		(switch gPrevRoomNum
			(110
				(if (and (Random 0 1) (== (gGame detailLevel:) 3))
					(aRat cycleSpeed: global101 init: setScript: sRatScript)
				)
			)
			(130
				(aDoor setCel: 255)
				(HandsOff)
				(self setScript: sFromToilet)
				(gTheMusic number: 110 loop: -1 flags: 1 play: 90)
			)
			(else
				(gEgo posn: 160 160)
			)
		)
		(if (== ((Inv at: 7) owner:) 120) ; rose
			(aRose init: approachVerbs: 3 4 10 11 stopUpd:) ; Do, Inventory, Zipper, Taste/Smell
			(table
				lookStr:
					{There is a single, lovely, long-stemmed, red rose in a delicate bud vase standing incongruously on the table.}
			)
		else
			(table
				lookStr:
					{Isn't it funny how you can see the top of that table even though you're looking at it from the side?}
			)
		)
		(aDoor cycleSpeed: global101 init: stopUpd: approachVerbs: 3) ; Do
		(aDrunk cycleSpeed: global101 init: stopUpd: approachVerbs: 3 5 4) ; Do, Talk, Inventory
		(drunkHead cycleSpeed: global101 init: approachVerbs: 3 5 4) ; Do, Talk, Inventory
		(drunkLeg init: stopUpd: approachVerbs: 3 5 4) ; Do, Talk, Inventory
		(drunkArm cycleSpeed: global101 init: approachVerbs: 3 5 4) ; Do, Talk, Inventory
		(boxes init:)
		(barrels init:)
		(table init: approachVerbs: 3) ; Do
		(transom init:)
		(theFan init:)
		(theLight init:)
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			(
				(and
					(IsFlag 40) ; fToiletPaperOnShoe
					(> (gEgo y:) 140)
					(not drunkMessage)
					(not seenTPmsg)
					(== gPrevRoomNum 130)
				)
				(= drunkMessage 4)
				(= seenTPmsg 1)
				(aDrunk setScript: sDrunkTalks)
			)
			((SteppedOn gEgo 4)
				(if (> nutsMessage -1)
					(if whichMessage
						(Print 120 0) ; "Wadda ya tryin' to do; make me a soprano??"
						(= whichMessage 0)
					else
						(Print 120 1) ; "Geeze! Them pointy-toed shoes hurt!"
						(= whichMessage 1)
					)
				)
				(= nutsMessage -1)
			)
			((and (SteppedOn gEgo 8) (< nutsMessage 0))
				(= nutsMessage 1)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 120 2) ; "You are in a dimly lit hallway. The paint peeling off the walls gives the cockroaches something to watch. An old table is pushed against the west wall. A filthy drunk wearing filthy clothes sits on the filthy floor, leaning his filthy back against the filthy wall."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance sRatScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (< (gEgo distanceTo: aRat) 80) (< state 2))
			(self state: 1)
			(= cycles 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aRat setCycle: End)
				(= seconds (Random 3 6))
			)
			(1
				(self init:)
			)
			(2
				(aRat
					setLoop: 2
					setCel: 0
					setPri: (- (gEgo priority:) 2)
					setCycle: MCyc @RATPTS self
				)
			)
			(3
				(aRat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sFromToilet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					x: 262
					y: 125
					setPri: (- (gEgo priority:) 2)
					setMotion: PolyPath 216 130 self
				)
			)
			(1
				(gTheMusic3 number: 802 loop: 1 play:)
				(aDoor setCycle: Beg self)
				(gEgo setPri: -1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sToToilet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic3 number: 801 loop: 1 play:)
				(aDoor setCycle: End)
				(gEgo
					egoSpeed:
					setPri: (- (gEgo priority:) 1)
					setMotion: MoveTo 262 (gEgo y:) self
				)
			)
			(1
				(gEgo userSpeed: setPri: -1)
				(gTheMusic fade:)
				(gCurRoom newRoom: 130)
			)
		)
	)
)

(instance sDrunkTalks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (drunkHead loop:) 1)
					(drunkHead setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(drunkHead loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(switch drunkMessage
					(1
						(Print 120 3) ; "Hiya shhhhonny. How's 'bout you 'n' me havin' a lil' drink?"
					)
					(4
						(Print 120 4) ; "Jeeezz! Somethin' die in there??"
					)
				)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sDrunkDrinks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (drunkHead loop:) 1)
					(drunkHead setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo egoSpeed: view: 808 loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(drunkArm loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setCycle: Beg self)
				(drunkArm setCycle: Beg)
			)
			(4
				(drunkHead loop: 3 cel: 0 setCycle: End self)
			)
			(5
				(gTheMusic3 number: 111 loop: 1 play: self)
				(Print 120 5 #at -1 20 #dispose) ; "Glug, glug, glug, glug, glug."
			)
			(6
				(NormalEgo 0)
				(HandsOn)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(drunkHead setCycle: Beg self)
			)
			(7
				(drunkHead loop: 2 cel: 0 setCycle: End self)
			)
			(8
				(switch drunkMessage
					(2
						(Print 120 6) ; "Shhaay, thanksh buddy! How 'bout sshhom'ore?"
					)
					(3
						(Print 120 7) ; "Slurp! "Ahhhh! That did hit the ol' spot!""
						(Print 120 8) ; ""Ya know, ya mus' be ma only frien' in the whole world! Shhoooo, I'm gonna give ya my only posshhess... hhic!"
						(gTheMusic3 number: 121 setLoop: 1 play:)
						(Print 120 9) ; ""...my only posshhess... hhic!"
						(gTheMusic3 play:)
						(Print 120 9) ; ""...my only posshhess... hhic!"
						(gTheMusic3 play:)
						(Print 120 9) ; ""...my only posshhess... hhic!"
						(gTheMusic3 play:)
						(if
							(or
								(gEgo mover:)
								(!= (gEgo x:) 229)
								(!= (gEgo y:) 143)
							)
							(Print 120 10) ; "Oh well, since you're leavin' anyway, jes' forgit it."
							(= drunkMessage 2)
						else
							(HandsOff)
							(Print 120 11) ; "...all I got in the world."
							(Print 120 12) ; "Besides, what'sha guy like me need witta television remote control!?"
						)
					)
				)
				(if (== drunkMessage 3)
					(+= state 1)
				)
				(= cycles 1)
			)
			(9
				(self dispose:)
			)
			(10
				(drunkArm loop: 5 cel: 0 setCycle: End self)
			)
			(11
				(Points 75 2)
				(gEgo
					egoSpeed:
					get: 6 ; remoteControl
					view: 808
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(12
				(gEgo setCycle: Beg self)
			)
			(13
				(drunkArm loop: 5 cel: 0 setCycle: Beg self)
			)
			(14
				(NormalEgo 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetRose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: view: 808 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(aRose z: 1000 dispose:)
				(Points 78 1)
				(gEgo setCycle: Beg self)
			)
			(2
				(table
					lookStr:
						{Isn't it funny how you can see the top of that table even though you're looking at it from the side?}
				)
				(NormalEgo 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance aRose of View
	(properties
		x 107
		y 107
		description {the rose}
		approachX 118
		approachY 142
		lookStr {There is a single, lovely, long-stemmed, red rose in a delicate bud vase standing incongruously on the table.}
		view 120
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(11 ; Taste/Smell
				(Print 120 13) ; "Thoughts of romance are awakened as the scent of the red rose reaches your nostrils."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance drunkHead of Prop
	(properties
		x 256
		y 146
		z 10
		approachX 229
		approachY 143
		view 122
		loop 1
		priority 10
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(aDrunk doVerb: theVerb invItem)
	)
)

(instance drunkArm of Actor
	(properties
		x 251
		y 133
		approachX 229
		approachY 143
		view 122
		loop 4
		priority 10
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(aDrunk doVerb: theVerb invItem)
	)
)

(instance drunkLeg of View
	(properties
		x 246
		y 149
		approachX 229
		approachY 143
		view 122
		loop 6
		priority 10
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(aDrunk doVerb: theVerb invItem)
	)
)

(instance aDrunk of Prop
	(properties
		x 251
		y 141
		description {Robin}
		approachX 229
		approachY 143
		view 122
		priority 9
		signal 16400
	)

	(method (cue)
		(super cue:)
		(Print 120 14) ; "He's a poor little lamb, who has lost his way..."
		(Print 120 15) ; "...and also his bladder control!"
	)

	(method (doVerb theVerb invItem &tmp choice)
		(switch theVerb
			(2 ; Look
				(gEgo
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) (self x:) (self y:))
						self
				)
			)
			(3 ; Do
				(Print 120 16) ; "You take pity on the poor drunk and want to help him, but his odor convinces you otherwise."
			)
			(5 ; Talk
				(= drunkMessage 1)
				(self setScript: sDrunkTalks)
			)
			(11 ; Taste/Smell
				(Print 120 17) ; "You reel back as the putrid stench of the unfortunate assails your senses."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(-- gLarryDollars)
						(Print 120 18) ; "He responds, "Shhay, buddy, thanx for da dollar. Butcha know, whad I could really usshh is a good, sshhtiff belt!""
					)
					(5 ; whiskey
						(gEgo put: 5) ; whiskey
						(if (gEgo has: 6) ; remoteControl
							(= drunkMessage 2)
						else
							(= drunkMessage 3)
						)
						(HandsOff)
						(self setScript: sDrunkDrinks)
					)
					(12 ; wine
						(Print 120 19) ; "Hey, waddaya think, I got no class?" mumbles the drunk. "I'm a whiskey drinker, pure and simple!"
					)
					(2 ; watch
						(Print 120 20) ; ""Know what time it is?" you ask the drunk."
						(Print 120 21) ; ""Time for you t' buy me a drink!" he responds."
					)
					(1 ; breathSpray
						(Print 120 22) ; ""Here, have a shot of this!" you tell the drunk."
						(Print 120 23) ; "Whadt?" he replies, "and ruin my edge?"
					)
					(4 ; ring
						(Print 120 24) ; "It'ssh lovely, but I don't know you well enough to get engagshed!"
					)
					(else
						(Print 120 25) ; "He's a drunk, Larry; there's only one thing he wants."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance aRat of Prop
	(properties
		x 249
		y 128
		description {the rat}
		view 120
		loop 1
		priority 14
		signal 16400
	)
)

(instance aDoor of Prop
	(properties
		x 251
		y 136
		description {the bathroom door}
		approachX 216
		approachY 130
		lookStr {The door bears the scars of too many late night brawls.}
		view 120
		loop 3
		priority 8
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sToToilet)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance boxes of Feature
	(properties
		x 51
		y 45
		nsTop -1
		nsBottom 91
		nsRight 102
		description {the stack of boxes}
		sightAngle 40
		lookStr {You didn't know Lefty was into boxing!}
	)
)

(instance barrels of Feature
	(properties
		x 165
		y 49
		nsLeft 128
		nsBottom 99
		nsRight 202
		description {the barrels}
		sightAngle 40
		lookStr {Those barrels are stacked better than any date you've ever had! But they do look as though they might fall over on top of you at any moment.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 120 26) ; "You can't drink what's in THOSE barrels!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 94
		y 118
		nsTop 95
		nsLeft 86
		nsBottom 142
		nsRight 112
		description {the table}
		sightAngle 40
		approachX 118
		approachY 142
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (not (ObjInRoom 7))
					(Print 120 27) ; "You have no use for such a lovely table."
				else
					(gEgo get: 7) ; rose
					(HandsOff)
					(gCurRoom setScript: sGetRose)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance transom of Feature
	(properties
		x 238
		y 135
		z 80
		nsTop 45
		nsLeft 222
		nsBottom 65
		nsRight 254
		description {the transom}
		sightAngle 40
		lookStr {A rancid glow leaks from the next room.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 120 28) ; "You can't reach that high."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theFan of Feature
	(properties
		x 26
		y 189
		z 158
		nsBottom 63
		nsRight 53
		description {the fan}
		sightAngle 40
		lookStr {This is Lefty's biggest fan!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 120 28) ; "You can't reach that high."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theLight of Feature
	(properties
		x 278
		y 140
		z 120
		nsLeft 257
		nsBottom 41
		nsRight 300
		description {the light}
		sightAngle 40
		lookStr {Lefty thought he ordered a "Bud Light!"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 120 28) ; "You can't reach that high."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

