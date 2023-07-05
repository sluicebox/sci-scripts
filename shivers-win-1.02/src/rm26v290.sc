;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26290)
(include sci.sh)
(use Main)
(use n951)

(public
	rm26v290 0
)

(instance rm26v290 of ShiversRoom
	(properties
		picture 26290
	)

	(method (init)
		(if (== gPrevRoomNum 25000) ; rm25v0
			(proc951_7 22601)
			(proc951_9 22601)
			(gSounds play: 22601 -1 0 0)
			(gSounds fade: 22601 106 4 15 0 0)
			(gSounds play: 12501 0 82 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 4)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26300
	)
)

