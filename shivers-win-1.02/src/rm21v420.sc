;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21420)
(include sci.sh)
(use Main)

(public
	rm21v420 0
)

(instance rm21v420 of ShiversRoom
	(properties
		picture 21420
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21390
	)
)

