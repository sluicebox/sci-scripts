;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 604)
(include sci.sh)
(use Main)
(use n096)
(use Avd)
(use Orbit)
(use Motion)
(use Actor)

(public
	lamb 0
)

(instance lamb of SActor
	(properties
		view 47
		signal 16384
		illegalBits -32764
	)

	(method (onMe)
		(return 0)
	)

	(method (init &tmp [temp0 2])
		(self
			moveSpeed: (gEgo moveSpeed:)
			setAvoider: (Avd new:)
			setCycle: Walk
		)
		(cond
			((> argc 0)
				(self moveSpeed: 2 posn: (gPlace x:) (gPlace y:))
				(if (< gCurRoomNum 36)
					(self setMotion: Orbit gPlace 20 0 60 30)
				)
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
				(if (and (== gCurRoomNum 21) (== gPrevRoomNum 44))
					(self posn: 190 121)
				else
					(self posn: (gEgo x:) (gEgo y:))
				)
				(self
					moveSpeed: (gEgo moveSpeed:)
					setMotion: NewFollow gEgo 30
				)
			)
		)
		(super init:)
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
		(super doit: &rest)
	)

	(method (put)
		((gGoals at: (- view 43)) egoHas: 0)
		(if (>= gCurRoomNum 36)
			(proc96_1 (lamb view:))
			(self dispose:)
		else
			(= [global200 gCurRoomNum] view)
			(self moveSpeed: 2 setMotion: Orbit gPlace 20 0 60 30)
		)
	)

	(method (get)
		(= [global200 gCurRoomNum] 0)
		((gGoals at: (- view 43)) egoHas: 1 egoSeen: 1)
		(self moveSpeed: (gEgo moveSpeed:) setMotion: NewFollow gEgo 30)
	)

	(method (delete)
		(= global129 0)
		(super delete:)
		(DisposeScript 604)
	)
)

