;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2317)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm2317 0
)

(instance rm2317 of ExitRoom
	(properties
		picture 2317
		south 230 ; hellZooRm
	)

	(method (init)
		(super init: &rest)
		(fGate init:)
		(fPath init:)
		(fcloseGate init:)
		(gGame handsOn:)
	)
)

(instance fGate of GKFeature
	(properties
		noun 20
		modNum 230
	)

	(method (init)
		(if (IsFlag 437)
			(= noun 26)
		)
		(super init: &rest)
		(self createPoly: 272 137 451 138 370 230 311 227)
	)
)

(instance fcloseGate of GKFeature
	(properties
		noun 18
		modNum 230
	)

	(method (init)
		(if (IsFlag 437)
			(= noun 26)
		)
		(super init: &rest)
		(self createPoly: 266 254 355 257 354 298 266 297)
	)
)

(instance fPath of GKFeature
	(properties
		noun 25
		modNum 230
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 437)
			(= noun 26)
		)
		(self createPoly: 290 229 382 232 406 284 358 282 357 252 268 252)
	)
)

