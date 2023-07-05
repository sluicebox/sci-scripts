;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 616)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use huntRegion)
(use Scaler)

(public
	hwoods4Rm 0
)

(local
	local0
)

(instance hwoods4Rm of ExitRoom
	(properties
		modNum 600
		picture 6302
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(606 ; hwoods2Rm
				(if (== global144 1)
					(PlayScene 4689)
					(= local0 4)
				else
					(= local0 1)
				)
			)
			(else
				(if (== global144 1)
					(PlayScene 2689)
					(= local0 1)
				else
					(= local0 4)
				)
			)
		)
		(switch local0
			(1
				(gEgo posn: 100 200 heading: 180)
			)
			(else
				(gEgo posn: 0 338 heading: 90)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 99 31 356 161 init:)
		(self setRegions: 499) ; huntRegion
		(proc499_4)
		(fNorthExit init:)
		(fWestExit init:)
		(gGame handsOn:)
	)
)

(instance fWestExit of HuntExit
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		x -10
		y 250
		BAD_SELECTOR 611
		BAD_SELECTOR 6
	)
)

(instance fNorthExit of HuntExit
	(properties
		approachX 100
		approachY 100
		BAD_SELECTOR 606
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 6 189 2 -1 199 -1 208 233)
	)
)

