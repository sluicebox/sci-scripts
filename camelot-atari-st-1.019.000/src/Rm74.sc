;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use MoveForward)
(use n128)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm74 0
)

(local
	local0
	local1
	local2
	[local3 9]
	[local12 19]
	local31
	local32
	local33
	local34
	local35
)

(procedure (localproc_0 &tmp temp0 temp1)
	(for ((= temp0 1)) (<= temp0 6) ((++ temp0))
		(while 1
			(if (not [local12 (= temp1 (Random 1 18))])
				(= [local12 temp1] 1)
				(= [local3 temp0] temp1)
				(break)
			)
		)
	)
	(= local31 0)
)

(procedure (localproc_1)
	(Face gEgo aphrodite)
	(ClearFlag 311)
	(gTObj tWindow: statueWindow)
	(Talk &rest)
)

(instance statueWindow of SysWindow
	(properties
		color 14
		back 8
		title {Statue}
		brTop 5
		brLeft 30
		brBottom 80
		brRight 290
	)
)

(instance leftDoor of Prop
	(properties
		y 86
		x 28
		view 274
		priority 1
		signal 16400
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)
)

(instance frontDoor of Act
	(properties
		y 137
		x 83
		yStep 8
		view 274
		loop 1
		priority 10
		signal 16400
		illegalBits 0
	)
)

(instance rightDoor of Prop
	(properties
		y 145
		x 232
		view 274
		loop 2
		priority 1
		signal 16400
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)
)

(instance aphrodite of PV
	(properties
		y 138
		x 148
		view 174
		priority 11
		signal 16400
	)
)

(instance rightArm of Prop
	(properties
		y 85
		x 161
		view 174
		loop 1
		priority 11
		signal 16400
	)
)

(instance leftArm of Prop
	(properties
		y 86
		x 145
		view 174
		loop 2
		priority 11
		signal 16400
	)
)

