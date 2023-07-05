;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1023)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	mhRecRmCH3SR2 0
)

(instance mhRecRmCH3SR2 of CloseupRoom
	(properties
		picture 511
	)

	(method (init)
		(ClearFlag 1001)
		(strap init:)
		(fidget init:)
		(= exitRoom 1013)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance strap of P2Feature
	(properties)

	(method (init)
		(if
			(or
				(IsFlag 347)
				(and (not (IsFlag 347)) (not (IsFlag 349)))
			)
			(= whoDoit strapCode)
			(super init: 284 224 400 247)
		)
	)
)

(instance strapCode of Code
	(properties)

	(method (doit)
		(if (not (IsFlag 349))
			(SetFlag 349)
			(= global209 240)
			(gCurRoom newRoom: 1013) ; mhRecRmCH3SR1
		else
			(SetFlag 350)
			(= global209 250)
			(gCurRoom newRoom: 1013) ; mhRecRmCH3SR1
		)
	)
)

(instance fidget of P2Fidget
	(properties
		x 203
		y 335
		view 15110
		cycleSpeed 8
		initStart 0
		initFinish 0
		cycleStart 3
		cycleFinish 5
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

