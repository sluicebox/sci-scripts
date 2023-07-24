;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21340)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v340 0
)

(instance rm21v340 of ShiversRoom
	(properties
		picture 21340
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 4)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21370
	)

	(method (init)
		(self
			createPoly: 2 2 78 2 78 109 74 110 73 128 66 130 66 140 56 142 1 142 1 6
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21370
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21350
	)

	(method (init)
		(self
			createPoly: 60 138 74 109 88 106 88 0 204 0 204 107 216 109 239 141 59 141
		)
		(super init: &rest)
	)
)

