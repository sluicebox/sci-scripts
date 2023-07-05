;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 204)
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
	bank 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 param1 &tmp temp0)
	(proc0_12 0 param1 (global302 bankBalHi:) (global302 bankBal:))
	(global302 bankBalHi: global454 bankBal: global455)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(proc0_18 310 global413 computerScript)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance bank of Dialog
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
			(proc0_17 2)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= global440 7)
			(= global441 113)
			(= global442 82)
			(if (< global534 2)
				(Load rsVIEW (theTalker view:))
			)
			(= global424 notEnoughCash)
			(= client param1)
			(gTimeKeep doit: 2)
			(= global400 4)
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
			)
			(self
				window: global38
				add:
					background
					theTalker
					piggyBank
					deposit
					withdraw
					loanPayment
					applyForLoan
					seeBroker
			)
			(= global413 theTalker)
			(if (< (global302 loanBal:) 50)
				(loanPayment price: (global302 loanBal:))
			)
			(if (== (global302 worksAt:) 4)
				(self add: workButton)
			)
			(self add: exitButton)
			(self
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(if (== (global302 worksAt:) 4)
				(self add: timeClock)
				(timeClock setSize:)
			)
			(gASong playBed: 47)
			(proc0_9 self keyMouseList deposit)
			(KeyMouse setList: keyMouseList)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(= temp1 (Random 0 9))
				(computerScript state: -1 cycles: 0 seconds: 0)
				(proc0_18 (+ temp1 300) global413 computerScript)
			else
				(computerScript cue:)
			)
		else
			(KeyMouse setCursor: theItem)
		)
		(= global518 0)
		(= global446 0)
		(if (and (>= global372 4) (not (Random 0 30)) (> (proc0_11) 0))
			(= global446 2)
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
		(keyMouseList release: dispose:)
		(= global502 prevDialog)
		(proc0_15 self 294)
		(self dispose:)
		(workButton dispose:)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		(= global525 0)
		temp0
		(DisposeScript 204)
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
		view 804
		priority 13
	)
)

(instance deposit of CostDItem
	(properties
		nsTop 35
		nsLeft 97
		key 1
		text {Deposit  }
		price 100
		typeOfGoods 4
		fixedPrice 1
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(if (global502 aTimeClock:)
			((global502 aTimeClock:) cel: 0 setCycle: 0)
		)
		(if (> (= temp0 (proc0_11)) 100)
			(= temp0 100)
		)
		(if temp0
			(if (== (global302 playing:) 29)
				(global413 setCycle: 0)
			else
				(global413 init: 2)
			)
			(proc0_10 (- 0 temp0))
			(piggyBank cel: 0 doit: End)
			(gCalc doit:)
			(if (and global427 (not local1))
				(= local1 1)
				(if global427
					(proc0_18 311 global413 computerScript)
				)
			)
		else
			(proc0_18 312 global413 computerScript)
		)
		(localproc_0 temp0)
		(return value)
	)

	(method (hilite)
		(self setPort:)
		(self hiliteControl: (if global535 flashColor else 15))
		(Wait 5)
		(self hiliteControl: (if global535 textColor else 0))
		(self resetPort:)
	)
)

(instance withdraw of CostDItem
	(properties
		nsTop 50
		nsLeft 92
		key 2
		text {Withdraw  }
		price 100
		typeOfGoods 4
		theSign 1
		fixedPrice 1
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(if (global502 aTimeClock:)
			((global502 aTimeClock:) cel: 0 setCycle: 0)
		)
		(if
			(>
				(= temp0
					(if (global302 bankBalHi:)
						200
					else
						(global302 bankBal:)
					)
				)
				100
			)
			(= temp0 100)
		)
		(if temp0
			(if (== (global302 playing:) 29)
				(global413 setCycle: 0)
			else
				(global413 init: 2)
			)
			(proc0_10 temp0)
			(piggyBank cel: 4 doit: Beg)
			(gCalc doit:)
			(if (and global427 (not local2))
				(= local2 1)
				(proc0_18 313 global413 computerScript)
			)
			(localproc_0 (- 0 temp0))
		else
			(proc0_18 314 global413 computerScript)
		)
		(return value)
	)

	(method (hilite)
		(self setPort:)
		(self hiliteControl: (if global535 flashColor else 15))
		(Wait 5)
		(self hiliteControl: (if global535 textColor else 15))
		(self resetPort:)
	)
)

(instance loanPayment of CostDItem
	(properties
		state 289
		nsTop 65
		nsLeft 94
		key 3
		text {Loan Payment}
		price 50
		typeOfGoods 4
		fixedPrice 1
	)

	(method (doFormat param1)
		(if price
			(Format param1 204 0 text price) ; "%s $%d"
			(= nsLeft 84)
		else
			(super doFormat: param1)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (global302 loanBal:)
			(if global416
				(global302 paySched: (+ (global302 paySched:) 1) madePay: 1)
				(global413 init: 2)
				(global302
					loanBal:
						(- (global302 loanBal:) (if (< price 50) price else 45))
				)
				(if (< (global302 loanBal:) 50)
					(self erase: price: (global302 loanBal:) draw:)
				)
				(if (not (global302 loanBal:))
					(global302 paySched: 0)
					(self erase: price: 0 nsLeft: 94 draw:)
				)
				(proc0_18 315 global413 computerScript)
			)
		else
			(proc0_18 316 global413 computerScript)
		)
		(return temp0)
	)
)

