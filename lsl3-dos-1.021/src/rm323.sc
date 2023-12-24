;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 323)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm323 0
)

(synonyms
	(woman attorney)
)

(local
	[string 300]
	seenMsg
	SuziState
)

(instance rm323 of Rm
	(properties
		picture 323
		west 320
	)

	(method (init)
		(Load rsVIEW 326)
		(Load rsVIEW 327)
		(Load rsSOUND 20)
		(super init:)
		(gAddToPics add: atpProps add: atpDoorNorth add: atpDoorSouth doit:)
		(aSuzi init:)
		(aChair init:)
		(self setScript: RoomScript)
		(= string 0)
		(if (!= gPrevRoomNum 325)
			(= gPrevRoomX 41)
			(= gPrevRoomY 156)
			(= gPrevLoop 0)
		)
		(if (== gEgoState 323)
			(HandsOff)
			(gEgo view: 326 setCel: 255)
			(= gPrevLoop 0)
			(RoomScript changeState: 4)
		else
			(NormalEgo)
		)
		(gEgo
			posn: gPrevRoomX gPrevRoomY
			loop: gPrevLoop
			observeBlocks: blockOne blockTwo wallBlockLeft wallBlockRight
			init:
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0002)
			(cond
				((== gLawyerState 1)
					(++ gLawyerState)
					(Print 323 0 #icon 324 5 0) ; "Oh, by the way, Mr. Laffer," says Ms. Cheatem, "according to an ancient island custom, any land owned by either or both spouses upon dissolution of the marriage becomes the exclusive property of the male member of the household."
					(Print 323 1 #icon 324 5 0) ; "Since Kalalau was the daughter of the tribal chief, and her dowry contained sizable quantities of real estate, this means you are now the owner of a considerable chunk of real estate. I'll make the necessary arrangements and have Roger, my secretary, draw up the papers for you."
					(Print 323 2 #icon 324 5 0) ; "Stop by the next time you're in the neighborhood; they shouldn't take long to prepare."
				)
				((== gLawyerState 5)
					(++ gLawyerState)
					(Print 323 3 #icon 324 5 0) ; "Oh, by the way, Mr. Laffer," says Ms. Cheatem, "the grapevine has it that you are interested in leaving your wife. Since you did pay Roger your $500.00, I'll be happy to draw up your divorce for you."
					(Print 323 4 #icon 324 5 0) ; "Stop by the next time you're in the neighborhood; it shouldn't take long to prepare."
				)
			)
			(gCurRoom newRoom: 320)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'lie')
				(cond
					((not (& (gEgo onControl:) $0004))
						(Print 323 5) ; "Walk over until you're near the front of the sofa."
					)
					((== gEgoState 1004)
						(YouAre) ; "You are."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(self changeState: 2)
					)
				)
			)
			(
				(or
					(Said 'nightstand,(get<off),(get<up),(nightstand<up)')
					(Said 'exit/barstool,barstool')
				)
				(cond
					((== gEgoState 0)
						(YouAre) ; "You are."
					)
					((!= gEgoState 1004)
						(Print 323 6) ; "How can you do that?"
					)
					(else
						(self changeState: 8)
					)
				)
			)
			((Said 'talk/woman')
				(cond
					((!= gEgoState 1004)
						(Print 323 7) ; ""Please, have a seat on the sofa, Mr. Laffer," says Ms. Cheatem."
					)
					((!= SuziState 0)
						(Print 323 8) ; "Ms. Cheatem appears to be busy right now."
					)
					((== gLawyerState 1)
						(Printf 323 9 gLaffer) ; ""Hello, Ms. Cheatem," you tell the lawyer. %s"
						(Format @string 323 10) ; "Good day, Mr. Laffer. How may I help you?"
						(SuziScript changeState: 2)
					)
					(else
						(Print 323 11) ; ""Nice day, isn't it, Ms. Cheatem?" you ask."
						(Format @string 323 12) ; "What? You want me to make small talk at $500.00 an hour?"
						(SuziScript changeState: 2)
					)
				)
			)
			((or (Said '/deed,land') (Said '//deed,land'))
				(cond
					((!= gEgoState 1004)
						(Print 323 13) ; ""Please have a seat, Mr. Laffer!" says Ms. Cheatem."
					)
					((!= SuziState 0)
						(Print 323 14) ; "She seems to be busy right now."
					)
					((== gLawyerState 1)
						(++ gLawyerState)
						(gGame changeScore: 30)
						(Print 323 15) ; "Ms. Cheatem, allow me to come right to the point. My wife, Kalalau, was a wonderful woman and brought to our marriage a considerable dowry, consisting of a few no-load mutual funds and some extensive real estate holdings."
						(Print 323 16) ; "I was wondering if there was any easy way for me to get my hands on that land. I've heard of some ancient island tradition concerning men and real property..."
						(Format @string 323 17) ; "Say no more, Mr. Laffer. I know exactly what you mean. According to ancient island custom, any land owned by either or both spouses upon dissolution of the marriage becomes the exclusive property of the male member of the household. Congratulations, Mr. Laffer. You are now the owner of a considerable chunk of Nontoonyt real estate. I'll make the necessary arrangements and have Roger, my secretary, boilerplate the papers for you."
						(SuziScript changeState: 2)
					)
					((== gLawyerState 2)
						(Format @string 323 18) ; "Thank you very much for stopping by, Mr. Laffer. Your free consultation has officially ended."
						(SuziScript changeState: 2)
					)
					(else
						(Print 323 11) ; ""Nice day, isn't it, Ms. Cheatem?" you ask."
						(Format @string 323 12) ; "What? You want me to make small talk at $500.00 an hour?"
						(SuziScript changeState: 2)
					)
				)
			)
			((or (Said '/decree') (Said '//decree'))
				(cond
					((!= gEgoState 1004)
						(Print 323 19) ; "Please have a seat, Mr. Laffer!"
					)
					((!= SuziState 0)
						(Print 323 14) ; "She seems to be busy right now."
					)
					((or (== gLawyerState 1) (== gLawyerState 2))
						(Print 323 20) ; "How exactly do I go about getting a divorce, Ms. Cheatem?"
						(Format @string 323 21) ; "It's simple, Mr. Laffer. As long as you don't expect to take your case through the local court system (which is owned lock, stock and barrel by Kalalau's father) you can just let me take care of everything. My standard divorce runs $500.00, and of course, I expect to be paid in cash."
						(SuziScript changeState: 2)
					)
					((== gLawyerState 5)
						(++ gLawyerState)
						(gGame changeScore: 40)
						(Print 323 22) ; "Isn't it time we finalized my divorce, Ms. Cheatem?"
						(Format @string 323 23) ; "Absolutely, Larry. Since you paid your $500.00 to Roger, I'll get started on it right away. The next time you're in the neighborhood, stop by his desk. It's a fairly straightforward agreement; it shouldn't take long to prepare."
						(SuziScript changeState: 2)
					)
					((== gLawyerState 6)
						(Print 323 24) ; "I was too stupid to listen the first time you told me about the divorce. Would you explain it all again, Ms. Cheatem?"
						(Format @string 323 25) ; "Absolutely not, Larry. What do you expect for only $500.00?"
						(SuziScript changeState: 2)
					)
					(else
						(Format @string 323 26) ; "Thank you very much for stopping by, Mr. Laffer. Your free consultation is now over."
						(SuziScript changeState: 2)
					)
				)
			)
			((Said '/equipment')
				(Print 323 27) ; "It's for internal use only."
				(Print 323 28 #at -1 144) ; "(Corporate internals, that is!)"
			)
			((Said '/call')
				(Print 323 29) ; "There is a telephone on the desk, but don't get any cute ideas about using it!"
			)
			((Said '/buffet,calf')
				(Print 323 30) ; "Why look! You can see right through her desktop as if it were glass!"
			)
			((Said '/barstool')
				(Print 323 31) ; "It looks comfortable."
			)
			((Said '/art')
				(Print 323 32) ; "The picture is beautiful, but you're more interested in other vistas hereabouts."
			)
			((Said '/door')
				(Print 323 33) ; "The doors are open and Ms. Cheatem expects them to stay that way!"
			)
			((Said '/cup')
				(Print 323 34) ; "Ms. Cheatem's glass-topped desk sits before her mini-blinded window overlooking the lovely toxic-waste and hyphen-removal plant."
			)
			((Said '/bookcase,bookcase,bookcase,cabinet,book')
				(Print 323 35) ; "Her shelves are filled with leather-bound legal tomes and collections of "TV Guide.""
			)
			((Said 'look>')
				(cond
					((Said '/woman,eye')
						(switch SuziState
							(1
								(Print 323 36) ; "Ms. Cheatem must feel whatever it is she's writing is more important than talking to you."
							)
							(3
								(Print 323 37) ; "Ms. Cheatem is busy right now, talking to a bigger name on line 3."
							)
							(5
								(Print 323 38) ; "How rude! She got up and walked away from her desk right in the middle of your stimulating conversation."
							)
							(6
								(Print 323 39) ; "Ms. Cheatem must have had an important incoming fax, since she had to interrupt your meeting to pick it up from the fax machine."
							)
							(else
								(Ok) ; "O.K."
								(= gPrevRoomX (gEgo x:))
								(= gPrevRoomY (gEgo y:))
								(= gPrevLoop (gEgo loop:))
								(if (== gEgoState 1004)
									(= gEgoState 323)
								)
								(gCurRoom newRoom: 325)
							)
						)
					)
					((Said '[/office,area]')
						(Print 323 40) ; "Ms. Cheatem has a nice office with a large picture window, much nicer than that cheap cubicle Chairman Kenneth gave you at Natives, Inc!"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 2)
		(switch (= state newState)
			(0
				(if (not (TestFlag 38))
					(= seconds 3)
				)
			)
			(1
				(SetFlag 38) ; beenIn323
				(Print 323 41) ; "Good day, Mr. Laffer," says the attorney from her desk with a smile, "I'm Suzi Cheatem. How may I help you?"
				(Print 323 42) ; "Please, make yourself at home. Have a seat on my couch."
			)
			(2
				(HandsOff)
				(Ok) ; "O.K."
				(gEgo illegalBits: 0)
				(cond
					((> (gEgo x:) 119)
						(gEgo setMotion: MoveTo 119 132 self)
					)
					((< (gEgo x:) 90)
						(gEgo setMotion: MoveTo 90 132 self)
					)
					(else
						(gEgo setMotion: MoveTo (gEgo x:) 132 self)
					)
				)
			)
			(3
				(gEgo view: 326 loop: 0 cel: 0 setCycle: End self)
			)
			(4
				(= gEgoState 1004)
				(User canInput: 1)
				(= cycles (Random 33 66))
			)
			(5
				(gEgo setLoop: (Random 1 4) cel: 0 setCycle: End self)
			)
			(6
				(= cycles (Random 11 33))
			)
			(7
				(gEgo setCycle: Beg self)
				(= state 3)
			)
			(8
				(HandsOff)
				(Ok) ; "O.K."
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(9
				(NormalEgo 2)
				(= gEgoState 0)
			)
		)
	)
)

(instance SuziScript of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 2 1)
		(switch (= state newState)
			(0
				(aSuzi loop: 3 setCel: 0 setCycle: 0)
				(= SuziState 0)
				(ChairScript changeState: 2)
				(= cycles 0)
				(= seconds (Random 5 10))
			)
			(1
				(cond
					((== (= SuziState (Random 0 7)) 1)
						(self changeState: 4)
					)
					((== SuziState 3)
						(self changeState: 18)
					)
					((== SuziState 5)
						(self changeState: 6)
					)
					((== SuziState 7)
						(self changeState: 16)
					)
					(else
						(self changeState: 0)
					)
				)
			)
			(2
				(= SuziState 2)
				(aSuzi view: 324 loop: 3 setCycle: Fwd)
				(= cycles (Random 11 44))
			)
			(3
				(if (== string 0)
					(if (== gLawyerState 1)
						(Format @string 323 43) ; "Well, I've certainly enjoyed our little visit together. When you're ready to do business, please come back and see me again."
					else
						(Format @string 323 44) ; "It was so nice of you to stop by again, Mr. Laffer. Please come see us again, whenever you have legal needs to be fulfilled!"
					)
				)
				(Print @string #at -1 10 #title {Suzi says} #mode 1 #icon 324 5 0)
				(if (and (== gLawyerState 1) (not seenMsg))
					(= seenMsg 1)
					(Print 323 45 #at -1 10 #title {Suzi says} #mode 1 #icon 324 5 0) ; "Oh, by the way, Mr. Laffer, did my secretary explain to you my policy concerning new clients? This first consultation is always free, but then you'll owe me for any work I do. I'm sure you understand."
				)
				(= string 0)
				(= cycles 22)
				(= state -1)
			)
			(4
				(aSuzi view: 324 loop: 4 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(self changeState: 0)
				(ChairScript cue:)
			)
			(6
				(= SuziState 0)
				(= seconds 2)
			)
			(8
				(= SuziState 5)
				(aSuzi
					view: 327
					loop: 3
					illegalBits: 0
					ignoreActors: 0
					setPri: -1
					loop: -1
					setCycle: Walk
					setMotion: MoveTo 232 125 self
				)
				(ChairScript changeState: 4)
			)
			(9
				(aSuzi setMotion: MoveTo 190 125 self)
			)
			(10
				(aSuzi setMotion: MoveTo 204 204 self)
			)
			(11
				(= cycles 15)
			)
			(12
				(= SuziState 6)
				(aSuzi loop: -1 setCycle: Walk setMotion: MoveTo 199 169 self)
			)
			(13
				(aSuzi setMotion: MoveTo 190 125 self)
			)
			(14
				(aSuzi ignoreActors: 1 setMotion: MoveTo 232 125 self)
			)
			(15
				(aSuzi setMotion: MoveTo 238 130 self)
			)
			(16
				(aSuzi
					view: 324
					posn: 242 120
					loop: 0
					cel: 0
					setPri: 13
					setCycle: End self
				)
				(ChairScript changeState: 5)
			)
			(17
				(ChairScript changeState: 0)
				(self changeState: 0)
			)
			(18
				(aSuzi view: 324 loop: 1 cel: 0 setCycle: End self)
				(ChairScript changeState: 2)
			)
			(19
				(aSuzi loop: 2 setCycle: Fwd)
				(= cycles (Random 11 33))
			)
			(20
				(aSuzi loop: 1 setCel: 255 setCycle: Beg self)
			)
			(21
				(ChairScript changeState: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance ChairScript of Script
	(properties)

	(method (changeState newState)
		(ShowState self newState 3 4)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(if (< SuziState 4)
					(self cue:)
				else
					(self changeState: 0)
				)
			)
			(2
				(aChair loop: 2 cycleSpeed: 2 setCycle: Fwd)
				(= seconds (Random 2 5))
			)
			(3
				(aChair setCel: 0 setCycle: 0)
				(self changeState: 0)
			)
			(4
				(aChair view: 329 posn: 247 133 loop: 3 stopUpd:)
				(= cycles (= seconds 0))
			)
			(5
				(aChair view: 329 loop: 0 posn: 247 133 cel: 0 setCycle: End)
			)
		)
	)
)

(instance atpProps of PV
	(properties
		y 132
		x 240
		view 329
		loop 4
		priority 10
		signal 16384
	)
)

(instance aChair of Prop
	(properties
		y 133
		x 247
		view 329
		loop 2
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 9)
	)
)

(instance aSuzi of Act
	(properties
		y 120
		x 242
		view 324
		loop 1
	)

	(method (init)
		(super init:)
		(self
			ignoreActors:
			illegalBits: 0
			setScript: SuziScript
			setPri: 11
			stopUpd:
		)
	)
)

(instance blockOne of Blk
	(properties
		top 199
		left 74
		bottom 333
		right 231
	)
)

(instance blockTwo of Blk
	(properties
		top 217
		left -20
		bottom 333
		right 333
	)
)

(instance wallBlockLeft of Blk
	(properties
		top 175
		left -20
		bottom 333
		right -3
	)
)

(instance wallBlockRight of Blk
	(properties
		left 325
		bottom 333
		right 340
	)
)

(instance aPhone of Act ; UNUSED
	(properties
		y -4
		x 152
		view 323
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self ignoreHorizon: ignoreActors: loop: 4 setPri: 5 setStep: 1 1)
	)
)

(instance atpDoorSouth of PV
	(properties
		y 103
		x 20
		view 323
		cel 3
		priority 13
		signal 16384
	)
)

(instance atpDoorNorth of PV
	(properties
		y 95
		x 41
		view 323
		loop 1
		cel 3
		priority 11
		signal 16384
	)
)

