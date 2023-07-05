;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25010)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm25v1 0
)

(instance rm25v1 of ShiversRoom
	(properties
		picture 25010
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (IsFlag 25)
			(vFabric x: -25 init:)
		else
			(vFabric init:)
		)
		(if (!= [global118 35] 0)
			(vPotView init:)
		)
		(super init: &rest)
		(if (or (proc951_11 4 25000) (proc951_11 0 25000))
			(proc951_9 22506)
			(gSounds play: 22506 -1 0 0)
			(gSounds fade: 22506 50 5 16 0 0)
		else
			(proc951_9 22501)
			(gSounds play: 22501 -1 0 0)
			(gSounds fade: 22501 74 5 16 0 0)
		)
	)
)

(instance vFabric of View
	(properties
		priority 20
		fixPriority 1
		view 25010
	)
)

(instance vPotView of View
	(properties
		x 145
		y 103
		view 0
	)

	(method (init)
		(self view: [global118 35] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 25 scaleY: 25 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 25000
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 25060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 25030
	)

	(method (init)
		(self createPoly: 95 70 83 69 83 136 186 138 189 70 158 52 111 50)
		(super init: &rest)
	)
)