(instance applyForLoan of WButton
	(properties
		nsTop 80
		nsLeft 93
		key 4
		text {Apply For Loan}
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(gASoundEffect play: 23)
		(if (global502 aTimeClock:)
			((global502 aTimeClock:) cel: 0 setCycle: 0)
		)
		(if (!= global323 60)
			(gTimeKeep doit: 2)
			(if
				(and
					(>
						(= temp2
							(+ (global302 wage:) (/ (global302 lqAss:) 1000))
						)
						(= temp1
							(+
								5
								(global302 latePay:)
								(/ (global302 loanBal:) 100)
								(if (global302 loanBal:) 1 else 0)
							)
						)
					)
					(>= (global302 paySched:) 0)
				)
				(= temp0 (* (- temp2 temp1) 100))
				(if (global302 loanBal:)
					(= temp3 17)
				else
					(= temp3 18)
				)
				(Format @global100 204 1 temp0) ; "$%d. Is this acceptable?"
				(if (!= (global302 playing:) 29)
					(proc0_18 (+ temp3 300) global413 computerScript)
				)
				(if
					(or
						(== (global302 playing:) 29)
						(Print @global100 81 {Yes} 1 81 {No} 0 70 110 319)
					)
					(gASoundEffect play: 23)
					(proc0_13 5)
					(proc0_18 319 global413 computerScript)
					(proc0_10 temp0)
					(global302 loanBal: (+ (global302 loanBal:) temp0))
					(gCalc doit:)
					(loanPayment erase: price: 50 draw:)
				else
					(gASoundEffect play: 23)
					(if (!= (global302 playing:) 29)
						(proc0_18 320 global413 computerScript)
					)
				)
			else
				(proc0_13 -1)
				(if (global302 loanBal:)
					(proc0_18 321 global413 computerScript)
				else
					(proc0_13 -1)
					(proc0_18 322 global413 computerScript)
				)
			)
		else
			(proc0_18 323 global413 computerScript)
		)
		(return 0)
	)
)

(instance seeBroker of WButton
	(properties
		nsTop 95
		nsLeft 95
		key 5
		text {See The Broker}
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(if (global502 aTimeClock:)
			((global502 aTimeClock:) cel: 0 setCycle: 0)
		)
		(if (!= global323 60)
			(if (not local0)
				(gTimeKeep doit: 2)
				(= local0 1)
			)
			(proc0_15 bank 294)
			(gASong fade:)
			(= temp0 ((ScriptID 213 0) init: client)) ; broker
			(bank draw:)
			(return temp0)
		else
			(proc0_18 324 global413 computerScript)
		)
		(return 0)
	)
)

(instance theTalker of Talker
	(properties
		nsTop 0
		nsLeft 0
		view 354
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 419
		nsTop 108
		nsLeft 144
		key 120
		view 250
		priority 15
	)
)

(instance workButton of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 77
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
				(bank delete: self)
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
		(if (bank contains: self)
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
		(piggyBank cel: 1 doit: Beg)
	)

	(method (setSize)
		(global502 aTimeClock: timeClock)
		(super setSize:)
	)
)

(instance piggyBank of DCIcon
	(properties
		nsTop 57
		view 704
		loop 1
		priority 14
		cycleSpeed 5
	)

	(method (init)
		(= cel 0)
	)

	(method (doit param1)
		(if (< global534 2)
			(self loop: 6 setCycle: param1 self 1)
		)
	)

	(method (setSize)
		(if (< global534 2)
			(super setSize: &rest)
		)
	)

	(method (draw)
		(if (< global534 2)
			(super draw: &rest)
		)
	)

	(method (setCycle)
		(if (< global534 2)
			(super setCycle: &rest)
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
					(if (proc0_6 18)
						(= global525 1)
						(= cycles 5)
						(event message: (deposit key:))
						(if (> (proc0_11) 500)
							(-- state)
						)
					)
				)
				(3
					(if
						(and
							(proc0_6 22)
							(or (global302 bankBal:) (global302 bankBalHi:))
						)
						(= global525 1)
						(= cycles 5)
						(event message: (withdraw key:))
						(if (-- global408)
							(-- state)
						)
					)
				)
				(4
					(if (proc0_6 21)
						(= cycles 60)
						(event message: (loanPayment key:))
					)
				)
				(5
					(if (or (proc0_6 19) (proc0_6 20))
						(= cycles 60)
						(event message: (seeBroker key:))
					)
				)
				(6
					(if (proc0_6 17)
						(= cycles 60)
						(cond
							((or (global302 bankBal:) (global302 bankBalHi:))
								(event message: (withdraw key:))
								(if
									(and
										(< (proc0_11) global408)
										(global302 bankBal:)
									)
									(-- state)
								)
							)
							((or (global302 invAss:) (global302 invAssHi:))
								(= global407 20)
								(event message: (seeBroker key:))
							)
							((not global483)
								(event message: (applyForLoan key:))
								(= global483 1)
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

	(method (cue)
		(super cue:)
		(= global525 0)
	)
)

