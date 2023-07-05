;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 857)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(class GiveOrTakeIcon of DIcon
	(properties
		state 1
		client 0
		dialog 0
		theLastX 0
		theLastY 0
		theLastVal 0
	)

	(method (highlight)
		(return 1)
	)

	(method (track param1 &tmp temp0 temp1 temp2)
		(if (== evMOUSEBUTTON (param1 type:))
			(= temp1 0)
			(repeat
				(= param1 (Event new:))
				(= temp2 (param1 type:))
				(param1 localize:)
				(if (!= (= temp0 (self check: param1)) temp1)
					(self highlight:)
					(= temp1 temp0)
				)
				(param1 dispose:)
				(breakif (== temp2 evMOUSERELEASE))
			)
			(if temp0
				(self highlight:)
			)
			(return temp0)
		else
			(return self)
		)
	)

	(method (handleEvent event)
		(cond
			(
				(and
					(or
						(== (event type:) evJOYDOWN)
						(and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					)
					(self check: event)
				)
				(event claimed: 1)
				1
			)
			((== (event type:) evMOUSEBUTTON)
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doit)
		(client get: self)
	)

	(method (draw &tmp temp0 temp1 temp2 temp3 [temp4 10] [temp14 10] [temp24 4])
		(super draw: &rest)
		(= temp0 (== self (client giver:)))
		(= temp1 ((dialog client:) font:))
		(= temp2
			(if temp0
				((dialog client:) color:)
			else
				((dialog window:) color:)
			)
		)
		(if temp0
			(Format @temp4 {%d} (client taken:))
			(TextSize @temp24 @temp4 temp1)
			(= temp3 (+ nsRight 5))
		else
			(Format @temp4 {%d} (client number:))
			(TextSize @temp24 @temp4 temp1)
			(= temp3 (- (- nsLeft [temp24 2]) 5))
		)
		(Format @temp14 {%d} theLastVal)
		(Display
			@temp14
			dsCOLOR
			((dialog window:) back:)
			dsFONT
			temp1
			dsCOORD
			theLastX
			theLastY
		)
		(Display
			@temp4
			dsCOLOR
			temp2
			dsFONT
			temp1
			dsCOORD
			(= theLastX temp3)
			(= theLastY (/ (- (+ nsBottom nsTop) [temp24 3]) 2))
		)
		(= theLastVal
			(if temp0
				(client taken:)
			else
				(client number:)
			)
		)
	)
)

(instance keepButton of DButton
	(properties)
)

(instance giveButton of DButton
	(properties
		value 1
	)
)

(class MoneyDialog of Dialog
	(properties
		margin 30
		taker 0
		giver 0
		client 0
	)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= client param1)
		(= window (or (client window:) gSystemWindow))
		(if text
			(window title: text)
		else
			(= text (window title:))
		)
		(= temp6 (param1 font:))
		(= temp2 (param1 view:))
		(= temp3 (param1 loop:))
		(= temp0 0)
		(for
			((= temp7 10))
			(= temp1 (param1 at: temp0))
			((= temp7 (+ 15 (temp1 nsBottom:))))
			
			((= temp4 (GiveOrTakeIcon new:))
				dialog: self
				client: temp1
				view: temp2
				loop: temp3
				cel: 0
				setSize:
				moveTo: margin temp7
			)
			(temp1
				state: 0
				view: temp2
				loop: temp3
				cel: (+ temp0 2)
				setSize:
				moveTo: (+ 5 (temp4 nsRight:)) temp7
				taker: temp4
				giver: (= temp5 (Clone temp4))
				taken: 0
			)
			(temp5 cel: 1 setSize: moveTo: (+ 5 (temp1 nsRight:)) temp7)
			(self add: temp4 temp1 temp5)
			(++ temp0)
		)
		(keepButton font: temp6 text: (param1 keepStr:) setSize:)
		(keepButton
			moveTo:
				(-
					(/ (+ (temp4 nsLeft:) (temp4 nsRight:)) 2)
					(/ (keepButton nsRight:) 2)
				)
				temp7
		)
		(giveButton font: temp6 text: (param1 giveStr:) setSize:)
		(giveButton
			moveTo:
				(-
					(/ (+ (temp5 nsLeft:) (temp5 nsRight:)) 2)
					(/ (giveButton nsRight:) 2)
				)
				temp7
		)
		(self add: keepButton giveButton setSize:)
		(self nsRight: (+ margin nsRight) center:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= temp3
			(or (client cursor:) ((gInventory at: (client number:)) cursor:) 999)
		)
		(= temp1 (gGame setCursor: temp3))
		(self open: 4 -1)
		(self eachElementDo: #select)
		(= temp0 (super doit: &rest))
		(if (IsObject temp0)
			(= temp0 (temp0 value:))
		)
		(if (not temp0)
			(client put:)
		)
		(if (client value:)
			(gGame setCursor: temp1)
		else
			(gTheIconBar curIcon: (= temp2 (gTheIconBar at: 0)))
			(gGame setCursor: (temp2 cursor:))
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 857)
	)
)

