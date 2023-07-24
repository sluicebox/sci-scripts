;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19260)
(include sci.sh)
(use Main)

(public
	rm19v260 0
)

(instance rm19v260 of ShiversRoom
	(properties
		picture 19260
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 19060) ; rm19v060
			(gSounds fade: 21910 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 19060
	)

	(method (init)
		(self
			createPoly: 82 144 127 96 128 29 142 14 174 8 219 16 211 129 231 131 241 147
		)
		(super init: &rest)
	)
)

