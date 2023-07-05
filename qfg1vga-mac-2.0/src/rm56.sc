;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Game)
(use System)

(public
	rm56 0
)

(instance rm56 of EncRoom
	(properties
		picture 701
		style 8
		horizon 54
		encChance 15
		entrances 7
	)

	(method (dispose)
		(SetFlag 46)
		(super dispose:)
	)

	(method (doVerb)
		(return 0)
	)

	(method (init)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(SL enable:)
		(NormalEgo)
		(if
			(not
				(OneOf gPrevRoomNum 420 480 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global103 (gEgo x:))
			(= global104 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)
)

