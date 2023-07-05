;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 125)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	intro 0
	wakeUp 1
	getOut 2
	getUp 3
	detector 4
)

(instance intro of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 125)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 65 63 self)
			)
			(1
				(if (not (IsFlag 5))
					(LowPrint 125 0) ; "As you look across this section of the cave, you see a Kobold resting on a ledge across from you."
				)
				(if (< global315 4)
					(gEgo setMotion: MoveTo 100 77 self)
				else
					(self cue:)
				)
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance wakeUp of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 15 1) setCycle: End) ; kobold
				(= cycles 12)
			)
			(1
				((ScriptID 15 1) setLoop: 7 setCycle: Fwd) ; kobold
				(TimePrint 3 125 1) ; "You go! You no stay here!"
				(= seconds 3)
			)
			(2
				(if (IsFlag 147)
					(= global315 2)
					(SetFlag 289)
					(SetFlag 297)
				else
					(HandsOn)
				)
				((ScriptID 15 1) setCycle: 0 setScript: 0) ; kobold
			)
		)
	)
)

(instance getOut of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 125)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 15 1) setLoop: 7 setCycle: Fwd) ; kobold
				(TimePrint 3 125 2) ; "No talk! You GO!"
				(= seconds 3)
			)
			(1
				(if (not (gEgo script:))
					(HandsOn)
				)
				((ScriptID 15 1) setCycle: 0 setScript: 0) ; kobold
			)
		)
	)
)

(instance getUp of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 125)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global315 2)
				((ScriptID 15 1) ; kobold
					ignoreActors:
					posn: ((ScriptID 15 2) x:) ((ScriptID 15 2) y:) ; body, body
					setLoop: 0
				)
				((ScriptID 15 2) dispose:) ; body
				(= cycles 2)
			)
			(1
				(gContMusic number: 23 loop: -1 play:)
				(if (IsFlag 157)
					(SetFlag 284)
				else
					(SetFlag 280)
				)
				(if (not (gEgo script:))
					(HandsOn)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance detector of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 125)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((and (IsFlag 165) (gEgo has: 5)) ; key
						(LowPrint 125 3) ; "There is a strong aura of magic around the key you have taken from the Kobold."
					)
					((== global321 0)
						(LowPrint 125 4) ; "There is a strong aura of magic around the key hanging from the Kobold's neck."
						((ScriptID 15 9) setCycle: End self) ; keySparkle
					)
					((== global321 1)
						(LowPrint 125 5) ; "There is magic in the key left behind by the Kobold."
					)
				)
				(cond
					((< global322 3)
						(LowPrint 125 6) ; "You see the outline of a chest glowing in a corner of the cavern."
						((ScriptID 15 8) setCycle: End self) ; chest
					)
					((< global322 5)
						(LowPrint 125 7) ; "You can detect faint glimmerings of magic from the remains of the exploded chest."
					)
					((and (== global321 2) (== global322 5))
						(LowPrint 125 8) ; "There is no magic here any more."
					)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

