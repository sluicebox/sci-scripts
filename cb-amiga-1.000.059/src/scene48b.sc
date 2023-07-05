;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 332)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene48b 0
)

(instance scene48b of Rm
	(properties
		picture 62
		style 7
	)

	(method (init)
		(super init:)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(Rudy setPri: 1 init:)
		(glass setPri: 3 init:)
		(rFace setPri: 2 init: hide:)
		(Eyes setPri: 3 init: hide:)
		(self setScript: drink)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance drink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 332 0 #dispose) ; "Rudy is having a drink in his room."
				(= cycles 2)
			)
			(1
				(glass setCycle: End self)
			)
			(2
				(rFace show: setCycle: Fwd)
				(= cycles 20)
			)
			(3
				(rFace hide:)
				(glass setCycle: Beg)
				(= seconds 2)
			)
			(4
				(Eyes show: setCycle: End)
				(= seconds 2)
			)
			(5
				(Eyes setCycle: Beg self)
			)
			(6
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance Rudy of Prop
	(properties
		y 111
		x 98
		view 391
	)
)

(instance glass of Prop
	(properties
		y 116
		x 124
		view 391
		loop 5
	)
)

(instance rFace of Prop
	(properties
		y 95
		x 107
		view 391
		loop 4
		cycleSpeed 1
	)
)

(instance Eyes of Prop
	(properties
		y 72
		x 107
		view 391
		loop 8
		cycleSpeed 2
	)
)

(instance myMusic of Sound
	(properties)
)

