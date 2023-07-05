;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4060)
(include sci.sh)
(use Main)
(use nExit)

(public
	curtisCubicleRoomSR6 0
)

(instance curtisCubicleRoomSR6 of CloseupRoom
	(properties
		picture 234
	)

	(method (init)
		(= exitRoom (- (+ 4021 gChapter) 1))
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

