;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Interface)
(use Wander)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm34 0
)

(local
	work
	seenHenchette
	goto95
	localBS
	swamInSuit
	henchInvited
)

(instance mDiving of Sound
	(properties
		number 21
		priority 100
		loop -1
	)
)

(instance rm34 of Rm
	(properties
		picture 34
		horizon 5
	)

	(method (init)
		(Load rsVIEW 310)
		(Load rsVIEW 134)
		(Load rsVIEW 135)
		(Load rsVIEW 137)
		(Load rsVIEW 138)
		(Load rsVIEW 139)
		(Load rsSOUND 21)
		(super init:)
		(mDiving init:)
		(gAddToPics
			add: aView1 aView2 aView3 aView4 aView5 aView6 aView7 aView8
			doit:
		)
		(aWake
			setPri: 2
			setCycle: Fwd
			cycleSpeed: 4
			ignoreActors:
			isExtra: 1
			init:
		)
		(aDrain setPri: 3 setCycle: Fwd cycleSpeed: 7 ignoreActors: init:)
		(aHead2
			setPri: 10
			cycleSpeed: 2
			minPause: 20
			maxPause: 30
			ignoreActors:
			isExtra: 1
			init:
		)
		(aHead6
			setPri: 10
			cycleSpeed: 1
			minPause: 16
			maxPause: 40
			ignoreActors:
			init:
		)
		(aHead7
			setPri: 10
			cycleSpeed: 3
			minPause: 12
			maxPause: 31
			ignoreActors:
			init:
		)
		(self setRegions: 300 setScript: rm34Script) ; rm300
		(if (== gCurrentEgoView 132)
			(self setRegions: 8) ; rm8
			(= gCurrentHenchView 311)
			(Load rsVIEW 311)
			(aHench
				view: gCurrentHenchView
				illegalBits: -32768
				observeControl: 256
				setCycle: Walk
				init:
				setScript: henchScript
			)
		)
		(aMan
			setLoop: 4
			illegalBits: -513
			init:
			setMotion: Wander
			moveSpeed: 5
			cycleSpeed: 5
			setStep: 1 1
		)
		(if (== gPrevRoomNum 134)
			(= gCurrentStatus 1006)
			(gEgo
				view: 134
				setLoop: -1
				setCycle: Fwd
				setPri: -1
				setMotion: 0
				setStep: 3 2
				illegalBits: -1
				ignoreControl: 512 256
				posn: 157 83
				cycleSpeed: 1
				moveSpeed: 1
				baseSetter: (= localBS BSetter)
				init:
			)
		else
			(NormalEgo 3)
			(gEgo posn: 157 183 init:)
		)
		(User canControl: 1 canInput: 1)
	)

	(method (dispose)
		(DisposeScript 970)
		(super dispose:)
	)
)

