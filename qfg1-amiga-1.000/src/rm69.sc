;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 69)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm69 0
)

(instance rm69 of EncRoom
	(properties
		picture 701
		style 8
		horizon 90
		north 61
		east 70
		encChance 20
		entrances 3
		illBits -20480
	)

	(method (dispose)
		(SetFlag 59)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 700)
		(if (and gNight (== gPrevRoomNum 70))
			(Load rsSCRIPT 295)
		)
		(super init:)
		(self setLocales: 804)
		(SL enable:)
		(NormalEgo)
		(if (not global332)
			(gEgo illegalBits: -24576 init:)
		)
		(switch gPrevRoomNum
			(70
				(gEgo posn: 318 140 setMotion: MoveTo 265 140)
				(if (IsFlag 188)
					(User canControl: 0)
					(User canInput: 0)
					(ClearFlag 188)
					(self setScript: (ScriptID 295 0)) ; byebye
				)
			)
			(61
				(gEgo posn: 180 92 setMotion: MoveTo 180 190)
			)
		)
		(southBush init:)
		(gAddToPics add: southBush doit:)
		(westBush ignoreActors: setPri: 7 init: addToPic:)
		(if
			(not
				(OneOf gPrevRoomNum 420 425 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global105 (gEgo x:))
			(= global106 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)
)

(instance southBush of PV
	(properties
		y 207
		x 158
		view 700
		loop 2
		cel 1
		priority 15
	)
)

(instance westBush of View
	(properties
		y 173
		x 30
		view 700
	)
)

