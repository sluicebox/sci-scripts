;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 207)
(include sci.sh)
(use Main)
(use WButton)
(use n108)
(use n109)
(use DialogScript)
(use Interface)
(use KeyMouse)
(use User)
(use System)

(public
	university 0
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 4] = [97 111 125 139]
	[local9 4] = [98 75 87 56]
	[local13 4] = [13 12 9 10]
	local17
)

(procedure (localproc_0) ; UNUSED
	(Format @global100 207 0) ; "Welcome to Hi-Tech U. We will learn you for the future."
	(Format @global100 207 1) ; "Welcome to Hi-Tech U. We'll learn you to talk English good!"
	(Format @global100 207 2) ; "Welcome to Hi-Tech U. Our Geology classes will put rocks in your head!"
	(Format @global100 207 3) ; "Welcome to Hi-Tech U, where you'll never be bored of education!"
	(Format @global100 207 4) ; "Welcome to Hi-Tech U. Enroll now for the third trimester!"
	(Format @global100 207 5) ; "Welcome to Hi-Tech U. All our professors have tweed jackets with elbow patches!"
	(Format @global100 207 6) ; "Welcome to Hi-Tech U. Our diplomas are genuine cheepskin!"
	(Format @global100 207 7) ; "Welcome to Hi-Tech U. Our alumni haven't complained yet!"
	(Format @global100 207 8) ; "Welcome to Hi-Tech U. Next semester is Double Credits Semester!"
	(Format @global100 207 9) ; "Welcome to Hi-Tech U. When it comes to education, we will NOT be undersold!"
	(Format @global100 207 10) ; "Welcome to Hi-Tech U. Already got your BA and MBA? We'll give you the third degree!"
	(Format @global100 207 11) ; "Welcome to Hi-Tech U. No matriculating in the dormitories, please!"
	(Format @global100 207 12) ; "Welcome to Hi-Tech U. Enroll now for our fifth quarter!"
	(Format @global100 207 13) ; "Welcome to Hi-Tech U. You come in with a skull full of mush and you leave thinking like a shyster."
	(Format @global100 207 14) ; "Welcome to Hi-Tech U. Draw Kenny and YOU could win an art scholarship!"
	(Format @global100 207 15) ; "Welcome to Hi-Tech U. Check out our Job Displacement Service!"
	(Format @global100 207 16) ; "Welcome to Hi-Tech U. Need financial assistance? What do we look like, a bank?"
	(Format @global100 207 17) ; "Welcome to Hi-Tech U, where one good term deserves another!"
	(Format @global100 207 18) ; "Welcome to Hi-Tech U. The CIA recruitment center's right here on campus!"
	(Format @global100 207 19) ; "Welcome to Hi-Tech U. Meet Ed Fiz, our Phys Ed instructor!"
	(Format @global100 207 20) ; "Welcome to Hi-Tech U. CPA degrees or 65% x 1.2146/5ths of your money back!"
	(Format @global100 207 21) ; "Welcome to Hi-Tech U. Where our campus ROTC stands for Really Obnoxious Teenage Civilians!"
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0 temp1)
	(for ((= temp0 (- (param1 size:) 1))) (>= temp0 0) ((-- temp0))
		(= temp1 (param1 at: temp0))
		(if (& (temp1 state:) $0001)
			(param2 add: temp1)
			(temp1
				keyMouseX:
					(+
						(/ (+ (temp1 nsLeft:) (temp1 nsRight:)) 2)
						(param1 nsLeft:)
					)
				keyMouseY:
					(+
						(/ (+ (temp1 nsTop:) (temp1 nsBottom:)) 2)
						(param1 nsTop:)
					)
			)
		)
	)
	(if global447
		(KeyMouse
			setCursor:
				(if (>= argc 3)
					param3
				else
					(param2 at: 0)
				)
		)
	)
	(KeyMouse
		curItem:
			(if (>= argc 3)
				param3
			else
				(param2 at: 0)
			)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2)
	(= temp2 (global302 education:))
	(for ((= temp0 (= temp1 0))) (< temp0 (temp2 size:)) ((++ temp0))
		(if
			(<
				0
				((temp2 at: temp0) quantity:)
				((temp2 at: temp0) unitsToGraduate:)
			)
			(++ temp1)
		)
	)
	(return temp1)
)

