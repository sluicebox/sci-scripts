;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2139)
(include sci.sh)
(use Main)
(use nExit)

(public
	pigOut 0
)

(instance pigOut of CloseupRoom
	(properties
		picture 21779
		style 0
	)

	(method (init)
		(= exitRoom gPrevRoomNum)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

