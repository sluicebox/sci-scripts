;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room92 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(instance theMusic of Sound
	(properties
		number 44
	)
)

(instance Room92 of Rm
	(properties
		picture 92
		style 16
	)

	(method (init)
		(Load rsVIEW 82)
		(Load rsVIEW 121)
		(Load rsVIEW 132)
		(Load rsVIEW 681)
		(Load rsVIEW 81)
		(Load rsVIEW 145)
		(Load rsVIEW 141)
		(Load rsVIEW 634)
		(Load rsVIEW 512)
		(self setRegions: 604) ; regBFCastle
		(super init:)
		(Notify 604 0)
		(= local8 0)
		((View new:)
			view: 634
			loop: 1
			cel: 0
			posn: 32 80
			setPri: 10
			init:
			startUpd:
		)
		((View new:)
			view: 634
			loop: 1
			cel: 1
			posn: 289 81
			setPri: 10
			init:
			addToPic:
		)
		((Prop new:)
			view: 512
			loop: 0
			posn: 289 69
			setPri: 10
			init:
			setCycle: Fwd
		)
		((= local7 (Prop new:))
			view: 512
			loop: 0
			posn: 34 68
			setPri: 10
			init:
			setCycle: Fwd
		)
		(= gIndoors 1)
		(if (== gPrevRoomNum 80)
			(gEgo posn: 153 157 view: 4 xStep: 4 yStep: 1 init:)
		)
		(if (== gPrevRoomNum 91)
			(gEgo posn: 53 132 view: 4 xStep: 4 yStep: 1 init:)
		)
		(if (== gPrevRoomNum 93)
			(gEgo posn: 271 132 view: 4 xStep: 4 yStep: 1 init:)
		)
		(if (== gPrevRoomNum 86)
			((= local0 (Prop new:))
				posn: 162 103
				view: 121
				cycleSpeed: 1
				setLoop: 0
				init:
				stopUpd:
				setScript: lipLooper
			)
			((= local1 (Prop new:))
				posn: 210 95
				view: 132
				loop: 2
				cel: 0
				init:
				stopUpd:
			)
			(User canControl: 0 canInput: 0)
			(= global205 1)
			(gEgo posn: 251 132 view: 81 setLoop: 1 init: setCycle: Walk)
			(lotTalk2 start: 0)
			(self setScript: lotTalk2)
		)
		(if (or (== gPrevRoomNum 79) (== gPrevRoomNum 0) (== gPrevRoomNum 333))
			(gEgo
				posn: 153 157
				view: 82
				xStep: 4
				yStep: 1
				setLoop: 0
				init:
				setCycle: Walk
			)
			((= local0 (Prop new:))
				posn: 162 103
				view: 121
				cycleSpeed: 1
				setLoop: 0
				init:
				stopUpd:
				setScript: lipLooper
			)
			((= local1 (Prop new:))
				posn: 210 95
				view: 132
				cel: 0
				loop: 2
				init:
				stopUpd:
			)
			((= local3 (Act new:))
				view: 141
				setStep: 4 2
				illegalBits: 0
				ignoreActors: 1
				posn: 350 130
				setCycle: Walk
				init:
				stopUpd:
			)
			(User canControl: 0 canInput: 0)
			(= global205 1)
			(gCurRoom setScript: walkIn)
		)
		(if (gCast contains: local0)
			(theMusic loop: 1 play:)
		)
	)

	(method (doit)
		(if (& (gEgo onControl: 0) $0040)
			(cond
				((and (== gAct 99) (== global169 0))
					(gCurRoom newRoom: 80)
				)
				((not local10)
					(Print 92 0) ; "The door is locked."
					(= local10 1)
				)
			)
		else
			(= local10 0)
		)
		(if (and (& (gEgo onControl: 0) $0020) (!= (gEgo view:) 81))
			(gCurRoom newRoom: 91)
		)
		(if (and (& (gEgo onControl: 0) $0010) (!= (gEgo view:) 81))
			(gCurRoom newRoom: 93)
		)
		(super doit:)
	)

	(method (dispose)
		(gSounds eachElementDo: #dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (or (== newRoomNumber 80) (== newRoomNumber 30))
			((ScriptID 604) keep: 0) ; regBFCastle
			(= global189 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		else
			(if (and local8 (== (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				((self script:) seconds: 1)
				(= local9 0)
				(= local8 0)
			)
			(if (== (event type:) evSAID)
				(cond
					((Said 'look>')
						(cond
							((Said '/throne')
								(Print 92 1) ; "Currently, Lolotte's ornate, gilded throne is empty."
							)
							((Said '/stair')
								(Print 92 2) ; "The carpeted stairs lead to Lolotte's gilded throne."
							)
							((Said '<behind,under/tapestries,painting')
								(Print 92 3) ; "There is nothing but wall behind the tapestry."
							)
							((Said '/tapestries,painting')
								(Print 92 4) ; "Two strange-looking tapestries hang on the wall behind Lolotte's throne."
							)
							((Said '/door')
								(Print 92 5) ; "You see two open doorways."
							)
							((Said '/wall')
								(Print 92 6) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 92 7) ; "There is nothing of importance on the floor."
							)
							((Said '/carpet')
								(Print 92 8) ; "The carpet leads to Lolotte's throne."
							)
							(
								(or
									(Said '<around')
									(Said '/room[<throne]')
									(Said '/castle')
								)
								(Print 92 9) ; "Lolotte's throne room is cold, dark, and ominous. From here, she rules her domain with an evil hand."
							)
						)
					)
					((Said 'sit/throne')
						(Print 92 10) ; "You don't have time for that."
					)
					((Said 'open/door')
						(if (and (== gAct 99) (== global169 0))
							(Print 92 11) ; "Just go there."
						else
							(Print 92 12) ; "OH, NO!! The door is locked!"
							(Print 92 13) ; "What now, Rosella?!"
						)
					)
					((Said 'unlatch/door')
						(if (and (== gAct 99) (== global169 0))
							(Print 92 14) ; "It already is."
						else
							(Print 92 15) ; "You don't have the key to unlock this door."
						)
					)
				)
			)
		)
	)
)

(instance walkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 153 137 self)
			)
			(1
				(gEgo cel: 1)
				(switch gAct
					(0
						(= global169 1)
						(gCurRoom setScript: lotTalk1)
					)
					(1
						(gCurRoom setScript: lotTalk3)
					)
					(2
						(gCurRoom setScript: lotTalk4)
					)
					(3
						(gCurRoom setScript: lotTalk5)
					)
					(else
						(Print 92 16) ; "ERROR"
					)
				)
			)
		)
	)
)

