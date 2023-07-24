;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56515)
(include sci.sh)
(use n011)
(use northExit)
(use Feature)

(public
	vzShrank 0
)

(instance vzShrank of ExitRoom
	(properties
		picture 56540
	)

	(method (init)
		(super init: &rest)
		(fSouthExit init:)
		(fClothes init:)
	)
)

(instance fClothes of GKFeature
	(properties
		BAD_SELECTOR 3646
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 109 143 402 161 475 134 521 147 559 178 571 242 543 328 38 244
		)
	)
)

(instance fSouthExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 4646 0 56501) ; vzRm
		else
			(super doVerb: &rest)
		)
	)
)

