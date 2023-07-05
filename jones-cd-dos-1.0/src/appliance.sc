;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 208)
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
	appliance 0
)

(local
	local0 = -1
)

(procedure (localproc_0 param1 param2)
	(if
		(and
			(>= (proc0_11) (param2 price:))
			(not ((global302 durables:) objectAtIndexQuan: param1))
		)
		(= global484 0)
		(return 1)
	)
	(return 0)
)

(instance boughtItem of Obj
	(properties)

	(method (doit &tmp temp0)
		(while (== local0 (= temp0 (Random 16 46)))
			1
		)
		(= local0 temp0)
		(proc0_18 (+ local0 100) global413 computerScript)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(proc0_18 147 global413 computerScript)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance appliance of Dialog
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
			(proc0_17 3)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= global440 1)
			(= global441 205)
			(= global442 132)
			(if (< global534 2)
				(Load rsVIEW (theTalker view:))
			)
			(= global424 notEnoughCash)
			(= gBoughtItem boughtItem)
			(= gItems items)
			(= client param1)
			(= global400 8)
			(gTimeKeep doit: 2)
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
					refrigerator
					freezer
					stove
					colorTV
					vcr
					stereo
					microwave
					hotTub
					computer
			)
			(if (== (global302 worksAt:) 8)
				(self add: workButton)
			)
			(self add: exitButton)
			(self
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(gASong playBed: 40)
			(if (== (global302 worksAt:) 8)
				(self add: timeClock)
				(timeClock setSize:)
			)
			(proc0_9 self keyMouseList refrigerator)
			(KeyMouse setList: keyMouseList)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(= temp0 (Random 0 15))
				(computerScript state: -1 cycles: 0 seconds: 0)
				(proc0_18 (+ temp0 100) global413 computerScript)
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
		(DisposeScript 208)
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
		view 808
		priority 13
	)
)

(instance refrigerator of CostDItem
	(properties
		nsTop 31
		nsLeft 77
		key 1
		text {Refrigerator|.......}
		textColor 39
		shadowColor 115
		indexNum 21
		basePrice 876
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 208 0 text price) ; "%s.||$%3d"
		else
			(Format param1 208 1 text price) ; "%s$%4d"
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

(instance freezer of CostDItem
	(properties
		nsTop 39
		nsLeft 77
		key 2
		text {Freezer|..............|}
		textColor 39
		shadowColor 115
		indexNum 22
		basePrice 513
		celNum 1
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 208 0 text price) ; "%s.||$%3d"
		else
			(Format param1 208 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance stove of CostDItem
	(properties
		nsTop 47
		nsLeft 77
		key 3
		text {Stove.................|}
		textColor 39
		shadowColor 115
		indexNum 23
		basePrice 570
		celNum 2
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 208 0 text price) ; "%s.||$%3d"
		else
			(Format param1 208 1 text price) ; "%s$%4d"
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

(instance colorTV of CostDItem
	(properties
		nsTop 60
		nsLeft 10
		key 4
		text {Color TV.............}
		textColor 39
		shadowColor 115
		indexNum 24
		basePrice 525
		celNum 3
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 208 0 text price) ; "%s.||$%3d"
		else
			(Format param1 208 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance vcr of CostDItem
	(properties
		nsTop 68
		nsLeft 10
		key 5
		text {VCR....................}
		textColor 39
		shadowColor 115
		indexNum 25
		basePrice 333
		celNum 4
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 208 0 text price) ; "%s.||$%3d"
		else
			(Format param1 208 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance stereo of CostDItem
	(properties
		nsTop 76
		nsLeft 10
		key 6
		text {Stereo................|}
		textColor 39
		shadowColor 115
		indexNum 26
		basePrice 412
		celNum 5
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 208 0 text price) ; "%s.||$%3d"
		else
			(Format param1 208 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance microwave of CostDItem
	(properties
		nsTop 84
		nsLeft 10
		key 7
		text {Microwave..........|}
		textColor 39
		shadowColor 115
		indexNum 27
		basePrice 330
		celNum 6
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 208 0 text price) ; "%s.||$%3d"
		else
			(Format param1 208 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 2)
		)
		(return temp0)
	)
)

(instance hotTub of CostDItem
	(properties
		nsTop 92
		nsLeft 10
		key 8
		text {Hot Tub..............}
		textColor 39
		shadowColor 115
		indexNum 28
		basePrice 1255
		celNum 7
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 208 0 text price) ; "%s.||$%3d"
		else
			(Format param1 208 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 3)
		)
		(return temp0)
	)
)

(instance computer of CostDItem
	(properties
		nsTop 100
		nsLeft 10
		key 10
		text {Computer............}
		textColor 39
		shadowColor 115
		indexNum 29
		basePrice 1599
		celNum 8
	)

	(method (doFormat param1)
		(if (< price 1000)
			(Format param1 208 0 text price) ; "%s.||$%3d"
		else
			(Format param1 208 1 text price) ; "%s$%4d"
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if
			(and
				global416
				(not ((global302 durables:) objectAtIndexQuan: indexNum))
			)
			(proc0_13 3)
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
				(appliance delete: self)
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
		(if (appliance contains: self)
			(self draw:)
		)
	)
)

(instance items of DCIcon
	(properties
		view 708
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

	(method (lastCel)
		(return 8)
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
	(properties)

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
		nsTop 57
		view 358
	)
)

(instance computerScript of DialogScript
	(properties)

	(method (handleEvent event &tmp [temp0 2])
		(if register
			(= register 0)
			(= cycles 1)
			(event type: evKEYBOARD x: 160 y: 100)
			(switch state
				(2
					(if (proc0_6 15)
						(cond
							((localproc_0 21 refrigerator)
								(event message: (refrigerator key:))
							)
							((localproc_0 23 stove)
								(event message: (stove key:))
							)
							((localproc_0 24 colorTV)
								(event message: (colorTV key:))
							)
							((localproc_0 27 microwave)
								(event message: (microwave key:))
							)
							((localproc_0 26 stereo)
								(event message: (stereo key:))
							)
							((localproc_0 22 freezer)
								(event message: (freezer key:))
							)
							((localproc_0 25 vcr)
								(event message: (vcr key:))
							)
							(else
								(= global484 1)
							)
						)
						(if (event message:)
							(= cycles 60)
						)
					)
				)
				(11
					(if (> (proc0_11) 800)
						(cond
							((localproc_0 21 refrigerator)
								(event message: (refrigerator key:))
							)
							((localproc_0 23 stove)
								(event message: (stove key:))
							)
							((localproc_0 24 colorTV)
								(event message: (colorTV key:))
							)
							((localproc_0 27 microwave)
								(event message: (microwave key:))
							)
							((localproc_0 26 stereo)
								(event message: (stereo key:))
							)
							((localproc_0 22 freezer)
								(event message: (freezer key:))
							)
							((localproc_0 28 hotTub)
								(event message: (hotTub key:))
							)
							((localproc_0 29 computer)
								(event message: (computer key:))
							)
							((localproc_0 25 vcr)
								(event message: (vcr key:))
							)
							(else
								(= global484 1)
							)
						)
					)
					(if (event message:)
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

