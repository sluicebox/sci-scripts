;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4050)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use PolyEdit)

(public
	curtisCubicleRoomSR5 0
)

(instance Blobview of View
	(properties
		x 180
		y 300
		view 44000
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
	)
)

(instance curtisCubicleRoomSR5 of CloseupRoom
	(properties
		picture 237
	)

	(method (init)
		(= exitRoom (- (+ 4021 gChapter) 1))
		(super init: &rest)
		(if (not (SetFlag 68))
			(Blobview init:)
			(proc63002_11 4000 2 45 2 1)
			(Blobview dispose:)
		)
		(gGame handsOn:)
	)
)

