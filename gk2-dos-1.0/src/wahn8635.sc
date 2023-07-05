;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8635)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	wahn8635 0
)

(instance wahn8635 of ExitRoom
	(properties
		picture 8635
		south 8603 ; wahnDisp3Rm
	)

	(method (init)
		(super init: &rest)
		(painting init:)
	)
)

(instance painting of GKFeature
	(properties
		noun 5
		modNum 860
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 104 -1 80 334 557 333 526 -3
					yourself:
				)
		)
		(super init: &rest)
	)
)

