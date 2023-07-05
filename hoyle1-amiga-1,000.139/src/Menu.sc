;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use n901)

(public
	proc997_0 0
)

(local
	[local0 20]
	[local20 20]
	[local40 20]
	[local60 20]
	[local80 20]
	local100
)

(procedure (proc997_0)
	(= gVolume
		(if (<= global236 2)
			(- global236 1)
		else
			(- (* (- global236 1) 2) 1)
		)
	)
	(SetMenu 1025 110 (Format @local0 {Volume is %d} (- global236 1)))
	(DoSound sndVOLUME gVolume)
	(if (DoSound sndSET_SOUND)
		(SetMenu 1026 110 {Turn Sound Off})
	else
		(DoSound sndSET_SOUND 0)
		(SetMenu 1026 110 {Turn Sound On})
	)
	(SetMenu 769 110 (Format @local20 { Deal Speed is %d} global405))
	(SetMenu 770 110 (Format @local40 { Play Speed is %d} global406))
	(SetMenu 771 110 (Format @local60 { Delay Speed is %d} global407))
	(SetMenu 772 110 (Format @local80 { Animation Speed is %d} (+ gSpeed 1)))
	(if global774
		(SetMenu 517 110 {Turn Conversation Off})
	else
		(SetMenu 517 110 {Turn Conversation On})
	)
)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About HOYLE:Help Menu `#1})
		(AddMenu
			{ Game }
			{Start A New Game `#9:Save Setup `^s:Quit `^Q:--!:Turn Conversation Off}
		)
		(AddMenu
			{ Speed }
			{ Deal Speed is 5 `^d: Play Speed is 5 `^p: Delay Speed is 5 `^w: Animation Speed is 2 `^a }
		)
		(AddMenu { Sound } {Volume is 0 `^v:Sound On/Off `#2})
		(self draw:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if local100
			(return)
		)
		(if (== gTheCursor 997)
			(event claimed: 1)
		)
		(gSysWindow setBack: 12 setColor: 14)
		(switch (= temp1 (super handleEvent: event))
			(257
				(Print (Format @global520 997 0) #title {HOYLE BOOK OF GAMES}) ; "DESIGNER AND PROGRAMMER:   Warren Schwader ARTWORK BY:   Jerry Moore   Eileen Fisher   Warren Schwader MUSIC AND SOUND EFFECTS BY:   Rob Atesalp AMIGA VERSION BY:   Robert W. Lindsley   Dan Foy"
				(Print
					(Format @global520 997 1 gVersion) ; "ALSO, THANKS TO:   Guruka Singh Khalsa   David Slayback   J. Mark Hood   Ellen Guon   David Skinner   Version %s"
					#title
					{HOYLE BOOK OF GAMES}
				)
			)
			(258
				(Print (Format @global520 997 2) #mode 1 #title {HOYLE's HELP}) ; "MOVING THE ARROW CURSOR MOUSE: Point with the Mouse, select with the Left Button. Rearrange cards in your hand by Dragging them. KEYBOARD: Use the Keyboard Arrows to move the cursor, select with the Enter key, use the Insert key to move cards around in your hand, and to play a dimmed card."
				(Print (Format @global520 997 3) #mode 1 #title {HOYLE's HELP}) ; "USING THE MENU BAR Point at the Menu Bar with the Mouse or Esc. Select an item by dragging the Mouse or by pressing arrow keys. When using the keyboard, press Enter after selecting an item. Esc will also put the menu bar away. Shortcuts are given after each item."
			)
			(513
				(if
					(= temp2
						(Print ; "Restarting?"
							997
							4
							#button
							{Select New Game}
							1
							#button
							{Reset Scores}
							2
							#button
							{Cancel}
							0
						)
					)
					(cond
						((== temp2 1)
							(if (global300 windowUp:)
								((global300 curly:) hide:)
							)
							(gCurRoom drawPic: 10 6)
							(proc0_5)
							(gGame restart:)
						)
						((and (!= gCurRoomNum 2) (<= 1 gCurRoomNum 7))
							(Print (Format @global520 997 5)) ; "Reset of scores will take effect beginning next hand."
							(= global508 1)
						)
					)
				)
			)
			(514
				(Load rsSCRIPT 901)
				(proc901_0)
				(DisposeScript 901)
			)
			(515
				(= gQuit (Print 997 6 #button {YES} 1 #button {NO} 0)) ; "Quitting HOYLE?"
			)
			(517
				(if global774
					(= global774 0)
					(Print 997 7) ; "Conversation OFF"
				else
					(= global774 1)
					(Print 997 8) ; "Conversation ON"
				)
				(proc997_0)
				(proc0_8)
			)
			(1025
				(gGame setCursor: 997)
				(self doit: 5 global236 6)
				(= gVolume
					(if (<= global429 2)
						(- global429 1)
					else
						(- (* (- global429 1) 2) 1)
					)
				)
				(= global236 global429)
				(SetMenu
					1025
					110
					(Format @global277 {Volume is %d} (- global236 1))
				)
				(if (DoSound sndSET_SOUND)
					(DoSound sndVOLUME gVolume)
				)
			)
			(1026
				(if (DoSound sndSET_SOUND)
					(DoSound sndSET_SOUND 0)
				else
					(DoSound sndSET_SOUND 1)
				)
				(proc997_0)
			)
			(769
				(gGame setCursor: 997)
				(self doit: 1 global405)
				(= global405 global429)
				(SetMenu 769 110 (Format @local20 { Deal Speed is %d} global405))
			)
			(770
				(gGame setCursor: 997)
				(self doit: 2 global406)
				(= global406 global429)
				(SetMenu 770 110 (Format @local40 { Play Speed is %d} global406))
			)
			(771
				(gGame setCursor: 997)
				(self doit: 3 global407)
				(= global407 global429)
				(SetMenu
					771
					110
					(Format @local60 { Delay Speed is %d} global407)
				)
			)
			(772
				(gGame setCursor: 997)
				(self doit: 7 (+ gSpeed 1))
				(= gSpeed (- global429 1))
				(SetMenu
					772
					110
					(Format @local80 { Animation Speed is %d} (+ gSpeed 1))
				)
			)
			(else
				(gCurRoom handleEvent: event temp1)
				(gSysWindow setBack: 14 setColor: 4)
				(return)
			)
		)
		(event claimed: 1)
		(gSysWindow setBack: 14 setColor: 4)
	)

	(method (doit param1 param2 param3 &tmp temp0)
		(= local100 1)
		((ScriptID 897) init: param1 param2 (if (== argc 3) param3 else 0)) ; myGauge
		((ScriptID 897) dispose:) ; myGauge
		(DisposeScript 897)
		(= local100 0)
		(return temp0) ; UNINIT
	)
)

