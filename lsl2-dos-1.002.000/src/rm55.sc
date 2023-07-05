;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use Airplane)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm55 0
)

(local
	waitressX
	aWaitress
	aSidewalk
	aPlane
	aDoor
	aParachute
	aPlate
	aSidewalkNorth
	aSidewalkSouth
	orderedSpecial
	seenMessage
)

(instance rm55 of Rm
	(properties
		picture 55
		horizon 5
		west 54
	)

	(method (init)
		(Load rsVIEW 511)
		(Load rsVIEW 519)
		(Load rsVIEW 520)
		(super init:)
		((View new:)
			view: 519
			loop: 0
			cel: 1
			posn: 279 166
			setPri: 11
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 519
			loop: 0
			cel: 2
			posn: 301 187
			setPri: 11
			ignoreActors:
			addToPic:
		)
		((View new:)
			view: 519
			loop: 0
			cel: 0
			posn: 19 160
			setPri: 12
			ignoreActors:
			addToPic:
		)
		((= aPlate (View new:))
			view: 519
			loop: 0
			cel: 3
			posn: 999 999
			setPri: 15
			ignoreActors:
			init:
		)
		((= aDoor (Prop new:))
			view: 519
			setLoop: 2
			setCel: 0
			setPri: 11
			posn: 257 127
			cycleSpeed: 1
			ignoreActors:
			stopUpd:
			init:
		)
		((= aParachute (Prop new:))
			view: 519
			setLoop: 3
			setCel: 0
			setPri: 11
			posn: 264 1146
			cycleSpeed: 1
			setCycle: Fwd
			ignoreActors:
			init:
		)
		((= aPlane (Airplane new:))
			view: 511
			setCel: 0
			startX: 306
			startY: 22
			endX: 22
			endY: 22
			init:
		)
		((= aSidewalkNorth (Act new:))
			view: 519
			setLoop: 1
			setCel: 0
			setPri: 0
			setStep: 1 1
			illegalBits: 0
			posn: 187 98
			ignoreActors:
			init:
			setScript: sidewalkNorthScript
		)
		((= aSidewalkSouth (Act new:))
			view: 519
			setLoop: 1
			setCel: 0
			setPri: 0
			setStep: 1 1
			illegalBits: 0
			posn: 127 65
			ignoreActors:
			init:
			setScript: sidewalkSouthScript
		)
		((= aWaitress (Act new:))
			view: 520
			loop: 3
			setPri: 15
			posn: 52 173
			ignoreActors:
			illegalBits: 0
			init:
			setCycle: Walk
			setScript: waitressScript
		)
		(self setRegions: 500 setScript: rm55Script) ; rm500
		(if (== gPrevRoomNum 57)
			(= gCurrentStatus 8)
			(HandsOff)
			(gEgo
				illegalBits: -32768
				setPri: -1
				setLoop: 2
				setCycle: 0
				setCel: 0
				setStep: 1 1
				posn: 141 87
				init:
			)
			(rm55Script changeState: 1)
		else
			(NormalEgo)
			(gEgo observeControl: 4 posn: 33 145 init:)
		)
	)
)

