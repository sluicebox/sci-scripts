;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
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
	fastFood 0
)

(local
	local0 = -1
)

(instance boughtItem of Obj
	(properties)

	(method (doit &tmp temp0)
		(while (== local0 (= temp0 (Random 20 54)))
			1
		)
		(= local0 temp0)
		(proc0_18 (+ local0 610) global413 computerScript)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(proc0_18 665 global413 computerScript)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance fastFood of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0)
		(= global562 0)
		(= gTimeClock timeClock)
		(if (not global518)
			(DoAudio audRATE 11025)
			(proc0_17 2)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= global440 3)
			(= global441 205)
			(= global442 80)
			(if (< global534 2)
				(Load rsVIEW (theTalker view:))
			)
			(= global424 notEnoughCash)
			(= gBoughtItem boughtItem)
			(= gItems items)
			(= client param1)
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
			)
			(gTimeKeep doit: 2)
			(= global400 10)
			(self
				window: global38
				add:
					background
					theTalker
					items
					hamburgers
					cheeseburgers
					chicken
					fries
					shakes
					colas
			)
			(= global413 theTalker)
			(if (== (global302 worksAt:) 10)
				(self add: workButton)
			)
			(self add: exitButton)
			(self
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(gASong playBed: 38)
			(if (== (global302 worksAt:) 10)
				(self add: timeClock)
				(timeClock setSize:)
			)
			(KeyMouse setList: keyMouseList)
			(proc0_9 self keyMouseList hamburgers)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(= global553 (Random 0 19))
				(computerScript state: -1 cycles: 0 seconds: 0)
				(proc0_18 (+ global553 610) global413 computerScript)
			else
				(computerScript cue:)
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
		(DisposeScript 210)
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
		view 810
		priority 13
	)
)

(instance hamburgers of CostDItem
	(properties
		nsTop 33
		nsLeft 10
		key 1
		text {Hamburgers.........}
		textColor 27
		shadowColor 116
		indexNum 3
		typeOfGoods 1
		basePrice 79
	)
)

(instance cheeseburgers of CostDItem
	(properties
		nsTop 45
		nsLeft 10
		key 2
		text {Cheeseburger.......|}
		textColor 27
		shadowColor 116
		indexNum 4
		typeOfGoods 1
		basePrice 89
		celNum 1
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global472))
			(= global472 1)
			(proc0_13 1)
		)
		(return temp0)
	)
)

(instance chicken of CostDItem
	(properties
		nsTop 63
		nsLeft 75
		key 3
		text {Astro Chicken.......|}
		textColor 27
		shadowColor 116
		indexNum 2
		typeOfGoods 1
		basePrice 124
		celNum 2
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global472))
			(= global472 1)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance fries of CostDItem
	(properties
		nsTop 74
		nsLeft 75
		key 4
		text {Fries....................}
		textColor 27
		shadowColor 116
		indexNum 5
		typeOfGoods 1
		basePrice 65
		celNum 3
	)
)

(instance shakes of CostDItem
	(properties
		nsTop 86
		nsLeft 75
		key 5
		text {Shakes.................|}
		textColor 27
		shadowColor 116
		indexNum 6
		typeOfGoods 3
		basePrice 102
		celNum 4
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global471))
			(= global471 1)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance colas of CostDItem
	(properties
		nsTop 97
		nsLeft 75
		key 6
		text {Colas...................|}
		textColor 27
		shadowColor 116
		indexNum 7
		typeOfGoods 3
		basePrice 69
		celNum 5
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (and global416 (not global471))
			(= global471 1)
			(proc0_13 1)
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
				(fastFood delete: self)
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
		(if (fastFood contains: self)
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
		view 360
	)
)

(instance items of DCIcon
	(properties
		nsTop 57
		view 710
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
					(if (proc0_6 2)
						(= cycles 60)
						(event
							message:
								(cond
									(global550 4)
									((> (proc0_11) 750)
										(Random 1 4)
									)
									((>= (proc0_11) (hamburgers price:))
										(if (Random 0 1) 1 else 4)
									)
									(else 4)
								)
						)
						(= global411 1)
					)
				)
				(3
					(if
						(and
							(not global550)
							(proc0_6 2)
							(not (Random 0 4))
							(> (proc0_11) 750)
						)
						(= cycles 60)
						(event message: (Random 5 6))
					)
				)
				(11
					(if (not global411)
						(= cycles 60)
						(event
							message:
								(cond
									(global550 4)
									((> (proc0_11) 750)
										(Random 1 4)
									)
									((Random 0 1) 1)
									(else 4)
								)
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

