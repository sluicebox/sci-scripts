;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 73)
(include sci.sh)
(use Main)
(use n100)
(use n101)
(use n102)
(use n106)
(use TalkObj)
(use TargActor)
(use RFeature)
(use Save)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm73 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8 = 55
	local9
	local10
	local11
	local12
	local13
)

(procedure (localproc_0 param1 &tmp temp0)
	(= temp0 0)
	(cond
		(
			(and
				(== gCurRoomNum global273)
				(or local7 global271 global272 [gInvDropped 7]) ; dagger
			)
			(gEgo get: 7 (+ local7 global271 global272 [gInvDropped 7])) ; dagger, dagger
			(HighPrint 73 0) ; "You retrieve your daggers."
			(= temp0 local7)
		)
		(param1
			(HighPrint 73 1) ; "There aren't any loose daggers here."
		)
	)
	(= [gInvDropped 7] (= local7 (= global272 (= global271 (= global273 0))))) ; dagger
	(return temp0)
)

(instance dags of Set
	(properties)
)

(instance knife1 of Act
	(properties
		view 65
	)
)

(instance knife2 of Act
	(properties
		view 65
	)
)

(instance shield of RPicView
	(properties
		y 132
		x 140
		view 73
		loop 8
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed self event 3) (Said 'look/stuff,shield,spear'))
				(HighPrint 73 2) ; "The objects on the ground are a brigand's shield and spear."
			)
		)
	)
)

(instance brunoWin of SysWindow
	(properties
		color 8
		title {Bruno:}
	)

	(method (open &tmp temp0)
		(= temp0 (- top 12))
		(-= top temp0)
		(-= bottom temp0)
		(super open:)
	)
)

(instance brutusWin of SysWindow
	(properties
		color 1
		title {Brutus:}
	)

	(method (open &tmp temp0)
		(= temp0 (- top 12))
		(-= top temp0)
		(-= bottom temp0)
		(super open:)
	)
)

(instance brunoTalk of TalkObj
	(properties
		tLoop 4
	)
)

(instance brutusTalk of TalkObj
	(properties
		tLoop 4
		cSpeed 4
	)
)

(instance brutus of TargActor
	(properties
		y 114
		x 136
		view 73
		loop 4
	)

	(method (doit)
		(brutusTalk doit:)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			(local11
				(event claimed: 1)
			)
			((super handleEvent: event))
			(
				(or
					(Said 'look/brutus,man,thief,bandit,body')
					(MouseClaimed self event 3)
				)
				(if (IsFlag 261)
					(HighPrint 73 3) ; "The dead brigand lies very still."
				else
					(HighPrint 73 4) ; "You see a hard-looking character who appears to be a thief. He must be one of the Brigands!"
				)
			)
			((Said 'get/shield')
				(if (IsFlag 261)
					(HighPrint 73 5) ; "The dead brigand's shield is not worth your while."
				else
					(HighPrint 73 6) ; "You're kidding, right?"
				)
			)
			((or (Said 'get/key') (Said 'search/bandit,man,thief,brutus,body'))
				(if (IsFlag 261)
					(if (gEgo inRect: 90 92 230 188)
						(gEgo setScript: egoSearch)
					else
						(HighPrint 73 7) ; "Get closer to him."
					)
				else
					(HighPrint 73 6) ; "You're kidding, right?"
				)
			)
			(else
				(brutusTalk handleEvent: event)
			)
		)
	)

	(method (getHurt param1)
		(if (and (<= (-= global333 param1) 0) (not (IsFlag 261)))
			(= global250 0)
			(= global332 0)
			(SetFlag 261)
			(self setScript: brutusDies)
		)
		(= global589 global333)
	)
)

(instance bruno of Act
	(properties
		y 117
		x 102
		view 65
		loop 4
	)

	(method (doit)
		(brunoTalk doit:)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'look/bruno') (MouseClaimed self event 3))
				(HighPrint 73 8) ; "This man looks very tough. From his clothing, you guess him to be a member of the Thieves' Guild."
			)
			(else
				(brunoTalk handleEvent: event)
			)
		)
	)
)

