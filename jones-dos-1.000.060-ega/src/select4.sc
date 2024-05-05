;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 237)
(include sci.sh)
(use Main)
(use Interface)
(use KeyMouse)
(use User)
(use System)

(public
	select4 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp0 ((ScriptID 1 2) at: 0)) ; players
	(= temp2
		(+ (temp0 monGoal:) (temp0 hapGoal:) (temp0 eduGoal:) (temp0 carGoal:))
	)
	(= temp1 ((ScriptID 1 2) at: 1)) ; players
	(temp1 playingAsJones: 1)
	(temp1 monGoal: (+ (temp0 monGoal:) param1))
	(if (> (temp1 monGoal:) 100)
		(temp1 monGoal: 100)
	)
	(if (< (temp1 monGoal:) 10)
		(temp1 monGoal: 10)
	)
	(if (< (= temp3 (+ temp2 (* 4 param1))) 40)
		(= temp3 40)
	)
	(if (> temp3 400)
		(= temp3 400)
	)
	(if (< (= temp5 (- (/ (-= temp3 (temp1 monGoal:)) 30) 2)) 1)
		(= temp5 1)
	)
	(if (> (= temp6 (+ (/ temp3 30) 2)) 10)
		(= temp6 10)
	)
	(temp1 hapGoal: (* (Random temp5 temp6) 10))
	(temp1 eduGoal: (* (Random temp5 temp6) 10))
	(= temp3 (- (-= temp3 (temp1 hapGoal:)) (temp1 eduGoal:)))
	(if (<= 10 temp3 100)
		(temp1 carGoal: temp3)
	else
		(if (> temp3 100)
			(= temp7 (- temp3 100))
			(temp1 carGoal: 100)
			(while temp7
				(switch (Random 0 4)
					(0
						(if (< (temp1 monGoal:) 100)
							(-= temp7 10)
							(temp1 monGoal: (+ (temp1 monGoal:) 10))
						)
					)
					(1
						(if (< (temp1 hapGoal:) 100)
							(-= temp7 10)
							(temp1 hapGoal: (+ (temp1 hapGoal:) 10))
						)
					)
					(2
						(if (< (temp1 hapGoal:) 100)
							(-= temp7 10)
							(temp1 hapGoal: (+ (temp1 hapGoal:) 10))
						)
					)
					(3
						(if (< (temp1 eduGoal:) 100)
							(-= temp7 10)
							(temp1 eduGoal: (+ (temp1 eduGoal:) 10))
						)
					)
					(4
						(if (< (temp1 eduGoal:) 100)
							(-= temp7 10)
							(temp1 eduGoal: (+ (temp1 eduGoal:) 10))
						)
					)
				)
			)
		)
		(if (< temp3 10)
			(= temp7 (- 10 temp3))
			(temp1 carGoal: 10)
			(while temp7
				(switch (Random 0 4)
					(0
						(if (> (temp1 monGoal:) 10)
							(-= temp7 10)
							(temp1 monGoal: (- (temp1 monGoal:) 10))
						)
					)
					(1
						(if (> (temp1 hapGoal:) 10)
							(-= temp7 10)
							(temp1 hapGoal: (- (temp1 hapGoal:) 10))
						)
					)
					(2
						(if (> (temp1 hapGoal:) 10)
							(-= temp7 10)
							(temp1 hapGoal: (- (temp1 hapGoal:) 10))
						)
					)
					(3
						(if (> (temp1 eduGoal:) 10)
							(-= temp7 10)
							(temp1 eduGoal: (- (temp1 eduGoal:) 10))
						)
					)
					(4
						(if (> (temp1 eduGoal:) 10)
							(-= temp7 10)
							(temp1 eduGoal: (- (temp1 eduGoal:) 10))
						)
					)
				)
			)
		)
	)
	(= global302 temp1)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance select4 of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init &tmp temp0)
		(proc0_17 0)
		(= keyMouseList dialogKeyMouse)
		(= prevDialog global502)
		(= global502 self)
		(= global413 (= client 0))
		(proc0_7)
		(self
			window: global59
			add: background yesButton noButton questionText1
			eachElementDo: #init 1
			eachElementDo: #setSize
			moveTo: 69 44
			open: 0 15 0 0 0 0 1
		)
		(KeyMouse setList: keyMouseList)
		(proc0_9 self keyMouseList yesButton)
		(User canControl: 1)
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
		(keyMouseList release:)
		(= global502 prevDialog)
		(keyMouseList dispose:)
		(self dispose:)
		temp0
		(DisposeScript 237)
	)
)

(instance background of DIcon
	(properties
		view 11
		priority 12
	)
)

(instance questionText1 of DText
	(properties
		nsTop 28
		nsLeft 55
		text { Would you like to\n\nchallenge Jones?}
	)

	(method (draw &tmp [temp0 30])
		(if (not local0)
			(++ local0)
			(self setPort:)
			(Display
				(Format @temp0 237 0 text) ; "%s"
				dsFONT
				0
				dsCOORD
				nsLeft
				nsTop
				dsCOLOR
				(if global535 128 else 14)
				dsBACKGROUND
				(if global535 79 else 9)
				dsWIDTH
				125
			)
			(self resetPort:)
		)
	)
)

(instance questionText2 of DText
	(properties
		nsTop 28
		nsLeft 55
		text {____Would you\n\n___like Jones to:}
	)

	(method (draw &tmp [temp0 30])
		(if (not local1)
			(++ local1)
			(self setPort:)
			(Display
				(Format @temp0 237 0 text) ; "%s"
				dsFONT
				0
				dsCOORD
				nsLeft
				nsTop
				dsCOLOR
				(if global535 128 else 14)
				dsBACKGROUND
				(if global535 79 else 9)
				dsWIDTH
				125
			)
			(self resetPort:)
		)
	)
)

(instance yesButton of ErasableDIcon
	(properties
		state 65
		nsTop 62
		nsLeft 80
		view 10
		loop 3
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(= global374 2)
		(= global507 4)
		(((ScriptID 1 2) at: 1) playing: 29) ; players
		(self erase: species 0)
		(noButton erase:)
		(select4
			delete: questionText1 self noButton
			add: questionText2 takeItEasy playFair goForBroke
		)
		(playFair select: 1)
		(select4 theItem: playFair)
		(takeItEasy init: 1 setSize: draw:)
		(playFair init: 1 setSize: draw:)
		(goForBroke init: 1 setSize: draw:)
		(questionText2 init: 1 setSize: draw:)
		(dialogKeyMouse release:)
		(proc0_9 select4 dialogKeyMouse playFair)
		(return temp0)
	)
)

(instance noButton of ErasableDIcon
	(properties
		state 99
		nsTop 87
		nsLeft 80
		view 10
		loop 3
		cel 1
		priority 13
	)
)

(instance takeItEasy of ErasableDIcon
	(properties
		state 35
		nsTop 57
		nsLeft 67
		view 10
		loop 2
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(localproc_0 10)
		(return temp0)
	)
)

(instance playFair of ErasableDIcon
	(properties
		state 35
		nsTop 74
		nsLeft 67
		view 10
		loop 2
		cel 1
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(localproc_0 0)
		(return temp0)
	)
)

(instance goForBroke of ErasableDIcon
	(properties
		state 35
		nsTop 91
		nsLeft 67
		view 10
		loop 2
		cel 2
		priority 13
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(localproc_0 -10)
		(return temp0)
	)
)

