;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9712)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	neuSaangerPic0 0
)

(instance neuSaangerPic0 of ExitRoom
	(properties
		picture 9716
		south 970 ; rm970
	)

	(method (init)
		(super init: &rest)
		(wolfPanel init:)
	)
)

(instance wolfPanel of GKFeature
	(properties
		modNum 970
		nsLeft 12
		nsTop 12
		nsRight 620
		nsBottom 320
	)

	(method (doVerb)
		(gGame changeScore: 1031)
		(cond
			((== gChapter 6)
				(= noun 8)
			)
			((IsFlag 625)
				(= noun 11)
			)
			(else
				(= noun 10)
			)
		)
		(super doVerb: &rest)
	)
)

