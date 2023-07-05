;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use n098)
(use Plane)
(use Array)
(use Print)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm120 0
)

(local
	[local0 2] = [-1 30]
	[local2 11]
	[local13 11]
	local24
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2)
	(if (== param1 2)
		(= temp0 315)
		(= temp1 175)
		(= temp2 1)
	else
		(= temp0 3)
		(= temp1 6)
		(= temp2 0)
	)
	(c2
		view: 954
		setLoop: temp2 1
		x: temp0
		y: 72
		setPri: 30
		cycleSpeed: 4
		setCycle: Fwd
	)
	(c3 view: 953 setLoop: 0 1 x: temp1 y: 17 setPri: 30)
	(UpdateScreenItem c2)
	(UpdateScreenItem c3)
)

(instance rm120 of LarryRoom
	(properties
		picture 120
		noControls 1
	)

	(method (init)
		(super init:)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(if (!= gPrevRoomNum 110)
			(SetCursor 98 0 0)
			(gGlobalSound2 number: 0 stop:)
			(gGlobalSound1 number: 120 loop: -1 play:)
		)
		(gEgo view: 98 x: 100 y: 100 init:)
		(self setScript: creditScr)
	)

	(method (dispose)
		(gGlobalSound1 number: 0 stop:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event type:)
			(if (< (script state:) 92)
				(event claimed: 1)
				(proc98_0)
			else
				(gCast eachElementDo: #dispose)
				(gThePlane drawPic: -2)
				(Palette 2 0 255 100) ; PalIntensity
				(event claimed: 1)
				(proc98_0)
			)
		)
	)
)

(instance c1 of Actor
	(properties
		priority 60
		fixPriority 1
		view 98
		signal 26657
	)
)

(instance c2 of Prop
	(properties
		priority 60
		fixPriority 1
		view 98
		signal 26657
	)
)

(instance c3 of Prop
	(properties
		priority 60
		fixPriority 1
		view 98
		signal 26657
	)
)

(instance c4 of Prop
	(properties
		priority 60
		fixPriority 1
		view 98
		signal 26657
	)
)

(instance c5 of Prop
	(properties
		priority 60
		fixPriority 1
		view 98
		signal 26657
	)
)

