;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use AudioScript)
(use Sync)
(use Game)
(use Actor)
(use System)

(public
	rm701 0
)

(local
	local0
	local1
	[local2 8]
	local10
	local11
	local12
)

(procedure (localproc_0)
	(DrawPic local0 9 0)
)

(instance rm701 of Rm
	(properties)

	(method (init)
		(= local0 2050)
		(self picture: 2050 yourself: setScript: closingCartoon)
		(if global159
			(= local11 7)
			(= local12 0)
			(= local10 1)
		else
			(= local11 15)
			(= local12 0)
			(= local10 0)
		)
		(super init: &rest)
	)
)

(instance closingCartoon of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				((ScriptID 763) doit:) ; cartoonCode
				(= cycles 1)
			)
			(2
				(HandsOff)
				(++ local0)
				(syncIt init: setCycle: MouthSync 10121 hide:)
				(gGlobalAudio number: 10121 play:)
				(= waitForCue 8960)
			)
			(3
				(doDrawPic doit:)
				(= waitForCue 10752)
			)
			(4
				(doDrawPic doit:)
				(= waitForCue 11264)
			)
			(5
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10122 hide:)
				(gGlobalAudio number: 10122 play:)
				(= waitForCue 12804)
			)
			(6
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10123 hide:)
				(gGlobalAudio number: 10123 play:)
				(= waitForCue 15360)
			)
			(7
				(doDrawPic doit:)
				(= waitForCue 15872)
			)
			(8
				(doDrawPic doit:)
				(= waitForCue 16896)
			)
			(9
				(doDrawPic doit:)
				(gGlobalAudio number: 10124 play: self)
			)
			(10
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10125 hide:)
				(gGlobalAudio number: 10125 play:)
				(= waitForCue 5888)
			)
			(11
				(doDrawPic doit:)
				(= waitForCue 6656)
			)
			(12
				(doDrawPic doit:)
				(= waitForCue 10496)
			)
			(13
				(doDrawPic doit:)
				(= waitForCue 12800)
			)
			(14
				(doDrawPic doit:)
				(= cycles 1)
			)
			(15
				(doDrawPic doit:)
				(= waitForCue 14336)
			)
			(16
				(doDrawPic doit:)
				(= cycles 1)
			)
			(17
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10126 hide:)
				(gGlobalAudio number: 10126 play:)
				(= waitForCue 15104)
			)
			(18
				(doDrawPic doit:)
				(= waitForCue 15616)
			)
			(19
				(doDrawPic doit:)
				(= local0 2067)
				(gCurRoom setScript: creditsScript)
			)
		)
	)
)

