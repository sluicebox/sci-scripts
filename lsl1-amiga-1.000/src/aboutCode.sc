;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 811)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	aboutCode 0
)

(local
	local0
	[local1 500]
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp string)
		((ScriptID 0 24) view: 856 loop: 0 cycleSpeed: (* (+ global101 1) 4)) ; deathIcon
		(Print 811 0 #font gSmallFont #mode 1 #width 200 #title {Sierra Presents}) ; ""Leisure Suit Larry 1: in the Land of the Lounge Lizards" Executive Producer Ken Williams Creative Director Bill Davis Director Al Lowe Producer Stuart Moulder"
		(Print ; "Game Designer Al Lowe Art Designer William Skirvin Lead Programmer Oliver Brelsford Composer Chris Braymen"
			811
			1
			#font
			gSmallFont
			#mode
			1
			#icon
			(ScriptID 0 24) ; deathIcon
			70
			200
			#title
			{Sierra Presents}
		)
		(Print 811 2 #font gSmallFont #mode 1 #width 200 #title {Sierra Presents}) ; "Animators Barry Smith, Jennifer Shontz, Roger Hardy Jr., William D. Skirvin, Eric Apel, Russ Truelove, and Desie Hartman Background Artists William D. Skirvin, Jay Allan Friedmann, Jennifer Shontz, Jane Cardinal, and Maurice Morgan Programmers Oliver Brelsford, Mike Larsen and Al Lowe Witty Text and Documentation Josh Mandel"
		(Print 811 3 #font gSmallFont #mode 1 #width 200 #title {Sierra Presents}) ; "Music Director Mark Seibert Sound Effects Chris Braymen, Mark Seibert and Orpheus Hanley Theme Song Composed by Al Lowe Some tunes written by dead guys (and you know who you are!)"
		(Print
			(Format @local1 811 4 gVersion) ; "Written Exclusively in S.C.I. "Sierra's Creative Interpreter" System Programmers J. Mark Hood, Jeff Stephenson, Bob Heitman Pablo Ghenis, Dan Foy, Larry Scott, Mark Wilden, Eric Hart, Chris Smith, John Rettig, Steven Coallier, and Randy Moss. Quality Assurance Gary Cox, Robin Bradley, Mike Pickhinke, Keri Cooper, and Joe Perry Version %s, July 4, 1991"
			#font
			gSmallFont
			#mode
			1
			#width
			222
			#title
			{Sierra Presents}
		)
		(Print ; "Having fun? Want to have more fun? For another "real good time," just dial Sierra On-Line's Order Desk at 800 326-6654 International customers call 209 683-4468 They have lots more games available and all of them are better than this!"
			811
			5
			#font
			gSmallFont
			#mode
			1
			#width
			222
			#title
			{A Paid Commercial Announcement}
		)
		(Print
			(cond
				((LarryHours)
					(Format ; "How could you play for %d hour%s, %d minute%s and %d second%s and only score %d point%s?!"
						@local1
						811
						6
						(LarryHours)
						(if (== (LarryHours) 1) {} else {s})
						(LarryMinutes)
						(if (== (LarryMinutes) 1) {} else {s})
						(LarrySeconds)
						(if (== (LarrySeconds) 1) {} else {s})
						gScore
						(if (== gScore 1) {} else {s})
					)
				)
				(gScore
					(Format ; "You've been playing this game for %d minute%s and %d second%s and you've only scored %d point%s?!"
						@local1
						811
						7
						(LarryMinutes)
						(if (== (LarryMinutes) 1) {} else {s})
						(LarrySeconds)
						(if (== (LarrySeconds) 1) {} else {s})
						gScore
						(if (== gScore 1) {} else {s})
					)
				)
				(else
					(Format ; "You've been playing this game for %d minute%s and %d second%s and you haven't scored a single point?"
						@local1
						811
						8
						(LarryMinutes)
						(if (== (LarryMinutes) 1) {} else {s})
						(LarrySeconds)
						(if (== (LarrySeconds) 1) {} else {s})
					)
				)
			)
			#font
			gSmallFont
			#title
			{You've Only Just Begun}
		)
		(Print 811 9 #font gSmallFont) ; "Get a life!"
	)
)

