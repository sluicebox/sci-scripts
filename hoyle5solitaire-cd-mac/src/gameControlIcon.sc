;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use h5Messager)
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

(local
	local0
)

(instance gameControlIcon of ControlIcon
	(properties
		noun 1
		modNum 12
		x 62
		y 420
		signal 451
		mainView 902
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(proc17_2)
		(gHoyle4GameControls show:)
		(proc64996_0)
	)
)

(instance optionsIcon of ControlIcon
	(properties
		noun 2
		modNum 12
		x 148
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
		(= temp2 6090)
		(= temp1 (gSystemPlane back:))
		(gSystemPlane back: 53)
		((ScriptID temp2 0) init:)
		(DisposeScript temp2)
		(gSystemPlane back: temp1)
		(if (and (== gCurRoomNum 700) global444)
			(proc700_9)
			(= global444 0)
		)
		(proc64996_0)
	)
)

(instance scoreIcon of ControlIcon
	(properties
		noun 3
		modNum 12
		x 234
		y 420
		signal 195
		mainView 902
		mainLoop 2
		cursorView 999
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(if (== gCardGameScriptNumber 6020)
			((ScriptID 6081 0) doit: global928) ; scoreBowling
		else
			((ScriptID 6080 0) doit: global928) ; scoreSolitaire
		)
	)
)

(instance rulesIcon of ControlIcon
	(properties
		noun 4
		modNum 12
		x 320
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
		((ScriptID 6100 0) init:) ; rulesSolitaire
		(proc64996_0)
	)
)

(instance moodIcon of ControlIcon
	(properties
		noun 5
		modNum 12
		x 406
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

	(method (doit &tmp temp0 temp1 temp2)
		(= temp1 (gSystemPlane back:))
		(gSystemPlane back: 53)
		(proc17_2)
		((ScriptID 13 0) doit:) ; theDeckCode
		(gSystemPlane back: temp1)
		(proc64996_0)
	)
)

(instance quitIcon of ControlIcon
	(properties
		noun 6
		modNum 12
		x 492
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
		(if (== global748 1)
			(if global924
				(gGame quitGame:)
				(proc0_8 0)
			else
				(= gNewRoomNum 975) ; chooseGame
			)
			(EnableCursor)
		else
			(if (== global748 3)
				(gGame quitGame:)
				(proc0_8 0)
			)
			(if (== global748 4)
				(= global111 1)
				(= global114 0)
				(if (== gCardGameScriptNumber 6020)
					(= global187 1)
					(= local0 global186)
				)
				((ScriptID 991 0) init: 975 3 gCurRoomNum 1) ; saveStats
				(if (== gCardGameScriptNumber 6020)
					(if global186
						((ScriptID 991 0) init: 975 3 gCurRoomNum 2) ; saveStats
						(if global186
							((ScriptID 991 0) init: 975 3 gCurRoomNum 3) ; saveStats
							(if global186
								((ScriptID 991 0) init: 975 3 gCurRoomNum 4) ; saveStats
							)
						)
					)
					(= global242 0)
					(= global186 local0)
				)
				(DisposeScript 991)
				(= global187 0)
				(if (== gCardGameScriptNumber 6020)
					(= gNewRoomNum 975) ; chooseGame
				)
			)
		)
		(proc64996_0)
	)
)

(instance gameControlIconF of View
	(properties
		x 62
		y 420
		view 902
	)
)

(instance optionsIconF of View
	(properties
		x 148
		y 420
		view 902
		loop 1
	)
)

(instance scoreIconF of View
	(properties
		x 234
		y 420
		view 902
		loop 2
	)
)

(instance rulesIconF of View
	(properties
		x 320
		y 420
		view 902
		loop 3
	)
)

(instance moodIconF of View
	(properties
		x 406
		y 420
		view 902
		loop 4
	)
)

(instance quitIconF of View
	(properties
		x 492
		y 420
		view 902
		loop 5
	)
)

