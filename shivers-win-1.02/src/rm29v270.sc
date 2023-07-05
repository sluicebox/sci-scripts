;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29270)
(include sci.sh)
(use Main)

(public
	rm29v270 0
)

(instance rm29v270 of ShiversRoom
	(properties
		picture 29270
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29040
	)

	(method (init)
		(self
			createPoly:
				135
				96
				116
				90
				103
				75
				100
				63
				107
				48
				122
				32
				134
				29
				159
				36
				172
				49
				174
				64
				162
				86
				138
				96
				135
				96
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 29800
	)

	(method (init)
		(self createPoly: 122 137 124 107 129 97 152 97 159 136 141 141 122 137)
		(super init: &rest)
	)
)

