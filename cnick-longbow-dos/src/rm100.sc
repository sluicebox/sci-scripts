;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use Interface)
(use Button)
(use n940)
(use Window)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	local0
	local1
)

(instance rm100 of Rm
	(properties
		sel_20 {rm100}
		sel_399 900
		sel_28 10
	)

	(method (sel_110)
		(if (not gPrevRoomNum)
			(gRgnMusic sel_40: 417 sel_3: 1 sel_39:)
		)
		(Load rsPIC 417)
		(gGame sel_395: 13)
		(proc0_3)
		(if (or gPrevRoomNum (GameIsRestarting))
			(= sel_399 417)
		)
		(super sel_110: &rest)
		(= gUseSortedFeatures 0)
		(gTheIconBar sel_178: sel_211: -100 sel_221: -100)
		(proc0_4)
		(User sel_339: 1 sel_229: 0)
		(gGame sel_198: 720)
		(self sel_146: startScript)
	)

	(method (sel_292)
		(if (gCurRoom sel_142:)
			(switch (gCurRoom sel_142:)
				(startScript
					(if (< (startScript sel_29:) 1)
						(startScript sel_144: 1)
					)
				)
			)
		)
	)

	(method (sel_111)
		(super sel_111:)
		(DisposeScript 417)
	)

	(method (sel_390)
		(super sel_390: &rest)
		(gGame sel_198: gWaitCursor)
		(gSounds sel_119: 168)
		(gSystemWindow sel_25: 0 sel_26: 42)
	)

	(method (sel_57)
		(super sel_57:)
		(if (== (gCurRoom sel_396:) 900)
			(Palette palANIMATE 95 218 -1)
		)
		(cond
			((and (== (gRgnMusic sel_166:) 20) (not local0))
				(= local0 1)
				(sparkle sel_153: 216 157 sel_110:)
			)
			((and (== (gRgnMusic sel_166:) 30) (not local1))
				(= local1 1)
				(sparkle sel_153: 65 156 sel_110:)
			)
			((and (== (gRgnMusic sel_166:) -1) (= local1 1))
				(startScript sel_145:)
			)
		)
	)
)

(instance startScript of Script
	(properties
		sel_20 {startScript}
	)

	(method (sel_110)
		(if gPrevRoomNum
			(= sel_134 1)
		)
		(super sel_110: &rest)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0 0)
			(1
				(if (< global103 2)
					(gRgnMusic sel_168:)
				else
					(gRgnMusic sel_171:)
				)
				(gCurRoom sel_408: 417 10)
				(= sel_137 3)
			)
			(2
				(aboutGames sel_110: sel_304:)
				(quitGames sel_110: sel_304:)
				(archery sel_110: sel_304:)
				(sticks sel_110: sel_304:)
				(nineMens sel_110: sel_304:)
				(= sel_137 1)
			)
			(3
				(gRgnMusic2 sel_40: 100 sel_39:)
				(gTheIconBar sel_214: (gTheIconBar sel_64: 2))
				(proc0_4)
				(gGame sel_198: 720)
				(= sel_136 3)
			)
			(4
				(self sel_111:)
			)
		)
	)
)

