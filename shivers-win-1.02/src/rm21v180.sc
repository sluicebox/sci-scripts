;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21180)
(include sci.sh)
(use Main)

(public
	rm21v180 0
)

(instance rm21v180 of ShiversRoom
	(properties
		picture 21180
	)

	(method (init)
		(efExitForwardRightPlaque init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21190
	)
)

(instance efExitForwardRightPlaque of ExitFeature
	(properties
		nextRoom 21181
	)

	(method (init)
		(self
			createPoly: 235 92 230 106 238 107 238 132 230 134 222 141 222 143 261 143 259 140 252 136 252 130 261 110 261 95 235 92
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21160
	)
)

