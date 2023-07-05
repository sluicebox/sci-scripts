;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24090)
(include sci.sh)
(use Main)

(public
	rm24v090 0
)

(instance rm24v090 of ShiversRoom
	(properties
		picture 24090
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24010
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24110
	)
)

