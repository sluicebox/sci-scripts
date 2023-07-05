;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18180)
(include sci.sh)
(use Main)

(public
	rm18v18 0
)

(instance rm18v18 of ShiversRoom
	(properties
		picture 18180
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18150
	)

	(method (init)
		(self createPoly: 1 1 60 1 60 142 1 142 1 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18200
	)

	(method (init)
		(self createPoly: 87 142 105 113 111 45 111 16 141 16 149 114 159 142)
		(super init: &rest)
	)
)

