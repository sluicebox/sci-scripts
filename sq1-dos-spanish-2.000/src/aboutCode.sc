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

(instance aboutCode of Code
	(properties)

	(method (doit &tmp temp0)
		(switch
			(= temp0
				(Print ; "Space Quest IV"
					811
					0
					#button
					{About SQIV}
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
				(if (== (gGame printLang:) global190)
					(gGame printLang: 1)
				else
					(gGame printLang: global190)
				)
			)
			(1
				(Printf 811 1 gVersion gVersion) ; "Space Quest \1d Roger Wilco in The Sarien Encounter The First in the Semi-popular Series Version %s The following hard-working, self-sacrificing people, who probably deserve a lot more money for their unreal efforts, made this thing possible:"
				(Print 811 2) ; "THE ARTISTS - Doug Herring, Vasken Nokhoudian, Nate Larsen, Arturo Sinclair, Deena Krutak, Eric Kasner, Desie Hartman, Willis Wong, Jerry Jessurun, Russ Truelove, Jay Friedman, Diana Wilson, Jennifer Shontz, Andy Hoyos, Jane Cardinal, Maurice F. Morgan. MUSIC/SOUND EFFECTS - Ken Allen, Mark Seibert, Orpheus Hanley. SYSTEM DEVELOPMENT - Mark Hood, Chris Smith, Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, Dan Foy, Larry Scott, Mark Wilden, Eric Hart, Chad Bye."
				(Print 811 3) ; "ADDITIONAL MATERIAL/SPECIAL CONTRIBUTIONS - Bridget McKenna, Gano Haine, Doug Herring, Jerry Shaw. THE NEARLY INCREDIBLE PROGRAMMERS - Jerry Shaw, Randy MacNeil, Dave Jamriska, Hugh Diedrichs. AMIGA IMPLEMENTATION - Steve Coallier, Jerry Shaw"
			)
		)
	)
)

