;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8644)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	wahn8644 0
)

(instance wahn8644 of ExitRoom
	(properties
		picture 8644
		south 8603 ; wahnDisp3Rm
	)

	(method (init)
		(super init: &rest)
		(ludbust init:)
	)
)

(instance ludbust of GKFeature
	(properties
		noun 6
		modNum 860
		x 321
		y 151
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 322 38 353 38 376 80 362 142 413 191 404 246 331 265 230 196 269 163 306 151 309 118 287 90 291 61
					yourself:
				)
		)
		(super init: &rest)
	)
)

