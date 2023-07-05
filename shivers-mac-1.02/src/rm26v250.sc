;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26250)
(include sci.sh)
(use Main)
(use n951)

(public
	rm26v250 0
)

(instance rm26v250 of ShiversRoom
	(properties
		picture 26250
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(proc951_1 5)
		(if (== newRoomNumber 24000) ; rm24v000
			(gSounds fade: 22601 0 4 15 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nsLeft 100
		nsTop 18
		nsRight 175
		nsBottom 143
		nextRoom 24000
	)
)

