;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 812)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use System)

(instance controls of Controls ; UNUSED
	(properties)
)

(class StdRoom of Rm
	(properties
		tpX 160
		tpY 160
	)

	(method (init param1)
		(if (not (and script argc param1))
			(NormalEgo &rest)
			((gEgo cycler:) doit:)
			((gEgo _head:) showSelf:)
		)
		(cond
			((or script (and argc param1))
				(gEgo edgeHit: EDGE_NONE init:)
				(super init:)
			)
			((not ((User alterEgo:) edgeHit:))
				(gEgo x: tpX y: tpY init:)
				(self style: 100)
				(super init:)
			)
			(else
				(walkIn register: (gEgo edgeHit:))
				(super init:)
				(self setScript: walkIn)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 ((User alterEgo:) edgeHit:))
				(self setScript: walkOut 0 temp0)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(switch (= state newState)
			(0
				(HandsOff)
				(= temp5 25)
				(= temp4
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				(= temp0 (= temp2 (gEgo x:)))
				(= temp1 (= temp3 (gEgo y:)))
				(switch register
					(1
						(= temp1 (+ 189 temp5))
					)
					(3
						(= temp1 (- temp3 2))
					)
					(2
						(= temp0 (- 0 temp4))
					)
					(4
						(= temp0 (+ 319 temp4))
					)
				)
				(gEgo
					edgeHit: EDGE_NONE
					posn: temp0 temp1
					ignoreActors: 1
					init:
					setMotion: MoveTo temp2 temp3 self
				)
			)
			(1
				(HandsOn)
				(gEgo ignoreActors: 0)
				(client setScript: 0)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(switch register
					(1
						(-= temp1 10)
					)
					(3
						(+= temp1 20)
					)
					(2
						(+= temp0 17)
					)
					(4
						(-= temp0 17)
					)
				)
				(HandsOff)
				(gEgo ignoreActors: 1 setMotion: MoveTo temp0 temp1 self)
			)
			(1
				(client setScript: 0)
				(gCurRoom newRoom: (gCurRoom edgeToRoom: register))
			)
		)
	)
)