(instance creditScr of Script
	(properties)

	(method (dispose &tmp temp0)
		(sfx number: 0 stop:)
		(sfx2 number: 0 stop:)
		(proc79_12
			123
			353
			520
			326
			800
			869
			126
			636
			312
			443
			814
			129
			124
			125
			637
			343
			127
			128
		)
		(cond
			((== state 89)
				(for ((= temp0 1)) (<= temp0 8) ((++ temp0))
					(if ([local13 temp0] dialog:)
						(([local13 temp0] dialog:) dispose:)
						(= [local13 temp0] 0)
					)
				)
			)
			((OneOf state 91 92)
				(for ((= temp0 1)) (<= temp0 8) ((++ temp0))
					(if ([local13 temp0] dialog:)
						(([local13 temp0] dialog:) dispose:)
						(= [local13 temp0] 0)
					)
				)
			)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc79_11
					123
					353
					520
					326
					800
					869
					126
					636
					312
					443
					814
					129
					124
					125
					637
					343
					127
					128
				)
				(c1 init:)
				(c2 init:)
				(c3 init:)
				(c4 init:)
				(c5 init:)
				(= register 0)
				(= cycles 2)
			)
			(1
				(if (>= (+= register 2) 100)
					(-- state)
					(Palette 2 0 255 register) ; PalIntensity
				)
				(= ticks 1)
			)
			(2
				(Palette 2 0 255 100) ; PalIntensity
				(= cycles 2)
			)
			(3
				(Load rsVIEW 943)
				(c1
					view: 939
					setLoop: 0 1
					setCycle: Fwd
					x: -20
					y: 132
					setMotion: MoveTo 130 132 self
				)
			)
			(4
				(c1 setMotion: MoveTo 175 132 self)
				(sfx number: 123 loop: 1 play:)
				(if (> gHowFast 3)
					(c3 cycleSpeed: 4)
				else
					(c3 cycleSpeed: 1)
				)
				(c3
					view: 943
					setLoop: 3 1
					setCel: 0
					x: 152
					y: 103
					setCycle: End self
				)
			)
			(5)
			(6
				(c1 setMotion: MoveTo 230 132 self)
				(sfx number: 123 loop: 1 play:)
				(if (> gHowFast 3)
					(c4 cycleSpeed: 4)
				else
					(c4 cycleSpeed: 1)
				)
				(c4
					view: 943
					setLoop: 1
					setCel: 0
					x: 198
					y: 101
					setCycle: End self
				)
			)
			(7)
			(8
				(sfx number: 123 loop: 1 play:)
				(if (> gHowFast 3)
					(c5 cycleSpeed: 4)
				else
					(c5 cycleSpeed: 1)
				)
				(c5
					view: 943
					setLoop: 2 1
					setCel: 0
					x: 248
					y: 103
					setCycle: End self
				)
				(c1 setMotion: MoveTo 362 132 self)
			)
			(9)
			(10
				(sfx number: 0 stop:)
				(proc79_12 123)
				(Load rsVIEW 951)
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(11
				(c1 setCel: 0 view: 98)
				(c2 setCel: 0 view: 98)
				(c3 setCel: 0 view: 98)
				(c4 setCel: 0 view: 98)
				(c5 setCel: 0 view: 98)
				(UnLoad 128 943)
				(= ticks 60)
			)
			(12
				(if (> gHowFast 3)
					(c2 cycleSpeed: 4)
				else
					(c2 cycleSpeed: 1)
				)
				(c2 view: 951 setCel: 1 setLoop: 0 1 x: 74 y: 77)
				(= cycles 2)
			)
			(13
				(sfx number: 353 loop: 1 play:)
				(c2 setCycle: End self)
			)
			(14
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(15
				(sfx number: 0 stop:)
				(proc79_12 353)
				(if (> gHowFast 3)
					(c3 cycleSpeed: 4)
				else
					(c3 cycleSpeed: 1)
				)
				(c3
					view: 951
					setCel: 0
					setLoop: 1 1
					x: 211
					y: -10
					setCycle: CT 4 1 self
				)
			)
			(16
				(sfx number: 520 loop: 1 play:)
				(c3 setCycle: End self)
			)
			(17
				(Load rsVIEW 944)
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(18
				(sfx number: 0 stop:)
				(proc79_12 520)
				(c1 setCel: 0 view: 98)
				(c2 setCel: 0 view: 98)
				(c3 setCel: 0 view: 98)
				(c4 setCel: 0 view: 98)
				(c5 setCel: 0 view: 98)
				(UnLoad 128 951)
				(= ticks 60)
			)
			(19
				(if (> gHowFast 3)
					(c1 cycleSpeed: 4)
				else
					(c1 cycleSpeed: 1)
				)
				(c1 view: 944 setCel: 0 setLoop: 0 1 x: 10 y: 75 setCycle: 0)
				(= ticks 90)
			)
			(20
				(sfx number: 326 loop: 1 play:)
				(c1 setCycle: End self)
			)
			(21
				(= ticks 40)
			)
			(22
				(sfx number: 0 stop:)
				(proc79_12 326)
				(if (> gHowFast 3)
					(c5 cycleSpeed: 4)
				else
					(c5 cycleSpeed: 1)
				)
				(c5 view: 944 setCel: 0 setLoop: 2 1 x: 196 y: 87)
				(= cycles 2)
			)
			(23
				(sfx number: 800 loop: 1 play:)
				(c5 setCycle: End self)
			)
			(24
				(c5 view: 98)
				(c2 view: 944 setCel: 0 setLoop: 1 1 x: 140 y: 70)
				(if (> gHowFast 3)
					(= seconds 5)
				else
					(= seconds 3)
				)
			)
			(25
				(sfx number: 0 stop:)
				(proc79_12 800)
				(gCast eachElementDo: #hide)
				(= ticks 60)
			)
			(26
				(c1 setCel: 0 view: 98)
				(c3 setCel: 0 view: 98)
				(c4 setCel: 0 view: 98)
				(c5 setCel: 0 view: 98)
				(gCast eachElementDo: #show)
				(c2 view: 946 setCel: 0 setLoop: 0 1 x: 139 y: 70)
				(UnLoad 128 944)
				(= ticks 90)
			)
			(27
				(sfx number: 869 loop: 1 play:)
				(if (> gHowFast 3)
					(c2 cycleSpeed: 6)
				else
					(c2 cycleSpeed: 2)
				)
				(c2 setCycle: End self)
			)
			(28
				(sfx2 number: 126 loop: 1 play:)
				(c2 setLoop: 1 1 setCycle: Fwd)
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(29
				(sfx number: 0 stop:)
				(proc79_12 869)
				(c2 setCel: 0 setLoop: 2 1 setCycle: 0)
				(= ticks 30)
			)
			(30
				(c2 setCycle: CT 3 1 self)
			)
			(31
				(sfx2 number: 0 stop:)
				(proc79_12 126)
				(sfx number: 636 loop: 1 play:)
				(c2 setCycle: End self)
			)
			(32
				(c2 setCel: 0 setLoop: 5 1)
				(c3 view: 946 setCel: 0 setLoop: 4 1 x: 209 y: 29)
				(c4
					view: 946
					setCel: 0
					setLoop: 3 1
					x: 78
					y: 2
					setCycle: End self
				)
			)
			(33
				(sfx number: 0 stop:)
				(proc79_12 636)
				(c3 setCycle: End self)
			)
			(34
				(= ticks 60)
			)
			(35
				(c2 setCycle: End self)
			)
			(36
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(37
				(c1 setCel: 0 view: 98)
				(c2 setCel: 0 view: 98)
				(c3 setCel: 0 view: 98)
				(c4 setCel: 0 view: 98)
				(c5 setCel: 0 view: 98)
				(Load rsVIEW 941)
				(= ticks 60)
			)
			(38
				(c1 view: 941 setCel: 0 setLoop: 0 1 x: 63 y: 29)
				(c2 view: 941 setCel: 1 setLoop: 0 1 x: 129 y: 59)
				(if (> gHowFast 3)
					(c5 cycleSpeed: 4)
				else
					(c5 cycleSpeed: 1)
				)
				(c5 view: 941 setLoop: 3 1 setCel: 0 x: 231 y: 133)
				(c3 view: 98)
				(c4 view: 98)
				(UnLoad 128 946)
				(= ticks 60)
			)
			(39
				(c5 setCycle: End self)
			)
			(40
				(sfx number: 312 loop: 1 play: self)
			)
			(41
				(sfx number: 0 stop:)
				(proc79_12 312)
				(c3 view: 941 setLoop: 1 1 setCel: 0 x: 160 y: 62)
				(c5 setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(42
				(Load rsVIEW 949)
				(= ticks 120)
			)
			(43
				(c3 view: 98)
				(c4 view: 98)
				(c5 view: 98)
				(c2 view: 949 setLoop: 3 1 setCel: 0 x: 31 y: 15)
				(if (> gHowFast 3)
					(c1 cycleSpeed: 4)
				else
					(c1 cycleSpeed: 1)
				)
				(c1
					view: 949
					setLoop: 2 1
					setCel: 0
					x: 330
					y: 74
					setStep: 20 20
					moveSpeed: 2
					setCycle: Fwd
					setMotion: MoveTo 132 74 self
				)
				(UnLoad 128 942)
				(UnLoad 128 941)
			)
			(44
				(c1
					setLoop: 1 1
					setCel: 0
					setCycle: 0
					setMotion: 0
					setCycle: 0
					x: 118
					y: 91
				)
				(= ticks 20)
			)
			(45
				(c1 cel: 1)
				(= ticks 30)
			)
			(46
				(if (> gHowFast 3)
					(c1 cycleSpeed: 4)
				else
					(c1 cycleSpeed: 1)
				)
				(c1 view: 949 setLoop: 7 1 setCel: 0 x: 119 y: 95)
				(if (> gHowFast 3)
					(c3 cycleSpeed: 4)
				else
					(c3 cycleSpeed: 1)
				)
				(c3 view: 949 setLoop: 0 1 setCel: 0 x: 133 y: 97)
				(= ticks 60)
			)
			(47
				(c1 setCycle: CT 2 1 self)
			)
			(48
				(sfx number: 443 loop: 1 play:)
				(c3 setCycle: End self)
				(c1 setCycle: End self)
			)
			(49)
			(50
				(sfx number: 0 stop:)
				(proc79_12 443)
				(c3 setLoop: 5 1 setCel: 0 x: 222 y: 68 setCycle: CT 9 1 self)
			)
			(51
				(c1 hide: setLoop: 6 1 cel: 0)
				(if (> gHowFast 3)
					(c3 cycleSpeed: 4)
				else
					(c3 cycleSpeed: 1)
				)
				(c3 setCycle: CT 11 1 self)
			)
			(52
				(sfx number: 814 loop: 1 play:)
				(if (> gHowFast 3)
					(c1 cycleSpeed: 6)
				else
					(c1 cycleSpeed: 2)
				)
				(c1 show: setCycle: End self)
			)
			(53
				(sfx number: 0 stop:)
				(proc79_12 814)
				(c3 setCycle: End self)
			)
			(54
				(c1 setLoop: 4 1 setCel: 0 x: 140 y: 117 setCycle: End self)
			)
			(55
				(= ticks 30)
			)
			(56
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(57
				(c1 view: 98)
				(c2 view: 98)
				(c3 view: 98)
				(c4 view: 98)
				(c5 view: 98)
				(Load rsVIEW 950)
				(= ticks 60)
			)
			(58
				(if (> gHowFast 3)
					(c1 cycleSpeed: 4)
				else
					(c1 cycleSpeed: 1)
				)
				(c1 view: 950 setLoop: 0 1 setCel: 0 x: 101 y: 132 setCycle: 0)
				(if (> gHowFast 3)
					(c2 cycleSpeed: 4)
				else
					(c2 cycleSpeed: 1)
				)
				(c2 view: 950 setLoop: 4 1 setCel: 0 x: 17 y: 51)
				(UnLoad 128 949)
				(= ticks 60)
			)
			(59
				(c1 setCycle: CT 6 1 self)
			)
			(60
				(if (> gHowFast 3)
					(c3 cycleSpeed: 4)
				else
					(c3 cycleSpeed: 1)
				)
				(c3
					view: 950
					setLoop: 1 1
					setCel: 0
					x: 93
					y: 88
					setCycle: End self
				)
				(sfx number: 129 loop: 1 play:)
				(c1 setCycle: End)
			)
			(61
				(= ticks 120)
			)
			(62
				(c1 cel: 0 setCycle: CT 6 1 self)
			)
			(63
				(if (> gHowFast 3)
					(c4 cycleSpeed: 4)
				else
					(c4 cycleSpeed: 1)
				)
				(c4
					view: 950
					setLoop: 2 1
					setCel: 0
					x: 96
					y: 86
					setCycle: End self
				)
				(sfx number: 129 loop: 1 play:)
				(c1 setCycle: End)
			)
			(64
				(= ticks 120)
			)
			(65
				(c1 cel: 0 setCycle: CT 6 1 self)
			)
			(66
				(if (> gHowFast 3)
					(c5 cycleSpeed: 4)
				else
					(c5 cycleSpeed: 1)
				)
				(c5
					view: 950
					setLoop: 3 1
					setCel: 0
					x: 97
					y: 83
					setCycle: End self
				)
				(sfx number: 129 loop: 1 play:)
				(c1 setCycle: End)
			)
			(67
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(68
				(sfx number: 0 stop:)
				(proc79_12 129)
				(c1 view: 98)
				(c2 view: 98)
				(c3 view: 98)
				(c4 view: 98)
				(c5 view: 98)
				(Load rsVIEW 945)
				(= ticks 60)
			)
			(69
				(c2 view: 945 setLoop: 1 1 setCel: 0 x: 103 y: 73)
				(if (> gHowFast 3)
					(c3 cycleSpeed: 4)
				else
					(c3 cycleSpeed: 1)
				)
				(c3 view: 945 setLoop: 0 1 setCel: 0 x: 66 y: 33)
				(UnLoad 128 950)
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(70
				(c3 setCycle: CT 6 1 self)
			)
			(71
				(sfx number: 124 loop: 1 play:)
				(= ticks 120)
			)
			(72
				(sfx number: 0 stop:)
				(proc79_12 124)
				(c3 setCycle: CT 11 1 self)
			)
			(73
				(c3 setCycle: End self)
				(sfx number: 125 loop: 1 play:)
			)
			(74
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(75
				(sfx number: 0 stop:)
				(proc79_12 125)
				(c1 view: 98)
				(c2 view: 98)
				(c3 view: 98)
				(c4 view: 98)
				(c5 view: 98)
				(Load rsVIEW 952)
				(= ticks 60)
			)
			(76
				(if (> gHowFast 3)
					(c3 cycleSpeed: 4)
				else
					(c3 cycleSpeed: 1)
				)
				(c3 view: 952 setLoop: 1 1 setCel: 0 x: 89 y: 26)
				(UnLoad 128 945)
				(= ticks 60)
			)
			(77
				(sfx number: 637 loop: 1 play:)
				(c3 setCycle: End self)
			)
			(78
				(sfx number: 0 stop:)
				(proc79_12 637)
				(c2 view: 952 setLoop: 2 1 setCel: 0 x: 313 y: 34)
				(= ticks 60)
			)
			(79
				(c2 setCycle: End self)
			)
			(80
				(if (> gHowFast 3)
					(c2 cycleSpeed: 4)
				else
					(c2 cycleSpeed: 1)
				)
				(c2 setLoop: 3 1 setCel: 0 x: 273 y: 31 setCycle: Fwd)
				(sfx2 number: 343 loop: -1 play:)
				(= ticks 180)
			)
			(81
				(sfx2 number: 0 stop:)
				(proc79_12 343)
				(if (> gHowFast 3)
					(c4 cycleSpeed: 4)
				else
					(c4 cycleSpeed: 1)
				)
				(c4
					view: 952
					setLoop: 0 1
					setCel: 0
					x: 286
					y: 39
					setCycle: End self
				)
			)
			(82
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(83
				(Load rsVIEW 948)
				(c1 view: 98)
				(c2 view: 98)
				(c3 view: 98)
				(c4 view: 98)
				(c5 view: 98)
				(= ticks 60)
			)
			(84
				(if (> gHowFast 3)
					(c4 cycleSpeed: 4)
				else
					(c4 cycleSpeed: 1)
				)
				(c4 view: 948 setLoop: 1 1 x: 140 y: 45 setCycle: Fwd)
				(sfx number: 127 loop: 1 play:)
				(UnLoad 128 952)
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(85
				(sfx number: 0 stop:)
				(proc79_12 127)
				(c4 setLoop: 0 1 cel: 0 setCycle: End self)
				(sfx number: 128 loop: 1 play:)
			)
			(86
				(if (> gHowFast 3)
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(87
				(sfx number: 0 stop:)
				(proc79_12 128)
				(c4 view: 955 setLoop: 0 x: 135 y: 70)
				(localproc_0 1)
				(= seconds 10)
			)
			(88
				(c2 view: 98)
				(c4 view: 98)
				(= cycles 2)
			)
			(89
				(localproc_0 2)
				(= local24 5)
				(for ((= temp0 1)) (<= temp0 8) ((++ temp0))
					(= [local2 temp0] (ByteArray new: 30))
					(= [local13 temp0] (myPrint new:))
					(Message msgGET 110 0 0 3 temp0 ([local2 temp0] data:))
					([local13 temp0]
						fore: 1
						back: -1
						font: 900
						skip: -1
						modeless: 2
						posn: 10 (+= local24 15)
						width: 200
						addText: ([local2 temp0] data:)
						plane: ((Plane new:) picture: -2 yourself:)
						init:
					)
					([local2 temp0] dispose:)
				)
				(FrameOut)
				(= seconds 10)
			)
			(90
				(for ((= temp0 1)) (<= temp0 8) ((++ temp0))
					(if ([local13 temp0] dialog:)
						(([local13 temp0] dialog:) dispose:)
						(= [local13 temp0] 0)
					)
				)
				(c2 view: 98)
				(c3 view: 98)
				(= cycles 2)
			)
			(91
				(localproc_0 1)
				(= local24 5)
				(for ((= temp0 1)) (<= temp0 8) ((++ temp0))
					(= [local2 temp0] (ByteArray new: 30))
					(= [local13 temp0] (myPrint new:))
					(Message msgGET 110 0 0 4 temp0 ([local2 temp0] data:))
					([local13 temp0]
						fore: 1
						back: -1
						font: 900
						skip: -1
						modeless: 2
						posn: 165 (+= local24 15)
						width: 200
						addText: ([local2 temp0] data:)
						plane: ((Plane new:) picture: -2 yourself:)
						init:
					)
					([local2 temp0] dispose:)
				)
				(FrameOut)
				(= seconds 10)
			)
			(92
				(gGlobalSound1 fade: 0 30 5 1)
				(= register 100)
				(c2 setCycle: 0 cel: 0)
				(= cycles 2)
			)
			(93
				(if (> (-= register 2) 0)
					(-- state)
					(Palette 2 0 255 register) ; PalIntensity
				else
					(for ((= temp0 1)) (<= temp0 8) ((++ temp0))
						(if ([local13 temp0] dialog:)
							(([local13 temp0] dialog:) dispose:)
							(= [local13 temp0] 0)
						)
					)
				)
				(= ticks 1)
			)
			(94
				(gCast eachElementDo: #dispose)
				(gThePlane drawPic: -2)
				(= ticks 180)
			)
			(95
				(Palette 2 0 255 100) ; PalIntensity
				(gCurRoom newRoom: 130)
			)
		)
	)
)

(instance myPrint of Print
	(properties
		doBorder 0
	)

	(method (handleEvent)
		(return 0)
	)

	(method (doit))
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance sfx2 of Sound
	(properties
		flags 5
	)
)

