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
		(SetMenu 774 113 0 110 {Turn on%j\c2\b9\d9})
	else
		(DoSound sndSET_SOUND 1)
		(SetMenu 774 113 1 110 {Turn off%j\b9\bd})
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
			{ \01 %j \01 }
			(if 81
				{About Glory I %j\b8\b4\bd\c4 \cc\ab\b0 \b8\de\db\b0\d8\a8 \c6\c2\b2\c3 `^g :Help%j\cd\d9\cc\df`#1 :Language%j\b9\de\dd\ba\de \be\dd\c0\b8`^l}
			else
				{About Glory I %j\b8\b4\bd\c4 \cc\ab\b0 \b8\de\db\b0\d8\a8 \c6\c2\b2\c3 `^g :Help%j\cd\d9\cc\df`#1}
			)
		)
		(AddMenu
			{ File %j \cc\a7\b2\d9 }
			{Save Game%j\be\b0\cc\de \b9\de\b0\d1`#5 :Restore Game%j\d8\bd\c4\b1 \b9\de\b0\d1`#7 :--! :Restart Game%j\d8\bd\c0\b0\c4 \b9\de\b0\d1`#9 :Quit%j\d4\d2\d9`^q}
		)
		(AddMenu
			{ Game %j \b9\de\b0\d1 }
			{Faster Animation%j\b1\c6\d2\a6\ca\d4\b8\bd\d9`+ :Normal Animation%j\cc\c2\b3\c9\ca\d4\bb`= :Slower Animation%j\b1\c6\d2\a6\b5\bf\b8\bd\d9`-:--! :Sound Volume%j\bb\b3\dd\c4\de\c1\ae\b3\be\c2...`^v :Turn Off Sound%j\bb\b3\dd\c4\de\a6\b9\bd`#2=1}
		)
		(AddMenu
			{ Action %j \b1\b8\bc\ae\dd }
			{Pause Game%j\b2\c1\bc\de\b7\ad\b3\bc`^p :Repeat%j\d8\cb\df\b0\c4`#3}
		)
		(AddMenu
			{ Information %j \b2\dd\cc\ab\d2\b0\bc\ae\dd }
			{Inventory%j\b2\dd\cd\de\dd\c4\d8\b0`^I :Char Sheet%j\b7\ac\d7\b8\c0\b0\bc\b0\c4`^S :--! :Time/Day%j\bc\de\b6\dd / \cb\c2\de\b9`^T}
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
					(Format @temp4 997 0 gVersion gVersion) ; "Written and Directed by: LORI ANN COLE Illustrated by: KENN NISHIUYE, JERRY MOORE, JEFF CROWE and CINDY WALKER Programmed by: BOB FISCHBACH, COREY COLE, LARRY SCOTT and JERRY SHAW Original Music by: MARK SEIBERT Version %s Copyright 1989 Sierra On-Line, Inc.%%j\c3\de\bb\de\b2\dd & \c3\de\a8\da\b8\c4 : \db\b0\d8\b0 \b1\dd \ba\b0\d9 \b2\d7\bd\c4 : \b9\dd \c6\bc\b3\b4\a4 \bc\de\aa\d8\b0 \d1\b0\b1 \bc\de\aa\cc \b8\db\b3\a4 \bc\dd\c3\de\a8 \b3\ab\b0\b6\b0 \cc\df\db\b8\de\d7\d1 : \ce\de\cc\de \cc\a8\bc\ad\ca\de\af\b8\a4 \ba\b0\d8\b0 \ba\b0\d9 \d7\d8\b0 \bd\ba\af\c4\a4 \bc\de\aa\d8\b0 \bc\ae\b0 \d0\ad\b0\bc\de\af\b8 : \cf\b0\b8 \bc\b0\ca\de\b0\c4 \ca\de\b0\bc\de\ae\dd : %s \ba\cb\df\b0\d7\b2\c4 1989 \bc\b4\d7 \b5\dd\d7\b2\dd K.K"
					80
					{  Quest for Glory I Credits  %j  \b8\b4\bd\c4 \cc\ab\b0 \b8\de\db\b0\d8\a8 \b8\da\bc\de\af\c4  }
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
					(Format @temp4 997 1) ; "Development System by: JEFF STEPHENSON, ROBERT E. HEITMAN, PABLO GHENIS, STUART GOLDSTEIN, and COREY COLE Quality Assurance by: MIKE PICKHINKE, SHARON HOBAN-SMITH, Godzilla, Genghis Khan, and the rest of the gang.%%j\bc\bd\c3\d1 : \bc\de\aa\cc \bd\c3\a8\b0\cc\de\dd\bf\dd \db\ca\de\b0\c4 \ca\b2\c4\cf\dd \ca\df\cc\de\db \b9\de\c6\bd\a4 \ba\b0\d8\b0 \ba\b0\d9 \bd\c1\ad\b1\b0\c4 \ba\de\b0\d9\c4\de\bd\c0\b2\dd \c3\bd\c4\cc\df\da\b0\d4\b0: \cf\b2\b8 \cb\df\b7\dd\b7\b0 \bc\ac\db\dd \ce\b0\ca\de\dd\bd\d0\bd \ba\de\bc\de\d7\a4 \bc\de\dd\b7\de\bd\b6\dd \bf\bc\c3 \bf\c9\ce\b6\c9 \c5\b6\cf\c0\c1"
					80
					{And last, but not least...%j\bf\bc\c3\bb\b2\ba\de\c6 ...}
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
					(Format @temp4 997 2 gVersion gVersion) ; "Japanese Executive Producer: EIJI NAGANO Japanese System Development by: PABLO GHENIS Japanese Conversion by: PABLO GHENIS, YOKO HAYASHI GARY KAMIGAWACHI, MICKIE LEE Japanese Translation by: AKIKO MAEDA SKJELLERUP Quality Assurance by: YOKO HAYASHI,GARY KAMIGAWACHI MIKE PICKHINKE Version %s Copyright 1989,1990 Sierra On-Line, Inc.%%j\cc\df\db\c3\de\ad\b0\bb\b0 : \c5\b6\de\c9 \b4\b2\bc\de \bc\bd\c3\d1 : \ca\df\cc\de\db \b9\de\c6\bd \cc\df\db\b8\de\d7\d1 : \ca\df\cc\de\db \b9\de\c6\bd\a4 \b9\de\b0\d8\b0 \b6\d0\b6\de\dc\c1 \ca\d4\bc \d6\b3\ba\a4 \d0\af\b7\b0 \d8\b0 \c4\d7\dd\bd\da\b0\bc\ae\dd : \bd\b9\db\b5\cc\df \cf\b4\c0\de \b1\b7\ba \c3\bd\c4\cc\df\da\b0\d4\b0 : \ca\d4\bc \d6\b3\ba\a4 \b9\de\b0\d8\b0 \b6\d0\b6\de\dc\c1 \ca\de\b0\bc\de\ae\dd %s \ba\cb\df\b0\d7\b2\c4 1989, 1990 \bc\b4\d7\b5\dd\d7\b2\dd\bc\de\ac\ca\df\dd"
					80
					{  Japanese Version Credits  %j  \bc\de\ac\ca\df\c6\b0\bd\de \ca\de\b0\bc\de\ae\dd \b8\da\bc\de\af\c4  }
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
							{Language preferences%j\cc\df\da\b2\bc\c0\b2 \b9\de\dd\ba\de}
							#button
							{OK%jOK}
							0
							#button
							(if (!= temp455 1)
								{English\nmessages%j\b4\b2\ba\de\c9\n\d2\af\be\b0\bc\de}
							else
								{Japanese\nmessages%j\c6\ce\dd\ba\de\c9\n\d2\af\be\b0\bc\de}
							)
							1
							#button
							(if temp456
								{No\nsubtitles%j\bc\de\cf\b8\c5\bc}
							else
								{subtitles%j\bc\de\cf\b8\c2\b7}
							)
							2
							#button
							(if (!= (gGame parseLang:) 1)
								{ English \nInput%j\b4\b2\ba\de\c3\de\n\c6\ad\b3\d8\ae\b8}
							else
								{Japanese\nInput%j\c6\ce\dd\ba\de\n\c6\ad\b3\d8\ae\b8}
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
						{Restart%j\d8\bd\c0\b0\c4}
						1
						#button
						{Continue%j\c2\c2\de\b9\d9}
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
								{Volume (1 - 16)?%j\ce\de\d8\ad\b0\d1 (1 - 16)?}
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
					{Game Paused%j\b2\c1\bc\de\b7\ad\b3\bc}
					#icon
					800
					0
					0
					#button
					{Let's be a hero%j\cb\b0\db\b0 \c6 \c5\db\b3\d6}
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

