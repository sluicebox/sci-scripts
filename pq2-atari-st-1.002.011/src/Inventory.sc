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

	(method (showSelf whom &tmp temp0 [temp1 30] [temp31 301] temp332 temp333)
		(StrCpy @temp31 carrying)
		(= temp0 0)
		(for
			((= temp332 (gInventory first:)))
			temp332
			((= temp332 (gInventory next: temp332)))
			
			(= temp333 (NodeValue temp332))
			(if (temp333 ownedBy: whom)
				(if temp0
					(StrCat @temp31 {,})
				)
				(++ temp0)
				(StrCat @temp31 (Format @temp1 995 0 (temp333 name:))) ; "%s"
			)
		)
		(if temp0
			(StrCat @temp31 {.})
			(Print @temp31)
		else
			(Print empty)
		)
	)
)

