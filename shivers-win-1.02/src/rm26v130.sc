;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26130)
(include sci.sh)
(use Main)

(public
	rm26v130 0
)

(instance rm26v130 of ShiversRoom
	(properties
		picture 26130
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 26180) ; rm26v180
			(gSounds fade: 22602 0 4 15 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26180
	)

	(method (init)
		(self createPoly: 21 0 263 0 263 143 21 143)
		(super init: &rest)
	)
)

