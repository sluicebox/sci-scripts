;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13460)
(include sci.sh)
(use Main)

(public
	rm13v460 0
)

(instance rm13v460 of ShiversRoom
	(properties
		picture 13510
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13461
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13459
	)
)

