;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24220)
(include sci.sh)
(use Main)

(public
	rm24v220 0
)

(instance rm24v220 of ShiversRoom
	(properties
		picture 24220
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24250
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24190
	)
)

