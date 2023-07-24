;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31290)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm31v290 0
)

(instance rm31v290 of ShiversRoom
	(properties
		picture 31290
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(if (!= [global118 41] 0)
			(vPotView init:)
		)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 106
		y 121
		view 0
	)

	(method (init)
		(self view: [global118 41] loop: 2)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 10)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31310
	)

	(method (init)
		(self
			createPoly: 181 143 164 113 164 102 152 86 153 54 153 52 111 52 111 94 99 110 95 126 81 142 181 144
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31280
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31280
	)
)

