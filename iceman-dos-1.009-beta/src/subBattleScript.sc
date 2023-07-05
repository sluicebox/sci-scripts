;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 398)
(include sci.sh)
(use n396)
(use Submarine_806)
(use n821)
(use System)

(public
	subBattleScript 0
)

(instance subBattleScript of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 398)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== (event type:) $0400) ; evNULL | $0400
				(switch (event message:)
					(JOY_NULL
						(proc396_0 5 398 0) ; "HARPOON MISSLE LAUNCHED, SIR."
						(self setScript: firedTooSoon)
					)
					(JOY_UP
						(proc396_0 5 398 1) ; "DECOY LAUNCHED, SIR."
					)
					(JOY_UPRIGHT
						(proc396_0 5 398 2) ; "STINGER LAUNCHED, SIR."
						(self setScript: firedTooSoon)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Submarine floor: 2312 longitude: 30 latitude: 60)
				(= seconds 8)
			)
			(1
				(proc396_0 5 398 3) ; "SONAR: REPORTING INVERSION LAYER AT 1,000 FEET."
				(= seconds 10)
			)
			(2
				(proc396_0 3 398 4) ; "SONAR: REPORTING TRENCHES ON OCEAN FLOOR."
				(= seconds 3)
			)
			(3
				(proc396_0 5 398 5) ; "NAVIGATION: SHOULD BE REYKJANES RIDGE SIR."
				(= seconds 15)
			)
			(4
				(proc396_0 5 398 6) ; "SONAR: PICKING UP FAINT NOISE FROM SINGLE SCREW."
				(= seconds 6)
			)
			(5
				(proc396_0 5 398 7) ; "SOURCE IS 26,000 YDS OFF PORT SIDE ABOUT MIDSHIP."
				(= seconds 6)
			)
			(6
				(proc396_0 3 398 8) ; "NEGATIVE ANGLE ON TARGET."
				(= seconds 4)
			)
			(7
				(proc396_0 4 398 9) ; "APPEARS TO BE ANOTHER SUB DOGGING US."
				(= seconds 5)
			)
			(8
				(proc396_0 5 398 10) ; "TARGET HAS STOPPED... NO PINGING... MUST BE LISTENING."
				(= seconds 5)
			)
			(9
				(proc396_0 5 398 11) ; "WE'RE BEING PINGED... PORT SIDE, JUST FORWARD OF MIDSHIP."
				(= seconds 6)
			)
			(10
				(proc396_0 5 398 12) ; "WE HAVE SIGNATURE PROFILE... SHE'S A RUSSIAN ALPHA."
				(= seconds 6)
			)
			(11
				(proc396_0 5 398 13) ; "BE ADVISED SHE JUST FLOODED TUBES, SIR!"
				(= seconds 6)
			)
			(12
				(proc396_0 5 398 14) ; "TARGET BEARING 30 DEGREES AND CLOSING AT 18,000 YARDS."
				(= seconds 6)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance firedTooSoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(EgoDead 926 1 0 398 15) ; "The United States rules of engagement prohibit our use of weapons unless fired upon. You're a shame to the service, Johnny."
			)
		)
	)
)

