;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29510)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm29v510 0
)

(instance rm29v510 of ShiversRoom
	(properties
		picture 29510
	)

	(method (init)
		(if (IsFlag 61)
			(if (IsFlag 70)
				(riddleMessage loop: 1 init:)
			else
				(SetFlag 70)
				(proc951_16 164)
				(gCurRoom setScript: sShowMessage)
			)
		)
		(efExitBack init: 8)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 29010
	)

	(method (init)
		(self
			createPoly: 134 72 73 48 0 11 0 142 100 143 51 130 31 112 35 95 74 79 128 73 149 73 197 80 230 95 238 111 226 125 186 139 184 144 263 143 264 36 184 50 150 71 142 73
		)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 29260
	)

	(method (init)
		(self createPoly: 134 72 74 48 0 10 1 0 263 0 262 10 185 50 147 72)
		(super init: &rest)
	)
)

(instance riddleMessage of Prop
	(properties
		priority 25
		fixPriority 1
		view 29260
		cycleSpeed 18
	)
)

(instance sShowMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 12908 0 90 0)
				(= ticks 30)
			)
			(1
				(riddleMessage cycleSpeed: 6 setCycle: Fwd init:)
				(= seconds 1)
			)
			(2
				(riddleMessage cycleSpeed: 12)
				(= seconds 1)
			)
			(3
				(riddleMessage cycleSpeed: 18)
				(= seconds 1)
			)
			(4
				(riddleMessage setCycle: End self)
			)
			(5
				(riddleMessage loop: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

