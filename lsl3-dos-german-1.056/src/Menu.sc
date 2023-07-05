;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Gauge)
(use Sound)
(use Game)
(use User)

(public
	TglSound 1
)

(local
	fermata
)

(procedure (TglSound &tmp i)
	(= i (DoSound sndSET_SOUND))
	(DoSound sndSET_SOUND (not i))
	(if i
		(SetMenu 1282 110 {Turn On})
	else
		(SetMenu 1282 110 {Turn Off})
	)
)

(class TheMenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu
			{ \01 }
			{About LSL3}
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
		(SetMenu
			1282
			110
			(if (DoSound sndSET_SOUND) {Turn Off} else {Turn On})
		)
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 [temp4 560] temp564 temp565 temp566)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ALT_l))
			(gGame
				parseLang:
					(if (== (gGame parseLang:) 49)
						(Print 997 0) ; "Parse English"
						1
					else
						(Print 997 1) ; "Parse Foreign"
						49
					)
			)
			(event claimed: 1)
			(return)
		)
		(switch (= temp0 (super handleEvent: event))
			(257
				(PrintSplit ; ""Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals!" Designed by Al Lowe Programmed by Al Lowe and Carlos Escobar Graphics by William Skirvin and Roger Hardy"
					997
					2
					33
					gSmallFont
					30
					1
					80
					{An Al Lowe Production}
					82
					51
					0
					0
				)
				(Format @temp4 997 3 gVersion gVersion) ; "Sierra's Creative Interpreter by Jeff Stephenson, Bob Heitman, Pablo Ghenis, and Stuart Goldstein Music Composed and Performed by Mike Dana Sound Effects by Rob Atesalp Atari ST Translation by Corey Cole Amiga Translation by Robert Lindsley Quality Assurance led by Robin Bradley Version %s January 7, 1991 %"
				(PrintSplit
					@temp4
					33
					gSmallFont
					80
					{The Cast of Thousands}
					67
					-1
					30
					70
					291
					30
					1
				)
				(PrintSplit ; "German Edition: Produced by Pablo Ghenis Translated by: Brigitte Burkertt-Hinojos and Sabine Duvall Program conversion by: Gary Kamigawachi and Sol Ackerman Graphics conversion by: Cheri Lloyd and Jeff Crowe Quality Assurance by: Mike Harian, Kevin Ray, Sabine Duvall and J\81rg Baumann Bilingual System by Pablo Ghenis"
					997
					4
					33
					gSmallFont
					80
					{The Cast of Thousands}
					67
					-1
					30
					70
					291
					30
					1
				)
				(Format ; "%s%"
					@gFilthLevelBuffer
					997
					5
					(switch gFilthLevel
						(4 {Totally Raunchiest})
						(3 {Really Filthy})
						(2 {Pretty Dirty})
						(1 {Rather Risque})
						(else {Mother Goose})
					)
					(switch gFilthLevel
						(4 {V\94llig verdorben})
						(3 {Verdorben})
						(2 {Geschmacklos})
						(1 {Gewagt})
						(else {Harmlos})
					)
				)
				(StrSplitInTwo @global470 @global530 @gFilthLevelBuffer)
				(= global468 @global470)
				(= global469 @global530)
				(cond
					(gGameHours
						(Format ; "How could you play at the "%s Level" for %d hour%s, %d minute%s and %d second%s and only score %d point%s?!%"
							@temp4
							997
							6
							global468
							gGameHours
							(if (== gGameHours 1) {} else {s})
							gGameMinutes
							(if (== gGameMinutes 1) {} else {s})
							gGameSeconds
							(if (== gGameSeconds 1) {} else {s})
							gScore
							(if (== gScore 1) {} else {s})
							global469
							gGameHours
							(if (== gGameHours 1) {} else {n})
							gGameMinutes
							(if (== gGameMinutes 1) {} else {n})
							gGameSeconds
							(if (== gGameSeconds 1) {} else {n})
							gScore
							(if (== gScore 1) {} else {e})
						)
					)
					(gScore
						(Format ; "You've been playing this game at the "%s Level" for %d minute%s and %d second%s and you've only scored %d point%s?!%"
							@temp4
							997
							7
							global468
							gGameMinutes
							(if (== gGameMinutes 1) {} else {s})
							gGameSeconds
							(if (== gGameSeconds 1) {} else {s})
							gScore
							(if (== gScore 1) {} else {s})
							gGameMinutes
							(if (== gGameMinutes 1) {} else {n})
							gGameSeconds
							(if (== gGameSeconds 1) {} else {n})
							global469
							gScore
							(if (== gScore 1) {} else {e})
						)
					)
					(else
						(Format ; "You've been playing this game at the "%s Level" for %d minute%s and %d second%s and you haven't scored a single point?%"
							@temp4
							997
							8
							global468
							gGameMinutes
							(if (== gGameMinutes 1) {} else {s})
							gGameSeconds
							(if (== gGameSeconds 1) {} else {s})
							gGameMinutes
							(if (== gGameMinutes 1) {} else {n})
							gGameSeconds
							(if (== gGameSeconds 1) {} else {n})
							global469
						)
					)
				)
				(Print
					@temp4
					#font
					gSmallFont
					#mode
					1
					#title
					{Get a Life!}
				)
			)
			(258
				(PrintSplit 997 9 33 gSmallFont 67 10 -1 70 290) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Enter selects the outlined item, or click on items with the mouse. Tab and Shift-Tab move between choices. ESC always cancels."
				(Print 997 10 #font gSmallFont) ; "If you really need help, pick up a copy of the "Passionate Patti" hint book at your software dealer."
			)
			(259
				(= temp565 (gGame printLang:))
				(= temp566 (gGame subtitleLang:))
				(while
					(switch
						(Print ; "Speak your mind any way you want to:"
							997
							11
							#title
							{Language preferences}
							#icon
							700
							(Random 0 3)
							(Random 0 5)
							#font
							gSmallFont
							#button
							{OK}
							0
							#button
							(if (!= temp565 1)
								{English\nmessages}
							else
								{German\nmessages}
							)
							1
							#button
							(if temp566
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
							(if temp566
								(SwapLangs)
							else
								(gGame
									printLang: (if (!= temp565 1) 1 else 49)
								)
							)
						)
						(2
							(gGame
								subtitleLang:
									(cond
										(temp566 0)
										((== temp565 1) 49)
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
					(= temp565 (gGame printLang:))
					(= temp566 (gGame subtitleLang:))
					(SL doit:)
				)
				1
			)
			(513
				(if (TestFlag 3)
					(Print ; "Sorry, but you can not save your game at this time. Please try again later."
						997
						12
						#title
						{Not now, I have a headache!}
					)
				else
					(gGame save:)
					(= global292 0)
					(= global293 0)
				)
			)
			(514
				(gGame restore:)
			)
			(515
				(if
					(>
						0
						(= global291
							(GetNumber
								{Minutes Between Reminders:}
								global291
							)
						)
					)
					(= global291 0)
				)
			)
			(517
				(if
					(Print ; "Are you serious? You want to start all the way back at the beginning again?"
						997
						13
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
						(Format ; "Quit? Now? When you're doing so well? Why, you're almost up to %d points!%"
							@temp4
							997
							14
							(= temp564 (Random (+ gScore 5) (+ gScore 50)))
							temp564
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
					15
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
					(
						(= temp2
							(GetNumber
								{New Text Color: (0-15)}
							)
						)
					)
				)
				(if (!= temp2 -1)
					(for
						((= temp3 16))
						(and (!= temp3 -1) (or (u> temp3 15) (== temp3 temp2)))
						(
							(= temp3
								(GetNumber
									{New Background Color: (0-15)}
								)
							)
						)
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
					(= gVolume
						((Gauge new:)
							description:
								{Use the mouse or the left and right arrow keys to adjust the volume.}
							text: {Sound Volume}
							normal: 8
							higher: {Louder}
							lower: {Softer}
							doit: gVolume
						)
					)
					(DoSound sndVOLUME gVolume)
					(DisposeScript 987)
				)
			)
			(1282
				(TglSound)
			)
		)
	)
)

