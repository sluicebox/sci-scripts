;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 608)
(include sci.sh)
(use Main)
(use n091)
(use ActorBody)
(use PFollow)
(use Orbit)
(use Motion)
(use System)

(public
	mouse 0
)

(local
	local0 = 1
	local1
)

(instance mouse of SActor
	(properties
		view 44
	)

	(method (onMe)
		(return 0)
	)

	(method (init &tmp [temp0 2])
		(self moveSpeed: (gEgo moveSpeed:) setCycle: Walk)
		(super init:)
		(cond
			((> argc 0)
				(self moveSpeed: 6 posn: (gPlace x:) (gPlace y:))
				(if (< gCurRoomNum 36)
					(self setMotion: Orbit gPlace 20 0 60 30)
				)
				(= local0 0)
			)
			((== gPrevRoomNum 45) ; mapRoom
				(if global172
					(self
						setCel: 0
						illegalBits: 0
						posn: (+ global115 20) global116
						setMotion: MoveTo global115 global116
					)
				)
				(self
					moveSpeed: (gEgo moveSpeed:)
					setMotion: PFollow gEgo 25
				)
			)
			((>= gCurRoomNum 36)
				(switch gCurRoomNum
					(42
						(self setScript: enterHouse)
					)
					(41
						(self
							setCel: 0
							illegalBits: 0
							posn: (+ global115 20) global116
							setMotion: MoveTo global115 global116
						)
					)
					(else
						(self hide:)
					)
				)
			)
			((== gPrevRoomNum 42)
				(self
					moveSpeed: (gEgo moveSpeed:)
					posn: (- (gEgo x:) 5) (+ (gEgo y:) 5)
					setMotion: PFollow gEgo 25
				)
			)
			(else
				(self
					moveSpeed: (gEgo moveSpeed:)
					posn: (+ (gEgo x:) 2) (+ (gEgo y:) 2)
					setMotion: PFollow gEgo 25
				)
			)
		)
		(if (< gCurRoomNum 36)
			(self setScript: wave)
			(= gWave wave)
		)
	)

	(method (put)
		((gGoals at: 1) egoHas: 0)
		(= local0 0)
		(cond
			((wave register:)
				(= local1 2)
			)
			((< gCurRoomNum 36)
				(= [global200 gCurRoomNum] view)
				(self moveSpeed: 6 setMotion: Orbit gPlace 20 0 60 30)
			)
			(else
				(proc91_1 (mouse view:))
				(self dispose:)
			)
		)
	)

	(method (get)
		(if (not local1)
			(= [global200 gCurRoomNum] 0)
		)
		((gGoals at: 1) egoHas: 1 egoSeen: 1)
		(if (not (wave register:))
			(self setMotion: PFollow gEgo 25)
			(= local0 1)
		else
			(= local1 1)
		)
	)

	(method (delete &tmp temp0)
		(= global129 0)
		(super delete:)
		(DisposeScript 608)
	)
)

(instance wave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 120 300))
			)
			(1
				(if
					(or
						(and local0 (not ((client mover:) onTarget:)))
						(gCurRoom script:)
					)
					(= state -1)
					(= cycles 1)
				else
					(cond
						((== gCurRoomNum 4) 0)
						((!= (DoAudio audPOSITION) -1) 0)
						(else
							(gSfx number: 596 play:)
						)
					)
					(= register (mouse cycleSpeed:))
					(mouse
						setMotion: 0
						loop: (+ (mouse loop:) 4)
						cycleSpeed: 12
						setCel: 0
						setCycle: End self
					)
				)
			)
			(2
				(mouse cycleSpeed: register setCycle: Walk)
				(= register 0)
				(if local0
					(mouse setMotion: PFollow gEgo 25)
				else
					(mouse setMotion: Orbit gPlace 20 0 60 30)
				)
				(switch local1
					(1
						(mouse get:)
					)
					(2
						(mouse put:)
					)
				)
				(= local1 0)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance enterHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mouse
					cel: 0
					illegalBits: 0
					posn: (- global115 15) (+ global116 45)
					setMotion: MoveTo (- global115 15) (+ global116 15) self
				)
			)
			(1
				(proc0_7 mouse gEgo)
				(self dispose:)
			)
		)
	)
)

