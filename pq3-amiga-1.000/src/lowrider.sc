;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 886)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use RandCycle)
(use PolyPath)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	lowrider 0
)

(local
	local0
	local1
	local2
)

(instance lowrider of Rgn
	(properties)

	(method (init)
		(if (gEgo has: 23) ; license
			(= local1 1)
			(= global113 0)
		else
			(= global113 599)
		)
		(thePlate init:)
		(theCar approachVerbs: 5 4 setScript: lowRide init:) ; Talk, Inventory
		(lWindow init:)
		(rWheel init:)
		(fWheel init:)
		(rapSound vol: 40 flags: 1 play:)
		(SetFlag 13)
		(if (not (gEgo has: 23)) ; license
			(proc0_17 20)
		)
		(gAddToPics add: rWheel fWheel doit:)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(& (gEgo onControl: 0) $0004)
					(not (gCast contains: insetSuspect))
					(not (gEgo has: 23)) ; license
					(not local1)
				)
				(= local1 1)
				(insetSuspect init:)
			)
		)
	)
)

(instance getLicense of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normal: 0 view: 208 loop: 6)
				((gEgo head:) view: 208)
				(= cycles 10)
			)
			(1
				(= local1 (= save1 1))
				(insetSuspect dispose:)
				(sonnyInset init:)
				(Say sonnyInset 886 0) ; "Sir, I pulled you over because you were driving too slow in the fast lane and traffic was backing up behind you."
				(= seconds 10)
			)
			(2
				(= save1 1)
				(sonnyInset dispose:)
				(Print 886 1 #dispose #at 10 10) ; "You finish by requesting his driver's license and registration."
				(= seconds 5)
			)
			(3
				(= local1 (= save1 1))
				(insetSuspect init:)
				(Say insetSuspect 886 2) ; "Whatchu talkin' `bout man? You guys always just want to hassle me!"
				(suspectMouth setCycle: RandCycle)
				(suspectArm cel: 1 forceUpd:)
				(= seconds 8)
			)
			(4
				(= save1 1)
				(Say insetSuspect 886 3) ; "Say esse, you can check out my ride.  I have a brand new smoglia device. Jus' don't lean on my new paint job."
				(suspectArm cel: 0 forceUpd:)
				(= seconds 10)
			)
			(5
				(= save1 1)
				(insetSuspect dispose:)
				(Print 886 4 #dispose #at 10 10) ; "After checking the registration, you hand it back to him and he says..."
				(= seconds 5)
			)
			(6
				(= save1 1)
				(insetSuspect init:)
				(Say insetSuspect 886 5) ; "You pigs are all the same man!"
				(suspectMouth setCycle: RandCycle)
				(suspectArm cel: 1 forceUpd:)
				(= seconds 4)
			)
			(7
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetSuspect dispose:)
				(gEgo normal: 1 view: 1 loop: 5 get: 23) ; license
				((gEgo head:) view: 1)
				((gInventory at: 23) state: 1) ; license
				(HandsOn)
				(= global113 0)
				(self dispose:)
			)
		)
	)
)

(instance stuffLuck of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (& (gEgo onControl: 0) $0004))
					(gEgo setMotion: PolyPath 219 133 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo normal: 0 view: 208 loop: 6)
				((gEgo head:) view: 208)
				(= cycles 10)
			)
			(2
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 886 6) ; "I am going to issue you a citation for impeding traffic."
				(= seconds 7)
			)
			(3
				(= save1 1)
				(sonnyInset dispose:)
				(insetSuspect init:)
				(suspectMouth setCycle: RandCycle)
				(Say insetSuspect 886 7) ; "I can not belief this man, I was jus' trying to keep from getting bugs all over my new flame job man."
				(suspectArm cel: 1 forceUpd:)
				(= seconds 7)
			)
			(4
				(gEgo normal: 1 view: 1 loop: 5 get: 23) ; license
				((gEgo head:) view: 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= local2 (= local0 1))
				(insetSuspect dispose:)
				(HandsOn)
				(if (not (gCurRoom script:))
					(theCar setScript: ticketTimeScript)
				)
				(self dispose:)
			)
		)
	)
)

