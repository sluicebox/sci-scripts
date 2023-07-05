;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use Interface)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	wallFlash 0
)

(local
	local0
)

(instance magicWall of Prop
	(properties
		view 117
	)
)

(instance wallFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (= local0 (gEgo looper:))
					(if (local0 oldCycler:)
						((local0 oldCycler:) dispose:)
						((gEgo looper:) oldCycler: 0)
						(gEgo moveSpeed: 0 setCycle: 0)
					)
					(if (== global116 1)
						(local0 turningDir: 0)
					else
						(local0 turnDir: 0 doingLooper: 0)
					)
					(gEgo looper: 0)
				)
				(gRmMusic number: (proc0_20 40) loop: 1 play:)
				(magicWall
					posn:
						(- (gEgo x:) (if (== global116 1) 20 else 10))
						(- (gEgo y:) 10)
					setCel: 0
					setPri: (gEgo priority:)
					init:
					setCycle: End
				)
				(gEgo
					view: 61
					looper: 0
					setLoop: (if (== global116 1) 1 else 0)
					cel: 0
					posn: (+ (gEgo x:) 6) (+ (gEgo y:) 2)
					cycleSpeed: 1
					setCycle: End self
				)
				(if (!= global116 1)
					(gEgo
						cycleSpeed: 0
						setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:)
					)
				)
			)
			(1
				(if global213
					(gRmMusic number: global213 loop: -1 play:)
				)
				(magicWall setCycle: Beg)
				(gEgo
					view: (if (== global116 1) 9 else 3)
					setLoop: 1
					cycleSpeed: 0
				)
				(if (== global116 1)
					(gEgo
						setCycle: Rev
						setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
					)
				else
					(= cycles 2)
				)
			)
			(2
				(DisposeScript 969)
				(gEgo setStep: 3 2 setCycle: Walk setLoop: -1 looper: local0)
				(if (not (IsFlag 319))
					(Print 205 0) ; "You were thrown back by a sorcerous barrier of great power. Yet there must be a way to pass it."
					(Print 205 1) ; "I suspect these five stones are a part of the riddle you must solve to breach the barrier."
				)
				(SetFlag 319)
				(magicWall dispose:)
				(= cycles 2)
			)
			(3
				(HandsOn)
				(gEgo setScript: 0)
				(DisposeScript 205)
			)
		)
	)
)

