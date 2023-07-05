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
		(gUser BAD_SELECTOR: 62)
		((gUser BAD_SELECTOR:) update:)
		(gTopMessage BAD_SELECTOR: 0)
		(switch gChapter
			(1
				(switch (gGame printLang:)
					(351
						(gTopMessage
							BAD_SELECTOR: {Cap\a1tulo 1: Filme de Encerramento}
						)
					)
					(else
						(gTopMessage BAD_SELECTOR: {Chapter One: Ending Movie})
					)
				)
				(PlayScene 115)
			)
			(2
				(switch (gGame printLang:)
					(351
						(gTopMessage
							BAD_SELECTOR: {Cap\a1tulo 2: Filme de Encerramento}
						)
					)
					(else
						(gTopMessage BAD_SELECTOR: {Chapter Two: Ending Movie})
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
							BAD_SELECTOR: {Cap\a1tulo 3: Filme de Encerramento}
						)
					)
					(else
						(gTopMessage BAD_SELECTOR: {Chapter Three: Ending Movie})
					)
				)
				(PlayScene 411)
			)
			(4
				(switch (gGame printLang:)
					(351
						(gTopMessage
							BAD_SELECTOR: {Cap\a1tulo 4: Filme de Encerramento}
						)
					)
					(else
						(gTopMessage BAD_SELECTOR: {Chapter Four: Ending Movie})
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
							BAD_SELECTOR: {Cap\a1tulo 5: Filme de Encerramento}
						)
					)
					(else
						(gTopMessage BAD_SELECTOR: {Chapter Five: Ending Movie})
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
		(gTopMessage BAD_SELECTOR: 0)
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

