;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 505)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use n940)
(use LoadMany)
(use Sound)
(use Actor)
(use System)

(public
	rm505 0
)

(local
	[ajax 10] = [5 5 5 8 0 3 9 0 0 0]
	[sexline 10] = [5 5 5 6 9 6 9 0 0 0]
	[sierra 10] = [2 0 9 6 8 3 8 9 8 9]
	index
	dialTimer
	[phoneEntry 11]
	touchTone
	tmpFont
)

(procedure (DialNumber number)
	(= [phoneEntry index] number)
	(if (or (== (++ index) 7) (== index 10))
		(cond
			((CheckAjax)
				(HandsOff)
				(gCurRoom setScript: sCallAjax)
			)
			((CheckSexline)
				(HandsOff)
				(gCurRoom setScript: sCallSexline)
			)
			((== (CheckSierra) 11)
				(HandsOff)
				(gCurRoom setScript: sCallSierra)
			)
			((and (== (CheckSierra) 8) (<= index 7)) 0)
			(else
				(ResetPhone)
				(sfxWrongNumber play:)
				(Print 505 37) ; "I'm sorry, but you have reached a number that is disconnected or no longer in service. Please hang up and dial again."
				(Print 505 38) ; "This is a recording."
				(sfxDialTone play: hold: 10)
			)
		)
	)
)

(procedure (ResetPhone &tmp i)
	(for ((= i 0)) (< i 10) ((++ i))
		(= [phoneEntry i] 0)
		(= index 0)
	)
)

(procedure (CheckAjax &tmp i)
	(for
		((= i 0))
		(and (<= i 7) (== [phoneEntry i] [ajax i]))
		((++ i))
	)
	(if (== i 8)
		(return 8)
	else
		(return 0)
	)
)

(procedure (CheckSexline &tmp i)
	(for
		((= i 0))
		(and (<= i 7) (== [phoneEntry i] [sexline i]))
		((++ i))
	)
	(if (== i 8)
		(return 8)
	else
		(return 0)
	)
)

(procedure (CheckSierra &tmp i)
	(for
		((= i 0))
		(and (<= i 10) (== [phoneEntry i] [sierra i]))
		((++ i))
	)
	(cond
		((== i 10)
			(return 11)
		)
		((== i 7)
			(return 8)
		)
		(else
			(return 0)
		)
	)
)

