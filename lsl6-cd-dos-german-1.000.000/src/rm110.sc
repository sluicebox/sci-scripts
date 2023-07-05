;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use LarryRoom)
(use n098)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm110 0
)

(instance rm110 of LarryRoom
	(properties
		picture 98
		noControls 1
	)

	(method (init)
		(super init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(if (!= gPrevRoomNum 100)
			(gGame setCursor: 98 1)
			(gGlobalSound2 number: 0 stop:)
		)
		(self setScript: cartoonScr)
	)

	(method (handleEvent event)
		(if (event type:)
			(event claimed: 1)
			(proc98_0)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance misc of Prop
	(properties
		view 98
	)
)

(instance larry of Prop ; UNUSED
	(properties
		x 93
		y 57
		view 106
		priority 4
		signal 18448
	)
)

(instance cartoonScr of Script
	(properties)

	(method (doit)
		(if
			(and
				(== (gGlobalSound1 number:) 120)
				(OneOf (gGlobalSound1 prevSignal:) 10 20)
			)
			(gGlobalSound1 prevSignal: 0)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState &tmp [temp0 30] [temp30 30])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCurRoom showControls: 1)
				(SetPort 0 0 139 320 10 0)
				(DrawPic 110 100)
				(misc
					view: 110
					setLoop: 0
					cel: 0
					x: 84
					y: 127
					cycleSpeed: 5
					init:
				)
				(= cycles 1)
			)
			(2
				(gGlobalSound1 number: 120 loop: -1 play:)
			)
			(3
				(sfx number: 121 loop: 1 play:)
				(misc setCycle: End)
			)
			(4
				(misc view: 114 x: 0 y: 0 hide:)
				(DrawPic 111 13)
				(= ticks 150)
			)
			(5
				(misc show:)
				(= ticks 10)
			)
			(6
				(misc view: 115)
				(= ticks 20)
				(= register 7)
			)
			(7
				(if (-- register)
					(-- state)
				)
				(if (== (misc view:) 116)
					(misc view: 115)
				else
					(misc view: 116)
				)
				(= ticks 30)
			)
			(8
				(misc view: 117)
				(= ticks 60)
				(= register 7)
			)
			(9
				(if (-- register)
					(-- state)
				)
				(if (== (misc view:) 117)
					(misc view: 116)
				else
					(misc view: 117)
				)
				(= ticks 2)
			)
			(10
				(misc view: 118)
				(= ticks 20)
			)
			(11
				(misc view: 119)
				(= ticks 10)
			)
			(12
				(misc view: 120)
				(= ticks 10)
			)
			(13
				(misc view: 121)
				(Load rsSOUND 443)
				(= ticks 30)
			)
			(14
				(sfx number: 444 loop: 1 play:)
				(ShakeScreen 3 ssUPDOWN)
				(Load rsSOUND 385)
				(= cycles 2)
			)
			(15
				(sfx number: 385 loop: 1 play:)
				(= cycles 2)
			)
			(16
				(misc view: 112 x: 77 y: 47 cel: 0 cycleSpeed: 8 setCycle: Fwd)
				(DrawPic 112 13)
				(= cycles 2)
			)
			(17
				(SetPort 0)
				(SetPort 0 0 190 320 10 0)
				(Message msgGET 110 0 0 1 1 @temp30) ; "\04 1994 Sierra On-Line, Inc."
				(Display @temp30 dsCOORD 1 165 dsWIDTH 318 dsALIGN alCENTER dsCOLOR 75 dsBACKGROUND 0 dsFONT 900)
				(= seconds 6)
			)
			(18
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

