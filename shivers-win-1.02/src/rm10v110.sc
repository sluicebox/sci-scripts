;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10110)
(include sci.sh)
(use Main)

(public
	rm10v110 0
)

(instance rm10v110 of ShiversRoom
	(properties
		picture 10110
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efRightTunnel init: 1)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10550
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10550
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10120
	)

	(method (init)
		(self
			createPoly: 197 132 211 117 217 106 221 77 221 65 205 37 191 27 169 16 136 13 105 14 93 17 80 26 66 43 61 57 57 80 58 98 65 112 77 127 85 132
		)
		(super init: &rest)
	)
)

(instance efRightTunnel of ExitFeature
	(properties
		nextRoom 10530
	)

	(method (init)
		(self
			createPoly: 170 16 184 0 198 0 214 7 231 20 243 36 243 143 205 143 198 133 211 117 218 103 221 80 222 65 206 38 190 25
		)
		(super init: &rest)
	)
)

