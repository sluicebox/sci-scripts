;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room34 0
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

(instance Room34 of Rm
	(properties
		picture 34
	)

	(method (init)
		(if gNight
			(= picture 134)
		)
		(= north 31)
		(= east 35)
		(= west 33)
		(= horizon 80)
		(= gIndoors 0)
		(= global108 horizon)
		(gEgo edgeHit: 0)
		(super init:)
		(self setRegions: 505 501 503 504) ; gfReg, waterReg, beachReg, Gull_Region
		(wave1
			view: 661
			isExtra: 1
			loop: 2
			cel: 0
			posn: 66 110
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave2
			view: 661
			isExtra: 1
			loop: 3
			cel: 0
			posn: 143 109
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(wave3
			view: 661
			isExtra: 1
			loop: 4
			cel: 0
			posn: 214 107
			setPri: 0
			ignoreActors:
			cycleSpeed: 3
			init:
		)
		(waves add: wave1 wave2 wave3)
		(wave1 setScript: waveActions)
		(switch gPrevRoomNum
			(31
				(gEgo posn: (gEgo x:) (+ horizon 2))
			)
			(33
				(gEgo posn: 2 (gEgo y:))
			)
			(35
				(gEgo posn: 317 (gEgo y:))
			)
		)
		(gEgo xStep: 3 yStep: 2 init:)
	)

	(method (dispose)
		(waves dispose: delete:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look[<around][/room,island]'))
			(if (== (gEgo view:) 2)
				(Print 34 0) ; "You see the azure ocean stretching in front of you as you stand on the beach of this marvelous island. Behind you, set amidst a beautiful garden, rises a splendid ivory palace."
			else
				(Print 34 1) ; "You see the azure ocean stretching in front of you and the beach of a marvelous island. Set amidst a beautiful garden, rises a splendid ivory palace."
			)
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

