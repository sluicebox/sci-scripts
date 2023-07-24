;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29220)
(include sci.sh)
(use Main)

(public
	rm29v220 0
)

(instance rm29v220 of ShiversRoom
	(properties
		picture 29220
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29230
	)

	(method (init)
		(self
			createPoly: 125 125 127 68 134 56 144 50 158 56 164 73 167 132 125 125
		)
		(super init: &rest)
	)
)

