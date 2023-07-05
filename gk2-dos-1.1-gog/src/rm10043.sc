;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10043)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm10043 0
)

(instance rm10043 of ExitRoom
	(properties
		picture 10043
		east 1000 ; altExtRm
		west 1000 ; altExtRm
	)

	(method (init)
		(super init: &rest)
		(SetFlag 719)
		(glassCaseSign init:)
		(silverLimbs init:)
		(theSouthExit init:)
	)
)

(instance glassCaseSign of GKFeature
	(properties
		sightAngle 40
		x 161
		y 170
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 266 276 264 317 200 317 196 276
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gGame changeScore: 1112)
				(SetFlag 704)
				(gCurRoom newRoom: 10047)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance silverLimbs of GKFeature
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
				(if (IsFlag 704)
					(gMessager say: 4 62 0 0 0 1000) ; "(THOUGHTFUL)I wonder if these penitent gifts do any good?"
				else
					(gGame changeScore: 1112)
					(gMessager say: 3 62 0 0 0 1000) ; "(LOOK AT PENITENT GIFTS, CURIOUS)Silver body parts."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theSouthExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		exitDir 4
	)

	(method (doVerb)
		(gCurRoom newRoom: 1000) ; altExtRm
	)
)

