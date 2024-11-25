;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 385)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm385 0
)

(local
	cueCounter
	step
	myTicks
	nonPerfect
)

(instance rm385 of LLRoom
	(properties
		picture 385
		style 14
	)

	(method (init)
		(super init:)
		(LoadMany rsSOUND 387)
		(= step 10)
		(cloud
			init:
			setStep: 10 10
			posn: (Random 250 255) 199
			setMotion: MoveTo (cloud x:) 14 cloud
		)
		(body init: setCycle: Fwd)
		(head init: setCycle: Fwd)
		(gTheMusic number: 386 loop: -1 play:)
		(gTheMusic2 number: 390 loop: -1 play: gCurRoom)
		(theMusic3 number: 387 loop: -1 play:)
		(gCurRoom setScript: sDyingInFirstClass)
		(SetFFRoom 1000 gCurRoom)
	)

	(method (cue)
		(gCurRoom newRoom: 390)
	)

	(method (newRoom)
		(gTheTimer dispose: delete:)
		(super newRoom: &rest)
	)
)

(instance cloud of Actor
	(properties
		x 255
		y 189
		view 385
		priority 1
		signal 18448
	)

	(method (cue)
		(switch (++ cueCounter)
			(1
				(Delay (Random 3 7) 1 self)
			)
			(2
				(if (< step 44)
					(+= step 2)
				)
				(cloud
					setStep: step step
					posn: (Random 250 255) 199
					setMotion: MoveTo (cloud x:) 14 self
				)
				(= cueCounter 0)
			)
		)
	)
)

(instance head of Prop
	(properties
		x 215
		y 78
		view 386
		loop 1
		priority 14
		signal 18448
	)
)

(instance body of Prop
	(properties
		x 173
		y 146
		view 386
		priority 10
		signal 18448
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance sDyingInFirstClass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 6)
			)
			(1
				(TPrint 385 0 #dispose self) ; "Hey! This is no dream! Your airliner is actually falling out of control!"
			)
			(2
				(= ticks 30)
			)
			(3
				(TPrint 385 1 #dispose self) ; "As your flight plummets from the sky, your life passes before your eyes."
			)
			(4
				(= ticks 30)
			)
			(5
				(TPrint 385 2 #dispose self) ; "For a while, you consider that redhead you dated during high school, wondering if there could have been some reason she wanted you to come over to her house that afternoon when her parents were out of town?"
			)
			(6
				(= ticks 30)
			)
			(7
				(TPrint 385 3 #dispose self) ; "But then you consider your performance since you were back at PornProdCorp...."
			)
			(8
				(= ticks 30)
				(= register 64)
			)
			(9
				(if (IsFlag register)
					(= cycles 1)
					(= myTicks 2)
				else
					(switch register
						(81
							(Say gEgo 385 4 #dispose self) ; "Was there an award back at good ol' PornProdCorp? I wish I had looked around more while I was there!"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(85
							(Say gEgo 385 5 #dispose self) ; "How I wish I had taken the charger for my camcorder!"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(86
							(Say gEgo 385 6 #dispose self) ; "What if I would have brought along some videotapes from PornProdCorp? I could have recorded those women I saw!"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(87
							(Say gEgo 385 7 #dispose self) ; "Boy, I wish I had degaussed those videotapes before I left my office."
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(74
							(Say gEgo 385 8 #dispose self) ; "I wonder what was inside that DayTrotter\05 I found in that New York City limousine?"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(68
							(Say gEgo 385 9 #dispose self) ; "And how about that AeroDork Airline magazine? What was in that?"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(142
							(Say gEgo 385 10 #dispose self) ; "I wonder how much the overdue charges are on those roller-skates?"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(161
							(Say gEgo 385 11 #dispose self) ; "Was there anything in that dentist's office I missed?"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(164
							(Say gEgo 385 12 #dispose self) ; "Did I ever finish that dentist's receptionist's survey?"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(166
							(Say gEgo 385 13 #dispose self) ; "I wish there had been some way I could have seen `more' of Chi Chi Lambada!"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(165
							(Say gEgo 385 14 #dispose self) ; "That Chi Chi Lambada was so easy! I wonder what making love to a gymnast would have been like?"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(167
							(Say gEgo 385 15 #dispose self) ; "Why didn't I record my encounter with Chi Chi Lambada?"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(116
							(Say gEgo 385 16 #dispose self) ; "Why didn't I pursue Michelle Milken harder? She seemed so easy to get to know!"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(117
							(Say gEgo 385 17 #dispose self) ; "Why didn't I record my encounter with Michelle Milken?"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(136
							(Say gEgo 385 18 #dispose self) ; "I bet if I had gone to see Lana Luscious mud wrestle, I could have gotten a kiss!"
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(137
							(Say gEgo 385 19 #dispose self) ; "I could have recorded my mud wrestling session with Lana Luscious."
							(= nonPerfect 1)
							(= myTicks 30)
						)
						(else
							(= myTicks 2)
							(= cycles 1)
						)
					)
				)
			)
			(10
				(if (< (++ register) 168)
					(-= state 2)
				)
				(= ticks myTicks)
			)
			(11
				(if nonPerfect
					(= cycles 1)
				else
					(Say gEgo 385 20 #dispose self) ; "You think to yourself, "I did pretty dog-gone well this time, even if I do have to say so myself!""
				)
			)
			(12
				(= ticks 60)
			)
			(13
				(TPrint 385 21 #dispose self) ; "All in all, you wish you had accepted that redhead's offer!"
			)
			(14
				(= ticks 60)
			)
			(15
				(TPrint ; "The loudspeaker crackles with a panic-stricken voice, "Any passengers with flight experience are urged to report to the cockpit immediately!""
					385
					22
					#at
					-1
					185
					#width
					280
					#title
					{The P. A. System}
					#dispose
					self
				)
			)
			(16
				(= ticks 60)
			)
			(17
				(Say gEgo 385 23 #dispose self) ; "Hmm," you think, "I used to sell flight simulator software door-to-door! Maybe I could help?"
			)
			(18
				(= ticks 60)
			)
			(19
				(Say gEgo 385 24 #dispose self) ; "Oh, stewardess," you shout, "What's wrong?"
			)
			(20
				(= ticks 60)
			)
			(21
				(TPrint 385 25 #title {The Stewardess} #dispose self) ; "She replies, "Oh, not to worry. It's just that the pilot's contract ran out a few moments ago and (being a good union man) he refuses to work without a contract!""
			)
			(22
				(TPrint 385 26 #title {The Stewardess} #dispose self) ; "Oh, sir, can you help us?"
			)
			(23
				(= ticks 60)
			)
			(24
				(Say gEgo 385 27 #dispose self) ; "Well, I'll do the best I can," you volunteer. "Did I mention I used to sell flight simulator software door-to-door?"
			)
			(25
				(= ticks 60)
			)
			(26
				(TPrint 385 28 #title {The Stewardess} #dispose self) ; "Oh, that's wonderful, Sir! Hurry! Follow me up to... er, down to the cockpit!"
			)
			(27
				(gCurRoom newRoom: 390)
			)
		)
	)
)

