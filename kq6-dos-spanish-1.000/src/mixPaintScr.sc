;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 915)
(include sci.sh)
(use Main)
(use n913)
(use Motion)
(use System)

(public
	mixPaintScr 0
)

(instance mixPaintScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gInventory hide:)
				(= cycles 2)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(gEgo setSpeed: 6 normal: 0 view: 915 setLoop: 0)
				(= seconds 3)
			)
			(3
				(gMessager say: 3 0 8 1 self 0) ; "Alexander dips the large, black feather into the teacup..."
			)
			(4
				(gEgo setLoop: 1 setCycle: Fwd)
				(= seconds 2)
			)
			(5
				(gMessager say: 3 0 8 2 self 0) ; "...and stirs the contents gently."
			)
			(6
				(gEgo setLoop: 2 setCycle: Fwd)
				(= seconds 2)
			)
			(7
				(gEgo setLoop: 3 setCycle: Fwd)
				(= seconds 2)
			)
			(8
				(gEgo setLoop: 4 setCycle: Fwd)
				(= seconds 2)
			)
			(9
				(gEgo setLoop: 5 setCycle: Fwd)
				(= seconds 2)
			)
			(10
				(gGlobalSound4 loop: 1 number: 946 play:)
				(gMessager say: 3 0 8 3 self 0) ; "To his amazement, the jet-black color of the feather slowly drains, from end to tip, into the teacup."
			)
			(11
				(gEgo reset: 2)
				(= cycles 2)
			)
			(12
				(gEgo put: 12) ; feather
				(gGame givePoints: 1)
				(gMessager say: 3 0 8 4 self 0) ; "The teacup mixture blackens and thickens to a paint-like consistency. Alexander carefully puts it away, discarding the drained feather."
			)
			(13
				(SetFlag 22)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(= register 0)
		(DisposeScript 915)
	)
)

