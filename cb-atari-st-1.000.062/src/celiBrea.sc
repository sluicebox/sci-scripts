;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 236)
(include sci.sh)
(use Main)
(use atsgl)
(use Interface)
(use Path)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	celiBrea 0
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
	[local8 11] = [190 154 186 154 105 154 24 123 -12 123 -32768]
	[local19 7] = [105 154 186 154 190 154 -32768]
	local26
)

(procedure (localproc_0)
	(Celie loop: 5 setCycle: Fwd)
	(Lillian loop: 3 cel: 2 setCycle: Beg)
	(LHead cel: 0 stopUpd:)
	(Print &rest #at 20 10 #font 4 #width 125 #mode 1 #dispose)
)

(procedure (localproc_1)
	(Lillian loop: 4 setCycle: Fwd)
	(LHead loop: 2 setCycle: Fwd)
	(Celie setCycle: 0)
	(Print &rest #at 160 145 #font 4 #width 140 #mode 1 #dispose)
)

(instance PathOut of Path
	(properties)

	(method (at param1)
		(return [local8 param1])
	)
)

(instance PathIn of Path
	(properties)

	(method (at param1)
		(return [local19 param1])
	)
)

(instance celiBrea of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (not (& gMustDos $0004))
			(LoadMany rsFONT 4 41)
			(LoadMany rsSOUND 29 94 95 96)
			(Load rsVIEW 642)
			(Load rsSCRIPT 406)
		)
		(LoadMany rsVIEW 480 499)
		(LoadMany rsMESSAGE 243 254 251)
		(LoadMany rsSYNC 2 6)
		(= global208 34)
		(= [global377 1] 254)
		(= [global377 5] 251)
		(roller ignoreActors: 1 setPri: 10 init: stopUpd: hide:)
		(pot ignoreActors: 1 setPri: 10 init: stopUpd:)
		(sprinkles ignoreActors: 1 setPri: 10 init: stopUpd: hide:)
		(Celie
			illegalBits: 0
			setPri: 10
			ignoreActors: 1
			setAvoider: (Avoid new:)
			init:
		)
		(Lillian setPri: 10 ignoreActors: 1 init: stopUpd:)
		(LHead setPri: 10 ignoreActors: 1 init: stopUpd:)
		(if (and (< gMinute 3) (== global155 0))
			(HandsOff)
			(Jeeves setAvoider: (Avoid new:) setScript: jeevActions init:)
		)
		(self setScript: bread)
	)

	(method (doit)
		(cond
			((gCast contains: Jeeves)
				(User canInput: 0)
			)
			((and (not local26) (not (gEgo script:)))
				(User canInput: 1)
			)
		)
		(DisposeScript 990)
		(if (and (< local2 70) (< global180 5))
			(++ local2)
		)
		(if (and local3 local4)
			(self setScript: casTalk)
		)
		(if (and local5 local3)
			(= local3 0)
			(Celie setScript: celieActions)
		)
		(if local6
			(= local6 0)
			(= local2 70)
			(Lillian setScript: lillActions)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 983)
		(DisposeScript 985)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
	)
)

(instance bread of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local26 1)
				(cond
					((not global216)
						(= state -1)
					)
					((not (& gMustDos $0004))
						(|= gMustDos $0004)
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
				(if (< global172 10)
					(++ global172)
				else
					(= global172 4)
				)
				(switch global172
					(1
						(localproc_0 236 0) ; "Now, now, chile. It ain't no use gettin' yourself upset. Things have a way o' workin' themselves out."
						(= seconds 7)
					)
					(2
						(localproc_1 236 1) ; "You know how they all are!"
						(= seconds 3)
					)
					(3
						(localproc_1 236 2) ; "Hi, Laura. Having fun?"
						(= seconds 3)
					)
					(4
						(localproc_0 236 3) ; "Mebbe your friend's hungry. She keep comin' in here."
						(= seconds 5)
					)
					(5
						(localproc_1 236 4) ; "You always understand me, you know, Celie?"
						(= seconds 5)
					)
					(6
						(localproc_1 236 5) ; "Teach me that chant again, Celie."
						(= seconds 4)
					)
					(7
						(localproc_1 236 6) ; "What'cha up to, Laura?"
						(= seconds 3)
					)
					(8
						(localproc_0 236 7) ; "Don't make no fuss 'bout that, darlin'!"
						(= seconds 4)
					)
					(9
						(localproc_0 236 8) ; "That ain't so bad, honey chile."
						(= seconds 3)
					)
					(else
						(localproc_0 236 9) ; "There's your friend...Missy Laura."
						(= seconds 4)
					)
				)
			)
			(2
				(cls)
				(Lillian stopUpd:)
				(LHead stopUpd:)
				(Celie stopUpd:)
				(switch global172
					(1
						(localproc_1 236 10) ; "I know, Celie...but, it just doesn't seem right!"
						(= seconds 5)
					)
					(2
						(localproc_0 236 11) ; "It'll be fine, Missy Lillian! You see."
						(= seconds 5)
					)
					(5
						(localproc_0 236 12) ; "I know, darlin'. You be all right."
						(= seconds 4)
					)
					(6
						(localproc_0 236 13) ; "Later, chile."
						(= seconds 3)
					)
					(8
						(localproc_1 236 14) ; "But, Celie...Oh, Laura."
						(= seconds 3)
					)
					(9
						(localproc_1 236 15) ; "Yes, it is!"
						(= seconds 3)
					)
					(else
						(= seconds 0)
						(= cycles 1)
					)
				)
			)
			(3
				(cls)
				(Lillian stopUpd:)
				(LHead stopUpd:)
				(Celie stopUpd:)
				(if (== global172 1)
					(localproc_1 236 16) ; "Oh...hi, Laura."
					(= seconds 3)
				else
					(= cycles 1)
				)
			)
			(4
				(cls)
				(LHead stopUpd:)
				(= local26 0)
				(if (not (gEgo script:))
					(User canInput: 1)
				)
				(= local2 0)
				(Lillian stopUpd: setScript: lillActions)
				(Celie setScript: celieActions)
				(client setScript: 0)
			)
		)
	)
)

