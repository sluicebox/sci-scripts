;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 134)
(include sci.sh)
(use Main)
(use rm31)
(use Motion)
(use System)

(public
	mirrorTalk 0
	wizardTalk 1
	poopTalk 2
	deadTalk 3
	magicTalk 4
	gameTalk 5
)

(instance mirrorTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 134)
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
				(proc31_5 10 134 0)
			)
			(1
				(proc31_6 5 134 1)
			)
			(2
				(proc31_5 5 134 2)
			)
			(3
				(proc31_6 6 134 3)
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
				(= cycles 12)
			)
			(5
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
				(gEgo setCel: 2)
				(proc31_5 11 134 4)
			)
			(6
				(proc31_5 8 134 5)
			)
			(7
				(proc31_6 8 134 6)
			)
			(8
				(proc31_5 4 134 7)
			)
			(9
				(proc31_5 8 134 8)
			)
			(10
				(proc31_8)
			)
		)
	)
)

(instance wizardTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 134)
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
				(proc31_5 7 134 9)
			)
			(1
				(proc31_5 10 134 10)
			)
			(2
				(proc31_5 5 134 11)
			)
			(3
				(proc31_5 7 134 12)
			)
			(4
				(proc31_6 5 134 13)
			)
			(5
				(proc31_5 5 134 14)
			)
			(6
				(proc31_6 6 134 15)
			)
			(7
				(= global311 1)
				(gEgo setCel: 3)
				((ScriptID 31 4) ; fenrus
					cycleSpeed: 0
					setLoop: 6
					setCel: -1
					setCycle: Fwd
				)
				(= cycles 12)
			)
			(8
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
				(gEgo setCel: 2)
				(proc31_8)
			)
		)
	)
)

(instance poopTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 134)
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
				(proc31_5 5 134 16)
			)
			(1
				(proc31_6 5 134 17)
			)
			(2
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
			(3
				(proc31_8)
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance deadTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 134)
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
				(proc31_6 7 134 18)
			)
			(1
				(proc31_5 5 134 19)
			)
			(2
				(proc31_5 6 134 20)
			)
			(3
				(proc31_6 5 134 21)
			)
			(4
				(proc31_5 7 134 22)
			)
			(5
				(proc31_6 4 134 23)
			)
			(6
				(proc31_6 4 134 24)
			)
			(7
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
			(8
				(proc31_8)
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
			)
		)
	)
)

(instance magicTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 134)
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
				(proc31_5 6 134 25)
			)
			(1
				(proc31_6 8 134 26)
			)
			(2
				(proc31_5 3 134 27)
			)
			(3
				(proc31_5 6 134 28)
			)
			(4
				(proc31_6 5 134 29)
			)
			(5
				(proc31_5 9 134 30)
			)
			(6
				(proc31_6 7 134 31)
			)
			(7
				(proc31_5 6 134 32)
			)
			(8
				(proc31_6 3 134 33)
			)
			(9
				(proc31_5 4 134 34)
			)
			(10
				(proc31_6 4 134 35)
			)
			(11
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
			(12
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
				(proc31_8)
			)
		)
	)
)

(instance gameTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 134)
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
				(proc31_5 11 134 36)
			)
			(1
				(proc31_6 5 134 37)
			)
			(2
				(proc31_5 5 134 38)
			)
			(3
				(proc31_5 9 134 39)
			)
			(4
				(proc31_5 9 134 40)
			)
			(5
				(proc31_8)
			)
		)
	)
)

