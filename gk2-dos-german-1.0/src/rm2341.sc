;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2341)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm2341 0
)

(instance rm2341 of ExitRoom
	(properties
		modNum 230
		picture 2341
		south 230 ; hellZooRm
	)

	(method (init)
		(super init: &rest)
		(self setRegions: 2299) ; zooRegion
		(fSign init:)
		(gGame handsOn:)
	)

	(method (notify)
		(ClearFlag 443)
		(super notify: &rest)
	)
)

(instance fSign of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 80 328 76 2 554 4 552 328)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 2 62 0 1 0 230) ; "(READING SIGN, THOUGHTFUL)CANIS LUPUS LUPUS, European Wolf."
			(SetFlag 432)
			(gGame changeScore: 831)
		)
	)
)

