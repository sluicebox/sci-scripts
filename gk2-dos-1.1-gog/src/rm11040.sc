;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11040)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm11040 0
)

(instance rm11040 of ExitRoom
	(properties
		picture 11040
		east 1100 ; foyerRm
		south 1100 ; foyerRm
		west 1100 ; foyerRm
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(super init: &rest)
		(poster init:)
	)
)

(instance poster of GKFeature
	(properties
		modNum 1100
		x 307
		y 165
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 418 0 400 333 173 333 197 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 4 62 0 0 0 1100) ; "(PICKUP, READING OPERA SIGN IN THEATER FOYER)Der Fluch des Englehart, by Richard Wagner. Conducted by Herr Claus Immerding and Herr Georg Immerding."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

