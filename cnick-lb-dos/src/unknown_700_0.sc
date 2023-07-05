;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use n010)
(use Interface)
(use GameControls)
(use System)

(public
	proc700_0 0
	unknown_700_0 1
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
	((= gGameControls unknown_700_0)
		sel_32: unknown_700_1
		sel_118:
			(unknown_700_3
				sel_325: unknown_700_10
				sel_404: 57
				sel_406: 1
				sel_405: 15
				sel_192: (Format @local2 98 32) ; "This slider will adjust the speed of the game's Text."
				sel_117:
			)
			(unknown_700_2
				sel_325: gGame
				sel_404: 365
				sel_406: (if (> (DoSound sndGET_POLYPHONY) 1) 15 else 1)
				sel_405: 0
				sel_192: (Format @local42 98 33) ; "This slider will adjust the sound volume."
				sel_117:
			)
			(unknown_700_4
				sel_325: unknown_700_4
				sel_404: 57
				sel_192: (Format @local87 98 34) ; "GAMES BUTTON - This Button will restart the game (after verification) so that you can select a new game to play."
				sel_117:
			)
			(unknown_700_5
				sel_325: unknown_700_5
				sel_404: 57
				sel_192: (Format @local172 98 35) ; "QUIT BUTTON - This button will allow you to quit the game after first verifying that you really, really, reeeealy do indeed want to quit."
				sel_117:
			)
			(unknown_700_6
				sel_325: unknown_700_6
				sel_404: 57
				sel_192: (Format @local277 98 36) ; "REPLAY BUTTON - This button will allow you to replay the same particular game that you are playing now, over again from the start."
				sel_117:
			)
			(unknown_700_7
				sel_325: unknown_700_7
				sel_404: 57
				sel_192: (Format @local377 98 37) ; "ABOUT BUTTON - By pressing this button you can determine which version of the game that you are playing, and see who the many people are who created it are."
				sel_117:
			)
			(unknown_700_8 sel_192: (Format @local497 98 38) sel_117:) ; "HELP BUTTON - This is the button that you pressed to get help on other things. By placing this cursor on an item on the Control Panel and pressing the button, you will get a brief explanation of what each button or slider is for."
			(unknown_700_9
				sel_325: unknown_700_9
				sel_404: 57
				sel_192: (Format @local662 98 39) ; "OK BUTTON - Pressing this button will put away the Game Control Panel and return you to whatever you were doing."
				sel_117:
			)
		sel_215: unknown_700_8
		sel_210: (if (not (HaveMouse)) unknown_700_9 else 0)
	)
)

(instance unknown_700_0 of GameControls
	(properties
		sel_20 -1
	)
)

(instance unknown_700_1 of Class_10_0
	(properties)

	(method (sel_183 &tmp temp0 temp1 temp2 temp3 temp4)
		(self sel_187: 30 sel_188: 72 sel_189: 170 sel_190: 251)
		(super sel_183:)
		(DrawCel 701 0 0 0 0 15)
		(Graph grUPDATE_BOX temp0 temp1 (+ temp3 1) (+ temp2 1) 1) ; UNINIT, UNINIT, UNINIT, UNINIT
	)
)

(instance unknown_700_2 of Slider
	(properties
		sel_20 -1
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

(instance unknown_700_3 of Slider
	(properties
		sel_20 -1
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

(instance unknown_700_4 of ControlIcon
	(properties
		sel_20 -1
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

(instance unknown_700_5 of ControlIcon
	(properties
		sel_20 -1
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

(instance unknown_700_6 of ControlIcon
	(properties
		sel_20 -1
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
				(== gCurRoomNum 100) ; unknown_100_4
				(== gCurRoomNum 300)
				(== gCurRoomNum 200)
				(== gCurRoomNum 400)
				(== gCurRoomNum 500) ; unknown_500_0
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

(instance unknown_700_7 of ControlIcon
	(properties
		sel_20 -1
		sel_2 701
		sel_3 5
		sel_4 0
		sel_7 12
		sel_6 73
		sel_14 387
		sel_196 -1
	)

	(method (sel_57)
		(ScriptID 4 0) ; unknown_4_0
		(gGameControls sel_102:)
		((ScriptID 4 0) sel_57:) ; unknown_4_0
	)
)

(instance unknown_700_8 of ControlIcon
	(properties
		sel_20 -1
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

(instance unknown_700_9 of ControlIcon
	(properties
		sel_20 -1
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

(instance unknown_700_10 of Code
	(properties
		sel_20 -1
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

