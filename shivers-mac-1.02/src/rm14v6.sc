;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14060)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm14v6 0
)

(instance rm14v6 of ShiversRoom
	(properties
		picture 14060
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (!= [global118 17] 0)
			(vPotView init:)
		)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 185
		y 39
		view 0
	)

	(method (init)
		(self view: [global118 17] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 18 scaleY: 18 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14080
	)

	(method (init)
		(self
			createPoly: 96 142 105 124 132 91 122 81 123 46 128 39 164 33 195 40 198 51 196 85 187 85 162 117 162 142
		)
		(super init: &rest)
	)
)

