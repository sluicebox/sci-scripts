;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	rm380 0
)

(instance myConv of Conversation
	(properties)
)

(instance rm380 of KQ6Room
	(properties
		picture 380
		style 7
		walkOffEdge 1
		autoLoad 0
	)

	(method (init)
		(super init: &rest)
		(gTheIconBar
			enable:
			disable: 0 1 2 3 4 5 6
			height: -100
			activateHeight: -100
		)
		(Cursor showCursor: 0)
		(gGlobalSound number: 380 setLoop: -1 play:)
		(oracArm init: stopUpd:)
		(egoBod addToPic:)
		(egoButt addToPic:)
		(gEgo
			view: 3812
			normal: 0
			posn: 230 152
			cycleSpeed: 18
			setPri: 14
			init:
			stopUpd:
			setScript: goodNews
		)
		(gGame givePoints: 5)
	)

	(method (dispose)
		(gTheIconBar height: 0 activateHeight: 0)
		(Cursor showCursor: 1)
		(gEgo setScale: 0)
		(gTheIconBar enable: 6)
		(gGame setCursor: gWaitCursor)
		(super dispose:)
	)
)

(instance oracArm of Prop
	(properties
		x 94
		y 87
		view 3832
		signal 16384
		cycleSpeed 8
	)
)

(instance cassFace of Prop
	(properties
		x 182
		y 158
		view 384
		signal 16384
	)
)

(instance deadHead of Prop
	(properties
		x 164
		y 125
		view 3841
		signal 16384
		cycleSpeed 10
	)
)

(instance flyer of Actor
	(properties
		view 353
		signal 24576
	)
)

(instance egoBod of View
	(properties
		x 230
		y 152
		view 381
		priority 14
		signal 16400
	)
)

(instance egoButt of View
	(properties
		x 232
		y 191
		view 381
		loop 1
		priority 14
		signal 16400
	)
)

