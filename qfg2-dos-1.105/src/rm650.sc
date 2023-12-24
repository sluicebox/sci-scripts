;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 650)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Stage)
(use TargActor)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm650 0
)

(local
	birdHead
	birdAnnoyance
	rockFeather
	nestFeather
	searchedNest
	askFeather
	movedSand
	griffinTalked
	birdMsg
	birdIntro
	birdEnd
	birdSquawk
	[birdTalk 10] = [0 {I have a red pencil box} {Can you direct me to the public bath} {I will not buy your rotten pears} {May a sleepy hippopotamus lie down on your house keys} {I can give you 5 dinars for the gourd} {My sister has a saurus for sale} {Excuse me, your camel has fallen on my mother} {Your horse is foundered and I do not need that} {May I apply spices to your beard?}]
	[intros 6] = [0 {Well, you think that might have been} {Hmm.  That rather sounded like} {You believe that was} {If your translation is correct, that was} {You think that roughly translates to}]
	[endings 5] = [0 {Perhaps you should have paid more attention in "Griffin 101"} {You should have kept your Griffin-English phrase book from Adventurer's School} {Of course, you can never be sure when talking with a Griffin} {Unfortunately, your fluency in Griffin-speak is too low}]
	[squawks 8] = [0 {Screech chirpy caw peep, squawka squawka!"} {Chirp caw peepa-peepa, screechy screechy!} {Freep squeaky pip-pip, awoooooo!} {Screechy squawk, titwillow, titwillow!} {Cheep, cheep, tite, penurious!} {Scratch squawk screech do-be-do-be-doooo!} {(Mumble, mumble...tourists...mumble mumble!)}]
)

(procedure (GriffinPrint &tmp aT aR aL)
	(= aR (BotWindow brRight:))
	(= aL (BotWindow brLeft:))
	(BotWindow color: 10 back: 6)
	(Print
		&rest
		#font
		gUserFont
		#title
		{Merv the Griffin}
		#window
		BotWindow
		#width
		(- aR (+ aL 16))
	)
)

(procedure (translateBird &tmp [str 150])
	(if (not griffinTalked)
		(HighPrint 650 0) ; "Hmm. Let's see now. "chirpy" is the first person indicative..."
		(HighPrint 650 1) ; "No, wait. "Caw" is the noun form..."
	)
	(if (== birdMsg 9)
		(= birdMsg 1)
	else
		(++ birdMsg)
	)
	(if (== birdIntro 5)
		(= birdIntro 1)
	else
		(++ birdIntro)
	)
	(if (== birdEnd 4)
		(= birdEnd 1)
	else
		(++ birdEnd)
	)
	(HighPrint
		(Format ; "%s "%s", but you're not sure. %s."
			@str
			650
			2
			[intros (ChooseFromCycle birdIntro 1 5)]
			[birdTalk (ChooseFromCycle birdMsg 1 9)]
			[endings (ChooseFromCycle birdEnd 1 4)]
		)
	)
	(= griffinTalked 1)
)

(procedure (TryRock)
	(cond
		(movedSand
			(if (TrySkill 0 60) ; strength
				(HighPrint 650 3) ; "The rock was heavy, but after the sand was moved, you manage to get the rock off the feather."
				(SetFlag 73) ; fMovedRock
				(= rockFeather 2)
			)
		)
		((TrySkill 0 85) ; strength
			(HighPrint 650 4) ; "The rock was heavy, but you manage to move it off the feather."
			(SetFlag 73) ; fMovedRock
			(= rockFeather 2)
		)
	)
	(IsFlag 73) ; fMovedRock
)

(instance rm650 of Stage
	(properties
		picture 650
		style 8
		east 665
		south 665
		west 665
		rightFromY 170
		rightToY 170
		leftFromY 170
		leftToY 170
	)

	(method (init)
		(LoadMany rsVIEW 0 6 7 8 11 12 14 31 47 650 657 655)
		(SolvePuzzle 653 3)
		(self setRegions: 660) ; desertReg
		(gEgo init:)
		(super init:)
		(= gRopeScript magicRope)
		(= gLevScript goToLevitate)
		(= gRopeHighY (= gLevHighY 60))
		(= gSpellChecker gAllChecker)
		(if (not (IsFlag 74)) ; fGriffinPOed
			(griffin init:)
		)
		(nest init:)
		(rock palette: (+ gNight 1) init:)
	)

	(method (dispose)
		(= gLevScript (= gRopeScript 0))
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp spellNum)
		(cond
			((super handleEvent: event))
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(HighPrint 650 5) ; "You see sheer cliff walls where the mountains begin, stark against the brilliant blue of the sky. On a ledge jutting out from the cliff, a Griffin seems to have made a nest."
				(HighPrint 650 6) ; "Some debris has fallen from the nest."
			)
			((Said 'look,look>')
				(cond
					((Said '/griffin')
						(HighPrint 650 7) ; "He's gone."
					)
					((Said '/cliff')
						(HighPrint 650 8) ; "A Cliff Note: How high a cliff would make a miffed Griffin stiff, if the gifted Griffin could lift cliffs?"
					)
					((or (Said '/debris,ground') (Said '<down'))
						(HighPrint 650 9) ; "You see various rocks lying on the ground around here."
					)
					((or (Said '<up') (Said '/sky,star,constellation'))
						(if gNight
							(HighPrint 650 10) ; "The desert sky is ablaze with stars."
						else
							(HighPrint 650 11) ; "The sun burns down."
						)
					)
					((Said '/bird')
						(if (IsFlag 74) ; fGriffinPOed
							(HighPrint 650 12) ; "It's a Griffin; it's a plane; it's....gone!"
						else
							(HighPrint 650 13) ; "It may have wings and feathers, but the Griffin is not what you'd normally call a bird!"
						)
					)
					((Said '/feather')
						(cond
							((gEgo has: 28) ; Feather
								(event claimed: 0)
							)
							((or (== rockFeather 1) (== nestFeather 1))
								(HighPrint 650 14) ; "The feather looks just like a Griffin feather."
							)
							(else
								(HighPrint 650 15) ; "You don't see one just yet."
							)
						)
					)
				)
			)
			((Said 'pluck,lockpick,grab/feather,bird,griffin')
				(cond
					((gEgo has: 28) ; Feather
						(HighPrint 650 16) ; "You already have a feather, so don't be greedy. The Griffin probably needs them more than you."
					)
					((not (gCast contains: griffin))
						(= birdAnnoyance 0)
						(self setScript: getFeather)
					)
					(else
						(HighPrint 650 17) ; "The Griffin has many feathers. Perhaps you can grab one of them."
					)
				)
			)
			(
				(or
					(Said 'search/nest')
					(Said 'search,look,look<for/feather')
					(Said 'look,look<in/nest')
				)
				(if (gEgo has: 28) ; Feather
					(HighPrint 650 16) ; "You already have a feather, so don't be greedy. The Griffin probably needs them more than you."
				else
					(HighPrint 650 18) ; "It's up there. You're down here."
				)
			)
			((Said 'search,find,get,get,get/feather')
				(cond
					((gEgo has: 28) ; Feather
						(HighPrint 650 16) ; "You already have a feather, so don't be greedy. The Griffin probably needs them more than you."
					)
					((not (or rockFeather nestFeather))
						(HighPrint 650 19) ; "Good idea! Now if you could just find one."
					)
					((< rockFeather 2)
						(HighPrint 650 20) ; "You will need to move the rock first."
					)
					(else
						(= birdAnnoyance 0)
						(self setScript: getFeather)
					)
				)
			)
			((Said 'talk,talk,ask>')
				(if (gCast contains: griffin)
					(cond
						((Said '[/griffin,griffin]/feather')
							(= askFeather 1)
							(griffin setScript: griffinTalk)
						)
						((Said '[/griffin,griffin]')
							(= askFeather 0)
							(griffin setScript: griffinTalk)
						)
					)
				else
					(event claimed: 0)
				)
			)
			((Said 'climb,climb')
				(cond
					((== gEgoGait 3) ; riding
						(event claimed: 0)
					)
					((> [gEgoStats 11] 75) ; climb
						(HighPrint 650 21) ; "With your skill, you can tell that since it juts outward, it would be too dangerous to climb the cliff."
					)
					(else
						(TrySkill 11 75) ; climb
						(self setScript: scrabble)
					)
				)
			)
		)
	)
)

(instance goToLevitate of Script
	(properties)

	(method (handleEvent event)
		(cond
			((!= (event type:) evSAID))
			((super handleEvent: event))
			((Said 'pluck,lockpick,grab/feather,bird,griffin')
				(if (< 40 (gEgo z:) 60)
					(= birdAnnoyance 2)
					(self setScript: getFeather)
				else
					(NotClose)
				)
			)
			(
				(or
					(Said 'search/nest')
					(Said 'search,look,look<for/feather')
					(Said 'look,look<in/nest')
				)
				(cond
					((> (gEgo z:) 60)
						(HighPrint 650 22) ; "You can see that the nest is made up mostly of rocks, hair, pin-feathers, and the down from the Griffin's breast."
					)
					((> (gEgo z:) 30)
						(= birdAnnoyance 0)
						(self setScript: getFeather)
					)
					(else
						(NotClose)
					)
				)
			)
			((Said 'search,find,get,get,get/feather')
				(if (< 30 (gEgo z:) 60)
					(= birdAnnoyance 0)
					(self setScript: getFeather)
				else
					(NotClose)
				)
			)
			((Said 'talk,talk,ask,yell,tell[/griffin,griffin]')
				(if (and (> (gEgo z:) 35) (gCast contains: griffin))
					(= birdAnnoyance 1)
					(griffin setScript: flyAway)
					(self cue:)
				else
					(event claimed: 0)
					(gCurRoom handleEvent: event)
				)
			)
			((Said 'climb,climb')
				(HighPrint 650 23) ; "If you'd really wanted to climb, you wouldn't be doing what you're doing right now."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 144 160 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(caller cue:)
			)
			(3
				(if (and (IsFlag 74) (gCast contains: griffin)) ; fGriffinPOed
					(gEgo setScript: (ScriptID 62 1) self 175) ; fallDown
				else
					(self cue:)
				)
			)
			(4
				(= nestFeather 1)
				(self dispose:)
			)
		)
	)
)

(instance scrabble of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 112 162 self)
			)
			(1
				(gEgo view: 7 loop: 3 setCycle: Fwd)
				(= cycles 16)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(NormalEgo)
				(= cycles 2)
			)
			(4
				(HighPrint 650 24) ; "It is hard to climb when the rock juts out toward you. You think that maybe climbing these cliffs is just too difficult."
				(self dispose:)
			)
		)
	)
)

