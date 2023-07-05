;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Game)
(use Actor)
(use System)

(public
	rm12 0
)

(instance rm12 of EncRoom
	(properties
		picture 700
		style 8
		horizon 43
		encChance 30
		entrances 6
		illBits -28672
	)

	(method (init)
		(Load rsVIEW 700)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(SL enable:)
		(NormalEgo)
		(southBush addToPic:)
		(southBush2 addToPic:)
		(if
			(not
				(OneOf gPrevRoomNum 420 425 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global103 (gEgo x:))
			(= global104 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)

	(method (dispose)
		(SetFlag 2)
		(super dispose:)
	)
)

(instance southBush of View
	(properties
		x 126
		y 165
		noun 1
		view 700
		loop 1
		priority 15
		signal 16
	)
)

(instance southBush2 of View
	(properties
		x 46
		y 167
		noun 1
		view 700
		loop 1
		priority 15
		signal 16
	)
)

