;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 659)
(include sci.sh)
(use Main)
(use AudioScript)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	cdIntro10 0
)

(local
	[local0 3]
	local3
	local4
	local5
	local6
)

(instance cdIntro10 of Rm
	(properties
		picture 76
		style 10
	)

	(method (init)
		(Load rsPIC 76)
		(HandsOff)
		(gGame setCursor: gNarrator 1)
		(super init:)
		(UnLoad 129 1)
		(LoadMany rsVIEW 764 766 0 768 777 783 1101)
		(owl
			init:
			cycleSpeed:
				(switch gHowFast
					(2 2)
					(else 0)
				)
		)
		(owlHead init:)
		(owlMouth init: hide:)
		(owlWing
			init:
			cycleSpeed:
				(switch gHowFast
					(2 2)
					(else 0)
				)
		)
		(crispin init:)
		(trunk init:)
		(crispinCup init:)
		(gEgo view: 766 setLoop: 0 normal: 0 posn: 173 125 init:)
		(gEgo cel: (- (NumCels gEgo) 1))
		((gEgo head:) hide:)
		(egoCup init:)
		(self setScript: a2s5Script setRegions: 769) ; introtoonRegion
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gEgo setPri: -1 setStep: 3 2 cycleSpeed: 0)
	)
)

(instance a2s5Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSCRIPT 929)
				(LoadMany rsVIEW 765 1103 771 775 767 769 1100 1102 779)
				(Load rsSYNC 10113)
				(= cycles 1)
			)
			(1
				(theMouth init: changeMouth: 0 play: 10113 1)
				(= waitForCue 4096)
			)
			(2
				(owlHead setCycle: End)
				(gEgo setScript: egoDrinkTea)
				(owl setScript: owlDrinkingTea)
				(= waitForCue 4352)
			)
			(3
				(= waitForCue 4608)
			)
			(4
				(theMouth hide:)
				(= cycles 1)
			)
			(5
				(if (== gHowFast 2)
					(gEgo view: 767 setLoop: 2 setCycle: End self)
				else
					(gEgo view: 767 setLoop: 2)
					(gEgo setCel: (- (NumCels gEgo) 1))
					(= cycles 1)
				)
			)
			(6
				(owl setScript: owlDrinkingTea)
				(theMouth changeMouth: 4 show:)
				(gEgo hide:)
				(= waitForCue 5378)
			)
			(7
				(if (== gHowFast 2)
					(gEgo setLoop: 2 setCycle: Beg self show:)
					(gEgo cel: (- (NumCels gEgo) 1))
				else
					(gEgo setLoop: 2 cel: 0 show:)
					(= cycles 1)
				)
				(theMouth hide:)
			)
			(8
				(gEgo setScript: egoDrinkTea)
				(owl setScript: owlDrinkingTea)
				(crispin hide:)
				(crispinTop init: setCycle: End)
				(crispinBottom init:)
				(= waitForCue 5632)
			)
			(9
				(crispinTop setCycle: 0)
				(= cycles 1)
			)
			(10
				(crispinTop setCel: 255)
				(theMouth changeMouth: 0 show: posn: 135 87 setPri: 15)
				(= waitForCue 5888)
			)
			(11
				(theMouth hide:)
				(crispinTop
					cycleSpeed:
						(switch gHowFast
							(2 1)
							(else 0)
						)
					setCycle: Beg
				)
				(= waitForCue 6144)
			)
			(12
				(gEgo setScript: egoDrinkTea)
				(theMouth changeMouth: 6 show:)
				(= waitForCue 6400)
			)
			(13
				(owlMouth setCycle: 0 setCel: 0 show:)
				(theMouth hide:)
				(if (== gHowFast 2)
					(crispinTop setLoop: 5 setCycle: End)
					(= waitForCue 8192)
				else
					(crispinTop setLoop: 5)
					(crispinTop cel: (- (NumCels crispinTop) 1))
					(= cycles 1)
				)
			)
			(14
				(crispinTop
					setCycle: 0
					setLoop: 6
					cycleSpeed:
						(switch gHowFast
							(2 2)
							(else 0)
						)
				)
				(theMouth changeMouth: 1 show:)
				(crispinTop hide:)
				(= waitForCue 8448)
			)
			(15
				(= waitForCue 8960)
			)
			(16
				(owlHead hide:)
				(owlWing hide:)
				(owlMouth hide:)
				(owl
					setLoop: 6
					cycleSpeed:
						(switch gHowFast
							(2 2)
							(else 1)
						)
					setCycle: End
				)
				(crispinTop setCel: 0 show:)
				(theMouth setCel: 255)
				(= waitForCue 9216)
			)
			(17
				(owl setCycle: 0)
				(= cycles 1)
			)
			(18
				(owl setCel: 255)
				(theMouth changeMouth: 6 posn: 96 94 show:)
				(= waitForCue 9472)
				0
				(gEgo setScript: egoDrinkTea)
			)
			(19
				(theMouth hide:)
				(owl
					cycleSpeed:
						(switch gHowFast
							(2 2)
							(else 1)
						)
					setCycle: Beg self
				)
				(crispinTop hide:)
				(if (== gHowFast 2)
					(crispinBottom
						setLoop: 7
						cycleSpeed:
							(switch gHowFast
								(2 2)
								(else 0)
							)
						setPri: (crispinTop priority:)
						setCycle: End
					)
				else
					(crispinBottom
						setLoop: 7
						setPri: (crispinTop priority:)
						setCycle: 0
					)
					(crispinBottom cel: (- (NumCels crispinBottom) 1))
				)
			)
			(20
				(owlWing show:)
				(owl setLoop: 0 cel: 0)
				(owlHead show:)
				(owlMouth setCel: 0 show:)
				(= cycles 1)
			)
			(21
				(if (!= (crispinBottom cel:) (- (NumCels crispinBottom) 1))
					(-- state)
				)
				(= cycles 1)
			)
			(22
				(theMouth changeMouth: 2 show:)
				(= cycles 1)
			)
			(23
				(= waitForCue 9988)
			)
			(24
				(theMouth changeMouth: 6)
				(= waitForCue 10240)
			)
			(25
				(owlMouth setCycle: 0 setCel: 0)
				(theMouth hide:)
				(= local6 0)
				(crispinBottom setCycle: Beg self)
			)
			(26
				(crispinBottom setLoop: 0 cycleSpeed: 0 cel: 1)
				(theMouth changeMouth: 1 show:)
				(= waitForCue 12288)
			)
			(27
				(crispinBottom hide: dispose:)
				(theMouth hide:)
				(= local4 1)
				(crispin
					view: 771
					show:
					setPri: 14
					setLoop: 0
					cycleSpeed:
						(switch gHowFast
							(2 2)
							(else 0)
						)
					cel: 0
					setCycle: End self
				)
			)
			(28
				(crispinCup addToPic:)
				(crispin cel: 0 setLoop: 10 setCycle: End self)
			)
			(29
				(crispin
					view: 1102
					setLoop: 1
					cycleSpeed: (if (== gHowFast 2) 6 else 1)
					cel: 0
					setCycle: Fwd
					signal: (| (crispin signal:) $4800)
					setMotion: MoveTo 145 126 self
					moveSpeed: (if (== gHowFast 2) 14 else 3)
				)
			)
			(30
				(crispin setMotion: MoveTo 207 126 self)
			)
			(31
				(gEgo view: 1100 setLoop: 4 cel: 0)
				(crispin
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 219 118 self
				)
			)
			(32
				(crispin
					setCycle: 0
					moveSpeed: (if (== gHowFast 2) 2 else 0)
					cycleSpeed:
						(switch gHowFast
							(2 1)
							(else 0)
						)
				)
				(= waitForCue 12368)
			)
			(33
				(crispin view: 775 setLoop: 4 cel: 0 setCycle: CT 4 1 self)
			)
			(34
				(= waitForCue 12544)
			)
			(35
				(crispin setCycle: End self)
			)
			(36
				(crispin
					setLoop: 5
					setCycle: Fwd
					cel: 0
					setScript: searchThroughChest self
				)
			)
			(37
				(= waitForCue 13824)
			)
			(38
				(crispin setCycle: 0)
				(= waitForCue 14080)
			)
			(39
				(if (== gHowFast 2)
					(crispin setLoop: 6 cel: 0 setCycle: End self)
				else
					(crispin setLoop: 6)
					(crispin cel: (- (NumCels crispin) 1))
					(= cycles 1)
				)
			)
			(40
				(if (== gHowFast 2)
					(crispin setLoop: 7 cel: 0 setCycle: End self)
				else
					(crispin setLoop: 7)
					(crispin cel: (- (NumCels crispin) 1))
					(= cycles 1)
				)
			)
			(41
				(crispin
					view: 1102
					setLoop: 2
					setCycle: Walk
					setMotion: MoveTo (- (crispin x:) 6) (crispin y:) self
				)
			)
			(42
				(crispin view: 765 setLoop: 3)
				(crispin cel: (- (NumCels crispin) 1))
				(theMouth changeMouth: 3 show:)
				(= waitForCue 14592)
				1
			)
			(43
				(theMouth hide:)
				(if (== gHowFast 2)
					(crispin
						view: 765
						setLoop: 2
						cycleSpeed:
							(switch gHowFast
								(2 2)
								(else 0)
							)
						cel: 0
						setCycle: End self
					)
				else
					(crispin
						view: 765
						setLoop: 2
						cycleSpeed:
							(switch gHowFast
								(2 2)
								(else 0)
							)
					)
					(crispin cel: (- (NumCels crispin) 1))
					(= cycles 1)
				)
			)
			(44
				(if (== gHowFast 2)
					(= seconds 1)
				else
					(= cycles 1)
				)
			)
			(45
				(gEgo
					view: 1100
					cycleSpeed:
						(switch gHowFast
							(2 2)
							(else 0)
						)
					setLoop: 4
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(46
				(if (== gHowFast 2)
					(gEgo cel: 4 setCycle: End self)
					(crispin setLoop: 3 cel: 0 setCycle: End)
				else
					(gEgo cel: (- (NumCels gEgo) 1))
					(crispin setLoop: 3)
					(crispin cel: (- (NumCels crispin) 1))
					(= cycles 1)
				)
			)
			(47
				(= waitForCue 16384)
			)
			(48
				(theMouth changeMouth: 5 show:)
				(gEgo ignoreActors: 1 setLoop: 5 setCycle: End)
				(= waitForCue 16640)
			)
			(49
				(theMouth changeMouth: 3 show:)
				(= waitForCue 16896)
			)
			(50
				2
				(= waitForCue 17152)
			)
			(51
				(= waitForCue 17232)
			)
			(52
				(crispin hide:)
				(theMouth hide:)
				(crispinBottom view: 765 posn: 211 114 setLoop: 4 init: show:)
				(crispinTop
					view: 765
					posn: 206 100
					setLoop: 5
					cel: 0
					setCycle: Fwd
					init:
					show:
				)
				(if (!= gHowFast 2)
					(= waitForCue 17408)
				else
					(= seconds 1)
				)
			)
			(53
				(if (== gHowFast 2)
					(crispinTop setCycle: End self)
				else
					(crispinTop setCycle: 0)
					(crispinTop cel: (- (NumCels crispinTop) 1))
					(= cycles 1)
				)
			)
			(54
				(if (== gHowFast 2)
					(= waitForCue 17408)
				else
					(= cycles 1)
				)
			)
			(55
				(theMouth posn: 208 88 setPri: 15 show:)
				(= waitForCue 17920)
			)
			(56
				(theMouth hide:)
				(crispinTop dispose:)
				(crispinBottom dispose:)
				(if (== gHowFast 2)
					(crispin
						show:
						view: 1103
						setLoop: 0
						cycleSpeed:
							(switch gHowFast
								(2 2)
								(else 0)
							)
						cel: 0
						setCycle: End self
					)
				else
					(crispin
						show:
						view: 1103
						setLoop: 0
						cycleSpeed:
							(switch gHowFast
								(2 2)
								(else 0)
							)
					)
					(crispin cel: (- (NumCels crispin) 1))
					(= cycles 1)
				)
			)
			(57
				(gEgo view: 769 get: 28 setLoop: 3 setCycle: CT 3 1 self) ; Wand
			)
			(58
				(gEgo setCycle: End self)
				(if (== gHowFast 2)
					(crispin view: 1103 setLoop: 1 cel: 0 setCycle: End)
				else
					(crispin view: 1103 setLoop: 1)
					(crispin cel: (- (NumCels crispin) 1))
				)
			)
			(59
				(if (!= (crispin cel:) (crispin lastCel:))
					(-- state)
				)
				(= cycles 1)
			)
			(60
				(gEgo cel: 0)
				(theMouth posn: 212 87 setPri: 15 show:)
				(= waitForCue 18432)
			)
			(61
				(= waitForCue 18688)
			)
			(62
				(gEgo view: 766 setLoop: 0)
				(gEgo cel: (- (NumCels gEgo) 1))
				((gEgo head:) hide:)
				(theMouth changeMouth: 6)
				(= waitForCue 20481)
			)
			(63
				(gEgo view: 1100 setLoop: 4 cel: 0)
				(owlMouth setCycle: 0 setCel: 0 show:)
				(theMouth changeMouth: 3 posn: 212 87)
				(= waitForCue 20736)
			)
			(64
				(theMouth changeMouth: 5 show:)
				(= waitForCue 20992)
			)
			(65
				(theMouth hide:)
				(owlHead hide:)
				(owlWing hide:)
				(owlMouth hide:)
				(owl setLoop: 7 cel: 0 setCycle: End self)
			)
			(66
				(owl setLoop: 8 cel: 0 setCycle: End self)
			)
			(67
				(crispin view: 771 setLoop: 11 setCycle: End)
				(owl
					setLoop: 9
					signal: 18432
					posn: 110 103
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo 146 178 self
				)
			)
			(68
				(owl dispose:)
				(= cycles 1)
			)
			(69
				(gEgo view: 766 setLoop: 1 setCycle: End self)
			)
			(70
				(egoCup addToPic:)
				(gEgo
					view: 0
					setLoop: 2
					normal: 1
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					moveSpeed: 1
					setStep: 3 2
					setMotion: MoveTo 145 191 self
				)
				((gEgo head:) show:)
			)
			(71
				(if (> (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(72
				(if global327
					(= gQuit 1)
				else
					(gCurRoom newRoom: 1)
				)
			)
		)
	)
)

(instance searchThroughChest of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= waitForCue 12800)
			)
			(1
				(crispin setCycle: 0)
				(= waitForCue 13056)
			)
			(2
				(crispin setCycle: Fwd)
				(= waitForCue 13312)
			)
			(3
				(crispin setCycle: 0)
				(= waitForCue 13568)
			)
			(4
				(crispin setCycle: Fwd)
				(= cycles 1)
			)
			(5
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
					view: 779
					setLoop: 0
					cycleSpeed:
						(switch gHowFast
							(2 2)
							(else 0)
						)
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
		view 777
		cel 1
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
			(self
				priority: (+ (trunk priority:) 1)
				signal: (| (self signal:) $0010)
			)
		)
	)
)

