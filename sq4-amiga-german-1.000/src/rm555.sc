;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 555)
(include sci.sh)
(use Main)
(use rmnScript)
(use eRS)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)

(public
	rm555 0
)

(instance rm555 of SQRoom
	(properties
		picture 555
	)

	(method (init)
		(super init:)
		(holo init:)
		(self setScript: realyStupidScript)
	)
)

(instance realyStupidScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(holo setCycle: End)
				(= cycles 1)
			)
			(1
				(hair init: setCycle: ForwardCounter 40)
				(= cycles 2)
			)
			(2
				(aSound init: number: 813 loop: 1 play:)
				(self
					save1:
						(proc0_12
							{"This is my mother and your wife. Her name was Beatrice, Beatrice Wankmeister. She was quite beautiful, wasn't she."}
							67
							5
							20
							28
							global150
							29
							global129
							30
							1
							70
							125
						)
				)
				(= seconds 10)
			)
			(4
				(self
					save1:
						(proc0_12
							{"What do you mean, WAS quite beautiful'? What are you saying."}
							67
							5
							20
							28
							global140
							29
							global129
							30
							1
							70
							125
						)
				)
				(= seconds 10)
			)
			(6
				(self
					save1:
						(proc0_12
							{"I'm so sorry! I shouldn't have said that! Please, I can't tell you any more."}
							67
							5
							20
							28
							global150
							29
							global129
							30
							1
							70
							125
						)
				)
				(= seconds 10)
			)
			(7
				(gCurRoom newRoom: 556)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance hair of Prop
	(properties
		x 176
		y 32
		description {holo of Rogers future wife.}
		sightAngle 180
		lookStr {Her golden hair blows in the breeze, and you wonder how you could get so lucky.}
		view 557
		loop 1
		priority 7
		signal 16400
	)
)

(instance holo of Prop
	(properties
		x 167
		y 120
		description {Holo of your future wife.}
		sightAngle 180
		lookStr {You gaze at the beautiful woman in the holo and look forward to the day that you finally meet her.}
		view 557
		priority 6
		signal 16400
	)
)

(instance aSound of Sound
	(properties
		number 813
	)
)

