;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 604)
(include sci.sh)
(use Main)
(use n091)
(use ActorBody)
(use PFollow)
(use Orbit)
(use Motion)
(use System)

(public
	lamb 0
)

(instance lamb of SActor
	(properties
		view 47
	)

	(method (onMe)
		(return 0)
	)

	(method (init &tmp [temp0 2])
		(super init:)
		(self moveSpeed: 8 setCycle: Walk)
		(cond
			((> argc 0)
				(self moveSpeed: 8 posn: (gPlace x:) (gPlace y:))
				(if (< gCurRoomNum 36)
					(self setMotion: Orbit gPlace 20 0 60 30)
				)
			)
			((>= gCurRoomNum 36)
				(if (== gCurRoomNum 42)
					(self setScript: enterHouse)
				else
					(self hide:)
				)
			)
			((== gPrevRoomNum 45) ; mapRoom
				(if global172
					(self posn: (+ (gEgo x:) 4) (+ (gEgo y:) 4))
				)
				(self
					moveSpeed: (gEgo moveSpeed:)
					setMotion: PFollow gEgo 30
				)
			)
			(else
				(cond
					((and (== gCurRoomNum 21) (== gPrevRoomNum 44))
						(self posn: 190 121)
					)
					((== gPrevRoomNum 42)
						(self posn: (- (gEgo x:) 5) (+ (gEgo y:) 8))
					)
					(else
						(self posn: (+ (gEgo x:) 2) (+ (gEgo y:) 2))
					)
				)
				(self
					moveSpeed: (gEgo moveSpeed:)
					setMotion: PFollow gEgo 30
				)
			)
		)
	)

	(method (put)
		((gGoals at: (- view 43)) egoHas: 0)
		(if (>= gCurRoomNum 36)
			(proc91_1 (lamb view:))
			(self dispose:)
		else
			(= [global200 gCurRoomNum] view)
			(self
				moveSpeed: 8
				setCycle: Walk
				setMotion: Orbit gPlace 20 0 60 30
			)
		)
	)

	(method (get)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: (- view 43)) egoHas: 1 egoSeen: 1)
		(self moveSpeed: (gEgo moveSpeed:) setMotion: PFollow gEgo 30)
	)

	(method (delete)
		(= global129 0)
		(super delete:)
		(DisposeScript 604)
	)
)

(instance enterHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lamb
					cel: 0
					illegalBits: 0
					posn: (- global115 15) (+ global116 45)
					setMotion: MoveTo (- global115 15) (+ global116 15) self
				)
			)
			(1
				(proc0_7 lamb gEgo)
				(self dispose:)
			)
		)
	)
)

