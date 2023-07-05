;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8640)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	wahn8640 0
)

(instance wahn8640 of ExitRoom
	(properties
		picture 8640
		south 8602 ; wahnDisp2Rm
	)

	(method (init)
		(super init: &rest)
		(letter init:)
		(papers init:)
	)
)

(instance letter of GKFeature
	(properties
		noun 3
		modNum 860
		nsLeft 4
		nsTop 50
		nsRight 173
		nsBottom 281
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 593)
			(gGame changeScore: 1018)
		)
		(super doVerb: theVerb)
	)
)

(instance papers of GKFeature
	(properties
		nsLeft 186
		nsTop 52
		nsRight 610
		nsBottom 278
		nextRoomNum 8641 ; wahn8641
	)
)