(instance giveCitation of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(theCar setScript: 0)
				(if (not (& (gEgo onControl: 0) $0004))
					(gEgo setMotion: PolyPath 219 133 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo normal: 0 view: 208 loop: 6)
				((gEgo head:) view: 208)
				(= cycles 10)
			)
			(2
				(= save1 1)
				(Print 886 8 #dispose #at 10 10) ; "After handing the ticket and his license to Mr. Ruiz, he says..."
				(= seconds 7)
			)
			(3
				(= save1 1)
				(insetSuspect init:)
				(suspectMouth setCycle: RandCycle)
				(suspectArm cel: 1 forceUpd:)
				(Say insetSuspect 886 9) ; "Iieee! Man, you pigs make me want to puke, man!"
				(= seconds 8)
			)
			(4
				(= save1 1)
				(Say insetSuspect 886 10) ; "I'll see you in the people's court, man!"
				(= seconds 8)
			)
			(5
				(= save1 1)
				(Say insetSuspect 886 11) ; "Judge Wapner will take care of you, esse!"
				(= seconds 8)
			)
			(6
				(= save1 1)
				(insetSuspect dispose:)
				(sonnyInset init:)
				(Say sonnyInset 886 12) ; "And you have a nice day, sir."
				(= seconds 4)
			)
			(7
				(sonnyInset dispose:)
				(gEgo normal: 1 view: 1 loop: 5 get: 23) ; license
				((gEgo head:) view: 1)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(SetFlag 221)
				(gEgo put: 23 886) ; license
				(gEgo put: 24 886) ; ticket
				(insetSuspect dispose:)
				(= global113 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance ticketTimeScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetSuspect dispose:)
				(= seconds 30)
			)
			(1
				(switch local0
					(0
						(= save1 1)
						(insetSuspect init:)
						(Say 886 13)
						(suspectMouth setCycle: RandCycle)
						(suspectArm cel: 1 forceUpd:)
						(= seconds 7)
						(++ local0)
						(= state -1)
					)
					(1
						(Print 886 14) ; "Better write this guy a ticket and get on with life!"
						(= cycles 1)
					)
				)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetSuspect dispose:)
				(self dispose:)
			)
		)
	)
)

(instance lowRide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theCar
					setStep: 1 1
					setMotion: MoveTo (theCar x:) (- (theCar y:) 3) self
				)
				(shockSound number: 296 play:)
			)
			(1
				(theCar stopUpd:)
				(= seconds 2)
			)
			(2
				(theCar setMotion: MoveTo (theCar x:) (+ (theCar y:) 3) self)
				(shockSound number: 299 play:)
			)
			(3
				(theCar stopUpd:)
				(if (< (gEgo x:) 160)
					(= state -1)
				)
				(= seconds 2)
			)
			(4
				(theCar posn: 209 161 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance letGo of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (& (gEgo onControl: 0) $0004))
					(gEgo setMotion: PolyPath 219 133 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo normal: 0 view: 208 loop: 6)
				((gEgo head:) view: 208)
				(= cycles 10)
			)
			(2
				(Print 886 15) ; "You decide not to issue Mr. Ruiz a citation. Handing him his license you say..."
				(= cycles 1)
			)
			(3
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 886 16) ; "Mr. Ruiz, I'm going to let you go with a warning this time. Just drive with the flow of traffic from now on."
				(= seconds 8)
			)
			(4
				(= save1 1)
				(sonnyInset dispose:)
				(insetSuspect init:)
				(suspectMouth setCycle: RandCycle)
				(Say insetSuspect 886 17) ; "Alright esse! Thanks man. Sorry `bout that pig thing man!"
				(suspectArm cel: 1 forceUpd:)
				(= seconds 5)
			)
			(5
				(= save1 1)
				(insetSuspect dispose:)
				(sonnyInset init:)
				(Say sonnyInset 886 18) ; "And you have a good day, sir."
				(= seconds 4)
			)
			(6
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sonnyInset dispose:)
				(gEgo normal: 1 view: 1 loop: 5 put: 23 886) ; license
				((gInventory at: 24) moveTo: 886) ; ticket
				((gEgo head:) view: 1)
				(ClearFlag 13)
				(SetFlag 216)
				(= global113 0)
				(self dispose:)
			)
		)
	)
)

