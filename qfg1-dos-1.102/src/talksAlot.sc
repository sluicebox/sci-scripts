;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	talksAlot 0
	knockout 1
)

(instance talksAlot of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 230)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 43 188 self)
			)
			(1
				(gEgo loop: 2)
				(= cycles 2)
			)
			(2
				(HighPrint 230 0) ; "You bar the door behind you."
				(gEgo setMotion: MoveTo 43 179 self)
			)
			(3
				(gEgo illegalBits: -32768)
				(HighPrint 230 1) ; "You behold a most fascinating place."
				(HighPrint 230 2) ; "The person labeled "ME" speaks:"
				(HighPrint 230 3) ; "Abandon mope, all ye who enter here!"
				(HighPrint 230 4) ; "Job hunting, or just sight-seeing?"
				(HighPrint 230 5) ; "I foresee a brilliant future for you in the fall."
				(HighPrint 230 6) ; "If you've got something to say, then speak fast or forever hold your pieces."
				(HighPrint 230 7) ; "State your case before I case your estate!"
				(self cue:)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance knockout of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 230)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 73 117 self)
			)
			(1
				(gEgo view: 296 setLoop: 7 setCel: 0)
				(= cycles 8)
			)
			(2
				((ScriptID 96 7) setPri: (+ (gEgo priority:) 1) setCel: 1) ; door3
				(= cycles 2)
			)
			(3
				((ScriptID 96 7) ; door3
					setPri: (- ((ScriptID 96 7) priority:) 1) ; door3
					setCel: 2
				)
				(gEgo setCel: 1)
				(= cycles 2)
				(if (not (IsFlag 259))
					((ScriptID 96 6) setCel: 3) ; head
					((ScriptID 96 5) ; yorick
						setLoop: 4
						cel: 0
						cycleSpeed: 1
						setCycle: Fwd
					)
				)
			)
			(4
				((ScriptID 96 16) ; effect
					number: (SoundFX 85)
					loop: 1
					priority: 2
					play:
				)
				((ScriptID 96 7) setCel: 3) ; door3
				(gEgo posn: 91 111 setCel: 2)
				(= cycles 2)
			)
			(5
				((ScriptID 96 7) setCel: 4) ; door3
				(gEgo posn: 109 107 setCel: 3)
				(= cycles 2)
			)
			(6
				((ScriptID 96 7) setCel: 5) ; door3
				(gEgo setPri: 7 posn: 126 119 setCel: 4)
				(= cycles 2)
			)
			(7
				((ScriptID 96 7) setCel: 0 stopUpd:) ; door3
				(gEgo posn: 137 137)
				(= cycles 2)
			)
			(8
				(gEgo posn: 152 161)
				(= cycles 2)
			)
			(9
				(gEgo posn: 160 189)
				(if (not (TakeDamage 5))
					(EgoDead 230 8 80 {You're the Fall Guy again} 82 517 2 5) ; "You're mad as heck, and you just won't take it anymore. As a matter of fact, you CAN'T take it anymore. Keep up your strength and health and try again."
				else
					(= cycles 10)
				)
			)
			(10
				(ClearFlag 258)
				(ClearFlag 257)
				(SetFlag 260)
				(gEgo setScript: (ScriptID 226 0)) ; rollout
				(client setScript: 0)
			)
		)
	)
)

