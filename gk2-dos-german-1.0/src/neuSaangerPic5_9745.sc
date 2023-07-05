;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9745)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	neuSaangerPic5 0
)

(instance neuSaangerPic5 of ExitRoom
	(properties
		picture 9745
		south 9702 ; rm9702
		west 9744 ; neuSaangerPic5
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		else
			(wolfPanel init:)
		)
		(super init: &rest)
	)
)

(instance wolfPanel of GKFeature
	(properties
		noun 8
		modNum 970
		nsLeft 12
		nsTop 12
		nsRight 620
		nsBottom 320
	)
)

(instance tourTapeButton of View
	(properties
		noun 19
		modNum 970
		x 10
		y 290
		view 141
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 625) ; enable "Wolf Panels at Neuschwanstein" in topic850
		)
		(super doVerb: theVerb)
	)
)

