;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use Sync)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro5 0
)

(local
	local0
	local1
	[local2 2]
	local4
)

(instance intro5 of Rm
	(properties
		picture 71
	)

	(method (init)
		(super init:)
		(= local0 1)
		(HandsOff)
		(gGame setCursor: 5 1)
		(egoHead init:)
		(gEgo
			view: 763
			loop: 1
			posn: 102 109
			normal: 0
			cycleSpeed: 2
			init:
			setPri: (+ (egoHead priority:) 1)
		)
		((gEgo head:) hide:)
		(owl view: 757 setPri: 10 ignoreActors: 1 setLoop: 1 init:)
		(intro_eyes
			setPri: (+ (owl priority:) 1)
			setLoop: 2
			posn: (+ (owl x:) 2) (- (owl y:) 34)
			setScript: blinkScript
			init:
		)
		(intro_mouth
			setPri: (+ (owl priority:) 1)
			setLoop: 3
			posn: (+ (owl x:) 3) (- (owl y:) 30)
			init:
		)
		(rWing
			view: 757
			setPri: (+ (owl priority:) 2)
			setLoop: 4
			posn: (- (owl x:) 5) (- (owl y:) 28)
			signal: 16384
			setScript: rWingScript
			init:
		)
		(lWing
			view: 757
			setPri: (+ (owl priority:) 2)
			setLoop: 5
			posn: (+ (owl x:) 7) (- (owl y:) 26)
			setScript: lWingScript
			signal: 16384
			init:
		)
		(self setRegions: 763) ; cartoonRegion
		(if (IsFlag 30)
			(self setScript: sceneEightScript)
		else
			(self setScript: sceneFiveScript)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(intro_eyes setPri: (+ (owl priority:) 1))
		(intro_mouth setPri: (+ (owl priority:) 1))
		(rWing setPri: (+ (owl priority:) 2))
		(lWing setPri: (+ (owl priority:) 2))
	)
)

(instance sceneFiveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGlobalSound number: 9 loop: -1 playBed:)
				(lWing setScript: lWingScript)
				(rWing setScript: rWingScript)
				(intro_mouth show: setCycle: MouthSync 864)
				(Say 864 self)
			)
			(2
				(intro_mouth setCycle: 0)
				(= cycles 1)
			)
			(3
				(cls)
				(intro_mouth hide:)
				(= global380 1)
				(gEgo setCycle: MouthSync 865)
				(Say 865 self)
			)
			(4
				(gEgo setCycle: 0)
				(gCurRoom newRoom: 105) ; intro6
			)
		)
	)
)

