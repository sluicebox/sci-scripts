;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8430)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm8v430 0
)

(local
	local0
)

(instance rm8v430 of ShiversRoom
	(properties
		picture 8430
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitDown init: 5)
		(efExitRight init: 1)
		(book init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8440
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8480
	)
)

(instance efExitDown of ExitFeature
	(properties
		nsLeft 21
		nsTop 120
		nsRight 243
		nsBottom 142
		nextRoom 8420
	)
)

(instance book of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 8430
	)

	(method (init)
		(if (IsFlag 40)
			(= cel 3)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 147)
		(if (not (IsFlag 40))
			(gCurRoom setScript: moveBookScript)
		)
	)
)

(instance moveBookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10805 0 32 0)
				(book cycleSpeed: 10 setCycle: End self)
				(SetFlag 40)
				(= local0 8450)
			)
			(1
				(book hide:)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 8490) ; rm8v490
			)
		)
	)
)

