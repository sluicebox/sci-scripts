;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use Interface)
(use Wander)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	killrudy 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(HandsOff)
	(TheMenuBar state: 0)
	(fight cycles: 0 115 0)
	(Duo setLoop: 0)
	(gEgo
		view: 52
		loop: (if (< (gEgo x:) (Duo x:)) 0 else 1)
		cel: 0
		setCycle: End fight
	)
)

(procedure (localproc_1 &tmp temp0 temp1)
	(= temp0 (+ (Rudy x:) 7))
	(= temp1 (Rudy y:))
	(TalkingHead posn: temp0 (- temp1 44) init:)
	(RightArm posn: (- temp0 4) (- temp1 32) init:)
	(LeftArm
		setLoop:
			(switch local4
				(1 8)
				(else 7)
			)
		posn: (+ temp0 4) (- temp1 37)
		init:
	)
	(Rudy
		view: 385
		setLoop: 3
		setCel: 1
		posn: temp0 temp1
		setScript: RudyTalking
		stopUpd:
	)
)

(procedure (localproc_2 &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(if (< (= local1 (/ (StrLen @temp0) 2)) 20)
		(= local1 20)
	)
)

(procedure (localproc_3)
	(if local2
		(localproc_2 &rest)
		(Mouth setScript: cycleMouth)
	)
	(Print &rest #at 15 10 #font 4 #mode 1 #draw #width 280 #dispose)
)

(procedure (localproc_4)
	(DrawPic 282 6 1 global61)
	(DrawPic local0 7 0 global61)
	(gCast eachElementDo: #hide)
	(Head show:)
	(Mouth show:)
	(Eye setScript: BigEye show:)
	(gFeatures dispose:)
)

(procedure (localproc_5)
	(DrawPic gCurRoomNum 7)
	(gAddToPics doit:)
	(gCast eachElementDo: #show)
	(Head hide:)
	(Mouth hide:)
	(Eye setScript: 0 hide:)
	((gGate downID:) hide:)
	((gGate upID:) hide:)
)

(procedure (localproc_6 param1)
	(Head cel: param1)
	(Eye loop: (+ 2 (* param1 3)) cel: 0)
	(= local5 (Eye loop:))
	(Mouth loop: (+ 3 (* param1 3)) cel: 1)
	(= local2 1)
	(localproc_4)
)

(instance myMusic of Sound
	(properties)
)

(instance arena of Cage
	(properties)
)

(instance killrudy of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(LoadMany rsPIC 182 282 382)
		(LoadMany rsVIEW 52 182 301 308 314 380 383 385 395)
		(LoadMany rsSOUND 24 25 31 34 56)
		(= global195 768)
		(Head init: hide:)
		(Eye init: hide:)
		(Mouth init: hide:)
		(if (!= [gCycleTimers 0] 1)
			(arena left: 95 right: 213 bottom: 144 top: 124 init:)
			(Duo observeBlocks: arena init:)
		else
			(SetFlag 33)
			(HandsOff)
			(TheMenuBar state: 0)
			(Rudy view: 385 loop: 2 posn: 130 126)
			(Rudy cel: (Rudy lastCel:) init:)
			(Colonel view: 385 loop: 1 posn: 133 128)
			(Colonel cel: (Colonel lastCel:) stopUpd: init:)
		)
		(= [gCycleTimers 0] 0)
		(self setScript: fight)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 976)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(= global190 0)
		(TheMenuBar state: 1)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(super handleEvent: event)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(if (Said '/rudolph,colonel')
						(Print 290 0) ; "Oh, no!! Colonel Dijon and Rudy are in the midst of a fierce struggle! You see a hypodermic needle between them and it's impossible to tell which of the two men is the aggressor. This is indeed a dangerous situation!"
					)
				)
				((Said 'talk')
					(Print 290 1) ; "Neither of them look to be in a talking mood!"
				)
				(
					(or
						(Said 'load/derringer')
						(Said 'attach,load/bullet/derringer<in,in')
					)
					(cond
						(global185
							(Print 290 2) ; "It's already loaded."
						)
						((gEgo has: 15) ; derringer
							(if (gEgo has: 14) ; bullet
								(Ok) ; "Okay."
								(gEgo put: 14 99) ; bullet
								(= global185 1)
							else
								(Print 290 3) ; "You have no bullet."
							)
						)
						(else
							(Print 290 4) ; "You have no gun."
						)
					)
				)
				((Said '*[/*]')
					(Print 290 5) ; "That isn't going to solve anything!"
				)
			)
		)
	)
)

