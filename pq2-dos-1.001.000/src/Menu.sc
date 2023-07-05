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
		(AddMenu { Speed } {Faster`+:Normal`=:Slower`-})
		(AddMenu { Sound } {Volume...`^v:Turn Off`#2=1})
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'quit[/game]')
		(SetMenu 769 109 'pause[/game]')
		(SetMenu 770 109 'inventory')
		(SetMenu 1026 109 'normal[/speed]')
		(SetMenu 773 109 'load,load[/9mm]')
		(SetMenu 774 109 'draw,gunbelt[/9mm]')
		(SetMenu 775 109 'fire[/9mm]')
		(= global105 777)
	)

	(method (handleEvent event &tmp [temp0 3] temp3 [temp4 320] temp324)
		(switch (super handleEvent: event)
			(257
				(Print
					(Format @temp4 997 0 gVersion) ; "Designed by:    Jim Walls Illustrated by:   Vu Nguyen           Cheryl Cornelius Programmed by:  Jerry Shaw           Bob Fischbach           David Slayback           Bob Heitman           Mickie Lee           Chris Hoyt Music by:      Mark Seibert Q.A. by:       D.J.,B.W.,K.S.,R.B.           K.W.,R.M.,C.B. & J.C.    Version %s"
					#title
					{Police Quest II - "The Vengeance"}
					#width
					180
					#font
					gSmallFont
					#at
					-1
					20
					#icon
					999
					2
					0
				)
			)
			(258
				(Print 997 1 #font gSmallFont) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Select the outlined item with <Enter> and use Tab and Shift-Tab to move between choices. Or click with the mouse to select an item. ESC always cancels."
			)
			(513
				(gGame save:)
			)
			(514
				(gGame restore:)
			)
			(516
				(if (Print 997 2 #button {Restart} 1 #button {Continue} 0 #icon 999 0 0) ; "Do you really want to  restart your game?"
					(gGame restart:)
				)
			)
			(517
				(= gQuit
					(Print 997 3 #button {Quit} 1 #button {Continue} 0 #icon 999 0 0) ; "Are you really turning   in your badge?"
				)
			)
			(769
				(= temp324 (Sound pause: 1))
				(Print 997 4 #title {Game Paused} #icon 999 1 0 #button {Let's roll.} 1) ; "Every cop needs a 10-7 (break) now and then. Keith will smoke a cigarette until you return."
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
				(gGame setSpeed: (-- gSpeed))
			)
			(1026
				(gGame setSpeed: 6)
			)
			(1027
				(gGame setSpeed: (++ gSpeed))
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

