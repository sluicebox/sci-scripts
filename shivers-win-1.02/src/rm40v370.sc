;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40370)
(include sci.sh)
(use Main)

(public
	rm40v370 0
)

(instance rm40v370 of ShiversRoom
	(properties
		picture 40150
	)

	(method (init)
		(efExitForward init: 3)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35100
	)

	(method (init)
		(self
			createPoly: 65 8 82 73 98 73 91 90 147 90 145 74 158 74 170 9 66 8
		)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 40350
	)

	(method (init)
		(self createPoly: 91 92 147 92 158 140 159 143 66 143 91 93)
		(super init: &rest)
	)
)

