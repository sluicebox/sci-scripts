;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34040)
(include sci.sh)
(use Main)

(public
	rm34v040 0
)

(instance rm34v040 of ShiversRoom
	(properties
		picture 34040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 34030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 34010
	)
)

