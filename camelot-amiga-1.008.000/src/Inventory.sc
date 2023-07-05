;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use n131)
(use Interface)
(use bordWindow)
(use System)

(class InvI of Obj
	(properties
		said 0
		view 0
		cel 0
		owner 0
		number 0
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
		(if view
			(Print 995 0 #icon view 0 cel #window bordWindow)
		)
	)
)

(class Inv of Set
	(properties
		carrying {You carry with you:\n}
		empty {What you see upon your person is what you have. You carry nothing else at present.}
	)

	(method (init)
		(= gInventory self)
	)

	(method (saidMe param1)
		(self firstTrue: #saidMe param1)
	)

	(method (showSelf whom)
		(proc131_0 whom)
	)
)

