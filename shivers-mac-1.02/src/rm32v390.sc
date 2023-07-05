;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32390)
(include sci.sh)
(use Main)
(use n951)
(use n32001)
(use Motion)
(use System)

(public
	rm32v390 0
)

(instance rm32v390 of ShiversRoom
	(properties
		picture 32390
	)

	(method (init)
		(if (and (IsFlag 82) (not (IsFlag 81)))
			(gSounds fade: 23201 0 2 2 1 0)
			(gSounds fadeChain:)
		)
		(pHangingProp init:)
		(pLeverProp init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 81)
			(efExitForward init: 5)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 82) (not (IsFlag 81)))
			(gSounds interruptChain:)
			(gSounds play: 23201 -1 82 0)
			(proc32001_0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32410
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32560
	)

	(method (init)
		(self createPoly: 76 142 31 97 124 72 192 100 105 143)
		(super init: &rest)
	)
)

(instance pHangingProp of ShiversProp
	(properties
		priority 110
		fixPriority 1
		view 32390
		cycleSpeed 0
	)

	(method (init)
		(self createPoly: 0 0 0 0 0 0 0 0 0 0)
		(if (IsFlag 81)
			(= cel (self lastCel:))
		)
		(super init: &rest)
	)
)

(instance pLeverProp of ShiversProp
	(properties
		priority 120
		fixPriority 1
		view 32390
		loop 1
	)

	(method (init)
		(if (IsFlag 81)
			(= cel (self lastCel:))
		)
		(self createPoly: 211 50 207 55 224 110 228 110 233 106 218 52 212 50)
		(super init: &rest)
	)

	(method (doVerb)
		(if (and (IsFlag 82) (not (IsFlag 81)))
			(gCurRoom setScript: sHangEmHigh)
			(self createPoly: 0 0 0 0 0 0 0 0 0 0)
		)
	)
)

(instance sHangEmHigh of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 13210 0 82 0)
				(SetFlag 81)
				(proc951_15 6750)
				(pLeverProp setCycle: End self)
			)
			(1
				(pHangingProp setCycle: End)
				(gSounds play: 13211 0 82 0)
				(gSounds play: 13212 0 122 self)
			)
			(2
				(efExitForward init: 5)
				(proc951_7 23201)
				(proc951_9 23201)
				(gSounds interruptChain:)
				(= cycles 1)
			)
			(3
				(gSounds play: 23201 -1 82 0)
				(proc32001_0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

