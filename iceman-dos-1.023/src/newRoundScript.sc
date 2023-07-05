;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 375)
(include sci.sh)
(use Interface)
(use Motion)
(use System)

(public
	newRoundScript 0
)

(instance newRoundScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 375)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not ((ScriptID 39 2) firstTrue: #rolling)) ; johnnyDice
				(not ((ScriptID 39 3) firstTrue: #rolling)) ; oldSaltDice
				(== state 4)
			)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 3) ; oldSaltDice
					selected: 1
					eachElementDo: #select 1
					eachElementDo: #roll
					eachElementDo: #hide
				)
				((ScriptID 39 3) eachElementDo: #selected 1) ; oldSaltDice
				((ScriptID 39 11) dispose:) ; cButton
				((ScriptID 39 12) dispose:) ; rButton
				((ScriptID 39 13) dispose:) ; nButton
				((ScriptID 39 2) ; johnnyDice
					selected: 1
					eachElementDo: #select 1
					eachElementDo: #roll
					eachElementDo: #hide
				)
				((ScriptID 39 2) eachElementDo: #selected 1) ; johnnyDice
				(= cycles 2)
			)
			(1
				(switch (Random 0 1)
					(0
						(= register 1)
						((ScriptID 39 6) setScript: (ScriptID 381 0) self) ; saltRArmP, pickSaltDice
					)
					(1
						(= register 0)
						((ScriptID 39 4) setScript: (ScriptID 380 0) self) ; johnnyRArmP, pickJohnnyDice
					)
				)
			)
			(2
				(if register
					((ScriptID 39 3) eachElementDo: #show) ; oldSaltDice
				)
				(= cycles 2)
			)
			(3
				(if register
					((ScriptID 39 4) setScript: (ScriptID 380 0) self) ; johnnyRArmP, pickJohnnyDice
				else
					((ScriptID 39 6) setScript: (ScriptID 381 0) self) ; saltRArmP, pickSaltDice
				)
			)
			(4
				(if (not register)
					((ScriptID 39 3) eachElementDo: #show) ; oldSaltDice
				)
			)
			(5
				((ScriptID 39 3) dScore:) ; oldSaltDice
				((ScriptID 39 2) dScore:) ; johnnyDice
				(cond
					(
						(and
							((ScriptID 39 2) highPair:) ; johnnyDice
							((ScriptID 39 3) highPair:) ; oldSaltDice
						)
						(cond
							(
								(==
									((ScriptID 39 2) highPair:) ; johnnyDice
									((ScriptID 39 3) highPair:) ; oldSaltDice
								)
								(self changeState: 6)
							)
							(
								(<
									((ScriptID 39 2) highPair:) ; johnnyDice
									((ScriptID 39 3) highPair:) ; oldSaltDice
								)
								((ScriptID 39 0) notify: 0 0) ; diceRm
								((ScriptID 39 0) notify: 12) ; diceRm
								(self dispose:)
							)
							(
								(>
									((ScriptID 39 2) highPair:) ; johnnyDice
									((ScriptID 39 3) highPair:) ; oldSaltDice
								)
								((ScriptID 39 0) notify: 0 1) ; diceRm
								((ScriptID 39 0) notify: 11) ; diceRm
								(self dispose:)
							)
						)
					)
					(
						(<
							((ScriptID 39 2) diceScore:) ; johnnyDice
							((ScriptID 39 3) diceScore:) ; oldSaltDice
						)
						((ScriptID 39 0) notify: 0 0) ; diceRm
						((ScriptID 39 0) notify: 12) ; diceRm
						(self dispose:)
					)
					(
						(>
							((ScriptID 39 2) diceScore:) ; johnnyDice
							((ScriptID 39 3) diceScore:) ; oldSaltDice
						)
						((ScriptID 39 0) notify: 0 1) ; diceRm
						((ScriptID 39 0) notify: 11) ; diceRm
						(self dispose:)
					)
					(
						(==
							((ScriptID 39 2) diceScore:) ; johnnyDice
							((ScriptID 39 3) diceScore:) ; oldSaltDice
						)
						(self changeState: 6)
					)
				)
			)
			(6
				(if ((ScriptID 39 2) diceScore:) ; johnnyDice
					((ScriptID 39 8) show: cycleSpeed: 1 setCycle: Fwd) ; johnnyMouth
				else
					((ScriptID 39 9) loop: 0 cycleSpeed: 2 setCycle: Fwd) ; saltMouth
				)
				(= seconds 3)
			)
			(7
				(if ((ScriptID 39 2) diceScore:) ; johnnyDice
					(switch (Random 0 1)
						(0
							(Print 375 0) ; "That's a push," you say, "We'll have to roll them again."
						)
						(1
							(Print 375 1) ; ""They're equal, we need a new roll," you observe."
						)
					)
				else
					(switch (Random 0 1)
						(0
							(Print 375 2) ; "We push, Sir," Flanagan says, "Let's roll em again!"
						)
						(1
							(Print 375 3) ; "Aye, lad," exclaims the Chief, "Looks like a scrambled mess. We'll need to roll em again."
						)
					)
				)
				(= cycles 2)
			)
			(8
				(if ((ScriptID 39 2) diceScore:) ; johnnyDice
					((ScriptID 39 8) setCycle: 0 hide:) ; johnnyMouth
				else
					((ScriptID 39 9) loop: 1 cel: 1 setCycle: 0) ; saltMouth
				)
				(self changeState: 0)
			)
		)
	)
)

