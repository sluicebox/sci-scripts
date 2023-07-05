;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(class InvI of Obj
	(properties
		said 0
		description 0
		owner 0
		view 0
		loop 0
		cel 0
		script 0
		value 0
	)

	(method (saidMe)
		(Said said)
	)

	(method (ownedBy id)
		(return (== owner id))
	)

	(method (moveTo id)
		(if (and (== (= owner id) gEgo) value)
			(gGame changeScore: value)
			(= value 0)
		)
		(return self)
	)

	(method (showSelf)
		(Print (+ global101 612) (gInventory indexOf: self) #icon view loop cel)
	)

	(method (changeState newState)
		(if script
			(script changeState: newState)
		)
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

	(method (saidMe)
		(self firstTrue: #saidMe)
	)

	(method (ownedBy whom)
		(self firstTrue: #ownedBy whom)
	)

	(method (showSelf whom)
		((ScriptID 829 0) text: carrying doit: whom) ; invD
	)
)

