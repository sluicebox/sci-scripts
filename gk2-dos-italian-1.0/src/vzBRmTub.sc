;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56546)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	vzBRmTub 0
)

(instance vzBRmTub of ExitRoom
	(properties
		modNum 546
		picture 56546
	)

	(method (init)
		(super init: &rest)
		(fSouthExit init:)
		(fTub init:)
		(gGame handsOn:)
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
			(PlayScene 1670 0 56512) ; vzBRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fTub of GKFeature
	(properties
		noun 7
		modNum 546
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 99 332 59 270 60 195 155 50 209 16 268 4 616 66 615 333
		)
	)
)

