;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15200)
(include sci.sh)
(use Main)

(public
	rm15v20 0
)

(instance rm15v20 of ShiversRoom
	(properties
		picture 15200
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
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

