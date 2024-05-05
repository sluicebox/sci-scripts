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
			{New__________~~F9 :Open_________F7 :Save_________F3 :Save As...___~~F5 :-! :Quit____~~~~~Ctrl-Q }
		)
		(AddMenu
			{ Game }
			{Controls_____~~Ctrl-C :Music off/on_____F2 :-! :Save-O-Matic\05 :Auto-Save\05 :Text On/Off }
		)
		(AddMenu
			{ Help }
			{Interface :Keyboard Fun :Customer Service :Hint Book :-! :You May Enjoy :About Larry 6 }
		)
	)

	(method (draw)
		(= state 1)
		(DrawStatus {__________________Leisure Suit Larry 6} 75 56)
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
			(518
				(if (& gMsgType $0001)
					(= gMsgType 2)
				else
					(= gMsgType 3)
				)
			)
			(769
				(if (!= gCurRoomNum 740)
					(= local0 temp1)
					(= temp1 0)
					(gGame setScript: helpScr)
				else
					(Print addText: 4 0 3 1 0 0 0 0 93 init: returnCursor) ; MISSING MESSAGE
				)
			)
			(770
				(= local0 temp1)
				(= temp1 0)
				(Message msgGET 93 2 0 2 1 global186) ; "Keyboard Fun"
				(Print
					addTitle: global186
					addText: 2 0 0 0 0 0 93 ; "Press Ctrl-F any time you feel like fidgeting. If you have a DAC chip on your sound card, press F1, F4, F6, F8 and F10 for a surprise."
					init: returnCursor
				)
			)
			(771
				(= local0 temp1)
				(= temp1 0)
				(Message msgGET 93 3 0 2 1 global186) ; "Customer Service"
				(Print
					addTitle: global186
					addText: 3 0 0 0 0 0 93 ; "If you're having technical problems with this game, call Sierra's "Robo-Tech" at 209 683-8989 or fax your problems to 209 683-3633."
					init: returnCursor
				)
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
				(Print
					addTitle: global186
					addText: 6 0 0 0 0 0 93 ; ""Shape Up or Slip Out!" is another in the long line of laughable Laffer software from Sierra and Al Lowe, World's Oldest Bald Bearded Computer Game Designer."
					init: returnCursor
				)
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
				(Print addTitle: global186 addText: 4 0 0 1 0 0 93 init: self) ; "Click once to clear this message. When you do, your cursor will change into a Question Mark. Pass the Question Mark over the other areas of the screen to learn what they do. When you are done, click again anywhere to turn off these messages."
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
					addText: 5 0 0 1 0 0 93 ; "Completely erase everything on this hard disk?   Press Cancel to prevent catastrophe or   Press OK to lose everything..."
					addButton: 100 5 0 1 1 0 70 93 ; "OK"
					init: self
				)
			)
			(1
				(gGame setCursor: gWaitCursor)
				(Print addTitle: global186 addText: 5 0 0 2 0 0 93 init: self) ; "Ha, ha, just kidding! Here's a blatantly commercial message about the fine line of Sierra Hint Books."
			)
			(2
				(gGame setCursor: gWaitCursor)
				(Print addTitle: global186 addText: 5 0 0 3 0 0 93 init: self) ; "Go back to your software dealer. Give him a lot less money than you already spent on this game. He'll sell you a booklet that will guarantee you'll get much more value from your software purchase. We call it a "hint book.""
			)
			(3
				(gGame setCursor: gWaitCursor)
				(Print addTitle: global186 addText: 5 0 0 4 0 0 93 init: self) ; "It's a book full of hints. And jokes. And where we buried all the really dirty stuff. And lots of goofy things about how much fun we had making this game. And pictures of Al Lowe naked!"
			)
			(4
				(gGame setCursor: gWaitCursor)
				(Print addTitle: global186 addText: 5 0 0 5 0 0 93 init: self) ; "No, wait! That last part was a lie! You don't really have to see Al naked."
			)
			(5
				(gGame setCursor: gWaitCursor)
				(Print addTitle: global186 addText: 5 0 0 6 0 0 93 init: self) ; "(Hell, it was bad enough for those of us who had to work with him that way!)"
			)
			(6
				(gGame setCursor: gWaitCursor)
				(Print addTitle: global186 addText: 5 0 0 7 0 0 93 init: self) ; "If you don't care about pictures of naked men, you could call our 24-hour automated Hint Line at 900 370-5583. Non-U.S.A.? Call 44 73 430 4004. Charges are only $0.75 per minute (which is much cheaper than Passionate Patti's Touch-Tone Ecstasy Line). If you're under 18, be sure to have your parents dial the number for you."
			)
			(7
				(gGame setCursor: local0)
				(self dispose:)
			)
		)
	)
)

(instance aboutScr of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 ((gUser curEvent:) new:))
		(if (and (== (temp0 type:) 4) (== (temp0 message:) 27))
			(gGame setCursor: local0)
			(self dispose:)
		)
		(if (& (temp0 modifiers:) $000b)
			(gGame setCursor: local0)
			(self dispose:)
		)
		(temp0 dispose:)
	)

	(method (changeState newState &tmp [temp0 120])
		(switch (= state newState)
			(0
				(gGame setCursor: gWaitCursor)
				(= register 0)
				(Message msgGET 93 8 0 2 1 global186) ; "Shape Up or Slip Out!"
				(self cue:)
			)
			(1
				(if (<= (++ register) 20)
					(Message msgGET 93 8 0 0 register @temp0)
					(if (== register 20)
						(Print
							font: gUserFont
							width: 170
							mode: 1
							addTitle: 8 0 2 1 93
							addTextF: @temp0 gVersion
						)
					else
						(Print
							font: gUserFont
							width: 170
							mode: 1
							addTitle: 8 0 2 1 93
							addText: @temp0
						)
					)
					((Print dialog:) setSize:)
					(Print init: self)
				else
					(gGame setCursor: local0)
					(self dispose:)
				)
			)
			(2
				(= state 0)
				(= ticks 30)
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

