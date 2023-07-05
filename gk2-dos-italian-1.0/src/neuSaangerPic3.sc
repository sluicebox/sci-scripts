;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9742)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	neuSaangerPic3 0
)

(instance neuSaangerPic3 of ExitRoom
	(properties
		picture 9742
		east 9743 ; neuSaangerPic4
		south 970 ; rm970
		west 9741 ; neuSaangerPic2
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
		noun 16
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

