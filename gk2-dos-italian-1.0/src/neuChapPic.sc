;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9440)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	neuChapPic 0
)

(instance neuChapPic of ExitRoom
	(properties
		picture 9440
		south 940 ; rm940
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
		(painting init:)
	)
)

(instance painting of GKFeature
	(properties
		modNum 940
		nsLeft 20
		nsTop 20
		nsRight 410
		nsBottom 300
	)

	(method (doVerb)
		(if (== gChapter 6)
			(= noun 17)
		else
			(= noun 5)
		)
		(super doVerb: &rest)
	)
)

(instance tourTapeButton of View
	(properties
		noun 3
		modNum 940
		x 10
		y 290
		view 141
		loop 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 585)
		)
		(super doVerb: theVerb)
	)
)

