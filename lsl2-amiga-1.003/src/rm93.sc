;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 93)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm93 0
)

(local
	work
)

(instance theSound of Sound
	(properties
		number 110
		priority 30
		loop -1
	)
)

(instance rm93 of Rm
	(properties
		picture 93
		style 7
	)

	(method (init)
		(Load rsVIEW 816)
		(Load rsVIEW 818)
		(Load rsVIEW 819)
		(Load rsVIEW 820)
		(Load rsSOUND 110)
		(super init:)
		(theSound play:)
		(aView1 loop: 5 cel: 0 addToPic:)
		(aView2 ignoreActors: loop: 5 cel: 1 setPri: 10 addToPic:)
		(aView3 loop: 5 cel: 2 setPri: 10 addToPic:)
		(aView4 loop: 5 cel: 3 setPri: 5 addToPic:)
		(aView5 ignoreActors: loop: 5 cel: 4 setPri: 15 addToPic:)
		(aView6 ignoreActors: loop: 5 cel: 5 setPri: 15 addToPic:)
		(aGenerator setLoop: 0 setPri: 7 init: cycleSpeed: 0 setCel: 0)
		(aRadio setLoop: 1 setPri: 4 init: cycleSpeed: 0)
		(aRightPanel1
			ignoreActors:
			setLoop: 3
			setPri: 15
			pauseCel: -1
			init:
			cycleSpeed: 0
		)
		(aRightPanel2
			ignoreActors:
			loop: 3
			setPri: 15
			pauseCel: -1
			init:
			cycleSpeed: 1
		)
		(aLeftPanel1
			ignoreActors:
			loop: 2
			cel: 1
			setPri: 15
			pauseCel: -1
			init:
			cycleSpeed: 1
		)
		(aLeftPanel2
			ignoreActors:
			setLoop: 2
			setPri: 15
			pauseCel: -1
			init:
			cycleSpeed: 1
		)
		(aDoor loop: 4 setCel: 255 setPri: 5 stopUpd: init:)
		(aGrapeWest
			ignoreActors:
			setLoop: 0
			setCycle: Fwd
			setPri: 10
			cycleSpeed: 1
			stopUpd:
			init:
		)
		(aGrapeEast
			ignoreActors:
			setLoop: 1
			setCycle: Fwd
			setPri: 10
			cycleSpeed: 1
			stopUpd:
			init:
		)
		(aFanWest
			ignoreActors:
			setLoop: 0
			setCycle: Fwd
			cycleSpeed: 2
			stopUpd:
			init:
		)
		(aFanEast
			ignoreActors:
			setLoop: 1
			setCycle: Fwd
			cycleSpeed: 3
			stopUpd:
			init:
		)
		(NormalEgo 2)
		(gEgo view: 818 posn: 84 82 init:)
		(self setScript: rm93Script)
	)
)

