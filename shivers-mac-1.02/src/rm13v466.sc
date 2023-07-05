;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13466)
(include sci.sh)
(use Main)

(public
	rm13v466 0
)

(instance rm13v466 of ShiversRoom
	(properties
		picture 13560
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13464
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13467
	)
)

