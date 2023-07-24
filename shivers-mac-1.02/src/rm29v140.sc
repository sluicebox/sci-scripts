;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29140)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm29v140 0
)

(instance rm29v140 of ShiversRoom
	(properties
		picture 29140
	)

	(method (init)
		(if (IsFlag 61)
			(self picture: 29141)
		)
		(efExitForwardRight init: 3)
		(efExitForwardLeft init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitUp init: 4)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 26020) ; rm26v020
				(gCurRoom setScript: sEnter)
			)
			((proc951_11 7 29000)
				(gSounds fade: 22901 0 5 16 1 0)
				(proc951_9 22902)
				(gSounds play: 22902 -1 50 0)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(proc951_11 7 29000)
				(!= newRoomNumber 29170) ; rm29v170
				(!= newRoomNumber 29160) ; rm29v160
				(!= newRoomNumber 29310) ; rm29v310
			)
			(gSounds fade: 22902 0 5 16 1 0)
			(gSounds stop: 22901)
			(proc951_9 22901)
			(gSounds play: 22901 -1 90 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29160
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 29130
	)

	(method (init)
		(self
			createPoly: 70 125 70 54 47 54 36 47 27 47 6 64 6 77 29 88 29 125 70 125
		)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 29170
	)

	(method (init)
		(self createPoly: 236 23 184 24 184 106 236 106 236 23)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 29310
	)

	(method (init)
		(self createPoly: 20 1 240 1 240 20 20 20 20 1)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 22602 0 1 30 1 self)
			)
			(1
				(proc951_10 22602)
				(= cycles 1)
			)
			(2
				(if (proc951_11 7 29000)
					(proc951_9 22902)
					(gSounds play: 22902 -1 50 0)
				else
					(proc951_9 22901)
					(gSounds play: 22901 -1 90 0)
				)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

