;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 129)
(include sci.sh)
(use Main)
(use Sound)
(use Motion)
(use System)

(public
	openSpell 0
	unlockChest 1
)

(local
	local0
)

(instance blowUp of Sound
	(properties
		number 62
		priority 1
	)
)

(instance openSpell of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 129)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 521 setLoop: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 12)
			)
			(1
				(SetFlag 166)
				(blowUp number: (SoundFX 36) init: play:)
				((ScriptID 15 8) ; chest
					setLoop: 2
					cel: 0
					cycleSpeed: 0
					setCycle: CT 4 1 self
				)
			)
			(2
				(blowUp number: (SoundFX 62) loop: 1 play:)
				((ScriptID 15 8) setCycle: End) ; chest
				(if (< global315 2)
					(= global315 2)
					(SetFlag 297)
				)
				(if (< (gEgo distanceTo: (ScriptID 15 8)) 20) ; chest
					(if (not (TakeDamage 20))
						(= local0 1)
					)
					(gEgo
						view: 513
						loop:
							(cond
								(local0
									(if (IsFlag 149) 1 else 0)
								)
								((IsFlag 149) 3)
								(else 2)
							)
						cel: 0
						illegalBits: 0
						cycleSpeed: 1
						setCycle: End self
					)
				)
				(= cycles 10)
			)
			(3
				(blowUp dispose:)
				(cond
					(local0
						(EgoDead 129 0 80 {Smithereens} 82 800 0 0) ; "You weren't able to take the full force of the blast from the magically booby-trapped Kobold's chest."
					)
					((< (gEgo distanceTo: (ScriptID 15 8)) 20) ; chest
						(HighPrint 129 1) ; "Wow! The chest must've been booby-trapped. You can really feel the damage from the blast."
						(= global319 2)
						(= cycles 5)
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(= global322 3)
				((ScriptID 15 8) stopUpd:) ; chest
				(EgoGait 0 0) ; walking
				(HandsOn)
				(NormalEgo)
				(gEgo loop: 2 forceUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance unlockChest of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 129)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 510
					setLoop: (if (< ((ScriptID 15 8) x:) (gEgo x:)) 1 else 0) ; chest
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 8)
			)
			(1
				(cond
					((and (TrySkill 9 70 global189) (not (IsFlag 342))) ; pick locks
						(HighPrint 129 2) ; "The invisible chest's invisible lid lifts."
						(HighPrint 129 3) ; "You add ten gold and sixty silver pieces to your money pouch."
						(= global322 2)
						(SolvePuzzle 650 5)
						(gEgo get: 1 60) ; silver
						(gEgo get: 2 10 setCycle: Beg self) ; gold
					)
					((IsFlag 342)
						(if (TrySkill 0 50) ; strength
							(HighPrint 129 4) ; "You pry at the sealed lid of the chest, and..."
							(if (not (TakeDamage 20))
								(= local0 1)
							)
						else
							(SetFlag 343)
							(HighPrint 129 5) ; "You hack and pry at the chest, but it seems to be stronger than you are."
							(if (< global315 2)
								(= global315 2)
								(SetFlag 297)
							)
							(EgoGait 0 0) ; walking
						)
					)
					(else
						(HighPrint 129 6) ; "Your fingers shift slightly, and..."
						(if (not (TakeDamage 20))
							(= local0 1)
						)
					)
				)
				(= cycles 2)
			)
			(2
				(if (or (== global322 2) (IsFlag 343))
					(ClearFlag 343)
					(NormalEgo)
					(HandsOn)
					(client setScript: 0)
				else
					(blowUp number: (SoundFX 36) init: play:)
					((ScriptID 15 8) ; chest
						setLoop: 2
						cel: 0
						cycleSpeed: 0
						setCycle: CT 4 1 self
					)
				)
			)
			(3
				(blowUp number: (SoundFX 62) loop: 1 play:)
				((ScriptID 15 8) setCycle: End) ; chest
				(if (< global315 2)
					(= global315 2)
					(SetFlag 297)
				)
				(gEgo
					view: 513
					loop:
						(cond
							(local0
								(if (IsFlag 149) 1 else 0)
							)
							((IsFlag 149) 3)
							(else 2)
						)
					cel: 0
					illegalBits: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(4
				(blowUp dispose:)
				(if local0
					(EgoDead 129 0 80 {Smithereens} 82 800 0 0) ; "You weren't able to take the full force of the blast from the magically booby-trapped Kobold's chest."
				else
					(HighPrint 129 1) ; "Wow! The chest must've been booby-trapped. You can really feel the damage from the blast."
					(= global322 3)
					(= global319 2)
					(= cycles 5)
					(NormalEgo)
				)
			)
			(5
				(EgoGait 0 0) ; walking
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

