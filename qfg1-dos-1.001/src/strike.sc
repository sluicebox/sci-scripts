;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 122)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	strike 0
)

(local
	local0
	local1
)

(instance strike of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(ClearFlag 339)
		(DisposeScript 122)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 318)
				(= global316 (gEgo view:))
				(= global317 (gEgo loop:))
				(= global318 (gEgo cel:))
				(HandsOff)
				(cond
					((== global315 3)
						(= local0 1)
					)
					((gEgo has: 9) ; shield
						(if (not (TakeDamage 15))
							(= local0 1)
						)
					)
					((not (TakeDamage 20))
						(= local0 1)
					)
				)
				(self cue:)
			)
			(1
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
			(2
				(if local0
					(= local1 1)
					(if
						(and
							(not ((ScriptID 15 4) script:)) ; ball
							(not ((ScriptID 15 6) script:)) ; dart
						)
						(if (== global315 3)
							(if (IsFlag 306)
								(EgoDead 122 0 80 {HUH?} 82 800 0 0) ; "Well, you THOUGHT all was calm. Maybe it was just YOU that got calmed. Or maybe the Kobold just CALMLY blasted you into oblivion. Maybe he really doesn't want to talk about it."
							else
								(EgoDead 122 1 80 {OH NOOOOOOO!} 82 800 0 0) ; "You lost your concentration when you contemplated changing fighting modes. The Kobold managed to blast you out of the game."
							)
						else
							(EgoDead 122 2 80 {ARRGGGHHH!!} 82 800 0 0) ; "The power of the Kobold Wizard's magic overcomes you. The best defense against such power would have been a good strategy."
						)
					else
						(= cycles 5)
					)
				else
					(= cycles 5)
				)
			)
			(3
				(cond
					(local1
						(self changeState: 2)
					)
					((IsFlag 315)
						(gEgo
							view: global316
							loop: global317
							cel: 0
							forceUpd:
						)
						(SetFlag 308)
						(SetFlag 318)
						(HandsOn)
						(client setScript: 0)
					)
					(else
						(NormalEgo)
						(gEgo
							view: global316
							loop: global317
							cel: global318
							forceUpd:
						)
						(if (== (gEgo view:) 0)
							(LookAt gEgo (ScriptID 15 1)) ; kobold
						)
						(gEgo cel: 0)
						(SetFlag 318)
						(HandsOn)
						(client setScript: 0)
					)
				)
			)
		)
	)
)

