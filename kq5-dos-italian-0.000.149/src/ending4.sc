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
		(gGame setCursor: 999 1)
		(gAddToPics add: aCastle doit:)
		(self setScript: cartoon)
	)

	(method (doit)
		(super doit:)
		(gGame setCursor: 999 1)
		(cond
			((== global105 256)
				(= local1 7)
				(= local2 0)
				(= local0 1)
			)
			((== global105 32)
				(= local1 7)
				(= local2 0)
				(= local0 1)
			)
			(else
				(= local1 15)
				(= local2 0)
				(= local0 0)
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
				(Display 123 3 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Your score:"
				(Display 123 3 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Your score:"
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
					local2
					dsFONT
					local0
				)
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
					local1
					dsFONT
					local0
				)
				(= seconds 10)
			)
			(1
				(localproc_0)
				(Display 123 5 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Creative Consultant"
				(Display 123 5 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Creative Consultant"
				(Display 123 6 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "William D. Skirvin"
				(Display 123 6 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "William D. Skirvin"
				(= seconds 4)
			)
			(2
				(localproc_0)
				(Display 123 7 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Artists"
				(Display 123 7 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Artists"
				(Display 123 8 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice Morgan Vas Nokhoudian Barry T. Smith"
				(Display 123 8 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice Morgan Vas Nokhoudian Barry T. Smith"
				(Display 123 9 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Harry McLaughlin Jennifer Shontz Deanna Yhalkee"
				(Display 123 9 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Harry McLaughlin Jennifer Shontz Deanna Yhalkee"
				(= seconds 12)
			)
			(3
				(localproc_0)
				(Display 123 7 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Artists"
				(Display 123 7 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Artists"
				(Display 123 10 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Jim Larsen Cheryl Loyd Jerry Moore Cheryl Sweeney Eric Kasner Hector Martinez Richard D. Zeigler-Martin"
				(Display 123 10 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Jim Larsen Cheryl Loyd Jerry Moore Cheryl Sweeney Eric Kasner Hector Martinez Richard D. Zeigler-Martin"
				(= seconds 8)
			)
			(4
				(localproc_0)
				(Display 123 11 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Programmed by:"
				(Display 123 12 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Programmed by:"
				(Display 123 13 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Chris Hoyt Robert W. Lindsley Raoul Said Doug Oldfield Carlos Escobar Oliver Brelsford"
				(Display 123 13 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Chris Hoyt Robert W. Lindsley Raoul Said Doug Oldfield Carlos Escobar Oliver Brelsford"
				(= seconds 10)
			)
			(5
				(localproc_0)
				(Display 123 14 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Development System"
				(Display 123 14 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Development System"
				(Display 123 15 dsCOORD 35 80 dsWIDTH 120 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Terry McHenry Robert E. Heitman Jeff Stephenson Pablo Ghenis Larry Scott"
				(Display 123 15 dsCOORD 34 79 dsWIDTH 120 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Terry McHenry Robert E. Heitman Jeff Stephenson Pablo Ghenis Larry Scott"
				(Display 123 16 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Eric Hart Dan Foy J. Mark Hood Chris Smith Mark Wilden"
				(Display 123 16 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Eric Hart Dan Foy J. Mark Hood Chris Smith Mark Wilden"
				(= seconds 12)
			)
			(6
				(localproc_0)
				(Display 123 17 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Composers"
				(Display 123 17 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Composers"
				(Display 123 18 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Mark Seibert Ken Allen"
				(Display 123 18 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Mark Seibert Ken Allen"
				(= seconds 4)
			)
			(7
				(localproc_0)
				(Display 123 19 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Additional Musicians"
				(Display 123 19 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Additional Musicians"
				(Display 123 20 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Rob Atesalp Chris Braymen"
				(Display 123 20 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Rob Atesalp Chris Braymen"
				(= seconds 4)
			)
			(8
				(localproc_0)
				(= cycles 1)
			)
			(9
				(localproc_0)
				(Display 123 21 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "International Producer Sabine Duvall  Translator Studio A"
				(Display 123 21 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "International Producer Sabine Duvall  Translator Studio A"
				(= seconds 8)
			)
			(10
				(localproc_0)
				(Display 123 22 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Foreign Languages Programming Gary Kamigawachi Sean Mooney William R. Shockley"
				(Display 123 22 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Foreign Languages Programming Gary Kamigawachi Sean Mooney William R. Shockley"
				(= seconds 8)
			)
			(11
				(localproc_0)
				(Display 123 23 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local2 dsFONT local0) ; "Quality Assurance Team Lead Dan Scott  Assistant Team Lead Keri Cooper"
				(Display 123 23 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local1 dsFONT local0) ; "Quality Assurance Team Lead Dan Scott  Assistant Team Lead Keri Cooper"
				(= seconds 8)
			)
			(12
				(localproc_0)
				(= cycles 1)
			)
			(13
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

