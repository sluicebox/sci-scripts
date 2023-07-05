;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8540)
(include sci.sh)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	wahnDispCase 0
)

(instance wahnDispCase of ExitRoom
	(properties
		picture 8540
		south 850 ; wahnEntryRm
	)

	(method (init)
		(super init: &rest)
		(cosJournal init:)
	)
)

(instance cosJournal of GKFeature
	(properties
		noun 1
		modNum 850
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 177 84 309 66 366 224 213 250
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 806)
				(super doVerb: theVerb)
			else
				(SetFlag 806)
				(PlayScene 521 0 850) ; wahnEntryRm
			)
		else
			(super doVerb: theVerb)
		)
	)
)

