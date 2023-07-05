;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 211)
(include sci.sh)
(use Main)
(use StatusBar)
(use SkilledActor)
(use Monster)
(use Game)
(use Actor)

(class Arena of Rm
	(properties
		style 6
		monster 0
		inTransit 0
		escaped 0
	)

	(method (init)
		(gAddToPics add:)
		(Load rsSCRIPT 213)
		(Load rsSCRIPT 425)
		Monster
		StatusBar
		SkilledActor
		(Load rsSCRIPT 215)
		(Load rsSCRIPT 155)
		(super init: &rest)
		(ClearFlag 285)
		(ClearFlag 129)
		(statusBackEgo init:)
		(statusBackMon init:)
		(gAddToPics add: statusBackEgo doit:)
		(gAddToPics add: statusBackMon doit:)
		((ScriptID 213 0) ; warrior
			view: 109
			init:
			stopUpd:
			opponent: monster
			drawStatus:
			startCombat: 215
		)
	)

	(method (doit)
		(cond
			(inTransit
				(super doit:)
			)
			(escaped
				(= global280 (monster health:))
				(= inTransit 1)
				(gCurRoom newRoom: gPrevRoomNum)
			)
			(
				(and
					(<= (monster health:) 0)
					(IsObject (ScriptID 213 0)) ; warrior
					((ScriptID 213 0) script:) ; warrior
					(not (((ScriptID 213 0) script:) script:)) ; warrior
					(!= global279 465)
					(!= global279 445)
					(!= global279 420)
				)
				(= inTransit 1)
				(= global280 0)
				(Animate (gCast elements:) 0)
				(gCurRoom newRoom: gPrevRoomNum)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (dispose)
		(DisposeScript 425)
		(DisposeScript 212)
		(DisposeScript 155)
		(DisposeScript 213)
		(DisposeScript 214)
		(DisposeScript 205)
		(DisposeScript 215)
		(SetFlag 129)
		(gUser canInput: 1)
		(statusBackEgo dispose:)
		(statusBackMon dispose:)
		(super dispose: &rest)
		(DisposeScript 211)
	)
)

(instance statusBackEgo of View
	(properties
		x 9
		y 7
		view 803
		cel 1
	)
)

(instance statusBackMon of View
	(properties
		x 232
		y 6
		view 803
	)
)

