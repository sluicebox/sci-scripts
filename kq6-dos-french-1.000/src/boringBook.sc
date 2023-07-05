;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 273)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	boringBook 0
	takeBoringBookScr 1
)

(instance takeBoringBookScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (if (< ((ScriptID 270 2) y:) 140) 1 else 0)) ; shopOwner
				(gEgo
					setSpeed: 6
					view: 278
					loop: 0
					cel: 0
					normal: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				(boringBook dispose:)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 2 5 4 1 self) ; "Alexander picks up the book from the small table."
			)
			(5
				(if register
					((ScriptID 270 2) view: 276 cel: 0 setCycle: CT 4 1 self) ; shopOwner
				else
					(++ state)
					(self cue:)
				)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 2 5 4 2 self oneOnly: 0) ; "Oh, yes! Please, take that book! You have my most humble thanks for doing so, good sir!"
			)
			(8
				(if register
					((ScriptID 270 2) setCycle: Beg self) ; shopOwner
				else
					(++ state)
					(= cycles 1)
				)
			)
			(9
				((ScriptID 270 2) view: 276 loop: 0 cel: 0) ; shopOwner
				(= cycles 1)
			)
			(10
				(gEgo reset: get: 1) ; boringBook
				(gGame givePoints: 1)
				(= cycles 2)
			)
			(11
				(UnLoad 128 278)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 273)
	)
)

(instance boringBook of View
	(properties
		x 112
		y 135
		z 14
		noun 2
		sightAngle 40
		approachX 108
		approachY 137
		view 270
		loop 2
		priority 8
		signal 17
	)

	(method (onMe param1 &tmp temp0)
		(if (= temp0 (super onMe: param1 &rest))
			(if (== (param1 message:) 1)
				(= approachX 134)
				(= approachY 129)
			else
				(= approachX 112)
				(= approachY 137)
			)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		((ScriptID 270 1) doVerb: theVerb &rest) ; bookStand
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 1) ; Do, Look
	)
)