(instance goodNews of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(myConv
					add: -1 1 0 1 2 ; "Hail to thee, great Oracle! Lord Azure sends you this wingless male. It appears that he solved the Cliffs of Logic and...."
					add: -1 1 0 1 3 ; "....defeated the minotaur in his lair. So I have seen."
					add: -1 1 0 1 4 ; "So this is the one that haunts my pool of late! Welcome, young seeker. What knowledge do you desire?"
					add: -1 1 0 1 5 ; "Princess Cassima. Whatever you can tell me, great Oracle...."
					add: -1 1 0 1 6 ; "Ah! Of course, the princess! That explains my images. Let us see what we can see."
					init: self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(oracArm view: 383 setCycle: CT 3 1 self)
				(UnLoad 128 3832)
			)
			(4
				(gGlobalSound4 number: 381 setLoop: 1 play:)
				(oracArm setCycle: End self)
			)
			(5
				(oracArm view: 3832 cel: 0 stopUpd:)
				(UnLoad 128 383)
				(= seconds 1)
			)
			(6
				(cassFace init: setCycle: End self)
				(gGlobalSound4 number: 382 setLoop: 1 play:)
			)
			(7
				(cassFace stopUpd:)
				(= ticks 6)
			)
			(8
				(= seconds 2)
			)
			(9
				(myConv
					add: -1 1 0 1 7 ; "I see a maiden--lovely and pure, but surrounded by evil. She is a rose set amidst bitter thorns."
					add: -1 1 0 1 8 ; "It is her fate to be the pawn of dark powers..."
					add: -1 1 0 1 9 ; "...and yours to try to redeem her!"
					init: self
				)
			)
			(10
				(cassFace startUpd: setCycle: Beg self)
			)
			(11
				(myConv
					add: -1 1 0 1 10 ; "How? How do I redeem her?"
					add: -1 1 0 1 11 ; "Fate is not like the cut of a blade, young one, but rather like the myriad of paths formed when a hammer cracks ice. I will tell you what I can, but what will actually come to pass is up to you."
					add: -1 1 0 1 12 ; "I see that any attempt to reach the girl will force you into battle, a struggle against a dark force. If you lose, your life will be forfeit."
					add: -1 1 0 1 13 ; "Who must I fight?"
					add: -1 1 0 1 14 ; "A great darkness surrounds your adversary, preventing me from seeing clearly.... I can only make out the shape of a black cloak."
					add: -1 1 0 1 15 ; "But before this final struggle, I see an infiltration--a dangerous game of hide and seek in corridors filled with enemies. The risks are high, but it is the only way to reach the one you seek."
					add: -1 1 0 1 16 ; "There is more than one way into this place. Your choice will dictate much."
					add: -1 1 0 1 17 ; "What else do you see, mighty Oracle?"
					init: self
				)
			)
			(12
				(= seconds 2)
			)
			(13
				(cassFace dispose:)
				(oracArm view: 383 setCycle: CT 3 1 self)
				(UnLoad 128 384)
				(UnLoad 128 3832)
			)
			(14
				(gGlobalSound4 number: 381 setLoop: 1 play:)
				(oracArm setCycle: End self)
			)
			(15
				(oracArm view: 3832 cel: 0 stopUpd:)
				(UnLoad 128 383)
				(= seconds 1)
			)
			(16
				(deadHead init: setCycle: End self)
				(gGlobalSound4 number: 383 setLoop: 1 play:)
			)
			(17
				(deadHead dispose:)
				(UnLoad 128 3841)
				(= cycles 6)
			)
			(18
				(myConv
					add: -1 1 0 1 18 ; "<gasp> Oooh.... Such pain! I see two restless spirits crying out for revenge."
					add: -1 1 0 1 19 ; "These shades could help you destroy the dark force if they were to be brought back from their spiritual form, yet this is only one possible path to your destiny."
					add: -1 1 0 1 20 ; "I'm afraid this is getting beyond me. I know very little about the afterlife. I can only advise getting counsel from the Druids."
					add: -1 1 0 1 21 ; "Be warned--the Druids are reclusive and dangerous. They might aid you or they might destroy you. Like their island, the Druid's nature is hidden in the mists."
					init: self
				)
			)
			(19
				(gGlobalSound4 stop:)
				(= ticks 6)
			)
			(20
				(gMessager say: 1 0 1 22 self) ; "There is nothing more I can do for you except to give you this...."
			)
			(21
				(oracArm view: 3831 posn: 158 82 setCycle: CT 5 1 self)
				(UnLoad 128 383)
			)
			(22
				(gGlobalSound4 number: 924 setLoop: 1 play:)
				(oracArm view: 3831 posn: 158 82 setCycle: CT 10 1 self)
			)
			(23
				(gEgo
					view: 3811
					setLoop: 0
					cel: 2
					posn: (- (gEgo x:) 2) (gEgo y:)
				)
				(= cycles 6)
			)
			(24
				(gEgo setCycle: CT 3 1 self)
				(oracArm cel: 11)
			)
			(25
				(gEgo cel: 4)
				(= cycles 6)
			)
			(26
				(oracArm view: 3832 posn: 94 87 cel: 0 stopUpd:)
				(UnLoad 128 3831)
				(gEgo
					view: 3812
					cel: 0
					posn: (+ (gEgo x:) 2) (gEgo y:)
					stopUpd:
				)
				(= seconds 1)
			)
			(27
				(gMessager say: 1 0 1 23 self) ; "It is water from the sacred pool. That and my blessing go with you."
			)
			(28
				(= cycles 6)
			)
			(29
				(gMessager say: 1 0 1 24 self) ; "Thank you, great Oracle."
			)
			(30
				(SetFlag 3)
				(gEgo get: 40) ; sacredWater
				(oracArm dispose:)
				(gGame givePoints: 1)
				(gEgo hide:)
				(egoBod dispose:)
				(egoButt dispose:)
				(gCurRoom setScript: flyToBeach)
			)
		)
	)
)

(instance flyToBeach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom drawPic: 350 10)
				(flyer setScale: Scaler 5 4 190 0)
				(= ticks 4)
			)
			(1
				(flyer
					posn: 174 14
					setLoop: 1
					setCycle: Fwd
					setScale: Scaler 50 5 19 14
					init:
					setMotion: MoveTo 174 19 self
				)
			)
			(2
				(flyer
					setScale: Scaler 50 49 190 0
					setMotion: MoveTo 180 -10 self
				)
			)
			(3
				(gCurRoom newRoom: 300)
			)
		)
	)
)

