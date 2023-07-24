;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6201)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v201 0
)

(instance rm6v201 of ShiversRoom
	(properties
		picture 6201
	)

	(method (init)
		(proc951_16 88)
		(efBack init: 8)
		(efNote init: 0)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 6200
	)

	(method (init)
		(self
			createPoly: 0 0 20 20 243 20 243 37 248 37 253 107 243 107 243 123 20 123 20 20 0 0 0 143 263 143 263 0
		)
		(super init: &rest)
	)
)

(instance efNote of ExitFeature
	(properties
		nextRoom 6202
	)

	(method (init)
		(self createPoly: 158 40 248 37 253 107 162 112)
		(super init: &rest)
	)
)

