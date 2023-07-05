;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 664)
(include sci.sh)
(use Main)
(use AudioScript)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	cdIntro5B 0
)

(local
	local0
	local1
	[local2 2]
	local4
	local5
)

(instance cdIntro5B of Rm
	(properties
		picture 71
	)

	(method (init)
		(Load rsPIC 71)
		(super init:)
		(UnLoad 129 70)
		(Load rsSCRIPT 929)
		(LoadMany rsVIEW 757 758 759 785 763)
		(LoadMany rsSYNC 869 870 872 873 874 875 876 877 878 879 880 881 882)
		(= local0 1)
		(HandsOff)
		(gGame setCursor: gNarrator 1)
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
		(self setRegions: 769) ; introtoonRegion
		(self setScript: sceneEightScript)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(intro_eyes setPri: (+ (owl priority:) 1))
		(rWing setPri: (+ (owl priority:) 2))
		(lWing setPri: (+ (owl priority:) 2))
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(SetFlag 31)
	)
)

(instance sceneEightScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMouth init: changeMouth: 1 play: 10108 650)
				(= waitForCue 8448)
			)
			(1
				(= waitForCue 8960)
			)
			(2
				(= local0 0)
				(intro_eyes hide:)
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
			(3
				(= waitForCue 9216)
			)
			(4
				(= local0 0)
				(theMouth hide:)
				(rWing hide:)
				(lWing hide:)
				(owl view: 758 cel: 1 setPri: 1 setLoop: 2 setCycle: End self)
			)
			(5
				(if (< (gTheSync prevCue:) 9296)
					(owl cel: 7 setCycle: CT 10 1 self)
					(-- state)
				else
					(owl cel: 7 setCycle: End self)
				)
			)
			(6
				(owl
					setLoop: 3
					setStep: 10 13
					setCycle: Fwd
					setMotion: MoveTo 203 200 self
				)
			)
			(7
				(egoHead setCel: 0)
				(owl setMotion: MoveTo 203 242 self)
			)
			(8
				(arms dispose:)
				(= cycles 1)
			)
			(9
				(= waitForCue 9472)
			)
			(10
				(leaves
					view: 758
					init:
					posn: 197 188
					setPri: 14
					setLoop: 4
					setCycle: End self
				)
			)
			(11
				(cls)
				(leaves dispose:)
				(= waitForCue 9552)
			)
			(12
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
			(13
				(egoHead setCel: 3)
				(owl setMotion: MoveTo 189 100 self)
			)
			(14
				(egoHead setCel: 2)
				(owl setMotion: MoveTo 189 86 self)
			)
			(15
				(owl setCycle: End self)
			)
			(16
				(owl setLoop: 1 setPri: 10 setCel: 0 setCycle: End self)
			)
			(17
				(intro_eyes
					view: 757
					show:
					setLoop: 2
					setScript: blinkScript
					posn: (+ (owl x:) 2) (- (owl y:) 34)
				)
				(rWing
					view: 757
					setLoop: 4
					setCel: 0
					posn: (- (owl x:) 5) (- (owl y:) 28)
					signal: 16384
				)
				(lWing
					view: 757
					setLoop: 5
					setCel: 0
					posn: (+ (owl x:) 7) (- (owl y:) 26)
					signal: 16384
				)
				(owl view: 757 setLoop: 1)
				(= waitForCue 9728)
			)
			(18
				(= local0 1)
				(lWingScript cue:)
				(rWingScript cue:)
				(theMouth show:)
				(= waitForCue 9984)
			)
			(19
				(= waitForCue 10240)
			)
			(20
				(theMouth changeMouth: 0)
				(gEgo hide:)
				(= waitForCue 10496)
			)
			(21
				(cls)
				(lWingScript cue:)
				(rWingScript cue:)
				(theMouth changeMouth: 1)
				(gEgo show:)
				0
				(= waitForCue 10576)
			)
			(22
				(theMouth hide:)
				(intro_eyes hide:)
				(= local0 0)
				(rWing hide:)
				(lWing hide:)
				(owl
					view: 759
					setLoop: 2
					cycleSpeed:
						(+
							(= local5 (owl cycleSpeed:))
							(if (== gHowFast 2) 2 else 0)
						)
					setCycle: Fwd
				)
				(= waitForCue 10608)
			)
			(23
				(owl setLoop: 3 cel: 0 setCycle: End self cycleSpeed: local5)
			)
			(24
				(theMouth show:)
				(= cycles 1)
			)
			(25
				(= waitForCue 12288)
			)
			(26
				(theMouth changeMouth: 0)
				(gEgo hide:)
				(= waitForCue 12544)
			)
			(27
				(owl view: 757 setLoop: 8)
				(rWing show:)
				(intro_eyes show: setScript: blinkScript)
				(= local0 1)
				(rWingScript cue:)
				(gEgo show:)
				(theMouth changeMouth: 1)
				(= waitForCue 12800)
			)
			(28
				(= waitForCue 13056)
			)
			(29
				(intro_eyes dispose:)
				(= local0 0)
				(rWing dispose:)
				(theMouth hide:)
				(cls)
				(owl view: 785 setLoop: 4 setCycle: End self)
			)
			(30
				(owl
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 110 58 self
					moveSpeed: (if (== gHowFast 2) 2 else 0)
				)
			)
			(31
				(egoHead setCel: 4)
				(= waitForCue 13136)
			)
			(32
				(owl setCycle: End self)
			)
			(33
				(owl setLoop: 6 setCycle: Fwd setScript: dustingEgo self)
			)
			(34
				(owl setLoop: 6 setCycle: End self)
			)
			(35
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
			(36
				(owl setLoop: 10 cel: 0 setCycle: Fwd)
				(sack setPri: (- (egoHead priority:) 1))
				(= waitForCue 13316)
			)
			(37
				(gEgo setCycle: Fwd)
				(= waitForCue 13568)
			)
			(38
				(theMouth
					changeMouth: 1
					posn: (- (owl x:) 15) (- (owl y:) 24)
					show:
				)
				(= waitForCue 13824)
			)
			(39
				(= waitForCue 13904)
			)
			(40
				(egoHead setCel: 1)
				(theMouth hide:)
				(owl setScript: leaveRoomScript)
				(= cycles 1)
			)
			(41
				(if (> (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(42
				(gCurRoom newRoom: 650) ; cdIntro
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
				(dust hide: dispose:)
				(if (== local1 3)
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

(instance theMouth of MonoAudioProp
	(properties
		view 757
	)

	(method (changeMouth param1)
		(switch param1
			(0
				(theMouth
					view: 763
					loop: 1
					posn: 102 109
					cycleSpeed: 2
					setPri: (+ (egoHead priority:) 1)
				)
			)
			(1
				(theMouth
					view: 757
					setLoop: 3
					posn: (+ (owl x:) 3) (- (owl y:) 30)
					setPri: (+ (owl priority:) 1)
				)
			)
		)
	)

	(method (doit)
		(if (== (owl loop:) 10)
			(theMouth
				y:
					(-
						(owl y:)
						(switch (owl cel:)
							(0 23)
							(1 25)
							(2 24)
						)
					)
			)
		)
		(super doit: &rest)
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
		view 785
	)
)

(instance sack of Actor
	(properties
		view 785
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

(instance leaveRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(owl
					setMotion: MoveTo 22 -22 self
					moveSpeed: (if (== gHowFast 2) 2 else 0)
				)
			)
			(1
				(owl hide:)
				(client setScript: 0)
			)
		)
	)
)

