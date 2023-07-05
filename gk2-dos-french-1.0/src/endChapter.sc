;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)

(public
	endChapter 0
)

(instance endChapter of GK2Room
	(properties)

	(method (init &tmp [temp0 2])
		(super init: &rest)
		(gCurInvView update:)
		(gUser curVerb: 62)
		((gUser hotCursor:) update:)
		(gTopMessage newText: 0)
		(switch gChapter
			(1
				(gTopMessage newText: {Chapitre Un: Film de Cloture})
				(PlayScene 115)
			)
			(2
				(gTopMessage newText: {Chapitre Deux: Film de Cloture})
				(if (gGk2Music handle:)
					(gGk2Music fade: 0 10 10 1)
				)
				(PlayScene 220)
			)
			(3
				(gTopMessage newText: {Chapitre Trois: Film de Cloture})
				(PlayScene 411)
			)
			(4
				(gTopMessage newText: {Chapitre Quatre: Film de Cloture})
				(if (gGk2Music handle:)
					(gGk2Music fade: 0 10 10 1)
				)
				(PlayScene 537)
			)
			(5
				(gTopMessage newText: {Chapitre Cinq: Film de Cloture})
				(if (gGk2Music handle:)
					(gGk2Music fade: 0 10 10 1)
					(Lock rsAUDIO 606 0)
				)
				(PlayScene 697)
			)
			(6)
		)
		(gTopMessage newText: 0)
		(if (<= (++ gChapter) 6)
			(if (!= gChapter 3)
				(gGame getDisc: gChapter)
			)
			(InitChapter)
		else
			(gCurRoom newRoom: 92) ; endRoom
		)
	)
)

