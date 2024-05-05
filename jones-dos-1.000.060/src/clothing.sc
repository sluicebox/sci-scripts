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

(procedure (localproc_0) ; UNUSED
	(Format @global100 209 0) ; "Welcome to QT Clothing. We will sell you anything, no matter how bad it looks."
	(Format @global100 209 1) ; "Welcome to QT Clothing. Meet our tailor, Howie Fitzhugh!"
	(Format @global100 209 2) ; "Welcome to QT Clothing. Our ties don't bind and our belts are a cinch."
	(Format @global100 209 3) ; "Welcome to QT Clothing. We have legal briefs and law suits."
	(Format @global100 209 4) ; "Welcome to QT Clothing, open 24 hours...we never clothes!"
	(Format @global100 209 5) ; "Welcome to QT Clothing. Thursday is Double Shoulder Pad Day!"
	(Format @global100 209 6) ; "Welcome to QT Clothing. Wear our clothes and you'll be a QT, too!"
	(Format @global100 209 7) ; "Welcome to QT Clothing. The only place in the world where you can buy just 1 pant!"
	(Format @global100 209 8) ; "Welcome to QT Clothing. Try on our soothing new Medicated Tux!"
	(Format @global100 209 9) ; "My! Don't WE look nice today!"
	(Format @global100 209 10) ; "It's the real you."
	(Format @global100 209 11) ; "Spiffy."
	(Format @global100 209 12) ; "Faaabulous!!!"
	(Format @global100 209 13) ; "Our clothes are of the highest quality."
	(Format @global100 209 14) ; "Have a wonderful day!"
	(Format @global100 209 15) ; "Lookin' good!"
	(Format @global100 209 16) ; "You can't go wong at QT."
	(Format @global100 209 17) ; "Perhaps you should stock up now while the prices are so reasonable."
	(Format @global100 209 18) ; "With your figure, perhaps you should consider going to a tent maker."
	(Format @global100 209 19) ; "Oooh, you look good enough to eat!"
	(Format @global100 209 20) ; "Don't you just love the new spring fashions? Tres magnifique!"
	(Format @global100 209 21) ; "It's nice like that, just a tad tight around the bottom."
	(Format @global100 209 22) ; "Good choice...rayon is back in this year!"
	(Format @global100 209 23) ; "Now what are you going to do about your HAIR?"
	(Format @global100 209 24) ; "Don't forget to accessorize!"
	(Format @global100 209 25) ; "Nice! It really accentuates those pectorals."
	(Format @global100 209 26) ; "You know, a little tummy tuck would take care of that slight pucker in back."
	(Format @global100 209 27) ; "Stop slouching and it won't crease across the torso."
	(Format @global100 209 28) ; "With a physique like yours, you could wear ANYthing!"
	(Format @global100 209 29) ; "Let me mention just two little words. Lipo. Suction."
)

(instance boughtItem of Obj
	(properties)

	(method (doit &tmp temp0)
		(while (== local1 (= temp0 (Random 9 29)))
			1
		)
		(= local1 temp0)
		(Print
			209
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

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(global413 init: 16)
		(Print ; "You do not have enough cash."
			209
			30
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

(instance clothing of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0)
		(if (not global518)
			(Load rsTEXT 209)
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
				(computerScript cue:)
			)
			(= global413 theTalker)
			(self
				window: global59
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
				open: 0 15
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
				(global413 init:)
				(Print
					209
					(Random 0 8)
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
		(= global502 prevDialog)
		(keyMouseList dispose:)
		(proc0_15 self 291)
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
		celNum 1
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
		celNum 2
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
		celNum 3
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
				(clothing delete: self)
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
		nsTop 57
		view 709
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

(instance timeClock of TimeClock
	(properties
		nsTop 56
		nsLeft 1
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

