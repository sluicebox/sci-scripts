;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use WButton)
(use n108)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use DCIcon)
(use Motion)
(use User)
(use System)

(public
	discount 0
)

(local
	[local0 6]
	local6
	local7 = -1
)

(procedure (localproc_0 &tmp temp0) ; UNUSED
	(= temp0 (super doit:))
	(if global416
		(global418 attributes: (& (global418 attributes:) $ffbf))
	)
	(return temp0)
)

(procedure (localproc_1 &tmp temp0) ; UNUSED
	(= temp0 (super doit:))
	(if global416
		(global418 attributes: (& (global418 attributes:) $ffbf))
	)
	(return temp0)
)

(instance boughtItem of Obj
	(properties)

	(method (doit &tmp temp0)
		(while (== local7 (= temp0 (Random 11 26)))
			1
		)
		(= local7 temp0)
		(proc0_18 (+ local7 330) global413 computerScript)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(proc0_18 357 global413 computerScript)
	)
)

(class FS of Cycle
	(properties
		count 0
	)

	(method (init param1 param2)
		(super init: param1)
		(= caller param2)
		(= count (= cycleCnt 0))
	)

	(method (doit)
		(++ cycleCnt)
		(if (> cycleCnt (client cycleSpeed:))
			(= cycleCnt 0)
			(if (> (++ count) (client lastCel:))
				(= count 0)
			)
			(client cel: (self next: count))
		)
	)

	(method (next &tmp temp0)
		(if (< (= temp0 [local0 count]) 16)
			(caller loop: 1)
			(return temp0)
		else
			(caller loop: 2)
			(return (mod temp0 16))
		)
	)
)

(class DiscountDItem of CostDItem
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global418 global416)
			(global418 attributes: (| (global418 attributes:) $0100))
		)
		(return temp0)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance discount of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0 temp1 temp2 temp3)
		(= global562 0)
		(= gTimeClock timeClock)
		(if (not global518)
			(DoAudio audRATE 11025)
			(proc0_17 1)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= local6 0)
			(= global440 3)
			(= global441 209)
			(= global442 71)
			(if (< global534 2)
				(Load rsVIEW (theTalker view:))
			)
			(= global424 notEnoughCash)
			(= gBoughtItem boughtItem)
			(= gItems items)
			(= client param1)
			(gTimeKeep doit: 2)
			(= global400 11)
			(= global404 1)
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
			)
			(self
				add:
					background
					theTalker
					items
					exitButton
					refrigerator
					stove
					stereo
					colorTV
					bwTV
					microwave
					vcr
					casualClothes
					leisureSuit
					baseballTickets
					theatreTickets
					concertTickets
					encyclopedia
					dictionary
					atlas
					dogFood
					eightTrack
					trumanCapote
			)
			(for ((= temp0 0)) (> size 10) ((++ temp0))
				(if [global385 temp0]
					(self delete: (self at: [global385 temp0]))
				else
					(self
						delete: (self at: (= global553 (Random 4 (- size 1))))
					)
					(= [global385 temp0] global553)
				)
			)
			(if (== (global302 worksAt:) 11)
				(= temp2 (self indexOf: exitButton))
				(self addAfter: (self at: (- temp2 1)) workButton)
			)
			(for ((= temp0 (= temp3 0))) (< temp0 size) ((++ temp0))
				(if ((self at: temp0) isKindOf: DiscountDItem)
					((self at: temp0) nsTop: (+ (* (+ temp3 1) 13) 20))
					(if (>= temp3 2)
						((self at: temp0) nsLeft: 78)
					)
					(= [local0 temp3] ((self at: temp0) celNum:))
					(++ temp3)
				)
			)
			(items cel: [local0 0])
			(= global413 theTalker)
			(self
				window: global38
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(if (== (global302 worksAt:) 11)
				(self add: timeClock)
				(timeClock setSize:)
			)
			(gASong playBed: 37)
			(proc0_9 self keyMouseList (self at: 4))
			(KeyMouse setList: keyMouseList)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(= global553 (Random 0 10))
				(computerScript state: -1 cycles: 0 seconds: 0)
				(proc0_18 (+ global553 330) global413 computerScript)
			else
				(computerScript cue:)
			)
		else
			(KeyMouse setCursor: theItem)
		)
		(= global518 0)
		(= temp1 (self doit: 0 0))
		(if (IsObject temp1)
			(if (self contains: temp1)
				(= temp1 0)
			)
		else
			(= temp1 1)
		)
		(DoAudio audSTOP)
		(gASong fade:)
		(timeClock dispose:)
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
		(proc0_15 self 294)
		(workButton dispose:)
		(self dispose:)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		temp1
		(DisposeScript 211)
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
		view 811
	)
)

