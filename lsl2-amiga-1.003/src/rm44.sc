;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Interface)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm44 0
)

(local
	work
	maidInRoom
	[unused 2]
)

(instance rm44 of Rm
	(properties
		picture 44
		horizon 1
	)

	(method (init)
		(Load rsVIEW 152)
		(Load rsVIEW 416)
		(if (and (gEgo has: 15) (gEgo has: 16)) ; Bikini_Top, Bikini_Bottom
			(Load rsVIEW 150)
			(Load rsVIEW 151)
		)
		(Load rsSOUND 12)
		(theSound init:)
		(super init:)
		(gAddToPics add: aTable aLamp aTable2 aBathroom aPainting doit:)
		(if ((gInventory at: 18) ownedBy: gCurRoomNum) ; Soap
			(aSoap stopUpd: init:)
		)
		(aBoat
			setCel: (Random 0 4)
			setPri: 0
			setStep: 1 1
			moveSpeed: 2
			illegalBits: 0
			init:
			setScript: boatScript
		)
		(NormalEgo)
		(gEgo posn: 159 162 init:)
		(if (== gCurrentEgoView 100)
			(Load rsVIEW 417)
			(Load rsVIEW 418)
			(Load rsVIEW 419)
			(Load rsVIEW 436)
			(aMaid posn: 160 234 illegalBits: 0 setCycle: Walk stopUpd: init:)
			(aBigFace view: 436 setLoop: 0 posn: 149 1060 setPri: 15 init:)
			(aBrother illegalBits: 0 posn: 160 234 setCycle: Walk init:)
		)
		(self setRegions: 400 setScript: rm44Script) ; rm400
	)
)

