;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9700)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm9v70 0
)

(instance rm9v70 of ShiversRoom
	(properties
		picture 9701
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitFaucet init: 8)
		(if (IsFlag 43)
			(gSounds play: 10920 0 42 0)
			(ClearFlag 43)
		)
		(if (IsFlag 42)
			((Prop new:)
				view: 9700
				setPri: 5 1
				loop: 0
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
			((Prop new:)
				view: 9700
				setPri: 6 1
				loop: 1
				cycleSpeed: 12
				setCycle: Fwd
				init:
			)
			(if (proc951_11 0 9000)
				(self setScript: sAttack)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
		(if (and (!= newRoomNumber 9930) (IsFlag 42) (proc951_11 0 9000)) ; rm9v93
			(gSounds fade: 20909 0 10 16 1 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9850
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9380
	)
)

(instance efExitFaucet of ExitFeature
	(properties
		nextRoom 9390
	)

	(method (init)
		(self
			createPoly: 24 101 72 108 139 111 173 109 225 105 243 100 243 143 20 143 20 97
		)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 50090 self)
			)
			(1
				(efExitLeft dispose:)
				(efExitRight dispose:)
				(efExitFaucet dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 6)
				(efExitFaucet init: 8)
				(if (proc951_11 0 9000)
					(proc951_9 20908)
					(gSounds play: 20908 -1 50 0)
					(proc951_9 20909)
					(gSounds play: 20909 -1 50 0)
					(= state 0)
					(proc925_1 50090 self 0 1)
				else
					(proc951_9 20903)
					(gSounds play: 20903 -1 0 0)
					(gSounds fade: 20903 42 10 16 0 0)
					(self dispose:)
				)
			)
		)
	)
)

