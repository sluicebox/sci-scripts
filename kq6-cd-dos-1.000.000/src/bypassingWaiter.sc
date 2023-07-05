;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 731)
(include sci.sh)
(use Main)
(use rm730)
(use n913)
(use Motion)
(use Actor)
(use System)

(public
	bypassingWaiter 0
)

(instance bypassingWaiter of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 731)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 59)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 1 1 self) ; "The castle guards lock the main entrance doors behind Alexander."
			)
			(2
				(self setScript: convScript self)
			)
			(3
				(gMessager say: 1 0 1 2 self) ; "From the open door comes the clatter of pots and pans, yelled instructions, and other busy kitchen noises."
			)
			(4
				(self setScript: convScript self)
			)
			(5
				(gMessager say: 1 0 1 3 self) ; "You! Girl! Don't just stand there! There's a stack of silver almost to the ceiling that needs polishing for the wedding! Get a move on!"
			)
			(6
				(self setScript: convScript self)
			)
			(7
				(gMessager say: 1 0 1 4 self) ; "(TO HIMSELF) Phew! I can't afford to get caught up in that mess! I'd never find Cassima."
			)
			(8
				(self setScript: convScript self)
			)
			(9
				(= cycles 2)
			)
			(10
				(gGame handsOn:)
				(ClearFlag 59)
				(self dispose:)
			)
		)
	)
)

(instance convScript of Script
	(properties)

	(method (dispose)
		(= start (+ state 1))
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 315)
				(gGlobalSound4 number: 901 loop: 1 play:)
				(gGlobalSound3 number: 731 loop: -1 play:)
				((ScriptID 730 1) setCycle: End self) ; kitchenDoor
			)
			(1
				(gGlobalSound4 stop:)
				(self dispose:)
			)
			(2
				(waiter
					init:
					ignoreActors:
					illegalBits: 0
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(3
				((ScriptID 730 1) cel: 0 stopUpd:) ; kitchenDoor
				(gGlobalSound3 stop:)
				(gGlobalSound4 number: 902 loop: 1 play:)
				(waiter cel: 5 setCycle: End self)
			)
			(4
				(waiter
					posn: 104 143
					setLoop: (+ (waiter loop:) 1)
					setCycle: CT 5 1 self
				)
			)
			(5
				(self dispose:)
			)
			(6
				(waiter setCycle: End self)
			)
			(7
				(waiter
					setCycle: Walk
					posn: 106 143
					setLoop: (+ (waiter loop:) 1)
					cel: 0
					setMotion: MoveTo 230 144 self
				)
			)
			(8
				(waiter
					setLoop: (+ (waiter loop:) 1)
					posn: 227 144
					cel: 0
					setCycle: End self
				)
				(gGlobalSound4 number: 901 loop: 1 play:)
				((ScriptID 730 2) hide:) ; basementDoor
			)
			(9
				(waiter dispose: setCycle: 0)
				((ScriptID 730 2) show: cel: 3 setCycle: Beg self) ; basementDoor
			)
			(10
				(gGlobalSound4 number: 902 loop: 1 play:)
				((ScriptID 730 2) stopUpd:) ; basementDoor
				((ScriptID 730 1) stopUpd:) ; kitchenDoor
				(self dispose:)
			)
			(11
				(gEgo setMotion: MoveTo 259 167 self)
			)
			(12
				(gEgo setHeading: 315 self)
			)
			(13
				(gEgo
					view: 734
					normal: 0
					setScale: 0
					cycleSpeed: 9
					setLoop: 1
					cel: 0
					posn: 251 168
					setCycle: End self
				)
			)
			(14
				(gEgo setLoop: 2 cel: 0 posn: 253 169 setCycle: End self)
			)
			(15
				(gEgo setLoop: 3 cel: 0 posn: 264 169 setCycle: End self)
			)
			(16
				(gEgo reset: 0 posn: 260 165)
				(gEgo put: 5) ; clothes
				(proc730_3)
				(self dispose:)
			)
		)
	)
)

(instance waiter of Actor
	(properties
		x 92
		y 143
		view 735
		xStep 4
	)
)

