;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Main)
(use Interface)
(use n417)
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
		sel_368 418
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
		(Class_0_5 sel_119: 441 0 sel_119: 111)
		(gSong sel_39: 801 sel_165: -1)
		(User sel_319: 1 sel_321: 1)
		(aboutGames sel_110: sel_283:)
		(quitGames sel_110: sel_283:)
		(yacht sel_110: sel_283:)
		(dominoes sel_110: sel_283:)
		(= global198 0)
		(= global546 1)
		(gSong sel_164: 70)
		(gSound2 sel_39: 700 sel_165: 1)
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

(instance aboutGames of Class_417_0
	(properties
		sel_20 {aboutGames}
		sel_1 193
		sel_0 170
		sel_2 418
	)

	(method (sel_277)
		(requestHelp sel_110:)
	)
)

(instance quitGames of Class_417_0
	(properties
		sel_20 {quitGames}
		sel_1 271
		sel_0 170
		sel_2 418
		sel_3 1
	)

	(method (sel_277)
		(= gQuit 1)
	)
)

(instance yacht of Class_417_0
	(properties
		sel_20 {yacht}
		sel_1 78
		sel_0 128
		sel_2 418
		sel_3 2
	)

	(method (sel_277)
		(gCurRoom sel_145: goGame 0 0)
	)
)

