;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 658)
(include sci.sh)
(use Main)
(use AudioScript)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	cdIntro9 0
)

(instance cdIntro9 of Rm
	(properties
		picture 1
		style 10
	)

	(method (init)
		(HandsOff)
		(gGame setCursor: gNarrator 1)
		(SetFlag 33)
		(LoadMany rsPIC 1)
		(self setScript: a2s3Script setRegions: 769) ; introtoonRegion
		(super init:)
		(UnLoad 129 74)
		(LoadMany rsVIEW 752 770 139 1073)
		(gEgo
			view: 752
			posn: 205 -2
			signal: 16384
			setLoop: 0
			setStep: 3 (if (== gHowFast 2) 6 else 12)
			cycleSpeed: (if (== gHowFast 2) 2 else 0)
			moveSpeed: (if (== gHowFast 2) 2 else 0)
			illegalBits: 0
			normal: 0
			init:
		)
		((gEgo head:) hide:)
		(rail
			view: 770
			setLoop: 4
			posn: 123 161
			setPri: 15
			cel: 1
			init:
			stopUpd:
		)
		(owl view: 139 setLoop: 7 posn: 199 -7 ignoreActors: 1 init:)
		(door view: 770 loop: 5 posn: 170 96 setPri: 1 init:)
		(smoke
			view: 770
			loop: 6
			setCycle: Fwd
			cycleSpeed: 9
			posn: 188 8
			setPri: 0
			init:
		)
		(water
			view: 770
			loop: 0
			setCycle: Fwd
			cycleSpeed: 20
			posn: 256 154
			setPri: 1
			init:
		)
		(rippling
			view: 770
			loop: 1
			setCycle: Fwd
			cycleSpeed: 9
			posn: 158 168
			signal: 16384
			setPri: 1
			init:
		)
		(rippling2
			view: 770
			loop: 2
			setCycle: Fwd
			cycleSpeed: 2
			posn: 79 154
			signal: 16384
			setPri: 1
			init:
		)
		(if (!= gHowFast 2)
			(smoke stopUpd:)
			(water stopUpd:)
			(rippling stopUpd:)
			(rippling2 stopUpd:)
		)
	)
)

(instance a2s3Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsPIC 75)
				(Load rsSCRIPT 929)
				(LoadMany rsVIEW 762 140 2 773 136)
				(Load rsSYNC 10112)
				(= cycles 1)
			)
			(1
				(theMouth init: hide: play: 10112 659)
				(= waitForCue 17924)
			)
			(2
				(owl setCycle: Fwd setMotion: MoveTo 111 89 self)
			)
			(3
				(owl
					view: 136
					loop: 10
					cel: 1
					setCycle: 0
					posn: 108 94
					setPri: 5
					signal: 16384
					illegalBits: 0
				)
				(lWing
					view: 136
					loop: 4
					cel: 0
					posn: 107 87
					setPri: (+ (owl priority:) 1)
					init:
				)
				(rWing
					view: 136
					loop: 6
					cel: 0
					posn: 114 87
					setPri: (+ (owl priority:) 1)
					init:
				)
				(owlHead
					view: 136
					loop: 1
					cel: 2
					posn: 108 87
					setPri: (+ (owl priority:) 1)
					init:
				)
				(= waitForCue 18004)
			)
			(4
				(gEgo
					setPri: 11
					setCycle: Fwd
					setMotion: MoveTo 207 150
					moveSpeed: 2
					cycleSpeed: 2
				)
				(= waitForCue 18180)
			)
			(5
				(gEgo
					posn: 205 157
					setLoop: 1
					setMotion: 0
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo
					setLoop: 2
					setCycle: Fwd
					moveSpeed: (if (== gHowFast 2) 2 else 0)
					cycleSpeed: (if (== gHowFast 2) 2 else 0)
				)
				(= waitForCue 18432)
			)
			(7
				(theMouth changeMouth: 3 show:)
				(= waitForCue 18688)
			)
			(8
				(theMouth hide:)
				(door setCycle: End self)
			)
			(9
				(= waitForCue 20480)
			)
			(10
				(cls)
				(crispin
					view: 762
					setLoop: 0
					setStep: 1 1
					setCycle: Fwd
					setPri: (+ (door priority:) 1)
					moveSpeed: (if (== gHowFast 2) 1 else 0)
					cycleSpeed: (if (== gHowFast 2) 1 else 0)
					signal: 18432
					illegalBits: 0
					posn: 165 101
					init:
					setMotion: MoveTo 144 128 self
				)
			)
			(11
				(crispin view: 762 setCycle: 0 setPri: -1 setLoop: 6)
				(theMouth changeMouth: 0 show:)
				(wizHead hide:)
				(= waitForCue 20992)
			)
			(12
				(gEgo setCycle: 0 setCel: (- (NumCels gEgo) 1))
				(= seconds 2)
			)
			(13
				(cls)
				(lWing cel: 0 setCycle: End self)
			)
			(14
				(= seconds 2)
			)
			(15
				(lWing setCycle: Beg self)
			)
			(16
				(= cycles 1)
			)
			(17
				(theMouth setLoop: 7 show:)
				(= waitForCue 21504)
			)
			(18
				(cls)
				(theMouth hide:)
				(crispin
					setLoop: 0
					setCycle: Walk
					signal: (| $4000 (crispin signal:))
					setMotion: MoveTo 134 136 self
				)
			)
			(19
				(crispin
					cycleSpeed: 0
					setLoop: 8
					setCycle: Fwd
					setMotion: MoveTo 180 138 self
					moveSpeed: 0
				)
			)
			(20
				(crispin setLoop: 10 setCycle: 0 cel: 0)
				(if (== gHowFast 2)
					(= seconds 2)
				else
					(= cycles 1)
				)
			)
			(21
				(if (== gHowFast 2)
					(gCast eachElementDo: #hide)
					(crispin setCycle: 0)
					(client setScript: a2s4Script)
				else
					(theMouth
						posn:
							(+ (crispin x:) 1)
							(+
								(-
									(crispin y:)
									(CelHigh
										(crispin view:)
										(crispin loop:)
										(crispin cel:)
									)
								)
								12
							)
					)
					(theMouth setPri: (+ (crispin priority:) 1) show:)
					(= waitForCue 22020)
				)
			)
			(22
				(client setScript: a2s5Script)
			)
		)
	)
)

