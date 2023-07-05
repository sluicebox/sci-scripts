;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7230)
(include sci.sh)
(use Main)

(public
	rm7230 0
)

(instance rm7230 of ShiversRoom
	(properties
		picture 7230
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7130
	)
)

