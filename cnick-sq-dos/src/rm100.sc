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

(instance rm100 of Rm
	(properties
		sel_20 {rm100}
		sel_399 900
		sel_28 10
	)

	(method (sel_110)
		(super sel_110: &rest)
		(proc0_2)
		(Load rsPIC 417)
		(if (or gPrevRoomNum (GameIsRestarting))
			(= sel_399 417)
		)
		(gTheIconBar sel_214: (gTheIconBar sel_64: 1))
		(gGame sel_198: gWaitCursor)
		(= gUseSortedFeatures 0)
		(proc0_23)
		(gGame sel_395: 12)
		(gSystemWindow sel_25: 0 sel_26: 4)
		(self sel_146: startScript)
	)

	(method (sel_57)
		(super sel_57:)
		(if (== (gCurRoom sel_396:) 900)
			(Palette palANIMATE 95 218 -1)
		)
	)

	(method (sel_390)
		(super sel_390: &rest)
		(proc0_23 gWaitCursor)
		(gSounds sel_119: 168)
		(gSystemWindow sel_25: 0 sel_26: 4)
	)

	(method (sel_292)
		(if (gCurRoom sel_142:)
			(switch (gCurRoom sel_142:)
				(startScript
					(if (< (startScript sel_29:) 1)
						(startScript sel_144: 1)
					)
				)
				(showMonoPicFirstScript
					(if (< (showMonoPicFirstScript sel_29:) 2)
						(showMonoPicFirstScript sel_144: 2)
					)
				)
			)
		)
	)
)

(instance startScript of Script
	(properties
		sel_20 {startScript}
	)

	(method (sel_110)
		(if (or gPrevRoomNum (GameIsRestarting))
			(= sel_134 1)
		)
		(super sel_110: &rest)
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(= sel_137 5)
			)
			(1
				(gCurRoom sel_408: 417 10)
				(if (< global106 2)
					(gLongSong sel_168:)
				else
					(gLongSong sel_171:)
				)
				(= sel_136 1)
			)
			(2
				(proc0_23 gWaitCursor)
				(= sel_137 2)
			)
			(3
				(gLongSong sel_40: 1 sel_3: -1 sel_39: 127)
				(proc0_23 721)
				(quitGames sel_110: sel_304:)
				(aboutGames sel_110: sel_304:)
				(msChicken sel_110: sel_304:)
				(burger sel_110: sel_304:)
				(skimmer sel_110: sel_304:)
				(= sel_136 4)
			)
			(4
				(self sel_111:)
			)
		)
	)
)

