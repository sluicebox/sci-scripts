;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 342)
(include sci.sh)
(use Main)
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
			((== (event type:) $0400) ; evNULL | $0400
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
		(if (and (== state 3) (not (-- local0)))
			(self setScript: pingedWrong)
		)
		(if local2
			(-- local2)
		)
		(if (and (& (Submarine flags:) $0080) local1)
			(= local2 20)
			(= local1 0)
		)
		(if (and (== state 3) local2 (not (& (Submarine flags:) $0080)))
			(self cue:)
		)
		(if (and (== local1 0) (not local2) (& (Submarine flags:) $0080))
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
				(Submarine longitude: 10 latitude: 35)
				(= seconds 10)
			)
			(1
				(proc396_0 4 342 3) ; "SONAR CONTACT"
				(= seconds 5)
			)
			(2
				(proc396_0 4 342 4) ; "SINGLE PINGS COMMING AT IRREGULAR INTERVALS."
				(= seconds 5)
			)
			(3
				(= local0 600)
			)
			(4
				(= seconds 4)
			)
			(5
				(proc396_0 4 342 5) ; "PINGS HAVE STOPPED, SIR."
				(= seconds 5)
			)
			(6
				(proc396_0 4 342 6) ; "APPEARS TO BE THE USS COONTZ, SIR."
				(= seconds 5)
			)
			(7
				(proc396_0 4 342 7) ; "TRACKING THE COONTZ WITH PASSIVE SONAR, SIR."
				(= seconds 5)
			)
			(8
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
				(proc396_0 4 342 8) ; "SIR, SHIP MOVING AWAY AT HIGH SPEED."
				(= seconds 5)
			)
			(1
				(proc396_0 5 342 9) ; "APPEARS TO BE THE USS COONTZ."
				(= seconds 6)
			)
			(2
				(EgoDead 7 0 0 342 10) ; "Having missed your rendevous with the USS Coontz, you lost your protection. Mission aborted."
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
				(EgoDead 926 1 0 342 11) ; "The United States rules of engagement prohibit our use of weapons unless fired upon. You're a shame to the service, Johnny."
			)
		)
	)
)

