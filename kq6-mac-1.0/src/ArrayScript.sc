;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 759)
(include sci.sh)
(use Main)
(use Print)
(use Rev)
(use Motion)
(use System)

(class ArrayScript of Script
	(properties
		start 1
		value 0
	)

	(method (init)
		(gGame handsOff:)
		(= start 1)
		(super init: &rest)
	)

	(method (changeState &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp5 0)
		(= value (self at: state))
		(++ state)
		(switch value
			(-4095
				(= temp0 (self getValue:))
				(= temp1 (self getValue:))
				(gEgo setCycle: CT temp0 temp1 self)
			)
			(-4092
				(gEgo setCycle: Beg self)
			)
			(-4094
				(gEgo setCycle: End self)
			)
			(-4088
				(gEgo setCycle: Fwd)
			)
			(-4080
				(gEgo setCycle: Rev)
			)
			(-4064
				(= cycles (self getValue:))
			)
			(-4032
				(= seconds (self getValue:))
			)
			(-3968
				(= temp0 (self getValue:))
				(= temp1 (self getValue:))
				(= temp2 (self getValue:))
				(self play: temp0 temp1 temp2)
			)
			(-14
				(gGame handsOn:)
				(self cue:)
			)
			(-15
				(gGame handsOff:)
				(self cue:)
			)
			(-3840
				(if (== (= temp0 (self getValue:)) -1)
					(= temp0 gCurRoomNum)
				)
				(= temp1 (self getValue:))
				(= temp2 (self getValue:))
				(= temp3 (self getValue:))
				(= temp4 (self getValue:))
				(gMessager say: temp1 temp2 temp3 temp4 self temp0)
			)
			(-16
				(= temp0 (self getValue:))
				(= temp1 (self getValue:))
				(UnLoad temp0 temp1)
				(self cue:)
			)
			(-14
				(gGame handsOn:)
				(self cue:)
			)
			(-15
				(gGame handsOff:)
				(self cue:)
			)
			(-1
				(self dispose:)
			)
			(else
				(-- state)
				(gEgo view: (self getValue:) loop: (self getValue:))
				(if (!= (= temp0 (self getValue:)) -1)
					(gEgo cel: temp0)
				)
				(gEgo x: (self getValue:) y: (self getValue:))
				(self cue:)
			)
		)
	)

	(method (cue)
		(self changeState: state)
	)

	(method (getValue)
		(= value (self at: state))
		(++ state)
		(return value)
	)

	(method (play)
		(Prints {Need play: method})
		(= cycles 1)
	)

	(method (at)
		(Prints {Need at: method})
		(SetDebug)
		(= gQuit 1)
	)
)

