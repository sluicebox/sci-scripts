;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 630)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	woods7Rm 0
)

(instance woods7Rm of ExitRoom
	(properties
		picture 61501
		east 635 ; woods8Rm
	)

	(method (init)
		(switch gPrevRoomNum
			(620 ; woods5Rm
				(gEgo posn: 370 260 heading: 180)
			)
			(else
				(gEgo posn: 525 338 heading: 270)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 99 31 356 161 init:)
		(super init: &rest)
		(fNorthExit init:)
		(gGame handsOn:)
	)
)

(instance fNorthExit of ExitFeature
	(properties
		approachX 140
		approachY 150
		BAD_SELECTOR 620
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 318 246 312 -3 463 0 468 235)
	)
)

