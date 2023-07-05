;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13605)
(include sci.sh)
(use Main)

(public
	rm13v605 0
)

(instance rm13v605 of ShiversRoom
	(properties
		picture 13231
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13436
	)

	(method (init)
		(self createPoly: 130 95 130 48 162 44 162 97)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13434
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13435
	)
)

