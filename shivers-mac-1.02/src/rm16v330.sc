;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16330)
(include sci.sh)
(use Main)

(public
	rm16v330 0
)

(instance rm16v330 of ShiversRoom
	(properties
		picture 16330
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16740
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16630
	)

	(method (init)
		(self
			createPoly: 88 144 107 93 136 57 137 10 243 10 243 28 243 58 204 59 206 48 200 46 179 46 173 49 171 106 196 143
		)
		(super init: &rest)
	)
)

