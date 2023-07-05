;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 397)
(include sci.sh)
(use Main)
(use subMarine_314)
(use Submarine_806)
(use n821)
(use LoadMany)
(use System)

(public
	russianSub 0
)

(local
	local0
)

(instance russianSub of Script
	(properties)

	(method (doit)
		(tempController doit:)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 396)
		(if (< state 9)
			(EgoDead 926 1 0 397 0) ; "Derelict of duty, you left your post."
		else
			(super dispose:)
			(DisposeScript 397)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSCRIPT 399)
				(self setScript: (ScriptID 398) self) ; subBattleScript
			)
			(1
				(= cycles 2)
			)
			(2
				(gIceGlobalSound number: (proc0_5 93) priority: 1 loop: -1 play:)
				(self setScript: (ScriptID 399) self) ; torpedosIn
			)
			(3
				(gIceGlobalSound fade:)
				(= cycles 2)
			)
			(4
				(self setScript: (ScriptID 342) self) ; coontz
			)
			(5
				(= cycles 2)
			)
			(6
				(self setScript: (ScriptID 341) self) ; gettingUnderCoontz
			)
			(7
				(= cycles 2)
			)
			(8
				(self setScript: (ScriptID 340) self) ; trackingTheCoontz
			)
			(9
				(subMarine cue:)
				(self dispose:)
			)
		)
	)
)

(instance tempController of Code
	(properties)

	(method (doit &tmp temp0)
		(if (not (umod (++ local0) 10))
			(Submarine
				waterTemp:
					(cond
						((< (= temp0 (Submarine depth:)) 1100)
							(- 12 (/ temp0 75))
						)
						((< (= temp0 (Submarine depth:)) 1300)
							(- 3 (Abs (/ (- temp0 1200) 50)))
						)
						(else
							(- 12 (/ temp0 100))
						)
					)
			)
		)
	)
)