(instance magicRope of Script
	(properties)

	(method (handleEvent event)
		(cond
			((!= (event type:) evSAID))
			((super handleEvent: event))
			((Said 'pluck,lockpick,grab/feather,bird,griffin')
				(if (< 40 (gEgo z:) 60)
					(= birdAnnoyance 2)
					(self setScript: getFeather)
				else
					(NotClose)
				)
			)
			(
				(or
					(Said 'search/nest')
					(Said 'search,look,look<for/feather')
					(Said 'look,look<in/nest')
				)
				(cond
					((> (gEgo z:) 60)
						(HighPrint 650 22) ; "You can see that the nest is made up mostly of rocks, hair, pin-feathers, and the down from the Griffin's breast."
					)
					((> (gEgo z:) 30)
						(if (gEgo has: 28) ; Feather
							(HighPrint 650 16) ; "You already have a feather, so don't be greedy. The Griffin probably needs them more than you."
						else
							(= birdAnnoyance 0)
							(self setScript: getFeather)
						)
					)
					(else
						(NotClose)
					)
				)
			)
			((Said 'search,find,get,get,get/feather')
				(if (< 30 (gEgo z:) 60)
					(= birdAnnoyance 0)
					(self setScript: getFeather)
				else
					(NotClose)
				)
			)
			((Said 'talk,talk,ask[/griffin,griffin]')
				(if (and (> (gEgo z:) 35) (gCast contains: griffin))
					(= birdAnnoyance 1)
					(griffin setScript: flyAway)
					(magicRope cue:)
				else
					(event claimed: 0)
					(gCurRoom handleEvent: event)
				)
			)
			((Said 'climb,climb')
				(HighPrint 650 23) ; "If you'd really wanted to climb, you wouldn't be doing what you're doing right now."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 83)
					(gEgo setMotion: MoveTo 85 164 self)
				else
					(gEgo setMotion: MoveTo 60 164 self)
				)
			)
			(1
				(if (< (gEgo x:) 70)
					(gEgo setHeading: 45 self)
				else
					(gEgo setHeading: 315 self)
				)
			)
			(2
				(caller cue:)
				(= caller 0)
			)
			(3
				(if birdAnnoyance
					(gEgo setScript: (ScriptID 61 3)) ; ropeFall
				else
					(self cue:)
				)
			)
			(4
				(= nestFeather 1)
				(self dispose:)
			)
		)
	)
)

