;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1011)
(include sci.sh)
(use Main)

(public
	rm1v11 0
)

(instance rm1v11 of ShiversRoom
	(properties
		picture 1011
	)

	(method (init)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nsLeft 21
		nsTop 115
		nsRight 243
		nsBottom 144
		nextRoom 1010
	)
)