(instance lillActions of Script
	(properties)

	(method (doit)
		(if (and local5 (self client:))
			(client setScript: 0)
			(= local4 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lillian ignoreActors: 1 loop: 5 setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(Lillian loop: 5 setCycle: Beg)
				(= seconds (Random 6 12))
			)
			(2
				(Lillian loop: 6 setCycle: End)
				(= seconds (Random 6 12))
			)
			(3
				(Lillian loop: 6 setCycle: Beg)
				(if (== local2 70)
					(client setScript: 0)
					(= local4 1)
				)
				(= seconds (Random 6 12))
				(= state -1)
			)
		)
	)
)

(instance celieActions of Script
	(properties)

	(method (doit)
		(if (not local7)
			(switch state
				(2
					(sprinkles show:)
				)
				(4
					(roller show:)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Celie loop: 0 setCycle: Fwd)
				(roller hide:)
				(= seconds (Random 3 6))
			)
			(1
				(Celie cel: 0 loop: 2 setCycle: End self)
			)
			(2
				(Celie cel: 0 loop: 3 setCycle: Fwd)
				(if (not local7)
					(sprinkles show:)
				)
				(sprinkles setCycle: Fwd)
				(= cycles 14)
			)
			(3
				(sprinkles cel: 0 hide:)
				(Celie cel: 0 stopUpd:)
				(if (and (== local2 70) (not local5))
					(client loop: 5 setScript: 0)
					(= local3 1)
				)
				(if (> (Random 1 100) 35)
					(= state -1)
				)
				(= seconds (Random 3 5))
			)
			(4
				(Celie
					view: 480
					setPri: -1
					loop: 2
					posn: 153 126
					ignoreActors: 0
					setCycle: Walk
					illegalBits: -32764
					setMotion: MoveTo 119 93 self
				)
				(if (not local7)
					(roller show:)
				)
			)
			(5
				(Celie loop: 3)
				(= seconds 3)
			)
			(6
				(Celie setMotion: MoveTo 145 131 self)
			)
			(7
				(Celie
					view: 485
					loop: 0
					cel: 0
					illegalBits: 0
					posn: 146 113
					ignoreActors: 1
					setPri: 10
				)
				(= state -1)
				(= seconds 1)
			)
		)
	)
)

