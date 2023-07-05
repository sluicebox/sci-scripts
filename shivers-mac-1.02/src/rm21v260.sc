;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21260)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v260 0
)

(instance rm21v260 of ShiversRoom
	(properties
		picture 21260
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21250
	)

	(method (init)
		(self
			createPoly:
				163
				123
				100
				123
				97
				99
				88
				16
				133
				15
				142
				27
				190
				29
				167
				90
				164
				124
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21290
	)
)

