;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8619)
(include sci.sh)
(use northExit)
(use Feature)

(public
	wahn8619 0
)

(instance wahn8619 of ExitRoom
	(properties
		picture 8619
		south 8604 ; wahnDisp4Rm
	)

	(method (init)
		(super init: &rest)
		(costume init:)
	)
)

(instance costume of GKFeature
	(properties
		noun 20
		modNum 860
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 147 332 163 64 182 56 162 14 201 8 204 27 214 -5 239 0 252 42 249 61 291 79 301 167 298 81 321 69 332 44 353 51 375 97 387 173 387 332
		)
	)
)

