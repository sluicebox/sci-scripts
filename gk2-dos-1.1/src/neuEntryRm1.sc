;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9140)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	neuEntryRm1 0
)

(instance neuEntryRm1 of ExitRoom
	(properties
		picture 9140
		east 9141 ; neuEntryRm2
		south 910 ; rm910
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
		(painting init:)
	)
)

(instance painting of GKFeature
	(properties
		modNum 910
		nsLeft 10
		nsTop 4
		nsRight 450
		nsBottom 312
	)

	(method (doVerb theVerb)
		(= noun
			(cond
				((== gChapter 6)
					(= modNum 940)
					17
				)
				((IsFlag 580) 4)
				(else 3)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance tourTapeButton of View
	(properties
		noun 12
		case 1
		modNum 910
		x 10
		y 290
		view 141
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 580)
		)
		(super doVerb: theVerb)
	)
)

