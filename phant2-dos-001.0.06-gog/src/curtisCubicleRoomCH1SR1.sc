;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4011)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2View)
(use ExitFeature)

(public
	curtisCubicleRoomCH1SR1 0
)

(instance curtisCubicleRoomCH1SR1 of P2Room
	(properties
		picture 230
		south 3331
	)

	(method (init)
		(if (gRoboGary isPlaying:)
			(gRoboGary fadeTo: 80)
		else
			(gP2SongPlyr fadeTo: 80)
		)
		(= global241 60)
		(super init: &rest)
		(computerView init: isHot: 0)
		(or
			(firstDeskFeature
				init:
					(proc63002_10
						223
						306
						214
						283
						245
						250
						255
						162
						287
						152
						323
						166
						331
						261
						304
						316
					)
			)
			(afterSlugDeskFeature
				init:
					(proc63002_10
						223
						306
						214
						283
						245
						250
						255
						162
						287
						152
						323
						166
						331
						261
						304
						316
					)
			)
			(usualDeskFeature
				init:
					(proc63002_10
						223
						306
						214
						283
						245
						250
						255
						162
						287
						152
						323
						166
						331
						261
						304
						316
					)
			)
		)
		(if (not (IsFlag 99))
			(SetFlag 5)
		)
		(gGame handsOn: 1)
	)
)

(instance computerView of P2View
	(properties
		x 120
		y 205
		view 230
		doneFlag 1000
	)
)

(instance firstDeskFeature of ExitFeature
	(properties
		doneFlag 39
		nextRoom 4021
		exitScene 5010
	)

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(SetFlag 1000)
		)
	)
)

(instance afterSlugDeskFeature of ExitFeature
	(properties
		readyFlag 26
		doneFlag 69
		nextRoom 4021
		exitScene 5020
	)
)

(instance usualDeskFeature of ExitFeature
	(properties
		nextRoom 4021
		exitScene 5011
	)
)

