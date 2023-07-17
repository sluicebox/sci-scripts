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
		(gUser sel_712: 62)
		((gUser sel_715:) update:)
		(gTopMessage sel_749: 0)
		(switch gChapter
			(1
				(switch (gGame printLang:)
					(351
						(gTopMessage
							sel_749: {Cap\a1tulo 1: Filme de Encerramento}
						)
					)
					(39
						(gTopMessage sel_749: {Cap\a1tolo 1: Scena finale})
					)
					(else
						(gTopMessage sel_749: {Chapter One: Ending Movie})
					)
				)
				(PlayScene 115)
			)
			(2
				(switch (gGame printLang:)
					(351
						(gTopMessage
							sel_749: {Cap\a1tulo 2: Filme de Encerramento}
						)
					)
					(39
						(gTopMessage sel_749: {Cap\a1tolo 2: Scena finale})
					)
					(else
						(gTopMessage sel_749: {Chapter Two: Ending Movie})
					)
				)
				(if (gGk2Music handle:)
					(gGk2Music fade: 0 10 10 1)
				)
				(PlayScene 220)
			)
			(3
				(switch (gGame printLang:)
					(351
						(gTopMessage
							sel_749: {Cap\a1tulo 3: Filme de Encerramento}
						)
					)
					(39
						(gTopMessage sel_749: {Cap\a1tolo 3: Scena finale})
					)
					(else
						(gTopMessage sel_749: {Chapter Three: Ending Movie})
					)
				)
				(PlayScene 411)
			)
			(4
				(switch (gGame printLang:)
					(351
						(gTopMessage
							sel_749: {Cap\a1tulo 4: Filme de Encerramento}
						)
					)
					(39
						(gTopMessage sel_749: {Cap\a1tolo 4: Scena finale})
					)
					(else
						(gTopMessage sel_749: {Chapter Four: Ending Movie})
					)
				)
				(if (gGk2Music handle:)
					(gGk2Music fade: 0 10 10 1)
				)
				(PlayScene 537)
			)
			(5
				(switch (gGame printLang:)
					(351
						(gTopMessage
							sel_749: {Cap\a1tulo 5: Filme de Encerramento}
						)
					)
					(39
						(gTopMessage sel_749: {Cap\a1tolo 5: Scena finale})
					)
					(else
						(gTopMessage sel_749: {Chapter Five: Ending Movie})
					)
				)
				(if (gGk2Music handle:)
					(gGk2Music fade: 0 10 10 1)
					(Lock rsAUDIO 606 0)
				)
				(PlayScene 697)
			)
			(6)
		)
		(gTopMessage sel_749: 0)
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

