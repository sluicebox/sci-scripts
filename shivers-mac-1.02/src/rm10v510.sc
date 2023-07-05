;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10510)
(include sci.sh)
(use Main)

(public
	rm10v510 0
)

(instance rm10v510 of ShiversRoom
	(properties
		picture 10510
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10530
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10540
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10520
	)

	(method (init)
		(self
			createPoly:
				78
				134
				91
				115
				72
				97
				69
				67
				87
				41
				107
				28
				151
				28
				178
				47
				190
				71
				189
				90
				180
				102
				165
				116
				176
				132
		)
		(super init: &rest)
	)
)

