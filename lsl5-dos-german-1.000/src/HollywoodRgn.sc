;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	HollywoodRgn 0
)

(instance HollywoodRgn of Rgn
	(properties)

	(method (init)
		(if (IsFlag 7) ; fBeenIn150
			(self setScript: sRemember)
		)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 160 170 180 190))
	)
)

(instance sRemember of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 30)
			)
			(1
				(TPrint 40 0) ; "Where am I?" you wonder. "What's happened to me? What am I doing here?"
				(TPrint 40 1) ; "The last you remember, you were writing your life story as a computer game, sitting on a deck with a half-naked woman, overlooking a beautiful lake nestled high in the Sierra Nevada."
				(= seconds 120)
			)
			(2
				(TPrint 40 2) ; "I remember a woman named Patti; something about an island; and, and... a gig as a computer game programmer?" you think. "What's going on?"
				(TPrint 40 3) ; "How did I end up in Hollywood--and what am I supposed to be doing here?" you sigh. "I'm so confused!"
				(TPrint 40 4 #at -1 185) ; "(Of course, you're quite accustomed to being confused!)"
				(= seconds 120)
			)
			(3
				(TPrint 40 5) ; "And what am I doing in Larry 5?" you think. "And whatever happened to Larry 4?"
				(TPrint 40 6) ; "Slowly you come to the realization that you must be suffering from amnesia, although how a computer game character gets amnesia you do not understand!"
				(= seconds 120)
			)
			(4
				(TPrint 40 7) ; "Who was that Patti woman? Does she still exist? Did she ever exist?" you think. "Or is she just a series of partially-toggled bits in my memories?"
				(TPrint 40 8) ; "You remember her most deeply in your heart, not to mention several other major organs."
				(TPrint 40 9) ; "But where is she? Will you see her again? Does she ever think of you?"
				(= seconds 120)
			)
			(5
				(TPrint 40 10) ; "Suddenly, your memories stir again, "Patti was Passionate Patti, the famous pianist/entertainer. I remember: I loved her!""
				(TPrint 40 11) ; "And wait! She loved me, too! Will I ever find her again?"
				(= seconds 120)
			)
		)
	)
)

