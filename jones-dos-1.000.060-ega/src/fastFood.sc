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

(procedure (localproc_0) ; UNUSED
	(Format @global100 210 0) ; "Welcome to Monolith Burger. Our Assistant Manager knows the Heimlich Manuever!"
	(Format @global100 210 1) ; "Welcome to Monolith Burger. Next week, come meet Monny the Burger Clown!"
	(Format @global100 210 2) ; "Welcome to Monolith Burger. You just missed Monny the Burger Clown!"
	(Format @global100 210 3) ; "Welcome to Monolith Burger. Buy 'em by the bushel!"
	(Format @global100 210 4) ; "Welcome to Monolith Burger. Our food is untouched by human hands, only by teenagers."
	(Format @global100 210 5) ; "Welcome to Monolith Burger. Cleanest restrooms in the game!"
	(Format @global100 210 6) ; "Welcome to Monolith Burger. Free bibs with every order of Lobster Nuggets!"
	(Format @global100 210 7) ; "Welcome to Monolith Burger. Try a box of Chocolate-Like(R) Cookie Shards!"
	(Format @global100 210 8) ; "Welcome to Monolith Burger. Have you played our Guess the Chicken Part Game?"
	(Format @global100 210 9) ; "Welcome to Monolith Burger. Special orders will take an extra 45 minutes."
	(Format @global100 210 10) ; "Welcome to Monolith Burger. Our soup today is Cream of Taco."
	(Format @global100 210 11) ; "Welcome to Monolith Burgers. Home of the Toemain Express and the Stomach Pump special."
	(Format @global100 210 12) ; "Welcome to Monolith Burgers, where we use only 100% Pure Extruded Beeflike Product!"
	(Format @global100 210 13) ; "Welcome to Monolith Burgers, where even the wrappers have wrappers!"
	(Format @global100 210 14) ; "Welcome to Monolith Burgers, where our Food(TM) is patented!"
	(Format @global100 210 15) ; "Welcome to Monolith Burgers. Our buns are the softest!"
	(Format @global100 210 16) ; "Welcome to Monolith Burgers, where our fat is always freshly rendered!"
	(Format @global100 210 17) ; "Welcome to Monolith Burgers, where quality eats are in the bag!"
	(Format @global100 210 18) ; "Welcome to Monolith Burgers, where our drinks have twice the ice!"
	(Format @global100 210 19) ; "Welcome to Monolith Burgers, where our burgers come from contented cows!"
	(Format @global100 210 20) ; "Will that be all?"
	(Format @global100 210 21) ; "Would you like fries with that?"
	(Format @global100 210 22) ; "Something else with that?"
	(Format @global100 210 23) ; "Take some home for your family too."
	(Format @global100 210 24) ; "Have a nice day."
	(Format @global100 210 25) ; "Sounds delicious."
	(Format @global100 210 26) ; "Will that be cash or charge? Tee hee."
	(Format @global100 210 27) ; "Well, aren't WE happy today."
	(Format @global100 210 28) ; "Would you like some Thousand Isla...I mean, Secret Sauce, with that?"
	(Format @global100 210 29) ; "Does your Mother know you're eating here?"
	(Format @global100 210 30) ; "Incidentally, we also sell used hairnets."
	(Format @global100 210 31) ; "Our pure beef burgers have half the soybeans of the other leading brands!"
	(Format @global100 210 32) ; "Would you like some deep-fried potatoes and deep-fried pie with your deep-fried sandwich?"
	(Format @global100 210 33) ; "This week only: buy two burgers and get the shakes for free!"
	(Format @global100 210 34) ; "You can save 45 minutes by flushing that right now."
	(Format @global100 210 35) ; "Mmmmm...that looks almost good enough to eat!"
	(Format @global100 210 36) ; "We now make our sandwiches from 100% biodegradable material!"
	(Format @global100 210 37) ; "Is that 'to go,' to eat here, or neither?"
	(Format @global100 210 38) ; "Please dispose of trash properly!"
	(Format @global100 210 39) ; "Would you like a Prepubescent Irradiated Kung Fu Tortise statuette with that?"
	(Format @global100 210 40) ; "Our Manager would like you to sign a petition to abolish the Minimum Wage."
	(Format @global100 210 41) ; "Did you know there's only 45 calories per french fry?"
	(Format @global100 210 42) ; "Next to disposable diapers, we're the most familiar sight on the highways!"
	(Format @global100 210 43) ; "Have you tried our new Breakfast Chile Releno?"
	(Format @global100 210 44) ; "This is my first job, so forgive me if I totally mess up your order."
	(Format @global100 210 45) ; "Try our new Licorice 'n Liver Shake!"
	(Format @global100 210 46) ; "Did you want a handful of ketchup packets with that?"
	(Format @global100 210 47) ; "Remember, if it's a 6-lb. Beefburger, it must be a Monolith!"
	(Format @global100 210 48) ; "Our burgers aren't broiled OR fried...they're poached!"
	(Format @global100 210 49) ; "You can find us in any town...just follow the trail of empty wrappers!"
	(Format @global100 210 50) ; "Remember...NO food is better than OUR food!"
	(Format @global100 210 51) ; "Would you like to take home some complimentary advertising on a placemat?"
	(Format @global100 210 52) ; "Our shakes are so thick, you can't even swallow 'em!"
	(Format @global100 210 53) ; "Help yourself to a piece of our new 90-foot Compressed Salad Bar!"
	(Format @global100 210 54) ; "Free refills if you can finish one cup of our coffee!"
)

(instance boughtItem of Obj
	(properties)

	(method (doit &tmp temp0)
		(while (== local0 (= temp0 (Random 20 54)))
			1
		)
		(= local0 temp0)
		(Print
			210
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
			210
			55
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

(instance fastFood of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0)
		(if (not global518)
			(Load rsTEXT 210)
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
				(computerScript cue:)
			)
			(gTimeKeep doit: 2)
			(= global400 10)
			(self
				window: global59
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
				open: 0 15
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
				(global413 init:)
				(Print
					210
					(Random 0 19)
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
				(fastFood delete: self)
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
		view 360
	)
)

(instance items of DCIcon
	(properties
		nsTop 57
		view 710
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

