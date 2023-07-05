;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	cololill 0
)

(synonyms
	(lil woman)
	(colonel man)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(Colonel cycleSpeed: 1 setCycle: Fwd)
	(Print &rest #at 15 10 #font 4 #width 125 #mode 1 #draw #dispose)
)

(procedure (localproc_1)
	(Lillian loop: 1 setCycle: Fwd)
	(LHead loop: 7 setCycle: Fwd)
	(Print &rest #at 140 10 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance cololill of Rgn
	(properties)

	(method (init)
		(super init:)
		(Load rsFONT 4)
		(Load rsVIEW 909)
		(LoadMany rsMESSAGE 243 298)
		(= global208 512)
		(= [global377 9] 298)
		(if (== [gCycleTimers 1] 0)
			(= [gCycleTimers 1] 1800)
		)
		(Colonel init: stopUpd:)
		(smoke1 view: 304 loop: 2 cel: 0 x: 182 y: 97 z: 30 init: hide:)
		(smoke2
			view: 304
			loop: 3
			cel: 0
			posn: (+ (Colonel x:) 11) (- (Colonel y:) 24)
			setPri: (CoordPri (Colonel y:))
			init:
			hide:
		)
		(Glow posn: (+ (Colonel x:) 10) (Colonel y:) z: 29 init: hide:)
		(if (and (== [gCycleTimers 1] 1) (& gMustDos $0002))
			(= global195 512)
			(Colonel setScript: colonelActions)
		else
			(Load rsFONT 41)
			(Load rsVIEW 642 905)
			(LoadMany rsSOUND 29 94 95 96)
			(LoadMany rsMESSAGE 406 372)
			(= global208 544)
			(= [global377 5] 372)
			(LHead init:)
			(Lillian init:)
			(SetFlag 38)
			(self setScript: argue)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'listen/fifi,colonel')
					(if (gCast contains: Lillian)
						(Print 270 0) ; "This seems to be a private conversation."
					else
						(Print 270 1) ; "He's not saying anything."
					)
				)
				((gCast contains: Lillian))
				((Said 'talk,ask,tell')
					(if local4
						(Print 270 2) ; "Colonel Dijon has shut his mouth and refuses to talk to you."
					else
						(= global213 10)
						(Say 1 270 3) ; "I have told you I don't wanna talk to you!"
						(++ local4)
					)
				)
				((Said 'give/*')
					(if global224
						(Print 270 4) ; "He's not paying any attention to it."
					else
						(DontHave) ; "You don't have it."
					)
				)
				((Said 'show/*]')
					(if global224
						(Print 270 5) ; "He's not interested in looking at it."
					else
						(DontHave) ; "You don't have it."
					)
				)
			)
		)
	)
)

(instance argue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0002))
						(|= gMustDos $0002)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state -1)
					)
					((self script:)
						(= state -1)
					)
				)
				(= cycles 1)
			)
			(1
				(User canInput: 0)
				(if (== (= local5 (& global179 $7fff)) global179)
					(if (< global179 10)
						(++ global179)
					else
						(= global179 -32767)
					)
				else
					(switch local5
						(1
							(= global179 -32766)
						)
						(2
							(= global179 -32763)
						)
						(5
							(= global179 -32762)
						)
						(6
							(= global179 -32760)
						)
						(8
							(= global179 -32752)
						)
						(10
							(= global179 -32767)
						)
					)
				)
				(switch local5
					(0
						(localproc_1 270 6) ; "But, Uncle Henri, I don't understand how you could...!"
					)
					(1
						(localproc_1 270 7) ; "This has nothing to do with you, Laura!"
					)
					(2
						(localproc_0 270 8) ; "Your friend doesn't seem to know the meaning of "private," does she, Lillian?"
					)
					(3
						(localproc_0 270 9) ; "I'm sorry you feel that way, Lillian, but..."
					)
					(4
						(localproc_1 270 10) ; "It's not right, Uncle Henri! You know how...!"
					)
					(5
						(localproc_0 270 11) ; "Young lady, do you mind?!"
					)
					(6
						(localproc_1 270 12) ; "But, Uncle Henri...!"
					)
					(7
						(localproc_0 270 13) ; "Lillian! It's not up to you to...!"
					)
					(8
						(localproc_0 270 14) ; "Can't you tell your friend to butt out?!"
					)
					(9
						(localproc_1 270 15) ; "You don't understand how I feel, Uncle Henri!"
					)
					(10
						(localproc_1 270 16) ; "Please leave, Laura! This is between me and my uncle!"
					)
				)
				(= seconds 5)
			)
			(2
				(LHead setCycle: 0)
				(cls)
				(Lillian setCycle: 0)
				(Colonel setCycle: 0)
				(= seconds 3)
				(switch local5
					(0
						(localproc_1 270 17) ; "Laura! What are YOU doing in here?!"
					)
					(5
						(localproc_0 270 18) ; "AHEM!"
					)
					(6
						(localproc_0 270 19) ; "Here she is again!"
					)
					(8
						(localproc_1 270 20) ; "Laura! I want to talk to my uncle...alone!"
					)
					(9
						(localproc_0 270 21) ; "Oh, no! Not HER again!"
					)
					(10
						(localproc_0 270 22) ; "Quiet, Lillian!"
					)
					(else
						(= seconds 1)
					)
				)
			)
			(3
				(cls)
				(LHead setCycle: 0 setScript: headActions)
				(Lillian setCycle: 0 setScript: lillActions)
				(Colonel setScript: colonelActions)
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance colonelActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smoke2 cel: 0 hide:)
				(Colonel
					view: 304
					loop: 0
					cycleSpeed: 1
					cel: 0
					setCycle: End self
				)
			)
			(1
				(Glow show: loop: 1 cel: 0 setCycle: Fwd)
				(= cycles 18)
			)
			(2
				(Glow hide:)
				(Colonel
					loop: 0
					cel: (- (NumCels Colonel) 1)
					setCycle: Beg self
				)
			)
			(3
				(smoke2 setCycle: Fwd show:)
				(smoke1 show: setCycle: End self)
			)
			(4
				(smoke1 cel: 0 hide:)
				(= cycles 1)
			)
			(5
				(if (< (Random 1 100) 30)
					(= state -1)
				else
					(= state 4)
				)
				(= seconds 5)
			)
		)
	)
)

