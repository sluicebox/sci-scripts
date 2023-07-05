;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17090)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm17v090 0
)

(instance rm17v090 of ShiversRoom
	(properties
		picture 17090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (proc951_11 9 17000)
			(if (and (!= gPrevRoomNum 17080) (!= gPrevRoomNum 17100)) ; rm17v080, rm17v100
				(proc951_9 21111)
				(gSounds play: 21111 -1 32 0)
			)
			(= picture 17091)
			(metalGuy init:)
		)
		(super init: &rest)
		(if (proc951_11 9 17000)
			(self setScript: sAttack)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17100
	)
)

(instance metalGuy of View
	(properties
		priority 1
		fixPriority 1
		view 17090
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 59170 self metalGuy)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(if (proc951_11 9 17000)
					(proc951_9 21703)
					(gSounds play: 21703 -1 50 0)
					(proc951_9 21111)
					(gSounds play: 21111 -1 50 0)
					(proc925_1 59170 self metalGuy 1)
					(= state 0)
				else
					(gSounds adjChainVol: 35)
					(gSounds
						playChain: 21701 -1 -1 -2 21701 -1 -1 -2 21702 -1 -1 -2
					)
					(self dispose:)
				)
			)
		)
	)
)

