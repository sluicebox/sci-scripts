;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 861)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm861 0
)

(local
	I
	N
	H
	M
	G
	L
	Q
	R
	S
	T
	maxSaury
	maxBrigs
	[bee1 12]
	[bee2 12]
	[bee3 12]
	[saury 10]
	[brigs1 25]
	[brigs6 25]
	[nearDude 3]
	[farDude 3]
	[bee1X 11] = [36 71 86 147 188 200 239 265 284 313 5]
	[bee1Y 11] = [89 89 88 91 91 95 84 72 67 70 89]
	[bee2X 11] = [3 15 5 59 97 152 184 226 236 313 27]
	[bee2Y 11] = [109 85 71 77 86 88 86 88 84 69 76]
	[bee3X 11] = [32 45 36 81 72 150 137 190 208 194 168]
	[bee3Y 11] = [109 111 117 109 113 108 111 108 104 115 113]
	[brigs1X 3] = [320 355 340]
	[brigs1Y 3] = [108 118 128]
	[brigs2X 4] = [36 77 141 204]
	[brigs2Y 4] = [85 87 89 91]
	xTimer
)

(procedure (makeBee1)
	(for ((= R 0)) (< R maxBrigs) ((++ R))
		(= [bee1 R] (aBee1 new:))
		([bee1 R]
			x: [bee1X R]
			y: [bee1Y R]
			init:
			setCycle: Fwd
		)
	)
)

(procedure (makeBee2)
	(for ((= S 0)) (< S maxBrigs) ((++ S))
		(= [bee2 S] (aBee2 new:))
		([bee2 S] x: [bee2X S] y: [bee2Y S])
		(InitAddToPics [bee2 S])
	)
)

(procedure (makeBee3)
	(for ((= T 0)) (< T maxBrigs) ((++ T))
		(= [bee3 T] (aBee3 new:))
		([bee3 T] x: [bee3X T] y: [bee3Y T])
		(InitAddToPics [bee3 T])
	)
)

(procedure (makeBrigands1)
	(for ((= H 0)) (< H maxBrigs) ((++ H))
		((= [brigs1 N] (aBrigs1 new:))
			x: [brigs1X H]
			y: [brigs1Y H]
			init:
			setCycle: Fwd
			setMotion: MoveTo 40 108
		)
		(++ N)
	)
)

(procedure (makeBrigands2)
	(for ((= M 0)) (< M maxBrigs) ((++ M))
		((= [brigs6 G] (aBrigs6 new:))
			x: [brigs2X M]
			y: [brigs2Y M]
			init:
			setCycle: Fwd
			setMotion: MoveTo (+ 57 (* 10 G)) 125
		)
		(++ G)
	)
)

(procedure (createNearGuy)
	((= [nearDude L] (aNearDude new:))
		init:
		setCycle: Fwd
		setMotion: MoveTo 330 127
	)
	(++ L)
)

(procedure (createFarGuy)
	((= [farDude Q] (aFarDude new:))
		init:
		setCycle: Fwd
		setMotion: MoveTo 330 123
	)
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
		setMotion: MoveTo 330 125
	)
	(++ I)
)

(procedure (stopSaury)
	(for ((= I 0)) (< I (+ maxSaury 1)) ((++ I))
		(if (gCast contains: [saury I])
			([saury I] setCycle: 0 setMotion: 0 stopUpd:)
			(InitAddToPics [saury I])
		)
	)
)

(procedure (stopNearDude)
	(for ((= L 0)) (< L 2) ((++ L))
		(if (gCast contains: [nearDude L])
			([nearDude L] setCycle: 0 setMotion: 0 stopUpd:)
			(InitAddToPics [nearDude L])
		)
	)
)

(procedure (stopFarDude)
	(for ((= Q 0)) (< Q 2) ((++ Q))
		(if (gCast contains: [farDude Q])
			([farDude Q] setCycle: 0 setMotion: 0 stopUpd:)
			(InitAddToPics [farDude Q])
		)
	)
)

