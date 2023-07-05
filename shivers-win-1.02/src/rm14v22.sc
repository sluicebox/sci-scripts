;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14220)
(include sci.sh)
(use Main)

(public
	rm14v22 0
)

(instance rm14v22 of ShiversRoom
	(properties
		picture 14220
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (> newRoomNumber 15000)
			(gSounds fade: 21401 0 5 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15030
	)

	(method (init)
		(self
			createPoly:
				111
				116
				119
				100
				107
				86
				110
				40
				107
				24
				216
				24
				218
				30
				208
				51
				217
				66
				211
				110
		)
		(super init: &rest)
	)
)

