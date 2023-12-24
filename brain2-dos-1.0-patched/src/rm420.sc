;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use dummyClient)
(use BrainWindow)
(use Talker)
(use IconBar)
(use RandCycle)
(use LoadMany)
(use GameControls)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm420 0
	drTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	[local13 26]
	local39
	local40
	[local41 60]
	[local101 60]
	[local161 60]
	local221
	local222
	local223
	local224
	local225
	local226
	[local227 18] = [1 58 40 0 63 40 3 65 39 5 61 38 4 56 36 2 61 42]
	[local245 15] = [13 38 51 14 36 50 12 33 50 15 33 50 11 32 52]
	[local260 15] = [8 24 83 9 24 83 10 27 82 7 26 82 6 26 84]
	local275 = 5
	local276 = 4
	local277 = 4
	[local278 7] = [11 12 13 7 8 9 0]
)

(procedure (localproc_0 &tmp temp0)
	(gMessager say: &rest)
	(= gGameTime (+ gTickOffset (GetTime)))
	(if gFastCast
		(while gFastCast
			(gFastCast eachElementDo: #doit)
			(if (and ((= temp0 (Event new:)) type:) gFastCast)
				(gFastCast firstTrue: #handleEvent temp0)
			)
			(temp0 dispose:)
			(= gGameTime (+ gTickOffset (GetTime)))
		)
	)
)

(instance rm420 of Rm
	(properties
		picture 420
		south 360
	)

	(method (init)
		(LoadMany rsVIEW 420 424)
		(LoadMany rsSOUND 114 141 176 238 250)
		(gTheIconBar disable:)
		(fasterCast add: drEyes)
		(self setScript: moveToNext)
		(super init:)
	)

	(method (dispose)
		(HandsOn 1)
		(fasterCast release: dispose:)
		(computer dispose:)
		(super dispose: &rest)
	)
)

(instance moveToNext of Script
	(properties)

	(method (changeState newState &tmp [temp0 3] temp3 temp4 temp5 temp6 temp7 temp8 [temp9 3] temp12 temp13 temp14 temp15 temp16 temp17 temp18)
		(switch (= state newState)
			(0
				(HandsOff)
				(massage1 init: setCycle: Fwd)
				(massage2 init: setCycle: Fwd)
				(drEyes init: cel: 1 x: 142 y: 61 setCycle: drBlink 180)
				(fan init: setCycle: Fwd)
				(lightBulb init: setCycle: Fwd)
				(monitor stopUpd: init:)
				(whistle stopUpd: init: setScript: blowWhistle self)
				(book stopUpd: init: setScript: flipPages)
			)
			(1
				(if (not gScore)
					(for ((= temp13 0)) (< temp13 25) ((++ temp13))
						(++ global119)
						(++ global120)
						(++ global121)
						(+= gScore 15)
						(= [global135 temp13] 15444)
						(+= global134 11)
						(+= global115 12)
					)
					(= [global135 25] 12244)
					(+= gScore 12)
					(+= global134 9)
					(++ global119)
					(++ global120)
					(++ global121)
					(+= global115 10)
					(= [global135 8] 15200)
					(-- global119)
					(-- global120)
					(-= global134 8)
					(-= global115 8)
					(= [global135 4] 15777)
					(+= global134 9)
					(+= global115 9)
				)
				(= local12 0)
				(= local39 0)
				(for ((= temp13 0)) (< temp13 26) ((++ temp13))
					(if (mod (/ [global135 temp13] 1000) 5)
						(= [local13 local12] temp13)
						(++ local12)
						(cond
							((/ (= temp3 (mod [global135 temp13] 1000)) 100)
								(+=
									local39
									(/ (- 15 (/ [global135 temp13] 1000)) 3)
								)
							)
							((/ temp3 10)
								(+=
									local39
									(/ (- 10 (/ [global135 temp13] 1000)) 2)
								)
							)
							(else
								(+= local39 (- 5 (/ [global135 temp13] 1000)))
							)
						)
					)
				)
				(= cycles 1)
			)
			(2
				(gGame setCursor: 996)
				(gMessager say: 1 9 0 0 self) ; "It's an automatic, ultra-foot massaging, completely adjustable and reclining chaise lounge beach chair -- including all the amenities, of course."
			)
			(3
				(= temp3 (+ (/ gScore 65) 1))
				(if (= temp5 (Message msgSIZE 420 3 4 0 1)) ; "Splendid! You have earned %s score of %d (out of a possible 390 points)! You have also earned %d Extra Credit Points (out of a possible total of 287 Extra Credit points), which gives you...along with credit for your unused hint charges...a grand total of %d (out of the highest possible score of 1,000 points)!"
					(= temp6 (Memory memALLOC_CRIT temp5))
				)
				(if temp6
					(Message msgGET 420 3 4 0 1 temp6) ; "Splendid! You have earned %s score of %d (out of a possible 390 points)! You have also earned %d Extra Credit Points (out of a possible total of 287 Extra Credit points), which gives you...along with credit for your unused hint charges...a grand total of %d (out of the highest possible score of 1,000 points)!"
				)
				(= temp7 (Message msgSIZE 420 16 4 0 temp3))
				(= temp8 (Memory memALLOC_CRIT temp7))
				(Message msgGET 420 16 4 0 temp3 temp8)
				(gMessager
					sayFormat:
						4
						temp6
						temp8
						gScore
						global134
						(+ gScore global134 global115 (if (not local12) 9))
					caller: self
				)
				(if temp6
					(Memory memFREE temp6)
				)
				(if temp8
					(Memory memFREE temp8)
				)
			)
			(4
				(massage1 dispose:)
				(massage2 dispose:)
				(= cycles 3)
			)
			(5
				(cond
					(
						(>=
							(+
								gScore
								global134
								global115
								(if (not local12) 9)
							)
							1000
						)
						(localproc_0 18 4 0)
						(= register 1)
						((= local1 (View new:))
							view: 424
							x: 146
							y: 79
							ignoreActors:
							setPri: 14
						)
						((= local0 (View new:))
							view: 424
							loop: 1
							cel: 1
							x: 157
							y: 92
							ignoreActors:
							setPri: 14
						)
						(monitor setScript: turnMonitor self 1)
					)
					((and (== global134 287) (== gScore 390))
						(localproc_0 20 4 0)
						(= register 1)
						(monitor setScript: turnMonitor self 0)
					)
					((== gScore 390)
						(localproc_0 19 4 0)
						(= register 2)
						(gCSoundFX number: 238 setLoop: -1 play: 127)
						((= local2 (Prop new:))
							view: 424
							loop: 2
							cel: 8
							x: 191
							y: 48
							ignoreActors:
							setCycle: Fwd
							init:
						)
						((= local3 (Prop new:))
							view: 424
							loop: 2
							cel: 0
							x: 302
							y: 60
							ignoreActors:
							setCycle: Fwd
							init:
						)
						((= local4 (Prop new:))
							view: 424
							loop: 3
							cel: 10
							x: 207
							y: 35
							ignoreActors:
							setCycle: Fwd
							init:
						)
						((= local5 (Prop new:))
							view: 424
							loop: 4
							cel: 0
							x: 207
							y: 37
							ignoreActors:
							setCycle: Fwd
							init:
						)
						((= local6 (Prop new:))
							view: 424
							loop: 5
							cel: 4
							x: 281
							y: 45
							ignoreActors:
							setCycle: Fwd
							init:
						)
						((= local7 (Prop new:))
							view: 424
							loop: 7
							cel: 5
							x: 179
							y: 50
							ignoreActors:
							setCycle: Fwd
							init:
						)
						((= local8 (Prop new:))
							view: 424
							loop: 7
							cel: 3
							x: 228
							y: 30
							ignoreActors:
							setCycle: Fwd
							init:
						)
						((= local9 (Prop new:))
							view: 424
							loop: 9
							cel: 4
							x: 277
							y: 37
							ignoreActors:
							setCycle: Fwd
							init:
						)
						((= local10 (Prop new:))
							view: 424
							loop: 8
							cel: 2
							x: 196
							y: 43
							ignoreActors:
							setCycle: Fwd
							init:
						)
						(= seconds 8)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(6
				(if (== register 2)
					(gCSoundFX stop:)
					(local2 dispose:)
					(local3 dispose:)
					(local4 dispose:)
					(local5 dispose:)
					(local6 dispose:)
					(local7 dispose:)
					(local8 dispose:)
					(local9 dispose:)
					(local10 dispose:)
				)
				(= cycles 3)
			)
			(7
				(massage1 init: setCycle: Fwd)
				(massage2 init: setCycle: Fwd)
				(= temp3 0)
				(if global119
					(+= temp3 1)
				)
				(if global120
					(+= temp3 2)
				)
				(if global121
					(+= temp3 4)
				)
				(= temp5 (Message msgSIZE 420 4 4 0 temp3))
				(= temp6 (Memory memALLOC_CRIT temp5))
				(Message msgGET 420 4 4 0 temp3 temp6)
				(cond
					(global119
						(= temp17 global119)
						(if global120
							(= temp18 global120)
						else
							(= temp18 global121)
						)
					)
					(global120
						(= temp17 global120)
						(= temp18 global121)
					)
					(else
						(= temp17 global121)
					)
				)
				(gMessager
					sayFormat: 4 temp6 temp17 temp18 global121
					caller: self
				)
				(if temp6
					(Memory memFREE temp6)
				)
			)
			(8
				(if local39
					(= temp5 (Message msgSIZE 420 6 4 0 1)) ; "I urge you to solve the following puzzles (without using your hint watch):|c4|"
					(= temp6 (Memory memALLOC_CRIT (+ temp5 (* local12 40))))
					(Message msgGET 420 6 4 0 1 temp6) ; "I urge you to solve the following puzzles (without using your hint watch):|c4|"
					(= temp8 (Memory memALLOC_CRIT 40))
					(for
						((= temp13 0))
						(and (< temp13 10) (< temp13 local12))
						((++ temp13))
						
						(Message msgGET 420 17 4 0 (+ [local13 temp13] 1) temp8)
						(StrCat temp6 { *})
						(StrCat temp6 temp8)
						(StrCat temp6 {* })
					)
					(gMessager sayFormat: 4 temp6 caller: self)
					(if temp6
						(Memory memFREE temp6)
					)
					(if temp8
						(Memory memFREE temp8)
					)
				else
					(= cycles 1)
				)
			)
			(9
				(= temp14 (= temp16 (= temp15 0)))
				(for ((= temp13 0)) (< temp13 26) ((++ temp13))
					(cond
						((/ (= temp12 (mod [global135 temp13] 1000)) 100)
							(++ temp14)
						)
						((/ temp12 10)
							(++ temp16)
						)
						(else
							(++ temp15)
						)
					)
				)
				(cond
					((== global121 26)
						(= temp3 1)
					)
					((and (> global121 13) (> (+ temp14 temp16) 24))
						(= temp3 10)
					)
					((> global121 13)
						(= temp3 11)
					)
					((== global120 26)
						(= temp3 4)
					)
					((and (> global120 13) (> (+ temp14 temp16) 24))
						(= temp3 12)
					)
					((> global120 13)
						(= temp3 13)
					)
					((and (> temp16 temp14) (> temp16 temp15))
						(= temp3 15)
					)
					((and (> temp14 temp16) (> temp14 temp15))
						(= temp3 14)
					)
					(else
						(= temp3 7)
					)
				)
				(if (< temp3 10)
					(cond
						((not local12) 0)
						((> local39 10)
							(= temp3 2)
						)
						(else
							(+= temp3 1)
						)
					)
				)
				(gMessager say: 2 4 0 temp3 self 420)
			)
			(10
				(whistle setScript: blowWhistle self)
				(book setScript: flipPages)
			)
			(11
				(= cycles 1)
			)
			(12
				(gMessager say: 1 26 0 0 self) ; "And now, let me introduce you to my excellent staff. They are collectively known as Brainstormers!"
			)
			(13
				(lightBulb dispose:)
				(fan dispose:)
				(massage1 dispose:)
				(massage2 dispose:)
				(drEyes dispose:)
				(head1 init: hide:)
				(head2 init: hide:)
				(head3 init: hide:)
				(= seconds 3)
			)
			(14
				(head1
					setCel: 0
					setLoop: [local227 (= register (* (Random 0 local275) 3))]
					x: [local227 (+ 1 register)]
					y: [local227 (+ 2 register)]
					show:
				)
				(= ticks 30)
			)
			(15
				(Message msgGET 420 1 0 20 (+ [local227 register] 1) @local41)
				(= [local227 register] [local227 (* local275 3)])
				(= [local227 (+ register 1)] [local227 (+ (* local275 3) 1)])
				(= [local227 (+ register 2)] [local227 (+ (* local275 3) 2)])
				(-- local275)
				(= local221
					(Display @local41 dsCOORD 100 40 dsCOLOR 51 dsALIGN alLEFT dsWIDTH 200 dsFONT 1 dsSAVEPIXELS)
				)
				(= local224
					(Display @local41 dsCOORD 99 39 dsCOLOR 255 dsALIGN alLEFT dsWIDTH 200 dsFONT 1 dsSAVEPIXELS)
				)
				(head1 setCycle: RandCycle)
				(= seconds 4)
			)
			(16
				(head1 setCycle: End self)
			)
			(17
				(head2
					view: 422
					setCel: 0
					setLoop: [local245 (= register (* (Random 0 local276) 3))]
					x: [local245 (+ 1 register)]
					y: [local245 (+ 2 register)]
					show:
				)
				(= ticks 30)
			)
			(18
				(Message msgGET 420 1 0 20 (+ [local245 register] 1) @local101)
				(= [local245 register] [local245 (* local276 3)])
				(= [local245 (+ register 1)] [local245 (+ (* local276 3) 1)])
				(= [local245 (+ register 2)] [local245 (+ (* local276 3) 2)])
				(-- local276)
				(= local222
					(Display @local101 dsCOORD 74 76 dsCOLOR 51 dsALIGN alLEFT dsWIDTH 200 dsFONT 1 dsSAVEPIXELS)
				)
				(= local225
					(Display @local101 dsCOORD 73 75 dsCOLOR 255 dsALIGN alLEFT dsWIDTH 200 dsFONT 1 dsSAVEPIXELS)
				)
				(head2 setCycle: RandCycle)
				(= seconds 4)
			)
			(19
				(head2 setCycle: End self)
			)
			(20
				(head3
					setCel: 0
					setLoop: [local260 (= register (* (Random 0 local277) 3))]
					x: [local260 (+ 1 register)]
					y: [local260 (+ 2 register)]
					show:
				)
				(= ticks 30)
			)
			(21
				(Message msgGET 420 1 0 20 (+ [local260 register] 1) @local161)
				(= [local260 register] [local260 (* local277 3)])
				(= [local260 (+ register 1)] [local260 (+ (* local277 3) 1)])
				(= [local260 (+ register 2)] [local260 (+ (* local277 3) 2)])
				(-- local277)
				(= local223
					(Display @local161 dsCOORD 57 117 dsCOLOR 51 dsALIGN alLEFT dsWIDTH 200 dsFONT 1 dsSAVEPIXELS)
				)
				(= local226
					(Display
						@local161
						dsCOORD
						56
						116
						dsCOLOR
						255
						dsALIGN
						alLEFT
						dsWIDTH
						200
						dsFONT
						1
						dsSAVEPIXELS
					)
				)
				(head3 setCycle: RandCycle)
				(= seconds 4)
			)
			(22
				(head3 setCycle: End)
				(= ticks 150)
			)
			(23
				(++ local40)
				(Display {} dsRESTOREPIXELS local224)
				(Display {} dsRESTOREPIXELS local225)
				(Display {} dsRESTOREPIXELS local226)
				(Display {} dsRESTOREPIXELS local221)
				(Display {} dsRESTOREPIXELS local222)
				(Display {} dsRESTOREPIXELS local223)
				(head1 hide:)
				(head2 hide:)
				(head3 hide:)
				(if (< local40 5)
					(self changeState: 13)
				else
					(head1
						setCel: 0
						setLoop: [local227 0]
						x: [local227 1]
						y: [local227 2]
						show:
					)
					(= ticks 30)
				)
			)
			(24
				(Message msgGET 420 1 0 20 (+ [local227 0] 1) @local41)
				(= local221
					(Display @local41 dsCOORD 100 45 dsCOLOR 51 dsALIGN alLEFT dsWIDTH 200 dsFONT 1 dsSAVEPIXELS)
				)
				(= local224
					(Display @local41 dsCOORD 99 44 dsCOLOR 255 dsALIGN alLEFT dsWIDTH 200 dsFONT 1 dsSAVEPIXELS)
				)
				(head1 setCycle: RandCycle)
				(= seconds 4)
			)
			(25
				(head1 setCycle: End self)
			)
			(26
				(head2 view: 420 setCel: 0 setLoop: 12 x: 24 y: 121 show:)
				(= ticks 30)
			)
			(27
				(Message msgGET 420 1 0 20 17 @local101) ; "Hi! I'm Oliver. Nobody else seems to want this banana, I think I'll take it!"
				(= local222
					(Display @local101 dsCOORD 57 117 dsCOLOR 51 dsALIGN alLEFT dsWIDTH 200 dsFONT 1 dsSAVEPIXELS)
				)
				(= local225
					(Display
						@local101
						dsCOORD
						56
						116
						dsCOLOR
						255
						dsALIGN
						alLEFT
						dsWIDTH
						200
						dsFONT
						1
						dsSAVEPIXELS
					)
				)
				(head2 setCycle: RandCycle)
				(= seconds 4)
			)
			(28
				(head2 setCycle: End self)
			)
			(29
				(Display {} dsRESTOREPIXELS local224)
				(Display {} dsRESTOREPIXELS local221)
				(Display {} dsRESTOREPIXELS local225)
				(Display {} dsRESTOREPIXELS local222)
				(head1 dispose:)
				(head2 dispose:)
				(head3 dispose:)
				(= ticks 150)
			)
			(30
				(Message msgGET 420 1 0 7 1 @local41) ; "Replay puzzles"
				(Message msgGET 420 1 0 8 1 @local101) ; "Repeat credits"
				(Message msgGET 420 1 0 9 1 @local161) ; "Quit playing"
				(quest init: show: dispose:)
				(switch local11
					(0
						(gCurRoom newRoom: 360)
					)
					(1
						(= local40 0)
						(= local275 5)
						(= local276 4)
						(= local277 4)
						(= [local227 0] 1)
						(= [local227 1] 58)
						(= [local227 2] 40)
						(= [local227 3] 0)
						(= [local227 4] 63)
						(= [local227 5] 40)
						(= [local227 6] 3)
						(= [local227 7] 65)
						(= [local227 8] 39)
						(= [local227 9] 5)
						(= [local227 10] 61)
						(= [local227 11] 38)
						(= [local227 12] 4)
						(= [local227 13] 56)
						(= [local227 14] 36)
						(= [local227 15] 2)
						(= [local227 16] 61)
						(= [local227 17] 42)
						(= [local245 0] 13)
						(= [local245 1] 38)
						(= [local245 2] 51)
						(= [local245 3] 14)
						(= [local245 4] 36)
						(= [local245 5] 50)
						(= [local245 6] 12)
						(= [local245 7] 33)
						(= [local245 8] 50)
						(= [local245 9] 15)
						(= [local245 10] 33)
						(= [local245 11] 50)
						(= [local245 12] 11)
						(= [local245 13] 32)
						(= [local245 14] 52)
						(= [local260 0] 8)
						(= [local260 1] 24)
						(= [local260 2] 83)
						(= [local260 3] 9)
						(= [local260 4] 24)
						(= [local260 5] 83)
						(= [local260 6] 10)
						(= [local260 7] 27)
						(= [local260 8] 82)
						(= [local260 9] 7)
						(= [local260 10] 26)
						(= [local260 11] 82)
						(= [local260 12] 6)
						(= [local260 13] 26)
						(= [local260 14] 84)
						(gCurRoom init:)
					)
					(else
						(= gQuit 1)
					)
				)
			)
		)
	)
)

(instance flipPages of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client startUpd: setCycle: End self)
			)
			(1
				(= ticks 20)
			)
			(2
				(client cel: 0 setCycle: End self)
			)
			(3
				(= seconds (Random 1 3))
			)
			(4
				(client cel: 0 setCycle: End self)
			)
			(5
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance turnMonitor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client startUpd:)
				(computer number: 176 setLoop: 1 play: 127)
				(client setCycle: End self)
			)
			(1
				(if register
					(local1 init:)
					(local0 init:)
				else
					(rewardWindow open:)
				)
				(gCSoundFX number: 250 setLoop: 1 play: 127)
				(= seconds 7)
			)
			(2
				(if register
					(local1 dispose:)
					(local0 dispose:)
				else
					(rewardWindow dispose:)
				)
				(= cycles 1)
			)
			(3
				(client setCycle: Beg self)
				(computer number: 114 setLoop: 1 play: 127)
			)
			(4
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance computer of Sound
	(properties)
)

(instance rewardWindow of SysWindow
	(properties
		top 77
		left 145
		bottom 183
		right 310
		back 36
		priority 13
	)

	(method (open)
		(super open: &rest)
		(DrawCel 424 0 0 0 0 -1)
		(DrawCel 424 1 0 8 7 -1)
	)
)

(instance blowWhistle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client startUpd: setCycle: Beg self)
			)
			(1
				(gCSoundFX number: 141 setLoop: 1 play: 127 self)
			)
			(2
				(client setCycle: End self)
			)
			(3
				(client stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance massage1 of Actor
	(properties
		x 150
		y 159
		view 420
		loop 4
		cycleSpeed 15
	)
)

(instance massage2 of Actor
	(properties
		x 212
		y 139
		view 420
		loop 5
		cel 4
		cycleSpeed 9
	)
)

(instance fan of Actor
	(properties
		x 185
		y 68
		view 420
		loop 2
	)
)

(instance lightBulb of Actor
	(properties
		x 67
		y 45
		view 420
		loop 3
	)
)

(instance smoke of Actor ; UNUSED
	(properties
		x 249
		y 6
		view 420
		loop 6
		cel 6
	)
)

(instance monitor of Prop
	(properties
		x 229
		y 129
		view 420
		loop 7
		priority 12
		signal 16
		cycleSpeed 9
	)
)

(instance whistle of Prop
	(properties
		x 181
		y 36
		view 420
		loop 8
	)
)

(instance book of Prop
	(properties
		x 191
		y 84
		view 420
		loop 9
	)
)

(instance head1 of Prop
	(properties
		view 422
		signal 16384
		cycleSpeed 12
	)
)

(instance head2 of Prop
	(properties
		view 422
		signal 16384
		cycleSpeed 12
	)
)

(instance head3 of Prop
	(properties
		view 422
		signal 16384
		cycleSpeed 12
	)
)

(instance drTalker of Talker
	(properties
		x 143
		y 68
		view 420
		loop 11
		talkWidth 280
		color 2
		back 44
		textX -130
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(= mouth drMouth)
		(super init: &rest)
	)

	(method (doit)
		(Animate (fasterCast elements:) 0)
		(drEyes doit:)
		(super doit: &rest)
	)
)

(instance drBlink of Blink
	(properties
		cycleDir -1
	)
)

(instance drMouth of Prop
	(properties
		view 420
	)
)

(instance drEyes of Prop
	(properties
		nsTop -7
		nsLeft -1
		view 420
		loop 10
	)

	(method (doit)
		(^= cel $0001)
		(super doit: &rest)
		(^= cel $0001)
	)
)

(instance fasterCast of Set
	(properties)
)

(instance quest of GameControls
	(properties)

	(method (init)
		(gGame setCursor: 999)
		((= window (BrainWindow new:))
			top: 60
			left: 77
			bottom: 130
			right: 243
			priority: 15
			yourself:
		)
		(self add: titleIc backIc creditsIc quitIc curIcon: backIc)
		(super init: &rest)
	)
)

(instance titleIc of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 0
		signal 4
		maskView 361
		maskLoop 3
	)

	(method (show &tmp [temp0 30])
		(Message msgGET 420 1 0 6 1 @temp0) ; "You may choose..."
		(Display @temp0 dsWIDTH 135 dsCOORD 15 8 dsCOLOR 17)
	)
)

(instance backIc of IconI
	(properties
		nsTop 25
		signal 257
	)

	(method (select)
		(= local11 0)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display @local41 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display @local41 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance creditsIc of IconI
	(properties
		nsTop 40
		signal 257
	)

	(method (select)
		(= local11 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display @local101 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display @local101 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance quitIc of IconI
	(properties
		nsTop 55
		signal 257
	)

	(method (select)
		(= local11 2)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(Display @local161 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
		(if (& signal $0004)
			(self mask:)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(= temp0 46)
		else
			(= temp0 17)
		)
		(Display @local161 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

