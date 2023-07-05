;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 232)
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
	grargue 0
)

(synonyms
	(rudolph man)
	(actress woman)
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(Gloria setCel: -1 loop: 1 setCycle: Fwd)
	(Print &rest #at 40 140 #font 4 #width 125 #mode 1 #draw #dispose)
)

(procedure (localproc_1)
	(rHead setCel: -1 setCycle: Fwd)
	(Rudy setCycle: Fwd)
	(Print &rest #at 171 140 #font 4 #width 125 #mode 1 #draw #dispose)
)

(instance grargue of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gMustDos $0001))
			(LoadMany rsFONT 4 41)
			(Load rsVIEW 642)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsSCRIPT 406)
		)
		(LoadMany rsMESSAGE 243 223 222)
		(LoadMany rsSYNC 3 9)
		(= global208 260)
		(= [global377 2] 223)
		(= [global377 8] 222)
		(Gloria init:)
		(Rudy init:)
		(rHead setPri: 9 init:)
		(Smoke init: hide:)
		(Ash init: hide:)
		(if (!= gPrevRoomNum 49)
			(self setScript: argue)
		)
	)

	(method (doit)
		(super doit:)
	)

	(method (dispose)
		(if (and (not (& gSpyFlags $0001)) (== [gCycleTimers 0] 0))
			(= [gCycleTimers 0] 1800)
		)
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
					(cond
						((Said '/cigarette')
							(Print 232 0) ; "It appears that Gloria has acquired a bad habit."
						)
						((Said '/boa')
							(Print 232 1) ; "That's a beautiful feather boa Gloria is wearing."
						)
					)
				)
				((Said 'listen/rudolph,actress')
					(Print 232 2) ; "You're bothering them."
				)
				((Said 'get,smoke>')
					(cond
						((Said '/cigarette')
							(Print 232 3) ; "You don't want it!"
						)
						((Said '/boa')
							(Print 232 4) ; "It's not yours to take!"
						)
					)
				)
			)
		)
	)
)

(instance argue of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== global120 3)
			(User canInput: 0)
			(= global120 4)
			(= cycles 12)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0001))
						(|= gMustDos $0001)
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
				(if (== (= local3 (& global179 $7fff)) global179)
					(if (< global179 6)
						(++ global179)
					else
						(= global179 -32765)
					)
				else
					(switch local3
						(3
							(= global179 -32764)
						)
						(4
							(= global179 -32762)
						)
						(6
							(= global179 -32765)
						)
					)
				)
				(switch local3
					(0
						(localproc_0 232 5) ; "Uncle Henri's a strange old coot, he..."
					)
					(1
						(localproc_0 232 6) ; "Also, this place is so creepy, I...well, here she is again."
					)
					(2
						(localproc_1 232 7) ; "You know the situation as well as I do, Gloria. You'll just have to...oh, oh."
					)
					(3
						(localproc_0 232 8) ; "We keep getting interrupted, dahling."
					)
					(4
						(localproc_1 232 9) ; "Isn't there such a thing as privacy anymore?"
					)
					(5
						(localproc_1 232 10) ; "I agree with you, he just doesn't..."
					)
					(6
						(localproc_1 232 11) ; "This is getting very tedious."
					)
				)
				(= seconds 5)
			)
			(2
				(cls)
				(Gloria setCel: 0)
				(rHead loop: 4 setCel: 0)
				(Rudy loop: 0 setCycle: 0)
				(= seconds 1)
			)
			(3
				(cls)
				(switch local3
					(0
						(localproc_1 232 12) ; "Quiet. We're not alone anymore."
						(= seconds 3)
					)
					(5
						(localproc_1 232 13) ; "Ahem...interrupted again."
						(= seconds 3)
					)
					(26
						(localproc_1 232 14) ; "I know what you mean, toots."
						(= seconds 3)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(User canInput: 1)
				(Rudy setCycle: 0)
				(rHead setCel: 0 setScript: rudyActions)
				(cls)
				(Gloria setScript: gloriaActions)
			)
			(5
				(localproc_0 232 15) ; "Some people are so rude, don't you think, dahling?"
				(= state 1)
				(= local3 26)
				(= seconds 5)
			)
		)
	)
)

