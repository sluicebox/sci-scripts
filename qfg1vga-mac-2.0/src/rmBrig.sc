;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 172)
(include sci.sh)
(use Main)
(use n814)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rmBrig 0
)

(instance rmBrig of Rm
	(properties
		picture 402
		style 7
	)

	(method (init)
		(Load rsVIEW 473)
		(Load rsSOUND 70)
		(super init:)
		(leader init: setScript: leaderToElsa)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance leader of Prop
	(properties
		x 139
		y 135
		view 473
		cycleSpeed 9
	)

	(method (init)
		(super init:)
	)
)

(instance leaderToElsa of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 60)
				(gGame setCursor: gTheCursor 0)
			)
			(1
				(SolvePuzzle 713 35)
				(elsaChange init: play:)
				(leader setCycle: End self)
			)
			(2
				(= ticks 90)
			)
			(3
				(gCurRoom newRoom: 97)
			)
		)
	)
)

(instance elsaChange of Sound
	(properties
		number 70
		priority 3
	)
)

