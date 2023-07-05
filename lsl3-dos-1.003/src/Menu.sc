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
	fermata
)

(class TheMenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About LSL3`^a:Help`#1})
		(AddMenu
			{ File }
			{Save Game`#5:Restore Game`#7:Auto Save`#4:--! :Restart Game`#9:Quit`^q}
		)
		(AddMenu
			{ Action }
			{Pause Game`^p:Inventory`^I:Retype`#3:--! :Colors`^c:--! :Boss Key`^b :Expletive`^x}
		)
		(AddMenu { Speed } {Change...`^s:--!:Faster`+:Normal`=:Slower`-})
		(AddMenu { Sound } {Volume...`^v:Turn Off`#2=1})
		(SetMenu 1282 110 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(if (< (Graph grGET_COLOURS) 9)
			(SetMenu 773 32 0)
		else
			(SetMenu 773 109 '/color')
		)
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 517 109 'restart[/game]')
		(SetMenu 518 109 'done[/game]')
		(SetMenu 769 109 'delay[/game]')
		(SetMenu 770 109 'all')
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 [temp4 220])
		(switch (= temp0 (super handleEvent: event))
			(257
				(Print ; ""Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals!" Designed by Al Lowe Programmed by Al Lowe and Carlos Escobar Graphics by William Skirvin and Roger Hardy"
					997
					0
					#font
					gSmallFont
					#mode
					1
					#title
					{An Al Lowe Production}
					#icon
					51
					0
					0
				)
				(Print
					(Format @temp4 997 1 gVersion) ; "Sierra's Creative Interpreter by Jeff Stephenson, Bob Heitman, Pablo Ghenis, and Stuart Goldstein Music Composed and Performed by Mike Dana Sound Effects by Rob Atesalp Atari ST Translation by Corey Cole Amiga Translation by Robert Lindsley Quality Assurance led by Robin Bradley Version %s October 27, 1989"
					#font
					gSmallFont
					#mode
					1
					#title
					{The Cast of Thousands}
					#at
					-1
					30
					#width
					234
				)
				(Format ; "%s"
					@gFilthLevelBuffer
					997
					2
					(switch gFilthLevel
						(4 {Totally Raunchiest})
						(3 {Really Filthy})
						(2 {Pretty Dirty})
						(1 {Rather Risque})
						(else {Mother Goose})
					)
				)
				(Print
					(cond
						(gGameHours
							(Format ; "How could you play at the "%s Level" for %d hour%s, %d minute%s and %d second%s and only score %d point%s?!"
								@temp4
								997
								3
								@gFilthLevelBuffer
								gGameHours
								(if (== gGameHours 1) {} else {s})
								gGameMinutes
								(if (== gGameMinutes 1) {} else {s})
								gGameSeconds
								(if (== gGameSeconds 1) {} else {s})
								gScore
								(if (== gScore 1) {} else {s})
							)
						)
						(gScore
							(Format ; "You've been playing this game at the "%s Level" for %d minute%s and %d second%s and you've only scored %d point%s?!"
								@temp4
								997
								4
								@gFilthLevelBuffer
								gGameMinutes
								(if (== gGameMinutes 1) {} else {s})
								gGameSeconds
								(if (== gGameSeconds 1) {} else {s})
								gScore
								(if (== gScore 1) {} else {s})
							)
						)
						(else
							(Format ; "You've been playing this game at the "%s Level" for %d minute%s and %d second%s and you haven't scored a single point?"
								@temp4
								997
								5
								@gFilthLevelBuffer
								gGameMinutes
								(if (== gGameMinutes 1) {} else {s})
								gGameSeconds
								(if (== gGameSeconds 1) {} else {s})
							)
						)
					)
					#font
					gSmallFont
					#mode
					1
					#title
					{Get a Life!}
				)
			)
			(258
				(Print 997 6 #font gSmallFont #at 10 -1 #width 290) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Enter selects the outlined item, or click on items with the mouse. Tab and Shift-Tab move between choices. ESC always cancels."
				(Print 997 7 #font gSmallFont) ; "If you really need help, pick up a copy of the "Passionate Patti" hint book at your software dealer."
			)
			(513
				(if (TestFlag 3)
					(Print 997 8 #title {Not now, I have a headache!}) ; "Sorry, but you can not save your game at this time. Please try again later."
				else
					(gGame save:)
					(= gAsMinutes 0)
					(= gAsSeconds 0)
				)
			)
			(514
				(gGame restore:)
			)
			(515
				(if
					(>
						0
						(= gAutoSaveMinutes
							(GetNumber {Minutes Between Reminders:} gAutoSaveMinutes)
						)
					)
					(= gAutoSaveMinutes 0)
				)
			)
			(517
				(if
					(Print ; "Are you serious? You want to start all the way back at the beginning again?"
						997
						9
						#title
						{Restart}
						#icon
						57
						0
						gEgoIsPatti
						#font
						gBigFont
						#button
						{Restart}
						1
						#button
						{ Oops }
						0
					)
					(gGame restart:)
				)
			)
			(518
				(= gQuit
					(Print
						(Format ; "Quit? Now? When you're doing so well? Why, you're almost up to %d points!"
							@temp4
							997
							10
							(Random (+ gScore 5) (+ gScore 50))
						)
						#title
						{Quit}
						#icon
						55
						0
						gEgoIsPatti
						#font
						gBigFont
						#button
						{ Quit }
						1
						#button
						{ Oops }
						0
					)
				)
			)
			(769
				(= fermata (Sound pause: 1))
				(Print ; "So what am I supposed to do, just stand here while you do something else? Oh, all right. I'll just hold my breath until you return..."
					997
					11
					#title
					{This game is paused.}
					#icon
					50
					0
					gEgoIsPatti
					#font
					gBigFont
					#button
					{Stop your whining!}
					1
				)
				(Sound pause: fermata)
			)
			(770
				(if (HaveMem 1024)
					(gInventory showSelf: gEgo)
				)
			)
			(771
				(event claimed: 0 type: evKEYBOARD message: (User echo:))
			)
			(773
				(for
					((= temp2 16))
					(and (u> temp2 15) (!= temp2 -1))
					((= temp2 (GetNumber {New Text Color: (0-15)})))
				)
				(if (!= temp2 -1)
					(for
						((= temp3 16))
						(and (!= temp3 -1) (or (u> temp3 15) (== temp3 temp2)))
						((= temp3 (GetNumber {New Background Color: (0-15)})))
					)
					(if (!= temp3 -1)
						(= gTextColor temp2)
						(= gBackgroundColor temp3)
					)
				)
				(gTheWindow color: gTextColor back: gBackgroundColor)
			)
			(775
				(gCurRoom newRoom: 90)
			)
			(776
				(GetInput
					(Format @temp4 gExpletive)
					38
					{Enter your favorite expletive:}
				)
				(if (> (StrLen @temp4) 4)
					(Format gExpletive @temp4)
				)
			)
			(1025
				(if (HaveMem 2048)
					(= temp1
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
					(gGame setSpeed: (- 16 temp1))
					(DisposeScript 987)
				)
			)
			(1027
				(if (> gSpeed (^ $0001 (= temp1 gDebugging)))
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
				(if (HaveMem 2048)
					(= temp1
						((Gauge new:)
							description:
								{Use the mouse or the left and right arrow keys to adjust the volume.}
							text: {Sound Volume}
							normal: 15
							higher: {Louder}
							lower: {Softer}
							doit: (DoSound sndVOLUME temp1) ; UNINIT
						)
					)
					(DoSound sndVOLUME temp1)
					(DisposeScript 987)
				)
			)
			(1282
				(= temp1 (DoSound sndSET_SOUND))
				(DoSound sndSET_SOUND (not temp1))
				(if temp1
					(SetMenu 1282 110 {Turn On})
					(Print 997 12) ; "Sound is off."
				else
					(SetMenu 1282 110 {Turn Off})
					(Print 997 13) ; "Sound is on."
				)
			)
		)
	)
)

