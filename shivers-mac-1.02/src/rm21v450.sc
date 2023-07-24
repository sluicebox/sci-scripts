;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21450)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v450 0
)

(instance rm21v450 of ShiversRoom
	(properties
		picture 21450
	)

	(method (init)
		(efExitForward init: 3)
		(efExitForwardRight init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (proc951_11 2 21000)
			(proc951_9 20608)
			(gSounds play: 20608 -1 32 0)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 4)
		(if (and (proc951_11 2 21000) (!= newRoomNumber 21050)) ; rm21v050
			(gSounds fade: 20608 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21120
	)

	(method (init)
		(self
			createPoly: 265 141 262 0 223 0 223 76 264 85 264 118 259 122 222 116 222 142 266 142
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21440
	)

	(method (init)
		(self createPoly: 68 144 114 99 114 28 191 26 191 144 68 144)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 21050
	)

	(method (init)
		(self createPoly: 193 84 193 109 258 120 258 86 211 83 193 83)
		(super init: &rest)
	)
)

