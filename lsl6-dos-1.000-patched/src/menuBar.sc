;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use n076)
(use n078)
(use n912)
(use Print)
(use System)

(public
	menuBar 0
)

(local
	local0
)

(instance menuBar of Class_912_0
	(properties)

	(method (init)
		(AddMenu
			{ File }
			{New          ~~F9 :Open         F7 :Save         F3 :Save As...   ~~F5 :-! :Quit    ~~~~~Ctrl-Q }
		)
		(AddMenu
			{ Game }
			{Controls     ~~Ctrl-C :Music off/on     F2 :-! :Save-O-Matic\05 :Auto-Save\05 }
		)
		(AddMenu
			{ Help }
			{Interface :Keyboard Fun :Customer Service :Hint Book :-! :You May Enjoy :About Larry 6 }
		)
	)

	(method (draw)
		(= state 1)
		(DrawStatus {                  Leisure Suit Larry 6} 75 56)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if gModelessDialog
			(return)
		)
		(if
			(and
				state
				(or
					(and (& (event type:) evMOUSEBUTTON) (< (event y:) 10))
					(& (event type:) evKEYBOARD)
				)
			)
			(= temp1 gTheCursor)
			(gGame setCursor: gNormalCursor)
		else
			(= temp1 0)
		)
		(switch (= temp0 (super handleEvent: event))
			(257
				(gGame restart:)
			)
			(258
				(gGame restore:)
			)
			(259
				(gGame save: 0)
			)
			(260
				(gGame save:)
			)
			(262
				(gGame quitGame:)
			)
			(513
				((ScriptID 0 10) doit:) ; icon7
			)
			(514
				(cond
					((gGame masterVolume:)
						(= gMasterVolume 0)
						(gGame masterVolume: 0)
					)
					((> global104 1)
						(= gMasterVolume 13)
						(gGame masterVolume: 15)
					)
					(else
						(= gMasterVolume 1)
						(gGame masterVolume: 1)
					)
				)
			)
			(516
				(proc78_1)
			)
			(517
				(proc76_0)
			)
			(769
				(if (!= gCurRoomNum 740)
					(= local0 temp1)
					(= temp1 0)
					(gGame setScript: helpScr)
				else
					(gMessager say: 4 0 3 1 returnCursor 93) ; "Interface help is unavailable at this time."
				)
			)
			(770
				(= local0 temp1)
				(= temp1 0)
				(Message msgGET 93 2 0 2 1 global186) ; "Keyboard Fun"
				(gMessager say: 2 0 0 0 returnCursor 93) ; "Press Ctrl-F any time you feel like fidgeting. If you have a DAC chip on your sound card, press F1, F4, F6, F8 and F10 for a surprise."
			)
			(771
				(= local0 temp1)
				(= temp1 0)
				(Message msgGET 93 3 0 2 1 global186) ; "Customer Service"
				(gMessager say: 3 0 0 0 returnCursor 93) ; "If you're having technical problems with this game, call Sierra's "Robo-Tech" at 209 683-8989 or fax your problems to 209 683-3633."
			)
			(772
				(= local0 temp1)
				(= temp1 0)
				(gGame setScript: hintScr)
			)
			(774
				(= local0 temp1)
				(= temp1 0)
				(Message msgGET 93 6 0 2 1 global186) ; "Other Al Lowe Games"
				(gMessager say: 6 0 0 0 returnCursor 93) ; ""Shape Up or Slip Out!" is another in the long line of laughable Laffer software from Sierra and Al Lowe, World's Oldest Bald Bearded Computer Game Designer."
			)
			(775
				(= local0 temp1)
				(= temp1 0)
				(gGame setScript: aboutScr)
			)
		)
		(if temp1
			(gGame setCursor: temp1)
		)
	)
)

(instance helpScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 93 4 0 2 1 global186) ; "Interface Help"
				(gMessager say: 4 0 0 1 self 93) ; "Click once to clear this message. When you do, your cursor will change into a Question Mark. Pass the Question Mark over the other areas of the screen to learn what they do. When you are done, click again anywhere to turn off these messages."
			)
			(1
				((ScriptID 75 0) init: doit: dispose:) ; nClickHelp
				(gGame setCursor: local0)
				(self dispose:)
			)
		)
	)
)

(instance hintScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Message msgGET 93 5 0 2 1 global186) ; "Hint Book"
				(Print
					addTitle: global186
					addText: 5 0 0 1 0 0 93 ; "Completely erase everything on this hard disk?  Press Cancel to prevent catastrophe or  Press OK to lose everything..."
					addButton: 100 5 0 1 1 0 70 93 ; "OK"
					init: self
				)
			)
			(1
				(gGame setCursor: gWaitCursor)
				(gMessager say: 5 0 0 2 self 93 oneOnly: 0) ; "Ha, ha, just kidding! Here's a blatantly commercial message about the fine line of Sierra Hint Books."
			)
			(2
				(gGame setCursor: local0)
				(self dispose:)
			)
		)
	)
)

(instance aboutScr of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(gGame setCursor: gWaitCursor)
				(Message msgGET 93 8 0 2 1 global186) ; "Shape Up or Slip Out!"
				(gMessager say: 8 0 0 1 12 self 93) ; ""Shape Up or Slip Out!" is an Up & Coming Production, Copyright 1993 by Sierra Publishing, a division of Sierra On-Line, Inc. Any resemblance to any characters, living or dead, means you need to find a better set of friends!"
			)
			(1
				(Message msgGET 93 8 0 0 13 @temp0) ; "November 18, 1993 Version %s"
				(Print addTitle: 8 0 2 1 93 addTextF: @temp0 gVersion init: self)
			)
			(2
				(gGame setCursor: local0)
				(self dispose:)
			)
		)
	)
)

(instance returnCursor of Script
	(properties)

	(method (cue)
		(if (!= gCurRoomNum 740)
			(gGame setCursor: local0)
		else
			(gGame setCursor: gWaitCursor)
		)
	)
)

