;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 700)
(include sci.sh)
(use Main)
(use AudioScript)
(use Sync)
(use Game)
(use Actor)
(use System)

(public
	rm700 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm700 of Rm
	(properties)

	(method (init)
		(= local5 (if global159 7 else 15))
		(= local0 2000)
		(self picture: 2000 yourself:)
		(self setScript: openingCartoon)
		(super init: &rest)
	)
)

(instance openingCartoon of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				((ScriptID 763) doit:) ; cartoonCode
				(= cycles 1)
			)
			(2
				(gCurRoom setRegions: 769) ; introtoonRegion
				(HandsOff)
				(Load rsPIC local0 (+ local0 1) (+ local0 2))
				(++ local0)
				(syncIt init: setCycle: MouthSync 10101 hide:)
				(gGlobalAudio number: 10101 play:)
				(= waitForCue 4608)
			)
			(3
				(doDrawPic doit:)
				(= waitForCue 5376)
			)
			(4
				(doDrawPic doit:)
				(= waitForCue 5888)
			)
			(5
				(Load rsPIC (+ local0 1) (+ local0 2) (+ local0 3))
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10102 hide:)
				(gGlobalAudio number: 10102 play: self)
				(self setScript: creditsScript)
			)
			(6
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10103 hide:)
				(gGlobalAudio number: 10103 play:)
				(= waitForCue 864)
			)
			(7
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10104 hide:)
				(gGlobalAudio number: 10104 play:)
				(= waitForCue 4608)
			)
			(8
				(Load rsPIC (+ local0 1) (+ local0 2) (+ local0 3))
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10105 hide:)
				(gGlobalAudio number: 10105 play:)
				(= waitForCue 5380)
			)
			(9
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10106 hide:)
				(gGlobalAudio number: 10106 play:)
				(= waitForCue 5892)
			)
			(10
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10107 hide:)
				(gGlobalAudio number: 10107 play: self)
			)
			(11
				(Load
					rsPIC
					(+ local0 1)
					(+ local0 2)
					(+ local0 3)
					(+ local0 4)
					(+ local0 5)
					(+ local0 6)
					(+ local0 7)
				)
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10108 hide:)
				(gGlobalAudio number: 10108 play:)
				(= waitForCue 9216)
			)
			(12
				(doDrawPic doit:)
				(= waitForCue 9472)
			)
			(13
				(doDrawPic doit:)
				(= waitForCue 9728)
			)
			(14
				(doDrawPic doit:)
				(= waitForCue 12288)
			)
			(15
				(doDrawPic doit:)
				(= waitForCue 13056)
			)
			(16
				(doDrawPic doit:)
				(= waitForCue 13316)
			)
			(17
				(doDrawPic doit:)
				(= waitForCue 13904)
			)
			(18
				(Load rsPIC (+ local0 1) (+ local0 2) (+ local0 3))
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10109 hide:)
				(gGlobalAudio number: 10109 play:)
				(= waitForCue 16388)
			)
			(19
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10111 hide:)
				(gGlobalAudio number: 10111 play:)
				(= waitForCue 16724)
			)
			(20
				(doDrawPic doit:)
				(= waitForCue 17668)
			)
			(21
				(Load
					rsPIC
					(+ local0 1)
					(+ local0 2)
					(+ local0 3)
					(+ local0 4)
					(+ local0 5)
				)
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10112 hide:)
				(gGlobalAudio number: 10112 play:)
				(= waitForCue 18180)
			)
			(22
				(doDrawPic doit:)
				(= waitForCue 18688)
			)
			(23
				(doDrawPic doit:)
				(= waitForCue 21504)
			)
			(24
				(doDrawPic doit:)
				(= waitForCue 22020)
			)
			(25
				(doDrawPic doit:)
				(= waitForCue 24576)
			)
			(26
				(Load
					rsPIC
					(+ local0 1)
					(+ local0 2)
					(+ local0 3)
					(+ local0 4)
					(+ local0 5)
				)
				(doDrawPic doit:)
				(syncIt init: setCycle: MouthSync 10113 hide:)
				(gGlobalAudio number: 10113 play:)
				(= waitForCue 9216)
			)
			(27
				(doDrawPic doit:)
				(= waitForCue 9988)
			)
			(28
				(doDrawPic doit:)
				(= waitForCue 12288)
			)
			(29
				(doDrawPic doit:)
				(= waitForCue 14080)
			)
			(30
				(doDrawPic doit:)
				(= waitForCue 20992)
			)
			(31
				(HandsOn)
				(gCurRoom newRoom: 1)
			)
		)
	)
)

