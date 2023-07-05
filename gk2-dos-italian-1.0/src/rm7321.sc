;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7321)
(include sci.sh)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	rm7321 0
)

(instance rm7321 of ExitRoom
	(properties
		picture 7321
		south 7301 ; rm7301
	)

	(method (init)
		(namePlate init:)
		(closeUpSpot init:)
		(if (IsFlag 610)
			(smellyRoses init:)
		)
		(super init: &rest)
	)
)

(instance smellyRoses of View
	(properties
		modNum 730
		x 222
		y 205
		priority 400
		fixPriority 1
		view 34614
	)

	(method (doVerb theVerb)
		(if (IsFlag 610)
			(= noun 13)
		else
			(= noun 12)
		)
		(super doVerb: theVerb)
	)
)

(instance closeUpSpot of GKFeature
	(properties
		nsLeft 154
		nsTop 169
		nsRight 566
		nsBottom 293
		BAD_SELECTOR 7349
	)
)

(instance namePlate of GKFeature
	(properties
		noun 4
		modNum 730
		nsLeft 278
		nsTop 283
		nsRight 558
		nsBottom 329
		y 2001
	)
)

