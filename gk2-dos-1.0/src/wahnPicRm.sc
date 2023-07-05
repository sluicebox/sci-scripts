;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8530)
(include sci.sh)
(use northExit)
(use Feature)

(public
	wahnPicRm 0
)

(instance wahnPicRm of ExitRoom
	(properties
		picture 8530
		south 850 ; wahnEntryRm
	)

	(method (init)
		(super init: &rest)
		(painting init:)
	)
)

(instance painting of GKFeature
	(properties
		modNum 850
		nsLeft 80
		nsTop 21
		nsRight 632
		nsBottom 312
	)
)

