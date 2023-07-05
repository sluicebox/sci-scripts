;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9244)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	neuBedPicRt 0
)

(instance neuBedPicRt of ExitRoom
	(properties
		picture 9244
		south 920 ; rm920
		west 9243 ; neuBedPicLeft
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		else
			(painting init:)
		)
		(super init: &rest)
	)
)

(instance painting of GKFeature
	(properties
		noun 17
		modNum 940
		nsLeft 12
		nsTop 12
		nsRight 440
		nsBottom 300
	)
)

(instance tourTapeButton of View
	(properties
		noun 16
		modNum 920
		x 10
		y 290
		view 141
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 592)
		)
		(super doVerb: theVerb)
	)
)

