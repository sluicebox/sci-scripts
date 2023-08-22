;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
(include sci.sh)
(use Main)
(use Interface)
(use rgClouds)
(use mwAvoider)
(use NewFeature)
(use Blk)
(use LoadMany)
(use Wander)
(use Chase)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm58 0
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
)

(procedure (localproc_0)
	(= local7 0)
	(if (or (localproc_6) (localproc_7))
		(return)
	)
	(if (gEgo blocks:)
		(gEgo ignoreBlocks: sleepingGiant)
	)
	(if (or (gEgo has: 16) local6 local5) ; Magic_Shield
		(localproc_1)
		(giant ignoreActors: 0 setMotion: Wander 50 setAvoider: mwAvoider)
		(= local7 0)
	else
		(giant
			setAvoider: mwAvoider
			setCycle: SyncWalk
			setMotion: Chase gEgo 15
		)
		(= local7 1)
		((ScriptID 0 21) init: number: 39 loop: -1 playBed:) ; gameSound
	)
)

(procedure (localproc_1)
	(if (not local0)
		(cond
			(local5
				(Print 58 40) ; "The giant cannot see you since you are invisible."
			)
			((gEgo has: 16) ; Magic_Shield
				(Print 58 41) ; "Fortunately, you have the magic shield with you. It's preventing the giant from pulverizing you!"
			)
			(local6
				(Print 58 42) ; "The fairy godmother's spell is protecting you."
			)
		)
		(= local0 1)
	)
)

(procedure (localproc_2 &tmp temp0 temp1)
	(= temp0 (giant x:))
	(= temp1 (giant y:))
	(= local2
		((Blk new:)
			left: (- temp0 5)
			top: (- temp1 38)
			right: (+ temp0 5)
			bottom: (- temp1 32)
			init:
			yourself:
		)
	)
	(= local3
		((Blk new:)
			left: (- temp0 11)
			top: (- temp1 31)
			right: (+ temp0 11)
			bottom: (- temp1 12)
			init:
			yourself:
		)
	)
	(= local4
		((Blk new:)
			left: (- temp0 16)
			top: (- temp1 11)
			right: (+ temp0 16)
			bottom: (+ temp1 1)
			init:
			yourself:
		)
	)
	(gEgo observeBlocks: local2 local3 local4)
)

(procedure (localproc_3)
	(cond
		((localproc_7)
			(Print 58 43) ; "Talk about overkill--he's dead already!"
		)
		((IsFlag 1)
			(Print 58 44) ; "Not when you're invisible!"
		)
		((localproc_6)
			(Print 58 45) ; "Now that he's asleep, he's completely harmless. There's no reason to hurt him."
		)
		((gCurRoom script:)
			(Print 58 46) ; "Not now."
		)
		(else
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_4 param1 param2)
	(return
		(== ((gInventory at: param1) owner:) (if (== argc 1) gCurRoomNum else param2))
	)
)

(procedure (localproc_5)
	(return (== (giant view:) (+ 140 (if (localproc_4 1) 0 else 300))))
)

(procedure (localproc_6)
	(return (== (giant view:) 142))
)

(procedure (localproc_7)
	(return (!= global132 -1))
)

(instance rm58 of cloudRoom
	(properties
		picture 58
		east 59
		south 61
		west 57
		picAngle 60
	)

	(method (init)
		(LoadMany
			rsVIEW
			140
			141
			142
			143
			144
			(+ 140 (if (localproc_4 1) 0 else 300))
			(+ 144 (if (localproc_4 1) 0 else 300))
			141
			(+ 141 (if (localproc_4 1) 0 else 300))
			67
			40
			53
			440
			441
			444
		)
		(LoadMany rsSOUND 76 77 59 19 18 75 39 66)
		(super init:)
		(proc610_1
			0
			0
			(proc0_18 53 (gEgo x:) 0)
			188
			315
			(proc0_18 174 (proc0_17 189 (gEgo y:) 79) 143)
			11
			(proc0_17 188 (gEgo y:) 77)
			309
		)
		(= local5 (IsFlag 1))
		(= local6 (!= 0 global124))
		(= local0 0)
		(gEgo init:)
		(proc0_1)
		(tree1 init:)
		(tree2 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
		(tree7 init:)
		(tree8 init:)
		(tree9 init:)
		(cloud init:)
		(giant init:)
		(chest init:)
		(localproc_0)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (giant script:) catchEgo)
				((giant script:) doit:)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(EDGE_TOP north)
						(EDGE_RIGHT east)
						(EDGE_BOTTOM south)
						(EDGE_LEFT west)
					)
				)
				(self newRoom: temp0)
			)
			((giant script:)
				((giant script:) doit:)
			)
		)
		(if (not script)
			(if (!= local5 (IsFlag 1))
				(= local5 (IsFlag 1))
				(localproc_0)
			)
			(if (!= local6 (!= 0 global124))
				(= local6 (> 0 global124))
				(localproc_0)
			)
		)
	)
)

