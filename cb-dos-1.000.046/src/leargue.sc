;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	leargue 0
)

(local
	local0
	local1
	local2
	[local3 2]
	local5
	local6
	local7
	local8
)

(procedure (localproc_0)
	(if (< global172 100)
		(lHead stopUpd:)
		(Lillian stopUpd:)
		(Ethel loop: 3 cycleSpeed: 1 setCycle: Fwd)
		(Print &rest #at 175 125 #font 4 #width 125 #mode 1 #dispose)
	)
)

(procedure (localproc_1)
	(if (< global172 100)
		(Ethel stopUpd:)
		(Lillian loop: 1 cycleSpeed: 1 setCycle: Fwd)
		(lHead cycleSpeed: 1 setCycle: Fwd)
		(Print &rest #at 10 45 #font 4 #width 125 #mode 1 #dispose)
	)
)

(instance leargue of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(LoadMany rsMESSAGE 243 221 226)
		(LoadMany rsVIEW 501 512)
		(LoadMany rsSYNC 4 6)
		(= [global377 3] 221)
		(= [global377 5] 226)
		(Lillian init: hide:)
		(= global373 Lillian)
		(if (or (== [gCycleTimers 4] 1) (== global203 2))
			(= global203 2)
			(if (or (!= gPrevRoomNum 45) (== gEthelState 1))
				(= gEthelState 1)
				(Ethel
					view: 325
					illegalBits: 0
					loop: 1
					cel: 6
					posn: 133 149
					ignoreActors:
					setPri: 13
					init:
				)
			)
			(Lillian
				view: 501
				loop: 4
				cel: 0
				illegalBits: 0
				posn: 120 148
				cycleSpeed: 1
				ignoreActors:
				show:
			)
			(lHead ignoreActors: 1 setPri: 11 init:)
			(self setScript: talkActions)
		)
	)

	(method (doit)
		(if (< local8 70)
			(++ local8)
		)
		(if (and local6 local7 (not script) (< global172 100))
			(self setScript: casTalk)
		)
		(if (== global172 99)
			(Lillian setCycle: 0)
			(lHead setCycle: 0)
			(cls)
			(localproc_0 230 0) ; "What was that?!"
			(++ global172)
		)
		(if (== global172 110)
			(cls)
			(Ethel setCycle: 0)
		)
		(if
			(and
				(== [gCycleTimers 4] 1)
				(== global203 1)
				(not script)
				(or (== (gEgo view:) 0) (== (gEgo view:) 11))
			)
			(HandsOff)
			(self setScript: comeBack)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(if (Said '/people,person,woman')
						(cond
							((and (== global203 2) (== gEthelState 1))
								(Print 230 1) ; "Ethel and Lillian seem to be having a little "mother-daughter" chat."
							)
							((== global203 2)
								(DoLook {lillian})
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
				((Said 'talk/person,men')
					(Print 230 2) ; "Which person are you referring to?"
				)
				((Said 'talk/people')
					(Print 230 3) ; "You can only talk to one person at a time."
				)
			)
		)
	)
)

(instance talkActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (> global172 98)
			(client setScript: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gEthelState 0)
					(= seconds 5)
				else
					(= cycles 1)
				)
			)
			(1
				(if (== gEthelState 0)
					(++ gEthelState)
					(= local1 1)
					(if (gEgo inRect: 145 157 160 162)
						(gEgo
							setMotion: MoveTo (- (gEgo x:) 50) (gEgo y:)
						)
					)
					(Ethel
						view: 325
						setLoop: 0
						illegalBits: -32768
						posn: 295 121
						setCycle: Walk
						setAvoider: (Avoid new:)
						setMotion: MoveTo 157 161 self
						init:
					)
				else
					(= local1 0)
					(= cycles 1)
				)
			)
			(2
				(if local1
					(Ethel
						loop: 1
						cel: 6
						ignoreActors:
						posn: 133 149
						setPri: 13
						setAvoider: 0
						setCycle: Beg self
					)
					(DisposeScript 985)
				else
					(= cycles 1)
				)
				(|= global208 $0028)
				(HandsOn)
			)
			(3
				(User canInput: 0)
				(if local1
					(localproc_0 230 4) ; "Hello girls. Looks like you are all settled in."
				else
					(if (== (= local5 (& global178 $7fff)) global178)
						(if (< global178 10)
							(++ global178)
						else
							(= global178 -32766)
						)
					else
						(switch local5
							(2
								(= global178 -32764)
							)
							(4
								(= global178 -32762)
							)
							(6
								(= global178 -32761)
							)
							(7
								(= global178 -32759)
							)
							(9
								(= global178 -32758)
							)
							(10
								(= global178 -32766)
							)
						)
					)
					(switch local5
						(0
							(localproc_0 230 5) ; "If you ask me, I don't think she has any..."
						)
						(1
							(localproc_1 230 6) ; "You know how it is, Mother..."
						)
						(2
							(localproc_0 230 7) ; "Your friend's here again."
						)
						(3
							(localproc_1 230 8) ; "Laura! Have you been exploring the house and grounds? Interesting old place, huh?"
						)
						(4
							(localproc_0 230 9) ; "Shhhh! Here she is again!"
						)
						(5
							(localproc_1 230 10) ; "Mother! Why are you always so...!"
						)
						(6
							(localproc_1 230 11) ; "Well, well. We're back again, are we?"
						)
						(7
							(localproc_0 230 12) ; "I don't know but..."
						)
						(8
							(localproc_1 230 13) ; "Stop doing that, Mother! I hate it when...!"
						)
						(9
							(localproc_1 230 14) ; "Finding things satisfactory, Laura?"
						)
						(else
							(localproc_0 230 15) ; "I wish your friend could find other things to do."
						)
					)
				)
				(= seconds 7)
			)
			(4
				(cls)
				(Lillian setCycle: 0 cel: 0 loop: 4)
				(lHead cel: 0 forceUpd:)
				(Ethel cel: 0 forceUpd:)
				(= seconds 1)
			)
			(5
				(cls)
				(if (== local1 0)
					(= seconds 5)
					(switch local5
						(0
							(localproc_0 230 16) ; "Oh, hello, dear."
						)
						(1
							(localproc_1 230 17) ; "Oh...hi, Laura."
						)
						(5
							(localproc_1 230 18) ; "Oh, it's you again, Laura."
						)
						(7
							(localproc_0 230 19) ; "Laura's back."
						)
						(8
							(localproc_1 230 20) ; "Oh, Laura!"
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
				(= local1 0)
			)
			(6
				(= local8 0)
				(Lillian setScript: lilActions)
				(Ethel setScript: ethelActions)
				(client setScript: 0)
				(User canInput: 1)
				(cls)
			)
		)
	)
)

(instance casTalk of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (> global172 98)
			(client setScript: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(= seconds 5)
				(switch global180
					(0
						(localproc_0 230 21) ; "Do you like my new outfit, Lil?"
					)
					(1
						(localproc_1 230 22) ; "Mother, I could use some extra spending money."
					)
					(2
						(localproc_0 230 23) ; "It's such a stifling night, don't you think?"
					)
					(3
						(localproc_1 230 24) ; "You have a run in your hose, Mother."
					)
					(4
						(localproc_0 230 25) ; "What have you done to your hair, Lillian?!"
					)
					(5
						(localproc_0 230 26) ; "Stop shaking your foot like that! It annoys me when you do that!"
					)
					(6
						(localproc_1 230 27) ; "Why do you have to drink so much, Mother?"
					)
					(7
						(localproc_0 230 28) ; "I don't approve of that young man you've been seeing."
					)
					(8
						(localproc_0 230 29) ; "That dress you're wearing is awful! Can't you dress like a nice young lady?"
					)
					(9
						(localproc_0 230 30) ; "Lil?"
					)
					(else
						(= seconds 1)
					)
				)
			)
			(1
				(cls)
				(Lillian loop: 4 stopUpd:)
				(lHead cel: 0 forceUpd: stopUpd:)
				(Ethel cel: 0 forceUpd: stopUpd:)
				(= seconds 1)
			)
			(2
				(cls)
				(= seconds 5)
				(switch global180
					(0
						(localproc_1 230 31) ; "Not particularly, Mother."
					)
					(1
						(localproc_0 230 32) ; "We'll talk about that later, Lillian."
					)
					(2
						(localproc_1 230 33) ; "Yeah, I guess."
					)
					(3
						(localproc_0 230 34) ; "Do I?! Darn! I don't have one to replace it!"
					)
					(4
						(localproc_1 230 35) ; "Why, don't you like it, Mother? It's all the rage!"
					)
					(5
						(localproc_1 230 36) ; "Well, excuse ME, Mother!"
					)
					(6
						(localproc_0 230 37) ; "A little drinky-poo now and then doesn't hurt anybody."
					)
					(7
						(localproc_1 230 38) ; "Really? I should tell him. He'd get a kick out of that!"
					)
					(8
						(localproc_1 230 39) ; "Speaking of clothes, Mother-- where did you get THAT dress? At the local five and dime?"
					)
					(9
						(localproc_1 230 40) ; "Not now, Mother. I'm not in the mood to talk."
					)
					(else
						(= seconds 1)
					)
				)
			)
			(3
				(cls)
				(lHead cel: 0 forceUpd: stopUpd:)
				(= seconds 5)
				(switch global180
					(8
						(localproc_0 230 41) ; "Well! Of all the nerve!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(= local8 0)
				(if (< global180 9)
					(++ global180)
				)
				(cls)
				(User canInput: 1)
				(Lillian setScript: lilActions)
				(Ethel setScript: ethelActions)
				(= local7 0)
				(= local6 0)
				(client setScript: 0)
			)
		)
	)
)

(instance ethelActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ethel cel: 0 loop: 1 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(Ethel cel: 0 loop: 2 setCycle: End)
				(= seconds 3)
			)
			(2
				(Ethel loop: 2 setCycle: Beg)
				(if (< (Random 1 100) 40)
					(= state 0)
				)
				(= seconds (Random 6 12))
			)
			(3
				(Ethel loop: 1 cel: 6 setCycle: Beg)
				(if (== local8 70)
					(client setScript: 0)
					(= local6 1)
				else
					(= state -1)
					(= seconds (Random 6 12))
				)
			)
		)
	)
)

