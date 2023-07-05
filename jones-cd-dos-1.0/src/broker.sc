;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 213)
(include sci.sh)
(use Main)
(use WButton)
(use n109)
(use DialogScript)
(use n115)
(use Interface)
(use KeyMouse)
(use System)

(public
	broker 0
)

(local
	local0
	[local1 5]
	[local6 5]
	[local11 5]
	[local16 5]
	[local21 5]
	[local26 5]
	local31
	local32
	local33
	local34
	local35
	local36
	local37
)

(procedure (localproc_0 param1 &tmp temp0)
	(= temp0 0)
	(if
		(= temp0
			(switch param1
				(0 tBillsHoldings)
				(1 goldHoldings)
				(2 silverHoldings)
				(3 porkBelliesHoldings)
				(4 blueChipStocksHoldings)
				(5 pennyStocksHoldings)
			)
		)
		(temp0 erase: init: draw:)
	)
)

(procedure (localproc_1 param1 param2 &tmp [temp0 20])
	(Format @temp0 213 4 param2) ; "$%d"
	(Format param1 213 5 @temp0) ; "%6s"
)

(procedure (localproc_2 param1 param2 &tmp [temp0 20])
	(Format @temp0 213 6 param2) ; "$%s"
	(Format param1 213 7 @temp0) ; "%7s"
)

(procedure (localproc_3 param1)
	(return
		(switch param1
			(0 tBills)
			(1 gold)
			(2 silver)
			(3 porkBellies)
			(4 blueChipStocks)
			(else pennyStocks)
		)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(if (== (global302 playing:) 29)
			(Timer set60ths: 0 (proc0_18 222))
		else
			(proc0_18 222)
		)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance broker of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0 temp1 temp2 temp3)
		(= temp3 global557)
		(= global557 0)
		(if (not global518)
			(= prevTalker global413)
			(= global413 0)
			(proc0_17 2)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= temp2 global424)
			(= global424 notEnoughCash)
			(= global502 self)
			(= client param1)
			(if (== (global302 playing:) 29)
				(= local31 0)
				(self setScript: compScript 0)
				(compScript cue:)
			)
			(self
				window: global38
				add:
					background
					tBills
					gold
					silver
					porkBellies
					blueChipStocks
					pennyStocks
					tBillsHoldings
					goldHoldings
					silverHoldings
					porkBelliesHoldings
					blueChipStocksHoldings
					pennyStocksHoldings
					buyButton
					sellButton
					exitButton
				eachElementDo: #init
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 -1
			)
			(= temp1 (KeyMouse curItem:))
			(gASong playBed: 48)
			(KeyMouse setList: keyMouseList)
			(proc0_9 self keyMouseList tBills)
			(= global430 tBills)
			(global430 brite:)
		else
			(KeyMouse setCursor: theItem)
		)
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
		(KeyMouse curItem: temp1)
		(if global447
			(KeyMouse setCursor: temp1)
		)
		(keyMouseList release: dispose:)
		(gASong fade:)
		(= global502 prevDialog)
		(proc0_15 self 294)
		(self dispose:)
		(= global430 0)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		(gASong playBed: 47)
		(= global413 prevTalker)
		(= global424 temp2)
		(= global525 0)
		(= global557 temp3)
		temp0
		(DisposeScript 213)
	)

	(method (advance)
		(buyButton enable: 0)
		(sellButton enable: 0)
		(super advance:)
		(buyButton enable: 1)
		(sellButton enable: 1)
	)

	(method (retreat)
		(buyButton enable: 0)
		(sellButton enable: 0)
		(super retreat:)
		(buyButton enable: 1)
		(sellButton enable: 1)
	)

	(method (draw &tmp [temp0 20] temp20)
		(self eachElementDo: #draw)
		(if global430
			(HiliteControl global430)
		)
		(= temp20 (if global535 93 else 3))
		(Display 213 0 dsFONT 10 dsCOORD 112 8 dsBACKGROUND temp20 dsCOLOR 0) ; "Market"
		(Display 213 1 dsFONT 10 dsCOORD 115 16 dsBACKGROUND temp20 dsCOLOR 0) ; "Value"
		(Display 213 2 dsFONT 10 dsCOORD 154 8 dsBACKGROUND temp20 dsCOLOR 0) ; "Your"
		(Display 213 3 dsFONT 10 dsCOORD 147 16 dsBACKGROUND temp20 dsCOLOR 0) ; "Holdings"
		(Display
			(localproc_1 @temp0 (tBills price:))
			dsFONT
			10
			dsCOORD
			109
			31
			dsBACKGROUND
			temp20
			dsCOLOR
			0
		)
		(Display
			(localproc_1 @temp0 (gold price:))
			dsFONT
			10
			dsCOORD
			109
			44
			dsBACKGROUND
			temp20
			dsCOLOR
			0
		)
		(Display
			(localproc_1 @temp0 (silver price:))
			dsFONT
			10
			dsCOORD
			109
			57
			dsBACKGROUND
			temp20
			dsCOLOR
			0
		)
		(Display
			(localproc_1 @temp0 (porkBellies price:))
			dsFONT
			10
			dsCOORD
			109
			70
			dsBACKGROUND
			temp20
			dsCOLOR
			0
		)
		(Display
			(localproc_1 @temp0 (blueChipStocks price:))
			dsFONT
			10
			dsCOORD
			109
			83
			dsBACKGROUND
			temp20
			dsCOLOR
			0
		)
		(Display
			(localproc_1 @temp0 (pennyStocks price:))
			dsFONT
			10
			dsCOORD
			109
			96
			dsBACKGROUND
			temp20
			dsCOLOR
			0
		)
		(if global518
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
		)
	)
)

