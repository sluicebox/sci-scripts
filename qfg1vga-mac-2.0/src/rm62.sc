;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use Encounter)
(use n814)
(use PolyPath)
(use Game)
(use System)

(public
	rm62 0
)

(instance rm62 of EncRoom
	(properties
		picture 702
		style 8
		horizon 55
		encChance 15
	)

	(method (dispose)
		(SetFlag 52)
		(DisposeScript 295)
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
		(if (and gNight (== gPrevRoomNum 170) (IsFlag 188))
			(HandsOff)
			(gEgo setScript: fairyWalkIn)
			(Load rsSCRIPT 295)
			(ClearFlag 188)
			(self setScript: (ScriptID 295 0)) ; byebye
			(self encChance: 0)
		)
		(self setRegions: 210) ; Encounter
	)
)

(instance fairyWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 90)
			)
			(1
				(HandsOff)
				(gEgo setMotion: PolyPath 160 110 self)
			)
			(2
				(gEgo loop: 2)
				(self dispose:)
			)
		)
	)
)