(instance lilActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lillian loop: 4 cel: 0 cycleSpeed: 2 setCycle: End)
				(lHead show: stopUpd:)
				(= seconds (Random 6 12))
			)
			(1
				(lHead show: stopUpd:)
				(Lillian loop: 6 setCycle: Fwd)
				(if (< (Random 1 100) 50)
					(= state 2)
				)
				(= seconds (Random 5 8))
			)
			(2
				(Lillian loop: 4 cel: (- (NumCels Lillian) 1) setCycle: Beg)
				(if (== local8 70)
					(= local7 1)
					(client setScript: 0)
				)
				(= state -1)
				(= seconds (Random 5 8))
			)
			(3
				(lHead hide:)
				(Lillian loop: 2 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(Lillian loop: 3 cycleSpeed: 1 setCycle: Fwd)
				(= seconds 2)
			)
			(5
				(Lillian cel: 2 loop: 2 cycleSpeed: 1 setCycle: Beg)
				(= state 0)
				(= seconds (Random 5 8))
			)
		)
	)
)

(instance comeBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global203 2)
				(Lillian
					view: 500
					posn: -29 148
					setCycle: Walk
					setPri: 10
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setMotion: MoveTo 55 148 self
					show:
				)
			)
			(1
				(Lillian setPri: -1 setMotion: MoveTo 97 151 self)
			)
			(2
				(Lillian setMotion: MoveTo 121 153 self)
			)
			(3
				(|= global208 $0020)
				(Lillian
					view: 501
					loop: 0
					cel: 4
					illegalBits: 0
					posn: 120 148
					cycleSpeed: 1
					setAvoider: 0
					ignoreActors:
					stopUpd:
				)
				(DisposeScript 985)
				(lHead setPri: 11 init:)
				(client setScript: talkActions)
			)
		)
	)
)

