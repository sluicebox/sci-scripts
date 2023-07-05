;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use n027)
(use MuseumRgn)

(public
	aRameses 0
)

(instance aRameses of MuseumActor
	(properties
		noun 1
		modNum 1891
		originalView 823
		room 370
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
				(switch temp0
					(258
						(cond
							((IsFlag 134)
								(if (proc27_0 6 global364)
									(gMessager say: noun 6 1 0 0 modNum) ; "We have already dithcuthed that, Mith Bow. Let uth move on to newer thubjecth."
								else
									(gMessager say: noun 6 72 0 0 modNum) ; "A thouthand curtheth on that man! He defiled the tombth of my thacred anthethtorth for hith own perthonal glory! He doethn't care a fig for what'th right and what'th wrong. Hith own evil deedth will catch up with him, though, jutht wait and thee."
									(proc27_1 6 @global364)
								)
							)
							((proc27_0 6 global297)
								(gMessager say: noun 6 1 0 0 modNum) ; "We have already dithcuthed that, Mith Bow. Let uth move on to newer thubjecth."
							)
							(else
								(gMessager say: noun 6 3 0 0 modNum) ; "A thouthand curtheth on that man! He defiled the tombth of my thacred anthethtorth for hith own perthonal glory! He doethn't care a fig for what'th right and what'th wrong. Hith own evil deedth will catch up with him, though, jutht wait and thee."
								(proc27_1 6 @global297)
							)
						)
					)
					(259
						(cond
							((IsFlag 171)
								(if (proc27_0 6 global363)
									(gMessager say: noun 6 1 0 0 modNum) ; "We have already dithcuthed that, Mith Bow. Let uth move on to newer thubjecth."
								else
									(gMessager say: noun 6 69 0 0 modNum) ; "I have heard a great deal about Mithter Carrington, but I do not know him very well. We have only thpoken once or twithe, but he theemth like a cultured, charming fellow."
									(proc27_1 6 @global363)
								)
							)
							((proc27_0 6 global298)
								(gMessager say: noun 6 1 0 0 modNum) ; "We have already dithcuthed that, Mith Bow. Let uth move on to newer thubjecth."
							)
							(else
								(gMessager say: noun 6 4 0 0 modNum) ; "I have heard a great deal about Mithter Carrington, but I do not know him very well. We have only thpoken once or twithe, but he theemth like a cultured, charming fellow."
								(proc27_1 6 @global298)
							)
						)
					)
					(266
						(cond
							((IsFlag 161)
								(if (proc27_0 6 global367)
									(gMessager say: noun 6 1 0 0 modNum) ; "We have already dithcuthed that, Mith Bow. Let uth move on to newer thubjecth."
								else
									(gMessager say: noun 6 73 0 0 modNum) ; "Mith Delacroix ith a charming young lady, and tho friendly!"
									(proc27_1 6 @global367)
								)
							)
							((proc27_0 6 global305)
								(gMessager say: noun 6 1 0 0 modNum) ; "We have already dithcuthed that, Mith Bow. Let uth move on to newer thubjecth."
							)
							(else
								(gMessager say: noun 6 11 0 0 modNum) ; "Mith Yvette ith a charming young lady, and tho friendly! She theemth genuinely interethted in Egyptology. We had a long dithcuthion about tombth one time...."
								(proc27_1 6 @global305)
							)
						)
					)
					(267
						(cond
							((IsFlag 158)
								(if (proc27_0 6 global365)
									(gMessager say: noun 6 1 0 0 modNum) ; "We have already dithcuthed that, Mith Bow. Let uth move on to newer thubjecth."
								else
									(gMessager say: noun 6 71 0 0 modNum) ; "I do not know Mithter Leach very well, but he theemth to be a dethent, hard-working fellow."
									(proc27_1 6 @global365)
								)
							)
							((proc27_0 6 global306)
								(gMessager say: noun 6 1 0 0 modNum) ; "We have already dithcuthed that, Mith Bow. Let uth move on to newer thubjecth."
							)
							(else
								(gMessager say: noun 6 12 0 0 modNum) ; "I do not know Mithter Leach very well, but he theemth to be a dethent, hard-working fellow."
								(proc27_1 6 @global306)
							)
						)
					)
					(else
						(cond
							((not (Message msgGET modNum noun 6 temp1 1))
								(gMessager say: noun 6 81 0 0 modNum) ; "I'm thorry, but I don't with to dithcuth that, Mith Bow."
							)
							((proc27_0 6 [global296 (- temp1 2)])
								(gMessager say: noun 6 1 0 0 modNum) ; "We have already dithcuthed that, Mith Bow. Let uth move on to newer thubjecth."
							)
							(else
								(gMessager say: noun 6 temp1 0 0 modNum)
								(proc27_1 6 @[global296 (- temp1 2)])
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

