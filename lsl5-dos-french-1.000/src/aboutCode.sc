;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use Motion)
(use System)

(public
	aboutCode 0
)

(local
	[local0 745]
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp string)
		(Load rsVIEW 993)
		(switch
			(= string
				(Print ; "Leisure Suit Larry 5"
					15
					0
					#button
					{About LSL5}
					1
					#button
					{Cancel}
					0
					#button
					{Foreign Displays}
					2
					#mode
					1
				)
			)
			(2
				(if (== (gGame printLang:) 33)
					(gGame parseLang: 1 printLang: 1)
				else
					(gGame parseLang: 33 printLang: 33)
				)
			)
			(1
				(TPrint ; ""Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work" Executive Producer Ken Williams Creative Director Bill Davis Director Al Lowe Producer Guruka Singh Khalsa"
					15
					1
					#font
					gSmallFont
					#mode
					1
					#width
					222
					#title
					{Sierra Presents}
				)
				(cycleIcon loop: 2)
				(TPrint ; "Game Designer Al Lowe Production Designer Andy Hoyos Art Designer Jane Cardinal Lead Programmer Brian K. Hughes Composer Craig Safan Art Team Manager Cheryl Loyd"
					15
					2
					#font
					gSmallFont
					#mode
					1
					#icon
					cycleIcon
					70
					180
					#title
					{The Bosses}
				)
				(cycleIcon loop: 3)
				(TPrint ; "Animators Cheryl Loyd, Barry T. Smith, Roger Hardy, Jr., Dana M. Dean, Karin Young, Marc Hudgins, Eric Kasner, Richard Powell, Phyllis Cucchiara, Terry Falls, Michael Hutchison, Desie Hartman, and Willis Wong"
					15
					3
					#font
					gSmallFont
					#mode
					1
					#icon
					cycleIcon
					70
					200
					#title
					{The Workers}
				)
				(TPrint ; "Background Artists Jane Cardinal, Maurice Morgan, Andy Hoyos, Cheryl Loyd, Jay Friedman, Jennifer Shontz, and Gloria Garland"
					15
					4
					#font
					gSmallFont
					#mode
					1
					#icon
					cycleIcon
					70
					200
					#title
					{The Workers}
				)
				(TPrint ; "Programmers Brian K. Hughes, Carlos Escobar, Steve Conrad, John Hartin, Oliver Brelsford, and Al Lowe"
					15
					5
					#font
					gSmallFont
					#mode
					1
					#icon
					cycleIcon
					70
					200
					#title
					{The Workers}
				)
				(TPrint ; "Foreign Languages Programmers Gary Kamigawachi Sean T. Mooney William R. Shockley"
					15
					6
					#font
					gSmallFont
					#mode
					1
					#icon
					cycleIcon
					70
					200
					#title
					{The Workers}
				)
				(cycleIcon loop: 1)
				(TPrint ; "Music Director Mark Seibert Composer Craig Safan Additional Music Chris Braymen Theme Song Composed by Al Lowe"
					15
					7
					#font
					gSmallFont
					#mode
					1
					#icon
					cycleIcon
					70
					200
					#title
					{The Boys in the Band}
				)
				(cycleIcon loop: 0)
				(Format @local0 15 8 gVersion gVersionDate gVersion gVersionDate) ; "Written Exclusively in S.C.I. "Sierra's Creative Interpreter" System Programmers Jeff Stephenson, Robert E. Heitman, Dan Foy, Larry Scott, John Rettig, J. Mark Hood, Chris Smith, Terry McHenry, Eric Hart, Chad Bye, Mark Wilden, Ken Koch, John Crane, Steve Coallier, and Randy Moss Quality Assurance Bill Davis Jr. Joe Carper Additional Written Material Josh Mandel Version %s %s"
				(TPrint
					@local0
					#font
					gSmallFont
					#mode
					1
					#icon
					cycleIcon
					70
					222
					#title
					{The Hackers}
				)
				(Format @local0 15 9 gVersionPhone gVersionIntPhone gVersionPhone gVersionIntPhone) ; "If you're having a good time playing this game and would like to order other fun products from the Sierra family of computer games, just give our Order Desk a telephone call at %s. (International customers call %s.) Our friendly and courteous order takers are probably sitting around doing nothing right now and would love to have someone to talk to!"
				(TPrint
					@local0
					#font
					gSmallFont
					#mode
					1
					#width
					222
					#title
					{A Paid Commercial Announcement}
				)
				(switch (gGame printLang:)
					(1
						(TPrint ; "You'll also want to order spare copies of all these other lovable Larry Laffer mis-adventures: "Leisure Suit Larry In the Land of the Lounge Lizards," "Leisure Suit Larry Goes Looking for Love (in Several Wrong Places)," "Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals," "Leisure Suit Larry 4: The Missing Floppies," and "The Laffer Utilities," a collection of silly little programs designed just for fun at the office. (Well, maybe you shouldn't order your copies of Larry 4 just yet; we seem to have misplaced our master disks.)"
							15
							10
							#font
							gSmallFont
							#mode
							1
							#width
							266
							#title
							{More Laffer Laughs}
						)
					)
					(33
						(TPrint ; "Vous devriez aussi commander des copies des autres (m\82s)aventures d\82sopilantes de Larry Laffer: "Leisure Suit Larry In the Land of the Lounge Lizards," "Leisure Suit Larry Goes Looking for Love (in Several Wrong Places)," "Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals," "Leisure Suit Larry 4: The Missing Floppies," et "The Laffer Utilities," une petite collection de programmes utilititaires agr\82ables \85 utiliser \85 la maison ou au bureau. (Peut-\88tre que vous devriez attendre un peu avant de commander votre copie de Larry 4. On n'arrive pas \85 mettre la main sur nos propre disquettes originales!)"
							15
							11
							#font
							gSmallFont
							#mode
							1
							#width
							266
							#title
							{Plus de `Laffer' Rire}
						)
					)
				)
				(TPrint ; "Besides the Larry series, Al Lowe has written these other fine Sierra games: "Bop-A-Bet," "Dragon's Keep," "Troll's Tale," "The Gelfling Adventure," "The Black Cauldron," "Winnie the Pooh in the Hundred Acre Woods," and "Donald Duck's Playground.""
					15
					12
					#font
					gSmallFont
					#mode
					1
					#width
					234
					#title
					{Discontinued Products}
				)
			)
		)
	)
)

(instance cycleIcon of DCIcon
	(properties
		view 993
		cycleSpeed 15
	)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

