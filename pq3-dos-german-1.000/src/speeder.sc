;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 887)
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
	speeder 0
)

(local
	local0
)

(instance speeder of Rgn
	(properties)

	(method (init)
		(super init:)
		(thePlate init:)
		(theCar init:)
		(SetFlag 12)
		(if (not (gEgo has: 23)) ; license
			(proc0_17 20)
			(= global113 599)
		else
			(= global113 0)
		)
		(speederSound init: play:)
	)

	(method (doit)
		(cond
			(script 0)
			(
				(and
					(& (gEgo onControl: 0) $0004)
					(not (gCast contains: insetSuspect))
					(not (gEgo has: 23)) ; license
					(!= ((gInventory at: 23) owner:) 887) ; license
				)
				(insetSuspect init:)
				(suspectMouth setCycle: 0 cel: 0)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance getLicense of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 5)
				(insetSuspect init:)
				(= cycles 2)
			)
			(1
				(= save1 1)
				(suspectMouth setCycle: RandCycle)
				(Say insetSuspect 887 0) ; "Good Lord! Where'd YOU come from? Ya musta fell from outta the sky, man, 'cause I never saw ya!"
				(= seconds 7)
			)
			(2
				(= save1 1)
				(insetSuspect hide:)
				(sonnyInset init:)
				(Say sonnyInset 887 1) ; "Sir, I'll need to see your driver's license and vehicle registration please."
				(= seconds 5)
			)
			(3
				(= save1 1)
				(Say sonnyInset 887 2) ; "Do you know why I stopped you?"
				(= seconds 4)
			)
			(4
				(= save1 1)
				(sonnyInset dispose:)
				(insetSuspect show:)
				(= cycles 1)
			)
			(5
				(Say insetSuspect 887 3) ; "I know, I know. I was speedin'. I had ta do it, man. See, I'm on my way ta see this beautifully constructed female. A real Nubian Queen! Know what I mean?"
				(= seconds 7)
			)
			(6
				(= save1 1)
				(Say insetSuspect 887 4) ; "Try ta picture it, Officer! She's got these LEGS.... Have mercy! They go ALL the way up! Can I help it if I'm a sucka for beauty?"
				(= seconds 7)
			)
			(7
				(= save1 1)
				(Say insetSuspect 887 5) ; "See, it was takin' WAY too long ta get ta her house. Another ten minutes and I wouldna been able to drive at all. You know what I mean... don't you, Officer?"
				(= seconds 9)
			)
			(8
				(= save1 1)
				(Say insetSuspect 887 6) ; "I'm sure ya wouldn't want a man in my condition drivin' around causin' accidents, now would ya? I was jus' tryin' ta get off - the road, that is."
				(= seconds 7)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetSuspect hide:)
				(gEgo get: 23) ; license
				((gInventory at: 23) state: 2) ; license
				(theCar setScript: giveWarning)
				(insetSuspect hide:)
				(HandsOn)
				(= global113 0)
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
				(theCar setScript: 0)
				(gEgo loop: 5)
				(= cycles 10)
			)
			(1
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 887 7) ; "I'm sorry, Mr. Hanley. I sympathize with you, but you're going to have to be more responsible when you're operating a moving vehicle."
				(= seconds 10)
			)
			(2
				(= save1 1)
				(sonnyInset dispose:)
				(insetSuspect init:)
				(suspectMouth setCycle: RandCycle)
				(Say insetSuspect 887 8) ; "Gotta give me a ticket, huh? Well, that's what I get for bein' a hero. Yer jus' doin' yer job. Am I OK to go now?"
				(= seconds 10)
			)
			(3
				(= save1 1)
				(insetSuspect dispose:)
				(sonnyInset init:)
				(Say sonnyInset 887 9) ; "You're all set. Slow it down and have a good evening."
				(= seconds 6)
			)
			(4
				(= save1 1)
				(sonnyInset dispose:)
				(insetSuspect init:)
				(suspectMouth setCycle: RandCycle)
				(Say insetSuspect 887 10) ; "Oh, I WILL!"
				(= seconds 3)
			)
			(5
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(HandsOn)
				(gEgo put: 23 887) ; license
				(gEgo put: 24 887) ; ticket
				(insetSuspect dispose:)
				(self dispose:)
			)
		)
	)
)

