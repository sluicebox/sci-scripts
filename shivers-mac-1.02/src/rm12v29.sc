;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12290)
(include sci.sh)
(use Main)

(public
	rm12v29 0
)

(instance rm12v29 of ShiversRoom
	(properties
		picture 12290
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12330
	)

	(method (init)
		(self
			createPoly:
				170
				140
				122
				95
				122
				40
				134
				22
				150
				22
				193
				87
				200
				102
				201
				140
		)
		(super init: &rest)
	)
)

