;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 217)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	GertieClarArgue 0
)

(synonyms
	(butt cigarette)
	(gertie woman)
	(attorney man)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(procedure (localproc_0)
	(Gertie loop: 2 cycleSpeed: 1 setCycle: Fwd)
	(Clarence setCycle: 0)
	(Print &rest #at 10 140 #font 4 #width 125 #mode 1 #draw #dispose)
)

(procedure (localproc_1)
	(Gertie loop: 1 cel: 1 stopUpd:)
	(Clarence loop: 3 cel: 0 cycleSpeed: 1 setCycle: Fwd)
	(Print &rest #at 101 140 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance GertieClarArgue of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gSpyFlags $0002))
			(LoadMany rsFONT 4 41)
			(Load rsVIEW 642)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
		)
		(LoadMany rsMESSAGE 243 218)
		(LoadMany rsSYNC 7 1)
		(= global208 64)
		(= [global377 6] 218)
		(= [global377 0] 216)
		(ClarAss init: stopUpd:)
		(Clarence setPri: 6 init:)
		(Smoke setPri: 6 init: hide:)
		(gEgo observeBlocks: gBlock)
		(if (not (& gSpyFlags $0002))
			(LoadMany rsMESSAGE 216)
			(Gertie init:)
			(self setScript: argue)
			(|= global208 $0001)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(if (and (not (& gSpyFlags $0002)) (== [gCycleTimers 1] 0))
			(= [gCycleTimers 1] 1800)
		)
		(DisposeScript 204)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '/butt')
							(SetFlag 13)
							(Print 217 0) ; "That's a big cigar!"
						)
						((Said '/drink,glass')
							(Print 217 1) ; "Clarence is drinking cognac at the bar."
						)
					)
				)
				((Said 'listen/attorney,gertie')
					(Print 217 2) ; "You've interrupted them."
				)
				((Said 'get/butt')
					(Print 217 3) ; "He wouldn't give it to you!"
				)
				((Said 'get/drink,glass')
					(Print 217 4) ; "You don't care for liquor...remember?"
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
				(if (== (= local6 (& global172 $7fff)) global172)
					(if (< global172 10)
						(++ global172)
					else
						(= global172 -32767)
					)
				else
					(switch local6
						(1
							(= global172 -32766)
						)
						(2
							(= global172 -32763)
						)
						(5
							(= global172 -32762)
						)
						(6
							(= global172 -32759)
						)
						(9
							(= global172 -32758)
						)
						(10
							(= global172 -32767)
						)
					)
				)
				(switch local6
					(0
						(localproc_1 217 5) ; "...that old biddy! She's half-sloshed most of the time and..."
					)
					(1
						(localproc_0 217 6) ; "Here she is again..."
					)
					(2
						(localproc_1 217 7) ; "As I was saying...ahem."
					)
					(3
						(localproc_0 217 8) ; "I agree she tipples a bit, but..."
					)
					(4
						(localproc_1 217 9) ; "...and I'd love to get my hands on...Oh, oh."
					)
					(5
						(localproc_0 217 10) ; "We have company!"
					)
					(6
						(localproc_1 217 11) ; "Interruptions! Interruptions!"
					)
					(7
						(localproc_0 217 12) ; "You're not being fair, Clarence!"
					)
					(8
						(localproc_1 217 13) ; "And about that other little matter. Your darling..."
					)
					(9
						(localproc_0 217 14) ; "I know, but...ahem."
					)
					(10
						(localproc_1 217 15) ; "We're not alone."
					)
				)
				(= seconds 5)
			)
			(2
				(cls)
				(switch local6
					(0
						(localproc_1 217 16) ; "Shhh. Here's that young friend of Lillian's."
					)
					(3
						(localproc_0 217 17) ; "Yes, it certainly is a lovely evening!"
					)
					(7
						(localproc_1 217 18) ; "Shhhh!"
					)
					(8
						(localproc_0 217 19) ; "Never mind!"
					)
					(else
						(Clarence setCycle: 0)
						(Gertie loop: 1 cel: 1 stopUpd:)
					)
				)
				(= seconds 3)
			)
			(3
				(cls)
				(Gertie loop: 1 cel: 1 stopUpd: setScript: gertActions)
				(Clarence stopUpd: setScript: clarActions)
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance gertActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Gertie loop: 1 cel: 1 forceUpd:)
				(= seconds (Random 3 8))
			)
			(1
				(Gertie loop: 1 cel: 0 forceUpd:)
				(= state (Random -1 1))
				(= seconds (Random 3 8))
			)
			(2
				(Gertie loop: 0 cel: 0 setCycle: End)
				(= seconds (Random 3 5))
			)
			(3
				(Gertie loop: 0 cel: 0 setCycle: End)
				(= seconds (Random 3 8))
			)
			(4
				(Gertie loop: 3 setCycle: Fwd)
				(= seconds (Random 3 8))
			)
			(5
				(Gertie setCycle: 0 stopUpd:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance clarActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= state 5)
				(= cycles 1)
			)
			(1
				(Clarence setLoop: 1 cel: 0 setCycle: End self)
				(= local3 (Random 1 3))
				(= local4 0)
			)
			(2
				(= seconds 2)
			)
			(3
				(Clarence setLoop: 4 cel: 1)
				(= cycles 1)
			)
			(4
				(Smoke cel: 0 setCycle: End self show:)
			)
			(5
				(if (< local4 local3)
					(++ local4)
					(Clarence cel: 0)
					(= cycles (= state 1))
				else
					(Smoke cel: 0 hide:)
					(Clarence setLoop: 5)
					(Clarence
						cel: (- (NumCels Clarence) 3)
						cycleSpeed: 2
						setCycle: Beg
					)
					(= seconds (Random 3 6))
				)
			)
			(6
				(Clarence setLoop: 2)
				(Clarence cel: (- (NumCels Clarence) 1))
				(= cycles 1)
			)
			(7
				(Clarence setCycle: Beg)
				(switch (Random 1 4)
					(1
						(= state 0)
					)
					(3
						(= state 8)
					)
				)
				(= seconds (Random 3 6))
			)
			(8
				(Clarence setCycle: End)
				(= state 6)
				(= seconds (Random 3 6))
			)
			(9
				(Clarence setLoop: 9 cel: 0 setCycle: End)
				(= seconds (Random 1 2))
			)
			(10
				(Clarence setCycle: Beg)
				(= seconds (Random 3 6))
				(if (< seconds 5)
					(= state 0)
				else
					(= state 5)
				)
			)
		)
	)
)

