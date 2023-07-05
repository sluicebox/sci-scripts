;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 234)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	fallSideways 0
	trapFall 1
)

(instance fallSideways of Script
	(properties)

	(method (dispose)
		(SetFlag 267)
		(super dispose:)
		(DisposeScript 234)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 259))
					((ScriptID 96 6) setCel: 3) ; head
					((ScriptID 96 5) ; yorick
						setLoop: 4
						cel: 0
						cycleSpeed: 1
						setCycle: Fwd
					)
				)
				(gEgo
					view: 517
					setLoop: (if (IsFlag 258) 3 else 2)
					x:
						(if (IsFlag 258)
							(- (gEgo x:) 10)
						else
							(+ (gEgo x:) 10)
						)
					cel: 0
					cycleSpeed: 1
					setCycle: CT 2 1 self
				)
				(if (== client (ScriptID 96 3)) ; trap3
					(gEgo setMotion: MoveTo (+ (gEgo x:) 12) (gEgo y:))
				)
			)
			(1
				((ScriptID 96 16) number: (SoundFX 9) loop: 1 priority: 2 play:) ; effect
				(gEgo
					setPri: (- (gEgo priority:) 1)
					yStep: 10
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) 220 self
				)
			)
			(2
				(if (not (TakeDamage 5))
					(EgoDead 234 0 80 {You're the Fall Guy again} 82 517 2 5) ; "You're mad as heck, and you just won't take it anymore. As a matter of fact, you CAN'T take it anymore. Keep up your strength and health and try again."
				else
					(ClearFlag 258)
					(ClearFlag 257)
					(SetFlag 260)
					(if (IsFlag 256)
						(ClearFlag 256)
						(gEgo setScript: (ScriptID 226 0)) ; rollout
						(client setCel: 0 setScript: 0)
					else
						(gEgo setScript: (ScriptID 226 0)) ; rollout
					)
				)
			)
		)
	)
)

(instance trapFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setCel: 1)
				(if (!= client (ScriptID 96 3)) ; trap3
					(client setPri: (- (client priority:) 1))
				)
				(= cycles 1)
			)
			(1
				(if (== client (ScriptID 96 4)) ; trap4
					(SetFlag 270)
					(self dispose:)
				else
					(client setScript: fallSideways)
				)
			)
		)
	)
)

