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
)

(class Inv of Set
	(properties
		carrying {You are carrying:}
		empty {You are carrying nothing!}
	)

	(method (init)
		(= gInventory self)
	)

	(method (saidMe param1)
		(self firstTrue: #saidMe param1)
	)

	(method (ownedBy whom)
		(self firstTrue: #ownedBy whom)
	)

	(method (showSelf whom &tmp temp0 temp1 temp2 [temp3 601] temp604 temp605)
		(StrCpy @temp3 carrying)
		(= temp2 (= temp1 0))
		(= temp0 0)
		(for
			((= temp604 (gInventory first:)))
			temp604
			((= temp604 (gInventory next: temp604)))
			
			(= temp605 (NodeValue temp604))
			(if (temp605 ownedBy: whom)
				(if temp1
					(StrCat @temp3 {...})
					(Print @temp3)
					(StrCpy @temp3 {...})
					(= temp1 0)
					(= temp0 0)
				)
				(if temp0
					(StrCat @temp3 {, })
				)
				(StrCat @temp3 (temp605 name:))
				(if (> (++ temp0) 15)
					(= temp2 (= temp1 1))
				)
			)
		)
		(cond
			(temp0
				(StrCat @temp3 {.})
				(Print @temp3)
			)
			((not temp2)
				(Print empty)
			)
		)
	)
)

