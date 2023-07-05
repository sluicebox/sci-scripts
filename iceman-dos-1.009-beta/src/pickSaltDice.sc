;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 381)
(include sci.sh)
(use Main)
(use diceRm)
(use Motion)
(use System)

(public
	pickSaltDice 0
)

(instance pickSaltDice of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 381)
	)

	(method (doit)
		(if (and (not ((ScriptID 39 17) register:)) (< (self state:) 1)) ; smokeCigar
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				((ScriptID 39 0) notify: 7 1) ; diceRm
				((ScriptID 39 7) setLoop: 4 setCycle: CT 3 1 self) ; saltLArmP
				(= register (proc39_22 (ScriptID 39 3))) ; oldSaltDice
			)
			(2
				((ScriptID 39 20) setLoop: register setCel: 0 hide:) ; redTumble
				((ScriptID 39 21) setCel: (- 5 register)) ; redTable
				((ScriptID 39 7) setLoop: 4 setCycle: End self) ; saltLArmP
			)
			(3
				((ScriptID 39 3) eachElementDo: #roll) ; oldSaltDice
				((ScriptID 39 7) stopUpd:) ; saltLArmP
				(= cycles 2)
			)
			(4
				((ScriptID 39 7) setLoop: 6 cycleSpeed: 1 setCycle: End self) ; saltLArmP
			)
			(5
				((ScriptID 39 0) notify: 7 0) ; diceRm
				((ScriptID 39 7) setLoop: 4 setCel: 0 cycleSpeed: 0 stopUpd:) ; saltLArmP
				(= register (Random 2 4))
				(= cycles 1)
			)
			(6
				((ScriptID 39 6) ; saltRArmP
					setLoop: 2
					setPri: (+ ((ScriptID 39 7) priority:) 1) ; saltLArmP
					setCel: 0
				)
				((ScriptID 39 23) number: (proc0_5 76) loop: 1 play:) ; soundDice
				(= cycles 1)
			)
			(7
				((ScriptID 39 6) setCel: 1) ; saltRArmP
				((ScriptID 39 23) number: (proc0_5 77) loop: 1 play:) ; soundDice
				(= cycles 1)
			)
			(8
				(if register
					(-- register)
					(self changeState: 6)
				else
					(= cycles 1)
				)
			)
			(9
				((ScriptID 39 6) setLoop: 3 setCycle: End self) ; saltRArmP
			)
			(10
				((ScriptID 39 6) stopUpd:) ; saltRArmP
				((ScriptID 39 20) show: setCycle: End self) ; redTumble
				((ScriptID 39 23) number: (proc0_5 75) loop: 1 play:) ; soundDice
			)
			(11
				((ScriptID 39 3) selected: 0 cue:) ; oldSaltDice
				((ScriptID 39 20) stopUpd:) ; redTumble
				((ScriptID 39 21) stopUpd:) ; redTable
				((ScriptID 39 23) dispose:) ; soundDice
				(= cycles 2)
			)
			(12
				((ScriptID 39 6) setLoop: 3 setCycle: Beg self) ; saltRArmP
			)
			(13
				((ScriptID 39 6) ; saltRArmP
					setPri: (- ((ScriptID 39 7) priority:) 1) ; saltLArmP
					setLoop: 1
				)
				(= cycles 2)
			)
			(14
				((ScriptID 39 6) stopUpd:) ; saltRArmP
				(self dispose:)
			)
		)
	)
)

