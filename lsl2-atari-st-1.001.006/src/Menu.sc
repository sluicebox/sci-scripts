;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use Gauge)
(use Sound)
(use User)

(local
	oldPause
)

(class TheMenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About LSL2`^a:Help`#1})
		(AddMenu
			{ File }
			{Save Game`#5:Restore Game`#7:--! :Restart Game`#9:Quit`^q}
		)
		(AddMenu
			{ Action }
			{Pause Game`^p:Inventory`^I:Retype`#3:--! :Boss Key`^b:Filth Level`^f:Trite Phrase`^t}
		)
		(AddMenu { Speed } {Change...`^s:--!:Faster`+:Normal`=:Slower`-})
		(AddMenu { Sound } {Volume...`^v:Turn Off`#2=1})
		(SetMenu 1282 110 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(SetMenu 513 109 'rescue[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'stop[/game]')
		(SetMenu 769 109 'pause[/game]')
		(SetMenu 770 109 'all')
	)

	(method (handleEvent event &tmp msg i [string2 100])
		(switch (= msg (super handleEvent: event))
			(257
				(Print ; ""Leisure Suit Larry goes Looking for Love (in Several Wrong Places)" Created, Designed, Written and Programmed by Al Lowe Graphics by Bill Skirvin, Bonnie Borucki and Douglas Herring"
					997
					0
					#font
					gSmallFont
					#mode
					1
					#title
					{An Al Lowe Production}
					#icon
					118
					0
					0
				)
				(Print
					(Format @gString 997 1 gVersion) ; "Sierra's Creative Interpreter developed by Jeff Stephenson, Bob Heitman, Pablo Ghenis, and Stuart Goldstein Graphics Systems by Bob Heitman Music composed and performed by Al Lowe Version %s, December 2, 1988"
					#font
					gSmallFont
					#mode
					1
					#at
					-1
					50
					#width
					234
				)
				(Print
					(if gGameHours
						(Format @gString 997 2 gGameHours gGameMinutes gGameSeconds) ; "You've been playing for %d hours, %d minutes and %d seconds."
					else
						(Format @gString 997 3 gGameMinutes gGameSeconds) ; "You've been playing for %d minutes and %d seconds."
					)
					#font
					gSmallFont
					#mode
					1
				)
			)
			(258
				(Print 997 4 #font gSmallFont #at 15 -1 #width 280) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Enter selects the outlined item, or click on items with the mouse. Tab and Shift-Tab move between choices. ESC always cancels."
			)
			(513
				(gGame save:)
			)
			(514
				(gGame restore:)
			)
			(516
				(if
					(Print ; "You mean you want to start over from the very beginning?"
						997
						5
						#title
						{Restart}
						#icon
						112
						0
						0
						#font
						gBigFont
						#button
						{ Oops }
						0
						#button
						{Restart}
						1
					)
					(gGame restart:)
				)
			)
			(517
				(= gQuit
					(Print ; "Are you just going to quit and leave me here all alone like this?"
						997
						6
						#title
						{Quit}
						#icon
						111
						0
						0
						#font
						gBigFont
						#button
						{Quit}
						1
						#button
						{Oops}
						0
					)
				)
			)
			(769
				(= oldPause (Sound pause: 1))
				(Print ; "Sure, you go ahead. I'll just wait in here until you get back..."
					997
					7
					#title
					{This game is paused.}
					#icon
					119
					0
					0
					#font
					gBigFont
					#button
					{Ok. I'm back.}
					1
				)
				(Sound pause: oldPause)
			)
			(770
				(if (not (HaveMem 1024))
					(Print 997 8) ; "Inventory cannot be displayed at this time."
				else
					(gInventory showSelf: gEgo)
				)
			)
			(771
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
			)
			(773
				(gCurRoom newRoom: 9)
			)
			(774
				(if (< (MemoryInfo 1) 2048) ; FreeHeap
					(NotNow) ; "Not now!"
				else
					(cond
						(
							(==
								(= gFilthLevel
									((Gauge new:)
										description:
											{Use the mouse or the left and right arrow keys to suit your taste.}
										text: {Filth-O-Meter}
										higher: {Dirtier}
										lower: {Cleaner}
										doit: gFilthLevel
									)
								)
								0
							)
							(Print 997 9) ; "Perhaps you should buy "Mother Goose!""
						)
						((<= gFilthLevel 4)
							(Print 997 10) ; "Thank you, I hate it when you talk dirty!"
						)
						((> gFilthLevel 14)
							(Print 997 11) ; "Why you dirty little bastard!"
						)
						(else
							(Print 997 12) ; "You're a nasty som'bitch, ain'cha?"
						)
					)
					(DisposeScript 987)
				)
			)
			(775
				(GetInput
					(Format @gString gTritePhrase)
					38
					{Enter your favorite trite phrase:}
				)
				(if (> (StrLen @gString) 4)
					(Format gTritePhrase @gString)
				)
			)
			(1025
				(if (not (HaveMem 2048))
					(Print 997 13) ; "Speed cannot be changed at this time."
				else
					(= i
						((Gauge new:)
							description:
								{Use the mouse or the left and right arrow keys to select the speed of moving characters.}
							text: {Animation Speed}
							normal: 10
							higher: {Faster}
							lower: {Slower}
							doit: (- 16 gSpeed)
						)
					)
					(gGame setSpeed: (- 16 i))
					(DisposeScript 987)
				)
			)
			(1027
				(if (> gSpeed (^ $0001 (= i gDebugging)))
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(1028
				(gGame setSpeed: 6)
			)
			(1029
				(gGame setSpeed: (++ gSpeed))
			)
			(1281
				(if (not (HaveMem 2048))
					(Print 997 14) ; "Volume cannot be changed at this time."
				else
					(= i
						((Gauge new:)
							description:
								{Use the mouse or the left and right arrow keys to adjust the volume.}
							text: {Sound Volume}
							normal: 15
							higher: {Louder}
							lower: {Softer}
							doit: (DoSound sndVOLUME)
						)
					)
					(DoSound sndVOLUME i)
					(DisposeScript 987)
				)
			)
			(1282
				(= i (DoSound sndSET_SOUND))
				(DoSound sndSET_SOUND (not i))
				(if i
					(SetMenu 1282 110 {Turn On})
					(Print 997 15) ; "Sound is off."
				else
					(SetMenu 1282 110 {Turn Off})
					(Print 997 16) ; "Sound is on."
				)
			)
			(else
				(if gDebugMenu
					(gDebugMenu doit: msg)
				)
			)
		)
	)
)