(instance insetSuspect of Prop
	(properties
		x 65
		y 160
		approachX 219
		approachY 133
		_approachVerbs 48
		lookStr {A mean looking dude ain't he.}
		view 338
		priority 15
		signal 16401
	)

	(method (dispose)
		(suspectMouth dispose:)
		(suspectArm dispose:)
		(super dispose:)
	)

	(method (init)
		(suspectMouth
			x: (+ (self x:) 30)
			y: (- (self y:) 40)
			z: (self z:)
			init:
		)
		(suspectArm x: (+ (self x:) 49) y: (self y:) z: (self z:) init:)
		(self stopUpd:)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(HandsOff)
				(cond
					((gEgo has: 24) ; ticket
						(gCurRoom setScript: giveCitation)
					)
					(local2
						(Print 886 19) ; "He doesn't look too pleased. Better get on with it."
						(HandsOn)
					)
					((gEgo has: 23) ; license
						(gCurRoom setScript: stuffLuck)
					)
					(else
						(gCurRoom setScript: getLicense)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance suspectMouth of Prop
	(properties
		view 338
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance suspectArm of Prop
	(properties
		view 338
		loop 2
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance theCar of Actor
	(properties
		x 209
		y 161
		description {car}
		approachX 219
		approachY 133
		lookStr {It's a lowered 58 Ford Fairlane. Nice flame job!}
		view 359
		signal 22528
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(HandsOff)
				(cond
					((gEgo has: 24) ; ticket
						(gCurRoom setScript: giveCitation)
					)
					(local2
						(Print 886 19) ; "He doesn't look too pleased. Better get on with it."
						(HandsOn)
					)
					((gEgo has: 23) ; license
						(gCurRoom setScript: stuffLuck)
					)
					(else
						(gCurRoom setScript: getLicense)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(23 ; license
						(HandsOff)
						(gCurRoom setScript: letGo)
					)
					(24 ; ticket
						(gCurRoom setScript: giveCitation)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(3 ; Do
				(Print 886 20) ; "What are you going to do? Kick the tires?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rWheel of PicView
	(properties
		x 199
		y 160
		description {car}
		view 359
		loop 1
		priority 1
		signal 16400
	)

	(method (doVerb theVerb)
		(theCar doVerb: theVerb)
	)
)

(instance fWheel of PicView
	(properties
		x 262
		y 138
		description {car}
		view 359
		loop 1
		cel 1
		priority 1
		signal 16400
	)
)

(instance lWindow of Prop
	(properties
		x 223
		y 136
		description {car}
		view 359
		loop 2
		cel 1
		priority 14
		signal 16400
		cycleSpeed 0
	)

	(method (doit)
		(rapSound vol: (- 127 (Abs (- (gEgo x:) (theCar x:)))))
		(self y: (- (theCar y:) 25))
		(super doit:)
		(if (== (rapSound prevSignal:) 10)
			(self setCycle: Beg)
		)
	)
)

(instance thePlate of Prop
	(properties
		x 154
		y 154
		description {car}
		lookStr {The plate reads - 22776}
		view 359
		cel 1
		signal 16384
	)

	(method (doit)
		(self y: (- (theCar y:) 7))
		(super doit:)
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

(instance rapSound of Sound
	(properties
		flags 1
		number 289
		loop -1
	)
)

(instance shockSound of Sound
	(properties)
)

