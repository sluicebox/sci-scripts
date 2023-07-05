;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 75)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm75 0
)

(local
	seenMessage
	aKalalau
	aCupidWest
	aCupidEast
	aCopter
)

(instance theSound of Sound
	(properties
		loop -1
	)
)

(instance rm75 of Rm
	(properties
		picture 75
		horizon 5
		south 74
		west 77
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(self setScript: rm75Script)
		(if gForceAtest
			(= gIslandStatus 105)
		)
		(cond
			((== gIslandStatus 0)
				(= gIslandStatus 1)
				(= gCurrentStatus 11)
				(rm75Script changeState: 1)
				(Load rsVIEW 703)
				(Load rsVIEW 704)
				(Load rsVIEW 705)
				(Load rsVIEW 706)
				(Load rsFONT 7)
				(Load rsPIC 99)
				(Load rsSOUND 116)
				(theSound number: 116 init:)
				((= aKalalau (Act new:))
					view: 705
					loop: 0
					ignoreActors:
					illegalBits: 0
					posn: 190 124
					init:
				)
				((= aCupidEast (Prop new:))
					view: 703
					ignoreActors:
					setLoop: 1
					posn: 217 127
					setCycle: Fwd
					init:
					hide:
				)
				((= aCupidWest (Prop new:))
					view: 703
					ignoreActors:
					setLoop: 0
					cel: 3
					posn: 84 127
					setCycle: Fwd
					init:
					hide:
				)
				(HandsOff)
				(gEgo posn: 115 185)
			)
			((== gIslandStatus 103)
				(= gIslandStatus 104)
				(= gCurrentStatus 22)
				(rm75Script changeState: 36)
				(Load rsVIEW 704)
				(Load rsVIEW 706)
				(Load rsVIEW 807)
				(Load rsSOUND 17)
				(theSound number: 17 play:)
				((= aCopter (Prop new:))
					view: 807
					posn: 319 136
					setCycle: Fwd
					init:
				)
				((= aKalalau (Act new:))
					view: 704
					loop: 2
					ignoreActors:
					illegalBits: 0
					posn: -11 145
					setCycle: Walk
					init:
				)
				(HandsOff)
				(gEgo posn: 327 186)
			)
			(else
				(self setRegions: 700) ; rm700
				(if (== gPrevRoomNum 77)
					(gEgo posn: 2 135)
				else
					(gEgo posn: 115 185)
				)
			)
		)
		(gEgo init:)
	)
)

