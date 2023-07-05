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
							{"This is my mother and your wife. Her name was Beatrice, Beatrice Wankmeister. She was quite beautiful, wasn't she."#j\a2\ee\de\98\e9\a0 \ea\ea\e3\de\a0 \95\e4\93\9b\fd\e9\a0\95\98\9b\fd\e9\a4\a0 \cb\de\b0\c4\d8\bd\a5\a5\a5\a5\a4 \n\cb\de\b0\c4\d8\bd\a5       \n     \dc\dd\b8\cf\b2\bd\c0\b0\a1\n\e4\e3\f3\a0\eb\de\9c\de\fd\a0 \e0\de\8f\e0\fd\e0\de\a1\a3}
							67
							5
							20
							28
							global137
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
							{"What do you mean, WAS quite beautiful'? What are you saying."#j\a2\eb\de\9c\de\fd \e0\de\8f\e0\fe\a0 \n"\e0\de\8f\e0"\8f\e3\a5\a5\a5\a5\a1\a0 \n\92\8f\e0\92\a0 \e5\e6\86\a0\n\92\8f\e3\f9\fd\e0\de\fe\a3}
							67
							5
							20
							28
							global189
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
							{"I'm so sorry! I shouldn't have said that! Please, I can't tell you any more."#j\a2\91\8f\a4\a0 \f3\93\9c\fc\99\e5\92\ff\a0 \92\93\ed\de\97\a0\9c\de\8c\e5\96\8f\e0\ff \ba\de\d2\dd\ff\a0 \9a\fa\a0 \92\9c\de\8e\93\ea\a0\n\92\94\e5\92\fd\e0\de\a1\a3}
							67
							5
							20
							28
							global137
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

