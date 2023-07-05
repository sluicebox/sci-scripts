;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27081)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm27v081 0
)

(instance rm27v081 of ShiversRoom
	(properties
		picture 27081
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (proc951_11 5 36000)
			(gSounds stop: 22701)
			(if (!= gPrevRoomNum 27080) ; rm27v080
				(proc951_9 20702)
				(gSounds play: 20702 -1 50 0)
			)
			(= picture 27084)
			(woodGuy init:)
		)
		(super init: &rest)
		(if (proc951_11 5 36000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 5 36000) (!= newRoomNumber 27080)) ; rm27v080
			(gSounds fade: 20702 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27080
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27082
	)
)

(instance woodGuy of View
	(properties
		priority 1
		fixPriority 1
		view 27084
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 55270 self woodGuy)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(if (proc951_11 5 36000)
					(proc951_9 22702)
					(gSounds play: 22702 -1 50 0)
					(proc951_9 20702)
					(gSounds play: 20702 -1 50 0)
					(= state 0)
					(proc925_1 55270 self woodGuy 1)
				else
					(proc951_9 22701)
					(gSounds play: 22701 -1 98 0)
					(self dispose:)
				)
			)
		)
	)
)