(instance crispinCup of Prop
	(properties
		x 144
		y 105
		view 777
		signal 16384
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
		(self
			priority: (+ (crispinBottom priority:) 1)
			signal: (| (self signal:) $0010)
		)
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
			(self
				priority: (+ (trunk priority:) 1)
				signal: (| (self signal:) $0010)
			)
		)
	)
)

(instance trunk of Prop
	(properties
		x 219
		y 118
		view 1101
	)

	(method (doit)
		(super doit:)
		(self
			setCel:
				(cond
					(local3 7)
					((== (crispin loop:) 4)
						(switch (crispin cel:)
							(5 0)
							(6 1)
							(7 2)
							(8 4)
							(9 5)
							(10
								6
								(= local3 1)
								(self addToPic:)
							)
						)
					)
				)
		)
	)
)

(instance owl of Actor
	(properties
		x 90
		y 109
		view 768
		priority 8
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
	)

	(method (init)
		(super init:)
		(self setPri: 8)
	)

	(method (doit)
		(super doit:)
		(if (== (owl loop:) 6)
			(self x: 96 y: 94)
		else
			(self x: 94 y: 94)
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
	)

	(method (init)
		(super init:)
		(self setPri: 8)
	)

	(method (doit)
		(super doit:)
		(if (and (not script) (not (& (owlWing signal:) $0008)) local6)
			(switch (Random 1 10)
				(1
					(self setScript: (bodyScript new:))
				)
			)
		)
	)
)

(instance theMouth of MonoAudioProp
	(properties
		x 133
		y 88
		view 783
		loop 1
	)

	(method (changeMouth param1)
		(self z: 0)
		(= local6 0)
		(switch param1
			(0
				(theMouth view: 783 loop: 1 x: 133 y: 88 setPri: 15)
			)
			(1
				(theMouth view: 764 loop: 6 x: 135 y: 107)
			)
			(2
				(theMouth view: 783 setLoop: 8 posn: 119 88 setPri: 15)
			)
			(3
				(theMouth view: 765 setLoop: 10 setPri: 15 posn: 212 87)
			)
			(4
				(theMouth view: 767 setLoop: 7 posn: (gEgo x:) (gEgo y:))
			)
			(5
				(theMouth view: 766 loop: 3 x: 172 y: 125 z: 36)
			)
			(6
				(theMouth
					view: 768
					loop: 3
					posn: (owlMouth x:) (owlMouth y:)
					setPri: 8
				)
				(= local6 1)
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

