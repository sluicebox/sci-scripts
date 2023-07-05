;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4015)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)

(public
	curtisCubicleRoomCH5SR1 0
)

(instance curtisCubicleRoomCH5SR1 of P2Room
	(properties
		picture 230
		south 3335
	)

	(method (init)
		(super init: &rest)
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
		(gGame handsOn: 1)
	)
)

(instance usualDeskFeature of ExitFeature
	(properties
		nextRoom 4025
		exitScene 5011
	)
)

