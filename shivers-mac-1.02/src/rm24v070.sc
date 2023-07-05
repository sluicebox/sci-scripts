;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24070)
(include sci.sh)
(use Main)

(public
	rm24v070 0
)

(instance rm24v070 of ShiversRoom
	(properties
		picture 24070
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24080
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24170
	)
)

