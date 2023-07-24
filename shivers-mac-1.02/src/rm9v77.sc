;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9770)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm9v77 0
)

(instance rm9v77 of ShiversRoom
	(properties
		picture 9770
	)

	(method (init)
		(if (proc951_11 6 9000)
			(= picture 9771)
			(crystalGuy init:)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(efExitBack init: 8)
		(if (proc951_11 6 9000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 6 9000) (or (== newRoomNumber 9530) (== newRoomNumber 9550))) ; rm9v53, rm9v55
			(gSounds fade: 20910 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9550
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9530
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 9521
	)

	(method (init)
		(self
			createPoly: 94 0 101 10 92 58 102 76 162 76 171 57 161 11 172 0 243 0 243 142 20 142 20 0
		)
		(super init: &rest)
	)
)

(instance crystalGuy of View
	(properties
		priority 1
		fixPriority 1
		view 9770
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 56090 self crystalGuy)
			)
			(1
				(efExitLeft dispose:)
				(efExitRight dispose:)
				(efExitBack dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(efExitBack init: 8)
				(if (proc951_11 6 9000)
					(proc951_9 20908)
					(gSounds play: 20908 -1 50 0)
					(proc951_9 20910)
					(gSounds play: 20910 -1 50 0)
					(= state 0)
					(proc925_1 56090 self crystalGuy 1)
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

