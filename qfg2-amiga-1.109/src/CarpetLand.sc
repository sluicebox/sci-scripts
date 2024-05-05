;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 785)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use TopWindow)
(use Interface)
(use LoadMany)
(use StopWalk)
(use DPath)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	CarpetLand 0
)

(procedure (DoTalk speaker parmColor parmBack timeToCue toCue)
	(if (< argc 5)
		(= toCue 0)
	)
	(TopWindow color: parmColor back: parmBack)
	(Print
		&rest
		#font
		gUserFont
		#title
		speaker
		#window
		TopWindow
		#width
		280
		#mode
		1
		#time
		timeToCue
		#dispose
		toCue
	)
)

(instance carpet of Actor
	(properties
		x 260
		y -1
		view 785
		priority 12
		signal 26640
	)
)

(instance shameen of Actor
	(properties
		x 159
		y 161
		view 785
		loop 7
		signal 16384
	)
)

(instance shema of Actor
	(properties
		x 157
		y 155
		view 785
		loop 10
		signal 16384
	)
)

(instance abdul of Prop
	(properties
		x 176
		y 158
		view 785
		loop 5
		signal 16384
	)
)

(instance CarpetLand of Rm
	(properties
		picture 300
		style 5
	)

	(method (init)
		(Load rsSCRIPT 964)
		(LoadMany rsVIEW 785 102 301 305 300 350 302 310 357 358 359 352 353)
		(LoadMany rsSOUND 305 17 755 756 757)
		(Load rsPIC 2)
		(gCSound fade:)
		(super init:)
		(gGame setCursor: gWaitCursor 0)
		(gKeyDownHandler add: self)
		(HandsOff)
		(InitAddToPics
			alleySign
			leftShadow
			rightShadow
			leftBlock
			rightBlock
			kattaInnSign
			kattaInnDoor
			leftWallBlock
			rightWallBlock
		)
		(alichica init:)
		(sitar init:)
		(lisha init:)
		(carpet init:)
		(walkers add: man1 man2 man3 eachElementDo: #init doit:)
		(man2 setScript: moveMan2)
		(man3 setScript: moveMan3)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(event claimed: 1)
		else
			(event claimed: 1)
		)
	)

	(method (dispose)
		(DisposeScript 964)
		(gKeyDownHandler delete: self)
		(gCSound fade:)
		(walkers dispose:)
		(super dispose:)
	)
)

(instance FlyIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(SetCursor gTheCursor 0)
				(gSpareSound number: 756 loop: 1 play:)
				(carpet
					setPri: 12
					illegalBits: 0
					setStep: 5 8
					setCycle: Fwd
					setMotion: DPath 255 32 245 72 235 112 215 144 185 160 self
				)
			)
			(2
				(gSpareSound number: 755 loop: 1 play:)
				(carpet
					setLoop: 1
					cel: 0
					setCycle: End
					setMotion: MoveTo 160 160 self
				)
			)
			(3
				(carpet setCycle: CT 1 1 self)
			)
			(4
				(carpet setLoop: 6 setPri: 0)
				(gEgo
					init:
					view: 785
					loop: 2
					cel: 0
					posn: 141 152
					setScript: egoDisembark
				)
				(shameen init: setScript: shameenDisembark)
				(shema init: setScript: shemaDisembark)
				(abdul init: setScript: abdulDisembark)
				(gAddToPics add: carpet doit:)
				(watchCarpet cue:)
				(self setScript: waitOne self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance waitOne of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 4)
			)
			(1
				(gCSound number: 757 loop: -1 playBed:)
				(egoDisembark cue:)
				(shameenDisembark cue:)
				(shemaDisembark cue:)
				(abdulDisembark cue:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance egoDisembark of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gEgo posn: 141 148 setCycle: End self)
			)
			(2
				(gEgo
					setLoop: 3
					cel: 0
					x: (+ (gEgo x:) 3)
					setCycle: End self
				)
			)
			(3
				(gEgo cel: 4)
			)
			(4
				(spellSound init: play:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo
					setLoop: 4
					cycleSpeed: 2
					cel: 0
					posn: (+ (gEgo x:) 8) (- (gEgo y:) 6)
					setCycle: End self
				)
			)
			(6
				(gEgo cycleSpeed: 0)
				(shameenDisembark cue:)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance shameenDisembark of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(shameen posn: 159 161 setLoop: 7 cel: 0 setCycle: CT 5 1)
			)
			(2
				(shameen setCycle: End self)
			)
			(3
				(shemaDisembark cue:)
			)
			(4
				(shameen setLoop: 8 cel: 0 x: (- (shameen x:) 19))
				(= cycles 1)
			)
			(5
				(shameen setLoop: 8 cycleSpeed: 0 cel: 0 setCycle: CT 5 1 self)
			)
			(6
				(egoDisembark cue:)
			)
			(7
				(shameen
					cel: 5
					cycleSpeed: 0
					x: (- (shameen x:) 11)
					setCycle: End self
				)
			)
			(8
				(DoTalk {Shameen:} 15 6 9 self 785 0) ; "Now you look like a hero, Shapeir style."
			)
			(9
				(= seconds 5)
			)
			(10
				(gCurRoom drawPic: 2 6)
				(gCast eachElementDo: #hide)
				(= cycles 1)
			)
			(11
				(gCurRoom newRoom: 765) ; notice2Room
				(self dispose:)
			)
		)
	)
)

