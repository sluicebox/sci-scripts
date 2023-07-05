;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10290)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm10v290 0
)

(instance rm10v290 of ShiversRoom
	(properties
		picture 10290
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spDoor init:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 39010) ; rm39v010
			(gSounds fadeChain:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10310
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 39010
	)

	(method (init)
		(self createPoly: 91 143 90 36 89 2 193 1 193 142)
		(super init: &rest)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 5
		fixPriority 1
		view 10290
	)

	(method (doVerb)
		(gSounds play: 13910 0 82 0)
		(self setCycle: End createPoly: -1 -1 -1 -1 -1 -1)
		(SetFlag 43)
		(efForward init: 3)
	)
)

