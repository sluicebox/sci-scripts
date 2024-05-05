;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 209)
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
	clothing 0
)

(local
	local0
	local1 = -1
)

(instance boughtItem of Obj
	(properties)

	(method (doit &tmp temp0)
		(while (== local1 (= temp0 (Random 9 29)))
			1
		)
		(= local1 temp0)
		(proc0_18 (+ local1 10) global413 computerScript)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(proc0_18 40 global413 computerScript)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance clothing of Dialog
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
			(proc0_17 1)
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
			(gTimeKeep doit: 2)
			(= global400 9)
			(= local0 0)
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
					businessSuit
					leisureSuit
					casualClothes
			)
			(if (== (global302 worksAt:) 9)
				(self add: workButton)
			)
			(self add: exitButton)
			(self
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(if (== (global302 worksAt:) 9)
				(self add: timeClock)
				(timeClock setSize:)
			)
			(gASong playBed: 39)
			(proc0_9 self keyMouseList businessSuit)
			(KeyMouse setList: keyMouseList)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(= global601 (Random 0 8))
				(computerScript state: -1 cycles: 0 seconds: 0)
				(proc0_18 (+ global601 10) global413 computerScript)
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
		(= global502 prevDialog)
		(keyMouseList dispose:)
		(proc0_15 self 294)
		(workButton dispose:)
		(self dispose:)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		temp0
		(DisposeScript 209)
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
		view 809
		priority 13
	)
)

(instance businessSuit of CostDItem
	(properties
		nsTop 63
		nsLeft 84
		key 2
		text {Business Suit__|}
		shadowColor 89
		flashColor 255
		indexNum 34
		typeOfGoods 1
		units 13
		basePrice 295
		celNum 2
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if global416
			(proc0_13 2)
			(global302 dressedForWork:)
			(global302 nakedCount: 0)
		)
		(return temp0)
	)
)

(instance leisureSuit of CostDItem
	(properties
		nsTop 78
		nsLeft 84
		key 3
		text {Dress Clothes__|}
		shadowColor 89
		flashColor 255
		indexNum 35
		typeOfGoods 1
		units 13
		basePrice 125
		celNum 1
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if global416
			(global302 dressedForWork:)
			(proc0_13 1)
			(global302 nakedCount: 0)
		)
		(return temp0)
	)
)

(instance casualClothes of CostDItem
	(properties
		nsTop 93
		nsLeft 84
		key 4
		text {Casual Clothes }
		shadowColor 89
		flashColor 255
		indexNum 36
		typeOfGoods 1
		units 11
		basePrice 73
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
				(clothing delete: self)
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
		(if (clothing contains: self)
			(self draw:)
		)
	)
)

(instance items of DCIcon
	(properties
		nsTop 57
		view 709
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
		view 359
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
					(if (proc0_6 11)
						(= local0 1)
						(= cycles 60)
						(event
							message:
								(switch (global302 uniform:)
									(36
										(casualClothes key:)
									)
									(35
										(leisureSuit key:)
									)
									(34
										(businessSuit key:)
									)
								)
						)
					)
				)
				(11
					(if
						(and
							(not local0)
							(>= (proc0_11) global412)
							(<= (global302 weeksOfClothing:) 1)
						)
						(= cycles 60)
						(event
							message:
								(switch (global302 uniform:)
									(36
										(casualClothes key:)
									)
									(35
										(leisureSuit key:)
									)
									(34
										(businessSuit key:)
									)
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

