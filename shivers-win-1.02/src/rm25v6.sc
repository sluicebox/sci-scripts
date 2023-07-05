;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25060)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm25v6 0
)

(instance rm25v6 of ShiversRoom
	(properties
		picture 25060
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitForwardRight init: 3)
		(if (proc951_11 0 25000)
			(proc951_9 22511)
			(gSounds play: 22511 -1 50 0)
		)
		(super init: &rest)
		(if (proc951_11 0 25000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 0 25000)
			(gSounds fade: 22511 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 25010
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 25000
	)

	(method (init)
		(self createPoly: 208 0 262 0 262 144 199 144 208 0)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 50250 self)
			)
			(1
				(efExitForwardRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 7)
				(efExitForwardRight init: 3)
				(if (proc951_11 0 25000)
					(proc951_9 22506)
					(gSounds play: 22506 -1 50 0)
					(proc951_9 22511)
					(gSounds play: 22511 -1 50 0)
					(proc925_1 50250 self 0 1)
					(= state 0)
				else
					(proc951_9 22501)
					(gSounds play: 22501 -1 0 0)
					(gSounds fade: 22501 74 5 16 0 0)
					(self dispose:)
				)
			)
		)
	)
)

