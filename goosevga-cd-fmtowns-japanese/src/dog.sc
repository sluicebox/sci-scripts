;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 609)
(include sci.sh)
(use Main)
(use n096)
(use Avoid)
(use Orbit)
(use Motion)
(use Actor)
(use System)

(public
	dog 0
)

(local
	local0 = 1
	local1
)

(instance dog of Act
	(properties
		view 46
		signal 16384
		illegalBits $8004
	)

	(method (init &tmp temp0 temp1)
		(self
			moveSpeed: (gEgo moveSpeed:)
			setAvoider: (Avoid new:)
			setCycle: Walk
		)
		(cond
			((> argc 0)
				(self posn: (gPlace x:) (gPlace y:))
				(if (< gCurRoomNum 36)
					(self setMotion: Orbit gPlace 20 0 60 30)
				)
				(= local0 0)
			)
			((>= gCurRoomNum 36)
				(switch (gCurRoom roomToEdge: gPrevRoomNum)
					(3
						(= temp0 global115)
						(= temp1 (+ global116 20))
					)
					(2
						(= temp1 global116)
						(= temp0 (+ global115 20))
					)
					(else
						(= temp1 global116)
						(= temp0 global115)
					)
				)
				((self avoider:) offScreenOK: 1)
				(self
					illegalBits: 0
					posn: temp0 temp1
					setMotion: MoveTo global115 global116
				)
			)
			(else
				(self
					posn: (gEgo x:) (gEgo y:)
					setMotion: NewFollow gEgo 30
				)
			)
		)
		(super init:)
		(if (and (< gCurRoomNum 36) (!= gCurRoomNum 27))
			(wave changeState: 0)
		)
	)

	(method (put)
		((gGoals at: 3) egoHas: 0)
		(cond
			((and (< gCurRoomNum 36) (not (wave register:)))
				(= [global200 gCurRoomNum] view)
				(self setMotion: Orbit gPlace 20 0 60 30)
			)
			((< gCurRoomNum 36)
				(= local1 2)
			)
			(else
				(relocateScript changeState: 0)
			)
		)
		(= local0 0)
	)

	(method (get)
		(if (not local1)
			(= [global200 gCurRoomNum] 0)
		)
		((gGoals at: 3) egoHas: 1 egoSeen: 1)
		(if (not (wave register:))
			(self setMotion: NewFollow gEgo 30)
			(= local0 1)
		else
			(= local1 1)
		)
	)

	(method (doit)
		(wave doit:)
		(super doit:)
	)

	(method (delete &tmp temp0)
		(= global129 0)
		(super delete:)
		(if (= temp0 (wave register:))
			(temp0 dispose:)
		)
		(DisposeScript 609)
	)
)

(instance wave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(= register (dog mover:))
				(if (and local0 (not (and register (register onTarget:))))
					(-= state 2)
					(= cycles 1)
					(= register 0)
				else
					(dog
						mover: 0
						loop: (+ (dog loop:) 4)
						cycleSpeed: 3
						setCel: 0
						setCycle: End
					)
					(if local0
						(= cycles (Random 8 18))
					else
						(= cycles (Random 18 28))
					)
				)
			)
			(2
				(if (dog mover:)
					(dog setMotion: 0)
				)
				(dog mover: register cycleSpeed: 0 setCycle: Walk)
				(= register 0)
				(switch local1
					(1
						(dog get:)
					)
					(2
						(dog put:)
					)
				)
				(= local1 0)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance relocateScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc96_1 (dog view:))
				(switch gCurRoomNum
					(39
						(dog
							setMotion:
								MoveTo
								(+ (dog x:) 10)
								(+ (dog y:) 40)
								self
						)
					)
					(40
						(dog setMotion: MoveTo (+ (dog x:) 10) (dog y:) self)
					)
					(else
						(dog setMotion: MoveTo 200 144 self)
					)
				)
			)
			(1
				(dog dispose:)
				(self dispose:)
			)
		)
	)
)

