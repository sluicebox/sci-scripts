;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10060)
(include sci.sh)
(use Main)

(public
	rm10v060 0
)

(instance rm10v060 of ShiversRoom
	(properties
		picture 10060
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitUp init: 4)
		(efExitRight init: 1)
		(efLipstick init: 0)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10040
	)

	(method (init)
		(self createPoly: 55 143 129 83 132 40 0 40 0 143 55 143)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 10030
	)

	(method (init)
		(self createPoly: 0 0 0 40 262 40 262 0 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10090
	)

	(method (init)
		(self createPoly: 240 40 262 40 262 143 240 143 240 40)
		(super init: &rest)
	)
)

(instance efLipstick of ExitFeature
	(properties
		nextRoom 10062
	)

	(method (init)
		(self createPoly: 110 136 131 114 173 123 160 143 137 143)
		(super init: &rest)
	)
)

