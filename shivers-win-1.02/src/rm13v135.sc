;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13135)
(include sci.sh)
(use Main)

(public
	rm13v135 0
)

(instance rm13v135 of ShiversRoom
	(properties
		picture 13290
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13133
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13132
	)
)

