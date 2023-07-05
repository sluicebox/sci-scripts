;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use MoveToY)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
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
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
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
		style 30
		horizon 48
		north 25
		east 45
		south 55
		vanishingX 319
		vanishingY -35
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 298 0 251 49 102 49 97 60 109 72 75 78 63 74 24 88 33 152 68 163 41 189 0 189 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 103 79 181 120 142 144 113 143 60 100
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 213 150 181 175 128 165 165 141
					yourself:
				)
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
				(gLongSong number: 802 loop: -1 playBed:)
				(cop2 init:)
				(shootEgo register: 200)
				(cop1 init: setScript: shootEgo)
			)
		)
		(gEgo init:)
		(theTank init:)
		(theSupport init:)
		(thePurpleBldg init:)
		(theLeftBldg init:)
		(theArea init:)
		(self setRegions: 701) ; street
		(super init:)
		(self setRegions: 705) ; bunny
		(supportPoly points: @local0 size: 12)
		(buildingPoly points: @local24 size: 10)
		(tankPoly points: @local44 size: 8)
	)

	(method (newRoom newRoomNumber)
		(cond
			((and (== (gEgo edgeHit:) 1) (!= script exitScript))
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
				)
				(= newRoomNumber 60)
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
				(gEgo setMotion: bumpMoveToY -10 self)
			)
			(1
				(= register 0)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance bumpMoveToY of MoveToY
	(properties)

	(method (doit)
		(super doit:)
		(if (client isBlocked:)
			(self moveDone:)
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
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(HandsOff)
					(gCurRoom setScript: tankScript)
				)
			)
			(6 ; Inventory
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
			)
			(2
				(Print 40 0) ; "Carefully placing the unstable ordnance back inside the tank, you decide some things are better left alone."
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
		lookStr {Huge supports miraculously still stand on this building.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: supportPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
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
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
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
			(4 ; Do
				(Print 40 1) ; "The building is inaccessible."
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

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You are at the left edge of this area. More debris chokes off the west. A devastated tank stands a blind guard.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4) ; Do
			(6 ; Inventory
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
			(self z: 77)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== ((gInventory at: 2) owner:) 40) ; bomb
					(Print 40 2) ; "This is the interior of a battle-scarred tank. Although somewhat intact, the operators must have lost their lives. A piece of unstable ordnance rests in the corner."
				else
					(Print 40 3) ; "This is the interior of a battle-scarred tank. Although somewhat intact, the operators must have lost their lives."
				)
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
		priority 15
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
			(1 ; Look
				(Print 40 4) ; "Surpisingly, no one has taken this small, innocuous-looking piece of unstable ordnance."
			)
			(4 ; Do
				(theBomb dispose:)
				(gEgo get: 2) ; bomb
				(if (and (IsFlag 0) (== (shootEgo state:) 0))
					(shootEgo register: 10)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cop1 of Actor
	(properties
		x 329
		y 165
		lookStr {Oh No! Sequel Police!}
		view 7
		loop 2
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
				(EgoDead)
			)
		)
	)
)

