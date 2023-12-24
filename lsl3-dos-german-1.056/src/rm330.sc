;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use Interface)
(use Jump)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm330 0
)

(local
	clothesOnTable
	seenDaleDance
	DaleState
	currentDrinker
	humpCount
	sitWithPatti
)

(instance rm330 of Rm
	(properties
		picture 330
		east 230
	)

	(method (init)
		(SetFlag 36) ; beenIn330
		(= gEgoState 17)
		(Load rsVIEW 330)
		(Load rsVIEW 333)
		(Load rsVIEW 332)
		(Load rsVIEW 337)
		(Load rsVIEW 336)
		(Load rsVIEW 14)
		(Load rsSOUND 330)
		(Load rsSOUND 331)
		(Load rsSOUND 332)
		(Load rsSOUND 10)
		(Load rsSCRIPT 991)
		(Load rsSCRIPT 969)
		(super init:)
		(gAddToPics add: atpPchair add: atpDchair doit:)
		(aDale init:)
		(aClothes init:)
		(aDrinker1 init:)
		(aDrinker2 init:)
		(aDrinker3 init:)
		(aDrinker4 init:)
		(aCurtain init:)
		(aPanties init:)
		(self setScript: RoomScript)
		(if (== gPrevRoomNum 335)
			(HandsOff)
			(gEgo
				view: 332
				setLoop: 4
				setCel: 255
				posn: 281 140
				illegalBits: 0
				init:
			)
			(RoomScript changeState: 3)
			(aDale view: 337 setLoop: 4 setCel: 255 posn: 283 121 cycleSpeed: 1)
			(DaleScript changeState: 24)
		else
			(NormalEgo)
			(gEgo
				view: 332
				loop: 1
				posn: 317 129
				baseSetter: squareBase
				init:
			)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if DaleState
			(cond
				((Said 'caress,get,get,grab,caress/dale,man,dale')
					(Print 330 0) ; "You'd love to, wouldn't you?"
				)
				((Said 'applaud')
					(Print 330 1) ; "You applaud uproariously."
					(if (== gEgoState 1004)
						(self changeState: 4)
					)
				)
				((Said '(get<off),drain/panties')
					(Print 330 2) ; "An excellent idea! But what would you do with them?"
				)
				((Said 'give,throw/panties>')
					(cond
						((not (gEgo has: 14)) ; Panties
							(DontHave) ; "You don't have it."
						)
						((Said '/[/!*]')
							(Print 330 3) ; "That's a good idea! But to whom?"
						)
						((not (Said '//backstage,dale,man,dale'))
							(Print 330 4) ; "No, they wouldn't want your panties."
						)
						((!= DaleState 2)
							(Print 330 5) ; "A good idea! But Dale is not dancing at the moment."
						)
						(else
							(self changeState: 12)
						)
					)
					(event claimed: 1)
				)
				((Said 'look,look/man,dale,dale,eye')
					(cond
						((== DaleState 0)
							(Print 330 6) ; "Where?"
						)
						((< DaleState 6)
							(Print 330 7) ; "Wow! He looks exactly like a young Tom Jones! The women here are going wild!"
							(Print 330 8 #at -1 144) ; "(The men look terminally bored.)"
						)
						((> DaleState 6)
							(Print 330 9) ; "He's gone, Patti."
						)
						((!= gEgoState 1004)
							(Print 330 10) ; "Sit down beside him first."
						)
						(else
							(self changeState: 18)
						)
					)
				)
				((Said 'talk,talk/dale,man,dale')
					(switch DaleState
						(2
							(Print 330 11) ; "He's really a hot dancer, Patti! Back in your B.L. period (Before Larry), you would have been instantly intensely interested in a man like him. Even now, something tells you to attract his attention."
						)
						(3
							(Print 330 12) ; "He can't hear you for the roar of the crowd."
						)
						(4
							(Print 330 13) ; "He's backstage now... resting up."
						)
						(5
							(Print 330 14) ; "Oh, Dale," you coo, "would you like to join me?"
							(= sitWithPatti 1)
						)
						(1
							(Print 330 12) ; "He can't hear you for the roar of the crowd."
						)
						(6
							(Print 330 15) ; "You've got him sitting here with you; why don't you try looking into his eyes?"
						)
						(else
							(Print 330 16) ; "He's gone for good, Patti; you've missed him!"
						)
					)
				)
				((Said 'talk,talk')
					(Print 330 17) ; "The people at the tables are uninterested in conversing with you Patti. They're here to see the show."
				)
				(
					(and
						(== DaleState 6)
						(or
							(Said 'eat,eat,eat,eat/dale,man,dale')
							(Said 'caress,caress,caress/dale,man,dale')
						)
					)
					(Print 330 18) ; "Ok."
				)
			)
		)
		(cond
			((and clothesOnTable (Said 'get,get,(up<pick)/cloth'))
				(Print 330 19) ; "Just leave them there. You have no interest in cross-dressing."
			)
			((Said 'get,get,buy,order/drink,drink,cup')
				(Print 330 20) ; "You didn't come in here to drink, Patti!"
			)
			(
				(or
					(Said 'go,climb,(get,get<on)/backstage,buffet,barstool')
					(Said 'whistle,yell')
				)
				(Print 330 21) ; "You're too sophisticated to lower yourself like that!"
			)
			((Said 'lie')
				(cond
					((& (gEgo onControl:) $0004)
						(Print 330 22) ; "This chair not only faces the wrong way, but has a "Reserved" sign on it. However, the chair beside it is unoccupied."
					)
					((not (& (gEgo onControl:) $0002))
						(NotClose) ; "You're not close enough."
					)
					((== gEgoState 1004)
						(YouAre) ; "You are."
					)
					((!= gEgoState 17)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(Ok) ; "O.K."
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said
						'rise,(get,get<off),(get,get<up),(rise,nightstand<up)'
					)
					(Said 'exit/barstool')
				)
				(cond
					((== gEgoState 17)
						(YouAre) ; "You are."
					)
					((!= gEgoState 1004)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((== DaleState 6)
						(Print 330 23) ; "It would be rude for you to ignore your guest, Patti!"
					)
					(else
						(self changeState: 9)
					)
				)
			)
			((Said 'throw/buck,bribe,bribe,buck')
				(Print 330 24) ; "That's not what you should throw in this place."
			)
			((Said 'look,look,caress<below/buffet,barstool')
				(Print 330 25) ; "You wouldn't want to!"
			)
			((Said 'look,look>')
				(cond
					((and clothesOnTable (Said '/cloth,buffet'))
						(Print 330 26) ; "Perhaps Dale finds you interesting. Maybe his clothes are a clue..."
					)
					((Said '/backstage')
						(Print 330 27) ; "That's why people come here -- to look at the stage!"
					)
					((Said '/barstool')
						(Print 330 28) ; "There are only two chairs available here."
						(if (== gEgoState 1004)
							(Print 330 29) ; "You're sitting in one of them."
						)
						(if (== DaleState 6)
							(Print 330 30) ; "Dale is sitting beside you!"
							(Print 330 31 #at -1 144) ; "(And you're looking at his chair?)"
						)
					)
					((Said '/burn,burn')
						(Print 330 32) ; "The spotlight is aimed directly at the stage."
					)
					((Said '/curtain')
						(if (aCurtain cel:)
							(Print 330 33) ; "Through that curtain walks someone who may be helpful to your quest, Patti!"
						else
							(Print 330 34) ; "It successfully prevents you from looking backstage."
						)
					)
					((Said '/buffet,woman,man,dale,dale,cup,drink,drink,couple')
						(Print 330 35) ; "Unlike you, the other people here are happy and enjoying themselves; not worried about finding their lover like you."
					)
					((Said '[/area]')
						(Print 330 36) ; "What a nasty establishment this is!"
						(Print 330 37 #at -1 144) ; "(You love it!)"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 281 140 self
				)
			)
			(2
				(gEgo setLoop: 4 setPri: 3 setCel: 0 setCycle: End self)
			)
			(3
				(User canInput: 1)
				(= gEgoState 1004)
				(if seenDaleDance
					(= cycles 0)
					(= seconds 3)
				else
					(= seenDaleDance 1)
					(DaleScript changeState: 1)
				)
			)
			(4
				(if (== DaleState 2)
					(gEgo loop: 5 setCycle: Fwd)
					(= cycles (Random 11 33))
				else
					(self changeState: 6)
				)
			)
			(5
				(gEgo setLoop: 4 setCel: 255)
				(= cycles (Random 11 33))
			)
			(6
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(7
				(= cycles (Random 33 66))
			)
			(8
				(gEgo setCycle: Beg self)
				(= state 3)
			)
			(9
				(HandsOff)
				(= cycles (= seconds 0))
				(gEgo view: 332 setLoop: 4 setCel: 255 setCycle: Beg self)
			)
			(10
				(gEgo
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo 282 132 self
				)
			)
			(11
				(= gEgoState 17)
				(NormalEgo 1 332)
				(gEgo baseSetter: squareBase)
			)
			(12
				(Ok) ; "O.K."
				(Print 330 38) ; "You slip off your "Saturday Night Specials" and readjust your pantyhose -- all in one smooth movement!"
				(= cycles (= seconds 0))
				(HandsOff)
				(gEgo
					view: 336
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(13
				(gEgo setLoop: 1 cel: 0 setCycle: Fwd)
				(= cycles 15)
			)
			(14
				(gEgo cycleSpeed: 0)
				(= cycles 15)
			)
			(15
				(= cycles 10)
			)
			(16
				(Print 330 39 #icon 14 0 0 #at -1 10) ; "Hey, Dale," you cry, "these are for you!"
				(gEgo cycleSpeed: 1 setLoop: 2 cel: 0 setCycle: End)
				(PutInRoom 14)
				(aPanties
					posn: (gEgo x:) (gEgo y:)
					setMotion: JumpTo 42 96 self
				)
			)
			(17
				(Print 330 40) ; "You shriek, "Take me, big boy. I'm yours!""
				(= cycles (= seconds 0))
				(aPanties stopUpd:)
				(gGame changeScore: 100)
				(User canInput: 1)
				(gEgo view: 332)
				(if (== gEgoState 1004)
					(self changeState: 2)
				else
					(NormalEgo 1 332)
					(gEgo baseSetter: squareBase)
				)
			)
			(18
				(Ok) ; "O.K."
				(HandsOff)
				(= gEgoState 14)
				(if (not (TestFlag 56))
					(Print 330 41) ; "Hello, handsome," you tell the male stripper. "My name is Patti, but you may call me Passionate!"
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(19
				(if (not (TestFlag 56))
					(SetFlag 56) ; seenDale
					(gGame changeScore: 1)
					(Print 330 42) ; "Thanks, Patti," he responds, "and you may call me Dale."
				)
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance aDale of Act
	(properties
		y 86
		x -86
		view 333
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd setScript: DaleScript)
	)
)

(instance DaleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(= seconds (Random 2 5))
			)
			(2
				(gMusic number: 10 loop: -1 play:)
				(Print 330 43) ; "Ladies and ladies," says the voiceover announcer, "Chip 'n' Dale's is proud to present, in person, tonight only, for one show only, the first, the original, the greatest, (the owner) ...DALE!!!"
				(Print 330 44 #at -1 144) ; "(a smattering of applause)"
				(aCurtain setCycle: End self)
			)
			(3
				(= gOldGameSpeed (gGame setSpeed: 6))
				(aCurtain stopUpd:)
				(gMusic number: 330 loop: -1 play:)
				(aDale setLoop: 0 setMotion: MoveTo 89 86 self)
				(= DaleState 1)
			)
			(4
				(aCurtain setCycle: Beg self)
				(aDale setLoop: 1 setCel: 0)
				(= DaleState 2)
			)
			(5
				(aCurtain stopUpd:)
				(aDale cycleSpeed: 1 setCycle: End self)
			)
			(6
				(aDale setLoop: 2 setCel: 0 setCycle: CT 6 1 self)
			)
			(7
				(aDale setCycle: End)
				(aClothes posn: 105 83 setMotion: JumpTo 248 133 self)
			)
			(8
				(aClothes stopUpd:)
				(= clothesOnTable 1)
				(= cycles 20)
			)
			(9
				(aDale cycleSpeed: 1 setLoop: 3 setCel: 0 setCycle: End self)
				(= humpCount 0)
			)
			(10
				(aDale setCycle: Fwd setLoop: 4)
				(= cycles 22)
			)
			(11
				(if (> 3 (++ humpCount))
					(= state 9)
				)
				(aDale
					setLoop: 5
					setMotion: MoveTo (Random 63 68) (Random 110 110)
				)
				(= cycles (Random 11 22))
			)
			(12
				(aDale setMotion: MoveTo 89 86 self)
			)
			(13
				(aDale setLoop: 6 cel: 0 setCycle: End)
				(gMusic number: 331 loop: 1 play:)
				(= cycles 33)
			)
			(14
				(Print 330 45 #at -1 10) ; "Ok, ladies! Let's really hear for him."
				(Print 330 46 #at -1 10) ; "Isn't he wonderful?!"
				(= cycles (Random 11 44))
			)
			(15
				(aCurtain setCycle: End)
				(aDale setCycle: CT 8 -1)
				(gMusic number: 330 play:)
				(= cycles 22)
			)
			(16
				(aCurtain stopUpd:)
				(aDale
					cycleSpeed: 0
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 42 86 self
				)
				(= DaleState 3)
			)
			(17
				(if (InRoom 14 330)
					(aPanties hide:)
					((Inv at: 14) owner: 335) ; Panties
				)
				(aDale setMotion: MoveTo -40 86 self)
			)
			(18
				(aDale stopUpd:)
				(aCurtain setCycle: Beg)
				(gMusic fade:)
				(= DaleState 4)
				(= seconds 5)
			)
			(19
				(gGame setSpeed: gOldGameSpeed)
				(aCurtain dispose:)
				(gMusic stop: number: 332 loop: gBgMusicLoops play:)
				(= seconds (Random 7 15))
			)
			(20
				(= DaleState 5)
				(aDale
					view: 337
					setLoop: -1
					setCycle: Walk
					ignoreActors: 0
					illegalBits: 0
					posn: 245 -10
					baseSetter: squareBase
					setMotion: MoveTo 316 129 self
				)
				(= cycles 20)
			)
			(21
				(Print 330 47) ; "Patti, look! It's him!! Dale!!! He's here, walking through the audience!"
			)
			(22
				(if (or sitWithPatti (InRoom 14 335))
					(= DaleState 6)
					(aDale
						ignoreActors:
						illegalBits: 0
						setMotion: MoveTo 283 121 self
					)
					(if (InRoom 14 335)
						(Print 330 48) ; "Hey, that was you that threw that lovely little pair of panties at me, wasn't it?" asks Dale. "You look lonely. Would you like a little company?"
					else
						(Print 330 49) ; "Say beautiful, aren't you that fabulous babe who's entertaining over at the casino?" Dale asks you. "It's a privilege for me even to sit with you!"
					)
				else
					(self changeState: 26)
				)
			)
			(23
				(aDale
					posn: 283 121
					cycleSpeed: 1
					setLoop: 4
					setCel: 0
					setCycle: End self
				)
			)
			(24
				(= seconds 11)
			)
			(25
				(if (!= gEgoState 1004)
					(= seconds 5)
					(-- state)
				else
					(Print 330 50) ; ""Well, babe, it's been my pleasure," says Dale, standing to leave."
					(= DaleState 5)
					(aDale setCycle: Beg self)
				)
			)
			(26
				(aDale
					cycleSpeed: 0
					setStep: 3 2
					setCycle: Walk
					ignoreActors: 0
					illegalBits: 0
					setLoop: -1
					baseSetter: squareBase
					setMotion: MoveTo 333 143 self
				)
			)
			(27
				(= DaleState 7)
				(aDale dispose:)
			)
		)
	)
)

(instance aDrinker1 of Prop
	(properties
		y 8
		x 221
		view 330
		loop 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aDrinker2 of Prop
	(properties
		y 44
		x 239
		view 330
		loop 3
	)

	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aDrinker3 of Prop
	(properties
		y 77
		x 225
		view 330
		loop 4
	)

	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aDrinker4 of Prop
	(properties
		y 166
		x 264
		view 330
		loop 5
	)

	(method (init)
		(super init:)
		(self setScript: drinkerScript ignoreActors: stopUpd:)
	)
)

(instance drinkerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(switch (Random 1 4)
					(1
						(= currentDrinker aDrinker1)
					)
					(2
						(= currentDrinker aDrinker2)
					)
					(3
						(= currentDrinker aDrinker3)
					)
					(4
						(= currentDrinker aDrinker4)
					)
				)
				(currentDrinker setCycle: End self)
			)
			(2
				(= cycles (Random 15 29))
			)
			(3
				(currentDrinker setCycle: Beg self)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance atpPchair of PV
	(properties
		y 140
		x 281
		view 330
		loop 1
		priority 1
		signal 16384
	)
)

(instance atpDchair of PV
	(properties
		y 121
		x 281
		view 330
		loop 1
		cel 1
		priority 1
		signal 16384
	)
)

(instance aCurtain of Prop
	(properties
		y 88
		view 330
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setPri: 3 ignoreActors:)
	)
)

(instance aPanties of Act
	(properties
		y 1142
		x 283
		view 336
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setLoop: 3 setPri: 15 setCycle: Fwd setStep: 10 6 ignoreActors:)
	)
)

(instance aClothes of Act
	(properties
		y 1083
		x 105
		view 333
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setLoop: 7 setPri: 15 setCycle: Fwd setStep: 5 5 ignoreActors:)
	)
)

(instance squareBase of Code
	(properties)

	(method (doit whom)
		(whom brBottom: (+ (whom y:) 5))
		(whom brTop: (- (whom brBottom:) 9))
		(whom brLeft: (- (whom x:) 8))
		(whom brRight: (+ (whom x:) 8))
	)
)

