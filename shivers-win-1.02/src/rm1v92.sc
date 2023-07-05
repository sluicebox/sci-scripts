;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1092)
(include sci.sh)
(use Main)

(public
	rm1v92 0
)

(instance rm1v92 of ShiversRoom
	(properties
		picture 1092
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1101
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1101
	)
)

