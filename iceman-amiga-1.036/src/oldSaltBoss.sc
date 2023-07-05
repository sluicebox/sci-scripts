;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 378)
(include sci.sh)
(use Main)
(use diceRm)
(use Interface)
(use Motion)
(use System)

(public
	oldSaltBoss 0
	johnnyRoll2 1
)

(local
	local0
)

(instance oldSaltBoss of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(if register
			(DisposeScript 378)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 2)
					(0
						(Print 378 0) ; "He says, "Well, I'm Boss.""
					)
					(1
						(Print 378 1) ; ""Let's see what I can roll, Commander." the old guy says."
					)
					(2
						(Print 378 2) ; ""Tis me that's Boss." he says."
					)
				)
				(proc39_1)
				(= cycles 2)
			)
			(1
				(if ((ScriptID 39 3) selected:) ; oldSaltDice
					((ScriptID 39 6) setScript: (ScriptID 381 0) self) ; saltRArmP, pickSaltDice
				else
					(= cycles 2)
				)
			)
			(2
				((ScriptID 39 9) loop: 0 cycleSpeed: 2 setCycle: Fwd) ; saltMouth
				(= seconds 3)
			)
			(3
				((ScriptID 39 9) loop: 1 cel: 1 setCycle: 0) ; saltMouth
				((ScriptID 39 3) dScore:) ; oldSaltDice
				((ScriptID 39 2) dScore:) ; johnnyDice
				(if
					(or
						(> ((ScriptID 39 3) diceScore:) 500) ; oldSaltDice
						(and
							(> ((ScriptID 39 3) diceScore:) 400) ; oldSaltDice
							(< ((ScriptID 39 2) diceScore:) 200) ; johnnyDice
						)
						(and
							(> ((ScriptID 39 3) diceScore:) 300) ; oldSaltDice
							(< ((ScriptID 39 2) diceScore:) 200) ; johnnyDice
						)
						(and
							(> ((ScriptID 39 3) diceScore:) 200) ; oldSaltDice
							(< ((ScriptID 39 2) diceScore:) 100) ; johnnyDice
						)
					)
					(switch (Random 0 2)
						(0
							(Print 378 3) ; "Mercy, mercy, lad," he begs, "Show me what you have!"
						)
						(1
							(Print 378 4) ; ""Let me see 'em, Commander." the old guy says."
						)
						(2
							(Print 378 5) ; "He looks you in the eye and demands, "Come on up!""
						)
					)
					(= register 0)
					(client setScript: johnnyRoll2)
				else
					(switch (Random 0 2)
						(0
							(Print 378 6) ; "The dice aren't working for me!" he complains, "I'll be havin' to ask ye to roll again."
						)
						(1
							(Print 378 7) ; ""Start a new round," he scowls."
						)
						(2
							(Print 378 8) ; "Sure now, 'tis me bad luck that'll be causin' me ta lose all me money. Let's roll again!"
						)
					)
					(= register 1)
					((ScriptID 39 0) notify: 10) ; diceRm
					(self dispose:)
				)
			)
		)
	)
)

(instance johnnyRoll2 of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gIceMouseDownHandler addToFront: self)
		(gIceKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(gIceMouseDownHandler delete: self)
		(super dispose: &rest)
		(DisposeScript 378)
	)

	(method (doit)
		(if (and local0 (not (-- local0)))
			(Print 378 9) ; "You can play by moving the cursor using your direction keys and then hitting ENTER. Also you can move the cursor using a mouse and then click for the ENTER."
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not ((ScriptID 39 0) notify: 9)) ; diceRm
					(= local0 250)
				)
			)
			(1
				((ScriptID 39 0) notify: 9 1) ; diceRm
				(if ((ScriptID 39 2) firstTrue: #selected) ; johnnyDice
					(= cycles 2)
				else
					((ScriptID 39 4) setScript: (ScriptID 379 0)) ; johnnyRArmP, checkScores
					(self dispose:)
				)
			)
			(2
				((ScriptID 39 4) setScript: (ScriptID 380 0) self) ; johnnyRArmP, pickJohnnyDice
			)
			(3
				((ScriptID 39 3) eachElementDo: #show) ; oldSaltDice
				(= cycles 2)
			)
			(4
				((ScriptID 39 4) setScript: (ScriptID 379 0)) ; johnnyRArmP, checkScores
				(self dispose:)
			)
		)
	)

	(method (handleEvent event)
		(if (and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
			(event type: evMOUSEBUTTON)
		)
		(cond
			((super handleEvent: event))
			((== (event type:) $0040) ; direction
				((ScriptID 39 10) handleEvent: event) ; objList
			)
			((and (MousedOn (ScriptID 39 12) event) (== state 0)) ; rButton
				((ScriptID 39 12) setCel: 0 setCycle: End) ; rButton
				(event claimed: 1)
				(self cue:)
			)
			((== (event type:) evMOUSEBUTTON)
				((ScriptID 39 2) firstTrue: #handleEvent event) ; johnnyDice
			)
		)
	)
)