(instance getFeather of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (IsFlag 90) (IsFlag 88)) ; fLevitating, fClimbingRope
					(self changeState: 4)
				else
					(self setScript: moveToRock self)
				)
			)
			(1
				(gEgo view: 47 loop: 1 setCycle: End self)
			)
			(2
				(SolvePuzzle 654 7)
				(HighPrint 650 25) ; "You pick up a large feather and put it away."
				(gEgo get: 28) ; Feather
				(= rockFeather 3)
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(self changeState: 7)
			)
			(4
				(if (IsFlag 88) ; fClimbingRope
					(gEgo setLoop: 6 cel: 0 setCycle: End self)
				else
					(gEgo setCycle: CT 3 -1 self)
				)
			)
			(5
				(SolvePuzzle 654 7)
				(= nestFeather 3)
				(gEgo get: 28) ; Feather
				(if birdAnnoyance
					(griffin setScript: flyAway)
					(self changeState: 7)
				else
					(HighPrint 650 26) ; "You find a large feather in the nest and put it away."
					(self cue:)
				)
			)
			(6
				(if (IsFlag 88) ; fClimbingRope
					(gEgo setCycle: Beg self)
				else
					(gEgo setCycle: End self)
				)
			)
			(7
				(cond
					((IsFlag 88) ; fClimbingRope
						(gEgo setLoop: 9)
						(if birdAnnoyance
							(magicRope cue:)
						else
							((ScriptID 61 2) cue:) ; ropeClimb
						)
					)
					((IsFlag 90) ; fLevitating
						(if birdAnnoyance
							(goToLevitate cue:)
						else
							((ScriptID 62 0) cue:) ; levitate
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance griffinTalk of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo griffin)
				(griffinBody posn: (griffin x:) (griffin y:) init:)
				(griffin
					loop: 5
					posn: (+ (griffin x:) 23) (- (griffin y:) 8)
					setPri: 10
					cel: 1
				)
				(= cycles 2)
			)
			(1
				(griffin cel: (Random 1 3))
				(= cycles 2)
			)
			(2
				(if (> (++ birdHead) (Random 4 6))
					(= birdHead 0)
					(self cue:)
				else
					(self changeState: 1)
				)
			)
			(3
				(if askFeather
					(GriffinPrint [squawks 1])
					(if (TrySkill 13 100) ; communication
						(HighPrint 650 27) ; "That sounded an awful lot like "I think there's a feather under that rock there", but of course we all know that Griffins can't talk!"
					else
						(translateBird)
					)
				else
					(if (== birdSquawk 7)
						(= birdSquawk 1)
					else
						(++ birdSquawk)
					)
					(GriffinPrint [squawks birdSquawk])
					(translateBird)
				)
				(= cycles 5)
			)
			(4
				(griffin setCycle: Beg self)
			)
			(5
				(griffin
					posn: (griffinBody x:) (griffinBody y:)
					loop: 0
					cel: 0
					setPri: -1
				)
				(griffinBody dispose:)
				(self dispose:)
			)
		)
	)
)