(instance creditsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4
					(Display 700 0 dsCOORD 70 10 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Executive Producer"
				)
				(= local3
					(Display 700 1 dsCOORD 70 26 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= local2
					(Display ; "Executive Producer"
						700
						0
						dsCOORD
						69
						9
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local5
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display 700 1 dsCOORD 69 25 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local5 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= seconds 4)
			)
			(1
				(Display 700 2 dsRESTOREPIXELS local2)
				(Display 700 2 dsRESTOREPIXELS local1)
				(Display 700 2 dsRESTOREPIXELS local4)
				(Display 700 2 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(2
				(= local4
					(Display 700 3 dsCOORD 11 75 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Creative Director"
				)
				(= local3
					(Display 700 4 dsCOORD 11 91 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
				)
				(= local2
					(Display ; "Creative Director"
						700
						3
						dsCOORD
						10
						74
						dsWIDTH
						120
						dsALIGN
						alCENTER
						dsCOLOR
						local5
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display 700 4 dsCOORD 10 90 dsWIDTH 120 dsALIGN alCENTER dsCOLOR local5 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
				)
				(= seconds 3)
			)
			(3
				(Display 700 2 dsRESTOREPIXELS local1)
				(Display 700 2 dsRESTOREPIXELS local2)
				(Display 700 2 dsRESTOREPIXELS local3)
				(Display 700 2 dsRESTOREPIXELS local4)
				(= cycles 1)
			)
			(4
				(= local4
					(Display 700 5 dsCOORD 70 10 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Designed, Directed and Produced by"
				)
				(= local3
					(Display 700 6 dsCOORD 70 26 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
				)
				(= local2
					(Display ; "Designed, Directed and Produced by"
						700
						5
						dsCOORD
						69
						9
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local5
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display 700 6 dsCOORD 69 25 dsWIDTH 240 dsALIGN alCENTER dsCOLOR local5 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
				)
				(= seconds 3)
			)
			(5
				(Display 700 2 dsRESTOREPIXELS local1)
				(Display 700 2 dsRESTOREPIXELS local2)
				(Display 700 2 dsRESTOREPIXELS local3)
				(Display 700 2 dsRESTOREPIXELS local4)
				(= cycles 1)
			)
			(6
				(= local4
					(Display 700 7 dsCOORD 121 24 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Art Designer"
				)
				(= local3
					(Display 700 8 dsCOORD 121 40 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Andy Hoyos"
				)
				(= local2
					(Display ; "Art Designer"
						700
						7
						dsCOORD
						120
						23
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local5
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display ; "Andy Hoyos"
						700
						8
						dsCOORD
						120
						39
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local5
						dsFONT
						8
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(7
				(Display 700 2 dsRESTOREPIXELS local1)
				(Display 700 2 dsRESTOREPIXELS local2)
				(Display 700 2 dsRESTOREPIXELS local3)
				(Display 700 2 dsRESTOREPIXELS local4)
				(= cycles 1)
			)
			(8
				(= local4
					(Display 700 9 dsCOORD 21 11 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Lead Programmer"
				)
				(= local3
					(Display 700 10 dsCOORD 21 27 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Robert W. Lindsley"
				)
				(= local2
					(Display ; "Lead Programmer"
						700
						9
						dsCOORD
						20
						10
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local5
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display ; "Robert W. Lindsley"
						700
						10
						dsCOORD
						20
						26
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local5
						dsFONT
						8
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(9
				(Display 700 2 dsRESTOREPIXELS local1)
				(Display 700 2 dsRESTOREPIXELS local2)
				(Display 700 2 dsRESTOREPIXELS local3)
				(Display 700 2 dsRESTOREPIXELS local4)
				(= cycles 1)
			)
			(10
				(= local4
					(Display 700 11 dsCOORD 11 75 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Composers"
				)
				(= local3
					(Display 700 12 dsCOORD 11 91 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Mark Seibert Ken Allen"
				)
				(= local2
					(Display ; "Composers"
						700
						11
						dsCOORD
						10
						74
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local5
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local1
					(Display ; "Mark Seibert Ken Allen"
						700
						12
						dsCOORD
						10
						90
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local5
						dsFONT
						8
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(11
				(Display 700 2 dsRESTOREPIXELS local1)
				(Display 700 2 dsRESTOREPIXELS local2)
				(Display 700 2 dsRESTOREPIXELS local3)
				(Display 700 2 dsRESTOREPIXELS local4)
				(self dispose:)
			)
		)
	)
)

(instance doDrawPic of Code
	(properties)

	(method (doit)
		(DrawPic local0)
		(++ local0)
	)
)

(instance syncIt of Prop
	(properties)

	(method (init)
		(if (not local6)
			(++ local6)
			(super init: &rest)
		)
	)
)

