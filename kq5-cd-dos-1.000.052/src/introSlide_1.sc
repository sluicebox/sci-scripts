;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 610)
(include sci.sh)
(use Main)
(use AudioScript)
(use Sync)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	introSlide_1 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance introSlide_1 of Rm
	(properties
		picture 68
	)

	(method (init)
		(= local4 (if global159 7 else 15))
		(super init: &rest)
		(HandsOff)
		(gGame setCursor: gNarrator 1)
		(= global103 1)
		(Load rsPIC 55)
		(LoadMany rsVIEW 755 754)
		(Load rsFONT 8)
		(aCastle init:)
		(self setScript: openingCartoon)
	)
)

(instance openingCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 763) doit:) ; cartoonCode
				(= cycles 1)
			)
			(1
				(gCurRoom setRegions: 769) ; introtoonRegion
				(= cycles 1)
			)
			(2
				(self setScript: scene1Script)
			)
			(3
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 68)
				(Load rsPIC 69)
				(LoadMany rsVIEW 748 749)
				(LoadMany rsFONT 600 8)
				(= seconds 2)
			)
			(4
				(self setScript: scene2Script)
			)
			(5
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 69)
				(Load rsPIC 68)
				(LoadMany rsVIEW 748 757 760)
				(= seconds 2)
			)
			(6
				(self setScript: scene3Script)
			)
			(7
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 68)
				(Load rsPIC 70)
				(LoadMany rsVIEW 761)
				(= seconds 2)
			)
			(8
				(self setScript: scene4Script)
			)
			(9
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 70)
				(Load rsPIC 71)
				(LoadMany rsVIEW 757 763)
				(= seconds 2)
			)
			(10
				(self setScript: scene5Script)
			)
			(11
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 71)
				(Load rsPIC 72)
				(LoadMany rsVIEW 761)
				(= seconds 2)
			)
			(12
				(self setScript: scene6Script)
			)
			(13
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 72)
				(Load rsPIC 70)
				(LoadMany rsVIEW 761)
				(= seconds 2)
			)
			(14
				(self setScript: scene7Script)
			)
			(15
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 70)
				(Load rsPIC 71)
				(LoadMany rsVIEW 763 757 758 759 785)
				(= seconds 2)
			)
			(16
				(self setScript: scene8Script)
			)
			(17
				(= seconds 1)
			)
			(18
				(gCurRoom newRoom: 611) ; introSlide_2
			)
		)
	)
)

