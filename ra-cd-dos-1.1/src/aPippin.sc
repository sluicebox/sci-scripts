;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use n027)
(use MuseumRgn)

(public
	aPippin 0
)

(instance aPippin of MuseumActor
	(properties
		noun 1
		modNum 1882
		originalView 822
		room 350
	)

	(method (cue)
		(super cue: &rest)
		(SetFlag 1)
		(self dispose:)
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(switch theVerb
			(6 ; Ask
				(if
					(==
						(= temp0
							(if (== argc 2)
								invItem
							else
								(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
							)
						)
						-1
					)
					(return)
				)
				(= temp2 (& temp0 $00ff))
				(= temp1
					(switch (& temp0 $ff00)
						(256
							(+ temp2 1)
						)
						(512
							(+ temp2 18)
						)
						(768
							(+ temp2 26)
						)
						(1024
							(+ temp2 61)
						)
					)
				)
				(cond
					((not (Message msgGET modNum noun 6 temp1 1))
						(gMessager say: noun 6 81 0 0 modNum) ; "Don't bother me with such silly questions."
					)
					((proc27_0 5 [global296 (- temp1 2)])
						(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me that, you silly female."
					)
					(else
						(gMessager say: noun 6 temp1 0 0 modNum)
						(proc27_1 5 @[global296 (- temp1 2)])
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

