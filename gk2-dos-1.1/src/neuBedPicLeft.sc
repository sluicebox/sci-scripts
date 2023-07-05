;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9243)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	neuBedPicLeft 0
)

(instance neuBedPicLeft of ExitRoom
	(properties
		picture 9243
		east 9244 ; neuBedPicRt
		south 920 ; rm920
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
		loop 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 591)
		)
		(super doVerb: theVerb)
	)
)