(instance shemaDisembark of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(shema setCycle: End self)
			)
			(2
				(shema
					view: 102
					setLoop: -1
					loop: 2
					cel: 0
					setCycle: Walk
					setMotion: DPath 131 153 112 172 self
				)
			)
			(3
				(shema setHeading: 360 self)
			)
			(4
				(shema view: 785 loop: 9 cel: 0)
				(shameenDisembark cue:)
			)
			(5
				(DoTalk {Shema:} 14 6 8 self 785 1) ; "No, no. That costume just will not do."
				(shema cycleSpeed: 1 setCycle: Fwd)
			)
			(6
				(shema setCycle: 0)
				(shameenDisembark cue:)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance abdulDisembark of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(abdul setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance alichicaTalks of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (<= state 2)
			(alichica loop: (if (alichica cycler:) 1 else 0))
		)
	)

	(method (changeState newState)
		(if (alichica cycler:)
			(alichica setCycle: 0)
		)
		(switch (= state newState)
			(0
				(DoTalk {Alichica:} 15 4 9 self 785 2) ; "You no gonna regret this, boss. Guaranteed the best in town or you no getta you money back."
				(alichica setCycle: Fwd)
			)
			(1
				(= seconds 4)
			)
			(2
				(DoTalk {Alichica:} 15 4 8 self 785 3) ; "How's about a nice... Wait?!... What is-a that up there?"
				(alichica setCycle: Fwd)
			)
			(3
				(alichica view: 305 setLoop: 5 stopUpd:)
				(moveMan2 cue:)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance moveMan2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(SetCursor gTheCursor 0)
				(alichica setScript: alichicaTalks)
				(man2 setMotion: DPath 157 86 157 102 128 108)
			)
			(2
				(gCurRoom setScript: watchCarpet self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance moveMan3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(man3 setMotion: MoveTo 66 162 self)
			)
			(1
				(man3 stopUpd:)
				(= cycles 3)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance watchCarpet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(snake stopExtra:)
				(= cycles 1)
			)
			(1
				(sitar setCycle: 0)
				(snakeSound fade:)
				(man1 startUpd: setHeading: 180 self)
			)
			(2
				(man1 stopUpd:)
				(man3 startUpd: setHeading: 90 self)
			)
			(3
				(man3 stopUpd:)
				(man2 startUpd: setHeading: 90 self)
			)
			(4
				(man2 stopUpd:)
				(alichica setLoop: 0)
				(= cycles 1)
			)
			(5
				(gAddToPics add: man1 man2 man3 sitar snake lisha alichica doit:)
				(= cycles 1)
			)
			(6
				(carpet setScript: FlyIn)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance kattaInnDoor of PicView
	(properties
		x 253
		y 117
		view 301
		loop 3
		priority 6
		signal 16401
	)
)

(instance alichica of Prop
	(properties
		x 89
		y 100
		view 305
		loop 1
		priority 8
		signal 16400
	)

	(method (init)
		(super init:)
		(InitAddToPics map alichicaStand backOfStand)
	)
)

(instance alichicaStand of PicView
	(properties
		x 77
		y 124
		description {Alichica's stand}
		view 300
		signal 16384
	)
)

(instance map of PicView
	(properties
		x 60
		y 90
		description {the map on the wall}
		lookStr {It is a map of the streets and alleys of Shapeir.}
		view 300
		cel 2
		signal 16384
	)
)

(instance backOfStand of PicView
	(properties
		x 92
		y 118
		z 16
		shiftClick 0
		view 300
		cel 3
		signal 16384
	)
)

(instance lisha of Prop
	(properties
		x 8
		y 168
		description {Lisha, the Flower Lady}
		lookStr {You see a charming young Katta with a smile for you.}
		view 350
		priority 12
		signal 16400
	)

	(method (init)
		(super init:)
		(InitAddToPics flowerStand)
	)
)

(instance flowerStand of PicView
	(properties
		x 20
		y 172
		description {the flower stand}
		lookStr {The flowers at the flower stand are very beautiful indeed, and the charming young Katta girl has a smile for you.}
		view 300
		loop 8
		priority 12
		signal 16400
	)
)

(instance sitar of Prop
	(properties
		x 282
		y 152
		description {Sitar, the snake charmer}
		lookStr {He looks like a charming fellow.}
		view 302
		loop 1
		cel 1
		priority 12
		signal 16912
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(snakeSound init: play:)
		(self setCycle: Fwd)
		(snake init:)
		(InitAddToPics snakeBasket snakeRug)
	)

	(method (dispose)
		(snakeSound dispose:)
		(super dispose:)
	)
)

(instance snake of Extra
	(properties
		x 267
		y 143
		description {the charmer's snake}
		view 302
		loop 2
		priority 11
		signal 16912
		cycleSpeed 2
		cycleType 2
		hesitation 1
		minCycles 0
		maxCycles 0
	)
)

(instance snakeRug of PicView
	(properties
		x 285
		y 158
		description {the snake charmer's rug}
		lookStr {The rug's design is charming.}
		view 302
		priority 0
		signal 16400
	)
)

(instance snakeBasket of PicView
	(properties
		x 266
		y 149
		description {the snake's basket}
		lookStr {It ain't much, but the snake calls it home.}
		view 302
		cel 1
		priority 11
		signal 16
	)
)

(instance kattaInnSign of PicView
	(properties
		x 255
		y 43
		description {the sign of the Katta's Tail Inn}
		view 301
		cel 6
		priority 6
		signal 16400
	)
)

(instance alleySign of PicView
	(properties
		x 160
		y 46
		description {the alley sign}
		lookStr {The symbol on the sign indicates "North".__The sign itself reads "Junub Tarik," which means "South Street."}
		view 310
		loop 2
		priority 6
		signal 16400
	)
)

(instance leftShadow of PicView
	(properties
		x 69
		y 189
		shiftClick 0
		view 300
		loop 5
		priority 0
		signal 16400
	)
)

(instance rightShadow of PicView
	(properties
		x 257
		y 189
		shiftClick 0
		view 300
		loop 5
		priority 0
		signal 16400
	)
)

(instance leftBlock of PicView
	(properties
		x 14
		y 189
		shiftClick 0
		view 300
		loop 6
		priority 15
		signal 16400
	)
)

(instance rightBlock of PicView
	(properties
		x 305
		y 189
		shiftClick 0
		view 300
		loop 6
		priority 15
		signal 16400
	)
)

(instance leftWallBlock of View
	(properties
		x 11
		y 165
		view 300
		loop 4
		priority 11
		signal 16
	)
)

(instance rightWallBlock of View
	(properties
		x 308
		y 163
		view 300
		loop 3
		priority 12
		signal 16
	)
)

(instance snakeSound of Sound
	(properties
		number 305
		priority 5
		loop -1
	)
)

(instance man1 of Actor
	(properties
		x 111
		y 120
		view 357
		loop 1
		signal 1
	)
)

(instance man2 of Actor
	(properties
		view 358
		loop 1
	)

	(method (init)
		(super init:)
		(self
			x: (if (!= gHowFast 0) 193 else 128)
			y: (if (!= gHowFast 0) 86 else 108)
			setCycle: StopWalk 352
			illegalBits: 0
		)
	)
)

(instance man3 of Actor
	(properties
		view 359
		loop 1
		cel 6
	)

	(method (init)
		(super init:)
		(self x: 106 y: 156 setCycle: StopWalk 353 illegalBits: 0)
	)
)

(instance walkers of List
	(properties)
)

(instance spellSound of Sound
	(properties
		number 17
	)
)

