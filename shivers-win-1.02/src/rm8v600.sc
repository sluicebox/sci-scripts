;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8600)
(include sci.sh)
(use Main)

(public
	rm8v600 0
)

(instance rm8v600 of ShiversRoom
	(properties
		picture 8600
	)

	(method (init)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nsLeft 21
		nsTop 0
		nsRight 243
		nsBottom 30
		nextRoom 8590
	)
)

