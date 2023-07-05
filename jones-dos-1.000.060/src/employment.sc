;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use WButton)
(use n109)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use User)
(use System)

(public
	employment 0
	proc206_1 1
)

(local
	[local0 37] = [0 10 10 10 20 20 20 20 20 30 30 30 30 30 30 30 30 40 40 40 40 40 40 40 40 50 50 50 50 50 50 60 60 60 60 70 70]
	[local37 37] = [0 10 10 10 10 20 20 20 20 20 20 30 30 30 30 30 30 30 40 40 40 40 40 40 40 40 50 50 50 50 50 50 60 60 60 70 70]
	[local74 37] = [0 0 0 0 0 0 0 0 0 0 0 0 0 10 10 14 10 14 14 14 12 14 11 14 14 16 15 15 15 15 13 19 15 14 14 15 15]
	[local111 37] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 11 0 0 0 0 0 0 0 0 13 13 16 13]
	[local148 37] = [4 5 4 4 5 6 8 6 6 5 6 6 7 8 7 8 9 7 9 9 10 10 11 15 14 11 12 14 18 18 19 20 19 22 23 22 25]
	[local185 37] = [10 3 11 7 10 11 3 1 4 8 10 5 12 5 11 1 3 10 12 5 5 4 8 3 8 7 12 4 3 5 5 7 4 5 5 4 5]
	[local222 37] = [1 1 1 1 2 2 2 1 1 1 3 1 1 2 3 2 3 4 2 3 4 2 2 4 3 2 3 3 5 5 6 3 4 7 8 5 10]
	[local259 37] = [36 36 36 36 36 35 36 36 36 35 36 36 35 36 34 36 36 35 34 35 36 35 36 35 34 35 34 34 34 34 36 35 34 34 34 34 34]
)

(procedure (localproc_0) ; UNUSED
	(Format @global100 206 0) ; "Why are you asking for less money?"
	(Format @global100 206 1) ; "Why are you asking for the same wage?"
	(Format @global100 206 2) ; "Congratulations. You have been given a raise."
	(Format @global100 206 3) ; "Sorry. We cannot grant your request at this time."
	(Format @global100 206 4) ; "Congratulations. You got the job."
	(Format @global100 206 5) ; "Sorry. We're closing. You'll have to come back next week."
	(Format @global100 206 6) ; "Welcome to ACNE Employment. Why work for the best when you can work like the rest."
	(Format @global100 206 7) ; "Welcome to ACNE Employment. We'll either find you a job, or we won't."
	(Format @global100 206 8) ; "Welcome to ACNE Employment, where your skills and our expertise add up to disappointment!"
	(Format @global100 206 9) ; "Welcome to ACNE Employment, where every lost job is a blemish on your resume!"
	(Format @global100 206 10) ; "Welcome to ACNE Employment. We'll get you a job no matter what it costs you!"
	(Format @global100 206 11) ; "Welcome to ACNE Employment, where your resume zits in our files!"
	(Format @global100 206 12) ; "Welcome to ACNE Employment. No matter how bad your skills are, we have a job to match!"
)

