;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 201)
(include sci.sh)
(use Main)
(use WButton)
(use n108)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use User)
(use System)

(public
	rentOffice 0
	proc201_1 1
)

(procedure (localproc_0) ; UNUSED
	(Format @global100 201 0) ; "Welcome to the Rent Office. Don't snivel. Just pay your rent and leave."
	(Format @global100 201 1) ; "Welcome to the Rent Office. The rent is high, but where else can you get so little for so much."
	(Format @global100 201 2) ; "Welcome to the Rent Office. We don't charge any extra rent for the cockroaches."
	(Format @global100 201 3) ; "Welcome to the Rental Office. No waterbeds, pets or velvet toreador paintings, please."
	(Format @global100 201 4) ; "Welcome to the Rental Office. Where Sunday is Double Rent Increase Day!"
	(Format @global100 201 5) ; "Welcome to the Rental Office. Our closets are so roomy, you'll never want to come out!"
	(Format @global100 201 6) ; "Welcome to the Rental Office. Our security apartments feature 24-hour eunuch guards!"
	(Format @global100 201 7) ; "Welcome to the Rental Office. Come in and meet your slumlo...I mean, your landlord!"
	(Format @global100 201 8) ; "Just a few rules: no pets, no children, no smoking, no parties, and no jogging in the halls."
	(Format @global100 201 9) ; "You'll love it! 24-hour security, spa, exercise room and free parking for BMWs."
	(Format @global100 201 10) ; "A wise choice. Our other building has just been condemned."
	(Format @global100 201 11) ; "Oh, good! You'll fit right in...EVERYBODY there has an attitude."
	(Format @global100 201 12) ; "We've just put in a sun deck for your slow-roasting pleasure."
	(Format @global100 201 13) ; "Ah. Well, I expect you'll find the neighborhood quite challenging."
	(Format @global100 201 14) ; "Oh. Well, hopefully you'll still be around at rent time."
	(Format @global100 201 15) ; "Of course, that comes furnished with a disgusting old chair. Enjoy!"
	(Format @global100 201 16) ; "You'll be happy to know that we just put a fresh battery in the smoke detector."
	(Format @global100 201 17) ; "Just remember, the cockroaches are more frightened of you than you are of them."
	(Format @global100 201 18) ; "Thank you. See you soon."
	(Format @global100 201 19) ; "Come back again soon."
	(Format @global100 201 20) ; "I'm here for all of your renting needs."
	(Format @global100 201 21) ; "Please tell all your rich friends about m... I mean us."
	(Format @global100 201 22) ; "Thank You, but please don't call me at 4 in the morning again."
)

(procedure (proc201_1)
	(if (rentOffice contains: payGarnishment)
		(payGarnishment erase: price: (global302 rentOwed:) draw:)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(global413 init: 16)
		(Print ; "You do not have enough cash."
			201
			23
			310
			global413
			global440
			global441
			global442
			70
			70
			25
			global426
		)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance rentOffice of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0 temp1)
		(if (not global518)
			(Load rsTEXT 201)
			(proc0_17 3)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= global440 3)
			(= global441 209)
			(= global442 74)
			(= client param1)
			(= global424 notEnoughCash)
			(gTimeKeep doit: 2)
			(= global400 1)
			(= global405 1)
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
				(computerScript cue:)
			)
			(= temp1 0)
			(if (== (global302 worksAt:) 1)
				(= temp1 -1)
			)
			(if (or (not (mod global372 4)) (global302 leaveOpen:))
				(= temp1 1)
			)
			(payRent
				indexNum: (if (== (global302 livesAt:) 0) 40 else 41)
				price: (global302 curRent:)
			)
			(self window: global59 add: background exitButton)
			(= global413 theTalker)
			(cond
				((== temp1 1)
					(self
						add:
							theTalker
							theLongTitleLeft
							payRent
							moreTime
							rentLowCost
							rentSecurity
					)
					(if (global302 rentOwed:)
						(self add: payGarnishment)
						(payGarnishment price: (global302 rentOwed:))
					)
				)
				((== temp1 -1)
					(self add: theTalker theShortTitle)
				)
				(else
					(if (>= global534 2)
						(Palette palUNSET_FLAG 8 16 1)
						(Palette palUNSET_FLAG 144 255 1)
					)
					(background view: 697 loop: 0 cel: 0)
				)
			)
			(if (== (global302 worksAt:) 1)
				(self delete: theLongTitleLeft add: theShortTitle workButton)
			)
			(self
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 15
			)
			(gASong playBed: 35)
			(if (== (global302 worksAt:) 1)
				(self add: timeClock)
				(timeClock init: setSize: draw:)
			)
			(proc0_9
				self
				keyMouseList
				(if (== temp1 1) payRent else exitButton)
			)
			(KeyMouse setList: keyMouseList)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (and (or (== temp1 1) (== temp1 -1)) (proc0_14))
				(global413 init:)
				(Print
					201
					(Random 0 7)
					310
					global413
					global440
					global441
					global442
					70
					100
					25
					global426
				)
			)
		else
			(KeyMouse setCursor: theItem)
		)
		(= global518 0)
		(= temp0 (self doit: 0 0))
		(if (IsObject temp0)
			(if (self contains: temp0)
				(= temp0 0)
			)
		else
			(= temp0 1)
		)
		(KeyMouse
			setList:
				(if prevDialog
					(prevDialog keyMouseList:)
				else
					gMainKeyMouseList
				)
		)
		(keyMouseList release:)
		(keyMouseList dispose:)
		(= global502 prevDialog)
		(gASong fade:)
		(proc0_15 self 291)
		(self dispose:)
		(if (IsObject payGarnishment)
			(payGarnishment dispose:)
		)
		(workButton dispose:)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		temp0
		(DisposeScript 201)
	)

	(method (draw)
		(super draw:)
		(if global518
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
		)
	)
)