(instance giant of Actor
	(properties
		yStep 3
		cycleSpeed 2
		illegalBits -32672
		xStep 4
		moveSpeed 2
	)

	(method (init)
		(super init:)
		(cond
			((localproc_7)
				(self
					view: 143
					loop: 1
					cel: 5
					posn: global132 global133
					stopUpd:
				)
				(localproc_2)
			)
			((IsFlag 38)
				(giant
					view: 142
					loop: 0
					cel: 0
					posn: 112 158
					setCycle: 0
					setMotion: 0
					setAvoider: 0
					stopUpd:
				)
				(giantHead init:)
			)
			(else
				(= local1
					(cond
						((not (>= global101 1)) 250)
						((localproc_4 1) 1070)
						(else -1)
					)
				)
				(self
					view: (+ 140 (if (localproc_4 1) 0 else 300))
					ignoreActors:
					posn: 134 118
					setCycle: SyncWalk
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (> local1 0) (== (-- local1) 20))
			((ScriptID 0 21) fade:) ; gameSound
		)
		(cond
			((and (localproc_5) (not local1) (not (gCurRoom script:)))
				(-- local1)
				(giant setScript: sleepGiant)
			)
			(
				(and
					(!= (giant script:) catchEgo)
					(!= (gCurRoom script:) useSling)
					(localproc_5)
					(OneOf
						(gEgo view:)
						0
						4
						7
						2
						(if (IsFlag 0) 23 else 16)
						(if (IsFlag 0) 17 else 15)
					)
					(or
						(OneOf (giant script:) 0 sleepGiant)
						(OneOf (gEgo view:) 32 23 17)
					)
					(!= (gEgo view:) 38)
					(!= (gEgo view:) 39)
					(< (self distanceTo: gEgo) 20)
				)
				(if local7
					(giant setScript: catchEgo)
				else
					(localproc_1)
				)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/giant') (MousedOn self event))
				(event claimed: 1)
				(cond
					((localproc_4 1)
						(cond
							((localproc_7)
								(Print 58 0) ; "The giant is lying dead on the ground; beside him is a sturdy chest."
							)
							((localproc_6)
								(Print 58 1) ; "The giant is asleep, with a chest lying next to him."
							)
							(else
								(Print 58 2) ; "The enormous giant has been carrying that heavy chest for longer than he can remember."
							)
						)
					)
					((localproc_7)
						(Print 58 3) ; "The giant is lying dead on the ground, slain by a pebble to the forehead."
					)
					((localproc_6)
						(Print 58 4) ; "The huge giant has fallen asleep and is now snoring loudly."
					)
					(else
						(Print 58 5) ; "The giant is enormous! He does look rather stupid, though."
					)
				)
			)
			((or (Said 'talk,talk,say[/*][/*]') (Said 'hello'))
				(cond
					((localproc_7)
						(Print 58 6) ; "A dead giant does not have a lot to say."
					)
					((localproc_6)
						(Print 58 7) ; "It is not a good idea to wake a sleeping giant."
					)
					(else
						(Print 58 8) ; "The giant is in no mood for talking."
					)
				)
			)
			((Said 'wake/giant')
				(cond
					((localproc_7)
						(Print 58 9) ; "No matter how much noise you make, you can't wake the dead!"
					)
					((localproc_6)
						(Print 58 7) ; "It is not a good idea to wake a sleeping giant."
					)
					(else
						(Print 58 10) ; "This giant is already awake...and he's in a bad mood!"
					)
				)
			)
			((Said 'tickle/giant')
				(if (localproc_7)
					(Print 58 11) ; "Tickling a dead giant? The thin air up here must be affecting your mind."
				else
					(Print 58 12) ; "The giant isn't ticklish. And it's a good thing for you that he isn't!"
				)
			)
			((Said 'stab/giant')
				(if (gEgo has: 0) ; Dagger
					(Print 58 13) ; "Getting that close to the giant would be dangerous. Besides, you couldn't reach his weak spot."
				else
					(Print 58 14) ; "You don't anything sharp enough to even try that."
				)
			)
			(
				(or
					(Said 'use/shot')
					(Said 'kill/giant/shot')
					(Said 'drop/pebble/shot')
					(Said 'shoot/giant[/shot]')
				)
				(cond
					((localproc_3))
					((not (gEgo has: 10)) ; Leather_Slingshot
						(Print 58 15) ; "You'll need something to help you kill the giant -- if that's how you want to defeat him!"
					)
					((not (gEgo has: 9)) ; Pebbles
						(Print 58 16) ; "You need some kind of small rock to use the sling."
					)
					((== (giant script:) sleepGiant)
						(Print 58 17) ; "With the giant going to sleep, it would be unnecessary and cruel to kill him."
					)
					(else
						(gCurRoom setScript: useSling)
					)
				)
			)
			((Said 'kill/giant>')
				(cond
					((localproc_3)
						(event claimed: 1)
					)
					((Said '/dagger')
						(if (gEgo has: 0) ; Dagger
							(self setScript: (ScriptID 780 0)) ; throwDag
						else
							(Print 58 18) ; "You don't have a dagger."
						)
					)
					(else
						(Print 58 19) ; "With what?"
						(event claimed: 1)
					)
				)
			)
			((Said 'throw,throw/boulder,pebble[/giant]')
				(if (localproc_6)
					(Print 58 20) ; "If you're trying to knock out the giant, don't bother. He's already knocked out from chasing you."
				)
			)
			((Said 'give/*[/giant,man]')
				(cond
					((== (giant view:) 143)
						(Print 58 21) ; "Now that he's dead, the giant couldn't care less what you want to give him."
					)
					((gEgo has: 1) ; Chest
						(Print 58 22) ; "The giant does not need anything. All he wants from you is to grind your bones to dust."
					)
					(else
						(Print 58 23) ; "The giant, with his chest, has all the treasure he needs; all he wants from you is to grind your bones to dust."
					)
				)
			)
			((Said 'kiss/giant')
				(if (not (localproc_4 1))
					(Print 58 24) ; "You have no reason to do that."
				else
					(Print 58 25) ; "How?"
				)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance giantHead of Prop
	(properties
		z 22
		description {giant}
		view 142
		loop 1
		cycleSpeed 4
	)

	(method (init)
		(super init:)
		(self posn: (giant x:) (giant y:) setScript: snorer)
	)
)

(instance snorer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(giantHead cel: 0 setCycle: CT 3 1)
				((ScriptID 0 21) number: 76 loop: 1 play: self) ; gameSound
			)
			(1
				(= cycles 10)
			)
			(2
				(giantHead setCycle: End)
				((ScriptID 0 21) number: 77 play: self) ; gameSound
			)
			(3
				(= cycles 30)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance chest of View
	(properties
		view 142
		cel 1
	)

	(method (init)
		(if (not (localproc_4 1))
			(return)
		)
		(super init:)
		(if (localproc_5)
			(self hide:)
		else
			(self posn: (+ (giant x:) 1) (- (giant y:) 2) show:)
		)
		(self stopUpd:)
		(gCast delete: self addToFront: self)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event)
				(return 1)
			)
			((Said 'look,look/chest')
				(self doVerb: 1)
			)
			((Said 'look,look/grass')
				(cond
					((localproc_5)
						(Print 58 26) ; "You see nothing of interest on the ground."
					)
					((> (gEgo distanceTo: self) 20)
						(Print 58 27) ; "There is a chest near the sleeping giant."
					)
					(else
						(Print 58 28) ; "On the ground near the giant is a magic chest that appears to have been fashioned from ebony and rimmed on the edges with gold."
					)
				)
			)
			((Said 'get,get/chest')
				(self doVerb: 7)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(cond
					((localproc_5)
						(Print 58 29) ; "The giant is carrying a chest."
					)
					((and (localproc_7) (> (gEgo distanceTo: self) 20))
						(Print 58 30) ; "There is a chest near the deceased giant."
					)
					((and (localproc_6) (> (gEgo distanceTo: self) 20))
						(Print 58 27) ; "There is a chest near the sleeping giant."
					)
					(else
						(Print 58 31) ; "The magic chest appears to have been fashioned from a solid block of maple and burnished to a brilliant luster. The edges are rimmed with gold, as are the clasp and hinges."
					)
				)
			)
			(7
				(cond
					((gCurRoom script:)
						(PrintTooBusy)
					)
					((localproc_5)
						(Print 58 32) ; "The giant is protecting the magic chest."
					)
					((> (gEgo distanceTo: self) 20)
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					(else
						(gCurRoom setScript: getChest)
					)
				)
			)
		)
	)
)

(instance catchEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_15 giant gEgo)
				(self cue:)
			)
			(1
				((ScriptID 0 21) fade:) ; gameSound
				(giant ignoreControl: 64)
				(if (== (giant loop:) 2)
					(giant
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 9) self
					)
				else
					(gEgo hide:)
					(giant
						cycleSpeed: 1
						view: (+ 144 (if (localproc_4 1) 0 else 300))
						loop: (if (== (giant loop:) 1) 1 else 0)
						cel: 0
						setCycle: End self
					)
					(if (== (giant loop:) 3)
						(- (giant y:) 9)
					)
				)
			)
			(2
				(if (!= (gEgo view:) 63)
					(gEgo hide:)
					(giant
						view: (+ 141 (if (localproc_4 1) 0 else 300))
						cel: (if (== (giant loop:) 2) 3 else 0)
						y: (+ (giant y:) 6)
						loop: 0
						cycleSpeed: 1
						setMotion: 0
						setAvoider: 0
						setCycle: CT 10 1 self
					)
				else
					(self dispose:)
				)
			)
			(3
				((ScriptID 0 21) number: 59 loop: 1 play:) ; gameSound
				(= cycles 1)
			)
			(4
				(ShakeScreen 6)
				(giant setCycle: End self)
			)
			(5
				(gEgo
					view: 141
					loop: 1
					cel: 0
					setPri: 0
					posn: (giant x:) (giant y:)
					stopUpd:
					show:
				)
				(giant
					view: (+ 140 (if (localproc_4 1) 0 else 300))
					loop: 0
					cel: 0
					setCycle: SyncWalk
					cycleSpeed: 2
					setMotion: Wander
					setAvoider: mwAvoider
				)
				(= seconds 3)
			)
			(6
				(HandsOn)
				(EgoDead 58 33)
				(self dispose:)
			)
		)
	)
)

