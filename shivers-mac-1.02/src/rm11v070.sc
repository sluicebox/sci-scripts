;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v070 0
)

(instance rm11v070 of ShiversRoom
	(properties
		picture 11070
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efPlaque init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 8)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11080
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 11440
	)

	(method (init)
		(self
			createPoly: 118 90 116 108 121 109 128 142 141 141 147 110 151 109 151 95 147 88
		)
		(super init: &rest)
	)
)

