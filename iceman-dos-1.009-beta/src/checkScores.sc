;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 379)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	checkScores 0
)

(instance checkScores of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 379)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said 'yes') (or ((ScriptID 39 0) notify: 8) (== state 3))) ; diceRm
				(Print 379 0) ; "Well, thank ya Commander." he says, "A good sport ya surely be!"
				((ScriptID 39 0) notify: 10) ; diceRm
				(self dispose:)
			)
			((and (Said 'no') (or ((ScriptID 39 0) notify: 8) (== state 3))) ; diceRm
				(Print 379 1) ; "Flanagan says, "Well, I thank ya anyway Commander! 'Twas fun wagerin with ya!""
				(SetCursor gTheCursor 1 310 180)
				(gCurRoom newRoom: 32) ; galleyRm
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 3) eachElementDo: #show dScore:) ; oldSaltDice
				((ScriptID 39 2) dScore:) ; johnnyDice
				(= cycles 2)
			)
			(1
				(if
					(<
						((ScriptID 39 3) diceScore:) ; oldSaltDice
						((ScriptID 39 2) diceScore:) ; johnnyDice
					)
					((ScriptID 39 8) show: cycleSpeed: 1 setCycle: Fwd) ; johnnyMouth
				else
					((ScriptID 39 9) loop: 0 cycleSpeed: 2 setCycle: Fwd) ; saltMouth
				)
				(= seconds 3)
			)
			(2
				(cond
					(
						(>
							((ScriptID 39 3) diceScore:) ; oldSaltDice
							((ScriptID 39 2) diceScore:) ; johnnyDice
						)
						(if (== ((ScriptID 39 0) notify: 2) 1) ; diceRm
							((ScriptID 39 0) notify: 2 0) ; diceRm
							((ScriptID 39 0) notify: 1 0) ; diceRm
							((ScriptID 39 0) ; diceRm
								notify: 4 (+ ((ScriptID 39 0) notify: 4) 1) ; diceRm
							)
							((ScriptID 39 0) ; diceRm
								notify: 3 (- ((ScriptID 39 0) notify: 3) 1) ; diceRm
							)
							(switch (Random 0 2)
								(0
									(Print 379 2) ; "Aye!" the old salt says, "Yer makin me wallet fat, SIR!"
								)
								(1
									(Print 379 3) ; "The old salt pipes up and says, "I hate to mention this Commander, but it appears yer dice rollin has cooled off a bit!""
								)
								(2
									(Print 379 4) ; "The rugged old salt says to you, "My, My, My lad! It appears as though yer wings have been clipped again!""
								)
							)
						else
							(if ((ScriptID 39 0) notify: 0) ; diceRm
								(switch (Random 0 1)
									(0
										(Print 379 5) ; ""Ye thought ya had me that time." Flanagan retorts"
									)
									(1
										(Print 379 6) ; "'Twas a good roll, wasn't it Sir?"
									)
								)
							else
								(switch (Random 0 2)
									(0
										(Print 379 7) ; "Flanagan says, "That's one for me.""
									)
									(1
										(Print 379 8) ; "The old man speaks, "One more win and the bet'll be mine!""
									)
									(2
										(Print 379 9) ; ""If I win again it'll be a horse for me." says the old sailor"
									)
								)
							)
							((ScriptID 39 0) notify: 2 1) ; diceRm
						)
						(if (not ((ScriptID 39 0) notify: 8)) ; diceRm
							((ScriptID 39 15) ; oldSaltMoney
								setCel:
									(-
										((ScriptID 39 0) notify: 4) ; diceRm
										(if ((ScriptID 39 0) notify: 5) ; diceRm
											0
										else
											1
										)
									)
							)
							((ScriptID 39 14) ; johnnyMoney
								setCel: ((ScriptID 39 0) notify: 3) ; diceRm
							)
						)
					)
					(
						(<
							((ScriptID 39 3) diceScore:) ; oldSaltDice
							((ScriptID 39 2) diceScore:) ; johnnyDice
						)
						((ScriptID 39 8) setCycle: 0 hide:) ; johnnyMouth
						(if (== ((ScriptID 39 0) notify: 1) 1) ; diceRm
							((ScriptID 39 0) notify: 1 0) ; diceRm
							((ScriptID 39 0) notify: 2 0) ; diceRm
							((ScriptID 39 0) ; diceRm
								notify: 4 (- ((ScriptID 39 0) notify: 4) 1) ; diceRm
							)
							(if ((ScriptID 39 0) notify: 5) ; diceRm
								((ScriptID 39 0) ; diceRm
									notify: 3 (+ ((ScriptID 39 0) notify: 3) 1) ; diceRm
								)
								(if (not ((ScriptID 39 0) notify: 8)) ; diceRm
									((ScriptID 39 15) ; oldSaltMoney
										setCel:
											(-
												((ScriptID 39 0) notify: 4) ; diceRm
												(if ((ScriptID 39 0) notify: 5) ; diceRm
													0
												else
													1
												)
											)
									)
									((ScriptID 39 14) ; johnnyMoney
										setCel: ((ScriptID 39 0) notify: 3) ; diceRm
									)
								)
								(switch (Random 0 2)
									(0
										(Print 379 10) ; ""All right, that's a horse. The bets mine." you say."
									)
									(1
										(Print 379 11) ; ""Great, the wins gives me the pot." you say as you stare into his eyes."
									)
									(2
										(Print 379 12) ; "Your reaction to the win is, "I'll take that bet!""
									)
								)
							else
								((ScriptID 39 0) notify: 5 1) ; diceRm
								((ScriptID 39 0) notify: 8 999) ; diceRm
								(gEgo get: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
								(Print 379 13) ; "Well the rum bottle is mine." you say "Thanks for the game."
							)
						else
							(if ((ScriptID 39 0) notify: 0) ; diceRm
								(switch (Random 0 2)
									(0
										(Print 379 14) ; ""And that's a leg for me. One more will get me a horse." you say"
									)
									(1
										(Print 379 15) ; ""That's one on my side." you reply to no one in particular."
									)
									(2
										(Print 379 16) ; "Your response to the win is, "Lets play!""
									)
								)
							else
								(switch (Random 0 1)
									(0
										(Print 379 17) ; ""Gotcha on that one old man. Thought you had me, though." you verbalize."
									)
									(1
										(Print 379 18) ; ""Whew, came from behind on that roll." you say"
									)
								)
							)
							((ScriptID 39 0) notify: 1 1) ; diceRm
						)
					)
					(else
						(switch (Random 0 2)
							(0
								(Print 379 19) ; "We push, Sir!" Flanagan says, "Let's roll em again."
							)
							(1
								(Print 379 20) ; "Well, a push. Roll em again."
							)
							(2
								(Print 379 21) ; "Do it again Sir. We tied."
							)
						)
					)
				)
				(= cycles 2)
			)
			(3
				((ScriptID 39 0) notify: 13) ; diceRm
				(self dispose:)
			)
		)
	)
)

