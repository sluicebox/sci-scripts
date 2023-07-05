;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 370)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use Osc)
(use Feature)
(use Motion)
(use Game)
(use Actor)

(public
	rm370 0
)

(local
	local0
)

(procedure (localproc_0)
	(Say &rest 67 3 15 70 61)
)

(procedure (localproc_1)
	(SetMessageColor 20)
	(Say &rest 67 250 15 70 67)
	(SetMessageColor 0)
)

(instance rm370 of Rm
	(properties
		picture 370
	)

	(method (init)
		(super init:)
		(gTheIconBar disable:)
		(SetFlag 190)
		(lobbsHead init:)
		(lobbsArm init:)
		(egoHead init:)
		(egoArm init:)
		(exitRoom init:)
		(candle init: setCycle: Fwd)
		(if (gEgo has: 15) ; comb
			(Say 1370 0) ; "***If you wish to return to Lobb's shop... Click anywhere in the room."
		)
		(gCurRoom setScript: dialogScript self)
	)

	(method (dispose)
		(if (not (gEgo has: 15)) ; comb
			(gEgo put: 3) ; slipper
			(gEgo get: 15) ; comb
			(SetScore 25 82)
		)
		(gTheIconBar enable:)
		(DisposeScript 939)
		(super dispose:)
	)
)

(instance exitRoom of Feature
	(properties
		nsBottom 189
		nsRight 319
		onMeCheck 16
	)

	(method (handleEvent event &tmp temp0)
		(if (self onMe: event)
			(gCurRoom newRoom: 360)
		)
	)
)

(instance lobbsHead of Prop
	(properties
		x 190
		y 107
		view 371
		loop 4
	)
)

(instance lobbsArm of Prop
	(properties
		x 198
		y 110
		view 371
		loop 5
	)
)

(instance egoArm of Prop
	(properties
		x 147
		y 118
		view 371
		loop 2
	)
)

(instance egoHead of Prop
	(properties
		x 145
		y 110
		view 371
		loop 1
	)
)

(instance candle of Actor
	(properties
		x 233
		y 115
		view 371
	)
)

