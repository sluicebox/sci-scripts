;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Main)
(use Interface)
(use Button)
(use PseudoMouse)
(use n940)
(use Window)
(use Game)
(use User)
(use System)

(public
	chooseGame 0
)

(local
	[local0 15]
	local15
	[local16 10]
	local26
)

(instance chooseGame of Rm
	(properties
		sel_20 {chooseGame}
		sel_368 417
		sel_28 10
	)

	(method (sel_110 &tmp [temp0 11])
		(= gPMouse PseudoMouse)
		(gSong sel_162: startSong)
		(super sel_110:)
		(= gUseSortedFeatures 0)
		(gGame sel_191: 982 1)
		(gTheIconBar sel_170:)
		(Format @local16 98 5) ; "OK"
		(gSound sel_99: 1)
		(= local15 0)
		(Characters sel_119: 441 0 sel_119: 111)
		(gSong sel_39: 801 sel_165: -1)
		(User sel_319: 1 sel_321: 1)
		(aboutGames sel_110: sel_283:)
		(quitGames sel_110: sel_283:)
		(backgammon sel_110: sel_283:)
		(checkers sel_110: sel_283:)
		(= global198 0)
		(= global546 1)
		(gSong sel_164: 70)
		(gSound2 sel_39: 700 sel_165: 1)
		(gGame sel_365: 13)
	)

	(method (sel_57)
		(super sel_57:)
		(if (and global546 (== (gSound2 sel_157:) -1))
			(= global546 0)
			(gSong sel_164: 127)
		)
	)

	(method (sel_277)
		(return 0)
	)

	(method (sel_111)
		(super sel_111: &rest)
		(= gPMouse 0)
		(DisposeScript 933)
		(gTheIconBar sel_170:)
		(DisposeScript 417)
		(DisposeScript 940)
		(DisposeScript 418)
	)
)

(instance startSong of Script
	(properties
		sel_20 {startSong}
	)

	(method (sel_144)
		(switch global187
			(100
				(gSong sel_39: 805)
			)
			(200
				(gSong sel_39: 803)
			)
			(300
				(gSong sel_39: 802)
			)
			(400
				(gSong sel_39: 806)
			)
			(500
				(gSong sel_39: 804)
			)
		)
	)
)

(instance aboutGames of Button
	(properties
		sel_20 {aboutGames}
		sel_1 193
		sel_0 170
		sel_2 417
	)

	(method (sel_277)
		(requestHelp sel_110:)
	)
)

(instance quitGames of Button
	(properties
		sel_20 {quitGames}
		sel_1 271
		sel_0 170
		sel_2 417
		sel_3 1
	)

	(method (sel_277)
		(= gQuit 1)
	)
)

(instance backgammon of Button
	(properties
		sel_20 {backgammon}
		sel_1 78
		sel_0 108
		sel_2 417
		sel_3 3
	)

	(method (sel_277)
		(gCurRoom sel_145: goGame 0 0)
	)
)

(instance checkers of Button
	(properties
		sel_20 {checkers}
		sel_1 78
		sel_0 127
		sel_2 417
		sel_3 2
	)

	(method (sel_277)
		(gCurRoom sel_145: goGame 0 1)
	)
)

