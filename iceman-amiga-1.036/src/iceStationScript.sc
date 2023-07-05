;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 344)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use n396)
(use Submarine_806)
(use n821)
(use System)

(public
	iceStationScript 0
)

(instance iceStationScript of Script
	(properties
		seconds 5
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== ((subMarine script:) state:) 12)
					(Print 344 0) ; "Get up and get to work Johnny!"
					(gCurRoom newRoom: 25) ; controlRm
				)
				((ScriptID 27 4) posn: 64 43) ; positionBlip
				(Submarine
					depth: (if (> (Submarine depth:) 200) 195 else 75)
					ceiling: 50
					floor: 200
					longitude: 120
					latitude: 80
				)
				(proc396_0 5 344 1) ; "SONAR REPORTS MANY ICEBERGS IN THE AREA."
				((ScriptID 364 1) init:) ; slider
				(= seconds 6)
			)
			(1
				(proc396_0 5 344 2) ; "ADVISE YOU TURN ON TV MONITOR AND GO TO 5 KNOTS."
				(= seconds 20)
			)
			(2
				(self setScript: (ScriptID 364) self) ; hitIceBergScript
			)
			(3
				((ScriptID 27 4) posn: 80 40) ; positionBlip
				(Submarine longitude: 15 latitude: 85)
				(= cycles 2)
			)
			(4
				(proc396_0 5 344 3) ; "SONAR REPORTS ICE FIELD CLEAR, SIR."
				(= seconds 6)
			)
			(5
				(proc396_0 5 344 4) ; "SONAR REPORTS A BREAK IN THE ICE AHEAD, SIR."
				(= seconds 6)
			)
			(6
				(proc396_0 10 344 5) ; "PICKING UP ACTIVE SONAR ON 150 DEGREE ARC, 100 MILES SOUTH OF TRUE NORTH."
				(= seconds 12)
			)
			(7
				(proc396_0 7 344 6) ; "SONAR IS STATIONARY... COULD BE ICE STATION LOOKING FOR US."
				(= seconds 10)
			)
			(8
				(if register
					(proc396_0 7 344 7) ; "RADIO IS STANDING BY WITH A CODED MESSAGE."
					(subMarine cue:)
				else
					(proc396_0 7 344 8) ; "SONAR TARGET IS GOING OUT OF RANGE."
					(EgoDead 7 0 0 344 9) ; "Without contacting the Ice Station, it would be impossible to continue the mission."
				)
				(= seconds 10)
			)
			(9
				(= start state)
				(if (<= (++ register) 3)
					(proc396_0 5 344 10) ; "PLEASE GET UP AND GET THE MESSAGE."
					(= seconds 10)
				else
					(EgoDead 7 0 0 344 11) ; "You could not continue without the message."
				)
			)
			(10
				(self init:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'contact/station[<ice]')
				(cond
					((< state 7)
						(Print 344 12) ; "The Ice Station is not yet in range."
					)
					((< state 8)
						(Print 344 13) ; "Radio reports Contact with Ice Station has been made."
						(= register 1)
					)
					(else
						(Print 344 14) ; "You already have."
					)
				)
			)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		else
			(super cue:)
		)
	)

	(method (dispose)
		(cond
			((< state 8)
				(EgoDead 926 4 0 344 15) ; "Never leave the panel in the midst of danger!"
			)
			((== state 12))
			(else
				(subMarine cue:)
			)
		)
		(Submarine ceiling: 0)
		(super dispose:)
		(DisposeScript 396)
		(DisposeScript 344)
	)
)

