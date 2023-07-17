;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 621)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use huntRegion)
(use Scaler)

(public
	hwoods5Rm 0
)

(local
	local0 = 1
)

(instance hwoods5Rm of ExitRoom
	(properties
		modNum 600
		picture 6202
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(626 ; hunt6Rm
				(if (== global144 1)
					(PlayScene 3689)
					(gEgo posn: 173 250 heading: 90)
				else
					(gEgo posn: 398 276 heading: 270)
				)
			)
			(631 ; hwoods7Rm
				(if (== global144 1)
					(PlayScene 1689)
					(gEgo posn: 173 250 heading: 90)
				else
					(gEgo posn: 305 341 heading: 0)
				)
			)
			(else
				(if (== global144 1)
					(cond
						((== 606 global136)
							(PlayScene 3689)
							(gEgo posn: 398 276 heading: 270)
						)
						((== global136 621)
							(PlayScene 1688)
							(gEgo posn: 173 250 heading: 90)
						)
					)
				else
					(gEgo posn: 173 250 heading: 90)
				)
				(Lock rsAUDIO 606 1)
				(gGk2Music setLoop: -1 number: 606 play:)
			)
		)
		(gEgo sel_737: setScaler: Scaler 63 28 321 241 init:)
		(self setRegions: 499) ; huntRegion
		(proc499_4)
		(fWestExit init:)
		(fSouthExit init:)
		(fEastExit init:)
		(gGame handsOn:)
	)
)

(instance fWestExit of HuntExit
	(properties
		nsTop 15
		nsRight 52
		nsBottom 334
		y 250
		BAD_SELECTOR 501
		BAD_SELECTOR 6
	)
)

(instance fSouthExit of HuntExit
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 631
		BAD_SELECTOR 4
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
		BAD_SELECTOR 626
		BAD_SELECTOR 2
	)
)

