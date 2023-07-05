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
			(1
				(= ticks 240)
			)
			(2
				(signActor setCel: 1)
				(= ticks 300)
			)
			(3
				(signActor setMotion: MoveTo 360 86 self)
			)
			(4
				(signActor x: -20 setCel: 2 setMotion: MoveTo 152 86 self)
			)
			(5
				(iconProp setCycle: End self)
				(gLongSong2 number: 831 setLoop: 1 play:)
			)
			(6
				(= ticks 240)
			)
			(7
				(signActor setMotion: MoveTo 152 -20 self)
			)
			(8
				(signActor setLoop: 2 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(9
				(= ticks 180)
			)
			(10
				(signActor setCel: 1)
				(= ticks 240)
			)
			(11
				(signActor setMotion: MoveTo 152 250 self)
			)
			(12
				(iconProp view: 912 x: 233 y: 112)
				(signActor
					y: -20
					setLoop: 4
					setCel: 0
					setMotion: MoveTo 152 86 self
				)
			)
			(13
				(iconProp setCycle: End self)
				(gLongSong2 number: 101 setLoop: 1 play:)
			)
			(14
				(gLongSong2 number: 929 setLoop: 1 play:)
				(signActor setCel: 1)
				(= ticks 300)
			)
			(15
				(signActor setMotion: MoveTo 152 220 self)
			)
			(16
				(signActor setLoop: 6 cel: 0 setMotion: MoveTo 152 86 self)
				(iconProp view: 913 x: 0 cel: 0)
			)
			(17
				(= ticks 180)
			)
			(18
				(iconProp setCycle: End)
				(signActor cel: 1)
				(gLongSong2 number: 940 setLoop: 1 play: self)
			)
			(19
				(gLongSong2 number: 891 setLoop: 1 play:)
				(= ticks 300)
			)
			(20
				(signActor setMotion: MoveTo 330 210 self)
			)
			(21
				(iconProp view: 917 x: 253 y: 20 cel: 0)
				(signActor
					setLoop: 8
					cel: 0
					x: -20
					y: -20
					setMotion: MoveTo 152 86 self
				)
			)
			(22
				(= ticks 120)
			)
			(23
				(signActor setCel: 1)
				(iconProp cycleSpeed: 12 setCycle: End self)
				(gLongSong2 number: 919 setLoop: -1 play:)
			)
			(24
				(gLongSong2 number: 931 setLoop: 1 play:)
				(= ticks 120)
			)
			(25
				(signActor setMotion: MoveTo 152 220 self)
			)
			(26
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
			(27
				(= ticks 240)
			)
			(28
				(signActor setCel: 1)
				(= ticks 240)
			)
			(29
				(signActor setMotion: MoveTo 152 220 self)
			)
			(30
				(gLongSong stop:)
				(signActor
					setLoop: 12
					y: -20
					cel: 0
					setMotion: MoveTo 152 86 self
				)
				(iconProp view: 909 x: 230 y: 95 cel: 0 setCycle: 0)
			)
			(31
				(= ticks 180)
			)
			(32
				(signActor setCel: 1)
				(iconProp setCycle: End self)
				(gLongSong2 number: 291 setLoop: 1 play: self)
			)
			(33)
			(34
				(gLongSong number: 407 setLoop: -1 play:)
				(signActor setMotion: MoveTo 152 -20 self)
			)
			(35
				(signActor
					view: 921
					setLoop: 2
					setCel: 0
					setMotion: MoveTo 152 92 self
				)
				(iconProp view: 910 x: 76 y: 184 cel: 0)
			)
			(36
				(= ticks 120)
			)
			(37
				(iconProp setCycle: CT 8 1 self)
				(signActor y: 120 setCel: 1)
			)
			(38
				(= ticks 120)
			)
			(39
				(gLongSong2 number: 905 setLoop: 1 play:)
				(iconProp setCycle: End self)
			)
			(40
				(= ticks 300)
			)
			(41
				(signActor setCel: 2)
				(= ticks 300)
			)
			(42
				(signActor setMotion: MoveTo 152 250 self)
			)
			(43
				(iconProp view: 911 cel: 0 x: 189 y: 98)
				(signActor setLoop: 0 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(44
				(= ticks 120)
			)
			(45
				(iconProp setCycle: CT 3 1 self)
			)
			(46
				(gLongSong2 number: 917 setLoop: 1 play: self)
			)
			(47
				(iconProp setCycle: CT 6 1 self)
			)
			(48
				(gLongSong2 number: 917 setLoop: 1 play: self)
			)
			(49
				(iconProp setCycle: End self)
			)
			(50
				(signActor x: 152 y: 131 setCel: 1)
				(= ticks 300)
			)
			(51
				(signActor setCel: 2)
				(= ticks 300)
			)
			(52
				(signActor setMotion: MoveTo 152 -40 self)
			)
			(53
				(iconProp view: 916 cel: 0 x: 259 y: 2)
				(signActor
					setLoop: 4
					x: -20
					y: -20
					setMotion: MoveTo 152 86 self
				)
				(gLongSong changeTo: 408)
			)
			(54
				(= ticks 300)
			)
			(55
				(signActor setCel: 1)
				(= ticks 180)
			)
			(56
				(signActor setMotion: MoveTo -20 220 self)
			)
			(57
				(signActor
					view: 922
					setLoop: 0
					cel: 0
					setMotion: MoveTo 152 86 self
				)
			)
			(58
				(iconProp setCycle: End self)
				(gLongSong2 number: 850 setLoop: 1 play:)
			)
			(59
				(gLongSong2 number: 912 setLoop: 1 play:)
				(= ticks 120)
			)
			(60
				(signActor y: 121 setCel: 1)
				(= ticks 300)
			)
			(61
				(signActor setCel: 2)
				(= ticks 300)
			)
			(62
				(signActor setCel: 3)
				(= ticks 300)
			)
			(63
				(signActor setMotion: MoveTo 152 -40 self)
			)
			(64
				(signActor
					setLoop: 2
					x: 360
					y: 220
					cel: 0
					setMotion: MoveTo 152 86 self
				)
				(iconProp view: 918 cel: 0 setCycle: Fwd)
			)
			(65
				(= ticks 180)
			)
			(66
				(signActor setLoop: 3 y: 121 setCel: 2)
				(= ticks 180)
			)
			(67
				(signActor setLoop: 2)
				(iconProp setCycle: 0 loop: 1)
				(gLongSong2 number: 403 setLoop: 1 play:)
				(= ticks 240)
				(gLongSong changeTo: 409)
			)
			(68
				(signActor view: 922 loop: 6 cel: 0 y: 86)
				(= ticks 180)
			)
			(69
				(signActor cel: 1 y: 121)
				(= ticks 90)
			)
			(70
				(signActor cel: 2)
				(= ticks 90)
			)
			(71
				(signActor setMotion: MoveTo 152 -20 self)
			)
			(72
				(iconProp dispose:)
				(signActor setLoop: 4 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(73
				(= ticks 240)
			)
			(74
				(signActor setCel: 1)
				(= ticks 240)
			)
			(75
				(signActor setMotion: MoveTo -20 -20 self)
			)
			(76
				(signActor
					view: 923
					x: 340
					y: 220
					setLoop: 0
					cel: 0
					setMotion: MoveTo 152 86 self
				)
			)
			(77
				(= ticks 240)
			)
			(78
				(signActor setCel: 1)
				(= ticks 240)
			)
			(79
				(signActor setMotion: MoveTo 152 220 self)
			)
			(80
				(signActor setLoop: 2 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(81
				(= ticks 240)
			)
			(82
				(signActor y: 131 setCel: 1)
				(= ticks 240)
			)
			(83
				(signActor setCel: 2)
				(= ticks 240)
			)
			(84
				(signActor setMotion: MoveTo 152 -20 self)
			)
			(85
				(iconProp view: 915 x: 92 y: 130 cel: 0 init:)
				(signActor setLoop: 4 cel: 0 setMotion: MoveTo 152 86 self)
			)
			(86
				(= ticks 240)
			)
			(87
				(gLongSong2 number: 930 setLoop: 1 play:)
				(self cue:)
			)
			(88
				(iconProp setCycle: End self)
				(signActor y: 114 setCel: 1)
			)
			(89
				(= ticks 300)
			)
			(90
				(signActor setCel: 2)
				(= ticks 300)
			)
			(91
				(gLongSong fade: 0 6 3 0 self)
			)
			(92
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

