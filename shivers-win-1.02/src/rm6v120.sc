;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6120)
(include sci.sh)
(use Main)

(public
	rm6v120 0
)

(instance rm6v120 of ShiversRoom
	(properties
		picture 6120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efPaper init: 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 30
		nextRoom 6130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6070
	)

	(method (init)
		(self
			createPoly:
				70
				118
				69
				55
				84
				56
				84
				67
				191
				68
				221
				68
				223
				77
				221
				80
				221
				88
				214
				97
				211
				132
		)
		(super init: &rest)
	)
)

(instance efPaper of ExitFeature
	(properties
		nextRoom 6111
	)

	(method (init)
		(self createPoly: 221 124 214 126 208 132 217 142 228 142 229 137)
		(super init: &rest)
	)
)

