;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 997)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm9v02 0
)

(instance rm9v02 of ShiversRoom
	(properties
		picture 2150
	)

	(method (init)
		(Purge 2500)
		(hsArea init:)
		(super init: &rest)
		(self setScript: sRunDemo)
	)

	(method (dispose)
		(sRunDemo dispose:)
		(super dispose: &rest)
	)
)

(instance hsArea of HotSpot
	(properties
		nsLeft -27
		nsTop -7
		nsRight 293
		nsBottom 193
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doVerb)
		(gSounds stop: 7112)
		(gCurRoom newRoom: 910) ; shiversLogo
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance pMyProp1 of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 6030
		cycleSpeed 2
	)

	(method (init)
		(super init: &rest)
	)
)

(instance pMyProp2 of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 7110
		loop 5
	)

	(method (init)
		(super init: &rest)
	)
)

(instance pMyProp3 of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 7110
		loop 7
	)

	(method (init)
		(super init: &rest)
	)
)

(instance pMyProp4 of ShiversProp
	(properties
		x 138
		y 110
		priority 100
		fixPriority 1
		view 52060
		loop 7
	)

	(method (init)
		(super init: &rest)
	)
)

(instance sRunDemo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc951_7 7112)
				(proc951_9 7112)
				(gSounds play: 7112 -1 0 0)
				(gSounds fade: 7112 100 1 30 0 0)
				(gCurRoom drawPic: 2050)
				(= seconds 1)
			)
			(1
				(gCurRoom drawPic: 2170)
				(= seconds 1)
			)
			(2
				(gCurRoom drawPic: 2190)
				(= seconds 1)
			)
			(3
				(gCurRoom drawPic: 2210)
				(= seconds 1)
			)
			(4
				(gCurRoom drawPic: 2230)
				(= seconds 1)
			)
			(5
				(gCurRoom drawPic: 3020)
				(= seconds 1)
			)
			(6
				(gCurRoom drawPic: 3070)
				(= seconds 1)
			)
			(7
				(gCurRoom drawPic: 3110)
				(= seconds 1)
			)
			(8
				(gCurRoom drawPic: 3220)
				(= seconds 1)
			)
			(9
				(gCurRoom drawPic: 3260)
				(= seconds 1)
			)
			(10
				(gCurRoom drawPic: 3300)
				(= seconds 1)
			)
			(11
				(gCurRoom drawPic: 6060)
				(= seconds 1)
			)
			(12
				(gCurRoom drawPic: 6100)
				(= seconds 1)
			)
			(13
				(gCurRoom drawPic: 6111)
				(= seconds 1)
			)
			(14
				(gCurRoom drawPic: 6030)
				(pMyProp1 view: 6030 loop: 0 init:)
				(= seconds 1)
			)
			(15
				(pMyProp1 cel: (pMyProp1 lastCel:) show:)
				(= seconds 1)
			)
			(16
				(pMyProp1 hide:)
				(gCurRoom drawPic: 9020)
				(= seconds 1)
			)
			(17
				(gCurRoom drawPic: 9060)
				(= seconds 1)
			)
			(18
				(gCurRoom drawPic: 9140)
				(= seconds 1)
			)
			(19
				(gCurRoom drawPic: 9540)
				(= seconds 1)
			)
			(20
				(gCurRoom drawPic: 11500)
				(= seconds 1)
			)
			(21
				(gCurRoom drawPic: 11080)
				(= seconds 1)
			)
			(22
				(gCurRoom drawPic: 11220)
				(= seconds 1)
			)
			(23
				(gCurRoom drawPic: 19040)
				(= seconds 1)
			)
			(24
				(gCurRoom drawPic: 19240)
				(= seconds 1)
			)
			(25
				(gCurRoom drawPic: 19210)
				(= seconds 1)
			)
			(26
				(gCurRoom drawPic: 19130)
				(= seconds 1)
			)
			(27
				(gCurRoom drawPic: 19180)
				(= seconds 1)
			)
			(28
				(gCurRoom drawPic: 12020)
				(= seconds 1)
			)
			(29
				(gCurRoom drawPic: 12110)
				(= seconds 1)
			)
			(30
				(gCurRoom drawPic: 12240)
				(= seconds 1)
			)
			(31
				(gCurRoom drawPic: 12370)
				(= seconds 1)
			)
			(32
				(gCurRoom drawPic: 12050)
				(= seconds 1)
			)
			(33
				(gCurRoom drawPic: 16000)
				(= seconds 1)
			)
			(34
				(gCurRoom drawPic: 16700)
				(= seconds 1)
			)
			(35
				(gCurRoom drawPic: 16340)
				(= seconds 1)
			)
			(36
				(gCurRoom drawPic: 18040)
				(= seconds 1)
			)
			(37
				(gCurRoom drawPic: 18060)
				(= seconds 1)
			)
			(38
				(gCurRoom drawPic: 18220)
				(= seconds 1)
			)
			(39
				(gCurRoom drawPic: 17100)
				(= seconds 1)
			)
			(40
				(gCurRoom drawPic: 17120)
				(= seconds 1)
			)
			(41
				(gCurRoom drawPic: 25040)
				(= seconds 1)
			)
			(42
				(gCurRoom drawPic: 14010)
				(= seconds 1)
			)
			(43
				(gCurRoom drawPic: 15060)
				(= seconds 1)
			)
			(44
				(gCurRoom drawPic: 15080)
				(= seconds 1)
			)
			(45
				(gCurRoom drawPic: 15140)
				(= seconds 1)
			)
			(46
				(gCurRoom drawPic: 8550)
				(= seconds 1)
			)
			(47
				(gCurRoom drawPic: 9540)
				(= seconds 1)
			)
			(48
				(gCurRoom drawPic: 8440)
				(= seconds 1)
			)
			(49
				(gCurRoom drawPic: 21020)
				(= seconds 1)
			)
			(50
				(gCurRoom drawPic: 21030)
				(= seconds 1)
			)
			(51
				(gCurRoom drawPic: 21060)
				(= seconds 1)
			)
			(52
				(gCurRoom drawPic: 21340)
				(= seconds 1)
			)
			(53
				(gCurRoom drawPic: 21290)
				(= seconds 1)
			)
			(54
				(gCurRoom drawPic: 22100)
				(= seconds 1)
			)
			(55
				(gCurRoom drawPic: 22040)
				(= seconds 1)
			)
			(56
				(gCurRoom drawPic: 22060)
				(= seconds 1)
			)
			(57
				(gCurRoom drawPic: 22240)
				(= seconds 1)
			)
			(58
				(gCurRoom drawPic: 22180)
				(= seconds 1)
			)
			(59
				(gCurRoom drawPic: 9290)
				(= seconds 1)
			)
			(60
				(gCurRoom drawPic: 9320)
				(= seconds 1)
			)
			(61
				(gCurRoom drawPic: 9390)
				(= seconds 1)
			)
			(62
				(gCurRoom drawPic: 9520)
				(= seconds 1)
			)
			(63
				(gCurRoom drawPic: 9480)
				(= seconds 1)
			)
			(64
				(gCurRoom drawPic: 9200)
				(= seconds 1)
			)
			(65
				(gCurRoom drawPic: 1021)
				(= seconds 1)
			)
			(66
				(gCurRoom drawPic: 1000)
				(= seconds 1)
			)
			(67
				(pMyProp1 view: 1017 loop: 0 cel: 0 show:)
				(= seconds 1)
			)
			(68
				(pMyProp1 hide:)
				(gCurRoom drawPic: 1521)
				(= seconds 1)
			)
			(69
				(gCurRoom drawPic: 1441)
				(= seconds 1)
			)
			(70
				(gCurRoom drawPic: 1380)
				(= seconds 1)
			)
			(71
				(gCurRoom drawPic: 1342)
				(= seconds 1)
			)
			(72
				(gCurRoom drawPic: 1212)
				(= seconds 1)
			)
			(73
				(gCurRoom drawPic: 4190)
				(= seconds 1)
			)
			(74
				(pMyProp1 view: 4193 loop: 0 cel: 0 show:)
				(= seconds 1)
			)
			(75
				(pMyProp1 cel: (pMyProp1 lastCel:))
				(= seconds 1)
			)
			(76
				(pMyProp1 hide:)
				(gCurRoom drawPic: 5010)
				(= seconds 1)
			)
			(77
				(gCurRoom drawPic: 6140)
				(= seconds 1)
			)
			(78
				(gCurRoom drawPic: 6200)
				(= seconds 1)
			)
			(79
				(gCurRoom drawPic: 6220)
				(= seconds 1)
			)
			(80
				(gCurRoom drawPic: 6221)
				(pMyProp1 view: 6221 loop: 0 cel: 0 show:)
				(= seconds 2)
			)
			(81
				(pMyProp1 hide:)
				(gCurRoom drawPic: 6070)
				(= seconds 1)
			)
			(82
				(gCurRoom drawPic: 6280)
				(= seconds 1)
			)
			(83
				(gSounds setVol: 7112 40)
				(gSounds play: 20605 0 85 0)
				(pMyProp4 view: 52060 cel: 0 init:)
				(pMyProp4 show:)
				(self cue:)
			)
			(84
				(pMyProp4 setCycle: End self)
			)
			(85
				(pMyProp4 view: 52064 cel: (pMyProp4 lastCel:))
				(self cue:)
			)
			(86
				(pMyProp4 setCycle: Beg self)
			)
			(87
				(gSounds setVol: 7112 100)
				(pMyProp4 hide:)
				(self cue:)
			)
			(88
				(gCurRoom drawPic: 6160)
				(= seconds 1)
			)
			(89
				(gCurRoom drawPic: 7050)
				(= seconds 1)
			)
			(90
				(gCurRoom drawPic: 7111)
				(pMyProp1 view: 7110 loop: 2)
				(pMyProp1 cel: (pMyProp1 lastCel:) show:)
				(pMyProp2 view: 7110 loop: 5 init:)
				(pMyProp2 cel: (pMyProp2 lastCel:) show:)
				(pMyProp3 view: 7110 loop: 7 init:)
				(pMyProp3 cel: (pMyProp3 lastCel:) show:)
				(= seconds 2)
			)
			(91
				(pMyProp1 hide:)
				(pMyProp2 hide:)
				(pMyProp3 hide:)
				(gCurRoom drawPic: 7080)
				(= ticks 100)
			)
			(92
				(gCurRoom drawPic: 29270)
				(= seconds 1)
			)
			(93
				(gCurRoom drawPic: 29260)
				(= seconds 1)
			)
			(94
				(gCurRoom drawPic: 29020)
				(= seconds 1)
			)
			(95
				(gCurRoom drawPic: 29040)
				(= seconds 1)
			)
			(96
				(gCurRoom drawPic: 29160)
				(= seconds 1)
			)
			(97
				(gCurRoom drawPic: 29250)
				(= seconds 1)
			)
			(98
				(gCurRoom drawPic: 20101)
				(= seconds 1)
			)
			(99
				(gCurRoom drawPic: 20102)
				(= seconds 1)
			)
			(100
				(gCurRoom drawPic: 20103)
				(= seconds 1)
			)
			(101
				(gCurRoom drawPic: 20104)
				(= seconds 1)
			)
			(102
				(gCurRoom drawPic: 20105)
				(= seconds 1)
			)
			(103
				(gCurRoom drawPic: 20106)
				(= seconds 1)
			)
			(104
				(= state -1)
				(gSounds fade: 7112 0 1 60 1 0)
				(gCurRoom drawPic: 921)
				(= seconds 15)
			)
		)
	)
)

