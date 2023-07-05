;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29090)
(include sci.sh)
(use Main)

(public
	rm29v090 0
)

(instance rm29v090 of ShiversRoom
	(properties
		picture 29090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitPlaque init: 3)
		(efExitForwardRight init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 29040
	)

	(method (init)
		(self
			createPoly:
				80
				61
				93
				40
				126
				27
				154
				41
				164
				63
				150
				88
				127
				100
				98
				89
				80
				61
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 29800
	)

	(method (init)
		(self createPoly: 142 136 150 96 167 94 178 106 180 135 164 140)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 29050
	)

	(method (init)
		(self createPoly: 243 30 243 131 187 131 187 28 242 28)
		(super init: &rest)
	)
)