(instance target of RPicView
	(properties
		y 105
		x 187
		view 74
		priority 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed self event 3) (Said 'look/target,board,sign'))
				(if local7
					(HighPrint 73 9) ; "You are using the old archery target for dagger practice."
				else
					(HighPrint 73 10) ; "The old archery target looks as though it has not been used in quite some time."
				)
			)
		)
	)
)

(instance rm73 of Rm
	(properties
		picture 73
		style 7
		east 74
		south 80
		west 72
	)

	(method (dispose)
		(dags eachElementDo: #dispose 84 release:)
		(dags dispose:)
		(if (!= gNewRoomNum 465) ; brigandArena
			(= global332 0)
			(= global264 0)
		)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 74)
		(Load rsSOUND (SoundFX 31))
		(Load rsSCRIPT 101)
		(SL enable:)
		(super init: &rest)
		(self setLocales: 804)
		(cond
			(
				(= local0
					(if
						(and
							(IsFlag 161)
							(not (IsFlag 235))
							(== gTimeOfDay 2)
						)
						(or (== gPrevRoomNum 72) (== gPrevRoomNum 74))
					)
				)
				(= global333 (= global589 100))
				(= global332 465)
				(Load rsVIEW 65)
				(Load rsVIEW 73)
			)
			(
				(= local2
					(if global334
						(IsFlag 261)
					)
				)
				(Load rsVIEW 73)
			)
			(
				(= local4
					(if (and global334 (or (== gPrevRoomNum 72) (== gPrevRoomNum 74)))
						(not (IsFlag 261))
					)
				)
				(Load rsVIEW 73)
				(= global333 global589)
				(= global332 465)
			)
			(
				(= local1
					(if (and global334 (== gPrevRoomNum 80))
						(not (IsFlag 261))
					)
				)
				(Load rsVIEW 73)
				(= global333 global589)
				(= global332 465)
				(= global264 6)
				(brutus posn: 134 120)
			)
			((= local3 (== gPrevRoomNum 465)) ; brigandArena
				(SetFlag 261)
				(Load rsVIEW 466)
			)
		)
		(if (or local4 local1 local0)
			(shield init:)
			(gAddToPics add: shield doit:)
			(gFeatures add: shield)
		)
		(target init:)
		(gAddToPics add: target doit:)
		(gFeatures add: target)
		(NormalEgo)
		(gEgo init:)
		(= local6 0)
		(cond
			((gEgo has: 33) ; chainmail
				(= local6 5)
			)
			((gEgo has: 8) ; leather
				(= local6 3)
			)
		)
		(brutus
			targDeltaX:
				(switch local5
					(1 12)
					(-1 -12)
				)
		)
		(switch gPrevRoomNum
			(72
				(gEgo posn: 2 160 setMotion: MoveTo 57 146)
				(= local5 -1)
			)
			(74
				(gEgo posn: 319 140 setMotion: MoveTo 276 133)
				(= local5 1)
			)
			(80
				(gEgo posn: 160 187 setMotion: MoveTo 160 170)
				(= local5 0)
			)
			(else
				(gEgo posn: 165 108 setMotion: MoveTo 165 125)
			)
		)
		(cond
			(local0
				(self setScript: brigsMeet)
			)
			(local4
				(brutus init: setScript: brutusThrows)
			)
			(local1
				(self setScript: brutusLives)
			)
			(local2
				(brutus view: 466 loop: 0 cel: 7 init: stopUpd:)
				(dags add:)
				(self setScript: nobodyHere)
			)
			(local3
				(= global332 0)
				(gEgo loop: 3 posn: 140 124)
				(self setScript: brutusDies)
			)
			(else
				(dags add:)
				(self setScript: nobodyHere)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look/dagger')
						(if local7
							(HighPrint 73 11) ; "The only daggers around here are the ones you've thrown at the target."
						else
							(event claimed: 0)
						)
					)
					((Said 'get/spear')
						(HighPrint 73 12) ; "There are no useable spears near you."
					)
					((Said 'hop/bush')
						(HighPrint 73 13) ; "These bushes are full of thorns. You decide not to risk it."
					)
					((Said 'search,look/body,bandit,bruno,brutus')
						(if (IsFlag 261)
							(HighPrint 73 14) ; "Some marauding beast must have taken the brigand's body away."
						else
							(HighPrint 73 15) ; "He isn't here."
						)
					)
					((Said 'rest[/!*]')
						(if (> global334 50)
							(-= global334 50)
						)
						(event claimed: 0)
					)
					((Said 'cast>')
						(= temp0 (SaidSpell event))
						(if (CastSpell temp0)
							(switch temp0
								(18
									(HighPrint 73 16) ; "You detect no magic here."
								)
								(20
									(if (CastDazzle)
										(if
											(or
												(IsFlag 261)
												(== (self script:) nobodyHere)
											)
											(HighPrint 73 17) ; "You waste a spell."
										else
											(= local12 1)
										)
									)
								)
								(23
									(if
										(or
											(IsFlag 261)
											(== (self script:) nobodyHere)
										)
										(CastDart 0)
									else
										(CastDart brutus)
									)
								)
								(22
									(HighPrint 73 18) ; "You've wasted a spell."
									(if
										(and
											(gCast contains: brutus)
											(not (IsFlag 261))
										)
										(HighPrint 73 19) ; "The brigand is too angry to calm."
									)
								)
								(17
									(HighPrint 73 18) ; "You've wasted a spell."
									(HighPrint 73 20) ; "There's nothing here to open."
								)
								(21
									(= global250 (+ 5 (/ [gEgoStats 21] 10))) ; zapSpell
									(if (or (gEgo has: 7) (gEgo has: 6)) ; dagger, blade
										(HighPrint 73 21) ; "Your weapon is now magically charged."
									else
										(HighPrint 73 22) ; "You don't seem to have a weapon to charge."
									)
								)
								(24
									(if
										(or
											(IsFlag 261)
											(== (self script:) nobodyHere)
										)
										(HighPrint 73 23) ; "You waste a spell. Fetch is only good for fetching small, visible objects."
									else
										(HighPrint 73 24) ; "Just wait. The nice brigand will throw you his knife."
									)
								)
								(else
									(HighPrint 73 25) ; "That spell is not useful here."
								)
							)
						)
					)
					((Said 'throw/dagger,dagger')
						(= temp1 0)
						(if
							(and
								(gCast contains: brutus)
								(not (IsFlag 261))
							)
							(LookAt gEgo brutus)
							(= temp1 brutus)
						)
						(ThrowKnife temp1)
					)
					((Said 'throw/boulder')
						(= temp1 0)
						(if
							(and
								(gCast contains: brutus)
								(not (IsFlag 261))
							)
							(LookAt gEgo brutus)
							(= temp1 brutus)
						)
						(ThrowRock temp1)
					)
					((Said 'climb,climb[/wall]')
						(if gNight
							(if (< (gEgo y:) 135)
								(if (TrySkill 11 35 0) ; climbing
									(HighPrint 73 26) ; "After making sure nobody is watching, you climb over the town's wall."
									(gCurRoom newRoom: 300)
								else
									(HighPrint 73 27) ; "Climbing this wall is too difficult for your level of skill. Keep practicing."
								)
							else
								(HighPrint 73 28) ; "You're not in a good spot for climbing the wall."
							)
						else
							(HighPrint 73 29) ; "You would have trouble convincing people you are a Hero if you climbed the wall into town during the day."
						)
					)
					((Said 'look/east,south,west,forest,forest')
						(HighPrint 73 30) ; "The forest is very overgrown near here."
					)
					(
						(Said
							'look[<at,around][/!*,range,clearing,area,hamlet,wall,north,building]'
						)
						(HighPrint 73 31) ; "The wall and buildings of Spielburg can be seen over the heavy brush. An old target leans against the town wall."
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance brigsMeet of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look/man,man,thief,bandit')
				(HighPrint 73 32) ; "You see a couple of hard-looking characters talking. One looks like a thief; the other appears to be a fighter of some sort."
			)
			((Said 'ask,talk,throw,cast')
				(brunoTalk caller: 0 endTalk:)
				(brutusTalk caller: 0 endTalk:)
				(bruno setMotion: 0)
				(client setScript: egoLoses)
			)
		)
	)

	(method (changeState newState)
		(if client
			(switch (= state newState)
				(0
					(SetFlag 235)
					(brunoTalk caller: self)
					(brutusTalk caller: self)
					(bruno init:)
					(brutus init:)
					(brunoTalk tWindow: brunoWin actor: bruno init:)
					(brutusTalk tWindow: brutusWin actor: brutus init:)
					(gMouseHandler add: bruno brutus)
					(gKeyHandler add: bruno brutus)
					(= seconds 4)
				)
				(1
					(Say brunoTalk 73 33) ; "So what's this about, anyway?"
				)
				(2
					(Say brutusTalk 73 34) ; "Her Nibs is starting to get suspicious about us."
				)
				(3
					(Say brunoTalk 73 35) ; "What's the bee in her bonnet?"
				)
				(4
					(Say brutusTalk 73 36) ; "Seems the "hero" wandering around here has her leery. She thinks he's going to go for the gold on her head."
				)
				(5
					(Say brunoTalk 73 37) ; "What's it ta do with us?"
				)
				(6
					(Say brutusTalk 73 38 73 39) ; "She's been asking too many questions 'bout us."
				)
				(7
					(Say brunoTalk 73 40) ; "Then we got to avoid the ambush and use the back for a bit, 'til the heat is off."
				)
				(8
					(Say brutusTalk 73 41) ; "Maybe we should just make our move now."
				)
				(9
					(Say brunoTalk 73 42 73 43 73 44) ; "Naw, let's wait for the creep to go first."
				)
				(10
					(Say brutusTalk 73 45) ; "Where's the back door, then?"
				)
				(11
					(Say brunoTalk 73 46) ; "Where the bouncer hops around. Ya got your key still?"
				)
				(12
					(Say brutusTalk 73 47) ; "Yeah."
				)
				(13
					(Say brunoTalk 73 48) ; "Don't lose it. I got the only other one. Yull haveta search the rock for the keyhole. It's hidden good. And remember the 'word'."
				)
				(14
					(Say brutusTalk 73 49) ; "What Word?"
				)
				(15
					(Say brunoTalk 73 50) ; "The 'word' what lets ya in so that Fred goes away."
				)
				(16
					(Say brutusTalk 73 51 73 52) ; "Oh yeah, sure."
				)
				(17
					(Say brunoTalk 73 53) ; "Hiden Goseke. Ya better learn it."
				)
				(18
					(Say brutusTalk 73 54) ; "You think I'm a dummy or somethin'?"
				)
				(19
					(Say brunoTalk 73 55 73 56) ; "Say the 'word' before ya open the door or ya might make Fred mad."
				)
				(20
					(Say brutusTalk 73 57) ; "Hey, no problem. What's the 'word' again?"
				)
				(21
					(Say brunoTalk 73 58) ; "Hiden Goseke."
				)
				(22
					(Say brutusTalk 73 59) ; "Hiden Goseke. Got it."
				)
				(23
					(Say brunoTalk 73 60) ; "I gotta get back before the Chief misses me. Be back in a bit."
				)
				(24
					(Say brutusTalk 73 61) ; "Hiden Goseke. See ya."
					(SolvePuzzle 691 12)
				)
				(25
					(bruno
						illegalBits: 0
						ignoreActors:
						setLoop: -1
						setCycle: Walk
						setMotion: MoveTo 170 226 self
					)
					(User canControl: 0)
				)
				(26
					(bruno dispose:)
					(User canControl: 1)
					(= global334 300)
					(client setScript: brutusWaits)
				)
			)
		)
	)
)

