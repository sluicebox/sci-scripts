;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8344)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm8344 0
)

(instance rm8344 of ExitRoom
	(properties
		picture 8344
		east 8345 ; rm8345
		south 8342 ; rm8342
	)

	(method (init)
		(super init: &rest)
		(plaque init:)
		(gGame changeScore: 1002)
	)
)

(instance plaque of Feature
	(properties
		noun 5
		modNum 830
		nsLeft 172
		nsTop 19
		nsRight 458
		nsBottom 326
	)
)

