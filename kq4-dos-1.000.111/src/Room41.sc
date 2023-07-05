;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room41 0
)

(local
	local0
	local1
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

(instance Room41 of Rm
	(properties
		picture 41
	)

	(method (init)
		(= north 35)
		(= south 32)
		(= east 31)
		(= west 40)
		(= horizon 80)
		(= gIndoors 0)
		(gEgo edgeHit: 0)
		(super init:)
		(self setRegions: 505 501 503 504) ; gfReg, waterReg, beachReg, Gull_Region
		(wave1
			view: 664
			loop: 0
			cel: 3
			posn: 150 126
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 1
			init:
		)
		(wave2
			view: 664
			loop: 1
			cel: 2
			posn: 112 166
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 1
			init:
		)
		(wave3
			view: 664
			loop: 2
			cel: 3
			posn: 37 176
			setPri: 0
			setCycle: Fwd
			ignoreActors:
			cycleSpeed: 1
			init:
		)
		(waves add: wave1 wave2 wave3)
		(wave1 setScript: waveActions_a)
		(switch gPrevRoomNum
			(38
				(gEgo x: 19 y: 98)
			)
			(35
				(cond
					((== (gEgo view:) 2)
						(gEgo posn: 117 107)
					)
					((== (gEgo view:) 5)
						(gEgo posn: 186 113)
					)
					((== (gEgo view:) 6)
						(gEgo posn: 186 113)
					)
					((== (gEgo view:) 7)
						(gEgo posn: 201 113)
					)
					((== (gEgo view:) 8)
						(gEgo posn: 237 113)
					)
					(else
						(gEgo posn: 182 113)
					)
				)
			)
			(31
				(gEgo posn: 318 110)
			)
			(32
				(gEgo x: 138 y: 188)
			)
			(40
				(gEgo posn: 1 (gEgo y:))
			)
		)
		(gEgo xStep: 2 yStep: 1 init:)
		((gEgo viewer:) doit:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (= local0 (gEgo onControl:)) $0040)
				(or (<= (gEgo heading:) 90) (>= (gEgo heading:) 270))
			)
			(gCurRoom newRoom: 35)
		)
		(if (& local0 $0010)
			(gCurRoom newRoom: 38)
		)
	)

	(method (dispose)
		(waves dispose:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(== (event type:) evSAID)
				(or
					(Said 'look/island')
					(Said 'look/around')
					(Said 'look/room')
					(Said 'look[<around][/!*]')
				)
			)
			(Print 41 0) ; "The beautiful blue ocean washes gently upon the shore of the magical island. Dominating the center of this island is a splendid ivory palace."
		)
	)
)

(instance waveActions_a of Script
	(properties
		name {waveActions}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local1 0)) (< local1 (waves size:)) ((++ local1))
					((View new:)
						view: ((waves at: local1) view:)
						loop: ((waves at: local1) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((waves at: local1) x:)
						y: ((waves at: local1) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local1 0)
				(self changeState: 1)
			)
			(1
				((waves at: local1) cel: 0 show: setCycle: End self)
			)
			(2
				((waves at: local1) hide:)
				(if (< local1 (- (waves size:) 1))
					(++ local1)
				else
					(= local1 0)
				)
				(waveActions_a changeState: 1)
			)
		)
	)
)

(instance waveActions_b of Script
	(properties
		name {waveActions}
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(for ((= local1 0)) (< local1 (waves size:)) ((++ local1))
					((View new:)
						view: ((waves at: local1) view:)
						loop: ((waves at: local1) loop:)
						cel: 0
						setPri: 0
						ignoreActors:
						x: ((waves at: local1) x:)
						y: ((waves at: local1) y:)
						init:
						addToPic:
						yourself:
					)
				)
				(= local1 0)
				(if global190
					(self changeState: 1)
				else
					(waves eachElementDo: #addToPic)
				)
			)
			(1
				((waves at: local1) cel: 0 show: setCycle: End self)
			)
			(2
				((waves at: local1) hide:)
				(if (< local1 (- (waves size:) 1))
					(++ local1)
				else
					(= local1 0)
				)
				(waveActions_b changeState: 1)
			)
		)
	)
)

