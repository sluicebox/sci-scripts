;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19257)
(include sci.sh)
(use Main)

(public
	rm19v257 0
)

(instance rm19v257 of ShiversRoom
	(properties
		picture 19257
	)

	(method (init)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nsLeft 21
		nsTop 113
		nsRight 243
		nsBottom 143
		nextRoom 19250
	)
)