(instance lillActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (Lillian cel:) 0)
					(Lillian loop: 0 cel: 3 setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1
				(Lillian loop: 0 cel: 0)
				(= seconds (Random 6 15))
			)
			(2
				(Lillian loop: 2 cel: 0 setCycle: End)
				(= seconds (Random 6 15))
			)
			(3
				(if (and (== (LHead loop:) 5) (== (LHead cel:) 2))
					(Lillian loop: 3 cel: 0 setCycle: End self)
				else
					(= state 0)
					(= cycles 1)
				)
			)
			(4
				(Lillian loop: 4 cel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(5
				(Lillian loop: 2 cel: 2 setCycle: Beg self)
				(= state 0)
			)
		)
	)
)

(instance headActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 12 18))
			)
			(1
				(LHead loop: 5 cel: 0 setCycle: End)
				(= seconds (Random 12 18))
			)
			(2
				(LHead setCycle: Beg)
				(= seconds (Random 12 18))
			)
			(3
				(LHead loop: 6 cel: 0 setCycle: End)
				(= seconds (Random 2 8))
			)
			(4
				(LHead setCycle: Beg)
				(= seconds (Random 12 18))
				(= state 0)
			)
		)
	)
)

(instance Colonel of Prop
	(properties
		y 97
		x 176
		view 312
	)

	(method (handleEvent event)
		(if (< (gEgo distanceTo: Colonel) (gEgo distanceTo: Lillian))
			(= global214 512)
		else
			(= global214 32)
		)
		(if (gCast contains: Lillian)
			(cond
				((Said 'look/people')
					(Print 270 23) ; "The Colonel and Lillian seem to be having a personal discussion. You feel as if you may be interrupting something."
				)
				((Said 'look,talk/person')
					(Print 270 24) ; "Which person are you referring to?"
				)
				((Said 'talk/people')
					(Print 270 25) ; "You can only talk to one person at a time."
				)
			)
		)
		(cond
			((Said 'talk/colonel,person')
				(if (gCast contains: Lillian)
					(= global213 10)
					(switch local1
						(0
							(Say 1 270 26) ; "This conversation ain't for you, young woman!"
						)
						(1
							(Say 1 270 27) ; "Will it do any good to ask you to leave my room?!"
						)
						(2
							(Say 1 270 28) ; "This is my private room, young lady!"
						)
						(3
							(Say 1 270 29) ; "Can't you get it through your thick skull?! I have nothin' to say to you!"
						)
						(else
							(Print 270 30) ; "The Colonel now eyes you coldly, and doesn't respond."
						)
					)
					(++ local1)
				else
					(event claimed: 0)
				)
			)
			((Said 'look/butt')
				(SetFlag 13)
				(Print 270 31) ; "The Colonel smokes a small, nasty-smelling cigar."
			)
			((Said 'get/butt')
				(Print 270 32) ; "It belongs to the Colonel!"
			)
			((or (MousedOn self event 3) (Said 'look/colonel,person'))
				(if (& global207 $0200)
					(if (gCast contains: Lillian)
						(Print 270 23) ; "The Colonel and Lillian seem to be having a personal discussion. You feel as if you may be interrupting something."
					else
						(Print 270 33) ; "Colonel Dijon tries to ignore you as you again invade the privacy of his room."
					)
				else
					(|= global207 $0200)
					(DoLook {colonel})
				)
				(event claimed: 1)
			)
		)
	)
)

(instance smoke1 of Prop
	(properties
		view 304
		loop 2
	)
)

(instance smoke2 of Prop
	(properties
		view 304
		loop 3
	)
)

(instance Lillian of Prop
	(properties
		y 94
		x 221
		view 502
	)

	(method (handleEvent event)
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
				(Print 270 23) ; "The Colonel and Lillian seem to be having a personal discussion. You feel as if you may be interrupting something."
			)
			((Said 'talk/lil')
				(= global213 6)
				(switch local2
					(0
						(Say 1 270 34) ; "I'll meet with you later, Laura. Okay?"
					)
					(1
						(Say 1 270 35) ; "Can't you see I'm talking to Uncle Henri?!"
					)
					(2
						(Say 1 270 36) ; "You don't understand, Laura. This is a PRIVATE conversation!"
					)
					(3
						(Say 1 270 37) ; "I'm beginning to wonder why I invited you in the first place!"
					)
					(else
						(Say 1 270 38) ; "Butt out, Laura!"
					)
				)
				(++ local2)
			)
		)
	)
)

(instance LHead of Prop
	(properties
		y 94
		x 221
		z 39
		view 502
		loop 7
	)
)

(instance Glow of Prop
	(properties
		view 304
		loop 1
	)
)