(instance Rm74 of Rm
	(properties
		picture 74
	)

	(method (init)
		(super init:)
		(ClearFlag 311)
		(= global112 1)
		(self setRegions: 125) ; Catacombs
		(gEgo loop: 3 setScript: walkIntoRoom)
		(leftDoor init: stopUpd:)
		(frontDoor init: stopUpd:)
		(rightDoor init: stopUpd:)
		(if (and (gEgo has: 10) (not (IsFlag 180))) ; lamb | dove
			(leftDoor setCel: 255 setPri: 10 ignoreActors:)
			(frontDoor posn: 83 77 setPri: 0)
			(rightDoor setCel: 255 setPri: 11 ignoreActors:)
			(gEgo illegalBits: $8000)
		)
		(if (IsItemAt 11) ; mirror | golden_apple
			(leftArm setCel: 4)
		)
		(if (not (IsItemAt 10)) ; lamb | dove
			(rightArm setCel: 255)
		)
		(gAddToPics add: aphrodite)
		(leftArm init: stopUpd:)
		(rightArm init: stopUpd:)
		(SetFlag 176)
		(gAddToPics doit:)
		(if (and (IsItemAt 11) (IsItemAt 10)) ; mirror | golden_apple, lamb | dove
			(gCurRoom setScript: askTheQuestions)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((> (gEgo y:) 188)
				(gEgo setMotion: LeaveRoom 73 2 10)
			)
			(
				(or
					(not (gEgo has: 10)) ; lamb | dove
					(IsFlag 172)
					(== (gEgo illegalBits:) $c000)
				)
				0
			)
			((& (gEgo onControl:) $0020)
				(leftDoor setScript: DeathDoor)
			)
			((& (gEgo onControl:) $0010)
				(frontDoor setScript: BlackenedPassage)
			)
			((& (gEgo onControl:) $0040)
				(rightDoor setScript: DeathDoor)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(ClearFlag 75)
		(super newRoom: newRoomNumber)
	)

	(method (notify)
		(if (== (gCurRoom script:) askTheQuestions)
			(askTheQuestions changeState: 3)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said 'look<behind/sculpture,aphrodite')
						(if (not (IsFlag 178))
							(Print 74 0) ; "There is nothing there."
						else
							(Print 74 1) ; "Behind and to each side of the statue, hidden doors have opened."
						)
					)
					(
						(or
							(Said 'look[<!*][/room,catacomb]')
							(Said '//room,catacomb')
							(Said 'look<around')
							(Said 'look<at/room,catacomb')
						)
						(if (not (IsFlag 178))
							(Print 74 2) ; "It is utterly empty except for a statue of Aphrodite."
						else
							(Print 74 3) ; "This room holds only the statue of Aphrodite and now has a total of four doors from which to choose."
						)
					)
					(
						(or
							(Said '/sculpture,aphrodite')
							(Said '//sculpture,aphrodite')
							(OnButton event 131 65 178 151)
						)
						(if (not (IsItemAt 11)) ; mirror | golden_apple
							(Print 74 4) ; "There is a stone statue of Aphrodite in the center of the room. Upon one hand rests a carved dove, but the other hand, though held out with palm open, is empty."
						else
							(Print 74 5) ; "The statue of Aphrodite now holds the apple which has turned to stone in its hand."
						)
					)
					((or (Said '/wall') (Said '//wall'))
						(if (not (IsFlag 178))
							(Print 74 6) ; "The walls are completely blank."
						else
							(Print 74 7) ; "What seemed to be blank walls have revealed three hidden doors."
						)
					)
					((Said 'look[<in,in]/door,door')
						(if (not (IsFlag 178))
							(Print 74 8) ; "Only half of the doorway into the room is left for part of the wall has crumbled away."
						else
							(Print 74 9) ; "With the exception of the doorway through which you entered, the other doorways are utterly black inside and it is impossible to tell what might lie within."
						)
					)
					((Said 'ask/aphrodite/*')
						(Print 74 10) ; "I cannot imagine why you think the Goddess herself would answer you."
					)
					((or (Said 'ask/sculpture/*') (Said 'ask/aphrodite/*'))
						(Print 74 11) ; "The statue shows no sign of answering."
					)
					((Said '//dove')
						(if (not (gEgo has: 10)) ; lamb | dove
							(Print 74 12) ; "The statue of Aphrodite has a dove upon her hand. Doves are considered one of her fertility symbols."
						else
							(Print 74 13) ; "The statue's instructions were to use the dove after you had proven yourself with sword and shield."
						)
					)
					((and local0 (Said '//path,direction,escape'))
						(Print 74 14) ; "I shall attempt to recall the directions: six doors must be entered in this order: west, east, south, east, south, north."
					)
					((Said '//flora')
						(Print 74 15) ; "It encompasses all things that are considered plants."
					)
					((Said '//fauna')
						(Print 74 16) ; "It refers to anything that is an animal."
					)
				)
			)
			(
				(or
					(Said 'greet')
					(Said 'talk/sculpture,aphrodite')
					(Said 'get,ask,pose/ask,direction,instruction')
				)
				(if (not (gEgo has: 10)) ; lamb | dove
					(Print 74 17) ; "In this place, it would not surprise me to hear a statue talk, but this one shows no interest in speech as yet."
				else
					(Print 74 18) ; "You have passed this test and the statue is silent."
				)
			)
			((Said 'get,rob/apple[<dinar,golden]')
				(if (not (IsItemAt 11)) ; mirror | golden_apple
					(Print 74 19) ; "You are not making sense, Arthur."
				else
					(Print 74 20) ; "It has turned to stone and become part of the statue."
				)
			)
			((Said 'get,rob/dove')
				(if (IsItemAt 10) ; lamb | dove
					(Print 74 21) ; "It is part of the statue."
				else
					(Print 74 22) ; "What nonsense is this? You were given the dove."
				)
			)
			((Said 'get,move,press,topple,(knock<above)/sculpture')
				(Print 74 23) ; "That is quite beyond your ability."
			)
			((Said 'give,drop,use/apple>')
				(cond
					((and (not (gEgo has: 11)) (not (gEgo has: 4))) ; mirror | golden_apple, rose | apple | green_apple
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
					(
						(or
							(and (gEgo has: 4) (Said '/<green')) ; rose | apple | green_apple
							(and (not (gEgo has: 11)) (Said '/*[<in,green]')) ; mirror | golden_apple
						)
						(if (IsItemAt 11) ; mirror | golden_apple
							(Print 74 24) ; "You have given the statue the only apple it required."
						else
							(event claimed: 1)
							(= local2 0)
							(gEgo setScript: giveApple)
						)
					)
					(
						(or
							(and (gEgo has: 11) (Said '/<golden,dinar')) ; mirror | golden_apple
							(and (not (gEgo has: 4)) (Said '/*[<in,golden]')) ; rose | apple | green_apple
						)
						(= local2 1)
						(gEgo setScript: giveApple)
					)
					((and (gEgo has: 4) (gEgo has: 11)) ; rose | apple | green_apple, mirror | golden_apple
						(event claimed: 1)
						(Print 74 25) ; "You have both a green apple and a golden apple."
					)
					(else
						(event claimed: 1)
						(DontHave) ; "First, you must have it. I cannot simply conjure it out of thin air for you."
					)
				)
			)
		)
	)
)

