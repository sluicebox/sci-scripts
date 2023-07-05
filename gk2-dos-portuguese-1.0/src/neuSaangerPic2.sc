;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9741)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	neuSaangerPic2 0
)

(instance neuSaangerPic2 of ExitRoom
	(properties
		picture 9741
		east 9742 ; neuSaangerPic3
		south 970 ; rm970
		west 9740 ; neuSaangerPic1
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		else
			(wolfPanel init:)
		)
		(super init: &rest)
	)
)

(instance wolfPanel of GKFeature
	(properties
		noun 8
		modNum 970
		nsLeft 12
		nsTop 12
		nsRight 620
		nsBottom 320
	)
)

(instance tourTapeButton of View
	(properties
		noun 15
		modNum 970
		x 10
		y 290
		view 141
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 625)
		)
		(super doVerb: theVerb)
	)
)

