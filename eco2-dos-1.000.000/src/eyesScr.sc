;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Motion)
(use Actor)
(use System)

(public
	eyesScr 0
)

(local
	[local0 6]
)

(instance eyeBlinkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (and (not (== register 0)) (not (Random 0 2)))
					(self cue:)
				else
					(if (not register)
						(= register (Random 2 4))
					)
					(= ticks (Random 40 160))
				)
			)
			(2
				(client cel: 0 setCycle: End self)
			)
			(3
				(if (-- register)
					(= state 0)
				)
				(= cycles 2)
			)
			(4
				(client dispose:)
			)
		)
	)
)

(instance eyesScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 5)
				(eyes1 init: setScript: (Clone eyeBlinkScr) self)
				(eyes2 init: setScript: (Clone eyeBlinkScr) self)
				(= ticks 30)
			)
			(1
				(eyes3 init: setScript: (Clone eyeBlinkScr) self)
				(eyes4 init: setScript: (Clone eyeBlinkScr) self)
				(= seconds 2)
			)
			(2
				(eyes5 init: setScript: (Clone eyeBlinkScr) self)
				(eyes6 init: setScript: (Clone eyeBlinkScr) self)
				(eyes7 init: setScript: eyeBlinkScr self)
			)
			(3
				(if (-- register)
					(-- state)
				)
			)
			(4
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance eyes1 of Prop
	(properties
		x 130
		y 99
		view 200
		loop 7
		cel 5
		cycleSpeed 20
	)
)

(instance eyes2 of Prop
	(properties
		x 212
		y 187
		view 200
		loop 7
		cel 5
		cycleSpeed 30
	)
)

(instance eyes3 of Prop
	(properties
		x 201
		y 122
		view 200
		loop 8
		cel 4
	)
)

(instance eyes4 of Prop
	(properties
		x 82
		y 96
		view 200
		loop 8
		cel 4
		cycleSpeed 10
	)
)

(instance eyes5 of Prop
	(properties
		x 56
		y 121
		view 200
		loop 9
		cel 3
		cycleSpeed 25
	)
)

(instance eyes6 of Prop
	(properties
		x 252
		y 92
		view 200
		loop 8
		cel 4
		cycleSpeed 15
	)
)

(instance eyes7 of Prop
	(properties
		x 293
		y 89
		view 200
		loop 9
		cel 3
		cycleSpeed 35
	)
)

