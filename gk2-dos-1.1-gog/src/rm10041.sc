;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10041)
(include sci.sh)
(use Main)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm10041 0
)

(instance rm10041 of ExitRoom
	(properties
		picture 10041
		east 10002 ; rm10002
		south 10002 ; rm10002
		west 10002 ; rm10002
	)

	(method (init)
		(super init: &rest)
		(plaqueArea2 init:)
	)
)

(instance plaqueArea2 of GKFeature
	(properties
		sightAngle 40
		x 307
		y 165
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 593 0 593 308 23 308 23 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 1 62 0 0 0 1000) ; "(ALTOTTING. READING 'MIRACLE' PLAQUES)These all say "Marie hat geholfen." -- "Mary helped.""
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

