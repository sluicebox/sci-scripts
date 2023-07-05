;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 131)
(include sci.sh)
(use Main)
(use Interface)
(use bordWindow)
(use Save)

(public
	proc131_0 0
)

(local
	local0
)

(procedure (proc131_0 param1)
	(invD doit: param1)
)

(instance invD of Dialog
	(properties
		text { You are carrying: }
	)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp7 (= temp3 0))
		(for
			((= temp5 (gInventory first:)))
			temp5
			((= temp5 (gInventory next: temp5)))
			
			(= temp6 (NodeValue temp5))
			(++ temp7)
			(if (and (temp6 ownedBy: param1) (> temp7 2))
				(++ temp3)
				(self
					add:
						((= temp4 (DText new:))
							value: temp6
							text: (temp6 name:)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: 1
							setSize:
							yourself:
						)
				)
				(if (< temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
					(= temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
				)
				(if (> (+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1)) 70)
					(= temp1 4)
					(+= temp0 (+ temp2 10))
					(= temp2 0)
				)
			)
		)
		(if (not temp3)
			(return 0)
		)
		(= window SysWindow)
		(self setSize:)
		(= local0 (DButton new:))
		(local0
			text: {OK}
			setSize:
			moveTo: (- nsRight (+ 4 (local0 nsRight:))) nsBottom
		)
		(local0 move: (- (local0 nsLeft:) (local0 nsRight:)) 0)
		(self add: local0 setSize: center:)
		(return temp3)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 131)
	)

	(method (doit param1 &tmp temp0)
		(if (not (self init: param1))
			(Print (gInventory empty:) #window bordWindow)
			(self dispose:)
			(return)
		)
		(self open: 4 15)
		(= temp0 local0)
		(repeat
			(if
				(or
					(not (= temp0 (super doit: temp0)))
					(== temp0 -1)
					(== temp0 local0)
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

