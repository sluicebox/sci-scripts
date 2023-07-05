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
	[local6 9] = [40 154 80 185 169 80 267 189 80]
)

(instance intro2 of Rm
	(properties
		picture 69
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gEgo
			normal: 1
			view: 748
			setStep: 3 2
			posn: 94 116
			setLoop: 3
			offset: 1
			setPri: 1
			cycleSpeed: 0
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
		(self setScript: creditsScript)
		(water init:)
		(SetFlag 23)
	)

	(method (dispose)
		(DisposeScript 401)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (not global327)
			(= temp0 (Event new:))
			(if (or (== (temp0 type:) evKEYBOARD) (== (temp0 type:) evMOUSEBUTTON))
				(temp0 dispose:)
				(gGlobalSound stop:)
				(gGame restart:)
			)
			(temp0 dispose:)
		)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo moveSpeed: 0 setStep: 3 2 setLoop: -1 setCycle: Walk)
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
					cycleSpeed: 0
					offset: 3
					setStep: 2 2
					setCycle: Walk
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
				(= local2
					(Display 101 0 dsCOORD 70 10 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Executive Producer"
				)
				(= local3
					(Display 101 1 dsCOORD 70 26 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= local0
					(Display 101 0 dsCOORD 69 9 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 600 dsSAVEPIXELS) ; "Executive Producer"
				)
				(= local1
					(Display 101 1 dsCOORD 69 25 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= seconds 4)
			)
			(1
				(Display 101 2 dsRESTOREPIXELS local0)
				(Display 101 2 dsRESTOREPIXELS local1)
				(Display 101 2 dsRESTOREPIXELS local2)
				(Display 101 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(2
				(= local2
					(Display 101 3 dsCOORD 11 75 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Creative Director"
				)
				(= local3
					(Display 101 4 dsCOORD 11 91 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
				)
				(= local0
					(Display 101 3 dsCOORD 10 74 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 7 dsFONT 600 dsSAVEPIXELS) ; "Creative Director"
				)
				(= local1
					(Display 101 4 dsCOORD 10 90 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 7 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
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
				(= local2
					(Display 101 5 dsCOORD 70 10 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Designed and Produced by"
				)
				(= local3
					(Display 101 6 dsCOORD 70 26 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
				)
				(= local0
					(Display 101 5 dsCOORD 69 9 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 7 dsFONT 600 dsSAVEPIXELS) ; "Designed and Produced by"
				)
				(= local1
					(Display 101 6 dsCOORD 69 25 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 7 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
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
				(= local2
					(Display 101 7 dsCOORD 121 24 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Art Designer"
				)
				(= local3
					(Display 101 8 dsCOORD 121 40 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Andy Hoyos"
				)
				(= local0
					(Display 101 7 dsCOORD 120 23 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 7 dsFONT 600 dsSAVEPIXELS) ; "Art Designer"
				)
				(= local1
					(Display 101 8 dsCOORD 120 39 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 7 dsFONT 8 dsSAVEPIXELS) ; "Andy Hoyos"
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
				(= local2
					(Display 101 9 dsCOORD 21 11 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Lead Programmer"
				)
				(= local3
					(Display 101 10 dsCOORD 21 27 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Chris Iden"
				)
				(= local0
					(Display 101 9 dsCOORD 20 10 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 7 dsFONT 600 dsSAVEPIXELS) ; "Lead Programmer"
				)
				(= local1
					(Display 101 10 dsCOORD 20 26 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 7 dsFONT 8 dsSAVEPIXELS) ; "Chris Iden"
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
					(Display 101 11 dsCOORD 11 75 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Composers  and"
				)
				(= local2
					(Display 101 12 dsCOORD 11 91 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Mark Seibert Ken Allen"
				)
				(= local1
					(Display 101 11 dsCOORD 10 74 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 600 dsSAVEPIXELS) ; "Composers  and"
				)
				(= local0
					(Display 101 12 dsCOORD 10 90 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 8 dsSAVEPIXELS) ; "Mark Seibert Ken Allen"
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
		(= x [local6 pos])
		(= y [local6 (++ pos)])
		(= cel [local6 (++ pos)])
	)

	(method (saveLoop)
		(= [local6 pos] cel)
		(++ pos)
	)
)

