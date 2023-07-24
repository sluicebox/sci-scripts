;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20150)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm20v150 0
)

(local
	local0
)

(instance rm20v150 of ShiversRoom
	(properties
		picture 20150
	)

	(method (init)
		(ClearFlag 43)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(spPlant init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 27024) ; rm27v024
			(gSounds fade: 22001 0 4 10 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27024
	)

	(method (init)
		(self createPoly: 73 51 173 51 171 125 171 126 77 126 73 52)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20160
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20160
	)
)

(instance spPlant of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 20150
	)

	(method (init)
		(self
			createPoly: 132 14 126 16 123 19 123 23 120 20 118 16 114 19 115 23 117 26 108 23 109 27 114 30 101 31 101 32 115 36 118 35 120 37 124 37 127 33 128 36 137 36 135 32 143 28 146 24 137 26 142 21 141 17 128 24 131 15
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 152)
		(if (== local0 0)
			(= local0 1)
			(SetFlag 43)
			(self setScript: sPlantMove)
		)
	)
)

(instance spSecretDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 20150
		loop 1
		cycleSpeed 10
	)
)

(instance sPlantMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12011 0 82 0)
				(spPlant setCycle: End)
				(= cycles 1)
			)
			(1
				(spSecretDoor init:)
				(= seconds 2)
			)
			(2
				(gCurRoom setScript: sOpenDoor)
				(self dispose:)
			)
		)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSounds play: 12012 0 82 0)
				(spSecretDoor setCycle: End)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(efExitForward init: 3)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

