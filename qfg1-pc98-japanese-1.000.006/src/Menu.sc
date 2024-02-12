;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Sound)
(use Save)
(use Game)
(use User)

(public
	proc997_0 0
)

(procedure (localproc_0 param1)
	(if (> argc 1)
		(Format (User inputLineAddr:) &rest)
	)
	(param1 claimed: 0 type: 4 message: (User echo:))
)

(procedure (proc997_0)
	(if (GetMenu 774 113)
		(DoSound sndSET_SOUND 0)
		(SetMenu 774 113 0 110 {Turn on})
	else
		(DoSound sndSET_SOUND 1)
		(SetMenu 774 113 1 110 {Turn off})
	)
)

(instance aWin of SysWindow
	(properties
		back 11
	)
)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu
			{ \01 }
			(if 81
				{About Glory I }
			else
				{About Glory I }
			)
		)
		(AddMenu
			{ File }
			{Save Game}
		)
		(AddMenu
			{ Game }
			{Faster Animation}
		)
		(AddMenu
			{ Action }
			{Pause Game}
		)
		(AddMenu
			{ Information }
			{Inventory}
		)
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 1025 109 'pause[/game]')
		(SetMenu 770 109 'normal[/speed]')
		(SetMenu 1281 109 '/inventory')
		(SetMenu 1284 109 'are<time<what')
	)

	(method (handleEvent event &tmp [temp0 3] temp3 [temp4 450] temp454 temp455 temp456)
		(switch (super handleEvent: event)
			(257
				(if (< global211 8)
					(aWin color: 0 back: 15)
				)
				(PrintSplit
					(Format @temp4 997 0 gVersion gVersion) ; "Written and Directed by: LORI ANN COLE Illustrated by: KENN NISHIUYE, JERRY MOORE, JEFF CROWE and CINDY WALKER Programmed by: BOB FISCHBACH, COREY COLE, LARRY SCOTT and JERRY SHAW Original Music by: MARK SEIBERT Version %s Copyright 1989 Sierra On-Line, Inc.%"
					80
					{  Quest for Glory I Credits  }
					30
					1
					70
					180
					33
					gSmallFont
					67
					-1
					20
					35
					aWin
				)
				(PrintSplit
					(Format @temp4 997 1) ; "Development System by: JEFF STEPHENSON, ROBERT E. HEITMAN, PABLO GHENIS, STUART GOLDSTEIN, and COREY COLE Quality Assurance by: MIKE PICKHINKE, SHARON HOBAN-SMITH, Godzilla, Genghis Khan, and the rest of the gang.%"
					80
					{And last, but not least...}
					30
					1
					70
					180
					33
					gSmallFont
					67
					-1
					20
					35
					aWin
				)
				(PrintSplit
					(Format @temp4 997 2 gVersion gVersion) ; "Japanese Executive Producer: EIJI NAGANO Japanese System Development by: PABLO GHENIS Japanese Conversion by: PABLO GHENIS, YOKO HAYASHI GARY KAMIGAWACHI, MICKIE LEE Japanese Translation by: AKIKO MAEDA SKJELLERUP Quality Assurance by: YOKO HAYASHI,GARY KAMIGAWACHI MIKE PICKHINKE Version %s Copyright 1989,1990 Sierra On-Line, Inc.%"
					80
					{  Japanese Version Credits  }
					30
					1
					70
					180
					33
					gSmallFont
					67
					-1
					20
					35
					aWin
				)
			)
			(258
				(PrintSplit 997 3 33 gSmallFont) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there. Click Right or Shift-Click Left Mouse Button on an object to look at it.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Select the outlined item with <Enter> and use Tab and Shift-Tab to move between choices. Or click with the mouse to select an item. ESC always cancels."
			)
			(259
				(= temp455 (gGame printLang:))
				(= temp456 (gGame subtitleLang:))
				(while
					(switch
						(Print
							(Format ; "Message Language : %s Subtitles : %s Input Language : %s%"
								@temp4
								997
								4
								(if (== temp455 1) {English} else {Japanese})
								(if temp456 {Yes} else {No})
								(if (== (gGame parseLang:) 1)
									{English}
								else
									{Japanese}
								)
								(if (== temp455 1)
									{\89p\8c\ea}
								else
									{\93\fa\96\{\8c\ea}
								)
								(if temp456
									{\8e\9a\96\8b\95t\82\ab}
								else
									{\8e\9a\96\8b\96\b3\82\b5}
								)
								(if (== (gGame parseLang:) 1)
									{\89p\8c\ea}
								else
									{\93\fa\96\{\8c\ea}
								)
							)
							#icon
							(gEgo view:)
							(gEgo loop:)
							(gEgo cel:)
							#title
							{Language preferences}
							#button
							{OK}
							0
							#button
							(if (!= temp455 1)
								{English\nmessages}
							else
								{Japanese\nmessages}
							)
							1
							#button
							(if temp456
								{No\nsubtitles}
							else
								{subtitles}
							)
							2
							#button
							(if (!= (gGame parseLang:) 1)
								{ English \nInput}
							else
								{Japanese\nInput}
							)
							3
						)
						(1
							(if temp456
								(SwapLangs)
							else
								(gGame
									printLang: (if (!= temp455 1) 1 else 81)
								)
							)
						)
						(2
							(gGame
								subtitleLang:
									(cond
										(temp456 0)
										((== temp455 1) 81)
										(else 1)
									)
							)
						)
						(3
							(gGame
								parseLang:
									(if (== (gGame parseLang:) 1) 81 else 1)
							)
						)
					)
					(= temp455 (gGame printLang:))
					(= temp456 (gGame subtitleLang:))
					(SL doit:)
				)
				1
			)
			(513
				(if (IsFlag 129)
					(gGame save:)
				)
			)
			(514
				(gGame restore:)
			)
			(516
				(if
					(Print ; "You can change your mind, if you have one."
						997
						5
						#button
						{Restart}
						1
						#button
						{Continue}
						0
						#icon
						800
						1
						3
					)
					(gGame restart:)
				)
			)
			(517
				(PromptQuit)
			)
			(769
				(if (> gSpeed 0)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(770
				(gGame setSpeed: 6)
			)
			(771
				(if (< gSpeed 16)
					(gGame setSpeed: (++ gSpeed))
				)
			)
			(773
				(if
					(!=
						(= temp3
							(GetNumber
								{Volume (1 - 16)?}
								(+ 1 (DoSound sndVOLUME))
							)
						)
						-1
					)
					(if (< (-- temp3) 0)
						(= temp3 0)
					)
					(if (> temp3 15)
						(= temp3 15)
					)
					(DoSound sndVOLUME temp3)
				)
			)
			(774
				(proc997_0)
			)
			(1025
				(= temp454 (Sound pause: 1))
				(Print ; "Every hero needs a break now and then. Have a nice nap."
					997
					6
					#title
					{Game Paused}
					#icon
					800
					0
					0
					#button
					{Let's be a hero}
					1
				)
				(Sound pause: temp454)
			)
			(1026
				(localproc_0 event)
			)
			(1281
				(cond
					((not (HaveMem 2000))
						(HighPrint 997 7) ; "Sorry, there's not enough room to see that here."
					)
					((not global104)
						((ScriptID 206 0) init: doit:) ; theInvSheet
					)
				)
			)
			(1282
				(cond
					((or (not (HaveMem 2000)) (== gCurRoomNum 95))
						(HighPrint 997 7) ; "Sorry, there's not enough room to see that here."
					)
					((not global104)
						((ScriptID 204 0) useWindow: 1 showBars: 1 init: doit:) ; theCharSheet
					)
				)
			)
			(1284
				(FindTime)
			)
			(1285
				(localproc_0 event {ask about })
			)
			(1286
				(localproc_0 event {look at })
			)
		)
		(if
			(and
				(event claimed:)
				gModelessDialog
				(or
					(== (gGame printLang:) 81)
					(== (gGame subtitleLang:) 81)
				)
			)
			(gModelessDialog dispose:)
		)
	)
)

