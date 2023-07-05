;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room35 0
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

(instance Room35 of Rm
	(properties
		picture 35
	)

	(method (init)
		(if gNight
			(= picture 135)
		)
		(= east (= north 31))
		(= west 34)
		(= horizon 80)
		(= gIndoors 0)
		(= global108 horizon)
		(gEgo edgeHit: 0)
		(super init:)
		(self setRegions: 505 501 503 504) ; gfReg, waterReg, beachReg, Gull_Region
		(wave1
			isExtra: 1
			view: 662
			loop: 0
			cel: 0
			posn: 110 123
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			isExtra: 1
			view: 662
			loop: 1
			cel: 0
			posn: 166 142
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave3
			isExtra: 1
			view: 662
			loop: 2
			cel: 0
			posn: 228 185
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(waves add: wave1 wave2 wave3)
		(wave1 setScript: waveActions)
		(switch gPrevRoomNum
			(38
				(gEgo x: 93 y: 187)
			)
			(41
				(cond
					((== (gEgo view:) 5)
						(gEgo x: 236 y: 187)
					)
					((== (gEgo view:) 6)
						(gEgo x: 266 y: 187)
					)
					((== (gEgo view:) 7)
						(gEgo x: 289 y: 187)
					)
					((== (gEgo view:) 8)
						(gEgo x: 310 y: 187)
					)
					(else
						(gEgo x: 212 y: 183)
					)
				)
				((gEgo viewer:) doit:)
			)
			(31
				(if (<= (gEgo y:) horizon)
					(gEgo posn: (gEgo x:) (+ horizon 2))
				else
					(gEgo posn: 317 (gEgo y:))
				)
			)
			(34
				(gEgo x: 1)
			)
		)
		(gEgo xStep: 3 yStep: 2 init:)
	)

	(method (doit)
		(cond
			((>= (gEgo y:) 189)
				(if (< (gEgo x:) 125)
					(= gNewRoomNum 38)
				else
					(= gNewRoomNum 41)
				)
			)
			((>= (gEgo x:) 319)
				(= gNewRoomNum 31)
			)
			((<= (gEgo x:) 0)
				(= gNewRoomNum 34)
			)
			((<= (gEgo y:) horizon)
				(= gNewRoomNum 31)
			)
		)
	)

	(method (dispose)
		(waves dispose: delete:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evSAID) (Said 'look[<around][/room,island]'))
			(Print 35 0) ; "You stare out at the ocean and the white sand beach of this secluded island. From the middle of the island, a majestic ivory palace towers, surrounded by a lovely manicured garden."
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

