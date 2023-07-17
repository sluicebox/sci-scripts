;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	woods1Rm 0
)

(instance woods1Rm of ExitRoom
	(properties
		picture 6001
		south 610 ; woods3Rm
	)

	(method (init)
		(switch gPrevRoomNum
			(605 ; woods2Rm
				(gEgo posn: 471 172 heading: 270)
			)
			(625 ; woods6Rm
				(gEgo posn: 170 249 heading: 90)
			)
			(else
				(gEgo posn: 283 303 heading: 0)
			)
		)
		(gEgo sel_737: setScaler: Scaler 77 34 303 160 init:)
		(super init: &rest)
		(fEastExit init:)
		(fWestExit init:)
		(gGame handsOn:)
	)
)

(instance fEastExit of ExitFeature
	(properties
		approachX 600
		approachY 172
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 481 193 481 78 614 0 614 193)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 605) ; woods2Rm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fWestExit of ExitFeature
	(properties
		approachX 10
		approachY 250
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 278 103 278 103 201 0 29)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 625) ; woods6Rm
		else
			(super doVerb: &rest)
		)
	)
)

