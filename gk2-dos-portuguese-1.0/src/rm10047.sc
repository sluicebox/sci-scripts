;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10047)
(include sci.sh)
(use Main)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm10047 0
)

(instance rm10047 of ExitRoom
	(properties
		picture 10047
		east 10043 ; rm10043
		south 10043 ; rm10043
		west 10043 ; rm10043
	)

	(method (init)
		(super init: &rest)
		(caseSign init:)
	)
)

(instance caseSign of GKFeature
	(properties
		x 161
		y 170
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 567 15 556 314 50 314 33 14
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 2 62 0 0 0 1000) ; "(READING THE SIGN, FASCINATED)'Penitent offerings.' A replica is made for the part of the body you wish to have healed. The replica is offered to the Lady of Alt\99tting as a token of faith."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

