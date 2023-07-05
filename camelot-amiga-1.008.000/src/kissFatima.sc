;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 193)
(include sci.sh)
(use Main)
(use Rm64)
(use n128)
(use Interface)
(use Avoid)
(use Motion)
(use System)

(public
	kissFatima 0
	givePurse 1
	askAboutTest 2
	fatimaOpensSideDoor 3
)

(instance kissFatima of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 6) (== (gRmMusic prevSignal:) 10))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(proc64_1 193 0) ; "If that is truly your wish, that is what you shall have of me."
			)
			(1
				(gEgo
					illegalBits: 0
					setAvoider: Avoid
					setMotion:
						MoveTo
						(- (global185 x:) 15)
						(- (global185 y:) 5)
						self
				)
				(global185 setLoop: 6)
			)
			(2
				(gEgo setLoop: 0 setAvoider: 0)
				(DisposeScript 985)
				(= seconds 1)
			)
			(3
				(gRmMusic fade:)
				(global185
					view: 370
					setLoop: 1
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(4
				(global185 setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(gRmMusic number: (proc0_20 73) loop: 1 play:)
				(gEgo hide:)
				(global185 view: 370 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(6
				(global185 view: 650 setLoop: 1 setCycle: Fwd)
			)
			(7
				(global185 setLoop: 4 setCel: 0 setCycle: Fwd)
				(= cycles 40)
			)
			(8
				(global185 setLoop: 3 cel: 0 setCycle: CT 2 1 self)
			)
			(9
				(= seconds 1)
			)
			(10
				(gEgo
					view: 650
					setLoop: 3
					setCel: 3
					ignoreActors:
					illegalBits: 0
					show:
					setCycle: End self
					xStep: 5
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:)
				)
				(global185 view: 370 loop: 1 cel: 0)
			)
			(11
				(= seconds 3)
			)
			(12
				(Print 193 1) ; "Alas! You are helpless, completely under Fatima's fatal spell. And here is the reward for your weakness, being strangled to death by Fatima."
				(EgoDead 193 2) ; "How will I ever explain this to the queen? Tsk- tsk."
			)
		)
	)
)

(instance givePurse of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp0 (if (< (gEgo y:) (global185 y:)) 6 else 10))
				(= temp1 (if (< (gEgo y:) (global185 y:)) -4 else 6))
				(gEgo
					setAvoider: Avoid
					setMotion:
						MoveTo
						(+ (global185 x:) temp0)
						(+ (global185 y:) temp1)
						self
				)
			)
			(1
				(gEgo setAvoider: 0)
				(DisposeScript 985)
				(if (>= (gEgo y:) (global185 y:))
					(gEgo
						view: 70
						loop: 0
						cel: 0
						cycleSpeed: 2
						setCycle: End self
					)
				else
					(= seconds 2)
					(gEgo loop: 2)
					(= state 2)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(PutItem 3) ; purse
				(gEgo
					view: 0
					loop: (if (> (gEgo y:) (global185 y:)) 3 else 2)
					cycleSpeed: 0
					setCycle: Walk
				)
				(if (not (IsFlag 164))
					(gTObj talkCue: self)
					(proc64_1 193 3) ; "By giving this purse, you show further proof that you are free of the need to gain material wealth. You grow more and more worthy in my eyes."
				else
					(= seconds 2)
				)
			)
			(4
				(if (not (IsFlag 164))
					(HandsOn)
					(client setScript: 0)
					(DisposeScript 193)
				else
					(client setScript: 0)
					(gEgo setScript: fatimaOpensSideDoor)
				)
			)
		)
	)
)

(instance askAboutTest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gTObj talkCue: self)
				(proc64_1 193 4 193 5 193 6) ; "The Test awaits behind this door. Six tablets, each engraved with a symbol of a Goddess, rest next to a stone plaque with six niches."
			)
			(1
				(if (gEgo has: 3) ; purse
					(proc64_1 193 7) ; "But there is one more thing I require of you, a gesture to show that you are not bound by material possessions. Give me your purse."
					(SetFlag 164)
					(self changeState: 2)
				else
					(client setScript: 0 setScript: fatimaOpensSideDoor)
				)
			)
			(2
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 193)
			)
		)
	)
)

(instance fatimaOpensSideDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(global185
					view: 371
					setLoop: 4
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(global186 cue: 1)
				(= cycles 16)
			)
			(2
				(global185 setCycle: Beg self)
			)
			(3
				(gTObj talkCue: self)
				(proc64_1 193 8) ; "The door is opened. The Test awaits you."
			)
			(4
				(global185 setCycle: Beg self)
			)
			(5
				(global185 cycleSpeed: 0)
				(gEgo illegalBits: -32768)
				(HandsOn)
				(SetFlag 323)
				(client setScript: 0)
				(DisposeScript 193)
			)
		)
	)
)

