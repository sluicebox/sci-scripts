;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 585)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use DPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm585 0
)

(instance rm585 of Rm
	(properties
		picture 585
	)

	(method (init)
		(HandsOff)
		(Load rsSOUND 485)
		(Load rsSCRIPT 964)
		(Load rsPIC 99)
		(super init:)
		(aOldMan init:)
		(aWhipper init:)
		(aDrummer1 init:)
		(aDrummer2 init:)
		(aSlave init:)
		(aCornMan init:)
		(aWoman init:)
		(gEgo
			illegalBits: 0
			ignoreActors:
			view: 582
			setLoop: 5
			setCycle: Walk
			setStep: 2 2
			setPri: -1
			posn: 332 161
			init:
		)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (> gMachineSpeed 16)
			(switch (Random 1 22)
				(1
					(aOldMan setCycle: Fwd)
				)
				(2
					(aOldMan stopUpd:)
				)
				(3
					(aWhipper setCycle: End)
				)
				(4
					(aWhipper stopUpd:)
				)
				(5
					(aDrummer1 setCycle: Fwd)
				)
				(6
					(aDrummer1 stopUpd:)
				)
				(7
					(aDrummer2 setCycle: Fwd)
				)
				(8
					(aDrummer2 stopUpd:)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0)
			(1
				(Print 585 0) ; "Knocked unconscious, securely wrapped in the Amazonian woman cannibal's net, you hang over her shoulder like a sack of potatoes in an Army mess."
				(gEgo
					setMotion:
						DPath
						343
						162
						343
						162
						294
						149
						222
						112
						206
						80
						201
						72
						201
						72
						197
						58
						190
						48
				)
				(aWoman
					setMotion:
						DPath
						329
						166
						306
						154
						265
						139
						207
						107
						195
						78
						192
						63
						187
						54
						self
				)
			)
			(2
				(gCurRoom drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= seconds 3)
			)
			(3
				(Print 585 1) ; "Oh, Patti! Where will they take you? What will they do to you? What will happen to you?"
				(= seconds 3)
			)
			(4
				(Print 585 2 #at -1 144) ; "(And will there be a hairdresser available to you afterwards?)"
				(= seconds 3)
			)
			(5
				(Print 585 3) ; "You are jostled through the village, paraded about the square, handled roughly, battered and bruised, then placed inside a cage made of bamboo and leather."
				(Print 585 4) ; "...an experience not wholly unfamiliar to you!"
				(= seconds 3)
			)
			(6
				(Print 585 5 #at -1 144) ; "(You fondly recall a blind date when you were at Juilliard...)"
				(= seconds 3)
			)
			(7
				(Print 585 6) ; "As you slowly regain consciousness, the blackness leaves your brain and you realize you are no longer tied up in that net. But something tells you you are no longer alone."
				(= seconds 3)
			)
			(8
				(gMusic number: 485 loop: -1 play:)
				(DisposeScript 964)
				(gCurRoom newRoom: 590)
			)
		)
	)
)

(instance aBowl of View
	(properties
		y 114
		x 284
		view 584
		loop 7
	)

	(method (init)
		(super init:)
		(self ignoreActors: stopUpd:)
	)
)

(instance aDrummer1 of Prop
	(properties
		y 55
		x 148
		view 585
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd stopUpd:)
	)
)

(instance aDrummer2 of Prop
	(properties
		y 57
		x 255
		view 585
		loop 1
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd stopUpd:)
	)
)

(instance aOldMan of Prop
	(properties
		y 107
		x 287
		view 584
		loop 6
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance aWhipper of Prop
	(properties
		y 138
		x 86
		view 584
		loop 1
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance aSlave of Prop
	(properties
		y 135
		x 134
		view 585
		loop 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd stopUpd:)
	)
)

(instance aCornMan of Act
	(properties
		y 89
		x 89
		view 584
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self
			setPri: 3
			setLoop: 2
			setCycle: Walk
			ignoreActors:
			setScript: ManScript
		)
	)
)

(instance ManScript of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0
				(aCornMan setMotion: MoveTo 159 87 self)
			)
			(1
				(aCornMan setMotion: DPath 170 90 233 100 261 113 self)
			)
			(2
				(aCornMan setPri: -1 setLoop: 3 cel: 0 setCycle: End self)
			)
			(3
				(aCornMan setLoop: 4 setCycle: End self)
				(aBowl init:)
			)
			(4
				(aCornMan
					setCycle: Fwd
					setLoop: 5
					setMotion: DPath 233 100 170 90 122 84 self
				)
			)
			(5
				(RoomScript changeState: 1)
				(aCornMan setPri: 3 setMotion: MoveTo 84 91 self)
			)
			(6
				(aCornMan hide:)
			)
		)
	)
)

(instance aWoman of Act
	(properties
		y 163
		x 330
		view 583
	)

	(method (init)
		(super init:)
		(self setStep: 2 2 setLoop: 5 setCycle: Walk illegalBits: 0)
	)
)

