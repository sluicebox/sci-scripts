;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1402)
(include sci.sh)
(use Main)

(public
	rm1v402 0
)

(instance rm1v402 of ShiversRoom
	(properties
		picture 1402
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1403
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1391
	)

	(method (init)
		(self
			createPoly:
				9
				142
				17
				131
				62
				112
				73
				73
				162
				72
				176
				80
				175
				104
				227
				122
				256
				143
		)
		(super init: &rest)
	)
)

