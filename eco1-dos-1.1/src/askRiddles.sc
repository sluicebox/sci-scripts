;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 142)
(include sci.sh)
(use Main)
(use rm140)
(use Interface)
(use n819)
(use Talker)
(use LoadMany)
(use User)
(use Actor)
(use System)

(public
	askRiddles 0
)

(local
	local0
)

(instance askRiddles of Script
	(properties)

	(method (init)
		(LoadMany rsVIEW 152 153 154)
		(super init: &rest)
		(HandsOff)
		(proc140_17 26 136)
		(gTheIconBar curIcon: (gTheIconBar at: 1))
		(HandsOn)
		(gTheIconBar disable: 5 0 3 4 5)
		(if (IsFlag 15)
			(gTheIconBar disable: 6)
		)
		(User canInput: 1)
		(gKeyDownHandler addToFront: client)
		(gMouseDownHandler addToFront: client)
		((ScriptID 140 13) setCycle: 0 startUpd:) ; oracle
	)

	(method (dispose)
		(gKeyDownHandler delete: client)
		(gMouseDownHandler delete: client)
		(super dispose:)
		(DisposeScript 142)
	)

	(method (handleEvent event)
		(if
			(and
				(== state 3)
				(!= (event type:) evVERB)
				(not
					(OneOf
						(event message:)
						KEY_TAB
						KEY_CONTROL
						KEY_F1
						KEY_F2
						KEY_F5
						KEY_F7
						KEY_F9
					)
				)
				(not (event modifiers:))
			)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(cond
				((== (gTheIconBar curIcon:) (gTheIconBar at: 1))
					(switch (= local0 (proc140_19 event))
						(1
							(Narrator
								posn: -1 5
								talkWidth: 224
								init: 4 0 0 18 0 140 ; "There's a symbol of a man in the mosaic picture."
							)
						)
						(2
							(Narrator
								posn: -1 5
								talkWidth: 224
								init: 4 0 0 19 0 140 ; "There's a symbol of a fish in the mosaic picture."
							)
						)
						(3
							(Narrator
								posn: -1 5
								talkWidth: 224
								init: 4 0 0 21 0 140 ; "There's a symbol of a heart in the mosaic picture."
							)
						)
						(4
							(Narrator
								posn: -1 5
								talkWidth: 224
								init: 4 0 0 22 0 140 ; "There's a symbol of a frond in the mosaic picture."
							)
						)
						(5
							(Narrator
								posn: -1 5
								talkWidth: 224
								init: 4 0 0 20 0 140 ; "There's a symbol of a dog in the mosaic picture."
							)
						)
						(0
							(if
								(not
									(InRect
										((ScriptID 140 14) nsLeft:) ; t1
										((ScriptID 140 14) nsTop:) ; t1
										((ScriptID 140 15) nsRight:) ; blankSpot
										((ScriptID 140 15) nsBottom:) ; blankSpot
										event
									)
								)
								(Narrator init: 4 0 0 52 0 140) ; "Adam is swimming in the Temple of Poseidon."
							else
								(Narrator init: 4 0 0 9 0 140) ; "The mosaic tile picture on the wall is now unscrambled. Strange symbols appear in the tile's design."
							)
						)
					)
					(= state 2)
					(= cycles 1)
				)
				((== (gTheIconBar curIcon:) (gTheIconBar at: 2))
					(proc140_18)
					(= state 3)
					(switch (= local0 (proc140_19 event))
						(1
							((ScriptID 2 1) init: 1 0 0 2 1 self 140) ; Adam, "Is the answer Man?"
						)
						(2
							((ScriptID 2 1) init: 1 0 0 3 1 self 140) ; Adam, "Is the answer Fish?"
						)
						(3
							((ScriptID 2 1) init: 1 0 0 4 1 self 140) ; Adam, "Is the answer Love?"
						)
						(4
							((ScriptID 2 1) init: 1 0 0 8 1 self 140) ; Adam, "Is the answer Frond?"
						)
						(5
							((ScriptID 2 1) init: 1 0 0 6 1 self 140) ; Adam, "Is the answer Dog?"
						)
						(0
							(Narrator
								posn: -1 5
								talkWidth: 224
								init: 4 0 0 42 self 140 ; "Place the cursor over the mosaic tile picture and click on the correct symbol to answer the riddle."
							)
							(= state -1)
						)
					)
				)
			)
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (changeState newState &tmp [temp0 500])
		(switch (= state newState)
			(0
				(if (IsFlag 30)
					((ScriptID 140 9) init: 2 0 0 23 1 self 140) ; Oracle, "Three riddles will your soul reveal, Use your heart, the truth to feel."
					(ClearFlag 30)
				else
					(= cycles 1)
				)
			)
			(1
				(if (IsFlag 31)
					((ScriptID 140 9) init: 2 0 0 16 1 self 140) ; Oracle, "Try again, the riddles wait. With your answers choose your fate."
					(ClearFlag 31)
				else
					(= cycles 1)
				)
			)
			(2
				(if (gCast contains: bubble)
					(bubble dispose:)
					(Animate (gCast elements:) 0)
				)
				(switch global118
					(1
						((ScriptID 140 9) init: 2 0 0 7 1 self 140) ; Oracle, "Here's the first riddle to master, From the picture, choose an answer."
					)
					(2
						((ScriptID 140 9) init: 2 0 0 10 1 self 140) ; Oracle, "Here's the second you must master, From the picture, choose an answer."
					)
					(3
						((ScriptID 140 9) init: 2 0 0 11 1 self 140) ; Oracle, "Here's the third and last to master, From the picture, choose an answer."
					)
					(4
						(= state 6)
						(= cycles 1)
					)
				)
			)
			(3
				(if (<= global118 3)
					(proc140_17 26 136)
					(Animate (gCast elements:) 0)
				)
				(switch global118
					(1
						(Message msgGET 140 2 0 0 4 @temp0) ; "Whose march of progress dooms us all, Lives aloof to Nature's call, Before he walks, must learn to crawl, And be a friend to great and small?"
						(Print @temp0 #icon 142 0 0 #at -1 5 #dispose)
					)
					(2
						(Message msgGET 140 2 0 0 8 @temp0) ; "What glides like a bird but does not fly, Lives and plays 'neath an emerald sky, Feels the hook's pain but cannot cry, Has no voice to question why?"
						(Print @temp0 #icon 142 0 0 #at -1 5 #dispose)
					)
					(3
						(Message msgGET 140 2 0 0 12 @temp0) ; "What reaches out to those in need, Hears the call of those who bleed, Never blindly takes in greed, Is a friend in word and deed?"
						(Print @temp0 #icon 142 0 0 #at -1 5 #dispose)
					)
				)
			)
			(4
				(if (!= global118 local0)
					(= state 9)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(5
				(switch global118
					(1
						(SetScore 5 259)
					)
					(2
						(SetScore 5 260)
					)
					(3
						(SetScore 5 261)
					)
				)
				((ScriptID 140 9) init: 2 0 0 5 1 self 140) ; Oracle, "The riddle have you answered true. A vision will I grant to you."
				(proc140_18)
			)
			(6
				(bubble
					view: (+ 151 global118)
					loop: 0
					cel: 0
					x: (- 160 (/ (CelWide (+ 151 global118) 0 0) 2))
					y: 84
					setPri: 15
					init:
					stopUpd:
				)
				(Animate (gCast elements:) 0)
				(switch global118
					(1
						((ScriptID 140 9) init: 2 0 0 6 0 self 140) ; Oracle, "Once there was a great whale King, Whose tail kept off all poisonous things. Like under glass we lived so free, From all with which man kills the seas."
					)
					(2
						((ScriptID 140 9) init: 2 0 0 9 0 self 140) ; Oracle, "And so an innocent shall fall, And become the stalker of us all. Mutated by a glowing breeze, Man makes a murderer of the seas."
					)
					(3
						((ScriptID 140 9) init: 2 0 0 13 0 self 140) ; Oracle, "A mighty King was led astray, Tricked and lured into harm's way. With all his strength he cannot free, Himself from man's machinery. Our destiny now lies with he, Foretold within the prophecy."
						(SetFlag 4)
						(SetFlag 45)
					)
				)
				(++ global118)
				(= state 1)
			)
			(7
				((ScriptID 2 1) init: 1 0 0 5 1 self 140) ; Adam, "The prophecy says a child of man might help save Eluria? Could that be me?"
			)
			(8
				((ScriptID 140 9) init: 2 0 0 14 1 self 140) ; Oracle, "Your answers show that you can see, The carelessness that haunts the seas. But the citizens must give their trust, To you alone - win them you must. This 'Sign of Trust' bring back to me, And you shall have the prophecy."
			)
			(9
				(= state 10)
				(= cycles 1)
			)
			(10
				(SetFlag 31)
				((ScriptID 140 9) init: 2 0 0 15 1 self 140) ; Oracle, "That's not the answer that I see. The ocean's voice speaks not in thee. Return when you understand the sea."
			)
			(11
				(self setScript: (ScriptID 140 16) self 1) ; closeOracle
			)
			(12
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bubble of View
	(properties)
)

