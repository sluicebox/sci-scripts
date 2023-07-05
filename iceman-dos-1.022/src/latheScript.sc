;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 388)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n828)
(use Motion)
(use System)

(public
	latheScript 0
	drillScript 1
	grindScript 2
)

(instance latheScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 388 0) ; "The lathe starts turning, slowly reducing the diameter of the metal cylinder."
				((ScriptID 34 2) setCycle: Fwd) ; dial1
				((ScriptID 34 3) setCycle: Fwd) ; dial2
				((ScriptID 34 4) setCycle: Fwd) ; dial3
				((ScriptID 34 5) setCycle: Fwd) ; shaft
				(client setMotion: MoveTo 115 93 client)
				((ScriptID 34 1) number: (proc0_5 30) loop: 1 play:) ; machNoise
			)
			(1
				(Print 388 1) ; "The lathe shuts down after turning down the cylinder to the proper diameter. You remove it from the lathe."
				((ScriptID 34 2) stopUpd:) ; dial1
				((ScriptID 34 3) stopUpd:) ; dial2
				((ScriptID 34 4) stopUpd:) ; dial3
				((ScriptID 34 5) dispose:) ; shaft
				(client setMotion: 0 stopUpd:)
				(HandsOn)
				(SetScore subMarine 406 512 1)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== ((ScriptID 34 1) prevSignal:) -1) ; machNoise
			(self cue:)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 388)
	)
)

(instance drillScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo heading: 0)
				((gEgo looper:) doit: gEgo (gEgo heading:))
				(= cycles 5)
			)
			(1
				(gEgo view: 434 setLoop: 0 setCel: 4 setCycle: Beg self)
			)
			(2
				(gEgo setCycle: End self)
				(client setCycle: End)
			)
			(3
				(Print 388 2) ; "You slowly drill a hole in the end of the metal cylinder."
				((ScriptID 34 1) number: (proc0_5 31) loop: 1 play:) ; machNoise
			)
			(4
				(gEgo setCycle: Beg self)
				(client setCycle: Beg)
			)
			(5
				(client stopUpd:)
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					view: 232
					loop: 3
					setLoop: -1
					setCycle: Walk
					setAvoider: 0
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== ((ScriptID 34 1) prevSignal:) -1) ; machNoise
			(self cue:)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 388)
	)
)

(instance grindScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 388 3) ; "Carefully, you grind the rough edges off the metal cylinder."
				(gEgo view: 434 loop: 1 cel: 0 cycleSpeed: 3 setCycle: Fwd)
				((ScriptID 34 1) number: (proc0_5 17) loop: 1 play:) ; machNoise
			)
			(1
				(Print 388 4) ; "Satisfied, you shut off the grinder."
				(gEgo view: 232 loop: 3 cycleSpeed: 0 setCycle: Walk)
				(SetScore subMarine 406 4096 1)
				(subMarine roomFlags: (| (subMarine roomFlags:) $0004))
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== ((ScriptID 34 1) prevSignal:) -1) ; machNoise
			(self cue:)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 388)
	)
)

