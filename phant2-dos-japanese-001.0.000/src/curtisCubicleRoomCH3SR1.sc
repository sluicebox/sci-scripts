;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4013)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2View)
(use ExitFeature)

(public
	curtisCubicleRoomCH3SR1 0
)

(instance curtisCubicleRoomCH3SR1 of P2Room
	(properties
		picture 230
		south 3333
	)

	(method (init)
		(super init: &rest)
		(computerView init: isHot: 0)
		(deskFeature
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

(instance deskFeature of ExitFeature
	(properties
		nextRoom 4023
		exitScene 5011
	)
)