(instance fight of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(super handleEvent: event)
		(if (== (event type:) evSAID)
			(cond
				(
					(or
						(Said 'shoot,kill/rudolph')
						(Said 'shoot/derringer/rudolph')
					)
					(cond
						(global185
							(if (== state 1)
								(= state 6)
								(= cycles 1)
								(= global185 0)
							else
								(Print 290 6) ; "Too late!"
							)
						)
						((gEgo has: 15) ; derringer
							(Print 290 7) ; "Click! Oh no! It's not loaded!"
						)
						(else
							(Print 290 8) ; "With what?"
						)
					)
				)
				(
					(or
						(Said 'shoot,kill/colonel')
						(Said 'shoot/derringer/colonel')
					)
					(cond
						(global185
							(if (== state 1)
								(= state 24)
								(= global185 0)
								(= cycles 1)
							else
								(Print 290 6) ; "Too late!"
							)
						)
						((gEgo has: 15) ; derringer
							(Print 290 7) ; "Click! Oh no! It's not loaded!"
						)
						(else
							(Print 290 8) ; "With what?"
						)
					)
				)
				((Said 'shoot/derringer')
					(Print 290 9) ; "This tricky situation requires more information."
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(if (IsFlag 33)
					(= state 3)
				)
				(= cycles 4)
			)
			(1
				(User canInput: 1 canControl: 0)
				(Print 290 0) ; "Oh, no!! Colonel Dijon and Rudy are in the midst of a fierce struggle! You see a hypodermic needle between them and it's impossible to tell which of the two men is the aggressor. This is indeed a dangerous situation!"
				(myMusic number: 24 loop: -1 play:)
				(Duo setLoop: 1 setCycle: Fwd setMotion: Wander 10)
				(= seconds 10)
			)
			(2
				(HandsOff)
				(TheMenuBar state: 0)
				(Duo setLoop: 0 setMotion: 0 setCycle: End self)
			)
			(3
				(Colonel
					view: 385
					loop: 1
					cel: 0
					posn: (- (Duo x:) 2) (Duo y:)
					setCycle: End
					init:
				)
				(Rudy
					view: 385
					loop: 2
					cel: 0
					posn: (+ (Duo x:) 2) (Duo y:)
					cycleSpeed: 2
					setCycle: End self
					init:
				)
				(Duo dispose:)
			)
			(4
				(myMusic number: 56 loop: -1 play:)
				(LeftArm setLoop: 7)
				(localproc_1)
				(if (IsFlag 33)
					(Print 290 10) ; "What's this!! Rudy is standing over the motionless body of Colonel Dijon. He is holding what appears to be a hypodermic needle in his hand!"
					(= cycles 1)
				else
					(= cycles 14)
				)
			)
			(5
				(= local0 182)
				(TheMenuBar state: 1)
				(localproc_6 0)
				(if (IsFlag 33)
					(localproc_3 290 11) ; "Hi ya, kid! I'm sorry it came to this, but there was no other choice; I had to protect myself. That old coot lured me up here and when I wasn't lookin' he tried to stick me with a hypodermic needle from Dr. Feels' bag."
				else
					(localproc_3 290 12) ; "Whew, that was close! I want you to know that I acted strictly in self-defense! That old coot lured me up here and when I wasn't lookin' he tried to stick me with a hypodermic needle from Dr. Feels' bag."
				)
				(= seconds 10)
			)
			(6
				(localproc_3 290 13) ; "I hate to think what was in it, but it must have been awful bad...look what it did to Uncle Henri! He tried to do to me what he did to the others."
				(= state 36)
				(= seconds 10)
			)
			(7
				(localproc_0)
			)
			(8
				(myMusic number: 25 loop: 1 play:)
				(gEgo loop: (+ (gEgo loop:) 2) cel: 0 setCycle: End)
				(Colonel
					view: 301
					loop: 0
					posn: (Duo x:) (Duo y:)
					setPri: 9
					init:
				)
				(Rudy
					view: 383
					cel: 0
					loop: 1
					posn: (Duo x:) (Duo y:)
					setPri: 8
					setCycle: End self
					init:
				)
				(Duo setMotion: 0 ignoreBlocks: arena hide:)
			)
			(9
				(Rudy stopUpd:)
				(myMusic number: 34 loop: 1 play:)
				(gEgo view: 0 loop: 3 setCycle: Walk)
				(Print 290 14) ; "You have shot and wounded Rudy."
				(= cycles 1)
			)
			(10
				(= seconds (= cycles 0))
				(Colonel
					setStep: 2 2
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Walk
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(- (gEgo y:) 10)
						self
				)
			)
			(11
				(= temp0 (Colonel x:))
				(= temp1 (Colonel y:))
				(Duo view: 314 loop: 0 posn: temp0 temp1 show: stopUpd:)
				(Colonel
					view: 314
					loop: 1
					cel: 0
					posn: temp0 (- temp1 22)
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(12
				(TheMenuBar state: 1)
				(= local0 382)
				(localproc_6 1)
				(= cycles 10)
			)
			(13
				(myMusic number: 31 loop: -1 play:)
				(localproc_3 290 15) ; "Uh, thank you, young lady, 'er, Laura. That was some mighty fine shootin'...for a gal. I guess I owe you my life, don't I? Why, my nephew was tryin' to kill me with poison in one of Wilbur's hypodermic needles!"
				(= seconds 18)
			)
			(14
				(localproc_3 290 16) ; "Ohhh, it's terrible what's been happenin' here tonight! I invite everyone here to tell 'em about my will and they end up killin' each other over it."
				(= seconds 12)
			)
			(15
				(cls)
				(= local2 0)
				(localproc_5)
				(Colonel setScript: coloTalking)
				(= cycles 10)
			)
			(16
				(localproc_3 290 17) ; "Truthfully, I WAS keepin' my eye on everyone in the house tonight, or so I THOUGHT! I didn't see any of the murders. It wasn't until I met Rudy in my bedroom that he told me what had happened. I couldn't believe it!"
				(= seconds 18)
			)
			(17
				(localproc_3 290 18) ; "He told me that my niece, Lillian, had finally gone totally berserk and out of a crazy jealousy was killing everyone that she thought had gotten between HER and ME!"
				(= seconds 12)
			)
			(18
				(cls)
				(= local2 1)
				(localproc_4)
				(= cycles 10)
			)
			(19
				(localproc_3 290 19) ; "She managed to just about murder everyone 'til she attacked Rudy with my derringer. Rudy managed to wrestle the gun from her and in self-defense, killed her instead!"
				(= seconds 12)
			)
			(20
				(localproc_3 290 20) ; "My nephew, seeing as how everyone else was already dead, decided to finish the job by killing me with a hypodermic needle and say I died of a heart attack induced by the terrible deeds that my niece had done!"
				(= seconds 12)
			)
			(21
				(cls)
				(= local2 0)
				(localproc_5)
				(= cycles 10)
			)
			(22
				(localproc_3 290 21) ; "I can't stand much more of this! Laura, please find Celie and tell her to fire one of the signal rockets that we use to summon help in emergencies."
				(= seconds 12)
			)
			(23
				(cls)
				(myMusic fade:)
				(= cycles 21)
			)
			(24
				(gCurRoom newRoom: 784) ; police
			)
			(25
				(localproc_0)
			)
			(26
				(= local4 1)
				(myMusic number: 25 loop: 1 play:)
				(gEgo loop: (+ (gEgo loop:) 2) cel: 0 setCycle: End)
				(Rudy
					view: 380
					cel: 0
					loop: 2
					posn: (+ (Duo x:) 2) (Duo y:)
					setPri: 9
					init:
				)
				(Colonel
					view: 308
					cel: 0
					loop: 0
					posn: (- (Duo x:) 2) (Duo y:)
					setPri: 8
					setCycle: End self
					init:
				)
				(Duo dispose:)
			)
			(27
				(Colonel stopUpd:)
				(myMusic number: 34 loop: 1 play:)
				(= seconds 1)
			)
			(28
				(Rudy
					ignoreActors: 1
					setCycle: Walk
					setMotion:
						MoveTo
						(- (Colonel x:) 5)
						(- (Colonel y:) 16)
						self
				)
				(gEgo view: 0 loop: 3 setCycle: 0)
			)
			(29
				(Rudy view: 393 loop: 0 cel: 0 setCycle: End self)
			)
			(30
				(= seconds 3)
			)
			(31
				(Rudy setCycle: Beg self)
			)
			(32
				(myMusic number: 56 loop: -1 play:)
				(LeftArm setLoop: 8)
				(localproc_1)
				(localproc_3 290 22) ; "He's dead! You have shot and killed Colonel Dijon!"
				(= seconds 4)
			)
			(33
				(TheMenuBar state: 1)
				(cls)
				(= local0 182)
				(localproc_6 0)
				(= cycles 10)
			)
			(34
				(localproc_3 290 23) ; "Thanks, kid! You saved my life! That old coot lured me up here and when I wasn't lookin' he tried to stick me with a hypodermic needle from Dr. Feels' bag."
				(Mouth setCycle: Fwd)
				(= seconds 16)
			)
			(35
				(localproc_3 290 24) ; "I hate to think what was in it, but without you comin' along I might be dead now...just like the others!"
				(= seconds 5)
			)
			(36
				(localproc_3 290 25) ; "Did you know about the others? Well...let me tell you about it."
				(= seconds 5)
			)
			(37
				(cls)
				(= local2 0)
				(localproc_5)
				(= cycles 10)
			)
			(38
				(localproc_3 290 26) ; "I found out that my uncle lured us all here so's he could kill us! He NEVER had any intention of leavin' his money to any of us at all!"
				(= seconds 10)
			)
			(39
				(localproc_3 290 27) ; "He only wanted to get rid of us. He's been sneakin' around here all night...and one by one he's been murdering everyone!"
				(= seconds 10)
			)
			(40
				(localproc_3 290 28) ; "He had us all fooled, let me tell you! He was in a lot better shape than we all thought! Well, it's a shame about everyone else, but at least you and I are still alive."
				(= seconds 10)
			)
			(41
				(cls)
				(= local2 1)
				(localproc_4)
				(= cycles 10)
			)
			(42
				(localproc_3 290 29) ; "I'm sure this night's been real traumatic for you. You go on home in the mornin' and I'll stay on here a couple more days to tend to things."
				(= seconds 10)
			)
			(43
				(localproc_3 290 30) ; "If you will, I'd like you to contact the authorities in New Orleans and let them know what happened here tonight."
				(= seconds 10)
			)
			(44
				(myMusic fade:)
				(if local4
					(localproc_3 290 31) ; "Thanks again, kid."
					(= seconds 4)
				else
					(= cycles 10)
				)
			)
			(45
				(cls)
				(gCurRoom newRoom: 785) ; goHome
			)
		)
	)
)

(instance cycleMouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Fwd show:)
				(= cycles local1)
			)
			(1
				(client cel: 0 setCycle: 0 setScript: 0)
				(self client: 0)
			)
		)
	)
)

