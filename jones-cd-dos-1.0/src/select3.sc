;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 236)
(include sci.sh)
(use Main)
(use Interface)
(use KeyMouse)
(use System)

(public
	select3 0
)

(local
	local0
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance select3 of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 param2 &tmp temp0 temp1)
		(= prevTalker global413)
		(= global413 0)
		(proc0_17 0)
		(= keyMouseList dialogKeyMouse)
		(= prevDialog global502)
		(= global502 self)
		(= client (if (== param2 2) param1 else 0))
		(= local0 param2)
		(if (== global374 (+ global507 1))
			(exButton loop: 11)
		)
		(if (!= local0 0)
			(wealthStar enable: 0)
			(happyStar enable: 0)
			(educationStar enable: 0)
			(careerStar enable: 0)
			(exButton loop: 0)
		)
		(proc0_7)
		(if (!= param2 2)
			(playerNumber1 cel: global507)
			(playerNumber2 cel: global507)
		else
			(playerNumber1
				cel:
					(if (global302 playJones:)
						4
					else
						(global302 whatNum:)
					)
			)
			(playerNumber2
				cel:
					(if (global302 playJones:)
						4
					else
						(global302 whatNum:)
					)
			)
		)
		(if (== param2 2)
			(windowTitle cel: 0 view: 501)
		else
			(windowTitle cel: param2 view: 506)
		)
		(if (== param2 0)
			(if global507
				(wealthStar
					updStar: (((ScriptID 1 2) at: (- global507 1)) monGoal:) ; players
				)
				(happyStar
					updStar: (((ScriptID 1 2) at: (- global507 1)) hapGoal:) ; players
				)
				(educationStar
					updStar: (((ScriptID 1 2) at: (- global507 1)) eduGoal:) ; players
				)
				(careerStar
					updStar: (((ScriptID 1 2) at: (- global507 1)) carGoal:) ; players
				)
			else
				(wealthStar updStar: 50)
				(happyStar updStar: 50)
				(educationStar updStar: 50)
				(careerStar updStar: 50)
			)
		else
			(= global507 ((ScriptID 1 2) indexOf: global302)) ; players
			(wealthStar updStar: (global302 monGoal:))
			(happyStar updStar: (global302 hapGoal:))
			(educationStar updStar: (global302 eduGoal:))
			(careerStar updStar: (global302 carGoal:))
		)
		(self
			window: global38
			add:
				background
				windowTitle
				playerNumber1
				playerNumber2
				exButton
				wealthStar
				happyStar
				educationStar
				careerStar
				goalPoints
				questionButton
		)
		(if (== param2 2)
			(self
				add: currentWealth currentHappy currentEducation currentCareer
			)
		)
		(self
			eachElementDo: #init 1
			eachElementDo: #setSize
			moveTo: 69 44
			open: 0 -1
		)
		(= temp1 (KeyMouse curItem:))
		(KeyMouse setList: keyMouseList)
		(proc0_9 self keyMouseList exButton)
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
		(= global502 prevDialog)
		(proc0_15 self 294)
		(self dispose:)
		(SetPort 0)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(= global413 prevTalker)
		temp0
		(DisposeScript 236)
	)
)

(instance background of DIcon
	(properties
		view 501
		loop 1
		priority 8
	)
)

(instance windowTitle of DIcon
	(properties
		nsLeft 24
		view 501
		priority 9
	)
)

(instance playerNumber1 of DIcon
	(properties
		loop 3
		priority 15
	)
)

(instance playerNumber2 of DIcon
	(properties
		nsLeft 158
		loop 3
		priority 15
	)
)

(instance exButton of ErasableDIcon
	(properties
		state 419
		nsTop 108
		nsLeft 143
		view 250
		loop 8
		priority 15
	)
)

(class StarSlider of DIcon
	(properties
		state 257
		view 501
		loop 2
		priority 10
		goalValue 0
	)

	(method (select)
		(return 0)
	)

	(method (hilite)
		(return 0)
	)

	(method (track param1 &tmp temp0 temp1 temp2 temp3)
		(= temp0 nsTop)
		(= temp1 999)
		(while (StillDown param1)
			(if client
				(param1 localize: ((client window:) window:))
			)
			(cond
				((not (>= (+ nsRight 5) (param1 x:) (- nsLeft 5)))
					(break)
				)
				((!= temp1 (- (param1 y:) 4))
					(= temp0
						(cond
							((> (= temp1 (- (param1 y:) 4)) 82) 82)
							((< temp1 43) 43)
							(else temp1)
						)
					)
					(= temp3 (* (+ (/ (- 82 temp0) 4) 1) 10))
					(self erase: updStar: temp3 draw:)
					(goalPoints draw:)
				)
			)
		)
		(return 0)
	)

	(method (updStar param1)
		(= cel (/ (- (= goalValue param1) 1) 10))
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 -1)
		(cond
			((!= (client theItem:) self) 0)
			((& (event type:) $0040) ; direction
				(cond
					((== (event message:) JOY_UP)
						(if (> (= temp0 (+ cel 1)) 9)
							(= temp0 9)
						)
					)
					((and (== (event message:) JOY_DOWN) (< (= temp0 (- cel 1)) 0))
						(= temp0 0)
					)
				)
			)
		)
		(if (!= temp0 -1)
			(= temp1 (* (+ temp0 1) 10))
			(self erase: updStar: temp1 draw:)
			(goalPoints draw:)
			(event claimed: 1)
			(return self)
		else
			(super handleEvent: event)
			(return)
		)
	)
)