(instance background of DIcon
	(properties
		view 696
	)
)

(class InvestmentDIcon of DIcon
	(properties
		state 1
		nsLeft 8
		view 696
		loop 1
		price 0
		basePrice 0
		fixedPrice 0
	)

	(method (brite)
		(self setPort:)
		(HiliteControl self)
		(self resetPort:)
	)

	(method (select param1)
		(if param1
			(|= state $0008)
		else
			(&= state $fff7)
		)
	)

	(method (doit)
		(gASoundEffect play: 23)
		(global430 select: 0 brite:)
		(= global430 self)
		(global430 select: 1 brite:)
		(super doit:)
	)
)

(instance tBills of InvestmentDIcon
	(properties
		nsTop 27
		price 100
		fixedPrice 1
	)
)

(instance tBillsHoldings of WButton
	(properties
		state 288
		nsLeft 142
		shadowColor 93
	)

	(method (init)
		(= nsTop (+ (tBills nsTop:) 4))
		(proc115_1 ((global302 investments:) at: 0) (tBills price:))
		(= text (localproc_2 @local1 (proc115_0 global454 global455)))
		(super init:)
	)
)

(instance gold of InvestmentDIcon
	(properties
		nsTop 40
		key 1
		cel 1
		basePrice 413
	)

	(method (init)
		(= price (proc109_0 global310 basePrice))
	)
)

(instance goldHoldings of WButton
	(properties
		state 288
		nsLeft 142
		shadowColor 93
	)

	(method (init)
		(= nsTop (+ (gold nsTop:) 4))
		(proc115_1 ((global302 investments:) at: 1) (gold price:))
		(= text (localproc_2 @local6 (proc115_0 global454 global455)))
		(super init:)
	)
)

(instance silver of InvestmentDIcon
	(properties
		nsTop 53
		key 2
		cel 2
		basePrice 14
	)

	(method (init)
		(= price (proc109_0 global311 basePrice))
	)
)

(instance silverHoldings of WButton
	(properties
		state 288
		nsLeft 142
		shadowColor 93
	)

	(method (init)
		(= nsTop (+ (silver nsTop:) 4))
		(proc115_1 ((global302 investments:) at: 2) (silver price:))
		(= text (localproc_2 @local11 (proc115_0 global454 global455)))
		(super init:)
	)
)

