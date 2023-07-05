;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6280)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm6v280 0
)

(instance rm6v280 of ShiversRoom
	(properties
		picture 6280
	)

	(method (init)
		(super init: &rest)
		(efExitBack init: 8)
		(if (proc951_11 2 6000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 6040
	)

	(method (init)
		(self createPoly: 0 0 0 143 20 143 20 20 243 20 243 143 263 143 263 0)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 52060 self)
			)
			(1
				(efExitBack dispose:)
				(proc925_0 self)
			)
			(2
				(efExitBack init: 8)
				(if (proc951_11 2 6000)
					(proc951_7 20603)
					(proc951_9 20603)
					(gSounds play: 20603 -1 32 0)
					(proc951_9 20608)
					(gSounds play: 20608 -1 32 0)
					(= state 0)
					(proc925_1 52060 self 0 1)
				else
					(proc951_7 20601)
					(proc951_9 20601)
					(gSounds play: 20601 -1 0 0)
					(gSounds fade: 20601 10 15 8 0 0)
					(gSounds playChain: -1 -4 20602 -1)
					(gSounds adjChainVol: 34)
					(self dispose:)
				)
			)
		)
	)
)

