;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14100)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm14v10 0
)

(instance rm14v10 of ShiversRoom
	(properties
		picture 14100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (proc951_11 3 14000)
			(proc951_9 21110)
			(gSounds play: 21110 -1 32 0)
		)
		(if (!= [global118 17] 0)
			(vPotView init:)
		)
		(super init: &rest)
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
		x 83
		y 79
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
		nextRoom 14110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14040
	)

	(method (init)
		(self
			createPoly: 162 143 154 139 86 128 75 122 65 111 65 84 88 82 95 104 135 109 123 116 110 118 177 126 210 143
		)
		(super init: &rest)
	)
)

