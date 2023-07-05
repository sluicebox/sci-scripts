;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4050)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)

(public
	curtisCubicleRoomSR5 0
)

(instance curtisCubicleRoomSR5 of CloseupRoom
	(properties
		picture 237
	)

	(method (init)
		(= exitRoom (- (+ 4021 gChapter) 1))
		(super init: &rest)
		(if (not (SetFlag 68))
			(proc63002_11 4000 2 45 2 1)
		)
		(gGame handsOn:)
	)
)

