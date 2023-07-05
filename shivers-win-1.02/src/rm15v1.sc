;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15010)
(include sci.sh)
(use Main)

(public
	rm15v1 0
)

(instance rm15v1 of ShiversRoom
	(properties
		picture 15010
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (<= 14000 newRoomNumber 15000)
			(gSounds fade: 21303 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14210
	)

	(method (init)
		(self createPoly: 37 142 37 59 63 55 86 55 126 62 145 56 156 56 156 142)
		(super init: &rest)
	)
)

