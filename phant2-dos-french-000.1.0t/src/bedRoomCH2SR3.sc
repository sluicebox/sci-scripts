;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2032)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Timer)
(use P2Fidget)
(use System)

(public
	bedRoomCH2SR3 0
)

(instance bedRoomCH2SR3 of P2Room
	(properties
		picture 21
	)

	(method (init)
		(ClearFlag 1001)
		(super init: &rest)
		(navel init:)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(if (gCast contains: nTimer)
			(nTimer dispose:)
		)
		(super dispose:)
	)
)

(instance navel of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(= whoDoit navelCode)
		(super init: 357 210 376 231)
		(fidget init:)
		(nTimer init:)
	)
)

(instance navelCode of Code
	(properties)

	(method (doit)
		(nTimer dispose:)
		(gSceneList add: 970 980)
		(gCurRoom newRoom: 800) ; endChapter
	)
)

(instance nTimer of P2Timer
	(properties)

	(method (init)
		(= whoDoit nTimerCode)
		(self start: 3 10)
	)
)

(instance nTimerCode of Code
	(properties)

	(method (doit)
		(= global209 980)
		(gCurRoom newRoom: 800) ; endChapter
	)
)

(instance fidget of P2Fidget
	(properties
		x 427
		y 105
		view 10210
		cycleSpeed 8
		dir -1
		initStart 0
		initFinish 0
		cycleFinish 6
		wholeCycle 1
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)
)

