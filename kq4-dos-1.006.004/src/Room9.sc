;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room9 0
)

(synonyms
	(pool water)
)

(local
	local0
	local1
)

(instance Room9 of Rm
	(properties
		picture 9
	)

	(method (init)
		(= north 3)
		(= south 15)
		(= east 10)
		(= west 8)
		(= horizon 75)
		(= gIndoors 0)
		(if (<= (gEgo y:) (+ horizon 1))
			(gEgo y: (+ horizon 2))
		)
		(if (< (gEgo x:) 93)
			(gEgo x: 93)
		)
		(super init:)
		(gEgo view: 2 init:)
		(if gNight
			(gCurRoom overlay: 109)
		)
		(self setRegions: 507 514) ; Woods_Region, regPan
		(if (not gNight)
			(if (< (Random 1 100) 50)
				(= local0 (Prop new:))
				(local0
					view: 342
					loop: 5
					cel: 2
					posn: 283 17
					setPri: 14
					setScript: bird1Actions
					init:
				)
			)
			(if (< (Random 1 100) 50)
				(= local1 (Prop new:))
				(local1
					view: 342
					loop: 4
					cel: 2
					posn: 58 30
					setPri: 14
					setScript: bird2Actions
					init:
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (gCast contains: global172)
			(= global211 global160)
			(= global212 global159)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'climb/boulder')
					(Print 9 0) ; "It's too difficult to climb while wearing that dress."
				)
				((Said 'look>')
					(cond
						((Said '/pool')
							(Print 9 1) ; "It's too far in the distance to see it clearly."
						)
						((Said '/boulder')
							(Print 9 2) ; "A large rock dominates the clearing."
						)
						((Said '/blossom')
							(Print 9 3) ; "There are flowers here and there."
						)
						((Said '[<around][/room]')
							(Print 9 4) ; "You have entered a shady wooded area, with birds calling from the many trees. You notice a pool in the distance to the north."
						)
					)
				)
			)
		)
	)
)

(instance bird1Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local0 setCycle: Fwd)
				(= seconds (Random 1 12))
			)
			(1
				(local0 setCycle: 0 cel: 0)
				(= seconds (Random 1 8))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance bird2Actions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 setCycle: Fwd)
				(= seconds (Random 1 12))
			)
			(1
				(local1 setCycle: 0 cel: 0)
				(= seconds (Random 1 8))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

