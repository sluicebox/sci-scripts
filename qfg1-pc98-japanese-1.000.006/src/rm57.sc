;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm57 0
)

(instance rm57 of EncRoom
	(properties
		picture 702
		style 8
		horizon 90
		north 43
		east 58
		south 67
		west 56
		encChance 15
	)

	(method (dispose)
		(SetFlag 47)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 702)
		(gContMusic stop:)
		(super init:)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(58
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(56
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(43
				(gEgo posn: 130 92 setMotion: MoveTo 130 190)
			)
			(67
				(gEgo posn: 120 188 setMotion: MoveTo 120 0)
			)
		)
		(gAddToPics add: snow1 snow2 snow5 snow6 snow7 eachElementDo: #init doit:)
		(snow3 setPri: 15 ignoreActors: init: addToPic:)
		(snow4 setPri: 1 ignoreActors: init: addToPic:)
		(if
			(not
				(OneOf gPrevRoomNum 420 425 430 435 440 445 455 450 460 465 470) ; bearArena, minotaurArena, saurusArena, mantrayArena, cheetaurArena, goblinArena, ogreArena, trollArena, dragonArena, brigandArena
			)
			(= global105 (gEgo x:))
			(= global106 (gEgo y:))
		)
		(self setRegions: 210) ; Encounter
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(if (and (Said 'look,look>') (Said '/ice'))
					(HighPrint 57 0) ; "You see snow and feel a cold wind blowing from the east."
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance snow1 of PV
	(properties
		y 40
		x 263
		view 702
		priority 15
	)
)

(instance snow2 of PV
	(properties
		y 76
		x 256
		view 702
		loop 1
		priority 15
	)
)

(instance snow3 of View
	(properties
		y 134
		x 268
		view 702
		loop 2
	)
)

(instance snow4 of View
	(properties
		y 125
		x 284
		view 702
		loop 3
	)
)

(instance snow5 of PV
	(properties
		y 26
		x 185
		view 702
		loop 4
		priority 15
	)
)

(instance snow6 of PV
	(properties
		y 44
		x 179
		view 702
		loop 4
		cel 1
		priority 15
	)
)

(instance snow7 of PV
	(properties
		y 83
		x 194
		view 702
		loop 5
	)
)

