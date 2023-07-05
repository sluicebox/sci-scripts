;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8442)
(include sci.sh)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm8442 0
)

(instance rm8442 of ExitRoom
	(properties
		picture 8442
		south 840 ; starnSeeRm
	)

	(method (init)
		(super init: &rest)
		(chapel init:)
	)
)

(instance chapel of GKFeature
	(properties
		modNum 840
	)

	(method (init)
		(= noun (if (IsFlag 603) 20 else 19))
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 302 19 234 124 231 214 189 247 188 316 235 316 270 301 357 303 385 315 421 315 419 243 380 217 374 121
					yourself:
				)
		)
		(super init: &rest)
	)
)

