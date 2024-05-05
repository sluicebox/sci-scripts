;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use Gauge)
(use Sound)
(use Inventory)
(use User)

(class TheMenuBar of Item
	(properties)

	(method (init)
		(AddMenu { \01 } {About KQ4`^a:Help`#1})
		(AddMenu { File } {Save`#5:Restore`#7:-!:Restart`#9:Quit`^q})
		(AddMenu { Action } {Pause`^p:Inventory`^i:Retype`#3})
		(AddMenu { Speed } {Speed`^s:-!:Faster`+:Normal`=:Slower`-})
		(AddMenu { Sound } {Volume`^v:-!:Turn Off=1`#2})
		(SetMenu 1283 110 (if (DoSound sndSET_SOUND) {Turn Off} else {Turn On}))
		(SetMenu 513 109 'save[/game]')
		(SetMenu 514 109 'restore[/game]')
		(SetMenu 516 109 'restart[/game]')
		(SetMenu 517 109 'quit[/game]')
		(SetMenu 769 109 'pause[/game]')
		(SetMenu 770 109 'inventory')
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 4] temp6 [temp7 288])
		(switch (= temp0 (super handleEvent: event))
			(257
				(= temp6 (Sound pause: 1))
				(Print
					(Format @temp7 997 0 gVersion) ; "KING'S QUEST IV "The Perils of Rosella" Designed and Directed by Roberta Williams Music by William Goldstein Programming by Ken Koch, Chane Fullmer System Design by Jeff Stephenson, Bob Heitman, Stuart Goldstein, Pablo Ghenis Background Scenes by William D. Skirvin Animation by Carolly Hauksdottir, Jerry Moore Graphics System by Robert E. Heitman Cavalry Coding by Al Lowe, David Slayback, Bob Heitman, Chris Hoyt Wrangling by Dale Carlson, Bob Ballew Quality Assurance by a cast of thousands! Version %s, September 19, 1988"
					#title
					{A Ken Williams Production}
					#font
					gSmallFont
					#mode
					1
					#at
					20
					22
					#width
					260
				)
				(Sound pause: temp6)
			)
			(258
				(= temp6 (Sound pause: 1))
				(Print 997 1 #font gSmallFont) ; "DURING THE GAME: Click at the top of the screen or press ESC to use the menus. Additional shortcuts are shown there.    IN TYPING WINDOWS: Arrows, Home and End move the cursor, or click anywhere with the mouse. Ctrl-C clears the line.    IN DIALOG WINDOWS: Enter selects the outlined item, or click on items with the mouse. Tab and Shift-Tab move between choices. ESC always cancels."
				(Sound pause: temp6)
			)
			(513
				(gGame save:)
			)
			(514
				(gGame restore:)
			)
			(516
				(= temp6 (Sound pause: 1))
				(if
					(Print ; "Do you really want to restart your game?"
						997
						2
						#icon
						100
						0
						0
						#font
						0
						#button
						{ Restart }
						1
						#button
						{Continue}
						0
					)
					(gGame restart:)
				)
				(Sound pause: temp6)
			)
			(517
				(= temp6 (Sound pause: 1))
				(= gQuit
					(Print ; "Do you really want to quit?"
						997
						3
						#icon
						100
						0
						0
						#font
						0
						#button
						{____Quit____}
						1
						#button
						{ Continue }
						0
					)
				)
				(Sound pause: temp6)
			)
			(769
				(= temp6 (Sound pause: 1))
				(Print 997 4 #font 0 #mode 1 #button { Continue } 0) ; "King's Quest IV "The Perils of Rosella" is paused."
				(Sound pause: temp6)
			)
			(770
				(if (not (HaveMem 2048))
					(Print 997 5) ; "Inventory can not be displayed at this time."
				else
					(= temp6 (Sound pause: 1))
					(Inv showSelf: gEgo)
					(Sound pause: temp6)
				)
			)
			(771
				(event message: (User echo:))
				(User getInput: event)
			)
			(1025
				(if (not (HaveMem 1800))
					(Print 997 6) ; "Speed can not be changed at this time."
				else
					(= temp1
						((Gauge new:)
							description:
								{Use the mouse or the left and right arrow keys to change the speed of moving characters.}
							text: {Animation Speed}
							minimum: 0
							normal: 10
							maximum: 15
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
				(if (> gSpeed 1)
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
				(if (not (HaveMem 1800))
					(Print 997 7) ; "Volume can not be changed at this time."
				else
					(= temp6 (DoSound sndPAUSE 1))
					(= temp1
						((Gauge new:)
							description:
								{Use the mouse or left and right arrow keys to change the volume.}
							text: {Sound Volume}
							minimum: 0
							normal: 12
							maximum: 15
							higher: {Louder}
							lower: {Softer}
							doit: (DoSound sndVOLUME)
						)
					)
					(DoSound sndPAUSE temp6)
					(DoSound sndVOLUME temp1)
					(DisposeScript 987)
				)
			)
			(1283
				(if (= temp1 (DoSound sndSET_SOUND))
					(SetMenu 1283 110 {Turn On})
				else
					(SetMenu 1283 110 {Turn Off})
				)
				(DoSound sndSET_SOUND (not temp1))
			)
			(else
				(if global202
					(global202 doit: temp0)
				)
			)
		)
	)
)

