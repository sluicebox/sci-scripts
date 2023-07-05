;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use h5Messager)
(use crazy8s)
(use oldMaid)
(use heartsGame)
(use ginRummy)
(use cribbage)
(use klondike)
(use bridge)
(use pokerRoom)
(use checkers)
(use backgam)
(use Print)
(use GameControls)
(use User)
(use Actor)

(public
	gameControlIcon 0
	optionsIcon 1
	scoreIcon 2
	rulesIcon 3
	quitIcon 4
	moodIcon 5
	gameControlIconF 6
	optionsIconF 7
	scoreIconF 8
	rulesIconF 9
	moodIconF 10
	quitIconF 11
)

(instance gameControlIcon of ControlIcon
	(properties
		noun 1
		modNum 12
		x 66
		y 420
		signal 451
		mainView 902
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(proc17_2)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
		(gHoyle4GameControls show:)
		(proc64996_0)
		(PlaySong play: 0)
	)
)

(instance optionsIcon of ControlIcon
	(properties
		noun 2
		modNum 12
		x 152
		y 420
		priority 1
		signal 195
		mainView 902
		mainLoop 1
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0 temp1 temp2)
		(proc17_2)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
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
			(800
				(= temp2 890)
			)
			(1200 ; checkers
				(= temp2 1210)
			)
			(1300 ; backgam
				(= temp2 1310)
			)
			(1100 ; pokerRoom
				(= temp2 1190)
			)
			(else
				(= temp2 912)
			)
		)
		(= temp1 (gSystemPlane back:))
		(gSystemPlane back: 53)
		((ScriptID temp2 0) init:)
		(DisposeScript temp2)
		(gSystemPlane back: temp1)
		(if (and (== gCurRoomNum 700) global444) ; bridge
			(proc700_9)
			(= global444 0)
		)
		(proc64996_0)
		(proc0_8 0)
	)
)

(instance scoreIcon of ControlIcon
	(properties
		noun 3
		modNum 12
		x 238
		y 420
		signal 195
		mainView 902
		mainLoop 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp [temp0 23])
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
			(700 ; bridge
				(proc700_1)
			)
			(800
				(proc800_1)
			)
			(1300 ; backgam
				(proc1300_1)
			)
			(1200 ; checkers
				(proc1200_2)
			)
			(1100 ; pokerRoom
				(proc1100_1)
			)
			(else
				(Print addText: 3 16 0 0 -1 -1 12 init:) ; "You cannot view a score unless you are playing a card game."
			)
		)
		(PlaySong play: 0)
	)
)

(instance rulesIcon of ControlIcon
	(properties
		noun 4
		modNum 12
		x 324
		y 420
		signal 195
		mainView 902
		mainLoop 3
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp [temp0 22])
		(proc17_2)
		(gSong stop:)
		(if global878
			(PlaySong play: (+ 60 global878))
		else
			(PlaySong play: 61)
		)
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
			(1100 ; pokerRoom
				((ScriptID 1120 0) init:) ; rulesPoker
			)
			(1300 ; backgam
				((ScriptID 1311 0) init:) ; showRules
			)
			(1200 ; checkers
				((ScriptID 1211 0) init:) ; showRules
			)
			(else
				((ScriptID 20 0) init:) ; rulesCrazy8s
			)
		)
		(PlaySong play: 0)
		(proc64996_0)
	)
)

(instance moodIcon of ControlIcon
	(properties
		noun 5
		modNum 12
		x 410
		y 420
		signal 195
		mainView 902
		mainLoop 4
		maskView 902
		maskLoop 4
		maskCel 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(if global921
			(self signal: 4)
			(self mainCel: 2)
		)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if global921
			(self signal: 4)
			(self mainCel: 2)
			(self show:)
			(FrameOut)
			(UpdateScreenItem self)
		else
			(= temp1 (gSystemPlane back:))
			(gSystemPlane back: 53)
			(proc17_2)
			(gSong stop:)
			(if global878
				(PlaySong play: (+ 60 global878))
			else
				(PlaySong play: 61)
			)
			((ScriptID 13 0) doit:) ; theDeckCode
			(gSystemPlane back: temp1)
			(proc64996_0)
		)
	)
)

(instance quitIcon of ControlIcon
	(properties
		noun 6
		modNum 12
		x 496
		y 420
		signal 195
		mainView 902
		mainLoop 5
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(= global748 0)
		(proc17_2)
		(if global924
			((ScriptID 930 0) init: 9131 0 900) ; yesNo
		else
			((ScriptID 930 0) init: 913 2 gCurRoomNum) ; yesNo
		)
		(DisposeScript 930)
		(cond
			((== global748 1)
				(if global924
					(gGame quitGame:)
					(proc0_8 0)
				else
					(= gNewRoomNum 975) ; chooseGame
				)
				(EnableCursor)
			)
			((== global748 3)
				(gGame quitGame:)
				(proc0_8 0)
			)
		)
		(proc64996_0)
	)
)

(instance gameControlIconF of View
	(properties
		x 66
		y 420
		view 902
	)
)

(instance optionsIconF of View
	(properties
		x 152
		y 420
		view 902
		loop 1
	)
)

(instance scoreIconF of View
	(properties
		x 238
		y 420
		view 902
		loop 2
	)
)

(instance rulesIconF of View
	(properties
		x 324
		y 420
		view 902
		loop 3
	)
)

(instance moodIconF of View
	(properties
		x 410
		y 420
		view 902
		loop 4
	)

	(method (init)
		(if global921
			(self signal: 4)
			(self cel: 2)
		)
		(super init: &rest)
	)

	(method (doit)
		(if global921
			(self signal: 4)
			(self cel: 2)
			(self show:)
			(FrameOut)
			(UpdateScreenItem self)
		else
			(super doit: &rest)
		)
	)
)

(instance quitIconF of View
	(properties
		x 496
		y 420
		view 902
		loop 5
	)
)

