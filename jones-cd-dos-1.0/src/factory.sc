;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
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
	factory 0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance factory of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0 temp1)
		(= global562 0)
		(= gTimeClock timeClock)
		(if (not global518)
			(DoAudio audRATE 11025)
			(proc0_17 3)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= global440 9)
			(= global441 129)
			(= global442 120)
			(if (< global534 2)
				(Load rsVIEW (theTalker view:))
			)
			(= client param1)
			(gTimeKeep doit: 2)
			(= global400 5)
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
			)
			(self window: global38 add: background theTalker)
			(if (== (global302 worksAt:) 5)
				(self add: workButton)
			)
			(self add: exitButton)
			(= global413 theTalker)
			(self
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(gASong playBed: 46)
			(if (== (global302 worksAt:) 5)
				(self add: timeClock)
				(timeClock init: setSize: draw:)
			)
			(proc0_9 self keyMouseList exitButton)
			(KeyMouse setList: keyMouseList)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(= temp1 (Random 0 7))
				(computerScript state: -1 cycles: 0 seconds: 0)
				(proc0_18 (+ temp1 50) global413 computerScript)
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
		(DisposeScript 205)
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
		view 705
		priority 13
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
				(factory delete: self)
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
		(if (factory contains: self)
			(self draw:)
		)
	)
)

(instance timeClock of TimeClock
	(properties
		nsTop 40
		nsLeft 96
	)

	(method (setSize)
		(global502 aTimeClock: timeClock)
		(super setSize:)
	)
)

(instance theTalker of Talker
	(properties
		nsTop 40
		nsLeft 18
		view 355
	)
)

(instance computerScript of DialogScript
	(properties)

	(method (handleEvent event)
		(if register
			(= register 0)
			(event type: evKEYBOARD x: 160 y: 100)
			(= cycles 1)
			(super handleEvent: event 1)
		)
	)
)

