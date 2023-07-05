;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11241)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm11241 0
)

(instance rm11241 of ExitRoom
	(properties
		picture 11241
		east 1120 ; resOfficeRm
		south 1120 ; resOfficeRm
		west 1120 ; resOfficeRm
	)

	(method (init)
		(super init: &rest)
		(bulletinBoard init:)
		(if (not (IsFlag 758))
			(seatChart init:)
		)
	)
)

(instance seatChart of View
	(properties
		modNum 1120
		x 65
		y 153
		view 30839
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 839)
				(SetFlag 758)
				(gEgo get: 66) ; invSeatingChart
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bulletinBoard of GKFeature
	(properties
		modNum 1120
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
				(gMessager say: 2 62 0 0 0 1120) ; "(LOOK AT BULLETIN BOARD)Old playbills and schedules."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

