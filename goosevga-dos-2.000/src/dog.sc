;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 609)
(include sci.sh)
(use Main)
(use n096)
(use Avd)
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

(instance dog of SActor
	(properties
		view 46
		signal 16384
		cycleSpeed 6
		illegalBits -32764
	)

	(method (onMe)
		(return 0)
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(self
			moveSpeed: (gEgo moveSpeed:)
			setAvoider: (Avd new:)
			setCycle: Walk
		)
		(cond
			((> argc 0)
				(self moveSpeed: 4 posn: (gPlace x:) (gPlace y:))
				(if (< gCurRoomNum 36)
					(self setMotion: Orbit gPlace 20 0 60 30)
				)
				(= local0 0)
			)
			((>= gCurRoomNum 36)
				(if (== gCurRoomNum 42)
					(self
						setCel: 0
						illegalBits: 0
						posn: global115 (+ global116 20)
						setMotion: MoveTo global115 global116
					)
					((self avoider:) offScreenOK: 1)
				else
					(self hide:)
				)
			)
			(else
				(switch (gCurRoom roomToEdge: gPrevRoomNum)
					(3
						(= temp0 (gEgo x:))
						(= temp1 (+ (gEgo y:) 20))
					)
					(2
						(= temp0 (+ (gEgo x:) 15))
						(= temp1 (gEgo y:))
					)
					(else
						(= temp0 (- (gEgo x:) 15))
						(= temp1 (gEgo y:))
					)
				)
				(self
					moveSpeed: (gEgo moveSpeed:)
					posn: temp0 temp1
					setMotion: NewFollow gEgo 30
				)
				((self avoider:) offScreenOK: 1)
			)
		)
		(if (and (< gCurRoomNum 36) (!= gCurRoomNum 27))
			(self setScript: wave)
			(= gWave wave)
		)
	)

	(method (put)
		((gGoals at: 3) egoHas: 0)
		(= local0 0)
		(cond
			((and (< gCurRoomNum 36) (not (wave register:)))
				(= [global200 gCurRoomNum] view)
				(self moveSpeed: 6 setMotion: Orbit gPlace 20 0 60 30)
			)
			((< gCurRoomNum 36)
				(= local1 2)
			)
			(else
				(proc96_1 (dog view:))
				(self dispose:)
			)
		)
	)

	(method (get)
		(if (not local1)
			(= [global200 gCurRoomNum] 0)
		)
		((gGoals at: 3) egoHas: 1 egoSeen: 1)
		(if (not (wave register:))
			(self
				moveSpeed: (gEgo moveSpeed:)
				setMotion: NewFollow gEgo 30
			)
			(= local0 1)
		else
			(= local1 1)
		)
	)

	(method (doit)
		(if
			(and
				(IsObject avoider)
				(avoider offScreenOK:)
				(< 0 x 257)
				(< 0 y 155)
				(not global166)
			)
			(avoider offScreenOK: 0)
		)
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
				(dog mover: register setCycle: Walk)
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

