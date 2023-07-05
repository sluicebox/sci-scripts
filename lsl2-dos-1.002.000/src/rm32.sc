;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Door)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm32 0
)

(local
	oldEgoX
	oldEgoY
	causeOfDeath
	aPorthole
	aDoor
	aMama
	aFruit
)

(instance theSound of Sound
	(properties)
)

(instance rm32 of Rm
	(properties
		picture 32
	)

	(method (init)
		(Load rsVIEW 304)
		(Load rsVIEW 131)
		(if (gEgo has: 5) ; Swimsuit
			(Load rsVIEW 132)
		)
		(super init:)
		(NormalEgo)
		(self setRegions: 300 setScript: rm32Script) ; rm300
		(if ((gInventory at: 11) ownedBy: gCurRoomNum) ; Fruit
			((= aFruit (View new:))
				view: 304
				setLoop: 2
				setPri: 4
				posn: 156 83
				init:
			)
		)
		((= aPorthole (Prop new:))
			view: 304
			setLoop: 1
			setCel: 0
			setPri: 4
			posn: 148 75
			setCycle: Fwd
			cycleSpeed: 5
			isExtra: 1
			init:
		)
		(if gTimesInRm33
			(Load rsVIEW 309)
			(Load rsSOUND 6)
			(theSound number: 6 init:)
			((= aMama (Act new:))
				view: 309
				ignoreActors:
				illegalBits: 0
				setLoop: 0
				cel: 3
				setPri: 7
				setStep: 3 2
				setCycle: Fwd
				posn: 217 110
				init:
			)
			(if (and (not gRgTimer) (== gCurrentTimer 2))
				(= gCurrentStatus 1000)
				(rm32Script changeState: 1)
			)
		)
		((= aDoor (Door new:))
			view: 304
			setLoop: 0
			posn: 207 114
			setPri: 7
			entranceTo: 33
			doorCtrl: 4
			roomCtrl: 8
			msgLook:
				{This door should be locked, as it leads to someone else's cabin. (But, it's not!)}
			msgFunny:
				{You may have heard a soft, "Come in." (But you're not sure.)}
			msgCloser: {Just walk near it.}
			init:
		)
		(if (== gPrevRoomNum 33)
			(gEgo posn: 200 113)
		else
			(gEgo posn: 156 121)
		)
		(gEgo init:)
	)
)

(instance rm32Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 20)
			(ShakeScreen 1 (Random 1 3))
		)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 31)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'open,look/cabinet')
			(if (not (gEgo inRect: 150 96 168 110))
				(NotClose) ; "You're not close enough."
			else
				(Print 32 0) ; "You quickly open the cramped little closet and look inside. You find absolutely nothing, so you return the doors to their closed position."
			)
		)
		(if (Said 'look<on,over,above/cabinet[<lid]')
			(Print 32 1) ; "You feel nothing but dust."
			(Print 32 2 #at -1 152) ; "(But remember this if you ever play "King's Quest III.")"
		)
		(if (Said 'look<below/bed')
			(Print 32 3) ; "You are so clever to think to look under the bed!"
			(Print 32 4) ; "You find nothing."
		)
		(if (Said 'look>')
			(if (Said '/bed')
				(Print 32 5) ; "It's small and hard."
				(if (> gFilthLevel 10)
					(Print 32 6 #at -1 152) ; "(A condition not unknown to you!)"
				)
			)
			(if (Said '/new,bureau,buffet')
				(cond
					((not (gEgo inRect: 150 96 168 110))
						(NotClose) ; "You're not close enough."
					)
					((not ((gInventory at: 11) ownedBy: gCurRoomNum)) ; Fruit
						(Print 32 7) ; "You wonder what brand of furniture polish the ship's employees use to bring out the natural grain of that fine plywood."
					)
					(else
						(Print 32 8) ; "There is a bowl of fruit sitting on the nightstand, with a note attached."
						(Print 32 9) ; "You read the note..."
						(Print 32 10) ; "Bon voyage, Larry! Love, Mrs. Bimbo"
						(if gTimesInRm33
							(Print 32 11) ; "Egad! She's sending you gifts!"
						else
							(Print 32 12) ; "Who's "Mrs. Bimbo?!""
						)
					)
				)
			)
			(if
				(and
					((gInventory at: 11) ownedBy: gCurRoomNum) ; Fruit
					(Said '/basket,basket')
				)
				(if (not (gEgo inRect: 150 96 168 110))
					(NotClose) ; "You're not close enough."
				else
					(Print 32 8) ; "There is a bowl of fruit sitting on the nightstand, with a note attached."
					(Print 32 9) ; "You read the note..."
					(Print 32 10) ; "Bon voyage, Larry! Love, Mrs. Bimbo"
					(if gTimesInRm33
						(Print 32 11) ; "Egad! She's sending you gifts!"
					else
						(Print 32 12) ; "Who's "Mrs. Bimbo?!""
					)
				)
			)
			(if (Said '[/cabin,airport]')
				(Print 32 13) ; "No one on "The Dating Connection" promised you a deluxe cabin. In fact, this is surely "un-luxe!" Located at the rear of the ship's lowest deck, the noise from the engine compartment is deafening."
				(Print 32 14) ; "You have a bed, a nightstand, and a small closet. There is a door in the aft wall."
			)
		)
		(if (Said '(get,climb<in),board,board/cabinet')
			(Print 32 15) ; "It's too small to hold you."
			(Print 32 16 #at -1 152) ; "(Bet you were expecting another cheap "out of the closet" joke!)"
		)
		(if (Said 'get/dirt')
			(Print 32 17) ; "Nah. You're allergic."
		)
		(if
			(or
				(Said 'get/dress')
				(Said 'get<dress')
				(Said 'wear,alter,(get<off),drain,(drop<on)/job,bra,bra,bikini')
			)
			(cond
				((== gCurrentEgoView 132)
					(if (not (gEgo inRect: 170 90 176 110))
						(Print 32 18) ; "Have you no modesty? At least move behind the closet!"
					else
						(= gCurrentEgoView 100)
						(Ok) ; "Ok."
						(gEgo view: 100)
					)
				)
				((not (gEgo has: 5)) ; Swimsuit
					(if (gEgo has: 15) ; Bikini_Top
						(Print 32 19) ; "Nah. Who'd wear half a swimsuit?"
					else
						(DontHave) ; "You don't have it."
					)
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not gTimesInRm33)
					(Print 32 20) ; "Don't you want to see what's behind that door to the right?"
				)
				((not (gEgo inRect: 170 90 176 110))
					(Print 32 18) ; "Have you no modesty? At least move behind the closet!"
				)
				(else
					(= gCurrentEgoView 132)
					(Print 32 21) ; "Ok. This IS a good place to change clothes."
					(gEgo view: 132)
				)
			)
		)
		(if (Said 'open/bureau,new,new')
			(Print 32 22) ; "You open the nightstand's sole drawer and inspect it thoroughly."
			(Print 32 23) ; "Nothing."
			(Print 32 24) ; "Zip."
			(Print 32 25) ; "Nada."
			(Print 32 26) ; "You close the drawer."
		)
		(if
			(and
				(not (gEgo has: 11)) ; Fruit
				((gInventory at: 11) ownedBy: gCurRoomNum) ; Fruit
				(Said 'eat,apply/basket')
			)
			(Print 32 27) ; "Ok. You feel refreshed and fruitless."
			((gInventory at: 11) moveTo: -1) ; Fruit
			(gGame changeScore: -2)
		)
		(if (Said 'get/basket,basket')
			(cond
				((not ((gInventory at: 11) ownedBy: gCurRoomNum)) ; Fruit
					(AlreadyTook) ; "You already took it."
				)
				((not (gEgo inRect: 150 96 168 110))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Ok) ; "Ok."
					(aFruit dispose:)
					(gEgo get: 11) ; Fruit
					(gGame changeScore: 3)
				)
			)
		)
		(if (Said 'lie,board,bath[/bed,nap,barstool]')
			(cond
				((== (gEgo view:) 131)
					(YouAre) ; "You are."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 150 96 168 110))
					(NotClose) ; "You're not close enough."
				)
				(else
					(= gCurrentStatus 1005)
					(Print 32 28) ; "Ok. Thinking a little shut-eye might do you some good, you collapse on the bed, and immediately begin snoring."
					(User canControl: 0 canInput: 1)
					(= oldEgoX (gEgo x:))
					(= oldEgoY (gEgo y:))
					(= gCurrentEgoView (gEgo view:))
					(= causeOfDeath 1)
					(gEgo
						view: 131
						setLoop: (if (== gCurrentEgoView 100) 0 else 2)
						cel: 0
						setCycle: Fwd
						cycleSpeed: 2
						setPri: 9
						illegalBits: 0
						posn: 124 98
						setMotion: 0
					)
					(if gTimesInRm33
						(self changeState: 5)
					)
				)
			)
		)
		(if
			(or
				(Said 'new,get,awaken,new[/up]')
				(Said '(get<off),disembark/bed')
				(Said 'new,get<up')
			)
			(cond
				((!= (gEgo view:) 131)
					(Print 32 29) ; "You're not down."
				)
				((!= gCurrentStatus 1005)
					(NotNow) ; "Not now!"
				)
				(else
					(Ok) ; "Ok."
					(gEgo posn: oldEgoX oldEgoY)
					(NormalEgo 0)
					(if (== (aDoor doorState:) 0)
						(gEgo observeControl: 16384)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= gCurrentStatus 1000)
				(= causeOfDeath 2)
				(HandsOff)
				(= cycles 5)
			)
			(2
				(Print 32 30) ; "Night has fallen on the good ship U.S.S. Love Tub, so you head for your bed and a few hours of relaxing sleep."
				(gEgo setMotion: MoveTo 159 112 self)
			)
			(3
				(gEgo setMotion: MoveTo 155 103 self)
			)
			(4
				(= gCurrentStatus 1005)
				(gEgo
					view: 131
					setLoop: (if (== gCurrentEgoView 100) 0 else 2)
					cel: 0
					setCycle: Fwd
					cycleSpeed: 2
					setPri: 9
					illegalBits: 0
					posn: 124 98
					setMotion: 0
				)
				(= seconds 5)
			)
			(5
				(= gCurrentStatus 1000)
				(HandsOff)
				(= seconds 5)
			)
			(6
				(if (!= (aDoor doorState:) 0)
					(self changeState: 7)
				else
					(Print 32 31) ; "Unbeknownst to our "little boy blue," the door to the adjoining cabin swings open."
					(aDoor locked: 0 notify: self force: 1 open:)
				)
			)
			(7
				(Print 32 32) ; "Suddenly a deep rumbling shakes your cabin, not the steady roar of the ship's engines (to which you've now grown accustomed), this sounds more like an onrushing steam locomotive encountering a steep gradient while the fireman pours on the coal!"
				(= seconds 2)
			)
			(8
				(aMama show: setMotion: MoveTo 181 111 self)
			)
			(9
				(aMama setLoop: 1 setCel: 0 posn: 177 110 setPri: 13)
				(= cycles 2)
			)
			(10
				(aMama posn: 171 108 setCel: 1)
				(= cycles 2)
			)
			(11
				(aMama posn: 165 106 setCel: 2)
				(= cycles 2)
			)
			(12
				(aMama posn: 162 104 setCel: 3)
				(= cycles 2)
			)
			(13
				(Print 32 33 #at -1 20) ; "IT'S MAMA!!!!"
				(aMama setLoop: 2 posn: 162 104 setCel: 0)
				(= cycles 2)
			)
			(14
				(aMama posn: 162 104 setCel: 1)
				(= cycles 2)
			)
			(15
				(aMama posn: 162 104 setCel: 2)
				(= cycles 2)
			)
			(16
				(aMama posn: 160 102 setCel: 3)
				(= cycles 2)
			)
			(17
				(aMama posn: 158 98 setCel: 4)
				(= cycles 2)
			)
			(18
				(aMama posn: 154 92 setCel: 5)
				(= cycles 2)
			)
			(19
				(aMama posn: 158 89 setCel: 5)
				(= cycles 2)
			)
			(20
				(theSound play:)
				(aMama setLoop: 3 setMotion: 0 setCycle: Fwd posn: 129 106)
				(gEgo setLoop: (if (== gCurrentEgoView 100) 1 else 3) posn: 125 93)
				(= seconds 4)
			)
			(21
				(aMama setLoop: 0 setCel: 0 posn: 155 103)
				(Print 32 34 #at -1 15 #width 280 #draw) ; "Oops," says the big Mother, "I didn't mean ta hurt 'cha, lil' fella!"
				(Print 32 35 #at -1 15 #width 280) ; ""Shooooot, an' he was such a cute 'n, too!" she moans."
				(= seconds 1)
			)
			(22
				(= gCurrentStatus 1001)
				(if (== causeOfDeath 2)
					(Print 32 36) ; "Now it becomes clear to you. You must escape from this vessel before darkness falls or you'll continue to be the main course at a Mama party!"
				else
					(Print 32 37 #at -1 15 #width 280) ; "Too bad, Larry, but it seems your bed just isn't the place to be, if you want to be alone!"
				)
			)
		)
	)
)

