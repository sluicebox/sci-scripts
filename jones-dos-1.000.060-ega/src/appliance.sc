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

(procedure (localproc_0) ; UNUSED
	(Format @global100 208 0) ; "Welcome to Socket City. If you paid full price, you must've bought it here!"
	(Format @global100 208 1) ; "Welcome to Socket City. You're just in time for our Pre-Arbor Day Value Fest!"
	(Format @global100 208 2) ; "Welcome to Socket City. Apply for our Revolving Algorithmic Usury Credit Line!"
	(Format @global100 208 3) ; "Welcome to Socket City. Our salespeople are here to help you...spend!"
	(Format @global100 208 4) ; "Welcome to Socket City. Special today on useless Yuppie electronic gadgets!"
	(Format @global100 208 5) ; "Welcome to Socket City. We only charge 10% over list price!"
	(Format @global100 208 6) ; "Welcome to Socket City. Go ahead and TRY to talk us down."
	(Format @global100 208 7) ; "Welcome to Socket City. Next Friday is Double Commission Day!"
	(Format @global100 208 8) ; "Welcome to Socket City. Come to our Moonlight Madness sale. 20% off if you wear your pajamas!"
	(Format @global100 208 9) ; "Welcome to Socket City. Values direct from the factory to the jobber to the wholesaler to us to YOU!"
	(Format @global100 208 10) ; "Welcome to Socket City, Home of High Pressure Sales!"
	(Format @global100 208 11) ; "Welcome to Socket City, where Quality meets its match!"
	(Format @global100 208 12) ; "Welcome to Socket City, where you get less for more!"
	(Format @global100 208 13) ; "Welcome to Socket City, where our Service Department never sleeps, eats or bathes!"
	(Format @global100 208 14) ; "Welcome to Socket City, where the customer is always ripe!"
	(Format @global100 208 15) ; "Welcome to Socket City. Where everything quits working the day after the warranty expires."
	(Format @global100 208 16) ; "Thank You very much."
	(Format @global100 208 17) ; "I'm sure that you will be very happy with your purchase."
	(Format @global100 208 18) ; "Thanks. You will have many years of trouble free service."
	(Format @global100 208 19) ; "Thank you for visiting Socket City."
	(Format @global100 208 20) ; "You sure know a deal when you see one."
	(Format @global100 208 21) ; "Come and see us again, anytime."
	(Format @global100 208 22) ; "Thank You. Let me know how you enjoy it."
	(Format @global100 208 23) ; "Perhaps I can interest you in something else."
	(Format @global100 208 24) ; "Have you seen our vacuum cleaners? They really suck!"
	(Format @global100 208 25) ; "Would you like the $200 Extended Service Contract with that?"
	(Format @global100 208 26) ; "You'll want the $150 Factory Extension Warranty with that, right?"
	(Format @global100 208 27) ; "Can we interest you in the $300 1-Year Lifetime Replacement Guarantee?"
	(Format @global100 208 28) ; "How about a $250 Extended Factory Service Warranty Replacement Guarantee Contract Agreement Deal with that?"
	(Format @global100 208 29) ; "If you ever require service, you know where to go!"
	(Format @global100 208 30) ; "Of course, for another $75, you could have gotten the next model up."
	(Format @global100 208 31) ; "Our free installation is only $45 today!"
	(Format @global100 208 32) ; "Sorry, we only had a floor sample left, but trust me, it's in perfect condition."
	(Format @global100 208 33) ; "Remember, we offer free delivery anywhere within the game!"
	(Format @global100 208 34) ; "Do you smell something burning? Oh, it's that cash in your pocket!"
	(Format @global100 208 35) ; "Now that didn't hurt a bit, did it?"
	(Format @global100 208 36) ; "Notice how we ignore anybody who's browsing the under-$200 items?"
	(Format @global100 208 37) ; "Since you're spending, how about replacing your car stereo with an $800 Kerplunkett?"
	(Format @global100 208 38) ; "Should we call the paramedics to treat your wallet for shock?"
	(Format @global100 208 39) ; "Care to go double-or-nothing for that 92 inch Projection TV?"
	(Format @global100 208 40) ; "Now, if I can steer you towards some of our higher-margin products..."
	(Format @global100 208 41) ; "Didn't you have your eye on that complete Home Videotape Production Studio?"
	(Format @global100 208 42) ; "If you're not completely satisfied, we'll be glad to give you partial credit."
	(Format @global100 208 43) ; "We're members of the Bait 'n Switch(TM) Retailer's Association!"
	(Format @global100 208 44) ; "We finance 90 Days, Same as Bankruptcy!"
	(Format @global100 208 45) ; "With every purchase over $5200, we're giving away free Chapter 11 Auto-Filers!"
	(Format @global100 208 46) ; "Please be aware that our Extended Service Contract excludes parts and labor."
)

