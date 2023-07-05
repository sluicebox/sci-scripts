;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use n098)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm120 0
)

(local
	[local0 2] = [-1 30]
	local2
	local3
)

(instance rm120 of LarryRoom
	(properties
		picture 120
		style 10
		autoLoad 0
		noControls 1
	)

	(method (init)
		(super init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(if (!= gPrevRoomNum 110)
			(gGame setCursor: 996 1)
			(gGlobalSound2 number: 0 stop:)
			(gGlobalSound1 number: 120 loop: -1 play:)
		)
		(UnLoad 132 121)
		(UnLoad 132 444)
		(UnLoad 132 385)
		(gEgo view: 98 x: 100 y: 100 init: setScript: palScr)
		(self setScript: creditScr)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event type:)
			(if (and (not local3) (!= global100 2))
				(event claimed: 1)
				(proc98_0)
			else
				(event claimed: 0)
			)
		)
	)
)

(instance c1 of Actor
	(properties
		view 98
		priority 14
		signal 26640
	)
)

(instance c2 of Prop
	(properties
		view 98
		priority 14
		signal 26640
	)
)

(instance c3 of Prop
	(properties
		view 98
		priority 14
		signal 26640
	)
)

(instance c4 of Prop
	(properties
		view 98
		priority 14
		signal 26640
	)
)

(instance c5 of Prop
	(properties
		view 98
		priority 14
		signal 26640
	)
)

(instance sfx of Sound
	(properties)
)

(instance sfx2 of Sound
	(properties)
)

(instance sfx3 of Sound
	(properties
		loop -1
	)
)

