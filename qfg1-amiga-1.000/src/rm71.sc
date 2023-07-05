;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm71 0
)

(instance rm71 of EncRoom
	(properties
		picture 703
		style 8
		horizon 90
		north 63
		east 72
		south 78
		west 70
		encChance 15
	)

	(method (dispose)
		(SetFlag 61)
		(super dispose:)
	)

	(method (init)
		(if (and gNight (== gPrevRoomNum 70))
			(Load rsSCRIPT 295)
		)
		(super init:)
		(SL enable:)
		(self setLocales: 804)
		(NormalEgo)
		(if (not global332)
			(gEgo init:)
		)
		(switch gPrevRoomNum
			(63
				(gEgo posn: 190 92 setMotion: MoveTo 190 190)
			)
			(72
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(70
				(gEgo posn: 1 140 setMotion: MoveTo 50 140)
				(if (IsFlag 188)
					(User canControl: 0)
					(User canInput: 0)
					(ClearFlag 188)
					(self setScript: (ScriptID 295 0)) ; byebye
				)
			)
			(78
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
)

