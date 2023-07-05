;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use RangeOsc)
(use Osc)
(use n940)
(use RandCycle)
(use MoveFwd)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1 0
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
)

(instance rm1 of Rm
	(properties
		picture 106
		style 7
	)

	(method (init)
		(LoadMany rsVIEW 602 118 119 601 198 600 114)
		(LoadMany rsPIC 300 301 302 303 14 120 121 122 123 124 125 126 127)
		(LoadMany rsSOUND 1 464 2 3 5 6 803)
		(gTheIconBar disable:)
		(super init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gGame setCursor: gWaitCursor 0)
		(self setScript: open1)
	)

	(method (doit)
		(super doit:)
		(switch curPic
			(300
				(if (> (++ local1) 2)
					(Palette palANIMATE 224 255 -1)
					(= local1 0)
				)
			)
			(301
				(if (> (++ local1) 4)
					(= local1 0)
				)
			)
			(302
				(if (> (++ local1) 0)
					(Palette palANIMATE 224 255 -1)
					(Palette palANIMATE 15 39 1)
					(Palette palANIMATE 56 63 1)
					(Palette palANIMATE 196 197 1)
					(= local1 0)
				)
				(if (& (sputnik onControl: 0) $0002)
					(shadow
						x: (+ (sputnik x:) 15)
						y: (+ (sputnik y:) 10)
						cel: (sputnik cel:)
						show:
					)
				else
					(shadow hide:)
				)
			)
			(303
				(if (> (++ local1) 2)
					(Palette palANIMATE 224 255 -1)
					(= local1 0)
				)
				(if (and local5 (not (-- local0)))
					(+= local5 local4)
					(Palette palSET_INTENSITY 224 255 local5)
					(if (not local5)
						(self cue:)
					)
					(if (== local5 100)
						(= local5 0)
					)
					(= local0 1)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if
			(and
				(event type:)
				(!= script open4)
				(!= (event message:) KEY_F2)
				(== gCurRoomNum gNewRoomNum)
			)
			(event claimed: 1)
			(Sound pause: 1)
			(gTheIconBar enable:)
			(gGame setCursor: gNormalCursor 1 160 100)
			(switch
				(PrintD
					{Would you like to skip\nthe introduction or\nwatch the whole thing?}
					67
					100
					60
					106
					81
					{Skip it}
					1
					106
					81
					{Watch it}
					2
					106
					81
					{Restore a Game}
					3
				)
				(1
					(if (!= (gLongSong number:) 2)
						(gLongSong number: 2 loop: -1 play:)
					else
						(Sound pause: 0)
					)
					(if local10
						(Display 1 0 dsRESTOREPIXELS local10)
						(= local10 0)
					)
					(if local11
						(Display 1 0 dsRESTOREPIXELS local11)
						(= local11 0)
					)
					(self setScript: open4)
					(= local9 1)
				)
				(2
					(Sound pause: 0)
				)
				(3
					(Sound pause: 0)
					(gGame restore:)
				)
			)
			(Sound pause: 0)
			(gTheIconBar disable: hide:)
			(gGame setCursor: gWaitCursor 0)
		)
	)
)

(instance open1 of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local6 (== (gLongSong prevSignal:) -1))
			(gLongSong prevSignal: 0)
			(self cue:)
		)
		(if (and (== state 1) (== (gLongSong prevSignal:) 10))
			(gLongSong prevSignal: 0)
			(self cue:)
		)
		(if (and local7 (>= (ship x:) 320))
			(= local7 0)
			(gLongSong2 hold: 0)
		)
		(if (and local8 (<= (ship x:) 0))
			(= local8 0)
			(gLongSong2 hold: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGame setCursor: gTheCursor 0)
				(= cycles 1)
			)
			(1
				(gLongSong number: 1 loop: -1 flags: 0 play:)
				0
			)
			(2
				(neon1 init: cycleSpeed: 20 setCycle: Fwd)
				(neon2 init: cycleSpeed: 20 setCycle: Fwd)
				(neon3 init: cycleSpeed: 20 setCycle: Fwd)
				(sign1 init: posn: 223 165 setCycle: RangeOsc -1 0 0)
				(gCurRoom drawPic: 300 -32759)
				(= seconds 2)
			)
			(3
				(= local10
					(proc0_12
						{\03 1991 Sierra On-Line, Inc.}
						30
						0
						28
						global135
						29
						global129
						70
						240
						67
						63
						181
					)
				)
				(= seconds 5)
			)
			(4
				(sign1
					posn: 208 159
					cycleSpeed: 8
					setLoop: 1
					cel: 0
					setCycle: RangeOsc 4 0 1 self
				)
				(sfxSnd number: 6 play:)
			)
			(5
				(Display 1 0 dsRESTOREPIXELS local10)
				(= local10 0)
				(= seconds 2)
			)
			(6
				(sfxSnd stop:)
				(sign1 setCycle: End self)
			)
			(7
				(sign1 dispose:)
				(neon1 dispose:)
				(neon2 dispose:)
				(neon3 dispose:)
				(gCurRoom drawPic: 301 13)
				(globe1 init: setCycle: Fwd)
				(= cycles 10)
			)
			(8
				(= local7 1)
				(gLongSong2 number: 4 loop: 1 play: 40 hold: 1)
				(ship
					init:
					setLoop: 5
					cel: 0
					setPri: 0
					xStep: 6
					yStep: 6
					moveSpeed: 4
					setMotion: MoveTo 145 30 self
				)
				(flame1 init: cycleSpeed: 4 setCycle: Fwd)
			)
			(9
				(ship setCycle: End setMotion: MoveTo 199 45 self)
			)
			(10
				(ship setCycle: Beg setMotion: MoveTo 275 53 self)
			)
			(11
				(ship setMotion: MoveTo 399 50 self)
			)
			(12
				(= seconds 2)
				(flame1 dispose:)
			)
			(13
				(= local8 1)
				(gLongSong2 number: 4 loop: 1 play: 80 hold: 1)
				(ship
					setLoop: 2
					cel: 0
					posn: 360 135
					xStep: 8
					yStep: 8
					moveSpeed: 2
					setMotion: MoveTo 237 137 self
				)
				(flame2 init: cycleSpeed: 2 setCycle: Fwd)
			)
			(14
				(ship setCycle: End setMotion: MoveTo 109 162 self)
			)
			(15
				(ship setCycle: Beg setMotion: MoveTo 43 173 self)
			)
			(16
				(ship setMotion: MoveTo -40 175 self)
			)
			(17
				(= seconds 2)
				(flame2 dispose:)
			)
			(18
				(= local7 1)
				(gLongSong2 number: 4 loop: 1 play: hold: 1)
				(ship
					setLoop: 1
					cel: 0
					posn: 0 50
					xStep: 10
					yStep: 8
					setPri: 5
					moveSpeed: 0
					setMotion: MoveTo 77 49 self
				)
				(flame3 init: cycleSpeed: 0 setCycle: Fwd)
			)
			(19
				(ship setCycle: End setMotion: MoveTo 220 98 self)
			)
			(20
				(ship setCycle: Beg setMotion: MoveTo 283 110 self)
			)
			(21
				(ship setMotion: MoveTo 418 110 self)
			)
			(22
				(flame3 dispose:)
				(globe1 dispose:)
				(ship dispose:)
				(letterS init: hide: cycleSpeed: 0)
				(letterA init: hide: cycleSpeed: 0)
				(letterR init: hide: cycleSpeed: 0)
				(letterI init: hide: cycleSpeed: 0)
				(letterE init: hide: cycleSpeed: 0)
				(letterN init: hide: cycleSpeed: 0)
				(gCurRoom drawPic: 302 13)
				(jet1 init: cycleSpeed: 2 setCycle: Fwd)
				(jet2 init: cycleSpeed: 2 setCycle: Fwd)
				(electricalThing init: setCycle: RandCycle cycleSpeed: 0)
				(shadow init: setLoop: 15 setPri: 11 hide:)
				(gSoundEffects number: 464 loop: -1 play: 40 fade: 127 30 20 0)
				(sputnik
					init:
					view: 602
					loop: 3
					cel: 0
					x: 52
					y: 4
					xStep: 4
					yStep: 4
					moveSpeed: 1
					posn: -182 -24
					setMotion: MoveTo 357 57 sputnik
					setPri: 12
					cycleSpeed: 4
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(23
				(sfxSnd number: 5 play:)
				(letterA setCycle: Fwd show:)
				(= cycles 5)
			)
			(24
				(letterA hide:)
				(letterS setCycle: Fwd show:)
				(= cycles 5)
			)
			(25
				(letterS hide:)
				(letterA setCycle: Fwd show:)
				(= cycles 5)
			)
			(26
				(letterA hide:)
				(letterR setCycle: Fwd show:)
				(= cycles 5)
			)
			(27
				(letterR hide:)
				(letterI setCycle: Fwd show:)
				(= cycles 5)
			)
			(28
				(letterI hide:)
				(letterE setCycle: Fwd show:)
				(= cycles 5)
			)
			(29
				(letterE hide:)
				(letterN setCycle: Fwd show:)
				(= cycles 5)
			)
			(30
				(letterN hide:)
				(letterE setCycle: Fwd show:)
				(= cycles 5)
			)
			(31
				(letterE hide:)
				(letterI setCycle: Fwd show:)
				(= cycles 5)
			)
			(32
				(letterI hide:)
				(letterR setCycle: Fwd show:)
				(= cycles 5)
			)
			(33
				(letterR hide:)
				(letterA setCycle: Fwd show:)
				(= cycles 5)
			)
			(34
				(letterA hide:)
				(letterS setCycle: Fwd show:)
				(= cycles 5)
			)
			(35
				(letterS hide:)
				(= cycles 60)
			)
			(36
				(jet1 dispose:)
				(jet2 dispose:)
				(shadow dispose:)
				(electricalThing dispose:)
				(sfxSnd stop:)
				(letterS dispose:)
				(letterA dispose:)
				(letterR dispose:)
				(letterI dispose:)
				(letterE dispose:)
				(letterN dispose:)
				(LoadMany rsPIC 303 120 121 122 123 124 125 126 127)
				(= ticks 1)
			)
			(37
				(gCurRoom drawPic: 303 13)
				(sputnik
					init:
					posn: 340 120
					view: 602
					setLoop: 2
					setStep: 5 3
					moveSpeed: 6
					cycleSpeed: 6
					setCycle: Rev
					hide:
				)
				(= seconds 2)
			)
			(38
				(= local5 1)
				(= local4 1)
				(= local0 1)
				(gSoundEffects number: 464 loop: -1 play: 40 fade: 127 30 20 0)
				(sputnik show: setMotion: MoveTo -10 240)
				(gCurRoom overlay: 120 100)
				(= seconds 5)
			)
			(39
				(= local5 99)
				(= local4 -1)
				(= local0 1)
			)
			(40
				(sputnik dispose:)
				(gCurRoom drawPic: 303 100)
				(= seconds 2)
			)
			(41
				(= local5 1)
				(= local4 1)
				(= local0 1)
				(gCurRoom overlay: 121 100)
				(= seconds 1)
			)
			(42
				(comet init: posn: -40 40 setMotion: MoveTo 1 41 self)
			)
			(43
				(comet cel: 1 setMotion: MoveTo 18 40 self)
			)
			(44
				(comet cel: 2 setMotion: MoveTo 48 42 self)
			)
			(45
				(comet cel: 3 setMotion: MoveTo 72 47 self)
			)
			(46
				(comet cel: 4 setMotion: MoveTo 95 52 self)
			)
			(47
				(comet cel: 5 setMotion: MoveTo 120 59 self)
			)
			(48
				(comet cel: 6 setMotion: MoveTo 141 67 self)
			)
			(49
				(comet cel: 7 setMotion: MoveTo 163 75 self)
			)
			(50
				(comet cel: 8 setMotion: MoveTo 184 82 self)
			)
			(51
				(comet cel: 9 setMotion: MoveTo 203 91 self)
			)
			(52
				(comet cel: 10 setMotion: MoveTo 222 100 self)
			)
			(53
				(comet cel: 11 setMotion: MoveTo 239 108 self)
			)
			(54
				(comet cel: 12 setMotion: MoveTo 256 116 self)
			)
			(55
				(comet cel: 13 setMotion: MoveTo 272 126 self)
			)
			(56
				(comet cel: 14 setMotion: MoveTo 289 137 self)
			)
			(57
				(comet cel: 15 setMotion: MoveTo 304 147 self)
			)
			(58
				(comet cel: 14 setMotion: MoveTo 340 155 self)
			)
			(59
				(= cycles 10)
				(comet dispose:)
			)
			(60
				(= local5 99)
				(= local4 -1)
				(= local0 1)
			)
			(61
				(gCurRoom drawPic: 303 100)
				(= seconds 2)
			)
			(62
				(= local5 1)
				(= local4 1)
				(= local0 1)
				(gCurRoom overlay: 122 100)
				(sputnik
					init:
					posn: -30 -30
					view: 602
					setLoop: 0
					setStep: 5 3
					moveSpeed: 6
					cycleSpeed: 6
					setCycle: Rev
					setMotion: MoveTo 330 200
				)
				(= seconds 7)
			)
			(63
				(= local5 99)
				(= local4 -1)
				(= local0 1)
			)
			(64
				(sputnik dispose:)
				(gCurRoom drawPic: 303 100)
				(= seconds 2)
			)
			(65
				(gSoundEffects number: 464 loop: -1 play: 40 fade: 127 30 20 0)
				(ship
					init:
					view: 118
					setLoop: 3
					posn: 21 200
					setCycle: Fwd
					cycleSpeed: 6
					setStep: 3 2
					moveSpeed: 2
					setMotion: MoveTo 330 5 ship
				)
				(gCurRoom overlay: 123 100)
				(= seconds 2)
			)
			(66
				(= local5 1)
				(= local4 1)
				(= local0 1)
				(= seconds 6)
			)
			(67
				(= local5 99)
				(= local4 -1)
				(= local0 1)
			)
			(68
				(gCurRoom drawPic: 303 100)
				(gCurRoom overlay: 124 100)
				(= local7 1)
				(gLongSong2 number: 4 loop: 1 play: 40 hold: 1)
				(ship
					view: 601
					setCycle: 0
					setLoop: 5
					cycleSpeed: 0
					x: -32
					y: 20
					cel: 0
					setPri: 0
					xStep: 6
					yStep: 6
					moveSpeed: 4
					setMotion: MoveTo 145 30 self
				)
				(flame1 init: cycleSpeed: 4 setCycle: Fwd)
			)
			(69
				(ship setCycle: End setMotion: MoveTo 199 45 self)
			)
			(70
				(= local5 1)
				(= local4 1)
				(= local0 1)
				(ship setCycle: Beg setMotion: MoveTo 275 53 self)
			)
			(71
				(ship setMotion: MoveTo 399 50 self)
			)
			(72
				(= seconds 2)
				(flame1 dispose:)
			)
			(73
				(= local8 1)
				(gLongSong2 number: 4 loop: 1 play: 80 hold: 1)
				(ship
					setLoop: 2
					cel: 0
					posn: 360 135
					xStep: 8
					yStep: 8
					moveSpeed: 2
					setMotion: MoveTo 237 137 self
				)
				(flame2 init: cycleSpeed: 2 setCycle: Fwd)
			)
			(74
				(ship setCycle: End setMotion: MoveTo 109 162 self)
			)
			(75
				(ship setCycle: Beg setMotion: MoveTo 43 173 self)
			)
			(76
				(ship setMotion: MoveTo -40 175 self)
			)
			(77
				(= seconds 2)
				(flame2 dispose:)
			)
			(78
				(= local5 99)
				(= local4 -1)
				(= local0 1)
				(= local7 1)
				(gLongSong2 number: 4 loop: 1 play: hold: 1)
				(ship
					setLoop: 1
					cel: 0
					posn: 0 50
					xStep: 10
					yStep: 8
					setPri: 15
					moveSpeed: 0
					setMotion: MoveTo 77 49 self
				)
				(flame3 init: cycleSpeed: 0 setCycle: Fwd)
			)
			(79
				(ship setCycle: End setMotion: MoveTo 220 98 self)
			)
			(80
				(ship setCycle: Beg setMotion: MoveTo 283 110 self)
			)
			(81
				(ship setMotion: MoveTo 418 110 self)
			)
			(82
				(= seconds 4)
				(ship dispose:)
				(flame3 dispose:)
			)
			(83
				(sputnik
					init:
					posn: 224 175
					view: 119
					cel: 8
					setLoop: 0
					setStep: 5 3
					moveSpeed: 6
					cycleSpeed: 10
				)
				(gCurRoom drawPic: 303 100)
				(= seconds 2)
			)
			(84
				(= local5 1)
				(= local4 1)
				(= local0 1)
				(gCurRoom overlay: 125 100)
				(= seconds 3)
			)
			(85
				(sputnik setMotion: MoveTo 224 0)
				(= seconds 1)
			)
			(86
				(sputnik setCycle: Beg)
				(= seconds 3)
			)
			(87
				(sputnik setCycle: End)
				(= seconds 3)
			)
			(88
				(sputnik dispose:)
				(= local5 99)
				(= local4 -1)
				(= local0 1)
				(= seconds 3)
			)
			(89
				(gCurRoom drawPic: 303 100)
				(= seconds 2)
			)
			(90
				(gCurRoom overlay: 126 100)
				(ship
					init:
					view: 118
					setLoop: 0
					setStep: 2 1
					cycleSpeed: 4
					moveSpeed: 2
					posn: 204 -7
					setCycle: Fwd
					setMotion: MoveTo -10 136
				)
				(arcada
					init:
					view: 118
					setLoop: 1
					setStep: 3 2
					cycleSpeed: 6
					moveSpeed: 2
					setCycle: Rev
					posn: 330 -10
					setMotion: MoveTo -10 220
				)
				(deltaur
					init:
					view: 118
					setLoop: 2
					setStep: 1 1
					cycleSpeed: 3
					moveSpeed: 2
					setCycle: Fwd
					posn: 330 77
					setMotion: MoveTo 164 220
				)
				(= seconds 1)
			)
			(91
				(= local5 1)
				(= local4 1)
				(= local0 1)
				(= seconds 6)
			)
			(92
				(= local5 99)
				(= local4 -1)
				(= local0 1)
			)
			(93
				(ship dispose:)
				(deltaur dispose:)
				(arcada dispose:)
				(= seconds 3)
			)
			(94
				(gCurRoom drawPic: 303 100)
				(= seconds 1)
			)
			(95
				(= local5 1)
				(= local4 1)
				(= local0 1)
				(gLongSong number: 2 loop: -1 play:)
				(gCurRoom overlay: 127 100)
				(= seconds 1)
			)
			(96
				(arcada
					init:
					view: 198
					setHeading: 288
					setLoop: 1
					setCel: 0
					xStep: 3
					yStep: 1
					moveSpeed: 3
					x: 280
					y: 200
					setMotion: MoveFwd 1000
				)
				(= seconds 6)
			)
			(97
				(deltaur
					init:
					signal: (| (deltaur signal:) $6000)
					show:
					view: 198
					setLoop: 0
					setCel: 0
					moveSpeed: 2
					x: 380
					y: -20
					setStep: 3 1
					setMotion: MoveTo 220 40 self
				)
			)
			(98
				(deltaur setHeading: 270 setMotion: MoveFwd 280)
				(= seconds 2)
			)
			(99
				(= local5 99)
				(= local4 -1)
				(= local0 1)
			)
			(100
				(gCurRoom drawPic: 303 100)
				(= seconds 2)
			)
			(101
				(arcada dispose:)
				(deltaur dispose:)
				(= cycles 10)
			)
			(102
				(gCurRoom drawPic: 303 100)
				(= seconds 1)
			)
			(103
				(arcada
					init:
					view: 198
					setHeading: 288
					setLoop: 1
					setCel: 0
					xStep: 3
					yStep: 1
					moveSpeed: 3
					x: 330
					y: 200
					setMotion: MoveFwd 1000
				)
				(= seconds 2)
			)
			(104
				(deltaur
					init:
					signal: (| (deltaur signal:) $6000)
					show:
					view: 198
					setLoop: 0
					setCel: 0
					moveSpeed: 2
					x: 380
					y: -20
					setStep: 3 1
					setMotion: MoveTo 220 43 self
				)
			)
			(105
				(deltaur setHeading: 270 setMotion: MoveFwd 280 self)
			)
			(106
				(arcada dispose:)
				(deltaur dispose:)
				(= cycles 10)
			)
			(107
				(= local11
					(Display ; "As we join our story, the crew of the Arcada is returning home to Xenon after a successful mission developing the Star Generator.  Exhilarated by their accomplishments, they are oblivious to the fact that a sinister craft approaches rapidly from behind."
						1
						1
						dsALIGN
						alCENTER
						dsFONT
						300
						dsCOLOR
						global135
						dsWIDTH
						240
						dsCOORD
						40
						30
						dsSAVEPIXELS
					)
				)
				(= seconds 15)
			)
			(108
				(Display 1 0 dsRESTOREPIXELS local11)
				(= local11 0)
				(= seconds 2)
			)
			(109
				(self setScript: open4 self)
			)
			(110
				(= local6 1)
			)
			(111
				(= local6 0)
				(gCurRoom setScript: leave)
			)
		)
	)
)