(instance creditsScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 60])
		(switch (= state newState)
			(0
				(Display 701 0 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Your score:"
				(Display 701 0 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Your score:"
				(Display
					(Format @temp0 701 1 gScore gPossibleScore) ; "%d out of %d possible."
					dsCOORD
					90
					80
					dsWIDTH
					140
					dsALIGN
					alCENTER
					dsCOLOR
					local12
					dsFONT
					local10
				)
				(Display
					(Format @temp0 701 1 gScore gPossibleScore) ; "%d out of %d possible."
					dsCOORD
					89
					79
					dsWIDTH
					140
					dsALIGN
					alCENTER
					dsCOLOR
					local11
					dsFONT
					local10
				)
				(= seconds 10)
			)
			(1
				(localproc_0)
				(Display 701 2 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Creative Consultant"
				(Display 701 2 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Creative Consultant"
				(Display 701 3 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "William D. Skirvin"
				(Display 701 3 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "William D. Skirvin"
				(= seconds 4)
			)
			(2
				(localproc_0)
				(Display 701 4 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Artists"
				(Display 701 4 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Artists"
				(Display 701 5 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice F. Morgan Vasken Nokhoudian Barry T. Smith"
				(Display 701 5 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Ernie Chan Douglas Herring Jeff Crowe William D. Skirvin Maurice F. Morgan Vasken Nokhoudian Barry T. Smith"
				(Display 701 6 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Deanna Yhalkee Jim Larsen Cheryl Loyd"
				(Display 701 6 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Cindy Walker Deena Krutak Dana Dean Roger Hardy, Jr. Deanna Yhalkee Jim Larsen Cheryl Loyd"
				(= seconds 12)
			)
			(3
				(localproc_0)
				(Display 701 4 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Artists"
				(Display 701 4 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Artists"
				(Display 701 7 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Gerald Moore Cheryl Sweeney Eric Kasner Richard Powell Phyllis Cucchiara Terrence Falls"
				(Display 701 7 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Gerald Moore Cheryl Sweeney Eric Kasner Richard Powell Phyllis Cucchiara Terrence Falls"
				(Display 701 8 dsCOORD 145 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Daryle Smith Jerry Jessurun Frances Powell Hector Martinez Richard D. Zeigler-Martin"
				(Display 701 8 dsCOORD 144 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Daryle Smith Jerry Jessurun Frances Powell Hector Martinez Richard D. Zeigler-Martin"
				(= seconds 8)
			)
			(4
				(localproc_0)
				(Display 701 9 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Programmed by:"
				(Display 701 9 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Programmed by:"
				(Display 701 10 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Dan Carver Chris Hoyt Doug Oldfield Carlos Escobar Oliver Brelsford"
				(Display 701 10 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Dan Carver Chris Hoyt Doug Oldfield Carlos Escobar Oliver Brelsford"
				(= seconds 10)
			)
			(5
				(localproc_0)
				(Display 701 11 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Music Director"
				(Display 701 11 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Music Director"
				(Display 701 12 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Mark Seibert"
				(Display 701 12 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Mark Seibert"
				(= seconds 4)
			)
			(6
				(localproc_0)
				(Display 701 13 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Development System"
				(Display 701 13 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Development System"
				(Display 701 14 dsCOORD 35 80 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Robert E. Heitman Jeff Stephenson Dan Foy Larry Scott J. Mark Hood Eric Hart Mark Wilden Chris Smith"
				(Display 701 14 dsCOORD 34 79 dsWIDTH 130 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Robert E. Heitman Jeff Stephenson Dan Foy Larry Scott J. Mark Hood Eric Hart Mark Wilden Chris Smith"
				(Display ; "Terry McHenry Chad Bye Ken Koch John Rettig John Crane Steven Coallier Randy Moss"
					701
					15
					dsCOORD
					145
					80
					dsWIDTH
					130
					dsALIGN
					alCENTER
					dsCOLOR
					local12
					dsFONT
					local10
				)
				(Display ; "Terry McHenry Chad Bye Ken Koch John Rettig John Crane Steven Coallier Randy Moss"
					701
					15
					dsCOORD
					144
					79
					dsWIDTH
					130
					dsALIGN
					alCENTER
					dsCOLOR
					local11
					dsFONT
					local10
				)
				(= seconds 12)
			)
			(7
				(localproc_0)
				(Display 701 16 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Additional Musicians   Sound Effects"
				(Display 701 16 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Additional Musicians   Sound Effects"
				(Display 701 17 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Rob Atesalp Chris Braymen  Orpheus Hanley"
				(Display 701 17 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Rob Atesalp Chris Braymen  Orpheus Hanley"
				(= seconds 4)
			)
			(8
				(localproc_0)
				(gTheIconBar enable:)
				(gTheIconBar disable: 0 1 2 3)
				(Display 701 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Voice Talent"
				(Display 701 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Voice Talent"
				(Display 701 19 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Narrator - Art Lewicki King Graham - Josh Mandel Cedric - Richard Aronson Crispin - Leonard "Ray" Bergeron Mordack - Andy Hoyos Princess Cassima - Dianah Pressley Prince Alexander - Barry T. Smith Princess Alicia - Diana Wilson"
				(Display 701 19 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Narrator - Art Lewicki King Graham - Josh Mandel Cedric - Richard Aronson Crispin - Leonard "Ray" Bergeron Mordack - Andy Hoyos Princess Cassima - Dianah Pressley Prince Alexander - Barry T. Smith Princess Alicia - Diana Wilson"
				(= seconds 10)
			)
			(9
				(localproc_0)
				(Display 701 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Voice Talent"
				(Display 701 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Voice Talent"
				(Display 701 20 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Willow Tree - Diana Wilson Prince Herbert - Gregory James Thomas Gnome - Gregory James Thomas Queen Beetrice - Dianah Pressley King Antony - Dan Long Amanda - Roberta Williams Gypsy Man - Ken Allen Fortune Teller - Sara Long"
				(Display 701 20 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Willow Tree - Diana Wilson Prince Herbert - Gregory James Thomas Gnome - Gregory James Thomas Queen Beetrice - Dianah Pressley King Antony - Dan Long Amanda - Roberta Williams Gypsy Man - Ken Allen Fortune Teller - Sara Long"
				(= seconds 10)
			)
			(10
				(localproc_0)
				(Display 701 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Voice Talent"
				(Display 701 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Voice Talent"
				(Display 701 21 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Toymaker - Leonard "Ray" Bergeron Toymaker's Son - Barry T. Smith Toymaker's Granddaughter - Kristen Hoyos Austin - Kevin Orcutt Boy in Town -Kevin Orcutt Tailor - D.J. Williams Shoemaker - Dan Long Shoemaker's Wife - Sarah Long"
				(Display 701 21 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Toymaker - Leonard "Ray" Bergeron Toymaker's Son - Barry T. Smith Toymaker's Granddaughter - Kristen Hoyos Austin - Kevin Orcutt Boy in Town -Kevin Orcutt Tailor - D.J. Williams Shoemaker - Dan Long Shoemaker's Wife - Sarah Long"
				(= seconds 10)
			)
			(11
				(localproc_0)
				(Display 701 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Voice Talent"
				(Display 701 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Voice Talent"
				(Display 701 22 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Woman in Town - Roberta Williams Man in Town - Barry T. Smith Baker - Dick Roberts Bakers Brother - Dick Roberts Witch - Sarah Long Elf - Nancy Zdenek Innkeeper - Leonard "Ray" Bergeron Innkeeper's Pal - Josh Mandel"
				(Display 701 22 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Woman in Town - Roberta Williams Man in Town - Barry T. Smith Baker - Dick Roberts Bakers Brother - Dick Roberts Witch - Sarah Long Elf - Nancy Zdenek Innkeeper - Leonard "Ray" Bergeron Innkeeper's Pal - Josh Mandel"
				(= seconds 10)
			)
			(12
				(localproc_0)
				(Display 701 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Voice Talent"
				(Display 701 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Voice Talent"
				(Display 701 23 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Eagle - Barry T. Smith Queen Icebella - Lori Ann Cole Sir Greywolf - Frederick Gott Hermit - Bill Davis Harpy - Roberta Williams Harpy - Nancy Zdenek Harpy - Barbara Eicker Harpy - Josh Mandel"
				(Display 701 23 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Eagle - Barry T. Smith Queen Icebella - Lori Ann Cole Sir Greywolf - Frederick Gott Hermit - Bill Davis Harpy - Roberta Williams Harpy - Nancy Zdenek Harpy - Barbara Eicker Harpy - Josh Mandel"
				(= seconds 10)
			)
			(13
				(localproc_0)
				(Display 701 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Voice Talent"
				(Display 701 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Voice Talent"
				(Display 701 24 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Rocky, The Rock Creature - Barry T. Smith Dink - Barry T. Smith Irate Customer in Tailor Shop - Guruka Singh Khalsa Bandit Leader - Stuart Moulder The Genie - Mark Seibert The Rat - Roberta Williams The Snake - Mark Seibert The Cat, Manannan - Guruka Singh Khalsa"
				(Display 701 24 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Rocky, The Rock Creature - Barry T. Smith Dink - Barry T. Smith Irate Customer in Tailor Shop - Guruka Singh Khalsa Bandit Leader - Stuart Moulder The Genie - Mark Seibert The Rat - Roberta Williams The Snake - Mark Seibert The Cat, Manannan - Guruka Singh Khalsa"
				(= seconds 10)
			)
			(14
				(localproc_0)
				(Display 701 18 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Voice Talent"
				(Display 701 18 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Voice Talent"
				(Display 701 25 dsCOORD 90 80 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Princess Rosella - Diana Wilson Singing Willow Tree - Debbie Seibert Singing Ants - Mark Seibert"
				(Display 701 25 dsCOORD 89 79 dsWIDTH 320 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Princess Rosella - Diana Wilson Singing Willow Tree - Debbie Seibert Singing Ants - Mark Seibert"
				(= seconds 5)
			)
			(15
				(localproc_0)
				(Display 701 26 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Special Thanks To"
				(Display 701 26 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Special Thanks To"
				(Display 701 27 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "J. Mark Hood"
				(Display 701 27 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "J. Mark Hood"
				(= seconds 5)
			)
			(16
				(localproc_0)
				(Display 701 28 dsCOORD 90 60 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "Quality Assurance"
				(Display 701 28 dsCOORD 89 59 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "Quality Assurance"
				(Display 701 29 dsCOORD 90 80 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local12 dsFONT local10) ; "John Ratcliffe"
				(Display 701 29 dsCOORD 89 79 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local11 dsFONT local10) ; "John Ratcliffe"
				(= seconds 5)
			)
			(17
				(localproc_0)
				(self init:)
			)
		)
	)
)

(instance syncIt of Prop
	(properties)

	(method (init)
		(if (not local1)
			(++ local1)
			(super init: &rest)
		)
	)
)

(instance doDrawPic of Code
	(properties)

	(method (doit)
		(DrawPic local0)
		(++ local0)
	)
)

