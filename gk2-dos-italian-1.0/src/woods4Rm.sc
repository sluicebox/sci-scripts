;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 615)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	woods4Rm 0
)

(instance woods4Rm of ExitRoom
	(properties
		picture 6301
		north 605 ; woods2Rm
		west 610 ; woods3Rm
	)

	(method (init)
		(switch gPrevRoomNum
			(605 ; woods2Rm
				(gEgo posn: 100 200 heading: 180)
			)
			(else
				(gEgo posn: 20 338 heading: 90)
			)
		)
		(gEgo sel_737: setScaler: Scaler 88 46 323 214 init:)
		(super init: &rest)
		(fNorthExit init:)
		(gGame handsOn:)
	)
)

(instance fNorthExit of ExitFeature
	(properties
		approachX 375
		approachY 230
		BAD_SELECTOR 605
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 6 189 2 -1 199 -1 208 233)
	)
)

