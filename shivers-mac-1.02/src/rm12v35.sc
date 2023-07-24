;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12350)
(include sci.sh)
(use Main)

(public
	rm12v35 0
)

(instance rm12v35 of ShiversRoom
	(properties
		picture 12350
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForward init: 9)
		(efOrgan init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12360
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 12390
	)

	(method (init)
		(self createPoly: 58 140 53 64 169 62 192 128 174 137 170 146)
		(super init: &rest)
	)
)

(instance efOrgan of ExitFeature
	(properties
		nextRoom 12370
	)

	(method (init)
		(self
			createPoly: 172 144 175 137 193 129 207 115 216 104 209 96 213 92 227 98 228 92 239 90 235 63 244 53 244 91 262 92 262 142
		)
		(super init: &rest)
	)
)