(instance giveWarning of rmnScript
	(properties)

	(method (doit)
		(super doit:)
		(if (or (not (gEgo normal:)) (gCurRoom script:))
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 60)
			)
			(1
				(HandsOff)
				(if (not (& (gEgo onControl: 0) $0004))
					(gEgo setMotion: PolyPath 219 133 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo loop: 5)
				(= cycles 10)
			)
			(3
				(= save1 1)
				(sonnyInset init:)
				(Say sonnyInset 887 11) ; "Mr. Hanley, if you promise to slow it down, I'll give you a warning."
				(= seconds 5)
			)
			(4
				(= save1 1)
				(sonnyInset dispose:)
				(insetSuspect init:)
				(suspectMouth setCycle: RandCycle)
				(Say insetSuspect 887 12) ; "Whoa! No kiddin'?! That's what I call a man lookin' out for another man - keepin' all the beauties in life satisfied! Know what I mean?"
				(= seconds 10)
			)
			(5
				(= save1 1)
				(insetSuspect hide:)
				(sonnyInset init:)
				(Say sonnyInset 887 13) ; "I hear ya. Slow it down and have a good evening."
				(= seconds 5)
			)
			(6
				(sonnyInset dispose:)
				(insetSuspect show:)
				(= cycles 1)
			)
			(7
				(= save1 1)
				(Say insetSuspect 887 10) ; "Oh, I WILL!"
				(= seconds 3)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(insetSuspect dispose:)
				((gInventory at: 24) owner: 887) ; ticket
				(gEgo put: 23 887) ; license
				(SetFlag 12)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance insetSuspect of Prop
	(properties
		x 250
		y 140
		approachX 219
		approachY 133
		_approachVerbs 24
		view 336
		priority 15
		signal 16401
	)

	(method (show)
		(super show:)
		(suspectMouth show:)
		(suspectEye setScript: blinkEyes show:)
		(suspectHead show:)
	)

	(method (hide)
		(super hide:)
		(suspectMouth hide:)
		(suspectEye setScript: 0 hide:)
		(suspectHead hide:)
	)

	(method (dispose)
		(suspectHead dispose:)
		(suspectMouth dispose:)
		(suspectEye setScript: 0 dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(self stopUpd: 1)
		(suspectHead
			view: (self view:)
			x: (self x:)
			y: (self y:)
			stopUpd: 1
			init:
		)
		(suspectMouth
			view: (self view:)
			x: (self x:)
			y: (self y:)
			stopUpd: 1
			setCycle: RandCycle
			init:
		)
		(suspectEye
			view: (self view:)
			x: (self x:)
			y: (+ (self y:) 2)
			z: 7
			stopUpd: 1
			setScript: blinkEyes
			init:
		)
	)

	(method (doit)
		(super doit:)
		(if (not (& (gEgo onControl: 0) $0004))
			(insetSuspect dispose:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(HandsOff)
				(cond
					((gEgo has: 24) ; ticket
						(gCurRoom setScript: giveCitation)
					)
					((gEgo has: 23) ; license
						(giveWarning start: 1)
						(theCar setScript: giveWarning)
					)
					(else
						(gCurRoom setScript: getLicense)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(24 ; ticket
						(HandsOff)
						(gCurRoom setScript: giveCitation)
					)
					(else
						(Print 887 14) ; "Yea right dude."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance suspectHead of Prop
	(properties
		view 336
		cel 1
		priority 15
		signal 16401
	)
)

(instance suspectMouth of Prop
	(properties
		view 336
		loop 2
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance suspectEye of Prop
	(properties
		view 336
		loop 1
		priority 15
		signal 16401
	)
)

(instance blinkEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(suspectEye cel: 1)
				(= cycles 4)
			)
			(2
				(suspectEye cel: 0)
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

(instance theCar of Actor
	(properties
		x 209
		y 161
		description {car}
		approachX 219
		approachY 133
		_approachVerbs 24
		view 337
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 887 15) ; "The convertible has only one occupant. There's nothing unusual looking about him."
			)
			(5 ; Talk
				(HandsOff)
				(cond
					((gEgo has: 24) ; ticket
						(gCurRoom setScript: giveCitation)
					)
					((gEgo has: 23) ; license
						(giveWarning start: 1)
						(theCar setScript: giveWarning)
					)
					(else
						(gCurRoom setScript: getLicense)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(24 ; ticket
						(HandsOff)
						(gCurRoom setScript: giveCitation)
					)
					(else
						(Print 887 14) ; "Yea right dude."
					)
				)
			)
			(3 ; Do
				(Print 887 16) ; "What are you going to do? Kick the tires?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thePlate of Prop
	(properties
		x 162
		y 149
		description {plate}
		view 337
		cel 2
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 887 17) ; "The plate reads - 34567."
			)
			(else
				(super doVerb: theVerb invItem &rest)
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

(instance speederSound of Sound
	(properties
		number 291
		loop -1
	)
)

