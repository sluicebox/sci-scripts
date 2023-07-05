;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32140)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v140 0
)

(instance rm32v140 of ShiversRoom
	(properties
		picture 32140
	)

	(method (init)
		(if (IsFlag 73)
			(= picture 32141)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32110
	)

	(method (init)
		(self
			createPoly:
				189
				130
				190
				121
				181
				115
				189
				103
				195
				93
				195
				74
				195
				64
				190
				48
				180
				40
				143
				28
				128
				31
				105
				42
				92
				66
				92
				91
				104
				103
				107
				111
				101
				120
				101
				128
				187
				127
		)
		(super init: &rest)
	)
)

