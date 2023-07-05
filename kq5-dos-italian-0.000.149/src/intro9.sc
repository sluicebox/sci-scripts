;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 108)
(include sci.sh)
(use Main)
(use DLetter)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro9 0
)

(instance intro9 of Rm
	(properties
		picture 1
		style 10
	)

	(method (init)
		(HandsOff)
		(gGame setCursor: 5 1)
		(SetFlag 33)
		(LoadMany rsVIEW 752 770 139 762 140 2 773)
		(gEgo
			view: 752
			posn: 205 -2
			signal: 16384
			setLoop: 0
			setStep: 3 6
			cycleSpeed: 2
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
		(self setScript: a2s3Script setRegions: 763) ; cartoonRegion
		(super init:)
	)
)

(instance a2s3Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(gGlobalSound number: 812 play:)
				(owl setCycle: Fwd setMotion: MoveTo 111 89 self)
			)
			(2
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
				(owlMouth
					view: 136
					loop: 7
					cel: 3
					posn: 110 85
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
				(gGlobalSound number: 860 play:)
				(gEgo
					setPri: 11
					setCycle: Fwd
					setMotion: MoveTo 207 150 self
				)
			)
			(3
				(gGlobalSound number: 68 play:)
				(gEgo posn: 205 157 setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setLoop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(owlMouth setCycle: Fwd)
				(PrintDC 108 0 #at 10 10 #dispose) ; "Sembra che l'effetto della polvere magica si sia esaurito."
				(= seconds 3)
			)
			(6
				(owlMouth setCycle: Beg)
				(door setCycle: End self)
			)
			(7
				(cls)
				(gGlobalSound number: 133 loop: -1 play:)
				(crispin
					view: 762
					setLoop: 0
					setStep: 1 1
					setCycle: Fwd
					setPri: (+ (door priority:) 1)
					moveSpeed: 1
					cycleSpeed: 1
					signal: 18432
					illegalBits: 0
					posn: 165 101
					init:
					setMotion: MoveTo 144 128 self
				)
			)
			(8
				(wizHead
					view: 762
					cycleSpeed: 2
					setLoop: 2
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
							10
						)
					init:
				)
				(crispin view: 762 setCycle: 0 setPri: -1 setLoop: 6)
				(= seconds 5)
				(wizHead setCycle: Fwd)
				(PrintDC 108 1 #at 100 10 #dispose) ; "Cedric! Dove sei stato? Ti stavo cercando!"
			)
			(9
				(wizHead setCycle: Beg)
				(gEgo setCycle: 0 setCel: (- (NumCels gEgo) 1))
				(= seconds 2)
			)
			(10
				(cls)
				(lWing cel: 0 setCycle: End self)
			)
			(11
				(= seconds 3)
			)
			(12
				(lWing setCycle: Beg self)
			)
			(13
				(wizHead cycleSpeed: 2 setLoop: 7 setCycle: End)
				(= seconds 2)
			)
			(14
				(wizHead setCycle: Fwd)
				(PrintDC 108 2 #at 100 10 #dispose) ; "Bene, bene, cosa abbiamo qu\8d?"
				(= seconds 5)
			)
			(15
				(cls)
				(wizHead hide:)
				(crispin
					setLoop: 0
					setCycle: Walk
					signal: (| $4000 (crispin signal:))
					setMotion: MoveTo 134 136 self
				)
			)
			(16
				(crispin
					cycleSpeed: 0
					moveSpeed: 0
					setLoop: 8
					setCycle: Fwd
					setMotion: MoveTo 180 138 self
				)
			)
			(17
				(crispin setLoop: 10 setCycle: 0)
				(= seconds 2)
			)
			(18
				(gCast eachElementDo: #hide)
				(crispin setCycle: 0)
				(client setScript: a2s4Script)
			)
		)
	)
)

(instance a2s4Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 75 10)
				(= cycles 15)
			)
			(1
				(cEyes init:)
				(cEyeBrows init:)
				(cmouth init: setCycle: Fwd)
				(PrintDC 108 3 #at 10 110 #dispose) ; "Sei un po'goffo, non \8a vero? Bene, vieni in casa ad asciugarti. Non fa bene starsene seduti come uno straccio bagnato."
				(= seconds 10)
			)
			(2
				(cls)
				(cEyes dispose:)
				(cEyeBrows dispose:)
				(cmouth setCycle: 0 dispose:)
				(= seconds 2)
			)
			(3
				(self setScript: a2s5Script)
			)
		)
	)
)