(instance getChest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setAvoider: mwAvoider
					setMotion:
						MoveTo
						(+
							(chest x:)
							(* 10 (if (< (gEgo x:) (giant x:)) -1 else 1))
						)
						(+ (chest y:) 7)
						self
				)
			)
			(1
				(gEgo
					view: 67
					loop:
						(+
							(if local5 2 else 0)
							(if (< (gEgo x:) (giant x:)) 0 else 1)
						)
					cel: 0
					setMotion: 0
					setAvoider: 0
					cycleSpeed: 1
					setCycle: End
				)
				(= cycles 7)
			)
			(2
				(getSound init: play:)
				(if (not (localproc_7))
					(Print 58 34 #at -1 20 #width 280) ; "Slowly, carefully, you take the chest without waking the giant."
				)
				(chest dispose:)
				(= cycles 1)
			)
			(3
				(gEgo setCycle: Beg self get: 1) ; Chest
				(SetScore 87 8)
			)
			(4
				(if (localproc_7)
					(Print 58 35 #at -1 20 #width 280) ; "It's easy to take a magic chest from a dead giant."
				else
					(giantHead setScript: snorer)
				)
				(proc0_1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance useSling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) fade:) ; gameSound
				(giant
					view: (+ 140 (if (localproc_4 1) 0 else 300))
					loop: 0
					setCycle: SyncWalk
				)
				(proc0_15 gEgo giant)
				(cond
					((> (giant y:) 176)
						(giant setMotion: MoveTo (giant x:) 176 self)
					)
					((& (giant onControl: 1) $4000)
						(giant
							setMotion: MoveTo (giant x:) (- (giant y:) 20) self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(proc0_15 giant gEgo)
				(gEgo
					view: 40
					cel: 0
					cycleSpeed: 1
					setCycle: CT (if (< (gEgo loop:) 2) 7 else 5) 1 self
				)
			)
			(2
				((ScriptID 0 21) number: 19 loop: 1 play:) ; gameSound
				(gEgo cel: (if (< (gEgo loop:) 2) 8 else 6) setCycle: End)
				(= cycles (proc0_17 25 (/ (gEgo distanceTo: giant) 5) 5))
			)
			(3
				((ScriptID 0 21) number: 18 loop: 1 play:) ; gameSound
				(giant
					view: 143
					loop: (if (localproc_4 1) 0 else 2)
					cel: 0
					cycleSpeed: 4
					setCycle: CT 1 1
					setAvoider: 0
					setMotion: 0
					ignoreActors:
					ignoreControl: 64
				)
				(= cycles 7)
			)
			(4
				(self setScript: sitGiant self)
			)
			(5
				(localproc_2)
				(if (not (gEgo canBeHere:))
					(proc0_1)
					(gEgo view: 141 loop: 1 cel: 0 setPri: 0)
				else
					(proc0_1)
				)
				(giant view: 143 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(6
				((ScriptID 0 21) number: 59 loop: 1 play:) ; gameSound
				(self cue:)
			)
			(7
				(ShakeScreen 6)
				(giant setCycle: End self)
			)
			(8
				(if (== (gEgo view:) 141)
					(EgoDead 58 36)
				)
				(SetScore 86 3)
				(UpdatePebbles)
				(= global132 (giant x:))
				(= global133 (giant y:))
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sitGiant of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(giant
					view: 143
					loop: (if (localproc_4 1) 0 else 2)
					cel: 1
					cycleSpeed: 6
					ignoreActors:
					setAvoider: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				((ScriptID 0 21) number: 59 loop: 1 play:) ; gameSound
				(giant cycleSpeed: 4 loop: 0 cel: 3)
				(chest init:)
				(= cycles 4)
			)
			(2
				(ShakeScreen 6)
				(giant setCycle: End cycleSpeed: 2)
				(= cycles 7)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sleepGiant of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== state 1)
				(giant inRect: 50 130 174 173)
				(gEgo inRect: 93 135 131 157)
				(not local8)
			)
			(Print 58 37) ; "Uh-oh. You happen to be standing in the giant's favorite spot for a snooze."
			(HandsOff)
			(gEgo setMotion: MoveTo 112 175)
			(= local8 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 21) number: 75 loop: 1 play:) ; gameSound
				(Print 58 38) ; "The giant is getting tired of looking for you. Seems like he may be getting ready to take a nap."
				(= local8 0)
				(giant
					view: (+ 140 (if (localproc_4 1) 0 else 300))
					setCycle: SyncWalk
					setAvoider: mwAvoider
				)
				(if (< (giant y:) 158)
					(if (< (giant x:) 111)
						(giant setMotion: MoveTo 50 150 self)
					else
						(giant setMotion: MoveTo 180 150 self)
					)
				else
					(self cue:)
				)
			)
			(1
				(giant setMotion: MoveTo 112 158 self)
			)
			(2
				(sleepingGiant init:)
				(HandsOff)
				(gEgo setMotion: 0)
				(self setScript: sitGiant self)
			)
			(3
				(giant
					view: 142
					loop: 0
					cel: 0
					setCycle: 0
					setMotion: 0
					setAvoider: 0
					stopUpd:
				)
				(SetFlag 38)
				(giantHead init:)
				(= seconds 4)
			)
			(4
				(HandsOn)
				(SetScore 88 7)
				(Print 58 39) ; "Good job! The huge giant, tuckered out from stomping around, has fallen fast asleep."
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(giant setAvoider: 0 setMotion: 0)
		(super dispose:)
	)
)

(instance sleepingGiant of Blk
	(properties
		top 135
		left 93
		bottom 157
		right 131
	)

	(method (init)
		(super init:)
		(gEgo observeBlocks: self)
	)
)

(instance tree1 of NewFeature
	(properties
		x 163
		y 16
		noun '/ceder'
		nsLeft 8
		nsBottom 33
		nsRight 318
		description {tree1}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees here are astonishingly tall; they loom over the land above the clouds.  You can barely see the tops!}
	)
)

(instance tree2 of NewFeature
	(properties
		x 197
		y 50
		noun '/ceder'
		nsTop 34
		nsLeft 75
		nsBottom 67
		nsRight 319
		description {tree2}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees here are astonishingly tall; they loom over the land above the clouds.  You can barely see the tops!}
	)
)

(instance tree3 of NewFeature
	(properties
		x 116
		y 105
		noun '/ceder'
		nsTop 68
		nsLeft 104
		nsBottom 143
		nsRight 128
		description {tree3}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees here are astonishingly tall; they loom over the land above the clouds.  You can barely see the tops!}
	)
)