(instance dialogScript of TScript
	(properties)

	(method (cue param1)
		(if (and argc (not param1))
			(= local0 1)
			(egoHead setCycle: 0 delete: dispose:)
			(egoArm setCycle: 0 delete: dispose:)
			(lobbsArm setCycle: 0 delete: dispose:)
			(lobbsHead setCycle: 0 delete: dispose:)
			(self dispose:)
			(gCurRoom newRoom: 360)
		else
			(super cue: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(HandsOff)
				(gGame setCursor: gTheCursor 1 160 180)
				(lobbsHead setCycle: Osc 20)
				(SetMessageColor 20)
				(Say 1370 1 self 67 249 15 70 68) ; "Forgive my caution, but the Sheriff has spies everywhere and I need to be sure of you."
				(SetMessageColor 0)
			)
			(2
				(lobbsArm setCycle: Osc 3)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 2 self) ; "So, you are the infamous Robin Hood."
			)
			(3
				(lobbsHead setCycle: 0)
				(egoHead setCycle: Osc 20)
				(lobbsArm setCycle: End)
				(localproc_0 1370 3 self) ; "None other."
			)
			(4
				(egoHead setCycle: 0)
				(lobbsHead setCycle: Osc 20)
				(egoArm setCycle: Osc 2)
				(localproc_1 1370 4 self) ; "Your disguise is...umm...interesting."
			)
			(5
				(lobbsHead setCycle: 0)
				(egoHead setCycle: Osc 20)
				(egoArm setCycle: End)
				(localproc_0 1370 5 self) ; "It serves its purpose, but the sooner I'm rid of it, the better. I've risked much to come here, Lobb."
			)
			(6
				(egoHead setCycle: 0)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 6 self) ; "Your pardon, I'll speak swiftly and to the point."
			)
			(7
				(lobbsArm setCycle: Osc 1)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 7 self) ; "Though you're known as an outlaw, it is also said that you swear fealty to King Richard."
			)
			(8
				(lobbsHead setCycle: 0)
				(lobbsArm setCycle: End)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 8 self) ; "As God is my witness, I am the King's loyal and devoted servant."
			)
			(9
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 9 self) ; "I was unjustly outlawed through treachery."
			)
			(10
				(egoArm setCycle: Osc 2)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 10 self) ; "Those who abuse their high offices with corruption and greed are my enemies--not Richard the Lionheart."
			)
			(11
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 11 self) ; "But what of the King? Have you news? Is he free yet?"
			)
			(12
				(egoHead setCycle: 0)
				(lobbsArm setCycle: Osc 2)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 12 self) ; "That, alas, is why I've called for you."
			)
			(13
				(lobbsArm setCycle: End)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 13 self) ; "Good Queen Eleanor labours to raise the 100,000 gold marks that is the ransom fee..."
			)
			(14
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 14 self) ; "but has yet been unable to raise the full amount."
			)
			(15
				(lobbsArm setCycle: Osc 3)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 15 self) ; "Prince John employs all means of political betrayal, bribery and outright theft to see that his brother is never released."
			)
			(16
				(lobbsHead setCycle: 0)
				(egoArm setCycle: Osc 2)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 16 self) ; "Shrivel his black soul!"
			)
			(17
				(egoHead setCycle: 0)
				(lobbsHead setCycle: Osc 20)
				(SetMessageColor 20)
				(Say 1370 17 self 67 230 15 70 75) ; "Aye! The Prince conspires with the Sheriff and Abbot of Nottingham."
				(SetMessageColor 0)
			)
			(18
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 18 self) ; "To the Abbot, Prince John is entrusting a treasure of 50,000 marks..."
			)
			(19
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 19 self) ; "which he has diverted away from the Queen and into his own pocket."
			)
			(20
				(lobbsArm setCycle: Osc 3)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 20 self) ; "This treasure will be sent from York, which means it must travel here along Watling Street.  If it could be captured--"
			)
			(21
				(lobbsHead setCycle: 0)
				(egoArm setCycle: Osc 2)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 21 self) ; "By the Virgin, it shall not leave Sherwood Forest except to be delivered to the Queen!"
			)
			(22
				(egoHead setCycle: 0)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 22 self) ; "It is as I hoped. You may be the only man in all of England who can bring about the King's release."
			)
			(23
				(lobbsHead setCycle: 0)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 23 self) ; "When will this treasure be sent, and how come you to know so much of these matters?"
			)
			(24
				(egoHead setCycle: 0)
				(egoArm setCycle: Osc 2)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 24 self) ; "I am but a humble servant of the Queen, as is the Lady Marian."
			)
			(25
				(egoArm setCycle: End)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 25 self) ; "Though Lady Marian is...ah.. humm... well, I shall leave it to the Lady how much you learn of her."
			)
			(26
				(lobbsArm setCycle: Osc 3)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 26 self) ; "As for the treasure, I must leave tomorrow and travel to York to learn what I can."
			)
			(27
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 27 self) ; "I'll send warning of their departure date to you through Lady Marian."
			)
			(28
				(lobbsHead setCycle: 0)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 28 self) ; "Then...I WILL see more of her?"
			)
			(29
				(egoHead setCycle: 0)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 29 self) ; "Indeed you will. Here in town, she lives the role of a demure maiden, but in the forest she-- ah...well."
			)
			(30
				(lobbsHead setCycle: 0)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 30 self) ; "She what?"
				(lobbsArm setCycle: End)
			)
			(31
				(lobbsArm setLoop: 6 x: 194 setCel: 0 setCycle: End self)
			)
			(32
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 31 self) ; "You will learn what you will learn. Take this silver comb...."
			)
			(33
				(lobbsHead setCycle: 0)
				(egoArm setLoop: 3 setCycle: End self)
			)
			(34
				(egoArm x: 149 y: 119 setCel: (gEgo lastCel:) setCycle: Beg)
				(gEgo put: 3) ; slipper
				(gEgo get: 15) ; comb
				(SetScore 25 82)
				(lobbsArm
					setLoop: 5
					x: 198
					setCel: (lobbsArm lastCel:)
					setCycle: Beg self
				)
			)
			(35
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 32 self) ; "When you give this to her, she'll know we have spoken and that you've joined us to save the King."
			)
			(36
				(lobbsHead setCycle: 0)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 33 self) ; "I could do nothing else. Where does Marian live?"
			)
			(37
				(egoHead setCycle: 0)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 34 self) ; "You will never seek her out in the town! Never!  That is far too dangerous for both of you."
			)
			(38
				(lobbsHead setCycle: Osc 20)
				(lobbsArm setCycle: Osc 1)
				(localproc_1 1370 35 self) ; "She'll await you in her sacred place, the Willow Grove upon the river."
			)
			(39
				(lobbsHead setCycle: 0)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 36 self) ; "Ah...the place of the dream..."
			)
			(40
				(egoHead setCycle: 0)
				(lobbsHead setCycle: Osc 20)
				(lobbsArm setCycle: End)
				(localproc_1 1370 37 self) ; "Beg pardon?"
			)
			(41
				(lobbsHead setCycle: 0)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 38 self) ; "Nothing. Give the Queen my word--"
			)
			(42
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 39 self) ; "I will seize this treasure in Her name, and as much other ransom as I can raise beside."
			)
			(43
				(egoHead setCycle: 0)
				(lobbsArm setCycle: Osc 3)
				(lobbsHead setCycle: Osc 20)
				(localproc_1 1370 40 self) ; "Bless you!"
			)
			(44
				(lobbsHead setCycle: 0)
				(egoHead setCycle: Osc 20)
				(localproc_0 1370 41 self) ; "And Godspeed you on your mission."
			)
			(45
				(HandsOn)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

