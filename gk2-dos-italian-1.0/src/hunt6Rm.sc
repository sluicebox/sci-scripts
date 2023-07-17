;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 626)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use huntRegion)
(use Scaler)

(public
	hunt6Rm 0
)

(local
	local0
)

(instance hunt6Rm of ExitRoom
	(properties
		modNum 600
		picture 62502
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(621 ; hwoods5Rm
				(if (== global144 1)
					(PlayScene 2689)
					(= local0 2)
				else
					(= local0 4)
				)
			)
			(601 ; hwoods1Rm
				(if (== global144 1)
					(PlayScene 3689)
					(= local0 4)
				else
					(= local0 2)
				)
			)
			(else
				(if (== global144 1)
					(PlayScene 689)
					(= local0 4)
				else
					(= local0 3)
				)
			)
		)
		(switch local0
			(2
				(gEgo posn: 565 320 heading: 270)
			)
			(4
				(gEgo posn: 243 350 heading: 90)
			)
			(else
				(gEgo posn: 307 341 heading: 0)
			)
		)
		(gEgo sel_737: setScaler: Scaler 81 24 320 165 init:)
		(self setRegions: 499) ; huntRegion
		(proc499_4)
		(fSouthExit init:)
		(fEastExit init:)
		(fWestExit init:)
		(gGame handsOn:)
	)
)

(instance fSouthExit of HuntExit
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 307
		y 400
		BAD_SELECTOR 636
		BAD_SELECTOR 4
	)
)

(instance fWestExit of HuntExit
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		y 250
		BAD_SELECTOR 621
		BAD_SELECTOR 6
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
		BAD_SELECTOR 601
		BAD_SELECTOR 2
	)
)

