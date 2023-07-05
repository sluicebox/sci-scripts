;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37120)
(include sci.sh)
(use Main)

(public
	rm37v120 0
)

(instance rm37v120 of ShiversRoom
	(properties
		picture 37120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37111
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37123
	)

	(method (init)
		(self
			createPoly:
				150
				140
				160
				122
				144
				91
				134
				91
				133
				51
				140
				47
				193
				45
				204
				67
				198
				90
				167
				90
				168
				112
				176
				122
				214
				122
				230
				142
		)
		(super init: &rest)
	)
)

