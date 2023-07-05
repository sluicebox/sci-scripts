;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use Motion)
(use System)

(public
	DyingScript 0
)

(instance DyingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMusic fade:)
				(gCurRoom setScript: 0)
				(= gEgoState 1002)
				(Load rsSOUND 2)
				(= seconds 3)
			)
			(1
				(Load rsVIEW caller)
				(gSoundFX stop:)
				(gMusic number: 2 loop: 1 priority: 255 play:)
				(deadIcon view: caller)
				(if
					(Print
						register
						#title
						next
						#font
						gBigFont
						#icon
						deadIcon
						#button
						{Keep On Muddling}
						0
						#button
						{Order A Hintbook}
						1
					)
					(Print 40 0) ; "See your local software dealer or call Sierra-on-Line. Have your credit card handy."
				)
				(repeat
					(switch
						(Print ; "Remember: save early, save often!"
							40
							1
							#title
							{Al says:}
							#font
							gBigFont
							#button
							{Restore}
							1
							#button
							{Restart}
							2
							#button
							{  Quit  }
							3
						)
						(1
							(gGame restore:)
						)
						(2
							(gGame restart:)
						)
						(3
							(= gQuit 1)
							(break)
						)
					)
				)
			)
		)
	)
)

(instance deadIcon of DCIcon
	(properties)

	(method (init)
		(super init:)
		(if (== gCurRoomNum 540)
			((= cycler (End new:)) init: self)
		)
	)
)

