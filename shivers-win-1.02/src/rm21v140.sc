;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21140)
(include sci.sh)
(use Main)

(public
	rm21v140 0
)

(instance rm21v140 of ShiversRoom
	(properties
		picture 21140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21200
	)
)