(instance a2s5Script of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(DrawPic 1 10)
				(gCast eachElementDo: #show)
				(wizHead hide:)
				((gEgo head:) hide:)
				(= cycles 20)
			)
			(1
				(gEgo setLoop: 4 normal: 0 cycleSpeed: 2 setCycle: End self)
			)
			(2
				(crispin setLoop: 9)
				(wizHead
					init:
					show:
					cycleSpeed: 2
					setPri: 10
					posn: 177 117
					view: 762
					setLoop: 11
				)
				(wizHead setCycle: Fwd)
				(PrintDC 108 4 #at 100 10 #dispose) ; "Cedric, entra in casa e versaci una bella tazza di t\8a caldo."
				(= seconds 5)
			)
			(3
				(cls)
				(wizHead setCycle: 0 hide: dispose:)
				(crispin setCycle: 0)
				(owlMouth setCycle: Fwd)
				(PrintDC 108 5 #at 10 120 #dispose) ; "Signors\8d, Crispin."
				(= seconds 4)
			)
			(4
				(cls)
				(owl view: 140 setLoop: 5 setCycle: CT 10 1 self)
				(owlMouth dispose:)
				(owlHead dispose:)
				(lWing dispose:)
				(rWing dispose:)
			)
			(5
				(owl
					view: 139
					setLoop: 9
					setCycle: Fwd
					setMotion: MoveTo 168 88 self
				)
			)
			(6
				(owl dispose:)
				(gEgo setPri: -1 setScript: egoMoveScript)
				(crispin
					setCycle: Fwd
					signal: (| $4000 (crispin signal:))
					illegalBits: 0
					setMotion: MoveTo 134 136 self
				)
			)
			(7
				(crispin
					setLoop: 1
					moveSpeed: 2
					cycleSpeed: 2
					setMotion: MoveTo 165 101 self
				)
			)
			(8
				(crispin dispose:)
				(self dispose:)
			)
		)
	)
)

(instance egoMoveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gEgo
					cycleSpeed: 2
					setCycle: KQ5SyncWalk
					moveSpeed: 2
					setLoop: 5
					setMotion:
						MoveTo
						(- (gEgo x:) 12)
						(- (gEgo y:) 12)
						self
				)
			)
			(2
				(gEgo setLoop: 7 setCycle: End self)
			)
			(3
				(gEgo view: 2 setLoop: -1 normal: 1)
				((gEgo head:) view: 2 setLoop: 4 hide:)
				(proc0_7 gEgo crispin 5)
				(= cycles 1)
			)
			(4
				((gEgo head:) show:)
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
				(gGlobalSound fade:)
				(gCurRoom newRoom: 109) ; intro10
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
		(self setPri: (+ (crispin priority:) 1))
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
		(self setPri: (+ (owlHead priority:) 1))
	)
)

(instance rail of Prop
	(properties)
)

(instance cEyes of Prop
	(properties
		x 175
		y 47
		view 773
		loop 2
		priority 10
		signal 18448
		cycleSpeed 2
	)

	(method (doit)
		(switch (Random 1 40)
			(1
				(if (not (self script:))
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
		view 773
		loop 1
		priority 9
		signal 18448
		cycleSpeed 2
	)

	(method (doit)
		(switch (Random 1 40)
			(1
				(if (not (self script:))
					(self setScript: goEyeBrows)
				)
			)
		)
		(super doit:)
	)
)

(instance cmouth of Prop
	(properties
		x 176
		y 63
		view 773
		signal 18448
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
				(if (and (not (self script:)) (owlMouth cycler:))
					(self setScript: (goEyesGo new:))
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
				(if (and (not (self script:)) (owlMouth cycler:))
					(self setScript: (goEyesGo new:))
				)
			)
		)
	)
)

