;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	LockerScript 0
)

(local
	[name1 20]
	[name2 20]
	[name3 20]
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
					(Format @name1 45 1 46 gLockerCombination1) ; "%s"
					(Format @name2 45 1 46 gLockerCombination2) ; "%s"
					(Format @name3 45 1 46 gLockerCombination3) ; "%s"
					(Printf 45 2 @name1 @name2 @name3) ; "Don't you ever take notes? It says, "%s," "%s," and "%s!""
				else
					(SetFlag 44)
					(Format @name1 45 1 46 (= gLockerCombination1 0)) ; "%s"
					(while (== 32 (StrAt @name1 0))
						(= gLockerCombination1 (Random 1 24))
						(Format @name1 45 1 46 gLockerCombination1) ; "%s"
					)
					(= gLockerCombination2 gLockerCombination1)
					(while
						(or (== gLockerCombination1 gLockerCombination2) (== 32 (StrAt @name2 0)))
						(= gLockerCombination2 (Random 1 24))
						(Format @name2 45 1 46 gLockerCombination2) ; "%s"
					)
					(= gLockerCombination3 gLockerCombination1)
					(while
						(or
							(== gLockerCombination1 gLockerCombination3)
							(== gLockerCombination2 gLockerCombination3)
							(== 32 (StrAt @name3 0))
						)
						(= gLockerCombination3 (Random 1 24))
						(Format @name3 45 1 46 gLockerCombination3) ; "%s"
					)
					(Printf 45 3 @name1 @name2 @name3) ; "Closer examination reveals the words to be: "%s," "%s," and "%s." Now, what could that mean? Why would Suzi scribble the names of Nontoonyt businesses on the back of her spa membership keycard?"
				)
				(HandsOn)
				(gGame setScript: 0)
				(DisposeScript 45)
				(DisposeScript 46)
			)
		)
	)
)

