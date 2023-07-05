;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use n913)
(use Game)
(use System)

(public
	rMist 0
)

(class rMist of Rgn
	(properties
		seenFirstMessage 0
		musicPlaying 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 550 560 570 580))
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(super init: &rest)
		(if (and (or (== gCurRoomNum 550) (== gCurRoomNum 560)) (not (IsFlag 14)))
			(if (not musicPlaying)
				(gGlobalSound number: 551 loop: -1 play:)
				(= musicPlaying 1)
			)
			(self setScript: hintDrums)
		)
		(if (== gCurRoomNum 580)
			(gGlobalSound stop:)
		)
	)

	(method (dispose)
		(gGlobalSound stop:)
		(SetFlag 25)
		(super dispose:)
	)
)

(instance hintDrums of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(cond
					((IsFlag 74)
						(self dispose:)
					)
					((gCurRoom script:)
						(self init:)
					)
					((== gCurRoomNum 550)
						(gMessager say: 1 0 5 1 self)
					)
					((== gCurRoomNum 560)
						(gMessager say: 1 0 1 1 self)
					)
				)
			)
			(2
				(= seconds 27)
			)
			(3
				(self init:)
			)
		)
	)
)