(instance dominoes of Class_417_0
	(properties
		sel_20 {dominoes}
		sel_1 78
		sel_0 147
		sel_2 418
		sel_3 3
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
		(Print 975 0 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Laura Bow's Parlor Games Team: Director: Bill Davis Producers: Tammy Dargan Tony Caudill Software Supervisor: J. Mark Hood"
		(Print 975 1 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Laura Bow's Parlor Games Team: (Con't) Lead Programmer: Thaddeus M. Pritchard  Quality Assurance: Mike Brosius Special thanks to: Randy MacNeill"
		(Print 975 2 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Parlor Game Team: Executive Producer: Ken Williams Creative Director: Bill Davis Director/Producer: Stuart Moulder Game Designers: Marti McKenn Bridget McKenna"
		(Print 975 3 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Parlor Game Team: (Con't) Art Designer: Jay Friedmann Lead Programmer: Warren Schwader Composer: Rob Atesalp"
		(Print 975 4 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Parlor Game Team: (Con't) Animators: Nathan Larsen, Marc Hudgins, Terrance C. Falls, Michael Hutchinson, Richard Powell"
		(Print 975 5 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Original Parlor Game Team: (Con't) Background Artist: Maurice Morgan Programmers: Michael Brock, Tom DeSalvo, John Harrell, Charles "Chip" Kerchner, Kim Bowdish Music Director: Mark Seibert"
		(Print 975 6 77 {Credits} 27 1 78 { Done } 25 50 26 42 32 SysWindow) ; "Original Parlor Game Team: (Con't) System Development: Jeff Stephenson, Dan Foy, Larry Scott, J. Mark Hood, Mark Wilden, Christopher Smith, Ken Koch Sound Effects: Rob Atesalp Quality Assurance: Dan Woolard"
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
						(= global187 500)
					)
					(1
						(= global187 100)
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
				(if (and (!= gPrevRoomNum 500) (!= gPrevRoomNum 100)) ; unknown_500_0, unknown_100_4
					(Format @temp0 975 8)
					(Format @global150 98 0) ; "Player 1"
					(if (StrCmp @temp0 @global472)
						(StrCpy @global150 @global472)
					)
					(Print 98 4 38 @global150 10 78 @local16 32 SysWindow) ; "Enter your name:"
					(if (not (StrLen @global150))
						(Format @global150 975 9) ; "Player 1"
					)
					(Format @global157 975 10) ; "Laura"
					(StrCpy @global472 @global150)
					(gGame_opt sel_57: 3)
				)
				(= global194 1)
				(= global195 2)
				(= global196 0)
				(= global197 0)
				(gUnknown_0_2 sel_441: 1 sel_2: 1)
				((gUnknown_0_2 sel_439:) sel_2: 1)
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
					(Print 975 11 27 1 78 { More } 32 SysWindow) ; "Other great products: This is just one of the five "Nick's Pick's Budget Games" available. If you are interested in learning more about the other Sierra family of fine software products, call us at 800 326-6654 (or 209 683-4468 outside the United States)."
					(Print 975 12 27 1 78 { Done } 32 SysWindow) ; "Other great products: (Con't) ...More fun and games. As you try to outsmart Laura Bow imagine what fun an entire collection of parlor games would be for you and your family. The Hoyle Book of Games series offers dozens of board and card games with multiple skill levels that keeps them ever challenging. If you're looking for even more challenges be sure to try the Laura Bow Mystery series. These mystery thrillers will keep you on the edge of your keyboard, biting your mouse in suspense. They're not only fun...they can be murder."
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
						(0
							(userHitESC sel_57:)
						)
						(1
							(gCurRoom sel_145: showIconBar)
							(break)
						)
						(2
							(Print ; "To roll dice, click on the ROLL button at the bottom left side of the screen. To keep some or all of the dice for scoring, click on them. They will travel to the bottom of the screen. All dice not at the bottom of the screen will remain in play. Dice can also be moved from the bottom of the screen back into play at any time before you have completed the third roll in a game turn."
								975
								13
								77
								{Help on Yacht}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "When you have completed the third roll in your turn, click on desired score catagory name once to highlight it and once more to lock in the score. Yacht Options: Lock In Selection - ON/OFF When the Lock in Selection option is set to ON, the player must choose a scoring category after the first roll. Regardless of subsequent rolls, in their turns, players must score that category. Default is OFF."
								975
								14
								77
								{Help on Yacht (Con't)}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "Color Cycling - ON/OFF When color cycling is ON, the background colors will slowly cycle. Default is OFF."
								975
								15
								77
								{Help on Yacht (Con't)}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "To choose the dominoes for your hand, click on them. They will be placed in your hand automatically. To play dominoes on the board, click on the domino you want to play and drag it to the desired position on the screen. To take dominoes from the boneyard, click on the BONEYARD button. When the boneyard is empty the button becomes a PASS button. When the game is over the button becomes a SHUFFLE button to begin the next hand."
								975
								16
								77
								{Help on Dominoes}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "Dominoes Options Must Play - ON/OFF If Must Play is ON, a player must make a play if one is possible before drawing a domino from the boneyard. The default setting for this option is OFF. Highest Doublet - ON/OFF If the highest Doublet is ON, the player with the highest value doublet (domino having the same value at both ends) starts the game play by playing the doublet. The default for this option is ON."
								975
								17
								77
								{Help on Dominoes (Con't)}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "Show Boneyard - ON/OFF If Show Boneyard is ON, the dominoes remaining in the boneyard at the end of the game will be displayed. The default setting for this option is OFF."
								975
								18
								77
								{Help on Dominoes (Con't)}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "Boneyard Minimum - 0/2 If Boneyard Minimum is set to 0, players will not be able to pass a turn unless no dominoes remain in the boneyard. If set to 2, players will be able to pass when 2 dominoes remain. The default setting for this option is 0. Dominoes per Hand - 7/5 If Dominoes per Hand is set to 7, each player will draw 7 dominoes before play begins. If set to 5, each player will draw 5. The default setting for this option is 7."
								975
								19
								77
								{Help on Dominoes (Con't)}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "Game Score - 100/200/300/400/500 Game Score can be set in increments of 100 to 500. When either player reaches this score, that player wins the game. The default setting for this option is 100. Default - Default sets all the game options to their default value."
								975
								20
								77
								{Help on Dominoes (Con't)}
								27
								1
								32
								SysWindow
								78
								{ More }
							)
							(Print ; "Using the Keyboard: To position the on-screen cursor using a keyboard, use the "Direction" (arrow) keys on your numeric keypad. You can quickly press and release the direction keys, to move the cursor one increment at a time or press and hold down the keys, releasing them when the cursor reaches the desired screen location. To move the cursor in even smaller increments, hold down the "Shift" key while using the "Direction" keys."
								975
								21
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
								22
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
				(Print 975 23 78 { Show Me } 1) ; "Moving the cursor to the extreme top of the screen (or pressing the "Esc" key) will bring up the control bar. Moving the cursor away from the top of the screen (or pressing the "Esc" key a second time) will put it away."
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

(instance userHitESC of Code
	(properties
		sel_20 {userHitESC}
	)

	(method (sel_57)
		(Print 975 24 78 {Ok, sorry.} 1 32 SysWindow 77 {OOOPPPS...}) ; "You did something that I wasn't expecting and to be quite honest, I'm not sure how to deal with it. Please use the designated buttons instead of using other keys."
	)
)

