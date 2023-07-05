;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29210)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm29v210 0
)

(instance rm29v210 of ShiversRoom
	(properties
		picture 29210
	)

	(method (init)
		(cond
			((IsFlag 61)
				(self picture: 29211)
				(if (IsFlag 68)
					(vSpaceshipFore init: 29211)
					(vSpaceshipBack init: 29211)
					(if (!= [global118 37] 0)
						(vPotView init:)
					)
				)
			)
			((IsFlag 68)
				(self picture: 29212)
				(vSpaceshipFore init: 29212)
				(vSpaceshipBack init: 29212)
				(if (!= [global118 37] 0)
					(vPotView init:)
				)
			)
			(else
				(self picture: 29210)
			)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance vSpaceshipFore of View
	(properties
		priority 40
		fixPriority 1
		view 0
	)

	(method (init param1)
		(= view param1)
		(if (== view 29211)
			(= y 143)
		)
		(super init: &rest)
	)
)

(instance vSpaceshipBack of View
	(properties
		priority 15
		fixPriority 1
		view 0
		loop 1
	)

	(method (init param1)
		(= view param1)
		(if (== view 29211)
			(= y 143)
		)
		(super init: &rest)
	)
)

(instance vPotView of View
	(properties
		x 75
		y 84
		view 0
	)

	(method (init)
		(self view: [global118 37] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 20 scaleY: 20 setPri: 20)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29170
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 29190
	)

	(method (init)
		(self createPoly: 191 118 191 42 88 42 88 118 191 118)
		(super init: &rest)
	)
)

