;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 660)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm660 0
)

(local
	local0
)

(instance rm660 of SQRoom
	(properties
		noun 1
		picture 660
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 118 19 88 22 76 30 60 30 45 38 37 80 49 114 91 139 163 139 156 102 97 76 54 61 59 34 88 34
					yourself:
				)
		)
		(gEgo init: normalize: setScaler: Scaler 100 32 91 15)
		(super init:)
		(switch gPrevRoomNum
			(700
				(gEgo setScript: sEgoEntry700)
			)
			(670
				(gEgo loop: 3 posn: 134 200 setMotion: MoveTo 134 132 self)
			)
			(else
				(gEgo loop: 2 posn: 125 25 setMotion: MoveTo 97 27 self)
			)
		)
		(stringys init: approachVerbs: 4) ; Do
		(stringys2 init: approachVerbs: 4) ; Do
		(exit700 init: gTheExitECursor approachVerbs: 7) ; ExitRight
		(exit650 init: gTheExitNCursor approachVerbs: 9) ; ExitUp
		(exit670 init: gTheExitSCursor approachVerbs: 10) ; ExitDown
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (dispose)
		(gEgo setScale: 0 normalize:)
		(super dispose:)
	)
)

(instance sEgoExit700 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo cycleSpeed:))
				(gEgo
					view: 660
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo setSpeed: local0)
				(gCurRoom newRoom: 700)
				(self dispose:)
			)
		)
	)
)

(instance sEgoEntry700 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 (gEgo cycleSpeed:))
				(gEgo
					posn: 148 108
					view: 661
					setLoop: 0 1
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo normalize: 5 setSpeed: local0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stringys of Feature
	(properties
		noun 3
		sightAngle 87
		approachX 85
		approachY 38
		x 112
		y 12
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 104 0 108 24 119 12 121 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance stringys2 of Feature
	(properties
		noun 3
		sightAngle 113
		approachX 196
		approachY 135
		x 267
		y 72
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 125 253 105 257 81 262 44 260 20 289 36 290 49 268 46 262 98 270 100 286 76 276 110 259 122
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exit650 of ExitFeature
	(properties
		approachX 97
		approachY 27
		nextRoom 650
		message 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 41 0 117 0 116 10 106 21 98 35 86 38 66 36 53 27 42 13
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; ExitUp
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 125 25 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super doVerb: 9)
	)
)

(instance exit670 of ExitFeature
	(properties
		sightAngle 40
		approachX 134
		approachY 132
		x 134
		y 133
		nextRoom 670
		message 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 133 320 133 320 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; ExitDown
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 134 200 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(super doVerb: 10)
	)
)

(instance exit700 of ExitFeature
	(properties
		noun 2
		sightAngle 40
		approachX 151
		approachY 102
		x 145
		y 102
		nextRoom 700
		message 7
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 181 29 183 44 195 55 199 56 211 43 213 18 201 0 187 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; ExitRight
				(gEgo setScript: sEgoExit700)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

