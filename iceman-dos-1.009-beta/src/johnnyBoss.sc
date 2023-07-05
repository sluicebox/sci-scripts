;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 377)
(include sci.sh)
(use Main)
(use diceRm)
(use Interface)
(use Motion)
(use System)

(public
	johnnyBoss 0
	comeButton 1
	newRoundButton 2
	oldSaltRoll2 3
)

(local
	local0
)

(instance johnnyBoss of Script
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
	)

	(method (doit)
		(if (and local0 (not (-- local0)))
			(Print 377 0) ; "You can play by moving the cursor using your direction keys and then hitting ENTER. Also you can move the cursor using a mouse and then click for the ENTER."
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 2) selected: 1) ; johnnyDice
				((ScriptID 39 9) loop: 0 cycleSpeed: 2 setCycle: Fwd) ; saltMouth
				(= seconds 3)
			)
			(1
				(switch (Random 0 2)
					(0
						(Print 377 1) ; "You be BOSS, Sir!"
					)
					(1
						(Print 377 2) ; "You have the edge, Sir."
					)
					(2
						(Print 377 3) ; "It's up to you."
					)
				)
				(if (not ((ScriptID 39 0) notify: 9)) ; diceRm
					(= local0 250)
				)
			)
			(2
				((ScriptID 39 0) notify: 9 1) ; diceRm
				((ScriptID 39 9) loop: 1 cel: 1 setCycle: 0) ; saltMouth
				(if ((ScriptID 39 2) firstTrue: #selected) ; johnnyDice
					((ScriptID 39 4) setScript: (ScriptID 380 0) self) ; johnnyRArmP, pickJohnnyDice
				else
					(= cycles 2)
				)
			)
			(3)
			(4
				(client setScript: oldSaltRoll2)
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
			((and (MousedOn (ScriptID 39 13) event) (== state 3)) ; nButton
				(event claimed: 1)
				(client setScript: newRoundButton)
			)
			((and (MousedOn (ScriptID 39 12) event) (== state 1)) ; rButton
				(if
					(and
						(< 100 ((ScriptID 39 2) diceScore:) 200) ; johnnyDice
						(< (proc39_22 (ScriptID 39 2)) 3) ; johnnyDice
					)
					(Print 377 4) ; "You must select at least 3 dice to roll."
				else
					((ScriptID 39 12) setCel: 0 setCycle: End) ; rButton
					(self cue:)
				)
				(event claimed: 1)
			)
			((MousedOn (ScriptID 39 11) event) ; cButton
				(event claimed: 1)
				(client setScript: comeButton)
			)
			((== (event type:) evMOUSEBUTTON)
				((ScriptID 39 2) firstTrue: #handleEvent event) ; johnnyDice
			)
		)
	)
)

(instance comeButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 11) setCel: 0 setCycle: End self) ; cButton
				((ScriptID 39 8) show: cycleSpeed: 1 setCycle: Fwd) ; johnnyMouth
				(= seconds 3)
			)
			(1
				(switch (Random 0 2)
					(0
						(Print 377 5) ; "With a smile on your face you tell the old salt,"
						(Print 377 6) ; "Ok ol' buddy, I've got you this time, come on up."
					)
					(1
						(Print 377 7) ; "You say, "Come on up, Salt, You're mine!""
					)
					(2
						(Print 377 8) ; "You laugh as you say, "I've got your number buddy, come on up!""
					)
				)
				(= cycles 2)
			)
			(2
				((ScriptID 39 8) setCycle: 0 hide:) ; johnnyMouth
				(client setScript: oldSaltRoll2)
			)
		)
	)
)

(instance newRoundButton of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 377)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 13) setCel: 0 setCycle: End) ; nButton
				((ScriptID 39 8) show: cycleSpeed: 1 setCycle: Fwd) ; johnnyMouth
				(= seconds 3)
			)
			(1
				(switch (Random 0 2)
					(0
						(Print 377 9) ; "Not this time." you say, "Roll 'em again."
					)
					(1
						(Print 377 10) ; "I don't like my odds" you say, "Let's roll!"
					)
					(2
						(Print 377 11) ; ""Try it again, maybe my luck will be better." you grunt."
					)
				)
				(= cycles 2)
			)
			(2
				((ScriptID 39 8) setCycle: 0 hide:) ; johnnyMouth
				((ScriptID 39 0) notify: 10) ; diceRm
				(self dispose:)
			)
		)
	)
)

(instance oldSaltRoll2 of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 377)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc39_1)
				(= cycles 2)
			)
			(1
				((ScriptID 39 6) setScript: (ScriptID 381 0) self) ; saltRArmP, pickSaltDice
			)
			(2
				((ScriptID 39 6) setScript: (ScriptID 379 0)) ; saltRArmP, checkScores
				(self dispose:)
			)
		)
	)
)

