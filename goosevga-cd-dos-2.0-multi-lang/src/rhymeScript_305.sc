;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use Sync)
(use Avoid)
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
	local7 = 1
	local8
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo setScript: egoGive)
				(Load rsVIEW 910)
				(Load rsVIEW 913)
			)
			(1
				(proc0_9)
				(global109
					setCel: 0
					setLoop: 5
					cycleSpeed: 2
					setCycle: End self
					setScript: 0
				)
			)
			(2
				(global109 cel: 0 cycleSpeed: 3 setLoop: 6 setCycle: End self)
			)
			(3
				(global111 dispose:)
				(gLongSong stop:)
				(rhymeSync init: 5)
				(global109
					setPri:
					setCel: 0
					setLoop: 7
					cycleSpeed: 0
					moveSpeed: 1
					setCycle: Walk
					setMotion: MoveTo 108 101 self
				)
			)
			(4
				(if (< (rhymeSync prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(proc0_16 (Format @global300 305 0)) ; "Humpty Dumpty sat on a wall,"
				(global109 cel: 0 setLoop: 8 setCycle: End self)
			)
			(6
				(= seconds 2)
			)
			(7
				(global109 cel: 0 setLoop: 9 cycleSpeed: 4 setCycle: Fwd)
				(= cycles 1)
			)
			(8
				(if (< (rhymeSync prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(proc0_16 (Format @global300 305 1)) ; "Humpty Dumpty had a great fall;"
				(global109 setCycle: End self)
			)
			(10
				(global109
					cycleSpeed: 0
					setCel: 0
					setLoop: 10
					setCycle: End self
				)
			)
			(11
				(global109 view: 910 setLoop: 8 setCel: 0)
				(kMan init:)
				(= cycles 1)
			)
			(12
				(if (< (rhymeSync prevSignal:) 30)
					(-- state)
				else
					(proc0_16 (Format @global300 305 2)) ; "All the King's horses,"
				)
				(= cycles 1)
			)
			(13
				(if (< (rhymeSync prevSignal:) 40)
					(-- state)
				else
					(proc0_16 (Format @global300 305 3)) ; "And all the King's men"
				)
				(= cycles 1)
			)
			(14
				(if (< (rhymeSync prevSignal:) 50)
					(-- state)
				else
					(proc0_16 (Format @global300 305 4)) ; "Couldn't put Humpty Dumpty together again."
				)
				(= cycles 1)
			)
			(15
				(if local1
					(-- state)
				)
				(= cycles 1)
			)
			(16
				(if (== (rhymeSync playing:) 0)
					(proc0_16 0)
					(proc0_10)
					(= seconds 2)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(17
				(gEgo setMotion: 0 setLoop: -1)
				(gLongSong number: 1 loop: -1 play:)
				(if (== gScore gPossibleScore)
					(gCurRoom setScript: (ScriptID 205)) ; walkTo
				else
					(proc0_3)
					(self dispose:)
				)
				(= local8 1)
			)
		)
		(if local8
			(DisposeScript 305)
		)
	)
)

(instance egoGive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setAvoider: Avoid setMotion: MoveTo 126 118 self)
			)
			(1
				(global110 init:)
				((gGoals at: 16) egoReturned: 1)
				(gEgo setAvoider: 0 setMotion: MoveTo 180 144 self)
				(DisposeScript 985)
				(rhymeScript cue:)
			)
			(2
				(proc0_7 gEgo global109)
				(self dispose:)
			)
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
				(ambulance addToPic:)
				(wheel addToPic:)
				(kMan setMotion: MoveTo 159 130 self)
				(= cycles 50)
			)
			(2
				(kMan setLoop: 6)
				(kHorse setLoop: 7)
				(stretch setCycle: 0 setCel: 1)
			)
			(3
				(= local7 0)
				(kMan
					view: 913
					setLoop: 0
					setCel: 255
					setCycle: carryto 0 -1 self
				)
				(kHorse view: 913 setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(4)
			(5
				(stretch setLoop: 11)
				(kMan setCycle: End self)
				(kHorse setCycle: End self)
			)
			(6)
			(7
				(kMan setLoop: 2 setCel: 0 setCycle: End self)
				(kHorse setLoop: 6 setCel: 0 setCycle: End self)
			)
			(8)
			(9
				(kMan setLoop: 3 setCel: 255 setCycle: Beg self)
				(kHorse setLoop: 4 setCel: 255 setCycle: Beg)
			)
			(10
				(kMan setLoop: 7 setCycle: Fwd)
				(kHorse setLoop: 5 setCycle: Fwd)
				(stretch setLoop: 9 setCycle: Fwd)
				(global109 dispose:)
				(= cycles 12)
			)
			(11
				(kMan setLoop: 3 setCel: 0 setCycle: carryto 4 1 self)
				(kHorse setLoop: 4 setCel: 0 setCycle: End)
				(stretch setLoop: 10 setCel: 1 setCycle: Walk)
			)
			(12
				(= local7 1)
				(kMan
					view: 910
					setLoop: 3
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo -10 136 self
				)
				(kHorse view: 910 setLoop: 5 setCel: 0 setCycle: Walk)
			)
			(13
				(kMan dispose:)
				(global111 priority: 3)
				(underAmb addToPic:)
				(wheel setPri: 5)
				(ambulance priority: 4 init: setMotion: MoveTo -35 128 self)
			)
			(14
				(ambulance dispose:)
				(self dispose:)
				(-- local1)
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

(instance ambulance of Act
	(properties
		y 128
		x -35
		z 5
		view 910
		priority 2
		signal 22544
		xStep 2
	)

	(method (init)
		(= signal 22544)
		(super init:)
		(rooroo init:)
		(wheel signal: 22544 init:)
	)

	(method (dispose)
		(rooroo dispose:)
		(wheel dispose:)
		(super dispose:)
	)
)

(instance underAmb of View
	(properties
		y 128
		x 45
		view 910
		cel 2
		priority 3
		signal 22800
	)
)

(instance rooroo of Prop
	(properties
		y 128
		x -19
		z 59
		view 910
		loop 1
		signal 18432
		cycleSpeed 1
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
		y 128
		x -19
		view 910
		cel 1
		priority 2
		signal 22544
	)

	(method (doit)
		(= x (ambulance x:))
		(super doit:)
	)
)

(instance kMan of Act
	(properties
		y 136
		x -10
		view 910
		loop 2
		signal 18432
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(stretch init:)
		(kHorse init:)
		(self setCycle: Walk setScript: rescue)
	)

	(method (dispose)
		(stretch dispose:)
		(kHorse dispose:)
		(super dispose:)
	)
)

(instance stretch of Prop
	(properties
		y 136
		x -43
		z 14
		view 910
		loop 12
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Walk)
	)

	(method (doit)
		(if local7
			(= x (+ (kMan x:) -33))
			(= y (kMan y:))
		)
		(super doit:)
	)
)

(instance kHorse of Prop
	(properties
		y 136
		x -71
		view 910
		loop 4
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCycle: Walk)
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

