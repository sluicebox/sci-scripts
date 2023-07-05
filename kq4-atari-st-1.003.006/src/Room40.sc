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
	Room40 0
)

(local
	local0
	local1
	local2
)

(instance waves of List
	(properties)
)

(instance wave1 of Prop
	(properties)
)

(instance wave2 of Prop
	(properties)
)

(instance Room40 of Rm
	(properties
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
			posn: 40 177
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			view: 664
			loop: 4
			cel: 2
			posn: 280 177
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(waves add: wave1 wave2)
		(wave1 setScript: waveActions)
		(local1
			isExtra: 1
			view: 650
			loop: 2
			cel: 2
			posn: 61 84
			setPri: 0
			ignoreActors:
			setCycle: Fwd
			init:
		)
		(local2 view: 613 loop: 1 cel: 0 posn: 156 77 setPri: 4 init: addToPic:)
		(cond
			((== gPrevRoomNum 32)
				(gEgo x: 160 y: 188)
			)
			((== gPrevRoomNum 39)
				(gEgo x: 1 y: (gEgo y:))
			)
			((== gPrevRoomNum 41)
				(gEgo x: 318 y: (gEgo y:))
			)
			((== gPrevRoomNum 37)
				(gEgo x: 158 y: (+ horizon (gEgo yStep:) 1))
			)
		)
		(gEgo xStep: 3 yStep: 2 init:)
		((gEgo viewer:) doit:)
	)

	(method (dispose)
		(waves dispose: delete:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evSAID) (Said 'look[<around][/room,island]'))
			(Print 40 0) ; "You have found yourself upon a most beautiful and exotic island. In the center of this island, a wondrous ivory palace towers. Behind you, the azure ocean washes gently upon the island's sparkling beach."
		)
	)
)

(instance waveActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local0 0)) (< local0 (waves size:)) ((++ local0))
					((View new:)
						view: ((waves at: local0) view:)
						loop: ((waves at: local0) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((waves at: local0) x:)
						y: ((waves at: local0) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local0 0)
				(if global223
					(self changeState: 1)
				else
					(waves eachElementDo: #addToPic)
				)
			)
			(1
				((waves at: local0) cel: 0 show: setCycle: End self)
			)
			(2
				((waves at: local0) hide:)
				(if (< local0 (- (waves size:) 1))
					(++ local0)
				else
					(= local0 0)
				)
				(waveActions changeState: 1)
			)
		)
	)
)

