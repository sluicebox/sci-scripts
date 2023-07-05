;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24190)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm24v190 0
)

(instance rm24v190 of ShiversRoom
	(properties
		picture 24191
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(woodGuy init:)
		(if (proc951_11 5 24000)
			(proc951_9 20702)
			(gSounds play: 20702 -1 32 0)
		)
		(super init: &rest)
		(if (proc951_11 5 24000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 5 24000)
			(gSounds fade: 20702 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24180
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24210
	)
)

(instance woodGuy of View
	(properties
		x 120
		y 133
		priority 1
		fixPriority 1
		view 55244
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 55240 self woodGuy)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(if (proc951_11 5 24000)
					(proc951_9 22404)
					(gSounds play: 22404 -1 50 0)
					(proc951_9 20702)
					(gSounds play: 20702 -1 32 0)
					(proc925_1 55240 self woodGuy 1)
					(= state 0)
				else
					(proc951_9 22402)
					(gSounds play: 22402 -1 98 0)
					(self dispose:)
				)
			)
		)
	)
)

