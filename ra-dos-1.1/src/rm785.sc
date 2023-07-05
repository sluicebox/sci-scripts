;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 785)
(include sci.sh)
(use Main)
(use eRS)
(use Actor)
(use System)

(public
	rm785 0
)

(local
	local0
	local1
	local2
	[local3 19] = [342 597 850 1113 1366 1628 1885 2131 2394 2651 2900 3166 3424 3683 3937 4184 4439 4688 4962]
)

(instance rm785 of LBRoom
	(properties
		picture 780
	)

	(method (init)
		(super init:)
		(gGameMusic1 number: 140 flags: 1 loop: -1 play:)
		(= local0
			(switch global126
				(1 1)
				(2 2)
				(3 3)
				(4 4)
			)
		)
		(gTheIconBar disable:)
		(gGame setCursor: 996)
		(= local1 (>> (& [local3 local2] $ff00) $0008))
		(characterView
			view: (+ 1800 (& [local3 local2] $00ff))
			loop: 1
			x: 10
			y: 10
			init:
		)
		(gNarrator x: 10 y: 113 talkWidth: 290)
		(self setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(gCurRoom
					drawPic:
						(if (== (characterView view:) 1898) 785 else 780)
						10
				)
				(= cycles 2)
			)
			(1
				(gMessager say: local1 0 local0 0 self)
			)
			(2
				(++ local2)
				(characterView dispose:)
				(= ticks 120)
			)
			(3
				(if (== local2 19)
					(gGameMusic1 fade: 0 12 30 1)
					(gCurRoom
						newRoom: (if (OneOf global126 1 4) 780 else 790)
					)
				else
					(= local1 (>> (& [local3 local2] $ff00) $0008))
					(characterView
						view: (+ 1800 (& [local3 local2] $00ff))
						loop: 1
						x:
							(switch (mod local1 3)
								(0 220)
								(1 10)
								(2 115)
							)
						y:
							(cond
								((== local1 19) 5)
								((and (< (mod local1 6) 4) (> (mod local1 6) 0)) 10)
								(else 103)
							)
						init:
					)
					(gNarrator
						x: (if (== local1 19) 160 else 10)
						y: (if (== (characterView y:) 10) 113 else 10)
						talkWidth: (if (== local1 19) 140 else 290)
					)
					(self changeState: 0)
				)
			)
		)
	)
)

(instance characterView of View
	(properties)
)

