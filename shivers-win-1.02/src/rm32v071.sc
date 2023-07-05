;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32071)
(include sci.sh)
(use Main)

(public
	rm32v071 0
)

(instance rm32v071 of ShiversRoom
	(properties
		picture 32071
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32072
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32072
	)
)

