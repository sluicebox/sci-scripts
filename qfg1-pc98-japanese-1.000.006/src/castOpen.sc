;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 115)
(include sci.sh)
(use Main)
(use rm15)
(use Motion)

(public
	castOpen 0
	castTrig 1
)

(instance castOpen of KScript
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 521 setLoop: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(SetFlag 216)
				(if (TrySkill 17 50 0) ; openSpell
					(self cue:)
				else
					((ScriptID 15 2) setScript: (ScriptID 15 5)) ; chest, chestBlows
					(self dispose:)
				)
			)
			(2
				(SetFlag 151)
				(LowPrint 115 0) ; "The invisible lid of the invisible chest lifts. A ripple of magical heat in the air informs you of a trap narrowly avoided by your skillful use of the Open spell."
				(proc15_1 1)
				(LookAt gEgo (ScriptID 15 2)) ; chest
				(self dispose:)
			)
		)
	)
)

(instance castTrig of KScript
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 521 setLoop: 1 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(SetFlag 216)
				((ScriptID 15 2) setScript: (ScriptID 15 5)) ; chest, chestBlows
				(self dispose:)
			)
		)
	)
)

