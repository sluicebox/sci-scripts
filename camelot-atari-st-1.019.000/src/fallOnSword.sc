;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 198)
(include sci.sh)
(use Main)
(use n128)
(use Motion)
(use System)

(public
	fallOnSword 0
	sheathSwordAndRun 1
)

(local
	local0
)

(instance fallOnSword of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not local0) (== (gSFX prevSignal:) 10))
			(= local0 1)
			(if (== state 2)
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gRegMusic stop:)
				(gSFX number: 114 loop: 1 play:)
				(gEgo mover: 0)
				(HandsOff)
				(if (not global124)
					(gEgo view: 4 cel: -1 setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					illegalBits: 0
					view: 94
					cel: 1
					cycleSpeed: 1
					setCycle: CT 5 1 self
				)
			)
			(2
				(if local0
					(self cue:)
				)
			)
			(3
				(gEgo cycleSpeed: 0 setCycle: CT 7 1 self)
			)
			(4
				(= cycles 14)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(EgoDead 198 0) ; "Well, at last you have learned to take my advice."
			)
		)
	)
)

(instance sheathSwordAndRun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global124 0)
				(gEgo
					view: 4
					cel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(1
				(gEgo view: 92)
				(SetFlag 317)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 198)
	)
)

