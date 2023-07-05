;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	[local0 58] = [2 0 175 140 2 1 175 140 2 2 175 140 2 3 175 140 2 4 175 140 2 5 175 140 2 6 175 140 2 7 175 140 2 8 175 140 0 0 175 140 0 1 175 140 0 2 175 140 0 3 175 140 0 4 175 140 -32768 600]
	local58
	local59
	local60
	local61
)

(instance rm600 of KQ6Room
	(properties
		noun 4
		picture 605
		horizon 88
		east 630
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 138 268 137 232 102 144 102 102 128 15 141
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 319 163 319 189 224 189 yourself:)
		)
		(super init: &rest)
		(SetFlag 91)
		(gGame handsOff:)
		(SetFlag 15)
		(switch gPrevRoomNum
			(630
				(gGame handsOn:)
				(gEgo init: setScale: Scaler 100 67 189 84 posn: 303 160)
			)
			(else
				(self setScript: horseToon)
			)
		)
		(deadGuy init: setScript: deadOneScript)
		(deadGuy2 init: setScript: deadTwoScript)
		(queen init: ignoreActors: 1 setScript: queenScript)
	)

	(method (newRoom newRoomNumber)
		(deadGuy setMotion: 0 setCycle: 0)
		(deadGuy2 setMotion: 0 setCycle: 0)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(super dispose:)
		(LoadMany 0 964 942)
	)
)

(instance theSky of Feature ; UNUSED
	(properties
		noun 7
		onMeCheck 16384
	)
)

(instance horse of Actor
	(properties
		x 196
		y 160
		view 606
		loop 1
	)
)

(instance queen of Actor
	(properties
		x 175
		y 140
		noun 3
		view 626
		loop 4
		cycleSpeed 30
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (gEgo has: 28) ; ticket
					(gMessager say: noun theVerb 1) ; "The spirits of Queen Allaria and King Caliphim continue their wandering. The queen acts as a silent guardian over the distraught, despairing king."
				else
					(gMessager say: noun theVerb 2) ; "Restless spirits are bound to the surface of the Underworld. Chained by earthly cares, they are unable to go below."
				)
			)
			(2 ; Talk
				(if (gEgo has: 28) ; ticket
					(gMessager say: noun theVerb 1) ; "The queen has already given Alexander her advice, and the king is too distressed to even notice Alexander's presence."
				else
					(gGame handsOff:)
					(script register: 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance deadGuy of Actor
	(properties
		x -20
		y 116
		noun 6
		view 600
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: egoIsDead 0 self)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (doit)
		(if
			(and
				(not local61)
				mover
				(not (gCurRoom script:))
				(<= (gEgo distanceTo: self) 10)
			)
			(gGame handsOff:)
			(= local58 1)
			(gCurRoom setScript: egoIsDead 0 self)
		)
		(super doit:)
	)
)

(instance deadGuy2 of Actor
	(properties
		x 341
		y 159
		noun 6
		view 602
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: egoIsDead 0 self)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (doit)
		(if
			(and
				(not local61)
				mover
				(not (gCurRoom script:))
				(<= (gEgo distanceTo: self) 10)
			)
			(gGame handsOff:)
			(= local58 1)
			(gCurRoom setScript: egoIsDead 0 self)
		)
		(super doit:)
	)
)

(instance deadOneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(if (gCurRoom script:)
					(self init:)
				else
					(= cycles 1)
				)
			)
			(2
				(while (== (= register (+ (Random 0 4) 600)) (deadGuy2 view:))
					0
				)
				(client
					view: register
					posn: 38 116
					ignoreActors: 1
					init:
					setScale: Scaler 100 67 189 84
					setCycle: Walk
					setMotion: DPath -20 116 38 116 148 122 112 158 -15 152 self
				)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance deadTwoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(if (gCurRoom script:)
					(self init:)
				else
					(= cycles 1)
				)
			)
			(2
				(while (== (= register (+ (Random 0 4) 600)) (deadGuy view:))
					0
				)
				(client
					view: register
					posn: 341 167
					ignoreActors: 1
					init:
					setScale: Scaler 100 67 189 84
					setCycle: Walk
					setMotion: DPath 331 167 149 151 108 107 -21 100 self
				)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance queenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(queen setCycle: End self)
			)
			(2
				(queen setCycle: MCyc @local0 self)
			)
			(3
				(= cycles (/ (queen cycleSpeed:) 2))
			)
			(4
				(cond
					((gCurRoom script:)
						(self start: 2 init:)
					)
					(register
						(queen setLoop: 4 cel: 0)
						(gCurRoom setScript: egoGetTicket)
					)
					(else
						(self start: 2 init:)
					)
				)
			)
		)
	)
)

