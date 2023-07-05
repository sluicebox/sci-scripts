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
	[local0 39] = [0 10 10 10 20 20 20 20 20 20 20 20 30 30 30 30 30 30 30 40 40 40 40 40 40 50 40 40 50 50 50 50 50 60 60 60 60 70 70]
	[local39 39] = [0 10 10 10 10 10 20 10 10 10 10 20 20 20 30 30 30 30 30 30 40 40 40 40 40 40 40 40 50 50 50 50 50 50 60 60 60 70 70]
	[local78 39] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 10 14 10 14 14 14 12 14 11 16 14 14 15 15 15 15 13 19 15 14 14 15 15]
	[local117 39] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 11 0 0 0 0 0 0 0 0 13 13 16 13]
	[local156 39] = [5 6 5 5 6 6 7 6 6 7 7 8 7 7 8 8 8 9 9 8 9 9 10 10 11 11 14 15 12 14 18 18 19 20 19 22 23 22 25]
	[local195 39] = [10 3 11 7 10 8 11 12 4 1 5 3 8 10 12 5 11 1 3 10 12 5 5 4 8 7 8 3 12 4 3 5 5 7 4 5 5 4 5]
	[local234 39] = [1 1 1 1 2 4 2 4 1 1 1 2 1 3 1 2 3 2 3 4 2 3 4 2 2 2 3 4 3 3 5 5 6 3 4 7 8 5 10]
	[local273 39] = [36 36 36 36 36 36 35 36 36 36 36 36 35 36 35 36 34 36 36 35 34 35 36 35 36 35 34 35 34 34 34 34 36 35 34 34 34 34 34]
)

(procedure (proc206_1 &tmp temp0)
	(if (>= global433 -1)
		(global413 init: 32)
		(if (== global433 -1)
			(proc0_13 -1)
			(gASong pause: 1)
			(gASoundEffect play: 44 gASong)
			(if (not global325)
				(global302 notEnoughEd: 1)
			)
			(if (or (not global325) (not global327) (not global326))
				(repeat
					(if (not [global325 (= temp0 (Random 0 2))])
						(break)
					)
				)
			else
				(= temp0 3)
			)
			(proc0_18 (+ 434 temp0) global413 computerScript)
		else
			(if (or (== global433 2) (== global433 4))
				(gASong pause: 1)
				(gASoundEffect play: 45 gASong)
			)
			(proc0_18 (+ global433 420) global413 computerScript)
		)
	)
)

(procedure (localproc_0 param1 &tmp temp0)
	(switch [local273 param1]
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
		state 163
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
			(Format param1 206 0 text price) ; "%s $%d Hr."
		else
			(Format param1 206 1 text price) ; "%s $%d Hr."
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
								(+ dependibility (* 5 (global302 raises:)))
							)
							(proc0_13 3)
							(global302 raises: (+ (global302 raises:) 1))
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
						raises: 0
						experience: (+ (global302 experience:) 2)
						maxExper:
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

	(method (init param1 &tmp temp0 temp1)
		(if (not global518)
			(DoAudio audRATE 11025)
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
			(= global437 39)
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
			)
			(= global413 theTalker)
			(self
				window: global38
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
				open: 0 -1
			)
			(gASong playBed: 43)
			(KeyMouse setList: keyMouseList)
			(proc0_9 self keyMouseList discountStore)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(= temp1 (Random 6 12))
				(computerScript state: -1 cycles: 0 seconds: 0)
				(proc0_18 (+ temp1 420) global413 computerScript)
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
		(keyMouseList dispose:)
		(= global502 prevDialog)
		(proc0_15 self 294)
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
		(proc0_15 global502 294)
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
		(proc0_15 global502 294)
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
		(proc0_15 global502 294)
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
		(proc0_15 global502 294)
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
		(proc0_15 global502 294)
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
		(proc0_15 global502 294)
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
		(proc0_15 global502 294)
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
		(proc0_15 global502 294)
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
		(proc0_15 global502 294)
		(= temp0 ((ScriptID 224 0) init: client)) ; rentJobs
		(global502 draw:)
		(proc206_1)
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
											[local39 global501]
										)
										(or
											(not (global302 wage:))
											(<
												(global302 wage:)
												[local156 global501]
											)
											(and
												(<=
													(global302 wage:)
													(+ [local156 global501] 1)
												)
												(!= global501 (global302 jobT:))
											)
										)
										(or
											(not (global302 notEnoughEd:))
											(and
												(global302
													hasDegree:
														[local78 global501]
												)
												(global302
													hasDegree:
														[local117 global501]
												)
											)
										)
										(localproc_0 global501)
									)
									(= global436 [local234 global501])
									(event message: [local195 global501])
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

