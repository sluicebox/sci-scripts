;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3340)
(include sci.sh)
(use Main)

(public
	rm3v340 0
)

(instance rm3v340 of ShiversRoom
	(properties
		picture 3340
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3360
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 4010
	)

	(method (init)
		(self
			createPoly: 215 126 200 70 199 60 205 42 210 25 220 7 227 1 243 1 243 127
		)
		(super init: &rest)
	)
)

