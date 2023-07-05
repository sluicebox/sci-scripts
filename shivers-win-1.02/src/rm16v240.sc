;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16240)
(include sci.sh)
(use Main)

(public
	rm16v240 0
)

(instance rm16v240 of ShiversRoom
	(properties
		picture 16240
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16700
	)
)

(instance efExitRight of ExitFeature ; UNUSED
	(properties
		nextRoom 16230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16220
	)

	(method (init)
		(self
			createPoly:
				35
				142
				92
				117
				117
				85
				117
				45
				153
				45
				153
				83
				174
				102
				174
				52
				185
				48
				185
				112
				224
				145
		)
		(super init: &rest)
	)
)

