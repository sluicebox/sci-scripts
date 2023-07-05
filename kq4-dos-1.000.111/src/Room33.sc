;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	Room33 0
)

(local
	local0
	local1
)

(instance Room33 of Rm
	(properties
		picture 33
	)

	(method (init)
		(= north 31)
		(= south 36)
		(= east 34)
		(= west 31)
		(= horizon 80)
		(= gIndoors 0)
		(= global108 horizon)
		(gEgo edgeHit: 0)
		(super init:)
		(= local0 (Prop new:))
		(= local1 (Prop new:))
		(local0
			isExtra: 1
			view: 661
			loop: 0
			cel: 1
			posn: 139 185
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(local1
			isExtra: 1
			view: 661
			loop: 1
			cel: 3
			posn: 227 133
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 2
			init:
		)
		(switch gPrevRoomNum
			(36 ; Room_36
				(gEgo x: 246 y: 187)
			)
			(39
				(cond
					((== (gEgo view:) 2)
						(gEgo posn: 138 188)
					)
					((== (gEgo view:) 5)
						(gEgo posn: 113 187)
					)
					((== (gEgo view:) 6)
						(gEgo posn: 84 187)
					)
					((== (gEgo view:) 7)
						(gEgo posn: 58 187)
					)
					(else
						(gEgo posn: 20 188)
					)
				)
				(Animate (gCast elements:) 0)
			)
			(34
				(gEgo posn: 317 (gEgo y:))
			)
			(31
				(if (< (gEgo y:) horizon)
					(gEgo posn: (gEgo x:) (+ horizon 2))
				else
					(gEgo posn: 2 (gEgo y:))
				)
			)
		)
		(gEgo xStep: 2 yStep: 1 init:)
		(self setRegions: 505 501 503 504) ; gfReg, waterReg, beachReg, Gull_Region
	)

	(method (doit)
		(cond
			((>= (gEgo y:) 189)
				(if (< (gEgo x:) 160)
					(= gNewRoomNum 39)
					(Animate (gCast elements:) 0)
				else
					(Animate (gCast elements:) 0)
					(= gNewRoomNum 36) ; Room_36
				)
			)
			((>= (gEgo x:) 319)
				(Animate (gCast elements:) 0)
				(= gNewRoomNum 34)
			)
			((<= (gEgo x:) 0)
				(Animate (gCast elements:) 0)
				(= gNewRoomNum 31)
			)
			((<= (gEgo y:) horizon)
				(Animate (gCast elements:) 0)
				(= gNewRoomNum 31)
			)
		)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if
			(and
				(== (event type:) evSAID)
				(or
					(Said 'look/around')
					(Said 'look/island')
					(Said 'look/room')
					(Said 'look[<around][/!*]')
				)
			)
			(Print 33 0) ; "You see the beach of a beautiful enchanted island. Behind you, an ivory palace rises majestically. A luxuriant garden encircles the magnificent palace."
		)
	)
)

