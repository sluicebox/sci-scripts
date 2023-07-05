;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24250)
(include sci.sh)
(use Main)

(public
	rm24v250 0
)

(instance rm24v250 of ShiversRoom
	(properties
		picture 24250
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24260
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24230
	)
)

