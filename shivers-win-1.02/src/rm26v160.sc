;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26160)
(include sci.sh)
(use Main)

(public
	rm26v160 0
)

(instance rm26v160 of ShiversRoom
	(properties
		picture 26160
	)

	(method (init)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 26110) ; rm26v110
			(gSounds fade: 22601 0 4 15 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26110
	)

	(method (init)
		(self createPoly: 0 0 242 0 242 144 0 144 0 0)
		(super init: &rest)
	)
)