(instance displayCredits of Code
	(properties
		sel_20 {displayCredits}
	)

	(method (sel_57)
		(gGame sel_365: 0)
		(gSystemWindow sel_25: 50 sel_26: 42)
		(Print 975 0 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "King Graham's Board Game Challenge Team: Director: Bill Davis Producers: Tammy Dargan Tony Caudill Software Supervisor: J. Mark Hood"
		(Print 975 1 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "King Graham's Board Game Challenge Team: (Con't) Lead Programmer: Thaddeus M. Pritchard  Quality Assurance: Mike Brosius Special thanks to: Randy MacNeill"
		(Print 975 2 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: Executive Producer: Ken Williams Creative Director: Bill Davis Director/Producer: Stuart Moulder Game Designers: Marti McKenn Bridget McKenna"
		(Print 975 3 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: (Con't) Art Designer: Jay Friedmann Lead Programmer: Warren Schwader Composer: Rob Atesalp"
		(Print 975 4 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: (Con't) Animators: Nathan Larsen, Marc Hudgins, Terrance C. Falls, Michael Hutchinson, Richard Powell"
		(Print 975 5 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: (Con't) Background Artist: Maurice Morgan Programmers: Michael Brock, Tom DeSalvo, John Harrell, Charles "Chip" Kerchner, Kim Bowdish Music Director: Mark Seibert"
		(Print 975 6 77 {Credits} 27 1 78 { Done } 25 50 26 42 32 SysWindow) ; "Original Board Game Challenge Team: (Con't) System Development: Jeff Stephenson, Dan Foy, Larry Scott, J. Mark Hood, Mark Wilden, Christopher Smith, Ken Koch Sound Effects: Rob Atesalp Quality Assurance: Dan Woolard"
		(gGame sel_365: 12)
	)
)

(instance goGame of Script
	(properties
		sel_20 {goGame}
	)

	(method (sel_143 param1 &tmp [temp0 10])
		(switch (= sel_29 param1)
			(0
				(= sel_135 2)
			)
			(1
				(switch sel_140
					(0
						(= global187 300)
					)
					(1
						(= global187 200)
					)
				)
				(= sel_135 1)
			)
			(2
				(= local26
					(Print ; "Select difficulty level..."
						975
						7
						78
						{Beginner}
						0
						78
						{Average}
						1
						78
						{Expert}
						2
					)
				)
				(if (and (!= gPrevRoomNum 300) (!= gPrevRoomNum 200)) ; backgam, checkers
					(Format @temp0 975 8)
					(Format @global150 98 0) ; "Player 1"
					(if (StrCmp @temp0 @global472)
						(StrCpy @global150 @global472)
					)
					(Print 98 4 38 @global150 10 78 @local16 32 SysWindow) ; "Enter your name:"
					(if (not (StrLen @global150))
						(Format @global150 975 9) ; "Player 1"
					)
					(StrCpy @global472 @global150)
					(gGame_opt sel_57: 3)
				)
				(= global194 1)
				(= global195 2)
				(gChar1 sel_441: 1 sel_2: 3)
				((gChar1 sel_439:) sel_2: 3)
				(= gNewRoomNum global187)
				(gCurRoom sel_358: global187)
				(proc0_4)
				(self sel_111:)
			)
		)
	)
)

(instance requestHelp of Obj
	(properties
		sel_20 {requestHelp}
	)

	(method (sel_110 param1 param2 param3 param4 param5 param6 param7)
		(= param4 (gSystemWindow sel_25:))
		(= param5 (gSystemWindow sel_26:))
		(super sel_110:)
		(self sel_57: param1 param2 param3 param4 param5 param6 param7)
	)

	(method (sel_57 param1 param2 param3)
		(ScriptID 940)
		(repeat
			(gSystemWindow sel_25: 0 sel_26: 43)
			(switch
				(= param3
					(PrintD
						{Select...}
						109
						78
						{Instructions}
						4
						109
						78
						{Sierra}
						1
						109
						78
						{Credits}
						2
						109
						78
						{Quit About}
						3
					)
				)
				(1
					(Print 975 10 27 1 78 { More } 32 SysWindow) ; "Other great products: This is just one of the five "Nick's Pick's Budget Games" available. If you are interested in learning more about the other Sierra family of fine software products, call us at 800 326-6654 (or 209 683-4468 outside the United States)."
					(Print 975 11 27 1 78 { More } 32 SysWindow) ; "Other great products: (Con't) ...More fun and games. Good King Graham is not only a good king, he's a darn good game opponent. Imagine what fun an entire collection of parlor games would be for you and your family. The Hoyle Book of Games series offers dozens of board and card games with multiple skill levels that keeps them ever challenging."
					(Print 975 12 27 1 78 { Done } 32 SysWindow) ; "Other great products: (Con't) If you have the courage into the world of the King's Quest series. All the episodes have consistent themes of wholesome game adventure that have challenged adults for almost a decade. This award-winning series has been proclaimed "...the best-selling family computer game series of all time.""
				)
				(2
					(displayCredits sel_57:)
					(break)
				)
				(3
					(gSystemWindow sel_25: 0 sel_26: 52)
					(break)
				)
				(4
					(gSystemWindow sel_25: 0 sel_26: 43)
					(switch
						(= param2
							(PrintD
								{Select...}
								109
								78
								{Control Bar}
								1
								109
								78
								{Game Help}
								2
							)
						)
						(1
							(gCurRoom sel_145: showIconBar)
							(break)
						)
						(2
							(Print ; "Play Backgammon by clicking on the playing pieces and dragging them to the desired position onscreen. To roll dice, click on the dice on the left hand side of the screen. To double, click on the doubling cube (when the doubling option is turned to ON). Backgammon Options: Doubling cube - ON/OFF If the Doubling Cube option is set to ON, players will have the option to double the game stakes at the beginning at their turn."
								975
								13
								77
								{Help on Backgammon}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "Play Checkers by clicking on the playing pieces and dragging them to the desired squares."
								975
								14
								77
								{Help on Checkers}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "Using the Keyboard: To position the on-screen cursor using a keyboard, use the "Direction" (arrow) keys on your numeric keypad. You can quickly press and release the direction keys, to move the cursor one increment at a time or press and hold down the keys, releasing them when the cursor reaches the desired screen location. To move the cursor in even smaller increments, hold down the "Shift" key while using the "Direction" keys."
								975
								15
								77
								{Using a Keyboard:}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "Once you reach the desired location, press the "Enter" or "Return" key to select or implement. To activate the "Control Bar", press the "Escape" (Esc) key. Use the "Direction" and "Enter" (or "Return") keys to move the cursor and select, as described previously. Once the "Control Bar" is activated, the "Tab" key can also be used to cycle the cursor through the different selection buttons, from left to right. (This method for moving the cursor can also be used in many of the requester windows).  Press "Escape" a second time to close the "Control Bar"."
								975
								16
								77
								{Using a Keyboard: (Con't)}
								27
								1
								32
								SysWindow
								78
								{ Done }
							)
						)
					)
				)
			)
		)
		(gSystemWindow sel_25: 0 sel_26: 52)
	)
)

(instance showIconBar of Script
	(properties
		sel_20 {showIconBar}
	)

	(method (sel_143 param1 &tmp temp0)
		(switch (= sel_29 param1)
			(0
				(proc0_4)
				(Print 975 17 78 { Show Me } 1) ; "Moving the cursor to the extreme top of the screen (or pressing the "Esc" key) will bring up the control bar. Moving the cursor away from the top of the screen (or pressing the "Esc" key a second time) will put it away."
				(= sel_136 1)
			)
			(1
				(SetCursor 150 0)
				(= sel_135 30)
			)
			(2
				(proc0_3)
				(gGame sel_191: 982)
				(self sel_111:)
			)
		)
	)
)

