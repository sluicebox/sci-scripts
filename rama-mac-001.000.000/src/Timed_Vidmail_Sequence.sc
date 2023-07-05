;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 131)
(include sci.sh)
(use Main)
(use VidmailChoices)
(use SaveManager)
(use System)

(class Timed_Vidmail_Sequence of Script
	(properties
		vidMail1 -1
		vidMail2 -1
		vidMail3 -1
		vidMail4 -1
		delay1 300
		delay2 300
		delay3 300
		delay4 400
	)

	(method (init)
		(super init: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(self seconds: delay1)
			)
			(1
				(if (!= vidMail1 -1)
					(if (== gNewRoomNum gCurRoomNum)
						(proc55_3 vidMail1)
						(self seconds: delay2)
						(if (== vidMail2 -1)
							(self dispose:)
						)
					else
						(-- state)
						(= cycles 2)
					)
				else
					(self dispose:)
				)
			)
			(2
				(if (!= vidMail2 -1)
					(if (== gNewRoomNum gCurRoomNum)
						(proc55_3 vidMail2)
						(self seconds: delay3)
						(if (== vidMail3 -1)
							(self dispose:)
						)
					else
						(-- state)
						(= cycles 2)
					)
				else
					(self dispose:)
				)
			)
			(3
				(if (!= vidMail3 -1)
					(if (== gNewRoomNum gCurRoomNum)
						(proc55_3 vidMail3)
						(self seconds: delay4)
						(if (== vidMail4 -1)
							(self dispose:)
						)
					else
						(-- state)
						(= cycles 2)
					)
				else
					(self dispose:)
				)
			)
			(4
				(if (!= vidMail4 -1)
					(if (== gNewRoomNum gCurRoomNum)
						(proc55_3 vidMail4)
						(self dispose:)
					else
						(-- state)
						(= cycles 2)
					)
				else
					(self dispose:)
				)
			)
		)
	)

	(method (serialize param1 param2 param3)
		(if (and argc param1)
			(SaveManager restoreScript: self)
			(self vidMail1: (SaveManager readWord:))
			(self vidMail2: (SaveManager readWord:))
			(self vidMail3: (SaveManager readWord:))
			(self vidMail4: (SaveManager readWord:))
			(self delay1: (SaveManager readWord:))
			(self delay2: (SaveManager readWord:))
			(self delay3: (SaveManager readWord:))
			(self delay4: (SaveManager readWord:))
		else
			(SaveManager saveScript: self param2 param3)
			(SaveManager writeWord: vidMail1)
			(SaveManager writeWord: vidMail2)
			(SaveManager writeWord: vidMail3)
			(SaveManager writeWord: vidMail4)
			(SaveManager writeWord: delay1)
			(SaveManager writeWord: delay2)
			(SaveManager writeWord: delay3)
			(SaveManager writeWord: delay4)
		)
	)
)

