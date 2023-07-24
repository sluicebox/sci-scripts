;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25030)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm25v3 0
)

(instance rm25v3 of ShiversRoom
	(properties
		picture 25030
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
		(if (proc951_11 4 25000)
			(proc951_9 22512)
			(gSounds play: 22512 -1 0 0)
			(gSounds fade: 22512 50 5 16 0 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 4 25000) (!= newRoomNumber 25050)) ; rm25v5
			(gSounds fade: 22512 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vFabric of View
	(properties
		priority 20
		fixPriority 1
		view 25030
	)
)

(instance vPotView of View
	(properties
		x 145
		y 110
		view 0
	)

	(method (init)
		(self view: [global118 35] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 34 scaleY: 34 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 25020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 25020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 25050
	)

	(method (init)
		(self
			createPoly: 189 143 56 143 65 120 56 120 56 107 85 67 157 65 187 107 194 112 193 119
		)
		(super init: &rest)
	)
)