(instance rm75Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0100)
			(if (== seenMessage 0)
				(= seenMessage 1)
				(Print 75 0) ; "You have no desire to return to the ocean after all you went through on that lifeboat, Larry!"
			)
		else
			(= seenMessage 0)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/water,lagoon')
				(Print 75 1) ; "The spectacular lagoon is crystal clear."
				(Print 75 2) ; "Too bad you didn't bring that swimming suit!"
			)
			(if (Said '[/airport,hill]')
				(Print 75 3) ; "In the distance you see the island's volcano ringed by a glacier, not at the top as you'd expect, but near the bottom of some vertical cliffs."
				(Print 75 4) ; "But here a beautiful, tropical beach wraps its glorious splendor around a crystalline lagoon. What a wonderful place to vacation!"
				(Print 75 5 #at -1 152) ; "(You wonder why it isn't covered with lots of cheap motels?!)"
			)
		)
		(if (and (not (gEgo has: 31)) (Said 'look/beach')) ; Sand
			(Print 75 6) ; "This sandy beach is beautiful."
		)
		(if (Said 'play,dig/beach')
			(Print 75 7) ; "Whee!"
		)
		(if (Said 'get/beach')
			(cond
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((not ((gInventory at: 31) ownedBy: gCurRoomNum)) ; Sand
					(AlreadyTook) ; "You already took it."
				)
				((not (& (gEgo onControl: 1) $4000))
					(NotClose) ; "You're not close enough."
				)
				(else
					(gEgo get: 31) ; Sand
					(gGame changeScore: 3)
					(Print 75 8) ; "You bend over and scoop up a large handful of beach sand and put it in your pockets."
					(if (> gFilthLevel 10)
						(Print 75 9 #at -1 152) ; "(At last your pants are bulging!)"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds 3)
			)
			(2
				(aKalalau cycleSpeed: 1 setCycle: End self)
			)
			(3
				(aKalalau setLoop: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(Print 75 10 #at -1 20) ; "Larry, look! Out in the surf! That beautiful native girl is waving at you, and..."
				(Print 75 11 #font 7 #at -1 20 #width 222) ; "SHE'S TOPLESS!!"
				(theSound play:)
				(= seconds 3)
			)
			(5
				(Print 75 12) ; "Gee," you think to yourself, "I thought girls like that only existed in 'National Geographic!'"
				(aKalalau setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(6
				(aKalalau
					cycleSpeed: 0
					setLoop: 2
					cel: 0
					setMotion: MoveTo 190 145
					setCycle: End self
				)
			)
			(7
				(aKalalau
					view: 704
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 190 164 self
				)
			)
			(8
				(aKalalau loop: 1)
				(gEgo setMotion: MoveTo 115 164 self)
				(Print 75 13 #draw) ; "It's love at first sight."
				(Print 75 14 #at -1 152) ; "(And also, second sight!)"
			)
			(9
				(gEgo setLoop: 0)
				(= cycles 10)
			)
			(10
				(gEgo posn: 1115 163)
				(aKalalau posn: 1190 163)
				(DrawPic 99 8)
				(= seconds 6)
			)
			(11
				(Print 75 15 #at -1 15 #width 280) ; "You think, "This is the girl I've dreamed of; the woman I've longed for; the moment I've waited for! Is this the love I've been looking for?""
				(= seconds 5)
			)
			(12
				(DrawPic 75 8)
				(gEgo posn: 115 163)
				(aKalalau posn: 190 163)
				(= seconds 3)
			)
			(13
				(gEgo view: 703 loop: 4 cel: 0 setCycle: End)
				(aKalalau view: 703 loop: 6 cel: 0 setCycle: End self)
			)
			(14
				(gEgo loop: 5 setCycle: Fwd)
				(aKalalau loop: 7 setCycle: Fwd)
				(= seconds 3)
			)
			(15
				(gEgo loop: 4 setCel: 255 setCycle: Beg)
				(aKalalau loop: 6 setCel: 255 setCycle: Beg self)
			)
			(16
				(aCupidWest show: setCycle: Fwd)
				(aCupidEast show: setCycle: Fwd)
				(gEgo view: 100 loop: 0 setLoop: -1 setCycle: Walk)
				(aKalalau view: 704 loop: 1 setLoop: -1 setCycle: Walk)
				(= seconds 4)
			)
			(17
				(aCupidEast hide:)
				(aCupidWest hide:)
				(= cycles 20)
			)
			(18
				(aCupidWest loop: 2 cel: 0 setCycle: End posn: 84 127 show:)
				(aCupidEast loop: 2 cel: 0 setCycle: End self posn: 217 127 show:)
			)
			(19
				(aCupidWest loop: 3 cel: 0 setCycle: Fwd)
				(aCupidEast loop: 3 cel: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(20
				(aCupidWest loop: 2 setCel: 255 setCycle: Beg)
				(aCupidEast loop: 2 setCel: 255 setCycle: Beg self)
			)
			(21
				(aCupidEast hide:)
				(aCupidWest hide:)
				(= cycles 20)
			)
			(22
				(aCupidWest loop: 9 cel: 0 setCycle: Fwd posn: 116 51 show:)
				(= cycles 5)
			)
			(23
				(aCupidEast loop: 8 cel: 0 setCycle: Fwd posn: 236 51 show:)
				(= cycles 41)
			)
			(24
				(aCupidEast hide:)
				(= cycles 5)
			)
			(25
				(aCupidWest hide:)
				(= cycles 20)
			)
			(26
				(Print 75 16) ; "Well, Larry? Are you just going to stand there? You've finally met the girl of your dreams, now's the time to take some action!"
				(gEgo setMotion: MoveTo 142 164)
				(aKalalau setMotion: MoveTo 158 164 self)
			)
			(27
				(aKalalau hide:)
				(gEgo
					view: 706
					setLoop: 0
					cel: 0
					posn: 151 163
					setCycle: End self
				)
			)
			(28
				(= seconds 5)
			)
			(29
				(gEgo setCycle: Beg self)
			)
			(30
				(Print 75 17 #draw) ; "You're limp. You've never been kissed like that before! Could it be? Is "Leisure Suit Larry" in love?"
				(Print 75 18 #at -1 152) ; "(Again?)"
				(aKalalau show: ignoreActors: 0)
				(gEgo
					view: gCurrentEgoView
					setLoop: -1
					loop: 0
					posn: 142 163
					setCycle: Walk
				)
				(= seconds 3)
			)
			(31
				(Print 75 19) ; "You recover enough to speak, "Ohmigosh, you're beautiful! You're wonderful! Do you understand English? What's your name? Where are you from? Are you busy tonight?""
				(Print 75 20) ; "Of course I understand English, you silly; all of us here on Nontoonyt Island do. We live in a small village just off the beach. My name is Kalalau; what's yours?"
				(Print gLaffer)
				(Print 75 21 #at 15 -1 #width 280) ; "Of course; it only stands to reason that such a lovely man would also have such a lovely name," Kalalau's smile beams, melting your heart. "But, as to your question concerning my availability tonight, I am afraid I have disappointing information for you: as enjoyable as I feel sure an evening with someone like you must be, customs here on the island forbid pre-marital dating. On Nontoonyt Island, all women save themselves for marriage."
				(Print 75 22) ; "Well, that's ok," you volunteer, "why don't we just get married instead!"
				(Print 75 23 #at 15 -1 #width 280) ; "She smiles in agreement, "Wouldn't that be wonderful! But, unfortunately our tribal elders have forbidden any new marriages until our island has been freed from its present scourge. Please permit me to elucidate: recently an abhorrent man took our island from us. He claimed our sacred ancestral burial grounds at the top of our volcano, and refuses to allow us to visit.""
				(Print 75 24 #at 15 -1 #width 280) ; "She continues, "Soon thereafter, our perpetually blue skies turned to fog. While none of us had ever seen snow or ice, suddenly a glacier appeared on the slopes of the volcano, preventing our passage to our sacred lands. A treacherous river then appeared, gouging a formidable canyon just behind our village. Then (most odious of all) he hypnotized our most beautiful women, enslaving them in his mountaintop fortress, forcing them to do his every whim, no matter how sick or repulsive.""
				(Print 75 25) ; ""What a drag!" you sympathize."
				(Print 75 26 #at 15 -1 #width 280) ; "Yes," she agrees, "but now, the worst of all: because of all this, he prevented my people from completing a megabuck deal with a large, multi-national hotel conglomerate who were prepared to turn this place into next year's trendiest tourist trap! We had it bagged: they were going to build a huge, casino/resort/hotel complex right here on this lagoon, provide employment for our lazy men in the growing field of slot-machine repair, and even fund a day-care center so, (even though we women would continue to work our normal, 16-hour days in the taro patches) at least we wouldn't have to carry our children on our backs!"
				(if (> gFilthLevel 4)
					(Print 75 27) ; "But did it happen? Hell, NO! And all because of that evil Dr. Nonookee!" she cries, suddenly turning quite sensitive. "Oh, if only some great hero could rid this island of his evilness, we could all live here happily ever after!"
				else
					(Print 75 28) ; "But did it happen? Oh my gracious, NO! And all because of that evil Dr. Nonookee!" she cries, suddenly turning quite sensitive. "Oh, if only some great hero could rid this island of his evilness, we could all live here happily ever after!"
				)
				(Print 75 29 #at -1 152) ; "(You're no fool, Larry. That sounds like a cue!)"
				(= seconds 3)
			)
			(32
				(theSound dispose:)
				(Print 75 30) ; "Say, I've got an idea," you tell her. "What if I stop this guy? Then could we get married?"
				(gGame changeScore: 10)
				(Print 75 31) ; "But, of course. Why didn't I think of that? Why, this is every little girl's fairy tale: a hero comes in a white suit to save my island and its people!"
				(Print 75 32 #at -1 152) ; "Sigh."
				(= seconds 3)
			)
			(33
				(Print 75 33) ; "Come on, Larry. Let's go!"
				(aKalalau setMotion: MoveTo (aKalalau x:) (- (aKalalau y:) 5) self)
			)
			(34
				(aKalalau setMotion: MoveTo -20 143)
				(= cycles 20)
			)
			(35
				(gEgo setMotion: MoveTo 0 143 self)
			)
			(36
				(= seconds 3)
			)
			(37
				(Print 75 34) ; "Hey, thanks for the lift, guys! Want to stick around for my wedding?"
				(Print 75 35) ; "Sure, why not? We'll grab the camcorder and be right there. Watch out for that blade!"
				(gEgo illegalBits: 0 setMotion: MoveTo 181 167 self)
			)
			(38
				(aKalalau setMotion: MoveTo 76 156)
				(gEgo setMotion: MoveTo 92 158 self)
			)
			(39
				(Print 75 36) ; "Hi, Larry; what took you so long?"
				(Print 75 37) ; "I ran into a little trouble with an artificial glacier!"
				(aKalalau hide:)
				(gEgo
					view: 706
					setLoop: 1
					cel: 0
					posn: 83 156
					setCycle: End self
				)
			)
			(40
				(= seconds 5)
			)
			(41
				(gEgo setCycle: Beg self)
			)
			(42
				(aKalalau show: ignoreActors: 0)
				(gEgo
					view: gCurrentEgoView
					setLoop: -1
					loop: 1
					posn: 92 157
					setCycle: Walk
				)
				(= seconds 3)
			)
			(43
				(Print 75 38) ; "I did it, Kalalau! I really did it!! Dr. Nonookee is no more, his evil spell is broken, the glacier is melting away, and your women are again free! Once again, peace reigns over this beautiful island! Let's find your father, and get married immediately!"
				(gEgo setMotion: MoveTo 0 143 self)
				(aKalalau setMotion: MoveTo -20 143)
			)
		)
	)
)

