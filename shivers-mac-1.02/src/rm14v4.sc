;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14040)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm14v4 0
)

(instance rm14v4 of ShiversRoom
	(properties
		picture 14040
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(if (!= [global118 17] 0)
			(vPotView init:)
		)
		(super init: &rest)
		(if (proc951_11 3 14000)
			(self setScript: sAttack)
		)
		(efExitForward init: 9)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 3 14000)
			(gSounds fade: 21110 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance vPotView of View
	(properties
		x 109
		y 42
		view 0
	)

	(method (init)
		(self view: [global118 17] loop: 1)
		(super init: &rest)
		(self setScale: scaleX: 17 scaleY: 17 setPri: 10)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14060
	)

	(method (init)
		(self
			createPoly:
				158
				143
				159
				115
				105
				88
				156
				83
				167
				77
				135
				69
				120
				70
				118
				41
				93
				36
				69
				42
				66
				48
				66
				72
				19
				81
				50
				88
				72
				88
				75
				97
				96
				112
				122
				122
				115
				143
				158
				143
		)
		(if (proc951_11 3 14000)
			(= nextRoom 0)
		)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 53140 self)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(efExitForward dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 7)
				(efExitRight init: 6)
				(efExitForward init: 9)
				(if (proc951_11 3 14000)
					(proc951_9 21402)
					(gSounds play: 21402 -1 66 0)
					(proc951_9 21110)
					(gSounds play: 21110 -1 50 0)
					(= state 0)
					(proc925_1 53140 self 0 1)
				else
					(efExitForward nextRoom: 14060)
					(self dispose:)
				)
			)
		)
	)
)

