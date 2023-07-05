;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 117)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm117 0
)

(local
	[local0 2]
	local2
	local3
	[local4 2]
)

(procedure (localproc_0 param1)
	(= local3
		(Display param1 dsWIDTH 250 dsCOORD 35 120 dsALIGN alCENTER dsFONT 680 dsCOLOR 10 dsBACKGROUND 0 dsSAVEPIXELS)
	)
	(RedrawCast)
)

(procedure (localproc_1)
	(Display 117 1 dsRESTOREPIXELS local3)
	(RedrawCast)
)

(instance rm117 of Rm
	(properties
		picture 83
	)

	(method (init)
		(= gShowStyle 0)
		(HandsOff)
		(= global159 1)
		(TheMenuBar state: 1 draw:)
		(SL enable:)
		(Load rsVIEW 54)
		(Load rsVIEW 139)
		(Load rsSOUND 81)
		(super init:)
		(ship init:)
		(self setScript: shipScript)
	)
)

(instance shipScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2
					(Display ; "AND SO WE BID OUR HERO A FOND FAREWELL AS HIS SHIP ONCE AGAIN BURSTS INTO LIGHT SPEED... COURSE UNKNOWN."
						117
						0
						dsWIDTH
						250
						dsCOORD
						35
						25
						dsALIGN
						alCENTER
						dsFONT
						680
						dsCOLOR
						14
						dsBACKGROUND
						0
						dsSAVEPIXELS
					)
				)
				(gLongSong number: 81 loop: -1 play:)
				(= cycles 2)
			)
			(1
				(ship setMotion: MoveTo 164 110 self)
			)
			(2
				(ship cycleSpeed: 0 setCycle: End self)
			)
			(3
				(ship cel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(Display 117 1 dsRESTOREPIXELS local2)
				(gCurRoom setScript: endScript)
			)
		)
	)
)

(instance endScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(end init: setCycle: End self)
			)
			(1
				(= seconds 5)
			)
			(2
				(end setCel: 255 setMotion: MoveTo 154 45 self)
			)
			(3
				(end stopUpd:)
				(= seconds 3)
			)
			(4
				(= local2
					(Display
						{THANKS TO THE FOLLOWING FOR THEIR\nCOOPERATION IN THE MAKING OF THIS GAME:}
						dsWIDTH
						250
						dsCOORD
						35
						85
						dsALIGN
						alCENTER
						dsFONT
						680
						dsCOLOR
						10
						dsBACKGROUND
						0
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(5
				(localproc_0 {PESTULON DEPARTMENT OF FORESTRY})
				(= seconds 6)
			)
			(6
				(localproc_1)
				(localproc_0 {MONOLITH SYNTHETIC INDUSTRIES, INC.})
				(= seconds 6)
			)
			(7
				(localproc_1)
				(localproc_0 {FESTER'S WORLD-O-WONDERS})
				(= seconds 6)
			)
			(8
				(localproc_1)
				(localproc_0 {GIPPAZOID NOVELTIES})
				(= seconds 6)
			)
			(9
				(localproc_1)
				(localproc_0 {PHLEEBHUT SAND ADVISORY COUNCIL})
				(= seconds 6)
			)
			(10
				(localproc_1)
				(localproc_0 {ARNOID DROIDWORKS})
				(= seconds 6)
			)
			(11
				(localproc_1)
				(localproc_0 {CAFFEINATE 90})
				(= seconds 6)
			)
			(12
				(localproc_1)
				(localproc_0 {ORBOSNACK FOOD INHALERS})
				(= seconds 6)
			)
			(13
				(localproc_1)
				(localproc_0 {FRIENDS OF THE TALKING BEAR SOCIETY})
				(= seconds 6)
			)
			(14
				(localproc_1)
				(localproc_0
					{MARK SEIBERT, BOB SIEBENBERG\n& STUART GOLDSTEIN\nFOR THEIR OUTSTANDING SOUND WORK}
				)
				(= seconds 6)
			)
			(15
				(localproc_1)
				(localproc_0
					{DOUG OLDFIELD, KEN KOCH & CHRIS SMITH\nFOR A GREAT PROGRAMMING EFFORT}
				)
				(= seconds 6)
			)
			(16
				(Display 117 1 dsRESTOREPIXELS local2)
				(Display 117 1 dsRESTOREPIXELS local3)
				(RedrawCast)
				(= local2
					(Display
						{THE LITTLE PEOPLE, NOBODIES, SCUM\nWOULD ALSO LIKE TO THANK\n}
						dsWIDTH
						250
						dsCOORD
						35
						85
						dsALIGN
						alCENTER
						dsFONT
						680
						dsCOLOR
						10
						dsBACKGROUND
						0
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display
						{ROBERT E. "BOBBIT" HEITMAN\nFOR HIS GENEROUS, YET VERBOSE, CONTRIBUTION OF ADVICE, HELP & EMERGENCY CODE SERVICE}
						dsWIDTH
						250
						dsCOORD
						35
						120
						dsALIGN
						alCENTER
						dsFONT
						680
						dsCOLOR
						10
						dsBACKGROUND
						0
						dsSAVEPIXELS
					)
				)
				(= seconds 6)
			)
			(17
				(Display 117 1 dsRESTOREPIXELS local2)
				(RedrawCast)
				(Display 117 1 dsRESTOREPIXELS local3)
				(RedrawCast)
				(= local2
					(Display
						{VERY SPECIAL THANKS TO}
						dsWIDTH
						250
						dsCOORD
						35
						95
						dsALIGN
						alCENTER
						dsFONT
						680
						dsCOLOR
						10
						dsBACKGROUND
						0
						dsSAVEPIXELS
					)
				)
				(RedrawCast)
				(= local3
					(Display
						{THE TWO BABES FROM ANDROMEDA\n(OUR WIVES)\nFOR PUTTING UP WITH US THESE LAST 12 MONTHS}
						dsWIDTH
						250
						dsCOORD
						35
						120
						dsALIGN
						alCENTER
						dsFONT
						680
						dsCOLOR
						10
						dsBACKGROUND
						0
						dsSAVEPIXELS
					)
				)
				(= seconds 8)
			)
			(18
				(Display 117 1 dsRESTOREPIXELS local3)
				(RedrawCast)
				(= local3
					(Display
						{YOU!\n(FOR SHELLING OUT YOUR HARD EARNED BUCKS TO BUY THIS GAME)}
						dsWIDTH
						250
						dsCOORD
						35
						120
						dsALIGN
						alCENTER
						dsFONT
						680
						dsCOLOR
						10
						dsBACKGROUND
						0
						dsSAVEPIXELS
					)
				)
				(= seconds 6)
			)
			(19
				(Display 117 1 dsRESTOREPIXELS local2)
				(Display 117 1 dsRESTOREPIXELS local3)
				(RedrawCast)
				(self changeState: 4)
			)
		)
	)
)

(instance ship of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 54
			setLoop: 0
			setCel: 0
			posn: 164 179
			setStep: 1 1
			ignoreActors: 1
			illegalBits: 0
			setCycle: 0
		)
	)
)

(instance end of Act
	(properties
		view 139
	)

	(method (init)
		(super init:)
		(self posn: 154 103 cel: 0 cycleSpeed: 1)
	)
)

