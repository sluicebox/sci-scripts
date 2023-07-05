;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7042)
(include sci.sh)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm7042 0
)

(instance rm7042 of ExitRoom
	(properties
		picture 7042
		east 7012 ; rm7012
		south 7012 ; rm7012
		west 7012 ; rm7012
	)

	(method (init)
		(super init: &rest)
		(churchSign init:)
	)
)

(instance churchSign of Feature
	(properties
		noun 9
		modNum 700
		x 308
		y 157
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 -2 107 316 510 316 510 -2
					yourself:
				)
		)
		(super init: &rest)
	)
)

