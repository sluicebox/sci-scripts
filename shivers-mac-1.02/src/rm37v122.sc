;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37122)
(include sci.sh)
(use Main)

(public
	rm37v122 0
)

(instance rm37v122 of ShiversRoom
	(properties
		picture 37122
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37123
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37251
	)

	(method (init)
		(self createPoly: 198 143 174 111 261 111 261 143 198 143)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37111
	)

	(method (init)
		(self createPoly: 174 145 151 105 170 105 162 25 100 16 60 81 60 141)
		(super init: &rest)
	)
)

