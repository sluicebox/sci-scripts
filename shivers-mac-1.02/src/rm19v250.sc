;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19250)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm19v250 0
)

(instance rm19v250 of ShiversRoom
	(properties
		picture 19250
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (proc951_11 8 19000)
			(self setScript: sAttack)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19260
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 58190 self)
			)
			(1
				(efExitLeft dispose:)
				(efExitRight dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(if (proc951_11 8 19000)
					(proc951_9 21909)
					(gSounds play: 21909 -1 50 0)
					(proc951_9 21910)
					(gSounds play: 21910 -1 50 0)
					(proc925_1 58190 self 0 1)
					(= state 0)
				else
					(gSounds
						playChain: -1 -5 21901 -1 -1 -5 21901 -1 -1 -5 21904 -1
					)
					(gSounds play: 21903 -1 48 0)
					(gSounds adjChainVol: 16)
					(self dispose:)
				)
			)
		)
	)
)

