;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2144)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2View)

(public
	livingRoomCh4SR4 0
)

(instance livingRoomCh4SR4 of CloseupRoom
	(properties
		picture 90
		style 0
	)

	(method (init)
		(= exitRoom gPrevRoomNum)
		(hairPin init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance hairPin of P2View
	(properties
		x 60
		y 272
		view 90
		loop 1
		doneFlag 514
		invItem 16
	)

	(method (init)
		(super init: &rest)
		(self
			addTarget:
				(proc63002_10 112 218 225 200 227 224 211 227 206 219 118 238)
		)
	)
)

