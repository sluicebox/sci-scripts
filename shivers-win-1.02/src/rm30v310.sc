;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30310)
(include sci.sh)
(use Main)

(public
	rm30v310 0
)

(instance rm30v310 of ShiversRoom
	(properties
		picture 30310
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
		nextRoom 30320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30320
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30270
	)

	(method (init)
		(self
			createPoly:
				81
				81
				81
				122
				113
				122
				109
				131
				174
				131
				162
				117
				162
				52
				119
				52
				119
				78
				82
				78
		)
		(super init: &rest)
	)
)

