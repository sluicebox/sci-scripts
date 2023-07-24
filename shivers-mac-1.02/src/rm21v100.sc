;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21100)
(include sci.sh)
(use Main)

(public
	rm21v100 0
)

(instance rm21v100 of ShiversRoom
	(properties
		picture 21100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21450
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21110
	)

	(method (init)
		(self
			createPoly: 186 142 156 132 131 132 123 122 116 120 116 65 141 57 168 57 178 33 200 24 213 24 232 57 212 100 214 116 231 124 232 130 189 142
		)
		(super init: &rest)
	)
)

