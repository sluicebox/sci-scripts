;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15210)
(include sci.sh)
(use Main)

(public
	rm15v21 0
)

(instance rm15v21 of ShiversRoom
	(properties
		picture 15210
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15190
	)
)

