;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 165)
(include sci.sh)
(use Main)
(use n117)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	mercenary 0
)

(local
	[local0 7] = [56 58 61 62 59 57 -1]
)

(instance mercenary of Act
	(properties
		y 175
		view 333
		illegalBits 0
		xStep 4
	)

	(method (init)
		(super init:)
		(self setCycle: Walk setScript: mercenaryActions)
	)

	(method (doit)
		(super doit:)
		(if (& (self signal:) $0400)
			(gEgo posn: (gEgo x:) (- (gEgo y:) 4))
		)
	)

	(method (delete)
		(super delete:)
		(DisposeScript 165)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if
			(or
				(event claimed:)
				(and
					(!= (event type:) evSAID)
					(not
						(and
							(== (event type:) evMOUSEBUTTON)
							(& (event modifiers:) emSHIFT)
						)
					)
				)
			)
			(return)
		)
		(if (& (self signal:) $0080)
			(return)
		)
		(= temp0
			(or
				(< (= temp1 (gEgo distanceTo: self)) 40)
				(and (>= (gEgo y:) 165) (< temp1 120))
			)
		)
		(cond
			(
				(or
					(Said 'look/mercenary,guard')
					(MousedOn self event)
					(and temp0 (Said 'look/man'))
				)
				(Face gEgo self)
				(Print 165 0) ; "The city guard does not look friendly."
			)
			((Said 'bribe/guard')
				(Print 165 1) ; "Do so, if you think it wise."
			)
			((Said 'give/coin')
				(cond
					((or (<= (gEgo y:) 165) (> temp1 60))
						(event claimed: 0)
					)
					((not (DoPurse)) 0)
					(else
						(proc0_18)
						(Print 165 2) ; "Do not trifle with these city guards. They would as soon kill you as look at you."
					)
				)
			)
			(
				(or
					(Said 'talk,ask,attack/man,mercenary,guard')
					(and temp0 (Said 'give,buy'))
				)
				(Face gEgo self)
				(Print 165 2) ; "Do not trifle with these city guards. They would as soon kill you as look at you."
			)
		)
	)
)

(instance mercenaryActions of Script
	(properties)

	(method (dispose)
		(= global160 (mercenary x:))
		(if (and (== gCurRoomNum 61) (== state 1))
			(++ global159)
			(= global161 330)
			(= global157 62)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (= global157 [local0 global159]) -1)
					(mercenary
						posn: global160 (mercenary y:)
						setMotion: MoveTo global161 175 self
					)
					(if (== global157 gCurRoomNum)
						(mercenary show: ignoreActors: 0)
					else
						(mercenary hide: ignoreActors: 1)
					)
				else
					(= global159 -1)
					(mercenary dispose:)
				)
			)
			(1
				(if (== global161 150)
					(mercenary loop: 2 setMotion: MoveTo 150 250 self)
				else
					(= cycles 1)
				)
			)
			(2
				(switch [local0 (++ global159)]
					(61
						(= global160 0)
						(= global161 150)
					)
					(62
						(= global160 150)
						(= global161 330)
						(mercenary y: 250)
					)
					(else
						(= global160 -10)
						(= global161 330)
						(mercenary y: 175)
					)
				)
				(self changeState: 0)
			)
		)
	)
)

