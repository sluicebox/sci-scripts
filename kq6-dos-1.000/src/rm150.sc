;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use KQ6Room)
(use Conversation)
(use Motion)
(use Actor)
(use System)

(public
	rm150 0
	genie 1
)

(local
	local0
	local1
	local2
)

(instance rm150 of KQ6Room
	(properties
		picture 150
		style 6
	)

	(method (cue)
		(gCurRoom newRoom: 220)
	)

	(method (init)
		(gTheIconBar disable: 6)
		(super init: &rest)
		(gGame givePoints: 2)
		(self setScript: roomScr)
		(swordArm init:)
		(gGlobalSound number: 150 loop: -1 play: self)
	)

	(method (dispose)
		(gTheIconBar enable: 6)
		(super dispose:)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance genieHeadScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(genie init:)
				(= cycles 2)
			)
			(1
				(= start (+ state 1))
				(self dispose:)
			)
			(2
				(genie hide:)
				(if (and (- (Random 0 3) 1) (not local1))
					(= local1 1)
					(= local2 1)
					(if (Random 0 1)
						(eye1 init: cel: 0 setCycle: End self)
						(= local0 1)
					else
						(eye2 init: cel: 0 setCycle: End self)
						(= local0 0)
					)
				else
					(= local1 0)
					(+= state 2)
					(= cycles 2)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(if local0
					(eye1 dispose:)
				else
					(eye2 dispose:)
				)
				(= cycles 2)
			)
			(5
				(= start (+ state 1))
				(self dispose:)
			)
			(6
				(genie show:)
				(= cycles 2)
			)
			(7
				(= start (- state 5))
				(self dispose:)
			)
		)
	)
)

(instance genie of Prop
	(properties
		x 161
		y 82
		view 150
	)
)

(instance swordArm of Prop
	(properties
		x 291
		y 120
		view 150
		loop 7
		signal 1
	)
)

(instance eye1 of Prop
	(properties
		x 166
		y 71
		view 902
	)
)

(instance eye2 of Prop
	(properties
		x 159
		y 71
		view 902
	)
)

(instance saladineyes of Prop ; UNUSED
	(properties
		x 293
		y 4
		view 150
		loop 10
		cel 2
	)
)

(instance roomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(roomConv
					add: -1 1 0 1 1 ; "Lord Alhazred, a visitor to see you. Prince Alexander of Daventry."
					add: genieHeadScr
					add: -1 1 0 1 2 ; "What is it that you seek, Prince Alexander?"
					add: genieHeadScr
					add: -1 1 0 1 3 ; "Pardon the intrusion, my lord, but I came to see Princess Cassima. Some months ago my father, King Graham, saved my family and I from imprisonment under an evil wizard named Mordack."
					add: genieHeadScr
					add: -1 1 0 1 4 ; "The same wizard that kidnapped the princess?"
					add: genieHeadScr
					add: -1 1 0 1 5 ; "Exactly. When my father rescued us, he also liberated Cassima and sent her home."
					add: genieHeadScr
					add: -1 1 0 1 6 ; "Then your father has my gratitude, and that of the entire kingdom, but I'm afraid I still fail to see the purpose of your visit."
					add: genieHeadScr
					add: -1 1 0 1 7 ; "<ahem> Well, I came to make sure that Cassima arrived safely and to pay my respects. Before we parted, she gave me an invitation to visit."
					init: self
				)
			)
			(2
				(roomConv
					add: genieHeadScr
					add: -1 1 0 1 8 ; "I have no doubt she did exactly that at the time, Prince Alexander. However, things have greatly changed for Cassima since her ordeal in Mordack's castle."
					add: -1 1 0 1 9 ; "Cassima's parents both became ill and died while she was gone. Cassima is sequestered in mourning for them, as befits a princess. She is not receiving visitors of ANY kind."
					add: -1 1 0 1 10 ; "Even if she were, I do not think YOUR visit would be...appropriate. You see, it is time for Cassima to take her responsibilities seriously. With her parents gone, she no longer has the luxury to be a carefree maiden."
					add: -1 1 0 1 11 ; "As was her parents' wish, Cassima and I are to be wed. We shall rule the kingdom together. I assure you, our marriage is all Cassima wants now. As a prince and a gentleman, it would be best that you leave before there is any further...embarrassment."
					add: genieHeadScr
					add: -1 1 0 1 12 ; "I see. I suppose that I was mistaken. I thought for certain that Cassima.... Well, I apologize."
					add: genieHeadScr
					add: -1 1 0 1 13 ; "A young man sees what he wishes to see. I'm sorry you've wasted your time traveling to the Land of the Green Isles. May your journey home be swift."
					add: genieHeadScr
					add: -1 1 0 1 14 ; "Perhaps I will take the opportunity to look around your fair land while I'm here."
					add: genieHeadScr
					add: -1 1 0 1 15 ; "I would advise against that. The kingdom is rather, shall we say, 'inhospitable' these days. But it is YOUR neck. You may risk it if you please."
					add: -1 1 0 1 16 ; "Captain Saladin will escort you from the castle. Good day."
					add: genieHeadScr
					init: self
				)
			)
			(3
				(if (not local2)
					(if (gCast contains: genie)
						(genie dispose:)
					)
					(eye1 init: cel: 0 setCycle: End self)
				else
					(++ state)
					(= cycles 1)
				)
			)
			(4
				(eye1 dispose:)
				(= cycles 2)
			)
			(5
				(gGlobalSound4 number: 756 loop: 1 play:)
				(swordArm setCycle: End)
				(gGlobalSound fade:)
			)
		)
	)
)