(instance flyAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch birdAnnoyance
					(1
						(HighPrint 650 28) ; "Perhaps it's your proximity, or perhaps your choice of words, but in any event, you seem to have startled the Griffin."
					)
					(2
						(HighPrint 650 29) ; "From among the Griffin's feathers, you choose a nice-looking one and pluck it."
					)
				)
				(SolvePuzzle 681 -10 3)
				(SetFlag 74) ; fGriffinPOed
				(= gGriffinHealth 100)
				(self cue:)
			)
			(1
				(TopWindow color: 10 back: 6)
				(Print ; "SQUAAAAWK!"
					650
					30
					#font
					gUserFont
					#at
					250
					80
					#width
					100
					#title
					{Merv the Griffin}
					#window
					TopWindow
					#time
					3
					#dispose
				)
				(griffin setCycle: End self)
			)
			(2
				(wings init: setCycle: Fwd)
				(griffin view: 655 setLoop: 0 setCel: 1 y: (- (griffin y:) 10))
				(= cycles 5)
			)
			(3
				(griffin xStep: 9 yStep: 6 setMotion: MoveTo 175 50 self)
			)
			(4
				(griffin
					xStep: 12
					yStep: 9
					ignoreHorizon:
					setMotion: MoveTo 300 -10 self
				)
			)
			(5
				(HighPrint 650 31) ; "The Griffin, formerly peaceful and content, now unhappy and upset, leaves the scene."
				(griffin dispose:)
				(wings dispose:)
				(self dispose:)
			)
		)
	)
)

