;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18150)
(include sci.sh)
(use Main)
(use n951)

(public
	rm18v15 0
)

(instance rm18v15 of ShiversRoom
	(properties
		picture 18150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 43)
			(ClearFlag 43)
			(gSounds play: 11806 0 82 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 9)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18240
	)

	(method (init)
		(self createPoly: 0 0 32 0 32 104 51 97 51 142 1 142 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18130
	)

	(method (init)
		(self createPoly: 51 142 106 93 106 52 159 52 159 96 211 142)
		(super init: &rest)
	)
)