(instance background of DIcon
	(properties
		view 701
		loop 1
		priority 13
	)
)

(instance payRent of CostDItem
	(properties
		state 65
		nsTop 60
		nsLeft 20
		key 1
		text {Pay rent for 1 month.__}
		price 325
		indexNum 40
		typeOfGoods 1
		units 4
		fixedPrice 1
	)

	(method (doit)
		(global413 init: 16)
		(if (>= (proc0_11 global302) price)
			((global302 consumables:) recieve: indexNum (- 4 (mod global372 4)))
			(proc0_10 (* theSign price))
			(gASoundEffect play: 23)
			(gCalc doit:)
			(if global427
				(Print
					201
					(Random 18 22)
					310
					global413
					global440
					global441
					global442
					70
					70
					25
					global426
				)
			)
		else
			(gASoundEffect play: 23)
			(Print ; "You do not have enough cash."
				201
				23
				310
				global413
				global440
				global441
				global442
				70
				70
				25
				global426
			)
		)
		(gTimeKeep doit: visitTime)
		(return 0)
	)
)

(instance moreTime of WButton
	(properties
		nsTop 70
		nsLeft 20
		key 2
		text {Ask For More Time._______}
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (if (== (global302 livesAt:) 0) 40 else 41))
		(if (not ((global302 consumables:) objectAtIndexQuan: temp1))
			(if (not (global302 triedExt:))
				(= temp0
					(switch (global302 rentExt:)
						(-1 0)
						(0 1)
						(1
							(> (Random 1 12) 3)
						)
						(2
							(> (Random 1 12) 6)
						)
						(else
							(> (Random 1 12) 9)
						)
					)
				)
				(if (and (not (global302 triedExt:)) temp0)
					(global302 rentExt: (+ (global302 rentExt:) 1))
					(proc0_13 1)
					(gASoundEffect play: 23)
					(gASong pause: 1)
					(gASoundEffect play: 45 gASong)
					(global413 init: 16)
					(Print ; "Sure, you can pay your rent next week."
						201
						24
						310
						global413
						global440
						global441
						global442
						70
						70
						25
						global426
					)
					(global302 triedExt: 1)
				else
					(proc0_13 -1)
					(gASoundEffect play: 23)
					(gASong pause: 1)
					(gASoundEffect play: 44 gASong)
					(global413 init: 16)
					(Print ; "Sorry, your rent must be paid now."
						201
						25
						310
						global413
						global440
						global441
						global442
						70
						70
						25
						global426
					)
					(global302 triedExt: 2)
				)
			else
				(switch (global302 triedExt:)
					(1
						(gASoundEffect play: 23)
						(global413 init: 16)
						(Print ; "I already told you Yes!"
							201
							26
							310
							global413
							global440
							global441
							global442
							70
							70
							25
							global426
						)
					)
					(2
						(gASoundEffect play: 23)
						(global413 init: 16)
						(Print ; "I'll say it again. NO!"
							201
							27
							310
							global413
							global440
							global441
							global442
							70
							70
							25
							global426
						)
						(gASong pause: 1)
						(gASoundEffect play: 44 gASong)
						(global302 triedExt: (+ (global302 triedExt:) 1))
					)
					(3
						(gASoundEffect play: 23)
						(global413 init: 16)
						(Print ; "WhaddoI look like? A bank?. Get outa here!"
							201
							28
							310
							global413
							global440
							global441
							global442
							70
							70
							25
							global426
						)
						(gASong pause: 1)
						(gASoundEffect play: 44 gASong)
						(global302 triedExt: (+ (global302 triedExt:) 1))
					)
					(4
						(gASoundEffect play: 23)
						(global413 init: 16)
						(Print ; "If I told you once, I've told you a thousand times. NO!!!!!"
							201
							29
							310
							global413
							global440
							global441
							global442
							70
							90
							25
							global426
						)
						(gASong pause: 1)
						(gASoundEffect play: 44 gASong)
						(global302 triedExt: (+ (global302 triedExt:) 1))
					)
					(5
						(gASoundEffect play: 23)
						(global413 init: 16)
						(Print ; "Click on that button one more time and I'll break your finger."
							201
							30
							310
							global413
							global440
							global441
							global442
							70
							90
							25
							global426
						)
						(gASong pause: 1)
						(gASoundEffect play: 44 gASong)
						(global302 triedExt: (+ (global302 triedExt:) 1))
					)
				)
			)
		else
			(gASoundEffect play: 23)
			(global413 init: 16)
			(Print ; "You don't need an extension."
				201
				31
				310
				global413
				global440
				global441
				global442
				70
				70
				25
				global426
			)
		)
		(return 0)
	)
)

