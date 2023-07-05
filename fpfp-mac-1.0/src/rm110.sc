;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use eRS)
(use Interface)
(use Print)
(use LoadMany)
(use Window)
(use Actor)
(use System)

(public
	rm110 0
)

(local
	local0 = 1
	local1
	local2 = 10
	local3
	local4
	local5
	local6 = 1
	local7 = 9
	[local8 2] = [12 14]
)

(instance rm110 of FPRoom
	(properties
		picture 190
		style 10
	)

	(method (init)
		(gTheIconBar disable:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gGame setCursor: 999 1)
		(gGameMusic1 number: 104 flags: 1 loop: 1 prevSignal: 0 play: self)
		(titleView1 init: hide:)
		(titleView2 init: hide:)
		(LoadMany rsMESSAGE 0 110)
		(super init:)
		(self setScript: sTownScript)
	)

	(method (handleEvent event)
		(if (and (event type:) (not local6))
			(= local6 1)
			(event claimed: 1)
			(sTownScript changeState: 6)
		)
	)

	(method (dispose)
		(super dispose:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
	)
)

(instance sTownScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gGameMusic1 prevSignal:) 10)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(1
				(= local6 0)
				(yellSound number: 2918 flags: 1 loop: 1 play:)
				(if (<= gHowFast local7)
					(titleView1 setPri: 15 setLoop: 0 show:)
					(= cycles 1)
				else
					(titleView1
						setScale: 10
						setScale:
						setPri: 15
						setLoop: 0
						setStep: 5 5
					)
					(for ((= local2 10)) (< local2 129) ((+= local2 6))
						(Animate (gCast elements:) 1)
						(titleView1 scaleX: local2 scaleY: local2 show:)
					)
					(= cycles 1)
				)
			)
			(2
				(= local4 1)
				(if (== (gGameMusic1 prevSignal:) 20)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(3
				(if (<= gHowFast local7)
					(titleView1 stopUpd:)
					(titleView2 setPri: 15 setLoop: 1 show:)
					(= cycles 1)
				else
					(titleView1 stopUpd:)
					(titleView2
						setScale: 10
						setScale:
						setPri: 15
						setLoop: 1
						setStep: 5 5
					)
					(for ((= local2 10)) (< local2 129) ((+= local2 3))
						(Animate (gCast elements:) 1)
						(titleView2 scaleX: local2 scaleY: local2 show:)
					)
					(= cycles 1)
				)
			)
			(4
				(= local5 1)
				(titleView2 stopUpd:)
				(= seconds 3)
			)
			(5
				(if (== (gGameMusic1 prevSignal:) 30)
					(= local3 1)
					(= cycles 1)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(6
				(= local6 1)
				(if (not local4)
					(titleView1 scaleSignal: 0 show: stopUpd:)
				)
				(if (not local5)
					(titleView2 scaleSignal: 0 show: stopUpd:)
				)
				(= cycles 1)
			)
			(7
				(gGame setCursor: 999 1)
				(gGameMusic1 pause: 0)
				(switch
					(Print
						dialog: TBDialog
						font: gUserFont
						posn: 46 160
						addButton: 1 19 0 0 1 0 0 0 ; "Restore"
						addButton: 2 19 0 0 6 55 0 0 ; "Prologue"
						addButton: 3 19 0 0 3 110 0 0 ; "Play"
						addButton: 4 19 0 0 4 149 0 0 ; "Help"
						addButton: 0 19 0 0 5 188 0 0 ; "Quit"
						init:
					)
					(0
						(= local0 0)
						(= gQuit 1)
					)
					(1
						(gGameMusic1 pause: 1)
						(gGame restore:)
					)
					(2
						(= local0 0)
						(gGameMusic1 fade:)
						(gCurRoom newRoom: 150)
					)
					(3
						(= local0 0)
						(gGameMusic1 fade:)
						(gCurRoom newRoom: 26) ; actBreak
					)
					(4
						(gGameMusic1 pause: 1)
						(gGameMusic2 number: 620 flags: 1 loop: -1 play:)
						(= local1 1)
					)
				)
				(= cycles 1)
			)
			(8
				(if local1
					(switch
						(Print
							window: SysWindow
							font: gUserFont
							addTitle: 17 0 0 1 110
							addButton: 1 4 0 0 1 0 0 110 ; "Sierra Customer Service"
							addButton: 2 5 0 0 1 0 17 110 ; "Sierra Sales"
							addButton: 3 6 0 0 1 0 34 110 ; "Sierra Technical Support"
							addButton: 4 7 0 0 1 0 51 110 ; "Technical Trouble-Shooting Tips"
							addButton: 5 8 0 0 1 0 68 110 ; "Warranty Information"
							addButton: 6 9 0 0 1 0 85 110 ; "Game Hints"
							addButton: 0 10 0 0 1 0 102 110 ; "EXIT"
							init:
						)
						(0
							(= local0 1)
							(= local1 0)
							(gGameMusic2 stop:)
							(gGameMusic1 pause: 0)
							(= cycles 1)
						)
						(1
							(gMessager say: 11 0 0 0 self) ; "Call Sierra Customer Service for inquiries about returned merchandise, back orders, defective merchandise, company policy, and general game information. You can call Sierra Customer Service at (800) 743-7725, 8:15 A.M. - 4:45 P.M. Pacific time, Monday-Friday."
						)
						(2
							(gMessager say: 12 0 0 0 self) ; "To place an order with Sierra On-Line, call (800) 326-6654 from 7:00 a.m. through 7:00 p.m. Pacific Time, Monday through Friday, for convenient, person-to-person service."
						)
						(3
							(gMessager say: 13 0 0 0 self) ; "Technical assistance is only a telephone call away. Call (209) 683-8989 for convenient, person-to-person service. If you prefer, you may request assistance by fax (209) 683-3633 or mail."
						)
						(4
							(gMessager say: 14 0 0 0 self) ; "If you're experiencing any type of technical difficulties with your program, here are some suggestions we recommend you try."
						)
						(5
							(gMessager say: 15 0 0 0 self) ; "If you need to send for replacement diskettes, send the original disk #1 to:"
						)
						(6
							(gMessager say: 16 0 0 0 self) ; "No, this isn't a menu of hints. You'd cheat. We know you would, because we play games, too, and we cheat every chance we get."
						)
					)
				else
					(= cycles 1)
				)
			)
			(9
				(if local1
					(self changeState: 8)
				else
					(= cycles 1)
				)
			)
			(10
				(if local0
					(self changeState: 7)
				else
					(= cycles 1)
				)
			)
			(11
				(gGame setCursor: 999 1)
				(self dispose:)
			)
		)
	)
)

(instance TBDialog of Dialog
	(properties)

	(method (doit param1 &tmp temp0 temp1 temp2)
		(= gGameTime (+ gTickOffset (GetTime)))
		(= temp2 0)
		(self eachElementDo: #init)
		(if theItem
			(theItem select: 0)
		)
		(= theItem
			(if (and argc param1)
				param1
			else
				(self firstTrue: #checkState 1)
			)
		)
		(if theItem
			(theItem select: 1)
		)
		(if (not theItem)
			(= eatTheMice gEatMice)
			(= lastTicks (GetTime))
		else
			(= eatTheMice 0)
		)
		(= temp1 0)
		(while (not temp1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(self eachElementDo: #cycle)
			(= temp0 ((Event new:) localize:))
			(if eatTheMice
				(-- eatTheMice)
				(if (== (temp0 type:) 1)
					(temp0 type: 0)
				)
				(while (== lastTicks (GetTime))
				)
				(= lastTicks (GetTime))
			)
			(self eachElementDo: #perform checkHiliteCode self temp0)
			(= temp1 (self handleEvent: temp0))
			(temp0 dispose:)
			(if (self check:)
				(break)
			)
			(if (== temp1 -2)
				(= temp1 0)
				(EditControl theItem 0)
				(break)
			)
			(gSounds eachElementDo: #check)
			(Wait 1)
			(if (== (gGameMusic1 prevSignal:) -1)
				(SetFlag 101)
				(= temp1 2)
				(break)
			)
		)
		(return temp1)
	)
)

(instance checkHiliteCode of Code
	(properties)

	(method (doit param1 param2 param3)
		(if
			(and
				(& (param1 state:) $0001)
				(param1 check: param3)
				(not (& (param1 state:) $0008))
			)
			((param2 theItem:) select: 0)
			(param2 theItem: param1)
			(param1 select: 1)
		)
	)
)

(instance titleView1 of Actor
	(properties
		x 160
		y 60
		view 190
		signal 16384
	)
)

(instance titleView2 of Actor
	(properties
		x 160
		y 120
		view 190
		loop 1
		signal 16384
	)
)

(instance yellSound of FPSound
	(properties
		flags 1
	)
)

