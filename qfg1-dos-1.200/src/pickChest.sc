;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 116)
(include sci.sh)
(use Main)
(use rm15)
(use Motion)

(public
	pickChest 0
)

(instance pickChest of KScript
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 116)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 216)
				(gEgo
					view: 510
					setLoop: (if (< ((ScriptID 15 2) x:) (gEgo x:)) 1 else 0) ; chest
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 8)
			)
			(1
				(= temp0 (= temp1 1))
				(cond
					((and register (TrySkill 0 40 0)) ; strength
						(SetFlag 282)
						(LowPrint 116 0) ; "You pry at the sealed lid of the chest, and..."
					)
					(register
						(LowPrint 116 1) ; "You hack and pry at the chest, but you are not strong enough to force its lid."
						(= temp1 0)
					)
					((TrySkill 9 70 global189) ; pick locks
						(LowPrint 116 2) ; "You hear a very satisfying "Snick" as your pick catches the lock just right. Then you sense powerful magics dissipating around the lock, and your hands shake as you realize you have narrowly avoided some sort of Magical Doom."
						(= temp0 (= temp1 0))
						(SetFlag 151)
					)
					(else
						(LowPrint 116 3) ; "Your fingers shift slightly, and you feel an odd prickling sensation coming from the lock. You have a bad feeling about this."
					)
				)
				(if temp0
					(proc15_6)
				)
				(if temp1
					((ScriptID 15 2) setScript: (ScriptID 15 5)) ; chest, chestBlows
				else
					(proc15_1 1)
				)
				(self dispose:)
			)
		)
	)
)