(procedure (disposeCaravan)
	(for ((= R 0)) (< R (+ maxSaury 1)) ((++ R))
		(if (gCast contains: [saury R])
			([saury R] dispose:)
		)
	)
	(for ((= R 0)) (< R 2) ((++ R))
		(if (gCast contains: [nearDude R])
			([nearDude R] dispose:)
		)
		(if (gCast contains: [farDude R])
			([farDude R] dispose:)
		)
	)
)

(procedure (disposeBrigands)
	(for ((= N 0)) (< N 13) ((++ N))
		(if (gCast contains: [brigs1 N])
			([brigs1 N] dispose:)
		)
		(if (gCast contains: [brigs6 N])
			([brigs6 N] dispose:)
		)
	)
)

(instance aBrigs1 of Actor
	(properties
		noun '/bandit'
		description {the brigands}
		lookStr {They look as thick as ants at a picnic, and far nastier.}
		view 861
		loop 13
		signal 18432
		illegalBits 0
		xStep 10
	)
)

(instance aBrigs6 of Actor
	(properties
		noun '/bandit'
		description {the brigands}
		lookStr {They look as thick as ants at a picnic, and far nastier.}
		yStep 5
		view 861
		loop 13
		signal 18432
		illegalBits 0
	)
)

(instance aSaury of Actor
	(properties
		x -20
		y 125
		description {the caravan}
		view 861
		signal 18432
		xStep 1
	)

	(method (doit)
		(if (== x -5)
			(if (< I maxSaury)
				(createNewGuy)
			)
			(if (== loop 10)
				(createFarGuy)
			)
			(if (== loop 8)
				(createNearGuy)
			)
		)
		(if (> x 325)
			(self setMotion: 0 setCycle: 0 dispose:)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					((== loop 10)
						(HighPrint 861 0) ; "Centaurs are best at finding their way across the desert."
					)
					((== loop 11)
						(HighPrint 861 1) ; "The only way of getting goods across the desert is by pack saurus."
					)
					(else
						(HighPrint 861 2) ; "The Bedouins of the desert are good people, for the most part."
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
		x 1
		y 127
		noun '/man,ride,member'
		description {the rider}
		lookStr {One of the riders of the caravan.}
		view 861
		loop 8
		signal 18432
		xStep 1
	)
)

(instance aFarDude of Actor
	(properties
		x 1
		y 123
		noun '/man,ride,member'
		description {the rider}
		lookStr {One of the riders of the caravan.}
		view 861
		loop 8
		signal 18432
		xStep 1
	)
)

(instance lookOut of Prop
	(properties
		x 297
		y 58
		description {the caravan}
		lookStr {The plain, Boss, the plain!__The caravan's on the plain.}
		view 861
		loop 7
	)
)

(instance rm861 of Rm
	(properties
		picture 861
		style 7
	)

	(method (init)
		(LoadMany rsVIEW 12 861 13)
		(Load rsPIC 2)
		(HandsOff)
		(= maxSaury (+ 2 (* gHowFast 2)))
		(= maxBrigs (Max 1 gHowFast))
		(nearHills init:)
		(farHills init:)
		(sky init:)
		(floor init:)
		(gEgo view: 12 setLoop: 3 yStep: 3 setPri: 11 posn: 110 240 init:)
		(super init:)
		(self setScript: joinGroup)
	)

	(method (doit)
		(cond
			((and (gCast contains: [brigs1 0]) (== ([brigs1 0] x:) 250))
				(makeBrigands1)
			)
			((and (gCast contains: [brigs1 3]) (== ([brigs1 3] x:) 250))
				(makeBrigands1)
			)
			((and (gCast contains: [brigs1 6]) (== ([brigs1 6] x:) 250))
				(makeBrigands1)
			)
			((and (gCast contains: [brigs1 9]) (== ([brigs1 9] x:) 250))
				(makeBrigands1)
			)
			((and (gCast contains: [brigs6 0]) (== ([brigs6 0] y:) 110))
				(makeBrigands2)
			)
			((and (gCast contains: [brigs6 3]) (== ([brigs6 3] y:) 110))
				(makeBrigands2)
			)
			((and (gCast contains: [brigs6 6]) (== ([brigs6 6] y:) 110))
				(makeBrigands2)
			)
		)
		(cond
			((not xTimer))
			((-- xTimer))
			(else
				(gCurRoom setScript: byeScript)
			)
		)
		(super doit:)
	)
)

(instance aBee1 of Prop
	(properties
		description {the brigand}
		lookStr {The brigands, the brigands!__Run for your lives!}
		view 861
		loop 6
	)
)

(instance aBee2 of PicView
	(properties
		description {the brigand}
		lookStr {The brigands, the brigands!__Run for your lives!}
		view 861
		loop 5
		cel 1
	)
)

(instance aBee3 of PicView
	(properties
		description {the brigand}
		lookStr {The brigands, the brigands!__Run for your lives!}
		view 861
		loop 5
		cel 2
	)
)

(instance nearHills of Feature
	(properties
		x 159
		y 85
		noun '/hill,hill'
		nsTop 72
		nsBottom 99
		nsRight 318
		description {the hills in the near distance}
		lookStr {The needle sharp hills stand in stark contrast to the desert floor.}
	)
)

(instance farHills of Feature
	(properties
		x 159
		y 59
		noun '/hill'
		nsTop 47
		nsBottom 72
		nsRight 318
		description {the distant mountains}
		lookStr {The distant mountains seem to go on forever.}
	)
)

(instance sky of Feature
	(properties
		x 159
		y 23
		noun '/sky'
		nsBottom 47
		nsRight 318
		description {the sky}
		lookStr {The crisp, clear morning sky makes you feel good to be alive.}
	)
)

(instance floor of Feature
	(properties
		x 158
		y 117
		noun '/ground,(floor<desert)'
		nsTop 103
		nsBottom 131
		nsRight 317
		description {the dry desert floor}
		lookStr {The dry, dusty desert floor looks well traveled through this narrow pass.}
	)
)

(instance joinGroup of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 110 156 self)
			)
			(1
				(gEgo setPri: 10 setMotion: MoveTo 110 213 self)
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo
					view: 13
					xStep: 1
					yStep: 1
					setLoop: 3
					setMotion: MoveTo 76 135 self
				)
				(createNewGuy)
			)
			(4
				(gEgo setPri: 8 setLoop: 6 setMotion: MoveTo 88 150 self)
			)
			(5
				(= seconds 3)
			)
			(6
				(gEgo setMotion: MoveTo 109 126 self)
			)
			(7
				(gEgo
					setPri: (+ (gEgo priority:) 1)
					setLoop: 0
					setMotion: MoveTo 330 126
				)
				(lookOut init: setCycle: Fwd)
				(self cue:)
			)
			(8
				(gCSound stop: number: 792 loop: 0 priority: 0 playBed:)
				(= seconds 7)
			)
			(9
				(stopSaury)
				(stopNearDude)
				(stopFarDude)
				(gEgo setCycle: 0 setMotion: 0)
				(if (>= gHowFast 1)
					(makeBrigands1)
					(makeBrigands2)
				)
				(= xTimer 16)
				(= cycles 2)
			)
			(10
				(makeBee1)
				(= seconds 2)
			)
			(11
				(makeBee2)
				(= seconds 2)
			)
			(12
				(makeBee3)
				(= seconds 2)
			)
			(13
				(self dispose:)
			)
		)
	)
)

(instance byeScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 861 3) ; "The caravan comes under siege from hundreds of nomadic brigands. Your small group is vastly outnumbered. The situation looks grim."
				(= seconds 1)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 2)
				(= seconds 2)
			)
			(2
				(disposeBrigands)
				(disposeCaravan)
				(= seconds 2)
			)
			(3
				(gCurRoom newRoom: 865)
				(self dispose:)
			)
		)
	)
)

