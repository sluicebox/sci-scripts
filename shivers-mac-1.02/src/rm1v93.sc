;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1093)
(include sci.sh)
(use Main)

(public
	rm1v93 0
)

(instance rm1v93 of ShiversRoom
	(properties
		picture 1093
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
		nextRoom 1094
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1094
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1110
	)

	(method (init)
		(self
			createPoly:
				74
				117
				76
				99
				87
				77
				106
				55
				127
				44
				143
				42
				160
				45
				172
				52
				187
				67
				198
				88
				201
				108
				177
				112
				196
				141
				123
				141
				129
				118
				75
				118
		)
		(super init: &rest)
	)
)

