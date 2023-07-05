;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8613)
(include sci.sh)
(use northExit)
(use Feature)

(public
	wahnBustRm1 0
)

(instance wahnBustRm1 of ExitRoom
	(properties
		picture 8613
		south 8601 ; wahnDispRm
	)

	(method (init)
		(super init: &rest)
		(wagbust init:)
	)
)

(instance wagbust of GKFeature
	(properties
		noun 16
		modNum 860
	)
)