(instance porkBellies of InvestmentDIcon
	(properties
		nsTop 66
		key 3
		cel 3
		basePrice 20
	)

	(method (init)
		(= price (proc109_0 global312 basePrice))
	)
)

(instance porkBelliesHoldings of WButton
	(properties
		state 288
		nsLeft 142
		shadowColor 93
	)

	(method (init)
		(= nsTop (+ (porkBellies nsTop:) 4))
		(proc115_1 ((global302 investments:) at: 3) (porkBellies price:))
		(= text (localproc_2 @local16 (proc115_0 global454 global455)))
		(super init:)
	)
)

(instance blueChipStocks of InvestmentDIcon
	(properties
		nsTop 79
		key 4
		cel 4
		basePrice 49
	)

	(method (init)
		(= price (proc109_0 global313 basePrice))
	)
)

(instance blueChipStocksHoldings of WButton
	(properties
		state 288
		nsLeft 142
		shadowColor 93
	)

	(method (init &tmp temp0)
		(= nsTop (+ (blueChipStocks nsTop:) 4))
		(proc115_1 ((global302 investments:) at: 4) (blueChipStocks price:))
		(= text (localproc_2 @local21 (proc115_0 global454 global455)))
		(super init:)
	)
)

(instance pennyStocks of InvestmentDIcon
	(properties
		nsTop 92
		key 5
		cel 5
		basePrice 7
	)

	(method (init)
		(= price (proc109_0 global314 basePrice))
	)
)

(instance pennyStocksHoldings of WButton
	(properties
		state 288
		nsLeft 142
		shadowColor 93
	)

	(method (init)
		(= nsTop (+ (pennyStocks nsTop:) 4))
		(proc115_1 ((global302 investments:) at: 5) (pennyStocks price:))
		(= text (localproc_2 @local26 (proc115_0 global454 global455)))
		(super init:)
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 419
		nsTop 108
		nsLeft 143
		key 120
		view 250
	)
)

(instance buyButton of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 7
		key 98
		view 250
		loop 4
	)

	(method (select param1)
		(super select: param1)
		(if global430
			(broker theItem: global430)
		)
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(= temp0 (((global302 investments:) at: (global430 key:))))
		(cond
			((>= (proc0_11) (global430 price:))
				(temp0 shares: (+ (temp0 shares:) 1))
				(proc0_10 (- 0 (global430 price:)))
				(global302 invAss: (+ (global302 invAss:) (global430 price:)))
				(localproc_0 (global430 key:))
			)
			((== (global302 playing:) 29)
				(Timer set60ths: 0 (proc0_18 222))
			)
			(else
				(proc0_18 222)
			)
		)
		(gCalc doit:)
		(return value)
	)

	(method (hilite)
		(super hilite: 5)
	)
)

(instance sellButton of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 77
		key 106
		view 250
		loop 5
	)

	(method (select param1)
		(super select: param1)
		(if global430
			(broker theItem: global430)
		)
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(= temp0 (((global302 investments:) at: (global430 key:))))
		(cond
			((temp0 shares:)
				(temp0 shares: (- (temp0 shares:) 1))
				(proc0_10 (global430 price:))
				(global302 invAss: (- (global302 invAss:) (global430 price:)))
				(localproc_0 (global430 key:))
				(if (== global430 tBills)
					(proc0_10 -3)
					(if global537
						(= global537 0)
						(if (== (global302 playing:) 29)
							(Timer set60ths: 0 (proc0_18 220))
						else
							(proc0_18 220)
						)
					)
				)
			)
			((== (global302 playing:) 29)
				(Timer set60ths: 0 (proc0_18 221))
			)
			(else
				(proc0_18 221)
			)
		)
		(gCalc doit:)
		(return value)
	)

	(method (hilite)
		(super hilite: 5)
	)
)

