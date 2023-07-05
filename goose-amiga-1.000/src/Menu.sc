;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use User)
(use System)

(procedure (localproc_0 &tmp temp0) ; UNUSED
	(Printf 997 0 (gCurRoom vanishingX:) (gCurRoom vanishingY:)) ; "vanishing x/y=%d/%d"
	(= temp0 (GetNumber {vanishingX:}))
	(or (OneOf temp0 -1 0) (gCurRoom vanishingX: temp0))
	(= temp0 (GetNumber {vanishingY:}))
	(or (OneOf temp0 -1 0) (gCurRoom vanishingY: temp0))
	(Printf 997 0 (gCurRoom vanishingX:) (gCurRoom vanishingY:)) ; "vanishing x/y=%d/%d"
)

(class TheMenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About game`^a :Help`#1 })
		(AddMenu { Game } {Kids  `#5 :Disk  `#7 })
		(AddMenu { Speed } {Change...`^s :--! :Faster`+ :Normal`= :Slower`- })
		(AddMenu { Sound } {Volume...`^v :Sound Off`#2=1 })
		(if global100
			(AddMenu
				{ Debug }
				{Game`^g :Cast`^c :Ego`^e :Memory`^h :--! :Visual`@v :Priority`@p :Control`@c :--! :WriteEgo`^w :Set Debug`^D }
			)
			(AddMenu
				{ Cheat }
				{Teleport`@t :Room num`@r :Input`@i :Set Vanish`@y }
			)
			(SetMenu 1537 109 'tp')
			(SetMenu 258 109 'help')
			(SetMenu 1540 109 'vanish')
		)
		(SetMenu 513 109 'save')
		(SetMenu 514 109 'restore')
		(SetMenu 772 109 'normal')
		(SetMenu 771 109 'faster')
		(SetMenu 773 109 'slower')
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 [temp3 251] temp254)
		(if global132
			(return 0)
		)
		(switch (= temp254 (super handleEvent: event (User blocks:)))
			(257
				(Print
					(Format @temp3 997 1 gVersion) ; "Executive Producer Ken Williams Designed by Roberta Williams Graphics by Jerry Moore and Cheryl Loyd Programming by Carlos Escobar, Scott Murphy, Chris Smith, and Chris Hoyt Music arrangements & Sound Effects by Ken Allen Amiga Conversion by Steven Coallier, Randy MacNeill and John Rettig "Mother Goose" theme by Amenda-Lombardo Producer Josh Mandel Version %s"
					#font
					3
					#mode
					1
					#title
					{Mixed-Up Mother Goose}
				)
				(Print
					(Format @temp3 997 2) ; "SCI Development System       by        Jeff Stephenson   Robert E. Heitman   Pablo Ghenis   John Hartin   Dan Foy   John Rettig   Corinna Abdul   Corey Cole   Quality Assurance       by        Sharon Smith   Sharon Simmons   Victor Sadauskas"
					#font
					3
					#mode
					1
					#title
					{Mixed-Up Mother Goose}
				)
			)
			(258
				(Print 997 3 #font 3) ; "MOTHER GOOSE HELP   ESC Brings up the menu.   F1 Displays this message.   F2 Turns the sound off and on.   F5 Lets you start a new kid's game     or restore an old one.   F7 Lets you save and quit the game.       TO MOVE AROUND: Arrows, Home, End, PgUp and PgDn keys move your character, or click anywhere with mouse."
			)
			(513
				(if (!= gCurRoomNum 199) ; intro
					(Load rsFONT gSmallFont)
					(Load rsCURSOR gWaitCursor)
					(gGame save:)
					(gGlobalMGSound fade:)
					(= global194 1)
					(proc0_20)
					(gCurRoom newRoom: 99) ; speedTest
				)
			)
			(1291
				(if (not gDebugOn)
					(= gDebugOn 1)
				else
					(= gDebugOn 0)
				)
			)
			(514
				(if (!= gCurRoomNum 199) ; intro
					(switch
						(= temp0
							(Print ; "What would you like to do?"
								997
								4
								#title
								{Disk}
								#icon
								602
								0
								0
								#font
								1
								#button
								{Save & Quit }
								1
								#button
								{Quit without saving }
								2
								#button
								{Oops}
								0
							)
						)
						(1
							(= global240 0)
							(gGame save:)
							(= gQuit 1)
						)
						(2
							(= gQuit 1)
						)
					)
				else
					(= gQuit
						(Print ; "Would You like to stop playing now?"
							997
							5
							#title
							{Disk}
							#icon
							602
							0
							0
							#font
							1
							#button
							{No}
							0
							#button
							{Yes}
							1
						)
					)
				)
			)
			(769
				(if
					(and
						(not global102)
						(!=
							(= temp2
								(GetNumber {Speed (1 - 15)?} (- 16 gSpeed))
							)
							-1
						)
					)
					(if (< (= temp2 (- 16 temp2)) 1)
						(= temp2 1)
					)
					(if (> temp2 16)
						(= temp2 16)
					)
					(= global206 gSpeed)
					(gGame setSpeed: temp2)
				)
			)
			(771
				(if (> gSpeed 1)
					(gGame setSpeed: (-- gSpeed))
				)
			)
			(772
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 6)
					)
					(2
						(gGame setSpeed: 8)
					)
				)
			)
			(773
				(if (< gSpeed 16)
					(gGame setSpeed: (++ gSpeed))
				)
			)
			(1025
				(if
					(!=
						(= temp2
							(GetNumber {Volume (1 - 16)?} (+ 1 (DoSound sndMASTER_VOLUME)))
						)
						-1
					)
					(if (< (-- temp2) 0)
						(= temp2 0)
					)
					(if (> temp2 15)
						(= temp2 15)
					)
					(DoSound sndMASTER_VOLUME temp2)
				)
			)
			(1026
				(if (== (++ global208) 3)
					(= global208 0)
				)
				(switch global208
					(0
						(DoSound sndSET_SOUND 1)
					)
					(2
						(DoSound sndSET_SOUND 0)
					)
				)
				(switch global208
					(0
						(SetMenu 1026 110 {Turn Off Music})
						(if (not global207)
							(gGlobalMGSound number: 1 loop: -1)
							(if (not global209)
								(gGlobalMGSound play:)
							)
							(= temp1 0)
						)
						(Print 997 6 #time 5) ; "Music and Sound Effects on."
					)
					(1
						(SetMenu 1026 110 {Turn Off Sound})
						(if (not global207)
							(gGlobalMGSound number: 1 loop: -1 stop:)
						)
						(Print 997 7 #time 5) ; "Music Off. Sound Effects on."
					)
					(2
						(Print 997 8 #time 5) ; "Music and Sound Effects off."
						(SetMenu 1026 110 {Turn On})
					)
				)
			)
		)
	)
)

