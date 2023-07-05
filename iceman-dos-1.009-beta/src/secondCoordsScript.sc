;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 347)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n396)
(use Submarine_806)
(use n821)
(use Monitor)
(use n827)
(use System)

(public
	secondCoordsScript 0
)

(instance secondCoordsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(proc396_0 5 347 0) ; "MAINTAIN CURRENT HEADING."
				(= seconds 4)
			)
			(2
				(checkHeading init: 353 (Submarine _absHeading:) 5)
				(= seconds 4)
			)
			(3
				(proc396_0 5 347 1) ; "ALL AHEAD FULL."
				(= seconds 4)
			)
			(4
				(checkThrottle init: 361 4 0)
				(= seconds 25)
			)
			(5
				(proc396_0 5 347 2) ; "SET DEPTH FOR 300 FT."
				(= seconds 5)
			)
			(6
				(checkDive init: 354 20 10)
				(proc396_0 5 347 3) ; "ACKNOWLEDGE WHEN DEPTH ATTAINED."
			)
			(7
				(checkDive active: 0)
				(checkDepth init: 391 300 10)
				(proc396_0 5 347 4) ; "AYE AYE COMMANDER! MAINTAIN COURSE AND DEPTH."
				(= seconds 20)
			)
			(8
				(proc396_0 5 347 5) ; "REDUCE SPEED TO 2/3."
				(checkThrottle active: 0)
				(= seconds 4)
			)
			(9
				(checkThrottle active: 1 value: 3)
			)
			(10
				(proc396_0 6 347 6) ; "MAKE YOUR DEPTH 100 FT."
				(checkDepth active: 0)
				(= seconds 4)
			)
			(11
				(checkDive active: 1 value: -20)
			)
			(12
				(checkDive active: 0)
				(checkDepth active: 1 value: 100)
				(proc396_0 6 347 7) ; "AHEAD SLOW."
				(checkThrottle active: 0)
				(= seconds 4)
			)
			(13
				(checkThrottle active: 1 value: 1 0)
			)
			(14
				(proc396_0 5 347 8) ; "SURFACE."
				(checkDepth active: 0)
				(= seconds 4)
			)
			(15
				(checkDive active: 1)
			)
			(16
				(checkDepth active: 1 value: 30 variance: 30)
				(= seconds 10)
			)
			(17
				(checkDive active: 0)
				(Print 347 9) ; "The Captain taps you on the shoulder and says..."
				(proc396_0 5 347 10) ; "YOUR SHIFT REPLACEMENT IS HERE, COMMANDER."
				(= seconds 5)
				(= register 0)
			)
			(18
				(= start state)
				(if (< (++ register) 4)
					(proc396_0 5 347 11) ; "LET'S GO TOPSIDE FOR SOME FRESH AIR WHILE RADIO IS MAKING CONTACT."
				else
					(EgoDead 7 0 0 347 12) ; "NOT OBEYING ORDERS AGAIN?"
				)
				(= seconds 10)
			)
			(19
				(self init:)
			)
		)
	)

	(method (doit)
		(checkHeading doit:)
		(checkThrottle doit:)
		(checkDive doit:)
		(checkDepth doit:)
		(switch state
			(6
				(if (and (< 290 (Submarine depth:) 310) (not gModelessDialog))
					(if (< (++ register) 4)
						(proc396_0 5 347 3) ; "ACKNOWLEDGE WHEN DEPTH ATTAINED."
					else
						(EgoDead 7 0 0 347 13) ; "Explicit orders must be obeyed."
					)
				)
			)
			(9
				(if (== (Submarine hSpeed:) 40)
					(= cycles 1)
				)
			)
			(11
				(if (< 90 (Submarine depth:) 110)
					(= cycles 1)
				)
			)
			(13
				(if (== (Submarine hSpeed:) 5)
					(= cycles 1)
				)
			)
			(15
				(if (< (Submarine depth:) 50)
					(= cycles 1)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/acknowledge,confirm<depth')
				(if (== state 6)
					(if (< 290 (Submarine depth:) 310)
						(= cycles 1)
					else
						(EgoDead 7 0 0 347 14) ; "Your depth is incorrect!"
					)
				else
					(Print 347 15) ; "That is not appropriate now."
				)
			)
		)
	)

	(method (dispose)
		(if (>= state 17)
			(subMarine cue:)
		else
			(EgoDead 7 0 0 347 16) ; "You shouldn't leave your post."
		)
		(DisposeScript 396)
		(DisposeScript 826)
		(super dispose:)
		(proc0_3)
		(DisposeScript 347)
	)
)

(instance checkThrottle of Monitor
	(properties
		cycles 10
	)

	(method (warn)
		(proc396_0 2 347 17) ; "WATCH YOUR THROTTLE!"
	)

	(method (die)
		(EgoDead 7 0 0 347 18) ; "Your throttle control was pretty bad."
	)
)

(instance checkDive of Monitor
	(properties)

	(method (warn)
		(proc396_0 3 347 19) ; "WATCH THAT PITCH, JOHNNY!"
	)

	(method (die)
		(EgoDead 7 0 0 347 20) ; "Your lack of control over the submarine has cost you the game."
	)
)

(instance checkDepth of Monitor
	(properties
		cycles 20
	)

	(method (warn)
		(proc396_0 2 347 21) ; "WATCH YOUR DEPTH!"
	)

	(method (die)
		(EgoDead 7 0 0 347 22) ; "Your depth control was pretty bad."
	)
)

(instance checkHeading of Monitor
	(properties)

	(method (doit)
		(if
			(and
				active
				(not (umod (++ cycles) 50))
				(<
					variance
					(umod (- value (proc827_0 Submarine theSelector)) 360)
					(- 360 variance)
				)
			)
			(if (<= (++ count) 3)
				(if gModelessDialog
					(-- count)
				else
					(self warn:)
				)
			else
				(self die:)
			)
		)
	)

	(method (warn)
		(proc396_0 4 347 23) ; "WATCH YOUR HEADING."
	)

	(method (die)
		(EgoDead 347 24) ; "Your lack of control will force you to restart."
	)
)

