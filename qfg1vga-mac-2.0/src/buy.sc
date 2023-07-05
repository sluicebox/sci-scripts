;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 551)
(include sci.sh)
(use Main)
(use Interface)
(use Dialog)

(public
	buy 0
)

(local
	local0
)

(class Ware
	(properties
		price 0
	)

	(method (dispose)
		(DisposeClone self)
	)
)

(instance buy of Dialog
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(Platform 0 4 3 -1)
		(= local0 gTheCursor)
		(gGame setCursor: 999)
		(= temp0 (= temp1 4))
		(= temp3 0)
		(if (!= gCurRoomNum 65)
			((= global192 (DText new:))
				text: {You may buy:}
				setSize:
				moveTo: 4 temp1
			)
		else
			((= global192 (DText new:))
				text: {You may give:}
				setSize:
				moveTo: 4 temp1
			)
		)
		(self add: global192 setSize:)
		(+= temp1 (+ (- (global192 nsBottom:) (global192 nsTop:)) 1))
		(for
			((= temp5 (gList first:)))
			temp5
			((= temp5 (gList next: temp5)))
			
			(= temp6 (NodeValue temp5))
			(++ temp3)
			(self
				add:
					((= temp4 (DText new:))
						value: temp3
						text: (temp6 name:)
						nsLeft: temp0
						nsTop: temp1
						state: 3
						setSize:
						yourself:
					)
			)
			(if (!= gCurRoomNum 65)
				(self
					add:
						((DText new:)
							text: (temp6 price:)
							nsLeft: (+ temp0 120)
							nsTop: temp1
							setSize:
							yourself:
						)
				)
				(self
					add:
						((DText new:)
							text:
								(if (StrCmp (temp6 price:) {1})
									{Silvers}
								else
									{Silver}
								)
							nsLeft: (+ temp0 140)
							nsTop: temp1
							setSize:
							yourself:
						)
				)
			)
			(+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1))
		)
		(= window gSystemWindow)
		(self setSize:)
		(= global192 (DButton new:))
		(if (!= gCurRoomNum 65)
			(global192
				text: {Buy nothing}
				setSize:
				moveTo: (- nsRight (+ 4 (global192 nsRight:))) nsBottom
			)
		else
			(global192
				text: {Give nothing}
				setSize:
				moveTo: (- nsRight (+ 4 (global192 nsRight:))) nsBottom
			)
		)
		(global192 move: (- (global192 nsLeft:) (global192 nsRight:)) 0)
		(self add: global192 setSize: center:)
		(return temp3)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(self init:)
		(self open: 4 15)
		(= temp2 ((gInventory at: 0) amount:)) ; silver
		(= temp4 (/ ((gInventory at: 0) amount:) 10)) ; silver
		(= temp1 (* ((gInventory at: 38) amount:) 10)) ; gold
		(= temp0 global192)
		(= temp0 (super doit: temp0))
		(if (or (not (IsObject temp0)) (== temp0 global192))
			(self dispose: 0)
		else
			(= temp5
				(not
					(mod
						(= temp3
							(ReadNumber
								((gList at: (- (temp0 value:) 1)) price:)
							)
						)
						10
					)
				)
			)
			(cond
				((< (+ temp1 temp2) temp3)
					(self dispose: -1)
				)
				((== (+ temp1 temp2) temp3)
					((gInventory at: 0) amount: 0) ; silver
					((gInventory at: 38) amount: 0) ; gold
					(gEgo use: 0 0) ; silver
					(self dispose: (temp0 value:))
				)
				((> temp2 temp3)
					((gInventory at: 0) ; silver
						amount: (- ((gInventory at: 0) amount:) temp3) ; silver
					)
					(self dispose: (temp0 value:))
				)
				(temp4
					((gInventory at: 0) ; silver
						amount: (- ((gInventory at: 0) amount:) (* temp4 10)) ; silver
					)
					(-= temp3 (* temp4 10))
					((gInventory at: 38) ; gold
						amount:
							(-
								((gInventory at: 38) amount:) ; gold
								(+ (/ temp3 10) (if temp5 0 else 1))
							)
					)
					(if (not temp5)
						((gInventory at: 0) ; silver
							amount:
								(+
									((gInventory at: 0) amount:) ; silver
									(- 10 (mod temp3 10))
								)
						)
					)
					(cond
						(
							(and
								(== ((gInventory at: 0) amount:) 0) ; silver
								(== ((gInventory at: 38) amount:) 0) ; gold
							)
							(gEgo use: 0 0) ; silver
						)
						(
							(and
								(== ((gInventory at: 0) amount:) 0) ; silver
								(> ((gInventory at: 38) amount:) 0) ; gold
							)
							((gInventory at: 0) amount: 10) ; silver
							((gInventory at: 38) ; gold
								amount: (- ((gInventory at: 38) amount:) 1) ; gold
							)
						)
					)
					(self dispose: (temp0 value:))
				)
				(else
					((gInventory at: 38) ; gold
						amount:
							(-
								((gInventory at: 38) amount:) ; gold
								(+ (/ temp3 10) (if temp5 0 else 1))
							)
					)
					(if (not temp5)
						((gInventory at: 0) ; silver
							amount:
								(+
									((gInventory at: 0) amount:) ; silver
									(- 10 (mod temp3 10))
								)
						)
					)
					(cond
						(
							(and
								(== ((gInventory at: 0) amount:) 0) ; silver
								(== ((gInventory at: 38) amount:) 0) ; gold
							)
							(gEgo use: 0 0) ; silver
						)
						(
							(and
								(== ((gInventory at: 0) amount:) 0) ; silver
								(> ((gInventory at: 38) amount:) 0) ; gold
							)
							((gInventory at: 0) amount: 10) ; silver
							((gInventory at: 38) ; gold
								amount: (- ((gInventory at: 38) amount:) 1) ; gold
							)
						)
					)
					(self dispose: (temp0 value:))
				)
			)
		)
	)

	(method (dispose param1)
		(self eachElementDo: #dispose 1)
		(super dispose:)
		(gList dispose:)
		(gGame setCursor: local0)
		(Platform 0 4 2 -1)
		(return param1)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event message:))
		(switch (= temp1 (event type:))
			(evKEYBOARD
				(switch temp0
					(KEY_UP
						(= temp0 KEY_SHIFTTAB)
					)
					(KEY_DOWN
						(= temp0 KEY_TAB)
					)
				)
			)
			($0040 ; direction
				(switch temp0
					(JOY_UP
						(= temp0 KEY_SHIFTTAB)
						(= temp1 evKEYBOARD)
					)
					(JOY_DOWN
						(= temp0 KEY_TAB)
						(= temp1 evKEYBOARD)
					)
				)
			)
		)
		(event type: temp1 message: temp0)
		(super handleEvent: event)
	)
)

