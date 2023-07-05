;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 387)
(include sci.sh)
(use Main)
(use Avoid)
(use Motion)
(use System)

(public
	jWalk 0
)

(instance jWalk of Script
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 985)
		(DisposeScript 387)
	)

	(method (doit)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 7)
			)
			(1
				(HandsOff)
				(global373
					setCycle: Walk
					setMotion: MoveTo 305 55 self
					setAvoider: ((Avoid new:) offScreenOK: 1)
					init:
				)
				(if (gEgo inRect: 252 117 312 131)
					(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 20))
				)
				(if (gEgo inRect: 295 50 320 60)
					(gEgo setMotion: MoveTo (- (gEgo x:) 15) (gEgo y:))
				)
			)
			(2
				(HandsOff)
				(global373 setMotion: MoveTo 302 124 self)
			)
			(3
				(global373 setMotion: MoveTo 270 123 self)
			)
			(4
				(global131 number: 43 loop: 1 priority: 5 play:)
				(gCellar setCycle: End self)
			)
			(5
				(global373
					illegalBits: 0
					setPri: 8
					setMotion: MoveTo 240 122 self
				)
			)
			(6
				(global373 setMotion: MoveTo 219 129 self)
			)
			(7
				(global373 hide:)
				(gCellar setCycle: Beg self)
				(global131 number: 44 loop: 1 priority: 5 play:)
			)
			(8
				(global373 dispose:)
				(gCellar stopUpd:)
				(HandsOn)
				(= global155 17)
				(client setScript: 0)
			)
		)
	)
)