(instance sceneEightScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gGlobalSound number: 10 loop: -1 playBed:)
				(intro_mouth setCycle: MouthSync 869)
				(Say 869 self)
			)
			(2
				(cls)
				(intro_mouth setCycle: MouthSync 870)
				(Say 870 self)
			)
			(3
				(= local0 0)
				(intro_eyes hide:)
				(intro_mouth setCycle: 0 hide:)
				(rWing hide:)
				(lWing hide:)
				(owl
					view: 758
					cycleSpeed: (if (== gHowFast 2) 2 else 1)
					posn: 189 86
					setPri: 10
					setLoop: 0
					setCycle: End self
				)
			)
			(4
				(cls)
				(gGlobalSound number: 808 loop: 1 playBed:)
				(= local0 0)
				(intro_eyes hide:)
				(intro_mouth setCycle: 0 hide:)
				(rWing hide:)
				(lWing hide:)
				(Say 871 0 1)
				(owl view: 758 cel: 1 setPri: 1 setLoop: 2 setCycle: End self)
			)
			(5
				(owl
					setLoop: 3
					setStep: 10 13
					setCycle: Fwd
					setMotion: MoveTo 203 200 self
				)
			)
			(6
				(egoHead setCel: 0)
				(owl setMotion: MoveTo 203 242 self)
			)
			(7
				(arms dispose:)
				(= cycles 1)
			)
			(8
				(if (not (== (gGlobalSound prevSignal:) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(gGlobalSound number: 809 playBed:)
				(leaves
					view: 758
					init:
					posn: 197 188
					setPri: 14
					setLoop: 4
					setCycle: End self
				)
			)
			(10
				(cls)
				(leaves dispose:)
				(= seconds 2)
			)
			(11
				(gGlobalSound number: 807 playBed:)
				(owl
					view: 759
					setLoop: 0
					setPri: 0
					setCycle: Fwd
					setStep: 3 2
					cycleSpeed: 2
					setMotion: MoveTo 189 150 self
				)
			)
			(12
				(egoHead setCel: 3)
				(owl setMotion: MoveTo 189 100 self)
			)
			(13
				(egoHead setCel: 2)
				(owl setMotion: MoveTo 189 86 self)
			)
			(14
				(owl setCycle: End self)
			)
			(15
				(owl setLoop: 1 setPri: 10 setCel: 0 setCycle: End self)
			)
			(16
				(intro_eyes
					view: 757
					show:
					setLoop: 2
					setScript: blinkScript
					posn: (+ (owl x:) 2) (- (owl y:) 34)
				)
				(intro_mouth
					view: 757
					setLoop: 3
					posn: (+ (owl x:) 3) (- (owl y:) 30)
				)
				(rWing
					view: 757
					setLoop: 4
					posn: (- (owl x:) 5) (- (owl y:) 28)
					signal: 16384
				)
				(lWing
					view: 757
					setLoop: 5
					posn: (+ (owl x:) 7) (- (owl y:) 26)
					signal: 16384
				)
				(owl view: 757 setLoop: 1)
				(= cycles 1)
			)
			(17
				(= local0 1)
				(lWingScript cue:)
				(rWingScript cue:)
				(intro_mouth show: setCycle: MouthSync 872)
				(Say 872 self)
			)
			(18
				(cls)
				(intro_mouth show: setCycle: MouthSync 873)
				(Say 873 self)
			)
			(19
				(intro_mouth setCycle: 0)
				(= cycles 1)
			)
			(20
				(cls)
				(gEgo setCycle: MouthSync 874)
				(Say 874 self)
			)
			(21
				(gEgo setCycle: 0)
				(= cycles 1)
			)
			(22
				(cls)
				(lWingScript cue:)
				(rWingScript cue:)
				(intro_mouth setCycle: MouthSync 875)
				(Say 875 self)
			)
			(23
				(Say 876 0 1)
				(= seconds 1)
			)
			(24
				(intro_eyes hide:)
				(= local0 0)
				(intro_mouth hide:)
				(rWing hide:)
				(lWing hide:)
				(owl view: 759 setLoop: 2 setCycle: End self)
			)
			(25
				(owl setLoop: 3 setCycle: End self)
			)
			(26
				(intro_mouth show: setCycle: Fwd)
				(= seconds 5)
			)
			(27
				(intro_mouth setCycle: 0)
				(= cycles 1)
			)
			(28
				(cls)
				(gEgo setCycle: MouthSync 877)
				(Say 877 self)
			)
			(29
				(gEgo setCycle: 0)
				(= cycles 1)
			)
			(30
				(owl view: 757 setLoop: 8)
				(rWing show:)
				(intro_eyes show: setScript: blinkScript)
				(= local0 1)
				(rWingScript cue:)
				(cls)
				(intro_mouth show: setCycle: MouthSync 878)
				(Say 878 self)
			)
			(31
				(cls)
				(intro_mouth show: setCycle: MouthSync 879)
				(Say 879 self)
			)
			(32
				(intro_mouth setCycle: 0)
				(= cycles 1)
			)
			(33
				(intro_eyes dispose:)
				(= local0 0)
				(rWing dispose:)
				(intro_mouth hide:)
				(cls)
				(owl view: 759 setLoop: 4 setCycle: End self)
			)
			(34
				(owl setLoop: 5 setCycle: Fwd setMotion: MoveTo 110 58 self)
			)
			(35
				(owl setCycle: End self)
			)
			(36
				(egoHead setCel: 4)
				(owl setLoop: 6 setCycle: Fwd setScript: dustingEgo self)
			)
			(37
				(owl setLoop: 6 setCycle: End self)
			)
			(38
				(sack
					init:
					illegalBits: 0
					signal: 16384
					setStep: 5 5
					setPri: (- (egoHead priority:) 1)
					posn: 91 37
					setLoop: 9
					setMotion: MoveTo 59 201
				)
				(owl setLoop: 10 setCycle: End self)
			)
			(39
				(owl setLoop: 10 cel: 0 setCycle: Fwd)
				(intro_mouth
					view: 759
					posn: (- (owl x:) 15) (- (owl y:) 24)
					setLoop: 11
					cel: 0
					setPri: (+ (owl priority:) 1)
					cycleSpeed: 2
					setCycle: Fwd
				)
				(sack setPri: (- (egoHead priority:) 1))
				(= seconds 2)
			)
			(40
				(gEgo setCycle: MouthSync 880)
				(Say 880 self)
			)
			(41
				(gEgo setCycle: 0)
				(= cycles 1)
			)
			(42
				(cls)
				(intro_mouth show:)
				(= cycles 3)
			)
			(43
				(intro_mouth setCycle: Fwd)
				(Say 881 self)
			)
			(44
				(cls)
				(Say 882 0 1)
				(= seconds (LangSwitch 13 20))
			)
			(45
				(egoHead setCel: 1)
				(intro_mouth dispose:)
				(owl setScript: leaveRoomScript)
				(= cycles 1)
			)
			(46
				(SetFlag 31)
				(gCurRoom newRoom: 100) ; intro
			)
		)
	)
)

