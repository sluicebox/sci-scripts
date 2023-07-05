;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Sound)
(use Game)
(use User)

(class TheMenuBar of MenuBar
	(properties)

	(method (init)
		(if 49
			(AddMenu
				{ \01 }
				{About game}
			)
		else
			(AddMenu
				{ \01 }
				{About game}
			)
		)
		(AddMenu
			{ File }
			{Save Game}
		)
		(AddMenu
			{ Action }
			{Pause Game}
		)
		(AddMenu
			{ Speed }
			{Change...}
		)
		(AddMenu
			{ Sound }
			{Volume...}
		)
		(SetMenu 513 109 'save')
		(SetMenu 514 109 'restore')
		(SetMenu 516 109 'restart')
		(SetMenu 517 109 'quit')
		(SetMenu 769 109 'pause')
		(SetMenu 770 109 'inv,inv')
		(SetMenu 1028 109 'normal')
		(SetMenu 1027 109 'faster')
		(SetMenu 1029 109 'slower')
		(SetMenu 258 109 'aid,aid')
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 461] temp463 temp464)
		(switch (super handleEvent: event (User blocks:))
			(257
				(PrintSplit
					(Format @temp2 997 0 gVersion gVersion) ; ""THE PIRATES OF PESTULON" Created and Written by Mark Crowe and Scott Murphy Programmed by Scott Murphy, Doug Oldfield, Ken Koch, Chris Smith Graphics by Mark Crowe Development System by Jeff Stephenson, Bob Heitman, Pablo Ghenis, Stuart Goldstein Music by Bob Siebenberg Sound FX & Music Editing by Mark Seibert Version %s%"
					33
					3
					30
					1
					80
					{Space Quest \0b}
				)
				(PrintSplit ; "German Edition: Produced by Pablo Ghenis Translated by: Brigitte Burkertt-Hinojos and Sabine Duvall Program conversion by: Gary Kamigawachi and Sol Ackerman Graphics conversion by: Cheri Lloyd and Jeff Crowe Quality Assurance by: Robin Bradley, Mike Harian, Kevin Ray, Sabine Duvall and J\81rg Baumann Bilingual System by Pablo Ghenis"
					997
					1
					33
					3
					80
					{The Cast of Thousands}
					67
					-1
					30
					70
					(if (gGame subtitleLang:) 234 else 291)
					30
					1
				)
			)
			(258
				(PrintSplit 997 2 33 3) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Enter selects the outlined item, or click on items with the mouse. Tab and Shift-Tab move between choices. ESC always cancels."
			)
			(259
				(if (or (== gCurRoomNum 900) (== gCurRoomNum 1))
					(event claimed: 0)
				else
					(= global251 1)
				)
			)
			(260
				(= temp463 (gGame printLang:))
				(= temp464 (gGame subtitleLang:))
				(while
					(switch
						(Print ; "Speak your mind any way you want to:"
							997
							3
							#title
							{Language preferences}
							#icon
							602
							1
							0
							#font
							300
							#button
							{OK}
							0
							#button
							(if (!= temp463 1)
								{English\nmessages}
							else
								{German\nmessages}
							)
							1
							#button
							(if temp464
								{No\nsubtitles}
							else
								{subtitles}
							)
							2
							#button
							(if (== (gGame parseLang:) 1)
								{German\nInput}
							else
								{English\nInput}
							)
							3
						)
						(1
							(if temp464
								(SwapLangs)
							else
								(gGame
									printLang: (if (!= temp463 1) 1 else 49)
								)
							)
						)
						(2
							(gGame
								subtitleLang:
									(cond
										(temp464 0)
										((== temp463 1) 49)
										(else 1)
									)
							)
						)
						(3
							(gGame
								parseLang:
									(if (== (gGame parseLang:) 1) 49 else 1)
							)
						)
					)
					(= temp463 (gGame printLang:))
					(= temp464 (gGame subtitleLang:))
					(SL doit:)
				)
				1
			)
			(513
				(if global193
					(Print 997 4) ; "Sorry. Not now."
				else
					(gGame save:)
				)
			)
			(514
				(gGame restore:)
			)
			(516
				(if
					(Print ; "You either just got snuffed or you can't get enough of a truly great game. Am I right?"
						997
						5
						#title
						{Restart}
						#icon
						602
						1
						0
						#font
						300
						#button
						{Restart}
						1
						#button
						{Oops}
						0
					)
					(gGame restart:)
				)
			)
			(517
				(if (!= gCurRoomNum 290)
					(= gQuit
						(Print ; "Leaving so soon? We'll be anxiously (yawn) awaiting your next visit. Be seeing you."
							997
							6
							#title
							{Bailing Out?}
							#icon
							602
							1
							0
							#font
							300
							#button
							{Quit}
							1
							#button
							{Oops}
							0
						)
					)
				else
					(event claimed: 0)
				)
			)
			(769
				(= temp0 (Sound pause: 1))
				(Print ; "Fine. Pause. Just don't be taking too long, OK? We don't want any babies playing this game."
					997
					7
					#title
					{This game is paused.}
					#icon
					602
					1
					0
					#font
					300
					#button
					{Ok. I'm back.}
					1
				)
				(DoSound sndPAUSE temp0)
			)
			(770
				(gInventory showSelf: gEgo)
			)
			(771
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
			)
			(773
				(Print 997 8) ; "Oh. I get it. You don't want your boss to know you've been playing Space Quest ]I[."
				(Print
					(Format
						@temp2
						{In fact, you don't want your boss to know that you've been playing Space Quest ]I[ for %d hours, %d minutes and %d seconds.%}
						global228
						global227
						global226
						global228
						global227
						global226
					)
				)
				(Print 997 9) ; "That's a good idea but I'm afraid that, being the good company men that we are, we can't help you cheat like that. Sorry."
			)
			(1025
				(if
					(!=
						(= temp1
							(GetNumber
								{Speed (1 - 16)?}
								gSpeed
							)
						)
						-1
					)
					(if (< temp1 1)
						(= temp1 1)
					)
					(if (> temp1 16)
						(= temp1 16)
					)
					(gGame setSpeed: temp1)
				)
			)
			(1027
				(if (> gSpeed 1)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(1028
				(gGame setSpeed: 5)
			)
			(1029
				(if (< gSpeed 16)
					(gGame setSpeed: (++ gSpeed))
				)
			)
			(1281
				(if
					(!=
						(= temp1
							(GetNumber
								{Volume (1 - 16)?}
								(+ 1 (DoSound sndVOLUME))
							)
						)
						-1
					)
					(if (< (-- temp1) 0)
						(= temp1 0)
					)
					(if (> temp1 15)
						(= temp1 15)
					)
					(DoSound sndVOLUME temp1)
				)
			)
			(1282
				(if (GetMenu 1282 113)
					(DoSound sndSET_SOUND 0)
					(SetMenu 1282 113 0 110 {Turn on})
				else
					(DoSound sndSET_SOUND 1)
					(SetMenu 1282 113 1 110 {Turn off})
				)
			)
		)
	)
)

