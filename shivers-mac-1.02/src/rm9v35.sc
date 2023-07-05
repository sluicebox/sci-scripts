;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9350)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v35 0
)

(instance rm9v35 of ShiversRoom
	(properties
		picture 9350
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 42) (== newRoomNumber 9730)) ; rm9v730
			(gSounds fade: 10908 8 15 8 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9360
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9730
	)

	(method (init)
		(self createPoly: 81 143 125 91 125 50 199 50 199 92 237 142)
		(super init: &rest)
	)
)