(instance BigEye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Eye setCel: 0 forceUpd:)
				(= seconds (Random 1 3))
			)
			(1
				(if (and (not local3) (== (Random 1 2) 1))
					(Eye setLoop: (- local5 1) setCel: 1 forceUpd:)
					(= local3 1)
					(= cycles 1)
				else
					(Eye setLoop: local5 setCel: 1 forceUpd:)
					(= local3 0)
					(= seconds (Random 1 3))
				)
				(= state -1)
			)
		)
	)
)

(instance coloTalking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Colonel
					loop: (Random 2 5)
					cel: 0
					cycleSpeed: (Random 2 4)
					setCycle: Fwd
				)
				(= cycles (Random 8 16))
			)
			(1
				(Colonel loop: 5)
				(= state -1)
				(= cycles (Random 4 8))
			)
		)
	)
)

(instance RudyTalking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(TalkingHead setCycle: Fwd)
				(RightArm setCycle: Fwd)
				(LeftArm setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(TalkingHead loop: (Random 4 5))
				(RightArm cycleSpeed: (Random 6 8))
				(LeftArm cycleSpeed: (+ (RightArm cycleSpeed:) 2))
				(= state 0)
				(= seconds 1)
			)
		)
	)
)

(instance Rudy of Act
	(properties
		y 113
		x 114
		view 383
		signal 16384
	)
)

(instance Colonel of Act
	(properties
		y 113
		x 114
		view 308
		signal 16384
		illegalBits 0
	)
)

(instance Duo of Act
	(properties
		y 129
		x 114
		view 395
		signal 16384
		cycleSpeed 1
		illegalBits 0
	)
)

(instance Head of Prop
	(properties
		y 133
		x 157
		view 182
	)
)

(instance Mouth of Prop
	(properties
		y 127
		x 148
		view 182
	)
)

(instance Eye of Prop
	(properties
		y 90
		x 142
		view 182
	)
)

(instance TalkingHead of Prop
	(properties
		view 385
		loop 4
		cycleSpeed 1
	)
)

(instance RightArm of Prop
	(properties
		view 385
		loop 6
	)
)

(instance LeftArm of Prop
	(properties
		view 385
	)
)