(instance rm55Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (& (gEgo onControl:) $0002) (== gCurrentStatus 0))
				(gCurRoom newRoom: 54)
			)
			((and (& (gEgo onControl:) $0010) (== gCurrentStatus 0))
				(= gCurrentStatus 8)
				(self changeState: 3)
			)
			((& (gEgo onControl:) $0008)
				(if (and (== gCurrentStatus 0) (not seenMessage))
					(= seenMessage 1)
					(Print 55 0) ; "Hey! Stay outta there!" shouts the waitress. "You tryin' to get yourself killed?"
				)
			)
			(else
				(= seenMessage 0)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'explore,(look<in)/appetizer,pate,gravy,special')
			(cond
				((!= orderedSpecial 2)
					(DontHave) ; "You don't have it."
				)
				((not (gEgo inRect: 35 181 151 189))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Print 55 1) ; "Say! There's a bobby pin buried in the gravy."
				)
			)
		)
		(if (Said 'look>')
			(if (Said '/appetizer,gravy,special')
				(cond
					((!= orderedSpecial 2)
						(DontHave) ; "You don't have it."
					)
					((not (gEgo inRect: 35 181 151 189))
						(NotClose) ; "You're not close enough."
					)
					(else
						(Print 55 2) ; "It looks like it might be edible."
					)
				)
			)
			(if (Said '/carpet')
				(Print 55 3) ; "The moving sidewalks are a refreshingly modern touch in such a small airport, but boy, is it a long way to the gates!"
			)
			(if (Said '/dispenser')
				(Print 55 4) ; "The one to your right is labeled: "Brokin" (sic). The machine to the left is labeled: "Flight Insurance, $100.""
				(Print 55 5 #at -1 152) ; "(It's a little large for an insurance machine, isn't it?)"
			)
			(if (Said '/buffet,buffet,bar')
				(Print 55 6) ; "It's just a cheap plastic laminate, with a delicate little design that's too small to show up at this resolution!"
			)
			(if (Said '/woman,agent')
				(Print 55 7) ; "Nah. You'd rather not."
				(Print 55 8 #at -1 152) ; "(Trust me on this one!)"
			)
			(if (Said '/menu,sign')
				(Print 55 9 #mode 1) ; "MENU  Today only: Blue P ate Special  $1.00"
				(Print 55 10) ; "At least the price is reasonable."
			)
			(if (Said '[/airport,brick]')
				(Print 55 11) ; "A waitress cruises behind the snack bar while a pair of moving sidewalks disappear into the distance. There are some vending machines along the east wall and near the snack bar is a sign."
			)
		)
		(if (Said 'ask,buy/menu')
			(Print 55 12) ; "Pardon me, ma'am," you say, "but do you have a menu?"
			(Print 55 13) ; "Ain'cha got no eyes, fella? What's that big thing hanging on the wall there?"
		)
		(if (Said 'talk/woman,agent')
			(cond
				((gEgo has: 25) ; Bobby_Pin
					(Print 55 14) ; "Ha, ha, I fooled you," you tell the waitress. "I'm not eating that stuff again."
					(Print 55 15) ; "Why not?" she asks, "we say it's just like momma used to make!"
				)
				((== orderedSpecial 2)
					(Print 55 16) ; ""Say, is this stuff good to eat?" you ask."
					(Print 55 17 #at -1 152) ; "(She does not respond.)"
				)
				((and orderedSpecial (< orderedSpecial 2))
					(Print 55 18) ; ""Hey, mama, hurry up with that chow," you order."
					(Print 55 19 #at -1 152) ; "(It affects her speed not in the least!)"
				)
				(else
					(Print 55 20) ; ""Lovely weather, eh?" you ask the waitress."
					(Print 55 21) ; "Yep."
				)
			)
		)
		(if (Said 'buy,buy/special,appetizer')
			(cond
				((or orderedSpecial (not ((gInventory at: 25) ownedBy: gCurRoomNum))) ; Bobby_Pin
					(Print 55 22) ; "You already did that."
					(Print 55 23 #at -1 152) ; "(And you don't want another!)"
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 35 181 151 189))
					(NotClose) ; "You're not close enough."
				)
				(else
					(self changeState: 11)
				)
			)
		)
		(if (Said 'get/special,appetizer')
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((< orderedSpecial 2)
					(Print 55 24) ; "You must have some food before you can take it."
				)
				((not (gEgo inRect: 35 181 151 189))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Print 55 25) ; "Nah. The plate is stuck to the counter!"
				)
			)
		)
		(if (Said 'eat/special,appetizer')
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((== orderedSpecial 3)
					(Print 55 26) ; "No way. You feel that you've tasted that stuff in an earlier lifetime, and that time was enough!"
				)
				((!= orderedSpecial 2)
					(Print 55 27) ; "You must have some food before you can eat it. Try ordering something."
				)
				((not (gEgo inRect: 35 181 151 189))
					(NotClose) ; "You're not close enough."
				)
				(else
					(self changeState: 15)
				)
			)
		)
		(if (Said 'eat/!')
			(Print 55 28) ; "Eat what?"
		)
		(if (Said 'explore,explore,get/gravy,special,bobbypin')
			(cond
				((not ((gInventory at: 25) ownedBy: gCurRoomNum)) ; Bobby_Pin
					(AlreadyTook) ; "You already took it."
				)
				((!= orderedSpecial 2)
					(Print 55 29) ; "Where?"
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not (gEgo inRect: 35 181 151 189))
					(NotClose) ; "You're not close enough."
				)
				(else
					(gEgo get: 25) ; Bobby_Pin
					(= orderedSpecial 3)
					(aPlate posn: 999 999)
					(gGame changeScore: 7)
					(Print 55 30 #draw) ; "This time, you decide to save yourself from a fate worse than (well, ok, actually quite similar to; no, indeed, I suppose it would be identical to) death by fishing the bobby pin out of the "Blue Pate Special's" gravy-like substance instead of swallowing it."
				)
			)
		)
		(if
			(or
				(Said 'buy,get/insurance,parachute')
				(Said 'apply/dispenser')
				(Said 'drop/buck/dispenser')
			)
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((gEgo inRect: 272 178 287 186)
					(Print 55 31) ; "This machine is clearly labeled, "Brokin!""
				)
				((not (gEgo inRect: 248 150 275 172))
					(NotClose) ; "You're not close enough."
				)
				((not ((gInventory at: 24) ownedBy: gCurRoomNum)) ; Parachute
					(Print 55 32) ; "It's empty now."
					(Print 55 33 #at -1 152) ; "(But it did swallow another of your hundred dollar bills!)"
				)
				(else
					(self changeState: 5)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo
					illegalBits: 0
					setCel: 0
					setMotion: MoveTo 125 114 self
				)
			)
			(2
				(NormalEgo 2)
				(gEgo observeControl: 4)
			)
			(3
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: 3
					setCel: 4
					setStep: 1 1
					setMotion: MoveTo 174 88 self
				)
			)
			(4
				(gCurRoom newRoom: 56)
			)
			(5
				(HandsOff)
				(Print 55 34) ; "You peel off another hundred-dollar bill from your wad of money and insert it into the slot; the machine slurps it up, digests it, considers its authenticity, finds it valid, then begins to whir and shake."
				(= seconds 3)
			)
			(6
				(aDoor setCycle: End self)
			)
			(7
				(aParachute posn: 264 146 setCycle: End self)
			)
			(8
				(aDoor setCycle: Beg self)
			)
			(9
				(= seconds 3)
			)
			(10
				(aParachute dispose:)
				(gEgo get: 24) ; Parachute
				(gGame changeScore: 3)
				(Print 55 35 #draw) ; "What kind of airline is this, any way? Well, you suppose a parachute would be pretty good insurance, so you pick it up off the floor and hide it in your inner suitcoat pocket!"
				(User canControl: 1 canInput: 1)
			)
			(11
				(= orderedSpecial 1)
				(HandsOff)
				(Print 55 36) ; "Hey, baby!" you shout. "Gimme one o' them 'Blue Plate Specials!'"
				(= seconds 3)
			)
			(12
				(Print 55 37) ; ""That's 'Blue PATE' to you, baldie!" she retorts."
				(= seconds 3)
			)
			(13
				(Print 55 38) ; "Yo," she yells back into the kitchen, "slop me up another bald one!"
				(waitressScript changeState: 10)
			)
			(14
				(User canControl: 1 canInput: 1)
				(Print 55 39) ; "Here ya go, big boy," she says with a toothy grin, "one 'Big Blue' comin' atcha."
				(Print 55 40) ; "She slings the plate on the counter before you."
				(aPlate posn: (gEgo x:) 176)
				(= orderedSpecial 2)
			)
			(15
				(= gCurrentStatus 1000)
				(HandsOff)
				(Ok) ; "Ok."
				(Print 55 41) ; "You quickly wolf down the "Blue Pate Special" as if you had not eaten for an entire adventure game. "Say," you tell the waitress, "this is pretty good stuff. Why, this tastes just like the meatloaf Mama Laffer usggheddf dfgggfssef pssqfufufaaf arrrrgggggggghhhhh!""
				(gEgo hide:)
				(Print 55 42 #draw) ; "You drop to the floor near the counter while making clever, creative sounds with your trachea."
				(= seconds 3)
			)
			(16
				(Print 55 43) ; "You now remember what it was you hated about Mama Laffer's cooking..."
				(Print 55 44) ; ""She had a habit of losing her bobby pins in the gravy," you think, while you frantically make the universal sign for choking."
				(Print 55 45 #at -1 152) ; "(What a shame the waitress never heard of Dr. Heimlich!)"
				(= gCurrentStatus 1001)
			)
		)
	)
)

(instance waitressScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 3))
			)
			(1
				(= waitressX (Random 5 150))
				(aWaitress
					setLoop: (if (> waitressX (aWaitress x:)) 2 else 3)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(aWaitress
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo waitressX 175 self
				)
			)
			(3
				(aWaitress setLoop: (+ (aWaitress loop:) 2) cel: 3 setCycle: Beg self)
			)
			(4
				(= seconds (Random 2 5))
			)
			(5
				(switch (Random 1 7)
					(1
						(aWaitress
							cycleSpeed: 1
							setLoop: 4
							cel: 0
							setCycle: End self
						)
					)
					(2
						(aWaitress
							cycleSpeed: 1
							setLoop: 6
							cel: 0
							setCycle: End self
						)
					)
					(else
						(self changeState: 8)
					)
				)
			)
			(6
				(aWaitress setLoop: (+ (aWaitress loop:) 1) setCycle: Fwd)
				(= cycles (Random 30 50))
			)
			(7
				(aWaitress setLoop: (- (aWaitress loop:) 1) cel: 3 setCycle: Beg self)
			)
			(8
				(aWaitress setLoop: 2 setCel: 0 cycleSpeed: 0 setCycle: Walk)
				(= seconds (Random 1 3))
			)
			(9
				(self changeState: 0)
			)
			(10
				(= seconds (= cycles 0))
				(aWaitress
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo -222 175 self
				)
			)
			(11
				(aWaitress setMotion: MoveTo (gEgo x:) 175 self)
			)
			(12
				(rm55Script cue:)
				(self changeState: 3)
			)
		)
	)
)

(instance sidewalkNorthScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aSidewalkNorth setMotion: MoveTo 184 66 self)
			)
			(1
				(aSidewalkNorth posn: 187 122)
				(self changeState: 0)
			)
		)
	)
)

(instance sidewalkSouthScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aSidewalkSouth setMotion: MoveTo 124 118 self)
			)
			(1
				(aSidewalkSouth posn: 127 65)
				(self changeState: 0)
			)
		)
	)
)

