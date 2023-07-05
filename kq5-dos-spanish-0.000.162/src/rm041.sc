;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Motion)
(use Actor)
(use System)

(public
	rm041 0
)

(instance rm041 of KQ5Room
	(properties
		picture 41
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 823 loop: -1 vol: 127 playBed:)
		(HandsOff)
		(SetCursor gWaitCursor 1 10 170)
		(roc init:)
		(self setScript: roomScript)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 40)
			)
			(1
				(roc
					setLoop: 0
					x: 87
					y: -25
					setStep: 2 2
					cycleSpeed: 2
					setCycle: Fwd
					setMotion: MoveTo 48 50 self
				)
			)
			(2
				(= cycles 40)
			)
			(3
				(roc setMotion: MoveTo (roc x:) (- (roc y:) 6) self)
			)
			(4
				(roc y: (+ (roc y:) 6) setCycle: CT 0 1 self)
			)
			(5
				(roc setLoop: 1 cel: 0 cycleSpeed: 5 setCycle: End self)
			)
			(6
				(roc
					setLoop: 2
					cel: 0
					x: 95
					y: 61
					xStep: 3
					cycleSpeed: 1
					setCycle: Fwd
					moveSpeed: 0
					setMotion: MoveTo 186 69 self
				)
			)
			(7
				(roc hide:)
				(= cycles 10)
			)
			(8
				(roc show: setLoop: 3 xStep: 3 setMotion: MoveTo 241 83 self)
			)
			(9
				(roc hide:)
				(= cycles 5)
			)
			(10
				(roc
					show:
					setStep: 1 1
					setLoop: 4
					cel: 5
					x: 241
					y: 88
					moveSpeed: 1
					setMotion: MoveTo 282 94 self
				)
			)
			(11
				(roc setLoop: 5 x: 283 y: 95 cycleSpeed: 3 setCycle: End self)
			)
			(12
				(roc
					setLoop: 6
					cel: 0
					x: 285
					y: 105
					setCycle: Fwd
					setMotion: MoveTo 284 109 self
				)
			)
			(13
				(roc setCycle: CT 1 1 self)
			)
			(14
				(roc setMotion: 0)
				(= cycles 6)
			)
			(15
				(roc setCycle: CT 2 1 self)
			)
			(16
				(roc
					setCycle: Fwd
					setMotion: MoveTo (roc x:) (- (roc y:) 10) self
				)
			)
			(17
				(= cycles 1)
			)
			(18
				(roc setLoop: 7 cel: 0 setCycle: End self)
			)
			(19
				(roc
					setLoop: 8
					cel: 5
					x: (+ (roc x:) 8)
					setCycle: Fwd
					setMotion: MoveTo 330 (roc y:) self
				)
			)
			(20
				(= global103 0)
				(gCurRoom newRoom: 42)
			)
		)
	)
)

(instance roc of Actor
	(properties
		view 590
		signal 10240
	)
)

