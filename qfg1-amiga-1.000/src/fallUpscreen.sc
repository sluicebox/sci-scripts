;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 225)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	fallUpscreen 0
	fallDownscreen 1
)

(instance fallUpscreen of Script
	(properties)

	(method (dispose)
		(SetFlag 267)
		(super dispose:)
		(DisposeScript 225)
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
				(gEgo view: 536 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				((ScriptID 96 16) number: (SoundFX 9) loop: 1 priority: 2 play:) ; effect
				(gEgo
					setPri: (- (gEgo priority:) 1)
					yStep: 6
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo (gEgo x:) 220 self
				)
			)
			(2
				(if (not (TakeDamage 5))
					(EgoDead 225 0 80 {You're the Fall Guy again.} 82 517 2 5) ; "You're mad as heck, and you're not going to take it anymore. As a matter of fact, you CAN'T take it anymore. Restore your strength and health and try again."
				else
					(ClearFlag 258)
					(ClearFlag 257)
					(SetFlag 260)
					(if (IsFlag 256)
						(ClearFlag 256)
						(gEgo setScript: (ScriptID 226 0)) ; rollout
						(if (== client (ScriptID 96 4)) ; trap4
							(client setPri: (+ (client priority:) 1))
						)
						(client setCel: 0 setScript: 0)
					else
						(gEgo setScript: (ScriptID 226 0)) ; rollout
					)
				)
			)
		)
	)
)

(instance fallDownscreen of Script
	(properties)

	(method (dispose)
		(SetFlag 267)
		(super dispose:)
		(DisposeScript 225)
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
				(gEgo view: 537 setLoop: 0 cel: 0 setCycle: End self)
			)
			(1
				((ScriptID 96 16) number: (SoundFX 9) loop: 1 priority: 2 play:) ; effect
				(gEgo
					setPri: (+ (gEgo priority:) 1)
					yStep: 12
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) 220 self
				)
			)
			(2
				(if (not (TakeDamage 5))
					(EgoDead 225 1 80 {You're the Fall Guy again.} 82 517 2 5) ; "You're mad as heck, and you just won't take it anymore. As a matter of fact, you CAN'T take it anymore. Start over, and remember to keep up your strength and health."
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

