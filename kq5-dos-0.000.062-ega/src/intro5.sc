;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use Interface)
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
		(eyes
			setPri: (+ (owl priority:) 1)
			setLoop: 2
			posn: (+ (owl x:) 2) (- (owl y:) 34)
			setScript: blinkScript
			init:
		)
		(mouth
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
		(if (IsFlag 31)
			(self setScript: sceneEightScript)
		else
			(self setScript: sceneFiveScript)
		)
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
		(eyes setPri: (+ (owl priority:) 1))
		(mouth setPri: (+ (owl priority:) 1))
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
				(mouth show: cycleSpeed: 2 setCycle: Fwd)
				(lWing setScript: lWingScript)
				(rWing setScript: rWingScript)
				(PrintDC 104 0 #at 140 100 #width 150 #dispose) ; "It was the powerful and evil wizard Mordack who did it. I just happened to be visiting with an old friend when I saw him materialize out of thin air. Thank goodness he didn't notice ME!"
				(= seconds 11)
			)
			(2
				(mouth setCycle: End self)
			)
			(3
				(cls)
				(mouth hide:)
				(gEgo setCycle: Fwd)
				(PrintDC 104 1 67 10 30 351 103) ; "Don't stop now! Go on!"
				(= seconds 4)
			)
			(4
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
				(mouth cycleSpeed: 2 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(gGlobalSound number: 10 loop: -1 playBed:)
				(PrintDC 104 2 #at 140 100 #dispose #width 150) ; "Perhaps I can help you. My employer also happens to be a wizard, which is why I recognized Mordack. Unlike Mordack, though, my employer is a very good wizard."
				(= seconds 10)
			)
			(3
				(cls)
				(PrintDC 104 3 #at 140 100 #dispose #width 150) ; "His name is Crispinophur...but we all call him Crispin for short. The only problem is, you see...,"
				(= seconds 2)
			)
			(4
				(= local0 0)
				(eyes hide:)
				(mouth setCycle: 0 hide:)
				(rWing hide:)
				(lWing hide:)
				(owl
					view: 758
					cycleSpeed: (if (== global286 2) 2 else 1)
					posn: 189 86
					setPri: 10
					setLoop: 0
					setCycle: End self
				)
			)
			(5
				(cls)
				(gGlobalSound number: 808 loop: 1 playBed:)
				(= local0 0)
				(eyes hide:)
				(mouth setCycle: 0 hide:)
				(rWing hide:)
				(lWing hide:)
				(PrintDC 104 4 #at 140 10 #dispose) ; "Wh-Whoa...!"
				(owl view: 758 cel: 1 setPri: 1 setLoop: 2 setCycle: End self)
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
				(if (not (== (gGlobalSound prevSignal:) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(10
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
			(11
				(cls)
				(leaves dispose:)
				(= seconds 2)
			)
			(12
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
				(eyes
					view: 757
					show:
					setLoop: 2
					setScript: blinkScript
					posn: (+ (owl x:) 2) (- (owl y:) 34)
				)
				(mouth
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
			(18
				(= local0 1)
				(mouth show: setCycle: Fwd cycleSpeed: 2)
				(lWingScript cue:)
				(rWingScript cue:)
				(PrintDC 104 5 #at 140 100 #dispose #width 150) ; "Ahem! Anyway...where was I? Oh yes."
				(= seconds 4)
			)
			(19
				(cls)
				(PrintDC 104 6 #at 140 100 #dispose #width 150) ; "The only problem is that Crispin is getting on in years and tends to be a bit forgetful."
				(= seconds 6)
			)
			(20
				(mouth setCycle: End self)
			)
			(21
				(cls)
				(gEgo setCycle: Fwd)
				(PrintDC 104 7 #at 10 10 #dispose) ; "I don't know. This doesn't sound as if it would work."
				(= seconds 6)
			)
			(22
				(gEgo setCycle: End self)
			)
			(23
				(cls)
				(mouth setCycle: Fwd cycleSpeed: 2)
				(lWingScript cue:)
				(rWingScript cue:)
				(PrintDC 104 8 #at 140 100 #dispose #width 150) ; "Oh, sure it would! Crispin is a very qualified wizard...one of the best. He just gets a little forgetful now and again, that's all."
				(= seconds 10)
			)
			(24
				(mouth setCycle: End self)
			)
			(25
				(PrintDC 104 9 #at 140 100 #dispose #width 150) ; "Now where is it? I know I brought it with me. Aha! Here it is!"
				(eyes hide:)
				(= local0 0)
				(mouth hide:)
				(rWing hide:)
				(lWing hide:)
				(owl view: 759 setLoop: 2 setCycle: End self)
			)
			(26
				(owl setLoop: 3 setCycle: End self)
			)
			(27
				(mouth show: setCycle: Fwd)
				(= seconds 5)
			)
			(28
				(mouth setCycle: End self)
			)
			(29
				(cls)
				(gEgo setCycle: Fwd)
				(PrintDC 104 10 #at 10 10 #dispose) ; "What is that?"
				(= seconds 3)
			)
			(30
				(gEgo setCycle: End self)
			)
			(31
				(owl view: 757 setLoop: 8)
				(rWing show:)
				(mouth show: setCycle: Fwd cycleSpeed: 2)
				(eyes show: setScript: blinkScript)
				(= local0 1)
				(rWingScript cue:)
				(cls)
				(PrintDC 104 11 #at 140 100 #dispose #width 150) ; "Well! It is my opinion that you don't stand a chance against the likes of Mordack."
				(= seconds 6)
			)
			(32
				(cls)
				(PrintDC 104 12 #at 140 100 #dispose #width 150) ; "Excuse me for saying, Your Majesty...but you don't have a choice. You MUST come with me. I'm sure Crispin can help you!"
				(= seconds 7)
			)
			(33
				(mouth setCycle: End self)
			)
			(34
				(eyes dispose:)
				(= local0 0)
				(rWing dispose:)
				(mouth hide:)
				(cls)
				(owl view: 759 setLoop: 4 setCycle: End self)
			)
			(35
				(owl setLoop: 5 setCycle: Fwd setMotion: MoveTo 110 58 self)
			)
			(36
				(owl setCycle: End self)
			)
			(37
				(egoHead setCel: 4)
				(owl setLoop: 6 setCycle: Fwd setScript: dustingEgo self)
			)
			(38
				(owl setLoop: 6 setCycle: End self)
			)
			(39
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
			(40
				(owl setLoop: 10 cel: 0 setCycle: Fwd)
				(mouth
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
			(41
				(gEgo setCycle: Fwd)
				(PrintDC 104 13 #at 129 51 #dispose) ; "What is that stuff?"
				(= seconds 2)
			)
			(42
				(gEgo setCycle: End self)
			)
			(43
				(cls)
				(mouth show:)
				(= cycles 3)
			)
			(44
				(PrintDC 104 14 #at 140 10 #width 150 #dispose) ; "Oh, just some old, left-over fairy dust I've been carrying around. It'll help you to fly."
				(= seconds 6)
			)
			(45
				(cls)
				(PrintDC 104 15 67 170 10 351 103 70 100) ; "You can follow me to the land of Serenia, where Crispin and I live. It's MUCH too far to walk, you know. I think the fairy dust is still good."
				(= seconds 13)
			)
			(46
				(egoHead setCel: 1)
				(mouth dispose:)
				(owl setScript: leaveRoomScript)
				(= cycles 1)
			)
			(47
				(SetFlag 32)
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
			(if (> (eyes cel:) 0)
				(eyes setCycle: Beg self)
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
				(eyes setCycle: End self)
			)
			(2
				(eyes setCycle: Beg self)
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

(instance owl of Act
	(properties
		y 86
		x 189
		view 757
	)
)

(instance leaves of Prop
	(properties
		y 188
		x 203
		view 757
	)
)

(instance eyes of Prop
	(properties
		view 757
	)
)

(instance mouth of Prop
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

(instance arms of Act
	(properties
		view 757
	)
)

(instance dust of Act
	(properties
		view 759
	)
)

(instance sack of Act
	(properties
		view 759
	)
)

(instance egoHead of Prop
	(properties
		y 118
		x 81
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
		y 95
		x 81
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