(instance giveApple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local35 (gEgo view:))
				(gEgo illegalBits: 0)
				(cond
					((gEgo inRect: 124 136 184 147)
						(-- state)
						(gEgo setMotion: MoveTo 120 145 self)
					)
					(
						(or
							(<= (gEgo x:) 120)
							(>= (gEgo y:) 155)
							(gEgo inRect: 120 148 126 157)
						)
						(= cycles 1)
					)
					((< (gEgo y:) 157)
						(-- state)
						(gEgo setMotion: MoveTo (gEgo x:) 157 self)
					)
					(else
						(gEgo setMotion: MoveTo 133 157 self)
					)
				)
			)
			(1
				(if (and (!= (gEgo x:) 126) (!= (gEgo y:) 153))
					(gEgo setMotion: MoveTo 126 153 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo view: 70 loop: 1 cel: 0 setCycle: End)
				(if (== local2 0)
					(leftArm setLoop: 0 setCel: 1)
					(= cycles 10)
				else
					(leftArm setLoop: 2 cycleSpeed: 2 setCycle: CT 1 1 self)
				)
			)
			(3
				(if (== local2 0)
					(leftArm setLoop: 2 setCel: 0)
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(if (== local2 0)
					(= seconds 2)
				else
					(leftArm setCycle: End self)
				)
			)
			(5
				(gEgo
					view: local35
					loop: 3
					setCycle: Walk
					illegalBits: $c000
				)
				(HandsOn)
				(client setScript: 0)
				(if (== local2 0)
					(Print 74 26) ; "The apple fit perfectly in the statue's hand, but caused nothing to happen."
				else
					(PutItem 11) ; mirror | golden_apple
					(SetScore 0 0 5)
					(gEgo setScript: giveGoldenApple)
				)
			)
		)
	)
)

(instance giveGoldenApple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 324)
				(gRmMusic number: 96 loop: -1 play:)
				(= cycles 1)
			)
			(1
				(gTObj talkCue: self)
				(localproc_1 74 27 74 28 74 29 74 30) ; "You have brought the gift by which I am made complete. For this, I will tell you what you must do to escape the catacombs."
			)
			(2
				(gTObj talkCue: self)
				(localproc_1 74 31) ; "As for the sacred cup, it lies beyond the catacombs. You will not find it here. The test now begins."
			)
			(3
				(HandsOn)
				(client setScript: 0)
				(gCurRoom setScript: askTheQuestions)
			)
		)
	)
)

