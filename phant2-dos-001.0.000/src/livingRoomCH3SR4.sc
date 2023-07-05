;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2143)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2View)
(use Rectangle)
(use System)

(public
	livingRoomCH3SR4 0
)

(instance livingRoomCH3SR4 of CloseupRoom
	(properties
		picture 91
		style 0
	)

	(method (init)
		(gEgo put: 12) ; lockerI
		(cond
			((IsFlag 315)
				(openFL init:)
			)
			((IsFlag 373)
				(gettingLetter init:)
			)
			(else
				(lockedPanel init:)
			)
		)
		(if (or (< gPrevRoomNum 2100) (> gPrevRoomNum 2199))
			(= exitRoom 2123)
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

(instance lockedPanel of P2View
	(properties
		priority 10
		x 10
		y 245
		view 91
		loop 3
		scene 2143
		doneFlag 373
	)

	(method (init)
		(= whoDoit panelCode)
		(if (super init: &rest)
			(self addTarget: (Rectangle new: 56 56 593 232))
		)
		(self delVerb: 4)
		(self addVerb: 16)
	)
)

(instance panelCode of Code
	(properties)

	(method (doit)
		(letter init:)
	)
)

(instance letter of P2View
	(properties
		priority 500
		x 185
		y 241
		view 91
		doneFlag 411
		invItem 11
	)

	(method (init)
		(if (super init: &rest)
			(self addTarget: (proc63002_10 206 169 415 130 445 233 216 231))
		)
	)
)

(instance gettingLetter of P2View
	(properties
		x 10
		y 245
		view 91
		loop 3
	)

	(method (init)
		(= whoDoit gettingLetterCode)
		(super init: &rest)
		(self addTarget: (Rectangle new: 56 56 593 232))
	)
)

(instance gettingLetterCode of Code
	(properties)

	(method (doit)
		(gettingLetter dispose:)
		(letter init:)
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

