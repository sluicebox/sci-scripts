;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use n027)
(use MuseumRgn)

(public
	aSteve 0
)

(instance aSteve of MuseumActor
	(properties
		noun 1
		modNum 1887
		scaleSignal 1
		originalView 812
		room 370
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(switch theVerb
			(1 ; Look
				(switch gAct
					(1
						(gMessager say: noun theVerb 0 0 0 modNum) ; "The stevedore looks a little more refined than you'd expect. He's also rather attractive."
					)
					(5
						(gMessager say: noun theVerb 27 0 0 modNum) ; "Steve has a lump on his head, his rumpled tuxedo has black smudges on it, and he's looking rather tired. However, his eyes still sparkle when he looks at you."
					)
					(else
						(gMessager say: noun theVerb 24 0 0 modNum) ; "It's Steve Dorian, dressed nattily in a tuxedo and an old pair of work boots. His eyes sparkle when he looks at you."
					)
				)
			)
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
				(switch temp0
					(258
						(cond
							((IsFlag 134)
								(if (proc27_0 10 global364)
									(gMessager say: noun 6 1 0 0 modNum) ; "Shall we move on to a new subject, Miss Bow? I'm afraid my expertise is limited."
								else
									(gMessager say: noun 6 72 0 0 modNum) ; "That particular gentleman was a little too full of himself for my liking, but I don't want to speak ill of the dead. My mother always told me that if I couldn't say something nice about someone, it's better to say nothing at all."
									(proc27_1 10 @global364)
								)
							)
							((proc27_0 10 global297)
								(gMessager say: noun 6 1 0 0 modNum) ; "Shall we move on to a new subject, Miss Bow? I'm afraid my expertise is limited."
							)
							(else
								(gMessager say: noun 6 3 0 0 modNum) ; "That particular gentleman is a little too full of himself for my liking. I suppose he has reason to be, though, being a famous archaeologist and all."
								(proc27_1 10 @global297)
							)
						)
					)
					(else
						(cond
							((not (Message msgGET modNum noun 6 temp1 1))
								(gMessager say: noun 6 81 0 0 modNum) ; "Uhh, I'm afraid I don't know how to answer that, Miss Bow. Sorry."
							)
							((proc27_0 10 [global296 (- temp1 2)])
								(gMessager say: noun 6 1 0 0 modNum) ; "Shall we move on to a new subject, Miss Bow? I'm afraid my expertise is limited."
							)
							(else
								(gMessager say: noun 6 temp1 0 0 modNum)
								(proc27_1 10 @[global296 (- temp1 2)])
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