(instance casTalk of Script
	(properties)

	(method (doit)
		(if local5
			(client setScript: 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local26 1)
				(User canInput: 0)
				(= local4 0)
				(= local3 0)
				(switch (++ global180)
					(1
						(localproc_0 236 17) ; "How's your momma doin' these days, chile?"
						(= seconds 5)
					)
					(2
						(localproc_1 236 18) ; "You make the best bread, Celie. I just love it!"
						(= seconds 5)
					)
					(3
						(localproc_1 236 19) ; "How's your son doing, Celie?"
						(= seconds 4)
					)
					(4
						(localproc_1 236 20) ; "Celie, could you make me up a new gris-gris for..."
						(= seconds 5)
					)
					(5
						(localproc_1 236 21) ; "Beauregard doesn't seem to have much energy anymore. All he does is lie around."
						(= seconds 7)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(cls)
				(Lillian stopUpd:)
				(Celie stopUpd:)
				(LHead stopUpd:)
				(Celie stopUpd:)
				(switch global180
					(1
						(localproc_1 236 22) ; "Oh...you know Mother, Celie."
						(= seconds 3)
					)
					(2
						(localproc_0 236 23) ; "Well, it'll be pipin' hot tomorrow mornin'!"
						(= seconds 4)
					)
					(3
						(localproc_0 236 24) ; "I'm so proud o' him, Missy Lillian! He's graduatin' from college, you know!"
						(= seconds 6)
					)
					(4
						(localproc_0 236 25) ; "Hush on that, chile! Not now!"
						(= seconds 4)
					)
					(5
						(localproc_0 236 26) ; "Why, he's 'most fifteen years ol', Missy Lillian. What do you 'spect?"
						(= seconds 7)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(cls)
				(LHead stopUpd:)
				(Celie stopUpd:)
				(Lillian stopUpd:)
				(Celie stopUpd:)
				(Lillian setScript: lillActions)
				(Celie setScript: celieActions)
				(= local26 0)
				(User canInput: 1)
				(= local2 0)
				(client setScript: 0)
			)
		)
	)
)

(instance jeevActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Jeeves loop: 4 setCycle: End self)
			)
			(1
				(Jeeves setCycle: Walk setMotion: MoveTo 221 119 self)
			)
			(2
				(global373 setCycle: End)
				(global374 setCycle: End self)
			)
			(3
				(Jeeves setCycle: Walk setMotion: MoveTo 251 119 self)
			)
			(4
				(global373 setCycle: Beg)
				(global374 setCycle: Beg self)
			)
			(5
				(global373 stopUpd:)
				(global374 stopUpd:)
				(User canControl: 1)
				(= [gCycleTimers 2] 1800)
				(= global155 1)
				(Jeeves setAvoider: 0 dispose:)
			)
		)
	)
)

(instance goSee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global213 6)
				(Say 1 236 27) ; "That can't be true, Laura, I'll go see!"
				(if (gEgo inRect: 180 145 200 150)
					(gEgo setMotion: MoveTo 212 160 self)
				else
					(= cycles 1)
				)
			)
			(1
				(Lillian
					view: 499
					loop: 0
					cel: 0
					posn: 193 143
					ignoreActors: 0
					setAvoider: ((Avoid new:) offScreenOK: 1)
					setCycle: End self
				)
				(LHead hide: dispose:)
				(if (gEgo inRect: 0 120 24 125)
					(gEgo setMotion: MoveTo (+ (gEgo x:) 40) (gEgo y:))
				)
			)
			(2
				(Lillian view: 500 setCycle: Walk setMotion: PathOut self)
			)
			(3
				(= global202 1)
				(= local7 1)
				(= seconds 2)
			)
			(4
				(= global202 2)
				(sprinkles hide:)
				(roller hide:)
				(= local7 0)
				(= cycles 2)
			)
			(5
				(Print 236 28 #dispose) ; "A short time later..."
				(Lillian setMotion: MoveTo 24 123 self)
			)
			(6
				(cls)
				(= global213 6)
				(Say 1 236 29) ; "Oh, you're just imagining things, Laura!"
				(Lillian setMotion: PathIn self)
			)
			(7
				(Lillian illegalBits: 0 setMotion: MoveTo 193 143 self)
			)
			(8
				(Lillian view: 499)
				(Lillian
					cel: (Lillian lastCel:)
					setAvoider: 0
					setCycle: Beg self
				)
			)
			(9
				(Lillian view: 515 posn: 201 132)
				(LHead setPri: 10 ignoreActors: 1 init: stopUpd:)
				(HandsOn)
				(= local5 0)
				(= local6 1)
				(client setScript: 0)
			)
		)
	)
)

(instance roller of Prop
	(properties
		y 113
		x 147
		view 485
		loop 1
	)

	(method (handleEvent)
		(cond
			((Said 'get/pin<rolling')
				(Print 236 30) ; "Celie won't let you."
			)
			((Said 'look/pin<rolling')
				(Print 236 31) ; "Looks like Celie is rolling out bread."
			)
		)
	)
)

(instance pot of Prop
	(properties
		y 112
		x 133
		view 485
		loop 1
		cel 1
	)
)

(instance sprinkles of Prop
	(properties
		y 126
		x 145
		z 20
		view 485
		loop 4
	)
)

