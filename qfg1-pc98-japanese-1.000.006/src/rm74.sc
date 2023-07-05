;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 74)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm74 0
)

(instance rm74 of EncRoom
	(properties
		picture 700
		style 8
		horizon 90
		north 65
		east 75
		south 81
		west 73
		encChance 15
		ambushX 100
		ambushY 120
	)

	(method (dispose)
		(SetFlag 64)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 240)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(65
				(gEgo posn: 140 92 setMotion: MoveTo 140 190)
			)
			(73
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(81
				(gEgo posn: 160 188 setMotion: MoveTo 160 0)
			)
			(75
				(gEgo posn: 318 140 setMotion: MoveTo 0 120)
			)
		)
		(eyes setPri: 5 init: stopUpd: setScript: peekABooScript)
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
				(if (Said 'look,look/eye')
					(HighPrint 74 0) ; "For a moment there, you thought you saw something. But nothing is there now."
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance peekABooScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 6 25))
			)
			(1
				(eyes setCycle: End self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance eyes of Prop
	(properties
		y 67
		x 305
		view 240
		cycleSpeed 1
	)
)