(instance compScript of DialogScript
	(properties)

	(method (handleEvent event &tmp temp0)
		(if register
			(= register 0)
			(= cycles 1)
			(event type: evKEYBOARD x: 160 y: 100)
			(= local37 -1)
			(= local0 state)
			(switch state
				(2
					(if (proc0_6 19)
						(= cycles 60)
						(for
							((= temp0 (= local31 (= local32 0))))
							(< temp0 5)
							((++ temp0))
							
							(if
								(and
									(>=
										(proc0_11)
										((localproc_3 (+ temp0 1)) price:)
									)
									(>= [global318 temp0] local32)
								)
								(cond
									((> [global318 temp0] local32)
										(= local32 [global318 temp0])
										(= local31 temp0)
									)
									((not (Random 0 2))
										(= local31 temp0)
									)
								)
							)
						)
						(= local33 (+ local31 1))
						(if
							(or
								(and (== local32 1) (not (Random 0 5)))
								(< local32 1)
							)
							(= local33 0)
						)
						(= local34 (localproc_3 local33))
						(event message: (local34 key:))
						(= local35 (if (== (mod global372 4) 3) 800 else 500))
					)
				)
				(3
					(if
						(and
							(proc0_6 19)
							(>= (proc0_11) ((localproc_3 local33) price:))
						)
						(= global525 1)
						(= global485 1)
						(event message: (buyButton key:))
						(if (> (proc0_11) local35)
							(= local37 3)
						)
					)
				)
				(4
					(if (proc0_6 20)
						(if (== global408 -1)
							(= local36 0)
							(= local37 7)
						else
							(= cycles 60)
							(= temp0 (= local31 0))
							(= local32 7)
							(while (< temp0 6)
								(if
									(((global302 investments:) at: temp0)
										shares:
									)
									(cond
										((not temp0)
											(= local32 0)
										)
										((<= [global318 (- temp0 1)] local32)
											(cond
												(
													(<
														[global318 (- temp0 1)]
														local32
													)
													(= local32
														[global318 (- temp0 1)]
													)
													(= local31 temp0)
												)
												((not (Random 0 2))
													(= local31 temp0)
												)
											)
										)
									)
								)
								(++ temp0)
							)
							(= local34 (localproc_3 local31))
							(event message: (local34 key:))
						)
					)
				)
				(5
					(if (proc0_6 20)
						(= global525 1)
						(if (< (proc0_11) global408)
							(= local37 5)
							(if
								(==
									(((global302 investments:) at: local31)
										shares:
									)
									1
								)
								(= local37 4)
							)
						)
						(event message: (sellButton key:))
					)
				)
				(6
					(if (and (proc0_6 20) (== global408 -1))
						(event message: JOY_NULL)
						(for ((= local36 1)) (< local36 6) ((++ local36))
							(if
								(and
									(((global302 investments:) at: local36)
										shares:
									)
									(<= [global318 (- local36 1)] -1)
								)
								(= local34 (localproc_3 local36))
								(= cycles 60)
								(event message: (local34 key:))
								(break)
							)
						)
						(if (not (event message:))
							(= local37 9)
						)
					)
				)
				(7
					(if (and (proc0_6 20) (== global408 -1) (<= 0 local36 5))
						(= global525 1)
						(if
							(>
								(((global302 investments:) at: local36) shares:)
								1
							)
							(= local37 7)
						else
							(= local37 6)
						)
						(= global503 1)
						(event message: (sellButton key:))
					)
				)
				(19
					(= global401 ((ScriptID 300 0) doit: global302)) ; WhereShouldIGo
					(if
						(and
							(< global323 60)
							(== global401 global400)
							(or (== global407 19) (== global407 20))
						)
						(= state 0)
					)
				)
				(else
					(super handleEvent: event 0)
				)
			)
		)
	)

	(method (cue)
		(= global525 0)
		(= state
			(if (>= local37 0)
				local37
			else
				(+ state 1)
			)
		)
		(= register 1)
	)
)

