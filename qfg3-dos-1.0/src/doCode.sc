;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use GloryWindow)
(use System)

(public
	doCode 0
	useCode 1
)

(instance aChestWindow of GloryWindow
	(properties
		color 5
		back 2
		yOffset 28
	)

	(method (open)
		((ScriptID 16 2) nsLeft: (- (/ (- (self right:) (self left:)) 2) 60)) ; invLook
		(+= bottom 4)
		(super open:)
	)
)

(instance doCode of Code
	(properties)

	(method (init &tmp temp0 temp1 temp2)
		(= temp1 0)
		(= temp2
			(cond
				((== gCurRoomNum 310) 0)
				((== gCurRoomNum 430) 14)
				(else 14)
			)
		)
		(for ((= temp0 0)) (< temp0 14) ((++ temp0))
			(if [global331 (+ temp0 temp2)]
				((gInventory at: (+ temp0 10)) realOwner: (ScriptID gCurRoomNum 0))
				(= temp1 1)
			)
		)
		(for ((= temp0 0)) (< temp0 47) ((++ temp0))
			(if (== ((gInventory at: temp0) realOwner:) gCurRoomNum)
				((gInventory at: temp0) realOwner: (ScriptID gCurRoomNum 0))
				(= temp1 1)
			)
		)
		(if temp1
			(gInventory window: aChestWindow)
			((ScriptID 16 1) init: (ScriptID gCurRoomNum 0)) ; pageCode
			(for ((= temp0 0)) (< temp0 47) ((++ temp0))
				(if (== ((gInventory at: temp0) realOwner:) (ScriptID gCurRoomNum 0))
					((gInventory at: temp0) realOwner: gCurRoomNum)
				)
				(if ((gInventory at: temp0) amount:)
					((gInventory at: temp0) realOwner: gEgo)
				)
			)
		else
			(gMessager say: 1 6 1 1 0 29) ; "The chest is empty."
		)
	)
)

(instance useCode of Code
	(properties)

	(method (init param1 param2 param3)
		(cond
			((or (not param1) (== param1 48))
				(gMessager say: 1 6 2 1 0 29) ; "Don't tempt the maid service!"
			)
			((and ((gInventory at: param1) mustKeep:) (!= param1 46))
				(gMessager say: 1 6 3 1 0 29) ; "That's safest left with you, hero."
			)
			((or (< param1 10) (>= param1 24))
				((gInventory at: param1) loseItem: roomGets:)
				(gMessager say: 1 6 4 1 0 29) ; "You put it in the chest."
				(gTheIconBar curInvIcon: 0)
			)
			(else
				(= param3
					(cond
						((== gCurRoomNum 310) 0)
						((== gCurRoomNum 430) 14)
						(else 14)
					)
				)
				((gInventory at: param1) roomGets:)
				((gInventory at: param1)
					amount: (- ((gInventory at: param1) amount:) 1)
				)
				(if (> ((gInventory at: param1) amount:) 0)
					(gMessager say: 1 6 5 1 0 29) ; "You put one into the chest."
				else
					((gInventory at: param1) loseItem:)
					(gTheIconBar curInvIcon: 0)
					(gMessager say: 1 6 4 1 0 29) ; "You put it in the chest."
				)
			)
		)
	)
)