(instance requestHelp of Obj
	(properties
		sel_20 {requestHelp}
	)

	(method (sel_110 param1 param2 param3 param4)
		(= param3 (gSystemWindow sel_25:))
		(= param4 (gSystemWindow sel_26:))
		(gGame sel_395: 0)
		(super sel_110:)
		(self sel_57: param1 param2 param3 param4)
	)

	(method (sel_57 param1 param2 param3 param4)
		(repeat
			(gSystemWindow sel_25: 0 sel_26: 42)
			(switch
				(= param2
					(PrintD
						{Select...}
						109
						78
						{Game Help}
						1
						109
						78
						{Credits}
						2
						109
						78
						{Sierra}
						4
						109
						78
						{Quit About}
						3
					)
				)
				(1
					(= param1 0)
					(= param3 (gSystemWindow sel_25:))
					(= param4 (gSystemWindow sel_26:))
					(gSystemWindow sel_25: 0 sel_26: 42)
					(repeat
						(switch
							(= param1
								(PrintD
									{Select game to receive help on:}
									109
									78
									{ Archery }
									200
									109
									78
									{ Nine Men Morris }
									541
									109
									78
									{ Sticks }
									543
									109
									78
									{ Exit Help }
									417
									77
									{Help}
								)
							)
							(200
								(Print ; "Eye Cursor: You may click the Eye Cursor onto an object you wish to look at in more detail. Walk Cursor: To exit the game of Archery, click the Walk Cursor onto either the right or left edge of the screen. Point of View Archery: (where you're sighting down your nocked arrow ready to fire.)"
									100
									0
									32
									cluckWindow
									27
									1
									77
									{Help on Archery}
									78
									{ More }
								)
								(Print ; "The Bow Cursor is moved up, down, left and right until your arrow head is positioned where you want it, then clicking will fire the arrow. Click on your bow hand to load another arrow if you wish to fire again."
									100
									1
									32
									cluckWindow
									27
									1
									77
									{Help on Archery (Con't)}
									78
									{ More }
								)
								(Print ; "Click the right mouse button to cycle through the available cursors, on multi-button mice. On a single button mouse, hold down the "Shift" key while clicking the button."
									100
									2
									32
									cluckWindow
									27
									1
									77
									{Help on Archery (Con't)}
									78
									{ More }
								)
								(Print ; "Using a keyboard: Use the number "5" key on your numeric keypad to cycle through the various cursors. To position the on-screen cursor using a keyboard, use the "Direction" (arrow) keys on your numeric keypad. You can quickly press and release the direction keys, to move the cursor one increment at a time or press and hold down the keys, releasing them when the cursor reaches the desired screen location. To move the cursor in even smaller increments, hold down the "Shift" key while using the "Direction" keys."
									100
									3
									32
									cluckWindow
									27
									1
									77
									{Help on Archery (Con't)}
									78
									{ More }
								)
								(Print ; "Once you reach the desired location, press the "Enter" or "Return" key to select or implement. In many requester windows, the "Tab" key may be used, in leu of the "Direction" keys, to cycle the cursor through the various selections."
									100
									4
									32
									cluckWindow
									27
									1
									77
									{Help on Archery (Con't)}
									78
									{ Done }
								)
							)
							(541
								(Print ; "Nine Men's Morris is a two person game. Each player has nine pieces.There are 24 "points" on the board where piece may be placed. These are the corners of the squares and the places where the connecting lines intersect."
									100
									5
									32
									cluckWindow
									27
									1
									77
									{Help on Nine Men Morris}
									78
									{ More }
								)
								(Print ; "The object of the game is to create "mills" and remove your opponent's pieces from the board until he only has 2 pieces left or is unable to make any moves. A "mill" is 3 of the same player's pieces laid in a row with no vacant points between them. Pieces that line up diagonally or without being connected by a line do not count. Each time a player moves one of his pieces so that he creates a new mill, he can remove one of his oponent's pieces."
									100
									6
									32
									cluckWindow
									27
									1
									77
									{Help on Nine Men Morris (Con't)}
									78
									{ More }
								)
								(Print ; "To begin, the first player places 1 piece on any vacant point (remember, there are 24 points). Then the other player places 1 piece. The players take turns placing pieces until all 9 pieces have been placed on the board. While the players put down the 9 pieces, each one should be trying to do two things: create a mill and/or prevent the other player from creating a mill."
									100
									7
									32
									cluckWindow
									27
									1
									77
									{Help on Nine Men Morris (Con't)}
									78
									{ More }
								)
								(Print ; "Once all remaining pieces (not counting any lost because the opponent created a mill) have been placed on the board, the second part of the game is for the players to continue taking turns moving 1 of their pieces to an adjacent vacant point on the board. A player may not jump over his own or another player's piece and moves must be made along the lines only. A piece cannot jump across spaces. A player who has made a mill may not take a piece from one of his opponent's mills unless there are no other pieces to take."
									100
									8
									32
									cluckWindow
									27
									1
									77
									{Help on Nine Men Morris (Con't)}
									78
									{ More }
								)
								(Print ; "A new mill may be formed by a player moving one of his pieces from an existing mill (so it's no longer a mill) in one turn and moving it back into the same place to recreate the mill on his next turn (provided the other player doesn't block the space in the meantime.) Walk Cursor: To exit the game of Nine Men's Morris, click the Walk Cursor onto either the right or left edge of the screen."
									100
									9
									32
									cluckWindow
									27
									1
									77
									{Help on Nine Men Morris (Con't)}
									78
									{ More }
								)
								(Print ; "Hand Cursor: To move the game pieces into play, click the cursor on the desired game board location. When all nine game pieces are on the board, reposition pieces by moving the cursor over the piece, clicking and holding down the mouse button while you move the cursor to the new location, and then, releasing the button.  Click on opponent's game pieces to remove them. Click the right mouse button to cycle through the available cursors, on multi- button mice. On a single button mouse, hold down the "Shift" key while clicking the button."
									100
									10
									32
									cluckWindow
									27
									1
									77
									{Help on Nine Men Morris (Con't)}
									78
									{ More }
								)
								(Print ; "Using a Keyboard: Use the "5" on your numeric keypad to cycle through the various cursors. Use the "Direction" (arrow) keys, on your numeric keypad, to move the "Hand" cursor to the location, on the game board, where you want to position your game piece.  Press "Enter" (or "Return") to drop the game piece. Once all game pieces are located on the game board, you will need to use the "Hand" cursor and "Enter" keys to select each piece to be moved. Then move the cursor to the new location and press "Enter" to drop the game piece there."
									100
									11
									32
									cluckWindow
									27
									1
									77
									{Help on Nine Men Morris (Con't)}
									78
									{ More }
								)
								(Print ; "To remove the opponent's game pieces, use the "Direction" keys to move the cursor onto the piece and press "Enter". In many requester windows, the "Tab" key may be used, in leu of the "Direction" keys, to cycle the cursor through the various selections."
									100
									12
									32
									cluckWindow
									27
									1
									77
									{Help on Nine Men Morris (Con't)}
									78
									{ Done }
								)
							)
							(543
								(Print ; "You have 4 offensive moves (strikes) and 4 defensive moves (parries, ducking and jumping). Offensive Moves: Overhead Great Blow - This move brings your staff down from high overhead. This is your most powerful blow, but it also leaves your guard wide open for a counter attack. To execute move, click above your foe's head."
									100
									13
									32
									cluckWindow
									77
									{Help on Sticks}
									78
									{ More }
								)
								(Print ; "Head Strike - Strikes at your foe's head. To execute move, click on your foe's head. Body Strike - Strikes at your foe's mid-torso. To execute move, click on your foe's body. Leg Strike - Strikes at your foe's lower legs. To execute move, click below your foe's knees."
									100
									14
									32
									cluckWindow
									77
									{Help on Sticks (Con't)}
									78
									{ More }
								)
								(Print ; "Defensive Moves Overhead Great Blow Parry - Parries with staff above the head to stop your foe's most powerful attack. To execute move, click above Robin's head. Ducking Head - Causes you to duck beneath your foe's strike at your head. To execute move, click on Robin's head."
									100
									15
									32
									cluckWindow
									77
									{Help on Sticks (Con't)}
									78
									{ More }
								)
								(Print ; "Body Parry - Parries with staff an attack at your mid torso. To execute move, click on Robin's body. Jumping up to avoid Leg Strike - Causes you to jump up and avoid your foe's attempt to strike your legs. To execute move, click below Robin's knees. Press the "F9" key to quit."
									100
									16
									32
									cluckWindow
									77
									{Help on Sticks (Con't)}
									78
									{ More }
								)
								(Print ; "Using a Keyboard: If you have only a keyboard, use numerical keys as follows: 1 - Jumping up to avoid Leg Strike 2 - Overhead Great Blow Parry 3 - Leg Strike 4 - Body Parry 6 - Body Strike 7 - Ducking Head 8 - Overhead Great Blow Press the "F9" key to quit."
									100
									17
									32
									cluckWindow
									77
									{Help on Sticks (Con't)}
									78
									{ Done }
								)
							)
							(417
								(break 2)
							)
						)
					)
				)
				(2
					(displayCredits sel_57:)
					(break)
				)
				(3
					(break)
				)
				(4
					(Print ; "This is just one of the five "Nick's Pick's Budget Games" available. If you are interested in learning more about the other Sierra family of fine software products, call us at 800 326-6654 (or 209 683-4468 outside the United States)."
						100
						18
						32
						cluckWindow
						77
						{Other great products...}
						78
						{ More }
						27
						1
					)
					(Print ; "...More fun and games. Once you become a skilled archer and an expert on the ways of medieval life, take your talents into a whole new world. The Conquests series (Conquest of the Longbow: The Legend of Robin Hood, and Conquest of Camelot: The Search for the Grail) combine fantasies of legends with solid historical research. You'll love your journey through 3-D cinemagraphic adventures as you bravely explore the challenges, intrigues and romances of the days of yore."
						100
						19
						32
						cluckWindow
						77
						{Other great products...}
						78
						{ Done }
						27
						1
					)
				)
			)
		)
		(gSystemWindow sel_25: 0 sel_26: 42)
		(gGame sel_395: 13)
	)
)

(instance displayCredits of Code
	(properties
		sel_20 {displayCredits}
	)

	(method (sel_57)
		(gSystemWindow sel_25: 50 sel_26: 42)
		(Print ; "Robin Hood's Games of Skill and Chance Team: Director: Bill Davis Producers: Tammy Dargan Tony Caudill Software Supervisor: J. Mark Hood"
			100
			20
			77
			{Credits}
			27
			1
			78
			{ More }
			25
			50
			26
			42
			32
			cluckWindow
		)
		(Print ; "Robin Hood's Games of Skill and Chance Team: (Con't) Lead Programmer: Thaddeus M. Pritchard  Quality Assurance: Mike Brosius Special thanks to: Randy MacNeill"
			100
			21
			77
			{Credits}
			27
			1
			78
			{ More }
			25
			50
			26
			42
			32
			cluckWindow
		)
		(Print ; "Original Conquests of the Longbow Team: Executive Producer: Ken Williams Creative Director: Bill Davis Director: Christy Marx Producer: Guruka Singh Khalsa"
			100
			22
			77
			{Credits}
			27
			1
			78
			{ More }
			25
			50
			26
			42
			32
			cluckWindow
		)
		(Print ; "Original Conquests of the Longbow Team: (Con't) Art Designer: Kenn Nishiuye Lead Programmer: Richard Aronson Composer: Mark Seibert"
			100
			23
			77
			{Credits}
			27
			1
			78
			{ More }
			25
			50
			26
			42
			32
			cluckWindow
		)
		(Print ; "Original Conquests of the Longbow Team: (Con't) Artists: Gerald Moore, Ernie Chan, Eric Kasner, Deanna Yhalkee, Al Roughton, Tamra Dayton, Frankie Powell, Arturo Sinclair, Diana Wilson Programmers: Bob Fischbach, Robert Lee Mallory, Todd Powers, Vana Baker, Cynthia L. Goff, Yoko Hayashi, J.Mark Hood, Kris Shankar"
			100
			24
			77
			{Credits}
			27
			1
			78
			{ More }
			25
			50
			26
			42
			32
			cluckWindow
		)
		(Print ; "Original Conquests of the Longbow Team: (Con't) Development Systems: Jeff Stephenson, Bob Heitman, Corey Cole, John Hartin, Dan Foy, John Rettig Sound Effects: Mark Seibert Combat System: Douglas Herring, Richard Aronson"
			100
			25
			77
			{Credits}
			27
			1
			78
			{ Done }
			25
			50
			26
			42
			32
			cluckWindow
		)
	)
)

(instance aboutGames of Button
	(properties
		sel_20 {aboutGames}
		sel_1 196
		sel_0 169
		sel_2 417
	)

	(method (sel_292)
		(requestHelp sel_110:)
	)
)

(instance quitGames of Button
	(properties
		sel_20 {quitGames}
		sel_1 270
		sel_0 169
		sel_2 417
		sel_3 1
	)

	(method (sel_292)
		(= gQuit 1)
	)
)

(instance archery of Button
	(properties
		sel_20 {archery}
		sel_1 79
		sel_0 112
		sel_2 417
		sel_3 2
	)

	(method (sel_292)
		(gCurRoom sel_390: 200)
	)
)

(instance nineMens of Button
	(properties
		sel_20 {nineMens}
		sel_1 79
		sel_0 129
		sel_2 417
		sel_3 4
	)

	(method (sel_292)
		(gCurRoom sel_390: 540)
	)
)

(instance sticks of Button
	(properties
		sel_20 {sticks}
		sel_1 79
		sel_0 146
		sel_2 417
		sel_3 3
	)

	(method (sel_292)
		(gCurRoom sel_390: 130)
	)
)

(instance sparkle of Prop
	(properties
		sel_20 {sparkle}
		sel_2 960
	)

	(method (sel_110)
		(self sel_155: 2 sel_4: 0 sel_307: sel_63: 14 sel_162: End)
		(super sel_110: &rest)
	)
)

(instance cluckWindow of SysWindow
	(properties
		sel_20 {cluckWindow}
		sel_26 42
	)
)

