;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13446)
(include sci.sh)
(use Main)

(public
	rm13v446 0
)

(instance rm13v446 of ShiversRoom
	(properties
		picture 13730
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13447
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13445
	)
)

