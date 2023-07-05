;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
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
				(= local0 (Display 500 0 dsCOORD 56 90 dsWIDTH 120 dsCOLOR 67 dsFONT 3 dsSAVEPIXELS)) ; "Executive Producer: Ken Williams"
				(= local1 (Display 500 1 dsCOORD 180 40 dsWIDTH 130 dsCOLOR 67 dsFONT 3 dsSAVEPIXELS)) ; "Creative Director: Bill Davis Director: Lori Ann Cole Producer: Stuart Moulder Game Designer: Lori Ann Cole"
				(= ticks 600)
			)
			(1
				(Display 500 2 dsRESTOREPIXELS local0)
				(Display 500 2 dsRESTOREPIXELS local1)
				(SetPort -1)
				(= local0 (Display 500 3 dsCOORD 56 85 dsWIDTH 150 dsCOLOR 67 dsFONT 3 dsSAVEPIXELS)) ; "Production Designer: Andy Hoyos Art Designer: Douglas Herring"
				(= local1 (Display 500 4 dsCOORD 180 50 dsWIDTH 135 dsCOLOR 67 dsFONT 3 dsSAVEPIXELS)) ; "Lead Programmer: Corey Cole  Music Arranged and Performed By: Mark Seibert Paul Aleman Chris Braymen"
				(= ticks 600)
			)
			(2
				(Display 500 2 dsRESTOREPIXELS local0)
				(Display 500 2 dsRESTOREPIXELS local1)
				(SetPort -1)
				(= local0 (Display 500 5 dsCOORD 56 78 dsWIDTH 135 dsCOLOR 67 dsFONT 3 dsSAVEPIXELS)) ; "Animators: Vasken Nokhoudian Dana Dean Deena Krutak Diana Wilson Jerry Jessurun Bob Gleason"
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
						67
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
				(= local0 (Display 500 7 dsCOORD 56 90 dsWIDTH 135 dsCOLOR 67 dsFONT 3 dsSAVEPIXELS)) ; "Music Director: Mark Seibert Quality Assurance: Sharon Smith Gordon Owens"
				(= local1 (Display 500 8 dsCOORD 180 30 dsWIDTH 135 dsCOLOR 67 dsFONT 3 dsSAVEPIXELS)) ; "Development System: Jeff Stephenson Robert E. Heitman Dan Foy Larry Scott J. Mark Hood Chris Smith Eric Hart Chad Bye Mark Wilden Ken Koch"
				(= ticks 600)
			)
			(4
				(gGlobalMusic fade: 0 15 12 1)
				(= gQuit 1)
			)
		)
	)
)

