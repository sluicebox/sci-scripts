;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27291)
(include sci.sh)
(use Main)

(public
	rm27v291 0
)

(instance rm27v291 of ShiversRoom
	(properties
		picture 27291
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27300
	)

	(method (init)
		(self createPoly: 88 142 121 58 142 58 175 142 89 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27290
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27292
	)
)

