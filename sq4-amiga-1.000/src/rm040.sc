;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm040 0
)

(local
	[local0 24] = [18 0 160 85 161 105 141 164 173 169 199 148 181 99 182 81 224 0 184 0 167 51 123 0]
	[local24 20] = [78 38 15 0 0 0 0 189 23 189 54 167 51 144 63 144 87 128 74 50]
	[local44 16] = [82 86 108 80 127 81 159 98 158 107 150 130 112 139 86 118]
	[local60 8] = [158 115 144 123 139 120 149 109]
	[local68 18] = [74 77 79 73 162 83 161 99 138 84 114 79 107 79 96 84 81 86]
	[local86 26] = [181 189 214 158 215 148 207 142 198 140 185 99 180 98 181 85 253 94 272 93 294 86 319 68 319 189]
	[local112 32] = [26 189 55 167 52 144 61 144 87 129 86 119 127 151 150 136 139 164 174 169 200 148 198 140 210 144 215 148 214 157 180 189]
	[local144 8] = [152 81 110 76 95 64 106 54]
	[local152 6] = [155 38 171 38 167 52]
	[local158 18] = [241 40 297 0 319 0 319 68 292 87 273 92 255 94 181 84 205 40]
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(gLongSong2 number: 105 vol: 127 loop: 1 play:)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (+ param1 1))
	)
	(= temp2 (Graph grSAVE_BOX temp0 (- param2 1) temp1 (+ param4 1) 1))
	(Graph grDRAW_LINE param1 param2 param3 param4 global143 -1 -1)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
	(Wait 1)
	(Wait 4)
	(Graph grRESTORE_BOX temp2)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
)

