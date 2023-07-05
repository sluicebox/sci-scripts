;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37230)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm37v230 0
)

(local
	local0
)

(instance rm37v230 of ShiversRoom
	(properties
		picture 37230
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(hsDoor init:)
	)

	(method (newRoom newRoomNumber)
		(if local0
			(SetFlag 43)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37240
	)
)

(instance pDoor of Prop
	(properties
		view 37230
		cycleSpeed 18
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 57 143 57 7 200 7 200 144)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 127)
		(gCurRoom setScript: sDoorOpens)
	)
)

(instance sDoorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pDoor init: setPri: 25 1)
				(proc951_7 10613)
				(= cycles 1)
			)
			(1
				(pDoor setCycle: End)
				(gSounds play: 13702 0 82 self)
			)
			(2
				(gGame handsOn:)
				(= local0 1)
				(hsDoor dispose:)
				(self dispose:)
			)
		)
	)
)

