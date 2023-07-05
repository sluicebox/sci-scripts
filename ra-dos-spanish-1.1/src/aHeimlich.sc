;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use n027)
(use MuseumRgn)

(public
	aHeimlich 0
)

(instance aHeimlich of MuseumActor
	(properties
		noun 1
		modNum 1889
		xStep 2
		room 350
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
					(259
						(cond
							((IsFlag 171)
								(if (proc27_0 2 global363)
									(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zat. Do not vaste my time, fraulein, or I vill become irritated. For all I know, you are distractink me vile art thieves are doing zere work in ze museeum!"
								else
									(gMessager say: noun 6 69 0 0 modNum) ; "He vas a goot man und I vill miss him. Ven I find ze COWARD who shtuck him on ze PORCUPINE, zey vill VISH zey had never been BORN!"
									(proc27_1 2 @global363)
								)
							)
							((proc27_0 2 global298)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zat. Do not vaste my time, fraulein, or I vill become irritated. For all I know, you are distractink me vile art thieves are doing zere work in ze museeum!"
							)
							(else
								(gMessager say: noun 6 4 0 0 modNum) ; "He is a goot man. He lets me do mein job. I just hope he lets me take care of ze filthy art thieves, ven zey are finally discovered. Zey vill vish zey had never been born!"
								(proc27_1 2 @global298)
							)
						)
					)
					(264
						(cond
							((IsFlag 143)
								(if (proc27_0 2 global366)
									(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zat. Do not vaste my time, fraulein, or I vill become irritated. For all I know, you are distractink me vile art thieves are doing zere work in ze museeum!"
								else
									(gMessager say: noun 6 74 0 0 modNum) ; "Zat irritating little civilian iz better off kaput! He reminded me of a zmall, yappy dog, always trailing after ze goot Doctor Carrington! His name zounded German, but I sink he vas ze impostor! I neffer trusted him, und he vas probably an ART THIEF anyvay!"
									(proc27_1 2 @global366)
								)
							)
							((proc27_0 2 global303)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zat. Do not vaste my time, fraulein, or I vill become irritated. For all I know, you are distractink me vile art thieves are doing zere work in ze museeum!"
							)
							(else
								(gMessager say: noun 6 9 0 0 modNum) ; "Vat an irritating little man. He reminds me of a zmall, yappy dog. I vould like to tie him in a knot and bounce him out ze door, but he iz under Dr. Carrington's protection. Perhaps he haz money he iz givink to ze museeum."
								(proc27_1 2 @global303)
							)
						)
					)
					(266
						(cond
							((IsFlag 161)
								(if (proc27_0 2 global367)
									(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zat. Do not vaste my time, fraulein, or I vill become irritated. For all I know, you are distractink me vile art thieves are doing zere work in ze museeum!"
								else
									(gMessager say: noun 6 73 0 0 modNum) ; "Fraulein Delacroix vas ze charming young female who had many of ze good qualities. Ven I find ze killer in zis museum, zey vill know ze true meaning of FEAR! Zey vill be KAPUT!"
									(proc27_1 2 @global367)
								)
							)
							((proc27_0 2 global305)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zat. Do not vaste my time, fraulein, or I vill become irritated. For all I know, you are distractink me vile art thieves are doing zere work in ze museeum!"
							)
							(else
								(gMessager say: noun 6 11 0 0 modNum) ; "Fraulein Delacroix is a charming young lady. She luffs the museum...und she iz a vork of art herzelf. I admire vomen who take good care of zere bodies as we military men do."
								(proc27_1 2 @global305)
							)
						)
					)
					(267
						(cond
							((IsFlag 158)
								(if (proc27_0 2 global365)
									(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zat. Do not vaste my time, fraulein, or I vill become irritated. For all I know, you are distractink me vile art thieves are doing zere work in ze museeum!"
								else
									(gMessager say: noun 6 71 0 0 modNum) ; "Ernie vas ze dezent man, und ven I FIND ze murderink COWARD who DROWNED him, zey vill be CRUSHED in my powerful hands!"
									(proc27_1 2 @global365)
								)
							)
							((proc27_0 2 global306)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zat. Do not vaste my time, fraulein, or I vill become irritated. For all I know, you are distractink me vile art thieves are doing zere work in ze museeum!"
							)
							(else
								(gMessager say: noun 6 12 0 0 modNum) ; "Ernie zeems a dezent man. He alwayz remembers to lock ze doors and vindows at night. I like zat. Ze only problem iz he keeps losink ze keys afterwards."
								(proc27_1 2 @global306)
							)
						)
					)
					(else
						(cond
							((not (Message msgGET modNum noun 6 temp1 1))
								(gMessager say: noun 6 81 0 0 modNum) ; "Fraulein, if anyone vill be conducting ze INTERROGATION here, it vill be ME, not YOU!"
							)
							((proc27_0 2 [global296 (- temp1 2)])
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zat. Do not vaste my time, fraulein, or I vill become irritated. For all I know, you are distractink me vile art thieves are doing zere work in ze museeum!"
							)
							(else
								(gMessager say: noun 6 temp1 0 0 modNum)
								(proc27_1 2 @[global296 (- temp1 2)])
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

