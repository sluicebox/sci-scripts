;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v11 0
)

(instance rm9v11 of ShiversRoom
	(properties
		picture 9110
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 3)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9140
	)

	(method (init)
		(self
			createPoly: 61 142 72 95 72 62 178 62 178 98 174 110 181 113 190 141
		)
		(super init: &rest)
	)
)

