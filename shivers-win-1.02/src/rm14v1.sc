;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14010)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm14v1 0
)

(instance rm14v1 of ShiversRoom
	(properties
		picture 14010
	)

	(method (init)
		(if (not (IsFlag 76))
			(SetFlag 76)
			(proc951_15 6750)
		)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(if (!= [global118 17] 0)
			(vPotView init:)
		)
		(super init: &rest)
		(if (proc951_11 3 14000)
			(proc951_9 21110)
			(gSounds play: 21110 -1 32 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 3 14000) (!= newRoomNumber 14040)) ; rm14v4
			(gSounds fade: 21110 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vPotView of View
	(properties
		x 190
		y 73
		view 0
	)

	(method (init)
		(self view: [global118 17] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 15 scaleY: 15 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14040
	)

	(method (init)
		(self
			createPoly: 168 143 183 131 157 119 156 109 119 103 153 96 153 78 157 72 177 69 197 75 197 96 212 97 242 106 213 110 192 111 220 128 219 143
		)
		(super init: &rest)
	)
)

