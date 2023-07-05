;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 117)
(include sci.sh)
(use Main)
(use FileSelector)
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
)

(procedure (localproc_0 param1)
	(SaveSubLang)
	(= local3 (Display param1 dsWIDTH 250 dsCOORD 35 120 dsALIGN alCENTER dsFONT 300 dsCOLOR 10 dsSAVEPIXELS))
	(RestoreSubLang)
	(RedrawCast)
)

(procedure (localproc_1)
	(SaveSubLang)
	(Display 117 1 dsRESTOREPIXELS local3)
	(RestoreSubLang)
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
		(Load rsVIEW (LangSwitch 139 326))
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
					(Display 117 0 dsWIDTH 250 dsCOORD 35 25 dsALIGN alCENTER dsFONT 300 dsCOLOR 14 dsSAVEPIXELS) ; "And so we bid our hero a fond farewell as his ship once again bursts into light speed... course unknown."
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
				(SaveSubLang)
				(= local2
					(Display
						{Thanks To The Following For Their\nCooperation In The Making Of This Game:}
						dsWIDTH
						250
						dsCOORD
						35
						85
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(RestoreSubLang)
				(= seconds 3)
			)
			(5
				(localproc_0
					{Pestulon Department of Forestry}
				)
				(= seconds 6)
			)
			(6
				(localproc_1)
				(localproc_0
					{Monolith Synthetic Industries, Inc.}
				)
				(= seconds 6)
			)
			(7
				(localproc_1)
				(localproc_0
					{Fester's World-O-Wonders}
				)
				(= seconds 6)
			)
			(8
				(localproc_1)
				(localproc_0 {Gippazoid Novelties})
				(= seconds 6)
			)
			(9
				(localproc_1)
				(localproc_0
					{Phleebhut Sand Advisory Council}
				)
				(= seconds 6)
			)
			(10
				(localproc_1)
				(localproc_0 {Arnoid Droidworks})
				(= seconds 6)
			)
			(11
				(localproc_1)
				(localproc_0 {Caffeinate 90})
				(= seconds 6)
			)
			(12
				(localproc_1)
				(localproc_0
					{OrboSnack Food Inhalers}
				)
				(= seconds 6)
			)
			(13
				(localproc_1)
				(localproc_0
					{Friends of the Talking Bear Society}
				)
				(= seconds 6)
			)
			(14
				(localproc_1)
				(localproc_0
					{Mark Seibert, Bob Siebenberg\n& Stuart Goldstein\nFor Their Outstanding Sound Work}
				)
				(= seconds 6)
			)
			(15
				(localproc_1)
				(localproc_0
					{Doug Oldfield, Ken Koch & Chris Smith\nFor A Great Programming Effort}
				)
				(= seconds 6)
			)
			(16
				(SaveSubLang)
				(Display 117 1 dsRESTOREPIXELS local2)
				(Display 117 1 dsRESTOREPIXELS local3)
				(RedrawCast)
				(= local2
					(Display
						{The Little People, Nobodies, Scum\nWould Also Like To Thank\n}
						dsWIDTH
						250
						dsCOORD
						35
						85
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display
						{Robert E. "Bobbit" Heitman\nFor His Generous, Yet Verbose, Contribution of Advice, Help & Emergency Code Service}
						dsWIDTH
						250
						dsCOORD
						35
						120
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(RestoreSubLang)
				(= seconds 6)
			)
			(17
				(SaveSubLang)
				(Display 117 1 dsRESTOREPIXELS local2)
				(RedrawCast)
				(Display 117 1 dsRESTOREPIXELS local3)
				(RedrawCast)
				(= local2
					(Display
						{Very Special Thanks to}
						dsWIDTH
						250
						dsCOORD
						35
						95
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(RedrawCast)
				(= local3
					(Display
						{The Two Babes From Andromeda\n(Our Wives)\nFor Putting Up With Us These Last 12 Months}
						dsWIDTH
						250
						dsCOORD
						35
						120
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(RestoreSubLang)
				(= seconds 8)
			)
			(18
				(SaveSubLang)
				(Display 117 1 dsRESTOREPIXELS local3)
				(RedrawCast)
				(= local3
					(Display
						{You!\n(For Shelling Out Your Hard Earned Bucks To Buy This Game)}
						dsWIDTH
						250
						dsCOORD
						35
						120
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						10
						dsSAVEPIXELS
					)
				)
				(RestoreSubLang)
				(= seconds 6)
			)
			(19
				(SaveSubLang)
				(Display 117 1 dsRESTOREPIXELS local2)
				(Display 117 1 dsRESTOREPIXELS local3)
				(RestoreSubLang)
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
		view 326
	)

	(method (init)
		(= view (LangSwitch 139 326))
		(super init:)
		(self posn: 154 103 cel: 0 cycleSpeed: 1)
	)
)

