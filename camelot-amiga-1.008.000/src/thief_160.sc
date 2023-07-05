;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	thief 0
)

(instance thief of Act
	(properties
		y 150
		x 32
		yStep 4
		view 354
		illegalBits 0
		xStep 6
	)

	(method (init)
		(super init:)
		(HandsOff)
		(thief setLoop: 4 setCycle: Walk)
		(self setScript: thiefRuns)
	)

	(method (delete)
		(super delete:)
		(DisposeScript 160)
	)
)

(instance thiefRuns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
				(gEgo setMotion: MoveTo 30 140)
			)
			(1
				(thief setMotion: MoveTo 28 123 self)
			)
			(2
				(thief setPri: 1 setMotion: MoveTo 44 115 self)
			)
			(3
				(thief dispose:)
				(HandsOn)
			)
		)
	)
)

