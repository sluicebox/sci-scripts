;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Interface)
(use GameControls)
(use System)

(public
	proc700_0 0
	hoyle3GameControls 1
)

(local
	local0
	local1
	[local2 40]
	[local42 45]
	[local87 85]
	[local172 105]
	[local277 100]
	[local377 120]
	[local497 165]
	[local662 85]
)

(procedure (localproc_0)
	(if (or (!= global199 local0) (!= (DoSound sndMASTER_VOLUME) local1))
		(gGame_opt sel_57: 3)
	)
)

(procedure (proc700_0)
	(= local0 global199)
	(= local1 (DoSound sndMASTER_VOLUME))
	((= gGameControls hoyle3GameControls)
		sel_32: gcWindow
		sel_118:
			(speedSlider
				sel_325: speedCode
				sel_404: 57
				sel_406: 1
				sel_405: 15
				sel_192: (Format @local2 98 32) ; "This slider will adjust the speed of the game's Text."
				sel_117:
			)
			(volumeSlider
				sel_325: gGame
				sel_404: 365
				sel_406: (if (> (DoSound sndGET_POLYPHONY) 1) 15 else 1)
				sel_405: 0
				sel_192: (Format @local42 98 33) ; "This slider will adjust the sound volume."
				sel_117:
			)
			(iconRestart
				sel_325: iconRestart
				sel_404: 57
				sel_192: (Format @local87 98 34) ; "GAMES BUTTON - This Button will restart the game (after verification) so that you can select a new game to play."
				sel_117:
			)
			(iconQuit
				sel_325: iconQuit
				sel_404: 57
				sel_192: (Format @local172 98 35) ; "QUIT BUTTON - This button will allow you to quit the game after first verifying that you really, really, reeeealy do indeed want to quit."
				sel_117:
			)
			(iconReplay
				sel_325: iconReplay
				sel_404: 57
				sel_192: (Format @local277 98 36) ; "REPLAY BUTTON - This button will allow you to replay the same particular game that you are playing now, over again from the start."
				sel_117:
			)
			(iconAbout
				sel_325: iconAbout
				sel_404: 57
				sel_192: (Format @local377 98 37) ; "ABOUT BUTTON - By pressing this button you can determine which version of the game that you are playing, and see who the many people are who created it are."
				sel_117:
			)
			(iconHelp sel_192: (Format @local497 98 38) sel_117:) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button or slider is for."
			(iconOK
				sel_325: iconOK
				sel_404: 57
				sel_192: (Format @local662 98 39) ; "OK BUTTON - Pressing this button will put away the Game Control Panel and return you to whatever you were doing."
				sel_117:
			)
		sel_215: iconHelp
		sel_210: (if (not (HaveMouse)) iconOK else 0)
	)
)

(instance hoyle3GameControls of GameControls
	(properties
		sel_20 {hoyle3GameControls}
	)
)

(instance gcWindow of InvisibleWindow
	(properties
		sel_20 {gcWindow}
	)

	(method (sel_183 &tmp temp0 temp1 temp2 temp3 temp4)
		(self sel_187: 30 sel_188: 72 sel_189: 170 sel_190: 251)
		(super sel_183:)
		(DrawCel 701 0 0 0 0 15)
		(Graph grUPDATE_BOX temp0 temp1 (+ temp3 1) (+ temp2 1) 1) ; UNINIT, UNINIT, UNINIT, UNINIT
	)
)

(instance volumeSlider of Slider
	(properties
		sel_20 {volumeSlider}
		sel_2 701
		sel_3 1
		sel_4 1
		sel_7 134
		sel_6 62
		sel_14 128
		sel_396 701
		sel_397 1
		sel_52 2
		sel_406 15
	)
)

(instance speedSlider of Slider
	(properties
		sel_20 {speedSlider}
		sel_2 701
		sel_3 1
		sel_4 1
		sel_7 84
		sel_6 62
		sel_14 128
		sel_396 701
		sel_397 1
		sel_52 2
		sel_405 15
	)
)

(instance iconRestart of ControlIcon
	(properties
		sel_20 {iconRestart}
		sel_2 701
		sel_3 2
		sel_4 0
		sel_7 12
		sel_6 13
		sel_14 387
		sel_196 -1
	)

	(method (sel_57 &tmp [temp0 10] [temp10 10])
		(if
			(Print ; "Select a game to play?"
				98
				29
				78
				(Format @temp0 98 63) ; "Yes"
				1
				78
				(Format @temp10 98 64) ; "No"
				0
			)
			(= gNewRoomNum 975) ; chooseGame
			(gGameControls sel_102:)
			(= global107 1)
			(localproc_0)
		)
	)
)

(instance iconQuit of ControlIcon
	(properties
		sel_20 {iconQuit}
		sel_2 701
		sel_3 3
		sel_4 0
		sel_7 12
		sel_6 33
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(gGame sel_100:)
		(if gQuit
			(gGameControls sel_102:)
			(localproc_0)
		)
	)
)

(instance iconReplay of ControlIcon
	(properties
		sel_20 {iconReplay}
		sel_2 701
		sel_3 4
		sel_4 0
		sel_7 12
		sel_6 53
		sel_14 387
		sel_196 -1
	)

	(method (sel_57 &tmp [temp0 10] [temp10 10])
		(if
			(or
				(== gCurRoomNum 100)
				(== gCurRoomNum 300) ; backgam
				(== gCurRoomNum 200) ; checkers
				(== gCurRoomNum 400)
				(== gCurRoomNum 500)
				(== gCurRoomNum 600)
			)
			(if
				(Print ; "Replay the current game?"
					98
					30
					78
					(Format @temp0 98 63) ; "Yes"
					1
					78
					(Format @temp10 98 64) ; "No"
					0
				)
				(= gNewRoomNum gCurRoomNum)
				(= gCurRoomNum 0)
				(gCurRoom sel_28: -32768)
				(gGameControls sel_102:)
				(= global198 1)
				(Animate (gCast sel_24:) 0)
				(localproc_0)
			)
		else
			(Print 98 31) ; "This button has no function except while in a game."
		)
	)
)

(instance iconAbout of ControlIcon
	(properties
		sel_20 {iconAbout}
		sel_2 701
		sel_3 5
		sel_4 0
		sel_7 12
		sel_6 73
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(ScriptID 4 0) ; aboutCode
		(gGameControls sel_102:)
		((ScriptID 4 0) sel_57:) ; aboutCode
	)
)

(instance iconHelp of ControlIcon
	(properties
		sel_20 {iconHelp}
		sel_2 701
		sel_3 6
		sel_4 0
		sel_7 12
		sel_6 93
		sel_33 980
		sel_37 6
		sel_14 387
		sel_196 -1
	)
)

(instance iconOK of ControlIcon
	(properties
		sel_20 {iconOK}
		sel_2 701
		sel_3 7
		sel_4 0
		sel_7 12
		sel_6 113
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(gGameControls sel_102:)
		(localproc_0)
	)
)

(instance speedCode of Code
	(properties
		sel_20 {speedCode}
	)

	(method (sel_57 param1)
		(return
			(if argc
				(= global199 param1)
			else
				global199
			)
		)
	)
)

