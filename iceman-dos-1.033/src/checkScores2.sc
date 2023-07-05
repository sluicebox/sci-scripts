;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 382)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	checkScores2 0
)

(instance checkScores2 of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 382)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (Said 'yes') ((ScriptID 39 0) notify: 8)) ; diceRm
				(Print 382 0) ; "Well, thank ya, Commander" he says, "A good sport ya surely be!"
				(if (== ((ScriptID 39 0) notify: 8) 999) ; diceRm
					((ScriptID 39 0) notify: 8 0) ; diceRm
				)
				((ScriptID 39 0) notify: 10) ; diceRm
				(self dispose:)
			)
			((and (Said 'no') ((ScriptID 39 0) notify: 8)) ; diceRm
				(Print 382 1) ; "Flanagan says, "Well, I thank ya anyway, Commander! It was fun wagerin' with ya!""
				(SetCursor gTheCursor 1 310 180)
				(gCurRoom newRoom: 32) ; galleyRm
				(self dispose:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				((ScriptID 39 9) loop: 1 cel: 1 setCycle: 0) ; saltMouth
				(proc0_3)
				(cond
					((== ((ScriptID 39 0) notify: 8) 999) ; diceRm
						(Print 382 2) ; "Now that ye have won me bottle," says the Old Salt, "Maybe ye would care to play for me money?"
					)
					(
						(and
							(== ((ScriptID 39 0) notify: 4) 0) ; diceRm
							(not ((ScriptID 39 0) notify: 8)) ; diceRm
						)
						((ScriptID 39 0) notify: 8 777) ; diceRm
						((ScriptID 39 15) cel: 0) ; oldSaltMoney
						((ScriptID 39 14) cel: 6) ; johnnyMoney
						(Print 382 3) ; "Commander Sir," old Flanagan says, "It appears ye have ripped me wallet assunder!"
						(Print 382 4) ; "Yer high rollin'," he continues, "has taken me last ten spot. But, I have an item ya might be interested in."
						(Print 382 5) ; "Flanagan explains the electronic device he possesses..."
						(Print 382 6) ; "Commander," he whispers, "On the last mission, I relieved a captured KGB agent of this little jewel."
						(Print 382 7) ; "Continuing he says, "It seems as though this wee device can be used to neutralize magnetic fields!""
						(Print 382 8) ; "If ya think ya can use it, lad, I'll wager the device in return for all yer money!"
					)
					(
						(and
							(== ((ScriptID 39 0) notify: 4) 1) ; diceRm
							((ScriptID 39 0) notify: 8) ; diceRm
						)
						((ScriptID 39 0) ; diceRm
							notify: 3 (- ((ScriptID 39 0) notify: 3) 1) ; diceRm
						)
						(Print 382 9) ; "Flanagan smiles and says, "I'd surely love to play more, Sir! But it's time I start me shift and you're out of money.""
						((ScriptID 39 15) setCel: 6) ; oldSaltMoney
						((ScriptID 39 14) setCel: 0) ; johnnyMoney
						(gCurRoom newRoom: 32) ; galleyRm
						(self dispose:)
					)
					((< ((ScriptID 39 0) notify: 4) 0) ; diceRm
						(Print 382 10) ; "It's plain to see," says Flanagan, "This ain't me day fer wagerin!"
						(Print 382 11) ; "Excusing himself, he continues, "I must be gettin' back to work, Sir. Make sure ya use the wee little device wisely!""
						(gEgo get: 8) ; Sub: Device | Tunisia: Tranquilizer_Gun
						((ScriptID 39 15) setCel: 0) ; oldSaltMoney
						((ScriptID 39 14) setCel: 6) ; johnnyMoney
						(gCurRoom newRoom: 32) ; galleyRm
						(self dispose:)
					)
					((== ((ScriptID 39 0) notify: 3) 0) ; diceRm
						((ScriptID 39 15) setCel: 6) ; oldSaltMoney
						((ScriptID 39 14) setCel: 0) ; johnnyMoney
						(gCurRoom setScript: (ScriptID 376 1)) ; johnnyLost
						(self dispose:)
					)
					(else
						((ScriptID 39 0) notify: 10) ; diceRm
						(self dispose:)
					)
				)
			)
		)
	)
)

