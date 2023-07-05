;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use Game)
(use Actor)
(use System)

(public
	rm57 0
)

(instance rm57 of EncRoom
	(properties
		picture 703
		style 8
		horizon 54
		encChance 15
	)

	(method (dispose)
		(SetFlag 47)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 702)
		(gLongSong stop:)
		(self setRegions: 804) ; forestRegion
		(super init:)
		(SL enable:)
		(NormalEgo)
		(snow2 ignoreActors: addToPic:)
		(snow3 ignoreActors: addToPic:)
		(snow4 ignoreActors: addToPic:)
		(snow5 ignoreActors: addToPic:)
		(snow6 ignoreActors: addToPic:)
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

(instance snow2 of View
	(properties
		x 292
		y 37
		noun 1
		view 702
		loop 1
		signal 16
	)
)

(instance snow3 of View
	(properties
		x 240
		y 44
		noun 1
		view 702
		loop 2
		signal 16
	)
)

(instance snow4 of View
	(properties
		x 235
		y 95
		noun 1
		view 702
		loop 3
		signal 16
	)
)

(instance snow5 of View
	(properties
		x 259
		y 128
		noun 1
		view 702
		loop 4
		signal 16400
	)
)

(instance snow6 of View
	(properties
		x 315
		y 94
		noun 1
		view 702
		loop 5
		signal 16
	)
)

