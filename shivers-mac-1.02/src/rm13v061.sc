;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13061)
(include sci.sh)
(use Main)

(public
	rm13v061 0
)

(instance rm13v061 of ShiversRoom
	(properties
		picture 13630
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 207
		nextRoom 13058
	)
)

