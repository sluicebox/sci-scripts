;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 914)
(include sci.sh)
(use Main)
(use n076)
(use n078)
(use fileScr)
(use GraphMenuBar)
(use Print)
(use System)

(public
	hiResMenu 0
)

(instance tFile of MenuTitle
	(properties
		mainView 968
		winY 14
		winView 965
	)

	(method (init)
		(self add: iNew iOpen iSave iSaveAs iQuit)
		(super init: &rest)
	)
)

(instance tGame of MenuTitle
	(properties
		mainView 968
		mainLoop 1
		x 23
		winX 23
		winY 14
		winView 966
	)

	(method (init)
		(self add: iSaveOMatic iAutoSave iMusic iControls iMessage)
		(super init: &rest)
	)
)

(instance tHelp of MenuTitle
	(properties
		mainView 968
		mainLoop 2
		x 47
		winX 47
		winY 14
		winView 967
	)

	(method (init)
		(if (or (== (gGame printLang:) 49) (== (gGame printLang:) 33))
			(self
				add:
					iInterface
					iKeyboard
					iCustomerService
					iYouMayEnjoy
					iAboutLarry
			)
		else
			(self
				add:
					iInterface
					iKeyboard
					iCustomerService
					iHints
					iYouMayEnjoy
					iAboutLarry
			)
		)
		(super init: &rest)
	)
)

(instance iNew of MenuItem
	(properties
		y 1
		view 965
		loop 1
	)

	(method (select)
		(gGame restart:)
	)
)

(instance iOpen of MenuItem
	(properties
		y 11
		view 965
		loop 2
	)

	(method (select)
		(gGame restore:)
	)
)

(instance iSave of MenuItem
	(properties
		y 21
		view 965
		loop 3
	)

	(method (select)
		(gGame save: 0)
	)
)

(instance iSaveAs of MenuItem
	(properties
		y 31
		view 965
		loop 4
	)

	(method (select)
		(gGame save:)
	)
)

(instance iQuit of MenuItem
	(properties
		y 41
		view 965
		loop 5
	)

	(method (select)
		(gGame quitGame:)
	)
)

(instance iSaveOMatic of MenuItem
	(properties
		y 1
		view 966
		loop 1
	)

	(method (select)
		(proc78_1)
	)
)

(instance iAutoSave of MenuItem
	(properties
		y 11
		view 966
		loop 2
	)

	(method (select)
		(proc76_0)
	)
)

(instance iMusic of MenuItem
	(properties
		y 21
		view 966
		loop 3
	)

	(method (select)
		(cond
			((gGame masterVolume:)
				(gGame masterVolume: 0)
				(= gMasterVolume 0)
			)
			((>= global104 1)
				(gGame masterVolume: 15)
				(= gMasterVolume 13)
			)
			(else
				(gGame masterVolume: 1)
				(= gMasterVolume 1)
			)
		)
	)
)

(instance iMessage of MenuItem
	(properties
		y 41
		view 966
		loop 5
	)

	(method (select)
		(if (IsFlag 105)
			(gTextScroller show:)
			(ClearFlag 105)
		else
			(gTextScroller hide:)
			(SetFlag 105)
		)
	)
)

(instance iControls of MenuItem
	(properties
		y 31
		view 966
		loop 4
	)

	(method (select &tmp temp0)
		(= temp0 gTheCursor)
		(gGame setCursor: gNormalCursor)
		((ScriptID 94) init:) ; ll6ControlPanel
		(gGame setCursor: temp0)
	)
)

(instance iInterface of MenuItem
	(properties
		y 1
		view 9671
	)

	(method (select)
		(gGame setScript: interfaceHelpScr)
	)
)

(instance iKeyboard of MenuItem
	(properties
		y 11
		view 9671
		loop 1
	)

	(method (select)
		(Message msgGET 93 2 0 2 1 (global186 data:)) ; "Keyboard Fun"
		(Print addTitle: (global186 data:) addText: 2 0 0 1 0 0 93 init:) ; "Press Ctrl-F any time you feel like fidgeting. If you have a DAC chip on your sound card, press F1, F4, F6, F8 and F10 for a surprise."
	)
)

(instance iCustomerService of MenuItem
	(properties
		y 21
		view 9671
		loop 2
	)

	(method (select)
		(gGame setScript: custSupScript)
	)
)

(instance iHints of MenuItem
	(properties
		y 31
		view 9671
		loop 3
	)

	(method (select)
		(gGame setScript: hintScript)
	)
)

(instance iYouMayEnjoy of MenuItem
	(properties
		y 41
		view 9671
		loop 4
	)

	(method (select)
		(gGame setScript: youLikeScript)
	)
)

(instance iAboutLarry of MenuItem
	(properties
		y 51
		view 9671
		loop 5
	)

	(method (select)
		(gGame setScript: (ScriptID 73)) ; aboutScr
	)
)

(instance hiResMenu of GraphMenuBar
	(properties
		x 3
		y 2
	)

	(method (init)
		(self add: tFile tGame tHelp)
		(super init: &rest)
	)
)

