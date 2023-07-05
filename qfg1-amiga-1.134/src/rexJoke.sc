;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 135)
(include sci.sh)
(use Main)
(use rm31)
(use Interface)
(use Motion)
(use User)
(use System)

(public
	rexJoke 0
	torchJoke 1
	ottoJoke 2
	commaJoke 3
	dingeJoke 4
	noJoke 5
	flyJoke 6
	broomJoke 7
)

(local
	local0
)

(instance rexJoke of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 135)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(proc31_5 11 135 0)
			)
			(1
				(if global314
					(proc31_5 6 135 1)
					(= global313 0)
					(proc31_8)
				else
					(self cue:)
				)
				(= global314 0)
			)
			(2
				(proc31_5 5 135 2)
				(= cycles 5)
			)
			(3
				(gEgo setCel: 3)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 20)
			)
			(4
				(proc31_8)
				(= global313 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance torchJoke of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 135)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(proc31_5 8 135 3)
			)
			(1
				(proc31_5 4 135 4)
				(= cycles 5)
			)
			(2
				(gEgo setCel: 3)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 20)
			)
			(3
				(proc31_8)
				(= global313 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance ottoJoke of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 135)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(proc31_5 8 135 5)
			)
			(1
				(if global314
					(proc31_5 6 135 6)
					(= global313 0)
					(proc31_8)
				else
					(self cue:)
				)
				(= global314 0)
			)
			(2
				(proc31_5 5 135 7)
				(= cycles 5)
			)
			(3
				(gEgo setCel: 3)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 20)
			)
			(4
				(proc31_8)
				(= global313 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance commaJoke of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 135)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(proc31_5 6 135 8)
			)
			(1
				(if global314
					(proc31_5 3 135 9)
					(= global313 0)
					(proc31_8)
				else
					(self cue:)
				)
				(= global314 0)
			)
			(2
				(proc31_5 5 135 10)
				(= cycles 5)
			)
			(3
				(gEgo setCel: 3)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 20)
			)
			(4
				(proc31_8)
				(= global313 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance dingeJoke of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 135)
	)

	(method (doit)
		(if (and (not global310) (not global311) (not local0))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(= local0 1)
				(proc31_5 6 135 11)
			)
			(1
				(= local0 0)
				(if global314
					(proc31_5 4 135 12)
					(= global313 0)
					(proc31_8)
				)
				(= global314 0)
			)
			(2
				(User canInput: 0)
				(proc31_5 4 135 13)
			)
			(3
				(proc31_6 6 135 14)
			)
			(4
				(gEgo setCel: 3)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 12)
			)
			(5
				(User canInput: 1)
				(proc31_8)
				(= global313 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance noJoke of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 135)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(proc31_5 6 135 15)
			)
			(1
				(if global314
					(proc31_5 8 135 16)
					(= global313 0)
					(proc31_8)
				else
					(self cue:)
				)
				(= global314 0)
			)
			(2
				(proc31_5 4 135 17)
				(= global313 0)
				(proc31_8)
			)
		)
	)
)

(instance flyJoke of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 135)
	)

	(method (doit)
		(if (and (not global310) (not global311) (not local0))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(= local0 1)
				(proc31_5 8 135 18)
			)
			(1
				(= local0 0)
				(if global314
					(proc31_5 4 135 19)
					(= global313 0)
					(proc31_8)
				)
				(= global314 0)
			)
			(2
				(User canInput: 0)
				(proc31_5 4 135 20)
			)
			(3
				(proc31_6 4 135 21)
			)
			(4
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(gEgo setCel: 3)
				(proc31_5 4 135 22)
			)
			(5
				(User canInput: 1)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
				(proc31_8)
				(= global313 0)
			)
		)
	)
)

(instance broomJoke of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 135)
	)

	(method (doit)
		(if (and (not global310) (not global311) (not local0))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global313 1)
				(= global312 0)
				(= local0 1)
				(proc31_5 4 135 23)
			)
			(1
				(= local0 0)
				(if global314
					(proc31_5 4 135 24)
					(= global313 0)
					(proc31_8)
				)
				(= global314 0)
			)
			(2
				(User canInput: 0)
				(proc31_5 4 135 25)
			)
			(3
				(proc31_6 4 135 26)
			)
			(4
				(gEgo setCel: 3)
				(= cycles 5)
			)
			(5
				(Print 135 27 #at 164 85) ; "(Gag!)"
				(= global313 0)
				(User canInput: 1)
				(proc31_8)
			)
		)
	)
)