(instance Celie of Act
	(properties
		y 113
		x 146
		view 485
	)

	(method (handleEvent event)
		(if (< (gEgo distanceTo: Celie) (gEgo distanceTo: Lillian))
			(= global214 2)
		else
			(= global214 32)
		)
		(= global213 2)
		(cond
			((Said 'look/woman')
				(event claimed: 1)
				(if (== global214 2)
					(DoLook {celie})
				else
					(DoLook {lillian})
				)
			)
			((and (MousedOn self event 3) (not (& global207 $0002)))
				(event claimed: 1)
				(DoLook {celie})
			)
			(
				(and
					(& global207 $0002)
					(or (MousedOn self event 3) (Said 'look/celie'))
				)
				(event claimed: 1)
				(Print 236 32) ; "Lillian and Celie seem to be having a discussion while Celie is making tomorrow's bread on the kitchen table."
			)
			((or (Said 'talk/celie') (and (== global214 2) (Said 'talk/woman')))
				(switch local0
					(0
						(Say 1 236 33) ; "I'm busy. Go on wid you now!"
					)
					(1
						(Say 1 236 34) ; "Me and Missy Lillian got some talkin' to do. Don't be botherin' us."
					)
					(else
						(Print 236 35) ; "Maybe Celie doesn't trust you? Anyway, she now refuses to answer you."
					)
				)
				(++ local0)
			)
			((Said 'ask[/celie]/lil<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 15 236 36)
			)
			((Said 'listen/celie,lil')
				(Print 236 37) ; "You shouldn't be such a snoop, Laura!"
			)
			((Said 'look/bread,dough')
				(Print 236 38) ; "Celie is rolling out tomorrow's bread on the kitchen table."
			)
			((Said 'get,eat/bread,dough')
				(Print 236 39) ; "Wait 'til tomorrow."
			)
			((Said 'give,show/necklace')
				(if (gEgo has: 0) ; necklace
					(if (< (gEgo distanceTo: Celie) 60)
						(Say 1 236 40) ; "My necklace! I wuz wunderin' where it got to! "Well, Missy Laura, thank you!"
						(gEgo put: 0) ; necklace
						(= global135 1)
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(DontHave) ; "You don't have it."
				)
			)
		)
	)
)

(instance LHead of Prop
	(properties
		y 98
		x 205
		view 515
		loop 1
	)
)

(instance Lillian of Act
	(properties
		y 132
		x 201
		view 515
		loop 3
	)

	(method (handleEvent event)
		(= global213 6)
		(cond
			((Said 'look/people')
				(Print 236 32) ; "Lillian and Celie seem to be having a discussion while Celie is making tomorrow's bread on the kitchen table."
			)
			((and (not (& global207 $0020)) (MousedOn self event 3))
				(event claimed: 1)
				(DoLook {lillian})
			)
			(
				(and
					(& global207 $0020)
					(or (MousedOn self event 3) (Said 'look/lil,people'))
				)
				(event claimed: 1)
				(Print 236 32) ; "Lillian and Celie seem to be having a discussion while Celie is making tomorrow's bread on the kitchen table."
			)
			((Said 'look,talk/person,woman')
				(Print 236 41) ; "Which person are you referring to?"
			)
			((Said 'talk/people')
				(Print 236 42) ; "You can only talk to one person at a time."
			)
			((and (IsFlag 51) (Said 'tell[/lil]/gertie<about'))
				(= global213 6)
				(cls)
				(if (& gCorpseFlags $0001) ; Gertie
					(if (& global145 $0001)
						(Say 1 236 43) ; "Like I said before, Laura, there's nothing there!"
					else
						(HandsOff)
						(|= global145 $0001)
						(= local5 1)
						(if (Lillian script:)
							(((Lillian script:) client:) setScript: 0)
						)
						(Lillian startUpd: setScript: goSee)
					)
				else
					(event claimed: 0)
				)
			)
			((Said 'talk/lil,woman')
				(switch local1
					(0
						(Say 1 236 44) ; "What'cha want, Laura?"
					)
					(1
						(Say 1 236 45) ; "Finding everything okay?"
					)
					(2
						(Say 1 236 46) ; "Do you mind, Laura? I'd like to talk to Celie."
					)
					(3
						(Say 1 236 47) ; "I haven't seen Celie in a long time. Can you leave us alone, Laura?!"
					)
					(else
						(Print 236 48) ; "Your friend seems more intent upon talking with Celie than with you. Perhaps, you should leave."
					)
				)
				(++ local1)
			)
			((Said 'ask[/lil]/celie<about')
				(= global212 1)
				(= global209 event)
				(proc243_1 5 236 49)
			)
		)
	)
)

(instance Jeeves of Act
	(properties
		y 144
		x 157
		view 451
		loop 4
	)

	(method (handleEvent event)
		(= global213 11)
		(cond
			((and (not (& global207 $0400)) (MousedOn self event 3))
				(event claimed: 1)
				(DoLook {jeeves})
			)
			(
				(and
					(& global207 $0400)
					(or (MousedOn self event 3) (Said 'look/butler'))
				)
				(event claimed: 1)
				(Print 236 32) ; "Lillian and Celie seem to be having a discussion while Celie is making tomorrow's bread on the kitchen table."
			)
		)
	)
)

