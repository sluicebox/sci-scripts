;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6313)
(include sci.sh)
(use Main)
(use nExit)
(use PolyEdit)

(public
	blBoothCH3SR1 0
)

(instance blBoothCH3SR1 of P2Room
	(properties
		picture 470
		south 6213
	)

	(method (init)
		(super init: &rest)
		(curtisOTS init:)
		(gP2SongPlyr fadeTo: 75)
		(gGame handsOn: 1)
	)
)

(instance curtisOTS of View
	(properties
		x 390
		y 335
		view 14701
	)

	(method (init)
		(super init:)
		(self setPri: 10)
	)
)

