;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9341)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)
(use Actor)

(public
	neuStudyRightPic 0
)

(instance neuStudyRightPic of ExitRoom
	(properties
		picture 9341
		east 9342 ; neuStudyNudePic
		south 930 ; rm930
		west 9340 ; neuStudyLeftPic
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
		case 5
		modNum 930
		x 10
		y 290
		view 141
	)
)

