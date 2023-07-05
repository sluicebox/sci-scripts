;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9711)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)
(use Actor)

(public
	neuSaangerWindow 0
)

(instance neuSaangerWindow of ExitRoom
	(properties
		picture 9711
		south 9702 ; rm9702
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
		(windowF init:)
	)
)

(instance windowF of GKFeature
	(properties
		noun 13
		modNum 970
		nsLeft 12
		nsTop 12
		nsRight 620
		nsBottom 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31 ; invDove
				(= theVerb 62) ; Do
				(super doVerb: 62)
			)
			(62 ; Do
				(gMessager say: 21 62 0 1 0 140) ; "(LOOK AT WINDOW)Nice view of the Alps."
			)
		)
	)
)

(instance tourTapeButton of View
	(properties
		noun 12
		modNum 970
		x 10
		y 290
		view 141
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event)
	)
)