(procedure (localproc_3)
	(= local1 0)
	(publishing addCourse: university)
	(research addCourse: university)
	(postDoctoral addCourse: university)
	(graduate addCourse: university)
	(academic addCourse: university)
	(ba addCourse: university)
	(juniorCollege addCourse: university)
	(engineering addCourse: university)
	(preEngineering addCourse: university)
	(electronics addCourse: university)
	(tradeSchool addCourse: university)
	(if local1
		(books cel: (- local1 1) nsTop: (+ 42 (* (- 4 local1) 14)))
	)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 5])
	(if local1
		(= temp0 (- (university size:) 1))
		(= temp3 (- 4 local1))
		(while (> temp0 2)
			(if ((university at: temp0) isMemberOf: UniversityDIcon)
				(if
					(= temp1
						((global302 education:)
							objectAtIndex: ((university at: temp0) indexNum:)
						)
					)
					(= temp2
						(-
							(- (temp1 unitsToGraduate:) (temp1 quantity:))
							(global302 extraCredits:)
						)
					)
					(if (and local17 (<= temp2 0))
						(= temp2 1)
					)
					(if
						(<=
							0
							temp2
							(-
								(temp1 unitsToGraduate:)
								(global302 extraCredits:)
							)
						)
						(= temp4 (GetPort))
						(SetPort 0)
						(Display
							(Format @temp5 207 24 temp2) ; "%d"
							dsCOLOR
							0
							dsBACKGROUND
							(if global535 [local9 temp3] else [local13 temp3])
							dsCOORD
							222
							[local5 temp3]
						)
						(SetPort temp4)
					)
				)
				(++ temp3)
			)
			(-- temp0)
		)
	)
)

