;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13009)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v009 0
)

(instance rm13v009 of ShiversRoom
	(properties
		picture 13080
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 6)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13008
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13008
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13005
	)

	(method (init)
		(self createPoly: 59 143 76 129 76 7 224 7 224 142)
		(super init: &rest)
	)
)

