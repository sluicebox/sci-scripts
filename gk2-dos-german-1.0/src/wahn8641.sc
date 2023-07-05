;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8641)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	wahn8641 0
)

(instance wahn8641 of ExitRoom
	(properties
		picture 8641
		south 8640 ; wahn8640
	)

	(method (init)
		(super init: &rest)
		(diagram init:)
		(SetFlag 630)
		(gGame changeScore: 1019)
	)
)

(instance diagram of GKFeature
	(properties
		noun 4
		modNum 860
		nsLeft 14
		nsTop 14
		nsRight 624
		nsBottom 312
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 594)
		)
		(super doVerb: theVerb)
	)
)

