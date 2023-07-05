;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2170)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)

(public
	tractorRoom 0
)

(instance tractorRoom of CloseupRoom
	(properties
		picture 21780
		style 0
	)

	(method (init)
		(= exitRoom gPrevRoomNum)
		(super init: &rest)
		(eggAMatic add: 2170 1 5)
		(gGame handsOn: 1)
	)
)