(instance rm040 of SQRoom
	(properties
		picture 40
		style 10
		horizon 48
		north 25
		east 45
		south 55
		vanishingX 319
		vanishingY -35
	)

	(method (init)
		(Load rsVIEW 40)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 298 0 251 49 102 49 97 60 102 66 45 97 33 152 68 163 41 189 0 189 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 103 79 181 120 142 144 113 143 60 100 75 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 215 148 179 179 123 169 169 137
					yourself:
				)
		)
		(if (IsFlag 0)
			(LoadMany rsVIEW 7 13)
			(cop1 init:)
		)
		(switch gPrevRoomNum
			(north
				(HandsOff)
				(self setScript: enterScript)
			)
			(south
				(gEgo x: 89)
			)
			(east)
			(else
				(SetFlag 0)
				(NormalEgo 0 0)
				(gEgo posn: 64 81)
				(self setScript: enterScript)
				(gLongSong number: 802 loop: -1 vol: 127 flags: 1 playBed:)
				(cop1 init:)
			)
		)
		(gEgo init:)
		(theTank init:)
		(theSupport init:)
		(thePurpleBldg init:)
		(theLeftBldg init:)
		(theHole init:)
		(street1 init:)
		(street2 init:)
		(sidewalk1 init:)
		(sidewalk2 init:)
		(sidewalk3 init:)
		(sidewalk4 init:)
		(theArea init:)
		(self setRegions: 701) ; street
		(super init:)
		(self setRegions: 705) ; bunny
		(supportPoly points: @local0 size: 12)
		(buildingPoly points: @local24 size: 10)
		(tankPoly points: @local44 size: 8)
		(holePoly points: @local60 size: 4)
		(street1Poly points: @local68 size: 9)
		(street2Poly points: @local86 size: 13)
		(sidewalk1Poly points: @local112 size: 16)
		(sidewalk2Poly points: @local144 size: 4)
		(sidewalk3Poly points: @local152 size: 3)
		(sidewalk4Poly points: @local158 size: 9)
	)

	(method (newRoom newRoomNumber)
		(cond
			(
				(and
					(== (gEgo edgeHit:) 1)
					(!= script exitScript)
					(!= script (ScriptID 701 3)) ; cyborgScreams
					(!= ((ScriptID 701 1) script:) (ScriptID 701 4)) ; deathDroid, droidShoots
				)
				(HandsOff)
				(self setScript: exitScript 0 1)
			)
			((and (== (gEgo edgeHit:) 1) (not (script register:)))
				(super newRoom: newRoomNumber)
			)
			(
				(and
					(== (gEgo edgeHit:) 3)
					(> (gEgo x:) 199)
					(not (IsFlag 0))
					(!= (gCurRoom script:) (ScriptID 701 3)) ; cyborgScreams
					(!= ((ScriptID 701 1) script:) (ScriptID 701 4)) ; deathDroid, droidShoots
				)
				(super newRoom: 60)
			)
			(else
				(super newRoom: newRoomNumber)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 72)
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
					)
				else
					(gEgo
						posn: 333 1
						setLoop: 5
						setMotion: MoveTo 272 49 self
					)
				)
			)
			(1
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 310 -1 self)
			)
			(1
				(= register 0)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance theTank of Feature
	(properties
		x 125
		y 110
		description {tank}
		sightAngle 45
		lookStr {A corroding battle machine vividly reveals why it no longer serves. The structural warpage, not to mention the gaping hole in it, indicates a violent end.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: tankPoly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (or (gCurRoom script:) (gCast contains: closeup))
					0
				else
					(HandsOff)
					(gCurRoom setScript: tankScript)
				)
			)
			(4 ; Inventory
				(switch invItem
					(2 ; bomb
						(HandsOff)
						(gCurRoom setScript: bombScript)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(11 ; Smell
				(Print 40 0) ; "It smells exactly like the hull of a useless, burnt out battle vehicle."
			)
			(10 ; Taste
				(Print 40 1) ; "It needs salt."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tankPoly of Polygon
	(properties)
)

(instance tankScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 154 137 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(if (== ((gInventory at: 2) owner:) 40) ; bomb
					(theBomb init:)
				)
				(closeup init: stopUpd:)
				(= cycles 1)
			)
			(3
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance bombScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 154 137 self)
			)
			(1
				(gEgo setHeading: 315 self)
				(gEgo put: 2 40) ; bomb
				(SetScore 44 -20)
			)
			(2
				(Print 40 2) ; "A very wise choice! Carefully placing the unstable ordnance back inside the tank, you decide some things are better left alone."
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance theSupport of Feature
	(properties
		x 172
		y 154
		description {supports}
		sightAngle 45
		lookStr {The huge building supports miraculously still stand.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: supportPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 40 3) ; "You inhale the smell of the column and file it away in your brain under "Useful Information.""
			)
			(10 ; Taste
				(Print 40 4) ; "Good thing it's not below freezing, or you'd end up spending the whole game with your tongue stuck to the frozen metal."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance supportPoly of Polygon
	(properties)
)

(instance thePurpleBldg of Feature
	(properties
		x 198
		y 15
		nsBottom 200
		nsRight 320
		description {purple building}
		sightAngle 45
		onMeCheck 8192
		lookStr {A battered and boarded purple building stands silently now.}
	)

	(method (doVerb theVerb)
		(theLeftBldg doVerb: theVerb)
	)
)

(instance theLeftBldg of Feature
	(properties
		x 43
		y 123
		description {left building}
		sightAngle 45
		lookStr {Another of Xenon's ruined structures awaits the the final, slow assault of nature.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 40 5) ; "The building is inaccessible."
			)
			(11 ; Smell
				(Print 40 6) ; "It smells like hundreds of sweaty public servants once populated this building."
			)
			(10 ; Taste
				(Print 40 7) ; "It tastes about like you'd expect it to taste, given how it smells."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance street1 of Feature
	(properties
		description {street}
	)

	(method (init)
		(super init:)
		(self onMeCheck: street1Poly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 40 8) ; "It's a safe bet that tank had something to do with the end of traffic on this thoroughfare."
			)
			(11 ; Smell
				(Print 40 9) ; "The pavement has lost that wonderful wet-tar smell you loved so much as a kid."
			)
			(10 ; Taste
				(Print 40 10) ; "Okay, you scrape some taste buds off onto the street."
			)
			(4 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance street1Poly of Polygon
	(properties)
)

(instance street2 of Feature
	(properties
		description {street}
	)

	(method (init)
		(super init:)
		(self onMeCheck: street2Poly)
	)

	(method (doVerb theVerb invItem)
		(street1 doVerb: theVerb invItem)
	)
)

(instance street2Poly of Polygon
	(properties)
)

(instance sidewalk1 of Feature
	(properties
		description {sidewalk}
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk1Poly)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 40 11) ; "One thing THIS society can say is that no citizen of THEIRS lives in the streets. In fact, nothing seems to live anywhere. This place is definitely DOA."
			)
			(11 ; Smell
				(Print 40 12) ; "The smell of devastation is everywhere."
			)
			(10 ; Taste
				(Print 40 13) ; "The taste of devastation is everywhere."
			)
			(4 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sidewalk1Poly of Polygon
	(properties)
)

(instance sidewalk2 of Feature
	(properties
		description {sidewalk}
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk2Poly)
	)

	(method (doVerb theVerb invItem)
		(sidewalk1 doVerb: theVerb invItem)
	)
)

(instance sidewalk2Poly of Polygon
	(properties)
)

(instance sidewalk3 of Feature
	(properties
		description {sidewalk}
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk3Poly)
	)

	(method (doVerb theVerb invItem)
		(sidewalk1 doVerb: theVerb invItem)
	)
)

(instance sidewalk3Poly of Polygon
	(properties)
)

(instance sidewalk4 of Feature
	(properties
		description {sidewalk}
	)

	(method (init)
		(super init:)
		(self onMeCheck: sidewalk4Poly)
	)

	(method (doVerb theVerb invItem)
		(sidewalk1 doVerb: theVerb invItem)
	)
)

(instance sidewalk4Poly of Polygon
	(properties)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You are at the left edge of this area. More debris chokes off the west. A devastated tank stands a blind guard.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance closeup of View
	(properties
		x 132
		y 155
		z 77
		description {tank interior}
		sightAngle 90
		view 40
		priority 13
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (or (gEgo mover:) (!= (gEgo loop:) 7))
			(self hide: dispose:)
		)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 77)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== ((gInventory at: 2) owner:) 40) ; bomb
					(Print 40 14) ; "This is the interior of a battle-scarred tank. Although somewhat intact, the operators must have lost their lives. A piece of unstable ordnance rests in the corner."
				else
					(Print 40 15) ; "This is the interior of a battle-scarred tank. Although somewhat intact, the operators must have lost their lives."
				)
			)
			(4 ; Inventory
				(theTank doVerb: 4 invItem)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theBomb of Prop
	(properties
		x 134
		y 156
		z 97
		description {explosive ordnance}
		sightAngle 90
		view 40
		cel 1
		priority 14
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (or (gEgo mover:) (!= (gEgo loop:) 7))
			(self hide: dispose:)
		)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 97)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 40 16) ; "Surprisingly, no one has taken this small, innocuous-looking piece of unstable ordnance."
			)
			(3 ; Do
				(theBomb dispose:)
				(gEgo get: 2) ; bomb
				(SetScore 69 25)
				(if (and (IsFlag 0) (== (shootEgo state:) 0))
					(shootEgo register: 10)
				)
				(Animate (gCast elements:) 0)
				(Print 40 17) ; "Okay. You now have the unstable ordnance. Remember, it was your idea. Good luck."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theHole of Feature
	(properties
		x 149
		y 115
		description {hole}
		sightAngle 45
	)

	(method (init)
		(super init:)
		(self onMeCheck: holePoly)
	)

	(method (doVerb theVerb invItem)
		(cond
			((or (== theVerb 2) (== theVerb 3)) ; Look, Do
				(theTank doVerb: 3 invItem)
			)
			((== theVerb 4) ; Inventory
				(theTank doVerb: 4 invItem)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance holePoly of Polygon
	(properties)
)

(instance cop1 of Actor
	(properties
		x 329
		y 165
		lookStr {Oh No! Sequel Police!}
		view 7
		loop 2
	)

	(method (init)
		(cop2 init:)
		(shootEgo register: 500)
		(self setScript: shootEgo)
		(super init:)
	)
)

(instance cop2 of Actor
	(properties
		x 340
		y 145
		lookStr {Oh No! Sequel Police!}
		view 7
	)
)

(instance shootEgo of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(cond
			(register
				(-- register)
			)
			((not state)
				(self cue:)
			)
		)
		(if (and (== state 1) (> (gEgo x:) 205))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1 0)
			(2
				(if (> (gEgo y:) 100)
					(cop1 y: 65)
					(cop2 y: 45)
				)
				(cop1 setCycle: Walk setMotion: MoveTo 275 (cop1 y:) self)
				(cop2 setCycle: Walk setMotion: MoveTo 0 (cop2 y:))
			)
			(3
				(Face cop1 gEgo)
				(= cycles 4)
			)
			(4
				(cop2 setMotion: 0)
				(Face cop2 gEgo)
				(cop1 view: 13 cel: 0 setMotion: 0 setCycle: CT 2 1 self)
			)
			(5
				(HandsOff)
				(cop1 setCycle: End self)
				(if (< (cop1 x:) (gEgo x:))
					(localproc_0
						(- (cop1 y:) 27)
						(cop1 x:)
						(- (gEgo y:) 32)
						(gEgo x:)
					)
				else
					(localproc_0
						(- (gEgo y:) 32)
						(gEgo x:)
						(- (cop1 y:) 27)
						(cop1 x:)
					)
				)
			)
			(6
				(gEgo
					setMotion: 0
					view: 26
					loop:
						(switch (gEgo loop:)
							(4 0)
							(5 1)
							(6 0)
							(7 1)
							(else
								(gEgo loop:)
							)
						)
					cel: 0
					cycleSpeed: 0
					setCycle: CT 2 1 self
				)
			)
			(7
				(gEgo setMotion: 0 setCycle: CT 1 -1 self)
			)
			(8
				(gEgo setMotion: 0 setCycle: End self)
			)
			(9
				(= seconds 4)
				(EgoDead 8)
			)
		)
	)
)