(instance askTheQuestions of Script
	(properties)

	(method (init)
		(super init:)
		(SetFlag 288)
	)

	(method (dispose)
		(ClearFlag 288)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not global80))
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(HandsOn)
				(= cycles 2)
				(localproc_0)
				(SetFlag 75)
			)
			(2
				(HandsOn)
				(= local32 1)
				(repeat
					(if (> (++ local31) 6)
						(= local31 1)
					)
					(if (!= [local3 local31] -1)
						(break)
					)
				)
				(gRmMusic number: 96 loop: -1 play:)
				(SetFlag 311)
				(Print
					806
					[local3 local31]
					#font
					4
					#title
					{Statue}
					#window
					statueWindow
					#dispose
				)
			)
			(3
				(HandsOff)
				(gTObj talkCue: self)
				(localproc_1 74 32) ; "That is not the answer. The test continues."
				(= state 1)
			)
			(4
				(HandsOff)
				(gTObj talkCue: self)
				(localproc_1 74 33) ; "The answer requires but a single word. The test continues."
				(= state 1)
			)
			(5
				(++ local33)
				(= [local3 local31] -1)
				(if (== local33 6)
					(gCurRoom setScript: 0)
					(gEgo setScript: answeredSix)
				else
					(HandsOff)
					(gTObj talkCue: self)
					(localproc_1 74 34) ; "That is the answer. The test continues."
					(= state 1)
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if
			(and
				(or
					(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(== (event type:) evMOUSEBUTTON)
				)
				(IsFlag 311)
			)
			(event claimed: 1)
		else
			(if (or (!= (event type:) evSAID) (event claimed:))
				(return)
			)
			(cond
				(
					(= temp0
						(switch [local3 local31]
							(1
								(Said '/6')
							)
							(2
								(Said '/apple')
							)
							(3
								(Said '/dove')
							)
							(4
								(Said '/greek')
							)
							(5
								(Said '/adonis')
							)
							(6
								(Said '/persephone')
							)
							(7
								(Said '/zeus')
							)
							(8
								(Said '/ares')
							)
							(9
								(Said '/cyprus')
							)
							(10
								(Said '/aphrodite')
							)
							(11
								(Said '/woman,girl')
							)
							(12
								(Said '/ivory')
							)
							(13
								(Said '/life')
							)
							(14
								(Said '/theseus')
							)
							(15
								(Said '/chariot')
							)
							(16
								(Said '/phaedra,phaedra')
							)
							(17
								(Said '/poseidon')
							)
							(18
								(Said '/charioteer')
							)
						)
					)
					(self changeState: 5)
				)
				((or (Said '*/*') (Said '/*/*') (Said '<*/*'))
					(self changeState: 4)
				)
				(else
					(event claimed: 1)
					(self changeState: 3)
				)
			)
		)
	)
)

