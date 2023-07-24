;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1550)
(include sci.sh)
(use Main)
(use n951)
(use Str)
(use Motion)
(use System)

(public
	rm1v550 0
)

(instance rm1v550 of ShiversRoom
	(properties
		picture 1550
	)

	(method (init)
		(spDoorbell init:)
		(spHandles init:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 9660) ; rm9v66
			(gSounds fade: 10112 0 2 40 1 0)
			(gSounds stop: 30110)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(if (IsFlag 39)
			(gCurRoom eraseText:)
		)
		(super dispose:)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1552
	)

	(method (init)
		(self
			createPoly: 63 1 63 142 130 142 130 129 104 129 104 96 158 96 158 129 133 129 133 142 189 142 189 2 65 1
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1551
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1551
	)
)

(instance spDoorbell of ShiversProp
	(properties
		view 1550
	)

	(method (init)
		(self setPri: 100 1)
		(super init:)
	)

	(method (doVerb)
		(self setScript: sDoorbell)
	)
)

(instance spHandles of ShiversProp
	(properties
		view 1550
		loop 1
	)

	(method (init)
		(self setPri: 100 1)
		(super init:)
	)

	(method (doVerb)
		(self setScript: sHandles)
	)
)

(instance sDoorbell of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds stop: 30110)
				(proc951_7 30110)
				(proc951_9 30110)
				(spDoorbell setCycle: End self)
			)
			(1
				(gGame handsOn:)
				(spDoorbell setCycle: Beg self)
				(if (IsFlag 39)
					(= temp0
						(Str
							format:
								{ Welcome to Professor Windlenot's museum of the strange and unusual. Unfortunately the museum is still preparing exhibits and hopes you will visit when we open sometime in the near future. }
						)
					)
					(gCurRoom drawText: temp0 0 0)
					(temp0 data: 0 dispose:)
					(gSounds play: 30110 0 122 0)
				else
					(gSounds play: 30110 0 122 0)
				)
			)
			(2
				(proc951_16 66)
				(self dispose:)
			)
		)
	)
)

(instance sHandles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(spHandles cel: 0)
				(self cue:)
			)
			(1
				(gSounds stop: 10916)
				(gSounds play: 10916 0 90 0)
				(spHandles setCycle: End self)
			)
			(2
				(spHandles setCycle: Beg self)
			)
			(3
				(if (IsFlag 87)
					(gCurRoom newRoom: 9660) ; rm9v66
				)
				(= cycles 1)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

