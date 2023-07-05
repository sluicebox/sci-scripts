;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9930)
(include sci.sh)
(use Main)
(use n951)
(use ForwardCounter)
(use Motion)
(use System)

(public
	rm9v93 0
)

(local
	local0
)

(instance rm9v93 of ShiversRoom
	(properties
		picture 9930
	)

	(method (init)
		(proc951_16 149)
		(spFaucet init:)
		(if (IsFlag 42)
			(efExitBack init: 8)
		else
			(efExitBack init: 8)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
		(if (!= newRoomNumber 9700) ; rm9v70
			(gSounds play: 10920 0 82 0)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 9390
	)

	(method (init)
		(self
			createPoly:
				0
				0
				82
				58
				82
				123
				207
				115
				205
				51
				82
				58
				0
				0
				263
				0
				263
				143
				0
				143
		)
		(super init: &rest)
	)
)

(instance spFaucet of ShiversProp
	(properties
		priority 11
		fixPriority 1
		view 9930
		cycleSpeed 15
	)

	(method (init)
		(self createPoly: 111 105 111 65 181 56 170 102)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 42)
			(self setScript: sFaucetOff)
			(ClearFlag 42)
			(efExitBack nextRoom: 9390 cursorCel: 8)
		else
			(self setScript: sFaucetOn)
			(efExitBack nextRoom: 9700 cursorCel: 4)
			(SetFlag 42)
		)
	)
)

(instance sFaucetOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client setCycle: Beg self)
				(gSounds stop: 10910)
				(gSounds stop: 10908)
				(gSounds play: 10910 -1 32 0)
				(= local0 4)
			)
			(1
				(client cel: (client lastCel:))
				(client setCycle: Beg self)
				(if local0
					(-- local0)
					(-- state)
				)
			)
			(2
				(gSounds stop: 10910)
				(gSounds stop: 20908)
				(gSounds stop: 20909)
				(= cycles 1)
			)
			(3
				(proc951_9 10908)
				(gSounds play: 10908 -1 0 0)
				(PrintDebug {fade to 42})
				(gSounds fade: 10908 42 15 8 0 0)
				(if (proc951_11 0 9000)
					(gSounds fade: 20903 0 1 16 1 self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(proc951_9 20908)
				(gSounds play: 20908 -1 50 0)
				(proc951_9 20909)
				(gSounds play: 20909 -1 34 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFaucetOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client setCycle: End self)
				(gSounds stop: 10910)
				(gSounds play: 10910 -1 32 0)
			)
			(1
				(client cel: 0)
				(self cue:)
			)
			(2
				(client setCycle: ForwardCounter 4 self)
			)
			(3
				(if (proc951_11 0 9000)
					(gSounds stop: 20903)
				)
				(client setCycle: End self)
			)
			(4
				(gSounds stop: 10910)
				(PrintDebug {fade to 0})
				(gSounds fade: 10908 0 5 8 0 0)
				(if (proc951_11 0 9000)
					(gSounds fade: 20908 0 1 16 1 self)
					(gSounds fade: 20909 0 1 16 1 0)
				else
					(= cycles 1)
				)
			)
			(5
				(gSounds stop: 20909)
				(= cycles 1)
			)
			(6
				(proc951_9 20903)
				(gSounds play: 20903 -1 0 0)
				(gSounds fade: 20903 50 10 16 0 0)
				(gGame handsOn:)
				(gSounds stop: 10908)
				(self dispose:)
			)
		)
	)
)

