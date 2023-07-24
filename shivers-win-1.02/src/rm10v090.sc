;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10090)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v090 0
)

(instance rm10v090 of ShiversRoom
	(properties
		picture 10090
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(if (and (!= newRoomNumber 10030) (!= newRoomNumber 10100) (IsFlag 6)) ; rm10v030, rm10v100
			(ClearFlag 6)
			(gSounds play: 10405 0 50 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10110
	)

	(method (init)
		(self
			createPoly: 68 143 88 118 70 112 57 81 53 57 59 41 73 31 110 21 152 20 172 25 175 32 184 41 196 67 191 95 183 103 173 112 167 116 182 143
		)
		(super init: &rest)
	)
)