(instance a2s4Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 75 10)
				(= waitForCue 21764)
			)
			(1
				(cEyes init:)
				(cEyeBrows init:)
				(theMouth changeMouth: 1 show:)
				(= waitForCue 22020)
			)
			(2
				(cEyes dispose:)
				(cEyeBrows dispose:)
				(theMouth hide:)
				(= seconds 2)
			)
			(3
				(self setScript: a2s5Script)
			)
		)
	)
)

(instance a2s5Script of AudioScript
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(if (== gHowFast 2)
					(DrawPic 1 10)
					(gCast eachElementDo: #show)
				)
				(theMouth hide:)
				((gEgo head:) hide:)
				(wizHead hide:)
				(if (== gHowFast 2)
					(= cycles 20)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					setLoop: 4
					normal: 0
					cycleSpeed: (if (== gHowFast 2) 2 else 0)
					setCycle: End self
				)
			)
			(2
				(crispin setLoop: 9)
				(gEgo setPri: -1 setScript: egoMoveScript)
				(= waitForCue 22528)
			)
			(3
				(theMouth changeMouth: 2 show:)
				(= waitForCue 22784)
			)
			(4
				(cls)
				(crispin setCycle: 0)
				(theMouth changeMouth: 3)
				(owlMouth hide:)
				(= waitForCue 24576)
			)
			(5
				(cls)
				(owl view: 140 setLoop: 5 setCycle: CT 10 1 self)
				(owlMouth dispose:)
				(owlHead dispose:)
				(lWing dispose:)
				(rWing dispose:)
				(theMouth hide:)
			)
			(6
				(owl
					view: 139
					setLoop: 9
					setCycle: Fwd
					setMotion: MoveTo 168 88 self
				)
			)
			(7
				(owl dispose:)
				(crispin
					setCycle: Fwd
					signal: (| $4000 (crispin signal:))
					illegalBits: 0
					setMotion: MoveTo 134 136 self
				)
			)
			(8
				(crispin
					setLoop: 1
					cycleSpeed: (if (== gHowFast 2) 2 else 0)
					setMotion: MoveTo 165 101 self
					moveSpeed: (if (== gHowFast 2) 2 else 0)
				)
			)
			(9
				(crispin dispose:)
				(self dispose:)
			)
		)
	)
)

