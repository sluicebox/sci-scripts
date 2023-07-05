;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2137)
(include sci.sh)
(use Main)
(use nExit)

(public
	outsideRoom 0
)

(instance outsideRoom of CloseupRoom
	(properties
		picture 21777
		style 0
	)

	(method (init)
		(= exitRoom gPrevRoomNum)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