(instance lotTalk1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 3)
				(= local4
					(Print 92 17 #at 5 25 #font gSmallFont #width 125 #draw #dispose) ; "Well, my pets," Lolotte hisses, "What have you drug home today?"
				)
				(= local8 1)
				(= seconds 7)
			)
			(1
				(= local9 0)
				(cls)
				(= local4 (Print 92 18 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Lolotte gives you the once over, and as she does her red eyes begin to narrow."
				(= local8 1)
				(= seconds 7)
			)
			(2
				(= local9 9)
				(cls)
				(= local4 (Print 92 19 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Are you a foolish girl who wandered here by mistake...or are you a SPY sent here by my enemy, Genesta?!"
				(= local8 1)
				(= seconds 10)
			)
			(3
				(cls)
				(= local4 (Print 92 20 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "You swear to Lolotte that you are nothing but a poor peasant girl who has lost her way, but she doesn't seem to believe you as her mouth begins to snarl and her eyes narrow to mere slits."
				(= local8 1)
				(= seconds 16)
			)
			(4
				(cls)
				(= local4 (Print 92 21 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "For the first time, you experience real fear and begin to tremble."
				(= local8 1)
				(= seconds 8)
			)
			(5
				(cls)
				(= local9 8)
				(= local4 (Print 92 22 #font gSmallFont #at 5 25 #width 125 #dispose)) ; "Lolotte snarls, "You don't look STUPID enough to have wandered HERE. I believe you're a SPY!""
				(= local8 1)
				(= seconds 9)
			)
			(6
				(cls)
				(= local4 (Print 92 23 #font gSmallFont #at 5 25 #width 125 #dispose)) ; "Take her to the cell!"
				(local0 loop: 1 cel: 0 setCycle: End)
				(= local8 1)
				(= seconds 4)
			)
			(6
				(= local8 0)
				(gEgo
					view: 81
					setLoop: 0
					illegalBits: 0
					setMotion: MoveTo 325 132
				)
				(= seconds 5)
			)
			(7
				(local7 setCycle: Fwd)
				(cls)
				(gCurRoom newRoom: 86)
			)
		)
	)
)

(instance lotTalk2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 153 137 self)
			)
			(1
				(gEgo view: 82 loop: 0 cel: 1)
				(= local9 4)
				(= local4 (Print 92 24 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Lolotte gives you a sickly-sweet look. "You're lucky, my dear," she coos."
				(= local8 1)
				(= seconds 7)
			)
			(2
				(= local9 7)
				(cls)
				(= local4 (Print 92 25 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "My precious son, Edgar, has taken a liking to you, and he believes you. He's convinced me to give you a chance to prove your innocence."
				(= local8 1)
				(= seconds 10)
			)
			(3
				(cls)
				(= local4 (Print 92 26 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "You glance at the homely young man standing next to Lolotte. He blushes."
				(local1 view: 132 loop: 2 setCycle: End)
				(= local8 1)
				(= seconds 6)
			)
			(4
				(= local9 5)
				(cls)
				(local1 setCycle: Beg)
				(= local4 (Print 92 27 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Lolotte continues, "I wish to own the unicorn that inhabits the meadowland.""
				(= local8 1)
				(= seconds 6)
			)
			(5
				(= local9 5)
				(cls)
				(= local4 (Print 92 28 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Bring me the unicorn, and I shall not only set you free, but reward you as well."
				(= local8 1)
				(= seconds 7)
			)
			(6
				(= local9 3)
				(local7 setCycle: Fwd)
				(cls)
				(= local4 (Print 92 29 #font gSmallFont #at 5 25 #width 125 #dispose)) ; "To her henchmen, Lolotte orders, "Go! Take her back to the forest!""
				(local0 loop: 2 cel: 0 setCycle: End)
				(= local8 1)
				(= seconds 6)
			)
			(7
				(= local8 0)
				(cls)
				(= gAct 1)
				(User canControl: 1 canInput: 1)
				(= global205 0)
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance lotTalk3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 6)
				(= local4 (Print 92 30 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "So," Lolotte says, "I hear you were a good girl and brought me the unicorn."
				(= gUnicornState 99)
				(gGame changeScore: 7)
				(local1 view: 132 loop: 2 setCycle: End)
				(= local8 1)
				(= seconds 7)
			)
			(1
				(= local9 8)
				(cls)
				(= local4 (Print 92 31 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "I'm ALMOST convinced you might be innocent after all. But..." she clears her throat, "not quite."
				(= local8 1)
				(= seconds 8)
			)
			(2
				(cls)
				(local1 setCycle: Beg)
				(= local4 (Print 92 32 #font gSmallFont #width 125 #dispose)) ; "Oh, oh. This doesn't sound good, you think."
				(= local8 1)
				(= seconds 7)
			)
			(3
				(= local9 12)
				(cls)
				(= local4 (Print 92 33 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Lolotte continues, "I am desirous of the hen that lays the golden eggs. Currently, the hen is kept by the ogre and his wife.""
				(= local8 1)
				(= seconds 12)
			)
			(4
				(= local9 6)
				(cls)
				(= local4 (Print 92 34 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Bring me the hen, and you shall have your freedom and a great reward!"
				(= local8 1)
				(= seconds 6)
			)
			(5
				(local7 setCycle: Fwd)
				(cls)
				(= local4 (Print 92 35 #font gSmallFont #at 5 25 #width 125 #dispose)) ; ""Take her away!" Lolotte orders her goons."
				(local0 loop: 2 cel: 0 setCycle: End)
				(= local8 1)
				(= seconds 5)
			)
			(6
				(cls)
				(= gAct 2)
				(User canControl: 1 canInput: 1)
				(= global205 0)
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance lotTalk4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 8)
				(= local4 (Print 92 36 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "What a good girl you are!" Lolotte gushes. "I really ought to give you your reward right now!"
				(gEgo put: 33 84) ; Magic_Hen
				(gGame changeScore: 7)
				(local1 view: 132 loop: 2 setCycle: End)
				(= local8 1)
				(= seconds 10)
			)
			(1
				(cls)
				(= local4 (Print 92 37 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "She pauses, and you wonder what she's up to."
				(= local8 1)
				(= seconds 4)
			)
			(2
				(local1 setCycle: Beg)
				(= local9 6)
				(cls)
				(= local4 (Print 92 38 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Lolotte goes on to say, "But, I have just the tiniest bit of doubt left.""
				(= local8 1)
				(= seconds 8)
			)
			(3
				(= local9 8)
				(cls)
				(= local4 (Print 92 39 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "If you do just ONE MORE thing for me, I'll be COMPLETELY convinced of your innocence and you'll receive a wonderful reward!"
				(= local8 1)
				(= seconds 8)
			)
			(4
				(cls)
				(= local4 (Print 92 40 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Somehow, you don't quite believe her."
				(= local8 1)
				(= seconds 4)
			)
			(5
				(= local9 6)
				(cls)
				(= local4 (Print 92 41 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "I want to have Pandora's Box. It is said that whoever owns it would be in possession of the purest evil."
				(= local8 1)
				(= seconds 10)
			)
			(6
				(= local9 7)
				(cls)
				(= local4 (Print 92 42 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Lolotte's red eyes glow as she exclaims, "With the power and evil of Pandora's Box, I would be UNSTOPPABLE!""
				(= local8 1)
				(= seconds 10)
			)
			(7
				(cls)
				(= local4 (Print 92 43 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Your terror returns as you realize what an evil being Lolotte really is!"
				(= local8 1)
				(= seconds 6)
			)
			(8
				(cls)
				(= local4 (Print 92 44 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "You wonder if you should be helping her in this way. But...what can you do about it? Nothing...right now."
				(= local8 1)
				(= seconds 8)
			)
			(9
				(= local9 8)
				(cls)
				(= local4 (Print 92 45 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "I don't know the whereabouts of Pandora's Box," Lolotte tells you. "You must search for it yourself."
				(= local8 1)
				(= seconds 10)
			)
			(10
				(cls)
				(= local4 (Print 92 46 #font gSmallFont #at 5 25 #width 125 #dispose)) ; "Again, she orders her henchmen to "Take her away!""
				(local0 loop: 2 cel: 0 setCycle: End)
				(= local8 1)
				(= seconds 6)
			)
			(11
				(local7 setCycle: Fwd)
				(cls)
				(= gAct 3)
				(User canControl: 1 canInput: 1)
				(= global205 0)
				(gCurRoom newRoom: 30)
			)
		)
	)
)

(instance lotTalk5 of Script
	(properties)

	(method (init param1)
		(super init: param1)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local9 6)
				(= local4 (Print 92 47 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Lolotte smiles an evil smile. "You know," she says, "I've never asked you your name. What is it?""
				(gEgo put: 4 84) ; Pandora_s_Box
				(gGame changeScore: 7)
				(local1 view: 132 loop: 2 setCycle: End)
				(= local8 1)
				(= seconds 10)
			)
			(1
				(cls)
				(= local4 (Print 92 48 #at 25 45 #font gSmallFont #width -1 #dispose)) ; "You tell her "Rosella.""
				(= local8 1)
				(= seconds 4)
			)
			(2
				(= local9 3)
				(cls)
				(local1 setCycle: Beg)
				(= local4 (Print 92 49 #at 5 25 #font gSmallFont #width 125 #dispose)) ; ""Rosella. What a pretty name." You wonder what this is all about."
				(= local8 1)
				(= seconds 8)
			)
			(3
				(= local9 4)
				(cls)
				(= local4 (Print 92 50 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "You find out soon enough. "Well, Rosella," Lolotte grins ominously, "You've earned your reward!""
				(= local8 1)
				(= seconds 8)
			)
			(4
				(= local9 6)
				(cls)
				(= local4 (Print 92 51 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "My son, Edgar, has fallen in love with you. I wish him to be happy, and I give you the honor of being his wife and MY daughter-in-law!"
				(local0 loop: 2 cel: 0 setCycle: End)
				(= local8 1)
				(= seconds 10)
			)
			(5
				(cls)
				(= local4 (Print 92 52 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "Your heart turns flips and somersaults as you hear this."
				(= local8 1)
				(= seconds 6)
			)
			(6
				(= seconds 1)
			)
			(7
				((= local2 (Prop new:))
					view: 681
					posn: (local1 x:) (- (local1 y:) 35)
					cel: 0
					init:
					cycleSpeed: 1
					setCycle: End self
				)
				(local0 loop: 3 cel: 0 setCycle: End)
				(= local8 0)
			)
			(8
				(local2 dispose:)
				(= seconds 10)
			)
			(9
				(local0 loop: 3 cel: 0 setCycle: Beg)
				(cls)
				(= local4 (Print 92 53 #at 5 25 #font gSmallFont #width 125 #dispose)) ; ""You'll be married first thing in the morning," she informs you."
				(= local8 1)
				(= seconds 10)
			)
			(10
				(cls)
				(= local4 (Print 92 54 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "You will sleep in Edgar's room tonight, while my son sleeps elsewhere."
				(= local8 1)
				(= seconds 7)
			)
			(11
				(cls)
				(getShit changeState: 0)
				(= local4 (Print 92 55 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "She motions to her goons. "Let us relieve you of your burdensome load before you retire.""
				(= local8 0)
				(= seconds 10)
			)
			(12
				(cls)
				(= local4 (Print 92 56 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "You are so shocked by this tragic turn of events, that you hardly notice your possessions being taken away."
				(for
					((= local6 (gInventory first:)))
					local6
					((= local6 (gInventory next: local6)))
					
					(if
						(and
							(= local5 (NodeValue local6))
							(== (local5 owner:) gEgo)
						)
						(local5 owner: 89)
					)
				)
				(= local8 0)
				(= seconds 8)
			)
			(13
				(local0 loop: 2 setCycle: Beg self)
			)
			(14
				(local7 setCycle: Fwd)
				(cls)
				(= local4 (Print 92 57 #at 5 25 #font gSmallFont #width 125 #dispose)) ; "To her goons, Lolotte orders, "Escort our Rosella to her room.""
				(= local9 3)
				(= local8 1)
				(= seconds 6)
			)
			(15
				(gEgo
					view: 81
					illegalBits: 0
					setLoop: 1
					setMotion: MoveTo -5 132 self
				)
			)
			(16
				(cls)
				(= gAct 99)
				(gEgo hide: illegalBits: -32768)
				(gCurRoom newRoom: 81)
			)
		)
	)
)

(instance lipLooper of Script
	(properties)

	(method (doit)
		(if (and (> local9 0) (== (local0 loop:) 0) (== (local0 cycler:) 0))
			(-- local9)
			(local0 setCycle: End)
		)
	)
)

(instance getShit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local3 posn: 290 130 setMotion: MoveTo 153 130 self)
			)
			(1
				(local3 loop: 2)
				(local3 setMotion: MoveTo 320 130 self)
			)
			(2
				(local3 dispose:)
			)
		)
	)
)

