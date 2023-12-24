;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm150 0
)

(local
	oldSpeed
	popping
	[screwPts 25] = [2 0 100 141 2 1 100 141 2 2 100 141 2 3 100 125 2 4 104 96 2 5 98 94 -32768]
)

(procedure (RoomFeats)
	(table approachVerbs: 3 4 10 11 2 init:) ; Do, Inventory, Zipper, Taste/Smell, Look
	(light init:)
	(underwear approachVerbs: 3 4 10 11 init:) ; Do, Inventory, Zipper, Taste/Smell
	(bed approachVerbs: 3 4 10 11 2 init:) ; Do, Inventory, Zipper, Taste/Smell, Look
	(clothesline init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
	(theSign init:)
	(windowsill init:)
	(herBreast dispose:)
	(herFace dispose:)
	(herCrack dispose:)
	(bedpost dispose:)
)

(procedure (CloseupFeats)
	(herBreast init:)
	(herFace init:)
	(herCrack init:)
	(bedpost init:)
	(table dispose:)
	(light dispose:)
	(underwear dispose:)
	(bed dispose:)
	(clothesline dispose:)
	(theSign dispose:)
	(windowsill dispose:)
)

(instance rm150 of LLRoom
	(properties
		picture 150
	)

	(method (init)
		(LoadMany rsVIEW 150 151 152 803)
		(Load rsPIC 155)
		(LoadMany rsSOUND 150 151 155 148)
		(if (or (!= (gTheMusic number:) 148) (== (gTheMusic prevSignal:) -1))
			(gTheMusic number: 148 loop: -1 vol: 127 flags: 1 play:)
		)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 144 104 114 104 86 121 149 121 134 139 65 142 65 148 241 148 237 139 218 139 218 132 228 132 212 115 125 115 125 109 149 109 149 -1 319 0 319 189 0 189 0 0 144 0
					yourself:
				)
		)
		(switch gPrevRoomNum
			(140
				(HandsOff)
				(gEgo init:)
				(self setScript: sFromStairs)
			)
			(160
				(HandsOff)
				(gCurRoom setScript: sFromWindow)
			)
			(else
				(gEgo init: posn: 170 160)
			)
		)
		(gEgo setPri: -1 actions: egoActions)
		(gEHead actions: egoActions)
		(super init:)
		(theHooker cycleSpeed: gHowFast init: approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		(if (IsFlag 35) ; fScoredHooker
			(theHooker z: 6 setCel: 0 setLoop: 7 setScript: sSmoke)
		else
			(theHooker stopUpd:)
			(hookerHead cycleSpeed: gHowFast init: approachVerbs: 3 4 10 11 5) ; Do, Inventory, Zipper, Taste/Smell, Talk
		)
		(if (== ((gInventory at: 9) owner:) 150) ; candy
			(candy init: approachVerbs: 3 4 10 11 stopUpd:) ; Do, Inventory, Zipper, Taste/Smell
		)
		(if (IsFlag 16) ; fHookerWindowOpen
			(aWindow cel: 2)
		)
		(aWindow cycleSpeed: gHowFast approachVerbs: 3 4 10 11 init: stopUpd:) ; Do, Inventory, Zipper, Taste/Smell
		(RoomFeats)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (gEgo mover:) (== (gCurRoom curPic:) 155))
			(gEgo setMotion: 0)
			(sCloseup state: 6 cue:)
		)
		(cond
			(script)
			((SteppedOn gEgo 16384)
				(HandsOff)
				(self setScript: sDownstairs)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(if (!= 150 (gCurRoom curPic:))
			(switch theVerb
				(2 ; Look
					(Print 150 0) ; "Until now, you were unsure of how a "professional," would look."
					(Print 150 1) ; "Now you know."
					(Print 150 2 #at -1 140) ; "(You were happier before!)"
				)
				(3 ; Do
					(Print 150 3) ; "This is your favorite part, ain' it, Honey?"
				)
				(5 ; Talk
					(Print 150 4) ; ""Nice mandibles," you offer."
					(Print 150 5) ; ""You don' think I'm saggy?" she replies, no Rhodes scholar."
				)
				(10 ; Zipper
					(Print 150 6) ; "She says, "Sorry, Mister, but all you gets is `Straight Ahead' wit' me.""
				)
				(11 ; Taste/Smell
					(Print 150 7) ; "Sniffing the air, you're suddenly hungry for tuna."
				)
				(else
					(super doVerb: theVerb invItem)
				)
			)
		else
			(switch theVerb
				(2 ; Look
					(Print 150 8) ; "You are in the hooker's seedy bedroom. The room's a mess, ditto the hooker!"
				)
				(11 ; Taste/Smell
					(Print 150 7) ; "Sniffing the air, you're suddenly hungry for tuna."
				)
				(4 ; Inventory
					(switch invItem
						(16 ; ribbon
							(Print 150 9) ; "Your ribbon is not long enough to reach outside."
						)
						(else
							(super doVerb: theVerb invItem)
						)
					)
				)
				(else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(class egoActions of Code
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					(
						(and
							(== (gEgo view:) 803)
							(not
								(and
									(== (gEgo view:) 803)
									(== (gEgo loop:) 0)
								)
							)
						)
						(Print 150 10) ; "Come on, my big stud-muffin! Come to Mama!"
					)
					((== (gEgo view:) 803)
						(Print 150 11) ; "You're really proud of your man-like chest."
					)
				)
			)
			(3 ; Do
				(cond
					(
						(and
							(== (gEgo view:) 803)
							(not
								(and
									(== (gEgo view:) 803)
									(== (gEgo loop:) 0)
								)
							)
						)
						(gCurRoom setScript: sGetDressed)
						(return 1)
					)
					((IsFlag 43) ; fWearingRubber
						(ClearFlag 43) ; fWearingRubber
						(gEgo put: 8 0) ; lubber
						(Points 87 1)
						(Print 150 12) ; "Good idea. You carefully remove your lubber and dispose of it in a way that will not be described here."
					)
					((IsFlag 35) ; fScoredHooker
						(Print 150 13) ; "Not again! A guy can only take so much!!"
					)
					(else
						(gCurRoom setScript: sGetUndressed)
						(return 1)
					)
				)
			)
			(10 ; Zipper
				(cond
					(
						(and
							(== (gEgo view:) 803)
							(not
								(and
									(== (gEgo view:) 803)
									(== (gEgo loop:) 0)
								)
							)
						)
						(gCurRoom setScript: sScrew)
						(return 1)
					)
					((IsFlag 35) ; fScoredHooker
						(Print 150 13) ; "Not again! A guy can only take so much!!"
					)
					(else
						(gCurRoom setScript: sGetUndressed)
						(return 1)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(8 ; lubber
						(cond
							((IsFlag 43) ; fWearingRubber
								(Print 150 14) ; "You already are wearing your "lubber.""
							)
							((IsFlag 35) ; fScoredHooker
								(Print 150 15) ; "Now's a great time to think of that! A little late now, isn't it, Larry?"
							)
							(
								(and
									(== (gEgo view:) 803)
									(== (gEgo loop:) 0)
								)
								(Print 150 16) ; "With your pants still on?"
							)
							((not (== (gEgo view:) 803))
								(Print 150 17) ; "With all your clothes on?"
							)
							(else
								(Print 150 18) ; "Yep! This would be a perfect time! Your Surgeon General is proud!"
								(SetFlag 43) ; fWearingRubber
								((Inv at: 8) state: 1) ; lubber
								(Points 96 10)
								(return 1)
							)
						)
					)
				)
			)
		)
	)
)

(instance sGetUndressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (gEgo view:) 803) (== (gEgo loop:) 0))
					(++ state)
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 100 141 self)
				)
			)
			(1
				(gEgo egoSpeed: setHeading: 0 self)
			)
			(2
				(gEgo
					view: 803
					setLoop:
						(if
							(and
								(== (gEgo view:) 803)
								(== (gEgo loop:) 0)
							)
							1
						else
							0
						)
					setCel: 0
					cycleSpeed: gHowFast
					setCycle: End self
				)
			)
			(3
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sGetDressed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo cycleSpeed: (* 2 gHowFast) setCycle: Beg self)
			)
			(1
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(2
				(= cycles 60)
			)
			(3
				(Print 150 19) ; "Ahh. That feels better."
				(HandsOn)
				(NormalEgo 3)
				(self dispose:)
			)
		)
	)
)

(instance sFromStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 141 111 setMotion: MoveTo 124 106 self)
			)
			(1
				(gEgo setMotion: MoveTo 118 112 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDownstairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 145 111 self)
			)
			(1
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance sCloseup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eyesProp setScript: sBlink)
				(herMouth setCycle: Fwd)
				(= seconds (Random 3 6))
			)
			(1
				(herMouth setCycle: End)
				(= seconds (Random 2 4))
			)
			(2
				(herMouth setCycle: Fwd)
				(= cycles (Random 3 6))
			)
			(3
				(herMouth setCycle: End)
				(= seconds 2)
			)
			(4
				(herMouth setCycle: Fwd)
				(= cycles (Random 3 6))
			)
			(5
				(if (IsFlag 20) ; fMouthSmellsBad
					(Print 150 20) ; "Jeez, Mister!" cries the hooker, "What've you been eating? Buffalo chips???"
				else
					(Print 150 21) ; "She certainly seems to enjoy that gum."
				)
				(= seconds 2)
			)
			(6
				(herMouth setCycle: End self)
			)
			(7
				(HandsOff)
				(= cycles 1)
			)
			(8
				(eyesProp z: 1000 setScript: 0 dispose:)
				(herMouth z: 1000 dispose:)
				(RoomFeats)
				(gCurRoom drawPic: 150)
				(gCast eachElementDo: #show)
				((ScriptID 0 25) loop: 0 cursor: 100) ; icon0
				(Animate (gCast elements:) 0)
				(NormalEgo)
				(InitEgoHead)
				(= cycles 1)
			)
			(9
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 25 250))
			)
			(1
				(eyesProp setCycle: Beg self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sScrew of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheMusic number: 150 play:)
				(gEgo
					setLoop: 2
					setCel: 0
					setPri: (+ (theHooker priority:) 1)
					setCycle: MCyc @screwPts self
				)
			)
			(1
				(= oldSpeed gSpeed)
				(= gSpeed 0)
				(theHooker z: 1000 hide:)
				(gEgo z: 1000 setPri: -1)
				(hookerHead dispose:)
				(censor init: setCycle: Fwd viewer: humpCycler)
				(= seconds (Random 7 13))
			)
			(2
				(censor setLoop: 1)
				(= seconds (Random 4 7))
			)
			(3
				(censor setLoop: 0)
				(= seconds (Random 7 13))
			)
			(4
				(censor viewer: 0 setCycle: Fwd cycleSpeed: 0)
				(= seconds 3)
			)
			(5
				(censor setCycle: End cycleSpeed: 3)
				(= seconds 3)
			)
			(6
				(censor setCycle: CT 4 1 cycleSpeed: 3)
				(= seconds 3)
			)
			(7
				(= gSpeed oldSpeed)
				(censor z: 1000 dispose:)
				(theHooker z: 6 show: setCel: 0 setLoop: 7)
				(gEgo
					egoSpeed:
					x: 100
					y: 141
					z: 0
					cycleSpeed: 4
					setCel: 255
					setCycle: Beg self
				)
			)
			(8
				(gTheMusic number: 148 play:)
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg)
				(= seconds 3)
			)
			(9
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg)
				(= seconds 3)
			)
			(10
				(SetFlag 35) ; fScoredHooker
				(Points 90 11)
				(NormalEgo 3)
				(theHooker setScript: sSmoke)
				(= cycles 60)
			)
			(11
				(Print 150 22) ; "Although successful, you feel less than satisfied. Technically speaking, you're no longer a virgin, but for some reason, the thrill just wasn't there. You vow to continue your quest until you please your heart, not just your other organs!"
				(if (IsFlag 43) ; fWearingRubber
					(Print 150 23) ; "It's a good thing you were wearing your raincoat!"
				else
					(SetFlag 15) ; fHasClap
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					egoSpeed:
					x: 241
					y: 124
					view: 151
					setLoop: 3
					setCel: 0
					cycleSpeed: gLarrySpeed
					setCycle: End self
				)
			)
			(1
				(gTheMusic fade:)
				(gEgo userSpeed:)
				(gCurRoom newRoom: 160)
			)
		)
	)
)

(instance sFromWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fakeEgo cycleSpeed: gLarrySpeed init: setCycle: Beg self)
			)
			(1
				(fakeEgo z: 1000 dispose:)
				(gEgo init: x: 228 y: 132 loop: 0 setHeading: 270)
				(InitEgoHead)
				(= cycles 10)
			)
			(2
				(NormalEgo 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetCandy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: view: 808 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(candy dispose:)
				(Points 65 2)
				(gEgo get: 9 setCycle: Beg self) ; candy
			)
			(2
				(NormalEgo 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sOpenWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					egoSpeed:
					normal: 0
					view: 151
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gTheMusic3 number: 151 play:)
				(SetFlag 16) ; fHookerWindowOpen
				(aWindow setCycle: End)
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sSmoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 10))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance hookerHead of Prop
	(properties
		z 14
		approachX 100
		approachY 141
		view 152
		loop 5
		priority 9
		signal 16400
	)

	(method (init)
		(self
			x: (theHooker x:)
			y: (theHooker y:)
			cycleSpeed: 6
			setCycle: ForwardCounter 6 self
		)
		(self cue:)
		(super init:)
	)

	(method (cue)
		(super cue:)
		(if (or (== loop 2) (== loop 5))
			(self setLoop: (+ (self loop:) 1) setCel: 0 setCycle: End self)
		else
			(self
				setLoop: (if (> (self loop:) 3) 5 else 2)
				setCycle: ForwardCounter (Random 5 15) self
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (< (gEgo x:) 126) (> (gEgo y:) 136))
				(if (> loop 3)
					(self setLoop: (- loop 3))
				)
			)
			((< loop 4)
				(self setLoop: (+ loop 3))
			)
		)
		(cond
			((and (== cel 7) (!= (gCurRoom curPic:) 155) (not popping))
				(= popping 1)
				(gumSound number: 155 play:)
			)
			((!= cel 7)
				(= popping 0)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Zipper
				(Print 150 24) ; "She says, "Sorry, Mister, but all you gets is `Straight Ahead' wit' me.""
			)
			(else
				(theHooker doVerb: theVerb invItem)
			)
		)
	)
)

(instance theHooker of Person
	(properties
		x 69
		y 112
		z 6
		description {the hooker}
		approachX 100
		approachY 141
		view 152
		priority 9
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((IsFlag 35) ; fScoredHooker
						(Print 150 25) ; "She seems more interested in that cigarette than she was in you."
					)
					((== (gEgo view:) 803)
						(Print 150 26) ; "NOW!? You've come this far, Larry; now's the time to do more than just look!"
					)
					(else
						(gEgo setMotion: 0)
						(gCast eachElementDo: #hide)
						(herMouth cycleSpeed: gLarrySpeed init: z: 0)
						(eyesProp cycleSpeed: (+ gHowFast 1) init: z: 11)
						(CloseupFeats)
						(gCurRoom drawPic: 155 setScript: sCloseup)
						((ScriptID 0 25) loop: 15 cursor: 106) ; icon0
						(Animate (gCast elements:) 0)
					)
				)
			)
			(3 ; Do
				(cond
					((and (== (gEgo view:) 803) (== (gEgo loop:) 0))
						(Print 150 16) ; "With your pants still on?"
					)
					((not (== (gEgo view:) 803))
						(Print 150 17) ; "With all your clothes on?"
					)
					(else
						(gCurRoom setScript: sScrew)
					)
				)
			)
			(5 ; Talk
				(if (IsFlag 35) ; fScoredHooker
					(Print 150 27) ; ""Was it good for you, baby?" you ask her."
					(Print 150 28) ; ""Was what good?" she replies."
				else
					(Print 150 29) ; "So," she snarls, "you just gonna stand there, or what?"
				)
			)
			(11 ; Taste/Smell
				(Print 150 30) ; "From here, her perfume smells cheap and overpowering."
				(Print 150 31 #at -1 140) ; "(Also from the next county, you suppose!)"
			)
			(10 ; Zipper
				(cond
					((and (== (gEgo view:) 803) (== (gEgo loop:) 0))
						(Print 150 16) ; "With your pants still on?"
					)
					((not (== (gEgo view:) 803))
						(Print 150 17) ; "With all your clothes on?"
					)
					(else
						(gCurRoom setScript: sScrew)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(Print 150 32) ; "I don' need dat, Honey. Didn't ju pay downstairs?"
					)
					(2 ; watch
						(Print 150 33) ; "Dat's right, Honey," she gums, "yore time's runnin' out."
					)
					(4 ; ring
						(Print 150 34) ; "No commitments, Honey. This is a biz'nus deal!"
					)
					(6 ; remoteControl
						(Print 150 35) ; "You jes' gonna stand there and play with your li'l remote?"
					)
					(8 ; lubber
						(Print 150 36) ; "Yeah, them's a good idea. Lemme see that'n. Well, how 'bout dat! I didn't know they came in `Extra Small!'"
					)
					(9 ; candy
						(Print 150 37) ; "Naw, Nuggie, none for me. But I jes' had me a john that gimme a box a' candy jus' like that'n."
					)
					(10 ; discoPass
						(Print 150 38) ; "Why waste yore time at the disco? We kin do the horizontal bop right here!"
					)
					(12 ; wine
						(Print 150 39) ; "Honey, dinner an' drinks ain' necessary here!"
					)
					(13 ; magazine
						(Print 150 40) ; "I've seen better!"
					)
					(15 ; pills
						(Print 150 41) ; "I hardly need extrinsic motivation!"
					)
					(16 ; ribbon
						(Print 150 42) ; "No S. and M. here, buddy!"
					)
					(11 ; pocketKnife
						(Print 150 43) ; "Honey, you don' need no knife. You can assault me with YORE deadly weapon!"
					)
					(17 ; graffiti
						(Print 150 44) ; "He did? Ain't he the sweetest? He's always sendin' me bizness!"
					)
					(else
						(Print 150 45) ; "Say, Honey-chil', whacha come up here for--bartering?"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance candy of View
	(properties
		x 239
		y 124
		description {the box of candy}
		approachX 228
		approachY 132
		view 150
		loop 1
		priority 9
		signal 16
	)
)

(instance aWindow of Prop
	(properties
		x 250
		y 110
		z 20
		description {the window}
		approachX 228
		approachY 132
		lookStr {There is a fire escape outside the window.}
		view 150
		cel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((== (gEgo view:) 803)
						(Print 150 46) ; "NOW!?"
					)
					((IsFlag 16) ; fHookerWindowOpen
						(HandsOff)
						(gCurRoom setScript: sExitWindow)
					)
					(else
						(HandsOff)
						(gCurRoom setScript: sOpenWindow)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance eyesProp of Prop
	(properties
		x 147
		y 75
		z 11
		description {her eyes}
		view 155
		signal 24576
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 150 47) ; "What smoldering eyes!"
			)
			(else
				(herFace doVerb: theVerb invItem)
			)
		)
	)
)

(instance herMouth of Prop
	(properties
		x 146
		y 83
		description {her mouth}
		view 155
		loop 1
		cel 2
		signal 24576
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 150 48) ; "Look out! It's the "Jaws of Life!""
			)
			(else
				(herFace doVerb: theVerb invItem)
			)
		)
	)
)

(instance censor of Actor
	(properties
		x 89
		y 115
		view 151
		priority 9
		signal 16400
	)
)

(instance fakeEgo of Prop
	(properties
		x 241
		y 124
		view 151
		loop 3
		cel 6
	)
)

(instance table of Feature
	(properties
		x 239
		y 126
		nsTop 116
		nsLeft 229
		nsBottom 136
		nsRight 249
		description {the table}
		sightAngle 40
		approachX 228
		approachY 132
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (ObjInRoom 9))
					(Print 150 49) ; "It's a really ugly table."
				else
					(Print 150 50) ; "There is a box of candy on the hooker's table. Probably a gift from some admirer, you suppose."
				)
			)
			(3 ; Do
				(cond
					((not (ObjInRoom 9))
						(Print 150 51) ; "You can't take her table. She's nailed it to the floor."
					)
					((== (gEgo view:) 803)
						(Print 150 46) ; "NOW!?"
					)
					(else
						(HandsOff)
						(gCurRoom setScript: sGetCandy)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 176
		y 131
		z 68
		nsTop 55
		nsLeft 160
		nsBottom 72
		nsRight 192
		description {the light}
		sightAngle 40
		lookStr {The lamp casts a yellow pallor over the hooker's parlor.}
	)
)

(instance underwear of Feature
	(properties
		x 207
		y 160
		z 48
		nsTop 98
		nsLeft 195
		nsBottom 127
		nsRight 220
		description {her underwear}
		sightAngle 40
		approachX 207
		approachY 148
		lookStr {The clothesline is barely strong enough to hold its present load. Poor girl, you'd think at these prices she could afford a laundromat.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 150 52) ; "Although you would look precious in that little white lace number, you're just not that kind of guy!"
			)
			(11 ; Taste/Smell
				(Print 150 53) ; "The hooker's underwear are not of the edible variety."
			)
			(4 ; Inventory
				(switch invItem
					(11 ; pocketKnife
						(clothesline doVerb: 3)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bed of Feature
	(properties
		x 97
		y 110
		nsTop 106
		nsLeft 57
		nsBottom 137
		nsRight 137
		description {the bed}
		sightAngle 40
		approachX 100
		approachY 141
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(11 ; Taste/Smell
				(Print 150 54) ; "The bed smells of stale cigarette smoke."
			)
			(else
				(theHooker doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance clothesline of Feature
	(properties
		x 207
		y 155
		z 53
		description {the clothesline}
		sightAngle 40
		onMeCheck 4096
		approachX 207
		approachY 148
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 150 55) ; "The clothesline is barely strong enough to hold its present light load. Besides, if you take it, her underwear would fall down."
				(Print 150 56 #at -1 140) ; "(And you know how em-bare-assing THAT would be!)"
			)
			(4 ; Inventory
				(switch invItem
					(11 ; pocketKnife
						(Print 150 57) ; "Although the pocket knife is sharp enough, you have no need to hassle this poor girl."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance theSign of Feature
	(properties
		x 40
		y 79
		nsTop 68
		nsLeft 27
		nsBottom 91
		nsRight 53
		description {the small sign over the hooker's bed}
		sightAngle 40
		approachX 40
		approachY 79
		lookStr {The sign over the hooker's bed reads, "Substantial penalty for early withdrawal!"}
	)
)

(instance windowsill of Feature
	(properties
		x 157
		y 170
		nsTop 152
		nsLeft 11
		nsBottom 189
		nsRight 303
		description {the window sill}
		sightAngle 40
		lookStr {Someone has yet to kick the habit!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 150 58) ; "You have no use for cigarette butts."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance herBreast of Feature
	(properties
		x 156
		y 158
		nsTop 139
		nsLeft 105
		nsBottom 177
		nsRight 207
		description {her breast}
		sightAngle 40
		lookStr {"Is that all you came up here to do, Honey? LOOK!?"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Zipper
				(Print 150 59) ; "Yeah, Larry! You should be so lucky!"
			)
			(11 ; Taste/Smell
				(Print 150 60) ; "To you, they taste slightly salty."
			)
			(3 ; Do
				(Print 150 61) ; "Is that all you came up those stairs for, Honey? To cop a little feel?"
			)
			(5 ; Talk
				(Print 150 62) ; ""Mmmmmbbbblllemmm," you mumble, imagining your face buried in that valley."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance herFace of Feature
	(properties
		x 146
		y 74
		nsTop 49
		nsLeft 122
		nsBottom 99
		nsRight 171
		description {her face}
		sightAngle 40
		lookStr {"You think I'm pretty, doncha Honey?" gums the hooker.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 150 63) ; ""Is that all you want to do, Honey?" she asks."
			)
			(5 ; Talk
				(Print 150 64) ; ""Nice mandibles," you offer."
				(Print 150 5) ; ""You don' think I'm saggy?" she replies, no Rhodes scholar."
			)
			(10 ; Zipper
				(Print 150 65) ; "Hey, baby," she groans, "none o' dat. `Straight ahead' is all you get!"
			)
			(11 ; Taste/Smell
				(Print 150 66) ; "You recognize that cologne: "Eau de Toilette Cie't!""
			)
			(4 ; Inventory
				(theHooker doVerb: theVerb invItem &rest)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance herCrack of Feature
	(properties
		x 65
		y 20
		nsLeft 29
		nsBottom 41
		nsRight 102
		description {the crack}
		sightAngle 40
		lookStr {Is that why you came up here? To look at a crack?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 150 67) ; "Get your hand out of the crack!"
			)
			(5 ; Talk
				(Print 150 68) ; "You can't imagine putting your tongue in THAT crack!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bedpost of Feature
	(properties
		x 301
		y 82
		nsLeft 283
		nsBottom 165
		nsRight 319
		description {the bedpost}
		sightAngle 40
		lookStr {That's where she leaves her chewing gum overnight.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 150 69) ; "No, there's no chewing gum losing its flavor on THAT bedpost."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance gumSound of Sound
	(properties
		flags 1
		prevSignal -1
	)
)

(instance humpCycler of Code
	(properties)

	(method (doit)
		(if (not (Random 0 30))
			(censor cycleSpeed: (Random 0 5))
		)
	)
)

