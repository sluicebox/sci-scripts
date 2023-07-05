;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro6 0
)

(instance intro6 of Rm
	(properties
		picture 72
	)

	(method (init)
		(HandsOff)
		(eyes init:)
		(mouth init:)
		(self setScript: sceneSixScript)
		(super init:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (not global327)
			(= temp0 (Event new:))
			(if (or (== (temp0 type:) evKEYBOARD) (== (temp0 type:) evMOUSEBUTTON))
				(temp0 dispose:)
				(gGlobalSound stop:)
				(gGame restart:)
			)
			(temp0 dispose:)
		)
	)
)

(instance sceneSixScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(mouth setCycle: Fwd)
				(PrintDC 105 0 67 10 110 351 103) ; "He conjured up a terrible whirlwind that swirled faster and faster around the castle. With another incantation Mordack then caused the wind to draw the castle up into the sky and out of sight. Oh, it was something to see, all right!"
				(= seconds 10)
			)
			(2
				(gCurRoom newRoom: 103) ; intro4
			)
		)
	)
)

(instance eyes of Prop
	(properties
		y 54
		x 154
		view 98
		priority 10
		signal 2064
	)

	(method (doit)
		(switch (Random 1 40)
			(1
				(eyes setCycle: End)
			)
		)
		(super doit:)
	)
)

(instance mouth of Prop
	(properties
		y 71
		x 156
		view 98
		loop 1
		priority 10
		signal 2064
		cycleSpeed 1
	)
)

