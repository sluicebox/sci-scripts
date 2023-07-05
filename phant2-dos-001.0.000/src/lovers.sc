;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2138)
(include sci.sh)
(use Main)
(use nExit)

(public
	lovers 0
)

(instance lovers of CloseupRoom
	(properties
		picture 21778
		style 0
	)

	(method (init)
		(= exitRoom gPrevRoomNum)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

