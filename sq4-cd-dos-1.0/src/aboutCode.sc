;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 811)
(include sci.sh)
(use Main)
(use Sq4Dialog)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp temp0 [temp1 600] [temp601 600])
		(= temp0 (gGame setCursor: 999 1))
		(Message msgGET 811 97 0 1 1 @temp1) ; "Roger Wilco and the Time Rippers Space Quest IV  Version %s  Scott and Mark really owe a lot to, and couldn't have done even 1 percent as well without the generous help of the following hard-working, self-sacrificing people who probably deserve a lot more money for their unreal efforts:"
		(Format @temp601 @temp1 gVersion)
		(proc816_1 @temp601)
		(Message msgGET 811 97 0 2 1 @temp1) ; "THE IMAGE PEOPLE - Jon Bock, Jane Cardinal, Dana Dean, Max Deardorff, Karin A. Young, Donald Waller, Jeff Crowe, Desie Hartman, Eric Kasner, Jim Larsen, Max Deardorff, Nate Larsen, Suzi Livengood, Cheryl Loyd, Michael A. Milo, Gerald Moore, Jennifer Schontz, Cheryl Sweeney, Willis Wong   THE MUSIC MASTERS - Ken Allen, Rob Atesalp, Mark Seibert, Orpheus Hanley, Rick Spurgeon, Aubrey Hodges   THE DEVELOPMENT SYSTEM PEOPLE - Jeff Stephenson, Robert E. Heitman, Pablo Ghenis, J. Mark Hood, Larry Scott, Dan Foy, Mark Wilden, Eric Hart, Terry McHenry, Ken Koch, Chris Smith, Jack Magne, Martin Peters"
		(proc816_1 @temp1)
		(Message msgGET 811 97 0 3 1 @temp1) ; "ADDITIONAL MATERIAL/SPECIAL CONTRIBUTIONS- Josh Mandel, Brian K. Hughes, Oliver Brelsford  THE PROGRAMMERS WHO MANAGE TO MAKE ALL THIS CRAP WORK - Dan Carver, Neil (the guy who likes to make vols) Matz, Robert Andrews, Oliver Brelsford, Carlos Escobar, Brian K. Hughes, Randy MacNeill, Doug Oldfield, Raoul Said, Jerry Shaw, Max Deardorff  Q.A. SPECIMENS - Bill Hilton, Matt Genesi  Special Thanks to "Neil and Bob" for getting me "up" when I was "down.""
		(proc816_1 @temp1)
		(Message msgGET 811 97 0 4 1 @temp1) ; "A NOTE FROM THE DESIGNERS:  Please disregard the 3 previous windows of text. A few loose-cannon programmers thought the world needed to see their names a whole lot more often. We apologize for any inconvenience these falsely inflated egos may have caused. Anyway, they've been dealt with (killed). We now return you to the game."
		(proc816_1 @temp1)
		(gGame setCursor: temp0 1)
	)
)

