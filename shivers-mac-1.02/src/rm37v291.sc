;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37291)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm37v291 0
)

(instance rm37v291 of ShiversRoom
	(properties
		picture 37291
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(if (proc951_11 9 37000)
			(= picture 37293)
			((View new:) view: 37290 setPri: 5 1 init:)
			(metalHead init:)
			(gSounds play: 21111 -1 50 0)
		)
		(super init: &rest)
		(if (proc951_11 9 37000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 9 37000)
			(gSounds fade: 21111 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37370
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37380
	)
)

(instance metalHead of View
	(properties
		priority 5
		fixPriority 1
		view 37290
		loop 1
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 59370 self metalHead)
			)
			(1
				(efExitLeft dispose:)
				(efExitRight dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 6)
				(if (proc951_11 9 37000)
					(proc951_9 23702)
					(gSounds play: 23702 -1 66 0)
					(proc951_9 21111)
					(gSounds play: 21111 -1 50 0)
					(proc925_1 59370 self metalHead 1)
					(= state 0)
				else
					(proc951_9 23701)
					(gSounds play: 23701 -1 90 0)
					(self dispose:)
				)
			)
		)
	)
)

