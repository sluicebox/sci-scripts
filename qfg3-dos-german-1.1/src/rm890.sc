;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 890)
(include sci.sh)
(use Main)
(use GloryWindow)
(use IconBar)
(use GameControls)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm890 0
)

(local
	local0
	[local1 10]
	[local11 10]
	[local21 10]
	[local31 5]
)

(procedure (localproc_0)
	(Message msgGET 26 1 0 8 1 @local1) ; "Continue"
	(Message msgGET 26 1 0 3 1 @local11) ; "Restore"
	(Message msgGET 26 1 0 4 1 @local21) ; "Restart"
	(Message msgGET 26 1 0 5 1 @local31) ; "Quit"
	(quest init: show: dispose:)
	(switch local0
		(1
			(gGame setCursor: 996 1)
			(SetCursor 0)
		)
		(2
			(gGame restart:)
			(gGame setCursor: 996 1)
			(SetCursor 0)
		)
		(3
			(gGame restore:)
			(gGame setCursor: 996 1)
			(SetCursor 0)
		)
		(4
			(= gQuit 1)
		)
	)
)

(instance rm890 of Rm
	(properties)

	(method (init)
		(super init:)
		(gGame setScript: weBeFamous)
	)
)

(instance weBeFamous of Script
	(properties)

	(method (handleEvent event)
		(event claimed: 1)
		(if (OneOf (event type:) evKEYBOARD evMOUSEBUTTON evJOYDOWN)
			(gGame setCursor: 999 1)
			(SetCursor 1)
			(Animate)
			(localproc_0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable:)
				(gGame setCursor: 996 1)
				(SetCursor 0)
				(gLongSong number: 231 setLoop: -1 play: 127)
				(Graph grFILL_BOX 0 0 200 320 1 22 -1)
				(Graph grUPDATE_BOX -1 -1 201 321 1)
				(foreignActor
					moveSpeed: 2
					view: 1000
					setLoop: 0
					cel: 0
					posn: -20 20
					init:
					setMotion: MoveTo 50 20
				)
				(signActor
					moveSpeed: 2
					view: 925
					setLoop: 0
					cel: 0
					posn: 450 70
					init:
					setMotion: MoveTo 200 70 self
				)
			)
			(1
				(iconProp view: 925 loop: 0 cel: 1 posn: 160 100 init:)
				(= ticks 300)
			)
			(2
				(foreignActor moveSpeed: 0 setMotion: MoveTo -20 20 self)
				(signActor moveSpeed: 0 setMotion: MoveTo 450 70 self)
			)
			(3)
			(4
				(iconProp dispose:)
				(foreignActor
					moveSpeed: 2
					view: 1000
					setLoop: 1
					cel: 0
					posn: -20 20
					init:
					setMotion: MoveTo 50 20
				)
				(signActor
					moveSpeed: 2
					view: 925
					setLoop: 2
					cel: 0
					posn: 450 70
					init:
					setMotion: MoveTo 200 70 self
				)
			)
			(5
				(iconProp view: 925 loop: 2 cel: 1 posn: 160 100 init:)
				(= ticks 300)
			)
			(6
				(foreignActor moveSpeed: 0 setMotion: MoveTo -20 20 self)
				(signActor moveSpeed: 0 setMotion: MoveTo 450 70 self)
			)
			(7)
			(8
				(iconProp dispose:)
				(foreignActor
					moveSpeed: 2
					view: 1000
					setLoop: 2
					cel: 0
					posn: -20 20
					init:
					setMotion: MoveTo 50 20
				)
				(signActor
					moveSpeed: 2
					view: 925
					setLoop: 4
					cel: 0
					posn: 450 70
					init:
					setMotion: MoveTo 200 70 self
				)
			)
			(9
				(iconProp view: 925 loop: 4 cel: 1 posn: 160 100 init:)
				(= ticks 300)
			)
			(10
				(foreignActor moveSpeed: 0 setMotion: MoveTo -20 20 self)
				(signActor moveSpeed: 0 setMotion: MoveTo 450 70 self)
			)
			(11)
			(12
				(iconProp dispose:)
				(foreignActor
					moveSpeed: 2
					view: 1000
					setLoop: 3
					cel: 0
					posn: -20 20
					init:
					setMotion: MoveTo 50 20
				)
				(signActor
					moveSpeed: 2
					view: 925
					setLoop: 6
					cel: 0
					posn: 450 70
					init:
					setMotion: MoveTo 200 70 self
				)
			)
			(13
				(iconProp view: 925 loop: 6 cel: 1 posn: 160 100 init:)
				(= ticks 300)
			)
			(14
				(foreignActor moveSpeed: 0 setMotion: MoveTo -20 20 self)
				(signActor moveSpeed: 0 setMotion: MoveTo 450 70 self)
			)
			(15)
			(16
				(iconProp view: 919 x: 10 y: 110 cel: 0 init:)
				(signActor
					view: 920
					x: 152
					y: 220
					setLoop: 0
					cel: 0
					init:
					setMotion: MoveTo 152 86 self
				)
			)
			(17
				(= ticks 240)
			)
			(18
				(signActor setCel: 1)
				(= ticks 300)
			)
			(19
				(signActor setMotion: MoveTo 360 86 self)
			)
			(20
				(signActor x: -20 setCel: 2 setMotion: MoveTo 152 86 self)
			)
			(21
				(iconProp setCycle: End self)
				(gLongSong2 number: 831 setLoop: 1 play:)
			)
			(22
				(= ticks 240)
			)
			(23
				(signActor setMotion: MoveTo 152 -20 self)
			)
			(24
				(signActor setLoop: 2 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(25
				(= ticks 180)
			)
			(26
				(signActor setCel: 1)
				(= ticks 240)
			)
			(27
				(signActor setMotion: MoveTo 152 250 self)
			)
			(28
				(iconProp view: 912 x: 233 y: 112)
				(signActor
					view: 920
					y: -20
					setLoop: 4
					setCel: 0
					setMotion: MoveTo 152 86 self
				)
			)
			(29
				(iconProp setCycle: End self)
				(gLongSong2 number: 101 setLoop: 1 play:)
			)
			(30
				(gLongSong2 number: 929 setLoop: 1 play:)
				(signActor setCel: 1)
				(= ticks 300)
			)
			(31
				(signActor setMotion: MoveTo 152 220 self)
			)
			(32
				(signActor setLoop: 6 cel: 0 setMotion: MoveTo 152 86 self)
				(iconProp view: 913 x: 0 cel: 0)
			)
			(33
				(= ticks 180)
			)
			(34
				(iconProp setCycle: End)
				(signActor cel: 1)
				(gLongSong2 number: 940 setLoop: 1 play: self)
			)
			(35
				(gLongSong2 number: 891 setLoop: 1 play:)
				(= ticks 300)
			)
			(36
				(signActor setMotion: MoveTo 330 210 self)
			)
			(37
				(iconProp view: 917 x: 253 y: 20 cel: 0)
				(signActor
					setLoop: 8
					cel: 0
					x: -20
					y: -20
					setMotion: MoveTo 152 86 self
				)
			)
			(38
				(= ticks 120)
			)
			(39
				(signActor setCel: 1)
				(iconProp cycleSpeed: 12 setCycle: End self)
				(gLongSong2 number: 919 setLoop: -1 play:)
			)
			(40
				(gLongSong2 number: 931 setLoop: 1 play:)
				(= ticks 120)
			)
			(41
				(signActor setMotion: MoveTo 152 220 self)
			)
			(42
				(iconProp view: 914 x: 0 y: 0 setCycle: Fwd)
				(signActor
					setLoop: 10
					cel: 0
					x: 360
					y: 86
					setMotion: MoveTo 152 86 self
				)
				(gLongSong number: 890 setLoop: 1 play:)
			)
			(43
				(= ticks 240)
			)
			(44
				(signActor setCel: 1)
				(= ticks 240)
			)
			(45
				(signActor setMotion: MoveTo 152 220 self)
			)
			(46
				(gLongSong stop:)
				(signActor
					setLoop: 12
					y: -20
					cel: 0
					setMotion: MoveTo 152 86 self
				)
				(iconProp view: 909 x: 230 y: 95 cel: 0 setCycle: 0)
			)
			(47
				(= ticks 180)
			)
			(48
				(signActor setCel: 1)
				(iconProp setCycle: End self)
				(gLongSong2 number: 291 setLoop: 1 play: self)
			)
			(49)
			(50
				(gLongSong number: 407 setLoop: -1 play:)
				(signActor setMotion: MoveTo 152 -20 self)
			)
			(51
				(signActor
					view: 921
					setLoop: 2
					setCel: 0
					setMotion: MoveTo 152 92 self
				)
				(iconProp view: 910 x: 76 y: 184 cel: 0)
			)
			(52
				(= ticks 120)
			)
			(53
				(iconProp setCycle: CT 8 1 self)
				(signActor y: 120 setCel: 1)
			)
			(54
				(= ticks 120)
			)
			(55
				(gLongSong2 number: 905 setLoop: 1 play:)
				(iconProp setCycle: End self)
			)
			(56
				(= ticks 300)
			)
			(57
				(signActor setCel: 2)
				(= ticks 300)
			)
			(58
				(signActor setMotion: MoveTo 152 250 self)
			)
			(59
				(iconProp view: 911 cel: 0 x: 189 y: 98)
				(signActor setLoop: 0 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(60
				(= ticks 120)
			)
			(61
				(iconProp setCycle: CT 3 1 self)
			)
			(62
				(gLongSong2 number: 917 setLoop: 1 play: self)
			)
			(63
				(iconProp setCycle: CT 6 1 self)
			)
			(64
				(gLongSong2 number: 917 setLoop: 1 play: self)
			)
			(65
				(iconProp setCycle: End self)
			)
			(66
				(signActor x: 152 y: 131 setCel: 1)
				(= ticks 300)
			)
			(67
				(signActor setCel: 2)
				(= ticks 300)
			)
			(68
				(signActor setMotion: MoveTo 152 -40 self)
			)
			(69
				(iconProp view: 916 cel: 0 x: 259 y: 2)
				(signActor
					setLoop: 4
					x: -20
					y: -20
					setMotion: MoveTo 152 86 self
				)
				(gLongSong changeTo: 408)
			)
			(70
				(= ticks 300)
			)
			(71
				(signActor setCel: 1)
				(= ticks 180)
			)
			(72
				(signActor setMotion: MoveTo -20 220 self)
			)
			(73
				(signActor
					view: 922
					setLoop: 0
					cel: 0
					setMotion: MoveTo 152 86 self
				)
			)
			(74
				(iconProp setCycle: End self)
				(gLongSong2 number: 850 setLoop: 1 play:)
			)
			(75
				(gLongSong2 number: 912 setLoop: 1 play:)
				(= ticks 120)
			)
			(76
				(signActor y: 121 setCel: 1)
				(= ticks 300)
			)
			(77
				(signActor setCel: 2)
				(= ticks 300)
			)
			(78
				(signActor setCel: 3)
				(= ticks 300)
			)
			(79
				(signActor setMotion: MoveTo 152 -40 self)
			)
			(80
				(signActor
					setLoop: 2
					x: 360
					y: 220
					cel: 0
					setMotion: MoveTo 152 86 self
				)
				(iconProp view: 918 cel: 0 setCycle: Fwd)
			)
			(81
				(= ticks 180)
			)
			(82
				(signActor setLoop: 3 y: 121 setCel: 2)
				(= ticks 180)
			)
			(83
				(signActor setLoop: 2)
				(iconProp setCycle: 0 loop: 1)
				(gLongSong2 number: 403 setLoop: 1 play:)
				(= ticks 240)
				(gLongSong changeTo: 409)
			)
			(84
				(signActor view: 922 loop: 6 cel: 0 y: 86)
				(= ticks 180)
			)
			(85
				(signActor cel: 1 y: 121)
				(= ticks 90)
			)
			(86
				(signActor cel: 2)
				(= ticks 90)
			)
			(87
				(signActor setMotion: MoveTo 152 -20 self)
			)
			(88
				(iconProp dispose:)
				(signActor setLoop: 4 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(89
				(= ticks 240)
			)
			(90
				(signActor setCel: 1)
				(= ticks 240)
			)
			(91
				(signActor setMotion: MoveTo -20 -20 self)
			)
			(92
				(signActor
					view: 923
					x: 340
					y: 220
					setLoop: 0
					cel: 0
					setMotion: MoveTo 152 86 self
				)
			)
			(93
				(= ticks 240)
			)
			(94
				(signActor setCel: 1)
				(= ticks 240)
			)
			(95
				(signActor setMotion: MoveTo 152 220 self)
			)
			(96
				(signActor setLoop: 2 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(97
				(= ticks 240)
			)
			(98
				(signActor y: 131 setCel: 1)
				(= ticks 240)
			)
			(99
				(signActor setCel: 2)
				(= ticks 240)
			)
			(100
				(signActor setMotion: MoveTo 152 -20 self)
			)
			(101
				(iconProp view: 915 x: 92 y: 130 cel: 0 init:)
				(signActor setLoop: 4 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(102
				(= ticks 240)
			)
			(103
				(gLongSong2 number: 930 setLoop: 1 play:)
				(self cue:)
			)
			(104
				(iconProp setCycle: End self)
				(signActor y: 114 setCel: 1)
			)
			(105
				(= ticks 300)
			)
			(106
				(signActor setCel: 2)
				(= ticks 300)
			)
			(107
				(gLongSong fade: 0 6 3 0 self)
			)
			(108
				(iconProp dispose:)
				(self init:)
			)
		)
	)
)

(instance iconProp of Prop
	(properties
		signal 16384
	)
)

(instance foreignActor of Actor
	(properties
		signal 24576
		illegalBits 0
		moveSpeed 0
	)
)

(instance signActor of Actor
	(properties
		signal 24576
		illegalBits 0
		moveSpeed 0
	)
)

(instance quest of GameControls
	(properties)

	(method (init)
		((= window (GloryWindow new:))
			top: 40
			left: 95
			bottom: 125
			right: 220
			priority: 15
			yourself:
		)
		(self add: continueIcon restoreIcon restartIcon quitIcon)
		(super init: &rest)
	)
)

(instance continueIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 15
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 1)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local1 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local1 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance restoreIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 30
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 3)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local11 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local11 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance restartIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 45
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 2)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show)
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local21 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local21 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

(instance quitIcon of IconI
	(properties
		view 935
		loop 2
		cel 0
		nsTop 60
		signal 257
		maskView 361
		maskLoop 3
	)

	(method (select)
		(= local0 4)
		(quest state: (& (quest state:) $ffdf))
	)

	(method (show &tmp [temp0 15])
		(= nsRight 80)
		(= nsBottom (+ nsTop 15))
		(DrawCel view loop cel nsLeft nsTop -1)
		(Display @local31 dsCOORD 20 (+ nsTop 3) dsCOLOR 17)
	)

	(method (highlight param1 &tmp temp0)
		(if param1
			(DrawCel view loop 1 nsLeft nsTop -1)
			(= temp0 46)
		else
			(DrawCel view loop 0 nsLeft nsTop -1)
			(= temp0 17)
		)
		(Display @local31 dsCOORD 20 (+ nsTop 3) dsCOLOR temp0)
	)
)

