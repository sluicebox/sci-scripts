;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 389)
(include sci.sh)
(use Interface)
(use pearlScript)
(use n396)
(use Submarine_806)
(use System)

(public
	pearl3Script 0
)

(local
	local0
)

(instance pearl3Script of Script
	(properties)

	(method (changeState newState param2)
		(switch (= state newState)
			(0
				(Print 389 0) ; "After a short trip you arrive at your first rendezvous point."
				(Submarine latitude: 30 longitude: 170)
				(= cycles 2)
			)
			(1
				(= start state)
				((ScriptID 373 1) active: 0) ; checkSpeed
				(proc396_0 5 389 1) ; "ALL STOP."
				(if (> (++ register) 3)
					(proc373_7 389 2)
				)
				(= seconds 10)
			)
			(2
				(if (and (>= argc 2) param2)
					(= seconds (= register 0))
					(self cue:)
				else
					(self init:)
				)
			)
			(3)
			(4
				(Print 389 3) ; "As the USS Blackhawk comes to a stop, the Captain taps you on the shoulder and says..."
				(proc396_0 5 389 4) ; "MEET ME IN MY QUARTERS, WESTLAND.  IT'S TIME TO OPEN THAT BRIEFCASE."
				(= seconds 10)
			)
			(5
				(= start state)
				(= register 0)
				(= seconds 10)
			)
			(6
				(proc396_0 5 389 5) ; "MEET ME IN MY QUARTERS, WESTLAND... NOW!!"
				(if (> (++ register) 3)
					(proc373_7 389 6)
				else
					(self init:)
				)
			)
		)
	)

	(method (doit)
		(switch state
			(1
				(if (== (Submarine throttle:) 0)
					(self cue: 1)
				)
			)
			(3
				(cond
					((umod (++ local0) 50))
					((== (Submarine throttle:) 0)
						(if (== (Submarine hSpeed:) 0)
							(self cue:)
						)
					)
					((< (++ register) 4)
						(proc396_0 3 389 7) ; "ALL STOP, COMMANDER!!!"
					)
					(else
						(proc373_7 389 8)
					)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 389)
	)
)

