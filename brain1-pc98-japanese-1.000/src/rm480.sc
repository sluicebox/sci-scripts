;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Interface)
(use Language)
(use Osc)
(use LoadMany)
(use DCIcon)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)

(public
	rm480 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 9] = [{mediocre} {mediocre} {adequate} {decent} {fine} {really good} {excellent} {terrific} {incredible}]
	[local16 250]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 100)) (<= temp0 5000) ((+= temp0 30))
		(Palette palSET_INTENSITY 0 255 temp0)
	)
	(gCurRoom drawPic: 421)
)

(procedure (localproc_1)
	(leftScreen view: 481 setLoop: 0 setCycle: Fwd)
)

(procedure (localproc_2)
	(rightScreen view: 482 setLoop: 0 setCycle: Fwd)
)

(instance rm480 of Rm
	(properties
		lookStr {This is Dr. Brain's Master Control Room.}
		picture 480
		style 7
	)

	(method (init)
		(Load rsSCRIPT 939)
		(LoadMany rsVIEW 480 481 482 483 485 486 490)
		(LoadMany rsSOUND 423 480 969)
		(titleWipeOn init: setLoop: 4 hide:)
		(titleWipeOff init: setLoop: 7 hide:)
		(shuttle init: setLoop: 5 hide:)
		(balloon init: setLoop: 6 hide:)
		(leftReels init:)
		(rightReels init:)
		(drBrain init:)
		(display1 init: setCycle: Fwd)
		(display2 init: setCycle: Fwd)
		(display3 init: setCycle: Fwd)
		(display4 init: setCycle: Fwd)
		(display5 init: setCycle: Fwd)
		(display6 init: setCycle: Fwd)
		(display7 init: setCycle: Fwd)
		(display8 init: setCycle: Fwd)
		(leftScreen init: setCycle: Fwd)
		(rightScreen init: setCycle: Fwd)
		(lcdDigits init: setCycle: Fwd)
		(leftReels setCycle: Fwd)
		(rightReels setCycle: Fwd)
		(super init:)
		(if (not (IsFlag 59))
			(SetFlag 59)
			(-= global123 25)
		)
		(proc5_18)
		(if (> gScore 200)
			(= gScore 200)
		)
		(self setScript: toonScript)
	)
)

(instance toonScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCMusic number: 480 setLoop: -1 flags: 1 priority: 15 play:)
				(= cycles 1)
			)
			(1
				(= global122 0)
				(proc5_1)
				(= ticks 180)
			)
			(2
				(drBrain setCycle: Walk setMotion: MoveTo 125 125 self)
			)
			(3
				(drBrain dispose:)
				(display1 setPri: 14)
				(display2 setPri: 14)
				(display3 setPri: 14)
				(display4 setPri: 14)
				(display5 setPri: 14)
				(display6 setPri: 14)
				(display7 setPri: 14)
				(display8 setPri: 14)
				(leftReels setPri: 14)
				(rightReels setPri: 14)
				(drHeadOnScreen init: setCycle: End self)
			)
			(4
				(drEyesOnScreen init: setCycle: Fwd)
				(drEyebrowsOnScreen init: setCycle: Fwd)
				(drMouthOnScreen init:)
				(= cycles 1)
			)
			(5
				(drMouthOnScreen setCycle: Fwd)
				(Print 480 0 #at 63 136 #time 5 #dispose self) ; "So, congratulations! You have solved every test I set for you!"
			)
			(6
				(if 1
					(= global408 (Memory memALLOC_CRIT (StrLen [local7 (/ gScore 25)])))
					(= global409 (Memory memALLOC_CRIT (StrLen [local7 (/ gScore 25)])))
					(StrSplitInTwo global408 global409 [local7 (/ gScore 25)])
					(Format @local16 480 1 global408 gScore gScore global409) ; "You've achieved the %s score of %d points on my little puzzles."
					(Memory memFREE global408)
					(Memory memFREE global409)
				)
				(Print @local16 #at 63 136 #time 8 #dispose self)
			)
			(7
				(Print 480 2 #at 63 136 #time 4 #dispose self) ; "You will make a fine lab assistant! Why, together we can . . ."
			)
			(8
				(= ticks 90)
			)
			(9
				(Print 480 3 #at 63 136 #time 8 #dispose self) ; "But enough of that! There's work to be done! Let's get to it! First, I'd like you to meet a few of my friends!"
			)
			(10
				(localproc_1)
				(localproc_2)
				(Print 480 4 #at 63 136 #time 5 #dispose self #mode 1) ; "International Producer:"
			)
			(11
				(display2 stopUpd:)
				(= cycles 1)
			)
			(12
				(= local4 (proc5_12 {Sabine Duvall} 67 -4 50 28 28))
				(leftScreen view: 483 setLoop: 2 setCycle: Osc)
				(= ticks 300)
			)
			(13
				(proc5_12 local4)
				(= cycles 1)
			)
			(14
				(localproc_1)
				(Print 480 5 #at 63 136 #time 5 #dispose self #mode 1) ; "Foreign Languages Lead Programming:"
			)
			(15
				(= local4 (proc5_12 {Gary Kamigawachi} 67 -10 45 28 28))
				(leftScreen view: 483 setLoop: 3 setCycle: Osc)
				(= ticks 300)
			)
			(16
				(proc5_12 local4)
				(= cycles 1)
			)
			(17
				(localproc_1)
				(Print 480 6 #at 63 136 #time 5 #dispose self #mode 1) ; "Foreign Languages Programming:"
			)
			(18
				(proc5_12 local4)
				(= cycles 1)
			)
			(19
				(= local4 (proc5_12 {William R. Shockley} 67 -4 50 28 28))
				(= local5 (proc5_12 {Sean T. Mooney} 67 240 55 28 28))
				(leftScreen view: 483 setLoop: 4 setCycle: Osc)
				(rightScreen view: 483 setLoop: 5 setCycle: Osc)
				(= ticks 300)
			)
			(20
				(proc5_12 local4)
				(proc5_12 local5)
				(= cycles 1)
			)
			(21
				(localproc_1)
				(localproc_2)
				(leftReels stopUpd:)
				(Print 480 7 #at 63 136 #time 5 #dispose self #mode 1) ; "Japanese Translator:"
			)
			(22
				(= local4 (proc5_12 {Akiko M. Skjellerup} 67 -4 50 28 28))
				(leftScreen view: 483 setLoop: 7 setCycle: Osc)
				(= ticks 300)
			)
			(23
				(proc5_12 local4)
				(= cycles 1)
			)
			(24
				(localproc_1)
				(leftReels setCycle: Fwd)
				(Print 480 8 #at 63 136 #time 5 #dispose self #mode 1) ; "Quality Assurance Team Lead:"
			)
			(25
				(= local4 (proc5_12 {Gordon Owens} 67 -4 50 28 28))
				(leftScreen view: 483 setLoop: 6 setCycle: Osc)
				(= ticks 300)
			)
			(26
				(proc5_12 local4)
				(= cycles 1)
			)
			(27
				(localproc_1)
				(localproc_2)
				(Print 480 9 #at 63 136 #time 5 #dispose self) ; "Director/Designer/Lead Programmer, and my alter-ego:"
			)
			(28
				(= local4 (proc5_12 {Corey Cole} 67 0 47 28 28))
				(leftScreen view: 481 setLoop: 1 setCycle: Osc)
				(= ticks 300)
			)
			(29
				(proc5_12 local4)
				(= cycles 1)
			)
			(30
				(localproc_1)
				(Print 480 10 #at 63 136 #time 5 #dispose self) ; "My esteemed Producer, who helped us to bring the castle in on time and under budget:"
			)
			(31
				(= local5 (proc5_12 {Stuart Moulder} 67 234 58 28 28))
				(rightScreen setLoop: 1 setCycle: Osc)
				(= ticks 240)
			)
			(32
				(proc5_12 local5)
				(= cycles 1)
			)
			(33
				(proc5_12 local5)
				(localproc_1)
				(localproc_2)
				(Print 480 11 #at 63 136 #time 5 #dispose self) ; "My art Production Designer (we'll let him out soon):"
			)
			(34
				(= local4 (proc5_12 {Andy Hoyos} 67 -2 49 28 28))
				(leftScreen view: 481 setLoop: 2 setCycle: Osc)
				(= ticks 240)
			)
			(35
				(proc5_12 local4)
				(localproc_1)
				(Print 480 12 #at 63 136 #time 4 #dispose self) ; "The Art Designer (he already got out!):"
			)
			(36
				(= local5 (proc5_12 {Douglas Herring} 67 224 53 28 28))
				(rightScreen view: 482 setLoop: 2 setCycle: Osc)
				(= ticks 240)
			)
			(37
				(proc5_12 local5)
				(localproc_2)
				(Print 480 13 #at 93 136 #time 4 #dispose self) ; "My Composers: "Whadidya say? I can't see you?""
			)
			(38
				(= local4 (proc5_12 {Mark Seibert} 67 0 47 28 28))
				(= local5 (proc5_12 {Ken Allen} 67 255 58 28 28))
				(leftScreen setLoop: 3)
				(rightScreen setLoop: 11)
				(= ticks 360)
			)
			(39
				(proc5_12 local4)
				(proc5_12 local5)
				(= local4 (proc5_12 {Chris Braymen} 67 0 50 28 28))
				(= local5 (proc5_12 {Rob Atesalp} 67 255 58 28 28))
				(leftScreen setLoop: 14)
				(rightScreen setLoop: 12)
				(= ticks 360)
			)
			(40
				(proc5_12 local4)
				(proc5_12 local5)
				(= cycles 1)
			)
			(41
				(localproc_1)
				(localproc_2)
				(Print 480 14 #at 63 136 #time 4 #dispose self) ; "Digitized sounds constructed by:"
			)
			(42
				(= local4 (proc5_12 {Orpheus Hanley} 67 0 47 28 28))
				(leftScreen setLoop: 15 setCycle: Osc)
				(= ticks 180)
			)
			(43
				(proc5_12 local4)
				(localproc_1)
				(localproc_2)
				(Print 480 15 #at 63 136 #time 6 #dispose self) ; "And here are some of my artist friends! They have helped me decorate this beautiful castle! The animators:"
			)
			(44
				(= local4 (proc5_12 {Vasken Nokhoudian} 67 0 50 28 28))
				(= local5 (proc5_12 {Dana Dean} 67 260 58 28 28))
				(leftScreen setLoop: 4 setCycle: Osc)
				(rightScreen setLoop: 3 setCycle: Osc)
				(= ticks 360)
			)
			(45
				(proc5_12 local4)
				(proc5_12 local5)
				(= cycles 1)
			)
			(46
				(= local4 (proc5_12 {Deena Krutak} 67 0 47 28 28))
				(= local5 (proc5_12 {Arturo Sinclair} 67 264 58 28 28))
				(leftScreen setLoop: 5)
				(rightScreen setLoop: 4)
				(= ticks 360)
			)
			(47
				(proc5_12 local4)
				(proc5_12 local5)
				(= cycles 1)
			)
			(48
				(= local4 (proc5_12 {Jerry Jessurun} 67 1 47 28 28))
				(= local5 (proc5_12 {Bob Gleason} 67 239 58 28 28))
				(leftScreen setLoop: 6)
				(rightScreen setLoop: 5)
				(= ticks 360)
			)
			(49
				(proc5_12 local4)
				(proc5_12 local5)
				(= cycles 1)
			)
			(50
				(= local4 (proc5_12 {Jay Allan Friedmann} 67 -3 50 28 28))
				(= local5 (proc5_12 {Jon Bock} 67 227 58 28 28))
				(leftScreen setLoop: 7)
				(rightScreen setLoop: 6)
				(= ticks 360)
			)
			(51
				(proc5_12 local4)
				(proc5_12 local5)
				(= cycles 1)
			)
			(52
				(= local4 (proc5_12 {Diana Wilson} 67 0 47 28 28))
				(leftScreen setLoop: 8)
				(localproc_2)
				(= ticks 180)
			)
			(53
				(proc5_12 local4)
				(localproc_1)
				(Print 480 16 #at 63 136 #time 5 #dispose self) ; "And here are some MORE of my artist friends! The background artists:"
			)
			(54
				(= local4 (proc5_12 {Dennis Lewis} 67 0 47 28 28))
				(= local5 (proc5_12 {John Shroades} 67 249 58 28 28))
				(leftScreen setLoop: 9 setCycle: Osc)
				(rightScreen setLoop: 7 setCycle: Osc)
				(= ticks 360)
			)
			(55
				(proc5_12 local4)
				(proc5_12 local5)
				(localproc_1)
				(localproc_2)
				(Print 480 17 #at 63 136 #time 6 #dispose self) ; "I also know some programmers! Without them, I would have had a hard time putting my little challenges together!"
			)
			(56
				(= local4 (proc5_12 {Jack Magne'} 67 0 50 28 28))
				(= local5 (proc5_12 {Brett Miller} 67 262 58 28 28))
				(leftScreen setLoop: 10 setCycle: Osc)
				(rightScreen setLoop: 8 setCycle: Osc)
				(= ticks 360)
			)
			(57
				(proc5_12 local4)
				(proc5_12 local5)
				(= cycles 1)
			)
			(58
				(= local4 (proc5_12 {John Wentworth} 67 -4 50 28 28))
				(= local5 (proc5_12 {Steve Conrad} 67 242 58 28 28))
				(leftScreen setLoop: 11)
				(rightScreen setLoop: 9 setCycle: Fwd)
				(= ticks 360)
			)
			(59
				(proc5_12 local4)
				(proc5_12 local5)
				(= cycles 1)
			)
			(60
				(localproc_1)
				(localproc_2)
				(Print 480 18 #at 63 136 #time 5 #dispose self) ; "My Quality Assurance Leads: Making sure the castle is as clean as can be!"
			)
			(61
				(= local4 (proc5_12 {Dave Clingman} 67 -4 50 28 28))
				(= local5 (proc5_12 {Sharon Simmons} 67 242 58 28 28))
				(leftScreen view: 483 setLoop: 1)
				(rightScreen setLoop: 10)
				(= ticks 300)
			)
			(62
				(proc5_12 local4)
				(proc5_12 local5)
				(= cycles 1)
			)
			(63
				(leftScreen view: 481)
				(localproc_1)
				(localproc_2)
				(Print 480 19 #at 63 136 #time 5 #dispose self) ; "Finally, special credit for Design Assistance and Necessary Discipline must surely go to:"
			)
			(64
				(= local4 (proc5_12 {Lori Ann Cole} 67 -4 50 28 28))
				(leftScreen setLoop: 12 setCycle: Osc)
				(= ticks 300)
			)
			(65
				(display2 startUpd:)
				(proc5_12 local4)
				(localproc_1)
				(Print 480 20 #at 63 136 #time 5 #dispose self) ; "But now it's time for me to devise a new set of challenges for you, my clever lab assistant!"
			)
			(66
				(Print 480 21 #at 80 136 #time 5 #dispose self) ; "Which means I must be off to the ..."
			)
			(67
				(drHeadOnScreen dispose:)
				(drEyesOnScreen dispose:)
				(drMouthOnScreen dispose:)
				(drEyebrowsOnScreen dispose:)
				(shuttleMask init:)
				(shuttleMaskTop init:)
				(balloonMaskRight init:)
				(balloonMaskLeft init:)
				(island init: setLoop: 0)
				(ocean init: setLoop: 2 setCycle: Fwd)
				(skyMask init:)
				(gAddToPics doit:)
				(sky0 init: setLoop: 1)
				(sky1 init: setLoop: 1)
				(= cycles 1)
			)
			(68
				(sky0 posn: 3 70 setMotion: MoveTo 101 70)
				(sky1 posn: 101 70 setMotion: MoveTo 199 70 self)
				(if (not local3)
					(= local3 1)
					(self setScript: trailerScript)
				)
			)
			(69
				(sky1 posn: 3 70 setMotion: MoveTo 101 70)
				(sky0 setMotion: MoveTo 199 70 self)
			)
			(70
				(-= state 3)
				(= cycles 1)
			)
		)
	)
)

(instance trailerScript of HandsOffScript
	(properties)

	(method (doit)
		(super doit:)
		(if (and local0 local2)
			(Sound pause: 1)
			(switch
				(= local1
					(Print
						{Would you like to restart,\nrestore a game, or quit?\n}
						82
						coreyIcon
						0
						0
						67
						30
						60
						106
						81
						{Restart}
						2
						106
						81
						{Restore a Game}
						1
						106
						81
						{Quit}
						3
					)
				)
				(1
					(Sound pause: 0)
					(gGame restore:)
				)
				(2
					(gCast eachElementDo: #dispose)
					(gGame restart:)
				)
				(3
					(Sound pause: 0)
					(= local0 0)
					(self changeState: 9)
				)
				(else
					(Sound pause: 0)
				)
			)
			(gGame setCursor: 50 0 1000 1000)
			(= local2 0)
			((User curEvent:) type: evNULL)
		)
		(if ((User curEvent:) type:)
			(gGame setCursor: 80 1 103 104)
			(= local2 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 240)
			)
			(1
				(titleWipeOn show: setCycle: End self)
			)
			(2
				(= local0 1)
				(= ticks 240)
			)
			(3
				(shuttle
					posn: 81 104
					show:
					setCycle: Fwd
					setMotion: MoveTo 200 56 self
				)
			)
			(4
				(shuttle hide:)
				(= ticks 240)
			)
			(5
				(balloon
					posn: 205 90
					show:
					setCycle: Fwd
					setMotion: MoveTo 95 91 self
				)
			)
			(6
				(balloon hide:)
				(= ticks 120)
			)
			(7
				(titleWipeOn setCel: 0)
				(titleWipeOff show: setCel: 0 setCycle: End self)
			)
			(8
				(self changeState: 0)
			)
			(9
				(gCMusic fade: 0 10 4 1 self)
			)
			(10
				(gCMusic number: 423 play:)
				(Load rsPIC 421)
				(gCast eachElementDo: #dispose)
				(= cycles 1)
			)
			(11
				(localproc_0)
				(= cycles 1)
			)
			(12
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(13
				(= local6 (Display 480 22 dsALIGN alCENTER dsCOORD 80 80 dsFONT 200 dsCOLOR 0 dsSAVEPIXELS)) ; "I ' L L  B E  B A C K !#j\cf\c0 \b1\c4\c3\de \d3\c4\de\af\c3\b8\d9 \d6!"
				(= ticks 60)
			)
			(14
				(gCMusic setVol: 6)
				(gCMusic2 number: 969 loop: 0 play: self)
				(= ticks 480)
			)
			(15
				(= ticks 120)
			)
			(16
				(Display 480 23 dsRESTOREPIXELS local6)
				(= gQuit 1)
			)
		)
	)
)

(instance display1 of Prop
	(properties
		x 69
		y 49
		view 480
		cel 1
		priority 1
		signal 16
	)
)

(instance display2 of Prop
	(properties
		x 85
		y 91
		view 480
		loop 1
		cel 7
		priority 1
		signal 16
	)
)

(instance leftReels of Prop
	(properties
		x 64
		y 79
		view 480
		loop 2
		cel 5
		priority 1
	)
)

(instance display3 of Prop
	(properties
		x 42
		y 110
		view 480
		loop 3
		cel 4
		priority 1
		signal 16
	)
)

(instance display4 of Prop
	(properties
		x 114
		y 46
		view 480
		loop 4
		priority 1
		signal 16
	)
)

(instance display5 of Prop
	(properties
		x 183
		y 47
		view 480
		loop 5
		priority 10
		signal 16
	)
)

(instance display6 of Prop
	(properties
		x 153
		y 56
		view 480
		loop 6
		cel 8
		priority 11
		signal 16
	)
)

(instance display7 of Prop
	(properties
		x 214
		y 100
		view 480
		loop 7
		priority 15
		signal 16
	)
)

(instance display8 of Prop
	(properties
		x 239
		y 92
		view 480
		loop 8
		cel 5
		priority 15
		signal 16
	)
)

(instance rightReels of Prop
	(properties
		x 296
		y 97
		view 480
		loop 9
		cel 6
		priority 15
		signal 16
	)
)

(instance leftScreen of Prop
	(properties
		x 75
		y 29
		view 481
	)
)

(instance rightScreen of Prop
	(properties
		x 253
		y 39
		view 482
	)
)

(instance lcdDigits of Prop
	(properties
		x 168
		y 22
		view 480
		loop 10
		cel 1
	)
)

(instance drBrain of Actor
	(properties
		x 12
		y 177
		view 485
		priority 6
		signal 16
	)
)

(instance drHeadOnScreen of Prop
	(properties
		x 147
		y 120
		view 490
		priority 14
		signal 16400
	)
)

(instance drEyesOnScreen of Prop
	(properties
		x 149
		y 98
		view 490
		loop 2
		priority 15
		signal 16
		cycleSpeed 18
	)
)

(instance drMouthOnScreen of Prop
	(properties
		x 149
		y 118
		view 490
		loop 1
		priority 15
		signal 16
		cycleSpeed 12
	)
)

(instance drEyebrowsOnScreen of Prop
	(properties
		x 149
		y 97
		view 490
		loop 3
		priority 15
		signal 16400
		cycleSpeed 18
	)
)

(instance island of View
	(properties
		x 108
		y 80
		view 486
		priority 10
		signal 16
	)
)

(instance sky0 of Actor
	(properties
		x 3
		y 70
		view 486
		loop 1
		priority 8
		signal 16400
		cycleSpeed 24
		xStep 1
		moveSpeed 24
	)
)

(instance sky1 of Actor
	(properties
		x 101
		y 70
		view 486
		loop 1
		cel 1
		priority 8
		signal 16400
		cycleSpeed 24
		xStep 1
		moveSpeed 24
	)
)

(instance skyMask of PicView
	(properties
		x 3
		y 70
		view 486
		loop 3
		priority 9
		signal 16400
	)
)

(instance ocean of Prop
	(properties
		x 109
		y 101
		view 486
		loop 2
		priority 11
		signal 16
	)
)

(instance titleWipeOn of Prop
	(properties
		x 122
		y 94
		view 486
		loop 4
		priority 15
		signal 16400
		cycleSpeed 3
	)
)

(instance titleWipeOff of Prop
	(properties
		x 122
		y 94
		view 486
		loop 7
		priority 15
		signal 16400
		cycleSpeed 3
	)
)

(instance shuttle of Actor
	(properties
		x 81
		y 104
		view 486
		loop 5
		priority 12
		signal 16400
		cycleSpeed 3
		moveSpeed 3
	)
)

(instance balloon of Actor
	(properties
		x 205
		y 90
		view 486
		loop 6
		priority 12
		signal 16400
		cycleSpeed 12
		moveSpeed 18
	)
)

(instance shuttleMask of View
	(properties
		x 72
		y 95
		view 486
		loop 3
		cel 1
		priority 13
		signal 16
	)
)

(instance shuttleMaskTop of View
	(properties
		x 161
		y 40
		view 486
		loop 3
		cel 2
		priority 13
		signal 16
	)
)

(instance balloonMaskRight of View
	(properties
		x 196
		y 77
		view 486
		loop 3
		cel 3
		priority 13
		signal 16
	)
)

(instance balloonMaskLeft of View
	(properties
		x 80
		y 76
		view 486
		loop 3
		cel 4
		priority 13
		signal 16
	)
)

(instance coreyIcon of DCIcon
	(properties
		view 481
		loop 13
		cycleSpeed 12
	)

	(method (init)
		((= cycler (Osc new:)) init: self)
	)
)

