;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2130)
(include sci.sh)
(use Main)
(use nExit)

(public
	teamRoom 0
)

(instance teamRoom of CloseupRoom
	(properties
		picture 21776
		style 0
	)

	(method (init)
		(= exitRoom gPrevRoomNum)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

