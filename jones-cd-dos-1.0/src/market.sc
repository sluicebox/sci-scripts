;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 203)
(include sci.sh)
(use Main)
(use FwdCount)
(use WButton)
(use n108)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use DCIcon)
(use User)
(use System)

(public
	market 0
)

(local
	local0
	local1 = -1
	local2 = 1
	local3
)

(instance boughtItem of Obj
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(if (!= param1 newspaper)
			(= temp1 0)
			(if (== param1 lotteryTickets)
				(if (not local2)
					(global413 init: 2)
					(= temp1 1)
				)
				(= local2 0)
			)
			(if (not temp1)
				(while (== local1 (= temp0 (Random 15 46)))
					1
				)
				(= local1 temp0)
				(proc0_18 (+ temp0 530) global413 computerScript)
			)
		)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(proc0_18 577 global413 computerScript)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance market of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0 temp1)
		(= global562 0)
		(= global563 0)
		(= gTimeClock timeClock)
		(= local3 0)
		(if (not global518)
			(DoAudio audRATE 11025)
			(proc0_17 2)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= global440 3)
			(= global441 207)
			(= global442 78)
			(if (< global534 2)
				(Load rsVIEW (theTalker view:))
			)
			(= global424 notEnoughCash)
			(= gBoughtItem boughtItem)
			(= gItems items)
			(= client param1)
			(gTimeKeep doit: 2)
			(= global400 3)
			(= local0 ((global302 durables:) objectAtIndexQuan: 21))
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
			)
			(= global413 theTalker)
			(self
				window: global38
				add:
					background
					theTalker
					items
					foodFor1Week
					foodFor2Weeks
					foodFor4Weeks
					lotteryTickets
					newspaper
			)
			(if (== (global302 worksAt:) 3)
				(self add: workButton)
			)
			(self add: exitButton)
			(self
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(if (== (global302 worksAt:) 3)
				(self add: timeClock)
				(timeClock setSize:)
			)
			(gASong playBed: 49)
			(proc0_9 self keyMouseList foodFor1Week)
			(KeyMouse setList: keyMouseList)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(= temp1 (Random 0 13))
				(computerScript state: -1 cycles: 0 seconds: 0)
				(proc0_18 (+ temp1 530) global413 computerScript)
			else
				(computerScript cue:)
			)
		else
			(KeyMouse setCursor: theItem)
		)
		(= global518 0)
		(= global446 0)
		(if (and (>= global372 4) (not (Random 0 50)) (> (proc0_11) 0))
			(= global446 1)
		)
		(= temp0 (self doit: 0 0))
		(if (IsObject temp0)
			(if (self contains: temp0)
				(= temp0 0)
			)
		else
			(= temp0 1)
		)
		(if global446
			(global302 cash: 0 cashHi: 0)
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
		temp0
		(DisposeScript 203)
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
		view 803
		priority 13
	)
)

