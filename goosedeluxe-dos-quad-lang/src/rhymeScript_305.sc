;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use Str)
(use Sync)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	rhymeScript 0
)

(local
	local0
	local1 = 1
	[local2 5] = [1 5 9 10 13]
	local7
	local8
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(= temp0 (Str new: 50))
		(switch (= state newState)
			(0
				(= local8 0)
				(= local7 1)
				(Load rsVIEW 910)
				(Load rsVIEW 913)
				(gEgo setMotion: PolyPath 123 119 self)
			)
			(1
				(global111 init:)
				(gEgo setMotion: PolyPath 180 144 self)
			)
			(2
				(proc0_7 gEgo global109)
				(= cycles 1)
			)
			(3
				(gLongSong stop:)
				(= ticks 30)
			)
			(4
				(if (!= gLanguage 3)
					(gMessager say: 1 0 0 6 0 400) ; "HUMPTY DUMPTY"
				)
				(proc0_9)
				(global109 cel: 0 setLoop: 5 1 cycleSpeed: 6 setCycle: End self)
			)
			(5
				(global109 cel: 0 cycleSpeed: 6 setLoop: 6 1 setCycle: End self)
			)
			(6
				(if (!= gLanguage 3)
					(gLongSong stop:)
					(rhymeSync init: 400 1 0 0 6)
				)
				(global109
					ignoreActors: 1
					setPri: 150
					cel: 0
					setLoop: 7 1
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 108 101 self
				)
			)
			(7
				(global109 cel: 0 setLoop: 8 1 setCycle: End self)
			)
			(8
				(if (== gLanguage 3)
					(gMessager say: 1 0 0 6 0 400) ; "HUMPTY DUMPTY"
					(gLongSong stop:)
					(rhymeSync init: 400 1 0 0 6)
				)
				(= cycles 1)
			)
			(9
				(cond
					((< (rhymeSync prevSignal:) 10)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {Humpty Dumpty se sent& en el muro})
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {T3te d'oeuf grimpe sur un mur.})
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0 format: {Auf der Mauer, auf der Lauer})
						)
					)
					(else
						(proc0_16
							(temp0 format: {Humpty Dumpty sat on a wall,})
						)
					)
				)
				(= cycles 1)
			)
			(10
				(= seconds 2)
			)
			(11
				(global109 cel: 0 setLoop: 9 1 cycleSpeed: 9 setCycle: Fwd)
				(= cycles 1)
			)
			(12
				(cond
					((< (rhymeSync prevSignal:) 20)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0
								format: {Humpty Dumpty sufri& una grave ca^da.}
							)
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {T3te d'oeuf tombe de ce mur.})
						)
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {sitzt `ne kleine Wanze,}))
					)
					(else
						(proc0_16
							(temp0 format: {Humpty Dumpty had a great fall,})
						)
					)
				)
				(= cycles 1)
			)
			(13
				(global109 setCycle: End self)
				(global111 cel: 0 setLoop: 1 1 cycleSpeed: 10 setCycle: End)
				(= cycles 1)
			)
			(14
				(global109
					cycleSpeed: 6
					cel: 0
					setLoop: 10 1
					setCycle: End self
				)
			)
			(15
				(global109 view: 910 setLoop: 7 1 cel: 0)
				(kMan init:)
				(= cycles 1)
			)
			(16
				(cond
					((< (rhymeSync prevSignal:) 30)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16 (temp0 format: {Todos los caballos del Rey,}))
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {Tout $tourdi, d$moli, engourdi})
						)
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {Seht euch mal die Wanze an,}))
					)
					(else
						(proc0_16 (temp0 format: {All the King's horses,}))
					)
				)
				(= cycles 1)
			)
			(17
				(cond
					((< (rhymeSync prevSignal:) 40)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0 format: {y todos los hombres del Rey,})
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0 format: {on le transporte 0 l'h4pital})
						)
					)
					((== gLanguage 3)
						(proc0_16 (temp0 format: {wie die Wanze tanzen kann!}))
					)
					(else
						(proc0_16 (temp0 format: {And all the King's men}))
					)
				)
				(= cycles 1)
			)
			(18
				(cond
					((< (rhymeSync prevSignal:) 50)
						(-- state)
					)
					((== gLanguage 1)
						(proc0_16
							(temp0
								format:
									{no pudieron arreglar a Humpty otra vez.}
							)
						)
					)
					((== gLanguage 2)
						(proc0_16
							(temp0
								format:
									{pour qu'il n'ait plus mal. A7e, a7e, a7e!}
							)
						)
					)
					((== gLanguage 3)
						(proc0_16
							(temp0
								format:
									{Auf der Mauer, auf der Lauer\nsitzt `ne kleine Wanze.}
							)
						)
					)
					(else
						(proc0_16
							(temp0
								format: {Couldn't put Humpty together again.}
							)
						)
					)
				)
				(= cycles 1)
			)
			(19
				(if local1
					(-- state)
				)
				(= cycles 1)
			)
			(20
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(21
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 600 loop: -1 play:)
				(= local8 1)
			)
		)
		(temp0 dispose:)
		(if local8
			(if (>= gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			)
			(self dispose:)
		)
	)
)

