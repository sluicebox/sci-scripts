;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use Motion)
(use Game)
(use Actor)

(public
	rm340 0
)

(local
	elementoid
	countdown
)

(instance rm340 of Rm
	(properties
		picture 340
		style 8
	)

	(method (init)
		(gCSound number: 340 loop: 1 priority: 8 playBed:)
		(super init:)
		(cond
			((<= gDay 7)
				(= elementoid 0)
			)
			((<= gDay 11)
				(= elementoid 2)
			)
			((<= gDay 14)
				(= elementoid 1)
			)
			((<= gDay 16)
				(= elementoid 3)
			)
		)
		(killer init:)
		(InitAddToPics town)
		(self setScript: destructo)
	)
)

(instance destructo of HandsOffScript
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(killer
					setLoop: elementoid
					cel: 0
					setPri: 6
					xStep: 1
					cycleSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 176 71 self
				)
			)
			(1
				(killer
					setLoop: elementoid
					cel: 0
					setPri: 6
					xStep: 1
					cycleSpeed: 1
					setMotion: MoveTo 109 71 self
				)
			)
			(2
				(if (< (++ countdown) 2)
					(self changeState: 0)
				else
					(= gDeathMusic 0)
					(EgoDead 0 340 0 #icon 347 elementoid 0) ; "The city is destroyed! Great job, Hero!"
				)
			)
		)
	)
)

(instance killer of Actor
	(properties
		x 109
		y 71
		view 347
	)
)

(instance town of PicView
	(properties
		x 148
		y 90
		view 780
		priority 7
	)
)

