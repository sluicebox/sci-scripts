;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18010)
(include sci.sh)
(use Main)

(public
	rm18v1 0
)

(instance rm18v1 of ShiversRoom
	(properties
		picture 18010
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18040
	)

	(method (init)
		(self createPoly: 0 0 130 0 130 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18030
	)
)

