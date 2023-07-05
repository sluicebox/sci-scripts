;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use System)

(public
	sEnter 0
	sGiveMsg 1
	sShowRunes 2
	sGetTheBush 3
	sFetchBonsai 4
)

(local
	local0
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch gPrevRoomNum
					(790
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 25)
								(gEgo y:)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 25)
								(gEgo y:)
								self
						)
					)
				)
			)
			(1
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveMsg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(self dispose:)
				else
					(= local0 1)
					(self cue:)
				)
			)
			(1
				(gMessager say: 15 6 4 0 self) ; "The path is dripping with slimy goo. You're having a hard time maintaining your footing on it."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sShowRunes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 152 162 self)
			)
			(1
				((ScriptID 800 1) init: approachVerbs: 43 setCycle: End self) ; pSquid, theDarksign
			)
			(2
				(gMessager say: 4 60 0 0 self) ; "When you bring the Will o' Wisp near the standing stone, glowing runes appear around a six-pointed image. In the center of the runes you can now see a small hole in the stone."
			)
			(3
				((ScriptID 800 1) ; pSquid
					view: 804
					setLoop: 6 1
					setCel: 0
					x: 168
					y: 179
					z: 30
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetTheBush of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 148 169 self)
			)
			(1
				(gEgo
					view: 4
					setLoop: 0 1
					setCel: 0
					posn: 141 169
					setCycle: CT 4 1 self
				)
			)
			(2
				((ScriptID 800 2) hide: dispose:) ; aBush
				(= seconds 1)
			)
			(3
				(gEgo setCel: 4 setCycle: CT 0 -1 self)
			)
			(4
				(SetFlag 335)
				(gEgo solvePuzzle: 415 15 get: 48 normalize:) ; theBonsai
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFetchBonsai of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 27) ; fetchSpell
				(if (IsFlag 353)
					((ScriptID 800 2) hide:) ; aBush
					(gEgo solvePuzzle: 415 15)
				)
				(self cue:)
			)
			(1
				(if (IsFlag 353)
					(gMessager say: 15 6 43 0 self) ; "Your magical lasso encircles the bonsai bush, and gently draws it out of the grimy goo. You carefully clean the plant, then put it away."
				else
					(gMessager say: 15 6 35 0 self) ; "The bush seems to be stuck; it looks as though it is caught in the rocks."
				)
			)
			(2
				(if (IsFlag 353)
					(gEgo get: 48) ; theBonsai
					((ScriptID 800 2) dispose:) ; aBush
					(SetFlag 335)
					(= seconds 1)
				else
					(self dispose:)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

