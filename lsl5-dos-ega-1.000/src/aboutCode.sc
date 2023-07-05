;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use DCIcon)
(use Motion)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [string 200])
		(Load rsVIEW 993)
		(TPrint 15 0 33 gSmallFont 30 1 70 222 80 {Sierra Presents}) ; ""Leisure Suit Larry 5: Passionate Patti Does A Little Undercover Work" Executive Producer Ken Williams Creative Director Bill Davis Director Al Lowe Producer Guruka Singh Khalsa"
		(cycleIcon loop: 2)
		(TPrint 15 1 33 gSmallFont 30 1 82 cycleIcon 70 180 80 {The Bosses}) ; "Game Designer Al Lowe Production Designer Andy Hoyos Art Designer Jane Cardinal Lead Programmer Brian K. Hughes Composer Craig Safan Art Team Manager Cheryl Loyd"
		(cycleIcon loop: 3)
		(TPrint 15 2 33 gSmallFont 30 1 82 cycleIcon 70 200 80 {The Workers}) ; "Animators Cheryl Loyd, Barry T. Smith, Roger Hardy, Jr., Dana M. Dean, Karin Young, Marc Hudgins, Eric Kasner, Richard Powell, Phyllis Cucchiara, Terry Falls, Michael Hutchison, Desie Hartman, and Willis Wong Background Artists Jane Cardinal, Maurice Morgan, Andy Hoyos, Cheryl Loyd, Jay Friedman, Jennifer Shontz, and Gloria Garland Programmers Brian K. Hughes, Carlos Escobar, Steve Conrad, John Hartin, Oliver Brelsford, and Al Lowe"
		(cycleIcon loop: 1)
		(TPrint ; "Music Director Mark Seibert Composer Craig Safan Additional Music Chris Braymen Theme Song Composed by Al Lowe"
			15
			3
			33
			gSmallFont
			30
			1
			82
			cycleIcon
			70
			200
			80
			{The Boys in the Band}
		)
		(cycleIcon loop: 0)
		(Format @string 15 4 gVersion gVersionDate) ; "Written Exclusively in S.C.I. "Sierra's Creative Interpreter" System Programmers Jeff Stephenson, Robert E. Heitman, Dan Foy, Larry Scott, John Rettig, J. Mark Hood, Chris Smith, Terry McHenry, Eric Hart, Chad Bye, Mark Wilden, Ken Koch, John Crane, Steve Coallier, and Randy Moss Quality Assurance Robin Bradley Joe Perry Additional Written Material Josh Mandel Version %s %s"
		(TPrint @string 33 gSmallFont 30 1 82 cycleIcon 70 222 80 {The Hackers})
		(Format @string 15 5 gVersionPhone gVersionIntPhone) ; "If you're having a good time playing this game and would like to order other fun products from the Sierra family of computer games, just give our Order Desk a telephone call at %s. (International customers call %s.) Our friendly and courteous order takers are probably sitting around doing nothing right now and would love to have someone to talk to!"
		(TPrint
			@string
			33
			gSmallFont
			30
			1
			70
			222
			80
			{A Paid Commercial Announcement}
		)
		(TPrint 15 6 33 gSmallFont 30 1 70 266 80 {More Laffer Laughs}) ; "You'll also want to order spare copies of all these other lovable Larry Laffer mis-adventures: "Leisure Suit Larry In the Land of the Lounge Lizards," "Leisure Suit Larry Goes Looking for Love (in Several Wrong Places)," "Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals," "Leisure Suit Larry 4: The Missing Floppies," and "The Laffer Utilities," a collection of silly little programs designed just for fun at the office. (Well, maybe you shouldn't order your copies of Larry4 just yet; we seem to have misplaced our master disks.)"
		(TPrint 15 7 33 gSmallFont 30 1 70 234 80 {Discontinued Products}) ; "Besides the Larry series, Al Lowe has written these other fine Sierra games: "Bop-A-Bet," "Dragon's Keep," "Troll's Tale," "The Gelfling Adventure," "The Black Cauldron," "Winnie the Pooh in the Hundred Acre Woods," and "Donald Duck's Playground.""
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

