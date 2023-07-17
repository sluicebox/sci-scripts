;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	woods3Rm 0
)

(instance woods3Rm of ExitRoom
	(properties
		picture 6101
		east 615 ; woods4Rm
		south 650 ; ravineRm
	)

	(method (init)
		(switch gPrevRoomNum
			(600 ; woods1Rm
				(gEgo posn: 414 253 heading: 180)
			)
			(615 ; woods4Rm
				(gEgo posn: 561 290 heading: 270)
			)
			(else
				(gEgo posn: 420 338 heading: 0)
			)
		)
		(gEgo sel_737: setScaler: Scaler 85 37 325 226 init:)
		(super init: &rest)
		(fNorthExit init:)
		(gGame handsOn:)
	)
)

(instance fNorthExit of ExitFeature
	(properties
		approachX 250
		approachY -1000
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 477 244 325 244 325 0 477 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 600) ; woods1Rm
		else
			(super doVerb: theVerb)
		)
	)
)

