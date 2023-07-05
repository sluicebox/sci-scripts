;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use diceRm)
(use Motion)
(use System)

(public
	pickJohnnyDice 0
)

(instance pickJohnnyDice of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 380)
	)

	(method (doit)
		(if (and (not ((ScriptID 39 16) register:)) (< (self state:) 1)) ; johnTwitch
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				((ScriptID 39 0) notify: 6 1) ; diceRm
				(= register (proc39_22 (ScriptID 39 2))) ; johnnyDice
				((ScriptID 39 5) setLoop: 5 setCycle: CT 3 1 self) ; johnnyLArmP
			)
			(2
				((ScriptID 39 18) setLoop: register setCel: 0 hide:) ; greenTumble
				((ScriptID 39 19) setCel: (- 5 register)) ; greenTable
				((ScriptID 39 5) setCycle: End self) ; johnnyLArmP
			)
			(3
				((ScriptID 39 2) eachElementDo: #roll) ; johnnyDice
				((ScriptID 39 5) stopUpd:) ; johnnyLArmP
				(= cycles 2)
			)
			(4
				((ScriptID 39 5) setLoop: 9 setCel: 255 setCycle: Beg self) ; johnnyLArmP
				(= register (Random 2 4))
			)
			(5
				((ScriptID 39 4) setLoop: 6 setCel: 0) ; johnnyRArmP
				((ScriptID 39 23) number: (proc0_5 76) loop: 1 play:) ; soundDice
				(= cycles 1)
			)
			(6
				((ScriptID 39 4) setLoop: 6 setCel: 1) ; johnnyRArmP
				((ScriptID 39 23) number: (proc0_5 77) loop: 1 play:) ; soundDice
				(= cycles 1)
			)
			(7
				(if register
					(-- register)
					(self changeState: 5)
				else
					(= cycles 1)
				)
			)
			(8
				((ScriptID 39 23) number: (proc0_5 77) loop: 1 play:) ; soundDice
				((ScriptID 39 4) setLoop: 7 setCycle: End self) ; johnnyRArmP
			)
			(9
				((ScriptID 39 4) stopUpd:) ; johnnyRArmP
				((ScriptID 39 18) show: setCycle: End) ; greenTumble
				((ScriptID 39 0) notify: 6 0) ; diceRm
				((ScriptID 39 23) number: (proc0_5 89) loop: 1 play:) ; soundDice
				(= seconds 4)
			)
			(10
				((ScriptID 39 23) dispose:) ; soundDice
				((ScriptID 39 11) init:) ; cButton
				((ScriptID 39 12) init:) ; rButton
				((ScriptID 39 13) init:) ; nButton
				((ScriptID 39 2) eachElementDo: #show selected: 0 cue:) ; johnnyDice
				((ScriptID 39 18) stopUpd:) ; greenTumble
				((ScriptID 39 19) stopUpd:) ; greenTable
				(= cycles 2)
			)
			(11
				((ScriptID 39 4) setLoop: 7 setCycle: Beg self) ; johnnyRArmP
			)
			(12
				((ScriptID 39 4) stopUpd:) ; johnnyRArmP
				(= cycles 2)
			)
			(13
				(self dispose:)
			)
		)
	)
)