(instance egoLoses of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bruno
					setLoop: (if (> (gEgo x:) 160) 5 else 6)
					cel: 0
					cycleSpeed: 2
					setCycle: CT 4 1 self
				)
			)
			(1
				(knife1
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setPri: (- (gEgo priority:) 1)
					setCycle: Fwd
					posn: (+ (bruno x:) (* local5 41)) (- (bruno y:) 24)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 22)
				)
				(bruno setCycle: CT 5 1 self)
			)
			(2
				(bruno setCycle: End)
				(knife2
					illegalBits: 0
					setLoop: 8
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					setPri: (- (gEgo priority:) 1)
					init:
					setCycle: Fwd
					posn: (+ (bruno x:) (* 41 local5)) (- (bruno y:) 27)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 25) self
				)
				(gEgo setLoop: 1)
			)
			(3
				(knife1 dispose:)
				(knife2 dispose:)
				(gEgo
					view: 516
					setLoop: 3
					cycleSpeed: 1
					setMotion: 0
					setCycle: End self
				)
			)
			(4
				(= seconds 4)
			)
			(5
				(EgoDead 73 62 82 516 2 5 80 {Keep your mouth shut.}) ; "Done in by poisoned daggers and desperate desperadoes! Try to avoid annoying that deadly duo next time."
			)
		)
	)
)

