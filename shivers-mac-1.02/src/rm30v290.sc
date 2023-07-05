;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30290)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm30v290 0
)

(instance rm30v290 of ShiversRoom
	(properties
		picture 30290
	)

	(method (init)
		(if (or (== gPrevRoomNum 30280) (== gPrevRoomNum 30300)) ; rm30v280, rm30v300
			(ClearFlag 43)
		)
		(pTrunk init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 43) (or (== newRoomNumber 30280) (== newRoomNumber 30300))) ; rm30v280, rm30v300
			(ClearFlag 43)
			(gSounds play: 13002 0 82 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30280
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30320
	)

	(method (init)
		(self createPoly: 36 141 36 93 60 85 209 85 230 92 230 142 36 142)
		(super init: &rest)
	)
)

(instance pTrunk of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 30290
	)

	(method (init)
		(if (IsFlag 43)
			(self cel: (self lastCel:))
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 43)
			(gSounds play: 13002 0 82 0)
			(self setCycle: Beg)
			(ClearFlag 43)
		else
			(gSounds play: 13001 0 82 0)
			(self setCycle: End)
			(self createPoly: 0 0 0 0 0 0)
			(efExitForward init: 3)
			(SetFlag 43)
		)
	)
)

