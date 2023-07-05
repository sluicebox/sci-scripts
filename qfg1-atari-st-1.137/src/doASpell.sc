;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use wizGame)
(use Motion)
(use System)

(public
	doASpell 0
	doFlame 1
)

(local
	[local0 9] = [0 0 10 10 10 0 -10 -10 -10]
	[local9 9] = [6 -6 -6 0 6 6 6 0 -6]
)

(instance doASpell of Script
	(properties)

	(method (dispose)
		((ScriptID 32 1) empty:) ; objList
		(super dispose:)
		(DisposeScript 240)
	)

	(method (handleEvent event &tmp [temp0 5])
		(cond
			((super handleEvent: event))
			((== (event type:) $0040) ; direction
				((ScriptID 32 1) handleEvent: event) ; objList
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc32_2 register)
					(switch register
						(17
							(proc32_12 0 8)
							(= register (ScriptID 32 3)) ; openSign
						)
						(24
							(proc32_12 8 32)
							(= register (ScriptID 32 4)) ; fetchSign
						)
						(19
							(= register (ScriptID 32 5)) ; trigSign
						)
					)
					(register setCycle: End self)
				else
					(= global203 1)
					(self dispose:)
				)
			)
			(1
				(register stopUpd:)
				(if (== register (ScriptID 32 5)) ; trigSign
					((ScriptID 32 6) changeForm:) ; playerBug
					(proc32_11)
					(= global203 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance doFlame of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 240)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(cond
			((super handleEvent: event))
			((== (event type:) $0040) ; direction
				(= temp1 [local0 (= temp3 (event message:))])
				(= temp2 [local9 temp3])
				(cond
					((and (<= ((ScriptID 32 7) x:) 0) (< temp1 0)) ; flame
						(= temp1 0)
					)
					((and (<= 319 ((ScriptID 32 7) x:)) (< 0 temp1)) ; flame
						(= temp1 0)
					)
					((and (<= ((ScriptID 32 7) y:) 0) (< temp2 0)) ; flame
						(= temp2 0)
					)
					((and (<= 189 ((ScriptID 32 7) y:)) (< 0 temp2)) ; flame
						(= temp2 0)
					)
				)
				((ScriptID 32 7) ; flame
					posn:
						(+ ((ScriptID 32 7) x:) temp1) ; flame
						(+ ((ScriptID 32 7) y:) temp2) ; flame
				)
				(event claimed: 1)
			)
			((== (event type:) evMOUSEBUTTON)
				(event claimed: 1)
				(= global279 (+ 4 (/ [gEgoStats 23] 5))) ; flameDartSpell
				((ScriptID 32 7) posn: (event x:) (event y:) setCycle: Fwd) ; flame
				(= global203 1)
				(self dispose:)
			)
			((and (== (event message:) KEY_RETURN) (== (event type:) evKEYBOARD))
				(event claimed: 1)
				(= global279 (+ 4 (/ [gEgoStats 23] 5))) ; flameDartSpell
				(= global203 1)
				(self dispose:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (proc32_2 23)
					(HandsOff)
					(= global279 0)
					(gGame setCursor: gNormalCursor 1)
					((ScriptID 32 8) setCycle: End self) ; flameSign
				else
					(= global203 1)
					(self dispose:)
				)
			)
			(1
				((ScriptID 32 8) stopUpd:) ; flameSign
				(HandsOn)
				((ScriptID 32 7) posn: 274 23 setCycle: Fwd) ; flame
			)
		)
	)
)

