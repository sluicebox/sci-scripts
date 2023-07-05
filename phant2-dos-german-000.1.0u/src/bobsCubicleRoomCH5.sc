;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4305)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2View)
(use System)

(public
	bobsCubicleRoomCH5 0
)

(instance bobsCubicleRoomCH5 of P2Room
	(properties
		picture 263
		south 3345
	)

	(method (init)
		(magnifyingGlass init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance magnifyingGlass of P2View
	(properties
		x 267
		y 220
		view 263
		sceneScored 1
	)

	(method (init)
		(super init: &rest)
		(if (not (IsFlag 758))
			(= whoDoit glassCode)
		else
			(self isHot: 0)
		)
	)
)

(instance glassCode of Code
	(properties)

	(method (doit)
		(SetFlag 758)
		(= global209 4910)
		(= global211 (= global212 1))
		(gCurRoom newRoom: 3315) ; mainOfficeRoomCH5SR1
	)
)

