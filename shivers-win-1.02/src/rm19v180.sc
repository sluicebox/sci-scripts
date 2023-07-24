;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19180)
(include sci.sh)
(use Main)
(use Actor)

(public
	rm19v180 0
)

(instance rm19v180 of ShiversRoom
	(properties
		picture 19180
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (!= [global118 21] 0)
			(vPotView init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19300
	)

	(method (init)
		(self
			createPoly: 64 143 102 109 101 41 110 30 130 27 154 33 160 44 160 95 208 145
		)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 116
		y 67
		view 0
	)

	(method (init)
		(self view: [global118 21] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 11 scaleY: 11 setPri: 10)
	)
)

