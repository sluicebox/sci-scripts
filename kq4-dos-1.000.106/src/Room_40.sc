;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room_40 0
)

(local
	local0
	local1
	local2
)

(instance Waves of List
	(properties)
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance Room_40 of Rm
	(properties
		name {Room 40}
		picture 40
	)

	(method (init)
		(= north 37)
		(= south 32)
		(= east 41)
		(= west 39)
		(= horizon 98)
		(= gIndoors 0)
		(super init:)
		(self setRegions: 505 501 503 504) ; gfReg, waterReg, beachReg, Gull_Region
		(gEgo edgeHit: 0)
		(= local1 (Prop new:))
		(= local2 (View new:))
		(wave1
			view: 664
			loop: 3
			cel: 0
			posn: 40 178
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			view: 664
			loop: 4
			cel: 2
			posn: 280 178
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(Waves add: wave1 wave2)
		(wave1 setScript: Wave_Actions)
		(local1
			view: 650
			loop: 2
			cel: 2
			posn: 61 85
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			init:
		)
		(local2
			name: {door}
			view: 613
			loop: 1
			cel: 0
			posn: 156 78
			setPri: 4
			init:
			addToPic:
		)
		(cond
			((== gPrevRoomNum 32) ; Room_32
				(gEgo x: 160 y: 188)
			)
			((== gPrevRoomNum 39)
				(gEgo x: 1 y: (gEgo y:))
			)
			((== gPrevRoomNum 41)
				(gEgo x: 318 y: (gEgo y:))
			)
			((== gPrevRoomNum 37) ; Room_37
				(gEgo x: 158 y: (+ horizon (gEgo yStep:) 1))
			)
		)
		(gEgo xStep: 2 yStep: 1 init:)
		((gEgo viewer:) doit:)
	)

	(method (dispose)
		(Waves dispose: delete:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evSAID) (Said 'look[<around][/room,island]'))
			(Print 40 0) ; "You have found yourself upon a most beautiful and exotic island. In the center of this island, a wondrous ivory palace towers. Behind you, the azure ocean washes gently upon the island's sparkling beach."
		)
	)
)

(instance Wave_Actions of Script
	(properties
		name {Wave Actions}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local0 0)) (< local0 (Waves size:)) ((++ local0))
					((View new:)
						view: ((Waves at: local0) view:)
						loop: ((Waves at: local0) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((Waves at: local0) x:)
						y: ((Waves at: local0) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local0 0)
				(if global190
					(self changeState: 1)
				else
					(Waves eachElementDo: #addToPic)
				)
			)
			(1
				((Waves at: local0) cel: 0 show: setCycle: End self)
			)
			(2
				((Waves at: local0) hide:)
				(if (< local0 (- (Waves size:) 1))
					(++ local0)
				else
					(= local0 0)
				)
				(Wave_Actions changeState: 1)
			)
		)
	)
)

