;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 604)
(include sci.sh)
(use Main)
(use n096)
(use Avoid)
(use Orbit)
(use Motion)
(use Actor)
(use System)

(public
	lamb 0
)

(instance lamb of Act
	(properties
		view 47
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
				(self setCel: 0 illegalBits: 0 posn: temp0 temp1)
				(if (== gCurRoomNum 44)
					(self setPri: 14)
				else
					(self setMotion: MoveTo global115 global116)
				)
			)
			(else
				(if (and (== gCurRoomNum 21) (== gPrevRoomNum 44))
					(self posn: 190 121)
				else
					(self posn: (gEgo x:) (gEgo y:))
				)
				(self setMotion: NewFollow gEgo 30)
			)
		)
		(super init:)
	)

	(method (put)
		((gGoals at: (- view 43)) egoHas: 0)
		(if (>= gCurRoomNum 36)
			(relocateScript changeState: 0)
		else
			(= [global200 gCurRoomNum] view)
			(self setMotion: Orbit gPlace 20 0 60 30)
		)
	)

	(method (get)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: (- view 43)) egoHas: 1 egoSeen: 1)
		(self setMotion: NewFollow gEgo 30)
	)

	(method (delete)
		(= global129 0)
		(super delete:)
		(DisposeScript 604)
	)
)

(instance relocateScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc96_1 (lamb view:))
				(switch gCurRoomNum
					(39
						(lamb
							setMotion:
								MoveTo
								(+ (lamb x:) 10)
								(+ (lamb y:) 40)
								self
						)
					)
					(40
						(lamb setMotion: MoveTo (+ (lamb x:) 10) (lamb y:) self)
					)
					(else
						(lamb setMotion: MoveTo 200 144 self)
					)
				)
			)
			(1
				(lamb dispose:)
				(self dispose:)
			)
		)
	)
)

