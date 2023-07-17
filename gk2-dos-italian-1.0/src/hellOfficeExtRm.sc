;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2402)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	hellOfficeExtRm 0
)

(instance hellOfficeExtRm of ExitRoom
	(properties
		picture 2402
		south 230 ; hellZooRm
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(230 ; hellZooRm
				(gEgo posn: 532 342 heading: 315)
			)
			(else
				(gEgo posn: 423 329 heading: 135)
			)
		)
		(gEgo sel_737: setScaler: Scaler 100 90 400 250 init:)
		(fDoor init:)
		(gGame handsOn: 0)
	)
)

(instance fDoor of GKFeature
	(properties
		BAD_SELECTOR 240
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 324 64 448 71 452 305 332 336)
	)
)

