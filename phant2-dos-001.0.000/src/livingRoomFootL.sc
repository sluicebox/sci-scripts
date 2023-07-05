;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2180)
(include sci.sh)
(use Main)
(use nExit)
(use P2View)
(use Rectangle)
(use System)

(public
	livingRoomFootL 0
)

(instance livingRoomFootL of CloseupRoom
	(properties
		picture 91
		style 0
	)

	(method (init)
		(gEgo put: 12) ; lockerI
		(openFL init:)
		(if (or (< gPrevRoomNum 2100) (> gPrevRoomNum 2199))
			(= exitRoom (- (+ 2121 gChapter) 1))
		else
			(= exitRoom gPrevRoomNum)
		)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(= global209 2144)
		(gEgo get: 12) ; lockerI
		(super dispose: &rest)
	)
)

(instance openFL of P2View
	(properties
		x 10
		y 245
		view 91
		loop 3
	)

	(method (init)
		(= whoDoit openedCode)
		(super init: &rest)
		(self addTarget: (Rectangle new: 56 56 593 232))
	)
)

(instance openedCode of Code
	(properties)

	(method (doit)
		(openFL dispose:)
	)
)

