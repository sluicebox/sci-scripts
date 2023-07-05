;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24270)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v270 0
)

(instance rm24v270 of ShiversRoom
	(properties
		picture 24270
	)

	(method (init)
		(if (IsFlag 67)
			(self picture: 24271)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 24330) ; rm24v330
			(gSounds fade: 22402 0 6 30 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 24330
	)

	(method (init)
		(self createPoly: 91 37 91 142 158 142 158 37 91 37)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24300
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24310
	)
)

