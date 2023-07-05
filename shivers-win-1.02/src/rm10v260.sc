;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10260)
(include sci.sh)
(use Main)

(public
	rm10v260 0
)

(instance rm10v260 of ShiversRoom
	(properties
		picture 10260
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10330
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10270
	)

	(method (init)
		(self
			createPoly:
				82
				132
				97
				108
				85
				97
				80
				85
				78
				75
				78
				65
				84
				50
				101
				36
				112
				32
				150
				32
				163
				37
				174
				46
				182
				57
				184
				66
				184
				77
				184
				86
				176
				95
				170
				104
				165
				107
				182
				133
		)
		(super init: &rest)
	)
)

