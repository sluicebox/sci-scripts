;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9242)
(include sci.sh)
(use Main)
(use northExit)
(use Actor)

(public
	neuBedStatue 0
)

(instance neuBedStatue of ExitRoom
	(properties
		picture 9242
		south 920 ; rm920
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
	)
)

(instance tourTapeButton of View
	(properties
		noun 2
		modNum 920
		x 10
		y 290
		view 141
		loop 5
	)
)

