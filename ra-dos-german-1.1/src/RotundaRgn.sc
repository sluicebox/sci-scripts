;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use n027)
(use Game)
(use Actor)
(use System)

(public
	RotundaRgn 0
	Countess 1
	Heimlich 3
	Olympia 4
	O_Riley 5
	Pippin 6
	Rameses 7
	Steve 8
	Tut 9
	Watney 10
	Yvette 11
	Ziggy 12
)

(class RotundaRgn of Rgn
	(properties
		convRoom 0
		convReturn 0
	)

	(method (init)
		(super init:)
		(= convRoom
			(switch global128
				(0 350)
				(1 350)
				(2 360)
				(3 360)
				(4 350)
				(5 350)
				(6 370)
				(7 370)
				(8 370)
				(9 350)
				(10 360)
				(11 360)
				(12 360)
				(13 350)
			)
		)
		(Countess approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(Heimlich approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(Olympia approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(O_Riley approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(Pippin approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(Rameses approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(Steve approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(Tut approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(Watney approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(Yvette approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
		(Ziggy approachDist: 20 approachVerbs: 2 6) ; Talk, Ask
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 335 340 350 355 360 370 400)) ; testRoom
		(= initialized 0)
		(cond
			((not (== gAct 2)))
			((OneOf newRoomNumber 335 400 420)
				(gGameMusic1 fade: 50 5 5 0)
			)
			((== newRoomNumber 340) ; testRoom
				(gGameMusic1 fade: 100 5 5 0)
			)
		)
		(if (and (& $7204 gMustDos) (not (IsFlag 71)) (== newRoomNumber 360))
			(SetFlag 71)
		)
		(super newRoom: newRoomNumber)
	)

	(method (notify)
		(= convReturn gCurRoomNum)
		(gCurRoom newRoom: 340) ; testRoom
	)
)

(instance Countess of Actor
	(properties
		noun 1
		modNum 1884
		view 813
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(cond
			((== theVerb 2) ; Talk
				(if (not (SetFlag 112))
					(gMessager say: noun theVerb 80 0 0 modNum) ; "Hi, I'm Laura Bow, and I'm covering this event for the Tribune's Society News column."
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 6 14) ; Ask, notebook
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
						(gMessager say: noun 6 81 0 0 modNum) ; "I SIMPLY don't know HOW to answer THAT, my dear."
					)
					((proc27_0 0 [global296 (- temp1 2)])
						(gMessager say: noun 6 1 0 0 modNum) ; "I bore rather easily, dear girl. DO let's move on to another subject, mmmmm?"
					)
					(else
						(gMessager say: noun 6 temp1 0 0 modNum)
						(proc27_1 0 @[global296 (- temp1 2)])
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Heimlich of Actor
	(properties
		noun 1
		modNum 1889
		view 814
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (OneOf theVerb 6 14) ; Ask, notebook
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
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Olympia of Actor
	(properties
		noun 1
		modNum 1892
		view 820
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (OneOf theVerb 6 14) ; Ask, notebook
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
					(gMessager say: noun 6 81 0 0 modNum) ; "I'm SURE I DON'T have an answer for THAT, Miss Bow."
				)
				((proc27_0 3 [global296 (- temp1 2)])
					(gMessager say: noun 6 1 0 0 modNum) ; "But we have already discussed that, my dear. Let's move on to a fresh topic, shall we?"
				)
				(else
					(gMessager say: noun 6 temp1 0 0 modNum)
					(proc27_1 3 @[global296 (- temp1 2)])
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance O_Riley of Actor
	(properties
		name {O'Riley}
		noun 1
		modNum 1888
		view 819
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(cond
			((== theVerb 2) ; Talk
				(if (not (SetFlag 114))
					(gMessager say: noun theVerb 80 0 0 modNum) ; "How are you, Detective O'Riley?"
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 6 14) ; Ask, notebook
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
								(if (proc27_0 4 global364)
									(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
								else
									(gMessager say: noun 6 72 0 0 modNum) ; "Someone got tired of the man's big ego, would be my guess."
									(proc27_1 4 @global364)
								)
							)
							((proc27_0 4 global297)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							)
							(else
								(gMessager say: noun 6 3 0 0 modNum) ; "That fella is just too big for his britches, that's all I have to say. Someone ought to take him down a notch or two."
								(proc27_1 4 @global297)
							)
						)
					)
					(259
						(cond
							((IsFlag 171)
								(if (proc27_0 4 global363)
									(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
								else
									(gMessager say: noun 6 69 0 0 modNum) ; "I guess you've examined poor Dr. Carrington's body?"
									(proc27_1 4 @global363)
								)
							)
							((proc27_0 4 global298)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							)
							(else
								(gMessager say: noun 6 4 0 0 modNum) ; "He's got too many brains, that one. He thinks he's better than us all."
								(proc27_1 4 @global298)
							)
						)
					)
					(264
						(cond
							((IsFlag 143)
								(if (proc27_0 4 global366)
									(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
								else
									(gMessager say: noun 6 74 0 0 modNum) ; "Have you had a chance to examine Ziggy's body?"
									(proc27_1 4 @global366)
								)
							)
							((proc27_0 4 global303)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							)
							(else
								(gMessager say: noun 6 9 0 0 modNum) ; "That man is a human weasel. Stay away from him, lassie."
								(proc27_1 4 @global303)
							)
						)
					)
					(266
						(cond
							((IsFlag 161)
								(if (proc27_0 4 global367)
									(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
								else
									(gMessager say: noun 6 73 0 0 modNum) ; "Have you had a chance to examine Miss Delacroix's body?"
									(proc27_1 4 @global367)
								)
							)
							((proc27_0 4 global305)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							)
							(else
								(gMessager say: noun 6 11 0 0 modNum) ; "Now, there's a lovely girl. A real lady, don't you know."
								(proc27_1 4 @global305)
							)
						)
					)
					(267
						(cond
							((IsFlag 158)
								(if (proc27_0 4 global365)
									(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
								else
									(gMessager say: noun 6 71 0 0 modNum) ; "Have you had a chance to examine Mr. Leach's body yet?"
									(proc27_1 4 @global365)
								)
							)
							((proc27_0 4 global306)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							)
							(else
								(gMessager say: noun 6 12 0 0 modNum) ; "Oh, he's an okay fella, I suppose. I haven't spent much time with the man."
								(proc27_1 4 @global306)
							)
						)
					)
					(780
						(cond
							((IsFlag 155)
								(if (proc27_0 4 global368)
									(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
								else
									(gMessager say: noun 6 75 0 0 modNum) ; "Sir, I think I've found the Dagger of Amon Ra."
									(proc27_1 4 @global368)
								)
							)
							((proc27_0 4 global332)
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							)
							(else
								(gMessager say: noun 6 38 0 0 modNum) ; "It's an oversized letter opener, if you ask me."
								(proc27_1 4 @global332)
							)
						)
					)
					(else
						(cond
							((not (Message msgGET modNum noun 6 temp1 1))
								(gMessager say: noun 6 81 0 0 modNum) ; "Sure and begorrah, the next thing you'll be asking me is where the little people keep their pots o' gold! I can't tell you anything about that, lass."
							)
							((proc27_0 4 [global296 (- temp1 2)])
								(gMessager say: noun 6 1 0 0 modNum) ; "I'm a busy man. Don't take up my time by asking the same questions twice."
							)
							(else
								(gMessager say: noun 6 temp1 0 0 modNum)
								(proc27_1 4 @[global296 (- temp1 2)])
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

(instance Pippin of Actor
	(properties
		noun 1
		modNum 1882
		view 822
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(cond
			((== theVerb 2) ; Talk
				(if (not (SetFlag 110))
					(gMessager say: noun theVerb 80 0 0 modNum) ; "This is quite a party. Does the museum always have a big fund-raiser when they open a new exhibit, Dr. Carter?"
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 6 14) ; Ask, notebook
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

(instance Rameses of Actor
	(properties
		noun 1
		modNum 1891
		view 823
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(cond
			((== theVerb 2) ; Talk
				(if (not (SetFlag 115))
					(gMessager say: noun theVerb 80 0 0 modNum) ; "Good evening, sir. My name is Laura Bow."
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 6 14) ; Ask, notebook
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
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Steve of Actor
	(properties
		noun 1
		modNum 1887
		view 812
		signal 16384
		scaleSignal 1
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (== theVerb 6) ; Ask
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
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Tut of Actor
	(properties
		noun 1
		modNum 1883
		view 821
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(cond
			((== theVerb 2) ; Talk
				(if (not (SetFlag 111))
					(gMessager say: noun theVerb 80 0 0 modNum) ; "You must be Dr. Ptahsheptut Smith. Nice gold ankh you're wearing. This is quite a party, isn't it?"
				else
					(super doVerb: theVerb)
				)
			)
			((OneOf theVerb 6 14) ; Ask, notebook
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
						(gMessager say: noun 6 81 0 0 modNum) ; "Ah, now that's a question worthy of the Great Sphinx. Unfortunately, I, myself, cannot answer it."
					)
					((proc27_0 7 [global296 (- temp1 2)])
						(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me that, you silly female."
					)
					(else
						(gMessager say: noun 6 temp1 0 0 modNum)
						(proc27_1 7 @[global296 (- temp1 2)])
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Watney of Actor
	(properties
		noun 1
		modNum 1886
		view 815
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (== theVerb 6) ; Ask
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
					(gMessager say: noun 6 81 0 0 modNum) ; "I'm sure I don't know how to answer THAT, I daresay."
				)
				((proc27_0 8 [global296 (- temp1 2)])
					(gMessager say: noun 6 1 0 0 modNum) ; "I'm really very busy, Miss Bow. I don't have time to cover the same subject twice."
				)
				(else
					(gMessager say: noun 6 temp1 0 0 modNum)
					(proc27_1 8 @[global296 (- temp1 2)])
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Yvette of Actor
	(properties
		noun 1
		modNum 1885
		view 817
		signal 16384
		scaleSignal 1
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(cond
			((== theVerb 2) ; Talk
				(if (not (SetFlag 113))
					(gMessager say: noun theVerb 80 0 0 modNum) ; "Bonjour, Miss Bow. Dr. Carrington told me you were covering zees party for ze newspaper. I'm Yvette Delacroix."
				else
					(gMessager say: noun theVerb 28 0 0 modNum) ; "Miss Bow, I am not wishing to be ze rude person, but I must keep mingling zees evening unless you have ze specific question."
				)
			)
			((OneOf theVerb 6 14) ; Ask, notebook
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
					(267
						(cond
							((IsFlag 158)
								(if (proc27_0 9 global365)
									(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
								else
									(gMessager say: noun 6 71 0 0 modNum) ; "Oh, my Ernie! Ze Icepick got heem!"
									(proc27_1 9 @global365)
								)
							)
							((proc27_0 9 global306)
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
							)
							(else
								(gMessager say: noun 6 12 0 0 modNum) ; "Ahh, Monsieur Leach, he ees ze very honorable man, no? Of everyone here, I trust heem most of all. Hees pay, eet ees not very good, but I will fix that when I become ze museum President someday. In ze meantime, he must do ze extra outside work to pay hees bills."
								(proc27_1 9 @global306)
							)
						)
					)
					(263
						(if (proc27_0 9 global302)
							(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
						else
							(gMessager say: noun 6 8 0 0 modNum) ; "Ah, ze Steve, he is so beeg and handsome, no?"
							(proc27_1 9 @global302)
						)
					)
					(else
						(cond
							((not (Message msgGET modNum noun 6 temp1 1))
								(gMessager say: noun 6 81 0 0 modNum) ; "I am not knowing how to answer zees. My Engleesh, she is not so good sometimes, no?"
							)
							((proc27_0 9 [global296 (- temp1 2)])
								(gMessager say: noun 6 1 0 0 modNum) ; "You already asked me zis, Miss Bow."
							)
							(else
								(gMessager say: noun 6 temp1 0 0 modNum)
								(proc27_1 9 @[global296 (- temp1 2)])
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

(instance Ziggy of Actor
	(properties
		noun 1
		modNum 1890
		view 816
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1 temp2)
		(if (OneOf theVerb 6 14) ; Ask, notebook
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
					(gMessager say: noun 6 81 0 0 modNum) ; "Can't help youse with dat, toots."
				)
				((proc27_0 11 [global296 (- temp1 2)])
					(gMessager say: noun 6 1 0 0 modNum) ; "How many times are ya gonna ask me? I already told ya everything I know about dat."
				)
				(else
					(gMessager say: noun 6 temp1 0 0 modNum)
					(proc27_1 11 @[global296 (- temp1 2)])
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

