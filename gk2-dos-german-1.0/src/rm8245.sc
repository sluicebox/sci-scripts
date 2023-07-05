;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8245)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm8245 0
)

(instance rm8245 of ExitRoom
	(properties
		picture 8245
		south 8243 ; rm8243
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		noun 18
		modNum 820
		nsLeft 168
		nsTop 19
		nsRight 458
		nsBottom 333
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 62) (IsFlag 637)) ; Do
			(gMessager say: noun theVerb 0 1 0 modNum)
		else
			(SetFlag 637)
			(super doVerb: theVerb)
		)
	)
)

