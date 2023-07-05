;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 253)
(include sci.sh)
(use Main)
(use AutoDoor)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm253 0
)

(synonyms
	(barrel can barrel)
	(basin handle faucet fountain)
)

(local
	sinkX
	sinkY
)

(instance rm253 of Rm
	(properties
		picture 253
		west 250
	)

	(method (init)
		(SetFlag 3)
		(SetFlag 4)
		(Load rsVIEW 254)
		(if gEgoIsPatti
			(= sinkX 45)
			(= sinkY 139)
		else
			(= sinkX 43)
			(= sinkY 137)
		)
		(if (and (gEgo has: 4) (== ((Inv at: 4) view:) 23)) ; Native_Grass, Native_Grass
			(Load rsVIEW 707)
			(Load rsVIEW 701)
			(Load rsVIEW 23)
		)
		(if (gEgo has: 13) ; Bottle_of_Wine
			(Load rsVIEW 13)
		)
		(if (not (TestFlag 30))
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(if
			(or
				(TestFlag 15)
				(and
					(not (Random 0 4))
					(> gMachineSpeed 16)
					(not gEgoIsPatti)
					(not (TestFlag 64))
					(TestFlag 30)
				)
			)
			(aJodi init:)
			(aBill init:)
			(alsHead init:)
			(alsFeet init:)
		)
		(super init:)
		(self setScript: RoomScript)
		(if (InRoom 5)
			(aSoap init:)
		)
		(aDoor setPri: 10 ignoreActors: init:)
		(gEgo posn: 1 171)
		(NormalEgo)
		(gEgo init:)
	)

	(method (newRoom newRoomNumber)
		(ClearFlag 3)
		(ClearFlag 4)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(& (gEgo onControl:) $0002)
					(or (< (gEgo heading:) 90) (> (gEgo heading:) 269))
				)
				(aDoor doorCtrl: 2 loop: 0)
			)
			(
				(and
					(& (gEgo onControl:) $0010)
					(> (gEgo heading:) 89)
					(< (gEgo heading:) 271)
				)
				(aDoor doorCtrl: 16 loop: 1)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'drink')
					(Said 'pull/basin,water')
					(Said 'get/drink/water')
					(Said 'get/drink')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0080))
						(Print 253 0) ; "You can't reach the sink from here."
					)
					(else
						(self changeState: 5)
					)
				)
			)
			((Said 'leak')
				(if (not (& (gEgo onControl:) $0010))
					(Print 253 1) ; "Not here! Can't you find someplace more modest?"
				else
					(Print 253 2) ; "Ahhhhhh!"
				)
			)
			(
				(or
					(Said 'fill/bottle')
					(Said 'drop/water/bottle')
					(Said 'get/water')
				)
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0080))
						(Print 253 0) ; "You can't reach the sink from here."
					)
					((not (gEgo has: 13)) ; Bottle_of_Wine
						(Print 253 3) ; "You have no way to carry any water."
					)
					((!= ((Inv at: 13) view:) 28) ; Bottle_of_Wine
						(Print 253 4) ; "Your bottle is currently full."
					)
					(else
						(self changeState: 10)
					)
				)
			)
			((Said 'get/soap')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (InRoom 5))
						(AlreadyTook) ; "You already took it."
					)
					((not (& (gEgo onControl:) $0080))
						(NotClose) ; "You're not close enough."
					)
					(else
						(self changeState: 1)
					)
				)
			)
			(
				(or
					(Said 'wear,(alter<in),(drop<on)/blade,skirt')
					(Said '(alter<from,out),(get<off),drain/cloth,cloth')
				)
				(cond
					((& (gEgo onControl:) $0040)
						(Print 253 5) ; "This cubicle has no door. You are far too modest to change clothes here."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 253 1) ; "Not here! Can't you find someplace more modest?"
					)
					((not (gEgo has: 4)) ; Native_Grass
						(Print 253 6) ; "What do you want to wear?"
					)
					((!= ((Inv at: 4) view:) 23) ; Native_Grass
						(Print 253 7) ; "How can you wear a clump of grass?"
					)
					((and (< gFilthLevel 3) (aDoor cel:))
						(Print 253 8) ; "Close the door!"
					)
					((== gEgoState 10)
						(self changeState: 17)
					)
					(else
						(self changeState: 15)
					)
				)
			)
			(
				(or
					(Said 'wear,(alter<in),(drop<on)/cloth,cloth')
					(Said '(alter<from,out),(get<off),drain/blade,skirt')
				)
				(cond
					((== gEgoState 0)
						(Print 253 6) ; "What do you want to wear?"
					)
					((& (gEgo onControl:) $0040)
						(Print 253 5) ; "This cubicle has no door. You are far too modest to change clothes here."
					)
					((not (& (gEgo onControl:) $0010))
						(Print 253 1) ; "Not here! Can't you find someplace more modest?"
					)
					((!= gEgoState 10)
						(Print 253 9) ; "How can you do that?"
					)
					((and (< gFilthLevel 3) (aDoor cel:))
						(Print 253 8) ; "Close the door!"
					)
					(else
						(self changeState: 17)
					)
				)
			)
			((Said 'clean/eye,body,me,bracelet')
				(if (or (TestFlag 8) (TestFlag 10))
					(Print 253 10) ; "You need more than just a hand basin to get rid of that workout aroma!"
				else
					(Print 253 11) ; "You would, but why bother?"
				)
			)
			((Said 'look>')
				(cond
					((Said '/bathroom,building')
						(Print 253 12) ; "The cabana has three cubicles (some of which have doors), and a sink with running water at its left end."
					)
					((Said '/basin')
						(Printf ; "A public sink is mounted on the side of the cabana.%s"
							253
							13
							(if (InRoom 5)
								{ A bar of soap hangs over the sink, suspended by a rope looped over a nail.}
							else
								{}
							)
						)
					)
					((and (InRoom 5) (Said '/soap,hemp'))
						(Print 253 14) ; "There's a bar of soap that's hanging from a rope that's looped over a nail that's driven into a board that's attached to the wall that's at the end of the cabana."
					)
					((and (not (gEgo has: 13)) (Said '/water')) ; Bottle_of_Wine
						(Print 253 15) ; "There is a water faucet on the sink. It may work."
					)
					((Said '/wall,clovis')
						(if (& (gEgo onControl:) $0010)
							(Print 253 16) ; "On the wall is scrawled the word "ZAX" which you think you've heard before, you're just not sure where."
						else
							(Print 253 17) ; "Two Guys from Clovis"
						)
					)
					((Said '/clovis')
						(Print 253 18) ; "Graffiti is not important in this game."
					)
					((Said '/nail,board,hemp')
						(Print 253 19) ; "Hey, come on. That was a JOKE!"
					)
					((Said '/barstool,hole')
						(if (& (gEgo onControl:) $0010)
							(Print 253 20) ; "YUCK!"
						else
							(NotClose) ; "You're not close enough."
						)
					)
					((Said '/barrel')
						(if (& (gEgo onControl:) $0100)
							(Print 253 21) ; "Believing yourself to be playing a previous Leisure Suit Larry game, you dig through the all the garbage in the can, only to discover..."
							(Print 253 22) ; "...a postcard saying, "The weather is here; wish you were beautiful." You return it to the trash."
						else
							(NotClose) ; "You're not close enough."
						)
					)
					((Said '/backstage,casino')
						(Print 253 23) ; "The casino is located just to the south of this clearing."
					)
					((Said '/door')
						(cond
							((& (gEgo onControl:) $0010)
								(Print 253 24) ; "The door closed behind you."
							)
							((& (gEgo onControl:) $0002)
								(Print 253 25) ; "The left cubicle is unoccupied at the moment. Just walk inside."
							)
							((& (gEgo onControl:) $0004)
								(Print 253 26) ; "This door is stuck. You cannot get inside."
							)
							((& (gEgo onControl:) $0008)
								(Print 253 27) ; "This cubicle has no door. You have no desire to use it!"
							)
							(else
								(NotClose) ; "You're not close enough."
							)
						)
					)
					((Said '[/area]')
						(Print 253 28) ; "The casino's changing cabana (which bears an amazing resemblance to an outhouse) is nestled in a grove of trees."
					)
				)
			)
			((Said '/door')
				(Print 253 29) ; "The left door is the only one that is available to you. The center door seems stuck and the right door is missing."
			)
			((Said '/barrel')
				(Print 253 30) ; "Stop thinking about garbage and get your mind back in the gutter!"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(HandsOff)
				(Ok) ; "O.K."
				(gEgo illegalBits: 0 setMotion: MoveTo sinkX sinkY self)
			)
			(2
				(gEgo view: 254 loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(aSoap dispose:)
				(gEgo get: 5 loop: 3 cel: 0 setCycle: End self) ; Soap-On-A-Rope
			)
			(4
				(NormalEgo 0)
				(gGame changeScore: 12)
				(Print 253 31) ; "You grab the unusually-shaped "Soap-On-A-Rope" that hangs above the sink."
			)
			(5
				(HandsOff)
				(Ok) ; "O.K."
				(gEgo illegalBits: 0 setMotion: MoveTo sinkX sinkY self)
			)
			(6
				(gSoundFX number: 253 loop: 11 play:)
				(gEgo
					view: (+ 254 gEgoIsPatti)
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(7
				(gEgo loop: 1 setCycle: Fwd)
				(= seconds 5)
			)
			(8
				(gEgo loop: 0 setCel: 255 setCycle: Beg self)
			)
			(9
				(gSoundFX stop:)
				(if (not (TestFlag 7))
					(SetFlag 7)
					(gGame changeScore: 2)
				)
				(Print 253 32 #at -1 10) ; "Ahhhhh."
				(NormalEgo 0)
			)
			(10
				(HandsOff)
				(Ok) ; "O.K."
				(gEgo illegalBits: 0 setMotion: MoveTo sinkX sinkY self)
			)
			(11
				(gSoundFX number: 253 loop: 1 play:)
				(gEgo
					view: (+ 254 gEgoIsPatti)
					loop: 2
					cel: 0
					setCycle: End self
				)
				(Print 253 33 #icon 13 0 0) ; "You place your bottle under the tap, while carefully considering the level of carcinogenic compounds therein."
			)
			(12
				(gEgo loop: 3 setCycle: Fwd)
				(= seconds 5)
			)
			(13
				(gEgo loop: 2 setCel: 255 setCycle: Beg self)
			)
			(14
				(gSoundFX stop:)
				((Inv at: 13) view: 29) ; Bottle_of_Wine
				(Format ((Inv at: 13) name:) 253 34) ; "Bottle of Water", Bottle_of_Wine
				(if (not (TestFlag 42))
					(SetFlag 42)
					(gGame changeScore: 37)
				)
				(NormalEgo 0)
			)
			(15
				(HandsOff)
				(Ok) ; "O.K."
				(if (not (TestFlag 59))
					(SetFlag 59)
					(gGame changeScore: 10)
				)
				(gEgo
					illegalBits: 0
					cycleSpeed: 1
					view: 701
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(16
				(= gNormalEgoView 707)
				(= gEgoState 10)
				(NormalEgo 3)
				(Print 253 35 #icon 23 0 0) ; "You remove your leisure suit and hide it inside the stall while slipping into the grass skirt. Boy, do you look like a native now!"
			)
			(17
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo
					illegalBits: 0
					cycleSpeed: 1
					view: 701
					loop: 2
					setCel: 255
					setCycle: Beg self
				)
			)
			(18
				(= gNormalEgoView 700)
				(= gEgoState 0)
				(NormalEgo 3)
				(if (gEgo has: 6) ; A_Twenty_Dollar_Bill
					(PutInRoom 4 -1)
					(Print 253 36) ; "Since you have no further use for the silly grass skirt, you toss it through a hole conveniently placed in the floor (you presume for just this purpose)."
				)
			)
		)
	)
)

(instance aDoor of AutoDoor
	(properties
		y 126
		x 93
		view 253
		roomCtrl 0
	)
)

(instance aSoap of View
	(properties
		y 111
		x 64
		view 253
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 10 ignoreActors: stopUpd:)
	)
)

(instance BillScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'talk/bill,man')
				(Print 253 37) ; "Bill ignores you (as usual)."
			)
			((Said 'talk/al')
				(Print 253 38) ; "Al is too busy working on something else to talk to you."
			)
			((Said 'look/al')
				(Print 253 39) ; "You couldn't bear the thought!"
			)
			((Said 'look/bill')
				(Print 253 40) ; "He's giving Al more verbal abuse."
			)
			((Said 'look/man')
				(Print 253 41) ; "It's William Skirvin, world-famous artist talking to Al Lowe, a ne'r-do-well game designer."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aBill setCel: 0)
				(= seconds (Random 2 9))
			)
			(1
				(aBill setLoop: 5 setCycle: Fwd)
				(= state -1)
				(= seconds (Random 2 5))
			)
			(2
				(aBill setLoop: 6 cel: 0 setCycle: End self)
				(= seconds 0)
			)
			(3
				(Print 253 42) ; "Wow!" says Bill. "Take a look at that bikini!"
				(Print 253 43) ; ""Open the door a little, will you, Bill?" responds Al."
				(= seconds 3)
			)
			(4
				(aBill setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance aJodi of Act
	(properties
		y 143
		x -30
		view 256
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Walk setScript: JodiScript)
	)
)

(instance JodiScript of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '/body')
				(Print 253 44 #at -1 144) ; "(Pant, pant, pant.)"
			)
			((Said '/woman,blond')
				(cond
					((< (aJodi y:) 0)
						(Print 253 45) ; "Where?"
					)
					((and (> state 3) (< state 6))
						(Print 253 46) ; "She's undressing!"
					)
					(else
						(Print 253 47) ; "What a body!"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(aJodi setMotion: MoveTo 184 143 self)
			)
			(2
				(aJodi setMotion: MoveTo 184 137 self)
			)
			(3
				(= seconds 3)
			)
			(4
				(aJodi loop: 4 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(5
				(SetFlag 64)
				(if
					(or
						(& (gEgo onControl:) $0040)
						(& (gEgo onControl:) $0008)
					)
					(Print 253 48) ; "Are you enjoying the view, buddy?"
				)
				(= seconds 3)
			)
			(6
				(aJodi
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 184 143 self
				)
			)
			(7
				(aJodi setMotion: MoveTo (aBill x:) 143 self)
			)
			(8
				(BillScript changeState: 2)
				(aJodi setMotion: MoveTo -10 143 self)
			)
			(9
				(aJodi dispose:)
				(self dispose:)
			)
		)
	)
)

(instance aBill of Prop
	(properties
		y 140
		x 160
		view 253
		loop 5
	)

	(method (init)
		(super init:)
		(self setPri: 10 setScript: BillScript stopUpd:)
	)
)

(instance alsHead of View
	(properties
		y 96
		x 138
		view 253
		loop 3
		priority 6
		signal 16641
	)
)

(instance alsFeet of View
	(properties
		y 132
		x 138
		view 253
		loop 4
		priority 9
		signal 16641
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 288
		view 257
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		y 154
		x 288
		view 257
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(aCredit1 setCycle: End)
				(= cycles 16)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 22)
			)
			(3
				(SetFlag 30)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)

