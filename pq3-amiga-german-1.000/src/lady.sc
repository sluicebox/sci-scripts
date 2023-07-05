;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 888)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use RandCycle)
(use PolyPath)
(use Sound)
(use Game)
(use Actor)
(use System)

(public
	lady 0
)

(local
	local0
	local1
	local2
)

(instance lady of Rgn
	(properties)

	(method (init)
		(pat init:)
		(thePlate init:)
		(patCar init:)
		(theCar init:)
		(gAddToPics add: thePlate pat patCar theCar doit:)
		(proc0_17 15)
		(SetFlag 211)
		(= global113 599)
	)
)

(instance patScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 293 133 self)
			)
			(1
				(= save1 1)
				(Face gEgo pat)
				(patInset init:)
				(Say patInset 888 0) ; "Okay, boss man, you handle it!"
				(= seconds 5)
			)
			(2
				(= save1 1)
				(patInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 888 1) ; "Why is the violator refusing to sign the ticket?"
				(= seconds 5)
			)
			(3
				(= save1 1)
				(sonnyInset dispose:)
				(patInset init:)
				(Say patInset 888 2) ; "Who knows! Geez! First I get this stupid cow, now I have ta deal with you, too!"
				(= seconds 6)
			)
			(4
				(= save1 1)
				(Say patInset 888 3) ; "This policy about calling a supervisor for failure to sign SUCKS!"
				(= seconds 5)
			)
			(5
				(= save1 1)
				(Say patInset 888 4) ; "Look, I don't need ya! I'm taking her downtown."
				(= seconds 5)
			)
			(6
				(= save1 1)
				(patInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 888 5) ; "No, you're not. You're going to stand right here until I have a chance to talk to the violator."
				(= seconds 5)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pat2Script of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 293 133 self)
			)
			(1
				(= save1 1)
				(Face gEgo pat)
				(sonnyInset init:)
				(Say sonnyInset 888 6) ; "Alright, Morales, the violator said you were abusive and rude. Why don't I have a hard time believing that?"
				(= seconds 10)
			)
			(2
				(= save1 1)
				(sonnyInset dispose:)
				(patInset init:)
				(Say patInset 888 7) ; "Look, Sarge, it's obvious the lady's hysterical. She'd pop off if ya looked at her funny."
				(= seconds 8)
			)
			(3
				(= save1 1)
				(patInset init:)
				(Say patInset 888 8) ; "She's been belligerent and hostile ever since I stopped her. She's beggin' for a night in jail."
				(= seconds 8)
			)
			(4
				(= save1 1)
				(patInset init:)
				(Say patInset 888 9) ; "So whaddaya gonna do, boss man?"
				(= seconds 4)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(SetFlag 11)
				(proc0_17 20)
				(Animate (gCast elements:) 0)
				(if
					(Print ; "INCARCERATE-Take her to jail, Pat. SIGNATURE-I'll witness her failure to sign."
						888
						10
						#button
						{INCARCERATE}
						1
						#button
						{SIGNATURE}
						0
					)
					(+= state 3)
				)
				(= cycles 1)
			)
			(6
				(SetScore 115 5)
				(= save1 1)
				(Print 888 11 #dispose #at 20 20) ; "Wisely and correctly you write, "Refusal to sign" in the signature box."
				(= global113 0)
				(= seconds 5)
			)
			(7
				(= save1 1)
				(patInset init:)
				(Say patInset 888 12) ; "Geez! Where'd ya get your training? Charm school? Just let her walk all over you...why doncha?!"
				(= seconds 8)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(patInset dispose:)
				(HandsOn)
				(self dispose:)
			)
			(9
				(= save1 1)
				(patInset init:)
				(Say patInset 888 13) ; "Brilliant deduction, Sherlock. Like I said before, I was already set to take her downtown."
				(= seconds 8)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Animate (gCast elements:) 0)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 98)
				(Print 888 14) ; "The excitement and trauma of the incident was more than enough to induce the woman's labor."
				(Print 888 15) ; "The complications that resulted were sufficient to bring a sizeable lawsuit against the department."
				(Print 888 16) ; "Sonny ends up with non-compensated days off."
				(EgoDead 3) ; "Your failure to follow correct police procedure has resulted in a $100,000,000 law suit. Time to hit that police manual."
			)
		)
	)
)

