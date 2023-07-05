;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 208)
(include sci.sh)
(use Main)
(use Rm64)
(use n128)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	moveEgoAndFatimaToCouch 0
	moveEgoToCouch 1
	moveFatimaToCouch 2
	kissAndSmother 3
)

(instance fallenArmor of View
	(properties
		y 140
		x 35
		view 370
		priority 7
		signal 16
	)
)

(instance moveEgoAndFatimaToCouch of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 0)
				(== (gEgo script:) 0)
				(== ((ScriptID 64 4) script:) 0) ; fatima
			)
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setScript: moveEgoToCouch)
				((ScriptID 64 4) setScript: moveFatimaToCouch) ; fatima
			)
			(1
				(client setScript: kissAndSmother)
			)
		)
	)
)

(instance moveEgoToCouch of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (gEgo inRect: 0 118 130 148))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global215 (proc64_2 gEgo))
				((ScriptID 64 5) endOfPath: 12) ; egoPath
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: (ScriptID 64 5) self ; egoPath
				)
			)
			(1
				(gEgo setMotion: MoveTo 15 135 self)
			)
			(2
				(gEgo loop: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance moveFatimaToCouch of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) ((ScriptID 64 4) inRect: 0 118 130 148)) ; fatima
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global216 (proc64_2 (ScriptID 64 4))) ; fatima
				((ScriptID 64 6) endOfPath: 12) ; fatimaPath
				((ScriptID 64 4) ; fatima
					view: 369
					ignoreActors:
					illegalBits: 0
					setMotion: (ScriptID 64 6) self ; fatimaPath
				)
			)
			(1
				((ScriptID 64 4) setMotion: MoveTo 45 138 self) ; fatima
			)
			(2
				(= global217 0)
				(if (> ((ScriptID 64 4) y:) (gEgo y:)) ; fatima
					(= global218 2)
				else
					(= global218 1)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance kissAndSmother of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== state 2) global220)
				(= global219 0)
				(self cue:)
			)
			((and (== state 7) (== (gRmMusic prevSignal:) 10))
				(self cue:)
			)
			((and (== state 12) (== (gRmMusic prevSignal:) 20))
				(self cue:)
			)
			((and (== state 14) (== (gRmMusic prevSignal:) 30))
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: MoveTo 25 134 self)
			)
			(1
				(gEgo setLoop: 0 setMotion: MoveTo 31 136 self)
			)
			(2 0)
			(3
				((ScriptID 64 7) fade:) ; bellySound
				((ScriptID 64 4) ; fatima
					view: 370
					setLoop: 1
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(4
				(= seconds 1)
			)
			(5
				((ScriptID 64 4) setLoop: 2 setCel: 0 setCycle: End self) ; fatima
			)
			(6
				(gEgo hide:)
				(gRmMusic number: (proc0_20 73) loop: 1 play:)
				((ScriptID 64 4) setLoop: 3 setCel: 0 setCycle: End self) ; fatima
			)
			(7
				(Print 208 0 #dispose) ; "No, Arthur, no!"
			)
			(8
				(clr)
				((ScriptID 64 4) setLoop: 4 cel: 0 setCycle: End self) ; fatima
			)
			(9
				(= seconds 1)
			)
			(10
				(fallenArmor init: stopUpd:)
				((ScriptID 64 4) ; fatima
					setLoop: 5
					setCel: 0
					cycleSpeed: 3
					setCycle: CT 2 1 self
				)
			)
			(11
				((ScriptID 64 4) posn: 60 134 setCel: 2 setCycle: End self) ; fatima
			)
			(12 0)
			(13
				((ScriptID 64 4) ; fatima
					setLoop: 6
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(14 0)
			(15
				(Print 208 1) ; "Alas! You are helpless, completely under Fatima's fatal spell. And here is the reward for your weakness, being smothered to death by a perfumed pillow."
				(EgoDead 208 2) ; "How will I ever explain this to the queen? Tsk- tsk."
			)
		)
	)
)

