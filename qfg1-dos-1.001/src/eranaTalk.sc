;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 133)
(include sci.sh)
(use Main)
(use rm31)
(use Motion)
(use System)

(public
	eranaTalk 0
	peaceTalk 1
	zaraTalk 2
	babaTalk 3
	curseTalk 4
	counterCurseTalk 5
	fenrusTalk 6
	hermitTalk 7
	initiationTalk 8
)

(instance eranaTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 133)
	)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(proc31_5 5 133 0)
			)
			(1
				(proc31_5 9 133 1)
			)
			(2
				(proc31_5 9 133 2)
			)
			(3
				(proc31_6 8 133 3)
			)
			(4
				(= global311 1)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 6)
			)
			(5
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
				(proc31_5 10 133 4)
			)
			(6
				(= global312 1)
				(client setScript: 0)
			)
		)
	)
)

(instance peaceTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 133)
	)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(proc31_5 9 133 5)
			)
			(1
				(proc31_5 9 133 6)
			)
			(2
				(proc31_5 5 133 7)
			)
			(3
				(proc31_6 4 133 8)
			)
			(4
				(= global311 1)
				(gEgo setCel: 3)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 8)
			)
			(5
				(proc31_8)
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance zaraTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 133)
	)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(proc31_5 9 133 9)
			)
			(1
				(proc31_5 6 133 10)
			)
			(2
				(proc31_6 8 133 11)
			)
			(3
				(proc31_6 5 133 12)
			)
			(4
				(= global311 1)
				(gEgo setCel: 3)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 8)
			)
			(5
				(proc31_8)
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance babaTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 133)
	)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(proc31_5 9 133 13)
			)
			(1
				(proc31_5 6 133 14)
			)
			(2
				(proc31_6 4 133 15)
			)
			(3
				(proc31_5 7 133 16)
			)
			(4
				(proc31_6 5 133 17)
			)
			(5
				(= global311 1)
				(gEgo setCel: 3)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 8)
			)
			(6
				(proc31_8)
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance curseTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 133)
	)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(proc31_5 7 133 18)
			)
			(1
				(proc31_5 10 133 19)
			)
			(2
				(proc31_5 7 133 20)
			)
			(3
				(proc31_8)
			)
		)
	)
)

(instance counterCurseTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 133)
	)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(proc31_5 10 133 21)
			)
			(1
				(proc31_5 8 133 22)
			)
			(2
				(proc31_7 133 23)
			)
			(3
				(proc31_7 133 24)
			)
			(4
				(proc31_7 133 25)
			)
			(5
				(proc31_7 133 26)
			)
			(6
				(proc31_5 11 133 27)
			)
			(7
				(proc31_6 8 133 28)
			)
			(8
				(proc31_8)
			)
		)
	)
)

(instance fenrusTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 133)
	)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(proc31_6 9 133 29)
			)
			(1
				(proc31_5 6 133 30)
			)
			(2
				(proc31_8)
			)
		)
	)
)

(instance hermitTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 133)
	)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(proc31_5 7 133 31)
			)
			(1
				(proc31_6 6 133 32)
			)
			(2
				(proc31_5 8 133 33)
			)
			(3
				(proc31_5 5 133 34)
			)
			(4
				(proc31_6 5 133 35)
			)
			(5
				(proc31_8)
			)
		)
	)
)

(instance initiationTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 133)
	)

	(method (doit)
		(if (and (not global310) (not global311))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global312 0)
				(proc31_5 7 133 36)
			)
			(1
				(proc31_8)
			)
		)
	)
)

