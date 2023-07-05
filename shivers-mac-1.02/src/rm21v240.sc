;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21240)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v240 0
)

(instance rm21v240 of ShiversRoom
	(properties
		picture 21240
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitForward init: 3)
		(efExitForwardRight init: 3)
		(super init: &rest)
		(if (proc951_11 2 21000)
			(proc951_9 22102)
			(gSounds play: 22102 -1 50 0)
			(gSounds fade: 22101 0 5 16 1 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 2 21000) (<= 21210 newRoomNumber 21230)) ; rm21v210, rm21v230
			(proc951_9 22101)
			(gSounds play: 22101 -1 0 0)
			(gSounds fade: 22101 98 5 16 0 0)
			(gSounds fade: 22102 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21100
	)

	(method (init)
		(self
			createPoly:
				145
				34
				145
				101
				125
				107
				70
				100
				70
				53
				102
				48
				117
				31
				145
				31
				145
				35
		)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 21450
	)

	(method (init)
		(self
			createPoly:
				205
				18
				179
				18
				169
				44
				169
				68
				166
				68
				166
				90
				197
				90
				202
				95
				226
				95
				226
				85
				221
				70
				211
				60
				211
				30
				204
				18
		)
		(super init: &rest)
	)
)

