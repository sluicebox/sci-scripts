;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm035 0
)

(local
	[local0 10] = [0 85 12 77 10 40 50 0 0 0]
	[local10 12] = [60 36 79 38 109 30 85 9 71 14 60 31]
	[local22 44] = [12 67 11 40 51 0 318 0 319 189 275 189 297 163 226 113 193 151 201 167 141 187 121 169 198 93 147 56 121 91 126 104 75 124 57 107 124 39 80 5 57 34 65 50]
)

(instance rm035 of SQRoom
	(properties
		picture 35
		style 30
		south 50
		west 30
		vanishingX -125
		vanishingY -112
	)

	(method (init)
		(switch gPrevRoomNum
			(45
				(gEgo init: x: 48 y: 245)
				(HandsOff)
				(self setScript: enterScript)
			)
			(south
				(gEgo x: 245)
			)
			(east 0)
			(else
				(gEgo x: 160 y: 130)
			)
		)
		(rubblePoly1 points: @local0 size: 5)
		(rubblePoly2 points: @local10 size: 6)
		(buildingPoly points: @local22 size: 22)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 238 152 230 163 165 189 125 189 110 174 129 155 209 144
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 38 110 126 79 158 103 71 135
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 108 35 86 39 92 43 81 51 0 80
					yourself:
				)
		)
		(gEgo init:)
		(theRubble1 init:)
		(theRubble2 init:)
		(theWhiteBldg init:)
		(theArea init:)
		(if (not (IsFlag 0))
			(self setRegions: 701) ; street
		)
		(super init:)
		(self setRegions: 705) ; bunny
	)

	(method (newRoom newRoomNumber)
		(if (and (== (gEgo edgeHit:) EDGE_BOTTOM) (< (gEgo x:) 124))
			(= newRoomNumber 45)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 78 188 self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance theRubble1 of Feature
	(properties
		x 11
		y 18
		description {rubble}
		sightAngle 45
		lookStr {The clearing ends here. Progress north is not possible over the jagged terrain.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: rubblePoly1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 35 0) ; "The rubble is rough and jagged. Your hide wasn't designed to traverse this kind of terrain."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rubblePoly1 of Polygon
	(properties)
)

(instance theRubble2 of Feature
	(properties
		x 82
		y 22
		description {rubble}
		sightAngle 45
		lookStr {The clearing ends here. Progress north is not possible over the jagged terrain.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: rubblePoly2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 35 0) ; "The rubble is rough and jagged. Your hide wasn't designed to traverse this kind of terrain."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rubblePoly2 of Polygon
	(properties)
)

(instance theWhiteBldg of Feature
	(properties
		x 237
		y 49
		description {white building}
		lookStr {A fairly intact-but-featureless dirty white structure fills space to the east.}
	)

	(method (init)
		(super init:)
		(self onMeCheck: buildingPoly)
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

(instance buildingPoly of Polygon
	(properties)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You are at the northeastern boundary of a clearing in the midst of a battle-scarred city. The massive wart-like complex in the background is the only thing in sight which appears to contain life.}
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

