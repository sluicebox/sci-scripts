;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm220 0
)

(local
	seenMsg
	[string 444]
)

(procedure (PrintPlot &tmp t)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		10
		5
		#width
		290
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 3 (LangSwitch t t (+ t t) (+ t t))))
)

(instance rm220 of Rm
	(properties
		picture 220
		horizon 67
		north 310
	)

	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(if (and (TestFlag 21) (not (TestFlag 28)))
			(Load rsVIEW 220)
			(Load rsVIEW 221)
			(Load rsFONT 9)
			(Load rsSOUND 110)
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(cond
			((== gPrevRoomNum 300)
				(gEgo posn: 6 175)
			)
			((== gPrevRoomNum 210)
				(gEgo posn: 2 151)
			)
			((== gPrevRoomNum 310)
				(gEgo posn: 316 70)
			)
			((== gPrevRoomNum 230)
				(gEgo posn: 316 142)
			)
			(else
				(gEgo posn: 316 182)
			)
		)
		(NormalEgo)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (gEgo edgeHit:)
			(cond
				((& (gEgo onControl:) $0002)
					(gCurRoom newRoom: 300)
				)
				((& (gEgo onControl:) $0004)
					(gCurRoom newRoom: 210)
				)
				((& (gEgo onControl:) $0008)
					(gCurRoom newRoom: 310)
				)
				((& (gEgo onControl:) $0010)
					(gCurRoom newRoom: 230)
				)
				((& (gEgo onControl:) $0020)
					(gCurRoom newRoom: 250)
				)
			)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (super handleEvent: event))
				(not (event claimed:))
				gModelessDialog
				(== (event message:) KEY_RETURN)
				(== (event type:) evKEYBOARD)
			)
			(event claimed: 1)
			(cls)
			(self cue:)
		)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look,look>')
			(if (Said '/building,office,club')
				(Print 220 0) ; "It's difficult to see from here. Why not just walk inside?"
			)
			(if (Said '[/area]')
				(Print 220 1) ; "Through the thick jungle you can barely see an office building to the northeast and a strange large blue structure to the southwest."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(cond
					((not (TestFlag 20))
						(HandsOff)
						(Print 220 2) ; "Say," you think, "I bet Kalalau is at home right now, waiting eagerly for my return. I'll head back there right now!"
						(gEgo loop: 1)
						(Animate (gCast elements:) 0)
						(gCurRoom newRoom: 210)
					)
					((not (TestFlag 21))
						(HandsOff)
						(= cycles 25)
					)
				)
			)
			(2
				(Format @string 220 3) ; "Recovering from Kalalau's shocking news, you carefully consider the alternatives."
				(gEgo setMotion: MoveTo 8 153 self)
				(= seconds (PrintPlot))
			)
			(3)
			(4
				(Format @string 220 4) ; "I suppose I could go into mourning," you think. "Mope around all day, sit in my room, rent lots of videos, things like that..."
				(= seconds (PrintPlot))
			)
			(5
				(Format @string 220 5) ; "Or, I could give up women, remain celibate forever, enter the ministry or something."
				(= seconds (PrintPlot))
			)
			(6
				(Format @string 220 6) ; "Wait a minute, what am I thinking? No way! Not me. Not Larry; Larry Laffer!"
				(= seconds (PrintPlot))
			)
			(7
				(Format @string 220 7) ; "You know, this island is the perfect location for a sophisticated, single swinger like yours truly."
				(= seconds (PrintPlot))
			)
			(8
				(Format @string 220 8) ; "And, thanks to a wonderful island tradition, Kalalau's dowry gave me hundreds of acres of potentially valuable forest land."
				(= seconds (PrintPlot))
			)
			(9
				(Format @string 220 9) ; "Perhaps my love for Kalalau blinded me to the potential of my current locale. Where else could I find more women than at a tropical resort? And to think, every one of them came here seeking just one thing -- a good time!"
				(gEgo setMotion: MoveTo 85 153 self)
				(= seconds (PrintPlot))
			)
			(10)
			(11
				(Format @string 220 10) ; "Yeah, that's it!" you exclaim out loud. "I've had it with monogamy, marriage, long-term relationships, commitment."
				(gMusic fade:)
				(= seconds (PrintPlot))
			)
			(12
				(Format @string 220 11) ; "So be it! My life's new goal will be to allow as many women as possible to enjoy me while they can!"
				(= seconds (PrintPlot))
			)
			(13
				(aBooth init: setMotion: MoveTo 111 153 self)
				(if (> gMachineSpeed 39)
					(gMusic number: 110 loop: 1 play:)
				)
			)
			(14
				(gEgo loop: 2)
				(= cycles 22)
			)
			(15
				(gEgo loop: 3)
				(= cycles 22)
			)
			(16
				(gEgo setPri: 10 setMotion: MoveTo 107 153 self)
			)
			(17
				(if (<= gMachineSpeed 39)
					(gMusic number: 110 loop: 1 play:)
				)
				(gEgo view: 221 loop: 1 cel: 0 setCycle: End self)
			)
			(18
				(gEgo
					loop: 2
					cel: 0
					posn: (gEgo x:) (- (gEgo y:) 16)
					setCycle: End self
				)
			)
			(19
				(= cycles 22)
			)
			(20
				(gEgo view: 221 loop: 3 cel: 0 setCycle: End self)
			)
			(21
				(Print 220 12 #at -1 10 #font 9 #time (LangSwitch 3 3 6 6) #dispose) ; "He's back!"
				(ShakeScreen 7 ssFULL_SHAKE)
				(= seconds 5)
			)
			(22
				(= gNormalEgoView 700)
				(NormalEgo 1)
				(HandsOff)
				(gEgo
					posn: (gEgo x:) (+ (gEgo y:) 16)
					setPri: 10
					setMotion: MoveTo 85 153 self
				)
			)
			(23
				(= cycles 22)
			)
			(24
				(aBooth setMotion: MoveTo 111 211 self)
				(= cycles 33)
			)
			(25
				(SetFlag 21) ; beenIn220
				(gEgo setMotion: MoveTo 107 153 self)
				(Format @string 220 13) ; "Look out, girls! Just when you thought it was safe to dive back into the gene pool, the original swinger is at it again!"
				(= seconds (PrintPlot))
			)
			(26
				(= cycles 33)
			)
			(27
				(aBooth stopUpd:)
			)
			(28
				(NormalEgo 0)
				(PutInRoom 3 210)
				(PutInRoom 1 216)
				(= gEgoState 0)
				(gMusic number: 299 loop: gBgMusicLoops play:)
			)
		)
	)
)

(instance aCredit1 of Prop
	(properties
		x 288
		y 131
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 220 906))
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		x 288
		y 154
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 220 906))
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(aCredit1 setCycle: End)
				(= cycles 16)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 22)
			)
			(3
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit2 loop: 2 setCycle: End)
				(= cycles 22)
			)
			(5
				(SetFlag 28) ; sawCredits220
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(6
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)

(instance aBooth of Actor
	(properties
		x 111
		y 211
		illegalBits 0
	)

	(method (init)
		(= view (LangSwitch 221 907))
		(super init:)
		(self ignoreActors: setLoop: 0 setPri: 11)
	)
)

