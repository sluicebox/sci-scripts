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

(procedure (localproc_0) ; UNUSED
	(Format @global100 205 0) ; "Welcome to the Factory. We will overwork you, under pay you, and expect you to take it with a smile."
	(Format @global100 205 1) ; "Welcome to the Factory. Where else can you have this much fun and get paid for it too."
	(Format @global100 205 2) ; "Welcome to the Factory. Where the work is hard, the pay is low, and the conditions are miserable."
	(Format @global100 205 3) ; "Welcome to the Factory. Thursday is Double Workman's Compensation Day!"
	(Format @global100 205 4) ; "Welcome to the Factory. We pay Top Dollar for Blue Collar!"
	(Format @global100 205 5) ; "Welcome to the Factory. No sweat...no paycheck!"
	(Format @global100 205 6) ; "Welcome to the Factory. Where money is our most important product."
	(Format @global100 205 7) ; "Welcome to the Factory. Please wear your safety helmet during scheduled inspections."
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

	(method (init param1 &tmp temp0)
		(if (not global518)
			(Load rsTEXT 205)
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
				(computerScript cue:)
			)
			(self window: global59 add: background theTalker)
			(if (== (global302 worksAt:) 5)
				(self add: workButton)
			)
			(self add: exitButton)
			(= global413 theTalker)
			(self
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 15
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
				(global413 init:)
				(Print
					205
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
		(proc0_15 self 291)
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
				(factory delete: self)
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