(instance rm34Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (& (gEgo onControl:) $0400) (== gCurrentStatus 0))
			(gEgo posn: 55 88)
			(self changeState: 1)
		)
		(if (and (& (gEgo onControl:) $1000) (== gCurrentStatus 0))
			(gEgo posn: 255 88)
			(self changeState: 1)
		)
		(if (and (& (gEgo onControl:) $0100) (== gCurrentStatus 0))
			(self changeState: 1)
		)
		(if (== 3 (gEgo edgeHit:))
			(if (== goto95 0)
				(gCurRoom newRoom: 31)
			else
				(Print 34 0) ; "You allow yourself to be seduced by the beautiful woman and quickly become close friends, then head for the ship's fantail where she parks her private helicopter. A short, romantic chopper ride across the South Pacific is followed by an intriguing look at her impressive garage door, hidden suspiciously by a mountain waterfall."
				(Print 34 1 #draw) ; "Later, that night..."
				(= gCurrentStatus 23)
				(gCurRoom newRoom: 95)
			)
		)
		(if (and gHenchOnScreen henchInvited (> (gEgo y:) 181))
			(= henchInvited 0)
			(= goto95 1)
			(gCurRoom south: 95)
			(Print 34 2) ; "Hey, baby," you cry, "wait for me!!"
			(HandsOff)
			(gEgo setMotion: MoveTo (gEgo x:) 234)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/man,children')
				(Print 34 3) ; "They are all too busy sunbathing to talk to you."
			)
			(if (Said '/airport,barstool')
				(if (!= gCurrentStatus 1009)
					(Print 34 4) ; "There's only one deck chair left."
				else
					(Print 34 5) ; "The webbing has stretched considerably since you plopped down!"
				)
			)
			(if (Said '<below/airport,barstool')
				(SeeNothing) ; "You see nothing special."
			)
			(if (Said '/inner')
				(Print 34 6) ; "Just think how ugly he must look from underneath!"
			)
			(if (Said '/flower,palm')
				(Print 34 7) ; "Your botanical investigation leads to nothing."
			)
			(if (Said '[/water,craft,airport]')
				(cond
					((== gCurrentStatus 1006)
						(Print 34 8) ; "Everything around you looks wet."
					)
					((== gCurrentStatus 1008)
						(Print 34 9) ; "You're too busy watching your life pass before your eyes!"
					)
					((== gCurrentStatus 1009)
						(Print 34 10) ; "You look straight up and see lots of blue sky."
					)
					(else
						(Print 34 11) ; "Doesn't that pool look refreshing?"
						(Print 34 12) ; "There is one empty chaise lounge by the pool."
					)
				)
			)
		)
		(if (or (Said '(get<in),board/water,water') (Said 'bathing'))
			(cond
				((== gCurrentStatus 1006)
					(Print 34 13) ; "You are!"
				)
				((!= gCurrentStatus 1008)
					(Print 34 14) ; "Good idea, Larry."
					(Print 34 15) ; "Try stepping into the pool first!"
				)
				(else
					(Ok) ; "Ok."
					(self changeState: 4)
				)
			)
		)
		(if
			(or
				(Said 'disembark/water,water')
				(Said 'get,climb<off')
				(Said 'apply,climb/ladder')
			)
			(cond
				((!= gCurrentStatus 1006)
					(NotNow) ; "Not now!"
				)
				((not (& (gEgo onControl:) $0100))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Ok) ; "Ok."
					(self changeState: 7)
				)
			)
		)
		(if (or (Said 'board,bathing/underwater') (Said 'dive'))
			(cond
				((== gCurrentStatus 1008)
					(Print 34 16) ; "You can't. You're too busy drowning!"
				)
				((!= gCurrentStatus 1006)
					(Print 34 17) ; "You try repeatedly to dive into the concrete pool deck with no success!"
				)
				((& (gEgo onControl:) $0100)
					(Print 34 18) ; "Not here! You might hit the edge of the pool."
				)
				(else
					(Ok) ; "Ok."
					(self changeState: 5)
					(mDiving play:)
				)
			)
		)
		(if
			(or
				(Said 'lie,board,bath[/bed,airport,barstool]')
				(Said 'bath[/down,airport,barstool]')
			)
			(cond
				((== gCurrentStatus 1009)
					(Print 34 19) ; "This is too comfortable for you to change positions now!"
				)
				((not (gEgo inRect: 139 102 199 134))
					(NotClose) ; "You're not close enough."
				)
				((!= gCurrentEgoView 132)
					(Print 34 20) ; "You're not properly dressed for sunbathing; where's your swimming suit?"
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(else
					(self changeState: 9)
				)
			)
		)
		(if (or (Said 'new,(new[<up]),(get<up)') (Said 'disembark[/barstool]'))
			(cond
				((== gCurrentStatus 0)
					(Print 34 13) ; "You are!"
				)
				((and (<= (henchScript state:) 4) (== gHenchOnScreen 1))
					(Print 34 21) ; "Not now! There's someone coming."
				)
				((!= gCurrentStatus 1009)
					(NotNow) ; "Not now!"
				)
				(else
					(self changeState: 15)
				)
			)
		)
		(if (or (Said 'breathe') (Said 'get/breath'))
			(Ok) ; "Ok."
		)
		(if (or (Said 'pull,pull<over') (Said 'lie<on/front,stomach,ear'))
			(Print 34 22) ; "Nah. That's unnecessary."
		)
		(if (Said '/woman>')
			(cond
				((Said 'talk/')
					(if gHenchOnScreen
						(Print (Format @gString 34 23 gLaffer)) ; ""Hi ya, beautiful," you tell her. %s"
					else
						(Print 34 24) ; "To whom are you speaking? There are no girls here."
					)
				)
				((Said 'look/')
					(if gHenchOnScreen
						(Print 34 25) ; "You have always loved bathing suits with the consistency of facial tissue!"
					else
						(Print 34 26) ; "Where? There's nothing here but guys."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(User canControl: 0)
				(= gCurrentEgoView (gEgo view:))
				(= gCurrentStatus 1008)
				(if (== gCurrentEgoView 100)
					(= swamInSuit 1)
					(= work 137)
					(User canInput: 0)
				else
					(= work 138)
				)
				(gEgo
					view: work
					illegalBits: -1
					ignoreControl: 256 512
					cycleSpeed: 1
					moveSpeed: 1
					setStep: 2 2
					setCycle: Fwd
					setMotion: Wander
				)
				(= seconds 5)
			)
			(2
				(= gCurrentStatus 1000)
				(User canInput: 0)
				(gEgo cel: 0 setCycle: End self setMotion: 0)
			)
			(3
				(if (== swamInSuit 1)
					(Print 34 27) ; "Next time, you might try swimming in something other than a thick polyester white leisure suit!"
				else
					(Print 34 28) ; "Why jump in the water if you're not going to swim?"
					(Print 34 29) ; "Surely you learned to swim when you were a little dorker?"
				)
				(= gCurrentStatus 1001)
				(gEgo hide:)
			)
			(4
				(= seconds (= cycles 0))
				(= gCurrentStatus 1006)
				(User canControl: 1)
				(gEgo
					view: 134
					setStep: 3 2
					setLoop: -1
					setMotion: 0
					baseSetter: (= localBS BSetter)
				)
			)
			(5
				(= seconds (= cycles 0))
				(HandsOff)
				(= gCurrentStatus 19)
				(gEgo
					view: 135
					loop:
						(if (or (== (gEgo loop:) 3) (== (gEgo loop:) 1))
							1
						else
							0
						)
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo hide:)
				(gCurRoom newRoom: 134)
			)
			(7
				(= seconds (= cycles 0))
				(if (== gWearingSunscreen 1)
					(= gWearingSunscreen 2)
				)
				(gEgo
					view: gCurrentEgoView
					setLoop: -1
					setPri: -1
					setMotion: 0
					setCycle: Walk
					cycleSpeed: 0
					moveSpeed: 0
					ignoreActors: 0
					illegalBits: 256
					observeControl: 512
					baseSetter: 0
				)
				(HandsOff)
				(= cycles 12)
			)
			(8
				(HandsOn)
				(Print 34 30) ; "That was refreshing!"
				(NormalEgo)
			)
			(9
				(HandsOff)
				(if (not gScoredChaise)
					(= gScoredChaise 1)
					(gGame changeScore: 3)
				)
				(Ok) ; "Ok."
				(if (< (gEgo y:) 113)
					(gEgo setMotion: MoveTo 160 112 self)
				else
					(self changeState: 10)
				)
			)
			(10
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 163 134 self
				)
			)
			(11
				(gEgo
					view: 139
					cycleSpeed: 1
					setMotion: 0
					setPri: 10
					setLoop: 0
					posn: 171 133
					cel: 0
					setCycle: End self
				)
			)
			(12
				(= gCurrentStatus 1009)
				(Print 34 31) ; "Ah! Seems like a lovely day to catch a few rays."
				(= seconds 5)
			)
			(13
				(if (== gWearingSunscreen 1)
					(User canInput: 1)
					(Print 34 32) ; "It's a good thing you applied that sunscreen!"
					(if (not seenHenchette)
						(henchScript changeState: 1)
					)
				else
					(= gCurrentStatus 1000)
					(gEgo
						setLoop: 1
						setCel: 0
						cycleSpeed: 5
						setCycle: End self
					)
				)
			)
			(14
				(Print 34 33 #at -1 20 #draw) ; "Those tropical UVs can be deadly!"
				(= gCurrentStatus 1001)
			)
			(15
				(= seconds (= cycles 0))
				(Ok) ; "Ok."
				(gEgo cycleSpeed: 1 setCycle: Beg self)
				(if (== 1 (henchScript state:))
					(henchScript changeState: 255)
				)
			)
			(16
				(gEgo posn: 163 123)
				(NormalEgo)
			)
		)
	)
)

(instance henchScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seenHenchette 1)
				(= seconds (Random 5 10))
			)
			(2
				(if (!= gCurrentStatus 1009)
					(self changeState: 1)
				else
					(aHench setMotion: MoveTo 155 129 self)
					(= gHenchOnScreen 1)
					(Notify 8 1)
				)
			)
			(3
				(aHench setMotion: MoveTo 160 129 self)
			)
			(4
				(Print 34 34) ; "Why, hello there, big fella," says the beautiful blond with the body like a brick shipyard, "why are you hanging around here? I've been looking for someone just like you for a long time. Why don't you come back to my place, and you won't have to hang around all alone ever again!"
				(Print 34 35 #at -1 130) ; "(Geez, Larry. You've finally found yourself a live one!)"
				(= seconds 5)
			)
			(5
				(Print 34 36) ; "Come on, Samson, I just can't wait to get you all alone!"
				(aHench setMotion: MoveTo 155 129 self)
				(= henchInvited 1)
			)
			(6
				(aHench setMotion: MoveTo 155 234 self)
			)
			(7
				(= seconds 10)
			)
			(8
				(aHench dispose:)
				(= gCurrentHenchView 0)
				(= gHenchOnScreen 0)
				(= henchInvited 0)
			)
		)
	)
)

