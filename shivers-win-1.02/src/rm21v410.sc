;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21410)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v410 0
)

(instance rm21v410 of ShiversRoom
	(properties
		picture 21410
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 4 21000) (== newRoomNumber 21180)) ; rm21v180
			(gSounds fade: 22102 0 5 16 1 0)
			(proc951_9 22101)
			(gSounds play: 22101 -1 0 0)
			(gSounds fade: 22101 98 5 16 0 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21430
	)

	(method (init)
		(self createPoly: 0 142 56 142 56 2 0 2 0 141)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21420
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21180
	)

	(method (init)
		(self createPoly: 93 143 90 120 125 31 155 31 192 120 192 142 93 144)
		(super init: &rest)
	)
)

