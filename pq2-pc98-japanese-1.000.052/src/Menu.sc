;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use rm13)
(use rm33)
(use Interface)
(use Sound)
(use Game)
(use User)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About PQ2`^a :Help`#1 :English`^l :Subtitle Off`^j })
		(switch (gGame parseLang:)
			(1
				(SetMenu 259 113 0 110 {Japanese})
			)
			(81
				(SetMenu 259 113 1 110 {English})
			)
		)
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
		(SetMenu 514 109 'japanesereplace[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'japanesestop[/game]')
		(SetMenu 769 109 'pause[/game]')
		(SetMenu 770 109 'show,inventory[/inventory]')
		(SetMenu 1028 109 'normal[/speed]')
		(SetMenu 773 109 'japaneseput,japaneseput[/9mm,ammo,bullet]')
		(SetMenu 774 109 'draw,gunbelt,replace/9mm')
		(SetMenu 775 109 'fire[/9mm]')
		(= global105 777)
	)

	(method (handleEvent event &tmp [temp0 4] temp4 [temp5 320] temp325)
		(switch (super handleEvent: event)
			(257
				(Print
					(Format @temp5 997 0 gVersion) ; "DESIGNED BY: Jim Walls ILLUSTRATED BY: Vu Nguyen, Cheryl Cornelius PROGRAMMED BY: David Slayback, Mickie Lee, Jerry Shaw, Bob Fischbach, Bob Heitman, Chris Hoyt ORIGINAL MUSIC BY: Mark Seibert Version J%s"
					#title
					{__Police Quest II Credits__}
					#mode
					1
					#font
					gSmallFont
					#icon
					999
					2
					0
				)
				(Print
					(Format @temp5 997 1) ; "JAPANESE EXECUTIVE PRODUCER: Eiji Nagano JAPANESE DEVELOPMENT SYSTEM BY: Pablo Ghenis, Stuart Goldstein, Mickie Lee DEVELOPMENT SYSTEM BY: Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, Stuart Goldstein JAPANESE TRANSLATION BY: Akiko Maeda Skjellerup QUALITY ASSURANCE BY: Mike Harian, Dave Weiss, Sharon Simmons, Dennis Jonathan"
					#title
					{And last, but not least...}
					#mode
					1
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
				(if (== (gGame subtitleLang:) 0)
					(Print 997 3 #font gSmallFont) ; "VERBS     NOUNS look      key open     door close     locker exit      gun take     dispatch put      wallet unlock    drawer talk      woman search    around"
				else
					(Print 997 4)
					(Print 997 5)
				)
			)
			(259
				(if (GetMenu 259 113)
					(gGame parseLang: 1)
					(SetMenu 259 113 0 110 {Japanese})
				else
					(gGame parseLang: 81)
					(SetMenu 259 113 1 110 {English})
				)
				(SL doit:)
			)
			(260
				(if (GetMenu 260 113)
					(gGame subtitleLang: 81)
					(SetMenu 260 113 0 110 {Subtitle Off})
				else
					(gGame subtitleLang: 0)
					(SetMenu 260 113 1 110 {Subtitle On})
				)
			)
			(513
				(gGame save:)
			)
			(514
				(gGame restore:)
			)
			(516
				(if (Print 997 6 #button {Restart} 1 #button {Continue} 0 #icon 999 0 0) ; "Do you really want to  restart your game?"
					(gGame restart:)
				)
			)
			(517
				(= gQuit
					(Print 997 7 #button {Quit} 1 #button {Continue} 0 #icon 999 0 0) ; "Are you really turning   in your badge?"
				)
			)
			(769
				(= temp325 (Sound pause: 1))
				(Print 997 8 #title {Game Paused} #icon 999 1 0 #button {Let's roll.} 1) ; "Every cop needs a 10-7 (break) now and then. Keith will smoke a cigarette until you return."
				(Sound pause: temp325)
			)
			(770
				(gInventory
					carrying:
						{You are carrying...}
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
				(if (!= (= temp4 (GetNumber {Speed (1 - 16)?} gSpeed)) -1)
					(if (< temp4 1)
						(= temp4 1)
					)
					(if (> temp4 16)
						(= temp4 16)
					)
					(gGame setSpeed: temp4)
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
						(= temp4
							(GetNumber {Volume (1 - 16)?} (+ 1 (DoSound sndVOLUME)))
						)
						-1
					)
					(if (< (-- temp4) 0)
						(= temp4 0)
					)
					(if (> temp4 15)
						(= temp4 15)
					)
					(DoSound sndVOLUME temp4)
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

