;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 860)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)

(public
	rm860 0
)

(local
	I
	L
	Q
	[saury 10]
	[nearDude 5]
	[farDude 5]
	xTimer
)

(procedure (drawNextScene whichPalette &tmp thePal)
	(= global61 whichPalette)
	(gCurRoom drawPic: 663 8)
	(if (or (== whichPalette 1) (== whichPalette 2))
		(= thePal 2)
	else
		(= thePal 1)
	)
	(waist palette: thePal)
	(saurTop palette: thePal)
	(saurBottom palette: thePal)
	(InitAddToPics waist saurTop saurBottom)
)

(procedure (createNearGuy)
	(= [nearDude L] (aNearDude new:))
	([nearDude L] init: setCycle: Fwd setMotion: MoveTo 330 122)
	(++ L)
)

(procedure (createFarGuy)
	(= [farDude Q] (aFarDude new:))
	([farDude Q] init: setCycle: Fwd setMotion: MoveTo 330 118)
	(++ Q)
)

(procedure (createNewGuy)
	((= [saury I] (aSaury new:))
		loop:
			(cond
				((or (== I 0) (== I 5)) 10)
				((or (== I 1) (== I 6)) 8)
				(else 11)
			)
		init:
		setCycle: Fwd
		setMotion: MoveTo 330 120
	)
	(++ I)
)

