;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use Interface)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm77 0
)

(local
	work
	aCampfire
	aArm
	aKalalau
	aBearer
	aWeaver
)

(instance rm77 of Rm
	(properties
		picture 77
		horizon 50
		east 78
		south 75
		west 76
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(self setScript: rm77Script)
		(Load rsVIEW 708)
		(if gForceAtest
			(= gIslandStatus 105)
		)
		(cond
			((== gIslandStatus 104)
				(= gIslandStatus 105)
				(= gCurrentStatus 22)
				(rm77Script changeState: 11)
				(Load rsVIEW 704)
				((View new:) view: 708 setLoop: 1 posn: 165 142 addToPic:)
				((= aKalalau (Act new:))
					view: 704
					ignoreActors:
					illegalBits: 0
					loop: 3
					posn: 145 183
					setCycle: Walk
					init:
				)
				(HandsOff)
			)
			((== gIslandStatus 1)
				(= gIslandStatus 2)
				(= gCurrentStatus 11)
				(rm77Script changeState: 1)
				(Load rsVIEW 709)
				((= aCampfire (Prop new:))
					view: 708
					setLoop: 0
					setPri: 10
					posn: 165 142
					setCycle: Fwd
					init:
				)
				((View new:) view: 709 loop: 0 posn: 124 137 addToPic:)
				((View new:)
					view: 709
					ignoreActors:
					loop: 2
					posn: 160 135
					setPri: (CoordPri 138)
					addToPic:
				)
				((= aArm (Extra new:))
					view: 709
					ignoreActors:
					loop: 1
					posn: 118 123
					setPri: (CoordPri 138)
					cycleSpeed: 5
					minPause: 2
					maxPause: 10
					isExtra: 1
					init:
				)
				((= aWeaver (Extra new:))
					view: 709
					loop: 7
					posn: 153 107
					cycleSpeed: 1
					init:
				)
				((= aBearer (Act new:))
					view: 709
					ignoreActors:
					illegalBits: 0
					setLoop: 3
					setCycle: Walk
					posn: 68 144
					init:
				)
				((= aKalalau (Act new:))
					view: 704
					ignoreActors:
					illegalBits: 0
					loop: 3
					posn: 145 183
					setCycle: Walk
					init:
				)
				(HandsOff)
			)
			(else
				((View new:) view: 708 setLoop: 1 posn: 165 142 addToPic:)
				(self setRegions: 700) ; rm700
			)
		)
		(cond
			((== gPrevRoomNum 76)
				(gEgo posn: 3 143)
			)
			((== gPrevRoomNum 78)
				(gEgo posn: 318 134)
			)
			(else
				(gEgo loop: 3 posn: 165 187)
			)
		)
		(gEgo init:)
	)
)

(instance rm77Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/campfire,expectorate')
				(Print 77 0) ; "The village campfire has burned down to just a few cool ashes."
			)
			(if (Said '/ash')
				(if ((gInventory at: 30) ownedBy: gCurRoomNum) ; Ashes
					(Print 77 1) ; "Some ashes might come in handy later in the game."
				else
					(Print 77 2) ; "There are only a few left; not enough to worry about!"
				)
			)
			(if (Said '/door')
				(Print 77 3) ; "All the doors here are closed. The natives enjoy their privacy. Leave them alone."
			)
			(if (Said '[/airport,stair,angeles,hut]')
				(if ((gInventory at: 30) ownedBy: gCurRoomNum) ; Ashes
					(Print 77 4) ; "The campfire made lots of ashes."
				else
					(Print 77 5) ; "The huts are filled with the joy of aerobics. Don't disturb them."
				)
			)
		)
		(if
			(or
				(Said '(board<in),(disembark<in),climb,board/stair,hut')
				(Said 'look/cup')
				(Said 'bang,open/door')
			)
			(Print 77 6) ; "It would be better if you stayed out."
		)
		(if (Said 'get/ash')
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not ((gInventory at: 30) ownedBy: gCurRoomNum)) ; Ashes
					(AlreadyTook) ; "You already took it."
				)
				((not (gEgo inRect: 144 126 186 148))
					(NotClose) ; "You're not close enough."
				)
				(else
					(gEgo get: 30) ; Ashes
					(gGame changeScore: 6)
					(Print 77 7) ; "You bend over the firepit and scoop up huge handfuls of ashes, completely filling all of your pockets with them!"
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= cycles 3)
			)
			(2
				(aBearer setMotion: MoveTo 123 145 self)
				(= cycles 15)
			)
			(3
				(Print 77 8) ; "Attention, please!" cries Kalalau. "Gather all the villagers before the Chief's hut. We must have a celebration."
			)
			(4
				(aBearer setLoop: 4 cel: 0 setCycle: CT 7 1 self)
			)
			(5
				((View new:)
					view: 709
					ignoreActors:
					loop: 6
					posn: 137 144
					addToPic:
				)
				(aBearer setCycle: End self)
			)
			(6
				(aBearer
					setLoop: 5
					setCycle: Walk
					setMotion: MoveTo -33 145 self
				)
				(Print 77 9 #draw) ; ""Wait here while I tell everyone," says the basket carrier."
			)
			(7
				(Print 77 10) ; "Oh, Larry, I so hope you'll be able to convince my father, the Chief, that we should be married," says Kalalau. "Sometimes Daddy can have a strange sense of humor!"
				(= seconds 3)
			)
			(8
				(Print 77 11) ; "Don't worry, baby," you reassure her. "For you I would cross the burning sands of the Sahara. I would climb the highest peaks of the Himalayas. I would swim the shark-infested waters of the ocean. Why, I'd even learn desktop publishing software!"
				(= seconds 3)
			)
			(9
				(Print 77 12) ; "My hero!"
				(Print 77 13) ; "Come on, let's go meet Daddy!"
				(aKalalau setMotion: MoveTo 4 148 self)
				(gEgo setMotion: MoveTo 4 138)
			)
			(10
				(gCurRoom newRoom: 76)
			)
			(11
				(= seconds 3)
			)
			(12
				(Print 77 14) ; "I'll go get Daddy; you notify the village. Have everyone assemble before the witch doctor's hut! Oh, Larry; I'm so excited!!"
				(Print 77 15) ; "Just think; I'll be Mrs. Larry; Mrs. Larry Laffer!"
				(aKalalau setMotion: MoveTo -5 132 self)
			)
			(13
				(Print 77 16) ; "Friends, natives, countrymen: lend me your ears."
				(Print 77 17 #at -1 152) ; "(You're off to an original start!)"
				(Print 77 18 #at 15 -1 #width 280) ; "People of Nontoonyt, the evil Doctor Nonookee is gone forever, your women have been freed and are returning here now, and you are again free to travel wherever you wish! Since I have met all the conditions of Chief Keneewauwau, Kalalau and I will be married! Please assemble for the wedding!!"
				(Print 77 19 #at -1 152) ; "(You hear the muffled sounds of cheers.)"
				(gCurRoom east: 0)
				(gEgo setMotion: MoveTo 345 124 self)
			)
			(14
				(Print 77 20 #at -1 20) ; "Later that day..."
				(gCurRoom newRoom: 78)
			)
		)
	)
)