(instance brutusWaits of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'ask,talk')
				(brutus setMotion: 0)
				(client setScript: brutusThrows)
			)
			(
				(and
					(!= (brutus script:) brutusThrows)
					(not (IsFlag 261))
					(Said 'throw,cast')
				)
				(brutus setMotion: 0)
				(brutus setScript: brutusThrows)
				(event claimed: 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds global334)
			)
			(1
				(if (not (IsFlag 261))
					(brutus
						illegalBits: 0
						ignoreActors:
						setLoop: -1
						loop: 1
						setCycle: Walk
						setMotion: MoveTo 170 224 self
					)
				)
			)
			(2
				(brutus dispose:)
			)
		)
	)
)

(instance brutusDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local13
					(knife1 dispose:)
				)
				(NormalEgo)
				(gEgo setScript: 0)
				(HandsOff)
				(if (== gPrevRoomNum 465) ; brigandArena
					(gEgo posn: 152 128)
					(brutus view: 466 loop: 0 init:)
				else
					(brutus view: 73 setLoop: 7)
				)
				(brutus posn: 139 114 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(HandsOn)
				(= local11 0)
				(brutus stopUpd:)
				(dags add:)
				(client setScript: nobodyHere)
			)
		)
	)
)

(instance brutusLives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(brutus
					init:
					setCycle: Walk
					setMotion: MoveTo (gEgo x:) (gEgo y:)
				)
				(brutusTalk actor: 0)
				(HighPrint 73 63) ; "Hey, watchu doin' here? Spyin', I'll wager!"
				(= cycles 11)
			)
			(1
				(gCurRoom newRoom: 465) ; brigandArena
			)
		)
	)
)

