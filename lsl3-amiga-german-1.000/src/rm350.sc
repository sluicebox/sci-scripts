;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm350 0
)

(local
	DaveTalkCounter
)

(instance rm350 of Rm
	(properties
		picture 350
		east 305
		west 355
	)

	(method (init)
		(super init:)
		(gAddToPics
			add: atpChair1
			add: atpChair2
			add: atpChair3
			add: atpChair4
			add: atpTable1
			add: atpTable2
			add: atpTenPin
			doit:
		)
		(self setScript: RoomScript)
		(aDave init:)
		(aDoor init:)
		(aPins init:)
		(if (> gMachineSpeed 16)
			(aWaterfall setCycle: Fwd isExtra: 1 init:)
		)
		(cond
			((== gPrevRoomNum 355)
				(HandsOff)
				(Load rsSOUND 350)
				(Load rsSOUND 351)
				(Load rsSOUND 11)
				(Load rsPIC 99)
				(aKen ignoreActors: setCycle: Walk setPri: 4 init:)
				(gEgo
					view: 351
					illegalBits: 0
					posn: 17 141
					setLoop: 0
					setCycle: Fwd
					setStep: 10 1
					init:
				)
				(DaveScript changeState: 3)
				(RoomScript changeState: 9)
			)
			((not (TestFlag 23))
				(HandsOff)
				(SetFlag 17)
				(SetFlag 19)
				(SetFlag 20)
				(SetFlag 21)
				(SetFlag 22)
				(SetFlag 23)
				(= gEgoState 4)
				(gEgo illegalBits: 0 loop: 1 posn: 295 144 init:)
				(RoomScript changeState: 1)
			)
			(else
				(NormalEgo 1)
				(gEgo observeControl: 16384 posn: 295 144 init:)
			)
		)
		(if (not (== gPrevRoomNum 355))
			(gMusic number: 32 loop: gBgMusicLoops play:)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'lie')
				(Print 350 0) ; ""May I please sit down in one of these chairs?" you ask Dave, the guard."
				(Print 350 1) ; "I'm sorry," says Dave. "These chairs are for visitors only, not for former employees!"
			)
			((Said 'open/door')
				(Print 350 2) ; "The door to the outside is never locked."
				(Print 350 3 #at -1 144) ; "The door to Kenneth's office is ALWAYS locked!"
			)
			((Said 'drink,drink,get,get/water')
				(Print 350 4) ; "Say, Davie, may I have a drink of this water?"
				(Print 350 5) ; "Dave responds, "That water is for our beloved employees and not for incompetent former goldbricks!""
			)
			((Said 'get')
				(Print 350 6) ; ""Get your hands off that!" cries the guard."
			)
			((Said 'give')
				(Print 350 7) ; ""Don't try to bribe me, Laffer!" replies Dave."
			)
			((Said 'talk,talk/man,guard,guard,dave,attendant')
				(switch (++ DaveTalkCounter)
					(1
						(gMusic stop:)
						(Print 350 8) ; "Hi, ya, Dave. How's it going!" you attempt to be cheerful. "May I go inside?"
						(Print 350 9) ; "Absolutely not," replies Dave. "I'd like to keep MY job here, Larry, not like SOME people I know!"
					)
					(2
						(Print 350 10) ; "Say, Dave," you smile, "have you heard that new piano player over at the casino?"
						(Print 350 11) ; "Nope," he replies, "but I've heard OF her!"
					)
					(else
						(Print 350 12) ; "Hey, Dave," you say offhandedly, "ya gettin' any lately?"
						(Print 350 13) ; "Well, I made it with that new entertainer over at the casino lounge," he grins, "but, that's no challenge. I hear every man on the island beat me to her!"
					)
				)
			)
			((or (Said '//job') (Said '/job'))
				(Print 350 14) ; "You wouldn't work for this firm again, even if they WOULD hire you!"
			)
			((or (Said '/chairman') (Said '//chairman'))
				(Print 350 15) ; "You wouldn't work for him again!"
				(Print 350 16 #at -1 144) ; "(At his request!)"
			)
			((Said 'look,look>')
				(cond
					((Said '/clit,skin,carpet,(head<skin),skin')
						(Print 350 17) ; "This was the only tiger remaining on this island."
						(Print 350 18 #at -1 144) ; "(Chairman Kenneth thought it would make a perfect throw rug!"
					)
					((Said '/barstool,book')
						(Printf 350 19 gEgoName gEgoName) ; "Nothing here is of importance to you now, %s."
					)
					((Said '/cup')
						(Print 350 20) ; "The view out the window looks much like the view immediately outside."
					)
					((Said '/flower')
						(Print 350 21) ; "Someone has reset your pins!"
					)
					((Said '/water,fountain,cascade')
						(Print 350 22) ; "Wow! Other offices just have water coolers. "Natives, Inc." has a bubbler of Perrier built into the floor!"
					)
					((Said '/buffet')
						(Print 350 23) ; "The table has four legs and rests on the floor."
					)
					((Said '/guard,guard,man,dave,attendant')
						(Print 350 24) ; "He's been behind that desk ever since you started working here."
					)
					((Said '/door')
						(Print 350 25) ; "The door to the outside is to the right. You remember vividly your last trip through the door to the left!"
					)
					((Said '[/area]')
						(Print 350 26) ; "The reception area of "Natives, Inc\05" contains a few chairs, a tigerskin rug, and a guard behind a large desk."
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gEgo setMotion: MoveTo 293 144 self)
			)
			(2
				(gEgo setMotion: MoveTo 281 144 self)
			)
			(3
				(Print 350 27) ; "Good morning, David," you tell the guard. "Another day, another dollar, eh?"
				(gEgo setMotion: MoveTo 225 166 self)
			)
			(4
				(Print 350 28) ; "Perhaps so, Larry," Dave replies, "but then again, perhaps not. Chairman Kenneth wants you to report to his office immediately."
				(gEgo setMotion: MoveTo 123 166 self)
			)
			(5
				(Print 350 29) ; ""Ok, David," you respond."
				(Print 350 30) ; "But to yourself you think, "Don't worry, it's probably nothing. I bet he wants to compliment me on my last big ad campaign.""
				(gEgo setPri: -1 setMotion: MoveTo 53 138 self)
			)
			(6
				(gEgo loop: 1)
				(aDoor setCycle: End self)
			)
			(7
				(aDoor stopUpd:)
				(gEgo setMotion: MoveTo -10 141)
			)
			(8)
			(9
				(gEgo setMotion: MoveTo 192 141 self)
				(aKen setMotion: MoveTo 35 141)
				(gMusic stop:)
				(gSoundFX number: 350 loop: 1 play:)
			)
			(10
				(gEgo
					setPri: 10
					setLoop: 1
					cel: 0
					setCycle: End
					setMotion: MoveTo 255 137 self
				)
				(aPins setCycle: End)
				(gSoundFX stop: number: 351 loop: 1 play:)
			)
			(11
				(gSoundFX fade:)
				(aPins stopUpd:)
				(gEgo stopUpd:)
				(= seconds 2)
			)
			(12
				(Printf 350 31 global304 global305) ; "%s" yells Chairman Kenneth, "another 7-10 split!"
				(= seconds 2)
			)
			(13
				(Print 350 32) ; "Davie boy," barks Kenneth, "load up my ramdisk; I'm gonna take the laptop out for a spin today!"
				(aKen setMotion: MoveTo 0 141 self)
			)
			(14
				(aKen dispose:)
				(aDoor setCycle: Beg self)
				(Print 350 33) ; "Well, well, Larry. It seems your ad campaign wasn't the only thing Chairman Kenneth didn't appreciate!"
				(Print 350 34) ; "Oh, well; you lived off your wits once, you can do it again..."
				(= seconds 3)
			)
			(15
				(gSoundFX number: 11 loop: 1 play:)
			)
			(16
				(gCurRoom drawPic: 99 6)
				(gCast eachElementDo: #hide)
				(= cycles 20)
			)
			(17
				(Print 350 35) ; "You shake the haze from your brain, slowly rise to your feet and stumble groggily outside..."
				(= gEgoState 4)
				(gCurRoom newRoom: 305)
			)
		)
	)
)

(instance atpChair1 of PicView
	(properties
		x 69
		y 124
		view 350
		cel 1
	)
)

(instance atpChair2 of PicView
	(properties
		x 256
		y 126
		view 350
		cel 2
	)
)

(instance atpChair3 of PicView
	(properties
		x 295
		y 168
		view 350
		cel 3
	)
)

(instance atpChair4 of PicView
	(properties
		x 25
		y 168
		view 350
	)
)

(instance atpTable1 of PicView
	(properties
		x 93
		y 108
		view 350
		cel 4
	)
)

(instance atpTable2 of PicView
	(properties
		x 232
		y 109
		view 350
		cel 5
	)
)

(instance aPins of Prop
	(properties
		x 222
		y 132
		view 350
		loop 2
	)

	(method (init)
		(super init:)
		(self setPri: 9 ignoreActors: stopUpd:)
	)
)

(instance atpTenPin of PicView
	(properties
		x 239
		y 148
		view 350
		loop 1
		priority 11
		signal 16384
	)
)

(instance aDave of Prop
	(properties
		x 144
		y 169
		view 353
	)

	(method (init)
		(super init:)
		(self cycleSpeed: 1 setPri: 15 setScript: DaveScript ignoreActors:)
	)
)

(instance DaveScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== 0 (aDave loop:))
			(aDave
				cel:
					(cond
						((< 80 (gEgo x:)) 0)
						((< 140 (gEgo x:)) 1)
						((< 180 (gEgo x:)) 2)
						((< 240 (gEgo x:)) 3)
						(else 4)
					)
			)
		)
	)

	(method (changeState newState &tmp DaveLoop)
		(switch (= state newState)
			(0
				(= cycles (Random 11 22))
			)
			(1
				(= seconds (Random 3 9))
				(switch (= DaveLoop (Random 0 5))
					(0
						(aDave loop: 1 setCycle: End self)
						(= seconds 0)
					)
					(1
						(aDave loop: 2 setCycle: End)
					)
					(else
						(aDave loop: 0)
						(= state -1)
					)
				)
			)
			(2
				(aDave setCycle: Beg self)
				(= state -1)
			)
			(3
				(aDave loop: 0)
				(= seconds (= cycles 0))
			)
		)
	)
)

(instance aKen of Actor
	(properties
		x 17
		y 141
		view 352
		illegalBits 0
	)
)

(instance aWaterfall of Prop
	(properties
		x 163
		y 103
		view 350
		loop 3
	)
)

(instance aDoor of Prop
	(properties
		x 29
		y 94
		view 350
		loop 4
	)

	(method (init)
		(super init:)
		(self setCel: (if (== gPrevRoomNum 355) 255 else 0) ignoreActors: stopUpd:)
	)
)

