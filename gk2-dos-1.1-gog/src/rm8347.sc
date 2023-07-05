;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8347)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8347 0
)

(instance rm8347 of ExitRoom
	(properties
		picture 8347
		south 830 ; rm830
	)

	(method (init)
		(super init: &rest)
		(deathMask init:)
	)
)

(instance deathMask of Feature
	(properties
		noun 4
		modNum 830
		nsLeft 258
		nsTop 124
		nsRight 380
		nsBottom 240
	)
)

