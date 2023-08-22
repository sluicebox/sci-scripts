;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	R13 0
)

(local
	local0
	local1
	local2
	local3
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance wave3 of Prop
	(properties)
)

(instance Wvs of List
	(properties)
)

(instance minBlock of Blk
	(properties
		top 115
		left 262
		bottom 121
		right 266
	)
)

(instance R13 of Rm
	(properties
		picture 13
	)

	(method (init)
		(= north 7)
		(= south 19)
		(= east 14)
		(= west 31)
		(= horizon 80)
		(= gIndoors 0)
		(if gNight
			(= picture 113)
		)
		(gEgo edgeHit: EDGE_NONE)
		(super init:)
		(wave1
			isExtra: 1
			view: 665
			loop: 3
			cel: 2
			posn: 133 92
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			isExtra: 1
			view: 665
			loop: 4
			cel: 3
			posn: 126 121
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave3
			isExtra: 1
			view: 665
			loop: 5
			cel: 1
			posn: 127 150
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(Wvs add: wave1 wave2 wave3)
		(wave1 setScript: WvA)
		(= local3 (+ (* (- global160 global213) 60) (- global159 global214)))
		(if (and ((Inv at: 9) ownedBy: 203) (>= local3 3)) ; Lute
			(= gMinstrelRoom (/ (= gMinstrelRoom (Random 1 30)) 10))
		)
		(if (== gMinstrelRoom 1)
			(= gMinstrelActor (Act new:))
			(gMinstrelActor
				name: {min}
				posn: 264 119
				view: 174
				loop: 2
				setCel: 0
				illegalBits: 0
				init:
			)
			(gEgo observeBlocks: minBlock)
		)
		(self setRegions: 501 516 503 504 506) ; waterReg, regMinstrel, beachReg, Gull_Region, meadReg
		(if (and (== global116 1) (not gNight))
			(= local1 (View new:))
			(local1 view: 534 setLoop: 0 setCel: 0 posn: 65 55 init: addToPic:)
		)
		(= local0 (Prop new:))
		(local0
			view: 625
			posn: 173 30
			setLoop: 1
			setCycle: Fwd
			cycleSpeed: 2
			init:
		)
		(if (== gPrevRoomNum 14) ; Room_14
			(= global105 0)
		)
		(switch global105
			(0
				(switch gPrevRoomNum
					(19
						(if (> (gEgo x:) 233)
							(gEgo x: 278 y: 188)
						else
							(gEgo x: 205 y: 188)
						)
					)
					(7
						(if (> (gEgo x:) 208)
							(gEgo x: 194 y: (+ horizon 2))
						else
							(gEgo posn: 148 (+ horizon 2))
						)
					)
					(14 ; Room_14
						(if (< (gEgo y:) horizon)
							(gEgo x: 318 y: (+ horizon 2))
						else
							(gEgo x: 318)
						)
					)
				)
			)
			(1
				(switch gPrevRoomNum
					(19
						(gEgo x: 88 y: 188)
					)
					(7
						(gEgo x: 133 y: (+ horizon 2))
					)
				)
			)
			(2
				(switch gPrevRoomNum
					(19
						(gEgo x: 88 y: 188)
					)
					(7
						(gEgo x: 124 y: (+ horizon 2))
					)
				)
			)
			(3
				(switch gPrevRoomNum
					(19
						(gEgo x: 45 y: 188)
					)
					(7
						(gEgo x: 108 y: (+ horizon 2))
					)
				)
			)
			(4
				(switch gPrevRoomNum
					(19
						(gEgo x: 16 y: 188)
					)
					(7
						(if (> (gEgo x:) 75)
							(gEgo x: 75 y: (+ horizon 2))
						else
							(gEgo y: (+ horizon (gEgo yStep:) 1))
						)
					)
					(31
						(if (<= (gEgo y:) horizon)
							(gEgo x: 1 y: (+ horizon 2))
						else
							(gEgo x: 1)
						)
					)
				)
			)
		)
		(gEgo init:)
	)

	(method (dispose)
		(Wvs dispose:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (gCast contains: gMinstrelActor)
			(= global213 global160)
			(= global214 global159)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '/grass')
					(Print 13 0) ; "A green meadowland, dotted with clumps of wildflowers, leads eastward."
				)
				((Said '/dock')
					(if (== global116 1)
						(Print 13 1) ; "You see someone sitting on the end of the pier."
					else
						(Print 13 2) ; "You see a shabby little house, with a pier, in the distance."
					)
				)
				((Said '/cottage')
					(Print 13 2) ; "You see a shabby little house, with a pier, in the distance."
				)
				((Said '/fisherman,man,woman,person')
					(cond
						((gCast contains: gMinstrelActor)
							(event claimed: 0)
						)
						((== global116 1)
							(Print 13 3) ; "You can't make out who it is."
						)
						(else
							(Print 13 4) ; "You don't see anyone at the moment."
						)
					)
				)
				((Said '[<around][/room]')
					(Print 13 5) ; "A sparkling, white-sand beach edges a vast blue ocean. Turning to the east, you see a lush flowery meadow."
				)
			)
		)
	)
)

(instance WvA of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local2 0)) (< local2 (Wvs size:)) ((++ local2))
					((View new:)
						view: ((Wvs at: local2) view:)
						loop: ((Wvs at: local2) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((Wvs at: local2) x:)
						y: ((Wvs at: local2) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local2 0)
				(self changeState: 1)
			)
			(1
				((Wvs at: local2) cel: 0 show: setCycle: End self)
			)
			(2
				((Wvs at: local2) hide:)
				(if (< local2 (- (Wvs size:) 1))
					(++ local2)
				else
					(= local2 0)
				)
				(WvA changeState: 1)
			)
		)
	)
)

