;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Save)
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
		(AddMenu { \01 } {About HQ `^h:Help`#1})
		(AddMenu
			{ File }
			{Save Game`#5:Restore Game`#7:--!:Restart Game`#9:Quit`^q}
		)
		(AddMenu
			{ Game }
			{Faster Animation`+:Normal Animation`=:Slower Animation`-:--!:Sound Volume...`^v:Turn Off Sound`#2=1}
		)
		(AddMenu
			{ Action }
			{Cast Spell`^c:Fight`^f:Escape`^e:--!:Pause Game`^p:Repeat`#3}
		)
		(AddMenu
			{ Information }
			{Inventory`^I:Char Sheet`^S:--!:Time/Day`^T:Ask about`^a:Look at`^l}
		)
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 1029 109 'pause[/game]')
		(SetMenu 770 109 'normal[/speed]')
		(SetMenu 1281 109 '/inventory')
		(SetMenu 1284 109 'are<time<what')
	)

	(method (handleEvent event &tmp [temp0 3] temp3 [temp4 300] temp304)
		(switch (super handleEvent: event)
			(257
				(if (< global211 8)
					(aWin color: 0 back: 15)
				)
				(Print
					(Format @temp4 997 0 gVersion) ; "Written and Directed by: LORI ANN COLE Illustrated by: KENN NISHIUYE, JERRY MOORE, JEFF CROWE and CINDY WALKER Programmed by: BOB FISCHBACH, COREY COLE, LARRY SCOTT and JERRY SHAW Original Music by: MARK SEIBERT Version %s Copyright 1989 Sierra On-Line, Inc."
					#title
					{__Hero's Quest I Credits__}
					#mode
					1
					#width
					160
					#font
					gSmallFont
					#at
					-1
					20
					#window
					aWin
				)
				(Print
					(Format @temp4 997 1) ; "Development System by: JEFF STEPHENSON, ROBERT E. HEITMAN, PABLO GHENIS, STUART GOLDSTEIN, and COREY COLE Quality Assurance by: MIKE PICKHINKE, SHARON HOBAN-SMITH, Godzilla, Genghis Khan, and the rest of the gang."
					#title
					{And last, but not least...}
					#mode
					1
					#width
					180
					#font
					gSmallFont
					#at
					-1
					20
					#window
					aWin
				)
			)
			(258
				(Print 997 2 #font gSmallFont) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there. Click Right or Shift-Click Left Mouse Button on an object to look at it.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Select the outlined item with <Enter> and use Tab and Shift-Tab to move between choices. Or click with the mouse to select an item. ESC always cancels."
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
				(if (Print 997 3 #button {Restart} 1 #button {Continue} 0 #icon 800 1 3) ; "You can change your mind  if you have one."
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
							(GetNumber {Volume (1 - 16)?} (+ 1 (DoSound sndVOLUME)))
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
				(localproc_0 event {cast })
			)
			(1026
				(localproc_0 event {fight })
			)
			(1027
				(localproc_0 event {escape })
			)
			(1029
				(= temp304 (Sound pause: 1))
				(Print ; "Every hero needs a break now and then. Have a nice nap."
					997
					4
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
				(Sound pause: temp304)
			)
			(1030
				(localproc_0 event)
			)
			(1281
				(cond
					((not (HaveMem 1500))
						(HighPrint 997 5) ; "Sorry, there's not enough room to see that here."
					)
					((not global104)
						((ScriptID 206 0) init: doit:) ; theInvSheet
					)
				)
			)
			(1282
				(cond
					((not (HaveMem 1500))
						(HighPrint 997 5) ; "Sorry, there's not enough room to see that here."
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
	)
)

