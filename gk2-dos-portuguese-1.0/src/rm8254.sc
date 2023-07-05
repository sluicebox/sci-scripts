;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8254)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm8254 0
)

(instance rm8254 of ExitRoom
	(properties
		picture 8254
		south 820 ; rm820
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
	)
)

(instance plaque of GKFeature
	(properties
		modNum 820
		nsLeft 100
		nsTop 54
		nsRight 530
		nsBottom 304
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 62) ; Do
			(= temp0
				(if (IsFlag 642)
					1
				else
					(SetFlag 642)
					0
				)
			)
			(gMessager say: 19 theVerb 0 temp0 0 820)
		else
			(super doVerb: theVerb)
		)
	)
)

