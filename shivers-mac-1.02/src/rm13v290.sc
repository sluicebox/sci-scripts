;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13290)
(include sci.sh)
(use Main)

(public
	rm13v290 0
)

(instance rm13v290 of ShiversRoom
	(properties
		picture 13400
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13288
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13289
	)
)

