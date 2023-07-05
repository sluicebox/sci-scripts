;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10044)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm10044 0
)

(instance rm10044 of ExitRoom
	(properties
		picture 10044
		east 1000 ; altExtRm
		south 1000 ; altExtRm
		west 1000 ; altExtRm
	)

	(method (init)
		(super init: &rest)
		(crosses init:)
	)
)

(instance crosses of GKFeature
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
				(if (IsFlag 703)
					(gMessager say: 7 62 0 0 0 1000) ; "(TURNING DOWN THE OFFER NERVOUSLY)I think I'll do my petitioning inside the chapel."
				else
					(SetFlag 703)
					(gMessager say: 6 62 0 0 0 1000) ; "(LOOK AT CROSSES, CURIOUS)I suppose the crosses are gifts from the cured. Or are they another means of petitioning the Lady?"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

