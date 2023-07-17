;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use huntRegion)
(use Scaler)

(public
	hwoods1Rm 0
)

(instance hwoods1Rm of ExitRoom
	(properties
		modNum 600
		picture 6002
	)

	(method (init)
		(self setRegions: 499) ; huntRegion
		(super init: &rest)
		(switch gPrevRoomNum
			(606 ; hwoods2Rm
				(if (== global144 1)
					(PlayScene 3689)
					(gEgo posn: 50 249 heading: 90)
				else
					(gEgo posn: 471 172 heading: 270)
				)
			)
			(626 ; hunt6Rm
				(if (== global144 1)
					(PlayScene 2689)
					(gEgo posn: 471 172 heading: 270)
				else
					(gEgo posn: 50 249 heading: 90)
				)
			)
			(else
				(if (== global144 1)
					(PlayScene 1689)
					(gEgo posn: 50 249 heading: 90)
				else
					(gEgo posn: 283 303 heading: 0)
				)
			)
		)
		(gEgo sel_737: setScaler: Scaler 77 34 303 160 init:)
		(proc499_4)
		(fEastExit init:)
		(fWestExit init:)
		(fSouthExit init:)
		(gGame handsOn:)
	)
)

(instance fEastExit of HuntExit
	(properties
		approachX 600
		approachY 172
		BAD_SELECTOR 606
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 481 193 481 78 614 0 614 193)
	)
)

(instance fWestExit of HuntExit
	(properties
		approachX 10
		approachY 250
		BAD_SELECTOR 626
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 278 103 278 103 201 0 29)
	)
)

(instance fSouthExit of HuntExit
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 611
		BAD_SELECTOR 4
	)
)

