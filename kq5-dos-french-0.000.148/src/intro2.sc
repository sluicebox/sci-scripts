;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 101)
(include sci.sh)
(use Main)
(use Waters)
(use Motion)
(use Game)
(use System)

(public
	intro2 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 9] = [40 154 80 185 169 80 267 189 80]
)

(instance intro2 of Rm
	(properties
		picture 69
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gGame setCursor: 5 1)
		(= local6 (if global159 7 else 15))
		(gEgo
			normal: 1
			view: 748
			setStep: 3 2
			posn: 94 116
			setLoop: 3
			setPri: 1
			cycleSpeed: 2
			moveSpeed: 2
			init:
		)
		((gEgo head:)
			show:
			view: 748
			setLoop: 4
			moveHead: 2048
			signal: (| $2000 ((gEgo head:) signal:))
		)
		(self setScript: creditsScript setRegions: 763) ; cartoonRegion
		(water init:)
		(SetFlag 22)
	)

	(method (dispose)
		(DisposeScript 401)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo moveSpeed: 0 setStep: 3 2 setLoop: -1 setCycle: KQ5SyncWalk)
	)
)

(instance sceneTwoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gEgo setMotion: MoveTo 154 112 self)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					cycleSpeed: 3
					x: (+ (gEgo x:) 4)
					setLoop: 5
					cel: 0
				)
				(= seconds 3)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(gEgo setLoop: 7 cel: 0 setCycle: End self)
			)
			(6
				(gEgo setLoop: 8 cel: 0 setCycle: End self)
			)
			(7
				(gEgo
					normal: 1
					setLoop: 6
					cycleSpeed: 2
					setStep: 2 2
					setCycle: SyncWalk
					setMotion: MoveTo 228 120 self
				)
				((gEgo head:) show: setLoop: 4 moveHead: 2048)
			)
			(8
				(gEgo setMotion: MoveTo 264 103 self)
			)
			(9
				(gEgo setMotion: MoveTo 292 89 self)
			)
			(10
				(gEgo setMotion: MoveTo 319 84 self)
			)
			(11
				(gEgo setMotion: MoveTo 323 84 self)
			)
			(12
				(if local5
					(-- state)
					(= cycles 1)
				else
					(gCurRoom newRoom: 102) ; intro3
				)
			)
		)
	)
)

(instance creditsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setScript: sceneTwoScript)
				(= local5 1)
				(= local3
					(Display 101 0 dsCOORD 70 10 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Producteur Ex\82cutif"
				)
				(= local2
					(Display 101 1 dsCOORD 70 26 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= local1
					(Display ; "Producteur Ex\82cutif"
						101
						0
						dsCOORD
						69
						9
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local6
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display 101 1 dsCOORD 69 25 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local6 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= seconds 4)
			)
			(1
				(Display 101 2 dsRESTOREPIXELS local1)
				(Display 101 2 dsRESTOREPIXELS local0)
				(Display 101 2 dsRESTOREPIXELS local3)
				(Display 101 2 dsRESTOREPIXELS local2)
				(= cycles 1)
			)
			(2
				(= local3
					(Display 101 3 dsCOORD 11 75 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Directeur a la Creation"
				)
				(= local2
					(Display 101 4 dsCOORD 11 91 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
				)
				(= local1
					(Display ; "Directeur a la Creation"
						101
						3
						dsCOORD
						10
						74
						dsWIDTH
						120
						dsALIGN
						alCENTER
						dsCOLOR
						local6
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display 101 4 dsCOORD 10 90 dsWIDTH 120 dsALIGN alCENTER dsCOLOR local6 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
				)
				(= seconds 3)
			)
			(3
				(Display 101 2 dsRESTOREPIXELS local0)
				(Display 101 2 dsRESTOREPIXELS local1)
				(Display 101 2 dsRESTOREPIXELS local2)
				(Display 101 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(4
				(= local3
					(Display 101 5 dsCOORD 70 10 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Design et Production par"
				)
				(= local2
					(Display 101 6 dsCOORD 70 26 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
				)
				(= local1
					(Display ; "Design et Production par"
						101
						5
						dsCOORD
						69
						9
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local6
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display 101 6 dsCOORD 69 25 dsWIDTH 240 dsALIGN alCENTER dsCOLOR local6 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
				)
				(= seconds 3)
			)
			(5
				(Display 101 2 dsRESTOREPIXELS local0)
				(Display 101 2 dsRESTOREPIXELS local1)
				(Display 101 2 dsRESTOREPIXELS local2)
				(Display 101 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(6
				(= local3
					(Display 101 7 dsCOORD 121 24 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Conception Artistique"
				)
				(= local2
					(Display 101 8 dsCOORD 121 40 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Andy Hoyos"
				)
				(= local1
					(Display ; "Conception Artistique"
						101
						7
						dsCOORD
						120
						23
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local6
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Andy Hoyos"
						101
						8
						dsCOORD
						120
						39
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local6
						dsFONT
						8
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(7
				(Display 101 2 dsRESTOREPIXELS local0)
				(Display 101 2 dsRESTOREPIXELS local1)
				(Display 101 2 dsRESTOREPIXELS local2)
				(Display 101 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(8
				(= local3
					(Display 101 9 dsCOORD 21 11 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Supervision a la Programmation"
				)
				(= local2
					(Display 101 10 dsCOORD 21 27 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Chris Iden"
				)
				(= local1
					(Display ; "Supervision a la Programmation"
						101
						9
						dsCOORD
						20
						10
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local6
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Chris Iden"
						101
						10
						dsCOORD
						20
						26
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local6
						dsFONT
						8
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(9
				(Display 101 2 dsRESTOREPIXELS local0)
				(Display 101 2 dsRESTOREPIXELS local1)
				(Display 101 2 dsRESTOREPIXELS local2)
				(Display 101 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(10
				(= local3
					(Display 101 11 dsCOORD 11 75 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Music Director"
				)
				(= local2
					(Display 101 12 dsCOORD 11 91 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Mark Seibert"
				)
				(= local1
					(Display ; "Music Director"
						101
						11
						dsCOORD
						10
						74
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local6
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Mark Seibert"
						101
						12
						dsCOORD
						10
						90
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local6
						dsFONT
						8
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(11
				(Display 101 2 dsRESTOREPIXELS local0)
				(Display 101 2 dsRESTOREPIXELS local1)
				(Display 101 2 dsRESTOREPIXELS local2)
				(Display 101 2 dsRESTOREPIXELS local3)
				(= local5 0)
			)
		)
	)
)

(instance water of Waters
	(properties
		view 749
		cycleSpeed 6
	)

	(method (getLoop)
		(= x [local7 pos])
		(= y [local7 (++ pos)])
		(= cel [local7 (++ pos)])
	)

	(method (saveLoop)
		(= [local7 pos] cel)
		(++ pos)
	)
)

