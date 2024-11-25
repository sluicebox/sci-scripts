;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 342)
(include sci.sh)
(use Main)
(use Interface)
(use n396)
(use Submarine_806)
(use n821)
(use System)

(public
	coontz 0
)

(local
	local0
	local1 = 1
	local2
)

(instance coontz of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== (event type:) $0400)
				(switch (event message:)
					(JOY_NULL
						(proc396_0 5 342 0) ; "HARPOON MISSLE LAUNCHED, SIR."
						(self setScript: firedOnCoontz)
					)
					(JOY_UP
						(proc396_0 5 342 1) ; "DECOY LAUNCHED, SIR."
					)
					(JOY_UPRIGHT
						(proc396_0 5 342 2) ; "STINGER LAUNCHED, SIR."
						(self setScript: firedOnCoontz)
					)
				)
			)
		)
	)

	(method (doit)
		(if (and (not script) (OneOf state 3 2) (not (-- local0)))
			(self setScript: pingedWrong)
		)
		(if local2
			(-- local2)
		)
		(if (and (& (Submarine flags:) $0080) local1)
			(= local2 20)
			(= local1 0)
		)
		(if
			(and
				(OneOf state 3 2)
				local2
				(not (& (Submarine flags:) $0080))
			)
			(self cue:)
		)
		(if
			(and
				(not script)
				(== local1 0)
				(not local2)
				(& (Submarine flags:) $0080)
			)
			(self setScript: pingedWrong)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 342)
		(DisposeScript 396)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 27 4) posn: 83 75) ; positionBlip
				(Submarine
					longitude: 12
					latitude: 36
					depth: 500
					absHeading: 45
					hSpeed: 20
				)
				(= seconds 10)
			)
			(1
				(Print 342 3) ; "Eight hours later off the coast of Portugal..."
				(proc396_0 4 342 4) ; "SONAR CONTACT"
				(= seconds 5)
			)
			(2
				(proc396_0 4 342 5) ; "SINGLE PINGS COMING AT IRREGULAR INTERVALS."
				(= local0 300)
				(= seconds 5)
			)
			(4
				(= seconds 3)
			)
			(5
				(proc396_0 3 342 6) ; "PINGS HAVE STOPPED, SIR."
				(= seconds 4)
			)
			(6
				(proc396_0 3 342 7) ; "APPEARS TO BE ONE OF OUR DESTROYERS, SIR."
				(= seconds 4)
			)
			(7
				(proc396_0 3 342 8) ; "TRACKING THE DESTROYER WITH PASSIVE SONAR, SIR."
				(= seconds 4)
			)
			(8
				(proc396_0 4 342 9) ; "AERIAL VIEW NOW SHOWING ON THE DISPLAY, SIR."
				(= seconds 5)
			)
			(9
				(proc396_0 4 342 10) ; "THE DESTROYER SHOWN AS CROSS, SIR."
				(= seconds 5)
			)
			(10
				(gGame changeScore: 5)
				(self dispose:)
			)
		)
	)
)

(instance pingedWrong of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc396_0 4 342 11) ; "SIR, SHIP MOVING AWAY AT HIGH SPEED."
				(= seconds 5)
			)
			(1
				(proc396_0 5 342 12) ; "SONAR SIGNATURE IDENTIFIES THE SHIP AS THE USS COONTZ."
				(= seconds 6)
			)
			(2
				(EgoDead 7 0 0 342 13) ; "Having not signaled correctly with your sonar, the USS Coontz leaves. You have lost your cover. Mission aborted."
			)
		)
	)
)

(instance firedOnCoontz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(EgoDead 926 1 0 342 14) ; "The United States rules of engagement prohibit our use of weapons unless fired upon. You're a shame to the service, Johnny."
			)
		)
	)
)

