;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 123)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	ending4 0
)

(local
	[local0 8]
	local8
	local9
	local10
)

(procedure (localproc_0)
	(DrawPic 68 9 0)
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
		(if global159
			(= local9 7)
			(= local10 0)
			(= local8 1)
		else
			(= local9 15)
			(= local10 0)
			(= local8 0)
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
				(gGlobalAudio number: 8134 loop: 1 play:)
			)
			(2
				(family cel: 0 setLoop: 9 setCycle: End self)
			)
			(3
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(egoHead init:)
				(valHead init:)
				(Say 5236 self)
			)
			(5
				(family setLoop: 2 setCycle: End self)
			)
			(6
				(egoHead setCycle: End self)
			)
			(7
				(cls)
				(Say 5237 self)
				(= seconds 5)
			)
			(8
				(cls)
				(egoHead setCycle: Beg)
				(valHead setLoop: 11 setCycle: MouthSync 5238)
				(Say 5238 self)
			)
			(9
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
			(10
				(family setPri: 0 setMotion: MoveTo (family x:) 210 self)
			)
			(11
				(theEnd init:)
				(= seconds 4)
			)
			(12
				(theEnd setMotion: MoveTo 155 46 self)
			)
			(13
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
				(Display 123 0 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Your score:"
				(Display 123 0 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Your score:"
				(Display
					(Format @temp0 123 1 gScore gPossibleScore) ; "%d out of %d possible."
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
				)
				(Display
					(Format @temp0 123 1 gScore gPossibleScore) ; "%d out of %d possible."
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
				)
				(= seconds 10)
			)
			(1
				(localproc_0)
				(Display 123 2 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Creative Consultant"
				(Display 123 2 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Creative Consultant"
				(Display 123 3 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "William D. Skirvin"
				(Display 123 3 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "William D. Skirvin"
				(= seconds 4)
			)
			(2
				(localproc_0)
				(Display 123 4 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Artists"
				(Display 123 4 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Artists"
				(Display 123 5 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice F. Morgan Vasken Nokhoudian Barry T. Smith"
				(Display 123 5 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice F. Morgan Vasken Nokhoudian Barry T. Smith"
				(Display 123 6 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Deanna Yhalkee Jim Larsen Cheryl Loyd"
				(Display 123 6 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Deanna Yhalkee Jim Larsen Cheryl Loyd"
				(= seconds 12)
			)
			(3
				(localproc_0)
				(Display 123 4 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Artists"
				(Display 123 4 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Artists"
				(Display 123 7 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Gerald Moore Cheryl Sweeney Eric Kasner Richard Powell Phyllis Cucchiara Terrence Falls"
				(Display 123 7 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Gerald Moore Cheryl Sweeney Eric Kasner Richard Powell Phyllis Cucchiara Terrence Falls"
				(Display 123 8 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Daryle Smith Jerry Jessurun Frances Powell Hector Martinez Richard D. Zeigler-Martin"
				(Display 123 8 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Daryle Smith Jerry Jessurun Frances Powell Hector Martinez Richard D. Zeigler-Martin"
				(= seconds 8)
			)
			(4
				(localproc_0)
				(Display 123 9 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Programmed by:"
				(Display 123 9 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Programmed by:"
				(Display 123 10 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Dan Carver Chris Carr Chris Hoyt Doug Oldfield Carlos Escobar Oliver Brelsford"
				(Display 123 10 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Dan Carver Chris Carr Chris Hoyt Doug Oldfield Carlos Escobar Oliver Brelsford"
				(= seconds 10)
			)
			(5
				(localproc_0)
				(Display 123 11 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Music Director"
				(Display 123 11 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Music Director"
				(Display 123 12 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Mark Seibert"
				(Display 123 12 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Mark Seibert"
				(= seconds 4)
			)
			(6
				(localproc_0)
				(Display 123 13 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Development System"
				(Display 123 13 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Development System"
				(Display 123 14 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Robert E. Heitman Jeff Stephenson Dan Foy Larry Scott J. Mark Hood Eric Hart Mark Wilden Chris Smith"
				(Display 123 14 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Robert E. Heitman Jeff Stephenson Dan Foy Larry Scott J. Mark Hood Eric Hart Mark Wilden Chris Smith"
				(Display 123 15 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Terry McHenry Chad Bye Ken Koch John Rettig John Crane Steven Coallier Randy Moss"
				(Display 123 15 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Terry McHenry Chad Bye Ken Koch John Rettig John Crane Steven Coallier Randy Moss"
				(= seconds 12)
			)
			(7
				(localproc_0)
				(Display 123 16 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Additional Musicians   Sound Effects"
				(Display 123 16 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Additional Musicians   Sound Effects"
				(Display 123 17 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Rob Atesalp Chris Braymen  Orpheus Hanley"
				(Display 123 17 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Rob Atesalp Chris Braymen  Orpheus Hanley"
				(= seconds 4)
			)
			(8
				(localproc_0)
				(gTheIconBar enable:)
				(gTheIconBar disable: 0 1 2 3)
				(Display 123 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 123 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 123 19 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Narrator - Art Lewicki King Graham - Josh Mandel Cedric - Richard Aronson Crispin - Leonard "Ray" Bergeron Mordack - Andy Hoyos Princess Cassima - Dianah Pressley Prince Alexander - Barry T. Smith Princess Alicia - Diana Wilson"
				(Display 123 19 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Narrator - Art Lewicki King Graham - Josh Mandel Cedric - Richard Aronson Crispin - Leonard "Ray" Bergeron Mordack - Andy Hoyos Princess Cassima - Dianah Pressley Prince Alexander - Barry T. Smith Princess Alicia - Diana Wilson"
				(= seconds 10)
			)
			(9
				(localproc_0)
				(Display 123 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 123 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 123 20 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Willow Tree - Diana Wilson Prince Herbert - Gregory James Thomas Gnome - Gregory James Thomas Queen Beetrice - Dianah Pressley King Antony - Dan Long Amanda - Roberta Williams Gypsy Man - Ken Allen Fortune Teller - Sara Long"
				(Display 123 20 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Willow Tree - Diana Wilson Prince Herbert - Gregory James Thomas Gnome - Gregory James Thomas Queen Beetrice - Dianah Pressley King Antony - Dan Long Amanda - Roberta Williams Gypsy Man - Ken Allen Fortune Teller - Sara Long"
				(= seconds 10)
			)
			(10
				(localproc_0)
				(Display 123 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 123 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 123 21 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Toymaker - Leonard "Ray" Bergeron Toymaker's Son - Barry T. Smith Toymaker's Granddaughter - Kristen Hoyos Austin - Kevin Orcutt Boy in Town -Kevin Orcutt Tailor - D.J. Williams Shoemaker - Dan Long Shoemaker's Wife - Sarah Long"
				(Display 123 21 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Toymaker - Leonard "Ray" Bergeron Toymaker's Son - Barry T. Smith Toymaker's Granddaughter - Kristen Hoyos Austin - Kevin Orcutt Boy in Town -Kevin Orcutt Tailor - D.J. Williams Shoemaker - Dan Long Shoemaker's Wife - Sarah Long"
				(= seconds 10)
			)
			(11
				(localproc_0)
				(Display 123 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 123 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 123 22 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Woman in Town - Roberta Williams Man in Town - Barry T. Smith Baker - Dick Roberts Bakers Brother - Dick Roberts Witch - Sarah Long Elf - Nancy Zdenek Innkeeper - Leonard "Ray" Bergeron Innkeeper's Pal - Josh Mandel"
				(Display 123 22 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Woman in Town - Roberta Williams Man in Town - Barry T. Smith Baker - Dick Roberts Bakers Brother - Dick Roberts Witch - Sarah Long Elf - Nancy Zdenek Innkeeper - Leonard "Ray" Bergeron Innkeeper's Pal - Josh Mandel"
				(= seconds 10)
			)
			(12
				(localproc_0)
				(Display 123 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 123 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 123 23 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Eagle - Barry T. Smith Queen Icebella - Lori Ann Cole Sir Greywolf - Frederick Gott Hermit - Bill Davis Harpy - Roberta Williams Harpy - Nancy Zdenek Harpy - Barbara Eicker Harpy - Josh Mandel"
				(Display 123 23 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Eagle - Barry T. Smith Queen Icebella - Lori Ann Cole Sir Greywolf - Frederick Gott Hermit - Bill Davis Harpy - Roberta Williams Harpy - Nancy Zdenek Harpy - Barbara Eicker Harpy - Josh Mandel"
				(= seconds 10)
			)
			(13
				(localproc_0)
				(Display 123 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 123 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 123 24 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Rocky, The Rock Creature - Barry T. Smith Dink - Barry T. Smith Irate Customer in Tailor Shop - Guruka Singh Khalsa Bandit Leader - Stuart Moulder The Genie - Mark Seibert The Rat - Roberta Williams The Snake - Mark Seibert The Cat, Manannan - Guruka Singh Khalsa"
				(Display 123 24 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Rocky, The Rock Creature - Barry T. Smith Dink - Barry T. Smith Irate Customer in Tailor Shop - Guruka Singh Khalsa Bandit Leader - Stuart Moulder The Genie - Mark Seibert The Rat - Roberta Williams The Snake - Mark Seibert The Cat, Manannan - Guruka Singh Khalsa"
				(= seconds 10)
			)
			(14
				(localproc_0)
				(Display 123 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 123 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 123 25 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Princess Rosella - Diana Wilson Singing Willow Tree - Debbie Seibert Singing Ants - Mark Seibert"
				(Display 123 25 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Princess Rosella - Diana Wilson Singing Willow Tree - Debbie Seibert Singing Ants - Mark Seibert"
				(= seconds 5)
			)
			(15
				(localproc_0)
				(Display 123 26 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Special Thanks To"
				(Display 123 26 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Special Thanks To"
				(Display 123 27 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "J. Mark Hood"
				(Display 123 27 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "J. Mark Hood"
				(= seconds 5)
			)
			(16
				(localproc_0)
				(Display 123 28 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Quality Assurance"
				(Display 123 28 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Quality Assurance"
				(Display 123 29 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "John Ratcliffe"
				(Display 123 29 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "John Ratcliffe"
				(= seconds 5)
			)
			(17
				(localproc_0)
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