(instance answeredSix of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 178)
				(= local32 0)
				(gRmMusic stop:)
				(gRegMusic stop: number: 94 loop: -1 play:)
				(gTObj talkCue: self)
				(localproc_1 74 35) ; "You have given the six answers I require and earned your chance at freedom. First, accept this gift."
			)
			(1
				(rightArm cycleSpeed: 2 setCycle: CT 2 1 self)
			)
			(2
				(cond
					((gEgo inRect: 124 136 184 147)
						(-- state)
						(gEgo setMotion: MoveTo 200 145 self)
					)
					((< (gEgo y:) 157)
						(-- state)
						(gEgo setMotion: MoveTo (gEgo x:) 157 self)
					)
					(else
						(gEgo setMotion: MoveTo 185 157 self)
					)
				)
			)
			(3
				(gEgo setMotion: MoveTo 185 153 self)
			)
			(4
				(gEgo loop: 3)
				(RedrawCast)
				(= local35 (gEgo view:))
				(gEgo view: 70 loop: 0 cel: 0 setCycle: End self)
				(gEgo get: 10) ; lamb | dove
				(SetScore 0 1 20)
				(rightArm setCycle: End)
			)
			(5
				(gEgo view: local35 loop: 3 setCycle: Walk)
				(gTObj talkCue: self)
				(localproc_1 74 36 74 37 74 38) ; "When you have proven yourself by sword and shield, the time will be right to use the dove."
			)
			(6
				(leftDoor setPri: 10 setCycle: End leftDoor)
				(frontDoor
					setPri: 10
					setLoop: 1
					setPri: 0
					setMotion: MoveTo (frontDoor x:) 77 self
				)
				(rightDoor setPri: 12 setCycle: End rightDoor)
			)
			(7
				(frontDoor stopUpd:)
				(gEgo illegalBits: $8000)
				(leftDoor setPri: 10 stopUpd: ignoreActors:)
				(rightDoor setPri: 11 stopUpd: ignoreActors:)
				(= cycles 2)
			)
			(8
				(gTObj talkCue: self)
				(localproc_1 74 39) ; "The doors you choose must face the direction I give you and you must ENTER them in exactly this order...."
			)
			(9
				(Print 74 40 #window statueWindow #title {Statue} #font 4) ; "West, east, south, east, south, north."
				(if (IsFlag 206)
					(gTObj talkCue: self)
					(localproc_1 74 41) ; "Have no fear for Galahad. When he is healed, I shall set him free. You have earned that boon."
				else
					(= cycles 1)
				)
			)
			(10
				(gTObj talkCue: self)
				(localproc_1 74 42) ; "I shall not speak again. Your escape relies now upon your own ingenuity."
				(SetFlag 318)
				(client setScript: 0)
				(ClearFlag 75)
				(HandsOn)
			)
		)
	)
)

(instance walkIntoRoom of Script
	(properties)

	(method (init)
		(super init: &rest)
		(HandsOff)
		(client posn: 133 210 setMotion: MoveTo 133 180 self)
	)

	(method (cue)
		(HandsOn)
		(client setScript: 0)
	)
)

(instance BlackenedPassage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 16) self
				)
			)
			(1
				(frontDoor
					startUpd:
					setPri: 9
					setMotion: MoveTo (frontDoor x:) 137 self
				)
			)
			(2
				(frontDoor setPri: 10)
				(RedrawCast)
				(gCurRoom style: 8 drawPic: 112)
				(gCast eachElementDo: #hide)
				(= seconds 2)
			)
			(3
				(Print 74 43) ; "You are enclosed in a narrow tunnel within the wall. Inch forward carefully and test the floor as you go."
				(= seconds 3)
			)
			(4
				(Print 74 44) ; "It takes you in one direction. Let us hope you find an exit soon, for it is as cold as the grave and the stone walls covered with something slick and unpleasant."
				(= seconds 3)
			)
			(5
				(Print 74 45) ; "The tunnel stops at a wall. Push, Arthur! Aye, it gives way into one of the rooms of the catacombs through a hidden doorway."
				(= seconds 5)
			)
			(6
				(gCurRoom newRoom: 72)
			)
		)
	)
)

(instance DeathDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local34)
					(HandsOff)
					(gEgo illegalBits: 0)
					(if (== client leftDoor)
						(gEgo setMotion: MoveTo 15 144)
					else
						(gEgo setMotion: MoveTo 270 150)
					)
					(client setPri: (+ (client priority:) 1))
					(= cycles 20)
				)
			)
			(1
				(client startUpd: setCycle: Beg self)
			)
			(2
				(= seconds 4)
			)
			(3
				(Print 74 46) ; "Nay, you have chosen wrongly! The door has shut behind you, trapping you within a pitch black hole scarcely larger than a coffin."
				(= local34 1)
				(EgoDead 74 47) ; "And a stone coffin it is, for here you shall die all too soon. Farewell, King Arthur."
			)
		)
	)
)

