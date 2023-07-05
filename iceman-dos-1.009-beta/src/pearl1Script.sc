;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 383)
(include sci.sh)
(use pearlScript)
(use n396)
(use Submarine_806)
(use n822)
(use System)

(public
	pearl1Script 0
)

(instance pearl1Script of Script
	(properties)

	(method (changeState newState param2)
		(switch (= state newState)
			(0
				(Submarine longitude: 156 latitude: 13 absHeading: 94)
				(= seconds 10)
				(proc822_0 self (ScriptID 373 4) 0 10) ; checkDepthScript
				((ScriptID 373 6) init: 353 94 5) ; checkHeading
			)
			(1
				(= start state)
				(proc396_0 5 383 0) ; "ALL AHEAD SLOW."
				(= cycles 100)
				(if (> (++ register) 3)
					(proc373_7 383 1)
				)
			)
			(2
				(if (and (>= argc 2) param2)
					(= register 0)
					(= cycles 1)
					((ScriptID 373 1) init: 358 5 2) ; checkSpeed
				else
					(self init:)
				)
			)
			(3
				(= start state)
				(proc396_0 5 383 2) ; "RIGHT FULL RUDDER... SET COURSE TO 180 DEGREES."
				((ScriptID 373 6) active: 0) ; checkHeading
				((ScriptID 373 2) init: 356 6 2) ; checkRudder
			)
			(4
				((ScriptID 373 2) active: 0) ; checkRudder
				((ScriptID 373 6) active: 1 value: 180) ; checkHeading
				(= seconds 15)
			)
			(5
				((ScriptID 373 2) active: 1) ; checkRudder
				((ScriptID 373 6) active: 0) ; checkHeading
				(proc396_0 5 383 3) ; "RIGHT FULL RUDDER... CHANGE COURSE TO 270 DEGREES."
				(= register 0)
			)
			(6
				(= start state)
				((ScriptID 373 6) active: 1 value: 270) ; checkHeading
				(proc396_0 5 383 4) ; "HOLD HER STEADY."
				((ScriptID 373 2) active: 0) ; checkRudder
				(= cycles 70)
				(if (> (++ register) 3)
					(proc373_7 383 5)
				)
			)
			(7
				(proc822_0 self (ScriptID 373 5) self) ; holdSteadyScript
			)
			(8
				(if (and (>= argc 2) param2)
					(= register 0)
					(self cue:)
				else
					(self init:)
				)
			)
			(9
				(proc396_0 5 383 6) ; "LET'S ROLL! ALL AHEAD 1/3."
				((ScriptID 373 1) active: 0) ; checkSpeed
				(= cycles 200)
			)
			(10
				((ScriptID 373 1) active: 1 value: 20) ; checkSpeed
				(= cycles 100)
			)
			(11
				(= start state)
				(proc396_0 5 383 7) ; "PREPARE FOR DIVE SEQUENCE... ACKNOWLEDGE GREEN BOARD."
				(= cycles 100)
				(if (> (++ register) 4)
					(proc373_7 383 8)
				)
			)
			(12
				(if (and (>= argc 2) param2)
					(= register 0)
					(= cycles 1)
				else
					(self init:)
				)
			)
			(13
				((ScriptID 373 4) dispose:) ; checkDepthScript
				(= cycles 5)
			)
			(14
				(self dispose:)
			)
		)
	)

	(method (doit)
		(switch state
			(1
				(if (== (Submarine hSpeed:) 5)
					(self cue: 1)
				)
			)
			(3
				(if (< 175 (Submarine absHeading:) 185)
					(= cycles 1)
				)
			)
			(5
				(if (< 265 (Submarine absHeading:) 275)
					(= cycles 1)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(and
					(Said '/acknowledge,confirm<board<green')
					(OneOf state 11 12)
				)
				(self cue: 1)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 383)
	)
)

