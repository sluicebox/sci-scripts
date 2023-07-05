;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 651)
(include sci.sh)
(use Main)
(use Waters)
(use AudioScript)
(use LoadMany)
(use Motion)
(use Game)
(use System)

(public
	cdIntro2 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	[local8 9] = [40 154 80 185 169 80 267 189 80]
)

(instance cdIntro2 of Rm
	(properties
		picture 69
	)

	(method (init)
		(Load rsPIC 69)
		(LoadMany rsFONT 600 8)
		(LoadMany rsVIEW 748 749)
		(Load rsSCRIPT 771)
		(super init:)
		(HandsOff)
		(gGame setCursor: gNarrator 1)
		(= local6 (if global159 7 else 15))
		(= local7 (gGame egoMoveSpeed:))
		(gGame egoMoveSpeed: 4)
		(gEgo
			normal: 1
			view: 748
			setStep: 3 2
			posn: -10 116
			setLoop: 3
			setPri: 1
			cycleSpeed: 2
			moveSpeed: 4
			init:
		)
		((gEgo head:)
			show:
			view: 748
			setLoop: 4
			moveHead: 2048
			signal: (| $2000 ((gEgo head:) signal:))
		)
		(self setScript: creditsScript setRegions: 769) ; introtoonRegion
		(water init:)
		(SetFlag 22)
	)

	(method (dispose)
		(gGame egoMoveSpeed: local7)
		(DisposeScript 401)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo moveSpeed: 0 setStep: 3 2 setLoop: -1 setCycle: KQ5SyncWalk)
	)
)

(instance sceneTwoScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(audioTrak init: hide: play: 10102 652)
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
				(= seconds 2)
			)
			(7
				(gEgo setLoop: 8 cel: 0 setCycle: End self)
			)
			(8
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
			(9
				(gEgo setMotion: MoveTo 264 103 self)
			)
			(10
				(gEgo setMotion: MoveTo 292 89 self)
			)
			(11
				(gEgo setMotion: MoveTo 319 84 self)
			)
			(12
				(gEgo setMotion: MoveTo 323 84 self)
			)
			(13
				(if (or local5 (> (DoAudio audPOSITION) -1))
					(-- state)
					(= cycles 1)
				else
					(gCurRoom newRoom: 652) ; cdIntro3
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
					(Display 651 0 dsCOORD 70 10 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Executive Producer"
				)
				(= local2
					(Display 651 1 dsCOORD 70 26 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= local1
					(Display ; "Executive Producer"
						651
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
					(Display 651 1 dsCOORD 69 25 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local6 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= seconds 7)
			)
			(1
				(Display 651 2 dsRESTOREPIXELS local1)
				(Display 651 2 dsRESTOREPIXELS local0)
				(Display 651 2 dsRESTOREPIXELS local3)
				(Display 651 2 dsRESTOREPIXELS local2)
				(= cycles 1)
			)
			(2
				(= local3
					(Display 651 3 dsCOORD 11 75 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Creative Director"
				)
				(= local2
					(Display 651 4 dsCOORD 11 91 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
				)
				(= local1
					(Display ; "Creative Director"
						651
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
					(Display 651 4 dsCOORD 10 90 dsWIDTH 120 dsALIGN alCENTER dsCOLOR local6 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
				)
				(= seconds 6)
			)
			(3
				(Display 651 2 dsRESTOREPIXELS local0)
				(Display 651 2 dsRESTOREPIXELS local1)
				(Display 651 2 dsRESTOREPIXELS local2)
				(Display 651 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(4
				(= local3
					(Display 651 5 dsCOORD 70 10 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Designed, Directed and Produced by"
				)
				(= local2
					(Display 651 6 dsCOORD 70 26 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
				)
				(= local1
					(Display ; "Designed, Directed and Produced by"
						651
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
					(Display 651 6 dsCOORD 69 25 dsWIDTH 240 dsALIGN alCENTER dsCOLOR local6 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
				)
				(= seconds 6)
			)
			(5
				(Display 651 2 dsRESTOREPIXELS local0)
				(Display 651 2 dsRESTOREPIXELS local1)
				(Display 651 2 dsRESTOREPIXELS local2)
				(Display 651 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(6
				(= local3
					(Display 651 7 dsCOORD 121 24 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Art Designer"
				)
				(= local2
					(Display 651 8 dsCOORD 121 40 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Andy Hoyos"
				)
				(= local1
					(Display ; "Art Designer"
						651
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
						651
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
				(= seconds 5)
			)
			(7
				(Display 651 2 dsRESTOREPIXELS local0)
				(Display 651 2 dsRESTOREPIXELS local1)
				(Display 651 2 dsRESTOREPIXELS local2)
				(Display 651 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(8
				(= local3
					(Display 651 9 dsCOORD 21 11 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Lead Programmer"
				)
				(= local2
					(Display 651 10 dsCOORD 21 27 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Robert W. Lindsley"
				)
				(= local1
					(Display ; "Lead Programmer"
						651
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
					(Display ; "Robert W. Lindsley"
						651
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
				(= seconds 5)
			)
			(9
				(Display 651 2 dsRESTOREPIXELS local0)
				(Display 651 2 dsRESTOREPIXELS local1)
				(Display 651 2 dsRESTOREPIXELS local2)
				(Display 651 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(10
				(= local3
					(Display 651 11 dsCOORD 11 75 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Composers"
				)
				(= local2
					(Display 651 12 dsCOORD 11 91 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Mark Seibert Ken Allen"
				)
				(= local1
					(Display ; "Composers"
						651
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
					(Display ; "Mark Seibert Ken Allen"
						651
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
				(= seconds 5)
			)
			(11
				(Display 651 2 dsRESTOREPIXELS local0)
				(Display 651 2 dsRESTOREPIXELS local1)
				(Display 651 2 dsRESTOREPIXELS local2)
				(Display 651 2 dsRESTOREPIXELS local3)
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
		(= x [local8 pos])
		(= y [local8 (++ pos)])
		(= cel [local8 (++ pos)])
	)

	(method (saveLoop)
		(= [local8 pos] cel)
		(++ pos)
	)
)

(instance audioTrak of MonoAudioProp
	(properties)
)

