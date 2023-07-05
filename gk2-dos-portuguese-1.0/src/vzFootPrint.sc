;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56542)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	vzFootPrint 0
)

(instance vzFootPrint of ExitRoom
	(properties
		modNum 546
		picture 56542
	)

	(method (init)
		(super init: &rest)
		(fSouthExit init:)
		(gGame changeScore: 1068)
		(fRug init:)
		(SetFlag 685)
		(fPrint init:)
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
			(PlayScene 2671 0 56512) ; vzBRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fPrint of GKFeature
	(properties
		noun 5
		modNum 546
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				59
				60
				159
				21
				199
				29
				197
				105
				124
				153
				118
				192
				141
				211
				119
				302
				68
				296
				50
				262
				72
				212
				70
				146
				60
				121
		)
	)
)

(instance fRug of GKFeature
	(properties
		noun 10
		modNum 546
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 281 332 382 0 616 -2 615 333)
	)
)