(instance moveRock of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: moveToRock self)
			)
			(1
				(gEgo view: 47 loop: 1 setCycle: End self)
			)
			(2
				(if (TryRock)
					(rock setCycle: End)
					(self changeState: 7)
				else
					(= cycles 4)
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 0 setCycle: Walk setMotion: MoveTo 183 139 self)
			)
			(5
				(gEgo view: 47 loop: 0 setCycle: End self)
			)
			(6
				(if movedSand
					(HighPrint 650 32) ; "Even after moving the sand, you are still too weak to move the rock. Perhaps you should do some more exercise to build up your strength."
				else
					(HighPrint 650 33) ; "The rock is firmly embedded in the sand."
				)
				(self cue:)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance digSand of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or movedSand (< rockFeather 1))
					(gEgo view: 47 loop: 1 setCycle: End)
					(= cycles 8)
				else
					(= movedSand 1)
					(self changeState: 3)
				)
			)
			(1
				(HighPrint 650 34) ; "What fun! Just like your sandbox back home."
				(gEgo setCycle: Beg self)
			)
			(2
				(self changeState: 8)
			)
			(3
				(self setScript: moveToRock self)
			)
			(4
				(gEgo view: 47 loop: 1 setCycle: End)
				(= cycles 8)
			)
			(5
				(gEgo
					setCel: (- (gEgo cel:) 1)
					setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:) self
				)
			)
			(6
				(gEgo setCycle: End)
				(= cycles 8)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(NormalEgo)
				(= cycles 2)
			)
			(9
				(if (== rockFeather 1)
					(HighPrint 650 35) ; "You can't quite free the feather, but you do manage to dig some sand from around the rock."
				)
				(self dispose:)
			)
		)
	)
)

