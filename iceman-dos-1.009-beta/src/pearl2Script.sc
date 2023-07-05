;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 384)
(include sci.sh)
(use Interface)
(use pearlScript)
(use n396)
(use Submarine_806)
(use n822)
(use System)

(public
	pearl2Script 0
)

(instance pearl2Script of Script
	(properties)

	(method (changeState newState param2)
		(switch (= state newState)
			(0
				((ScriptID 373 1) init: 358 20 5) ; checkSpeed
				(proc396_0 5 384 0) ; "DIVE! DIVE! DIVE! RIG PLANES FOR 10 DEGREES."
				(= cycles 50)
			)
			(1
				((ScriptID 373 3) init: 354 10 0) ; checkDive
				(= cycles 20)
			)
			(2
				(proc396_0 5 384 1) ; "LEVEL OFF AT 200 FT... REPORT WHEN DEPTH ATTAINED."
				(proc822_0 self (ScriptID 373 4) 0 200) ; checkDepthScript
			)
			(3
				((ScriptID 373 4) dispose:) ; checkDepthScript
				((ScriptID 373 3) active: 0) ; checkDive
				((ScriptID 373 6) active: 0) ; checkHeading
				(proc396_0 5 384 2) ; "AYE COMMANDER WESTLAND... CHANGE HEADING TO 360 DEGREES."
				((ScriptID 373 2) init: 356 4 2) ; checkRudder
			)
			(4
				(= start state)
				((ScriptID 373 2) active: 0) ; checkRudder
				((ScriptID 373 6) init: 353 360 10) ; checkHeading
				(proc396_0 5 384 3) ; "AYE AYE COMMANDER! MAINTAIN COURSE AND DEPTH."
				(if (> (++ register) 3)
					(proc373_7 384 4)
				)
				(= cycles 70)
			)
			(5
				(proc822_0 self (ScriptID 373 5) self 1) ; holdSteadyScript
			)
			(6
				(if (and (>= argc 2) param2)
					(= register 0)
					(self cue:)
				else
					(self init:)
				)
			)
			(7
				(= start state)
				(proc396_0 5 384 5) ; "STEADY AS SHE GOES."
				(if (> (++ register) 3)
					(proc373_7 384 4)
				)
				(= cycles 10)
			)
			(8
				(proc822_0 self (ScriptID 373 5) self 1) ; holdSteadyScript
			)
			(9
				(if (and (>= argc 2) param2)
					(= register 0)
					(= cycles 1)
				else
					(self init:)
				)
			)
			(10
				((ScriptID 373 1) active: 0) ; checkSpeed
				(proc396_0 5 384 6) ; "OK WESTLAND, LET'S BLOW THIS PUPPY OUT AND TAKE HER ON A SPEED RUN!"
				(= cycles 50)
			)
			(11
				(= start state)
				(proc396_0 5 384 7) ; "ALL AHEAD FULL... HOLD ON TO YOUR JOCKSTRAPS!"
				(if (> (++ register) 3)
					(proc373_7 384 8)
				)
			)
			(12
				(if (and (>= argc 2) param2)
					(self cue:)
				else
					(self init:)
				)
			)
			(13
				(self dispose:)
			)
		)
	)

	(method (doit)
		(switch state
			(3
				(if
					(or
						(> (Submarine absHeading:) 355)
						(< (Submarine absHeading:) 5)
					)
					(= cycles 1)
				)
			)
			(10
				(if (== (Submarine throttle:) 4)
					(self cue: 1)
				)
			)
			(11
				(if (== (Submarine throttle:) 4)
					(self cue: 1)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/acknowledge,confirm<depth')
				(if (and (< 190 (Submarine depth:) 210) (== state 2))
					(self cue: 1)
				else
					(Printf 384 9 (Submarine depth:) state) ; "Your depth was incorrect! d%d s%d"
					(proc373_7 384 10)
				)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 384)
	)
)

