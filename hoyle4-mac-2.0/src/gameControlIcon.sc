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
(use bridge)
(use euchre)
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

(local
	[local0 455]
)

(instance gameControlIcon of ControlIcon
	(properties
		view 902
		loop 0
		cel 0
		cursor 999
		signal 451
		highlightColor -1
		noun 1
		modNum 12
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gTheIconBar hide:)
		(proc0_8 1002)
		(gHoyle4GameControls show:)
	)
)

(instance optionsIcon of ControlIcon
	(properties
		view 902
		loop 1
		cel 0
		cursor 999
		signal 195
		highlightColor -1
		noun 2
		modNum 12
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
			(700 ; bridge
				(= temp2 790)
			)
			(800 ; euchre
				(= temp2 890)
			)
			(else
				(= temp2 912)
			)
		)
		(gGameControls hide:)
		(= temp1 (gSystemWindow back:))
		(gSystemWindow back: 53)
		(proc0_8 1040)
		((ScriptID temp2 0) init:)
		(DisposeScript temp2)
		(gSystemWindow back: temp1)
		(if (and (== gCurRoomNum 700) global444) ; bridge
			(proc700_9)
			(= global444 0)
		)
		(proc0_8 0)
	)
)

(instance scoreIcon of ControlIcon
	(properties
		view 902
		loop 2
		cel 0
		cursor 999
		signal 195
		highlightColor -1
		noun 3
		modNum 12
		helpVerb 4
	)

	(method (doit &tmp [temp0 21] temp21)
		(gTheIconBar hide:)
		(= temp21 (GetPort))
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
				(proc400_1)
			)
			(500 ; cribbage
				(proc500_1)
			)
			(600 ; klondike
				(proc600_1)
			)
			(700 ; bridge
				(proc700_1)
			)
			(800 ; euchre
				(proc800_1)
			)
			(else
				(Print addText: 3 16 0 0 -1 -1 12 init:) ; "You cannot view a score unless you are playing a card game."
			)
		)
		(SetPort temp21)
	)
)

(instance rulesIcon of ControlIcon
	(properties
		view 902
		loop 3
		cel 0
		cursor 999
		signal 195
		highlightColor -1
		noun 4
		modNum 12
		helpVerb 4
	)

	(method (doit &tmp [temp0 21] temp21)
		(gTheIconBar hide:)
		(proc0_8 1030)
		(= temp21 (GetPort))
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
			(700 ; bridge
				((ScriptID 720 0) init:) ; rulesBridge
			)
			(800 ; euchre
				((ScriptID 820 0) init:) ; rulesSpades
			)
			(else
				((ScriptID 20 0) init:) ; rulesCrazy8s
			)
		)
		(SetPort temp21)
		(proc0_8 0)
	)
)

(instance deckIcon of ControlIcon
	(properties
		view 902
		loop 4
		cel 0
		cursor 999
		signal 195
		highlightColor -1
		noun 5
		modNum 12
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2)
		(gTheIconBar hide:)
		(= temp1 (gSystemWindow back:))
		(gSystemWindow back: 53)
		(proc0_8 1098)
		((ScriptID 13 0) doit:) ; theDeckCode
		(gSystemWindow back: temp1)
		(proc0_8 0)
	)
)

(instance helpIcon of ControlIcon
	(properties
		view 902
		loop 5
		cel 0
		cursor 995
		type 8192
		signal 131
		highlightColor -1
		noun 6
		modNum 12
		helpVerb 4
	)

	(method (doit)
		(super doit: &rest)
	)
)

