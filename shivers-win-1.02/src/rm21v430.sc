;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21430)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm21v430 0
)

(instance rm21v430 of ShiversRoom
	(properties
		picture 21430
	)

	(method (init)
		(if (proc951_11 4 21000)
			(proc951_9 22512)
			(gSounds play: 22512 -1 50 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (proc951_11 4 21000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 21390) (proc951_11 4 21000)) ; rm21v390
			(gSounds fade: 22512 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21410
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 54210 self)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(if (proc951_11 4 21000)
					(proc951_9 22102)
					(gSounds play: 22102 -1 50 0)
					(proc951_9 22512)
					(gSounds play: 22512 -1 50 0)
					(proc925_1 54210 self 0 1)
					(= state 0)
				else
					(proc951_9 22101)
					(gSounds play: 22101 -1 0 0)
					(gSounds fade: 22101 98 5 16 0 0)
					(self dispose:)
				)
			)
		)
	)
)

