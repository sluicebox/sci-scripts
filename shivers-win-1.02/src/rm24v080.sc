;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24080)
(include sci.sh)
(use Main)

(public
	rm24v080 0
)

(instance rm24v080 of ShiversRoom
	(properties
		picture 24080
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24100
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24070
	)
)