(procedure (localproc_1 param1 param2)
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
		(Print
			208
			local0
			310
			global413
			global440
			global441
			global442
			25
			global426
		)
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(global413 init: 16)
		(Print ; "You do not have enough cash."
			208
			47
			310
			global413
			global440
			global441
			global442
			70
			70
			25
			global426
		)
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
		(if (not global518)
			(Load rsTEXT 208)
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
				(computerScript cue:)
			)
			(= global413 theTalker)
			(self
				window: global59
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
				open: 0 15
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
				(global413 init:)
				(Print
					208
					(Random 0 15)
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
		(proc0_15 self 291)
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
			(Format param1 208 48 text price) ; "%s.||$%3d"
		else
			(Format param1 208 49 text price) ; "%s$%4d"
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
			(Format param1 208 48 text price) ; "%s.||$%3d"
		else
			(Format param1 208 49 text price) ; "%s$%4d"
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
			(Format param1 208 48 text price) ; "%s.||$%3d"
		else
			(Format param1 208 49 text price) ; "%s$%4d"
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
			(Format param1 208 48 text price) ; "%s.||$%3d"
		else
			(Format param1 208 49 text price) ; "%s$%4d"
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
			(Format param1 208 48 text price) ; "%s.||$%3d"
		else
			(Format param1 208 49 text price) ; "%s$%4d"
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
			(Format param1 208 48 text price) ; "%s.||$%3d"
		else
			(Format param1 208 49 text price) ; "%s$%4d"
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
			(Format param1 208 48 text price) ; "%s.||$%3d"
		else
			(Format param1 208 49 text price) ; "%s$%4d"
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
			(Format param1 208 48 text price) ; "%s.||$%3d"
		else
			(Format param1 208 49 text price) ; "%s$%4d"
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
			(Format param1 208 48 text price) ; "%s.||$%3d"
		else
			(Format param1 208 49 text price) ; "%s$%4d"
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
				(appliance delete: self)
				(self erase:)
			)
			((and (< global323 60) (> temp0 0))
				(items setCycle: 0)
				(timeClock doit:)
			)
		)
		(super doit: 0)
	)
)

(instance items of DCIcon
	(properties
		view 708
		loop 1
		priority 14
		cycleSpeed 100
	)

	(method (init)
		(if (< global534 2)
			(self setCycle: FwdCount self)
		)
	)

	(method (doit param1)
		(if (and (< global534 2) global416)
			(if cycler
				(cycler cycleCnt: -200)
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
							((localproc_1 21 refrigerator)
								(event message: (refrigerator key:))
							)
							((localproc_1 23 stove)
								(event message: (stove key:))
							)
							((localproc_1 24 colorTV)
								(event message: (colorTV key:))
							)
							((localproc_1 27 microwave)
								(event message: (microwave key:))
							)
							((localproc_1 26 stereo)
								(event message: (stereo key:))
							)
							((localproc_1 22 freezer)
								(event message: (freezer key:))
							)
							((localproc_1 25 vcr)
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
							((localproc_1 21 refrigerator)
								(event message: (refrigerator key:))
							)
							((localproc_1 23 stove)
								(event message: (stove key:))
							)
							((localproc_1 24 colorTV)
								(event message: (colorTV key:))
							)
							((localproc_1 27 microwave)
								(event message: (microwave key:))
							)
							((localproc_1 26 stereo)
								(event message: (stereo key:))
							)
							((localproc_1 22 freezer)
								(event message: (freezer key:))
							)
							((localproc_1 28 hotTub)
								(event message: (hotTub key:))
							)
							((localproc_1 29 computer)
								(event message: (computer key:))
							)
							((localproc_1 25 vcr)
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