(instance moveToRock of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (< (gEgo y:) 161) (< (gEgo x:) 90))
					(gEgo setMotion: MoveTo (gEgo x:) 175 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 210 139 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance griffin of TargActor
	(properties
		x 98
		y 77
		noun '/griffin,creature,griffin'
		description {Merv, the Griffin}
		lookStr {The Griffin looks like a cross between a lion and an eagle.  It seems to be sleeping.}
		view 657
		illegalBits 0
	)

	(method (hurtMe)
		(= birdAnnoyance 3)
		(griffin setScript: flyAway)
		(return 1)
	)
)

(instance wings of Prop
	(properties
		noun '/griffin,creature,griffin'
		description {Merv, the Griffin}
		lookStr {The Griffin looks like a cross between a lion and an eagle.  It seems to be sleeping.}
		view 657
		loop 6
		signal 16384
	)

	(method (doit)
		(= x (+ (griffin x:) 3))
		(= y (- (griffin y:) 34))
		(super doit:)
	)
)

(instance rock of Prop
	(properties
		x 187
		y 134
		noun '/boulder'
		description {the rock}
		view 650
	)

	(method (init)
		(if (IsFlag 73) ; fMovedRock
			(= movedSand 1)
			(= rockFeather 3)
			(rock cel: 3)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(switch rockFeather
					(3
						(HighPrint 650 36) ; "The rock is as you left it when you turned it over."
					)
					(2
						(HighPrint 650 37) ; "There is a feather lying near the rock."
					)
					(else
						(= rockFeather 1)
						(HighPrint 650 38) ; "You can see part of a feather sticking out from under a rock near the cliff base."
					)
				)
			)
			(5
				(cond
					((rock cel:)
						(HighPrint 650 39) ; "You've moved the rock about as far as it will budge."
					)
					((> (gEgo view:) 5)
						(HighPrint 650 40) ; "Not now!"
					)
					(else
						(gCurRoom setScript: moveRock)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((== gEgoGait 3) ; riding
				(event claimed: 0)
			)
			((Said 'move,dig,get/sand[/boulder]')
				(if (> (gEgo view:) 5)
					(HighPrint 650 40) ; "Not now!"
				else
					(gCurRoom setScript: digSand)
				)
			)
			((Said 'lift,get,(lockpick<up)/boulder')
				(cond
					((rock cel:)
						(HighPrint 650 39) ; "You've moved the rock about as far as it will budge."
					)
					((> (gEgo view:) 5)
						(HighPrint 650 40) ; "Not now!"
					)
					(else
						(gCurRoom setScript: moveRock)
					)
				)
			)
			((Said 'replace/boulder')
				(if (rock cel:)
					(HighPrint 650 41) ; "You're a big Hero around here. You don't have to be tidy. You don't have to put all the nice rocks back where you found them."
				else
					(HighPrint 650 42) ; "Huh?"
				)
			)
			((Said 'climb,climb')
				(event claimed: 0)
			)
		)
	)
)

(instance nest of Feature
	(properties
		x 100
		y 148
		z 85
		noun '/nest'
		nsTop 38
		nsLeft 52
		nsBottom 89
		nsRight 148
		description {the Griffin's nest}
	)

	(method (doVerb theVerb)
		(if (== theVerb 1)
			(if (or (< (gEgo y:) 140) (> (gEgo z:) 20))
				(HighPrint 650 22) ; "You can see that the nest is made up mostly of rocks, hair, pin-feathers, and the down from the Griffin's breast."
			else
				(HighPrint 650 43) ; "From this angle, the nest seems to be made up mostly of rocks."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance griffinBody of View
	(properties
		view 657
		loop 4
		signal 16384
	)
)

