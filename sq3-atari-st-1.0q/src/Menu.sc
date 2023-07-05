;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use User)

(class TheMenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About game`^a :Help`#1 :VaporCalc`^c })
		(AddMenu
			{ File }
			{Save Game`#5 :Restore Game`#7 :--! :Restart Game`#9 :Quit`^q }
		)
		(AddMenu
			{ Action }
			{Pause Game`^p :Inventory`^I :Retype`#3 :--! :Boss Key`^b }
		)
		(AddMenu { Speed } {Change...`^s :--! :Faster`+ :Normal`= :Slower`- })
		(AddMenu { Sound } {Volume...`^v :Sound Off`#2=1 })
		(SetMenu 513 109 'save')
		(SetMenu 514 109 'restore')
		(SetMenu 516 109 'restart')
		(SetMenu 517 109 'quit')
		(SetMenu 769 109 'pause')
		(SetMenu 770 109 'inventory')
		(SetMenu 1028 109 'normal')
		(SetMenu 1027 109 'faster')
		(SetMenu 1029 109 'slower')
		(SetMenu 258 109 'aid')
	)

	(method (handleEvent event &tmp i str [str2 201])
		(switch (super handleEvent: event (User blocks:))
			(257
				(Print
					(Format @str2 997 0 gVersion) ; ""THE PIRATES OF PESTULON" Created and Written by Mark Crowe and Scott Murphy Programmed by Scott Murphy, Doug Oldfield, Ken Koch, Chris Smith Graphics by Mark Crowe Development System by Jeff Stephenson, Bob Heitman, Pablo Ghenis, Stuart Goldstein Music by Bob Siebenberg Sound FX & Music Editing by Mark Seibert Version %s"
					#font
					3
					#mode
					1
					#title
					{Space Quest \0b}
				)
			)
			(258
				(Print 997 1 #font 3) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Enter selects the outlined item, or click on items with the mouse. Tab and Shift-Tab move between choices. ESC always cancels."
			)
			(259
				(= global251 1)
			)
			(513
				(if global193
					(Print 997 2) ; "Sorry. Not now."
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
						3
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
							4
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
				(= i (Sound pause: 1))
				(Print ; "Fine. Pause. Just don't be taking too long, OK? We don't want any babies playing this game."
					997
					5
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
				(DoSound sndPAUSE i)
			)
			(770
				(gInventory showSelf: gEgo)
			)
			(771
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
			)
			(773
				(Print 997 6) ; "Oh. I get it. You don't want your boss to know you've been playing Space Quest ]I[."
				(Print
					(Format
						@str2
						{In fact, you don't want your boss to know that you've been playing Space Quest ]I[ for %d hours, %d minutes and %d seconds.}
						global228
						global227
						global226
					)
				)
				(Print 997 7) ; "That's a good idea but I'm afraid that, being the good company men that we are, we can't help you cheat like that. Sorry."
			)
			(1025
				(if (!= (= str (GetNumber {Speed (1 - 16)?} gSpeed)) -1)
					(if (< str 1)
						(= str 1)
					)
					(if (> str 16)
						(= str 16)
					)
					(gGame setSpeed: str)
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
						(= str
							(GetNumber {Volume (1 - 16)?} (+ 1 (DoSound sndVOLUME)))
						)
						-1
					)
					(if (< (-- str) 0)
						(= str 0)
					)
					(if (> str 15)
						(= str 15)
					)
					(DoSound sndVOLUME str)
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

