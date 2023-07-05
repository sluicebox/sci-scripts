;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10142)
(include sci.sh)
(use Main)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm10142 0
)

(instance rm10142 of ExitRoom
	(properties
		picture 10142
		east 10102 ; rm10102
		south 10102 ; rm10102
		west 10102 ; rm10102
	)

	(method (init)
		(super init: &rest)
		(madonna init:)
	)
)

(instance madonna of GKFeature
	(properties
		sightAngle 40
		x 327
		y 154
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 426 0 426 308 228 308 228 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 5 62 0 0 0 1010) ; "(LOOK AT MADONNA STATUE, HUSHED)It's the Lady of Alt\99tting."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

