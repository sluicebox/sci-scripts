;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 673)
(include sci.sh)
(use Main)
(use AudioScript)
(use KQ5Room)
(use RandCycle)
(use LoadMany)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	cdEnding4 0
)

(local
	[local0 8]
	local8
	local9
	local10
	local11
)

(procedure (localproc_0)
	(DrawPic 68 9 0)
	(theEnd forceUpd:)
	(gAddToPics add: aCastle doit:)
)

(instance cdEnding4 of KQ5Room
	(properties
		picture 68
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 941)
		(Load rsSCRIPT 929)
		(Load rsVIEW 936)
		(LoadMany rsSOUND 699 799)
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
		(if (and (== (gGlobalSound prevSignal:) -1) local11)
			(if (< (DoSound sndGET_POLYPHONY) 32)
				(gGlobalSound number: 699 loop: -1 playBed:)
			else
				(gGlobalSound number: 799 loop: -1 playBed:)
			)
		)
	)
)

(instance cartoon of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(syncIt init: hide: play: 10126)
				(= waitForCue 14592)
			)
			(2
				(gTheIconBar disable: 0 1 2 3 4 5)
				(family init: setCycle: End self)
			)
			(3
				(family cel: 0 setLoop: 9 setCycle: End self)
			)
			(4
				(= waitForCue 14848)
			)
			(5
				(egoHead init:)
				(valHead init:)
				(= waitForCue 15104)
			)
			(6
				(family setLoop: 2 setCycle: End self)
			)
			(7
				(egoHead setCycle: End self)
			)
			(8
				(cls)
				(= waitForCue 15360)
			)
			(9
				(cls)
				(egoHead setCycle: Beg)
				(valHead setLoop: 11 setCycle: RandCycle cycleSpeed: 4)
				(= waitForCue 15616)
			)
			(10
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
			(11
				(family setPri: 0 setMotion: MoveTo (family x:) 210 self)
			)
			(12
				(theEnd init:)
				(= seconds 4)
			)
			(13
				(theEnd setMotion: MoveTo 155 46 self)
			)
			(14
				(self setScript: creditsScript)
				(= cycles 1)
			)
			(15
				(if (> (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(16
				(gGlobalSound prevSignal: -1)
				(= local11 1)
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
				(Display 673 0 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Your score:"
				(Display 673 0 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Your score:"
				(Display
					(Format @temp0 673 1 gScore gPossibleScore) ; "%d out of %d possible."
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
					(Format @temp0 673 1 gScore gPossibleScore) ; "%d out of %d possible."
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
				(Display 673 2 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Creative Consultant"
				(Display 673 2 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Creative Consultant"
				(Display 673 3 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "William D. Skirvin"
				(Display 673 3 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "William D. Skirvin"
				(= seconds 4)
			)
			(2
				(localproc_0)
				(Display 673 4 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Artists"
				(Display 673 4 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Artists"
				(Display 673 5 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice F. Morgan Vasken Nokhoudian Barry T. Smith"
				(Display 673 5 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice F. Morgan Vasken Nokhoudian Barry T. Smith"
				(Display 673 6 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Deanna Yhalkee Jim Larsen Cheryl Loyd"
				(Display 673 6 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Deanna Yhalkee Jim Larsen Cheryl Loyd"
				(= seconds 12)
			)
			(3
				(localproc_0)
				(Display 673 4 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Artists"
				(Display 673 4 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Artists"
				(Display 673 7 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Gerald Moore Cheryl Sweeney Eric Kasner Richard Powell Phyllis Cucchiara Terrence Falls"
				(Display 673 7 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Gerald Moore Cheryl Sweeney Eric Kasner Richard Powell Phyllis Cucchiara Terrence Falls"
				(Display 673 8 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Daryle Smith Jerry Jessurun Frances Powell Hector Martinez Richard D. Zeigler-Martin"
				(Display 673 8 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Daryle Smith Jerry Jessurun Frances Powell Hector Martinez Richard D. Zeigler-Martin"
				(= seconds 8)
			)
			(4
				(localproc_0)
				(Display 673 9 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Programmed by:"
				(Display 673 9 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Programmed by:"
				(Display 673 10 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Dan Carver Chris Hoyt Doug Oldfield Carlos Escobar Oliver Brelsford"
				(Display 673 10 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Dan Carver Chris Hoyt Doug Oldfield Carlos Escobar Oliver Brelsford"
				(= seconds 10)
			)
			(5
				(localproc_0)
				(Display 673 11 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Music Director"
				(Display 673 11 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Music Director"
				(Display 673 12 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Mark Seibert"
				(Display 673 12 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Mark Seibert"
				(= seconds 4)
			)
			(6
				(localproc_0)
				(Display 673 13 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Development System"
				(Display 673 13 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Development System"
				(Display 673 14 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Robert E. Heitman Jeff Stephenson Dan Foy Larry Scott J. Mark Hood Eric Hart Mark Wilden Chris Smith"
				(Display 673 14 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Robert E. Heitman Jeff Stephenson Dan Foy Larry Scott J. Mark Hood Eric Hart Mark Wilden Chris Smith"
				(Display 673 15 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Terry McHenry Chad Bye Ken Koch John Rettig John Crane Steven Coallier Randy Moss"
				(Display 673 15 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Terry McHenry Chad Bye Ken Koch John Rettig John Crane Steven Coallier Randy Moss"
				(= seconds 12)
			)
			(7
				(localproc_0)
				(Display 673 16 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Additional Musicians   Sound Effects"
				(Display 673 16 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Additional Musicians   Sound Effects"
				(Display 673 17 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Rob Atesalp Chris Braymen  Orpheus Hanley"
				(Display 673 17 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Rob Atesalp Chris Braymen  Orpheus Hanley"
				(= seconds 4)
			)
			(8
				(localproc_0)
				(gTheIconBar enable:)
				(gTheIconBar disable: 0 1 2 3)
				(Display 673 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 673 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 673 19 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Narrator - Art Lewicki Graham - Josh Mandel Cedric - Richard Aronson Crispin - Leonard "Ray" Bergeron Mordack - Andy Hoyos Cassima - Dianah Pressley Alexander - Barry T. Smith Alicia - Diana Wilson"
				(Display 673 19 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Narrator - Art Lewicki Graham - Josh Mandel Cedric - Richard Aronson Crispin - Leonard "Ray" Bergeron Mordack - Andy Hoyos Cassima - Dianah Pressley Alexander - Barry T. Smith Alicia - Diana Wilson"
				(= seconds 10)
			)
			(9
				(localproc_0)
				(Display 673 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 673 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 673 20 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Willow - Diana Wilson Herbert - Gregory James Thomas Gnome - Gregory James Thomas Beetrice - Dianah Pressley Antony - Dan Long Amanda - Roberta Williams Gypsy Man - Ken Allen Fortune Teller - Sara Long"
				(Display 673 20 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Willow - Diana Wilson Herbert - Gregory James Thomas Gnome - Gregory James Thomas Beetrice - Dianah Pressley Antony - Dan Long Amanda - Roberta Williams Gypsy Man - Ken Allen Fortune Teller - Sara Long"
				(= seconds 10)
			)
			(10
				(localproc_0)
				(Display 673 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 673 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 673 21 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Toymaker - Leonard "Ray" Bergeron Toymakers Son - Barry T. Smith Toymakers Granddaughter - Kristen Hoyos Austin - Kevin Orcutt Boy in Town -Kevin Orcutt Tailor - DJ Williams Shoemaker - Dan Long Shoemaker's Wife - Sarah Long"
				(Display 673 21 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Toymaker - Leonard "Ray" Bergeron Toymakers Son - Barry T. Smith Toymakers Granddaughter - Kristen Hoyos Austin - Kevin Orcutt Boy in Town -Kevin Orcutt Tailor - DJ Williams Shoemaker - Dan Long Shoemaker's Wife - Sarah Long"
				(= seconds 10)
			)
			(11
				(localproc_0)
				(Display 673 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 673 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 673 22 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Woman in Town - Roberta Williams Man in Town - Barry T. Smith Baker - Dick Roberts Bakers Brother - Dick Roberts Witch - Sarah Long Elf - Nancy Zdenek Innkeeper - Leonard "Ray" Bergeron Innkeeper's Pal - Josh Mandel"
				(Display 673 22 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Woman in Town - Roberta Williams Man in Town - Barry T. Smith Baker - Dick Roberts Bakers Brother - Dick Roberts Witch - Sarah Long Elf - Nancy Zdenek Innkeeper - Leonard "Ray" Bergeron Innkeeper's Pal - Josh Mandel"
				(= seconds 10)
			)
			(12
				(localproc_0)
				(Display 673 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 673 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 673 23 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Eagle - Barry T. Smith Icebella - Lori Ann Cole Sir Greywolf - Frederic Gott Hermit - Bill Davis Harpy - Roberta Williams Harpy - Nancy Zdenek Harpy - Barbara Eicker Harpy - Josh Mandel"
				(Display 673 23 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Eagle - Barry T. Smith Icebella - Lori Ann Cole Sir Greywolf - Frederic Gott Hermit - Bill Davis Harpy - Roberta Williams Harpy - Nancy Zdenek Harpy - Barbara Eicker Harpy - Josh Mandel"
				(= seconds 10)
			)
			(13
				(localproc_0)
				(Display 673 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 673 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 673 24 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Rocky, The Rock Creature - Barry T. Smith Dink - Barry T. Smith Irate Customer in Tailor Shop - Guruka Singh Khalsa Bandit Leader - Stuart Moulder The Genie - Mark Seibert The Rat - Roberta Williams The Snake - Mark Seibert The Cat - Guruka Singh Khalsa"
				(Display 673 24 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Rocky, The Rock Creature - Barry T. Smith Dink - Barry T. Smith Irate Customer in Tailor Shop - Guruka Singh Khalsa Bandit Leader - Stuart Moulder The Genie - Mark Seibert The Rat - Roberta Williams The Snake - Mark Seibert The Cat - Guruka Singh Khalsa"
				(= seconds 10)
			)
			(14
				(localproc_0)
				(Display 673 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Voice Talent"
				(Display 673 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Voice Talent"
				(Display 673 25 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Rosella - Diana Wilson Singing Willow Tree - Debbie Seibert Singing Ants - Mark Seibert"
				(Display 673 25 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Rosella - Diana Wilson Singing Willow Tree - Debbie Seibert Singing Ants - Mark Seibert"
				(= seconds 5)
			)
			(15
				(localproc_0)
				(Display 673 26 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Special Thanks To"
				(Display 673 26 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Special Thanks To"
				(Display 673 27 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "J. Mark Hood"
				(Display 673 27 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "J. Mark Hood"
				(= seconds 5)
			)
			(16
				(localproc_0)
				(Display 673 28 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "Quality Assurance"
				(Display 673 28 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "Quality Assurance"
				(Display 673 29 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local10 dsFONT local8) ; "John Ratcliffe"
				(Display 673 29 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local9 dsFONT local8) ; "John Ratcliffe"
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

(instance syncIt of MonoAudioProp
	(properties)
)

