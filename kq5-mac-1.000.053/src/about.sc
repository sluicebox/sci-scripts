;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 756)
(include sci.sh)
(use Interface)
(use System)

(public
	about 0
)

(local
	[local0 100]
)

(instance about of Code
	(properties)

	(method (doit &tmp temp0 [temp1 255])
		(switch
			(= temp0
				(Print ; "King's Quest V"
					756
					0
					#font
					1
					#button
					{About KQV}
					1
					#button
					{Help}
					2
					#button
					{Cancel}
					0
				)
			)
			(1
				(Format @temp1 756 1) ; "We pause now for Station Identification. This is Sierra On-Line, Inc., Oakhurst, California."
				(Print @temp1 #mode 1)
				(Print 756 2) ; "If you're enjoying KING'S QUEST V, we sincerely hope you'll enjoy our other 256-color Macintosh adventure games:"
				(Print 756 3 #width 210) ; "In SPACE QUEST IV: ROGER WILCO AND THE TIME RIPPERS, you step into the boots of intrepid space janitor Roger Wilco. Recruited by emmisaries from the future, Roger travels through time to Space Quests of the past and future in order to save his home planet from a computer brain gone mad."
				(Print 756 4 #width 210) ; "It's Roger's silliest, most mind-bending and irreverent adventure yet! And we're not just saying that because the Two Guys From Andromeda asked us to. We're saying it because it's true. So there."
				(Print 756 5 #width 210) ; "In LEISURE SUIT LARRY 5: PASSIONATE PATTI DOES A LITTLE UNDERCOVER WORK, you'll play the roles of both Larry Laffer and Passionate Patti. Larry's conducting auditions for the hostess of a controversial new TV show, and Patti's going undercover to root out corruption in the music industry. How their missions intercept is the stuff of which contemporary legends are made!"
				(Print 756 6 #width 210) ; "Al Lowe reaches new highs (or Lowes?) in comedy with LSL5, his first dual-role semi-political psychosociological adventure (and maybe his last!). Of course, we can't tell you about the REALLY good parts, since this preview has been rated G, for General audiences."
				(Print 756 7 #width 220) ; "From Dynamix comes RED BARON MAC, the WWI flight simulator that set new industry standards for flight combat games. Computer Gaming World dubbed RED BARON the "Simulator of the Year!" Battle the Aces, wage a campaign over the course of the war, and use the extensive VCR features to change, replay and "direct" your greatest battles. You, too, can change the course of history with RED BARON MAC!"
				(Print 756 8 #width 210) ; "SQ4-MAC, LSL5-MAC, and RED BARON MAC are available at your local software store, or directly through Sierra. Just give our toll-free number a call:         1-800-326-6654 Our hours are 7am to 9pm Pacific Time, Monday through Friday. In the UK and Europe, please call 0734-303322 (UK) for pricing and availability."
				(Print 756 9 #width 210) ; "Now back to King's Quest V, already in progress."
			)
			(2
				((ScriptID 753) doit:) ; help
			)
		)
	)
)