(instance rescue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ambulance init: setMotion: MoveTo 28 128 self)
			)
			(1
				(wheel cel: 1)
				(kMan moveSpeed: 0 setMotion: MoveTo 145 130 self)
			)
			(2
				(kMan cel: 0 setLoop: 5 1 setMotion: MoveTo 155 130 self)
			)
			(3
				(= local7 0)
				(kMan
					view: 913
					setLoop: 0 1
					cel: 255
					setCycle: carryto 0 -1 self
				)
				(kHorse
					init:
					view: 913
					show:
					setLoop: 1 1
					cel: 255
					setCycle: Beg self
				)
				(stretch init: x: (+ (kMan x:) -33) y: (kMan y:) show:)
			)
			(4)
			(5
				(stretch setLoop: 11 1)
				(kMan setCycle: End self)
				(kHorse setCycle: End self)
			)
			(6)
			(7
				(kMan setLoop: 2 1 cel: 0 setCycle: End self)
				(kHorse setLoop: 6 1 cel: 0 setCycle: End self)
			)
			(8)
			(9
				(kMan setLoop: 3 1 cel: 255 setCycle: Beg self)
				(kHorse setLoop: 4 1 cel: 255 setCycle: Beg)
			)
			(10
				(kMan setLoop: 7 1 setCycle: Fwd)
				(kHorse setLoop: 5 1 setCycle: Fwd)
				(stretch setLoop: 8 1 setCycle: End)
				(global109 dispose:)
				(= cycles 12)
			)
			(11
				(kMan setLoop: 3 1 cel: 0 setCycle: carryto 4 1 self)
				(kHorse setLoop: 4 1 cel: 0 setCycle: End)
				(stretch setCycle: Walk)
			)
			(12
				(= local7 1)
				(kMan view: 910 setLoop: 3 1 cel: 0 setCycle: Walk)
				(= cycles 1)
			)
			(13
				(kHorse hide:)
				(stretch hide:)
				(kMan setMotion: MoveTo -10 136 self)
			)
			(14
				(wheel cel: 2)
				(ambulance setMotion: MoveTo -35 128 self)
			)
			(15
				(kMan dispose:)
				(stretch dispose:)
				(kHorse dispose:)
				(ambulance dispose:)
				(-- local1)
				(self dispose:)
			)
		)
	)
)

(instance carryto of CT
	(properties)

	(method (doit)
		(super doit:)
		(stretch z: [local2 (client cel:)])
	)
)

(instance ambulance of Actor
	(properties
		x -35
		y 128
		z 5
		priority 2
		view 910
		xStep 2
		moveSpeed 0
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setLoop: 0 1)
		(rooroo init:)
		(wheel init:)
	)

	(method (dispose)
		(rooroo dispose:)
		(wheel dispose:)
		(super dispose:)
	)
)

(instance rooroo of Prop
	(properties
		x -19
		y 128
		z 59
		view 910
		loop 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (doit)
		(= x (+ (ambulance x:) 4))
		(super doit:)
	)
)

(instance wheel of View
	(properties
		x -19
		y 128
		view 910
		cel 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: (+ (ambulance priority:) 1) setLoop: 0 1)
	)

	(method (doit)
		(= x (ambulance x:))
		(super doit:)
	)
)

(instance kMan of Actor
	(properties
		x -10
		y 136
		view 910
		loop 2
	)

	(method (init)
		(super init:)
		(self setLoop: 2 1 ignoreActors: 1 setCycle: Walk setScript: rescue)
	)
)

(instance stretch of Actor
	(properties
		z 14
		view 910
		loop 12
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setCycle: Walk)
	)

	(method (doit)
		(if local7
			(= x (+ (kMan x:) -33))
			(= y (kMan y:))
		)
		(super doit:)
	)
)

(instance kHorse of Actor
	(properties
		x -71
		y 136
		view 910
		loop 4
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setCycle: Fwd)
	)

	(method (doit)
		(= x (+ (kMan x:) -61))
		(= y (kMan y:))
		(super doit:)
	)
)

(instance rhymeSync of ScriptSync
	(properties)
)

