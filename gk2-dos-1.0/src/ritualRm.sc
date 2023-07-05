;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use System)

(public
	ritualRm 0
)

(instance ritualRm of ExitRoom ; "Hunt Club: Ritual Room"
	(properties
		noun 6
		picture 4601
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 440 450) ; clubMainRm, clubBackRm
			(gGk2Music fade: 0 10 10 1)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if (== gPrevRoomNum 450) ; clubBackRm
			(Lock rsAUDIO 460 1)
			(gGk2Music number: 460 setLoop: -1 play:)
		)
		(switch gPrevRoomNum
			(450 ; clubBackRm
				(gEgo
					posn: 218 319
					heading: 90
					normalize:
					setScaler: Scaler 100 80 330 290
					init:
				)
			)
			(4611
				(gEgo
					posn: 248 293
					heading: 225
					normalize:
					setScaler: Scaler 100 80 330 290
					init:
				)
			)
			(else
				(gEgo
					posn: 248 293
					heading: 90
					normalize:
					setScaler: Scaler 100 80 330 290
					init:
				)
			)
		)
		(gGame handsOff:)
		(SetFlag 513) ; enable "Club Basement" in rm3302
		(super init: &rest)
		(efStairs init:)
		(fTrophies init:)
		(fTable init:)
		(cond
			((and (IsFlag 524) (IsFlag 525))
				(PlayScene 331 0 440) ; clubMainRm
			)
			((== gPrevRoomNum 450) ; clubBackRm
				(PlayScene 1332)
			)
			(else
				(gGame handsOn:)
			)
		)
	)
)

(instance fTrophies of GKFeature
	(properties
		approachX 480
	)

	(method (init)
		(self createPoly: 306 69 306 229 477 229 476 74 392 31)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4612)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fTable of GKFeature
	(properties
		approachX 640
		approachY 300
	)

	(method (init)
		(self createPoly: 617 72 575 80 564 122 572 223 627 239 617 202)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4611)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance efStairs of ExitFeature
	(properties
		approachY 300
		exitDir 1
	)

	(method (init)
		(self createPoly: 132 295 132 199 113 145 200 82 200 -3 20 -1 20 320)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 450) ; clubBackRm
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

