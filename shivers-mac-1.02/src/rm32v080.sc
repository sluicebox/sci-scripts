;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32080)
(include sci.sh)
(use Main)

(public
	rm32v080 0
)

(instance rm32v080 of ShiversRoom
	(properties
		picture 32080
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32100
	)

	(method (init)
		(self
			createPoly:
				170
				113
				186
				98
				188
				73
				185
				48
				176
				40
				154
				26
				134
				21
				104
				26
				81
				40
				72
				57
				68
				72
				69
				85
				73
				94
				81
				109
				87
				115
				96
				120
				110
				123
				169
				123
		)
		(super init: &rest)
	)
)

