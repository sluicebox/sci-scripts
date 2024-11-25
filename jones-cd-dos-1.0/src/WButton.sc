;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 104)
(include sci.sh)
(use Main)
(use FwdCount)
(use n109)
(use Interface)
(use DCIcon)
(use Sync)
(use System)

(public
	WButton 0
	proc104_1 1
)

(procedure (proc104_1 &tmp temp0 temp1) ; UNUSED
	(= temp0 (GetPort))
	(SetPort 0)
	(if global302
		(= temp1 (if (== (global302 playing:) 29) global426 else 5000))
	)
	(Print &rest #window gBubbleWindow #time temp1)
	(SetPort temp0)
)

(class WButton of DButton
	(properties
		type 0
		state 33
		theFont 10
		textColor 0
		backColor -1
		shadowColor 6
		flashColor 100
		width 0
	)

	(method (select param1)
		(if param1
			(|= state $0008)
		else
			(&= state $fff7)
		)
	)

	(method (init)
		(self setTextSize:)
	)

	(method (draw &tmp [temp0 40])
		(self setTextSize:)
		(super draw:)
		(if (and global535 shadowColor)
			(self
				doDisplay:
					(+ nsLeft 1)
					(+ nsTop 1)
					(if global535 shadowColor else 7)
					1
			)
		)
		(self doDisplay: nsLeft nsTop (if global535 textColor else 0) 0)
	)

	(method (hilite param1)
		(self setPort:)
		(self hiliteControl: (if global535 flashColor else 12))
		(Wait 0)
		(if global525
			(Wait 5)
		else
			(Wait (/ 25 param1))
		)
		(self hiliteControl: (if global535 textColor else 0))
		(self resetPort:)
	)

	(method (track param1 &tmp temp0 temp1)
		(= temp1 0)
		(if (& (param1 type:) $0001)
			(self setPort:)
			(repeat
				(= param1 (Event new: evPEEK))
				(param1 localize: ((client window:) window:))
				(if (!= (= temp0 (self check: param1)) temp1)
					(self
						hiliteControl:
							(cond
								(temp0
									(if global535 flashColor else 12)
								)
								(global535 textColor)
								(else 0)
							)
					)
				)
				(= temp1 temp0)
				(param1 dispose:)
				(breakif (not (StillDown)))
			)
			(if temp0
				(self hiliteControl: (if global535 textColor else 0))
			)
			(self resetPort:)
			(return temp0)
		else
			(if (and (& (param1 type:) $0004) (== (param1 message:) key))
				(self hilite: 1)
			)
			(return self)
		)
	)

	(method (hiliteControl param1 &tmp [temp0 40])
		(self doFormat: @temp0)
		(Display @temp0 dsCOORD nsLeft nsTop dsCOLOR param1 dsBACKGROUND backColor dsFONT theFont)
	)

	(method (doFormat param1)
		(Format param1 104 0 text) ; "%s"
	)

	(method (setTextSize &tmp [temp0 40] [temp40 4])
		(self doFormat: @temp0)
		(if (and temp0 (StrLen @temp0))
			(TextSize @[temp40 0] @temp0 theFont 0)
			(= nsBottom (+ [temp40 2] nsTop (!= shadowColor 0)))
			(= nsRight (+ [temp40 3] nsLeft (!= shadowColor 0)))
		)
	)

	(method (doDisplay param1 param2 param3 &tmp temp0 [temp1 40])
		(self doFormat: @temp1)
		(self setPort:)
		(Display
			@temp1
			dsCOORD
			param1
			param2
			dsCOLOR
			param3
			dsBACKGROUND
			(if global535 backColor else -1)
			dsFONT
			theFont
		)
		(self resetPort:)
	)

	(method (doit &tmp temp0)
		(gASoundEffect play: 23)
		(= temp0 (super doit:))
		(if global413
			(global413 init:)
		)
		(return temp0)
	)
)

(class CostDItem of WButton
	(properties
		nsLeft 4
		price 0
		indexNum 0
		typeOfGoods 0
		units 1
		theSign -1
		basePrice 0
		fixedPrice 0
		theDurable 0
		visitTime 0
		celNum 0
	)

	(method (init param1 &tmp temp0)
		(super init:)
		(= temp0 (if (and argc (!= param1 1)) param1 else global309))
		(if (not fixedPrice)
			(= price (proc109_0 temp0 basePrice))
		)
	)

	(method (doFormat param1)
		(if price
			(if (< price 100)
				(Format param1 104 1 text price) ; "%s $%d"
			else
				(Format param1 104 2 text price) ; "%s$%d"
			)
		else
			(super doFormat: param1)
		)
	)

	(method (doit &tmp temp0)
		(if (global502 aTimeClock:)
			((global502 aTimeClock:) cel: 0 setCycle: 0)
		)
		(if (= global416 (>= (proc0_11) price))
			(= global418 0)
			(switch typeOfGoods
				(1
					(= global418
						((global302 consumables:) recieve: indexNum units)
					)
				)
				(0
					(= global418
						((global302 durables:) recieve: indexNum units)
					)
				)
				(2
					(= global418
						((global302 education:) recieve: indexNum units)
					)
					(if
						(>=
							(global418 quantity:)
							(- (global418 unitsToGraduate:) (global302 xcred:))
						)
						(global418 quantity: (global418 unitsToGraduate:))
					)
				)
			)
			(if global418
				(global418 indexNum: indexNum)
				(if (not (& (global418 attributes:) $0038))
					(global418 pricePaid: price)
				)
			)
			(proc0_10 (* theSign price))
			(= temp0 (super doit:))
			(gCalc doit:)
			(if (and gItems (IsObject gItems) (< global534 2))
				(gItems doit: celNum)
			)
			(if (and gBoughtItem global427)
				(gBoughtItem doit: self)
			)
		else
			(= temp0 (super doit:))
			(if global413
				(global413 cel: 6)
			)
			(if global424
				(global424 doit:)
			)
		)
		(gTimeKeep doit: visitTime)
		(return temp0)
	)
)

(class Talker of DCIcon
	(properties
		nsTop 1
		nsLeft 115
		priority 14
		cycleSpeed 10
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(= temp0 (if global427 16 else 2))
		(if (and argc param1)
			(= temp0 param1)
		)
		(if (>= argc 2)
			(self ticksToDo: 0 cycleSpeed: 0 setCycle: param2 param3)
		)
		(if (and (>= argc 4) param4)
			(MouthSync caller: param4)
			(param4 cycles: 0 seconds: 0)
		)
	)

	(method (draw)
		(if (< global534 2)
			(super draw: &rest)
		)
	)

	(method (setCycle)
		(super setCycle: &rest)
	)

	(method (setSize)
		(if (< global534 2)
			(super setSize: &rest)
		)
	)

	(method (setCel param1)
		(= cel param1)
	)
)

(class TimeClock of DCIcon
	(properties
		view 750
		priority 14
		cycleSpeed 10
	)

	(method (doit)
		(self cel: 0 setCycle: FwdCount self 1)
		(gASoundEffect play: 31)
		(super doit:)
	)
)

