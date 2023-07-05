;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 123)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	ending4 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 2]
)

(instance ending4 of Rm
	(properties
		picture 68
	)

	(method (init)
		(super init:)
		(gAddToPics add: aCastle doit:)
		(self setScript: cartoon)
	)

	(method (doit)
		(super doit:)
		(if (== (gGlobalSound prevSignal:) -1)
			(if (< (DoSound sndGET_POLYPHONY) 32)
				(gGlobalSound number: 699 loop: -1 playBed:)
			else
				(gGlobalSound number: 799 loop: -1 playBed:)
			)
		)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				((gUIcons at: 0) state: 0)
				((gUIcons at: 1) state: 0)
				((gUIcons at: 2) state: 0)
				((gUIcons at: 3) state: 0)
				((gUIcons at: 4) state: 0)
				((gUIcons at: 5) state: 0)
				((gUIcons at: 6) state: 0)
				((gUIcons at: 9) state: 0)
				((gUIcons at: 10) state: 0)
				(family init: setCycle: End self)
			)
			(2
				(family cel: 0 setLoop: 9 setCycle: End self)
			)
			(3
				(egoHead init:)
				(valHead init:)
				(PrintDC 123 0 #at 10 10 #dispose) ; "Well, there she is...our happy home. And we're all safe and sound once more."
				(= seconds 7)
			)
			(4
				(family setLoop: 2 setCycle: End self)
			)
			(5
				(egoHead setCycle: End self)
			)
			(6
				(cls)
				(PrintDC 123 1 #at 10 10 #dispose) ; "Let's go home, shall we?"
				(egoHead setLoop: 4 setCycle: Fwd)
				(= seconds 5)
			)
			(7
				(cls)
				(egoHead setCycle: Beg)
				(valHead setLoop: 11 setCycle: Fwd)
				(PrintDC 123 2 #at 100 100 #dispose) ; "Yes, let's."
				(= seconds 3)
			)
			(8
				(cls)
				(egoHead dispose:)
				(valHead dispose:)
				(family
					setLoop: 5
					moveSpeed: 2
					setCycle: Fwd
					setMotion: MoveTo (family x:) 175 self
				)
			)
			(9
				(family setPri: 0 setMotion: MoveTo (family x:) 210 self)
			)
			(10
				(theEnd init:)
				(= seconds 4)
			)
			(11
				(theEnd setMotion: MoveTo 155 46 self)
			)
			(12
				(self setScript: creditsScript)
			)
		)
	)
)

(instance aCastle of RPicView
	(properties
		y 77
		x 157
		view 755
		loop 4
		signal 16384
	)
)

(instance family of Act
	(properties
		y 183
		x 151
		view 933
		loop 1
		priority 14
		signal 16
		cycleSpeed 2
	)
)

(instance egoHead of Prop
	(properties
		y 157
		x 145
		view 933
		loop 3
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self setPri: 13)
	)
)

(instance theEnd of Act
	(properties
		y 88
		x 155
		view 933
		loop 6
		priority 15
		signal 18448
		illegalBits 0
	)
)

(instance creditsScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 60])
		(switch (= state newState)
			(0
				(= local1
					(Display 123 3 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Your score:"
				)
				(= local0
					(Display 123 3 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Your score:"
				)
				(= local3
					(Display
						(Format @temp0 123 4 gScore gPossibleScore) ; "%d out of %d possible."
						dsCOORD
						90
						80
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						0
						dsFONT
						1
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display
						(Format @temp0 123 4 gScore gPossibleScore) ; "%d out of %d possible."
						dsCOORD
						89
						79
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						7
						dsFONT
						1
						dsSAVEPIXELS
					)
				)
				(= seconds 10)
			)
			(1
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display 123 6 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Creative Consultant"
				)
				(= local0
					(Display 123 6 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Creative Consultant"
				)
				(= local3
					(Display 123 7 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "William D. Skirvin"
				)
				(= local2
					(Display 123 7 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "William D. Skirvin"
				)
				(= seconds 4)
			)
			(2
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display 123 8 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Artists"
				)
				(= local0
					(Display 123 8 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Artists"
				)
				(= local3
					(Display 123 9 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice Morgan Vas Nokhoudian Barry T. Smith"
				)
				(= local2
					(Display 123 9 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice Morgan Vas Nokhoudian Barry T. Smith"
				)
				(= local5
					(Display 123 10 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Cindy Walker Deena Benz Tamra Dayton Dana Dean Roger Hardy, Jr. Harry McLaughlin Jennifer Shontz"
				)
				(= local4
					(Display 123 10 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Cindy Walker Deena Benz Tamra Dayton Dana Dean Roger Hardy, Jr. Harry McLaughlin Jennifer Shontz"
				)
				(= seconds 12)
			)
			(3
				(Display 123 5 dsRESTOREPIXELS local4)
				(Display 123 5 dsRESTOREPIXELS local5)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local3
					(Display 123 11 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Deanna Yhalkee Jim Larsen Cheryl Loyd Jerry Moore Cheryl Sweeney Eric Kasner Hector Martinez Richard D. Zeigler-Martin"
				)
				(= local2
					(Display 123 11 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Deanna Yhalkee Jim Larsen Cheryl Loyd Jerry Moore Cheryl Sweeney Eric Kasner Hector Martinez Richard D. Zeigler-Martin"
				)
				(= seconds 8)
			)
			(4
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display 123 12 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Programmed by:"
				)
				(= local0
					(Display 123 12 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Programmed by:"
				)
				(= local3
					(Display 123 13 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Chris Hoyt Robert W. Lindsley Raoul Said Doug Oldfield Carlos Escobar Oliver Brelsford"
				)
				(= local2
					(Display 123 13 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Chris Hoyt Robert W. Lindsley Raoul Said Doug Oldfield Carlos Escobar Oliver Brelsford"
				)
				(= seconds 10)
			)
			(5
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display 123 14 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Additional Musicians"
				)
				(= local0
					(Display 123 14 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Additional Musicians"
				)
				(= local3
					(Display 123 15 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Rob Atesalp Chris Braymen"
				)
				(= local2
					(Display 123 15 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Rob Atesalp Chris Braymen"
				)
				(= seconds 5)
			)
			(6
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display 123 16 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Development System"
				)
				(= local0
					(Display 123 16 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Development System"
				)
				(= local3
					(Display 123 17 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Robert E. Heitman Jeff Stephenson Pablo Ghenis"
				)
				(= local2
					(Display 123 17 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Robert E. Heitman Jeff Stephenson Pablo Ghenis"
				)
				(= seconds 6)
			)
			(7
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local3
					(Display 123 18 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 1 dsSAVEPIXELS) ; "Corey Cole Dan Foy John Rettig John Hartin Larry Scott Eric Hart J. Mark Hood"
				)
				(= local2
					(Display 123 18 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 7 dsFONT 1 dsSAVEPIXELS) ; "Corey Cole Dan Foy John Rettig John Hartin Larry Scott Eric Hart J. Mark Hood"
				)
				(= seconds 6)
			)
			(8
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(HandsOn)
				(User canInput: 1 controls: 0)
				(self init:)
			)
		)
	)
)

(instance valHead of Prop
	(properties
		y 158
		x 156
		view 933
		loop 10
		cycleSpeed 3
	)
)

