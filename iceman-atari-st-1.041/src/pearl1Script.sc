;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 383)
(include sci.sh)
(use pearlScript)
(use n396)
(use Submarine_806)
(use n821)
(use n822)
(use Monitor)
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
				(proc822_0 self (ScriptID 373 4) 0 35) ; checkDepthScript
				((ScriptID 373 6) init: 353 94 5) ; checkHeading
			)
			(1
				(= start state)
				(proc396_0 5 383 0) ; "ALL AHEAD SLOW."
				(= seconds 10)
				(if (> (++ register) 3)
					(proc373_7 383 1)
				)
			)
			(2
				(if (and (>= argc 2) param2)
					(= register 0)
					(= cycles 1)
					(= seconds 0)
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
				(= seconds 7)
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
				(= seconds 5)
			)
			(10
				(checkThrottle init: 361 2 0)
			)
			(11
				((ScriptID 373 1) active: 1 value: 20) ; checkSpeed
				(= seconds 10)
			)
			(12
				(= start state)
				(proc396_0 5 383 7) ; "PREPARE FOR DIVE SEQUENCE... ACKNOWLEDGE GREEN BOARD."
				(= seconds 10)
				(if (> (++ register) 4)
					(proc373_7 383 8)
				)
			)
			(13
				(if (and (>= argc 2) param2)
					(= register 0)
					(= cycles 1)
				else
					(self init:)
				)
			)
			(14
				((ScriptID 373 4) dispose:) ; checkDepthScript
				(= cycles 5)
			)
			(15
				(self dispose:)
			)
		)
	)

	(method (doit)
		(switch state
			(10
				(if (== (Submarine hSpeed:) 20)
					(= cycles 1)
				)
			)
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
		(checkThrottle doit:)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said '/acknowledge,confirm<board<green')
					(Said 'confirm/board<green')
					(Said '[!*]/green<all')
					(Said '[!*]/board<green')
				)
				(if (OneOf state 12 13)
					(self cue: 1)
				else
					(proc396_0 5 383 9) ; "NOT NOW JOHNNY."
				)
			)
			((Said 'acknowledge/board<green')
				(proc396_0 5 383 10) ; "THAT'S RIGHT, JOHNNY, 'ACKNOWLEDGE GREEN BOARD'."
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 383)
	)
)

(instance checkThrottle of Monitor
	(properties
		cycles 10
	)

	(method (warn)
		(proc396_0 2 383 11) ; "WATCH YOUR THROTTLE!"
	)

	(method (die)
		(EgoDead 7 0 0 383 12) ; "Your throttle control was pretty bad."
	)
)