(instance aSaury of Actor
	(properties
		x 48
		y 120
		description {the caravan}
		view 861
		priority 2
		signal 18448
		xStep 1
	)

	(method (doit)
		(if (== (self x:) 63)
			(if (< I (+ 2 (* gHowFast 2)))
				(createNewGuy)
			)
			(if (== (self loop:) 10)
				(createFarGuy)
			)
			(if (== (self loop:) 8)
				(createNearGuy)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					((== loop 10)
						(HighPrint 860 0) ; "Centaurs are best at finding their way across the desert."
					)
					((== loop 11)
						(HighPrint 860 1) ; "The best way to get goods across the desert is by pack saurus."
					)
					(else
						(HighPrint 860 2) ; "The Bedouins of the desert are good people, for the most part."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aNearDude of Actor
	(properties
		x 69
		y 122
		noun '/man,ride,member'
		description {the rider}
		lookStr {One of the riders of the caravan.}
		view 861
		loop 8
		priority 2
		signal 18448
		xStep 1
	)
)

(instance aFarDude of Actor
	(properties
		x 69
		y 118
		noun '/man,ride,member'
		description {the rider}
		lookStr {One of the riders of the caravan.}
		view 861
		loop 8
		priority 2
		signal 18448
		illegalBits 0
		xStep 1
	)
)

(instance rm860 of Rm
	(properties
		picture 2
		style 7
	)

	(method (init)
		(LoadMany rsVIEW 860 861)
		(Load rsPIC 663)
		(Load rsSOUND 790)
		(super init:)
		(HandsOff)
		(self setScript: startIt)
	)

	(method (doit)
		(cond
			((not xTimer))
			((-- xTimer))
			(else
				(gCurRoom newRoom: 861)
			)
		)
		(super doit:)
	)
)

(instance sun of Actor
	(properties
		x 200
		y 100
		yStep 3
		view 860
		loop 8
		signal 16
	)
)

(instance torso of Prop
	(properties
		x 138
		y 178
		noun 'you,hero'
		description {yourself}
		lookStr {What a dashing foreign devil you are!}
		view 860
		loop 4
		priority 15
		signal 16
	)
)

(instance waist of PicView
	(properties
		x 140
		y 189
		noun 'you,hero'
		description {yourself}
		lookStr {What a buffed-out dude you are!}
		view 860
		loop 7
		priority 15
		signal 16400
	)
)

(instance egoHead of Prop
	(properties
		x 142
		y 130
		noun 'you,hero'
		description {yourself}
		lookStr {What a dashing foreign devil you are!}
		view 860
		priority 14
		signal 16
	)
)

(instance leftArm of Prop
	(properties
		x 161
		y 186
		noun 'you,hero'
		description {yourself}
		lookStr {Check out those biceps!}
		view 860
		loop 2
		priority 14
		signal 16
	)
)

(instance rightArm of Prop
	(properties
		x 111
		y 180
		noun 'you,hero'
		description {yourself}
		lookStr {Check out those biceps!}
		view 860
		loop 3
		priority 14
		signal 16
	)
)

(instance reins of Prop
	(properties
		x 74
		y 146
		noun '/rein'
		description {the reins}
		lookStr {Used for manual guidance of this type of ATV.}
		view 860
		loop 1
		priority 14
		signal 16
		cycleSpeed 1
	)
)

(instance saurTop of PicView
	(properties
		x 40
		y 118
		noun 'head,saurii'
		description 'the&saurii'
		lookStr {A "ship of the desert?"}
		view 860
		loop 5
		priority 15
		signal 16
	)
)

(instance saurBottom of PicView
	(properties
		x 34
		y 189
		noun 'saurii'
		description 'the&saurii'
		lookStr {Mighty muscular.}
		view 860
		loop 6
		priority 15
		signal 16
	)
)

(instance rock of Feature
	(properties
		x 233
		y 147
		noun '/boulder'
		nsTop 140
		nsLeft 209
		nsBottom 154
		nsRight 258
		description {the rock}
		lookStr {A rock by any other name....}
	)
)

(instance sky of Feature
	(properties
		x 200
		y 33
		noun '/sky'
		nsLeft 81
		nsBottom 66
		nsRight 319
		description {the crisp, morning sky}
		lookStr {The crisp, beautiful sky makes you feel glad to be alive.}
	)
)

(instance sky2 of Feature
	(properties
		x 40
		y 21
		noun '/sky'
		nsBottom 43
		nsRight 80
		description {the crisp, morning sky}
		lookStr {The crisp, beautiful sky makes you feel glad to be alive.}
	)
)

(instance dunes of Feature
	(properties
		x 200
		y 86
		noun '/hill,dune,sand'
		nsTop 67
		nsLeft 81
		nsBottom 106
		nsRight 319
		description {sand dunes}
		lookStr {The ever-changing, shifting dunes of the desert are ever shifting and changing.}
	)
)

(instance startIt of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(Print 860 3) ; "Before the sun has risen over the mountaintops, you are awakened by Shameen, who tells you that even now, the caravan to Raseir is preparing to depart."
				(= seconds 1)
			)
			(2
				(Print 860 4) ; "Shema greets you as you leave the room with some breakfast and supplies to take with you. The inn is filled with katta merchants who wish you luck upon your departure."
				(= seconds 1)
			)
			(3
				(Print 860 5) ; "As you pass through the gate of Shapeir, the gate guard presents you with a new saurus, a gift from the Sultan. Ahead in the desert sands awaits a mass of Saurii and riders being led by the Caravan Master, a huge Centaur who orders the Caravan into motion before the sun can be seen."
				(= seconds 1)
			)
			(4
				(Print 860 6) ; "You ride out to join in this new adventure, pausing only to watch the sunrise."
				(= seconds 1)
			)
			(5
				(gCSound number: 790 loop: -1 priority: 0 playBed:)
				(drawNextScene 1)
				(egoHead palette: 2 init:)
				(torso palette: 2 init:)
				(rightArm palette: 2 init:)
				(leftArm palette: 2 init:)
				(reins palette: 2 init:)
				(if (> gHowFast 0)
					(egoHead setCycle: Fwd)
					(torso setCycle: Fwd)
					(rightArm setCycle: Fwd)
					(leftArm setCycle: Fwd)
					(reins setCycle: Fwd)
				else
					(egoHead stopUpd:)
					(torso stopUpd:)
					(rightArm stopUpd:)
					(leftArm stopUpd:)
					(reins stopUpd:)
				)
				(if gHowFast
					(= seconds gHowFast)
				else
					(= cycles 1)
				)
			)
			(6
				(drawNextScene 2)
				(if gHowFast
					(= seconds gHowFast)
				else
					(= cycles 1)
				)
			)
			(7
				(drawNextScene 3)
				(egoHead palette: 1 forceUpd:)
				(torso palette: 1 forceUpd:)
				(rightArm palette: 1 forceUpd:)
				(leftArm palette: 1 forceUpd:)
				(reins palette: 1 forceUpd:)
				(sun init: setLoop: 8 setCycle: Fwd setMotion: MoveTo 160 -50)
				(if gHowFast
					(= seconds gHowFast)
				else
					(= cycles 1)
				)
			)
			(8
				(sun setMotion: 0 stopUpd:)
				(drawNextScene 0)
				(InitFeatures rock sky sky2 dunes)
				(= xTimer 150)
				(createNewGuy)
				(if gHowFast
					(= seconds (/ (+ gHowFast 1) 2))
				else
					(= cycles 1)
				)
			)
			(9
				(= gDay 18)
				(FixTime 9 0)
				(self dispose:)
			)
		)
	)
)

