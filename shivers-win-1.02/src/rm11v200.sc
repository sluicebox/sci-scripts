;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v200 0
)

(instance rm11v200 of ShiversRoom
	(properties
		picture 11200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (proc951_11 3 11000)
			(proc951_7 21110)
			(proc951_9 21110)
			(gSounds play: 21110 -1 32 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (> newRoomNumber 1000) (!= newRoomNumber 11300)) ; rm1v00, rm11v300
			(gSounds fade: 21110 0 15 15 1 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11600
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11300
	)

	(method (init)
		(self
			createPoly:
				56
				121
				61
				108
				80
				106
				114
				75
				153
				85
				200
				113
				192
				132
				63
				129
		)
		(super init: &rest)
	)
)

