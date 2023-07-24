;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13523)
(include sci.sh)
(use Main)

(public
	rm13v523 0
)

(instance rm13v523 of ShiversRoom
	(properties
		picture 13900
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (< 1000 newRoomNumber 13000) ; rm1v00, rm13v000
			(gSounds fade: 21303 0 10 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13522
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13522
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12230
	)

	(method (init)
		(self
			createPoly: 92 130 92 37 101 19 126 9 142 8 160 10 180 24 185 40 185 130
		)
		(super init: &rest)
	)
)

