;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use Interface)
(use Button)
(use n940)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm100 0
)

(instance rm100 of Rm
	(properties
		picture 900
		style 10
	)

	(method (init)
		(super init: &rest)
		(gGame masterVolume: 15)
		(LoadMany rsVIEW 417)
		(if (or gPrevRoomNum (GameIsRestarting))
			(= picture 417)
		)
		(proc0_2)
		(gTheIconBar enable: disable: 1 2 height: -100 activateHeight: -100)
		(= gUseSortedFeatures 0)
		(self setScript: startScript)
	)

	(method (doVerb)
		(switch (gCurRoom script:)
			(startScript
				(if (< (startScript state:) 1)
					(startScript changeState: 1)
				)
			)
			(else 0)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (gCurRoom curPic:) 900)
			(Palette palANIMATE 95 218 -1)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 417)
	)

	(method (newRoom)
		(= gUseSortedFeatures 1)
		(if (< global107 2)
			(gLongSong stop:)
		else
			(gLongSong fade:)
		)
		(proc0_2)
		(gGame setCursor: gWaitCursor)
		(super newRoom: &rest)
	)
)

(instance startScript of Script
	(properties)

	(method (init)
		(proc0_2)
		(proc0_32)
		(if gPrevRoomNum
			(proc0_29)
			(= start 1)
		)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gLongSong setLoop: -1)
				(gSounds eachElementDo: #stop)
				(gCurRoom drawPic: 417 10)
				(= cycles 5)
			)
			(2
				(aboutGames init:)
				(quitGames init:)
				(cond
					((< global158 1)
						(loan init: posn: 76 109)
					)
					((< global158 10)
						(slotMachine init: posn: 77 103)
						(blackJack init: posn: 77 120)
						(poker init: posn: 77 137)
						(loan init: posn: 77 154)
					)
					(else
						(blackJack init: posn: 77 120)
						(poker init: posn: 77 137)
						(slotMachine init: posn: 77 103)
					)
				)
				(= cycles 20)
			)
			(3
				(gLongSong number: 1 loop: -1 play: 40)
				(proc0_32 721)
				(slotMachine stopUpd:)
				(blackJack stopUpd:)
				(poker stopUpd:)
				(aboutGames stopUpd:)
				(quitGames stopUpd:)
				(if (loan isNotHidden:)
					(loan stopUpd:)
				)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance aboutGames of Button
	(properties
		x 197
		y 170
		view 417
	)

	(method (doVerb)
		(requestHelp init: &rest)
	)
)

(instance quitGames of Button
	(properties
		x 274
		y 170
		view 417
		loop 1
	)

	(method (doVerb)
		(= gQuit 1)
	)
)

(instance slotMachine of Button
	(properties
		x 77
		y 103
		view 417
		loop 2
	)

	(method (doVerb)
		(gCurRoom newRoom: 260)
	)
)

(instance blackJack of Button
	(properties
		x 77
		y 120
		view 417
		loop 3
	)

	(method (doVerb)
		(gCurRoom newRoom: 250)
	)
)

(instance poker of Button
	(properties
		x 77
		y 137
		view 417
		loop 4
	)

	(method (doVerb)
		(gCurRoom newRoom: 720)
	)
)

(instance loan of Button
	(properties
		x 77
		y 154
		view 417
		loop 5
	)

	(method (doVerb)
		(loanOffice doit:)
	)
)

(instance loanOffice of Code
	(properties)

	(method (doit &tmp temp0 [temp1 200])
		(super doit:)
		(cond
			((< global158 1)
				(= temp0 1212)
			)
			((< global158 10)
				(= temp0 1211)
			)
		)
		(switch temp0
			(1211
				(repeat
					(switch
						(Print ; "Do you wish to take a loan out for more money? (Note: this requires you pay it back later.)"
							100
							0
							#mode
							1
							#window
							SysWindow
							#title
							{Loan}
							#button
							{Sure!}
							1
							#button
							{Naw}
							2
						)
						(1
							(if (< global149 10)
								(++ global149)
								(Format ; "Outstanding Loans: %d Total amount owed: $%d.00 Loans available: %d"
									@temp1
									100
									1
									global149
									(* global149 100)
									(- 10 global149)
								)
								(Print
									@temp1
									27
									1
									77
									{Loan Shark's Office}
									32
									SysWindow
									78
									{ Done }
								)
								(Printf 100 2 (+= global158 100)) ; "You now have %d.00 Larry Dollars!!"
								(winSound play:)
								(loan dispose:)
							else
								(Format ; "Outstanding Loans: %d Total amount owed: $%d.00 Loans available: %d"
									@temp1
									100
									1
									global149
									(* global149 100)
									0
								)
								(Print
									@temp1
									27
									1
									77
									{Loan Shark's Office}
									32
									SysWindow
									78
									{ Done }
								)
							)
							(winSound play:)
							(break)
						)
						(2
							(Print 100 3) ; "Alright, suit yourself!"
							(break)
						)
					)
				)
			)
			(1212
				(if (< global149 10)
					(++ global149)
					(winSound play:)
					(Format ; "Outstanding Loans: %d Total amount owed: $%d.00 Loans available: %d"
						@temp1
						100
						1
						global149
						(* global149 100)
						(- 10 global149)
					)
					(winSound play:)
					(Print
						@temp1
						27
						1
						77
						{Loan Shark's Office}
						32
						SysWindow
						78
						{ Done }
					)
					(Printf 100 2 (+= global158 100)) ; "You now have %d.00 Larry Dollars!!"
				else
					(Format @temp1 100 1 global149 (* global149 100) 0) ; "Outstanding Loans: %d Total amount owed: $%d.00 Loans available: %d"
					(Print
						@temp1
						27
						1
						77
						{Loan Shark's Office}
						32
						SysWindow
						78
						{Done}
					)
					(Print 100 4 #mode 1) ; "We are sorry to advise you that your loan has been turned down for the following reasons: -- Your credit is maxed out... We'll start the entire game over for you."
					(gGame restart:)
				)
				(winSound play:)
				(slotMachine init: stopUpd:)
				(blackJack init: stopUpd:)
				(poker init: stopUpd:)
				(loan dispose:)
			)
		)
	)
)

(instance displayCredits of Code
	(properties)

	(method (doit)
		(gGame masterVolume: 0)
		(gSystemWindow color: 50 back: 42)
		(Print 100 5 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Leisure Suit Larry 's Casino Team: Director: Bill Davis Producers: Tammy Dargan Tony Caudill Software Supervisor: J. Mark Hood"
		(Print 100 6 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Leisure Suit Larry 's Casino Team: (Con't) Lead Programmer: Thaddeus M. Pritchard  Quality Assurance: Mike Brosius Special thanks to: Randy MacNeill"
		(Print 100 7 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: Executive Producer: Ken Williams Creative Director: Bill Davis Director/Game Designer: Al Lowe Producer: Guruka Singh Khalsa"
		(Print 100 8 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: (Con't) Production Designer: Andy Hoyos Art Designer: Jane Cardinal Lead Programmer: Brian K. Hughes Composer: Craig Safan"
		(Print 100 9 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: (Con't) Art Team Manager: Cheryl Loyd Animators: Barry T. Smith, Roger Hardy, Jr., Dana M. Dean, Karin Young, Marc Hudgins, Eric Kasner, Richard Powell, Phyllis Cucchiara, Terry C. Falls, Michael Hutchison, Desie Hartman, Willis Wong Background Artists: Maurice Morgan, Jay Friedman, Jennifer Shontz, Gloria Garland"
		(Print 100 10 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: (Con't) Programmers: Carlos Escobar, Steve Conrad, John Hartin, Oliver Breslford Music Director: Mark Seibert Additional Music: Chris Braymen"
		(Print 100 11 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work Team: (Con't) System Development: Jeff Stephenson, Robert E. Heitman, Dan Foy, Larry Scott, John Rettig, J. Mark Hood, Christopher Smith, Terry McHenry, Eric Hart, Chad Bye, Mark Wilden, Ken Koch, John Crane"
		(Print 100 12 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: Executive Producer: Ken Williams Creative Director: Bill Davis Director/Game Designer: Al Lowe Producer: Stuart Moulder"
		(Print 100 13 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: (Con't) Art Designer: William D. Skirvin Lead Programmer: Oliver Breslford Music Director: Mark Seibert"
		(Print 100 14 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: (Con't) Animators: Barry T. Smith, Jennifer Shontz, Roger Hardy, Jr., Eric Apel, Russell Truelove, Desie Hartman Background Artists: Jay Allan Friedmann, Jennifer Shontz, Jane Cardinal, Maurice Morgan"
		(Print 100 15 77 {Credits} 27 1 78 { More } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: (Con't) Programmer: Mike Larsen Composer: Chris Braymen System Development: J. Mark Hood, Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, Dan Foy, Larry Scott, Mark Wilden, Eric Hart, Christopher Smith"
		(Print 100 16 77 {Credits} 27 1 78 { Done } 32 cluckWindow) ; "Original Leisure Suit Larry In The Land of The Lounge Lizards Team: (Con't) Sound Effects: Chris Braymen, Orpheus Hanley Quality Assurance: Mike Pickhinke"
		(gGame masterVolume: 12)
	)
)

(instance winSound of Sound
	(properties
		number 724
	)
)

(instance sparkle of Prop ; UNUSED
	(properties
		view 950
	)

	(method (init)
		(self setLoop: 2 cel: 0 ignoreActors: setPri: 14 setCycle: End)
		(super init:)
	)
)

(instance cluckWindow of SysWindow
	(properties
		back 42
	)
)

(instance requestHelp of Obj
	(properties)

	(method (init param1 param2 param3 param4)
		(= param3 (gSystemWindow color:))
		(= param4 (gSystemWindow back:))
		(gGame masterVolume: 0)
		(super init:)
		(self doit: param1 param2 param3 param4)
	)

	(method (doit param1 param2)
		(repeat
			(gSystemWindow color: 0 back: 42)
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
					(gSystemWindow color: 0 back: 42)
					(Print ; "Using the Keyboard: To position the on-screen cursor using a keyboard, use the "Direction" (arrow) keys on your numeric keypad. You can quickly press and release the direction keys, to move the cursor one increment at a time or press and hold down the keys, releasing them when the cursor reaches the desired screen location. To move the cursor in even smaller increments, hold down the "Shift" key while using the "Direction" keys."
						100
						17
						32
						cluckWindow
						27
						1
						77
						{Game Help}
						78
						{ More }
					)
					(Print ; "In many requester windows, the "Tab" key may be used, in leu of the "Direction" keys, to cycle the cursor through the various selections. Once you reach the desired location, press the "Enter" or "Return" key to select or implement. Press "5" on the numeric keypad to cycle through the available cursors."
						100
						18
						32
						cluckWindow
						27
						1
						77
						{Game Help (Con't)}
						78
						{ More }
					)
					(Print ; "Using a Mouse: To position the on-screen cursor, move the mouse to the desired position.  To execute a command, click the mouse button (multi-button mouse users, click the left button). Click the right mouse button to cycle through the available cursors, on multi-button mice. On a single button mouse, hold down the "Shift" key while clicking the button."
						100
						19
						32
						cluckWindow
						27
						1
						77
						{Game Help (Con't)}
						78
						{ More }
					)
				)
				(2
					(displayCredits doit:)
					(break)
				)
				(3
					(break)
				)
				(4
					(Print ; "This is just one of the five "Nick's Pick's Budget Games" available. If you are interested in learning more about the other Sierra family of fine software products, call us at 800 326-6654 (or 209 683-4468 outside the United States)."
						100
						20
						32
						cluckWindow
						27
						1
						77
						{Other great products...}
						78
						{ More }
					)
					(Print ; "...More fun and games. Sometimes it seems that life with Larry is all fun and games, well hang on, there's more. Singles' scene strike-out king; fashion disaster, computer age cult hero, Larry constantly tries to get as much out of life as possible. When you plunge into the Leisure Suit Larry series, Larry will take you undercover (and under the covers), you'll explore exotic and erotic islands and you'll always be treated to a healthy serving of sex, thugs and rock 'n' roll."
						100
						21
						32
						cluckWindow
						27
						1
						77
						{Other great products...}
						78
						{ Done }
					)
				)
			)
		)
		(gSystemWindow color: 0 back: 42)
		(gGame masterVolume: 13)
	)
)

