;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 132)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm132 0
)

(local
	local0 = 3
)

(instance rm132 of Rm
	(properties
		picture 32
		style -32758
		horizon 50
		vanishingX 130
		vanishingY 50
	)

	(method (init)
		(super init:)
		(gCurRoom setScript: sFryRat)
	)
)

(instance sFryRat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music2 number: 142 setLoop: 1 play:)
				(= cycles 6)
			)
			(1
				(rat init:)
				(= cycles 6)
			)
			(2
				(rat posn: 174 25)
				(= cycles 6)
			)
			(3
				(rat posn: 164 39)
				(= cycles 6)
			)
			(4
				(rat setLoop: 1 posn: 160 46)
				(ratHead init:)
				(= cycles 6)
			)
			(5
				(ratEyes init:)
				(= cycles 6)
			)
			(6
				(ratEyes hide:)
				(= cycles 6)
			)
			(7
				(ratEyes show:)
				(= cycles 6)
			)
			(8
				(ratEyes hide:)
				(= cycles 6)
			)
			(9
				(ratHead setLoop: 1 setCel: 2 posn: 156 50)
				(= cycles 6)
			)
			(10
				(= cycles 6)
			)
			(11
				(ratEyes show: setLoop: 6 setCel: 0 posn: 160 66)
				(= cycles 6)
			)
			(12
				(ratEyes hide:)
				(= cycles 6)
			)
			(13
				(= cycles 6)
			)
			(14
				(ratHead setCel: 3 posn: 151 52)
				(= cycles 6)
			)
			(15
				(ratHead posn: 151 49)
				(= cycles 6)
			)
			(16
				(= cycles 6)
			)
			(17
				(ratEyes show: setLoop: 8 posn: 161 52)
				(= cycles 6)
			)
			(18
				(ratEyes hide:)
				(= cycles 6)
			)
			(19
				(ratEyes show:)
				(= cycles 6)
			)
			(20
				(ratEyes hide:)
				(= cycles 6)
			)
			(21
				(= cycles 1)
			)
			(22
				(ratEyes dispose:)
				(ratHead dispose:)
				(rat
					scaleSignal: 1
					scaleX: 133
					scaleY: 133
					setLoop: 2
					setCel: 0
					posn: 149 21
				)
				(= cycles 2)
			)
			(23
				(rat scaleSignal: 1 scaleX: 128 scaleY: 128 posn: 139 14)
				(= cycles 2)
			)
			(24
				(rat posn: 118 17)
				(= cycles 2)
			)
			(25
				(rat scaleSignal: 1 scaleX: 115 scaleY: 115 posn: 106 27)
				(= cycles 2)
			)
			(26
				(rat scaleSignal: 1 scaleX: 107 scaleY: 107 posn: 93 40)
				(= cycles 2)
			)
			(27
				(rat scaleSignal: 1 scaleX: 101 scaleY: 101 posn: 75 55)
				(= cycles 2)
			)
			(28
				(rat dispose:)
				(gSq5Music2 number: 145 setLoop: 1 play:)
				(sparks init: setCycle: Fwd)
				(= cycles 6)
			)
			(29
				(sparks dispose:)
				(shine1 init:)
				(shine2 init:)
				(shine3 init:)
				(Palette palSET_FROM_RESOURCE 322 2)
				(= cycles 1)
			)
			(30
				(gSq5Music2 number: 146 setLoop: 1 play:)
				(shine1 hide:)
				(shine2 hide:)
				(shine3 hide:)
				(Palette palSET_FROM_RESOURCE 32 2)
				(= ticks 5)
			)
			(31
				(shine1 show:)
				(shine2 show:)
				(shine3 show:)
				(Palette palSET_FROM_RESOURCE 322 2)
				(if (> (-- local0) 0)
					(-= state 2)
				)
				(= ticks 5)
			)
			(32
				(Palette palSET_FROM_RESOURCE 32 2)
				(shine1 dispose:)
				(shine2 dispose:)
				(shine3 dispose:)
				(gSq5Music2 stop:)
				(SetFlag 7)
				(= cycles 1)
			)
			(33
				(gCurRoom newRoom: 127)
			)
		)
	)
)

(instance mouseHead of Actor ; UNUSED
	(properties
		x 172
		y 40
		view 145
		loop 8
		priority 5
		signal 16
	)
)

(instance inMouse of Actor ; UNUSED
	(properties
		x 247
		y 56
		view 145
		signal 24576
		cycleSpeed 10
		moveSpeed 10
	)
)

(instance sparks of Prop
	(properties
		x 113
		y 91
		view 145
		loop 5
		priority 15
		signal 16
	)
)

(instance shine1 of View
	(properties
		x 93
		y 28
		view 145
		loop 7
	)
)

(instance shine2 of View
	(properties
		x 94
		y 79
		view 145
		loop 7
		cel 1
		priority 20
		signal 16
	)
)

(instance shine3 of View
	(properties
		x 158
		y 62
		view 145
		loop 7
		cel 2
	)
)

(instance rat of Actor
	(properties
		x 184
		y 12
		view 145
	)
)

(instance ratHead of Actor
	(properties
		x 155
		y 47
		view 145
		loop 1
		cel 1
		signal 16384
	)
)

(instance ratEyes of Actor
	(properties
		x 161
		y 57
		view 145
		loop 4
	)
)

