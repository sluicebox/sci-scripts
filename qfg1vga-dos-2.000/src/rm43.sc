;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Game)
(use System)

(public
	rm43 0
)

(instance rm43 of EncRoom
	(properties
		picture 705
		style 8
		encChance 20
		entrances 12
	)

	(method (dispose)
		(SetFlag 33)
		(super dispose:)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(SL enable:)
		(NormalEgo)
		(if
			(not
				(OneOf gPrevRoomNum 420 425 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global103 (gEgo x:))
			(= global104 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)

	(method (doVerb theVerb)
		((ScriptID 804 0) doVerb: theVerb &rest) ; forestRegion
	)
)

