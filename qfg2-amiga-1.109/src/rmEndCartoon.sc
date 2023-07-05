;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 820)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use TopWindow)
(use Interface)
(use LoadMany)
(use DPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rmEndCartoon 0
)

(instance rmEndCartoon of Rm
	(properties
		picture 2
		style 6
	)

	(method (dispose)
		(LoadMany 0 964)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 4 310 344 346 450 785)
		(LoadMany rsPIC 2 300)
		(Load rsSOUND 822)
		(super init:)
		(= gEgoGait 0) ; walking
		(self setScript: endCartoon)
	)
)

(instance endCartoon of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 15)
				(gCast contains: carpet)
				(>= (carpet y:) 60)
				(not (mod (carpet y:) 20))
			)
			(Face gEgo carpet)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 820 0 #width 264 #mode 1 #time 30) ; "With the help of the Slave Woman, Mayzun, you found the Emir Ali hiding in his bedroom. With your urging (and a few sharp remarks from Mayzun), the Emir swore he'd restore the city. By the first light of dawn, the Emir Ali al-Din Hasan ordered all fighting to cease and proclaimed the evil rule of Ad Avis and Khaveen to be over. As the Emir began an incredibly dull speech, you slipped away to complete your quest."
				(= cycles 2)
			)
			(1
				(= global61 2)
				(gCurRoom picture: 300 style: 16 drawPic: 300)
				(NormalEgo)
				(gEgo
					view: 344
					loop: 0
					cel: 0
					setPri: 10
					posn: 110 174
					illegalBits: 0
					ignoreActors:
					init:
				)
				(fountain init:)
				(spout init:)
				(= seconds 2)
			)
			(2
				(HighPrint 820 1 25 15) ; "You stand beside the cracked and dry fountain in Raseir's Plaza of the Fountain. You hold in your hands the waterskin containing the Water Elemental that you captured so long ago in Shapeir."
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(3
				(HighPrint 820 2 103 25 6) ; "The Elemental, under your command, is released into the fountain."
				(gEgo cycleSpeed: 3 setLoop: 1 setCycle: Fwd)
				(= cycles 10)
			)
			(4
				(waterElem init: setCycle: Beg self)
			)
			(5
				(gEgo cycleSpeed: 1 setCycle: 0)
				(waterElem
					setLoop: 3
					cel: 4
					x: (+ (waterElem x:) 14)
					setCycle: Beg self
				)
			)
			(6
				(waterElem
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 135 166 self
				)
			)
			(7
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
				(waterElem setPri: -1 illegalBits: 0 setScript: goRound)
				(= seconds 8)
			)
			(8
				(NormalEgo)
				(gEgo
					view: 4
					loop: 4
					setPri: 10
					illegalBits: 0
					ignoreActors:
					stopUpd:
				)
				(waterskin init:)
			)
			(9
				(pouringWater init: setCycle: Fwd cycleSpeed: 2)
				(if (not gHowFast)
					(pouringWater stopUpd:)
				)
				(= seconds 3)
			)
			(10
				(spout view: 310)
				(waterElem
					cycleSpeed: 1
					loop: 2
					setCycle: End self
					setScript: 0
				)
			)
			(11
				(waterElem loop: 4 cel: 0 setCycle: End self)
			)
			(12
				(waterElem dispose:)
				(fountain view: 310)
				(= seconds 2)
				(gMiscSound number: 822 loop: -1 priority: 0 play:)
			)
			(13
				(= global61 0)
				(gCurRoom picture: 300 style: 8 drawPic: 300)
				(SolvePuzzle 656 20)
				(SkillUsed 14 200) ; honor
				(= cycles 2)
			)
			(14
				(HighPrint 820 3 25 5) ; "You stare in wonder at the powerful transformation of the Plaza by the magic of the Water Elemental."
				(= seconds 5)
			)
			(15
				(carpet
					init:
					setMotion:
						DPath
						319
						19
						291
						61
						253
						98
						190
						122
						145
						134
						130
						134
						self
				)
			)
			(16
				(Face gEgo carpet)
				(TopWindow color: 2 back: 0)
				(HighPrint 820 4 80 {Abdulla} 35 TopWindow 25 6) ; "The Sultan personally sent me to return you to his Palace, Hero of all Shapeir."
				(carpet stopUpd:)
				(self cue:)
			)
			(17
				(NormalEgo)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo (- (carpet x:) 20) (- (carpet y:) 10) self
				)
			)
			(18
				(gEgo setHeading: 135)
				(= cycles 15)
			)
			(19
				(HandsOn)
				(gCurRoom newRoom: 821) ; rmEndCartoon2
				(self dispose:)
			)
		)
	)
)

(instance goRound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(waterElem
					cycleSpeed: 0
					setMotion:
						DPath
						152
						166
						168
						166
						185
						174
						185
						181
						168
						189
						152
						189
						135
						181
						135
						174
						self
				)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance waterskin of View
	(properties
		x 99
		y 179
		view 344
		loop 3
		signal 1
	)
)

(instance fountain of View
	(properties
		x 161
		y 197
		view 450
		priority 11
		signal 16
	)
)

(instance spout of View
	(properties
		x 160
		y 186
		view 450
		cel 1
		priority 13
		signal 16
	)
)

(instance waterElem of Actor
	(properties
		x 114
		y 146
		view 346
		loop 4
		cel 4
		priority 12
		signal 16400
		cycleSpeed 1
	)
)

(instance pouringWater of Prop
	(properties
		x 159
		y 190
		view 310
		loop 1
		priority 13
		signal 16
	)
)

(instance carpet of Actor
	(properties
		x 330
		y -10
		view 785
		loop 11
		priority 7
		signal 26640
		illegalBits 0
	)
)

