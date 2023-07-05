;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25040)
(include sci.sh)
(use Main)

(public
	rm25v4 0
)

(instance rm25v4 of ShiversRoom
	(properties
		picture 25040
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 25050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 25050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 25020
	)

	(method (init)
		(self
			createPoly:
				78
				143
				94
				129
				108
				129
				108
				36
				144
				36
				144
				127
				150
				136
				157
				136
				160
				142
		)
		(super init: &rest)
	)
)