(instance creditScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== local2 2) (== (c1 cel:) 3) (not (sfx2 handle:)))
			(sfx2 number: 122 loop: 1 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(c1 init:)
				(c2 init:)
				(c3 init:)
				(c4 init:)
				(c5 init:)
				(= cycles 2)
			)
			(1
				((ScriptID 825 1) view: 98 dispose:) ; tram
				(UnLoad 128 82)
				(= cycles 2)
			)
			(2
				(UnLoad 130 911)
				(Load rsVIEW 943)
				(Load rsVIEW 939)
				(Load rsSOUND 123)
				(Load rsSOUND 122)
				(= cycles 2)
			)
			(3
				(= local2 2)
				(c1
					view: 939
					setLoop: 0
					setCycle: Fwd
					x: -20
					y: 132
					setPri: 4
					setMotion: MoveTo 130 132 self
				)
			)
			(4
				(c1 setMotion: MoveTo 175 132 self)
				(sfx number: 123 loop: 1 play:)
				(c3
					view: 943
					setLoop: 3
					cel: 0
					x: 152
					y: 103
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(5
				(c3 stopUpd:)
			)
			(6
				(c1 setMotion: MoveTo 230 132 self)
				(sfx number: 123 loop: 1 play:)
				(c4
					view: 943
					loop: 1
					cel: 0
					x: 198
					y: 101
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(7
				(c4 stopUpd:)
			)
			(8
				(sfx number: 123 loop: 1 play:)
				(c5
					view: 943
					setLoop: 2
					cel: 0
					x: 248
					y: 103
					cycleSpeed: 4
					setPri: 1
					setCycle: End self
				)
				(c1 setMotion: MoveTo 362 132 self)
			)
			(9
				(c5 stopUpd:)
			)
			(10
				(= local2 0)
				(UnLoad 132 122)
				(UnLoad 132 123)
				(Load rsVIEW 951)
				(= seconds 3)
			)
			(11
				(c1 view: 98 forceUpd:)
				(c2 view: 98 forceUpd:)
				(c3 view: 98 forceUpd:)
				(c4 view: 98 forceUpd:)
				(c5 view: 98 forceUpd:)
				(DrawPic 120 9)
				(UnLoad 128 943)
				(= ticks 60)
			)
			(12
				(c2
					view: 951
					setLoop: 0
					x: (proc79_4 74 74 54 74 74)
					y: 77
					cycleSpeed: 6
					cel: 1
				)
				(= cycles 2)
			)
			(13
				(sfx number: 353 loop: 1 play:)
				(c2 setCycle: End self)
			)
			(14
				(= seconds 3)
			)
			(15
				(c2 stopUpd:)
				(c3 view: 951 setLoop: 1 cel: 0 x: 211 y: -10 cycleSpeed: 6)
				(= cycles 2)
			)
			(16
				(c3 setCycle: CT 4 1 self)
			)
			(17
				(sfx number: 520 loop: 1 play:)
				(c3 setCycle: End self)
			)
			(18
				(c3 stopUpd:)
				(Load rsVIEW 944)
				(= seconds 4)
			)
			(19
				(UnLoad 128 951)
				(c1 view: 98 forceUpd:)
				(c2 view: 98 forceUpd:)
				(c3 view: 98 forceUpd:)
				(c4 view: 98 forceUpd:)
				(c5 view: 98 forceUpd:)
				(DrawPic 120 9)
				(= ticks 60)
			)
			(20
				(c1
					view: 944
					setLoop: 0
					cel: 0
					x: 10
					y: 75
					cycleSpeed: 4
					priority: 6
					startUpd:
					setCycle: 0
				)
				(Load rsSOUND 800)
				(= ticks 90)
			)
			(21
				(sfx number: 326 loop: 1 play:)
				(c1 setCycle: End self)
			)
			(22
				(c1 stopUpd:)
				(= ticks 40)
			)
			(23
				(c5
					view: 944
					setLoop: 2
					x: 196
					y: 87
					cel: 0
					cycleSpeed: 6
					startUpd:
				)
				(= cycles 2)
			)
			(24
				(sfx number: 800 loop: 1 play:)
				(c5 setCycle: End self)
			)
			(25
				(c5 view: 98 forceUpd:)
				(c2 view: 944 loop: 1 cel: 0 x: 140 y: 70 forceUpd:)
				(UnLoad 132 800)
				(= seconds 5)
			)
			(26
				(DrawPic 120 9)
				(= ticks 60)
			)
			(27
				(gCast eachElementDo: #hide)
				(= ticks 60)
			)
			(28
				(gCast eachElementDo: #show)
				(c2 view: 946 setLoop: 0 cel: 0 x: 139 y: 70 cycleSpeed: 8)
				(c1 view: 98)
				(c3 view: 98)
				(c4 view: 98)
				(c5 view: 98)
				(UnLoad 128 944)
				(= ticks 90)
			)
			(29
				(sfx number: 869 loop: 1 play:)
				(c2 cycleSpeed: 6 setCycle: End self)
			)
			(30
				(sfx number: 126 loop: 1 play: self)
				(c2 setLoop: 1 cycleSpeed: 6 setCycle: Fwd)
				(= seconds 4)
			)
			(31)
			(32
				(c2 setLoop: 2 cel: 0 setCycle: 0)
				(= ticks 30)
			)
			(33
				(UnLoad 132 325)
				(c2 setCycle: CT 3 1 self)
			)
			(34
				(sfx number: 636 loop: 1 play:)
				(c2 setCycle: End self)
			)
			(35
				(c2 setLoop: 5 cel: 0)
				(c3 view: 946 setLoop: 4 cel: 0 x: 209 y: 29)
				(c4
					view: 946
					setLoop: 3
					cel: 0
					x: (proc79_4 78 78 138 78 78)
					y: (proc79_4 2 2 10 2 2)
					setCycle: End self
				)
			)
			(36
				(c3 setCycle: End self)
			)
			(37
				(= ticks 60)
			)
			(38
				(c2 setCycle: End self)
			)
			(39
				(= seconds 6)
			)
			(40
				(c1 view: 98 forceUpd:)
				(c2 view: 98 forceUpd:)
				(c3 view: 98 forceUpd:)
				(c4 view: 98 forceUpd:)
				(c5 view: 98 forceUpd:)
				(DrawPic 120 9)
				(Load rsVIEW 941)
				(= ticks 60)
			)
			(41
				(c1 view: 941 setLoop: 0 cel: 0 x: 63 y: 29 stopUpd:)
				(c2 view: 941 setLoop: 0 cel: 1 x: 129 y: 59 stopUpd:)
				(c5
					view: 941
					setLoop: 3
					cel: 0
					x: 231
					y: 133
					setPri: 2
					cycleSpeed: 10
					forceUpd:
				)
				(c3 view: 98)
				(c4 view: 98)
				(UnLoad 128 946)
				(= seconds 3)
			)
			(42
				(c5 setCycle: End self)
			)
			(43
				(sfx number: 312 loop: 1 play:)
				(= ticks 60)
			)
			(44
				(c3 view: 941 setLoop: 1 cel: 0 x: 160 y: 62 forceUpd:)
				(c5 setLoop: 2 cel: 0 setCycle: End self)
			)
			(45
				(= seconds 4)
			)
			(46
				(c1 view: 98 forceUpd:)
				(c2 view: 98 forceUpd:)
				(c3 view: 98 forceUpd:)
				(c4 view: 98 forceUpd:)
				(c5 view: 98 forceUpd:)
				(DrawPic 120 9)
				(Load rsVIEW 949)
				(= ticks 60)
			)
			(47
				(c2 view: 949 setLoop: 3 cel: 0 x: 31 y: 15 stopUpd:)
				(c1
					view: 949
					setLoop: 2
					cel: 0
					x: 330
					y: 74
					setStep: 15 15
					startUpd:
					cycleSpeed: 4
					moveSpeed: 4
					setCycle: Fwd
					setMotion: MoveTo 132 74 self
				)
				(c3 view: 98)
				(c4 view: 98)
				(c5 view: 98)
				(UnLoad 128 942)
				(UnLoad 128 941)
				(= ticks 90)
			)
			(48
				(c1
					setLoop: 1
					cel: 0
					setCycle: 0
					setMotion: 0
					setCycle: 0
					x: 118
					y: 91
				)
				(= ticks 20)
			)
			(49
				(c1 cel: 1)
				(= ticks 30)
			)
			(50
				(c1 view: 949 setLoop: 7 cel: 0 x: 119 y: 95 cycleSpeed: 8)
				(c3 view: 949 setLoop: 0 cel: 0 x: 133 y: 97 cycleSpeed: 8)
				(= ticks 60)
			)
			(51
				(c1 setCycle: CT 2 1 self)
			)
			(52
				(sfx number: 443 loop: 1 play:)
				(c3 setPri: 2 setCycle: End self)
				(c1 setPri: 1 setCycle: End self)
			)
			(53)
			(54
				(c3 setLoop: 5 cel: 0 x: 222 y: 68 setCycle: CT 9 1 self)
			)
			(55
				(c1 hide: setLoop: 6 cel: 0)
				(c3 cycleSpeed: 12 setCycle: CT 11 1 self)
			)
			(56
				(sfx number: 814 loop: 1 play:)
				(c1 show: cycleSpeed: 12 setCycle: End self)
			)
			(57
				(c3 setCycle: End self)
				(= cycles 3)
			)
			(58
				(c1 setLoop: 4 cel: 0 x: 140 y: 117 setCycle: End self)
			)
			(59)
			(60
				(= seconds 4)
			)
			(61
				(c1 view: 98 forceUpd:)
				(c2 view: 98 forceUpd:)
				(c3 view: 98 forceUpd:)
				(c4 view: 98 forceUpd:)
				(c5 view: 98 forceUpd:)
				(DrawPic 120 9)
				(Load rsVIEW 950)
				(= ticks 60)
			)
			(62
				(c1
					view: 950
					setLoop: 0
					cel: 0
					x: 101
					y: 132
					cycleSpeed: 8
					setCycle: 0
					startUpd:
				)
				(c2
					view: 950
					setLoop: 4
					cel: 0
					x: 17
					y: 51
					cycleSpeed: 4
					forceUpd:
					stopUpd:
				)
				(UnLoad 128 949)
				(= ticks 60)
			)
			(63
				(c1 setCycle: CT 6 1 self)
			)
			(64
				(c3
					view: 950
					setLoop: 1
					cel: 0
					x: 93
					y: 88
					startUpd:
					cycleSpeed: 6
					setCycle: End self
				)
				(sfx number: 129 loop: 1 play:)
				(c1 setCycle: End)
			)
			(65
				(= ticks 120)
			)
			(66
				(c1 cel: 0 setCycle: CT 6 1 self)
			)
			(67
				(c4
					view: 950
					setLoop: 2
					cel: 0
					x: 96
					y: 86
					startUpd:
					cycleSpeed: 6
					setCycle: End self
				)
				(sfx number: 129 loop: 1 play:)
				(c1 setCycle: End)
			)
			(68
				(= ticks 120)
			)
			(69
				(c1 cel: 0 setCycle: CT 6 1 self)
			)
			(70
				(c5
					view: 950
					setLoop: 3
					cel: 0
					x: 97
					y: 83
					startUpd:
					cycleSpeed: 6
					setCycle: End self
				)
				(sfx number: 129 loop: 1 play:)
				(c1 setCycle: End)
			)
			(71
				(= seconds 5)
			)
			(72
				(c1 view: 98 forceUpd:)
				(c2 view: 98 forceUpd:)
				(c3 view: 98 forceUpd:)
				(c4 view: 98 forceUpd:)
				(c5 view: 98 forceUpd:)
				(DrawPic 120 9)
				(Load rsVIEW 945)
				(= ticks 60)
			)
			(73
				(c2 view: 945 setLoop: 1 cel: 0 x: 103 y: 73 startUpd:)
				(c3
					view: 945
					setLoop: 0
					cel: 0
					x: 66
					y: 33
					cycleSpeed: 6
					startUpd:
				)
				(UnLoad 128 950)
				(= seconds 3)
			)
			(74
				(c3 setCycle: CT 6 1 self)
			)
			(75
				(sfx number: 124 loop: 1 play:)
				(= ticks 120)
			)
			(76
				(c3 setCycle: CT 11 1 self)
			)
			(77
				(c3 setCycle: End self)
				(sfx number: 125 loop: 1 play:)
			)
			(78
				(= seconds 5)
			)
			(79
				(c1 view: 98 forceUpd:)
				(c2 view: 98 forceUpd:)
				(c3 view: 98 forceUpd:)
				(c4 view: 98 forceUpd:)
				(c5 view: 98 forceUpd:)
				(DrawPic 120 9)
				(Load rsVIEW 952)
				(= ticks 60)
			)
			(80
				(c3
					view: 952
					setLoop: 1
					cel: 0
					x: 89
					y: 26
					cycleSpeed: 6
					startUpd:
				)
				(UnLoad 128 945)
				(= ticks 60)
			)
			(81
				(sfx number: 637 loop: 1 play:)
				(c3 setPri: 2 setCycle: End self)
			)
			(82
				(c3 stopUpd:)
				(c2 view: 952 setLoop: 2 cel: 0 x: 313 y: 34 startUpd:)
				(= ticks 60)
			)
			(83
				(c2 setCycle: End self)
			)
			(84
				(c2 setLoop: 3 cel: 0 x: 273 y: 31 cycleSpeed: 6 setCycle: Fwd)
				(sfx3 number: 343 loop: -1 play:)
				(= seconds 4)
			)
			(85
				(c4
					view: 952
					setLoop: 0
					cel: 0
					x: 286
					y: 39
					cycleSpeed: 4
					startUpd:
					setCycle: End self
				)
			)
			(86
				(= seconds 6)
			)
			(87
				(Load rsSOUND 516)
				(Load rsVIEW 948)
				(c1 view: 98 forceUpd:)
				(c2 view: 98 forceUpd:)
				(c3 view: 98 forceUpd:)
				(c4 view: 98 forceUpd:)
				(c5 view: 98 forceUpd:)
				(DrawPic 120 9)
				(sfx3 number: 0 stop:)
				(= ticks 60)
			)
			(88
				(= local2 1)
				(c4
					view: 948
					setLoop: 1
					x: 140
					y: 45
					cycleSpeed: 8
					setCycle: Fwd
				)
				(sfx number: 127 loop: 1 play:)
				(UnLoad 128 952)
				(= seconds 3)
			)
			(89
				(c4 setLoop: 0 cel: 0 setCycle: End self)
				(sfx number: 128 loop: 1 play:)
			)
			(90
				(= seconds 4)
			)
			(91
				(gGlobalSound1 fade: 0 30 5 1)
				(= register 100)
				(= cycles 2)
			)
			(92
				(if (> (-= register 2) 0)
					(-- state)
					(Palette palSET_INTENSITY 0 255 register)
				)
				(= ticks 1)
			)
			(93
				(gCast eachElementDo: #dispose)
				(DrawPic 98)
				(= ticks 180)
			)
			(94
				(Palette palSET_INTENSITY 0 255 100)
				(gCurRoom newRoom: 130)
			)
		)
	)
)

(instance palScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 8)
			)
			(1
				(Palette palANIMATE 97 111 1)
				(self init:)
			)
		)
	)
)

