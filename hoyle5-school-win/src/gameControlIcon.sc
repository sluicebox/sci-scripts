;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use crazy8s)
(use oldMaid)
(use heartsGame)
(use ginRummy)
(use cribbage)
(use klondike)
(use Print)
(use GameControls)

(public
	gameControlIcon 0
	optionsIcon 1
	scoreIcon 2
	rulesIcon 3
	helpIcon 4
	deckIcon 5
)

(instance gameControlIcon of ControlIcon
	(properties
		noun 1
		modNum 12
		signal 451
		mainView 902
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gTheIconBar hide:)
		(proc0_8 2)
		(gHoyle4GameControls show:)
	)
)

(instance optionsIcon of ControlIcon
	(properties
		noun 2
		modNum 12
		x 55
		signal 195
		mainView 902
		mainLoop 1
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2)
		(gTheIconBar hide:)
		(switch gCurRoomNum
			(100 ; crazy8s
				(= temp2 190)
			)
			(200 ; oldMaid
				(= temp2 290)
			)
			(300 ; heartsGame
				(= temp2 390)
			)
			(400 ; ginRummy
				(= temp2 490)
			)
			(500 ; cribbage
				(= temp2 590)
			)
			(600 ; klondike
				(= temp2 690)
			)
			(700
				(= temp2 790)
			)
			(800
				(= temp2 890)
			)
			(else
				(= temp2 912)
			)
		)
		(= temp1 (gSystemPlane back:))
		(gSystemPlane back: 53)
		(proc0_8 40)
		((ScriptID temp2 0) init:)
		(DisposeScript temp2)
		(gSystemPlane back: temp1)
		(if (and (== gCurRoomNum 700) global444)
			(proc700_9)
			(= global444 0)
		)
		(proc0_8 0)
	)
)

(instance scoreIcon of ControlIcon
	(properties
		noun 3
		modNum 12
		x 109
		signal 195
		mainView 902
		mainLoop 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp [temp0 22])
		(gTheIconBar hide:)
		(switch gCurRoomNum
			(100 ; crazy8s
				(proc100_1)
			)
			(200 ; oldMaid
				(proc200_1)
			)
			(300 ; heartsGame
				(proc300_1)
			)
			(400 ; ginRummy
				(ShowGinRummyScore)
			)
			(500 ; cribbage
				(proc500_1)
			)
			(600 ; klondike
				(proc600_1)
			)
			(700
				(proc700_1)
			)
			(800
				(proc800_1)
			)
			(else
				(Print addText: 3 16 0 0 -1 -1 12 init:) ; "You cannot view a score unless you are playing a card game."
			)
		)
	)
)

(instance rulesIcon of ControlIcon
	(properties
		noun 4
		modNum 12
		x 162
		signal 195
		mainView 902
		mainLoop 3
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp [temp0 22])
		(gTheIconBar hide:)
		(proc0_8 30)
		(switch gCurRoomNum
			(100 ; crazy8s
				((ScriptID 120 0) init:) ; rulesCrazy8s
			)
			(200 ; oldMaid
				((ScriptID 220 0) init:) ; rulesOldMaid
			)
			(300 ; heartsGame
				((ScriptID 320 0) init:) ; rulesHearts
			)
			(400 ; ginRummy
				((ScriptID 420 0) init:) ; rulesGinRummy
			)
			(500 ; cribbage
				((ScriptID 520 0) init:) ; rulesCribbage
			)
			(600 ; klondike
				((ScriptID 620 0) init:) ; rulesKlondike
			)
			(700
				((ScriptID 720 0) init:) ; MISSING SCRIPT
			)
			(800
				((ScriptID 820 0) init:) ; MISSING SCRIPT
			)
			(else
				((ScriptID 20 0) init:) ; rulesCrazy8s
			)
		)
		(proc0_8 0)
	)
)

(instance deckIcon of ControlIcon
	(properties
		noun 5
		modNum 12
		x 215
		signal 195
		mainView 902
		mainLoop 4
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2)
		(gTheIconBar hide:)
		(= temp1 (gSystemPlane back:))
		(gSystemPlane back: 53)
		(proc0_8 98)
		((ScriptID 13 0) doit:) ; theDeckCode
		(gSystemPlane back: temp1)
		(proc0_8 0)
	)
)

(instance helpIcon of ControlIcon
	(properties
		noun 6
		modNum 12
		x 268
		signal 131
		type 8192
		mainView 902
		mainLoop 5
		cursorView 995
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

