;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21130)
(include sci.sh)
(use Main)

(public
	rm21v130 0
)

(instance rm21v130 of ShiversRoom
	(properties
		picture 21130
	)

	(method (init)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(efExitForwardRightPlaque init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21140
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 21160
	)

	(method (init)
		(self
			createPoly:
				77
				56
				108
				56
				108
				99
				122
				110
				122
				112
				66
				112
				66
				108
				70
				105
				70
				56
				76
				56
		)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 21170
	)

	(method (init)
		(self
			createPoly:
				164
				105
				164
				76
				188
				9
				202
				5
				235
				90
				204
				86
				196
				97
				196
				116
				165
				106
		)
		(super init: &rest)
	)
)

(instance efExitForwardRightPlaque of ExitFeature
	(properties
		nextRoom 21141
	)

	(method (init)
		(self
			createPoly:
				198
				127
				198
				120
				204
				116
				204
				102
				200
				100
				200
				98
				208
				90
				222
				90
				228
				93
				228
				100
				225
				105
				225
				121
				231
				123
				236
				127
				236
				132
				233
				134
				210
				134
				199
				127
		)
		(super init: &rest)
	)
)