(instance Gertie of Prop
	(properties
		y 103
		x 125
		view 342
	)

	(method (handleEvent event)
		(if (< (gEgo distanceTo: Gertie) (gEgo distanceTo: Clarence))
			(= global214 1)
		else
			(= global214 64)
		)
		(= global213 1)
		(cond
			((Said 'look/people')
				(Print 217 20) ; "Clarence seems to be having a "heated" discussion with Gertie."
			)
			((Said 'look,talk/person')
				(Print 217 21) ; "Which person are you referring to?"
			)
			((Said 'talk/people')
				(Print 217 22) ; "You can only talk to one person at a time."
			)
			((Said 'ask[/gertie]/attorney<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 4 217 23)
			)
			((Said 'talk/gertie')
				(switch local0
					(0
						(Say 1 217 24) ; "Please leave us be, Laura."
					)
					(1
						(Say 1 217 25) ; "We were having a private discussion here."
					)
					(2
						(Say 1 217 26) ; "It would be best if you left, Laura."
					)
					(else
						(Say 1 217 27) ; "Please go, Laura!"
					)
				)
				(++ local0)
			)
			((and (MousedOn self event 3) (not (& global207 $0001)))
				(event claimed: 1)
				(DoLook {gertie})
			)
			(
				(and
					(& global207 $0001)
					(or (MousedOn self event 3) (Said 'look/gertie'))
				)
				(Print 217 28) ; "It looks like Gertie and Clarence are "having words.""
				(event claimed: 1)
			)
		)
	)
)

(instance Clarence of Prop
	(properties
		y 74
		x 171
		view 401
		loop 1
	)

	(method (handleEvent event)
		(= global213 7)
		(cond
			((Said 'talk/attorney')
				(switch local1
					(0
						(Say 1 217 29) ; "This IS a private conversation, young lady. Do you mind?"
					)
					(1
						(Say 1 217 30) ; "Did you understand me? Leave us alone!"
					)
					(2
						(Say 1 217 31) ; "Stop pestering me, young woman!--Laura--or whatever your name is!"
					)
					(else
						(Say 1 217 32) ; ""Bug off!!"
					)
				)
				(++ local1)
			)
			((Said 'ask[/attorney]/gertie<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 9 217 33)
			)
			((and (MousedOn self event 3) (not (& global207 $0040)))
				(event claimed: 1)
				(DoLook {clarence})
			)
			(
				(and
					(& global207 $0040)
					(or (MousedOn self event 3) (Said 'look/attorney'))
				)
				(event claimed: 1)
				(Print 217 20) ; "Clarence seems to be having a "heated" discussion with Gertie."
			)
		)
	)
)

(instance ClarAss of Prop
	(properties
		y 102
		x 168
		view 401
		cel 2
	)
)

(instance Smoke of Prop
	(properties
		y 60
		x 167
		view 401
		loop 6
	)
)

(instance gBlock of Blk
	(properties
		top 98
		left 115
		bottom 104
		right 140
	)
)

