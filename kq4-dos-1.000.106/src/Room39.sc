;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room39 0
)

(local
	local0
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

(instance wave3 of Prop
	(properties)
)

(instance Room39 of Rm
	(properties
		picture 39
	)

	(method (init)
		(= south 32)
		(= east 40)
		(= west 31)
		(= horizon 94)
		(= gIndoors 0)
		(gEgo edgeHit: EDGE_NONE)
		(super init:)
		(wave1
			isExtra: 1
			view: 663
			loop: 3
			cel: 3
			posn: 146 113
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			isExtra: 1
			view: 663
			loop: 4
			cel: 3
			posn: 214 144
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave3
			isExtra: 1
			view: 663
			loop: 5
			cel: 1
			posn: 275 170
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(waves add: wave1 wave2 wave3)
		(wave1 setScript: waveActions)
		(switch gPrevRoomNum
			(37 ; Room_37
				(gEgo x: 307 y: 100)
			)
			(36 ; Room_36
				(gEgo x: 302 y: 100)
			)
			(32 ; Room_32
				(gEgo x: 160 y: 188)
			)
			(31
				(gEgo posn: 40 120)
			)
			(33
				(cond
					((== (gEgo view:) 2)
						(gEgo posn: 188 (+ horizon 2))
					)
					((== (gEgo view:) 8)
						(gEgo posn: 95 (+ horizon 2))
					)
					((== (gEgo view:) 6)
						(gEgo posn: 165 (+ horizon 2))
					)
					((== (gEgo view:) 5)
						(gEgo posn: 175 (+ horizon 2))
					)
					((== (gEgo view:) 7)
						(gEgo posn: 135 (+ horizon 2))
					)
					(else
						(gEgo posn: 161 (+ horizon 2))
					)
				)
			)
			(40 ; Room_40
				(gEgo posn: 318 (gEgo y:))
			)
		)
		(gEgo xStep: 2 yStep: 1 init:)
		(self setRegions: 505 501 503 504) ; gfReg, waterReg, beachReg, Gull_Region
	)

	(method (doit)
		(cond
			((>= (gEgo y:) 189)
				(= gNewRoomNum 32) ; Room_32
			)
			((>= (gEgo x:) 319)
				(= gNewRoomNum 40) ; Room_40
			)
			((<= (gEgo x:) 0)
				(= gNewRoomNum 31)
			)
			((<= (gEgo y:) horizon)
				(if (> (gEgo x:) 292)
					(= gNewRoomNum 36) ; Room_36
				else
					(= gNewRoomNum 33)
				)
			)
		)
	)

	(method (dispose)
		(waves dispose: delete:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evSAID) (Said 'look[<around][/room,island]'))
			(Print 39 0) ; "You see a sparkling, sand beach of an exotic island. Before you, in the center of the island, a wonderful ivory palace rises. A lovely garden surrounds the palace."
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
				(self changeState: 1)
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

