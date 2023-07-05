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

(procedure (localproc_0)
	(DrawPic 68 18 0)
	(theEnd forceUpd:)
	(gAddToPics add: aCastle doit:)
)

(instance ending4 of KQ5Room
	(properties
		picture 68
	)

	(method (init)
		(super init:)
		(gGame setCursor: gNormalCursor 1)
		(gAddToPics add: aCastle doit:)
		(self setScript: cartoon)
	)

	(method (doit)
		(super doit:)
		(gGame setCursor: gNormalCursor 1)
		(cond
			((== global105 256)
				(= local9 7)
				(= local10 0)
				(= local8 1)
			)
			((== global105 32)
				(= local9 31)
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
				(Display 123 3 dsCOORD 60 60 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Your score:"
				(Display 123 3 dsCOORD 59 59 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Your score:"
				(Display
					(Format @temp0 123 4 gScore gPossibleScore gScore gPossibleScore) ; "%d out of %d possible."
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
				)
				(Display
					(Format @temp0 123 4 gScore gPossibleScore gScore gPossibleScore) ; "%d out of %d possible."
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
				)
				(= seconds 10)
			)
			(1
				(localproc_0)
				(Display 123 5 dsCOORD 60 60 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Creative Consultant"
				(Display 123 5 dsCOORD 59 59 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Creative Consultant"
				(Display 123 6 dsCOORD 60 80 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "William D. Skirvin"
				(Display 123 6 dsCOORD 59 79 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "William D. Skirvin"
				(= seconds 4)
			)
			(2
				(localproc_0)
				(Display 123 7 dsCOORD 60 60 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Artists"
				(Display 123 7 dsCOORD 59 59 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Artists"
				(Display 123 8 dsCOORD 25 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice F. Morgan Vasken Nokhoudian Barry T. Smith"
				(Display 123 8 dsCOORD 24 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice F. Morgan Vasken Nokhoudian Barry T. Smith"
				(Display 123 9 dsCOORD 155 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Deanna Yhalkee Jim Larsen Cheryl Loyd"
				(Display 123 9 dsCOORD 154 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Deanna Yhalkee Jim Larsen Cheryl Loyd"
				(= seconds 12)
			)
			(3
				(localproc_0)
				(Display 123 7 dsCOORD 60 60 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Artists"
				(Display 123 7 dsCOORD 59 59 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Artists"
				(Display 123 10 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Gerald Moore Cheryl Sweeney Eric Kasner Richard Powell Phyllis Cucchiara Terrence Falls"
				(Display 123 10 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Gerald Moore Cheryl Sweeney Eric Kasner Richard Powell Phyllis Cucchiara Terrence Falls"
				(Display 123 11 dsCOORD 155 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Daryle Smith Jerry Jessurun Frances Powell Hector Martinez Richard D. Zeigler-Martin"
				(Display 123 11 dsCOORD 154 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Daryle Smith Jerry Jessurun Frances Powell Hector Martinez Richard D. Zeigler-Martin"
				(= seconds 8)
			)
			(4
				(localproc_0)
				(Display 123 12 dsCOORD 60 60 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Programmed by:"
				(Display 123 12 dsCOORD 59 59 dsWIDTH 200 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Programmed by:"
				(Display 123 13 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Chris Hoyt Robert W. Lindsley Raoul Said Doug Oldfield Carlos Escobar Oliver Brelsford"
				(Display 123 13 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Chris Hoyt Robert W. Lindsley Raoul Said Doug Oldfield Carlos Escobar Oliver Brelsford"
				(= seconds 10)
			)
			(5
				(localproc_0)
				(Display 123 14 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Music Director"
				(Display 123 14 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Music Director"
				(Display 123 15 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Mark Seibert"
				(Display 123 15 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Mark Seibert"
				(= seconds 4)
			)
			(6
				(localproc_0)
				(Display 123 16 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Development System"
				(Display 123 16 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Development System"
				(Display 123 17 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Robert E. Heitman Jeff Stephenson Dan Foy Larry Scott J. Mark Hood Eric Hart Mark Wilden Chris Smith"
				(Display 123 17 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Robert E. Heitman Jeff Stephenson Dan Foy Larry Scott J. Mark Hood Eric Hart Mark Wilden Chris Smith"
				(Display 123 18 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Terry McHenry Chad Bye Ken Koch John Rettig John Crane Steven Coallier Randy Moss"
				(Display 123 18 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Terry McHenry Chad Bye Ken Koch John Rettig John Crane Steven Coallier Randy Moss"
				(= seconds 12)
			)
			(7
				(localproc_0)
				(Display 123 19 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Additional Musicians   Sound Effects"
				(Display 123 19 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Additional Musicians   Sound Effects"
				(Display 123 20 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Rob Atesalp Chris Braymen  Orpheus Hanley"
				(Display 123 20 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Rob Atesalp Chris Braymen  Orpheus Hanley"
				(= seconds 4)
			)
			(8
				(localproc_0)
				(= local0
					(Display ; "Amiga Conversion Team"
						123
						21
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
				(= local1
					(Display ; "Amiga Conversion Team"
						123
						21
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
				(= local2
					(Display ; "Lead Programmer"
						123
						22
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
				(= local3
					(Display ; "Lead Programmer"
						123
						22
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
				(= local4
					(Display ; "Steven Coallier"
						123
						23
						dsCOORD
						90
						100
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
				(= local5
					(Display ; "Steven Coallier"
						123
						23
						dsCOORD
						89
						99
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
				(= seconds 5)
			)
			(9
				(Display 123 24 dsRESTOREPIXELS local5)
				(Display 123 24 dsRESTOREPIXELS local4)
				(Display 123 24 dsRESTOREPIXELS local3)
				(Display 123 24 dsRESTOREPIXELS local2)
				(= local2
					(Display ; "Programming"
						123
						25
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
				(= local3
					(Display ; "Programming"
						123
						25
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
				(= local4
					(Display ; "Gary Kamigawachi William R. Shockley Sean T. Mooney Chris Carr"
						123
						26
						dsCOORD
						90
						100
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
				(= local5
					(Display ; "Gary Kamigawachi William R. Shockley Sean T. Mooney Chris Carr"
						123
						26
						dsCOORD
						89
						99
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
				(= seconds 5)
			)
			(10
				(Display 123 24 dsRESTOREPIXELS local5)
				(Display 123 24 dsRESTOREPIXELS local4)
				(Display 123 24 dsRESTOREPIXELS local3)
				(Display 123 24 dsRESTOREPIXELS local2)
				(= local2
					(Display ; "Sound Programming"
						123
						27
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
				(= local3
					(Display ; "Sound Programming"
						123
						27
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
				(= local4
					(Display ; "Eric Hart"
						123
						28
						dsCOORD
						90
						100
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
				(= local5
					(Display ; "Eric Hart"
						123
						28
						dsCOORD
						89
						99
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
				(= seconds 5)
			)
			(11
				(Display 123 24 dsRESTOREPIXELS local5)
				(Display 123 24 dsRESTOREPIXELS local4)
				(Display 123 24 dsRESTOREPIXELS local3)
				(Display 123 24 dsRESTOREPIXELS local2)
				(= local2
					(Display ; "System Development"
						123
						29
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
				(= local3
					(Display ; "System Development"
						123
						29
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
				(= local4
					(Display ; "John Rettig Steven Coallier Randy Moss John Crane"
						123
						30
						dsCOORD
						90
						100
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
				(= local5
					(Display ; "John Rettig Steven Coallier Randy Moss John Crane"
						123
						30
						dsCOORD
						89
						99
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
				(= seconds 5)
			)
			(12
				(Display 123 24 dsRESTOREPIXELS local5)
				(Display 123 24 dsRESTOREPIXELS local4)
				(Display 123 24 dsRESTOREPIXELS local3)
				(Display 123 24 dsRESTOREPIXELS local2)
				(= local2
					(Display ; "Producer"
						123
						31
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
				(= local3
					(Display ; "Producer"
						123
						31
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
				(= local4
					(Display ; "Sabine Duvall Stuart Moulder"
						123
						32
						dsCOORD
						90
						100
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
				(= local5
					(Display ; "Sabine Duvall Stuart Moulder"
						123
						32
						dsCOORD
						89
						99
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
				(= seconds 5)
			)
			(13
				(Display 123 24 dsRESTOREPIXELS local5)
				(Display 123 24 dsRESTOREPIXELS local4)
				(Display 123 24 dsRESTOREPIXELS local3)
				(Display 123 24 dsRESTOREPIXELS local2)
				(= local2
					(Display ; "Art Conversion"
						123
						33
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
				(= local3
					(Display ; "Art Conversion"
						123
						33
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
				(= local4
					(Display ; "Richard Powell Terrence Falls Phyllis Cucchiara Nathan Larsen"
						123
						34
						dsCOORD
						90
						100
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
				(= local5
					(Display ; "Richard Powell Terrence Falls Phyllis Cucchiara Nathan Larsen"
						123
						34
						dsCOORD
						89
						99
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
				(= seconds 5)
			)
			(14
				(Display 123 24 dsRESTOREPIXELS local5)
				(Display 123 24 dsRESTOREPIXELS local4)
				(Display 123 24 dsRESTOREPIXELS local3)
				(Display 123 24 dsRESTOREPIXELS local2)
				(= local2
					(Display ; "Music and Sound Effects"
						123
						35
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
				(= local3
					(Display ; "Music and Sound Effects"
						123
						35
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
				(= local4
					(Display ; "Paul Aleman"
						123
						36
						dsCOORD
						90
						100
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
				(= local5
					(Display ; "Paul Aleman"
						123
						36
						dsCOORD
						89
						99
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
				(= seconds 5)
			)
			(15
				(Display 123 24 dsRESTOREPIXELS local5)
				(Display 123 24 dsRESTOREPIXELS local4)
				(Display 123 24 dsRESTOREPIXELS local3)
				(Display 123 24 dsRESTOREPIXELS local2)
				(Display 123 24 dsRESTOREPIXELS local1)
				(Display 123 24 dsRESTOREPIXELS local0)
				(= cycles 1)
			)
			(16
				(localproc_0)
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

