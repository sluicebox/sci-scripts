;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11080)
(include sci.sh)
(use Main)

(public
	rm11v080 0
)

(instance rm11v080 of ShiversRoom
	(properties
		picture 11080
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11090
	)

	(method (init)
		(self createPoly: 243 0 243 91 262 95 263 112 234 142 264 142 264 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11030
	)

	(method (init)
		(self
			createPoly: 30 143 30 112 119 112 127 106 132 87 123 55 166 55 149 95 177 100 200 97 215 82 218 66 226 59 243 59 243 90 217 98 202 98 188 102 183 104 171 104 170 126 180 143
		)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 11420
	)

	(method (init)
		(self
			createPoly: 243 89 212 103 224 109 246 98 244 111 227 142 236 142 262 108 261 93
		)
		(super init: &rest)
	)
)

