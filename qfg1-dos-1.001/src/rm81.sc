;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 81)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm81 0
)

(instance rm81 of EncRoom
	(properties
		picture 703
		style 8
		horizon 80
		north 74
		east 82
		south 87
		west 80
		encChance 20
	)

	(method (dispose)
		(SetFlag 71)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(hollowLog init: stopUpd:)
		(switch gPrevRoomNum
			(74
				(gEgo posn: 190 92 setMotion: MoveTo 190 190)
			)
			(82
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(80
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(87
				(gEgo posn: 200 188 setMotion: MoveTo 200 0)
			)
		)
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
				(cond
					((Said 'look[<around,at][/forest,area]')
						(HighPrint 81 0) ; "There is a roaring sound off to the east."
					)
					((or (MouseClaimed hollowLog event 3) (Said 'look/log'))
						(HighPrint 81 1) ; "The hollow log looks somberly back with it's single giant eye and you know at once that nothing is to be gained by investigating this gaunt relic of a more vertical past."
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance hollowLog of View
	(properties
		y 91
		x 281
		view 181
	)
)

