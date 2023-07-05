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
					posn: 281 91
					setPri: -1
					loop: 1
					cycleSpeed: 3
					moveSpeed: 0
					setPri: 14
					setMotion: MoveTo 174 101 self
				)
			)
			(3
				(FakeEgo setLoop: 1 setCel: 0 setMotion: MoveTo 134 121 self)
			)
			(4
				(FakeEgo
					posn: 134 141
					setCel: -1
					cel: 0
					loop: 2
					setCycle: End self
				)
			)
			(5
				(FakeEgo setLoop: 3 setCel: 0 setCycle: End self)
			)
			(6
				(FakeEgo dispose:)
				(gEgo setCycle: 0 posn: 134 139 init:)
				(proc0_7 gEgo mother)
				(global109 init:)
				(global110 left: 130)
				(= cycles 2)
			)
			(7
				(proc411_0 (gEgo head:) herHead)
				(= cycles 1)
			)
			(8
				(proc0_20)
				(mother say: (= register 480) self)
			)
			(9
				(gEgo say: (++ register) self)
			)
			(10
				(mother say: (++ register) self)
			)
			(11
				(gEgo say: (++ register) self)
			)
			(12
				(mother say: (++ register) self)
			)
			(13
				(proc411_1)
				(DoSound sndMASTER_VOLUME global125)
				(herHead dispose:)
				(mother setCycle: Walk setMotion: MoveTo 82 125 self)
			)
			(14
				(mother loop: 3)
				(global111
					signal: (& (global111 signal:) $feff)
					startUpd:
					setCycle: End self
				)
			)
			(15
				(mother setMotion: MoveTo 82 114 self)
			)
			(16
				(global111 setCycle: Beg self)
				(mother setMotion: MoveTo 108 114 self)
			)
			(17
				(mother dispose:)
				(global110 left: 40)
			)
			(18
				(global111 signal: (| (global111 signal:) $0100) stopUpd:)
				(= cycles 3)
			)
			(19
				(proc0_3)
				(gEgo setCycle: Walk)
				(= global104 0)
				(self dispose:)
			)
		)
	)
)

(instance FakeEgo of Act
	(properties
		y 22
		x 179
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
		y 141
		x 84
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
		y 103
		x 84
		view 92
		loop 5
		moveHead 0
	)
)

