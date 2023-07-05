;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10115)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm10115 0
)

(instance rm10115 of ExitRoom
	(properties
		modNum 1010
		picture 10115
		east 10102 ; rm10102
		south 10102 ; rm10102
		west 10102 ; rm10102
	)

	(method (init)
		(self setRegions: 1030) ; dressRegion
		(if (IsFlag 724)
			(= picture 10114)
		)
		(super init: &rest)
		(urns init:)
	)

	(method (notify)
		(ClearFlag 724)
		(ClearFlag 721)
		(SetFlag 730)
		(gCurRoom newRoom: 10102)
	)
)

(instance urns of GKFeature
	(properties
		sightAngle 40
		x 306
		y 77
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 447 0 447 155 166 155 166 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 724)
						(gMessager say: 15 62 0 0 0 1010) ; "(LIGHTS ARE OUT, CLICK ON NICHE WITHOUT MOVING CHAIR FIRST)I can't reach the urns!"
					)
					((IsFlag 727)
						(gMessager say: 16 62 0 0 0 1010) ; "(CLICK ON URN NICHE, LIGHTS ON)I think I know which one is Ludwig's, but how am I going to get it down?"
					)
					(else
						(SetFlag 727)
						(gMessager say: 14 62 0 0 0 1010) ; "(LOOK AT URNS IN CHAPEL)The heart urns!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

