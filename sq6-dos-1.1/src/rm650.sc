;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use SQRoom)
(use ExitFeature)
(use Scaler)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm650 0
)

(instance rm650 of SQRoom
	(properties
		noun 1
		picture 650
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 277 42 274 62 274 65 271 83 250 101 249 115 213 132 206 136 258 136 259 130 278 111 268 99 297 82 288 63 290 40
					yourself:
				)
		)
		(gEgo init: normalize: setPri: 120)
		(if (!= (gGSound1 number:) 640)
			(gGSound1 number: 640 setLoop: -1 play:)
		)
		(super init:)
		(switch gPrevRoomNum
			(660
				(gEgo
					posn: 248 200
					loop: 3
					setScaler: Scaler 100 75 115 68
					setMotion: MoveTo 248 128 self
				)
			)
			(else
				(gEgo setScript: sEgoEntry620)
			)
		)
		(stringsF init:)
		(stringsM init:)
		(stringsN init:)
		(pyloris init:)
		(exit620 init: gTheExitNCursor approachVerbs: 9) ; ExitUp
		(exit660 init: gTheExitSCursor approachVerbs: 10) ; ExitDown
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(super dispose:)
	)
)

(instance sEgoExit620 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 651
					loop: 0
					cel: 0
					cycleSpeed: 12
					setScaler: Scaler 100 100 115 68
					setCycle: End self
				)
			)
			(1
				(gCurRoom newRoom: 620)
				(self dispose:)
			)
		)
	)
)

(instance sEgoEntry620 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					posn: 289 60
					view: 650
					loop: 0
					cel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(gEgo
					normalize: 2
					setPri: 120
					setScaler: Scaler 100 75 115 68
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance stringsN of Feature
	(properties
		noun 3
		sightAngle 40
		x 117
		y 50
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 75 36 72 42 61 80 64 100 95 62 139 18 173 0 126 0 102 30
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance stringsF of Feature
	(properties
		noun 3
		sightAngle 40
		x 226
		y 24
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 237 0 228 31 228 47 226 49 221 45 223 20 216 13 226 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance stringsM of Feature
	(properties
		noun 3
		sightAngle 40
		x 203
		y 17
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 216 0 209 10 202 10 200 2 200 19 198 30 194 33 192 35 190 19 199 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pyloris of Feature
	(properties
		noun 2
		sightAngle 40
		x 289
		y 20
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 278 0 297 0 309 11 307 31 293 49 278 50 269 35 266 16
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exit620 of ExitFeature
	(properties
		noun 4
		approachX 280
		approachY 64
		nextRoom 620
		message 9
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 290 3 276 15 281 37 293 38 302 27 298 11
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; ExitUp
				(gEgo setScript: sEgoExit620)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exit660 of ExitFeature
	(properties
		approachX 248
		approachY 128
		nextRoom 660
		message 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 63 132 320 132 320 138 63 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; ExitDown
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 248 200 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 660)
	)
)