(instance rentLowCost of CostDItem
	(properties
		nsTop 80
		nsLeft 20
		key 3
		text {Rent Low-Cost Apartment__}
		indexNum 40
		typeOfGoods 1
		units 4
		basePrice 325
	)

	(method (doit &tmp temp0 temp1)
		(if (== (global302 livesAt:) 0)
			(gASoundEffect play: 23)
			(global413 init: 16)
			(Print ; "You already live at the low-cost housing."
				201
				32
				310
				global413
				global440
				global441
				global442
				70
				70
				25
				global426
			)
			(return 0)
		else
			(if
				(and
					(>= (proc0_11) price)
					(= temp1 ((global302 consumables:) objectAtIndex: 41))
					(temp1 quantity:)
				)
				(global413 init: 32)
				(if (== (global302 playing:) 29)
					(temp1 quantity: 0)
				else
					(gASoundEffect play: 23)
					(if
						(Print
							(Format @global100 201 33 (temp1 quantity:)) ; "Your %d weeks of prepaid rent on your Security Apartment are non-refundable. Are you sure that you want to rent a Low Cost Apartment at this time?"
							81
							{ YES }
							1
							81
							{ NO }
							0
							310
							global413
							global440
							global441
							global442
							70
							150
							311
						)
						(gASoundEffect play: 23)
						(global413 init: 16)
						(Print ; "OK. It was your decision."
							201
							34
							310
							global413
							global440
							global441
							global442
							70
							70
							25
							global426
						)
						(temp1 quantity: 0)
					else
						(gASoundEffect play: 23)
						(global413 init: 2)
						(Print ; "Smart move, buddy."
							201
							35
							310
							global413
							global440
							global441
							global442
							70
							70
							25
							global426
						)
						(return 0)
					)
				)
			)
			(= temp0 (super doit:))
			(if global416
				(payRent erase: indexNum: indexNum price: price draw:)
				(global302 curRent: price livesAt: 0)
				(if global427
					(global413 init: 16)
					(Print
						201
						(Random 13 17)
						310
						global413
						global440
						global441
						global442
						70
						100
						25
						global426
					)
				)
			)
		)
		(return temp0)
	)
)

