;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32380)
(include sci.sh)
(use Main)

(public
	rm32v380 0
)

(instance rm32v380 of ShiversRoom
	(properties
		picture 32380
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32074
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32400
	)

	(method (init)
		(self
			createPoly:
				193
				103
				165
				85
				165
				33
				97
				34
				85
				83
				51
				98
				49
				111
				194
				111
				194
				102
		)
		(super init: &rest)
	)
)

