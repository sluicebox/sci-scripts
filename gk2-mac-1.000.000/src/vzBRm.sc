;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56512)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	vzBRm 0
)

(instance vzBRm of ExitRoom
	(properties
		modNum 546
		picture 56512
		east 56511 ; vzNightStand
		west 56501 ; vzRm
	)

	(method (init)
		(super init: &rest)
		(fSink init:)
		(fTub init:)
		(fRug init:)
		(gGame handsOn:)
	)
)

(instance fSink of GKFeature
	(properties
		sceneNum 669
		nextRoomNum 56544 ; vzBRmSink
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 205 120 295 121 301 147 207 188)
	)
)

(instance fTub of GKFeature
	(properties
		sceneNum 670
		nextRoomNum 56546 ; vzBRmTub
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 314 260 253 169 316 154 505 163 505 280)
	)
)

(instance fRug of GKFeature
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 671 0 56541) ; vzRug
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 329 334 378 299 494 313 489 334)
	)
)

