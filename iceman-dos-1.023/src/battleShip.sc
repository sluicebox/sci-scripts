;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 348)
(include sci.sh)
(use Main)
(use Interface)
(use n396)
(use Submarine_806)
(use n821)
(use System)

(public
	battleShip 0
)

(instance battleShip of Script
	(properties)

	(method (dispose)
		(proc0_3)
		(DisposeScript 396)
		(if (< state 4)
			(EgoDead 926 1 0 348 0) ; "Derelict of duty, you left your post."
		else
			(super dispose:)
			(DisposeScript 348)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== (event type:) $0400)
				(switch (event message:)
					(JOY_NULL
						(proc396_0 5 348 1) ; "HARPOON MISSLE LAUNCHED, SIR."
						(self setScript: (ScriptID 326 0)) ; firedTooSoon
					)
					(JOY_UP
						(proc396_0 5 348 2) ; "DECOY LAUNCHED, SIR."
					)
					(JOY_UPRIGHT
						(proc396_0 5 348 3) ; "STINGER LAUNCHED, SIR."
						(self setScript: (ScriptID 326 0)) ; firedTooSoon
					)
				)
			)
		)
	)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				((ScriptID 27 4) posn: 57 56) ; positionBlip
				(Submarine longitude: 170 latitude: 65)
				(= seconds 10)
			)
			(1
				(proc396_0 4 348 4) ; "SONAR CONTACT"
				(= seconds 5)
			)
			(2
				(Format @temp0 348 5 19500) ; "RUSSIAN DESTROYER %d YARDS."
				(proc396_0 4 @temp0)
				(= seconds 5)
			)
			(3
				(Format @temp0 348 6 18300) ; "%d YARDS AND CLOSING."
				(proc396_0 4 @temp0)
				(= seconds 5)
			)
			(4
				(Print 348 7) ; "TACTICAL DISPLAY KEYS ARE:"
				(Print 348 8) ; "Top bar (white) extending from the right represents the approaching enemy vessel."
				(Print 348 9) ; "Other bars (red) extending from the right represent the approaching enemy weapons."
				(Print 348 10) ; "Lower bars (black) extending from the left represent your weapons approaching the enemy."
				(client setScript: (ScriptID 339 0)) ; battleShip1
			)
		)
	)
)