(instance wealthStar of StarSlider
	(properties
		nsTop 38
		nsLeft 32
		goalValue 1
	)

	(method (updStar param1)
		(((ScriptID 1 2) at: global507) monGoal: param1) ; players
		(super updStar: param1)
	)
)

(instance happyStar of StarSlider
	(properties
		nsTop 38
		nsLeft 68
		goalValue 1
	)

	(method (updStar param1)
		(((ScriptID 1 2) at: global507) hapGoal: param1) ; players
		(super updStar: param1)
	)
)

(instance educationStar of StarSlider
	(properties
		nsTop 38
		nsLeft 104
		goalValue 1
	)

	(method (updStar param1)
		(((ScriptID 1 2) at: global507) eduGoal: param1) ; players
		(super updStar: param1)
	)
)

(instance careerStar of StarSlider
	(properties
		nsTop 38
		nsLeft 139
		goalValue 1
	)

	(method (updStar param1)
		(((ScriptID 1 2) at: global507) carGoal: param1) ; players
		(super updStar: param1)
	)
)

(instance goalPoints of DText
	(properties
		nsTop 29
		nsLeft 31
		text {Goal Points = }
		font 0
	)

	(method (draw &tmp [temp0 20] temp20)
		(self setPort:)
		(= temp20
			(+
				(wealthStar goalValue:)
				(happyStar goalValue:)
				(educationStar goalValue:)
				(careerStar goalValue:)
			)
		)
		(Display
			(Format @temp0 236 0 text temp20) ; "%s%3d"
			dsFONT
			font
			dsCOORD
			nsLeft
			nsTop
			dsCOLOR
			0
			dsBACKGROUND
			(if global535 99 else 9)
		)
		(self resetPort:)
	)
)

(instance currentWealth of DIcon
	(properties
		nsTop 43
		nsLeft 30
		view 501
		loop 3
		priority 15
	)

	(method (draw &tmp temp0 temp1 temp2)
		(= temp0 (global302 monStat:))
		(= temp1 (global302 monGoal:))
		(if (< temp0 0)
			(= temp0 0)
		)
		(if (>= temp0 temp1)
			(= temp0 temp1)
			(= temp2 71)
			(= cel 1)
		else
			(= temp2 80)
			(= cel 0)
		)
		(if (>= (= value temp0) temp1)
			(= nsTop (- temp2 (* (/ (- value 10) 10) 4)))
		else
			(= nsTop (- temp2 (/ (+ value 3) 4)))
		)
		(self setSize:)
		(super draw:)
	)
)

(instance currentHappy of DIcon
	(properties
		nsTop 43
		nsLeft 66
		view 501
		loop 3
		priority 15
	)

	(method (draw &tmp temp0 temp1 temp2)
		(= temp0 (global302 hapStat:))
		(= temp1 (global302 hapGoal:))
		(if (< temp0 0)
			(= temp0 0)
		)
		(if (>= temp0 temp1)
			(= temp0 temp1)
			(= temp2 71)
			(= cel 1)
		else
			(= temp2 80)
			(= cel 0)
		)
		(if (>= (= value temp0) temp1)
			(= nsTop (- temp2 (* (/ (- value 10) 10) 4)))
		else
			(= nsTop (- temp2 (/ (+ value 3) 4)))
		)
		(self setSize:)
		(super draw:)
	)
)

(instance currentEducation of DIcon
	(properties
		nsTop 80
		nsLeft 102
		view 501
		loop 3
		priority 15
	)

	(method (draw &tmp temp0 temp1 temp2)
		(= temp0 (global302 eduStat:))
		(= temp1 (global302 eduGoal:))
		(if (< temp0 0)
			(= temp0 0)
		)
		(if (>= temp0 temp1)
			(= temp0 temp1)
			(= temp2 71)
			(= cel 1)
		else
			(= temp2 80)
			(= cel 0)
		)
		(if (>= (= value temp0) temp1)
			(= nsTop (- temp2 (* (/ (- value 10) 10) 4)))
		else
			(= nsTop (- temp2 (/ (+ value 3) 4)))
		)
		(self setSize:)
		(super draw:)
	)
)

(instance currentCareer of DIcon
	(properties
		nsTop 43
		nsLeft 137
		view 501
		loop 3
		priority 15
	)

	(method (draw &tmp temp0 temp1 temp2)
		(= temp0 (global302 carStat:))
		(= temp1 (global302 carGoal:))
		(if (< temp0 0)
			(= temp0 0)
		)
		(if (>= temp0 temp1)
			(= temp0 temp1)
			(= temp2 71)
			(= cel 1)
		else
			(= temp2 80)
			(= cel 0)
		)
		(if (>= (= value temp0) temp1)
			(= nsTop (- temp2 (* (/ (- value 10) 10) 4)))
		else
			(= nsTop (- temp2 (/ (+ value 3) 4)))
		)
		(self setSize:)
		(super draw:)
	)
)

(instance questionButton of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 124
		view 250
		loop 9
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(proc0_15 select3 294)
		(if (== (DoSound sndGET_POLYPHONY) 1)
			(gASong pause: 1)
		)
		(= temp0 ((ScriptID 229 0) init: client)) ; goalsDefine
		(if (== (DoSound sndGET_POLYPHONY) 1)
			(gASong pause: 0)
		)
		(select3 draw:)
		(return temp0)
	)
)

