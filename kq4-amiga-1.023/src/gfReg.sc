;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 505)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	gfReg 0
)

(synonyms
	(ocean seawater ocean)
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance gfReg of Rgn
	(properties)

	(method (init)
		(peacockNoise init:)
		(super init:)
		(switch gCurRoomNum
			(33
				(= local1 198)
				(= local0 155)
			)
			(34
				(= local1 172)
				(= local0 133)
			)
			(35
				(= local1 126)
				(= local0 144)
			)
			(39
				(= local1 224)
				(= local0 113)
			)
			(40
				(= local1 241)
				(= local0 117)
			)
			(41
				(= local1 102)
				(= local0 109)
			)
		)
		(if (< (Random 1 100) 75)
			(= local2 (+ (Random 1 3) 32))
		else
			(= local2 (+ (Random 1 3) 38))
		)
		(if ((Inv at: 8) ownedBy: 888) ; Peacock_Feather
			((Inv at: 8) moveTo: local2) ; Peacock_Feather
		)
		(if ((Inv at: 8) ownedBy: gCurRoomNum) ; Peacock_Feather
			(= local3 (View new:))
			(local3 view: 514 posn: local1 local0 loop: 0 cel: 0 init: stopUpd:)
		)
		(if (and (<= (Random 1 100) 40) (> local1 0))
			(Load rsVIEW 337)
			(= local4 (Act new:))
			(local4
				view: 336
				moveSpeed: 1
				cycleSpeed: 1
				setCycle: Walk
				setMotion: Wander 30000
				illegalBits: -2
				posn: local1 (- local0 4)
				init:
				setScript: peacockActions
				setStep: 1 1
			)
		)
	)

	(method (doit)
		(if
			(and
				(gCast contains: local4)
				(not (local4 inRect: -10 50 329 199))
			)
			(local4 dispose:)
		)
	)

	(method (dispose)
		(gTimers eachElementDo: #dispose 84)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/beach,beach')
							(if ((Inv at: 8) ownedBy: gCurRoomNum) ; Peacock_Feather
								(Print 505 0) ; "Something catches your eye! Why, it's a beautiful peacock feather!"
							else
								(Print 505 1) ; "The ocean water laps gently upon the sandy beach of the island."
							)
						)
						((Said '/feather')
							(cond
								((gCast contains: local3)
									(Print 505 2) ; "You see a beautiful peacock feather lying upon the beach."
								)
								((gEgo has: 8) ; Peacock_Feather
									((Inv at: 8) showSelf:) ; Peacock_Feather
								)
								(else
									(Print 505 3) ; "You don't see one here."
								)
							)
						)
						((Said '/tamir')
							(Print 505 4) ; "You see Tamir in the distance."
						)
						((Said '<in,under/ocean,water')
							(if (!= (gEgo view:) 2)
								(Print 505 5) ; "You look under the water, and see nothing but...more water!"
							else
								(Print 505 6) ; "You're not in the water."
							)
						)
						((Said '/ocean,water')
							(Print 505 7) ; "The wide blue ocean surrounds this island. Off to the east, you can barely see the mainland of Tamir."
						)
						((or (Said '/dirt') (Said '<down'))
							(cond
								(((Inv at: 8) ownedBy: gCurRoomNum) ; Peacock_Feather
									(Print 505 0) ; "Something catches your eye! Why, it's a beautiful peacock feather!"
								)
								((and (>= gCurRoomNum 36) (<= gCurRoomNum 38)) ; Room_36
									(Print 505 8) ; "You see nothing but grass and shrubs."
								)
								(else
									(Print 505 9) ; "You see nothing but sandy soil."
								)
							)
						)
						((Said '/boulder')
							(Print 505 10) ; "You don't see many rocks."
						)
						((Said '/forest')
							(Print 505 11) ; "There are many beautiful trees in this garden setting."
						)
						((Said '/grass')
							(Print 505 12) ; "Lush green grass carpets this magical island."
						)
						((Said '/bush')
							(Print 505 13) ; "A low hedge borders the lovely garden."
						)
						((Said '/flora')
							(Print 505 14) ; "The foliage is lush and green."
						)
						((Said '/blossom')
							(Print 505 15) ; "Beautiful flowers seem to flourish here."
						)
						((Said '/garden')
							(Print 505 16) ; "A splendid garden surrounds the magnificent ivory palace."
						)
						((Said '/castle')
							(Print 505 17) ; "An enchanting ivory palace, encircled by a luxuriant garden, rises from the center of this secluded island."
						)
						((Said '/peacock')
							(if (gCast contains: local4)
								(Print 505 18) ; "A majestic peacock, with a beautiful tail, struts by."
							else
								(Print 505 19) ; "You don't see one."
							)
						)
						((Said '/bird')
							(if (gCast contains: local4)
								(Print 505 18) ; "A majestic peacock, with a beautiful tail, struts by."
							else
								(event claimed: 0)
							)
						)
					)
				)
				((Said 'climb/forest')
					(Print 505 20) ; "It is difficult to climb trees while wearing that dress!"
				)
				((Said 'talk>')
					(cond
						((Said '/peacock')
							(if (gCast contains: local4)
								(Print 505 21) ; "Peacocks don't talk!"
							else
								(Print 505 19) ; "You don't see one."
							)
						)
						((Said '/bird')
							(if (gCast contains: local4)
								(Print 505 21) ; "Peacocks don't talk!"
							else
								(event claimed: 0)
							)
						)
					)
				)
				((Said 'get/feather')
					(cond
						(((Inv at: 8) ownedBy: gCurRoomNum) ; Peacock_Feather
							(if (< (gEgo distanceTo: local3) 15)
								(gEgo get: 8) ; Peacock_Feather
								(gGame changeScore: 2)
								(gEgo setScript: getFeather)
							else
								(Print 800 1) ; "You're not close enough."
							)
						)
						((gEgo has: 8) ; Peacock_Feather
							(event claimed: 0)
						)
						(else
							(Print 505 22) ; "You might find one lying around here somewhere."
						)
					)
				)
				((Said 'get/blossom')
					(Print 505 23) ; "It would waste your precious time to stop and pick flowers."
				)
				((Said 'get,capture/peacock')
					(if (gCast contains: local4)
						(Print 505 24) ; "You don't need the peacock."
					else
						(Print 505 3) ; "You don't see one here."
					)
				)
				((Said 'get,capture/bird,parrot')
					(Print 505 25) ; "That wouldn't accomplish anything."
				)
				((Said 'kiss')
					(if (gCast contains: local4)
						(Print 505 26) ; "There's no need for that."
					else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance getFeather of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 21)
				(LookAt gEgo local3)
				(gEgo setCycle: End self)
			)
			(1
				(gEgo setCycle: Beg self)
				(= global182 1)
				(local3 dispose:)
			)
			(2
				(gEgo view: 2 setScript: 0 setCycle: Walk)
				(HandsOn)
			)
		)
	)
)

(instance peacockActions of Script
	(properties)

	(method (doit)
		(switch (Random 1 100)
			(1
				(peacockNoise play:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 4) setReal: self (Random 10 40)) ; timer1
			)
			(1
				(local4
					view: 337
					setLoop: 0
					setMotion: 0
					cel: 0
					setCycle: End self
				)
			)
			(2
				((ScriptID 0 4) setReal: self 4) ; timer1
			)
			(3
				(local4 setCycle: Beg self)
			)
			(4
				(local4
					view: 336
					setLoop: -1
					setCycle: Walk
					setMotion: Wander 30000
				)
				(self changeState: 0)
			)
		)
	)
)

(instance peacockNoise of Sound
	(properties
		number 602
		priority 15
	)
)

