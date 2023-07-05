;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1441)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Feature)
(use Actor)

(public
	rm1441 0
)

(instance rm1441 of GK2Room
	(properties
		picture 1441
		north 1430 ; rm1430
	)

	(method (init)
		(northExit init:)
		(southExit init:)
		(stuff init:)
		(super init:)
		(if (not (gEgo has: 21)) ; invScrewdriver
			(vodkaAndOj init:)
		)
	)
)

(instance stuff of GKFeature
	(properties
		noun 29
		modNum 140
		nsRight 640
		nsBottom 380
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 300
		nsRight 613
		nsBottom 334
		x 225
		y 2000
		BAD_SELECTOR 4
	)

	(method (doVerb)
		(PlayScene 1127 0 140) ; srGabeRoom
	)
)

(instance northExit of ExitFeature
	(properties
		nsRight 640
		nsBottom 100
		BAD_SELECTOR 1430
		BAD_SELECTOR 0
	)

	(method (setCursor param1)
		(param1 view: 998 loop: 1 cel: 1)
	)
)

(instance vodkaAndOj of View
	(properties
		x 121
		y 205
		view 30126
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gEgo get: 21) ; invScrewdriver
			(PlayScene 126)
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