(instance rm44Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0004)
			(gCurRoom newRoom: 40)
		)
		(if (and (== state 7) (gEgo inRect: 100 120 127 130))
			(self cue:)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look<below/bed')
			(Print 44 0) ; "Pretty clever!"
			(Print 44 1) ; "But, you find only dust."
			(Print 44 2 #at -1 130) ; "(The maid probably has other chores to accomplish!)"
		)
		(if (Said '/burn')
			(Print 44 3) ; "It's just a lamp."
		)
		(if (Said 'look>')
			(if (Said '/woman')
				(cond
					((not maidInRoom)
						(Print 44 4) ; "Where?"
					)
					((!= gCurrentStatus 0)
						(NotNow) ; "Not now!"
					)
					(else
						(aBigFace posn: 149 59)
						(Timer setReal: aBigFace 5)
						(HandsOff)
					)
				)
			)
			(if (Said '/cabinet,bathtub')
				(Print 44 5) ; "The room is very comfortable."
			)
			(if (Said '/mirror')
				(if (== gCurrentEgoView 100)
					(Print 44 6) ; "Will you ever be handsome?"
				else
					(Print 44 7) ; "Eaaaaagggggtttttthhhhhhh!"
					(Print 44 8 #at -1 130) ; "(You just scared yourself silly!)"
				)
			)
			(if (Said '/barstool,bathroom')
				(Print 44 9) ; "The toilet is on the south wall of the bathroom."
			)
			(if
				(Said
					'/(airport<bath),basin,cabinet,bowl,bathroom,(airport<bath)'
				)
				(if ((gInventory at: 18) ownedBy: gCurRoomNum) ; Soap
					(Print 44 10) ; "A bowl filled with complimentary soap is near the sink."
				else
					(Print 44 11) ; "A bowl that formerly contained soap is near the sink."
				)
			)
			(if (Said '/bureau')
				(Print 44 12) ; "There isn't one."
			)
			(if (Said '/bed')
				(Print 44 13) ; "Why? You're not sleepy."
			)
			(if (Said '/art')
				(Print 44 14) ; "Starving Artists' Corp."
			)
			(if (Said '<back/art')
				(Print 44 15) ; "Made in Taiwan"
			)
			(if
				(or
					(Said '/mirror')
					(and
						(or (== gCurrentEgoView 150) (== gCurrentEgoView 151))
						(Said '/bikini')
					)
				)
				(cond
					((== gCurrentEgoView 150)
						(Print 44 16) ; "What a shame your figure hasn't yet filled out."
					)
					((== gCurrentEgoView 151)
						(Print 44 17) ; "There are few people who can fill a bikini like you, Larry!"
					)
					((== gCurrentEgoView 149)
						(Print 44 18) ; "Who says blondes have more fun, Larry?"
					)
					(else
						(Print 44 19) ; "Hey, look!" you cry, "It's me, Larry. Larry Laffer!"
					)
				)
			)
			(if (Said '/new,buffet')
				(if ((gInventory at: 19) ownedBy: gCurRoomNum) ; Matches
					(Print 44 20) ; "There is a book of complimentary matches lying on the nightstand near the bed."
				else
					(Print 44 21) ; "There's nothing left on the nightstand but a lamp, which you don't need."
				)
			)
			(if (Said '/cup')
				(Print 44 22) ; "There is a beach outside filled with people having fun."
				(Print 44 23 #at -1 130) ; "(Unlike you, Larry!)"
			)
			(if (Said '/beach')
				(Print 44 24) ; "The people are having a "beach" of a good time!"
			)
			(if (Said '[/airport]')
				(Print 44 25) ; "This room is considerably larger than your stateroom on board the cruise ship! It has a picture window overlooking the beach."
				(if (& (gEgo onControl:) $0002)
					(if ((gInventory at: 18) ownedBy: gCurRoomNum) ; Soap
						(Print 44 10) ; "A bowl filled with complimentary soap is near the sink."
					else
						(Print 44 11) ; "A bowl that formerly contained soap is near the sink."
					)
				else
					(Print 44 26) ; "There is a restroom, plus a dressing area near the picture window."
					(if ((gInventory at: 19) ownedBy: gCurRoomNum) ; Matches
						(Print 44 20) ; "There is a book of complimentary matches lying on the nightstand near the bed."
					)
				)
			)
		)
		(if (Said 'get/bowl')
			(Print 44 27) ; "Leave the toilet where it is!"
		)
		(if
			(or
				(Said 'shit,leak')
				(Said '/shit,leak')
				(Said '//shit,leak')
				(Said '/bathroom')
			)
			(if (gEgo inRect: 227 142 259 149)
				(gEgo loop: 2 setMotion: 0)
				(Print 44 28 #draw) ; "Ahhhh."
			else
				(NotClose) ; "You're not close enough."
			)
		)
		(if (and (== gCurrentEgoView 151) (Said 'drain/soap,buck/lid[<bikini]'))
			(Print 44 29) ; "No, better leave it there."
		)
		(if (Said 'wear,apply/flower')
			(Print 44 30) ; "You would look sweet, but decide to wait until later."
		)
		(if (Said '(pull<on),apply/water,basin')
			(Print 44 31) ; "You'd like to wash your hands of this whole affair!;"
		)
		(if (Said 'close,pull/cup,curtain')
			(Print 44 32) ; "It's too bad they don't close, but the darkened glass prevents anyone outside from looking in and seeing you in the dressing area."
		)
		(if maidInRoom
			(if (Said 'no')
				(Print 44 33) ; ""No, everything is NOT ok," you tell the maid."
				(Print 44 34) ; ""Well, sir; perhaps you'd like something that is not on the room service menu?" she asks with a smile."
			)
			(if (Said 'talk/woman')
				(Print (Format @gString 44 35 gLaffer)) ; ""Hello, my little native beauty," you tell her. %s"
				(Print 44 36) ; "Hello, sir," she smiles. "I would like to help you in any way I can."
			)
			(if (Said '(enjoy<make),(clit<have),fuck/woman')
				(cond
					((!= gCurrentStatus 0)
						(NotNow) ; "Not now!"
					)
					((> state 5)
						(Print 44 37) ; "Ok. I'm ready," she says with a smile. "How about you?"
					)
					(else
						(Ok) ; "Ok."
						(self changeState: 6)
					)
				)
			)
		)
		(if
			(or
				(Said '(board<to),(get<in),board/bed,nap')
				(Said '(lie<down),lie,nap')
			)
			(cond
				((== (gEgo view:) 152)
					(YouAre) ; "You are."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((!= gCurrentEgoView 100)
					(Print 44 38) ; "Not dressed like that!"
				)
				((< (gEgo y:) 121)
					(Print 44 39) ; "First, move to the other side of the bed."
				)
				((not (gEgo inRect: 104 127 122 131))
					(NotClose) ; "You're not close enough."
				)
				(else
					(= gCurrentStatus 1005)
					(Ok) ; "Ok."
					(User canControl: 0 canInput: 1)
					(= gCurrentEgoView (gEgo view:))
					(gEgo
						view: 152
						setLoop: 0
						cel: 0
						setCycle: Fwd
						cycleSpeed: 5
						setPri: 8
						setMotion: 0
						illegalBits: 0
						posn: 111 110
					)
				)
			)
		)
		(if (or (Said 'disembark/bed') (Said 'new,(awaken,new,get<up)'))
			(cond
				((!= (gEgo view:) 152)
					(YouAre) ; "You are."
				)
				((!= gCurrentStatus 1005)
					(NotNow) ; "Not now!"
				)
				(else
					(Ok) ; "Ok."
					(gEgo posn: 110 129)
					(NormalEgo 3)
				)
			)
		)
		(if
			(or
				(Said
					'wear,(alter<in),(drop<on)/job,(bra<bathing),lid,bottom,bikini'
				)
				(Said 'alter,(get<off),drain/bra,bra')
			)
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(maidInRoom
					(Print 44 40) ; "Not while there's a lady present!"
				)
				((or (== gCurrentEgoView 150) (== gCurrentEgoView 151))
					(Print 44 41) ; "You are!"
				)
				((and (gEgo has: 15) (gEgo has: 16)) ; Bikini_Top, Bikini_Bottom
					(if (gEgo inRect: 176 100 199 115)
						(Ok) ; "Ok."
						(= gCurrentEgoView 150)
						(gEgo view: 150)
						(gGame changeScore: 5)
						(Print 44 42 #at -1 130) ; "(Boy, do you look sweet!)"
					else
						(Print 44 43) ; "Have you no modesty? At least move to the dressing area behind the restroom."
					)
				)
				((or (gEgo has: 15) (gEgo has: 16)) ; Bikini_Top, Bikini_Bottom
					(Print 44 44) ; "Nah. Why would you want to wear half a bikini?"
				)
				(else
					(DontHave) ; "You don't have it."
				)
			)
		)
		(if
			(or
				(Said 'alter,wear,(drop<on)/bra,bra')
				(Said 'alter,drain,(get<off)/(bra<bathing),job')
			)
			(if (or (== gCurrentEgoView 150) (== gCurrentEgoView 151))
				(Print 44 45) ; "You'd better stay in the bikini. It's your only hope of escape."
			else
				(Print 44 46) ; "What do you want to wear?"
			)
		)
		(if (Said 'get/bathtub,bath')
			(Print 44 47) ; "There's no time."
		)
		(if (Said 'get/match')
			(cond
				((not ((gInventory at: 19) ownedBy: gCurRoomNum)) ; Matches
					(AlreadyTook) ; "You already took it."
				)
				((not (gEgo inRect: 70 127 103 139))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Ok) ; "Ok."
					(gEgo get: 19) ; Matches
					(gGame changeScore: 2)
					(Print 44 48) ; "You slip a book of matches into your pocket."
					(Print 44 49 #at -1 130) ; "(Gee, Larry; at last you've found your match!)"
					(theSound play:)
					(Print 44 50) ; "(Drum fill)"
				)
			)
		)
		(if (Said 'get/soap')
			(cond
				((not ((gInventory at: 18) ownedBy: gCurRoomNum)) ; Soap
					(AlreadyTook) ; "You already took it."
				)
				((not (gEgo inRect: 222 131 243 145))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Ok) ; "Ok."
					(gEgo get: 18) ; Soap
					(gGame changeScore: 2)
					(aSoap hide:)
					(Print 44 51 #at 15 -1 #width 280 #draw) ; "You grab the bowl full of tiny bars of soap and dump it into your pockets thinking, "When I get home, I can carefully wet these, and glue them all together to make at least one regular-sized bar. What a great deal!""
					(Print 44 52 #at -1 130) ; "(You have always been terminally cheap!)"
				)
			)
		)
		(if
			(or
				(Said 'drop,drop/lid,bikini/buck,bill')
				(Said 'drop,drop/buck,bill/lid,bikini')
			)
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(maidInRoom
					(Print 44 40) ; "Not while there's a lady present!"
				)
				((== gCurrentEgoView 151)
					(Print 44 53) ; "Your bra is full already!"
				)
				((!= gCurrentEgoView 150)
					(Print 44 54) ; "You aren't wearing a bikini."
				)
				((gEgo inRect: 176 100 199 115)
					(Ok) ; "Ok."
					(= gBraContents 6)
					(= gCurrentEgoView 151)
					(NormalEgo)
					(gGame changeScore: 12)
					(Print 44 55 #at -1 130) ; "(Are you sure you want to do this?)"
				)
				(else
					(Print 44 56) ; "Have you no modesty? At least move to the room's dressing area behind the restroom."
				)
			)
		)
		(if
			(or
				(Said 'drop,drop/lid,bikini/soap')
				(Said 'drop,drop/soap/lid,bikini')
			)
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(maidInRoom
					(Print 44 40) ; "Not while there's a lady present!"
				)
				((== gCurrentEgoView 151)
					(Print 44 53) ; "Your bra is full already!"
				)
				((!= gCurrentEgoView 150)
					(Print 44 54) ; "You aren't wearing a bikini."
				)
				((not (gEgo has: 18)) ; Soap
					(Print 44 57) ; "You have no soap."
				)
				((gEgo inRect: 176 100 199 115)
					(Ok) ; "Ok."
					(= gBraContents 18)
					(= gCurrentEgoView 151)
					(NormalEgo)
					(gGame changeScore: 12)
					(Print 44 55 #at -1 130) ; "(Are you sure you want to do this?)"
				)
				(else
					(Print 44 56) ; "Have you no modesty? At least move to the room's dressing area behind the restroom."
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gCurrentStatus 0) (== gCurrentEgoView 100))
					(= seconds 10)
				)
			)
			(1
				(if (and (== gCurrentStatus 0) (== gCurrentEgoView 100))
					(= maidInRoom 1)
					(aMaid setMotion: MoveTo 160 132 self)
				)
			)
			(2
				(LookAt aMaid gEgo 1)
				(= seconds 3)
			)
			(3
				(Print 44 58 #at -1 15 #width 280) ; ""Good morning, sir! I'm your customer service representative in charge of horizontal surface consistency and custodial maintenance. I trust you are finding everything satisfactory?" she asks."
				(Print 44 59 #at -1 130) ; "(She says she's the maid!)"
				(= seconds 8)
			)
			(4
				(Print (Format @gString 44 60 gTritePhrase)) ; "Ok," says the native maid coyly, "%s"
				(aMaid setMotion: MoveTo 160 234 self)
			)
			(5
				(= maidInRoom 0)
				(aMaid dispose:)
			)
			(6
				(= seconds (= cycles 0))
				(Print 44 61 #at -1 20) ; "Oh, sir," she smiles demurely, "I just love Americano men; they are so (how you say) 'financial.'"
				(aMaid setMotion: MoveTo 130 130 self)
			)
			(7
				(aMaid
					illegalBits: 0
					ignoreActors:
					view: 418
					loop: 0
					cel: 0
					setPri: 9
					posn: 127 110
				)
				(Print (Format @gString 44 62 gTritePhrase) #at -1 20 #draw) ; "Well, come on, big boy! What are you waiting for? Don't you want to '%s'"
			)
			(8
				(HandsOff)
				(= gCurrentStatus 1000)
				(gEgo
					illegalBits: 0
					ignoreActors:
					view: 418
					loop: 1
					cel: 0
					posn: 111 119
					setPri: 8
				)
				(= seconds 3)
			)
			(9
				(Print 44 63 #at -1 20 #draw) ; "Gee," you tell her, "is this room service, or what?"
				(= seconds 3)
			)
			(10
				(gEgo cycleSpeed: 1 setCycle: End self)
				(aMaid cycleSpeed: 1 setCycle: End)
			)
			(11
				(= seconds 4)
			)
			(12
				(gEgo hide:)
				(aMaid setLoop: 2 cel: 0 setCycle: Fwd posn: 137 104 setPri: 8)
				(= seconds 3)
			)
			(13
				(aMaid setLoop: 3)
				(= seconds 2)
			)
			(14
				(aMaid setLoop: 2)
				(= seconds 4)
			)
			(15
				(aMaid setLoop: 4)
				(= seconds 2)
			)
			(16
				(aMaid setLoop: 2)
				(= seconds 4)
			)
			(17
				(aMaid setLoop: 5)
				(= seconds 2)
			)
			(18
				(aMaid setLoop: 2)
				(aBrother setScript: brotherScript)
			)
			(19
				(aBrother setCycle: End self)
				(if (> gFilthLevel 10)
					(Print 44 64 #at -1 20 #draw) ; "Seester Maria! How many times I gotta tell you? Lay off the white meat!"
				else
					(Print 44 65) ; "Sister! How many times shall I shoot him?"
				)
				(= seconds 3)
			)
			(20
				(aMaid setLoop: 6)
				(= seconds 4)
			)
			(21
				(if (> gFilthLevel 10)
					(Print 44 66) ; "Bad choice, Larry! Remember: there's no such thing as a free lunch!"
				else
					(Print 44 67) ; "Bad choice, Larry!"
				)
				(= gCurrentStatus 1001)
			)
		)
	)
)

(instance brotherScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(aBrother setMotion: MoveTo 160 160 self)
			)
			(2
				(Print 44 68) ; "While you are indisposed, through the doorway marches the maid's older brother, Carlos."
				(Print 44 69) ; "Thanks to U.S. foreign aid, Carlos has many extra bullets that he enjoys firing for amusement!"
				(aBrother setMotion: MoveTo 150 122 self)
			)
			(3
				(aBrother setLoop: 1 cel: 0)
				(= seconds 3)
			)
			(4
				(rm44Script cue:)
				(self dispose:)
			)
		)
	)
)

(instance boatScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 15))
			)
			(1
				(aBoat setMotion: MoveTo 98 85 self)
			)
			(2
				(aBoat stopUpd:)
				(= seconds (Random 5 15))
			)
			(3
				(aBoat setCel: (Random 0 4) setMotion: MoveTo 179 85 self)
			)
			(4
				(aBoat setCel: (Random 0 4) stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance aBigFace of Prop
	(properties)

	(method (cue)
		(Print 44 70 #draw) ; "You find native women sexy."
		(Print 44 71 #at 55 155 #width 210) ; "(But then, you find any woman sexy!)"
		(self posn: 149 1060)
		(HandsOn)
	)
)

(instance theSound of Sound
	(properties
		number 12
	)
)

(instance aTable of PV
	(properties
		y 132
		x 81
		view 416
		priority 9
		signal 16384
	)
)

(instance aLamp of PV
	(properties
		y 96
		x 110
		view 416
		cel 1
		priority 4
		signal 16384
	)
)

(instance aTable2 of PV
	(properties
		y 106
		x 108
		view 416
		cel 2
		priority 3
		signal 16384
	)
)

(instance aBathroom of PV
	(properties
		y 126
		x 241
		view 416
		cel 3
		priority 9
		signal 16384
	)
)

(instance aPainting of PV
	(properties
		y 97
		x 82
		view 416
		cel 5
		priority 4
		signal 16384
	)
)

(instance aSoap of View
	(properties
		y 122
		x 256
		view 416
		cel 4
		priority 10
		signal 16384
	)
)

(instance aBoat of Act
	(properties
		y 84
		x 179
		view 416
		loop 1
		signal 16384
	)
)

(instance aMaid of Act
	(properties
		view 417
		loop 3
	)
)

(instance aBrother of Act
	(properties
		view 419
		signal 16384
	)
)

