;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56541)
(include sci.sh)
(use n011)
(use northExit)
(use Feature)

(public
	vzRug 0
)

(instance vzRug of ExitRoom
	(properties
		modNum 546
		picture 56541
	)

	(method (init)
		(super init: &rest)
		(fSouthExit init:)
		(fRug init:)
		(fMudPrint init:)
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
			(PlayScene 2671 0 56512) ; vzBRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fMudPrint of GKFeature
	(properties
		sceneNum 1671
		nextRoomNum 56542 ; vzFootPrint
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 64 126 66 102 90 91 64 81 63 61 85 64 96 66 87 53 101 44 110 45 113 50 112 38 131 31 137 39 141 27 161 27
		)
	)
)

(instance fRug of GKFeature
	(properties
		noun 4
		modNum 546
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 1 187 187 1 615 0 615 288 0 292)
	)
)

