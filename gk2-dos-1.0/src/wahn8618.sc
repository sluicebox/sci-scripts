;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8618)
(include sci.sh)
(use northExit)
(use Feature)

(public
	wahn8618 0
)

(instance wahn8618 of ExitRoom
	(properties
		picture 8618
		south 8604 ; wahnDisp4Rm
	)

	(method (init)
		(super init: &rest)
		(model init:)
	)
)

(instance model of GKFeature
	(properties
		noun 21
		modNum 860
	)

	(method (init)
		(super init: &rest)
		(self createPoly: -3 333 -1 270 140 30 291 13 442 31 620 332)
	)
)

