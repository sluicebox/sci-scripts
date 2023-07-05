;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	boringBookScript 0
)

(instance boringBookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gEgo
					normal: 0
					view: 903
					cel: 0
					setLoop: 2
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(2
				(gEgo cel: 0 setLoop: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 1 setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(gMessager say: 1 42 0 1 self 0) ; "Alexander opens the bargain book and reads a paragraph at random."
			)
			(5
				(gMessager say: 1 42 0 2 self 0) ; "Two dulcimas raised to the degree of 40 halfdulcimas, divided into equal parts by the third of a cackle of grouse geese, put over the result of ten finemackels (albeit small finemackels), stretched over the total of...."
			)
			(6
				(gEgo setLoop: 2 lastCel: setCycle: Beg self)
			)
			(7
				(= seconds 1)
			)
			(8
				(localMusic loop: 1 number: 961 play:)
				(gEgo setLoop: 3 cycleSpeed: 10 setCycle: End self)
			)
			(9
				(gEgo setCel: 0 setCycle: CT 5 1 self)
			)
			(10
				(= cycles 15)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(= cycles 15)
			)
			(13
				(gEgo reset: 2)
				(= cycles 10)
			)
			(14
				(gMessager say: 1 42 0 3 self 0) ; "!!!Do not print this."
			)
			(15
				(gMessager say: 1 42 0 4 self 0) ; "Phew! What an incredibly boring book! No wonder the book shop owner wanted to get rid of it so badly."
			)
			(16
				(gGame handsOn:)
				(localMusic stop: dispose:)
				(self dispose:)
				(LoadMany 0 88)
			)
		)
	)
)

(instance localMusic of Sound
	(properties)
)

