;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use Talker)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm110 0
	azizaTalker 1
)

(local
	local0
	local1
)

(instance rm110 of Rm
	(properties
		picture 110
		style 9
	)

	(method (init)
		(gTheIconBar disable:)
		(HandsOff)
		(Load rsSOUND 281)
		(self setRegions: 61) ; intro
		(aziza init:)
		(super init: &rest)
		(if (== gPrevRoomNum 140)
			(gCurRoom setScript: azizaTalk)
		else
			(gLongSong client: self)
			(gCurRoom setScript: azizaMoreTalk)
		)
	)

	(method (dispose)
		(DisposeScript 35)
		(super dispose:)
	)

	(method (cue)
		(cond
			((!= (gLongSong number:) 111)
				(cond
					((or local0 (== (gLongSong prevSignal:) -1))
						(gLongSong number: 111 play: self setLoop: -1)
					)
					((== (gLongSong prevSignal:) 100)
						(= local0 1)
					)
				)
			)
			((and (== (gLongSong prevSignal:) 20) local1)
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance azizaTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(gLongSong number: 110 play: hold:)
				(gMessager say: 1 6 1 0 self) ; "I thank you, Rakeesh and my Prince, for answering my summons. I have information for both of you."
			)
			(2
				(gLongSong2 number: 281 play:)
				(aziza setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 100) ; openCart
			)
		)
	)
)

(instance azizaMoreTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(gLongSong2 number: 281 play:)
				(aziza setCycle: End self)
			)
			(2
				(table setCycle: End self init:)
			)
			(3
				(= ticks 90)
			)
			(4
				(gMessager say: 1 6 2 0 self) ; "When Ad Avis died, his magical power was released, and I could sense the moment of his death. Such a release of power could be felt by skilled magic users all over the world."
			)
			(5
				(gLongSong2 number: 281 play:)
				(aziza setCycle: End self)
			)
			(6
				(AdAvisFace setCycle: End self init:)
			)
			(7
				(AdAvisFace loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(= seconds 4)
			)
			(9
				(AdAvisFace setCycle: Beg self)
			)
			(10
				(AdAvisFace
					setLoop: 0
					setCel: (AdAvisFace lastCel:)
					setCycle: Beg self
				)
			)
			(11
				(AdAvisFace dispose:)
				(= cycles 3)
			)
			(12
				(gMessager say: 1 6 3 0 self) ; "It is very disturbing that the body of Ad Avis could not be found. Even with all my magic, I cannot determine who - or what - removed the body or what became of it afterwards."
			)
			(13
				(gLongSong2 number: 281 play:)
				(penta setCycle: End self init:)
			)
			(14
				(penta loop: 1 cel: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(15
				(penta cel: 1)
				(kreeshaFace init:)
				(= seconds 2)
			)
			(16
				(Narrator color: 37)
				(gMessager say: 2 6 4 0 self) ; "Please tell Rakeesh that he must return quickly to Tarna. There is serious talk of war here, and I think only Rakeesh can now bring peace."
			)
			(17
				(kreeshaFace dispose:)
				(penta dispose:)
				(= cycles 3)
			)
			(18
				(gMessager say: 1 6 5 0 self) ; "In three days, a magical portal will open in Shapeir to take Rakeesh back to Tarna. I suggest that if you, Prince of Shapeir, wish to truly be a hero, you accompany Rakeesh."
			)
			(19
				(Narrator color: 0)
				(= local1 1)
			)
		)
	)
)

(instance table of Prop
	(properties
		x 151
		y 125
		view 110
	)
)

(instance aziza of Prop
	(properties
		x 68
		y 130
		view 112
		priority 2
		signal 16
	)
)

(instance penta of Prop
	(properties
		x 149
		y 82
		view 116
		priority 9
		signal 16400
	)
)

(instance AdAvisFace of Prop
	(properties
		x 143
		y 121
		view 115
		priority 10
		signal 16400
	)
)

(instance kreeshaFace of Prop
	(properties
		x 153
		y 102
		view 118
		priority 10
		signal 16400
	)
)

(instance azizaTalker of Talker
	(properties
		x 48
		y 62
		view 112
		loop 2
		talkWidth 135
		color 10
		back 57
		textX 60
	)

	(method (init)
		(super init: azizaBust azizaEyes azizaMouth &rest)
	)
)

(instance azizaBust of Prop
	(properties
		view 112
		loop 2
	)
)

(instance azizaMouth of Prop
	(properties
		view 112
		loop 1
		cycleSpeed 10
	)
)

(instance azizaEyes of Prop
	(properties
		view 112
		loop 2
		cycleSpeed 30
	)
)

