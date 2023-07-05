;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21120)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm21v120 0
)

(instance rm21v120 of ShiversRoom
	(properties
		picture 21120
	)

	(method (init)
		(if (IsFlag 83)
			(= picture 21121)
		)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (and (!= [global118 25] 0) (IsFlag 83))
			(vPotView init:)
			(vMask init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 2 21000) (== newRoomNumber 21150)) ; rm21v150
			(proc951_9 22101)
			(gSounds play: 22101 -1 0 0)
			(gSounds fade: 22101 98 5 16 0 0)
			(gSounds fade: 22102 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vMask of View
	(properties
		priority 30
		fixPriority 1
		view 21121
	)
)

(instance vPotView of View
	(properties
		x 94
		y 121
		view 0
	)

	(method (init)
		(self view: [global118 25] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 20 scaleY: 20 setPri: 25)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21450
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21090
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 21070
	)

	(method (init)
		(self createPoly: 41 105 41 124 69 135 108 125 108 95 41 95 41 104)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 21150
	)

	(method (init)
		(self createPoly: 209 115 209 69 179 42 228 42 257 68 257 110 211 115)
		(super init: &rest)
	)
)

