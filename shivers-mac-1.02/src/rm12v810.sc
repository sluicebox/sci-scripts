;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12810)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm12v810 0
)

(local
	local0
)

(instance rm12v810 of ShiversRoom
	(properties
		picture 12810
	)

	(method (init)
		(= local0 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(hsDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (>= newRoomNumber 12000)
			(if local0
				(gSounds stop: 21902)
				(gSounds play: 11107 0 64 0)
			)
		else
			(gSounds stop: 21210)
			(gSounds interruptChain:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 44 143 44 0 214 0 214 143)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_7 11106)
		(gCurRoom setScript: sOpenDoor)
	)
)

(instance pDoor of Prop
	(properties
		view 12810
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hsDoor dispose:)
				(pDoor init: setPri: 25 1 cycleSpeed: 15 setCycle: End)
				(gSounds play: 11106 0 64 self)
			)
			(1
				(efExitForward init: 3)
				(= local0 1)
				(gGame handsOn:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11100
	)

	(method (init)
		(self createPoly: 44 143 44 0 214 0 214 143)
		(super init: &rest)
	)
)

