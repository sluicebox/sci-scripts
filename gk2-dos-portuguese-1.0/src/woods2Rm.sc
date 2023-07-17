;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 605)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	woods2Rm 0
)

(instance woods2Rm of ExitRoom ; "Woods"
	(properties
		modNum 600
		noun 10
		picture 60501
		south 615 ; woods4Rm
	)

	(method (init)
		(switch gPrevRoomNum
			(600 ; woods1Rm
				(gEgo posn: 108 237 heading: 90)
			)
			(615 ; woods4Rm
				(gEgo posn: 174 333 heading: 0)
			)
			(else
				(gEgo posn: 234 227 heading: 270)
				(gSoundManager play: 0 600 601)
			)
		)
		(gEgo sel_737: setScaler: Scaler 81 28 322 192 init:)
		(fEastExit init:)
		(fWestExit init:)
		(super init: &rest)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 500) ; lodgeExtRm
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fEastExit of ExitFeature
	(properties
		approachX 385
		approachY 202
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 540 0 540 156 420 156 420 216 614 216 614 0)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 500) ; lodgeExtRm
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fWestExit of ExitFeature
	(properties
		approachY 217
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 237 87 237 87 142 0 6)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 600) ; woods1Rm
		else
			(super doVerb: theVerb)
		)
	)
)

