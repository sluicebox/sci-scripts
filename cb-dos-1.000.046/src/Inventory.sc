;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(local
	yesI
)

(class InvI of Obj
	(properties
		said 0
		description 0
		owner 0
		view 0
		loop 0
		cel 0
		script 0
	)

	(method (saidMe)
		(Said said)
	)

	(method (ownedBy id)
		(return (== owner id))
	)

	(method (moveTo id)
		(= owner id)
		(return self)
	)

	(method (showSelf)
		(ShowView (if description description else name) view loop cel)
	)

	(method (changeState newState)
		(if script
			(script changeState: newState)
		)
	)
)

(class Inv of Set
	(properties
		carrying {}
		empty {You are carrying nothing!}
	)

	(method (init)
		(= gInventory self)
	)

	(method (saidMe)
		(self firstTrue: #saidMe)
	)

	(method (ownedBy whom)
		(self firstTrue: #ownedBy whom)
	)

	(method (showSelf whom)
		(invD text: carrying doit: whom)
	)
)

(instance invD of Dialog
	(properties)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(for
			((= temp5 (gInventory first:)))
			temp5
			((= temp5 (gInventory next: temp5)))
			
			(= temp6 (NodeValue temp5))
			(if (temp6 ownedBy: param1)
				(++ temp3)
				(self
					add:
						((= temp4 (DText new:))
							value: temp6
							text: (temp6 name:)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: gSmallFont
							setSize:
							yourself:
						)
				)
				(if (< temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
					(= temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
				)
				(if
					(>
						(+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1))
						140
					)
					(= temp1 4)
					(+= temp0 (+ temp2 10))
					(= temp2 0)
				)
			)
		)
		(if (not temp3)
			(self dispose:)
			(return 0)
		)
		(= window gMyWindow)
		(self setSize:)
		(= yesI (DButton new:))
		(yesI
			text: {OK}
			setSize:
			moveTo: (- nsRight (+ 4 (yesI nsRight:))) nsBottom
		)
		(yesI move: (- (yesI nsLeft:) (yesI nsRight:)) 0)
		(self add: yesI setSize: center:)
		(return temp3)
	)

	(method (doit param1 &tmp temp0)
		(if (not (self init: param1))
			(Print (gInventory empty:))
			(return)
		)
		(self open: 4 15)
		(= temp0 yesI)
		(repeat
			(if
				(or
					(not (= temp0 (super doit: temp0)))
					(== temp0 -1)
					(== temp0 yesI)
				)
				(break)
			)
			((temp0 value:) showSelf:)
		)
		(self dispose:)
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

