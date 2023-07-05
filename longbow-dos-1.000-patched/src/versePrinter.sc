;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 855)
(include sci.sh)
(use Main)
(use n013)
(use System)

(public
	versePrinter 0
)

(instance versePrinter of Script
	(properties)

	(method (init)
		(SetMessageColor 33)
		(super init: &rest)
	)

	(method (dispose)
		(SetMessageColor 0)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Say 855 0 self 33 3) ; "The trees argued amongst themselves to decide who was first amongst trees. In Latin they spoke:"
			)
			(1
				(= temp0
					(switch global144
						(0
							(Say 855 1 self 33 3) ; "Fearn said, "My power increases beneath water." "Red is my crowning beauty," Luis claimed. "I do not sleep in winter," said Ailm. "I strangle even the strongest," Gort said. "Music hides within me," said Ruis. Ochtach said, "Much is made of me.""
						)
						(1
							(Say 855 2 self 33 3) ; "Red is my crowning beauty," Luis claimed. Idho cried, "The power of the bow sleeps within me." Beth bragged, "Men become drunk upon my sap." Eadha said, "The Romans loved me dearly." "Music hides within me," said Ruis. Ochtach said, "Much is made of me."
						)
						(2
							(Say 855 3 self 33 3) ; "Music hides within me," said  Ruis. Eadha said, "The Romans loved me dearly." "I strangle even the strongest," Gort said. "I do not sleep in winter," said Ailm. "Red is my crowning beauty," Luis claimed. Idho cried, "The power of the bow sleeps within me." Said Saille, "Harps sang to me in Babylon."
						)
						(3
							(Say 855 4 self 33 3) ; "I do not sleep in winter," said Ailm. "Music hides within me," said Ruis. Said Duir, "Pigs grow fat on my acorns." Eadha said, "The Romans loved me dearly." "I am tall and straight," said Nion. Said Saille, "Harps sang to me in Babylon."
						)
						(4
							(Say 855 5 self 33 3) ; "Said Duir, "Pigs grow fat on my acorns." Eadha said, "The Romans loved me dearly." Said Saille, "Harps sang to me in Babylon." Idho cried, "The power of the bow sleeps within me." "I strangle even the strongest," Gort said. "I am tall and straight," said Nion. Ochtach said, "Much is made of me.""
						)
						(5
							(Say 855 6 self 33 3) ; "Beth bragged, "Men become drunk upon my sap." Ochtach said, "Much is made of me." "I am tall and straight," said Nion. Idho cried, "The power of the bow sleeps within me." "Chariots wage battle with me," said Tinne. "I do not sleep in winter," said Ailm. Said Saille, "Harps sang to me in Babylon.""
						)
						(6
							(Say 855 7 self 33 3) ; "Said Muin, "Nothing is sweeter than what I bear." Eadha said, "The Romans loved me dearly." Said Duir, "Pigs grow fat on my acorns." Idho cried, "The power of the bow sleeps within me." "My helmeted fruit is my treasure," Coll said. Ochtach said, "Much is made of me." "Music hides within me," said Ruis."
						)
						(7
							(Say 855 8 self 33 3) ; "I am tall and straight," said Nion. Eadha said, "The Romans loved me dearly." Said Muin, "Nothing is sweeter than what I bear." Ochtach said, "Much is made of me." "Music hides within me," said Ruis. "I do not sleep in winter," said Ailm. "Red is my crowning beauty," Luis claimed. Idho cried, "The power of the bow sleeps within me." Said Saille, "Harps sang to me in Babylon."
						)
						(8
							(Say 855 9 self 33 3) ; ""My helmeted fruit is my treasure," Coll said. Idho cried, "The power of the bow sleeps within me." Said Saille, "Harps sang to me in Babylon." "Chariots wage battle with me," said Tinne. Eadha said, "The Romans loved me dearly." "Music hides within me," said Ruis. "I am tall and straight," said Nion. "I do not sleep in winter," said Ailm."
						)
						(9
							(Say 855 10 self 33 3) ; "Chariots wage battle with me," said Tinne. "Music hides within me," said Ruis. "I do not sleep in winter," said Ailm. "I am tall and straight," said Nion. Said Saille, "Harps sang to me in Babylon." Fearn said, "My power increases beneath water." Idho cried, "The power of the bow sleeps within me." "I strangle even the strongest," Gort said. Ochtach said, "Much is made of me."
						)
					)
				)
			)
			(2
				(Say 855 11 self 33 3) ; "So the trees argued, but the key is this, Every tree is first amongst trees, And first they are in order spoken."
			)
			(3
				(self dispose:)
				(DisposeScript 855)
			)
		)
	)
)