(instance brutusThrows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(brutus
					setLoop: (if (> (gEgo x:) 160) 5 else 6)
					cel: 0
					cycleSpeed: 2
					setCycle: CT 4 1 self
				)
			)
			(1
				(brutus setCycle: CT 5 1 self)
			)
			(2
				(if local12
					(self cue:)
				else
					(brutus setCycle: End self)
					(= local11 1)
				)
			)
			(3
				(if local12
					(self cue:)
				else
					(= local13 1)
					(knife1
						illegalBits: 0
						setLoop: 7
						ignoreActors:
						ignoreHorizon:
						xStep: 6
						yStep: 7
						init:
						setPri: (- (gEgo priority:) 1)
						setCycle: Fwd
						posn: (+ (brutus x:) (* local5 32)) (- (brutus y:) 20)
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 22) self
					)
				)
			)
			(4
				(if local13
					(= local13 0)
					(knife1 dispose:)
					(if (not (TakeDamage (- 10 local6)))
						(self changeState: 7)
					)
					(gEgo
						view: 513
						setLoop: (if (== local5 1) 3 else 2)
						cycleSpeed: 1
						setMotion: 0
						setCycle: End
					)
					(= cycles 12)
				else
					(self cue:)
				)
			)
			(5
				(NormalEgo)
				(LookAt gEgo brutus)
				(= local11 0)
				(if local12
					(= seconds 12)
					(= local12 0)
				else
					(= seconds 3)
				)
			)
			(6
				(self changeState: 0)
			)
			(7
				(gEgo
					view: 516
					setLoop: 2
					setCel: -1
					cel: 0
					cycleSpeed: 1
					setMotion: 0
					setCycle: End self
				)
			)
			(8
				(= seconds 3)
			)
			(9
				(EgoDead 73 64 82 516 2 5 80 {Daggered to death.}) ; "Done in by daggers and a desperate desperado! Try to avoid annoying that deadly duo next time."
			)
		)
	)
)

