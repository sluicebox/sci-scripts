;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7440)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	rm7440 0
)

(instance rm7440 of ExitRoom
	(properties
		picture 7440
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
					init: 235 96 330 96 332 226 232 225
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(= noun
			(cond
				((== gChapter 6) 49)
				((== gChapter 4) 12)
				((IsFlag 179) 51) ; "Ludwig II" in gastTopicRm
				(else 50)
			)
		)
		(super doVerb: &rest)
	)
)

