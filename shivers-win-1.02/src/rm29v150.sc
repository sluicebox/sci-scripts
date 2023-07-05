;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29150)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v150 0
)

(instance rm29v150 of ShiversRoom
	(properties
		picture 29150
	)

	(method (init)
		(if (IsFlag 68)
			(self picture: 29151)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29130
	)

	(method (init)
		(self
			createPoly:
				81
				143
				81
				111
				48
				105
				50
				91
				89
				66
				109
				59
				190
				47
				212
				64
				212
				143
				81
				143
		)
		(super init: &rest)
	)
)

