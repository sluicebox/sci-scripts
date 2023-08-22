;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 226)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	rollout 0
)

(instance rollout of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 226)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				((ScriptID 96 16) stop:) ; effect
				(if (Said 'stop,grab,stand,halt,no')
					(if (< state 6)
						(= cycles 0)
						(self changeState: 6)
					else
						(event claimed: 1)
					)
				else
					((ScriptID 96 16) play:) ; effect
				)
				(if (Said 'cast')
					(HighPrint 226 0) ; "NOT NOW!!"
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 264)
					((ScriptID 96 8) setCycle: Beg) ; door7
				)
				(if (not (IsFlag 259))
					((ScriptID 96 5) setLoop: 4 setCycle: Fwd) ; yorick
				)
				((ScriptID 96 9) setCycle: End self) ; door11
			)
			(1
				((ScriptID 96 16) ; effect
					number: (SoundFX 83)
					loop: 1
					priority: 2
					play:
				)
				(gEgo edgeHit: EDGE_NONE)
				(gEgo
					view: 296
					setLoop: 4
					setPri: 3
					illegalBits: 0
					posn: 190 63
					cycleSpeed: 0
					moveSpeed: 0
					setStep: 6 4
					setCycle: Fwd
					setMotion: MoveTo 213 78 self
				)
			)
			(2
				(if (IsFlag 264)
					(ClearFlag 264)
					((ScriptID 96 8) stopUpd:) ; door7
					((ScriptID 96 12) dispose:) ; behindDoor7
				)
				(User canInput: 1)
				(if (not (IsFlag 259))
					((ScriptID 96 5) setLoop: 3) ; yorick
				)
				(gEgo setPri: 11 setMotion: MoveTo 268 114 self)
			)
			(3
				(User canInput: 0)
				((ScriptID 96 9) setCycle: Beg) ; door11
				(gEgo setMotion: MoveTo 294 129 self)
			)
			(4
				((ScriptID 96 16) number: (SoundFX 9) loop: 1 priority: 2 play:) ; effect
				((ScriptID 96 2) setCel: 1) ; trap2
				(if (not (IsFlag 259))
					((ScriptID 96 5) setLoop: 4) ; yorick
				)
				(gEgo yStep: 20 setMotion: MoveTo 325 200)
				(= cycles 20)
			)
			(5
				(if (not (TakeDamage 5))
					(EgoDead 226 1 80 {You're the Fall Guy again} 82 517 2 5) ; "You're mad as heck, and you just won't take it anymore. As a matter of fact, you CAN'T take it anymore. Keep up your strength and health and try again."
				else
					((ScriptID 96 2) setCel: 0) ; trap2
					(self changeState: 0)
				)
			)
			(6
				((ScriptID 96 16) ; effect
					number: (SoundFX 87)
					loop: -1
					priority: 2
					play:
				)
				(gEgo
					setLoop: 5
					cel: 0
					setStep: 3 2
					setMotion: MoveTo 278 119 self
					cycleSpeed: 2
					setCycle: CT 2 1
				)
				((ScriptID 96 9) setCycle: Beg) ; door11
			)
			(7
				((ScriptID 96 16) stop:) ; effect
				(gEgo y: (+ (gEgo y:) 14) setCel: 3)
				(= cycles 15)
			)
			(8
				(gEgo setCel: 4)
				((ScriptID 96 9) stopUpd:) ; door11
				(if (not (IsFlag 259))
					((ScriptID 96 5) setLoop: 0 cel: 0 setCycle: 0 stopUpd:) ; yorick
					((ScriptID 96 6) setCel: 1) ; head
				)
				(= cycles 4)
			)
			(9
				(HandsOn)
				(gEgo setLoop: 1)
				(NormalEgo)
				(ClearFlag 260)
				(self dispose:)
			)
		)
	)
)