(class UniversityDIcon of DIcon
	(properties
		state 1
		preReq 0
		indexNum 0
		typeOfGoods 2
		fixedPrice 1
		visitTime 6
	)

	(method (addCourse param1)
		(if
			(and
				(not (global302 hasDegree: indexNum))
				(or (not preReq) (global302 hasDegree: preReq))
			)
			(param1 add: self)
			(++ local1)
			(self nsTop: (- 108 (* 14 local1)) nsLeft: (+ (books nsLeft:) 5))
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= local17 0)
		(gASoundEffect play: 23)
		(= temp1 (super doit:))
		(if
			(or
				(>
					(global302 enrollments:)
					(+ (localproc_2) (global302 numDegrees:))
				)
				(and
					(==
						(global302 enrollments:)
						(+ (localproc_2) (global302 numDegrees:))
					)
					(global302 courseActive: indexNum)
				)
			)
			(if (!= global323 60)
				(= global418 ((global302 education:) recieve: indexNum 1))
				(localproc_4)
				(if
					(>=
						(global418 quantity:)
						(-
							(global418 unitsToGraduate:)
							(global302 extraCredits:)
						)
					)
					(global418 quantity: (global418 unitsToGraduate:))
				)
				(global418 indexNum: indexNum)
				(gTimeKeep doit: visitTime)
				(if (global302 hasDegree: indexNum)
					(gASong fade:)
					(global302 notEnoughEd: 0)
					(proc0_13 5)
					(global302 eduCredit: (+ (global302 eduCredit:) 5))
					(global302 dependibility: (+ (global302 dependibility:) 5))
					(global302 expCredit: (+ (global302 expCredit:) 5))
					(User canControl: 0)
					(self select: 0)
					(exitButton select: 0)
					(university theItem: exitButton)
					(proc0_15 university 291)
					((ScriptID 230 0) init: client indexNum) ; diploma
					(gASong play: 41)
					(university draw:)
					(for
						((= temp0 (- (university size:) 1)))
						(> temp0 2)
						((-- temp0))
						
						(if ((university at: temp0) isMemberOf: UniversityDIcon)
							(university delete: (university at: temp0))
						)
					)
					(books erase:)
					(localproc_3)
					(if local1
						(books draw:)
						(for
							((= temp2 (- (university size:) 1)))
							(> temp2 2)
							((-- temp2))
							
							(if
								((university at: temp2)
									isMemberOf: UniversityDIcon
								)
								((university at: temp2) init: setSize: draw:)
							)
						)
						(localproc_4)
					else
						(enrollButton erase:)
						(university delete: enrollButton books)
					)
					(if (university contains: timeClock)
						(university delete: timeClock)
						(university add: timeClock)
					)
					(dialogKeyMouse release:)
					(localproc_1
						university
						dialogKeyMouse
						(if (not local1)
							(university at: (- (university size:) 1))
						else
							(university at: local3)
						)
					)
					(global302 eduStat: (+ 1 (* 9 (global302 numDegrees:))))
				)
			else
				(if global413
					(global413 init: 16)
				)
				(Print ; "No time is left to go to class."
					207
					22
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
		else
			(if global413
				(global413 init: 16)
			)
			(= temp1 0)
			(Print ; "You need to enroll in a class first."
				207
				23
				310
				global413
				global440
				global441
				global442
				70
				113
			)
		)
		(return temp1)
	)

	(method (select))
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance notEnoughCash of Obj
	(properties)

	(method (doit)
		(global413 init: 16)
		(Print ; "You do not have enough cash."
			207
			25
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

(instance university of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0)
		(if (not global518)
			(= local17 1)
			(Load rsTEXT 207)
			(proc0_17 2)
			(= keyMouseList dialogKeyMouse)
			(= prevDialog global502)
			(= global502 self)
			(= global440 7)
			(= global441 110)
			(= global442 78)
			(if (< global534 2)
				(Load rsVIEW (theTalker view:))
			)
			(= global424 notEnoughCash)
			(= client param1)
			(gTimeKeep doit: 2)
			(= global400 7)
			(= global413 theTalker)
			(if (== (global302 playing:) 29)
				(self setScript: computerScript)
				(computerScript cue:)
			)
			(self
				window: global59
				add: background theTalker books exitButton enrollButton
			)
			(= local3 5)
			(if (== (global302 worksAt:) 7)
				(Load rsVIEW 750)
				(self add: workButton)
				(++ local3)
			)
			(localproc_3)
			(if (not local1)
				(self delete: books enrollButton)
				(-- local3)
			)
			(enrollmentFee init:)
			(self
				eachElementDo: #init 1
				eachElementDo: #setSize
				moveTo: 69 44
				open: 0 15
			)
			(if (== (global302 worksAt:) 7)
				(self add: timeClock)
				(timeClock init: setSize: draw:)
			)
			(gASong playBed: 41)
			(KeyMouse setList: keyMouseList)
			(localproc_1
				self
				keyMouseList
				(if (not local1)
					exitButton
				else
					(self at: local3)
				)
			)
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
			(User canControl: 1)
			(if (proc0_14)
				(global413 init:)
				(Print
					207
					(Random 0 21)
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
			(if (and (not (global302 coursesDone:)) (not local1))
				(global302 coursesDone: 1)
				(global413 init:)
				(Print ; "Perhaps next year we will have more classes to offer to you."
					207
					26
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
		(workButton dispose:)
		(self dispose:)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(proc0_17 0)
		temp0
		(DisposeScript 207)
	)

	(method (draw)
		(super draw:)
		(if global518
			(gCalc setSize: value: (- (global302 cash:) 1) draw:)
		)
		(localproc_4)
	)
)

(instance background of DIcon
	(properties
		view 807
		priority 13
	)
)

(instance books of DIcon
	(properties
		state 64
		nsLeft 71
		view 707
		loop 1
		priority 13
	)
)

(instance enrollmentFee of CostDItem
	(properties
		nsTop 32
		nsLeft 85
		text {Enrollment Fee }
		typeOfGoods 4
		basePrice 50
	)

	(method (init)
		(= price (proc109_0 global309 basePrice))
	)

	(method (doit)
		(if (>= (proc0_11) price)
			(global302 enrollments: (+ (global302 enrollments:) 1))
		)
		(super doit:)
	)

	(method (select))
)

(instance tradeSchool of UniversityDIcon
	(properties
		key 2
		view 707
		loop 2
		priority 13
		indexNum 10
	)

	(method (draw param1)
		(self setPort:)
		(if (or (and (!= type 6) (!= type 7)) (and argc param1))
			(self erase:)
			(if (& state $0040)
				(= lsTop nsTop)
				(= lsLeft nsLeft)
				(= lsBottom nsBottom)
				(= lsRight nsRight)
				(= underBits
					(Graph
						grSAVE_BOX
						(- nsTop 1)
						(- nsLeft 1)
						(+ nsBottom 1)
						(+ nsRight 1)
						1
					)
				)
			)
		)
		(if type
			(DrawControl self)
		)
		(self resetPort:)
	)
)

(instance electronics of UniversityDIcon
	(properties
		key 3
		view 707
		loop 2
		cel 1
		priority 13
		preReq 10
		indexNum 11
	)
)

(instance preEngineering of UniversityDIcon
	(properties
		key 4
		view 707
		loop 2
		cel 2
		priority 13
		preReq 10
		indexNum 12
	)
)

(instance engineering of UniversityDIcon
	(properties
		key 5
		view 707
		loop 2
		cel 3
		priority 13
		preReq 12
		indexNum 13
	)
)

(instance juniorCollege of UniversityDIcon
	(properties
		key 6
		view 707
		loop 2
		cel 4
		priority 13
		indexNum 14
	)
)

(instance ba of UniversityDIcon
	(properties
		key 7
		view 707
		loop 2
		cel 5
		priority 13
		preReq 14
		indexNum 15
	)
)

(instance academic of UniversityDIcon
	(properties
		key 8
		view 707
		loop 2
		cel 6
		priority 13
		preReq 14
		indexNum 16
	)
)

(instance graduate of UniversityDIcon
	(properties
		key 14
		view 707
		loop 2
		cel 7
		priority 13
		preReq 16
		indexNum 17
	)
)

(instance postDoctoral of UniversityDIcon
	(properties
		key 10
		view 707
		loop 2
		cel 8
		priority 13
		preReq 17
		indexNum 18
	)
)

(instance research of UniversityDIcon
	(properties
		key 11
		view 707
		loop 2
		cel 9
		priority 13
		preReq 18
		indexNum 19
	)
)

(instance publishing of UniversityDIcon
	(properties
		key 12
		view 707
		loop 2
		cel 10
		priority 13
		preReq 19
		indexNum 20
	)
)

(instance exitButton of ErasableDIcon
	(properties
		state 99
		nsTop 108
		nsLeft 147
		key 120
		view 250
		priority 15
	)

	(method (select))
)

(instance enrollButton of ErasableDIcon
	(properties
		state 65
		nsTop 108
		nsLeft 105
		key 1
		view 250
		loop 10
		priority 15
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(cond
			((== (global302 playing:) 29)
				(enrollmentFee doit:)
				(if global416
					(proc104_1
						(Format @global100 207 27 (enrollmentFee price:)) ; "Your enrollment fee of $%d has been accepted."
						310
						global413
						global440
						global441
						global442
						70
						113
					)
				)
			)
			(
				(Print
					(Format @global100 207 28 (enrollmentFee price:)) ; "The enrollment fee is $%d. Would you like to enroll?"
					310
					global413
					global440
					global441
					global442
					70
					113
					81
					{Yes}
					1
					81
					{No}
					0
					311
				)
				(enrollmentFee doit:)
				(global413 init:)
				(if (and global427 global416)
					(Print ; "Thank You. You may select the class of your choice."
						207
						29
						310
						global413
						global440
						global441
						global442
						70
						113
					)
				)
			)
			(global427
				(global413 init:)
				(Print ; "Perhaps at another time."
					207
					30
					310
					global413
					global440
					global441
					global442
					70
					113
				)
			)
		)
		(super doit: 0)
	)
)

(instance workButton of ErasableDIcon
	(properties
		state 65
		nsTop 108
		nsLeft 71
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
				(university delete: self)
				(self erase:)
			)
			((and (< global323 60) (> temp0 0))
				(timeClock doit:)
			)
		)
		(super doit: 0)
	)

	(method (select))
)

(instance timeClock of TimeClock
	(properties
		nsTop 56
	)

	(method (setSize)
		(global502 aTimeClock: timeClock)
		(super setSize:)
	)
)

(instance theTalker of Talker
	(properties
		nsLeft 0
		view 357
	)
)

(instance computerScript of DialogScript
	(properties)

	(method (handleEvent event &tmp temp0 temp1)
		(if register
			(= register 0)
			(event type: evKEYBOARD x: 160 y: 100)
			(= cycles 1)
			(switch state
				(2
					(if (proc0_6 16)
						(if (== global407 16)
							(= local4 global408)
							(if
								(and
									(not (global302 notEnoughEd:))
									(>=
										(global302 eduStat:)
										(global302 eduGoal:)
									)
									(<= (-= local4 1) 0)
								)
								(= local4 1)
							)
						else
							(= local4 10)
							(if global410
								(-= global410 100)
								(= local4 (+ 2 (/ (- 60 global410) 6)))
								(if (not (mod (- 60 global410) 6))
									(-- local4)
								)
							)
						)
					)
					(= local2 0)
					(= temp1 (if (university contains: workButton) 1 else 0))
					(for
						((= temp0 (- (university size:) (+ 1 temp1))))
						(>= temp0 (- (university size:) (+ local1 temp1)))
						((-- temp0))
						
						(if
							(and
								((university at: temp0)
									isMemberOf: UniversityDIcon
								)
								(global302
									courseActive:
										((university at: temp0) indexNum:)
								)
							)
							(= local2 (university at: temp0))
							(break)
						)
					)
					(if (and (not local2) (!= (global302 numDegrees:) 11))
						(= local2
							(university
								at:
									(-
										(university size:)
										(+ (Random 1 local1) temp1)
									)
							)
						)
					)
				)
				(3
					(if
						(and
							(proc0_6 16)
							local2
							(==
								(global302 enrollments:)
								(global302 numDegrees:)
							)
							(>= (proc0_11) (enrollmentFee price:))
						)
						(= cycles 30)
						(event message: (enrollButton key:))
					)
				)
				(4
					(if
						(and
							(proc0_6 16)
							local4
							(>=
								(global302 enrollments:)
								(global302 numDegrees:)
							)
							local2
						)
						(-- local4)
						(= cycles 30)
						(event message: (local2 key:))
					)
				)
				(11
					(if (and (== global407 1) (not (proc0_6 16)))
						(= global407 16)
						(if
							(or
								(global302 notEnoughEd:)
								(< (global302 eduStat:) (global302 eduGoal:))
							)
							(= global408 2)
						else
							(= global408 1)
						)
						(= state 0)
						(self cue:)
					)
				)
				(else
					(super handleEvent: event 1)
				)
			)
		)
	)
)