(instance rentSecurity of CostDItem
	(properties
		nsTop 90
		nsLeft 20
		key 4
		text {Rent Security Apartment__}
		indexNum 41
		typeOfGoods 1
		units 4
		basePrice 475
	)

	(method (doit &tmp temp0 temp1)
		(if (== (global302 livesAt:) 2)
			(gASoundEffect play: 23)
			(global413 init: 16)
			(Print ; "You already live at the security apartments."
				201
				36
				310
				global413
				global440
				global441
				global442
				70
				70
				25
				global426
			)
			(return 0)
		else
			(gASoundEffect play: 23)
			(if
				(and
					(>= (proc0_11) price)
					(= temp1 ((global302 consumables:) objectAtIndex: 40))
					(temp1 quantity:)
				)
				(global413 init: 32)
				(cond
					((== (global302 playing:) 29)
						(temp1 quantity: 0)
					)
					(
						(Print
							(Format @global100 201 37 (temp1 quantity:)) ; "Your %d weeks of prepaid rent on your Low Cost Apartment are non-refundable. Are you sure that you want to rent a Security Apartment at this time?"
							311
							81
							{ YES }
							1
							81
							{ NO }
							0
							310
							global413
							global440
							global441
							global442
							70
							150
						)
						(gASoundEffect play: 23)
						(global413 init: 16)
						(Print ; "OK. It was your decision."
							201
							34
							310
							global413
							global440
							global441
							global442
							70
							70
							25
							global426
						)
						(temp1 quantity: 0)
					)
					(else
						(gASoundEffect play: 23)
						(global413 init: 2)
						(Print ; "Smart move, buddy."
							201
							35
							310
							global413
							global440
							global441
							global442
							70
							70
							25
							global426
						)
						(return 0)
					)
				)
			)
			(= temp0 (super doit:))
			(if global416
				(payRent erase: indexNum: indexNum price: price draw:)
				(global302 curRent: price livesAt: 2)
				(if global427
					(global413 init: 16)
					(Print
						201
						(Random 8 12)
						310
						global413
						global440
						global441
						global442
						70
						100
						25
						global426
					)
				)
			)
		)
		(return temp0)
	)
)

(instance payGarnishment of CostDItem
	(properties
		state 65
		nsTop 100
		nsLeft 20
		key 5
		text {Pay Garnishment Balance__}
		typeOfGoods 4
		fixedPrice 1
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if global416
			(global302 rentOwed: 0)
			(self erase: state: 0)
			(if global427
				(global413 init: 16)
				(Print ; "Please, pay your rent promptly from now on."
					201
					38
					310
					global413
					global440
					global441
					global442
					70
					100
					25
					global426
				)
			)
			(KeyMouse advance:)
			(rentOffice advance:)
			((global502 keyMouseList:) delete: self)
			(rentOffice delete: self)
		)
		(return temp0)
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 99
		nsTop 108
		nsLeft 143
		key 120
		view 250
		priority 15
	)
)

(instance workButton of ErasableDIcon
	(properties
		state 65
		nsTop 108
		nsLeft 75
		key 119
		view 250
		loop 1
		priority 15
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(timeClock cel: 0 draw:)
		(cond
			((== (= temp0 (proc108_0)) -1)
				(rentOffice delete: self)
				(self erase:)
			)
			((and (< global323 60) (> temp0 0))
				(timeClock doit:)
			)
		)
		(super doit: 0)
	)
)

(instance timeClock of TimeClock
	(properties)

	(method (setSize)
		(global502 aTimeClock: timeClock)
		(super setSize:)
	)
)

(instance theShortTitle of DIcon
	(properties
		nsLeft 67
		view 701
		priority 13
	)
)

(instance theLongTitleLeft of DIcon
	(properties
		view 701
		cel 1
		priority 13
	)
)

(instance theTalker of Talker
	(properties
		nsTop 0
		view 351
	)
)

(instance computerScript of DialogScript
	(properties)

	(method (handleEvent event)
		(if register
			(= register 0)
			(= cycles 1)
			(event type: evKEYBOARD x: 160 y: 100)
			(switch state
				(2
					(if (proc0_6 7)
						(= cycles 60)
						(event message: (payRent key:))
						(cond
							((== (global302 livesAt:) 0)
								(if
									(or
										(and
											((global302 durables:)
												objectAtIndexQuan: 21
											)
											((global302 durables:)
												objectAtIndexQuan: 23
											)
											(> (proc0_11) 600)
										)
										(<
											(rentSecurity price:)
											(global302 curRent:)
										)
									)
									(event message: (rentSecurity key:))
								)
							)
							(
								(and
									(<
										(rentLowCost price:)
										(- (global302 curRent:) 200)
									)
									(<
										(rentSecurity price:)
										(- (global302 curRent:) 100)
									)
								)
								(event message: (rentLowCost key:))
							)
						)
					)
				)
				(3
					(if (proc0_6 8)
						(= cycles 60)
						(event message: (moreTime key:))
					)
				)
				(11
					(if
						(and
							(rentOffice contains: payGarnishment)
							(> (proc0_11) (+ (payGarnishment price:) 300))
						)
						(= cycles 60)
						(event message: (payGarnishment key:))
					)
				)
				(else
					(super handleEvent: event 1)
				)
			)
		)
	)
)

