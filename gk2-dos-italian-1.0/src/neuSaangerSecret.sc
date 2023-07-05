;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9713)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	neuSaangerSecret 0
)

(instance neuSaangerSecret of ExitRoom
	(properties
		picture 9713
		south 970 ; rm970
	)

	(method (init)
		(super init: &rest)
		(panel init:)
	)
)

(instance panel of GKFeature
	(properties
		x 250
		y 210
		BAD_SELECTOR 970
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 293 252 418 239 417 295 293 314
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gEgo
				get:
					(cond
						((gEgo has: 60) ; invOperaAct1
							(gEgo put: 60) ; invOperaAct1
							59
						)
						((gEgo has: 59) ; invOperaAct2
							(gEgo put: 59) ; invOperaAct2
							58
						)
						(else 60)
					)
			)
			(SetFlag 804)
		)
		(SetFlag 699)
		(PlayScene 785)
		(PlayScene 783 0 BAD_SELECTOR)
	)
)

