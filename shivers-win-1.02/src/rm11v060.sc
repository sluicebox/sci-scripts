;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11060)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v060 0
)

(instance rm11v060 of ShiversRoom
	(properties
		picture 11060
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efUnicorn init: 9)
		(efPlaque init: 3)
		(if (proc951_11 9 11000)
			(proc951_7 21111)
			(proc951_9 21111)
			(gSounds play: 21111 -1 32 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (<= 11070 newRoomNumber 11090) ; rm11v070, rm11v090
			(gSounds fade: 21111 0 15 15 1 0)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11070
	)
)

(instance efUnicorn of ExitFeature
	(properties
		nextRoom 11340
	)

	(method (init)
		(self
			createPoly: 156 119 146 111 146 72 154 69 161 44 173 44 174 50 173 52 175 60 171 70 175 75 173 119 166 120
		)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 11430
	)

	(method (init)
		(self
			createPoly: 88 84 85 95 89 96 93 124 77 133 84 137 113 138 122 132 108 124 104 124 111 83
		)
		(super init: &rest)
	)
)

