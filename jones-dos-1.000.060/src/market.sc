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
)

(procedure (localproc_0) ; UNUSED
	(Format @global100 203 0) ; "Welcome to Black's Market. Where quality and service are unherd of and you will stand in line forever."
	(Format @global100 203 1) ; "Welcome to Black's Market, where you can grow old in our checkout lines."
	(Format @global100 203 2) ; "Welcome to Black's Market. Our meats are a cut above!"
	(Format @global100 203 3) ; "Welcome to Black's Market. You can't beat our eggs!"
	(Format @global100 203 4) ; "Welcome to Black's Market, where every day is Double Coupon Day!"
	(Format @global100 203 5) ; "Welcome to Black's Market. Look for our special on day-old sushi!"
	(Format @global100 203 6) ; "Welcome to Black's Market. Open all day and night for your binging pleasure!"
	(Format @global100 203 7) ; "Welcome to Black's Market. Lowest prices in town on pickled octopus!"
	(Format @global100 203 8) ; "Welcome to Black's Market. Hey, check out those melons!"
	(Format @global100 203 9) ; "Welcome to Black's Market. Our butcher loves to stop and chew the fat!"
	(Format @global100 203 10) ; "Welcome to Black's Market. Don't bypass our artichoke hearts!"
	(Format @global100 203 11) ; "Welcome to Black's Market. This time, please don't take home the shopping cart."
	(Format @global100 203 12) ; "Welcome to Black's Market, the grosser grocer!"
	(Format @global100 203 13) ; "Welcome to Black's Market. Our Swiss Cheese is made from Hole Milk!"
	(Format @global100 203 14) ; "Mr. Schwader to 6 for check approval...Mr. Schwader to 6 for check approval..."
	(Format @global100 203 15) ; "Would you like fries with that? Oops, sorry, I usedta work at Monolith Burger."
	(Format @global100 203 16) ; "Just so you know, we saw you eating those grapes in the produce section."
	(Format @global100 203 17) ; "Cookies, ice cream and soda? Any REAL food in that shopping cart?"
	(Format @global100 203 18) ; "If you wanna write a check, I need 8 forms of ID and a blood sample."
	(Format @global100 203 19) ; "You had eleven items, not ten. Next time, use the right aisle."
	(Format @global100 203 20) ; "One of your eggs is broken. Better use it quickly."
	(Format @global100 203 21) ; "Price check, please...a 5-pound box of Quintuple-Stuff Sandwich Cookies!"
	(Format @global100 203 22) ; "Have you tried the Deli Department's Cheezy Sweet 'n Saurkraut Salad?"
	(Format @global100 203 23) ; "Thank You. See you next time"
	(Format @global100 203 24) ; "Will that be paper or plastic?"
	(Format @global100 203 25) ; "Have a Good day."
	(Format @global100 203 26) ; "We appreciate your business."
	(Format @global100 203 27) ; "It's clear that you are a person who knows how to shop."
	(Format @global100 203 28) ; "I'm happy to see that you're well today."
	(Format @global100 203 29) ; "Thank you for shopping at Black's Market."
	(Format @global100 203 30) ; "Next time, give peas a chance!"
	(Format @global100 203 31) ; "No tipping, please!"
	(Format @global100 203 32) ; "Can we help you out to your marble?"
	(Format @global100 203 33) ; "Come back for all your grocery needs!"
	(Format @global100 203 34) ; "Say, two more trips and you'll have enough stamps!"
	(Format @global100 203 35) ; "Hope you didn't buy any of those recalled mushrooms last week!"
	(Format @global100 203 36) ; "Next time, don't dent the cans and expect a discount."
	(Format @global100 203 37) ; "Your selection of food indicates you're compensating for a lack of affection."
	(Format @global100 203 38) ; "Please be more careful with the mayonnaise in Aisle 7 next time."
	(Format @global100 203 39) ; "Arugla, Raddichio and Belgian Endive? What a yuppie!"
	(Format @global100 203 40) ; "I'm sorry we were out of those little corns this week."
	(Format @global100 203 41) ; "Would you like to be a checker? OK. YOU'RE A RED ONE."
	(Format @global100 203 42) ; "Look in our Italian Pet Food section for Dog Ciao!"
	(Format @global100 203 43) ; "If you can find lower prices on groceries, you're playing a different game."
	(Format @global100 203 44) ; "Check out our corn...you'll love to nibble our ears."
	(Format @global100 203 45) ; "Our celery stalks at midnight."
	(Format @global100 203 46) ; "Meet our dairy department managers, Sam 'n Ella!"
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
				(Print
					203
					local1
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
	)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(global413 init: 16)
		(Print ; "You do not have enough cash."
			203
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

(instance market of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0)
		(if (not global518)
			(Load rsTEXT 203)
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
				(computerScript cue:)
			)
			(= global413 theTalker)
			(self
				window: global59
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
				open: 0 15
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
				(global413 init:)
				(Print
					203
					(Random 0 13)
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
			(if (and (not (Random 0 50)) (> (proc0_11) 0))
				(= global446 1)
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
		(if global446
			(global302 cash: 0 cashHi: 0)
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
			(Format param1 203 48 text price) ; "%s.||$%2d"
		else
			(Format param1 203 49 text price) ; "%s$%3d"
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
			(Format param1 203 48 text price) ; "%s.||$%2d"
		else
			(Format param1 203 49 text price) ; "%s$%3d"
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
			(Format param1 203 48 text price) ; "%s.||$%2d"
		else
			(Format param1 203 49 text price) ; "%s$%3d"
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
		(Format param1 203 50 text price) ; "%s$%2d"
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
		(Format param1 203 51 text price) ; "%s$%d"
	)

	(method (doit &tmp temp0)
		(if (!= global323 60)
			(super doit:)
			(if global416
				(gASong fade:)
				(gTimeKeep doit: 1)
				(proc0_15 market 291)
				(= temp0 ((ScriptID 215 0) init: client)) ; newspaper
				(gASong play: 49)
				(global502 draw:)
				(global413 cel: 0 setCycle: 0 draw:)
				(return temp0)
			)
		else
			(global413 init: 16)
			(Print ; "No time to read the newspaper."
				203
				52
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
		(return 0)
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
				(market delete: self)
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
					(if (and (not (Random 0 3)) (< global323 60))
						(= cycles 60)
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

