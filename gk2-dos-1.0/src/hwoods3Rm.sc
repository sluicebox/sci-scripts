;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 611)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use huntRegion)
(use Scaler)

(public
	hwoods3Rm 0
)

(local
	local0
)

(instance hwoods3Rm of ExitRoom
	(properties
		modNum 600
		picture 6102
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(601 ; hwoods1Rm
				(if (== global144 1)
					(PlayScene 5689)
					(= local0 3)
				else
					(= local0 1)
				)
			)
			(616 ; hwoods4Rm
				(if (== global144 1)
					(PlayScene 3689)
					(= local0 1)
				else
					(= local0 2)
				)
			)
			(else
				(if (== global144 1)
					(PlayScene 689)
					(= local0 2)
				else
					(= local0 3)
				)
			)
		)
		(switch local0
			(1
				(gEgo posn: 385 239 heading: 180)
			)
			(3
				(gEgo posn: 445 338 heading: 0)
			)
			(else
				(gEgo posn: 605 310 heading: 270)
			)
		)
		(gEgo normalize: setScaler: Scaler 85 37 325 226 init:)
		(self setRegions: 499) ; huntRegion
		(fNorthExit init:)
		(fEastExit init:)
		(fSouthExit init:)
		(proc499_4)
		(gGame handsOn:)
	)
)

(instance fEastExit of HuntExit
	(properties
		nsLeft 586
		nsTop 15
		nsRight 640
		nsBottom 334
		x 700
		y 255
		nextRoomNum 616 ; hwoods4Rm
		exitDir 2
	)
)

(instance fNorthExit of HuntExit
	(properties
		approachX 250
		approachY -1000
		nextRoomNum 601 ; hwoods1Rm
		exitDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 477 244 325 244 325 0 477 0)
	)
)

(instance fSouthExit of HuntExit
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		nextRoomNum 651 ; hravineRm
		exitDir 4
	)
)

