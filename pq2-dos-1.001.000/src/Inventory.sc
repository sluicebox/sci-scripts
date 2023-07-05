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

	(method (showSelf whom &tmp temp0 [temp1 30] [temp31 251] temp282 temp283)
		(StrCpy @temp31 carrying)
		(= temp0 0)
		(for
			((= temp282 (gInventory first:)))
			temp282
			((= temp282 (gInventory next: temp282)))
			
			(= temp283 (NodeValue temp282))
			(if (temp283 ownedBy: whom)
				(if temp0
					(StrCat @temp31 {,})
				)
				(++ temp0)
				(StrCat @temp31 (Format @temp1 995 0 (temp283 name:))) ; "%s"
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

