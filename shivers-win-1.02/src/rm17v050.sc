;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17050)
(include sci.sh)
(use Main)
(use n951)
(use Osc)

(public
	rm17v050 0
)

(instance rm17v050 of ShiversRoom
	(properties
		picture 17050
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitDoor init: 9)
		(if (not (Random 0 3))
			(spShadow init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 9 17000) (== newRoomNumber 17020)) ; rm17v020
			(proc951_7 21703)
			(gSounds play: 21703 -1 50 0)
			(gSounds fadeChain:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17060
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 17020
	)

	(method (init)
		(self createPoly: 107 130 107 29 173 29 174 131)
		(super init: &rest)
	)
)

(instance spShadow of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 17051
		cycleSpeed 15
	)

	(method (init)
		(self setCycle: Osc 1)
		(super init: &rest)
	)
)

