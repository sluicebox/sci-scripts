;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8643)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	wahn8643 0
)

(instance wahn8643 of ExitRoom
	(properties
		picture 8643
		south 8602 ; wahnDisp2Rm
	)

	(method (init)
		(super init: &rest)
		(plq init:)
		(SetFlag 808)
		(gGame changeScore: 1022)
	)
)

(instance plq of GKFeature
	(properties
		noun 8
		modNum 860
		nsLeft 24
		nsTop 16
		nsRight 597
		nsBottom 314
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 595)
		)
		(super doVerb: theVerb)
	)
)

