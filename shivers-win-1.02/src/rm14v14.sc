;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14140)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm14v14 0
)

(instance rm14v14 of ShiversRoom
	(properties
		picture 14140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitDoor init: 9)
		(if (proc951_11 3 14000)
			(proc951_9 21402)
			(gSounds play: 21402 -1 66 0)
		)
		(if (!= [global118 17] 0)
			(vPotView init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 3 14000) (!= newRoomNumber 14100)) ; rm14v10
			(gSounds fade: 21402 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vPotView of View
	(properties
		x 73
		y 76
		view 0
	)

	(method (init)
		(self view: [global118 17] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 11 scaleY: 11 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14130
	)

	(method (init)
		(self
			createPoly: 263 0 243 0 243 52 263 52 263 118 243 118 243 143 263 143
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14100
	)

	(method (init)
		(self createPoly: 198 114 144 117 125 100 132 73 216 73)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 14090
	)

	(method (init)
		(self createPoly: 198 115 215 73 243 52 264 52 263 118 243 118)
		(super init: &rest)
	)
)

