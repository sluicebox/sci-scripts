;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56544)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	vzBRmSink 0
)

(instance vzBRmSink of ExitRoom
	(properties
		modNum 546
		picture 56544
	)

	(method (init)
		(super init: &rest)
		(fSouthExit init:)
		(fSink init:)
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
		exitDir 4
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 1669 0 56512) ; vzBRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fSink of GKFeature
	(properties
		noun 6
		modNum 546
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				-1
				254
				81
				30
				252
				18
				213
				3
				215
				-2
				378
				-1
				363
				12
				541
				5
				617
				168
				618
				332
				-2
				333
		)
	)
)

