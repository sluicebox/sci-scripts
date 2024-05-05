;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use selectRoom_2)
(use Interface)
(use n315)
(use n319)
(use Gauge)
(use User)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu {__\01 } {About Hoyle Solitaire`^a:Help`#1})
		(AddMenu {___Game__} {Quick Replay`#3:Start A New Game`#9:Quit`^q})
		(AddMenu {__Sound__} {Sound Toggle `#2:Volume `^v})
		(AddMenu
			{__Options__}
			{Animation Speed`^s:Cursor Speed`^z:Select Colors/Deck`^c:Auto Play`^p}
		)
		(AddMenu {__Rules__} {Read`^r:Differences`^d})
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
					(Format @global100 997 1) ; "DEVELOPMENT SYSTEM BY:   Jeff Stephenson  Robert E. Heitman  Pablo Ghenis  John Hartin  Dan Foy  John Rettig  Corinna Abdul  Corey Cole Version 1.000.011"
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
				(Print (Format @global100 997 2) #width 250 #title {HELP}) ; "MOUSE - Left mouse button selects. Right mouse button (or Alt-Left) is Single Auto Play.  KEYBOARD - Keypad arrows move the cursor. ENTER key selects. INS key is Single Auto Play.  JOYSTICK - Select a card with button. No Single Auto Play with joystick.  MENU BAR - Point or ESC activates menu bar. Shortcuts are given after each item."
				(event claimed: 1)
			)
			(513
				(= global678 0)
				(proc0_2)
				(if (gTheDealer currentlyActive:)
					(Print 997 3) ; "Replay will take place after the deal is over."
				)
				(= global323 1)
				(if (gCurRoom script:)
					((gCurRoom script:) dispose:)
				)
				(event claimed: 1)
			)
			(514
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
							(Print 997 3) ; "Replay will take place after the deal is over."
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
			(515
				(if
					(= gQuit
						(Print 997 5 #button {QUIT} 1 #button {CANCEL} 0 #icon 196 0 0) ; "Quitting Hoyle Solitaire?"
					)
					(gOptions_sol doit: 1)
				)
				(event claimed: 1)
			)
			(516
				(gGame showMem:)
				(event claimed: 1)
			)
			(769
				(= temp4 (DoSound sndSET_SOUND))
				(DoSound sndSET_SOUND (- 1 temp4))
				(if (DoSound sndSET_SOUND)
					(Printf 997 6) ; "Sound turned ON"
				else
					(Printf 997 7) ; "Sound turned OFF"
				)
				(event claimed: 1)
			)
			(770
				(= temp2 (DoSound sndPAUSE 1))
				(= temp3
					((Gauge new:)
						description:
							{Use the mouse or right and left arrow keys to set the sound volume.}
						text: {Sound Volume}
						minimum: 0
						normal: 12
						maximum: 15
						higher: {Louder}
						lower: {Softer}
						doit: (DoSound sndVOLUME)
					)
				)
				(DoSound sndPAUSE temp2)
				(DoSound sndVOLUME (= gVolume temp3))
				(DisposeScript 987)
				(event claimed: 1)
			)
			(1025
				(= temp3
					((Gauge new:)
						description:
							{Use the mouse or arrow keys to change speed.}
						text: {Animation Speed}
						minimum: 1
						normal: 4
						maximum: 8
						higher: {Slower}
						lower: {Faster}
						doit: gSpeed
					)
				)
				(if (>= 8 temp3 1)
					(= gSpeed temp3)
				)
				(DisposeScript 987)
				(event claimed: 1)
			)
			(1026
				(= temp3
					((Gauge new:)
						description:
							{Use the mouse or arrow keys to change speed.}
						text: {Cursor Speed}
						minimum: 1
						normal: 2
						maximum: 4
						higher: {Slower}
						lower: {Faster}
						doit: (- 4 (KeyMouse cursorSpeed:))
					)
				)
				(if (>= 3 temp3 1)
					(KeyMouse cursorSpeed: (- 4 temp3))
				)
				(DisposeScript 987)
				(event claimed: 1)
			)
			(1027
				(cond
					((== gCurRoomNum 2) ; selectRoom
						(= gNewRoomNum 3) ; selectRoom
					)
					((== gCurRoomNum 1)
						(Print 997 8) ; "To select a new background color or deck design, choose this menu item again during the Select New Game screen."
					)
				)
				(event claimed: 1)
			)
			(1028
				(= global683 1)
				(if (and (== gCurRoomNum 1) (== (gCurRoom state:) 2))
					(if global311
						(= global678 (- 1 global678))
					else
						(Print 997 9) ; "Auto Play feature is not applicable for this game."
					)
				else
					(Print 997 10) ; "Auto Play feature is not applicable at this time."
				)
				(event claimed: 1)
			)
			(1029
				(Print 997 11) ; "Undo is not implemented yet!"
				(event claimed: 1)
			)
			(1281
				(if (== gCurRoomNum 1)
					(proc319_0 event)
				else
					(Print 997 12) ; "Rules are available for each game after selecting a game."
				)
				(event claimed: 1)
			)
			(1282
				(if (== gCurRoomNum 1)
					(proc319_1 event)
				else
					(Print 997 13) ; "Rule differences are available for each game after selecting a game."
				)
				(event claimed: 1)
			)
		)
	)
)

