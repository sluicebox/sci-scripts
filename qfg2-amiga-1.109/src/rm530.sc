;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use StairScript)
(use TopWindow)
(use Flame)
(use n095)
(use Interface)
(use Feature)
(use LoadMany)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm530 0
)

(local
	djinniWarned
	djinniUrged
)

(procedure (NawarPrint)
	(nawarWindow color: 12 back: 1)
	(HighPrint &rest 35 nawarWindow 80 {Nawar:})
)

(procedure (TriedToMove event dir1 dir2 dir3)
	(event claimed: 1)
	(if (== (event type:) 64)
		(OneOf (event message:) dir1 dir2 dir3)
	)
)

(procedure (DjinniWarns correctWay)
	(switch (++ djinniWarned)
		(1
			(if correctWay
				(djinniPrint 530 0) ; "Not yet, Master! You will be seen!"
			else
				(djinniPrint 530 1) ; "No, Master! Not that way! You will be seen!"
			)
		)
		(2
			(if correctWay
				(djinniPrint 530 2) ; "Please wait until it's safe, Master! You must not be caught!"
			else
				(djinniPrint 530 3) ; "No, Master! Choose your direction carefully, or you will be caught."
			)
		)
		(3
			(gEgo setScript: egoCaughtS)
		)
	)
)

(instance nawarWindow of TopWindow
	(properties)
)

(instance rm530 of Rm
	(properties
		picture 530
		style 6
	)

	(method (init)
		(LoadMany rsVIEW 0 4 26 2 47 530 532 531 3)
		(Load rsPIC 2)
		(flame1 init:)
		(flame2 init:)
		(flame3 init:)
		(poolWater init: setCycle: Fwd)
		(fountainWater init: setCycle: Fwd)
		(eunuchGuard init: setCycle: Walk)
		(eunuch init:)
		(bigEhi init:)
		(super init:)
		(sky init:)
		(InitAddToPics
			plant
			carpet
			table
			fish
			pots
			wine
			pillows
			sconce1
			sconce2
			sconce3
			vase
			bigElow
		)
		(gCSound number: 530 loop: -1 playBed:)
		(gEgo illegalBits: 0 posn: 272 133 loop: 2 init:)
		(NormalEgo)
		(gEgo setScript: sneakThruS)
	)

	(method (dispose)
		(gCSound fade:)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit:)
		(cond
			((== (gEgo script:) egoCaughtS))
			(
				(and
					(< 5 (eunuchGuard x:) 100)
					(not (eunuchGuard loop:))
					(== (gEgo x:) 225)
				)
				(gEgo setScript: egoCaughtS)
			)
		)
	)
)

(instance sneakThruS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: comeInS self)
			)
			(1
				(= djinniWarned 0)
				(self setScript: hajibToDoorS self)
			)
			(2
				(= djinniWarned 0)
				(self setScript: crawlToTableS self)
			)
			(3
				(= djinniWarned 0)
				(self setScript: sneakToDoorS self)
			)
			(4
				(gEgo setScript: upStepsS)
				(self dispose:)
			)
		)
	)
)

