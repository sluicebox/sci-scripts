;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8346)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)

(public
	rm8346 0
)

(instance rm8346 of ExitRoom
	(properties
		picture 8346
		east 8349 ; rm8349
		south 8342 ; rm8342
		west 8345 ; rm8345
	)

	(method (init)
		(super init: &rest)
		(gGame changeScore: 1004)
		(plaque init:)
	)
)

(instance plaque of Feature
	(properties
		noun 7
		modNum 830
		nsLeft 188
		nsTop 24
		nsRight 556
		nsBottom 304
	)
)

