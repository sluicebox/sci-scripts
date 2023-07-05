;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 231)
(include sci.sh)
(use Main)
(use n115)
(use Interface)
(use KeyMouse)
(use System)

(public
	inventories 0
)

(local
	[local0 700]
)

(procedure (localproc_0 &tmp [temp0 31] temp31 temp32 temp33 temp34)
	(global302 calcNetWorth:)
	(for ((= temp31 0)) (< temp31 700) ((++ temp31))
		(= [local0 temp31] 0)
	)
	(= temp32 (global302 durables:))
	(= temp33 0)
	(if (temp32 size:)
		(for ((= temp31 0)) (< temp31 (temp32 size:)) ((++ temp31))
			(+=
				temp33
				(*
					((temp32 at: temp31) pricePaid:)
					((temp32 at: temp31) quantity:)
				)
			)
		)
	)
	(Format @local0 231 0 (global302 actualName:)) ; "%=25s"
	(if (global302 worksAt:)
		(Format (StrEnd @local0) 231 1 700 (+ (global302 worksAt:) 71)) ; "Works at %-16s"
		(Format (StrEnd @local0) 231 2 700 (global302 occupation:)) ; "As a %-20s"
		(Format (StrEnd @local0) 231 3 (global302 wage:)) ; "Hourly wage: $%-11d"
	else
		(Format (StrEnd @local0) 231 4 231 5) ; "%-25s"
	)
	(Format ; "Cash: $%-18s"
		(StrEnd @local0)
		231
		6
		(proc115_0 (global302 cashHi:) (global302 cash:))
	)
	(Format ; "Savings: $%-15s"
		(StrEnd @local0)
		231
		7
		(proc115_0 (global302 bankBalHi:) (global302 bankBal:))
	)
	(Format (StrEnd @local0) 231 8 (global302 rentOwed:)) ; "Rent Owed: $%-13d"
	(Format (StrEnd @local0) 231 9 (global302 loanBal:)) ; "Loan Balance: $%-10d"
	(Format (StrEnd @local0) 231 10 temp33) ; "Total Goods: $%-11d"
	(Format ; "Investment Total: $%-6s"
		(StrEnd @local0)
		231
		11
		(proc115_0 (global302 invAssHi:) (global302 invAss:))
	)
	(Format ; "Net Worth: $%-13s"
		(StrEnd @local0)
		231
		12
		(proc115_0 (global302 netWorthHi:) (global302 netWorth:))
	)
	(Format (StrEnd @local0) 231 0 231 13) ; "%=25s"
	(if
		(and
			(= temp34 ((global302 consumables:) objectAtIndex: 36))
			(temp34 quantity:)
		)
		(Format (StrEnd @local0) 231 0 231 14 temp34) ; "%=25s"
	)
	(if
		(and
			(= temp34 ((global302 consumables:) objectAtIndex: 35))
			(temp34 quantity:)
		)
		(Format (StrEnd @local0) 231 0 231 15 temp34) ; "%=25s"
	)
	(if
		(and
			(= temp34 ((global302 consumables:) objectAtIndex: 34))
			(temp34 quantity:)
		)
		(Format (StrEnd @local0) 231 0 231 16 temp34) ; "%=25s"
	)
	(if
		(and
			(= temp34 ((global302 consumables:) objectAtIndex: 1))
			(temp34 quantity:)
		)
		(Format (StrEnd @local0) 231 17 (temp34 quantity:)) ; "%3d Weeks of Food"
	)
	(= temp32 (global302 durables:))
	(if (temp32 size:)
		(for ((= temp31 0)) (< temp31 (temp32 size:)) ((++ temp31))
			(if ((temp32 at: temp31) quantity:)
				(Format ; "%3d %-21s"
					(StrEnd @local0)
					231
					18
					((temp32 at: temp31) quantity:)
					700
					((temp32 at: temp31) indexNum:)
				)
			)
		)
	)
	(Format (StrEnd @local0) 231 0 231 19) ; "%=25s"
	(if (global302 numDegrees:)
		(= temp32 (global302 education:))
		(if (temp32 size:)
			(for ((= temp31 0)) (< temp31 (temp32 size:)) ((++ temp31))
				(if (global302 hasDegree: ((temp32 at: temp31) indexNum:))
					(Format ; "%-25s"
						(StrEnd @local0)
						231
						4
						700
						((temp32 at: temp31) indexNum:)
					)
				)
			)
		)
	)
	(Format (StrEnd @local0) 231 0 231 20) ; "%=25s"
	(= temp32 (global302 investments:))
	(for ((= temp31 0)) (< temp31 (temp32 size:)) ((++ temp31))
		(if ((temp32 at: temp31) shares:)
			(Format ; "%-25s"
				(StrEnd @local0)
				231
				4
				(Format ; "%d %s"
					@global100
					231
					21
					((temp32 at: temp31) shares:)
					700
					((temp32 at: temp31) indexNum:)
				)
			)
		)
	)
)

(instance dialogKeyMouse of Set
	(properties)
)

(instance inventories of Dialog
	(properties
		nsBottom 119
		nsRight 184
		menuBarOK 1
		standard 0
	)

	(method (init param1 &tmp temp0 [temp1 2] temp3 temp4)
		(proc0_17 1)
		(= global510 0)
		(= keyMouseList dialogKeyMouse)
		(= prevDialog global502)
		(= global502 self)
		(proc0_7)
		(= temp3 global443)
		(= global443 1)
		(= client param1)
		(global59 color: 0 back: (if global535 142 else 15))
		(= prevTalker global413)
		(= global413 0)
		(self window: global59 add: background invSelector doneButton)
		(localproc_0)
		(invSelector text: @local0 moveTo: 17 20)
		(self
			eachElementDo: #init
			eachElementDo: #setSize
			moveTo: 69 44
			open: 0 15
		)
		(= temp4 (KeyMouse curItem:))
		(proc0_9 self keyMouseList doneButton)
		(KeyMouse setList: keyMouseList)
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
		(KeyMouse curItem: temp4)
		(if global447
			(KeyMouse setCursor: temp4)
		)
		(keyMouseList release: dispose:)
		(= global502 prevDialog)
		(proc0_15 self 291)
		(self dispose:)
		(= global413 prevTalker)
		(= global443 temp3)
		(Graph grFILL_BOX (+ nsTop 1) nsLeft (- nsBottom 1) (- nsRight 3) 2 0 0)
		(= global510 1)
		(proc0_17 0)
		temp0
		(DisposeScript 231)
	)
)

(instance background of DIcon
	(properties
		view 505
		loop 4
	)
)

(instance doneButton of ErasableDIcon
	(properties
		state 99
		nsTop 108
		nsLeft 143
		view 250
		loop 2
	)
)

(instance invSelector of DSelector
	(properties
		type 7
		font 4
		x 25
		y 7
	)
)