(procedure (proc206_1)
	25
	166
	(if (>= global433 -1)
		(global413 init: 32)
		(if (== global433 -1)
			(proc0_13 -1)
			(gASong pause: 1)
			(gASoundEffect play: 44 gASong)
			(Format @global100 206 13) ; "Sorry. You didn't get the job for the following reasons:"
			(if (< global372 4)
				(= global326 1)
			)
			(if (or (not global325) (not global326) (not global327))
				(if (not global325)
					(StrCat @global100 {Not enough Education\n})
					(global302 notEnoughEd: 1)
				)
				(if (not global327)
					(StrCat @global100 {Not enough Experience.\n})
				)
				(if (not global326)
					(StrCat @global100 {Poor work History.\n})
				)
			else
				(StrCat @global100 {No openings.\n})
			)
			(proc104_1
				@global100
				310
				global413
				global440
				global441
				global442
				70
				150
			)
		else
			(if (or (== global433 2) (== global433 4))
				(gASong pause: 1)
				(gASoundEffect play: 45 gASong)
			)
			(proc104_1
				(Format @global100 206 global433)
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

(procedure (localproc_1 param1 &tmp temp0)
	(switch [local259 param1]
		(36
			(= temp0 0)
		)
		(35
			(= temp0 (proc109_0 global309 125))
		)
		(34
			(= temp0 (proc109_0 global309 295))
		)
	)
	(return (>= (proc0_11) (+ temp0 (proc109_0 global309 65))))
)

(class JobDItem of CostDItem
	(properties
		state 35
		visitTime 4
		dependibility 10
		experience 10
		education 0
		education2 0
		jobNum 0
		uniform 36
	)

	(method (qualify &tmp temp0 temp1)
		(= temp0 (+ (* (global302 numDegrees:) 8) 10))
		(= global325
			(if (or (not education) (global302 hasDegree: education))
				(or (not education2) (global302 hasDegree: education2))
			)
		)
		(global302
			needEd1: (if global325 0 else education)
			needEd2: (if global325 0 else education2)
		)
		(= global326
			(>=
				(global302 dependibility:)
				(- dependibility (if (== dependibility 10) 10 else 0))
			)
		)
		(= global327 (>= (global302 experience:) experience))
		(= global328
			(<=
				(Random 1 100)
				(+
					(/
						(+
							(global302 dependibility:)
							(global302 experience:)
							temp0
						)
						3
					)
					30
				)
			)
		)
		(self turnedDown:)
		(if (== indexNum 44)
			(= global328 1)
		)
		(if (and global325 global326 global327 global328)
			(global302 jobKey: key jobT: global501)
			(return 1)
		)
		(return 0)
	)

	(method (turnedDown param1 &tmp temp0)
		(cond
			(argc
				(if global370
					(for ((= temp0 0)) (< temp0 global370) ((++ temp0))
						(if (== [global330 temp0] param1)
							(return)
						)
					)
				)
				(= [global330 global370] param1)
				(++ global370)
			)
			(global370
				(for ((= temp0 0)) (< temp0 global370) ((++ temp0))
					(if (== [global330 temp0] jobNum)
						(= global328 0)
						(return)
					)
				)
			)
		)
	)

	(method (doFormat param1)
		(if (< price 10)
			(Format param1 206 14 text price) ; "%s $%d Hr."
		else
			(Format param1 206 15 text price) ; "%s $%d Hr."
		)
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(= global433 -2)
		(if (!= global323 60)
			(gTimeKeep doit: visitTime)
			(= temp0 (self qualify:))
			(cond
				(
					(and
						(== (global302 worksAt:) global419)
						(== (global302 occupation:) indexNum)
					)
					(cond
						((> (global302 wage:) price)
							(= global433 0)
						)
						((== (global302 wage:) price)
							(= global433 1)
						)
						(
							(>=
								(global302 dependibility:)
								(+ dependibility (* 5 (global302 raisesGiven:)))
							)
							(proc0_13 3)
							(global302
								raisesGiven: (+ (global302 raisesGiven:) 1)
							)
							(global302 wage: price)
							(= global433 2)
						)
						(else
							(= global433 3)
						)
					)
				)
				(temp0
					(= global438 1)
					(global302
						raisesGiven: 0
						experience: (+ (global302 experience:) 2)
						maxExperience:
							(+ experience 10 (if (not experience) 10 else 0))
						wage: price
						baseWage: basePrice
						worksAt: global419
						occupation: indexNum
						minDepend: dependibility
						dependibility:
							(if (< (global302 dependibility:) 10)
								10
							else
								(global302 dependibility:)
							)
						uniform: uniform
					)
					(global302
						carStat:
							(if (global302 wage:)
								(* (/ (global302 dependibility:) 8) 10)
							else
								0
							)
					)
					(if (> (global302 carStat:) 100)
						(global302 carStat: 100)
					)
					(proc0_13 3)
					(= global433 4)
				)
				(else
					(if (and global325 global326 global327 (not global328))
						(self turnedDown: jobNum)
					)
					(= global433 -1)
				)
			)
		else
			(= global433 5)
		)
		(return value)
	)
)

(class JobScript of DialogScript
	(properties)

	(method (handleEvent event)
		(if register
			(= register 0)
			(event type: evKEYBOARD x: 160 y: 100)
			(= cycles 1)
			(switch state
				(2
					(event message: global436)
				)
				(else
					(super handleEvent: event 0)
				)
			)
		)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance employment of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0)
		(if (not global518)
			(Load rsTEXT 206)
			(proc0_17 1)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= global440 2)
			(= global441 205)
			(= global442 95)
			(= global501 -1)
			(= global433 -2)
			(if (< global534 2)
				(Load rsVIEW (theTalker view:))
			)
			(= client param1)
			(gTimeKeep doit: 2)
			(= global400 6)
			(= global402 1)
			(= global437 37)
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
					discountStore
					fastFoodStore
					clothingStore
					applianceStore
					theUniversity
					theFactory
					theBank
					theMarket
					theRentOffice
					exitButton
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 15
			)
			(gASong playBed: 43)
			(KeyMouse setList: keyMouseList)
			(proc0_9 self keyMouseList discountStore)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(global413 init:)
				(Print
					206
					(Random 6 12)
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
		(keyMouseList dispose:)
		(= global502 prevDialog)
		(proc0_15 self 291)
		(self dispose:)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		temp0
		(DisposeScript 206)
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
		view 706
	)
)

(instance discountStore of WButton
	(properties
		nsTop 37
		nsLeft 23
		key 11
		text {Z-Mart Discount}
		shadowColor 80
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 global502 291)
		(= temp0 ((ScriptID 216 0) init: client)) ; discountJobs
		(global502 draw:)
		(proc206_1)
		(return temp0)
	)
)

(instance fastFoodStore of WButton
	(properties
		nsTop 45
		nsLeft 22
		key 10
		text {Monolith Burgers}
		shadowColor 80
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 global502 291)
		(= temp0 ((ScriptID 217 0) init: client)) ; fastFoodJobs
		(global502 draw:)
		(proc206_1)
		(return temp0)
	)
)

(instance clothingStore of WButton
	(properties
		nsTop 53
		nsLeft 35
		key 12
		text {QT Clothing}
		shadowColor 80
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 global502 291)
		(= temp0 ((ScriptID 218 0) init: client)) ; clothingJobs
		(global502 draw:)
		(proc206_1)
		(return temp0)
	)
)