(instance Ethel of Act
	(properties)

	(method (handleEvent event)
		(if (< (gEgo distanceTo: Ethel) (gEgo distanceTo: Lillian))
			(= global214 8)
		else
			(= global214 32)
		)
		(= global213 4)
		(cond
			((and (MousedOn self event 3) (not (& global207 $0008)))
				(event claimed: 1)
				(DoLook {ethel})
			)
			(
				(and
					(& global207 $0008)
					(or (MousedOn self event 3) (Said 'look/ethel'))
				)
				(event claimed: 1)
				(Print 230 1) ; "Ethel and Lillian seem to be having a little "mother-daughter" chat."
			)
			((Said 'talk/ethel')
				(switch local0
					(0
						(Say 1 230 42) ; "Are you having a good time, dear?"
					)
					(1
						(Say 1 230 43) ; "Why don't you run along now, Laura?"
					)
					(2
						(Say 1 230 44) ; "Go do some more exploring, dear."
					)
					(3
						(Say 1 230 45) ; "Your friend is persistent, isn't she, Lil?"
					)
					(else
						(Print 230 46) ; "Ethel refuses to answer your idle chit-chat."
					)
				)
				(++ local0)
			)
			((Said 'ask[/ethel]/lil<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 14 230 47)
			)
			((Said 'listen/ethel,lil')
				(Print 230 48) ; "They're not saying anything interesting."
			)
			((Said 'look/drink,glass')
				(Print 230 49) ; "Ethel seems to be drinking a strong alcoholic drink."
			)
			((Said 'look/give')
				(Print 230 50) ; "Ethel holds a white hanky in her hand as she drinks some sort of strong alcoholic drink."
			)
			((Said 'look/handkerchief')
				(Print 230 51) ; "Ethel holds a white hanky in her hand."
			)
			((Said 'get>')
				(cond
					((Said '/drink,glass')
						(Print 230 52) ; "That's Ethel's drink."
					)
					((Said '/handkerchief')
						(Print 230 53) ; "It's hers!"
					)
				)
			)
		)
	)
)

(instance Lillian of Act
	(properties
		y 134
		x 69
		view 500
	)

	(method (handleEvent event)
		(if (== global203 2)
			(= global213 6)
			(cond
				((and (MousedOn self event 3) (not (& global207 $0020)))
					(event claimed: 1)
					(DoLook {lillian})
				)
				(
					(and
						(& global207 $0020)
						(or (MousedOn self event 3) (Said 'look/lil'))
					)
					(event claimed: 1)
					(Print 230 1) ; "Ethel and Lillian seem to be having a little "mother-daughter" chat."
				)
				((Said 'talk/lil')
					(switch local2
						(0
							(Say 1 230 54) ; "Hi, Laura. How's it all going?"
						)
						(1
							(Say 1 230 55) ; "Are you meeting everybody? They're a comical group, aren't they?"
						)
						(2
							(Say 1 230 56) ; "Go on, Laura. I'll be around. See ya later...alligator!"
						)
						(3
							(Say 1 230 57) ; "Mother is getting angry with you. She wants to talk with me. See ya!"
						)
						(else
							(Say 1 230 58) ; "See ya around, Laura!"
						)
					)
					(++ local2)
				)
				((Said 'ask[/lil]/ethel<about')
					(= global212 1)
					(= global209 event)
					(proc243_1 10 230 59)
				)
			)
		)
	)
)

(instance lHead of Prop
	(properties
		y 115
		x 116
		view 501
		loop 9
		signal 16384
	)
)

