;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1460)
(include sci.sh)
(use Main)

(public
	rm1v460 0
)

(instance rm1v460 of ShiversRoom
	(properties
		picture 1460
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
		nextRoom 1461
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1461
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1470
	)

	(method (init)
		(self
			createPoly:
				68
				142
				144
				91
				145
				44
				225
				43
				226
				79
				238
				91
				238
				95
				263
				115
				263
				143
		)
		(super init: &rest)
	)
)

