;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9540)
(include sci.sh)
(use Main)
(use northExit)
(use Actor)

(public
	neuLRPainting 0
)

(instance neuLRPainting of ExitRoom
	(properties
		picture 9540
		south 950 ; rm950
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
		noun 8
		case 1
		modNum 950
		x 10
		y 290
		view 141
	)
)

