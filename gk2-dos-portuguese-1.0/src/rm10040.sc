;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10040)
(include sci.sh)
(use Main)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm10040 0
)

(instance rm10040 of ExitRoom
	(properties
		picture 10040
		east 1000 ; altExtRm
		south 1000 ; altExtRm
		west 1000 ; altExtRm
	)

	(method (init)
		(super init: &rest)
		(plaqueArea1 init:)
	)
)

(instance plaqueArea1 of GKFeature
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

