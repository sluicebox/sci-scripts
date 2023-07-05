;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 229)
(include sci.sh)
(use Main)
(use Interface)
(use KeyMouse)
(use System)

(public
	goalsDefine 0
)

(local
	local0
)

(procedure (localproc_0)
	(textOne erase:)
	(theTitle cel: local0 draw:)
	(corner1 cel: local0 draw:)
	(corner2 cel: local0 draw:)
	(corner3 cel: local0 draw:)
	(corner4 cel: local0 draw:)
	(switch local0
		(0
			(textOne
				text:
					{Wealth is defined as the total accumulation of money, savings, and investments. Try the stock market, and be on the watch for Wild Willy. And most importantly... sorry, out of room.}
			)
		)
		(1
			(textOne
				text:
					{Happiness is accumulated by acquiring goods, achieving goals, taking time off from work, and helping little old ladies cross the street so that they don't get hit by any speeding marbles.}
			)
		)
		(2
			(textOne
				text:
					{Education is accumulated by attending the university and graduating from the classes offered. A computer and some reference books can be very beneficial to your studies.}
			)
		)
		(3
			(textOne
				text:
					{Career is achieved by working hard, climbing the corporate ladder, improving your skills, dependability, and advancing your education. Remember, hire a kid, they have all the answers.}
			)
		)
	)
	(textOne draw:)
	(DoAudio audPLAY (+ local0 590))
)

(instance dKeyMouse of Set
	(properties)
)

(instance goalsDefine of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init &tmp temp0 temp1)
		(DoAudio audRATE 11025)
		(proc0_17 1)
		(= keyMouseList dKeyMouse)
		(= prevDialog global502)
		(= global502 self)
		(proc0_7)
		(= client (= local0 0))
		(self
			window: global38
			add:
				background
				theTitle
				corner1
				corner2
				corner3
				corner4
				textOne
				rightArrow
				doneButton
			eachElementDo: #init 1
			eachElementDo: #setSize
			moveTo: 69 44
			open: 0 -1
		)
		(= temp1 (KeyMouse curItem:))
		(proc0_9 self keyMouseList doneButton)
		(KeyMouse setList: keyMouseList)
		(DoAudio audPLAY 590)
		(gASong
			fade:
				(if (>= (- global520 10) 0)
					(* (- global520 10) 8)
				else
					0
				)
				2
				5
				0
		)
		(= temp0 (self doit: 0 0))
		(if (IsObject temp0)
			(if (self contains: temp0)
				(= temp0 0)
			)
		else
			(= temp0 1)
		)
		(DoAudio audSTOP)
		(gASong fade: (* global520 8) 2 5 0)
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
		(proc0_15 self 294)
		(= global502 prevDialog)
		(self dispose:)
		(proc0_17 0)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		temp0
		(DisposeScript 229)
	)
)

(instance background of DIcon
	(properties
		view 501
		loop 4
	)
)

(instance doneButton of ErasableDIcon
	(properties
		state 419
		nsTop 108
		nsLeft 106
		view 250
		loop 2
	)
)

(instance rightArrow of ErasableDIcon
	(properties
		state 289
		nsTop 108
		nsLeft 47
		view 250
		loop 8
	)

	(method (doit &tmp temp0)
		(= temp0 (super doit:))
		(if (> (++ local0) 3)
			(= local0 0)
		)
		(localproc_0)
		(return temp0)
	)
)

(instance corner1 of DIcon
	(properties
		view 501
		loop 6
	)
)

(instance corner2 of DIcon
	(properties
		nsLeft 147
		view 501
		loop 6
	)
)

(instance corner3 of DIcon
	(properties
		nsTop 88
		view 501
		loop 6
	)
)

(instance corner4 of DIcon
	(properties
		nsTop 88
		nsLeft 147
		view 501
		loop 6
	)
)

(instance theTitle of DIcon
	(properties
		nsTop 4
		nsLeft 41
		view 501
		loop 5
	)
)

(instance textOne of DText
	(properties
		nsTop 30
		nsLeft 6
		text {Wealth is defined as the total accumulation of money, savings, and investments. Try the stock market, and be on the watch for Wild Willy. And most importantly... sorry, out of room.}
		font 4
	)

	(method (draw &tmp [temp0 300])
		(self setPort:)
		(Display
			text
			dsFONT
			font
			dsCOORD
			nsLeft
			nsTop
			dsCOLOR
			0
			dsBACKGROUND
			(if global535 99 else 9)
			dsWIDTH
			171
			dsALIGN
			alCENTER
		)
		(self resetPort:)
	)
)

