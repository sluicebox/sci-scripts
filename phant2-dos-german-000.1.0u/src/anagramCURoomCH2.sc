;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4662)
(include sci.sh)
(use Main)
(use nExit)
(use P2View)
(use System)

(public
	anagramCURoomCH2 0
)

(instance anagramCURoomCH2 of CloseupRoom
	(properties
		picture 361
		exitRoom 4632
	)

	(method (init)
		(super init: &rest)
		(paperV init:)
		(gGame handsOn:)
	)
)

(instance paperV of P2View
	(properties
		x 85
		y 294
		view 361
		doneFlag 253
		invItem 23
	)

	(method (init)
		(if (super init: &rest)
			(= whoDoit adoptAnOfficeAndCleanItUp)
		)
	)
)

(instance adoptAnOfficeAndCleanItUp of Code
	(properties)

	(method (doit)
		(gCurRoom newRoom: 4632) ; paulsOfficeRoomCH2SR3
	)
)

