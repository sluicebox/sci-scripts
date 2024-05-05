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

(procedure (proc201_1)
	(if (rentOffice contains: payGarnishment)
		(payGarnishment erase: price: (global302 rentOwed:) draw:)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(proc0_18 183 global413 computerScript)
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

	(method (init param1 &tmp temp0 temp1 temp2)
		(= global562 0)
		(= gTimeClock timeClock)
		(if (not global518)
			(DoAudio audRATE 11025)
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
			(self window: global38 add: background exitButton)
			(= global413 theTalker)
			(cond
				((== temp1 1)
					(Palette palUNSET_FLAG 8 16 1)
					(Palette palUNSET_FLAG 144 255 1)
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
					(Palette palUNSET_FLAG 8 16 1)
					(Palette palUNSET_FLAG 144 255 1)
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
				open: 0 -1
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
			(if (or (== temp1 1) (== temp1 -1))
				(if (and (== temp1 1) (proc0_14))
					(= temp2 (Random 0 7))
					(computerScript state: -1 cycles: 0 seconds: 0)
					(proc0_18 (+ temp2 160) global413 computerScript)
				else
					(computerScript cue:)
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
		(DoAudio audSTOP)
		(gASong fade:)
		(proc0_15 self 294)
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
		state 289
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

	(method (doit &tmp temp0)
		(global413 init: 16)
		(if (>= (proc0_11 global302) price)
			((global302 consumables:) recieve: indexNum (- 4 (mod global372 4)))
			(proc0_10 (* theSign price))
			(gASoundEffect play: 23)
			(gCalc doit:)
			(if global427
				(= temp0 (Random 18 22))
				(proc0_18 (+ temp0 160) global413 computerScript)
			)
		else
			(gASoundEffect play: 23)
			(proc0_18 183 global413 computerScript)
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
					(proc0_18 184 global413 computerScript)
					(global302 triedExt: 1)
				else
					(proc0_13 -1)
					(gASoundEffect play: 23)
					(gASong pause: 1)
					(gASoundEffect play: 44 gASong)
					(proc0_18 185 global413 computerScript)
					(global302 triedExt: 2)
				)
			else
				(switch (global302 triedExt:)
					(1
						(gASoundEffect play: 23)
						(proc0_18 186 global413 computerScript)
					)
					(2
						(gASoundEffect play: 23)
						(proc0_18 187 global413 computerScript)
						(gASong pause: 1)
						(gASoundEffect play: 44 gASong)
						(global302 triedExt: (+ (global302 triedExt:) 1))
					)
					(3
						(gASoundEffect play: 23)
						(proc0_18 188 global413 computerScript)
						(gASong pause: 1)
						(gASoundEffect play: 44 gASong)
						(global302 triedExt: (+ (global302 triedExt:) 1))
					)
					(4
						(gASoundEffect play: 23)
						(proc0_18 189 global413 computerScript)
						(gASong pause: 1)
						(gASoundEffect play: 44 gASong)
						(global302 triedExt: (+ (global302 triedExt:) 1))
					)
					(5
						(gASoundEffect play: 23)
						(proc0_18 190 global413 computerScript)
						(gASong pause: 1)
						(gASoundEffect play: 44 gASong)
						(global302 triedExt: (+ (global302 triedExt:) 1))
					)
				)
			)
		else
			(gASoundEffect play: 23)
			(proc0_18 191 global413 computerScript)
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

	(method (doit &tmp temp0 temp1 temp2)
		(if (== (global302 livesAt:) 0)
			(gASoundEffect play: 23)
			(proc0_18 192 global413 computerScript)
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
					(proc0_18 193 global413)
					(if
						(Print
							(Format @global100 201 0) ; "Rent Low-Cost Apartment?"
							81
							{ YES }
							1
							81
							{ NO }
							0
							70
							150
							319
						)
						(gASoundEffect play: 23)
						(proc0_18 194 global413 computerScript)
						(temp1 quantity: 0)
					else
						(gASoundEffect play: 23)
						(proc0_18 195 global413 computerScript)
						(return 0)
					)
				)
			)
			(= temp0 (super doit:))
			(if global416
				(payRent erase: indexNum: indexNum price: price draw:)
				(global302 curRent: price livesAt: 0)
				(if global427
					(= temp2 (Random 13 17))
					(proc0_18 (+ temp2 160) global413 computerScript)
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

	(method (doit &tmp temp0 temp1 temp2)
		(if (== (global302 livesAt:) 2)
			(gASoundEffect play: 23)
			(proc0_18 196 global413 computerScript)
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
				(if (== (global302 playing:) 29)
					(temp1 quantity: 0)
				else
					(proc0_18 197 global413)
					(if
						(Print
							(Format @global100 201 1) ; "Rent Security Apartment?"
							319
							#button
							{ YES }
							1
							#button
							{ NO }
							0
							#width
							150
						)
						(gASoundEffect play: 23)
						(proc0_18 194 global413 computerScript)
						(temp1 quantity: 0)
					else
						(gASoundEffect play: 23)
						(proc0_18 195 global413 computerScript)
						(return 0)
					)
				)
			)
			(= temp0 (super doit:))
			(if global416
				(payRent erase: indexNum: indexNum price: price draw:)
				(global302 curRent: price livesAt: 2)
				(if global427
					(= temp2 (Random 8 12))
					(proc0_18 (+ temp2 160) global413 computerScript)
				)
			)
		)
		(return temp0)
	)
)

(instance payGarnishment of CostDItem
	(properties
		state 289
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
				(proc0_18 198 global413 computerScript)
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
		state 419
		nsTop 108
		nsLeft 143
		key 120
		view 250
		priority 15
	)
)

(instance workButton of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 75
		key 119
		view 250
		loop 1
		priority 15
	)

	(method (doit)
		(if (!= (global302 playing:) 29)
			(gASoundEffect play: 23)
			(timeClock cel: 0 draw:)
			(= global566 (proc108_0))
		)
		(cond
			((== global566 -1)
				(rentOffice delete: self)
				(self erase:)
			)
			((and (< global323 60) (> global566 0))
				(timeClock doit:)
			)
		)
		(super doit: 0)
	)

	(method (select param1)
		(if param1
			(|= state $0008)
		else
			(&= state $fff7)
		)
		(if (rentOffice contains: self)
			(self draw:)
		)
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

