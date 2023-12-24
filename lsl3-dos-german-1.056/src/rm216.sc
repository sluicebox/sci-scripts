;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 216)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm216 0
)

(local
	girlTalkCount
	boxOpen
	[string 444]
)

(procedure (PrintKalalau &tmp t)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		5
		15
		#title
		{Kalalau says...}
		#width
		220
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 3 (LangSwitch t t (+ t t) (+ t t))))
)

(procedure (Print216 &tmp t)
	(= t (PrintDelay @string))
	(Print
		@string
		#at
		10
		120
		#title
		{You say...}
		#width
		160
		#time
		(LangSwitch t t (+ t t) (+ t t))
		#dispose
	)
	(return (+ 3 (LangSwitch t t (+ t t) (+ t t))))
)

(instance rm216 of Rm
	(properties
		picture 216
		east 210
	)

	(method (init)
		(if (not (TestFlag 20))
			(aKandBB init:)
		)
		(Load rsVIEW 217)
		(Load rsSOUND 217)
		(Load rsSOUND 218)
		(super init:)
		(aMailBox init: stopUpd:)
		(self setScript: RoomScript)
		(if (and (TestFlag 20) (not (TestFlag 27)))
			(Load rsVIEW 219)
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(NormalEgo)
		(gEgo
			loop: 1
			posn: 318 166
			observeBlocks: blockFence1 blockFence2
			init:
		)
		(if (gCast contains: aKandBB)
			(gSoundFX number: 216 loop: -1 play:)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
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
		(cond
			((Said 'climb,jump/wall')
				(if gEgoIsPatti
					(Print 216 0) ; "Larry built these walls a year ago to keep out undesirables."
				else
					(Print 216 1) ; "A year ago you built these walls to keep out undesirables; and now you are one."
				)
			)
			((Said '/club,club')
				(if gEgoIsPatti
					(Print 216 2) ; "Can't you just picture you and Larry in that tub?"
				else
					(Print 216 3) ; "You fondly recall your many positive experiences in that tub."
				)
			)
			((Said 'get,get/box')
				(Print 216 4) ; "You can't; it's bolted securely to the wall."
			)
			((Said 'open/door')
				(Print 216 5) ; "You can't; it's securely locked."
			)
			((Said 'pick,break/lock,bolt,bolt,door,fence')
				(Print 216 6) ; "There's just no getting in there!"
			)
			((Said 'climb/door')
				(if gEgoIsPatti
					(Print 216 7) ; "That's ONE idea; but not a very good one!"
				else
					(Print 216 8) ; "A good idea, but there is nothing inside that gate for you but bad memories!"
				)
			)
			((Said 'unbolt/door')
				(Print 216 9) ; "You can't; Kalalau changed the locks!"
			)
			((Said 'look,look<in/box')
				(cond
					(gEgoIsPatti
						(Print 216 10) ; "You don't need to do that."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0002))
						(NotClose) ; "You're not close enough."
					)
					((not boxOpen)
						(Print 216 11) ; "Although you try as hard as you can, you just can't see through the lid, Larry!"
					)
					((InRoom 1)
						(Print 216 12) ; "Well, well. Look at this! It's an envelope from your credit card company."
					)
					(else
						(Print 216 13) ; "Careful examination of the contents of your mailbox reveals..."
						(Print 216 14) ; "...nothing!"
					)
				)
			)
			((Said 'open/box,lid')
				(cond
					(gEgoIsPatti
						(Print 216 10) ; "You don't need to do that."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0002))
						(NotClose) ; "You're not close enough."
					)
					(boxOpen
						(ItIs) ; "It is."
					)
					(else
						(self changeState: 12)
					)
				)
			)
			((Said 'close/box,lid')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (& (gEgo onControl:) $0002))
						(NotClose) ; "You're not close enough."
					)
					((not boxOpen)
						(ItIs) ; "It is."
					)
					(else
						(self changeState: 18)
					)
				)
			)
			((Said 'get,get/card,letter,letter,envelope')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (InRoom 1))
						(Print 216 15) ; "You don't see that here."
					)
					((not (& (gEgo onControl:) $0002))
						(NotClose) ; "You're not close enough."
					)
					((not boxOpen)
						(Print 216 16) ; "Where?"
					)
					(else
						(self changeState: 23)
					)
				)
			)
			((Said 'tickle/finial')
				(Print 216 17) ; "You've been playing "King's Quest IV" too long!"
			)
			((Said '/wall,fence>')
				(cond
					((Said 'climb/')
						(Print 216 18) ; "You COULD do that, but there is no game over there!"
					)
					((Said 'look,look/')
						(if gEgoIsPatti
							(Print 216 19) ; "High stucco walls lead down a pathway to Larry's former residence, the most beautiful home on Nontoonyt."
						else
							(Print 216 20) ; "High stucco walls lead down a pathway to your former residence, the most beautiful home on Nontoonyt. Your mailbox hangs on the wall near the gate."
						)
					)
					(else
						(event claimed: 1)
						(Print 216 21) ; "This fence effectively keeps out all intruders -- including you!"
					)
				)
			)
			((Said 'look,look>')
				(cond
					((and (InRoom 1) (Said '/letter,letter,envelope,card'))
						(Print 216 22) ; "What's that in your mailbox? Perhaps you should look in there."
					)
					((Said '/box')
						(if (& (gEgo onControl:) $0002)
							(Print 216 23) ; "Yes. It is a mailbox."
						else
							(Print 216 24) ; "There's a mailbox next to the gate."
						)
					)
					((Said '/door')
						(Print 216 25) ; "Graceful finials adorn the locked gate. What's that?, you say. Well, suffice it to say, it looks like a big upside-down punching bag mounted atop the column beside the gate. See, you learn something new every day!"
					)
					((Said '/finial')
						(Print 216 26) ; "Yes, that's a big finial, all right!"
						(Print 216 27 #at -1 144) ; "(It reminds you of a uvula!)"
					)
					((Said '/building')
						(if gEgoIsPatti
							(Print 216 28) ; "This is where your Larry used to live with some cheap hussy."
						else
							(Print 216 29) ; "You were so sure you would spend the rest of your life living happily with your beloved Kalalau, but, alas, some things are just not meant to be."
						)
					)
					((Said '[/area]')
						(if gEgoIsPatti
							(Print 216 28) ; "This is where your Larry used to live with some cheap hussy."
						else
							(Print 216 30) ; "You gave Kalalau full rein in the design and decorating of your home. Lucky for you she was the daughter of a king!"
							(Print 216 31 #at -1 144) ; "(Kalalau was heavily into the "Grocery Store Check-Out Line Magazine" school of architecture!)"
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (TestFlag 20))
					(= cycles 40)
				)
			)
			(1
				(HandsOff)
				(gEgo loop: 3)
				(Format @string 216 32) ; ""Oh, Kalalau, baby!" you shout. "Your lover boy Larry is home!"%"
				(= seconds (Print216))
				(= cycles 0)
			)
			(2
				(Format @string 216 33) ; ""Oh, no, you're not!" cries a voice from over the fence. "You don't live here any more. I've found a new lover and filed for divorce. By island law, all I need do is walk three times in a circle around our bed. I've done that many times over the past few years!"%"
				(= seconds (PrintKalalau))
			)
			(3
				(Print 216 34 #at -1 144 #dispose #time 11) ; "(You are stunned! You had no idea anything was wrong!)"
				(= seconds 14)
			)
			(4
				(Format @string 216 35) ; ""What do you mean, `divorce?' `Walk three times?' Oh, Kalalau: say it isn't so!"%"
				(= seconds (Print216))
			)
			(5
				(Format @string 216 36) ; ""It IS so, Larry! I'm leaving you and keeping the house. Now, please go and leave us alone!"%"
				(= seconds (PrintKalalau))
			)
			(6
				(Format @string 216 37) ; ""`Us?!' What do you mean, `us?' Are you in our hot tub with someone else? Who? Who is it, Kalalau?"%"
				(= seconds (Print216))
			)
			(7
				(Format @string 216 38) ; ""I'm with Bobbi, my new lover," she responds hurtfully. "Bobbi is able to meet my needs where you never were. You'll never bore me to sleep again, Larry Laffer!"%"
				(= seconds (PrintKalalau))
			)
			(8
				(Format @string 216 39) ; ""Kalalau!" you cry. "How could you possibly leave me for another man?"%"
				(= seconds (Print216))
			)
			(9
				(Format @string 216 40) ; ""I didn't, you fool!" she replies. "Bobbi's a woman!"%"
				(= seconds (PrintKalalau))
			)
			(10
				(SetFlag 20) ; beenIn216
				(Print
					(Format ; "Poor Larry. Not only does Kalalau no longer love you, she's fallen in love with another woman! What could Kalalau possibly see in an Amazonian Harley-riding former-cannibal%s slot-machine repairwoman?%"
						@string
						216
						41
						(if (>= gFilthLevel 3) { lesbian} else {})
						(if (>= gFilthLevel 3) { lesbischen} else {})
					)
					#dispose
					#time
					28
				)
				(= seconds 31)
			)
			(11
				(HandsOn)
				(cls)
				(= seconds 0)
			)
			(12
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 118 120 self
				)
			)
			(13
				(gEgo loop: 3)
				(= seconds 2)
			)
			(14
				(gEgo
					view: 217
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(gSoundFX number: 217 loop: 1 play:)
			)
			(15
				(aMailBox setCel: (if (InRoom 1) 1 else 2) stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(16
				(NormalEgo 3)
				(= boxOpen 1)
				(if (gCast contains: aKandBB)
					(gSoundFX number: 216 loop: -1 play:)
				)
			)
			(18
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 118 120 self
				)
			)
			(19
				(gEgo loop: 3)
				(= seconds 2)
			)
			(20
				(gEgo
					view: 217
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(21
				(aMailBox setCel: 0 stopUpd:)
				(gEgo setCycle: Beg self)
				(gSoundFX number: 218 loop: 1 play:)
			)
			(22
				(NormalEgo 3)
				(= boxOpen 0)
				(if (gCast contains: aKandBB)
					(gSoundFX number: 216 loop: -1 play:)
				)
			)
			(23
				(HandsOff)
				(gEgo
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 118 120 self
				)
			)
			(24
				(gEgo loop: 3)
				(= seconds 2)
			)
			(25
				(gEgo
					cycleSpeed: 1
					view: 217
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(26
				(aMailBox setCel: 2 stopUpd:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(27
				(= seconds 2)
			)
			(28
				(Print 216 42 #at 10 5 #width 290) ; "Eagerly, you take the envelope from the mailbox. Could this be that big break from Ed McMahon you've been hoping for?"
				(= cycles 22)
			)
			(29
				(gEgo view: 217 setLoop: 2 cel: 0 setCycle: End self)
			)
			(30
				(= cycles 20)
			)
			(31
				(Print 216 43 #at 10 5 #width 290) ; "Say! It's an answer from that credit card company whose application you mailed only 15 weeks ago."
				(gEgo setCycle: Beg self)
			)
			(32
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(33
				(gEgo get: 1) ; Credit_Card
				(gGame changeScore: 20)
				(Print 216 44 #icon 217 3 0 #at -1 10) ; "Ripping open the envelope, you discover your new credit card. And, look! It's in your name only! Kalalau can't claim this as community property!"
				(= seconds 3)
			)
			(34
				(NormalEgo 3)
			)
		)
	)
)

(instance aKandBB of Prop
	(properties
		view 218
	)

	(method (init)
		(super init:)
		(self posn: 246 42 setScript: KandBBScript)
	)
)

(instance KandBBScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'talk,talk/woman,woman,exwife')
			(switch (++ girlTalkCount)
				(1
					(Print 216 45) ; "Oh, Kalalau," you cry, "is there anything I can do to win you back?"
					(Print 216 46) ; "There is no reply."
				)
				(2
					(Print 216 47) ; "Kalalau, you can't treat me like dirt, you know," you say, growing indignant. "I don't have to stand here taking abuse from you. I can do that anywhere!"
					(Print 216 46) ; "There is no reply."
				)
				(3
					(Print 216 48) ; "All right, that's it! You may refuse to love me, but you won't ignore me. I'm leaving you -- for good!"
					(Print 216 49) ; "At last there is a response from over the wall..."
					(Print 216 50) ; "Good!"
				)
				(else
					(Print 216 51) ; ""Knock, knock," you shout."
					(Print 216 52) ; ""Who's there?" replies Kalalau."
					(Print 216 53) ; "Not me, baby! I'm outta here!!"
				)
			)
		)
		(if (Said '/club,club')
			(Print 216 54) ; "They seem to be enjoying themselves."
		)
		(if (Said 'look,look/woman,woman,exwife')
			(if (> gFilthLevel 3)
				(Print 216 55) ; "It seems Kalalau is too busy playing "little Dutch boy" to worry about you!"
			else
				(Print 216 56) ; "They can't see you over the fence, they can't hear you over the roar of the bubbles, and they don't want to see or hear you ever again!"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(aKandBB loop: 0 setCycle: Fwd)
				(= cycles (Random 20 40))
			)
			(2
				(aKandBB setCel: 3)
				(= cycles (Random 20 40))
			)
			(3
				(aKandBB loop: 1 setCycle: Fwd)
				(= cycles (Random 20 40))
			)
			(4
				(aKandBB setCel: 3)
				(= cycles (Random 20 40))
			)
			(5
				(if (== 1 (Random 1 4))
					(aKandBB loop: 2 setCycle: End)
					(= cycles (Random 80 140))
				else
					(self changeState: 1)
				)
			)
			(6
				(aKandBB setCycle: Beg)
				(self changeState: 1)
			)
		)
	)
)

(instance blockFence2 of Blk
	(properties)
)

(instance blockFence1 of Blk
	(properties)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 288
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 219 905))
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		y 154
		x 288
		loop 1
		cycleSpeed 1
	)

	(method (init)
		(= view (LangSwitch 219 905))
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
				(aCredit2 setLoop: 2 setCycle: End)
				(= cycles 22)
			)
			(5
				(SetFlag 27) ; sawCredits216
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

(instance aMailBox of Prop
	(properties
		y 107
		x 134
		view 216
		signal 1
	)
)

