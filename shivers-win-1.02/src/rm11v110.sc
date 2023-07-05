;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v110 0
)

(instance rm11v110 of ShiversRoom
	(properties
		picture 11110
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efInhaler init: 0)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 11107 0 64 0)
			(ClearFlag 43)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11120
	)

	(method (init)
		(self createPoly: 211 143 198 85 197 0 263 0 263 143)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11170
	)

	(method (init)
		(self
			createPoly:
				82
				144
				89
				133
				135
				133
				135
				115
				105
				117
				98
				132
				90
				132
				92
				127
				91
				77
				70
				77
				87
				39
				155
				39
				156
				115
				167
				145
		)
		(super init: &rest)
	)
)

(instance efInhaler of ExitFeature
	(properties
		nextRoom 11510
	)

	(method (init)
		(self createPoly: 107 116 134 115 135 133 97 133)
		(super init: &rest)
	)
)

