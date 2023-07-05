;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 292)
(include sci.sh)
(use Main)
(use Jump)
(use Motion)
(use System)

(public
	getRock 0
	youMissed 1
	heCaughtIt 2
	climbDown 3
)

(instance getRock of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 292)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						MoveTo
						(gEgo x:)
						(if (> (gEgo y:) 175)
							(- (gEgo y:) 5)
						else
							(+ (gEgo y:) 5)
						)
				)
				(= cycles 5)
			)
			(1
				(gEgo
					view: 510
					setLoop: (Random 0 1)
					cel: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 8)
			)
			(2
				(HighPrint 292 0) ; "You pick up a few small rocks."
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo get: 21 10) ; boulder
				(HandsOn)
				(gEgo loop: 3 setScript: 0)
				(NormalEgo)
			)
		)
	)
)

(instance youMissed of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 292)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 16 2) ; rock
					setStep: 30 20
					setMotion: MoveTo 0 (- ((ScriptID 16 2) y:) 100) self ; rock
				)
			)
			(1
				((ScriptID 16 2) ; rock
					setMotion: JumpTo (Random 130 160) (Random 145 160) self
				)
			)
			(2
				(HandsOn)
				((ScriptID 16 2) hide: setScript: 0) ; rock
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 292)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== global326 1)
					(self changeState: 3)
				else
					(self cue:)
				)
			)
			(1
				(if (== global326 4)
					((ScriptID 16 1) dispose:) ; flyingSeed
				)
				(gEgo
					view: 0
					setCycle: Walk
					cycleSpeed: 1
					moveSpeed: 1
					setPri: 4
					setLoop: 0
					setMotion: MoveTo 157 90 self
				)
			)
			(2
				(gEgo setLoop: 2 setPri: -1 setMotion: MoveTo 148 96 self)
			)
			(3
				(gEgo view: 517 setLoop: 1 cel: 6 posn: 144 105)
				(= cycles 5)
			)
			(4
				(gEgo cycleSpeed: 2 moveSpeed: 0 setCycle: Beg self)
			)
			(5
				(= cycles 2)
			)
			(6
				(= global326 0)
				(NormalEgo)
				(gEgo posn: 139 137 loop: 3 setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance heCaughtIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCel: 1)
				((ScriptID 16 1) posn: 144 49) ; flyingSeed
				(= cycles 1)
			)
			(1
				((ScriptID 16 1) hide:) ; flyingSeed
				(gEgo setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCel: 4)
				((ScriptID 16 1) posn: 142 56 show:) ; flyingSeed
				(= seconds 4)
			)
			(3
				(TimePrint 4 292 1) ; "You put the seed into your pack and climb down."
				(= global327 2)
				(= global328 2)
				(= seconds 4)
			)
			(4
				(SolvePuzzle 651 8)
				(gEgo get: 20) ; seed
				(= global326 4)
				(SetFlag 136)
				(gEgo setScript: climbDown)
				(SetFlag 192)
			)
		)
	)
)