(instance BSetter of Code
	(properties)

	(method (doit whom)
		(whom brBottom: (+ (whom y:) 5))
		(whom brTop: (- (whom y:) 3))
		(whom brLeft: (- (whom x:) 10))
		(whom brRight: (+ (whom x:) 10))
	)
)

(instance aView1 of PV
	(properties
		y 136
		x 11
		view 310
		loop 2
		cel 6
		priority 10
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 136
		x 45
		view 310
		loop 2
		priority 10
		signal 16384
	)
)

(instance aView3 of PV
	(properties
		y 136
		x 80
		view 310
		loop 2
		cel 1
		priority 10
		signal 16384
	)
)

(instance aView4 of PV
	(properties
		y 136
		x 115
		view 310
		loop 2
		cel 1
		priority 10
		signal 16384
	)
)

(instance aView5 of PV
	(properties
		y 136
		x 177
		view 310
		loop 2
		cel 2
		priority 10
		signal 16384
	)
)

(instance aView6 of PV
	(properties
		y 136
		x 224
		view 310
		loop 2
		cel 3
		priority 10
		signal 16384
	)
)

(instance aView7 of PV
	(properties
		y 136
		x 263
		view 310
		loop 2
		cel 4
		priority 10
		signal 16384
	)
)

(instance aView8 of PV
	(properties
		y 136
		x 303
		view 310
		loop 2
		cel 5
		priority 10
		signal 16384
	)
)

(instance aWake of Prop
	(properties
		y 53
		x 128
		view 310
	)
)

(instance aDrain of Prop
	(properties
		y 68
		x 119
		view 310
		loop 1
	)
)

(instance aHead2 of Extra
	(properties
		y 111
		x 49
		view 310
		loop 3
	)
)

(instance aHead6 of Extra
	(properties
		y 106
		x 228
		view 310
		loop 5
	)
)

(instance aHead7 of Extra
	(properties
		y 117
		x 259
		view 310
		loop 6
	)
)

(instance aMan of Act
	(properties
		y 85
		x 194
		view 310
	)
)

(instance aHench of Act
	(properties
		y 233
		x 155
	)
)

