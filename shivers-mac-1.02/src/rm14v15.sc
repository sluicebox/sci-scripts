;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14150)
(include sci.sh)
(use Main)

(public
	rm14v15 0
)

(instance rm14v15 of ShiversRoom
	(properties
		picture 14150
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
		nextRoom 14160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14200
	)

	(method (init)
		(self
			createPoly: 146 117 156 110 165 108 150 68 150 61 184 61 195 76 177 76 179 107 197 116 193 124 162 127
		)
		(super init: &rest)
	)
)

