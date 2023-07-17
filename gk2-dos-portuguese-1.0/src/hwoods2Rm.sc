;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 606)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use huntRegion)
(use Scaler)

(public
	hwoods2Rm 0
)

(local
	local0 = 1
)

(instance hwoods2Rm of ExitRoom
	(properties
		modNum 600
		picture 60502
	)

	(method (init)
		(super init: &rest)
		(self setRegions: 499) ; huntRegion
		(switch gPrevRoomNum
			(601 ; hwoods1Rm
				(if (== global144 1)
					(PlayScene 2689)
					(gEgo posn: 234 227 heading: 270)
				else
					(gEgo posn: 108 237 heading: 90)
				)
			)
			(616 ; hwoods4Rm
				(if (== global144 1)
					(PlayScene 689)
					(gEgo posn: 234 227 heading: 270)
				else
					(gEgo posn: 174 333 heading: 0)
				)
			)
			(else
				(if (== global144 1)
					(cond
						((== global136 621)
							(PlayScene 3689)
							(gEgo posn: 108 237 heading: 90)
						)
						((== global136 606)
							(PlayScene 688)
							(gEgo posn: 234 227 heading: 270)
						)
					)
				else
					(gEgo posn: 234 227 heading: 270)
				)
				(Lock rsAUDIO 606 1)
				(gGk2Music setLoop: -1 number: 606 play:)
			)
		)
		(gEgo sel_737: setScaler: Scaler 81 28 322 192 init:)
		(proc499_4)
		(fEastExit init:)
		(fWestExit init:)
		(fSouthExit init:)
		(gGame handsOn:)
	)
)

(instance fEastExit of HuntExit
	(properties
		approachX 385
		approachY 202
		BAD_SELECTOR 501
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 540 0 540 156 420 156 420 216 614 216 614 0)
	)
)

(instance fWestExit of HuntExit
	(properties
		approachY 217
		BAD_SELECTOR 601
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 237 87 237 87 142 0 6)
	)
)

(instance fSouthExit of HuntExit
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 200
		y 400
		BAD_SELECTOR 616
		BAD_SELECTOR 4
	)
)

