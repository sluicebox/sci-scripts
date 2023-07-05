;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9443)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm9443 0
)

(instance rm9443 of ExitRoom
	(properties
		picture 9443
		south 940 ; rm940
	)

	(method (init)
		(super init: &rest)
		(blackMad init:)
	)
)

(instance blackMad of GKFeature
	(properties
		modNum 940
	)

	(method (init)
		(= noun
			(cond
				((== gChapter 6) 12)
				((IsFlag 584) 7)
				(else 6)
			)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 269 29 354 4 367 106 446 287 446 336 220 341 248 261 212 246 260 126 228 95 275 71
					yourself:
				)
		)
		(super init: &rest)
	)
)

