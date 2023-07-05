;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7428)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm7428 0
)

(instance rm7428 of ExitRoom
	(properties
		picture 7426
		south 740 ; gastRm
	)

	(method (init)
		(super init: &rest)
		(portrait init:)
	)
)

(instance portrait of GKFeature
	(properties
		modNum 740
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 146 -2 146 333 470 333 470 -1
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(= noun
			(cond
				((== gChapter 6) 49)
				((IsFlag 179) 8)
				(else 7)
			)
		)
		(super doVerb: &rest)
	)
)

