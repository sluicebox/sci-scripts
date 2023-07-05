;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4312)
(include sci.sh)
(use Main)
(use nExit)
(use P2View)

(public
	bobsCubicleRoomCH2SR1 0
)

(instance bobsCubicleRoomCH2SR1 of CloseupRoom
	(properties
		picture 265
		exitRoom 4302
	)

	(method (init)
		(super init: &rest)
		(bobsButtonView init:)
		(gGame handsOn: 1)
	)
)

(instance bobsButtonView of P2View
	(properties
		x 266
		y 213
		view 265
		doneFlag 244
		invItem 0
	)
)

