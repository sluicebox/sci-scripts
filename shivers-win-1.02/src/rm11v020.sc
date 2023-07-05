;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11020)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm11v020 0
)

(instance rm11v020 of ShiversRoom
	(properties
		picture 11020
	)

	(method (init)
		(super init: &rest)
		(if (< gPrevRoomNum 11000)
			(self setScript: sEnter)
		else
			(efExitLeft init: 2)
			(efExitRight init: 1)
			(efForwardLeft init: 9)
			(efForwardRight init: 9)
			(efInhaler init: 0)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 8)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11050
	)
)

(instance efForwardLeft of ExitFeature
	(properties
		nextRoom 11180
	)

	(method (init)
		(self
			createPoly:
				106
				136
				84
				136
				84
				119
				109
				119
				108
				78
				107
				64
				26
				64
				25
				144
				107
				144
				106
				141
		)
		(super init: &rest)
	)
)

(instance efForwardRight of ExitFeature
	(properties
		nextRoom 11120
	)

	(method (init)
		(self
			createPoly:
				214
				106
				214
				81
				202
				77
				190
				77
				161
				77
				160
				58
				189
				58
				189
				45
				243
				45
				243
				106
		)
		(super init: &rest)
	)
)

(instance efInhaler of ExitFeature
	(properties
		nextRoom 11510
	)

	(method (init)
		(self createPoly: 106 136 84 136 84 119 109 119)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 11105 0 32 self)
				(proc951_7 21902)
				(proc951_9 21902)
			)
			(1
				(gSounds play: 21902 -1 8 0)
				(if (and (not (proc951_11 3 11000)) (not (proc951_11 3 11000)))
					(proc951_7 21101)
					(proc951_9 21101)
					(gSounds play: 21101 -1 48 0)
					(gSounds adjChainVol: 32)
					(gSounds playChain: -1 -5 21102 -1)
				)
				(gGame handsOn:)
				(efExitLeft init: 2)
				(efExitRight init: 1)
				(efForwardLeft init: 9)
				(efForwardRight init: 9)
				(efInhaler init: 0)
				(self dispose:)
			)
		)
	)
)