(instance showMonoPicFirstScript of Script
	(properties
		sel_20 {showMonoPicFirstScript}
	)

	(method (sel_144 param1)
		(switch (= sel_29 param1)
			(0
				(proc0_23 gWaitCursor)
				(gCurRoom sel_408: 386 10)
				(= sel_137 3)
				(bossesMouth sel_110: sel_236: 6 sel_162: Fwd)
				(bossesArm sel_110: sel_4: 2)
			)
			(1
				(Print ; "This is so easy, a human could probably do it. Burger comes out of the oven. Drop on yer lettuce, yer pickle, squeeze on yer mayo, squirt on yer mustard, on goes yer ketchup, top it off with yer sesame-seed bun. You make 'em MY way, and if you mess up enough times, you're outta here. Got it? Now get to work!"
					100
					0
					64
					-1
					140
					22
					14
					77
					{Welcome to Monolith}
					32
					welcomeWindow
					111
				)
				(= sel_137 15)
			)
			(2
				(if gModelessDialog
					(gModelessDialog sel_111:)
				)
				(gSystemWindow sel_25: 0 sel_26: 4)
				(User sel_229: 0 sel_339: 0)
				(gCurRoom sel_390: 387)
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
			(gSystemWindow sel_25: 0 sel_26: 4)
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
					(gSystemWindow sel_25: 0 sel_26: 4)
					(repeat
						(switch
							(= param1
								(PrintD
									{Select game to receive help on:}
									109
									78
									{ Ms. Astro Chicken }
									290
									109
									78
									{ Monolith Burger }
									387
									109
									78
									{ Sand Skimmer }
									36
									109
									78
									{ Exit Help }
									417
									77
									{Help}
								)
							)
							(290
								(Print ; "The object of Ms. Astro Chicken is to prevent your chicken from being shot down by the crazed farmer, or being eaten by the rabid dog. You avoid these terrible fates by flying overhead and dropping eggs on the offending pair. You also have a flying weasel to watch out for! To replenish your egg supply, you need to eat the corn when it appears on the screen. You can use a mouse, or a keyboard to control your chicken. With a mouse, Point and click your LEFT mouse button to where you want your chicken to go. Clicking the RIGHT mouse button releases the eggs. With a keyboard, use the ARROW keys to direct your chicken. The ENTER or RETURN keys will release your eggs."
									100
									1
									32
									SysWindow
									27
									1
									77
									{Help on Ms. Astro Chicken}
									78
									{ More }
								)
								(Print ; "Remember that your egg supply is limited. You can run out unless you refill by eating corn! Press the "F9" key to quit."
									100
									2
									32
									SysWindow
									27
									1
									77
									{Help on Ms. Astro Chicken (Con't)}
									78
									{ Done }
								)
							)
							(387
								(Print ; "The object of Monolith Burger Builder is to make complete burgers by putting all the condiments on the patty as it moves down the conveyor belt, and putting a bun on top when it gets to the end. You can put the condiments on in any order, but you MUST make sure to put the bun on last. If your burger isn't complete by the time Master Burger 2000 inspects it, the burger will be rejected and zapped. If you make too many rejects, you'll be fired. To play the game, click the LEFT mouse button on each condiment to pick it up. You can then move the condiment by moving your mouse. To drop the condiment on your burger, click the burger with the condiment icon. Click on the "Instructions" button for more information."
									100
									3
									32
									SysWindow
									27
									1
									77
									{Help on Monolith Burger Builder}
									78
									{ More }
								)
								(Print ; "Using the Keyboard: Use the "Direction" (Arrow) keys on your numeric keypad to position the cursor over the various condiments. Press the "Enter" or "Return" key to pick up the condiment. Then use the "Direction" keys, once again, to position the condiment on the burger. Press the "Enter" or "Return" key to drop the condiment on the burger. Use the "F9" key to quit. Press "R" to activate the "Instructions" button."
									100
									4
									32
									SysWindow
									27
									1
									77
									{Help on Monolith Burger Builder (Con't)}
									78
									{ Done }
								)
							)
							(36
								(Print ; "The object of Sand Skimmer is to move your skimmer across the sand, avoiding the obstacles, as you make your way to Ulence Flats. To play the game, slalom your mouse to either the right of left and then click your mouse button to position your sand skimmer. If you hit any of the smaller rocks, your skimmer will be damaged. The damage meter will indicate how much damage you have taken. Watch out for the large rocks. As the game says, "...they cut you NO slack!""
									100
									5
									32
									SysWindow
									27
									1
									77
									{Help on Sand Skimmer}
									78
									{ More }
								)
								(Print ; "Using a keyboard: To position your Sandskimmer using a keyboard, press either the left or right arrow direction keys on the numeric keypad. To stop your Sandskimmer from moving too far one way or the other, press the same direction key again. Press the "F9" key to quit."
									100
									6
									32
									SysWindow
									27
									1
									77
									{Help on Sand Skimmer (Con't)}
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
					(gSystemWindow sel_25: 0 sel_26: 52)
					(break)
				)
				(4
					(Print ; "This is just one of the five "Nick's Pick's Budget Games" available. If you are interested in learning more about the other Sierra family of fine software products, call us at 800 326-6654 (or 209 683-4468 outside the United States)."
						100
						7
						32
						SysWindow
						27
						1
						77
						{Other great products...}
						78
						{ More }
					)
					(Print ; "...More fun and games. Imagine exploring an entire universe of game fun and action. Sierra's Space Quest series is wild, satirical and insanely brilliant (or is that brilliantly insane?). You'll blast-off with Roger Wilco, sanitation engineer turned swashbuckler, battle bizarre aliens, stumble through a galaxy of spine-tingling suspense and side-splitting mishaps. You'll love every outrageous episode in the Space Quest series."
						100
						8
						32
						SysWindow
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
		(gSystemWindow sel_25: 0 sel_26: 4)
		(gGame sel_395: 15)
	)
)

(instance displayCredits of Code
	(properties
		sel_20 {displayCredits}
	)

	(method (sel_57)
		(gSystemWindow sel_25: 50 sel_26: 42)
		(Print 100 9 77 {Credits} 27 1 78 { More } 25 50 26 42 32 SysWindow) ; "Roger Wilco's Spaced Out Game Pack Team: Director: Bill Davis Producers: Tony Caudill Tammy Dargan Software Supervisor: J. Mark Hood"
		(Print ; "Roger Wilco's Spaced Out Game Pack Team: (Con't) Lead Programmer: Thaddeus M. Pritchard  Quality Assurance: Mike Brosius Special thanks to: Randy MacNeill"
			100
			10
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
			SysWindow
		)
		(Print ; "Original Roger Wilco in the Sarien Encounter Team: Executive Producer: Ken Williams Creative Director: Bill Davis Directors: Scott Murphy Douglas Herring"
			100
			11
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
			SysWindow
		)
		(Print ; "Original Roger Wilco in the Sarien Encounter Team: (Con't) Producer: Stuart Moulder Game Designers: Scott Murphy Mark Crowe Art Designer: Douglas Herring"
			100
			12
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
			SysWindow
		)
		(Print ; "Original Roger Wilco in the Sarien Encounter Team: (Con't) Lead Programmer: Jerry Shaw Composer: Ken Allen Animators: Vas Nokhoudian, Nathan Larsen, Arturo Sinclair, Deena Krutak, Desie Hartman, Jerry Jessurun, Russell Truelove, Diana R. Wilson"
			100
			13
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
			SysWindow
		)
		(Print ; "Original Roger Wilco in the Sarien Encounter Team: (Con't) Background Artists: Nathan Larsen, Arturo Sinclair, Suzi Livengood, Eric Kasner, Willis Wong, Jay Friedmann, Jennifer Shontz, Andy Hoyos Programmers: Randy MacNeill, Dave Jamriska, Hugh Diedrichs"
			100
			14
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
			SysWindow
		)
		(Print ; "Original Roger Wilco in the Sarien Encounter Team: (Con't) Music Director: Mark Seibert System Development: Christopher Smith, Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, Dan Foy, Larry Scott, J. Mark Hood, Mark Wilden, Eric Hart Sound Effects: Mark Seibert, Orpheus Hanley"
			100
			15
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
			SysWindow
		)
		(Print ; "Original Roger Wilco and the Time Rippers Team: Executive Producer: Ken Williams Creative Director: Bill Davis Producer: Guruka Singh Khalsa Game Designers: Mark Crowe Scott Murphy"
			100
			16
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
			SysWindow
		)
		(Print ; "Original Roger Wilco and the Time Rippers Team: (Con't) Art Designer: Mark Crowe Lead Programmer: Scott Murphy Music Director: Mark Seibert"
			100
			17
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
			SysWindow
		)
		(Print ; "Original Roger Wilco and the Time Rippers Team: (Con't) Animators: Jon Bock, Jane Cardinal, Jeff Crowe, Desie Hartman, Eric Kasner, Jim Larsen, Nathan Larsen, Suzi Livengood, Cheryl Loyd, Michael A. Milo, Gerald Moore, Cheryl Sweeney, Willis Wong Background Artists: Jon Bock, Jane Cardinal, Jennifer Shontz, Cheryl Sweeney Programmers: Oliver Breslford, Carlos Escobar, Brian K. Hughes, Mike Larsen, Randy MacNeill, Doug Oldfield, Raoul Said, Jerry Shaw"
			100
			18
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
			SysWindow
		)
		(Print ; "Original Roger Wilco and the Time Rippers Team: (Con't) System Development: Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, Dan Foy, Larry Scott, Terry McHenry, John Rettig, Corey Cole, J. Mark Hood, Mark Wilden, Eric Hart, John Hartin Quality Assurance: Mike Harian, Dan Scott"
			100
			19
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
			SysWindow
		)
	)
)

(instance welcomeWindow of SysWindow
	(properties
		sel_20 {welcomeWindow}
		sel_26 5
	)
)

(instance bossesMouth of Actor
	(properties
		sel_20 {bossesMouth}
		sel_1 155
		sel_0 39
		sel_2 386
		sel_4 3
	)
)

(instance bossesArm of Actor
	(properties
		sel_20 {bossesArm}
		sel_1 96
		sel_0 134
		sel_2 386
		sel_3 2
		sel_4 2
	)
)

(instance aboutGames of Button
	(properties
		sel_20 {aboutGames}
		sel_1 196
		sel_0 168
		sel_2 417
	)

	(method (sel_292)
		(requestHelp sel_110:)
	)
)

(instance quitGames of Button
	(properties
		sel_20 {quitGames}
		sel_1 273
		sel_0 168
		sel_2 417
		sel_3 1
	)

	(method (sel_292)
		(= gQuit 1)
	)
)

(instance msChicken of Button
	(properties
		sel_20 {msChicken}
		sel_1 85
		sel_0 113
		sel_2 417
		sel_3 2
	)

	(method (sel_292)
		(gCurRoom sel_390: 290)
		(= gNormalCursor 20)
	)
)

(instance burger of Button
	(properties
		sel_20 {burger}
		sel_1 85
		sel_0 130
		sel_2 417
		sel_3 3
	)

	(method (sel_292)
		(quitGames sel_111:)
		(aboutGames sel_111:)
		(msChicken sel_111:)
		(burger sel_111:)
		(skimmer sel_111:)
		(gCurRoom sel_146: showMonoPicFirstScript)
	)
)

(instance skimmer of Button
	(properties
		sel_20 {skimmer}
		sel_1 85
		sel_0 147
		sel_2 417
		sel_3 4
	)

	(method (sel_292)
		(gCurRoom sel_390: 36)
	)
)

(instance sparkle of Prop ; UNUSED
	(properties
		sel_20 {sparkle}
		sel_2 950
	)

	(method (sel_110)
		(self sel_155: 2 sel_4: 0 sel_307: sel_63: 14 sel_162: End)
		(super sel_110:)
	)
)

