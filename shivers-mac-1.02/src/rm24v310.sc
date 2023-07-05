;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24310)
(include sci.sh)
(use Main)

(public
	rm24v310 0
)

(instance rm24v310 of ShiversRoom
	(properties
		picture 24310
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24270
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24280
	)
)

