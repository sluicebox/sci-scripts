;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use Interface)
(use MoveToY)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm055 0
)

(local
	local0
	[local1 58] = [288 0 288 10 257 33 221 33 170 66 210 69 180 93 127 93 72 133 116 141 91 161 168 167 204 139 215 136 227 120 218 120 223 107 307 113 307 126 304 130 301 133 279 158 262 167 274 173 285 170 319 172 319 189 0 189 0 0]
	[local59 34] = [0 158 16 154 33 164 42 161 92 171 110 164 130 162 140 172 168 165 204 145 222 142 262 160 268 171 295 172 319 178 319 189 0 189]
	[local93 42] = [0 157 15 154 32 164 43 161 69 165 94 147 94 137 102 132 102 127 129 108 129 91 173 89 199 71 198 49 218 47 233 34 234 28 256 28 284 7 284 0 0 0]
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

(instance rm055 of SQRoom
	(properties
		picture 55
		style 30
		horizon 29
		north 40
		east 60
		vanishingX 320
		vanishingY -70
	)

	(method (init)
		(switch gPrevRoomNum
			(north
				(HandsOff)
				(self setScript: enterScript)
			)
			(east
				(cond
					((> (gEgo y:) 172)
						(gEgo y: 172)
					)
					((< 110 (gEgo y:) 135)
						(gEgo y: 108)
					)
				)
			)
			(else
				(gEgo x: 160 y: 160)
			)
		)
		(if (IsFlag 0)
			(HandsOff)
			(cop1 init:)
			(cop2 init:)
		)
		(gEgo init:)
		(aircar init:)
		(theRubble init:)
		(theLeftBldg init:)
		(theArea init:)
		(if (not (IsFlag 0))
			(self setRegions: 701) ; street
		)
		(super init:)
		(self setRegions: 705) ; bunny
		(poly1 points: @local1 size: 29)
		(self addObstacle: poly1)
		(rubblePoly points: @local59 size: 17)
		(buildingPoly points: @local93 size: 21)
	)

	(method (newRoom newRoomNumber)
		(cond
			((and (== (gEgo edgeHit:) EDGE_TOP) (!= script exitScript))
				(HandsOff)
				(self setScript: exitScript 0 1)
			)
			((and (== (gEgo edgeHit:) EDGE_TOP) (not (script register:)))
				(super newRoom: newRoomNumber)
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
				(gEgo posn: 315 -1 setMotion: MoveTo 280 47 self)
			)
			(1
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

(instance cop1 of Actor
	(properties
		x 204
		y 125
		view 7
		loop 2
	)

	(method (doit)
		(super doit: &rest)
		(if (not (self script:))
			(self setScript: shootEgo)
		)
	)
)

(instance cop2 of Actor
	(properties
		x 88
		y 135
		view 7
	)
)

(instance shootEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(cop1 setCycle: Walk setMotion: MoveTo 237 80 self)
				(cop2 setCycle: Walk setMotion: DPath 138 143 236 65)
			)
			(2
				(cop1 view: 13 cel: 0 setMotion: 0 setCycle: CT 4 1 self)
			)
			(3
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
			(4
				(gEgo
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
			(5
				(gEgo setCycle: CT 1 -1 self)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(= seconds 4)
			)
			(8
				(EgoDead) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeup of View
	(properties
		x 233
		y 188
		z 13
		description {aircar interior}
		sightAngle 45
		lookStr {The interior of the aircar sports many broken gauges and instruments as well as a glove box.}
		view 106
		priority 14
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (gEgo mover:)
			(self hide: dispose:)
		)
		(if (> ((ScriptID 701 1) y:) 165) ; deathDroid
			((ScriptID 701 1) setPri: 13) ; deathDroid
		)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 13)
		)
	)
)

(instance glovebox of View
	(properties
		x 249
		y 189
		z 30
		description {glovebox}
		sightAngle 45
		view 106
		loop 1
		priority 15
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (gEgo mover:)
			(self hide: dispose:)
		)
		(if (== (gCurRoom curPic:) 31)
			(self z: 1000)
		else
			(self z: 30)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(switch cel
					(0
						(if (== ((gInventory at: 16) owner:) 55) ; laptop_computer
							(self cel: 2)
						else
							(self cel: 1)
						)
					)
					(1
						(self cel: 0)
					)
					(2
						(if local0
							(gEgo get: 16) ; laptop_computer
							(self cel: 1)
						else
							(self cel: 0)
						)
					)
				)
			)
			(1 ; Look
				(++ local0)
				(switch cel
					(0
						(Print 55 0) ; "It is a closed glove box."
					)
					(1
						(Print 55 1) ; "The glove box is empty."
					)
					(2
						(Print 55 2) ; "It looks like a genuine PocketPal(tm) portable terminal."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance aircar of Feature
	(properties
		x 257
		y 127
		nsTop 87
		nsLeft 216
		nsBottom 167
		nsRight 299
		description {aircar}
		sightAngle 45
		onMeCheck 16
		lookStr {A quick inspection of the disabled surface transport reveals nothing of interest other than a glove box.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurRoom script:)
					0
				else
					(HandsOff)
					(if (> (gEgo x:) 260)
						(carScript register: 1)
					)
					(HandsOff)
					(gCurRoom setScript: carScript)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gEgo setMotion: PolyPath 279 158 self)
				else
					(gEgo setMotion: PolyPath 219 131 self)
				)
			)
			(1
				(if register
					(gEgo setHeading: 225 self)
				else
					(gEgo setHeading: 135 self)
				)
			)
			(2
				(glovebox init:)
				(closeup init: stopUpd:)
				(= cycles 1)
			)
			(3
				(self register: 0)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance theRubble of Feature
	(properties
		x 160
		y 187
		description {rubble}
		sightAngle 45
		lookStr {Boy, this place is a mess. No travel to the south is possible due to the dangerous terrain.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: rubblePoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 55 3) ; "The rubble is too hazardous to attempt passage over."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rubblePoly of Polygon
	(properties)
)

(instance theLeftBldg of Feature
	(properties
		x 101
		y 27
		description {building}
		sightAngle 25
		lookStr {This sealed, battered building is the last one standing in the southeastern area.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 55 4) ; "The building is closed-up with welded metal panels enhancing a non-access re-design scheme."
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
		lookStr {You are at the southeastern boundary of this chunk of city.}
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

