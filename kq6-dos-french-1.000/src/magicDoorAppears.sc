;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 711)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	magicDoorAppears 0
)

(instance magicDoorAppears of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 711)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 36 156 reset: 0 hide:)
				(magicDoor init:)
				(= cycles 2)
			)
			(1
				(gGlobalSound2 number: 231 setLoop: 1 play:)
				(magicDoor cycleSpeed: 8 setCycle: CT 6 1 self)
			)
			(2
				(gEgo show:)
				(magicDoor cel: 7 setCycle: End self)
			)
			(3
				(magicDoor dispose:)
				(gMessager say: 9 0 14 0 self) ; "The magic paint door fades back into the wall. So much for an easy exit!"
			)
			(4
				(= cycles 3)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance magicDoor of Prop
	(properties
		x 27
		y 131
		view 714
		priority 10
		signal 16
	)
)

