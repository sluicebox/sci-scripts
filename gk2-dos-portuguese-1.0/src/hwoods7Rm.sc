;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 631)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use huntRegion)
(use Scaler)
(use System)

(public
	hwoods7Rm 0
)

(instance hwoods7Rm of ExitRoom ; "Woods"
	(properties
		modNum 600
		noun 10
		picture 61502
	)

	(method (init)
		(if (== gPrevRoomNum 666) ; uDie
			(Palette 2 0 255 0) ; PalIntensity
			(= picture -1)
		)
		(super init: &rest)
		(SetFlag 407)
		(self setRegions: 499) ; huntRegion
		(switch gPrevRoomNum
			(666 ; uDie
				(gEgo posn: 253 335 heading: 90)
				(proc11_13)
			)
			(544 ; vgRm
				(gEgo posn: 253 335 heading: 90)
			)
			(621 ; hwoods5Rm
				(if (== global144 1)
					(PlayScene 5689)
					(gEgo posn: 525 338 heading: 270)
				else
					(gEgo posn: 370 260 heading: 180)
				)
			)
			(else
				(if (== global144 1)
					(PlayScene 3689)
					(gEgo posn: 370 260 heading: 180)
				else
					(gEgo posn: 525 338 heading: 270)
				)
			)
		)
		(gEgo sel_737: setScaler: Scaler 88 46 323 214 init:)
		(if (OneOf gPrevRoomNum 666 544) ; uDie, vgRm
			(PlayScene 685)
			(if (== gPrevRoomNum 666) ; uDie
				(gCurRoom drawPic: 61502 -1 1)
			)
			(= global136 636)
			(if (or (not (gGk2Music handle:)) (!= 606 (gGk2Music number:)))
				(Lock rsAUDIO 606 1)
				(gGk2Music setLoop: -1 number: 606 play:)
			)
		else
			(proc499_4)
		)
		(fNorthExit init:)
		(fEastExit init:)
		(gGame handsOn:)
	)
)

(instance fNorthExit of HuntExit
	(properties
		approachX 300
		approachY 150
		BAD_SELECTOR 621
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 318 246 312 -3 463 0 468 235)
	)
)

(instance fEastExit of HuntExit
	(properties
		nsLeft 586
		nsTop 15
		nsRight 640
		nsBottom 334
		x 600
		y 300
		BAD_SELECTOR 636
		BAD_SELECTOR 2
	)
)

