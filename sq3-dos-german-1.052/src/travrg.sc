;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	travrg 0
)

(instance travrg of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 51)
		(Load rsSOUND 33)
		(self keep: 0)
		(if global594
			(= global175 6)
		)
		(super init:)
	)

	(method (doit &tmp [temp0 50])
		(if global219
			(-- global220)
			(-- global175)
		)
		(if (== global175 15)
			(Print 701 0) ; "WARNING: Short range fighters approaching from rear. Weapons lock-on detected."
		)
		(if (and (== global175 1) (!= gCurRoomNum 18))
			(= global175 0)
			(if (== gCurRoomNum 14)
				(self setScript: Attack1)
			else
				(self setScript: Attack2)
			)
		)
		(if (and (== global220 1) global209 (not global178))
			(cond
				((== global209 2)
					(= global220 180)
				)
				((== global209 3)
					(= global220 90)
				)
				(else
					(= global220 4)
				)
			)
			(+= global161 global165)
			(+= global162 global166)
			(if (and (== global161 global163) (== global162 global164))
				(= global220 0)
				(= global167 1)
			else
				(if (== global161 12)
					(= global214 (* global161 global162))
				else
					(= global214 (+ (* (- global162 1) 12) global161))
				)
				(if (> global163 global161)
					(= global165 1)
				)
				(if (< global163 global161)
					(= global165 -1)
				)
				(if (== global163 global161)
					(= global165 0)
				)
				(if (> global164 global162)
					(= global166 1)
				)
				(if (< global164 global162)
					(= global166 -1)
				)
				(if (== global164 global162)
					(= global166 0)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
	)
)

(instance Attack1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global594 2)
					(self changeState: 4)
				else
					(ShakeScreen 5 ssFULL_SHAKE)
					(= global594 1)
					(if
						(or
							(not (-- global174))
							(== global205 1)
							(== global205 0)
						)
						(client setScript: BlowUp)
					)
					(zipShip
						posn: 128 69
						setLoop: 2
						cel: 0
						setPri: 6
						illegalBits: 0
						init:
						cycleSpeed: 0
						setCycle: End self
					)
				)
			)
			(1
				(zipShip cel: 0 setCycle: End self)
			)
			(2
				(zipShip cel: 0 setCycle: End self)
			)
			(3
				(zipShip cel: 0 setLoop: 3 posn: 142 79 setCycle: End self)
			)
			(4
				(= global594 2)
				(= seconds 4)
			)
			(5
				(if (or (== global594 2) (not (gCast contains: zipShip)))
					(zipShip init:)
				)
				(zipShip
					cel: 0
					setLoop: 0
					posn: 185 72
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(6
				(zipShip cel: 0 setLoop: 1 posn: 195 80 setCycle: End self)
			)
			(7
				(zipShip cel: 0 setCycle: End self)
			)
			(8
				(zipShip setLoop: 4 cel: 0 setCycle: End self)
			)
			(9
				(zipShip dispose:)
				(RedrawCast)
				(ShakeScreen 5 ssFULL_SHAKE)
				(if (or (not (-- global174)) (== global205 2) (== global205 0))
					(client setScript: BlowUp)
				)
				(= global594 0)
				(= global175 10)
			)
		)
	)
)

(instance Attack2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global594 2)
					(self changeState: 1)
				else
					(ShakeScreen 5 ssFULL_SHAKE)
					(= global594 1)
					(if
						(or
							(not (-- global174))
							(== global205 1)
							(== global205 0)
						)
						(gCurRoom setScript: BlowUp)
					)
					(= cycles 1)
				)
			)
			(1
				(= global594 2)
				(= seconds 6)
			)
			(2
				(ShakeScreen 5 ssFULL_SHAKE)
				(if (or (not (-- global174)) (== global205 2) (== global205 0))
					(gCurRoom setScript: BlowUp)
				)
				(= global175 10)
				(= global594 0)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance BlowUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShakeScreen 20 ssFULL_SHAKE)
				(gCast eachElementDo: #dispose)
				(cls)
				(gCurRoom drawPic: 121)
				(if (not global174)
					(PrintSplit 701 1) ; "With your shield depleted, the final hit shreds the side of your ship. In the sudden vacuum, your body fluids expand beyond the capacity of your tissues. Your desicated body will drift forever, a grim testament to your blundering stupidity."
				else
					(PrintSplit 701 2) ; "Having the correct shield up could have prevented this!  The final shot shreds the side of your ship. In the sudden vacuum, your body fluids expand beyond the capacity of your tissues. Your desicated body will drift forever, a grim testament to your blundering stupidity."
				)
				(EgoDead 0 0 4 5)
			)
		)
	)
)

(instance zipShip of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 51 ignoreActors: 1 setPri: 6 illegalBits: 0)
	)
)

(instance boom of Sound ; UNUSED
	(properties
		number 33
		priority 2
	)
)