(instance comeInS of Script
	(properties)

	(method (handleEvent event)
		(cond
			((TriedToMove event 6 5 4)
				(self cue:)
			)
			((!= (event type:) $0040)) ; direction
			(else
				(DjinniWarns 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(startingTimer set: startingTimer 8)
				(= cycles 5)
			)
			(1
				(NawarPrint 530 4) ; "Go quickly. Hide in the room and I will distract Hajib at the table."
				(DontMove 0)
			)
			(2
				(DontMove 1)
				(EgoGait 2 0) ; sneaking
				(gEgo setMotion: MoveTo 259 172 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance hajibToDoorS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NawarPrint 530 5) ; "Hajib, would you please come here a minute? I wish to share some words with you."
				(gEgo setMotion: MoveTo 225 181)
				(eunuch setLoop: 4 setCel: 0 cycleSpeed: 3 setCycle: End self)
				(eunuchGuard setMotion: MoveTo -10 95)
			)
			(1
				(eunuch
					setLoop: 5
					setCel: 0
					cycleSpeed: 0
					posn: (- (eunuch x:) 3) (eunuch y:)
					setCycle: End self
				)
			)
			(2
				(gEgo view: 47 setLoop: 1 setCel: 0 setCycle: End)
				(eunuch
					view: 532
					setLoop: 0
					setCel: 0
					setPri: 7
					posn: 166 140
					setCycle: Walk
					setMotion: MoveTo 276 138 self
				)
			)
			(3
				(HighPrint 530 6 80 {Hajib:}) ; "What is it, young and restless one?"
				(self dispose:)
			)
		)
	)
)

(instance crawlToTableS of Script
	(properties)

	(method (handleEvent event)
		(cond
			((TriedToMove event 7 8 1)
				(if (<= 65 (eunuchGuard x:) 255)
					(DjinniWarns 1)
				else
					(self cue:)
				)
			)
			((!= (event type:) $0040)) ; direction
			(else
				(DjinniWarns 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(delayTimer set: delayTimer 10)
				(DontMove 0)
			)
			(1
				(DontMove 1)
				(gEgo
					view: 26
					posn: (- (gEgo x:) 12) (+ (gEgo y:) 6)
					setLoop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 110 155 self
				)
				(delayTimer dispose:)
				(returnTimer setCycle: returnTimer 55)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sneakToDoorS of Script
	(properties)

	(method (handleEvent event)
		(cond
			((TriedToMove event 7 8 1)
				(if (<= 160 (eunuchGuard x:) 255)
					(self cue:)
				else
					(DjinniWarns 1)
				)
			)
			((!= (event type:) $0040)) ; direction
			(else
				(DjinniWarns 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(delayTimer set: delayTimer 14)
				(DontMove 0)
			)
			(1
				(DontMove 1)
				(gEgo view: 47 setLoop: 1 setCel: 3 setCycle: Beg self)
				(delayTimer dispose:)
			)
			(2
				(= gEgoGait 2) ; sneaking
				(NormalEgo)
				(gEgo illegalBits: 0 setMotion: MoveTo 58 142 self)
			)
			(3
				(gEgo setMotion: MoveTo 72 88 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance egoCaughtS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(yawnTimer dispose:)
				(bigEhi setLoop: 2 cel: 0 setCycle: End self)
			)
			(1
				(HighPrint 530 7 80 {Eunuch:}) ; "Brothers! A stranger! Help!"
				(= cycles 1)
			)
			(2
				(eunuch setHeading: 270 self)
			)
			(3
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(= cycles 5)
			)
			(4
				(Print 530 8 #mode 1 #title {You call that sneaking?}) ; "You quickly discover that despite the fact they are overweight, the Eunuch Guards know how to fight. You are quickly overwhelmed and captured."
				(= cycles 3)
			)
			(5
				(Print 530 9 #title {It's all over but the crying!} #mode 1) ; "As they start to drag you away, you here the Djinni scream "He's loose! Iblis is free!" As the walls collapse around you, you think to yourself that maybe you should have been sneakier"
				(= cycles 3)
			)
			(6
				(gCurRoom newRoom: 790)
			)
		)
	)
)

(instance upStepsS of StairScript
	(properties
		stairSize 9
		numStairs 2
	)

	(method (init)
		(= goingUp 1)
		(super init: &rest)
	)

	(method (dispose)
		(gCurRoom newRoom: 490)
		(super dispose:)
	)
)

(instance sky of Feature
	(properties
		x 78
		y 24
		noun '/sky,star'
		nsTop 14
		nsLeft 56
		nsBottom 34
		nsRight 101
		description {the dark black sky}
		lookStr {The inky black skies of Raseir are ablaze with stars.}
	)
)

(instance yawnTimer of Timer
	(properties)

	(method (cue)
		(if (bigEhi cel:)
			(bigEhi setCel: 0)
		else
			(bigEhi setCel: 1)
		)
		(StartTimer self 10 20)
	)
)

(instance returnTimer of Timer
	(properties)

	(method (cue)
		(if (< (eunuchGuard x:) 0)
			(eunuchGuard setMotion: MoveTo 255 95)
		else
			(gEgo setScript: egoCaughtS)
		)
	)
)

(instance startingTimer of Timer
	(properties)

	(method (cue)
		(if (== (gEgo y:) 133)
			(gEgo setScript: egoCaughtS)
		)
	)
)

(instance delayTimer of Timer
	(properties)

	(method (cue)
		(if (!= (gEgo script:) egoCaughtS)
			(if (> (eunuchGuard x:) 180)
				(djinniPrint 530 10) ; "Now, hurry, Master. The guard may return any moment!"
			else
				(djinniPrint 530 11) ; "You had better find a different hiding place, Master, a man is walking back this way."
			)
			(returnTimer set: returnTimer 20)
		)
	)
)

(instance eunuch of Actor
	(properties
		x 166
		y 137
		noun '/hajib,man,eunuch'
		description {Hajib}
		lookStr {The eunuch looks like a formidable foe.}
		view 531
		loop 3
		illegalBits 0
	)
)

(instance eunuchGuard of Actor
	(properties
		x 304
		y 95
		noun '/abu,man,eunuch'
		description {the eunuch guard}
		lookStr {The eunuch guard, Abu, paces back and forth.}
		view 532
		signal 16384
		illegalBits 0
	)
)

(instance bigEhi of Prop
	(properties
		y 148
		noun '/eunuch,man'
		description {the sleeping eunuch}
		lookStr {The eunuch seems to be sleeping soundly.}
		view 531
		priority 15
		signal 16400
	)

	(method (init)
		(StartTimer yawnTimer 10 20)
		(super init: &rest)
	)
)

(instance fountainWater of Prop
	(properties
		x 213
		y 123
		noun '/fount,spray,water,spout'
		description {the fountain water}
		lookStr {The sound of the water is almost hypnotic.}
		view 530
		loop 7
		signal 16384
	)
)

(instance poolWater of Prop
	(properties
		x 228
		y 134
		noun '/fount,oasis,water,base'
		description {the fountain water}
		lookStr {The water at the base of the fountain looks cool and refreshing.}
		view 530
		loop 8
		priority 12
		signal 16400
		cycleSpeed 2
	)
)

(instance flame1 of Flame
	(properties
		x 29
		y 42
		noun '/lamp,fire,flame,torch'
		description {the torch}
		lookStr {The torch flickers calmly.}
		view 530
		loop 10
		signal 24576
	)
)

(instance flame2 of Flame
	(properties
		x 166
		y 42
		noun '/lamp,fire,flame,torch'
		description {the torch}
		lookStr {The torch flickers calmly.}
		view 530
		loop 10
		signal 24576
	)
)

(instance flame3 of Flame
	(properties
		x 218
		y 42
		noun '/lamp,fire,flame,torch'
		description {the torch}
		lookStr {The torch flickers calmly.}
		view 530
		loop 10
		signal 24576
	)
)

(instance plant of PicView
	(properties
		x 123
		y 88
		noun '/tree,bush,plant'
		description {the Raseirian Rubber Plant}
		lookStr {The Raserian Rubber Plant gets good light and air at the door.}
		view 530
		priority 1
		signal 24592
	)
)

(instance carpet of PicView
	(properties
		x 60
		y 105
		noun '/carpet,carpet'
		description {the woven carpet}
		lookStr {The carpet is finely woven of the best Shapeirian wool.}
		view 530
		loop 1
		priority 1
		signal 16400
	)
)

(instance table of PicView
	(properties
		x 110
		y 135
		noun '/table'
		description {the table}
		lookStr {The table is made of hand rubbed Iblia wood from the hills of the Forbidden City of Iblis.}
		view 530
		loop 2
		priority 9
		signal 16
	)
)

(instance fish of PicView
	(properties
		x 220
		y 173
		noun '/carp,statue,fount'
		description {the fountain}
		lookStr {The world famous Spitting Fish is the pride of Raseir.}
		view 530
		loop 3
		priority 12
		signal 16400
	)
)

(instance pots of PicView
	(properties
		x 281
		y 189
		noun '/pan,urn,bottle'
		description {the clay pots}
		lookStr {The large earthen pots probably contain water.}
		view 530
		loop 4
		priority 15
		signal 16
	)
)

(instance wine of PicView
	(properties
		x 131
		y 119
		noun '/wine,pitcher,drink'
		description {the eunuchs' wine}
		lookStr {It's a fine port, a favorite of the eunuchs, no doubt.}
		view 530
		loop 5
		priority 10
		signal 16
	)
)

(instance pillows of PicView
	(properties
		x 130
		y 148
		noun '/cushion'
		description {the pillows}
		lookStr {The big, fat pillows are for big, fat eunuchs.}
		view 530
		loop 6
		priority 9
		signal 16
	)
)

(instance sconce1 of PicView
	(properties
		x 29
		y 43
		noun '/sconce'
		description {the torch sconce}
		lookStr {The sconce holds the torch.}
		view 530
		loop 9
		priority 1
		signal 16
	)
)

(instance sconce2 of PicView
	(properties
		x 166
		y 43
		noun '/sconce'
		description {the sconce}
		lookStr {The sconce holds the torch.}
		view 530
		loop 9
		priority 1
		signal 16
	)
)

(instance sconce3 of PicView
	(properties
		x 218
		y 43
		noun '/sconce'
		description {the sconce}
		lookStr {The sconce holds the torch.}
		view 530
		loop 9
		priority 1
		signal 16
	)
)

(instance vase of PicView
	(properties
		x 306
		y 65
		noun '/bouquet,vase'
		description {the flowers}
		lookStr {A "Friendship Bouquet" brightens any day.}
		view 530
		loop 11
		priority 15
		signal 16
	)
)

(instance bigElow of PicView
	(properties
		x 31
		y 189
		noun '/eunuch,man'
		description {the sleeping eunuch}
		lookStr {The eunuch seems to be sleeping soundly.}
		view 531
		loop 1
		priority 15
		signal 16400
	)
)

