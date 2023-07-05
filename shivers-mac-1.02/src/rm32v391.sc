;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32391)
(include sci.sh)
(use Main)

(public
	rm32v391 0
)

(instance rm32v391 of ShiversRoom
	(properties
		picture 32391
	)

	(method (init)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32390
	)

	(method (init)
		(self createPoly: 192 1 262 1 262 143 201 143 192 1)
		(super init: &rest)
	)
)

