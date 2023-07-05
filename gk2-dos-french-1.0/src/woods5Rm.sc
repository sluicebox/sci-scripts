;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	woods5Rm 0
)

(instance woods5Rm of ExitRoom ; "Woods"
	(properties
		modNum 600
		noun 10
		picture 6201
		east 625 ; woods6Rm
		south 630 ; woods7Rm
		west 500 ; lodgeExtRm
	)

	(method (init)
		(switch gPrevRoomNum
			(6240
				(gEgo posn: 346 266 heading: 90)
			)
			(625 ; woods6Rm
				(gEgo posn: 398 276 heading: 270)
			)
			(630 ; woods7Rm
				(gEgo posn: 305 341 heading: 0)
			)
			(else
				(gEgo posn: 173 250 heading: 90)
				(gSoundManager play: 0 600 601)
			)
		)
		(gEgo normalize: setScaler: Scaler 63 28 321 241 init:)
		(super init: &rest)
		(fOrangeMud init:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 500) ; lodgeExtRm
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fOrangeMud of GKFeature
	(properties
		modNum 600
		approachX 420
		approachY 250
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 451 223 398 229 394 248 453 256 501 250 501 229)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 679)
			(gCurRoom newRoom: 6240)
		else
			(super doVerb: theVerb)
		)
	)
)