(instance custSupScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 93 3 0 2 1 (global186 data:)) ; "Customer Service"
				(Print
					addTitle: (global186 data:)
					addText: 3 0 0 1 0 0 93 ; "If you're having technical problems with this game, call Sierra's "Robo-Tech" at 209 683-8989 or fax your problems to 209 683-3633."
					init: self
				)
			)
			(1
				(if
					(or
						(== (gGame printLang:) 49)
						(== (gGame printLang:) 33)
					)
					(self cue:)
				else
					(Print
						addTitle: (global186 data:)
						addText: 3 0 0 2 0 0 93 ; "But don't try to call them for hints; they're hard, cruel people who get their kicks by hanging up on hint beggars!"
						init: self
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance hintScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 93 5 0 2 1 (global186 data:)) ; "Hint Book"
				(Print
					addTitle: (global186 data:)
					addText: 5 0 0 1 0 0 93 ; "Completely erase everything on this hard disk?   Press Cancel to prevent catastrophe or   Press OK to lose everything..."
					addButton: 100 5 0 1 1 0 35 93 ; "OK"
					init: self
				)
			)
			(1
				(Print
					addTitle: (global186 data:)
					addText: 5 0 0 2 0 0 93 ; "Ha, ha, just kidding! Here's a blatantly commercial message about the fine line of Sierra Hint Books."
					init: self
				)
			)
			(2
				(Print
					addTitle: (global186 data:)
					addText: 5 0 0 3 0 0 93 ; "Go back to your software dealer. Give him a lot less money than you already spent on this game. He'll sell you a booklet that will guarantee you'll get much more value from your software purchase. We call it a "hint book.""
					init: self
				)
			)
			(3
				(Print
					addTitle: (global186 data:)
					addText: 5 0 0 4 0 0 93 ; "It's a book full of hints. And jokes. And where we buried all the really dirty stuff. And lots of goofy things about how much fun we had making this game. And pictures of Al Lowe naked!"
					init: self
				)
			)
			(4
				(Print
					addTitle: (global186 data:)
					addText: 5 0 0 5 0 0 93 ; "No, wait! That last part was a lie! You don't really have to see Al naked."
					init: self
				)
			)
			(5
				(Print
					addTitle: (global186 data:)
					addText: 5 0 0 6 0 0 93 ; "(Hell, it was bad enough for those of us who had to work with him that way!)"
					init: self
				)
			)
			(6
				(Print
					addTitle: (global186 data:)
					addText: 5 0 0 7 0 0 93 ; "If you don't care about pictures of naked men, you could call our 24-hour automated Hint Line at 900 370-5583. Non-U.S.A.? Call 44 73 430 4004. Charges are only $0.75 per minute (which is much cheaper than Passionate Patti's Touch-Tone Ecstasy Line). If you're under 18, be sure to have your parents dial the number for you."
					init: self
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance youLikeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 93 6 0 2 1 (global186 data:)) ; "Other Al Lowe Games"
				(Print
					addTitle: (global186 data:)
					addText: 6 0 0 1 0 0 93 ; ""Shape Up or Slip Out!" is another in the long line of laughable Laffer software from Sierra and Al Lowe, World's Oldest Bald Bearded Computer Game Designer."
					init: self
				)
			)
			(1
				(Print
					addTitle: (global186 data:)
					addText: 6 0 0 2 0 0 93 ; "Other Laffer titles include: "Leisure Suit Larry in the Land of the Lounge Lizards," "Leisure Suit Larry Goes Looking For Love (in Several Wrong Places)," "Passionate Patti in Pursuit of the Pulsating Pectorals," and "Passionate Patti Does a Little Undercover Work." All are available at "finer" software stores everywhere, or by calling Sierra On-Line, Inc."
					init: self
				)
			)
			(2
				(Print
					addTitle: (global186 data:)
					addText: 6 0 0 3 0 0 93 ; "Those of you playing in offices worldwide should consider slipping through a requisition for "The Laffer Utilities," an innocuously-named collection of 17 silly things you can do on a computer, available in versions for DOS and Windows."
					init: self
				)
			)
			(3
				(Print
					addTitle: (global186 data:)
					addText: 6 0 0 4 0 0 93 ; "Some of "The Laffer Utilities" might actually be useful, such as Jokes, Betting Pools, Automatic Signmaker, and a large collection of clip art. But we promise nothing but laughter!"
					init: self
				)
			)
			(4
				(Print
					addTitle: (global186 data:)
					addText: 6 0 0 5 0 0 93 ; "Al Lowe has also turned his perverse sense of humor loose on the Old West, with the critically-acclaimed "Freddy Pharkas, Frontier Pharmacist!" It's your standard Western tale of a boy raised to be a gunslinger, who gives it all up for a career in pharmacology."
					init: self
				)
			)
			(5
				(Print
					addTitle: (global186 data:)
					addText: 6 0 0 6 0 0 93 ; "Enjoy Al's collection of "Western movie cliches with a twist" with such delightful characters as Madame Ovaree (proprietor of "Ye Olde Ore House"), Srini Lahkaka Bagnish (Freddy's faithful Indian companion), and the evil Kenny the Kid (fastest draw in the West) in whom Freddy, and you, may meet your collective match!"
					init: self
				)
			)
			(6
				(if
					(or
						(== (gGame printLang:) 49)
						(== (gGame printLang:) 33)
					)
					(self cue:)
				else
					(Print
						addTitle: (global186 data:)
						addText: 6 0 0 7 0 0 93 ; "To order these (or any other Sierra products) call us at 800 757-7707, 209 683-4468, or fax your order to 209 683-4297. Non-U.S.A. customers call 44 73 430 3201."
						init: self
					)
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance interfaceHelpScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 93 4 0 2 1 (global186 data:)) ; "Interface Help"
				(Print
					addTitle: (global186 data:)
					addText: 4 0 0 1 0 0 93 ; "Click once to clear this message. When you do, your cursor will change into a Question Mark. Pass the Question Mark over the other areas of the screen to learn what they do. When you are done, click again anywhere to turn off these messages."
					init: self
				)
			)
			(1
				((ScriptID 75 0) init: doit: dispose:) ; nClickHelp
				(self dispose:)
			)
		)
	)
)

