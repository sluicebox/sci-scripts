;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Actor)
(use System)

(public
	landing 0
)

(instance landing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(mother init: stopUpd:)
				(FakeEgo init: setCycle: Fwd setMotion: MoveTo 266 22 self)
			)
			(1
				(= seconds 3)
			)
			(2
				(FakeEgo
					view: (+ global114 21)
					illegalBits: 0
					cel: 1
					posn: 289 106
					setPri: -1
					loop: 1
					cycleSpeed: 6
					moveSpeed: 2
					xStep: 2
					setPri: 14
					setMotion: MoveTo 198 124 self
				)
			)
			(3
				(FakeEgo
					setCycle: 0
					setLoop: 2
					setCel: 0
					posn: (+ (FakeEgo x:) -10) 141
					setPri: -1
					setMotion: MoveTo 34 141
				)
				(= ticks 66)
			)
			(4
				(FakeEgo setCycle: End self)
				(= ticks 18)
			)
			(5
				(FakeEgo setMotion: 0)
			)
			(6
				(FakeEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(7
				(FakeEgo dispose:)
				(gEgo
					setCycle: 0
					posn: (+ (FakeEgo x:) -3) (+ (FakeEgo y:) -2)
					init:
				)
				(proc0_7 gEgo mother)
				(global109 init: posn: (+ (FakeEgo x:) -3) (FakeEgo y:))
				(global110 left: (+ (gEgo x:) -3))
				(= cycles 2)
			)
			(8
				(proc411_0 (gEgo head:) herHead)
				(= cycles 1)
			)
			(9
				(proc0_20)
				(mother say: (= register 480) self)
			)
			(10
				(gEgo say: (++ register) self)
			)
			(11
				(mother say: (++ register) self)
			)
			(12
				(gEgo say: (++ register) self)
			)
			(13
				(mother say: (++ register) self)
			)
			(14
				(proc411_1)
				(herHead dispose:)
				(mother setCycle: Walk setMotion: MoveTo 82 125 self)
			)
			(15
				(mother loop: 3)
				(global111 startUpd: setCycle: End self)
				(gSfx number: 38 play:)
			)
			(16
				(mother setMotion: MoveTo 82 114 self)
			)
			(17
				(mother setMotion: MoveTo 108 114)
				(global111 setCycle: Beg self)
				(gSfx number: 36 play:)
			)
			(18
				(mother dispose:)
				(global110 left: 40)
				(= cycles 3)
			)
			(19
				(global111 stopUpd:)
				(= cycles 3)
			)
			(20
				(proc0_3)
				(gEgo setCycle: Walk)
				(= global104 0)
				(self dispose:)
			)
		)
	)
)

(instance FakeEgo of Actor
	(properties
		x 179
		y 22
		view 16
		signal 26624
		cycleSpeed 4
		illegalBits 0
		xStep 1
		moveSpeed 1
	)
)

(instance mother of CDActor
	(properties
		x 84
		y 141
		view 92
		loop 4
		illegalBits 0
	)

	(method (init)
		(super init:)
		(= head herHead)
		(head setLoop: 5 init: self)
	)
)

(instance herHead of Head
	(properties
		x 84
		y 103
		view 92
		loop 5
		moveHead 0
	)
)

