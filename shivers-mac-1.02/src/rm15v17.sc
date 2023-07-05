;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15170)
(include sci.sh)
(use Main)

(public
	rm15v17 0
)

(instance rm15v17 of ShiversRoom
	(properties
		picture 15170
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15150
	)

	(method (init)
		(self createPoly: 57 142 103 100 99 54 148 54 148 100 192 135 193 141)
		(super init: &rest)
	)
)

