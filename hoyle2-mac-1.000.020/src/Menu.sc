;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use selectRoom_2)
(use Interface)
(use n315)
(use n319)
(use MacGauge)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01} {About Hoyle Solitaire `#0:Help `#1})
		(AddMenu
			{ Game}
			{Start A New Game `^n :Quick Replay `#3 :--! :Close`#2 :--! :--! :Quit `^Q }
		)
		(AddMenu
			{ Edit }
			{Undo`^z :--! :Cut`^x :Copy`^c :Paste`^v :Clear`#5 :Select All`#4 }
		)
		(AddMenu { Sound} {Sound Toggle `#2: Volume `#0})
		(AddMenu
			{ Options}
			{Animation Speed`#0:Select Colors|Deck`#0:Auto Play`#0}
		)
		(AddMenu { Rules} {Read`#0:Differences`#0})
		(self draw:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (== gTheCursor 997)
			(event claimed: 1)
		)
		(switch (= temp0 (super handleEvent: event))
			(257
				(Print
					(Format @global100 997 0) ; "EXECUTIVE PRODUCER:  Ken Williams DESIGNER AND PROGRAMMER:  Warren Schwader ARTISTS:  Warren Schwader  James Larsen  Jerry Moore COMPOSER:  Rob Atesalp"
					81
					{More}
					70
					180
					80
					{Hoyle Solitaire}
				)
				(Print
					(Format @global100 997 1) ; "DEVELOPMENT SYSTEM BY:   Jeff Stephenson  Robert E. Heitman  Pablo Ghenis  John Hartin  Dan Foy  John Rettig  Corinna Abdul  Corey Cole Version 1.000.020"
					81
					{More}
					70
					180
					80
					{Hoyle Solitaire}
				)
				(Print
					(Format @global100 997 2) ; "ADDITIONAL MACINTOSH DEVELOPMENT BY:   John Crane  Chris Brayman  Jeff Crowe  Nate Larsen  Steve Coallier  Rich Powell"
					81
					{ OK }
					70
					180
					80
					{Hoyle Solitaire}
				)
				(event claimed: 1)
			)
			(258
				(Print (Format @global100 997 3) #width 250 #title {HELP}) ; "MOUSE - Mouse button selects.  MENU BAR - Point activates menu bar. Shortcuts are given after each item."
				(event claimed: 1)
			)
			(513
				(if
					(= temp1
						(Print ; "Replay or New Game?"
							997
							4
							#button
							{New Game}
							1
							#button
							{Replay}
							2
							#button
							{Same Deck}
							3
							#button
							{Cancel}
							0
							#icon
							196
							0
							1
						)
					)
					(= global678 0)
					(proc0_2)
					(if (== temp1 1)
						(gOptions_sol doit: 1)
						(if (== gCurRoomNum 2) ; selectRoom
							(proc2_1)
						)
						(gCurRoom drawPic: 10 8)
						(proc0_2)
						(if (proc0_6 124)
							(proc315_1)
						)
						(gTheCardToss posn: 500 500)
						(gTheAutoCardToss posn: 500 500)
						(gTheAutoCardToss2 posn: 500 500)
						(if (gCurRoom script:)
							((gCurRoom script:) dispose:)
						)
						(proc0_2)
						(gGame restart:)
					else
						(if (gTheDealer currentlyActive:)
							(Print 997 5) ; "Replay will take place after the deal is over."
						)
						(= global323 1)
						(if (== temp1 3)
							(= global404 1)
						)
						(if (gCurRoom script:)
							((gCurRoom script:) dispose:)
						)
					)
				)
			)
			(519
				(if
					(= gQuit
						(Print 997 6 #button {QUIT} 1 #button {CANCEL} 0 #icon 196 0 0) ; "Quitting Hoyle Solitaire?"
					)
					(gOptions_sol doit: 1)
				)
				(event claimed: 1)
			)
			(514
				(= global678 0)
				(proc0_2)
				(if (gTheDealer currentlyActive:)
					(Print 997 5) ; "Replay will take place after the deal is over."
				)
				(= global323 1)
				(if (gCurRoom script:)
					((gCurRoom script:) dispose:)
				)
				(event claimed: 1)
			)
			(1025
				(= temp4 (DoSound sndSET_SOUND))
				(DoSound sndSET_SOUND (- 1 temp4))
				(if (DoSound sndSET_SOUND)
					(Printf 997 7) ; "Sound turned ON"
				else
					(Printf 997 8) ; "Sound turned OFF"
				)
				(event claimed: 1)
			)
			(1026
				(= temp2 (DoSound sndPAUSE 1))
				(= temp3
					((MacGauge new:)
						description: {Use the mouse to set the sound volume.}
						text: {Sound Volume}
						topX: 10
						bottomY: 6
						range: 8
						view: 701
						loop: 0
						cel: 2
						start: gVolume
						doit: (DoSound sndVOLUME)
					)
				)
				(DoSound sndPAUSE temp2)
				(DoSound sndVOLUME (= gVolume temp3))
				(DisposeScript 897)
				(event claimed: 1)
			)
			(1281
				(= temp3
					((MacGauge new:)
						description: {Use the mouse to change speed.}
						text: {Animation Speed}
						topX: 10
						bottomY: 6
						range: 8
						low: 1
						view: 701
						loop: 0
						cel: 1
						start: gSpeed
						doit: gSpeed
					)
				)
				(if (>= 9 temp3 1)
					(= gSpeed temp3)
				else
					(= gSpeed 9)
				)
				(SetMenu 1281 113 gSpeed)
				(DisposeScript 897)
				(event claimed: 1)
			)
			(1282
				(cond
					((== gCurRoomNum 2) ; selectRoom
						(= gNewRoomNum 3) ; selectRoom
					)
					((== gCurRoomNum 1)
						(Print 997 9) ; "To select a new background color or deck design, choose this menu item again during the Select New Game screen."
					)
				)
				(event claimed: 1)
			)
			(1283
				(= global683 1)
				(if (and (== gCurRoomNum 1) (== (gCurRoom state:) 2))
					(if global311
						(= global678 (- 1 global678))
					else
						(Print 997 10) ; "Auto Play feature is not applicable for this game."
					)
				else
					(Print 997 11) ; "Auto Play feature is not applicable at this time."
				)
				(event claimed: 1)
			)
			(1284
				(Print 997 12) ; "Undo is not implemented yet!"
				(event claimed: 1)
			)
			(1537
				(if (== gCurRoomNum 1)
					(proc319_0 event)
				else
					(Print 997 13) ; "Rules are available for each game after selecting a game."
				)
				(event claimed: 1)
			)
			(1538
				(if (== gCurRoomNum 1)
					(proc319_1 event)
				else
					(Print 997 14) ; "Rule differences are available for each game after selecting a game."
				)
				(event claimed: 1)
			)
		)
	)
)