(instance gloriaActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (< global120 4) (> global120 0) (client script:))
			(++ global120)
			(client setScript: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(Gloria cel: 0 loop: 0 cycleSpeed: 0 setCycle: End)
				(= seconds 3)
			)
			(2
				(Gloria cel: (- (NumCels Gloria) 1) loop: 0 setCycle: Beg)
				(= seconds 2)
			)
			(3
				(Smoke show: setPri: (CoordPri (Gloria y:)) setCycle: End self)
			)
			(4
				(Smoke cel: 0 hide:)
				(= seconds (Random 2 5))
			)
			(5
				(Gloria cel: 0 loop: 4 setCycle: End self)
			)
			(6
				(Gloria cel: 0 loop: 5 cycleSpeed: 1 setCycle: Fwd)
				(Ash cel: 0 show: setCycle: End)
				(= cycles 5)
			)
			(7
				(Ash hide:)
				(Gloria cel: 2 loop: 4 setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance rudyActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (< global120 4) (> global120 0) (client script:))
			(++ global120)
			(client setScript: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(rHead setCel: -1 loop: 5 setCycle: End self)
				(= seconds (Random 3 5))
			)
			(2
				(Rudy cel: 0 loop: 2 setCycle: End)
				(= seconds (Random 3 5))
			)
			(3
				(rHead setCycle: Beg)
				(= seconds (Random 3 5))
			)
			(4
				(Rudy loop: 3 setCycle: End)
				(= seconds (Random 3 5))
			)
			(5
				(rHead setCycle: End)
				(= seconds (Random 5 8))
			)
			(6
				(rHead setCycle: Beg self)
				(= state 4)
			)
		)
	)
)

(instance Rudy of Prop
	(properties
		y 135
		x 178
		view 382
		cycleSpeed 2
	)

	(method (handleEvent event)
		(= global213 9)
		(if (< (gEgo distanceTo: Rudy) (gEgo distanceTo: Gloria))
			(= global214 256)
		else
			(= global214 4)
		)
		(cond
			((Said 'talk/rudolph')
				(switch local1
					(0
						(Say 1 232 16) ; "My sister and I are talking; do you mind?"
					)
					(1
						(Say 1 232 17) ; "Hurry up and get on with it!"
					)
					(else
						(Print 232 18) ; "Rudy looks at you impatiently."
					)
				)
				(++ local1)
			)
			((Said 'ask[/rudolph]/actress<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 13 232 19)
			)
			((and (not (& global207 $0100)) (MousedOn self event 3))
				(event claimed: 1)
				(DoLook {rudy})
			)
			(
				(and
					(& global207 $0100)
					(or (MousedOn self event 3) (Said 'look/rudolph'))
				)
				(event claimed: 1)
				(Print 232 20) ; "It seems like Gloria and Rudy are having a private discussion."
			)
		)
	)
)

(instance Gloria of Prop
	(properties
		y 137
		x 135
		view 362
	)

	(method (handleEvent event)
		(= global213 3)
		(cond
			((Said 'talk/actress')
				(switch local0
					(0
						(Say 1 232 21) ; "Please make it brief, dahling."
					)
					(1
						(Say 1 232 22) ; "Listen, dahling, don't you have anything better to do?"
					)
					(else
						(Print 232 23) ; "Gloria tries to ignore you."
					)
				)
				(++ local0)
			)
			((Said 'ask[/actress]/rudolph<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 21 232 24)
			)
			((Said 'look/people')
				(Print 232 20) ; "It seems like Gloria and Rudy are having a private discussion."
			)
			((Said 'look,talk/person,men')
				(Print 232 25) ; "Which person are you referring to?"
			)
			((Said 'talk/people')
				(Print 232 26) ; "You can only talk to one person at a time."
			)
			((and (not (& global207 $0004)) (MousedOn self event 3))
				(event claimed: 1)
				(DoLook {gloria})
			)
			(
				(and
					(& global207 $0004)
					(or (MousedOn self event 3) (Said 'look/actress[/!*]'))
				)
				(event claimed: 1)
				(Print 232 20) ; "It seems like Gloria and Rudy are having a private discussion."
			)
		)
	)
)

(instance Smoke of Prop
	(properties
		y 137
		x 139
		z 43
		view 362
		loop 2
		cycleSpeed 1
	)
)

(instance Ash of Prop
	(properties
		y 137
		x 143
		view 362
		loop 6
	)
)

(instance rHead of Prop
	(properties
		y 135
		x 178
		z 42
		view 382
		loop 4
		cycleSpeed 1
	)
)

