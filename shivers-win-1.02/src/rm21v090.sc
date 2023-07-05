;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21090)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v090 0
)

(instance rm21v090 of ShiversRoom
	(properties
		picture 21090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (proc951_11 2 21000) (not (<= 21100 newRoomNumber 21120))) ; rm21v100, rm21v120
			(proc951_9 22101)
			(gSounds play: 22101 -1 0 0)
			(gSounds fade: 22101 98 5 16 0 0)
			(gSounds fade: 22102 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21130
	)

	(method (init)
		(self
			createPoly:
				121
				92
				121
				112
				127
				116
				127
				125
				118
				127
				99
				127
				88
				123
				89
				117
				93
				114
				94
				43
				64
				43
				64
				72
				47
				90
				28
				95
				28
				141
				203
				140
				193
				115
				177
				115
				167
				107
				170
				97
				170
				57
				161
				42
				120
				42
				121
				92
		)
		(super init: &rest)
	)
)

