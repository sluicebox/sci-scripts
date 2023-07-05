;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7605)
(include sci.sh)
(use Location)
(use Polygon)
(use Feature)

(public
	octoMuseumWheelCU 0
)

(instance octoMuseumWheelCU of CloseupLocation
	(properties
		heading 0
	)

	(method (init)
		(super init: 7614)
		(WHEEL_0 init:)
		(self edgeW: 0 edgeE: 0)
	)
)

(instance WHEEL_0 of Feature
	(properties
		noun 45
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 89 107 154 111 199 39 291 1 389 44 438 109 499 108 527 288 60 291 87 107
					yourself:
				)
		)
	)
)

