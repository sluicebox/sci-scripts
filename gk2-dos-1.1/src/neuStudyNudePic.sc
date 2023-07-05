;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9342)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)
(use Actor)

(public
	neuStudyNudePic 0
)

(instance neuStudyNudePic of ExitRoom
	(properties
		picture 9342
		south 930 ; rm930
		west 9341 ; neuStudyRightPic
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
		case 4
		modNum 930
		x 10
		y 290
		view 141
	)
)

