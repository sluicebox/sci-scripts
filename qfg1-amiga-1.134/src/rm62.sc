;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use Encounter)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm62 0
)

(instance rm62 of EncRoom
	(properties
		picture 702
		style 8
		horizon 90
		north 45
		east 63
		south 70
		west 61
		encChance 15
	)

	(method (dispose)
		(SetFlag 52)
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
			(45
				(gEgo posn: 130 92 setMotion: MoveTo 130 190)
			)
			(63
				(gEgo posn: 318 140 setMotion: MoveTo 0 140)
			)
			(61
				(gEgo posn: 1 140 setMotion: MoveTo 320 140)
			)
			(70
				(gEgo posn: 120 188 setMotion: MoveTo 120 175)
				(if (IsFlag 188)
					(ClearFlag 188)
					(User canControl: 0)
					(User canInput: 0)
					(self setScript: (ScriptID 295 0)) ; byebye
				)
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

