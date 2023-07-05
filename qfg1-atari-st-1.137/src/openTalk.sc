;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 132)
(include sci.sh)
(use Main)
(use rm31)
(use Motion)
(use System)

(public
	openTalk 0
	fetchTalk 1
	triggerTalk 2
	dazzleTalk 3
	trapTalk 4
	goGame 5
)

(instance openTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 132)
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
				(proc31_5 7 132 0)
			)
			(1
				(proc31_5 7 132 1)
			)
			(2
				(proc31_6 5 132 2)
			)
			(3
				(proc31_5 4 132 3)
			)
			(4
				(proc31_6 4 132 4)
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

(instance fetchTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 132)
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
				(proc31_5 7 132 5)
			)
			(1
				(proc31_5 5 132 6)
			)
			(2
				(proc31_6 4 132 7)
			)
			(3
				(proc31_5 6 132 8)
			)
			(4
				(proc31_6 5 132 9)
			)
			(5
				(proc31_8)
			)
		)
	)
)

(instance triggerTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 132)
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
				(proc31_5 9 132 10)
			)
			(1
				(proc31_5 9 132 11)
			)
			(2
				(proc31_5 6 132 12)
			)
			(3
				(proc31_5 7 132 13)
			)
			(4
				(proc31_5 7 132 14)
			)
			(5
				(proc31_8)
			)
		)
	)
)

(instance dazzleTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 132)
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
				(proc31_5 5 132 15)
			)
			(1
				(proc31_5 6 132 16)
			)
			(2
				(proc31_5 10 132 17)
			)
			(3
				(proc31_8)
			)
		)
	)
)

(instance trapTalk of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 132)
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
				(proc31_5 8 132 18)
			)
			(1
				(proc31_5 9 132 19)
			)
			(2
				(proc31_6 7 132 20)
			)
			(3
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
			(4
				(= global311 0)
				((ScriptID 31 4) cycleSpeed: 1 setLoop: 5 setCel: 0 setCycle: 0) ; fenrus
				(gEgo setCel: 2)
				(proc31_5 5 132 21)
			)
			(5
				(proc31_8)
			)
		)
	)
)

(instance goGame of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 132)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 31 3) ; poof
					cycleSpeed: 0
					cel: 0
					posn: 160 102
					setPri: 14
					setCycle: End self
				)
			)
			(1
				(gEgo setCel: 0)
				((ScriptID 31 9) ; door1
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 143 119
					startUpd:
				)
				((ScriptID 31 10) ; door2
					setLoop: 0
					setCel: 0
					setMotion: MoveTo 178 119 self
					startUpd:
				)
			)
			(2
				(gCurRoom newRoom: 32) ; wizGame
			)
		)
	)
)

