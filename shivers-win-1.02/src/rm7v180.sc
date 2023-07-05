;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7180)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm7v180 0
)

(instance rm7v180 of ShiversRoom
	(properties
		picture 7180
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(woodGuy init:)
		(super init: &rest)
		(if (proc951_11 5 7000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 5 7000)
			(gSounds fade: 20702 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7190
	)
)

(instance woodGuy of View
	(properties
		x 118
		y 128
		priority 1
		fixPriority 1
		view 7180
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 55070 self woodGuy)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 7)
				(efExitRight init: 6)
				(if (proc951_11 5 7000)
					(proc951_9 20701)
					(gSounds play: 20701 -1 50 0)
					(proc951_9 20702)
					(gSounds play: 20702 -1 50 0)
					(= state 0)
					(proc925_1 55070 self woodGuy 1)
				else
					(gSounds playChain: -1 -4 20602 -1)
					(gSounds adjChainVol: 34)
					(self dispose:)
					(proc925_1 55070 self woodGuy 1)
				)
			)
		)
	)
)

