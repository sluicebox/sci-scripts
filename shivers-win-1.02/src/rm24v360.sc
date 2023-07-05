;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24360)
(include sci.sh)
(use Main)
(use n925)
(use n951)
(use Actor)
(use System)

(public
	rm24v360 0
)

(instance rm24v360 of ShiversRoom
	(properties
		picture 24360
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(efExitPlaque init: 3)
		(if (proc951_11 1 24000)
			(= picture 24361)
			(waxGuy init:)
			(proc951_9 20803)
			(gSounds play: 20803 -1 50 0)
		)
		(super init: &rest)
		(if (proc951_11 1 24000)
			(self setScript: sAttack)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 24420) (proc951_11 1 24000)) ; rm24v420
			(gSounds fade: 20803 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24370
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 36
		nextRoom 24355
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 24820
	)

	(method (init)
		(self createPoly: 205 101 210 113 232 113 226 100 205 100)
		(super init: &rest)
	)
)

(instance waxGuy of View
	(properties
		priority 1
		fixPriority 1
		view 24360
	)
)

(instance sAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc925_1 51240 self waxGuy)
			)
			(1
				(efExitRight dispose:)
				(efExitLeft dispose:)
				(efExitPlaque dispose:)
				(proc925_0 self)
			)
			(2
				(efExitLeft init: 7)
				(efExitRight init: 1)
				(efExitPlaque init: 3)
				(if (proc951_11 1 24000)
					(proc951_9 22404)
					(gSounds play: 22404 -1 50 0)
					(proc951_9 20803)
					(gSounds play: 20803 -1 50 0)
					(proc925_1 51240 self waxGuy 1)
					(= state 0)
				else
					(proc951_9 22401)
					(gSounds play: 22401 -1 0 0)
					(gSounds fade: 22401 98 5 16 0 0)
					(self dispose:)
				)
			)
		)
	)
)

