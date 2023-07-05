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
	hours
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [string 200])
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
			(Format @string 811 4 gVersion) ; "Written Exclusively in S.C.I. "Sierra's Creative Interpreter" System Programmers J. Mark Hood, Jeff Stephenson, Bob Heitman Pablo Ghenis, Dan Foy, Larry Scott, Mark Wilden, Eric Hart, and Chris Smith Quality Assurance Team Leaders Mike Pickhinke and Keri Cooper Version %s, June 26, 1991"
			#font
			gSmallFont
			#mode
			1
			#width
			222
			#title
			{Sierra Presents}
		)
		(Print
			(cond
				((LarryHours)
					(Format ; "How could you play for %d hour%s, %d minute%s and %d second%s and only score %d point%s?!"
						@string
						811
						5
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
						@string
						811
						6
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
						@string
						811
						7
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
		(Print 811 8 #font gSmallFont) ; "Get a life!"
	)
)