(instance egoMoveScript of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo
					cycleSpeed:
						(switch gHowFast
							(2 2)
							(else 0)
						)
					setCycle: KQ5SyncWalk
					setLoop: 5
					setMotion:
						MoveTo
						(- (gEgo x:) 12)
						(- (gEgo y:) 12)
						self
					moveSpeed:
						(switch gHowFast
							(2 2)
							(else 0)
						)
				)
			)
			(2
				(gEgo setLoop: 7 setCycle: End self)
			)
			(3
				(gEgo view: 2 setLoop: -1 normal: 1)
				((gEgo head:) view: 2 setLoop: 4 moveHead: 0 show:)
				(proc0_7 gEgo crispin 5)
				(= waitForCue 24656)
			)
			(4
				(gEgo
					setCycle: KQ5SyncWalk
					setStep: 2 1
					setMotion: MoveTo 142 131 self
				)
			)
			(5
				(gEgo setMotion: MoveTo 155 113 self)
			)
			(6
				(if (> (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(gCurRoom newRoom: 659) ; cdIntro10
			)
		)
	)
)

(instance crispin of Actor
	(properties)
)

(instance wizHead of Prop
	(properties)

	(method (doit)
		(super doit:)
		(self priority: (+ (crispin priority:) 1) signal: (| signal $0010))
	)
)

(instance cedric of Actor ; UNUSED
	(properties)
)

(instance door of Prop
	(properties)
)

(instance smoke of Prop
	(properties)
)

(instance water of Prop
	(properties)
)

(instance rippling of Prop
	(properties)
)

(instance rippling2 of Prop
	(properties)
)

(instance owl of Actor
	(properties)
)

(instance owlMouth of Prop
	(properties)

	(method (doit)
		(super doit:)
		(self priority: (+ (owlHead priority:) 1) signal: (| signal $0010))
	)
)

(instance rail of Prop
	(properties)
)

(instance cEyes of Prop
	(properties
		x 175
		y 47
		view 1073
		loop 2
		priority 10
		signal 18448
		cycleSpeed 2
	)

	(method (doit)
		(switch (Random 1 40)
			(1
				(if (not script)
					(self setScript: (goEyesGo new:))
				)
			)
		)
		(super doit:)
	)
)

(instance cEyeBrows of Prop
	(properties
		x 175
		y 47
		view 1073
		loop 1
		priority 9
		signal 18448
		cycleSpeed 2
	)

	(method (doit)
		(switch (Random 1 40)
			(1
				(if (not script)
					(self setScript: goEyeBrows)
				)
			)
		)
		(super doit:)
	)
)

(instance goEyeBrows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cEyeBrows setCycle: End self)
			)
			(1
				(cEyeBrows setCycle: Beg self)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

(instance goEyesGo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(client setScript: 0)
			)
		)
	)
)

(instance owlHead of Prop
	(properties)
)

(instance rWing of Prop
	(properties)

	(method (doit)
		(super doit:)
		(switch (Random 1 40)
			(1
				(if (and (not script) (owlMouth cycler:))
					(self setScript: (goEyesGo new:))
				)
			)
		)
	)
)

(instance theMouth of MonoAudioProp
	(properties
		view 136
	)

	(method (changeMouth param1)
		(switch param1
			(0
				(theMouth view: 762 setLoop: 2)
				(theMouth
					posn:
						(crispin x:)
						(+
							(-
								(crispin y:)
								(CelHigh
									(crispin view:)
									(crispin loop:)
									(crispin cel:)
								)
							)
							6
						)
					setPri: (+ (crispin priority:) 1)
				)
			)
			(2
				(theMouth setPri: 10 posn: 176 117 view: 762 setLoop: 11)
			)
			(1
				(theMouth view: 1073 loop: 0 x: 158 y: 83 signal: 18448)
			)
			(3
				(theMouth
					view: 136
					loop: 7
					cel: 3
					posn: 110 85
					setPri: (+ (owl priority:) 2)
				)
			)
		)
	)
)

(instance lWing of Prop
	(properties)

	(method (doit)
		(super doit:)
		(switch (Random 1 40)
			(1
				(if (and (not script) (owlMouth cycler:))
					(self setScript: (goEyesGo new:))
				)
			)
		)
	)
)

