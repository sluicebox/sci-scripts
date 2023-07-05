;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 373)
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
	pearlScript 0
	checkSpeed 1
	checkRudder 2
	checkDive 3
	checkDepthScript 4
	holdSteadyScript 5
	checkHeading 6
	proc373_7 7
)

(local
	local0 = 1
)

(procedure (proc373_7)
	(DisposeScript 370)
	(DisposeScript 822)
	(EgoDead 926 3 0 &rest)
)

(instance pearlScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(switch (= state newState)
			(0
				(ScriptID 396)
				(ScriptID 822)
				Monitor
				((ScriptID 27 4) posn: 51 64) ; positionBlip
				(self setScript: (ScriptID 383) self) ; pearl1Script
			)
			(1
				(= cycles 2)
			)
			(2
				(self setScript: (ScriptID 384) self) ; pearl2Script
			)
			(3
				(proc396_0 5 373 0) ; "BRING HER LEFT TO 355 DEGREES."
				(checkDive init: 354 0 0)
				(checkRudder init: 356 3 0)
			)
			(4
				(= start state)
				(checkRudder active: 0)
				(proc396_0 5 373 1) ; "STEADY AS SHE GOES."
				(checkHeading init: 353 355 5)
			)
			(5
				(checkSpeed init: 358 60 2)
				(proc396_0 5 373 2) ; "MAINTAIN CURRENT HEADING AND SPEED"
				(= seconds 20)
			)
			(6
				(checkDive active: 0)
				(checkSpeed active: 0)
				(checkHeading active: 0)
				(self setScript: (ScriptID 389) self) ; pearl3Script
			)
			(7
				((ScriptID 27 4) posn: 47 59) ; positionBlip
				(self dispose:)
			)
		)
	)

	(method (doit)
		(checkSpeed doit:)
		(checkRudder doit:)
		(checkDive doit:)
		(checkHeading doit:)
		(super doit: &rest)
		(if (and (> (Submarine depth:) 45) (& (Submarine flags:) $0008))
			(proc373_7 373 3)
		)
		(switch state
			(3
				(if (< 353 (Submarine absHeading:) 357)
					(= cycles 1)
				)
			)
			(4
				(if (== (Submarine hSpeed:) 60)
					(= cycles 1)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/attain,acknowledge,confirm<depth')
				(Print 373 4) ; "Ok, Ok, Johnny, wait until I tell you to do so."
			)
			((Said 'hold[<on][/jockstrap,strap[<jock]]')
				(Print 373 5) ; "That's just a figure of speech, John."
			)
			((Said 'blow/puppy')
				(Print 373 6) ; "That's illegal in most states, Johnny."
				(Print 373 7) ; "But anything's legal in Tunisia."
			)
		)
	)

	(method (dispose)
		(proc0_3)
		(cond
			((< state 6)
				(EgoDead 7 0 0 373 8) ; "You left your post without following the captain's directions."
			)
			((!= (Submarine throttle:) 0)
				(EgoDead 7 0 0 373 9) ; "All Stop means ALL STOP."
			)
			((!= (Submarine pitch:) 0)
				(EgoDead 7 0 0 373 10) ; "You should have stabilized the submarine's pitch. Mission aborted."
			)
			(else
				(subMarine cue:)
				(gGame
					changeScore:
						(-
							5
							(/
								(+
									(checkSpeed count:)
									(checkRudder count:)
									(checkDive count:)
									(checkHeading count:)
								)
								2
							)
						)
				)
				(super dispose:)
				(DisposeScript 396)
				(DisposeScript 826)
				(DisposeScript 373)
			)
		)
	)
)

(instance checkSpeed of Monitor
	(properties)

	(method (warn)
		(proc396_0 3 373 11) ; "WATCH YOUR SPEED, JOHNNY!"
	)

	(method (die)
		(proc373_7 373 12)
	)
)

(instance checkRudder of Monitor
	(properties)

	(method (warn)
		(proc396_0 3 373 13) ; "WATCH THE HELM, JOHNNY!"
	)

	(method (die)
		(proc373_7 373 14)
	)
)

(instance checkDive of Monitor
	(properties)

	(method (warn)
		(proc396_0 3 373 15) ; "WATCH THAT PITCH, JOHNNY!"
	)

	(method (die)
		(proc373_7 373 16)
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
		(proc396_0 4 373 17) ; "WATCH YOUR HEADING."
	)

	(method (die)
		(proc373_7 373 18)
	)
)

(instance checkDepthScript of Script
	(properties)

	(method (doit)
		(cond
			((umod (++ local0) 50))
			((== register -1))
			((> state 3)
				(proc373_7 373 19)
			)
			((!= register 200)
				(if (> (Abs (- (Submarine depth:) register)) 10)
					(proc396_0 3 373 20) ; "WATCH YOUR DEPTH!"
					(= cycles 1)
				)
			)
			((> (Submarine depth:) 220)
				(proc373_7 373 21)
			)
			((> (Submarine depth:) 190)
				(checkDive value: 0)
				(proc396_0 3 373 22) ; "REPORT WHEN DEPTH ATTAINED!"
				(= cycles 1)
			)
		)
		(super doit:)
	)
)

(instance holdSteadyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(self register: 1 dispose:)
				(return)
			)
		)
	)

	(method (doit)
		(if
			(or
				(Submarine rudder:)
				(Submarine pitch:)
				((ScriptID 806 1) incPerTime:) ; accelerator
			)
			(= register 0)
			(self dispose:)
		else
			(super doit: &rest)
		)
	)
)

