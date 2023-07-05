;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 386)
(include sci.sh)
(use Main)
(use Interface)
(use Avoid)
(use Motion)
(use System)

(public
	jDog 0
)

(instance jDog of Script
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 985)
		(DisposeScript 386)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== state 3) (== (global373 cel:) 4))
			(global375 show: ignoreActors: 1 stopUpd:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (!= gPrevRoomNum 35)
					(global376 setCycle: End self)
					(global131 number: 43 loop: 1 priority: 5 play:)
				else
					(= cycles 1)
				)
			)
			(1
				(global373
					setCycle: Walk
					setAvoider: ((Avoid new:) offScreenOK: 1)
				)
				(if (!= gPrevRoomNum 35)
					(global373 setMotion: MoveTo 196 141 self init:)
				else
					(= cycles 1)
				)
			)
			(2
				(if (!= gPrevRoomNum 35)
					(global376 setCycle: Beg)
					(global131 number: 44 loop: 1 priority: 5 play:)
				)
				(Print 386 0 #at 175 15 #font 4 #dispose) ; "Come and get it!"
				(global373 setMotion: MoveTo 216 161 self)
			)
			(3
				(cls)
				(global376 stopUpd:)
				(global373 view: 445 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(global373 view: 440 setMotion: MoveTo 140 248 setCycle: Walk)
				(global374
					setCycle: Walk
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo 224 159 self
				)
			)
			(5
				(global374 view: 526 setLoop: 0 cel: 0 setCycle: End self)
			)
			(6
				(global374 setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(7
				(global374
					setLoop: 0
					cel: (- (NumCels global374) 1)
					setPri: 11
					setCycle: Beg self
				)
			)
			(8
				(global374
					view: 520
					setLoop: -1
					setCycle: Walk
					illegalBits: 0
					setMotion: MoveTo 160 156 self
				)
				(global373 dispose:)
			)
			(9
				(HandsOn)
				(= [gCycleTimers 2] 1800)
				(= global162 1)
				(= global155 2)
				(global375 ignoreActors: 0)
				(= global190 0)
				(client setScript: 0)
			)
		)
	)
)

