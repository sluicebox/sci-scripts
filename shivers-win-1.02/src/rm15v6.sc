;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15060)
(include sci.sh)
(use Main)

(public
	rm15v6 0
)

(instance rm15v6 of ShiversRoom
	(properties
		picture 15060
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
		nextRoom 15050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15080
	)

	(method (init)
		(self
			createPoly:
				69
				103
				69
				81
				64
				53
				69
				42
				79
				30
				82
				20
				89
				19
				101
				20
				120
				18
				138
				17
				158
				21
				180
				29
				183
				42
				177
				57
				173
				79
				178
				99
				184
				122
				175
				137
				171
				142
				101
				142
				80
				133
				66
				111
		)
		(super init: &rest)
	)
)