(instance egoGetTicket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local59 (deadGuy mover:))
				(deadGuy mover: 0)
				(= local60 (deadGuy2 mover:))
				(deadGuy2 mover: 0)
				(gEgo setMotion: PolyPath 149 157 self)
			)
			(1
				(gEgo setHeading: 315 self)
			)
			(2
				(theConv
					add: -1 3 2 2 1 ; "(GENTLY) Who are you, grieving spirits?"
					add: -1 3 2 2 2 ; "(GHOSTLY, REMOTE) I am Queen Allaria of the Land of the Green Isles, and this beloved spirit is my husband, King Caliphim."
					add: -1 3 2 2 3 ; "(GETTING ANGRY) We were murdered in our beds by our trusted vizier. Like a viper, he snuck in during the night and stabbed us in our sleep!"
					add: -1 3 2 2 4 ; "(SORROWFUL) Now my husband's soul is broken and he will not speak."
					add: -1 3 2 2 5 ; "(EXCITED) Then you are the ones I seek. Are you not the parents of Princess Cassima?"
					add: -1 3 2 2 6 ; "(EXCITED, JOYFUL) Our daughter! Have you news of the princess?"
					add: -1 3 2 2 7 ; "(QUIETLY) I know that she is alive and safely back in her kingdom after being rescued from Mordack. But I'm afraid I have not personally seen her. Alhazred is keeping her in her room in mourning for you."
					add: -1 3 2 2 8 ; "(ANGUISHED) Oh, dreaded news! I am glad to hear of her return, but she will not be safe alone with that devil! Oh, that we could be there to protect her!"
					add: -1 3 2 2 9 ; "(DISTANTLY, HORRIBLY GUILTY/HAMLETESQUE) Cassima! How I've failed thee!"
					add: -1 3 2 2 10 ; "(SADLY) My poor husband will never rest while our murder goes unavenged and our daughter is in danger!"
					add: -1 3 2 2 11 ; "(RESOLUTELY) I came to take you back with me. Your people are still loyal to you. They need to know about the vizier. Cassima needs you, too."
					init: self
				)
			)
			(3
				(theConv
					add: -1 3 2 2 12 ; "(SURPRISED, DOUBTFUL) But this is the Realm of the Dead! We cannot leave it! Nor, for that matter, can you."
					add: -1 3 2 2 13 ; "The only one who might be able to return us all to the land of the living is the Lord of the Dead, but he would never help us. He has no mercy."
					add: -1 3 2 2 14 ; "(FIRMLY) I might be able to convince him. I must try."
					add: -1 3 2 2 15 ; "(RESIGNED, NOT HOPEFUL) Then, take this. It is my ticket to the Underworld. There you will find the Lord of the Dead."
					add: -1 3 2 2 16 ; "I cannot use the ticket as long as I'm chained here, and if we cannot be avenged, I will never be unchained."
					add: -1 3 2 2 17 ; "Thank you. Perhaps it will save us all."
					init: self
				)
			)
			(4
				(queen setLoop: 4 cel: 0 setCycle: End self)
				(gEgo normal: 0 view: 626 setLoop: 5 cel: 0)
			)
			(5
				(gEgo get: 28) ; ticket
				(gGame givePoints: 1)
				(queen setCycle: Beg self)
			)
			(6
				(gEgo reset: 7)
				(= cycles 1)
			)
			(7
				(gMessager say: 3 2 2 18 self) ; "(GENTLY, SWEETLY) Be careful, young man. If you can ease my husband's torment and help our daughter, we will be most grateful."
			)
			(8
				(gMessager say: 3 2 2 19 self) ; "I will do my best. Goodbye, Queen Allaria."
			)
			(9
				(if local59
					(deadGuy mover: local59)
				)
				(if local60
					(deadGuy2 mover: local60)
				)
				(= local59 (= local60 0))
				(= local61 0)
				(queen setScript: queenScript 0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theConv of Conversation
	(properties)
)

(instance egoIsDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(deadGuy setMotion: 0)
				(deadGuy2 setMotion: 0)
				(if local58
					(gMessager say: 5 0 3 1 self) ; "Uh, oh! One of the wandering ghouls brushes up against Alexander!"
				else
					(gMessager say: 6 5 0 1 self) ; "Alexander decides to get closer to the undead creature...."
				)
			)
			(1
				(cond
					(local58
						(= cycles 1)
					)
					((> (gEgo x:) (register x:))
						(gEgo
							setMotion:
								PolyPath
								(+ (register x:) 20)
								(register y:)
								self
						)
					)
					(else
						(gEgo
							setMotion:
								PolyPath
								(- (register x:) 20)
								(register y:)
								self
						)
					)
				)
				(gGlobalSound stop:)
				(gGlobalSound2 number: 601 play:)
			)
			(2
				(if local58
					(gMessager say: 5 0 3 2 self) ; "The touch of the putred flesh dissolves the living matter like acid!"
				else
					(gMessager say: 6 5 0 2 self) ; "A decision that was definitely not one of his best."
				)
			)
			(3
				(gEgo
					view: 606
					normal: 0
					setLoop: 0
					cel: 0
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(4
				(EgoDead 38) ; "Alexander's mother always told him to avoid bad ghouls!"
			)
		)
	)
)

(instance horseToon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(horse
					init:
					setScale: Scaler 100 67 189 84
					cel: 0
					setCycle: End self
				)
				(SetCursor 1)
			)
			(1
				(gEgo
					init:
					normal: 0
					setScale: Scaler 100 67 189 84
					view: 606
					setLoop: 2
					cel: 0
					setPri: (+ (horse priority:) 1)
					posn: (+ (horse x:) 38) (- (horse y:) 39)
					setCycle: End self
				)
				(horse
					view: 607
					setLoop: 0
					cel: 0
					posn: (+ (horse x:) 40) (+ (horse y:) 5)
				)
			)
			(2
				(gEgo reset: 7 posn: (+ (gEgo x:) 17) (+ (gEgo y:) 47))
				(= cycles 2)
			)
			(3
				(gMessager say: 5 0 4 1 self) ; "Night Mare deposits Alexander on a strange, cold world."
			)
			(4
				(horse setCycle: End self)
				(gGlobalSound fade: 0 10 20 1)
			)
			(5
				(gGlobalSound number: 600 flags: 1 play:)
				(= cycles 1)
			)
			(6
				(gMessager say: 5 0 4 2 self) ; "And some of the inhabitants don't look too friendly!"
			)
			(7
				(horse dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

