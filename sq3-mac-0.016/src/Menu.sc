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
		(AddMenu { \01 } {About game`^a :Help`#1 :VaporCalc`#0 })
		(AddMenu
			{ File }
			{Restart Game`^n :Restore Game`^o :--! :Close`#0 :--! :Save Game`^s :--! :Quit`^q }
		)
		(AddMenu
			{ Edit }
			{Undo`^z :--! :Cut`^x :Copy`^c :Paste`^v :Clear`#5 :Select All`#4 }
		)
		(AddMenu
			{ Action }
			{Pause Game`^p :Inventory`^I :Retype`#3 :--! :Boss Key`^b }
		)
		(AddMenu { Speed } {Change...`#0 :--! :Faster`[ :Normal`] :Slower`\ })
		(AddMenu { Sound } {Volume...`#0 :Sound Off`#2=1 })
	)

	(method (handleEvent event &tmp i str [str2 201])
		(switch (super handleEvent: event (User blocks:))
			(257
				(Print
					(Format
						@str2
						{"THE PIRATES OF PESTULON"\nCreated and Written by\nMark Crowe and Scott Murphy\nProgrammed by Scott Murphy,\nDoug Oldfield, Ken Koch, Chris Smith\nGraphics by Mark Crowe\nDevelopment System by Jeff Stephenson,\nBob Heitman, Pablo Ghenis, Stuart Goldstein\nMusic by Bob Siebenberg\nSound FX & Music Editing by Mark Seibert\nMacintosh version by \nJohn Hartin, John Rettig, John Crane\nVersion %s}
						gVersion
					)
					#font
					4
					#title
					{Space Quest III}
				)
			)
			(258
				(Print
					{      DURING THE GAME:\nClick at the top of the screen to use the menus. Additional shortcuts are shown there.\n\n     IN DIALOG WINDOWS:\nEnter selects the outlined item, or click on items with the mouse. ESC always cancels. }
					#font
					4
				)
			)
			(259
				(= global251 1)
			)
			(518
				(if global193
					(Print 997 0) ; "Sorry. Not now."
				else
					(gGame save:)
				)
			)
			(514
				(gGame restore:)
			)
			(513
				(if
					(Print ; "You either just got snuffed or you can't get enough of a truly great game. Am I right?"
						997
						1
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
			(520
				(if (!= gCurRoomNum 290)
					(= gQuit
						(Print ; "Leaving so soon? We'll be anxiously (yawn) awaiting your next visit. Be seeing you."
							997
							2
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
			(1025
				(= i (Sound pause: 1))
				(Print ; "Fine. Pause. Just don't be taking too long, OK? We don't want any babies playing this game."
					997
					3
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
			(1026
				(gInventory showSelf: gEgo)
			)
			(1027
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
			)
			(1029
				(Print 997 4) ; "Oh. I get it. You don't want your boss to know you've been playing Space Quest ]I[."
				(Print
					(Format
						@str2
						{In fact, you don't want your boss to know that you've been playing Space Quest ]I[ for %d hours, %d minutes and %d seconds.}
						global228
						global227
						global226
					)
				)
				(Print 997 5) ; "That's a good idea but I'm afraid that, being the good company men that we are, we can't help you cheat like that. Sorry."
			)
			(1281
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
			(1283
				(if (> gSpeed 1)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(1284
				(gGame setSpeed: 5)
			)
			(1285
				(if (< gSpeed 16)
					(gGame setSpeed: (++ gSpeed))
				)
			)
			(1537
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
			(1538
				(if (GetMenu 1538 113)
					(DoSound sndSET_SOUND 0)
					(SetMenu 1538 113 0 110 {Sound on})
				else
					(DoSound sndSET_SOUND 1)
					(SetMenu 1538 113 1 110 {Sound off})
				)
			)
		)
	)
)

