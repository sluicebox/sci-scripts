;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 123)
(include sci.sh)
(use Main)
(use DLetter)
(use KQ5Room)
(use RFeature)
(use Motion)
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
	local8
	local9
	local10
)

(instance ending4 of KQ5Room
	(properties
		picture 68
	)

	(method (init)
		(super init:)
		(gGame setCursor: 999 1)
		(gAddToPics add: aCastle doit:)
		(self setScript: cartoon)
	)

	(method (doit)
		(super doit:)
		(gGame setCursor: 999 1)
		(cond
			((== global105 256)
				(= local9 7)
				(= local10 0)
				(= local8 1)
			)
			((== global105 32)
				(= local9 7)
				(= local10 0)
				(= local8 1)
			)
			(else
				(= local9 15)
				(= local10 0)
				(= local8 0)
			)
		)
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
				(gTheIconBar disable: 0 1 2 3 4 5)
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
		x 157
		y 77
		view 934
		signal 16384
	)
)

(instance family of Actor
	(properties
		x 151
		y 183
		view 934
		loop 1
		priority 14
		signal 16
		cycleSpeed 2
	)
)

(instance egoHead of Prop
	(properties
		x 145
		y 157
		view 934
		loop 3
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self setPri: 13)
	)
)

(instance theEnd of Actor
	(properties
		x 155
		y 88
		view 934
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
					(Display ; "Your score:"
						123
						3
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Your score:"
						123
						3
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display
						(Format @temp0 123 4 gScore gPossibleScore gScore gPossibleScore) ; "%d out of %d possible."
						dsCOORD
						90
						80
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display
						(Format @temp0 123 4 gScore gPossibleScore gScore gPossibleScore) ; "%d out of %d possible."
						dsCOORD
						89
						79
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
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
					(Display ; "Creative Consultant"
						123
						6
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Creative Consultant"
						123
						6
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display ; "William D. Skirvin"
						123
						7
						dsCOORD
						90
						80
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display ; "William D. Skirvin"
						123
						7
						dsCOORD
						89
						79
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 4)
			)
			(2
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display ; "Artists"
						123
						8
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Artists"
						123
						8
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice Morgan Vas Nokhoudian Barry T. Smith"
						123
						9
						dsCOORD
						25
						80
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice Morgan Vas Nokhoudian Barry T. Smith"
						123
						9
						dsCOORD
						24
						79
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local5
					(Display ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Harry McLaughlin Jennifer Shontz Deanna Yhalkee"
						123
						10
						dsCOORD
						155
						80
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local4
					(Display ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Harry McLaughlin Jennifer Shontz Deanna Yhalkee"
						123
						10
						dsCOORD
						154
						79
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 12)
			)
			(3
				(Display 123 5 dsRESTOREPIXELS local4)
				(Display 123 5 dsRESTOREPIXELS local5)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local3
					(Display ; "Jim Larsen Cheryl Loyd Jerry Moore Cheryl Sweeney Eric Kasner Hector Martinez Richard D. Zeigler-Martin"
						123
						11
						dsCOORD
						60
						80
						dsWIDTH
						200
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display ; "Jim Larsen Cheryl Loyd Jerry Moore Cheryl Sweeney Eric Kasner Hector Martinez Richard D. Zeigler-Martin"
						123
						11
						dsCOORD
						59
						79
						dsWIDTH
						200
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 8)
			)
			(4
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display ; "Programmed by:"
						123
						12
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Programmed by:"
						123
						12
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display ; "Chris Hoyt Robert W. Lindsley Raoul Said Doug Oldfield Carlos Escobar Oliver Brelsford"
						123
						13
						dsCOORD
						90
						80
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display ; "Chris Hoyt Robert W. Lindsley Raoul Said Doug Oldfield Carlos Escobar Oliver Brelsford"
						123
						13
						dsCOORD
						89
						79
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 10)
			)
			(5
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display ; "Development System"
						123
						14
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Development System"
						123
						14
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display ; "Terry McHenry Robert E. Heitman Jeff Stephenson Pablo Ghenis Larry Scott"
						123
						15
						dsCOORD
						25
						80
						dsWIDTH
						130
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display ; "Terry McHenry Robert E. Heitman Jeff Stephenson Pablo Ghenis Larry Scott"
						123
						15
						dsCOORD
						24
						79
						dsWIDTH
						130
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local5
					(Display ; "Eric Hart Dan Foy J. Mark Hood Chris Smith Mark Wilden"
						123
						16
						dsCOORD
						155
						80
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local4
					(Display ; "Eric Hart Dan Foy J. Mark Hood Chris Smith Mark Wilden"
						123
						16
						dsCOORD
						154
						79
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 12)
			)
			(6
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(Display 123 5 dsRESTOREPIXELS local4)
				(Display 123 5 dsRESTOREPIXELS local5)
				(= local1
					(Display ; "Composers"
						123
						17
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Composers"
						123
						17
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display ; "Mark Seibert Ken Allen"
						123
						18
						dsCOORD
						90
						80
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display ; "Mark Seibert Ken Allen"
						123
						18
						dsCOORD
						89
						79
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 4)
			)
			(7
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display ; "Additional Musicians"
						123
						19
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Additional Musicians"
						123
						20
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local3
					(Display ; "Rob Atesalp Chris Braymen"
						123
						21
						dsCOORD
						90
						80
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local2
					(Display ; "Rob Atesalp Chris Braymen"
						123
						21
						dsCOORD
						89
						79
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 4)
			)
			(8
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(= local1
					(Display ; "International Producer Sabine Duvall  Translator Ernesto Maquieira"
						123
						22
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "International Producer Sabine Duvall  Translator Ernesto Maquieira"
						123
						22
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 8)
			)
			(9
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(= local1
					(Display ; "Foreign Languages Programming Gary Kamigawachi Sean Mooney"
						123
						23
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Foreign Languages Programming Gary Kamigawachi Sean Mooney"
						123
						23
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 8)
			)
			(10
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(= local1
					(Display ; "Quality Assurance Team Lead Dan Scott  Assistant Team Lead William R. Shockley"
						123
						24
						dsCOORD
						90
						60
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local10
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Quality Assurance Team Lead Dan Scott  Assistant Team Lead William R. Shockley"
						123
						24
						dsCOORD
						89
						59
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local9
						dsFONT
						local8
						dsSAVEPIXELS
					)
				)
				(= seconds 8)
			)
			(11
				(Display 123 5 dsRESTOREPIXELS local0)
				(Display 123 5 dsRESTOREPIXELS local1)
				(Display 123 5 dsRESTOREPIXELS local2)
				(Display 123 5 dsRESTOREPIXELS local3)
				(gTheIconBar enable:)
				(gTheIconBar disable: 0 1 2 3)
				(self init:)
			)
		)
	)
)

(instance valHead of Prop
	(properties
		x 156
		y 158
		view 934
		loop 11
		cycleSpeed 3
	)
)