(instance rm93Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(gGame restart:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 86 127 self)
				(= cycles 10)
			)
			(1
				(aDoor setCycle: Beg)
			)
			(2
				(aDoor stopUpd:)
				(gEgo setMotion: MoveTo 66 160 self)
			)
			(3
				(Print 93 0 #at -1 15 #width 280 #time 10) ; "Where is that woman? Why is she so slow?" shouts Dr. Nonookee. "She should be here by now!"
				(= cycles 30)
			)
			(4
				(gEgo setMotion: MoveTo 249 160 self)
			)
			(5
				(Print 93 1 #at -1 15 #width 280 #time 5) ; "Sir," crackles the radio, "shipment incoming!"
				(Print 93 2 #at -1 20 #time 5) ; ""Ah, ha! Here she is. That's more like it!" he says."
				(= cycles 30)
			)
			(6
				(gEgo setMotion: MoveTo 225 160 self)
			)
			(7
				(gEgo setMotion: MoveTo 225 97 self)
			)
			(8
				(gEgo setMotion: MoveTo 241 93 self)
			)
			(9
				(Print 93 3 #at -1 20 #time 5) ; ""Calling LA. Calling LA." he says into the microphone."
				(Print 93 4 #at -1 20 #time 4) ; ""Yes, sir," responds a female voice on the radio."
				(Print 93 5 #at -1 15 #width 280 #time 5) ; ""Is everything in place for the transfer?" he asks."
				(Print 93 6 #at -1 20 #time 4) ; ""Everything!" she snaps back."
				(Print 93 7 #at -1 20 #time 4) ; "He smiles a broad smile."
				(Print 93 8 #at -1 15 #width 280 #time 10) ; "Excellent, LA. Keep me informed," he concludes, "and remember: no mistakes!"
				(= cycles 30)
			)
			(10
				(gEgo setMotion: MoveTo 219 99 self)
			)
			(11
				(gEgo setMotion: MoveTo 219 135 self)
			)
			(12
				(gEgo setMotion: MoveTo 161 135 self)
			)
			(13
				(gEgo setMotion: MoveTo 161 98 self)
			)
			(14
				(Print 93 9 #at -1 15 #width 280 #time 8) ; "Evidently the bad Doctor is planning something to do with Los Angeles and some sort of transfer. What could it be?"
				(= cycles 6)
			)
			(15
				(gEgo
					illegalBits: 0
					ignoreActors:
					setLoop: 4
					posn: 160 100
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
			)
			(16
				(Print 93 10 #at -1 20 #time 4 #draw) ; "FAN ME," he shouts, "AND NOW!"
				(aView7 ignoreActors: loop: 4 setPri: 6 addToPic:)
				(gEgo
					view: 820
					setLoop: 2
					setPri: 8
					posn: 161 71
					cycleSpeed: 1
				)
				(aFanEast setCycle: Fwd)
				(aFanWest setCycle: Fwd)
				(= cycles 30)
			)
			(17
				(Print 93 11 #at -1 15 #width 280 #time 5) ; "Now, feed me grapes," he orders with a sinister smile, "and keep 'em coming!"
				(= cycles 10)
			)
			(18
				(aGrapeEast setCycle: CT 4 1 self)
			)
			(19
				(gEgo setCycle: End)
				(aGrapeEast setCycle: End self)
			)
			(20
				(gEgo setCycle: Beg)
				(aGrapeEast setCycle: Beg self)
			)
			(21
				(= cycles 10)
			)
			(22
				(aGrapeWest setCycle: CT 4 1 self)
			)
			(23
				(gEgo setLoop: 3 setCycle: End)
				(aGrapeWest setCycle: End self)
			)
			(24
				(gEgo setCycle: Beg)
				(aGrapeWest setCycle: Beg self)
			)
			(25
				(= cycles 30)
			)
			(26
				(Print 93 12 #at -1 15 #width 280 #time 6) ; "Gosh, Larry; let's hope you never end up on the bad side of this character!"
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance aView1 of View
	(properties
		y 85
		x 39
		view 816
	)
)

(instance aView2 of View
	(properties
		y 107
		x 251
		view 816
	)
)

(instance aView3 of View
	(properties
		y 107
		x 291
		view 816
	)
)

(instance aView4 of View
	(properties
		y 73
		x 253
		view 816
	)
)

(instance aView5 of View
	(properties
		y 139
		x 23
		view 816
	)
)

(instance aView6 of View
	(properties
		y 139
		x 294
		view 816
	)
)

(instance aView7 of View
	(properties
		y 96
		x 161
		view 820
	)
)

(instance aGenerator of Extra
	(properties
		y 101
		x 258
		view 816
	)
)

(instance aRadio of Extra
	(properties
		y 75
		x 263
		view 816
	)
)

(instance aRightPanel1 of Extra
	(properties
		y 163
		x 267
		view 816
	)
)

(instance aRightPanel2 of Extra
	(properties
		y 151
		x 283
		view 816
	)
)

(instance aLeftPanel1 of Extra
	(properties
		y 151
		x 35
		view 816
	)
)

(instance aLeftPanel2 of Extra
	(properties
		y 163
		x 50
		view 816
	)
)

(instance aDoor of Prop
	(properties
		y 84
		x 96
		view 816
	)
)

(instance aGrapeWest of Prop
	(properties
		y 98
		x 142
		view 820
	)
)

(instance aGrapeEast of Prop
	(properties
		y 98
		x 179
		view 820
	)
)

(instance aFanWest of Prop
	(properties
		y 85
		x 132
		view 819
	)
)

(instance aFanEast of Prop
	(properties
		y 85
		x 191
		view 819
	)
)

