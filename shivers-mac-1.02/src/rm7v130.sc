;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7130)
(include sci.sh)
(use Main)

(public
	rm7v130 0
)

(instance rm7v130 of ShiversRoom
	(properties
		picture 7130
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7150
	)
)

