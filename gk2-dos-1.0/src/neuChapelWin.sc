;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9441)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)
(use Actor)

(public
	neuChapelWin 0
)

(instance neuChapelWin of ExitRoom
	(properties
		picture 9441
		south 940 ; rm940
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
	)
)

(instance stainWin of GKFeature ; UNUSED
	(properties
		noun 5
		modNum 940
		nsLeft 20
		nsTop 20
		nsRight 410
		nsBottom 300
	)
)

(instance tourTapeButton of View
	(properties
		noun 4
		modNum 940
		x 10
		y 290
		view 141
		loop 5
	)
)

