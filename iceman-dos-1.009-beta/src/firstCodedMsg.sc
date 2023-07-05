;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 349)
(include sci.sh)
(use Main)
(use subMarine_314)
(use n396)
(use Submarine_806)
(use n821)
(use Monitor)
(use n827)
(use System)

(public
	firstCodedMsg 0
)

(local
	local0
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
		(proc396_0 2 349 0) ; "WATCH HEADING!"
	)

	(method (die)
		(EgoDead 7 0 0 349 1) ; "Your heading control was pretty bad."
	)
)

(instance checkThrottle of Monitor
	(properties
		cycles 10
	)

	(method (warn)
		(proc396_0 2 349 2) ; "WATCH YOUR THROTTLE!"
	)

	(method (die)
		(EgoDead 7 0 0 349 3) ; "Your throttle control was pretty bad."
	)
)

(instance checkDepth of Monitor
	(properties
		cycles 20
	)

	(method (warn)
		(proc396_0 2 349 4) ; "WATCH YOUR DEPTH!"
	)

	(method (die)
		(EgoDead 7 0 0 349 5) ; "Your depth control was pretty bad."
	)
)

(instance checkPitch of Monitor
	(properties
		cycles 30
	)

	(method (warn)
		(proc396_0 2 349 6) ; "WATCH YOUR PITCH!"
	)

	(method (die)
		(EgoDead 7 0 0 349 7) ; "Your dive control was pretty bad."
	)
)

(instance firstCodedMsg of Script
	(properties
		seconds 5
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(proc396_0 5 349 8) ; "MAINTAIN CURRENT HEADING, COMMANDER."
				(checkHeading init: 353 (Submarine _absHeading:) 5)
				(= seconds 7)
			)
			(2
				(proc396_0 5 349 9) ; "ALL AHEAD 2/3."
				(= seconds 7)
			)
			(3
				(proc396_0 4 349 10) ; "SET DEPTH FOR 300 FT."
				(= cycles 60)
				(checkThrottle init: 361 3 0)
			)
			(4
				(checkPitch init: 354 20 10)
				(proc396_0 5 349 11) ; "ACKNOWLEDGE WHEN DEPTH IS ATTAINED."
			)
			(5
				(checkPitch active: 0)
				(proc396_0 5 349 12) ; "AYE AYE COMMANDER! MAINTAIN COURSE AND DEPTH."
				(checkDepth init: 391 300 10)
				(= seconds 10)
			)
			(6
				(proc396_0 2 349 13) ; "SONAR CONTACT."
				(= seconds 2)
			)
			(7
				(proc396_0 2 349 13) ; "SONAR CONTACT."
				(= seconds 2)
			)
			(8
				(proc396_0 2 349 13) ; "SONAR CONTACT."
				(= seconds 2)
			)
			(9
				(proc396_0 2 349 13) ; "SONAR CONTACT."
				(= seconds 2)
			)
			(10
				(proc396_0 5 349 14) ; "TWIN SCREWS BEARING 330 DEGREES OFF PORT BOW."
				(= seconds 6)
			)
			(11
				(proc396_0 5 349 15) ; "RANGE 17000' AND CLOSING."
				(= seconds 6)
			)
			(12
				(proc396_0 5 349 16) ; "STAND BY FOR SIGNATURE IDENTIFICATION."
				(= seconds 6)
			)
			(13
				(proc396_0 5 349 17) ; "SONAR COMPUTERIZED SIGNATURE SCAN."
				(= seconds 6)
			)
			(14
				(proc396_0 2 349 18) ; "FRIENDLY."
				(= seconds 2)
			)
			(15
				(proc396_0 2 349 18) ; "FRIENDLY."
				(= seconds 2)
			)
			(16
				(proc396_0 2 349 18) ; "FRIENDLY."
				(= seconds 2)
			)
			(17
				(proc396_0 3 349 19) ; "TYPE... FRENCH "FRIGATE.""
				(= seconds 4)
			)
			(18
				(proc396_0 3 349 20) ; "CLASS... "FL 3000.""
				(= seconds 15)
			)
			(19
				(proc396_0 5 349 21) ; "COME TO PERISCOPE DEPTH."
				(checkDepth active: 0)
				(checkPitch active: 0)
				(= seconds 5)
			)
			(20
				(checkPitch init: 354 -20 10)
				(= seconds 4)
			)
			(21
				(proc396_0 4 349 22) ; "REDUCE SPEED TO 1/3."
				(checkThrottle active: 0)
				(= seconds 5)
			)
			(22
				(checkThrottle init: 361 2 0)
			)
			(23
				(checkPitch active: 0)
				(= seconds 15)
			)
			(24
				(checkDepth init: 391 40 30)
				(proc396_0 4 349 23) ; "ALL AHEAD SLOW."
				(checkThrottle active: 0)
				(= seconds 4)
			)
			(25
				(checkThrottle value: 1 active: 1)
				(= register 0)
			)
			(26
				(= start state)
				(proc396_0 5 349 24) ; "COMMANDER... RADIO IS STANDING BY WITH CODED MESSAGES."
				(= seconds 15)
			)
			(27
				(if (>= (++ register) 4)
					(EgoDead 7 0 0 349 25) ; "YOU HAD PLENTY OF TIME TO GET THE MESSAGE."
				else
					(self init:)
				)
			)
		)
	)

	(method (doit)
		(switch state
			(4
				(if
					(and
						(not (umod (++ local0) 50))
						(< 290 (Submarine depth:) 310)
					)
					(if (> local0 200)
						(EgoDead 7 0 0 349 26) ; "OBEY THE COMMANDS."
					else
						(proc396_0 4 349 11) ; "ACKNOWLEDGE WHEN DEPTH IS ATTAINED."
					)
				)
			)
			(21
				(if (< 40 (Submarine depth:) 70)
					(checkPitch active: 0)
				)
			)
			(22
				(if (< 40 (Submarine depth:) 70)
					(self cue:)
				)
			)
			(25
				(if (<= (Submarine hSpeed:) 5)
					(self cue:)
				)
			)
		)
		(checkHeading doit:)
		(checkThrottle doit:)
		(checkDepth doit:)
		(checkPitch doit:)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((and (== state 4) (Said '/acknowledge,confirm<depth'))
				(if (< 290 (Submarine depth:) 310)
					(self cue:)
				else
					(EgoDead 7 0 0 349 27) ; "YOUR DEPTH WAS INCORRECT!"
				)
			)
		)
	)

	(method (dispose)
		(if (> state 25)
			(gGame changeScore: 1)
			(subMarine cue:)
		else
			(EgoDead 7 0 0 349 28) ; "You shouldn't have left your post."
		)
		(proc0_3)
		(super dispose:)
		(DisposeScript 396)
		(DisposeScript 349)
		(DisposeScript 826)
	)
)

