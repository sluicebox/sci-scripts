;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use n013)
(use Game)
(use Actor)
(use System)

(public
	creditRm 0
)

(local
	local0
)

(instance creditRm of Room
	(properties
		modNum 680
		picture 99
		style 14
		exitStyle 13
	)

	(method (init)
		(super init: &rest)
		(gTheIconBar disable:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(gGkMusic1
			number: (if (IsFlag 470) 370 else 5)
			setLoop: 1
			play:
			setVol: (gGkMusic1 musicVolume:)
		)
		(gGame setCursor: ((ScriptID 0 1) view: 996)) ; globeCursor
		(self setScript: (if (IsHiRes) doHiResCredits else doCredits))
	)

	(method (handleEvent)
		(gCurRoom newRoom: 370)
		(return 1)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gTheIconBar enable:)
		(super dispose: &rest)
	)
)

(instance doCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(credit view: 790 init:)
				(= local0 0)
				(= ticks 200)
			)
			(1
				(credit loop: local0)
				(if (and (== local0 13) (IsFlag 470))
					(gGkMusic1 fade:)
				)
				(if (< local0 14)
					(-- state)
					(++ local0)
				)
				(= ticks 200)
			)
			(2
				(if (IsFlag 470)
					(= gDay 1)
					(gCurRoom newRoom: 370)
				else
					(credit view: 7911 loop: (= local0 0))
					(= ticks 200)
				)
			)
			(3
				(credit loop: local0)
				(if (< local0 15)
					(-- state)
					(++ local0)
				)
				(= ticks 200)
			)
			(4
				(credit view: 792 loop: (= local0 0))
				(= ticks 200)
			)
			(5
				(credit loop: local0)
				(if (< local0 4)
					(-- state)
					(++ local0)
				)
				(= ticks 200)
			)
			(6
				(= gDay 1)
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance doHiResCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(credit view: 10600 y: 190 init:)
				(theLoop init:)
				(= ticks 330)
			)
			(2
				(if (gCast contains: theLoop)
					(theLoop dispose:)
				)
				(credit view: (+ (credit view:) 1))
				(if (< (credit view:) 10612)
					(-- state)
				)
				(= ticks 330)
			)
			(3
				(credit view: 10600)
				(theLoop view: 10700 setLoop: 1 init:)
				(= ticks 200)
			)
			(4
				(theLoop setLoop: (+ (theLoop loop:) 1))
				(if (< (theLoop loop:) 7)
					(-- state)
				)
				(= ticks 200)
			)
			(5
				(theLoop view: 10701 setLoop: 0)
				(= ticks 200)
			)
			(6
				(theLoop setLoop: (+ (theLoop loop:) 1))
				(if (< (theLoop loop:) 15)
					(-- state)
				)
				(= ticks 200)
			)
			(7
				(theLoop view: 10702 setLoop: 0)
				(= ticks 200)
			)
			(8
				(= gDay 1)
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance credit of View
	(properties
		x 160
		y 80
		view 790
	)
)

(instance theLoop of Prop
	(properties
		x 240
		y 80
		priority 250
		fixPriority 1
		view 10700
	)
)

