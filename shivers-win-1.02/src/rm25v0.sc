;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25000)
(include sci.sh)
(use Main)

(public
	rm25v0 0
)

(instance rm25v0 of ShiversRoom
	(properties
		picture 25000
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (>= newRoomNumber 26000)
			(gSounds fade: 22501 0 5 16 1 0)
			(gSounds fade: 22506 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 25060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 25010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26290
	)

	(method (init)
		(self
			createPoly: 85 144 85 8 213 8 213 132 212 134 212 141 213 142 213 143
		)
		(super init: &rest)
	)
)

