;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use System)

(public
	LockerScript 0
)

(local
	[local0 50]
	[local50 50]
	[local100 50]
	[local150 30]
	[local180 30]
	[local210 30]
	[local240 30]
	[local270 30]
	[local300 30]
)

(instance LockerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (TestFlag 44)
					(self cue:)
				else
					(gGame changeScore: 65)
					(Print 45 0 #icon 9 0 1) ; "Well, well. Look at this! Suzi wrote her locker number plus some words on the back of her spa keycard."
					(= seconds 2)
				)
			)
			(1
				(if (TestFlag 44)
					(Format @local0 45 1 46 gLockerCombination1) ; "%s"
					(Format @local50 45 1 46 gLockerCombination2) ; "%s"
					(Format @local100 45 1 46 gLockerCombination3) ; "%s"
				else
					(Format @local0 45 1 46 (= gLockerCombination1 0)) ; "%s"
					(while (== 32 (StrAt @local0 0))
						(= gLockerCombination1 (Random 1 24))
						(Format @local0 45 1 46 gLockerCombination1) ; "%s"
					)
					(= gLockerCombination2 gLockerCombination1)
					(while
						(or (== gLockerCombination1 gLockerCombination2) (== 32 (StrAt @local50 0)))
						(= gLockerCombination2 (Random 1 24))
						(Format @local50 45 1 46 gLockerCombination2) ; "%s"
					)
					(= gLockerCombination3 gLockerCombination1)
					(while
						(or
							(== gLockerCombination1 gLockerCombination3)
							(== gLockerCombination2 gLockerCombination3)
							(== 32 (StrAt @local100 0))
						)
						(= gLockerCombination3 (Random 1 24))
						(Format @local100 45 1 46 gLockerCombination3) ; "%s"
					)
				)
				(StrSplitInTwo @local240 @local150 @local0)
				(StrSplitInTwo @local270 @local180 @local50)
				(StrSplitInTwo @local300 @local210 @local100)
				(if (TestFlag 44)
					(Printf ; "Don't you ever take notes? It says, "%s," "%s," and "%s!""
						45
						2
						@local240
						@local270
						@local300
						@local150
						@local180
						@local210
					)
				else
					(SetFlag 44) ; scoredCombination
					(Printf ; "Closer examination reveals the words to be: "%s," "%s," and "%s.""
						45
						3
						@local240
						@local270
						@local300
						@local150
						@local180
						@local210
					)
					(Print 45 4) ; "Now, what could that mean? Why would Suzi scribble the names of Nontoonyt businesses on the back of her spa membership keycard?"
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

