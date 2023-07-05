;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4650)
(include sci.sh)
(use Main)
(use nExit)
(use P2View)
(use P2Timer)
(use System)

(public
	paulsOfficeRoomSR5 0
)

(local
	local0
)

(instance paulsOfficeRoomSR5 of CloseupRoom
	(properties
		picture 341
	)

	(method (init)
		(= exitRoom (+ 4642 (- gChapter 2)))
		(storageKeyView init: whoDoit: keyCode)
		(paulBookView init:)
		(paperView init:)
		(super init: &rest)
		((ScriptID 63000 1) exitScene: 6773) ; sExit
		((ScriptID 63000 0) exitScene: 6773) ; nExit
		((ScriptID 63000 2) exitScene: 6773) ; eExit
		((ScriptID 63000 3) exitScene: 6773) ; wExit
		(gGame handsOn: 1)
	)

	(method (dispose)
		(if local0
			(= global211 1)
			(= global212 0)
			(= global209 6800)
		)
		(if (>= gChapter 4)
			(= global209 (if (== [global221 1] 0) 6773 else 6774))
		)
		(super dispose: &rest)
	)
)

(instance storageKeyView of P2View
	(properties
		x 407
		y 249
		view 341
		doneFlag 251
		invItem 13
	)
)

(instance keyCode of Code
	(properties)

	(method (doit)
		(paulCH2Timer start: whoDoit: paulCH2Code)
		((ScriptID 63000 1) nextRoom: 0 whoDoit: paulCH2Code) ; sExit
		((ScriptID 63000 2) nextRoom: 0 whoDoit: paulCH2Code) ; eExit
		((ScriptID 63000 3) nextRoom: 0 whoDoit: paulCH2Code) ; wExit
		((ScriptID 63000 0) nextRoom: 0 whoDoit: paulCH2Code) ; nExit
	)
)

(instance paulCH2Timer of P2Timer
	(properties
		kind 3
		length 10
	)
)

(instance paulCH2Code of Code
	(properties)

	(method (doit)
		(= local0 1)
		(if (paulCH2Timer seconds:)
			(paulCH2Timer dispose:)
		)
		(gCurRoom newRoom: 3322) ; mainOfficeRoomCH2SR2
		((ScriptID 63000 1) whoDoit: 0) ; sExit
		((ScriptID 63000 2) whoDoit: 0) ; eExit
		((ScriptID 63000 0) whoDoit: 0) ; nExit
		((ScriptID 63000 3) whoDoit: 0) ; wExit
	)
)

(instance paulBookView of P2View
	(properties
		x 484
		y 275
		view 341
		loop 1
		doneFlag 539
		invItem 17
	)

	(method (init)
		(if (and (super init: &rest) (!= gChapter 4))
			(self delVerb: 4)
		)
	)
)

(instance paperView of P2View
	(properties
		x 66
		y 255
		view 341
		loop 2
		doneFlag 538
		invItem 25
	)

	(method (init)
		(if (and (super init: &rest) (!= gChapter 4))
			(self delVerb: 4)
		)
	)
)

