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
					{Japanese Messages#jEnglish Messages}
					2
					#mode
					1
				)
			)
			(2
				(if (== (gGame printLang:) 81)
					(gGame parseLang: 1 printLang: 1)
				else
					(gGame parseLang: 81 printLang: 81)
				)
				(proc0_14 global188)
			)
			(1
				(Printf 811 1 gVersion) ; "Roger Wilco and the Time Rippers     Space Quest \1d  Version %s"
				(Printf 811 2) ; "Scott and Mark really owe a lot to, and couldn't have done even 1 percent as well without the generous help of the following hard-working, self-sacrificing people who probably deserve a lot more money for their unreal efforts:"
				(Print 811 3) ; "THE IMAGE PEOPLE - Jon Bock, Jane Cardinal, Jeff Crowe, Desie Hartman, Eric Kasner, Jim Larsen, Nate "Nader" Larsen, Suzi Livengood, Cheryl Loyd, Michael A. Milo, Gerald Moore, Jennifer Schontz, Cheryl Sweeney, Willis Wong THE MUSIC MASTERS - Ken Allen, Rob Atesalp, Mark Seibert THE DEVELOPMENT SYSTEM PEOPLE - Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, J. Mark Hood, Larry Scott, Dan Foy, Mark Wilden, Eric Hart, Terry McHenry, John Rettig, Corey Cole, John Hartin"
				(Print 811 4) ; "ADDITIONAL MATERIAL/SPECIAL CONTRIBUTIONS- Josh Mandel, Doug Oldfield, Brian K. Hughes, Oliver Brelsford THE ROLE OF ROGER WILCO - Jim ("Why am I doing this?") Larsen THE PROGRAMMERS WHO MANAGE TO MAKE ALL THIS CRAP WORK - Oliver Brelsford, Carlos Escobar, Brian K. Hughes, Mike (just another) Larsen, Randy MacNeill, Doug Oldfield, Raoul Said, Jerry Shaw"
				(Print 811 5) ; "A NOTE FROM THE DESIGNERS: Please disregard the 3 previous windows of text. A few loose-cannon programmers thought the world needed to see their names a whole lot more often. We apologize for any inconvenience these falsely inflated egos might have caused. Anyway, they've been dealt with (killed). We now return you to the game."
			)
		)
	)
)

