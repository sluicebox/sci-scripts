;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 109)
(include sci.sh)
(use Main)
(use Interface)
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
	)

	(method (init)
		(proc0_24 128 764 765 771 766 767 0 768)
		(HandsOff)
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
		(self setScript: a2s5Script)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo setPri: -1 setStep: 3 2 cycleSpeed: 0)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (not global327)
			(= temp0 (Event new:))
			(if (or (== (temp0 type:) evKEYBOARD) (== (temp0 type:) evMOUSEBUTTON))
				(temp0 dispose:)
				(gGlobalSound stop:)
				(gGame restart:)
			)
			(temp0 dispose:)
		)
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
				(crispinMouth setCycle: Fwd)
				(owl setScript: owlDrinkingTea)
				(PrintDC 109 0 #at 10 10 #dispose #width 270) ; "...The Society of Wizards has always taken a dim view of Mordack and his abuse of his power. Why, he's even been put on suspension a few times. It never seems to do any good, though."
				(= cycles 1)
			)
			(2
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(crispinMouth setCycle: Beg self)
			)
			(4
				(cls)
				(gEgo view: 767 setLoop: 2 setCycle: End self)
			)
			(5
				(gEgo setLoop: 7 cycleSpeed: 3 setCycle: Fwd)
				(owl setScript: owlDrinkingTea)
				(PrintDC 109 1 #at 100 120 #dispose) ; "Crispin, why would Mordack want to take my family or castle? What did WE ever do to him?"
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
				(crispinMouth show: posn: 135 87 setCycle: Fwd)
				(cls)
				(PrintDC 109 2 #at 10 10 #dispose) ; "I'm afraid I don't know the answer to that. Mordack is a very unpredictable wizard. I've NEVER understood that evil mind of his."
				(= cycles 1)
			)
			(10
				(if (< (gGlobalSound prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(crispinMouth hide:)
				(crispinTop cycleSpeed: 2 setCycle: Beg self)
			)
			(12
				(cls)
				(owlMouth show: setCycle: Fwd)
				(gEgo setScript: egoDrinkTea)
				(PrintDC 109 3 #at 10 120 #dispose) ; "I thought perhaps you could help His Majesty, Crispin. That's why I brought him here."
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
				(owlMouth hide:)
				(crispinTop setLoop: 5 setCycle: End self)
			)
			(15
				(crispinTop setLoop: 6 cycleSpeed: 4 setCycle: Fwd)
				(PrintDC 109 4 #at 10 10 #dispose) ; "Well, let me see now..."
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
				(PrintDC 109 5 #at 10 10 #dispose) ; "I used to be a very powerful wizard at one time, you know...but I've gotten a little rusty lately."
				(= cycles 1)
			)
			(18
				(if
					(and
						(< (gGlobalSound prevSignal:) 60)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(19
				(crispinTop setCycle: Beg self)
			)
			(20
				(cls)
				(owlHead hide:)
				(owlWing hide:)
				(owl setLoop: 6 setCycle: End self)
			)
			(21
				(owlMouth show: setCycle: Fwd)
				(gEgo setScript: egoDrinkTea)
				(PrintDC 109 6 #at 10 120 #dispose) ; "A LITTLE rusty!"
				(= seconds 3)
			)
			(22
				(owlMouth hide:)
				(owl setCycle: Beg self)
			)
			(23
				(cls)
				(owlWing show:)
				(owl setLoop: 0 cel: 0)
				(owlHead show:)
				(crispinTop hide:)
				(crispinBottom
					setLoop: 7
					cycleSpeed: 2
					setPri: (crispinTop priority:)
					setCycle: End self
				)
			)
			(24
				(if
					(and
						(< (gGlobalSound prevSignal:) 70)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(25
				(crispinMouth posn: 119 88 setLoop: 8 show: setCycle: Fwd)
				(PrintDC 109 7 #at 10 10 #dispose) ; "That's quite enough from you, Cedric!"
				(= cycles 1)
			)
			(26
				(if
					(and
						(< (gGlobalSound prevSignal:) 80)
						(!= (gGlobalSound prevSignal:) -1)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(27
				(cls)
				(owlMouth show:)
				(crispinMouth hide:)
				(PrintDC 109 8 #at 10 120 #dispose) ; "Yes, sir, Crispin...sir."
				(= seconds 3)
			)
			(28
				(cls)
				(owlMouth hide:)
				(crispinBottom setCycle: Beg self)
			)
			(29
				(if (not (== (gGlobalSound prevSignal:) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(30
				(gGlobalSound number: 81 loop: -1 play:)
				(crispinBottom setLoop: 0 cycleSpeed: 0 cel: 1)
				(crispinTop show: setCycle: Fwd)
				(PrintDC 109 9 #at 10 10 #dispose #width 270) ; "I don't know what I have that would be of much use to you. Most of my wizard stuff is pretty old and worn out. But, let's see what I can find."
				(= seconds 12)
			)
			(31
				(cls)
				(crispinBottom hide:)
				(crispinTop hide:)
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
			(32
				(crispinCup addToPic:)
				(UnLoad 128 764)
				(crispin cel: 0 setLoop: 10 setCycle: End self)
			)
			(33
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
			(34
				(crispin setMotion: MoveTo 207 126 self)
			)
			(35
				(gEgo view: 767 setLoop: 4 cel: 0)
				(crispin
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 219 118 self
				)
			)
			(36
				(crispin setLoop: 4 cel: 0 setCycle: CT 4 1 self)
			)
			(37
				(gGlobalSound3 number: 124 loop: 1 play:)
				(crispin setCycle: End self)
			)
			(38
				(crispin
					setLoop: 5
					setCycle: Fwd
					cel: 0
					setScript: searchThroughChest self
				)
			)
			(39
				(PrintDC 109 10 #at 100 10 #dispose) ; "Hmmmm. It might work."
				(= seconds 4)
			)
			(40
				(cls)
				(crispin setLoop: 6 cel: 0 setCycle: End self)
			)
			(41
				(crispin setLoop: 7 cel: 0 setCycle: End self)
			)
			(42
				(crispin
					setLoop: 2
					view: 771
					setCycle: Walk
					setMotion: MoveTo (- (crispin x:) 6) (crispin y:) self
				)
			)
			(43
				(crispin view: 765 cel: 0 setLoop: 0)
				(PrintDC 109 11 #at 100 10 #dispose) ; "Here, eat this."
				(= seconds 3)
			)
			(44
				(crispin setLoop: 2 cycleSpeed: 2 cel: 0 setCycle: End self)
			)
			(45
				(= seconds 2)
			)
			(46
				(gEgo
					view: 767
					cycleSpeed: 2
					setLoop: 4
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(47
				(cls)
				(gEgo cel: 4 setCycle: End self)
				(crispin setLoop: 3 cel: 0 setCycle: End)
			)
			(48
				(egoHead init: setCycle: Fwd)
				(PrintDC 109 12 #at 10 10 #dispose) ; "What IS that?"
				(gEgo ignoreActors: 1 setLoop: 5 setCycle: End)
				(= seconds 4)
			)
			(49
				(cls)
				(egoHead hide:)
				(crispinMouth show:)
				(crispinMouth
					view: 765
					setLoop: 10
					setPri: 15
					posn: 212 87
					setCycle: Fwd
				)
				(PrintDC 109 13 #at 10 10 #dispose #width 270) ; "That's an old piece of magical white snake I had left over from last year."
				(= seconds 7)
			)
			(50
				(cls)
				(PrintDC 109 14 #at 10 10 #dispose #width 270) ; "With it, you'll be able to communicate with the natural and animal world. You could find that quite helpful."
				(= seconds 9)
			)
			(51
				(cls)
				(crispin hide:)
				(crispinMouth hide:)
				(crispinBottom view: 765 posn: 211 114 setLoop: 4 show:)
				(gGlobalSound3 number: 125 loop: 1 play:)
				(crispinTop
					view: 765
					posn: 206 100
					setLoop: 5
					cel: 0
					setCycle: Fwd
					show:
				)
				(= seconds 2)
			)
			(52
				(crispinTop setCycle: End self)
			)
			(53
				(crispinMouth show: posn: 208 88 setCycle: Fwd)
				(PrintDC 109 15 #at 10 10 #dispose #width 270) ; "Here's my old wand. I don't even know if it works anymore. Most of its power may be gone. You should know that wands are like pets."
				(= seconds 10)
			)
			(54
				(cls)
				(PrintDC 109 16 #at 10 10 #dispose #width 270) ; "They've got to get to know you before they'll work for you. Just treat it with care and respect and hopefully it will do something for you."
				(= seconds 10)
			)
			(55
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
			(56
				(= seconds 2)
			)
			(57
				(gEgo get: 28 setLoop: 3 setCycle: CT 3 1 self) ; Wand
			)
			(58
				(gEgo setCycle: End self)
				(crispin setLoop: 7 cel: 0 setCycle: End)
			)
			(59
				(= cycles 6)
			)
			(60
				(= cycles 1)
			)
			(61
				(gEgo setLoop: 4 cel: 0)
				(= cycles 1)
			)
			(62
				(cls)
				(crispinMouth show: posn: 212 87)
				(PrintDC 109 17 #at 10 10 #dispose) ; "You'd better get going, my boy. No telling WHAT that confounded Mordack could be up to."
				(= seconds 7)
			)
			(63
				(cls)
				(PrintDC 109 18 #at 10 10 #dispose) ; "You go with him, Cedric. Show him the way."
				(= seconds 5)
			)
			(64
				(cls)
				(crispinMouth hide:)
				(owlMouth show:)
				(gEgo view: 766 setLoop: 0)
				(gEgo cel: (- (NumCels gEgo) 1))
				((gEgo head:) hide:)
				(PrintDC 109 19 #at 10 120 #dispose) ; "M-m-me?"
				(= seconds 3)
			)
			(65
				(cls)
				(gEgo view: 767 setLoop: 4 cel: 0)
				(owlMouth hide:)
				(crispinMouth show:)
				(PrintDC 109 20 #at 10 10 #dispose) ; "Yes, you! Don't be such a coward."
				(= seconds 4)
			)
			(66
				(cls)
				(crispinMouth hide:)
				(crispin setLoop: 9 cel: 0 setCycle: End self)
			)
			(67
				(crispinMouth
					show:
					setLoop: 1
					posn: 214 79
					cycleSpeed: 2
					ignoreActors: 1
					setCycle: Fwd
				)
				(PrintDC 109 21 #at 10 10 #dispose) ; "Now, go on! You'd better get started!"
				(= seconds 4)
			)
			(68
				(cls)
				(egoHead show:)
				(crispinMouth hide:)
				(PrintDC 109 22 #at 100 120 #dispose) ; "Thank you, sir. I appreciate all you've done for me."
				(= seconds 6)
			)
			(69
				(cls)
				(egoHead hide:)
				(owlHead hide:)
				(owlWing hide:)
				(owlMouth hide:)
				(owl setLoop: 7 cel: 0 setCycle: End self)
			)
			(70
				(owl setLoop: 8 cel: 0 setCycle: End self)
			)
			(71
				(owl
					setLoop: 9
					signal: 18432
					posn: 110 103
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 146 178 self
				)
			)
			(72
				(owl dispose:)
				(UnLoad 128 768)
				(crispin view: 771 setLoop: 11 setCycle: End self)
			)
			(73
				(gEgo view: 766 setLoop: 1 setCycle: End self)
			)
			(74
				(egoCup addToPic:)
				(UnLoad 128 767)
				(gEgo
					view: 0
					setLoop: 2
					normal: 1
					offset: 3
					setCycle: Walk
					cycleSpeed: 0
					moveSpeed: 1
					setStep: 3 2
					setMotion: MoveTo 145 191 self
				)
				((gEgo head:) show:)
			)
			(75
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
				(PrintDC 109 23 #at 100 10 #dispose) ; "No, that won't do."
				(= cycles 10)
			)
			(1
				(crispin setCycle: Fwd)
				(= seconds 4)
			)
			(2
				(cls)
				(crispin setCycle: 0)
				(PrintDC 109 24 #at 100 10 #dispose) ; "That's all used up."
				(= cycles 10)
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
		y 103
		x 155
		view 767
		loop 6
	)
)

(instance crispin of Act
	(properties
		y 124
		x 140
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
		y 105
		x 144
		view 764
		cel 3
		signal 16384
	)
)

(instance crispinMouth of Prop
	(properties
		y 88
		x 133
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
		y 107
		x 135
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
		y 124
		x 140
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
		y 118
		x 219
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
		y 125
		x 172
		z 36
		view 766
		loop 3
		cycleSpeed 2
	)
)

(instance owl of Act
	(properties
		y 109
		x 90
		view 768
		priority 8
		cycleSpeed 2
	)
)

(instance owlHead of Prop
	(properties
		y 102
		x 92
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
		y 94
		x 94
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
		y 100
		x 86
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

