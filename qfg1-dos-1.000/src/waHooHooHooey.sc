;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 138)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	waHooHooHooey 0
)

(instance waHooHooHooey of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 138)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 517
					illegalBits: 0
					setLoop: 2
					cel: 0
					x: (- (gEgo x:) 12)
					setStep: 0 4
					cycleSpeed: 1
					setCycle: End
					setMotion: MoveTo (gEgo x:) 106 self
				)
				((ScriptID 82 4) number: (SoundFX 9) loop: 1 play:) ; rm82Sound
			)
			(1
				((ScriptID 82 4) number: (SoundFX 10) loop: 1 play:) ; rm82Sound
				(if (not (TakeDamage 10))
					(EgoDead ; "Had you been healthier, you probably could have survived that fall. In your weakened condition, however, you succumbed to your injuries."
						138
						0
						82
						517
						2
						5
						80
						{Your figure remains still and silent.}
					)
				else
					(gEgo
						view: 503
						setLoop: 4
						cel: 0
						x: (+ (gEgo x:) 11)
						y: (+ (gEgo y:) 36)
					)
					(self cue:)
				)
			)
			(2
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(3
				(ClearFlag 272)
				(if (IsFlag 274)
					(ClearFlag 274)
				else
					(HighPrint 138 1) ; "Man, that's a narrow ledge up there!"
				)
				(HandsOn)
				(gEgo setLoop: 2)
				(NormalEgo)
				(client setScript: 0)
			)
		)
	)
)

