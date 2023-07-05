;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8652)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8652 0
)

(instance rm8652 of ExitRoom
	(properties
		picture 8652
		south 8614 ; wahnharpsichordRm1
	)

	(method (init)
		(super init: &rest)
		(plaqueF init:)
	)
)

(instance plaqueF of GKFeature
	(properties
		noun 18
		modNum 860
		nsLeft 10
		nsTop 10
		nsRight 600
		nsBottom 330
	)
)