(instance refrigerator of DiscountDItem
	(properties
		nsLeft 11
		key 1
		text {Refrigerator.....}
		textColor 26
		shadowColor 102
		indexNum 21
		basePrice 650
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 211 0 text price) ; "%s.||$%3d"
		else
			(Format param1 211 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance stove of DiscountDItem
	(properties
		nsLeft 11
		key 2
		text {Stove|..............||}
		textColor 26
		shadowColor 102
		indexNum 23
		basePrice 490
		celNum 1
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 211 0 text price) ; "%s.||$%3d"
		else
			(Format param1 211 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance stereo of DiscountDItem
	(properties
		nsLeft 11
		key 3
		text {Stereo|.............||}
		textColor 26
		shadowColor 102
		indexNum 26
		basePrice 450
		celNum 2
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 211 0 text price) ; "%s.||$%3d"
		else
			(Format param1 211 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance colorTV of DiscountDItem
	(properties
		nsLeft 11
		key 4
		text {Color TV..........||}
		textColor 26
		shadowColor 102
		indexNum 24
		basePrice 349
		celNum 3
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 211 0 text price) ; "%s.||$%3d"
		else
			(Format param1 211 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance bwTV of DiscountDItem
	(properties
		nsLeft 11
		key 5
		text {Black & White TV||}
		textColor 26
		shadowColor 102
		indexNum 30
		basePrice 110
		celNum 4
	)
)

(instance microwave of DiscountDItem
	(properties
		nsLeft 11
		key 6
		text {Microwave|.........|}
		textColor 26
		shadowColor 102
		indexNum 27
		basePrice 220
		celNum 5
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance vcr of DiscountDItem
	(properties
		nsLeft 11
		key 7
		text {VCR...................|}
		textColor 26
		shadowColor 102
		indexNum 25
		basePrice 250
		celNum 6
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance casualClothes of DiscountDItem
	(properties
		nsLeft 11
		key 8
		text {Casual Clothes...}
		textColor 26
		shadowColor 102
		indexNum 36
		typeOfGoods 1
		units 9
		basePrice 35
		celNum 7
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if global416
			(global302 dressedForWork:)
			(global302 nakedCount: 0)
		)
		(return temp0)
	)
)

(instance leisureSuit of DiscountDItem
	(properties
		nsLeft 11
		key 20
		text {Dress Clothes.....}
		textColor 26
		shadowColor 102
		indexNum 35
		typeOfGoods 1
		units 9
		basePrice 90
		celNum 8
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if global416
			(global302 dressedForWork:)
			(global302 nakedCount: 0)
		)
		(return temp0)
	)
)

(instance baseballTickets of DiscountDItem
	(properties
		nsLeft 11
		key 10
		text {Baseball Tickets..}
		textColor 26
		shadowColor 102
		indexNum 37
		typeOfGoods 1
		units 4
		basePrice 45
		celNum 9
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global466))
			(= global466 1)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance theatreTickets of DiscountDItem
	(properties
		nsLeft 11
		key 11
		text {Theatre Tickets...}
		textColor 26
		shadowColor 102
		indexNum 38
		typeOfGoods 1
		units 4
		basePrice 30
		celNum 10
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global467))
			(= global467 1)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance concertTickets of DiscountDItem
	(properties
		nsLeft 11
		key 12
		text {Concert Tickets|..|}
		textColor 26
		shadowColor 102
		indexNum 39
		typeOfGoods 1
		units 4
		basePrice 40
		celNum 11
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global468))
			(= global468 1)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance encyclopedia of DiscountDItem
	(properties
		nsLeft 11
		key 23
		text {Encyclopedia.....}
		textColor 26
		shadowColor 102
		indexNum 31
		basePrice 475
		celNum 12
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 211 0 text price) ; "%s.||$%3d"
		else
			(Format param1 211 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance dictionary of DiscountDItem
	(properties
		nsLeft 11
		key 14
		text {Dictionary..........}
		textColor 26
		shadowColor 102
		indexNum 32
		basePrice 70
		celNum 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance atlas of DiscountDItem
	(properties
		nsLeft 11
		key 24
		text {Atlas.................|}
		textColor 26
		shadowColor 102
		indexNum 33
		basePrice 55
		celNum 14
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance dogFood of DiscountDItem
	(properties
		nsLeft 11
		key 16
		text {Dog Food...........|}
		textColor 26
		shadowColor 102
		typeOfGoods 3
		basePrice 18
		celNum 15
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if global416
			(proc0_13 -1)
		)
		(return temp0)
	)
)

(instance eightTrack of DiscountDItem
	(properties
		nsLeft 11
		key 17
		text {8-Track Player...}
		textColor 26
		shadowColor 102
		typeOfGoods 3
		basePrice 75
		celNum 16
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if global416
			(proc0_13 -1)
		)
		(return temp0)
	)
)

(instance trumanCapote of DiscountDItem
	(properties
		nsLeft 11
		key 18
		text {Works of Capote|}
		textColor 26
		shadowColor 102
		typeOfGoods 3
		basePrice 100
		celNum 17
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if global416
			(proc0_13 -2)
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
				(discount delete: self)
				(self erase:)
			)
			((and (< global323 60) (> global566 0))
				(items setCycle: 0)
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
		(if (discount contains: self)
			(self draw:)
		)
	)
)

(instance timeClock of TimeClock
	(properties
		nsTop 57
	)

	(method (cue)
		(self setCycle: 0)
		(items init:)
	)

	(method (setSize)
		(global502 aTimeClock: timeClock)
		(super setSize:)
	)
)

(instance items of DCIcon
	(properties
		nsTop 57
		view 711
		loop 1
		priority 14
		cycleSpeed 300
	)

	(method (cycle &tmp [temp0 2])
		(if (== (DoAudio audPOSITION) -1)
			(super cycle:)
		)
	)

	(method (init)
		(if (< global534 2)
			(self setCycle: FS self)
		)
	)

	(method (doit param1 &tmp temp0)
		(if (and (< global534 2) global416)
			(if cycler
				(cycler cycleCnt: -400)
			)
			(= temp0 (mod param1 16))
			(self cel: temp0 loop: (if (< param1 16) 1 else 2) draw:)
		)
	)

	(method (setCycle)
		(if (< global534 2)
			(super setCycle: &rest)
		)
	)

	(method (draw)
		(if (< global534 2)
			(super draw: &rest)
		)
	)

	(method (setSize)
		(if (< global534 2)
			(super setSize: &rest)
		)
	)

	(method (lastCel)
		(return 5)
	)
)

(instance theTalker of Talker
	(properties
		nsTop 0
		view 361
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
					(if
						(and
							(proc0_6 12)
							(not ((global302 durables:) objectAtIndexQuan: 33))
							(discount contains: atlas)
						)
						(event message: (atlas key:))
						(= cycles 60)
					)
				)
				(3
					(if
						(and
							(proc0_6 12)
							(>= (proc0_11) 800)
							(not ((global302 durables:) objectAtIndexQuan: 32))
							(discount contains: dictionary)
						)
						(event message: (dictionary key:))
						(= cycles 60)
					)
				)
				(4
					(if
						(and
							(proc0_6 12)
							(>= (proc0_11) 800)
							(not ((global302 durables:) objectAtIndexQuan: 31))
							(discount contains: encyclopedia)
						)
						(event message: (encyclopedia key:))
						(= cycles 60)
					)
				)
				(5
					(if (proc0_6 11)
						(switch (global302 uniform:)
							(36
								(if (discount contains: casualClothes)
									(event message: (casualClothes key:))
									(= cycles 60)
								)
							)
							(35
								(if (discount contains: leisureSuit)
									(event message: (leisureSuit key:))
									(= cycles 60)
								)
							)
						)
					)
				)
				(11
					(if
						(and
							(not global550)
							(< local6 2)
							(Random 0 1)
							(> (proc0_11) 800)
						)
						(++ local6)
						(event
							message:
								(Random
									(baseballTickets key:)
									(concertTickets key:)
								)
						)
						(= cycles 60)
					)
				)
				(else
					(super handleEvent: event 1)
				)
			)
		)
	)
)

