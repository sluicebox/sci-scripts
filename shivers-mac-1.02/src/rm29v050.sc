;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29050)
(include sci.sh)
(use Main)

(public
	rm29v050 0
)

(instance rm29v050 of ShiversRoom
	(properties
		picture 29050
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29230
	)

	(method (init)
		(self
			createPoly: 87 145 87 70 95 55 109 45 121 45 133 52 141 65 141 74 146 136 87 145
		)
		(super init: &rest)
	)
)

