;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 690)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm690 0
)

(instance rm690 of Rm
	(properties
		picture 690
	)

	(method (init &tmp [temp0 50])
		(gUser canInput: 1 canControl: 0)
		(super init:)
		(if (not global256)
			(Load rsVIEW 91)
			(ray init:)
		)
		(self setScript: RayScript)
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look,look>')
				(cond
					((Said '[/around,scope]')
						(Print 690 0) ; "Hate to make you feel stupid, but you're already looking!"
					)
					((Said '/moon')
						(Print 690 1) ; "That's the moon, alright! It's known around these parts as 'Pestulon'."
					)
					((Said '/beam')
						(cond
							(global256
								(Print 690 2) ; "No more beam. You broke it, remember?"
							)
							(global170
								(Print 690 3) ; "The force beam forms a protective energy shield around the moon."
							)
							(else
								(Print 690 4) ; "It looks like something from an old science fiction movie."
							)
						)
					)
				)
			)
			((Said 'get,get>')
				(event claimed: 1)
				(Print 690 5) ; "There's nothing to get here."
			)
		)
	)
)

(instance RayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(cond
					((not global254)
						(cond
							(global170
								(Print 690 6) ; "AHA!!! You've discovered the force beam generator!  And that moon must be Pestulon."
							)
							(global256
								(Print 690 7) ; "What is that thing, anyway? Whatever it is, you busted it real good."
							)
							(else
								(Print 690 8) ; "What is that thing, anyway? Maybe it's a TV transmitter, beaming game shows and championship wrestling to all corners of the globe."
							)
						)
						(gGame changeScore: 10)
					)
					(global256
						(if global170
							(Print 690 9) ; "Yep, the broken generator's still there. How many times ya gonna look at it?"
						else
							(Print 690 10) ; "Yep, that thing's still there. But it's not beaming anymore since you broke it."
						)
					)
					(global170
						(Print 690 11) ; "Yep, the generator's still there. How many times ya gonna look at it?"
					)
					(else
						(Print 690 12) ; "Yep, that thing's still here. How many times ya gonna look at it?"
					)
				)
				(= global254 1)
				(= seconds 5)
			)
			(2
				(++ global593)
				(client newRoom: 69)
			)
		)
	)
)

(instance ray of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 91
			setLoop: 0
			setCel: 0
			setPri: 11
			posn: 145 85
			setCycle: Fwd
			cycleSpeed: 0
		)
	)
)

