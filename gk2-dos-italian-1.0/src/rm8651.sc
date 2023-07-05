;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8651)
(include sci.sh)
(use northExit)
(use Feature)

(public
	rm8651 0
)

(instance rm8651 of ExitRoom
	(properties
		picture 8651
		south 8645 ; wahn8645
	)

	(method (init)
		(super init: &rest)
		(plaqueF init:)
	)
)

(instance plaqueF of GKFeature
	(properties
		noun 24
		modNum 860
		nsLeft 10
		nsTop 10
		nsRight 600
		nsBottom 330
	)
)

