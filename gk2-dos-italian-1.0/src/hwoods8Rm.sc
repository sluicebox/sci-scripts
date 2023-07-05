;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 636)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use huntRegion)
(use Scaler)

(public
	hwoods8Rm 0
)

(instance hwoods8Rm of ExitRoom
	(properties
		modNum 600
		picture 63502
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(631 ; hwoods7Rm
				(if (== global144 1)
					(PlayScene 2689)
					(gEgo posn: 322 339 heading: 270)
				else
					(gEgo posn: 55 265 heading: 90)
				)
			)
			(626 ; hunt6Rm
				(if (== global144 1)
					(PlayScene 4689)
					(gEgo posn: 322 339 heading: 270)
				else
					(gEgo posn: 201 205 heading: 180)
				)
			)
			(else
				(if (== global144 1)
					(PlayScene 1689)
					(gEgo posn: 55 265 heading: 90)
				else
					(gEgo posn: 322 339 heading: 0)
				)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 86 19 329 177 init:)
		(self setRegions: 499) ; huntRegion
		(proc499_4)
		(fNorthExit init:)
		(fSouthExit init:)
		(fWestExit init:)
		(gGame handsOn:)
	)
)

(instance fNorthExit of HuntExit
	(properties
		approachX 200
		approachY 100
		BAD_SELECTOR 626
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 137 191 141 -1 262 1 264 190)
	)
)

(instance fSouthExit of HuntExit
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 250
		y 400
		BAD_SELECTOR 641
		BAD_SELECTOR 4
	)
)

(instance fWestExit of HuntExit
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		y 250
		BAD_SELECTOR 631
		BAD_SELECTOR 6
	)
)