(instance tree4 of NewFeature
	(properties
		x 282
		y 125
		noun '/ceder'
		nsTop 149
		nsLeft 268
		nsBottom 101
		nsRight 297
		description {tree4}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees here are astonishingly tall; they loom over the land above the clouds.  You can barely see the tops!}
	)
)

(instance tree5 of NewFeature
	(properties
		x 271
		y 84
		noun '/ceder'
		nsTop 69
		nsLeft 253
		nsBottom 99
		nsRight 289
		description {tree5}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees here are astonishingly tall; they loom over the land above the clouds.  You can barely see the tops!}
	)
)

(instance tree6 of NewFeature
	(properties
		x 215
		y 76
		noun '/ceder'
		nsTop 68
		nsLeft 204
		nsBottom 84
		nsRight 227
		description {tree6}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees here are astonishingly tall; they loom over the land above the clouds.  You can barely see the tops!}
	)
)

(instance tree7 of NewFeature
	(properties
		x 6
		y 119
		noun '/ceder'
		nsTop 49
		nsBottom 189
		nsRight 8
		description {tree7}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees here are astonishingly tall; they loom over the land above the clouds.  You can barely see the tops!}
	)
)

(instance tree8 of NewFeature
	(properties
		x 298
		y 144
		noun '/ceder'
		nsTop 124
		nsLeft 288
		nsBottom 165
		nsRight 309
		description {tree8}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees here are astonishingly tall; they loom over the land above the clouds.  You can barely see the tops!}
	)
)

(instance tree9 of NewFeature
	(properties
		x 279
		y 132
		noun '/ceder'
		nsTop 102
		nsLeft 265
		nsBottom 163
		nsRight 293
		description {tree9}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The trees here are astonishingly tall; they loom over the land above the clouds.  You can barely see the tops!}
	)
)

(instance cloud of NewFeature
	(properties
		x 159
		y 49
		noun '/cloud'
		nsTop 21
		nsBottom 77
		nsRight 319
		description {cloud}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {Thick, cottony clouds surround the land up here, obscuring your view of Daventry far below.}
	)
)

(instance getSound of Sound
	(properties
		number 66
		priority 10
	)
)

