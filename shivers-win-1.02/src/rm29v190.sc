;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29190)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use System)

(public
	rm29v190 0
)

(instance rm29v190 of ShiversRoom
	(properties
		picture 29190
	)

	(method (init)
		(if (proc951_11 7 29000)
			(proc951_9 22903)
			(gSounds play: 22903 -1 50 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (proc951_11 7 29000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 7 29000)
			(gSounds fade: 22903 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29200
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 29210
	)

	(method (init)
		(self createPoly: 191 118 191 42 88 42 88 118 191 118)
		(super init: &rest)
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 57290 self)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(if (proc951_11 7 29000)
					(proc951_9 22902)
					(gSounds play: 22902 -1 50 0)
					(proc951_9 22903)
					(gSounds play: 22903 -1 50 0)
					(proc925_1 57290 self 0 1)
					(= state 0)
				else
					(proc951_9 22901)
					(gSounds play: 22901 -1 90 0)
					(self dispose:)
				)
			)
		)
	)
)

