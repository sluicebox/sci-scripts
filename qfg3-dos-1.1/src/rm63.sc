;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm63 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm63 of Rm
	(properties
		picture 146
	)

	(method (init &tmp temp0)
		(super init:)
		(= local5 1)
		(= local4 0)
		(gTheIconBar disable:)
		(Load rsVIEW 920)
		(Load rsVIEW 921)
		(Load rsVIEW 922)
		(Load rsVIEW 923)
		(Load rsSOUND 350)
		(Load rsSOUND 320)
		(Load rsSOUND 330)
		(Load rsSOUND 230)
		(Load rsSOUND 622)
		(Load rsSOUND 833)
		(Load rsSOUND 840)
		(Load rsSOUND 845)
		(Load rsSOUND 880)
		(Load rsSOUND 100)
		(= local3 (gGame setCursor: 996 1))
		(SetCursor 0)
		(Palette palSET_INTENSITY 0 255 100)
	)

	(method (doit &tmp temp0)
		(if local5
			(= local5 0)
			(doCredits init: self)
			(creditsMusic init: self)
			(for
				((= temp0 (Event new:)))
				(not (OneOf (temp0 type:) evKEYBOARD evMOUSEBUTTON evJOYDOWN))
				((= temp0 (Event new:)))
				
				(temp0 dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(doCredits doit:)
				(creditsMusic doit:)
				(gSounds eachElementDo: #check)
				(gSounds eachElementDo: #doit)
				(Animate (gCast elements:) 1)
				(if gDoMotionCue
					(= gDoMotionCue 0)
					(gCast eachElementDo: #motionCue)
				)
			)
			(temp0 dispose:)
			(doCredits dispose:)
			(creditsMusic dispose:)
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (dispose)
		(UnLoad 128 920)
		(UnLoad 128 921)
		(UnLoad 128 922)
		(UnLoad 128 923)
		(Lock rsSOUND 350 0)
		(Lock rsSOUND 320 0)
		(Lock rsSOUND 330 0)
		(Lock rsSOUND 230 0)
		(Lock rsSOUND 622 0)
		(Lock rsSOUND 833 0)
		(Lock rsSOUND 840 0)
		(Lock rsSOUND 845 0)
		(Lock rsSOUND 100 0)
		(Lock rsSOUND 880 0)
		(SetCursor 1)
		(gGame setCursor: local3 1)
		(gTheIconBar enable:)
		(gGame setScript: 0)
		(super dispose:)
	)
)

(instance doCredits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((= local0 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 0
					setCel: 0
					x: 160
					priority: 0
					y: 230
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 71 self
					init:
				)
			)
			(1
				((= local1 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 0
					setCel: 1
					x: 160
					y: 230
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 106 self
					init:
				)
			)
			(2
				((= local2 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 0
					setCel: 2
					x: 160
					y: 230
					moveSpeed: 2
					yStep: 3
					priority: 2
					setMotion: MoveTo 160 131 self
					init:
				)
			)
			(3
				(= ticks 137)
			)
			(4
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15)
				(local2 setMotion: MoveTo 160 -15 self)
			)
			(5
				(local0 dispose:)
				(local1 dispose:)
				(local2 dispose:)
				(= cycles 2)
			)
			(6
				((= local0 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 2
					setCel: 0
					x: 160
					priority: 0
					y: 230
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 77 self
					init:
				)
			)
			(7
				((= local1 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 0
					setCel: 1
					x: 160
					y: 230
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 106 self
					init:
				)
			)
			(8
				(= ticks 137)
			)
			(9
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(10
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(11
				((= local0 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 4
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 67 self
					init:
				)
			)
			(12
				((= local1 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 4
					setCel: 1
					x: 160
					y: 230
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 104 self
					init:
				)
			)
			(13
				(= ticks 137)
			)
			(14
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(15
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(16
				((= local0 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 6
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 72 self
					init:
				)
			)
			(17
				((= local1 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 6
					setCel: 1
					x: 160
					y: 230
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 109 self
					init:
				)
			)
			(18
				(= ticks 137)
			)
			(19
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(20
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(21
				((= local0 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 8
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 83 self
					init:
				)
			)
			(22
				((= local1 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 8
					setCel: 1
					x: 160
					y: 230
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 114 self
					init:
				)
			)
			(23
				(= ticks 137)
			)
			(24
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(25
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(26
				((= local0 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 10
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 77 self
					init:
				)
			)
			(27
				((= local1 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 10
					setCel: 1
					x: 160
					y: 230
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 111 self
					init:
				)
			)
			(28
				(= ticks 137)
			)
			(29
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(30
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(31
				((= local0 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 12
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 79 self
					init:
				)
			)
			(32
				((= local1 (Actor new:))
					view: 920
					signal: 24592
					setLoop: 12
					setCel: 1
					x: 160
					y: 230
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 112 self
					init:
				)
			)
			(33
				(= ticks 137)
			)
			(34
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(35
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(36
				((= local0 (Actor new:))
					view: 921
					signal: 24592
					setLoop: 2
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 51 self
					init:
				)
			)
			(37
				((= local1 (Actor new:))
					view: 921
					signal: 24592
					setLoop: 2
					setCel: 1
					x: 160
					y: 245
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 131 self
					init:
				)
			)
			(38
				(= ticks 137)
			)
			(39
				(local1 cel: 2)
				(DrawPic 146 9)
				(= ticks 237)
			)
			(40
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(41
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(42
				((= local0 (Actor new:))
					view: 921
					signal: 24592
					setLoop: 0
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 40 self
					init:
				)
			)
			(43
				((= local1 (Actor new:))
					view: 921
					signal: 24592
					setLoop: 0
					setCel: 1
					x: 160
					y: 270
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 140 self
					init:
				)
			)
			(44
				(= ticks 137)
			)
			(45
				(local1 cel: 2)
				(DrawPic 146 9)
				(= ticks 237)
			)
			(46
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(47
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(48
				((= local0 (Actor new:))
					view: 921
					signal: 24592
					setLoop: 4
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 71 self
					init:
				)
			)
			(49
				((= local1 (Actor new:))
					view: 921
					signal: 24592
					setLoop: 4
					setCel: 1
					x: 160
					y: 230
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 106 self
					init:
				)
			)
			(50
				(= ticks 137)
			)
			(51
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(52
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(53
				((= local0 (Actor new:))
					view: 922
					signal: 24592
					setLoop: 0
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 58 self
					init:
				)
			)
			(54
				((= local1 (Actor new:))
					view: 922
					signal: 24592
					setLoop: 0
					setCel: 1
					x: 160
					y: 245
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 144 self
					init:
				)
			)
			(55
				(= ticks 137)
			)
			(56
				(local1 cel: 2)
				(DrawPic 146 9)
				(= ticks 237)
			)
			(57
				(local1 cel: 3)
				(DrawPic 146 9)
				(= ticks 237)
			)
			(58
				(local1 cel: 4)
				(DrawPic 146 9)
				(= ticks 237)
			)
			(59
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(60
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(61
				((= local0 (Actor new:))
					view: 922
					signal: 24592
					setLoop: 2
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 54 self
					init:
				)
			)
			(62
				((= local1 (Actor new:))
					view: 922
					signal: 24592
					setLoop: 2
					setCel: 1
					x: 160
					y: 245
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 132 self
					init:
				)
			)
			(63
				(= ticks 137)
			)
			(64
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(65
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(66
				((= local0 (Actor new:))
					view: 922
					signal: 24592
					setLoop: 4
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 73 self
					init:
				)
			)
			(67
				((= local1 (Actor new:))
					view: 922
					signal: 24592
					setLoop: 4
					setCel: 1
					x: 160
					y: 245
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 111 self
					init:
				)
			)
			(68
				(= ticks 137)
			)
			(69
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(70
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(71
				((= local0 (Actor new:))
					view: 923
					signal: 24592
					setLoop: 0
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 72 self
					init:
				)
			)
			(72
				((= local1 (Actor new:))
					view: 923
					signal: 24592
					setLoop: 0
					setCel: 1
					x: 160
					y: 245
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 107 self
					init:
				)
			)
			(73
				(= ticks 137)
			)
			(74
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(75
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(76
				((= local0 (Actor new:))
					view: 923
					signal: 24592
					setLoop: 2
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 54 self
					init:
				)
			)
			(77
				((= local1 (Actor new:))
					view: 923
					signal: 24592
					setLoop: 2
					setCel: 1
					x: 160
					y: 245
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 145 self
					init:
				)
			)
			(78
				(= ticks 137)
			)
			(79
				(local1 cel: 2)
				(DrawPic 146 9)
				(= ticks 237)
			)
			(80
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(81
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(82
				((= local0 (Actor new:))
					view: 922
					signal: 24592
					setLoop: 6
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 53 self
					init:
				)
			)
			(83
				((= local1 (Actor new:))
					view: 922
					signal: 24592
					setLoop: 6
					setCel: 1
					x: 160
					y: 245
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 134 self
					init:
				)
			)
			(84
				(= ticks 137)
			)
			(85
				(local1 cel: 2)
				(DrawPic 146 9)
				(= ticks 237)
			)
			(86
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(87
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(88
				((= local0 (Actor new:))
					view: 923
					signal: 24592
					setLoop: 4
					setCel: 0
					x: 160
					y: 230
					priority: 0
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 46 self
					init:
				)
			)
			(89
				((= local1 (Actor new:))
					view: 923
					signal: 24592
					setLoop: 4
					setCel: 1
					x: 160
					y: 245
					priority: 1
					moveSpeed: 2
					yStep: 3
					setMotion: MoveTo 160 137 self
					init:
				)
			)
			(90
				(= ticks 137)
			)
			(91
				(local1 cel: 2)
				(DrawPic 146 9)
				(= ticks 237)
			)
			(92
				(local0 setMotion: MoveTo 160 -15)
				(local1 setMotion: MoveTo 160 -15 self)
			)
			(93
				(local0 dispose:)
				(local1 dispose:)
				(= cycles 2)
			)
			(94
				(self init:)
			)
		)
	)
)

(instance creditsMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong setLoop: 1 number: 350 play: self)
			)
			(1
				(gLongSong setLoop: 1 number: 320 play: self)
			)
			(2
				(gLongSong setLoop: 1 number: 330 play: self)
			)
			(3
				(gLongSong setLoop: 1 number: 230 play: self)
			)
			(4
				(gLongSong setLoop: 1 number: 622 play: self)
			)
			(5
				(gLongSong setLoop: 1 number: 833 play: self)
			)
			(6
				(gLongSong setLoop: 1 number: 840 play: self)
			)
			(7
				(gLongSong setLoop: 1 number: 845 play: self)
			)
			(8
				(gLongSong setLoop: 1 number: 100 play: self)
			)
			(9
				(gLongSong setLoop: 1 number: 880 play: self)
			)
			(10
				(self init:)
			)
		)
	)

	(method (cue)
		(cond
			((not local4)
				(= local4 1)
				(self changeState: (+ state 1) &rest)
			)
			((== (gLongSong prevSignal:) -1)
				(self changeState: (+ state 1) &rest)
			)
		)
	)
)