(instance leave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(gTheIconBar disable: hide:)
				(gGame setCursor: gWaitCursor 0)
				(gCurRoom drawPic: 99 -32759)
				(= seconds 1)
			)
			(1
				(Palette palSET_INTENSITY 0 255 100)
				(gCurRoom newRoom: 4)
				(self dispose:)
			)
		)
	)
)

(instance open4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palSET_INTENSITY 0 256 100)
				(gCurRoom drawPic: 14 -32759)
				(gCast eachElementDo: #hide)
				(armsL init: setPri: 12)
				(armsR init:)
				(star1 setCycle: Osc -1 init:)
				(star2 setCycle: Osc -1 init:)
				(star3 setCycle: Osc -1 init:)
				(armsL stopUpd:)
				(armsR stopUpd:)
				(= seconds 2)
			)
			(1
				(armsL startUpd: setCycle: Beg)
				(armsR startUpd: setCycle: End self)
			)
			(2
				(gSoundEffects number: 803 loop: 1 play:)
				(ShakeScreen 3 7) ; ssFULL_SHAKE | $0004
				(armsR stopUpd:)
				(armsL stopUpd:)
				(= seconds 2)
			)
			(3
				(gLongSong number: 3 loop: 1 play:)
				(= seconds 4)
			)
			(4
				(if local9
					(gCurRoom setScript: leave)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance comet of Actor
	(properties
		x 1
		y 41
		yStep 3
		view 602
		loop 14
		priority 1
		signal 26640
		xStep 4
	)
)

(instance ship of Actor
	(properties
		x -32
		y 20
		view 601
		loop 2
		signal 24592
		xStep 4
	)

	(method (cue)
		(gSoundEffects fade:)
	)
)

(instance sign1 of Prop
	(properties
		x 218
		y 157
		view 600
		cycleSpeed 4
	)

	(method (init)
		(super init:)
	)
)

(instance globe1 of Prop
	(properties
		x 240
		y 169
		view 601
		loop 6
		cycleSpeed 4
	)
)

(instance sputnik of Actor
	(properties
		x 52
		y 4
		yStep 6
		view 602
		loop 3
		signal 18448
		xStep 6
	)

	(method (cue)
		(gSoundEffects fade: 0 30 20 1)
	)

	(method (dispose)
		(gSoundEffects fade: 0 30 20 1)
		(super dispose:)
	)
)

(instance shadow of Actor
	(properties
		x 52
		y 34
		yStep 6
		view 602
		loop 15
		signal 18448
		xStep 6
	)
)

(instance jet1 of Prop
	(properties
		x 116
		y 179
		view 602
		loop 5
		cel 4
		signal 16400
		cycleSpeed 1
	)
)

(instance jet2 of Prop
	(properties
		x 211
		y 178
		view 602
		loop 6
		cel 4
		signal 16400
		cycleSpeed 1
	)
)

(instance electricalThing of Prop
	(properties
		x 128
		y 69
		view 602
		loop 4
		priority 11
		signal 16400
		cycleSpeed 5
	)
)

(instance neon1 of Actor
	(properties
		x 25
		y 70
		view 600
		loop 2
		priority 10
		signal 16
		cycleSpeed 2
	)
)

(instance neon2 of Actor
	(properties
		x 104
		y 145
		view 600
		loop 3
		priority 10
		signal 16
		cycleSpeed 2
	)
)

(instance neon3 of Actor
	(properties
		x 296
		y 24
		view 600
		loop 4
		priority 10
		signal 16
		cycleSpeed 2
	)
)

(instance letterS of Prop
	(properties
		x 74
		y 92
		view 602
		loop 7
		cel 2
		priority 10
		signal 16
	)
)

(instance letterA of Prop
	(properties
		x 115
		y 94
		view 602
		loop 8
		cel 4
		priority 10
		signal 16
	)
)

(instance letterR of Prop
	(properties
		x 145
		y 97
		view 602
		loop 9
		priority 10
		signal 16
	)
)

(instance letterI of Prop
	(properties
		x 176
		y 95
		view 602
		loop 10
		cel 3
		priority 10
		signal 16
	)
)

(instance letterE of Prop
	(properties
		x 199
		y 93
		view 602
		loop 11
		cel 5
		priority 10
		signal 16
	)
)

(instance letterN of Prop
	(properties
		x 249
		y 95
		view 602
		loop 12
		cel 2
		priority 10
		signal 16
	)
)

(instance flame1 of Prop
	(properties
		view 601
		loop 12
		signal 18448
	)

	(method (doit)
		(self x: (- (ship x:) 1) y: (+ (ship y:) 1))
		(super doit: &rest)
	)
)

(instance flame2 of Prop
	(properties
		view 601
		loop 9
		signal 18448
	)

	(method (doit)
		(self x: (+ (ship x:) 0) y: (- (ship y:) 2))
		(super doit: &rest)
	)
)

(instance flame3 of Prop
	(properties
		view 601
		loop 8
		priority 9
		signal 18448
	)

	(method (doit)
		(cond
			((< (ship cel:) 3)
				(flame3 y: (- (ship y:) 0))
			)
			((< (ship cel:) 6)
				(flame3 y: (- (ship y:) 2))
			)
			((== (ship cel:) 6)
				(flame3 y: (- (ship y:) 4))
			)
			((== (ship cel:) 8)
				(flame3 y: (- (ship y:) 6))
			)
		)
		(flame3 x: (- (ship x:) 66))
		(super doit: &rest)
	)
)

(instance arcada of Actor
	(properties
		x 319
		y 189
		yStep 1
		view 198
		loop 1
		signal 16384
		moveSpeed 2
	)
)

(instance deltaur of Actor
	(properties
		x 330
		view 198
		signal 16384
		xStep 4
		moveSpeed 2
	)
)

(instance armsL of Prop
	(properties
		x 201
		y 78
		view 114
		cel 2
		signal 24576
		cycleSpeed 24
	)
)

(instance armsR of Prop
	(properties
		x 159
		y 98
		view 114
		loop 3
		signal 24576
		cycleSpeed 24
	)
)

(instance star1 of Prop
	(properties
		x 39
		y 156
		view 114
		loop 1
		cel 1
		cycleSpeed 14
	)
)

(instance star2 of Prop
	(properties
		x 279
		y 15
		view 114
		loop 1
		cel 2
		cycleSpeed 12
	)
)

(instance star3 of Prop
	(properties
		x 280
		y 176
		view 114
		loop 2
		cel 4
		cycleSpeed 8
	)
)

(instance sfxSnd of Sound
	(properties
		loop -1
	)
)

