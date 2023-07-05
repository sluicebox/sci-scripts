;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Game)

(public
	Room500 0
)

(local
	local0
	local1
	[local2 4]
	local6
	[local7 200]
)

(instance Room500 of Rm
	(properties
		picture 500
	)

	(method (init)
		(SetPort 0 0 200 320 0 0)
		(super init: &rest)
		(gCurRoom setScript: rollCredits)
	)
)

(instance rollCredits of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetPort -1)
				(= local0
					(Display ; "Executive Producer: Ken Williams"
						500
						0
						dsCOORD
						56
						90
						dsWIDTH
						120
						dsCOLOR
						(proc10_30 67 0)
						dsFONT
						3
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display ; "Creative Director: Bill Davis Director: Lori Ann Cole Producer: Stuart Moulder Game Designer: Lori Ann Cole"
						500
						1
						dsCOORD
						180
						40
						dsWIDTH
						130
						dsCOLOR
						(proc10_30 67 0)
						dsFONT
						3
						dsSAVEPIXELS
					)
				)
				(= ticks 600)
			)
			(1
				(Display 500 2 dsRESTOREPIXELS local0)
				(Display 500 2 dsRESTOREPIXELS local1)
				(SetPort -1)
				(= local0
					(Display ; "Production Designer: Andy Hoyos Art Designer: Douglas Herring"
						500
						3
						dsCOORD
						56
						85
						dsWIDTH
						150
						dsCOLOR
						(proc10_30 67 0)
						dsFONT
						3
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display ; "Lead Programmer: Corey Cole Music Arranged and Performed By: Mark Seibert Paul Aleman Chris Braymen  Digitized Sounds: Orpheus Hanley"
						500
						4
						dsCOORD
						180
						30
						dsWIDTH
						135
						dsCOLOR
						(proc10_30 67 0)
						dsFONT
						3
						dsSAVEPIXELS
					)
				)
				(= ticks 600)
			)
			(2
				(Display 500 2 dsRESTOREPIXELS local0)
				(Display 500 2 dsRESTOREPIXELS local1)
				(SetPort -1)
				(= local0
					(Display ; "Animators: Vasken Nokhoudian Dana Dean Deena Krutak Diana Wilson Jerry Jessurun Bob Gleason"
						500
						5
						dsCOORD
						56
						78
						dsWIDTH
						135
						dsCOLOR
						(proc10_30 67 0)
						dsFONT
						3
						dsSAVEPIXELS
					)
				)
				(= local6 26)
				(= local1
					(Display
						(Format @local7 500 6 local6) ; "Background Artists: Bob Gleason Andy Hoyos Dennis Lewis Programmers: Jack Magn%c Kevin Ray John Wentworth Brett Miller Steve Conrad"
						dsCOORD
						180
						30
						dsWIDTH
						135
						dsCOLOR
						(proc10_30 67 0)
						dsFONT
						3
						dsSAVEPIXELS
					)
				)
				(= ticks 600)
			)
			(3
				(Display 500 2 dsRESTOREPIXELS local0)
				(Display 500 2 dsRESTOREPIXELS local1)
				(SetPort -1)
				(= local0
					(Display ; "Music Director: Mark Seibert Quality Assurance: Sharon Smith Gordon Owens"
						500
						7
						dsCOORD
						56
						90
						dsWIDTH
						135
						dsCOLOR
						(proc10_30 67 0)
						dsFONT
						3
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display ; "Development System: Jeff Stephenson Robert E. Heitman Dan Foy Larry Scott J. Mark Hood Chris Smith Eric Hart Chad Bye Mark Wilden Ken Koch"
						500
						8
						dsCOORD
						180
						30
						dsWIDTH
						135
						dsCOLOR
						(proc10_30 67 0)
						dsFONT
						3
						dsSAVEPIXELS
					)
				)
				(= ticks 600)
			)
			(4
				(gGlobalMusic fade: 0 15 12 1 self)
				(= seconds 10)
			)
			(5
				(= seconds 3)
			)
			(6
				(= gQuit 1)
			)
		)
	)
)

