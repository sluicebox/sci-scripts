;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 109)
(include sci.sh)
(use Main)
(use Sync)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro10 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance intro10 of Rm
	(properties
		picture 76
		style 30
	)

	(method (init)
		(LoadMany rsVIEW 764 765 771 766 767 0 768)
		(HandsOff)
		(gGame setCursor: 5 1)
		(owl init:)
		(owlHead init:)
		(owlMouth init: hide:)
		(owlWing init:)
		(crispin init:)
		(trunk init:)
		(crispinCup init:)
		(crispinMouth init:)
		(gEgo view: 766 setLoop: 0 normal: 0 posn: 173 125 init:)
		(gEgo cel: (- (NumCels gEgo) 1))
		((gEgo head:) hide:)
		(egoCup init:)
		(self setScript: a2s5Script setRegions: 763) ; cartoonRegion
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo setPri: -1 setStep: 3 2 cycleSpeed: 0)
	)
)

(instance a2s5Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gGlobalSound loop: 1 number: 80 play:)
				(owlHead setCycle: End)
				(gEgo setScript: egoDrinkTea)
				(owl setScript: owlDrinkingTea)
				(crispinMouth setCycle: MouthSync 893)
				(Say 893 0 1)
				(= cycles 1)
			)
			(2
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(crispinMouth setCycle: 0)
				(= cycles 1)
			)
			(4
				(cls)
				(gEgo view: 767 setLoop: 2 setCycle: End self)
			)
			(5
				(gEgo setLoop: 7 cycleSpeed: 3)
				(owl setScript: owlDrinkingTea)
				(gEgo setCycle: MouthSync 894)
				(Say 894 0 1)
				(= cycles 1)
			)
			(6
				(if (< (gGlobalSound prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(gEgo
					setLoop: 2
					cel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(8
				(gEgo setScript: egoDrinkTea)
				(owl setScript: owlDrinkingTea)
				(crispin hide:)
				(crispinMouth hide:)
				(crispinTop init: setCycle: End self)
				(crispinBottom init:)
			)
			(9
				(cls)
				(crispinMouth show: posn: 135 87 setCycle: MouthSync 895)
				(Say 895 0 1)
				(= cycles 1)
			)
			(10
				(if (< (gGlobalSound prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(crispinMouth hide: setCycle: 0)
				(crispinTop cycleSpeed: 2 setCycle: Beg self)
			)
			(12
				(cls)
				(gEgo setScript: egoDrinkTea)
				(owlMouth show: setCycle: MouthSync 896)
				(Say 896 0 1)
				(= cycles 1)
			)
			(13
				(if
					(and
						(< (gGlobalSound prevSignal:) 40)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(14
				(cls)
				(owlMouth setCycle: 0 setCel: 0)
				(crispinTop setLoop: 5 setCycle: End self)
			)
			(15
				(crispinTop setLoop: 6 cycleSpeed: 4)
				(crispinTop setCycle: MouthSync 897)
				(Say 897 0 1)
				(= cycles 1)
			)
			(16
				(if
					(and
						(< (gGlobalSound prevSignal:) 50)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(17
				(cls)
				(crispinTop setCycle: MouthSync 898)
				(Say 898 self)
			)
			(18
				(owlHead hide:)
				(owlWing hide:)
				(owlMouth hide:)
				(owl setLoop: 6 cycleSpeed: 1 setCycle: End self)
			)
			(19
				(crispinTop setCycle: 0)
				(owlMouth show: setCycle: MouthSync 899)
				(Say 899 self)
				(gEgo setScript: egoDrinkTea)
			)
			(20
				(owlMouth hide: setCycle: 0)
				(owl cycleSpeed: 2 setCycle: Beg self)
			)
			(21
				(cls)
				(owlWing show:)
				(owl setLoop: 0 cel: 0)
				(owlHead show:)
				(owlMouth setCel: 0 show:)
				(= cycles 1)
			)
			(22
				(if
					(and
						(< (gGlobalSound prevSignal:) 70)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(23
				(crispinTop hide:)
				(crispinBottom
					setLoop: 7
					cycleSpeed: 2
					setPri: (crispinTop priority:)
					setCycle: End self
				)
			)
			(24
				(crispinMouth posn: 119 88 setLoop: 8 show:)
				(crispinMouth setCycle: MouthSync 900)
				(Say 900 0 1)
				(= cycles 1)
			)
			(25
				(if
					(and
						(< (gGlobalSound prevSignal:) 80)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(26
				(cls)
				(crispinMouth hide: setCycle: 0)
				(owlMouth setCycle: MouthSync 901)
				(Say 901 self)
			)
			(27
				(cls)
				(owlMouth setCycle: 0 setCel: 0)
				(crispinBottom setCycle: Beg self)
			)
			(28
				(if (not (== (gGlobalSound prevSignal:) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(29
				(gGlobalSound number: 81 loop: -1 play:)
				(crispinBottom setLoop: 0 cycleSpeed: 0 cel: 1)
				(crispinTop show: setCycle: MouthSync 902)
				(Say 902 self)
			)
			(30
				(cls)
				(crispinBottom hide: dispose:)
				(crispinTop hide: setCycle: 0)
				(= local4 1)
				(crispin
					view: 771
					show:
					setPri: 14
					setLoop: 0
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
			)
			(31
				(crispinCup addToPic:)
				(UnLoad 128 764)
				(crispin cel: 0 setLoop: 10 setCycle: End self)
			)
			(32
				(crispin
					setLoop: 1
					cycleSpeed: 1
					cel: 0
					setCycle: Fwd
					moveSpeed: 3
					signal: (| (crispin signal:) $4800)
					setMotion: MoveTo 145 126 self
				)
			)
			(33
				(crispin setMotion: MoveTo 207 126 self)
			)
			(34
				(gEgo view: 767 setLoop: 4 cel: 0)
				(crispin
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 219 118 self
				)
			)
			(35
				(crispin setLoop: 4 cel: 0 setCycle: CT 4 1 self)
			)
			(36
				(gGlobalSound3 number: 124 loop: 1 play:)
				(crispin setCycle: End self)
			)
			(37
				(crispin
					setLoop: 5
					setCycle: Fwd
					cel: 0
					setScript: searchThroughChest self
				)
			)
			(38
				(Say 905 self)
			)
			(39
				(cls)
				(crispin setLoop: 6 cel: 0 setCycle: End self)
			)
			(40
				(crispin setLoop: 7 cel: 0 setCycle: End self)
			)
			(41
				(crispin
					setLoop: 2
					view: 771
					setCycle: Walk
					setMotion: MoveTo (- (crispin x:) 6) (crispin y:) self
				)
			)
			(42
				(crispin view: 765 setLoop: 3)
				(crispin cel: (crispin lastCel:))
				(crispinMouth
					view: 765
					setLoop: 10
					setPri: 15
					posn: 212 87
					setCycle: MouthSync 906
					show:
				)
				(Say 906 self)
			)
			(43
				(crispinMouth setCycle: 0 hide:)
				(crispin
					view: 765
					setLoop: 2
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
			)
			(44
				(= seconds 2)
			)
			(45
				(gEgo
					view: 767
					cycleSpeed: 2
					setLoop: 4
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(46
				(cls)
				(gEgo cel: 4 setCycle: End self)
				(crispin setLoop: 3 cel: 0 setCycle: End)
			)
			(47
				(egoHead init: setCycle: MouthSync 907)
				(Say 907 self)
				(gEgo ignoreActors: 1 setLoop: 5 setCycle: End)
			)
			(48
				(cls)
				(egoHead hide: setCycle: 0)
				(crispinMouth show:)
				(crispinMouth view: 765 setLoop: 10 setPri: 15 posn: 212 87)
				(crispinMouth setCycle: MouthSync 908)
				(Say 908 self)
			)
			(49
				(cls)
				(crispinMouth setCycle: MouthSync 909)
				(Say 909 self)
			)
			(50
				(cls)
				(crispin hide:)
				(crispinMouth hide:)
				(crispinBottom view: 765 posn: 211 114 setLoop: 4 init: show:)
				(gGlobalSound3 number: 125 loop: 1 play:)
				(crispinTop
					view: 765
					posn: 206 100
					setLoop: 5
					cel: 0
					setCycle: Fwd
					init:
					show:
				)
				(= seconds 2)
			)
			(51
				(crispinTop setCycle: End self)
			)
			(52
				(crispinMouth show: posn: 208 88)
				(crispinMouth setCycle: MouthSync 910)
				(Say 910 self)
			)
			(53
				(cls)
				(crispinMouth setCycle: MouthSync 911)
				(Say 911 self)
			)
			(54
				(crispinMouth hide:)
				(crispinTop dispose:)
				(crispinBottom dispose:)
				(crispin
					show:
					setLoop: 6
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
			)
			(55
				(= seconds 2)
			)
			(56
				(gEgo get: 28 setLoop: 3 setCycle: CT 3 1 self) ; Wand
			)
			(57
				(gEgo setCycle: End self)
				(crispin setLoop: 7 cel: 0 setCycle: End)
			)
			(58
				(= cycles 6)
			)
			(59
				(= cycles 1)
			)
			(60
				(gEgo setLoop: 4 cel: 0)
				(= cycles 1)
			)
			(61
				(cls)
				(crispinMouth show: posn: 212 87)
				(crispinMouth setCycle: MouthSync 912)
				(Say 912 self)
			)
			(62
				(cls)
				(crispinMouth setCycle: MouthSync 913)
				(Say 913 self)
			)
			(63
				(cls)
				(crispinMouth hide: setCycle: 0)
				(gEgo view: 766 setLoop: 0)
				(gEgo cel: (- (NumCels gEgo) 1))
				((gEgo head:) hide:)
				(owlMouth setCycle: MouthSync 914)
				(Say 914 self)
			)
			(64
				(cls)
				(gEgo view: 767 setLoop: 4 cel: 0)
				(owlMouth setCycle: 0 setCel: 0)
				(crispinMouth show: setCycle: MouthSync 915)
				(Say 915 self)
			)
			(65
				(crispinMouth setCycle: 0 hide:)
				(crispin view: 771 setLoop: 11 setCycle: End self)
			)
			(66
				(cls)
				(egoHead show:)
				(egoHead setCycle: MouthSync 916)
				(Say 916 self)
			)
			(67
				(cls)
				(egoHead hide: setCycle: 0)
				(owlHead hide:)
				(owlWing hide:)
				(owlMouth hide:)
				(owl setLoop: 7 cel: 0 setCycle: End self)
			)
			(68
				(owl setLoop: 8 cel: 0 setCycle: End self)
			)
			(69
				(owl
					setLoop: 9
					signal: 18432
					posn: 110 103
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 146 178 self
				)
			)
			(70
				(owl dispose:)
				(UnLoad 128 768)
				(= cycles 1)
			)
			(71
				(gEgo view: 766 setLoop: 1 setCycle: End self)
			)
			(72
				(egoCup addToPic:)
				(UnLoad 128 767)
				(gEgo
					view: 0
					setLoop: 2
					normal: 1
					setCycle: SyncWalk
					cycleSpeed: 0
					moveSpeed: 1
					setStep: 3 2
					setMotion: MoveTo 145 191 self
				)
				((gEgo head:) show:)
			)
			(73
				(gGlobalSound fade:)
				(if global327
					(= gQuit 1)
				else
					(gCurRoom newRoom: 1)
				)
			)
		)
	)
)

(instance searchThroughChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cls)
				(gGlobalSound3 number: 126 loop: -1 play:)
				(crispin setCycle: 0)
				(Say 903 self)
			)
			(1
				(crispin setCycle: Fwd)
				(= seconds 4)
			)
			(2
				(cls)
				(crispin setCycle: 0)
				(Say 904 self)
			)
			(3
				(crispin setCycle: Fwd)
				(= seconds 2)
			)
			(4
				(gGlobalSound3 stop:)
				(client setScript: 0)
			)
		)
	)
)

(instance egoDrinkTea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoCup hide:)
				(gEgo
					view: 767
					setLoop: 0
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo setLoop: 0)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(5
				(gEgo view: 766 setLoop: 0)
				(gEgo cycleSpeed: 0)
				(egoCup show:)
				(client setScript: 0)
			)
		)
	)
)

(instance crispinDrinkTea of Script ; UNUSED
	(properties)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					local5
					(not local2)
					(== (crispinTop loop:) 3)
					(== (crispinTop cel:) 4)
				)
				(crispinCup hide:)
				(= local2 1)
				(= local5 0)
			)
			(
				(and
					local5
					local2
					(== (crispinTop loop:) 3)
					(== (crispinTop cel:) 4)
				)
				(crispinCup show:)
				(= local2 0)
				(= local5 0)
			)
			((!= (crispinTop cel:) 4)
				(= local5 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crispinCup setPri: 15)
				(= local1 (crispinTop loop:))
				(crispinTop setLoop: 3 cel: 0 setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(crispinTop setLoop: 4 cel: 0 setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(crispinTop setCycle: Beg self)
			)
			(5
				(crispinTop
					setLoop: 3
					cel: (- (NumCels crispinTop) 1)
					setCycle: Beg self
				)
			)
			(6
				(crispinTop setLoop: local1)
				(crispinCup setPri: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance bodyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance egoCup of Prop
	(properties
		x 155
		y 103
		view 767
		loop 6
	)
)

(instance crispin of Actor
	(properties
		x 140
		y 124
		view 764
	)

	(method (doit)
		(super doit:)
		(if (not local4)
			(self setPri: (+ (trunk priority:) 1))
		)
	)
)

(instance crispinCup of Prop
	(properties
		x 144
		y 105
		view 764
		cel 3
		signal 16384
	)
)

(instance crispinMouth of Prop
	(properties
		x 133
		y 88
		view 764
		loop 1
		cycleSpeed 2
	)

	(method (doit)
		(super doit:)
		(if local4
			(self setPri: 15)
		else
			(self
				setPri:
					(+
						((if (gCast contains: crispinTop)
								crispinTop
							else
								crispin
							)
							priority:
						)
						1
					)
			)
		)
	)
)

(instance crispinTop of Prop
	(properties
		x 135
		y 107
		view 764
		loop 2
	)

	(method (doit)
		(super doit:)
		(self setPri: (+ (crispinBottom priority:) 1))
	)
)

(instance crispinBottom of Prop
	(properties
		x 140
		y 124
		view 764
		cel 1
	)

	(method (doit)
		(super doit:)
		(if local4
			(self setPri: (+ (trunk priority:) 1))
		)
	)
)

(instance trunk of Prop
	(properties
		x 219
		y 118
		view 766
		loop 4
	)

	(method (doit)
		(super doit:)
		(self
			setCel:
				(cond
					(local3
						(if global159 7 else 5)
					)
					((and (== (crispin loop:) 4) (== (crispin cel:) 5))
						(if global159 0 else 1)
					)
					((and (== (crispin loop:) 4) (== (crispin cel:) 6))
						(if global159 1 else 2)
					)
					((and (== (crispin loop:) 4) (== (crispin cel:) 7))
						(if global159 2 else 3)
					)
					((and (== (crispin loop:) 4) (== (crispin cel:) 8))
						(if global159 4 else 4)
					)
					((and (== (crispin loop:) 4) (== (crispin cel:) 9))
						(if global159
							5
						else
							5
							(= local3 1)
							(self addToPic:)
						)
					)
					((and (== (crispin loop:) 4) (== (crispin cel:) 10))
						(if global159 6 else 5)
						(= local3 1)
						(self addToPic:)
					)
				)
		)
	)
)

(instance egoHead of Prop
	(properties
		x 172
		y 125
		z 36
		view 766
		loop 3
		cycleSpeed 2
	)
)

(instance owl of Actor
	(properties
		x 90
		y 109
		view 768
		priority 8
		cycleSpeed 2
	)
)

(instance owlHead of Prop
	(properties
		x 92
		y 102
		view 768
		loop 1
		priority 8
	)

	(method (init)
		(super init:)
		(self setPri: 8)
	)
)

(instance owlMouth of Prop
	(properties
		x 94
		y 94
		view 768
		loop 3
		priority 8
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self setPri: 8)
	)

	(method (doit)
		(super doit:)
		(if (== (owl loop:) 6)
			(self posn: 96 94)
		else
			(self posn: 94 94)
		)
	)
)

(instance owlWing of Prop
	(properties
		x 86
		y 100
		view 768
		loop 4
		priority 12
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setPri: 8)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(not (self script:))
				(not (& (owlWing signal:) $0008))
				(not (& (owlMouth signal:) $0008))
				(owlMouth cycler:)
			)
			(switch (Random 1 10)
				(1
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

(instance owlDrinkingTea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owlHead hide:)
				(owlMouth hide:)
				(owlWing hide:)
				(owl setLoop: 2 setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(owl setCycle: Beg self)
			)
			(3
				(owlHead show:)
				(owlMouth show:)
				(owlWing show:)
				(owl setLoop: 0 cel: 0)
				(client setScript: 0)
			)
		)
	)
)