(instance ladyScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 182 131 self)
			)
			(1
				(= save1 1)
				(Face gEgo theCar)
				(Print 888 17 #dispose #at 10 10) ; "Looking at the young lady you see that she's pregnant and nearly full term."
				(= seconds 6)
			)
			(2
				(= save1 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 888 18) ; "You introduce yourself to the woman and say..."
				(sonnyInset init:)
				(Say sonnyInset 888 19) ; "Your signature on the citation is not an admission of guilt, Ma'am, only your promise to appear."
				(= seconds 5)
			)
			(3
				(= save1 1)
				(sonnyInset dispose:)
				(insetSuspect init:)
				(suspectMouth setCycle: RandCycle init:)
				(Say insetSuspect 888 20) ; "I don't care! You think I'm afraid to sign a stupid ticket? If it was a check for $10,000, I wouldn't sign it for that witch over there!"
				(= seconds 7)
			)
			(4
				(= save1 1)
				(Say insetSuspect 888 21) ; "I can't believe the L.P.D. would allow someone like her to patrol our streets! What a waste of our tax money!"
				(= seconds 7)
			)
			(5
				(= save1 1)
				(Say insetSuspect 888 22) ; "She's rude, abusive, and insulting!  I refuse to sign a ticket for anybody who calls me fat girl!!"
				(= seconds 7)
			)
			(6
				(= save1 1)
				(insetSuspect dispose:)
				(sonnyInset init:)
				(Say sonnyInset 888 23) ; "Would you please reconsider and sign the citation?"
				(= seconds 5)
			)
			(7
				(= save1 1)
				(sonnyInset dispose:)
				(insetSuspect init:)
				(suspectMouth setCycle: RandCycle init:)
				(Say insetSuspect 888 24) ; "Hell NO!! Take me to jail!"
				(= seconds 4)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(suspectMouth dispose:)
				(suspectHead init:)
				(= seconds 3)
			)
			(9
				(= save1 1)
				(suspectHead dispose:)
				(Print 888 25 #dispose #at 20 20) ; ""What should I do with this lady?", you think."
				(= seconds 4)
			)
			(10
				(= local0 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetSuspect dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lady2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 182 131 self)
			)
			(1
				(Print 888 26) ; "Looking at the young lady, you see that she's pregnant and nearly full term."
				(Face gEgo theCar)
				(insetSuspect init:)
				(suspectMouth setCycle: RandCycle init:)
				(Say insetSuspect 888 27) ; "What are you looking at? Why don't you go talk to your "witch in blue" over there?"
				(= seconds 6)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetSuspect dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance winceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 182 131 self)
			)
			(1
				(insetSuspect init:)
				(Print 888 28 #dispose #at 10 10) ; "The woman only winces, as though the emotion of the situation is causing her physical stress."
				(= cycles 12)
			)
			(2
				(suspectHead init:)
				(if (and (IsFlag 115) (== (++ local2) 5))
					(sFX number: 139 play:)
				)
				(= seconds 5)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(insetSuspect dispose:)
				(self dispose:)
			)
		)
	)
)

(instance pat of PicView
	(properties
		x 312
		y 124
		view 318
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 888 29) ; "Officer Morales' black eyes challenge you. She impresses you as being both arrogant and stubborn."
			)
			(5 ; Talk
				(cond
					((IsFlag 11)
						(Print 888 30) ; "You've already taken care of the situation. You had better get back on patrol."
					)
					(local0
						(HandsOff)
						(gCurRoom setScript: pat2Script)
					)
					(local1
						(Print 888 31) ; "The officer is waiting."
					)
					(else
						(HandsOff)
						(= local1 1)
						(gCurRoom setScript: patScript)
					)
				)
			)
			(3 ; Do
				(Print 888 32) ; "I don't think the officer would appreciate you touching her."
			)
			(4 ; Inventory
				(Print 888 33) ; "I sympathize, but Sonny wouldn't do that."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance patCar of PicView
	(properties
		x 336
		y 117
		description {car}
		view 208
		signal 16385
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Print 888 34) ; "That must be Officer Morales' patrol car."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance insetSuspect of Prop
	(properties
		x 244
		y 126
		view 322
		priority 15
		signal 16401
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Print 888 35) ; "The woman looks furious and on the verge of tears. She's VERY pregnant."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(suspectHead dispose:)
		(suspectMouth dispose:)
		(super dispose:)
	)

	(method (init)
		(self stopUpd:)
		(super init:)
	)
)

(instance suspectHead of Prop
	(properties
		x 244
		y 126
		view 322
		loop 3
		priority 15
		signal 16401
	)
)

(instance suspectMouth of Prop
	(properties
		x 244
		y 126
		view 322
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance theCar of PicView
	(properties
		x 209
		y 161
		description {car}
		view 318
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 888 36) ; "There's one woman in the car. She looks upset, but not dangerous."
			)
			(5 ; Talk
				(cond
					(local0
						(HandsOff)
						(gCurRoom setScript: winceScript)
					)
					(local1
						(HandsOff)
						(gCurRoom setScript: ladyScript)
					)
					(else
						(HandsOff)
						(gCurRoom setScript: lady2Script)
					)
				)
			)
			(3 ; Do
				(Print 888 37) ; "Using force on the violator will only get you in some very hot water."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(Print 888 37) ; "Using force on the violator will only get you in some very hot water."
					)
					(16 ; nightStick
						(Print 888 37) ; "Using force on the violator will only get you in some very hot water."
					)
					(else
						(Print 888 38) ; "Do you think she really cares about that?"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePlate of PicView
	(properties
		x 156
		y 149
		description {plate}
		view 318
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Print 888 39) ; "The plate reads - 83756"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance patInset of Prop
	(properties
		x 52
		y 107
		description {Pat Morales}
		view 27
		priority 15
		signal 16401
	)

	(method (init)
		(pEyes posn: (self x:) (self y:) setScript: patEyesBlink init:)
		(patMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(patMouth dispose:)
		(pEyes setScript: 0 dispose:)
	)
)

(instance patMouth of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 1
		priority 15
		signal 16401
		cycleSpeed 10
	)
)

(instance pEyes of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 2
		priority 15
		signal 16401
	)
)

(instance patEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(pEyes cel: 1)
				(= cycles 4)
			)
			(2
				(pEyes cel: 0)
				(= cycles 1)
			)
			(3
				(= seconds 2)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sonnyInset of Prop
	(properties
		x 44
		y 107
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sonnyMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(sonnyEyes x: (self x:) y: (self y:) init: setScript: egoEyesBlink)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(sonnyMouth dispose:)
		(sonnyEyes setScript: 0 dispose:)
	)
)

(instance sonnyMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sonnyEyes of Prop
	(properties
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoEyesBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(sonnyEyes cel: 1)
				(= cycles 4)
			)
			(2
				(sonnyEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance sFX of Sound
	(properties)
)

