;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2190)
(include sci.sh)
(use Main)
(use nExit)
(use P2View)
(use Polygon)

(public
	livingRoomSRPolaroid 0
)

(instance livingRoomSRPolaroid of CloseupRoom
	(properties
		picture 90
		style 0
	)

	(method (init)
		(= exitRoom gPrevRoomNum)
		(polaroid init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance polaroid of P2View
	(properties
		x 298
		y 305
		view 90
		doneFlag 94
		invItem 5
	)

	(method (init)
		(if (super init: &rest)
			(self addTarget: (polarPoly init:))
		)
	)
)

(instance polarPoly of Polygon
	(properties)

	(method (init)
		(super init: 316 90 467 45 531 215 373 262)
		(return self)
	)
)

