;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18130)
(include sci.sh)
(use Main)

(public
	rm18v13 0
)

(instance rm18v13 of ShiversRoom
	(properties
		picture 18130
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
		nextRoom 18140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18140
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18110
	)

	(method (init)
		(self
			createPoly:
				49
				142
				77
				119
				105
				117
				107
				80
				130
				51
				153
				80
				154
				117
				195
				117
				195
				126
				211
				142
		)
		(super init: &rest)
	)
)

