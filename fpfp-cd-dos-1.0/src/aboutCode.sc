;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	aboutCode 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(Print mode: 1 ticks: (* gTextSpeed 10) addText: 2 0 0 param1 0 0 13)
	(= temp0 (Print dialog:))
	(Print
		addIcon:
			910
			param2
			0
			(-
				(/ (+ (temp0 nsLeft:) (temp0 nsRight:)) 2)
				(+ (/ (CelWide 910 param2) 2) 5)
			)
			(cond
				((OneOf param2 2 3) 60)
				((== param2 4) 50)
				((== param2 5) 35)
				(else 30)
			)
		init:
	)
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 300])
		(Load rsVIEW 910)
		(= gNormalCursor ((gTheIconBar curIcon:) cursor:))
		(gGame setCursor: 998)
		(= global134 20)
		(gSystemWindow color: 0 back: 20)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 1 0 0 13 ; "FREDDY PHARKAS, FRONTIER PHARMACIST is brought to you in living VGA by the hombres out at Sierra On-Line, Inc. and Screw Loose Amusements."
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 2 40 0 13 ; "Designed and written by  Al Lowe and Josh Mandel"
					addIcon: 910 0 0 0 30
					addIcon: 910 1 0 105 30
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 3 1))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 4 2))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 5 3))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 6 4))
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 7 0 0 13 ; "Authentic Western\04  Audio Engineering by   Dan Kehler,  Rick Spurgeon,  and Kelli Spurgeon"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 8 0 0 13 ; "Authentic Western\04 Voices by   Cam Clarke as Freddy Pharkas  Neil Ross as The Narrator  Kath Soucie as Penelope Primm  Lewis Arquette as Whittlin' Willy  Michael Gough as Kenny the Kid"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 9 0 0 13 ; "Authentic Western\04 Voices by   Jan Rabson as Sam Andreas  Richard Paul as Chester Field  Susan Silo as Helen Back  Nicolas Guest as Srini  Lewis Arquette as P. H. Balance"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 10 0 0 13 ; "Authentic Western\04 Voices by   Jan Rabson as Wheaton "Aces" Hall  Michael Gough as Salvatore O'Hannahan  Susan Silo as Madame Ovaree  Nicolas Guest as Hop Singh"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 11 0 0 13 ; "Authentic Western\04 Voices by   Bill Bryant as Doc Gillespie  Jocko Marcellino as Smithie  Richard Paul as Sheriff "Chicken" Shift  Jan Rabson as Diamond Jim Laffer"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 12 0 0 13 ; "Authentic Western\04  Voice Direction by   Al Lowe"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 13 0 0 13 ; "Authentic Western\04  Voiceovers Produced by   Dan Kehler"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 14 0 0 13 ; "Authentic Western\04  Music & Sounds by   Aubrey Hodges"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 15 5))
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 16 0 0 13 ; "Additional Animation and Mondo Thanks To:   Jeff Crowe,  Joan Delehanty,  Maria Fruehe,  Gloria Garland,  Michael Hutchison,  Tony Margioni,  Jerry Moore,  Cindy Walker,  Chris "Smokehouse" Willis,  and Deanna Yhalkee"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 17 0 0 13 ; "Special Guest Programming by   Doug Oldfield,  Carlos Escobar,  and Brian K. Hughes"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 18 0 0 13 ; "Customer Service Liaisonin' by   Larry Buchanan  and Mike Weiner"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 19 0 0 13 ; "Systems Programming by   Vana Baker, Ed Critchlow,  Dan Foy, J. Mark Hood,  Brian K. Hughes, Ken Koch,  Jack Magne, Terry McHenry,  Martin Peters, Larry Scott,  Christopher Smith, and Mark Wilden"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 20 0 0 13 ; "Special Thanks To:   Bob Ballew, Donovan Holmes,  Jeff & Jon Martin, Rick Spurgeon,  Nathan Gams, Alan Mandel,  and the Freddy Pharkas Beta Testers"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 21 0 0 13 ; "If you're not enjoying FREDDY PHARKAS, FRONTIER PHARMACIST, you will no doubt also dislike Al Lowe's other groundbreaking comedy adventure games:"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 22 0 0 13 ; "|c0|Leisure Suit Larry in the Land of the Lounge Lizards,|c| |c1|Leisure Suit Larry 2: Leisure Suit Larry Goes Looking For Love (In Several Wrong Places),|c| |c2|Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals,|c| |c0|Leisure Suit Larry 5: Passionate Patti Does a Little Undercover Work,|c| and |c3|Leisure Suit Larry 6: Shape Up or Slip Out!|c|"
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 23 0 0 13 ; "These and all the other fine Sierra products (including the handy six-pack of FREDDY PHARKAS, FRONTIER PHARMACIST), are available from Sierra. See your Game Manual."
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 24 0 0 13 ; "Hints are available on our 24-hour Automated Hint Line. See your Game Manual."
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 25 0 0 13 ; "Hint Books may be purchased from our Sales Department. See your Game Manual."
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 26 0 0 13 ; "Our Customer Support people can help you with your technical problems, disk replacements, etc. See your Game Manual."
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					mode: 1
					font: gUserFont
					ticks: (* gTextSpeed 10)
					addText: 2 0 0 27 0 0 13 ; "This half-hour infomercial has been brought to you by Screw Loose Amusements, the Freddy Pharkas team. Now back to the game, already in progress."
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(self dispose:)
	)

	(method (dispose)
		(Print ticks: -1)
		(= global134 34)
		(gSystemWindow color: 0 back: 34)
		(gGame setCursor: gNormalCursor)
		(DisposeScript 13)
	)
)

