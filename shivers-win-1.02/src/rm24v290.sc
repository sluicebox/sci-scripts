;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24290)
(include sci.sh)
(use Main)

(public
	rm24v290 0
)

(instance rm24v290 of ShiversRoom
	(properties
		picture 24290
	)

	(method (init)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 24280
	)

	(method (init)
		(self createPoly: 1 121 1 142 263 142 263 122 263 121 2 121)
		(super init: &rest)
	)
)

