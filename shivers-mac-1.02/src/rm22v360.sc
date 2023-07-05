;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22360)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v360 0
)

(instance rm22v360 of ShiversRoom
	(properties
		picture 22360
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(efExitDoor init: 3)
		(if (IsFlag 22)
			(self picture: 22361)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22370
	)

	(method (init)
		(self
			createPoly:
				211
				1
				209
				40
				254
				40
				254
				113
				212
				113
				212
				142
				262
				142
				262
				1
				212
				1
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22180
	)

	(method (init)
		(self
			createPoly: 111 42 99 42 52 85 52 141 183 141 177 84 123 42 111 42
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 22810
	)

	(method (init)
		(self createPoly: 19 98 28 105 41 101 31 93 19 96 19 98)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 22250
	)

	(method (init)
		(self createPoly: 208 44 251 44 251 110 205 110 205 44)
		(super init: &rest)
	)
)

