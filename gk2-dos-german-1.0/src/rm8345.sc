;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8345)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm8345 0
)

(instance rm8345 of ExitRoom
	(properties
		picture 8345
		east 8346 ; rm8346
		south 8342 ; rm8342
		west 8344 ; rm8344
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
		(SetFlag 644)
		(SetFlag 597)
		(gGame changeScore: 1003)
	)
)

(instance plaque of Feature
	(properties
		noun 6
		modNum 830
		nsLeft 188
		nsTop 24
		nsRight 556
		nsBottom 304
	)
)