(instance scene1Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(syncIt init: setCycle: MouthSync 10101 hide:)
				(gGlobalAudio number: 10101 play:)
				(= seconds 1)
			)
			(1
				(= local1 (Display 610 0 dsCOORD 80 100 dsFONT 8 dsCOLOR 0)) ; "CASTLE DAVENTRY"
				(= local0 (Display 610 0 dsCOORD 79 99 dsFONT 8 dsCOLOR local4)) ; "CASTLE DAVENTRY"
				(= seconds 3)
			)
			(2
				(DrawPic 68 9 0)
				(= cycles 1)
			)
			(3
				(= waitForCue 4608)
			)
			(4
				(Palette palSET_INTENSITY 0 255 0)
				(mordack init:)
				(= cycles 1)
			)
			(5
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 5120)
			)
			(6
				(Palette palSET_INTENSITY 0 255 0)
				(mordack loop: 2 cel: 4 show:)
				(lightning init:)
				(clouds init:)
				(= cycles 1)
			)
			(7
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 5200)
			)
			(8
				(Palette palSET_INTENSITY 0 255 0)
				(lightning loop: 5 cel: 2 show:)
				(clouds loop: 2 cel: 2 show:)
				(= cycles 1)
			)
			(9
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 5376)
			)
			(10
				(Palette palSET_INTENSITY 0 255 0)
				(lightning loop: 5 cel: 4 show:)
				(clouds cel: 3 show:)
				(= cycles 1)
			)
			(11
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 5632)
			)
			(12
				(Palette palSET_INTENSITY 0 255 0)
				(aCastle hide:)
				(lightning hide:)
				(mordack loop: 5 cel: 3 show:)
				(clouds loop: 3 cel: 7 show:)
				(= cycles 1)
			)
			(13
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 5888)
			)
			(14
				(Palette palSET_INTENSITY 0 255 0)
				(gCast eachElementDo: #hide)
				(= cycles 1)
			)
			(15
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 3)
			)
			(16
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(17
				(= seconds 1)
			)
			(18
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scene2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 69 10)
				(theEgo init:)
				(theHead init:)
				(water init:)
				(= local3
					(Display 610 1 dsCOORD 70 10 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Executive Producer"
				)
				(= local2
					(Display 610 2 dsCOORD 70 26 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= local1
					(Display ; "Executive Producer"
						610
						1
						dsCOORD
						69
						9
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local4
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display 610 2 dsCOORD 69 25 dsWIDTH 140 dsALIGN alCENTER dsCOLOR local4 dsFONT 8 dsSAVEPIXELS) ; "Ken Williams"
				)
				(= seconds 2)
			)
			(1
				(gGlobalAudio number: 10102 play:)
				(= seconds 6)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 146 y: 112 view: 748 show:)
				(theHead x: 146 y: 112 view: 748 show:)
				(water cel: 2 show:)
				(Display 610 3 dsRESTOREPIXELS local0)
				(Display 610 3 dsRESTOREPIXELS local1)
				(Display 610 3 dsRESTOREPIXELS local3)
				(Display 610 3 dsRESTOREPIXELS local2)
				(= local3
					(Display 610 4 dsCOORD 11 75 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Creative Director"
				)
				(= local2
					(Display 610 5 dsCOORD 11 91 dsWIDTH 120 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
				)
				(= local1
					(Display ; "Creative Director"
						610
						4
						dsCOORD
						10
						74
						dsWIDTH
						120
						dsALIGN
						alCENTER
						dsCOLOR
						local4
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display 610 5 dsCOORD 10 90 dsWIDTH 120 dsALIGN alCENTER dsCOLOR local4 dsFONT 8 dsSAVEPIXELS) ; "Bill Davis"
				)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 5)
			)
			(4
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 158 y: 112 loop: 5 cel: 6 show:)
				(theHead hide:)
				(water loop: 0 cel: 3 show:)
				(Display 610 3 dsRESTOREPIXELS local0)
				(Display 610 3 dsRESTOREPIXELS local1)
				(Display 610 3 dsRESTOREPIXELS local2)
				(Display 610 3 dsRESTOREPIXELS local3)
				(= cycles 1)
			)
			(5
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 1)
			)
			(6
				(DrawPic 69 9)
				(theEgo loop: 7 cel: 1 show:)
				(water
					x: 185
					y: 169
					view: 749
					loop: 1
					cel: 5
					priority: 13
					show:
				)
				(= seconds 1)
			)
			(7
				(DrawPic 69 9)
				(theEgo loop: 7 cel: 5 show:)
				(water x: 185 y: 169 loop: 1 cel: 5 show:)
				(= local3
					(Display 610 6 dsCOORD 70 10 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Designed, Directed and Produced by"
				)
				(= local2
					(Display 610 7 dsCOORD 70 26 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
				)
				(= local1
					(Display ; "Designed, Directed and Produced by"
						610
						6
						dsCOORD
						69
						9
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local4
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display 610 7 dsCOORD 69 25 dsWIDTH 240 dsALIGN alCENTER dsCOLOR local4 dsFONT 8 dsSAVEPIXELS) ; "Roberta Williams"
				)
				(= seconds 6)
			)
			(8
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 222 y: 119 loop: 6 cel: 6 show:)
				(theHead x: 222 y: 119 loop: 4 cel: 0 priority: 8 show:)
				(water x: 40 y: 154 view: 749 loop: 0 cel: 3 priority: 11 show:)
				(Display 610 3 dsRESTOREPIXELS local0)
				(Display 610 3 dsRESTOREPIXELS local1)
				(Display 610 3 dsRESTOREPIXELS local2)
				(Display 610 3 dsRESTOREPIXELS local3)
				(= local3
					(Display 610 8 dsCOORD 121 24 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Art Designer"
				)
				(= local2
					(Display 610 9 dsCOORD 121 40 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Andy Hoyos"
				)
				(= local1
					(Display ; "Art Designer"
						610
						8
						dsCOORD
						120
						23
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local4
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Andy Hoyos"
						610
						9
						dsCOORD
						120
						39
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local4
						dsFONT
						8
						dsSAVEPIXELS
					)
				)
				(= cycles 1)
			)
			(9
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 6)
			)
			(10
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 290 y: 90 cel: 0 show:)
				(theHead x: 290 y: 90 priority: 5 show:)
				(water loop: 0 cel: 2 show:)
				(Display 610 3 dsRESTOREPIXELS local0)
				(Display 610 3 dsRESTOREPIXELS local1)
				(Display 610 3 dsRESTOREPIXELS local2)
				(Display 610 3 dsRESTOREPIXELS local3)
				(= local3
					(Display 610 10 dsCOORD 21 11 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Lead Programmer"
				)
				(= local2
					(Display 610 11 dsCOORD 21 27 dsWIDTH 240 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Robert W. Lindsley"
				)
				(= local1
					(Display ; "Lead Programmer"
						610
						10
						dsCOORD
						20
						10
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local4
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Robert W. Lindsley"
						610
						11
						dsCOORD
						20
						26
						dsWIDTH
						240
						dsALIGN
						alCENTER
						dsCOLOR
						local4
						dsFONT
						8
						dsSAVEPIXELS
					)
				)
				(= cycles 1)
			)
			(11
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 6)
			)
			(12
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 323 y: 84 loop: 6 cel: 7 show:)
				(theHead x: 323 y: 84 z: 32 loop: 4 cel: 0 priority: 4 show:)
				(water loop: 0 cel: 2 show:)
				(Display 610 3 dsRESTOREPIXELS local0)
				(Display 610 3 dsRESTOREPIXELS local1)
				(Display 610 3 dsRESTOREPIXELS local2)
				(Display 610 3 dsRESTOREPIXELS local3)
				(= local3
					(Display 610 12 dsCOORD 11 75 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 600 dsSAVEPIXELS) ; "Composers"
				)
				(= local2
					(Display 610 13 dsCOORD 11 91 dsWIDTH 140 dsALIGN alCENTER dsCOLOR 0 dsFONT 8 dsSAVEPIXELS) ; "Mark Seibert Ken Allen"
				)
				(= local1
					(Display ; "Composers"
						610
						12
						dsCOORD
						10
						74
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local4
						dsFONT
						600
						dsSAVEPIXELS
					)
				)
				(= local0
					(Display ; "Mark Seibert Ken Allen"
						610
						13
						dsCOORD
						10
						90
						dsWIDTH
						140
						dsALIGN
						alCENTER
						dsCOLOR
						local4
						dsFONT
						8
						dsSAVEPIXELS
					)
				)
				(= cycles 1)
			)
			(13
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 6)
			)
			(14
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(15
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scene3Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 68 10)
				(theEgo
					x: 44
					y: 162
					view: 748
					loop: 0
					cel: 6
					priority: 12
					init:
				)
				(= seconds 2)
			)
			(1
				(syncIt init: setCycle: MouthSync 10103 hide:)
				(gGlobalAudio number: 10103 play:)
				(= waitForCue 800)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo
					x: 44
					y: 162
					view: 748
					loop: 0
					cel: 6
					priority: 12
					show:
				)
				(owl x: 16 y: 74 view: 760 loop: 2 cel: 1 priority: 6 init:)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 1)
			)
			(4
				(DrawPic 68 9)
				(theEgo
					x: 44
					y: 162
					view: 748
					loop: 2
					cel: 8
					priority: 12
					show:
				)
				(owl x: 25 y: 100 view: 757 loop: 0 cel: 13 priority: 6 show:)
				(= cycles 1)
			)
			(5
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(= seconds 1)
			)
			(7
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scene4Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 70 10)
				(theMouth init:)
				(owlEyes init:)
				(egoEyes init:)
				(egoBody init:)
				(theEgo x: 121 y: 78 view: 761 loop: 3 cel: 0 priority: 6 init:)
				(leftLimb init:)
				(rightLimb init:)
				(= seconds 2)
			)
			(1
				(syncIt init: setCycle: MouthSync 10104 hide:)
				(gGlobalAudio number: 10104 play:)
				(= waitForCue 4356)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(owl
					x: 177
					y: 79
					z: 0
					view: 761
					loop: 0
					cel: 0
					priority: 4
					init:
				)
				(theEgo hide:)
				(theMouth
					x: 121
					y: 78
					z: 0
					view: 761
					loop: 3
					cel: 3
					priority: 6
				)
				(egoEyes loop: 2 cel: 0)
				(leftLimb loop: 5 cel: 3)
				(rightLimb loop: 6 cel: 0)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(4
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(= seconds 1)
			)
			(6
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scene5Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 71 10)
				(theHead
					x: 81
					y: 118
					z: 0
					view: 763
					loop: 0
					cel: 2
					priority: 10
					init:
				)
				(theEgo
					x: 102
					y: 109
					view: 763
					loop: 1
					cel: 0
					priority: 11
					init:
				)
				(owl x: 189 y: 86 view: 757 loop: 1 cel: 0 priority: 10 init:)
				(owlEyes
					x: 191
					y: 52
					view: 757
					loop: 2
					cel: 0
					priority: 11
					init:
				)
				(rightLimb
					x: 184
					y: 58
					view: 757
					loop: 4
					cel: 6
					priority: 12
					init:
				)
				(leftLimb
					x: 196
					y: 60
					z: 0
					view: 757
					loop: 5
					cel: 6
					priority: 12
					init:
				)
				(theMouth
					x: 192
					y: 56
					z: 0
					view: 757
					loop: 3
					cel: 2
					priority: 11
					init:
				)
				(= seconds 2)
			)
			(1
				(syncIt init: setCycle: MouthSync 10105 hide:)
				(gGlobalAudio number: 10105 play:)
				(= waitForCue 5124)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo hide:)
				(rightLimb loop: 4 cel: 0)
				(leftLimb loop: 6 cel: 4)
				(theMouth x: 102 y: 109 view: 763 loop: 1 cel: 4)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(4
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(= seconds 1)
			)
			(6
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scene6Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 72 10)
				(owlEyes
					x: 154
					y: 54
					view: 98
					loop: 0
					cel: 5
					priority: 10
					init:
				)
				(theMouth
					x: 152
					y: 75
					view: 1070
					loop: 1
					cel: 2
					priority: 10
					init:
				)
				(= seconds 2)
			)
			(1
				(syncIt init: setCycle: MouthSync 10106 hide:)
				(gGlobalAudio number: 10106 play:)
				(= waitForCue 5892)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(theMouth cel: 4)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(4
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(= seconds 2)
			)
			(6
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scene7Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 70 10)
				(owl x: 177 y: 79 view: 761 loop: 0 cel: 0 priority: 4 init:)
				(theMouth
					x: 121
					y: 78
					view: 761
					loop: 3
					cel: 1
					priority: 6
					init:
				)
				(owlEyes
					x: 175
					y: 66
					view: 761
					loop: 1
					cel: 0
					priority: 7
					init:
				)
				(egoEyes
					x: 121
					y: 78
					view: 761
					loop: 2
					cel: 0
					priority: 10
					init:
				)
				(egoBody init:)
				(rightLimb
					x: 102
					y: 84
					view: 761
					loop: 6
					cel: 0
					priority: 11
					init:
				)
				(leftLimb
					x: 128
					y: 75
					view: 761
					loop: 5
					cel: 3
					priority: 11
					init:
				)
				(= seconds 2)
			)
			(1
				(syncIt init: setCycle: MouthSync 10107 hide:)
				(gGlobalAudio number: 10107 play:)
				(= waitForCue 6404)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(owl hide:)
				(theMouth x: 177 y: 79 view: 761 loop: 0 cel: 0 priority: 4)
				(theEgo x: 121 y: 78 view: 761 loop: 3 cel: 0 priority: 6 init:)
				(egoEyes loop: 2 cel: 0)
				(leftLimb loop: 5 cel: 0)
				(rightLimb loop: 6 cel: 0)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(4
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(= seconds 1)
			)
			(6
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scene8Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 71 10)
				(theEgo
					x: 81
					y: 118
					view: 763
					loop: 0
					cel: 2
					priority: 10
					init:
				)
				(egoBody
					x: 102
					y: 109
					view: 763
					loop: 1
					cel: 0
					priority: 11
					init:
				)
				(owl x: 189 y: 86 view: 757 loop: 1 cel: 0 priority: 10 init:)
				(owlEyes
					x: 191
					y: 52
					view: 757
					loop: 2
					cel: 0
					priority: 11
					init:
				)
				(rightLimb
					x: 184
					y: 58
					view: 757
					loop: 4
					cel: 0
					priority: 12
					init:
				)
				(leftLimb
					x: 196
					y: 60
					view: 757
					loop: 5
					cel: 6
					priority: 12
					init:
				)
				(theMouth
					x: 192
					y: 56
					view: 757
					loop: 3
					cel: 7
					priority: 11
					init:
				)
				(= seconds 2)
			)
			(1
				(syncIt init: setCycle: MouthSync 10108 hide:)
				(gGlobalAudio number: 10108 play:)
				(= waitForCue 9216)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(owl view: 758 loop: 2 cel: 9 priority: 1)
				(owlEyes hide:)
				(rightLimb hide:)
				(leftLimb hide:)
				(theMouth hide:)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 9296)
			)
			(4
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 101 y: 105 view: 763 loop: 0 cel: 0 priority: 10)
				(egoBody hide:)
				(owl x: 203 y: 130 view: 758 loop: 3 cel: 4 priority: 1)
				(= cycles 1)
			)
			(5
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 2)
			)
			(6
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 203 y: 180 view: 758 loop: 3 cel: 2)
				(= cycles 1)
			)
			(7
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 9472)
			)
			(8
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 203 y: 242 view: 758 loop: 3 cel: 0)
				(leaves
					x: 197
					y: 188
					view: 758
					loop: 4
					cel: 11
					priority: 14
					init:
				)
				(= cycles 1)
			)
			(9
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 2)
			)
			(10
				(DrawPic 71 9)
				(owl x: 192 y: 168 view: 759 loop: 0 cel: 0 priority: 0)
				(leaves hide:)
				(= cycles 10)
			)
			(11
				(DrawPic 71 9)
				(theEgo x: 81 y: 118 view: 763 loop: 0 cel: 2)
				(egoBody
					x: 102
					y: 109
					view: 763
					loop: 1
					cel: 0
					priority: 11
					show:
				)
				(owl x: 189 y: 86 view: 757 loop: 1 cel: 0 priority: 10)
				(owlEyes
					x: 191
					y: 52
					view: 757
					loop: 2
					cel: 0
					priority: 11
					show:
				)
				(rightLimb
					x: 184
					y: 58
					view: 757
					loop: 4
					cel: 0
					priority: 12
					show:
				)
				(leftLimb x: 196 y: 60 view: 757 loop: 6 cel: 4 priority: 12)
				(theMouth
					x: 192
					y: 56
					view: 757
					loop: 3
					cel: 7
					priority: 11
					show:
				)
				(= waitForCue 10240)
			)
			(12
				(Palette palSET_INTENSITY 0 255 0)
				(egoBody hide:)
				(theMouth x: 102 y: 109 view: 763 loop: 1 cel: 3 priority: 11)
				(= cycles 1)
			)
			(13
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 10496)
			)
			(14
				(Palette palSET_INTENSITY 0 255 0)
				(egoBody
					x: 102
					y: 109
					view: 763
					loop: 1
					cel: 0
					priority: 11
					show:
				)
				(theMouth x: 192 y: 56 view: 757 loop: 3 cel: 7 priority: 11)
				(= cycles 1)
			)
			(15
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 10576)
			)
			(16
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 189 y: 86 view: 759 loop: 2 cel: 8 priority: 10)
				(owlEyes hide:)
				(rightLimb hide:)
				(leftLimb hide:)
				(theMouth hide:)
				(= cycles 1)
			)
			(17
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 10608)
			)
			(18
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 189 y: 86 view: 759 loop: 3 cel: 6 priority: 10)
				(theMouth
					x: 192
					y: 56
					view: 757
					loop: 3
					cel: 7
					priority: 11
					show:
				)
				(= cycles 1)
			)
			(19
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 13056)
			)
			(20
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 180 y: 83 view: 785 loop: 5 cel: 0 priority: 10)
				(theMouth hide:)
				(= cycles 1)
			)
			(21
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(22
				(DrawPic 71 9)
				(theEgo
					x: 97
					y: 109
					view: 763
					loop: 0
					cel: 4
					priority: 10
					show:
				)
				(egoBody hide:)
				(owl x: 110 y: 48 view: 785 loop: 6 cel: 5 priority: 10)
				(= seconds 2)
			)
			(23
				(DrawPic 71 5)
				(owl x: 110 y: 48 view: 785 loop: 6 cel: 4 priority: 10)
				(dust init:)
				(= waitForCue 13568)
			)
			(24
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 110 y: 48 view: 785 loop: 10 cel: 2 priority: 10)
				(dust hide:)
				(theMouth
					x: 95
					y: 24
					view: 757
					loop: 3
					cel: 6
					priority: 11
					show:
				)
				(sack init:)
				(= cycles 1)
			)
			(25
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 13904)
			)
			(26
				(DrawPic 71 9)
				(theEgo x: 103 y: 108 view: 763 loop: 0 cel: 1 priority: 10)
				(owl x: 55 y: 31 view: 785 loop: 10 cel: 1 priority: 10)
				(theMouth hide:)
				(= cycles 1)
			)
			(27
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(28
				(= seconds 1)
			)
			(29
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance aCastle of View
	(properties
		x 157
		y 77
		view 755
		loop 4
		priority 4
		signal 16400
	)
)

(instance mordack of View
	(properties
		x 230
		y 176
		view 754
		cel 1
		priority 13
		signal 16400
	)
)

(instance lightning of View
	(properties
		x 157
		y 77
		view 755
		loop 5
		priority 5
		signal 16400
	)
)

(instance clouds of View
	(properties
		x 157
		y 86
		view 755
		loop 1
		cel 3
		priority 5
		signal 16400
	)
)

(instance theEgo of View
	(properties
		x 11
		y 115
		view 748
		loop 3
		cel 8
		priority 1
		signal 16400
	)
)

(instance theHead of View
	(properties
		x 11
		y 115
		z 31
		view 748
		loop 4
		priority 7
		signal 16400
	)
)

(instance water of View
	(properties
		x 40
		y 154
		view 749
		cel 1
		priority 11
		signal 16400
	)
)

(instance owl of View
	(properties
		x 25
		y 100
		view 757
		cel 13
		priority 6
		signal 16400
	)
)

(instance owlEyes of View
	(properties
		x 175
		y 66
		view 761
		loop 1
		priority 7
		signal 16400
	)
)

(instance theMouth of View
	(properties
		x 177
		y 79
		view 761
		cel 3
		priority 4
		signal 16400
	)
)

(instance egoEyes of View
	(properties
		x 121
		y 78
		view 761
		loop 2
		cel 1
		priority 10
		signal 16400
	)
)

(instance leftLimb of View
	(properties
		x 128
		y 75
		view 761
		loop 5
		priority 11
		signal 16400
	)
)

(instance rightLimb of View
	(properties
		x 102
		y 84
		view 761
		loop 6
		priority 11
		signal 16400
	)
)

(instance egoBody of View
	(properties
		x 132
		y 128
		view 761
		loop 4
		priority 4
		signal 16400
	)
)

(instance leaves of View
	(properties
		x 197
		y 188
		view 758
		loop 4
		cel 11
		priority 14
		signal 16400
	)
)

(instance sack of View
	(properties
		x 59
		y 201
		view 785
		loop 9
		priority 9
		signal 16400
	)
)

(instance dust of View
	(properties
		x 87
		y 54
		view 785
		loop 7
		cel 5
		priority 12
		signal 16400
	)
)

(instance syncIt of Prop
	(properties)
)

