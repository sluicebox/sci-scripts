;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8612)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	wahnBustRm1 0
)

(instance wahnBustRm1 of ExitRoom
	(properties
		picture 8612
		south 8601 ; wahnDispRm
	)

	(method (init)
		(super init: &rest)
		(cosBust init:)
	)
)

(instance cosBust of GKFeature
	(properties
		noun 17
		modNum 860
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 261 40 241 79 285 164 285 178 213 217 221 238 262 278 305 282 294 334 402 335 395 279 409 279 416 229 352 194 359 145 367 136 372 71 369 42 348 18 302 16
					yourself:
				)
		)
		(super init: &rest)
	)
)