(instance lWingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(lWing cycleSpeed: 2 setLoop: 5 setCycle: End)
				(= seconds 4)
			)
			(2
				(lWing setLoop: 6 setCycle: End)
				(= seconds 3)
			)
			(3)
			(4
				(lWing setLoop: 5 setCycle: End)
				(= seconds 2)
			)
			(5
				(lWing setLoop: 6 setCycle: End)
				(= seconds 3)
			)
			(6)
			(7
				(lWing setLoop: 5 setCycle: End)
				(= seconds 2)
			)
			(8
				(lWing setLoop: 6 setCycle: End)
				(= seconds 4)
			)
			(9
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance rWingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(rWing cycleSpeed: 2 setCycle: End)
				(= seconds 2)
			)
			(2
				(rWing setCycle: Beg)
				(= seconds 3)
			)
			(3
				(= local0 0)
				(rWing setLoop: 7 setCycle: End)
				(= seconds 2)
			)
			(4
				(= local0 1)
				(rWing setLoop: 4 setCel: 0)
				(= cycles 1)
			)
			(5)
			(6
				(rWing setCycle: End)
				(= seconds 2)
			)
			(7
				(rWing setCycle: Beg)
				(= seconds 3)
			)
			(8)
			(9
				(rWing setCycle: End)
				(= seconds 4)
			)
			(10
				(rWing setCycle: Beg)
				(= seconds 2)
			)
			(11)
			(12
				(= local0 0)
				(rWing setLoop: 7 setCycle: End self)
			)
			(13
				(= local0 1)
				(rWing setLoop: 4 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(14
				(rWing setCycle: Beg)
				(= seconds 4)
			)
			(15
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance blinkScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== local0 0)
			(if (> (intro_eyes cel:) 0)
				(intro_eyes setCycle: Beg self)
			else
				(= cycles 1)
			)
			(= state 2)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(intro_eyes setCycle: End self)
			)
			(2
				(intro_eyes setCycle: Beg self)
				(= state -1)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance dustingEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (client cel:) 0)
					(if local4
						(= local4 0)
					else
						(++ local4)
					)
					(dust
						init:
						setPri:
							(if local4
								(- (egoHead priority:) 1)
							else
								(+ (egoHead priority:) 1)
							)
						setLoop: 7
						posn: 81 75
						setCycle: End self
					)
				else
					(= state -1)
					(= cycles 1)
				)
			)
			(1
				(if (not (== (gGlobalSound3 number:) 811))
					(gGlobalSound3 number: 811 play:)
				)
				(dust hide: dispose:)
				(if (== local1 3)
					(gGlobalSound3 stop:)
					(self dispose:)
				else
					(++ local1)
					(= state -1)
					(= cycles 1)
				)
			)
		)
	)
)

(instance owl of Actor
	(properties
		x 189
		y 86
		view 757
	)
)

(instance leaves of Prop
	(properties
		x 203
		y 188
		view 757
	)
)

(instance intro_eyes of Prop
	(properties
		view 757
	)
)

(instance intro_mouth of Prop
	(properties
		view 757
	)
)

(instance rWing of Prop
	(properties
		view 757
	)
)

(instance lWing of Prop
	(properties
		view 757
	)
)

(instance arms of Actor
	(properties
		view 757
	)
)

(instance dust of Actor
	(properties
		view 759
	)
)

(instance sack of Actor
	(properties
		view 759
	)
)

(instance egoHead of Prop
	(properties
		x 81
		y 118
		view 763
		cel 2
		priority 10
		signal 24592
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (setCel)
		(super setCel: &rest)
		(self stopUpd:)
		(switch (self cel:)
			(0
				(gEgo hide:)
				(self posn: 101 105)
			)
			(1
				(gEgo hide:)
				(self posn: 103 108)
			)
			(2
				(gEgo show:)
				(self posn: 81 118)
			)
			(3
				(gEgo hide:)
				(self posn: 99 112)
			)
			(4
				(gEgo hide:)
				(self posn: 97 109)
			)
		)
	)
)

(instance sparkles of Prop ; UNUSED
	(properties
		x 81
		y 95
		view 759
		loop 12
		priority 15
	)
)

(instance leaveRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owl setMotion: MoveTo 22 -20 self)
			)
			(1
				(owl hide:)
				(client setScript: 0)
			)
		)
	)
)