(instance foodFor1Week of CostDItem
	(properties
		nsTop 31
		nsLeft 6
		key 1
		text {Food For 1 Week....}
		textColor 37
		shadowColor 112
		indexNum 1
		typeOfGoods 1
		basePrice 55
	)

	(method (doFormat param1)
		(if (< price 100)
			(Format param1 203 0 text price) ; "%s.||$%2d"
		else
			(Format param1 203 1 text price) ; "%s$%3d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global470))
			(= global470 1)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance foodFor2Weeks of CostDItem
	(properties
		nsTop 46
		nsLeft 6
		key 2
		text {Food For 2 Weeks..|}
		textColor 37
		shadowColor 112
		indexNum 1
		typeOfGoods 1
		units 2
		basePrice 100
		celNum 1
	)

	(method (doFormat param1)
		(if (< price 100)
			(Format param1 203 0 text price) ; "%s.||$%2d"
		else
			(Format param1 203 1 text price) ; "%s$%3d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global470))
			(= global470 1)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance foodFor4Weeks of CostDItem
	(properties
		nsTop 64
		nsLeft 75
		key 3
		text {Food For 4 Weeks..}
		textColor 37
		shadowColor 112
		indexNum 1
		typeOfGoods 1
		units 4
		basePrice 190
		celNum 2
	)

	(method (doFormat param1)
		(if (< price 100)
			(Format param1 203 0 text price) ; "%s.||$%2d"
		else
			(Format param1 203 1 text price) ; "%s$%3d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global470))
			(= global470 1)
			(proc0_13 4)
		)
		(return temp0)
	)
)

(instance lotteryTickets of CostDItem
	(properties
		nsTop 79
		nsLeft 74
		key 4
		text {10 Lottery Tickets|...|}
		textColor 37
		shadowColor 112
		price 10
		indexNum 9
		typeOfGoods 1
		units 10
		fixedPrice 1
		celNum 3
	)

	(method (doFormat param1)
		(Format param1 203 2 text price) ; "%s$%2d"
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global469))
			(= global469 1)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance newspaper of CostDItem
	(properties
		nsTop 94
		nsLeft 75
		key 5
		text {Newspaper................|}
		textColor 37
		shadowColor 112
		price 1
		indexNum 8
		typeOfGoods 3
		fixedPrice 1
		visitTime 1
		celNum 4
	)

	(method (doFormat param1)
		(Format param1 203 3 text price) ; "%s$%d"
	)

	(method (doit &tmp temp0)
		(if (!= global323 60)
			(super doit:)
			(if global416
				(gASong fade:)
				(gTimeKeep doit: 1)
				(proc0_15 market 294)
				(if (== (global302 playing:) 29)
					(SetMenu 1025 112 0)
					(SetMenu 1026 112 0)
				)
				(= temp0 ((ScriptID 215 0) init: client)) ; newspaper
				(SetMenu 1025 112 1)
				(SetMenu 1026 112 1)
				(= global563 0)
				(gASong play: 49)
				(global502 draw:)
				(global413 cel: 0 setCycle: 0 draw:)
				(return temp0)
			)
		else
			(proc0_18 578 global413 computerScript)
		)
		(return 0)
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
		state 257
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
				(market delete: self)
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
		(if (market contains: self)
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

(instance theTalker of Talker
	(properties
		nsTop 0
		view 353
	)
)

(instance items of DCIcon
	(properties
		nsTop 57
		view 703
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
			(self setCycle: FwdCount self)
		)
	)

	(method (doit param1)
		(if (and (< global534 2) global416)
			(if cycler
				(cycler cycleCnt: -400)
			)
			(self cel: param1 draw:)
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
					(if (and (proc0_6 2) local0)
						(= cycles 60)
						(cond
							((< (proc0_11) 200)
								(event message: (foodFor1Week key:))
							)
							((< (proc0_11) 400)
								(event message: (foodFor2Weeks key:))
							)
							(else
								(event message: (foodFor4Weeks key:))
							)
						)
						(= global411 1)
					)
				)
				(3
					(if (and (proc0_6 2) local0)
						(= cycles 60)
						(if (> (proc0_11) 800)
							(event message: (foodFor4Weeks key:))
						)
					)
				)
				(4
					(if
						(and
							(proc0_6 2)
							((global302 durables:) objectAtIndexQuan: 22)
							local0
						)
						(= cycles 60)
						(if (> (proc0_11) 800)
							(event message: (foodFor4Weeks key:))
						)
					)
				)
				(5
					(if (and (not local3) (not (Random 0 3)) (< global323 60))
						(= cycles 60)
						(= local3 1)
						(event message: (newspaper key:))
					)
				)
				(6
					(if
						(and
							(or (not (Random 0 2)) (proc0_6 13))
							(>= (proc0_11) 100)
						)
						(= global407 13)
						(if (> (= global408 (Random 1 (/ (proc0_11) 100))) 5)
							(= global408 5)
						)
					)
				)
				(7
					(if (and (== global407 13) global408)
						(= cycles 60)
						(event message: (lotteryTickets key:))
						(if (-- global408)
							(-- state)
						)
					)
				)
				(else
					(super handleEvent: event 1)
				)
			)
		)
	)
)

