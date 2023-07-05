;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18160)
(include sci.sh)
(use Main)
(use n951)

(public
	rm18v16 0
)

(instance rm18v16 of ShiversRoom
	(properties
		picture 18160
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(ClearFlag 43)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18150
	)

	(method (init)
		(self createPoly: 227 142 208 122 208 28 226 28)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18240
	)

	(method (init)
		(self createPoly: 130 130 130 80 184 80 184 130 130 130)
		(super init: &rest)
	)
)

