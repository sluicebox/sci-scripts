;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use GloryRm)
(use Interface)

(public
	rm4 0
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4)
	((ScriptID 7 4) init: 8) ; fixTime
	(if (FileIO fiEXISTS {18.scr})
		(= temp1 (GetNumber {Which room? (0 = continue):}))
	else
		(= temp1 0)
	)
	(if temp1
		(if (!= temp1 140)
			(= temp2 200)
			(for ((= temp3 0)) (< temp3 20) ((++ temp3))
				(= [gEgoStats temp3] temp2)
			)
			(= [gEgoStats 16] 1900) ; experience
			(= [gEgoStats 17] (gEgo maxHealth:)) ; health
			(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
			(= [gEgoStats 19] (gEgo maxMana:)) ; mana
			(for ((= temp4 0)) (< temp4 22) ((++ temp4))
				(= [gEgoStats (+ 20 temp4)] temp2)
			)
			(= global394 1)
			(SetFlag 20)
			((gInventory at: 18) state: 1) ; theShield
			((gInventory at: 19) state: 1) ; theSword
			(proc0_18 17)
			(proc0_18 18)
			(proc0_18 19)
		)
		(ClearFlag 51)
		(gCurRoom newRoom: temp1)
	else
		(gEgo setSpeed: global433)
		(gCurRoom newRoom: 100)
	)
)

(instance rm4 of GloryRm
	(properties)

	(method (init)
		(SetFlag 6)
		(super init:)
		(localproc_0)
	)
)

