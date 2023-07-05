;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use Interface)
(use MacGauge)
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
	(SetMenu 1281 110 (Format @local0 {Volume is %d} global236))
	(SetMenu 1281 113 global236)
	(DoSound sndVOLUME global236)
	(if (DoSound sndSET_SOUND)
		(SetMenu 1282 110 {Turn Sound Off})
	else
		(DoSound sndSET_SOUND 0)
		(SetMenu 1282 110 {Turn Sound On})
	)
	(SetMenu 1025 110 (Format @local20 { Deal Speed is %d} global405))
	(SetMenu 1025 113 global405)
	(SetMenu 1026 110 (Format @local40 { Play Speed is %d} global406))
	(SetMenu 1027 110 (Format @local60 { Wait Speed is %d} global407))
	(SetMenu 1028 110 (Format @local80 { Animation Speed is %d} (+ gSpeed 1)))
	(if global774
		(SetMenu 521 110 {Turn Conversation Off})
	else
		(SetMenu 521 110 {Turn Conversation On})
	)
)

(class MenuBar of MenuBar
	(properties)

	(method (init)
		(AddMenu { \01 } {About HOYLE `#0:Help Menu `#1})
		(AddMenu
			{ Game }
			{Start A New Game `^n :--! :--! :Close`#2 :--! :Save Setup `^s:Quit `^Q:--!:Turn Conversation Off `#0}
		)
		(AddMenu
			{ Edit }
			{Undo`^z :--! :Cut`^x :Copy`^c :Paste`^v :Clear`#5 :Select All`#4 }
		)
		(AddMenu
			{ Speed }
			{ Deal Speed`#4=dealSpeed: Play Speed`#4=playSpeed: Wait Speed`#4=waitSpeed: Animation Speed`#4=speed }
		)
		(DoSound sndSET_SOUND)
		(AddMenu { Sound } {Volume`#0:Sound On/Off `#2})
		(self draw:)
	)

	(method (handleEvent event &tmp [temp0 41] temp41 temp42 temp43)
		(if local100
			(return)
		)
		(if (== gTheCursor 997)
			(event claimed: 1)
		)
		(gSysWindow setBack: 12 setColor: 14)
		(switch (= temp42 (super handleEvent: event))
			(257
				(Print (Format @global520 997 0) #title {HOYLE BOOK OF GAMES}) ; "DESIGNER AND PROGRAMMER:   Warren Schwader ARTWORK BY:   Jerry Moore   Eileen Fisher   Warren Schwader MUSIC AND SOUND EFFECTS BY:   Rob Atesalp MACINTOSH VERSION BY:   John Hartin   Steven Coallier"
				(Print
					(Format @global520 997 1 gVersion) ; "ALSO, THANKS TO:   Guruka Singh Khalsa   David Slayback   J. Mark Hood   Ellen Guon   David Skinner   John Rettig   John Crane   Version %s"
					#title
					{HOYLE BOOK OF GAMES}
				)
			)
			(258
				(Print (Format @global520 997 2) #mode 1 #title {HOYLE's HELP}) ; "MOVING THE ARROW CURSOR MOUSE: Point with the Mouse, select with the Button. Rearrange cards in your hand by Dragging them."
				(Print (Format @global520 997 3) #mode 1 #title {HOYLE's HELP}) ; "USING THE MENU BAR Point at the Menu Bar with the Mouse. Select an item by dragging the Mouse and releasing. Keyboard shortcuts are given after each item."
			)
			(513
				(if
					(= temp43
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
						((== temp43 1)
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
			(518
				(Load rsSCRIPT 901)
				(proc901_0)
				(DisposeScript 901)
			)
			(519
				(= gQuit (Print 997 6 #button {YES} 1 #button {NO} 0)) ; "Quitting HOYLE?"
			)
			(521
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
			(1281
				(= gVolume
					(= temp41
						((MacGauge new:)
							description:
								{Use the mouse\nto set the\nsound volume.}
							text: {Sound Volume}
							topX: 10
							bottomY: 6
							range: 8
							view: 701
							loop: 0
							cel: 2
							start: global236
							doit: (DoSound sndVOLUME temp41) ; UNINIT
						)
					)
				)
				(DoSound sndVOLUME gVolume)
				(= global236 temp41)
				(SetMenu 1281 110 (Format @local0 {Volume is %d} global236))
				(SetMenu 1281 113 global236)
				(DisposeScript 897)
			)
			(1282
				(if (DoSound sndSET_SOUND)
					(DoSound sndSET_SOUND 0)
				else
					(DoSound sndSET_SOUND 1)
				)
				(proc997_0)
			)
			(1025
				(= global405
					(= temp41
						((MacGauge new:)
							description:
								{Use the mouse\nto set the\ndealing speed.}
							text: {Dealing Speed}
							topX: 10
							bottomY: 6
							range: 8
							low: 1
							view: 701
							loop: 0
							cel: 1
							start: global405
							doit: global405
						)
					)
				)
				(SetMenu
					1025
					110
					(Format @local20 { Deal Speed is %d} global405)
				)
				(SetMenu 1025 113 global405)
				(DisposeScript 897)
			)
			(1026
				(= global406
					(= temp41
						((MacGauge new:)
							description:
								{Use the mouse\nto set the\nplaying speed.}
							text: {Playing Speed}
							topX: 10
							bottomY: 6
							range: 8
							low: 1
							view: 701
							loop: 0
							cel: 1
							start: global406
							doit: global406
						)
					)
				)
				(SetMenu
					1026
					110
					(Format @local40 { Play Speed is %d} global406)
				)
				(SetMenu 1026 113 global406)
				(DisposeScript 897)
			)
			(1027
				(= global407
					(= temp41
						((MacGauge new:)
							description:
								{Use the mouse\nto set the\nwait speed.}
							text: {  Wait Speed  }
							topX: 10
							bottomY: 6
							range: 8
							low: 1
							view: 701
							loop: 0
							cel: 1
							start: global407
							doit: global407
						)
					)
				)
				(SetMenu
					1027
					110
					(Format @local60 { Wait Speed is %d} global407)
				)
				(SetMenu 1027 113 global407)
				(DisposeScript 897)
			)
			(1028
				(= gSpeed
					(-
						(= temp41
							((MacGauge new:)
								description:
									{Use the mouse\nto set the\nanimation speed.}
								text: {Animation Speed}
								topX: 10
								bottomY: 6
								range: 8
								low: 1
								view: 701
								loop: 0
								cel: 1
								start: (+ gSpeed 1)
								doit: (+ gSpeed 1)
							)
						)
						1
					)
				)
				(SetMenu
					1028
					110
					(Format @local80 { Animation Speed is %d} (+ 1 gSpeed))
				)
				(SetMenu 1028 113 (+ 1 gSpeed))
				(DisposeScript 897)
			)
			(else
				(gCurRoom handleEvent: event temp42)
				(gSysWindow setBack: 14 setColor: 4)
				(return)
			)
		)
		(event claimed: 1)
		(gSysWindow setBack: 14 setColor: 4)
	)

	(method (doit &tmp temp0))
)

