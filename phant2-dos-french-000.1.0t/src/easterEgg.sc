;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 909)
(include sci.sh)
(use Main)
(use nExit)
(use Str)
(use BorderWindow)
(use PolyEdit)
(use Cycle)
(use TextField)
(use Jump)

(public
	easterEgg 0
)

(instance easterEgg of CloseupRoom
	(properties
		picture 3000
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(= exitRoom gPrevRoomNum)
		(eeTitle
			setText: {EASTER EGG SUMMARY}
			setSize:
			init: gThePlane
			posn: 160 53
			setPri: 400
		)
		(= temp0 (Str new:))
		(temp0
			format:
				{You've scored %d points out of a maximum of %d points}
				global242
				480
		)
		(eeScore
			setText: (temp0 data:)
			setSize:
			init: gThePlane
			posn: 135 93
			setPri: 400
		)
		(temp0 dispose:)
		(= temp0 (Str new:))
		(= temp3 120)
		(cond
			((<= global242 0)
				(temp0 format: {Zero? Come on, we didn't make it that hard!})
				(= temp1 153)
				(= temp2 260)
				(= temp4 9800)
			)
			((<= 1 global242 temp3)
				(temp0 format: {Need some help? Try Tech-Support.})
				(= temp1 180)
				(= temp2 260)
				(= temp4 9801)
			)
			((<= (+ temp3 1) global242 (* temp3 2))
				(temp0
					format:
						{You're probably saying to yourself, 'These guys must have a lot of time on their hands.'}
				)
				(= temp1 109)
				(= temp2 260)
				(= temp4 9802)
			)
			((<= (+ (* temp3 2) 1) global242 (* temp3 3))
				(temp0 format: {You're pretty good at finding these things!})
				(= temp1 153)
				(= temp2 260)
				(= temp4 9803)
			)
			((<= (+ (* temp3 3) 1) global242 479)
				(temp0
					format:
						{Hey, you're almost there!\nHave you activated the nudity code yet?}
				)
				(= temp1 180)
				(= temp2 260)
				(= temp4 9804)
			)
			((>= global242 480)
				(temp0
					format:
						{Congratulations, you've found all our Easter Eggs. \nYou didn't get any hints from off of the internet\ndid you?}
				)
				(= temp1 143)
				(= temp2 260)
				(andyWho init:)
				(tamWho init:)
				(moveMamma init:)
				(= temp4 9805)
			)
		)
		(eeComment
			setText: (temp0 data:)
			setSize:
			init: gThePlane
			posn: temp1 temp2
			setPri: 400
		)
		(temp0 dispose:)
		(SetCursor 70 251)
		(super init: &rest)
		(gP2SongPlyr start: 909)
		(gP2SoundFX play: temp4)
		(gGame handsOn:)
	)

	(method (dispose)
		(gP2SongPlyr stop:)
		(moveUp dispose:)
		(moveDown dispose:)
		(moveRight dispose:)
		(moveLeft dispose:)
		(moveMamma dispose:)
		(super dispose: &rest)
	)
)

(instance eeTitle of TextView
	(properties
		borderColor 255
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: &rest)
		(text font: 7)
	)
)

(instance eeScore of TextView
	(properties
		borderColor 255
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: &rest)
		(text font: 7007)
	)
)

(instance eeComment of TextView
	(properties
		borderColor 255
	)

	(method (init)
		(|= signal $1000)
		(super init: &rest)
		(self setPri: 1)
	)

	(method (setText)
		(super setText: &rest)
		(text font: 2111)
	)
)

(instance andyWho of Prop
	(properties
		x 268
		y 181
		view 909
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setPri: 30)
		(self setCycle: Fwd)
	)
)

(instance tamWho of View
	(properties
		x 253
		y 196
		view 909
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance moveMamma of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch (Random 1 4)
					(1
						(moveLeft init: 0 self)
					)
					(2
						(moveRight init: 0 self)
					)
					(3
						(moveUp init: 0 self)
					)
					(4
						(moveDown init: 0 self)
					)
				)
			)
			(1
				(= state -1)
				(= ticks 1)
			)
		)
	)
)

(instance moveLeft of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (> (= temp0 (- (= temp0 (tamWho x:)) 8)) 200)
					(-- state)
				)
				(tamWho x: temp0)
				(= ticks 1)
			)
			(1
				(if (< (= temp0 (+ (= temp0 (tamWho x:)) 8)) 253)
					(-- state)
				else
					(= temp0 253)
				)
				(tamWho x: temp0)
				(= ticks 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance moveUp of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (> (= temp0 (- (= temp0 (tamWho y:)) 8)) 148)
					(-- state)
				)
				(tamWho y: temp0)
				(= ticks 1)
			)
			(1
				(if (< (= temp0 (+ (= temp0 (tamWho y:)) 8)) 196)
					(-- state)
				else
					(= temp0 196)
				)
				(tamWho y: temp0)
				(= ticks 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance moveRight of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (< (= temp0 (+ (= temp0 (tamWho x:)) 8)) 310)
					(-- state)
				)
				(tamWho x: temp0)
				(= ticks 1)
			)
			(1
				(if (> (= temp0 (- (= temp0 (tamWho x:)) 8)) 253)
					(-- state)
				else
					(= temp0 253)
				)
				(tamWho x: temp0)
				(= ticks 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance moveDown of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (< (= temp0 (+ (= temp0 (tamWho y:)) 8)) 260)
					(-- state)
				)
				(tamWho y: temp0)
				(= ticks 1)
			)
			(1
				(if (> (= temp0 (- (= temp0 (tamWho y:)) 8)) 196)
					(-- state)
				else
					(= temp0 196)
				)
				(tamWho y: temp0)
				(= ticks 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

