;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 884)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use RandCycle)
(use Chase)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	allied 0
)

(local
	local0
)

(instance allied of Rgn
	(properties)

	(method (init)
		(theCar init:)
		(= global113 599)
		(= global112 suspect)
		(suspect init:)
		(SetFlag 15)
		(proc0_17 20)
	)

	(method (doit)
		(cond
			(script
				(script doit:)
			)
			((and (not (gCurRoom script:)) (gCast contains: suspect))
				(gCurRoom setScript: alliedScript)
			)
		)
	)
)

(instance alliedScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (& (suspect onControl: 0) $0400) (not local0))
			(= local0 1)
			(Print 884 0 #dispose #at 80 10) ; "You hear the man yell to you... "Police officer!""
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable: 0)
				(User canControl: 0)
				(= cycles 5)
			)
			(1
				(Print 884 1 #dispose #at 80 10) ; "There's a large man getting out of the car to meet you."
				(suspect cycleSpeed: 6 moveSpeed: 6 setCycle: End self)
			)
			(2
				(suspect
					posn: 279 100
					setLoop: 1
					setCycle: SyncWalk
					setMotion: MoveTo 258 108 self
				)
			)
			(3
				(Print 884 2 #dispose #at 80 10) ; "The man has something in his hand that you cannot identify."
				(suspect view: 324 loop: 1 cel: 0 setCycle: End)
				(= seconds 4)
			)
			(4
				(suspect
					view: 323
					setLoop: 1
					setCycle: SyncWalk
					setMotion: Chase gEgo 25 self
				)
			)
			(5
				(client setScript: youNerd)
				(self dispose:)
			)
		)
	)
)

(instance youNerd of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(aInset init:)
				(= save1 1)
				(Say aInset 884 3) ; "I was tailing a drug runner. I couldn't I.D. myself on the road."
				(= seconds 5)
			)
			(1
				(= save1 1)
				(Say aInset 884 4) ; "Damn! Maybe I can still catch up. Are we kosher, here?"
				(= seconds 5)
			)
			(2
				(= save1 1)
				(aInset dispose:)
				(sonnyInset init:)
				(Say sonnyInset 884 5) ; "Go get him. Sorry if I screwed you up."
				(= seconds 5)
			)
			(3
				(= save1 1)
				(aInset init:)
				(sonnyInset dispose:)
				(Say aInset 884 6) ; "Hell, I was speeding. You didn't know me from Adam. I'm outta here."
				(= seconds 5)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(aInset dispose:)
				(suspect
					view: 323
					setLoop: 2
					setCycle: SyncWalk
					setMotion: MoveTo 289 100 self
				)
			)
			(5
				(suspect
					view: 323
					setLoop: 0
					posn: 300 90
					cel: 6
					setCycle: Beg self
				)
			)
			(6
				(suspect dispose:)
				(theCar setStep: 5 5 setMotion: MoveTo 375 95 self)
			)
			(7
				(= global113 0)
				(theCar dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shootHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo normal: 0 view: 8 loop: 6 cel: 0 setCycle: End self)
			)
			(1
				(suspect view: 324 loop: 0 cel: 0 setCycle: End self)
				(gunShotSound init: play:)
			)
			(2
				(gEgo view: 8 cel: 6 setCycle: Beg self)
			)
			(3
				(gEgo
					normal: 1
					view: 1
					loop: 5
					setCycle: Walk
					setMotion: MoveTo (- (suspect x:) 30) (suspect y:) self
				)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(EgoDead 16) ; "The man you killed was an allied agent reaching for his badge to I.D. himself. Your trigger finger gets you five years in jail and kills your career."
			)
		)
	)
)

(instance theCar of Actor
	(properties
		x 309
		y 127
		description {car}
		lookStr {The suspect's car.}
		view 323
		loop 3
		signal 18433
	)
)

(instance suspect of Actor
	(properties
		x 290
		y 94
		view 323
		signal 2048
		cycleSpeed 8
		moveSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; gun
						(HandsOff)
						(suspect setMotion: 0)
						(gCurRoom setScript: shootHim)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance aInset of Prop
	(properties
		x 254
		y 124
		description {Agent}
		view 325
		priority 15
		signal 16401
	)

	(method (init)
		(aMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(aMouth dispose:)
	)
)

(instance aMouth of Prop
	(properties
		description {Agent}
		view 325
		loop 1
		priority 15
		signal 16401
		cycleSpeed 10
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

(instance gunShotSound of Sound
	(properties
		number 937
	)
)

