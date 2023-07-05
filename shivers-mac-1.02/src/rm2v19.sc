;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2190)
(include sci.sh)
(use Main)

(public
	rm2v19 0
)

(instance rm2v19 of ShiversRoom
	(properties
		picture 2190
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2210
	)

	(method (init)
		(self
			createPoly:
				20
				142
				45
				105
				61
				105
				67
				95
				77
				95
				80
				89
				100
				82
				114
				43
				121
				30
				133
				23
				146
				30
				157
				43
				171
				82
				192
				90
				192
				95
				207
				95
				211
				106
				235
				106
				263
				142
		)
		(super init: &rest)
	)
)

