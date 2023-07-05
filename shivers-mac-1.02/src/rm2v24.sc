;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2240)
(include sci.sh)
(use Main)

(public
	rm2v24 0
)

(instance rm2v24 of ShiversRoom
	(properties
		picture 2240
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
		nextRoom 2250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2220
	)

	(method (init)
		(self
			createPoly:
				34
				142
				33
				122
				56
				114
				57
				93
				100
				92
				109
				53
				121
				44
				140
				44
				150
				51
				150
				64
				156
				91
				195
				93
				195
				114
				214
				123
				214
				142
		)
		(super init: &rest)
	)
)

