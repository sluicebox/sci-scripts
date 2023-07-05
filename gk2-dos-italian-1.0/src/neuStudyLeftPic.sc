;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9340)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)
(use Actor)

(public
	neuStudyLeftPic 0
)

(instance neuStudyLeftPic of ExitRoom
	(properties
		picture 9340
		east 9341 ; neuStudyRightPic
		south 930 ; rm930
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
	)
)

(instance painting of GKFeature ; UNUSED
	(properties
		modNum 930
		nsLeft 20
		nsTop 20
		nsRight 410
		nsBottom 300
	)
)

(instance tourTapeButton of View
	(properties
		noun 11
		case 3
		modNum 930
		x 10
		y 290
		view 141
	)
)