(instance rm505 of LLRoom
	(properties
		lookStr {You are using the Quiki-Mart's one and only telephone.}
		picture 515
	)

	(method (init)
		(LoadMany rsPIC 515)
		(LoadMany rsVIEW 515)
		(LoadMany
			rsSOUND
			490
			491
			492
			493
			494
			495
			496
			497
			498
			499
			508
			500
			501
			502
			503
			505
			506
			509
		)
		(gEgo init: x: (+ (gEgo x:) 1000))
		(one init:)
		(two init:)
		(three init:)
		(four init:)
		(five init:)
		(six init:)
		(seven init:)
		(eight init:)
		(nine init:)
		(zero init:)
		(star init:)
		(pound init:)
		(if (IsFlag 26)
			(ClearFlag 26)
			(HandsOff)
			(gCurRoom setScript: sSurveyResponse)
		else
			(sfxDialTone play: hold: 10)
		)
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (== (gCurRoom script:) 0)
			(++ dialTimer)
		)
		(if (> dialTimer 800)
			(sfxDialTone stop:)
			(sfxWrongNumber play:)
			(Print 505 0) ; "Please hang up and try again. This is a recording."
			(ResetPhone)
			(= dialTimer 0)
			(sfxDialTone play: hold: 10)
		)
		(if (gEgo mover:)
			(gCurRoom setScript: sBackToRoom)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 505 1) ; "Please dial the party to whom you wish to speak with."
			)
			(3 ; Do
				(Print 505 2) ; "Just press a button or walk away."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sBackToRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(ResetPhone)
				(= cycles 5)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance sCallSexline of Script
	(properties)

	(method (changeState newState &tmp [tmpStr 200])
		(switch (= state newState)
			(0
				(ResetPhone)
				(if (IsFlag 57)
					(sfxDialTone stop:)
					(sfxPhoneBusy play:)
					(Print 505 3) ; "Hmmm... it's busy."
					(sfxPhoneBusy stop:)
					(sfxDialTone play: hold: 10)
					(HandsOn)
					(self dispose:)
				else
					(sfxPhoneRinging loop: 3 play: self)
					(= gYourPart 0)
					(= gVideo 0)
					(= gYourClothing 0)
					(= gTheirName 0)
					(= gTheirPart 0)
					(= gTheirClothing 0)
					(= gObject 0)
					(= gRoom 0)
					(= gActivity 0)
				)
			)
			(1
				(sfxPhoneAnswered play:)
				(Print 505 4) ; "A sensuous female voice answers the telephone after the third ring."
				(Points 57 2)
				(Print 505 5) ; "Hello, welcome to the National Quiki-Sex Survey Hot Line. Please answer the following questions. I may have something wonderful waiting for you!!"
				(= cycles 20)
			)
			(2
				(Print 505 6) ; "First, a few questions about you..."
				(= seconds 3)
			)
			(3
				(Print 505 7) ; "What is your name?"
				(= seconds 3)
			)
			(4
				(Print 505 8) ; ""My name is Larry; Larry Laffer," you respond."
				(= seconds 3)
			)
			(5
				(= tmpFont (DEdit font:))
				(DEdit font: gMonoFont)
				(Print 505 9) ; "Oooh," she sighs, "what a sweet name!"
				(while (> 2 (StrLen @gYourPart))
					(PrintD
						26
						{"So tell me, Larry: what is the best part of your body?"}
						103
						41
						@gYourPart
						24
					)
				)
				(= seconds 3)
			)
			(6
				(Printf 505 10 @gYourPart) ; "Oh, I so love a man with a manly, yet urbane, %s!"
				(= seconds 3)
			)
			(7
				(while (> 2 (StrLen @gVideo))
					(PrintD
						26
						{"And Larry, what is your favorite X-rated video?"}
						103
						41
						@gVideo
						51
					)
				)
				(= seconds 3)
			)
			(8
				(Print 505 11) ; "Mmmmmm, mine too!" she says, knowingly. "I just love that part with the two women!"
				(while (> 2 (StrLen @gYourClothing))
					(PrintD
						26
						{"Now tell me your favorite article of clothing."}
						103
						41
						@gYourClothing
						24
					)
				)
				(= seconds 3)
			)
			(9
				(Print 505 12) ; ""Ahhh, and I can just picture you in it, too!" she moans."
				(Print 505 13) ; "Now, a few questions about your favorite lover."
				(while (> 2 (StrLen @gTheirName))
					(PrintD
						26
						{"Larry, what is your favorite sex partner's first name?"}
						103
						41
						@gTheirName
						18
					)
				)
				(= seconds 3)
			)
			(10
				(Format
					@tmpStr
					{"What's the best part of %s's anatomy?"}
					@gTheirName
				)
				(while (> 2 (StrLen @gTheirPart))
					(PrintD 26 @tmpStr 103 41 @gTheirPart 24)
				)
				(= seconds 3)
			)
			(11
				(Format
					@tmpStr
					{"What is %s's sexiest article of clothing?"}
					@gTheirName
				)
				(while (> 2 (StrLen @gTheirClothing))
					(PrintD 26 @tmpStr 103 41 @gTheirClothing 24)
				)
				(= seconds 3)
			)
			(12
				(Format @tmpStr {"What's %s's favorite object?"} @gTheirName)
				(while (> 2 (StrLen @gObject))
					(PrintD 26 @tmpStr 103 41 @gObject 24)
				)
				(= seconds 3)
			)
			(13
				(while (> 2 (StrLen @gRoom))
					(PrintD
						26
						{"And where do you two most enjoy making love?"}
						103
						41
						@gRoom
						24
					)
				)
				(= seconds 3)
			)
			(14
				(Print 505 14) ; "Yeah, me too!"
				(Format
					@tmpStr
					{"And, finally, what do you and %s like to do when you're together?"}
					@gTheirName
				)
				(while (> 2 (StrLen @gActivity))
					(PrintD 26 @tmpStr 103 41 @gActivity 50)
				)
				(DEdit font: tmpFont)
				(= seconds 3)
			)
			(15
				(Print 505 15) ; "Thanks for participating. Your prize is..."
				(sfxPhoneHangUp play:)
				(sfxDialTone play: hold: 10)
				(Print 505 16) ; "...."
				(Print 505 17) ; "Hum. Looks like they hung up on you. Oh, well. It was probably a bummer prize anyway!"
				(SetFlag 39)
				(= cycles 10)
			)
			(16
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sSurveyResponse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sfxDialTone stop:)
				(ClearFlag 39)
				(= seconds 2)
			)
			(1
				(Print 505 18) ; "You pick up the telephone, and hear a familiar voice."
				(= seconds 3)
			)
			(2
				(Printf 505 19 @gTheirName @gRoom @gYourClothing 67 -1 20) ; "Hello, Larry! This is %s. I was just sitting here in the %s, wearing your %s and thinking about you (if you know what I mean!)."
				(= seconds 3)
			)
			(3
				(Printf 505 20 @gTheirClothing @gVideo 67 -1 20) ; "Why don't you forget about this silly game, and come over to my place? I'll slip into my %s, and we'll curl up in front of the fireplace and I'll stick in our copy of "%s!""
				(= seconds 3)
			)
			(4
				(Printf 505 21 @gYourPart @gObject @gTheirPart) ; "You know your %s has always turned me on! So bring along a %s and come play with my %s!"
				(= seconds 3)
			)
			(5
				(Printf 505 22 @gActivity) ; "Pretty soon, we'll both get excited and we'll %s like we always do!"
				(= seconds 3)
			)
			(6
				(Print 505 23) ; "Bye, Larry! See you soon?"
				(sfxPhoneHangUp play:)
				(sfxDialTone play: hold: 10)
				(= seconds 3)
			)
			(7
				(SetFlag 19)
				(HandsOn)
				(self dispose:)
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance sCallAjax of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ResetPhone)
				(if gDebugging
					(SetFlag 80)
				)
				(cond
					((and (IsFlag 80) (not (IsFlag 55)))
						(Points 55 5)
						(sfxPhoneRinging loop: 3 play: self)
					)
					((or (not (IsFlag 80)) (IsFlag 55))
						(sfxPhoneBusy play:)
						(Print 505 24) ; "Hmmm... Ajax Liquor Store's line is busy."
						(sfxPhoneBusy stop:)
						(sfxDialTone play: hold: 10)
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(1
				(sfxPhoneAnswered play:)
				(Print 505 25) ; "Hello. Ajax Liquor Store. We deliver!"
				(= cycles 1)
			)
			(2
				(Print 505 26) ; ""I'd like to purchase some fine wine," you say."
				(= seconds 3)
			)
			(3
				(Print 505 27) ; "Hey, ya called the right guy!" he says. "Where didja want it delivered?"
				(= seconds 3)
			)
			(4
				(Print 505 28) ; "To the Casino Hotel's Honeymoon Suite," you respond. "And step on it!"
				(= seconds 3)
			)
			(5
				(Print 505 29) ; "Ok. Consider it done. I'll send one of my hottest young men. Hey, thanks for calling!"
				(Print 505 30) ; "And with that, he hangs up."
				(sfxPhoneHangUp play:)
				(= seconds 3)
			)
			(6
				(sfxDialTone play: hold: 10)
				(Print 505 31 #at -1 140) ; "(What did he mean, "hottest?")"
				(SetFlag 24)
				(= cycles 1)
			)
			(7
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sCallSierra of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Points 56 5)
				(ResetPhone)
				(sfxPhoneRinging loop: 2 play: self)
			)
			(1
				(sfxPhoneAnswered play:)
				(Print 505 32) ; "Hello," a pleasant voice responds. "Sierra On-Line."
				(= seconds 3)
			)
			(2
				(Print 505 33) ; "We're not open right now, but if you'd call during business hours (and stop using this pretend telephone), we would be happy to sell you a copy of one of Al Lowe's other fine games!"
				(= seconds 3)
			)
			(3
				(Print 505 34) ; "At the same time, be sure to inquire about our full line of Leisure Suit Larry novelty items."
				(= seconds 3)
			)
			(4
				(Print 505 35) ; "Thank you for calling Sierra On-Line, and for your purchase of `Leisure Suit Larry in the Land of the Lounge Lizards.' Goodbye."
				(sfxPhoneHangUp play:)
				(= seconds 2)
			)
			(5
				(sfxDialTone play: hold: 10)
				(Print 505 36) ; "Such blatant commercialism turns you on. You make a mental note to purchase one of those great, Al Lowe games!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sfxPhone of Sound
	(properties
		flags 1
	)
)

(instance sfxDialTone of Sound
	(properties
		flags 1
		number 490
		loop -1
	)
)

(instance sfxPhoneAsterisk of Sound
	(properties
		flags 1
		number 500
	)
)

(instance sfxPhonePoundSign of Sound
	(properties
		flags 1
		number 501
	)
)

(instance sfxPhone0 of Sound ; UNUSED
	(properties
		number 508
	)
)

(instance sfxPhoneBusy of Sound
	(properties
		flags 1
		number 502
		loop -1
	)
)

(instance sfxPhoneRinging of Sound
	(properties
		flags 1
		number 503
	)

	(method (check)
		(DoSound sndUPDATE_CUES self)
		(if signal
			(= prevSignal signal)
			(= signal 0)
			(cond
				((> (self loop:) 1)
					(self loop: (- (self loop:) 1))
					(DoSound sndPLAY self 0)
				)
				((IsObject client)
					(client cue: self)
				)
			)
		)
	)
)

(instance sfxPhoneAnswered of Sound
	(properties
		flags 1
		number 505
	)
)

(instance sfxPhoneHangUp of Sound
	(properties
		flags 1
		number 506
	)
)

(instance sfxWrongNumber of Sound
	(properties
		flags 1
		number 509
	)
)

(instance sButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sfxDialTone stop:)
				(sfxPhone
					number:
						(if (== client zero)
							508
						else
							(+ 490 (client loop:))
						)
					play:
				)
				(client setCel: 1)
				(= dialTimer 0)
				(= cycles 4)
			)
			(1
				(client setCel: 0)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(DialNumber (client loop:))
				(= cycles 1)
			)
			(3
				(= touchTone 0)
				(self dispose:)
			)
		)
	)
)

(instance one of Prop
	(properties
		x 110
		y 71
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(5 ; Talk
				(Print 505 1) ; "Please dial the party to whom you wish to speak with."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance two of Prop
	(properties
		x 135
		y 71
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(else
				(one doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance three of Prop
	(properties
		x 161
		y 71
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(else
				(one doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance four of Prop
	(properties
		x 114
		y 91
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(else
				(one doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance five of Prop
	(properties
		x 137
		y 91
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(else
				(one doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance six of Prop
	(properties
		x 162
		y 91
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(else
				(one doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance seven of Prop
	(properties
		x 116
		y 111
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 7
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(else
				(one doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance eight of Prop
	(properties
		x 140
		y 111
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(else
				(one doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance nine of Prop
	(properties
		x 164
		y 112
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(else
				(one doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance zero of Prop
	(properties
		x 140
		y 132
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setScript: sButton)
			)
			(else
				(one doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance star of Prop
	(properties
		x 118
		y 132
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(= touchTone -1)
				(self setScript: sButton)
				(sfxPhoneAsterisk play:)
			)
			(one
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pound of Prop
	(properties
		x 164
		y 130
		description {the button}
		sightAngle 40
		lookStr {Thoroughly inspecting the touchtone telephone, you conclude that it's just like any other telephone.}
		view 515
		loop 11
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(= touchTone -2)
				(self setScript: sButton)
				(sfxPhonePoundSign play:)
			)
			(5 ; Talk
				(Print 505 1) ; "Please dial the party to whom you wish to speak with."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

