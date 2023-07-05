;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42091)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)
(use P2Fidget)

(public
	rm2091 0
)

(instance rm2091 of P2Room
	(properties
		picture 2091
		north 42080
		south 42080
		east 42080
		west 42080
	)

	(method (init)
		(super init: &rest)
		(alienFoodF init: 200 100 500 320)
		(alienFood init:)
		(gGame handsOn: 1)
	)
)

(instance alienFood of P2Fidget
	(properties
		x 154
		y 126
		view 2091
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 2
	)
)

(instance alienFoodF of P2Feature
	(properties
		doneFlag 717
		invItem 29
		nextRoom 42080
	)
)

