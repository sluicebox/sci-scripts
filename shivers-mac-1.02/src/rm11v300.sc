;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11300)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm11v300 0
)

(instance rm11v300 of ShiversRoom
	(properties
		picture 11300
	)

	(method (init)
		(super init: &rest)
		(efExitBack init: 8)
		(if (proc951_11 3 11000)
			(self setScript: sAttack)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 11200
	)

	(method (init)
		(self
			createPoly:
				61
				143
				0
				144
				0
				0
				264
				0
				264
				143
				193
				143
				193
				126
				178
				100
				129
				89
				58
				143
		)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 53110 self)
			)
			(1
				(gSounds stop: 21902)
				(efExitBack dispose:)
				(proc925_0 self)
			)
			(2
				(proc951_7 21902)
				(proc951_9 21902)
				(gSounds play: 21902 -1 8 0)
				(efExitBack init: 8)
				(if (proc951_11 3 11000)
					(proc951_7 21103)
					(proc951_9 21103)
					(gSounds play: 21103 -1 50 0)
					(proc951_7 21110)
					(proc951_9 21110)
					(gSounds play: 21110 -1 32 0)
					(proc925_1 53110 self 0 1)
					(= state 0)
				else
					(proc951_7 21101)
					(proc951_9 21101)
					(gSounds play: 21101 -1 48 0)
					(gSounds adjChainVol: 32)
					(gSounds playChain: -1 -5 21102 -1)
					(self dispose:)
				)
			)
		)
	)
)