(instance applianceStore of WButton
	(properties
		nsTop 61
		nsLeft 12
		key 8
		text {Socket City Appliance}
		shadowColor 80
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 global502 291)
		(= temp0 ((ScriptID 219 0) init: client)) ; applianceJobs
		(global502 draw:)
		(proc206_1)
		(return temp0)
	)
)

(instance theUniversity of WButton
	(properties
		nsTop 69
		nsLeft 20
		key 7
		text {Hi-Tech University}
		shadowColor 80
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 global502 291)
		(= temp0 ((ScriptID 220 0) init: client)) ; universityJobs
		(global502 draw:)
		(proc206_1)
		(return temp0)
	)
)

(instance theFactory of WButton
	(properties
		nsTop 77
		nsLeft 41
		key 5
		text {Factory}
		shadowColor 80
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 global502 291)
		(= temp0 ((ScriptID 221 0) init: client)) ; factoryJobs
		(global502 draw:)
		(proc206_1)
		(return temp0)
	)
)

(instance theBank of WButton
	(properties
		nsTop 85
		nsLeft 48
		key 4
		text {Bank}
		shadowColor 80
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 global502 291)
		(= temp0 ((ScriptID 222 0) init: client)) ; bankJobs
		(global502 draw:)
		(proc206_1)
		(return temp0)
	)
)

(instance theMarket of WButton
	(properties
		nsTop 93
		nsLeft 26
		key 3
		text {Black's Market}
		shadowColor 80
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 global502 291)
		(= temp0 ((ScriptID 223 0) init: client)) ; marketJobs
		(global502 draw:)
		(proc206_1)
		(return temp0)
	)
)

(instance theRentOffice of WButton
	(properties
		nsTop 101
		nsLeft 35
		key 1
		text {Rent Office}
		shadowColor 80
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 global502 291)
		(= temp0 ((ScriptID 224 0) init: client)) ; rentJobs
		(global502 draw:)
		(proc206_1)
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

(instance theTalker of Talker
	(properties
		nsTop 17
		view 356
	)
)

(instance computerScript of DialogScript
	(properties)

	(method (handleEvent event &tmp temp0)
		(if register
			(= register 0)
			(event type: evKEYBOARD x: 160 y: 100)
			(= cycles 1)
			(switch state
				(2
					(= global438 0)
					(if (or (proc0_6 3) (proc0_6 5))
						(= cycles 60)
						(for
							((= global501 (- global437 1)))
							(>= global501 0)
							((-- global501))
							
							(cond
								(
									(and
										(< global323 60)
										(>=
											(global302 dependibility:)
											[local0 global501]
										)
										(>=
											(global302 experience:)
											[local37 global501]
										)
										(or
											(not (global302 wage:))
											(<
												(global302 wage:)
												[local148 global501]
											)
											(and
												(<=
													(global302 wage:)
													(+ [local148 global501] 1)
												)
												(!= global501 (global302 jobT:))
											)
										)
										(or
											(not (global302 notEnoughEd:))
											(and
												(global302
													hasDegree:
														[local74 global501]
												)
												(global302
													hasDegree:
														[local111 global501]
												)
											)
										)
										(localproc_1 global501)
									)
									(= global436 [local222 global501])
									(event message: [local185 global501])
									(= global437 global501)
									(break)
								)
								((not global501)
									(= state 4)
									(= cycles 1)
								)
							)
						)
					)
				)
				(3
					(cond
						(global438
							(++ state)
						)
						((and global437 (or (proc0_6 3) (proc0_6 5)))
							(= state 1)
						)
					)
				)
				(4
					(if (proc0_6 4)
						(= cycles 60)
						(= global436 (global302 jobKey:))
						(event
							message:
								(if (== (global302 worksAt:) 9)
									12
								else
									(global302 worksAt:)
								)
						)
					)
				)
				(else
					(super handleEvent: event 0)
				)
			)
		)
	)
)

