;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use rm13)
(use rm33)
(use Interface)
(use Sound)
(use User)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About PQ2 `^a:Help`#1})
		(AddMenu
			{ File }
			{Save Game`#5:Restore Game`#7:--! :Restart Game`#9:Quit`^q}
		)
		(AddMenu
			{ Action }
			{Pause Game`^p:Inventory`^I:Repeat`#3:--! :Load Gun`#6:Draw/Holster Gun`#8:Fire Gun`#0:--! :Enter/Exit Car`#4}
		)
		(AddMenu { Speed } {Set Speed`^s:--!:Faster`+:Normal`=:Slower`-})
		(AddMenu { Sound } {Volume...`^v:Turn Off`#2=1})
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'quit[/game]')
		(SetMenu 769 109 'pause[/game]')
		(SetMenu 770 109 'inventory')
		(SetMenu 1028 109 'normal[/speed]')
		(SetMenu 773 109 'load,load[/9mm]')
		(SetMenu 774 109 'draw,gunbelt[/9mm]')
		(SetMenu 775 109 'fire[/9mm]')
		(= global105 777)
	)

	(method (handleEvent event &tmp [temp0 3] temp3 [temp4 320] temp324)
		(switch (super handleEvent: event)
			(257
				(Print
					(Format @temp4 997 0 gVersion) ; "DESIGNED BY: Jim Walls ILLUSTRATED BY: Vu Nguyen, Cheryl Cornelius PROGRAMMED BY: David Slayback, Bob Fischbach, Jerry Shaw, Mickie Lee, Bob Heitman, Chris Hoyt MUSIC BY: Mark Seibert Version %s"
					#title
					{__Police Quest II Credits__}
					#mode
					1
					#width
					160
					#font
					gSmallFont
					#icon
					999
					2
					0
				)
				(Print
					(Format @temp4 997 1) ; "DEVELOPMENT SYSTEM BY: Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, Stuart Goldstein QUALITY ASSURANCE BY: Jennifer Cobb, Dennis Jonathan, Bridget Wight, Randy MacNeil, Kathy Sands, Jodi Shirk, Kim Woods, Chad Bye, Eddie Pearman, Robin Bradley"
					#title
					{And last, but not least...}
					#mode
					1
					#width
					180
					#font
					gSmallFont
					#icon
					999
					2
					0
				)
			)
			(258
				(Print 997 2 #font gSmallFont) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Select the outlined item with <Enter> and use Tab and Shift-Tab to move between choices. Or click with the mouse to select an item. ESC always cancels."
			)
			(513
				(if (HaveMem 1200)
					(Load rsSCRIPT 990)
					(Load rsSCRIPT 975)
					(gGame save:)
				else
					(Print 997 3) ; "You can't do that right now."
				)
			)
			(514
				(if (HaveMem 1200)
					(Load rsSCRIPT 990)
					(Load rsSCRIPT 975)
					(gGame restore:)
				else
					(Print 997 3) ; "You can't do that right now."
				)
			)
			(516
				(if (Print 997 4 #button {Restart} 1 #button {Continue} 0 #icon 999 0 0) ; "Do you really want to  restart your game?"
					(gGame restart:)
				)
			)
			(517
				(= gQuit
					(Print 997 5 #button {Quit} 1 #button {Continue} 0 #icon 999 0 0) ; "Are you really turning   in your badge?"
				)
			)
			(769
				(= temp324 (Sound pause: 1))
				(Print 997 6 #title {Game Paused} #icon 999 1 0 #button {Let's roll.} 1) ; "Every cop needs a 10-7 (break) now and then. Keith will smoke a cigarette until you return."
				(Sound pause: temp324)
			)
			(770
				(gInventory
					carrying: {You are carrying...}
					empty:
						{You have only your diving equipment.\nYou left everything else in the van.}
					showSelf: gEgo
				)
			)
			(771
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
			)
			(773
				(event claimed: 0 type: evKEYBOARD message: KEY_F6)
			)
			(774
				(event claimed: 0 type: evKEYBOARD message: KEY_F8)
			)
			(775
				(event claimed: 0 type: evKEYBOARD message: KEY_F10)
			)
			(777
				(cond
					((== gCurRoomNum 13)
						(proc13_1)
					)
					((== gCurRoomNum 33)
						(proc33_1)
					)
					((not global106)
						(= global132 1)
					)
				)
			)
			(1025
				(if (!= (= temp3 (GetNumber {Speed (1 - 16)?} gSpeed)) -1)
					(if (< temp3 1)
						(= temp3 1)
					)
					(if (> temp3 16)
						(= temp3 16)
					)
					(gGame setSpeed: temp3)
				)
			)
			(1027
				(if (> gSpeed 1)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(1028
				(gGame setSpeed: 6)
			)
			(1029
				(if (< gSpeed 20)
					(gGame setSpeed: (++ gSpeed))
				)
			)
			(1281
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

