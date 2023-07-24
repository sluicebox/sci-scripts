;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21050)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm21v050 0
)

(instance rm21v050 of ShiversRoom
	(properties
		picture 21050
	)

	(method (init)
		(efExitForwardLeftPlaque init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
		(if (proc951_11 2 21000)
			(proc951_9 20608)
			(gSounds play: 20608 -1 50 0)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 2 21000)
			(gSounds fade: 20608 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21060
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21440
	)
)

(instance efExitForwardLeftPlaque of ExitFeature
	(properties
		nextRoom 21321
	)

	(method (init)
		(self
			createPoly: 30 117 42 117 43 122 42 142 54 142 59 130 66 113 66 101 64 100 38 100 33 107 29 116
		)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 52210 self)
			)
			(1
				(efExitLeft dispose:)
				(efExitRight dispose:)
				(efExitForwardLeftPlaque dispose:)
				(proc925_0 self)
			)
			(2
				(efExitRight init: 1)
				(efExitLeft init: 2)
				(efExitForwardLeftPlaque init: 3)
				(if (proc951_11 2 21000)
					(proc951_9 20608)
					(gSounds play: 20608 -1 50 0)
					(proc951_9 22102)
					(gSounds play: 22102 -1 50 0)
					(= state 0)
					(proc925_1 52210 self 0 1)
				else
					(proc951_9 22101)
					(gSounds play: 22101 -1 98 0)
					(self dispose:)
				)
			)
		)
	)
)

