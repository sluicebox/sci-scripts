;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13501)
(include sci.sh)
(use Main)

(public
	rm13v501 0
)

(instance rm13v501 of ShiversRoom
	(properties
		picture 13620
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13502
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13500
	)
)

