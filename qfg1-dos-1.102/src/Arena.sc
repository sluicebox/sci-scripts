;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use LoadMany)
(use Game)

(class Arena of Rm
	(properties
		style 6
		monster 0
		inTransit 0
		escaped 0
	)

	(method (init)
		(Load rsSCRIPT 213)
		(Load rsSCRIPT 205)
		(LoadMany rsVIEW global302 540 535)
		(super init:)
		(SL enable:)
		(ClearFlag 129)
		(= global305 1)
		((ScriptID 213 0) ; warrior
			init:
			stopUpd:
			weaponView: (if (gEgo has: 6) 540 else 535) ; blade
			opponent: monster
			drawStatus:
			startCombat: 215
		)
		(monster init: drawStatus:)
	)

	(method (doit)
		(cond
			(inTransit
				(super doit:)
			)
			(escaped
				(= global333 (monster health:))
				(= inTransit 1)
				(monster dispose:)
				((ScriptID 213 0) dispose:) ; warrior
				(gCurRoom newRoom: gPrevRoomNum)
			)
			((<= (monster health:) 0)
				(= global264 0)
				(= global333 0)
				(= inTransit 1)
				(Animate (gCast elements:) 0)
				(monster dispose:)
				((ScriptID 213 0) dispose:) ; warrior
				(gCurRoom newRoom: gPrevRoomNum)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (dispose)
		(SetFlag 129)
		(super dispose:)
	)
)