(instance nobodyHere of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'throw/dagger,dagger')
				(cond
					((or (== gPrevRoomNum 72) (== gPrevRoomNum 74))
						(HighPrint 73 65) ; "There are too many bushes between you and the target."
					)
					((< (gEgo y:) 135)
						(HighPrint 73 66) ; "You're too close to the target for it to be a challange."
					)
					((gEgo has: 7) ; dagger
						(if (!= global273 gCurRoomNum)
							(= global273 gCurRoomNum)
							(= global271 (= global272 0))
						)
						(-- [gInvNum 7]) ; dagger
						(++ local7)
						(self changeState: 6)
					)
					(else
						(HighPrint 73 67) ; "You have no daggers to throw."
					)
				)
			)
			((and (Said 'get/dagger') (localproc_0 1))
				(self changeState: 1)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors:)
				(= local9 (gEgo y:))
				(cond
					((< (gEgo x:) 129)
						(gEgo setMotion: MoveTo 134 (gEgo y:) self)
					)
					((> (gEgo x:) 180)
						(gEgo setMotion: MoveTo 173 (gEgo y:) self)
					)
					((< (gEgo y:) 110)
						(gEgo setMotion: MoveTo (gEgo x:) 116 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gEgo setMotion: MoveTo 186 109 self)
			)
			(3
				(dags eachElementDo: #dispose 84 release:)
				(= seconds 2)
			)
			(4
				(dags add:)
				(gEgo
					setMotion:
						MoveTo
						156
						(if (> local9 115) local9 else 115)
						self
				)
			)
			(5
				(NormalEgo)
				(gEgo loop: 3)
				(HandsOn)
			)
			(6
				(HandsOff)
				(gEgo
					view: 510
					setLoop: 2
					cel: 0
					cycleSpeed: 2
					setCycle: CT 3 1 self
				)
			)
			(7
				(gEgo setCycle: End)
				(TrySkill 10 0 20) ; throwing
				(= temp3 (/ (- 120 [gEgoStats 10]) 10)) ; throwing
				(= temp1 (- (Random 0 temp3) (/ temp3 2)))
				(= temp2 (- (Random 0 temp3) (/ temp3 2)))
				(knife1
					illegalBits: 0
					setLoop: 7
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setPri: (- (gEgo priority:) 1)
					setCycle: Fwd
					posn: (+ (gEgo x:) 30) (- (gEgo y:) 24)
					setMotion:
						MoveTo
						(+ (target x:) temp1)
						(+ (- (target y:) 22) temp2)
						self
				)
			)
			(8
				(if (< local7 local8)
					((= temp0 (Prop new:))
						init:
						view: 65
						loop: 7
						cel: (Random 0 6)
						posn: (knife1 x:) (knife1 y:)
						stopUpd:
					)
					(dags add: temp0)
				)
				(knife1 dispose:)
				(NormalEgo)
				(gEgo loop: 3)
				(HandsOn)
			)
		)
	)
)

(instance egoSearch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 145 120 self
				)
			)
			(1
				(LookAt gEgo brutus)
				(gEgo
					loop: (mod (+ (gEgo loop:) 4) 2)
					view: 510
					setCycle: End self
				)
			)
			(2
				(localproc_0 0)
				(if (IsFlag 245)
					(HighPrint 73 68) ; "You find nothing else on the brigand's body."
				else
					(HighPrint 73 69) ; "You find a single key on the brigand's body, and put it away."
					(SetFlag 245)
					(gEgo get: 5) ; key
				)
				(NormalEgo)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

