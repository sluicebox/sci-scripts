;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room33 0
)

(synonyms
	(armoire armoire closet)
	(room hall)
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(if (< (gEgo distanceTo: Mirror) 50)
		(= global213 12)
		(Say 0 33 0) ; "You gaze into the mirror and appraise your appearance. A bit disheveled, perhaps, but not bad...considering the circumstances."
	else
		(NotClose) ; "You're not close enough."
	)
)

(instance Room33 of Rm
	(properties
		picture 33
	)

	(method (init)
		(= horizon 95)
		(= north 4)
		(= south 37)
		(super init:)
		(LoadMany rsVIEW 33 103)
		(LoadMany rsSOUND 43 44 71 72)
		(clockFace init: hide:)
		(hourHand init: hide:)
		(minuteHand init: hide:)
		(if gDetailLevel
			(mirrorImage setPri: 12 init:)
			(lampL setPri: 4 setCycle: Fwd init:)
			(lampR setPri: 4 setCycle: Fwd init:)
		else
			(lampL addToPic:)
			(lampR addToPic:)
		)
		(gAddToPics add: lamp phone eachElementDo: #init doit:)
		(if
			(and
				(or (not (IsFlag 41)) (not (IsFlag 42)) (not (IsFlag 43)))
				(> gAct 0)
			)
			(= local4 1)
			(Load rsVIEW 925)
			(LoadMany rsMESSAGE 412)
		)
		(Clock stopUpd: ignoreActors: 1 init:)
		(if
			(and
				(== gAct 2)
				(== global143 0)
				(== global144 0)
				(== global139 0)
				(== global140 0)
			)
			(Clock cel: 1 ignoreActors: 0)
		)
		(= local3 gConMusic)
		(if (!= gPrevRoomNum 33)
			(local3 number: 28 loop: -1 play:)
		)
		(Mirror stopUpd: ignoreActors: 1 init:)
		(rDoor cel: (if (== gPrevRoomNum 4) 2 else 0) init: stopUpd:)
		(lDoor cel: (if (== gPrevRoomNum 4) 2 else 0) stopUpd: init:)
		(self setFeatures: phone lamp Case2 Case1)
		(gEgo view: 0 illegalBits: -32762 init:)
		(switch gPrevRoomNum
			(4
				(rDoor setCycle: Beg)
				(lDoor setCycle: Beg)
				(gEgo posn: 159 110 setMotion: MoveTo 159 118)
				(mySound loop: 1 play:)
			)
			(32
				(gEgo posn: 68 135)
			)
			(34
				(gEgo setPri: -1 posn: 254 136)
			)
			(49
				(gEgo ignoreControl: 2 posn: 52 165)
				(Clock cel: (- (NumCels Clock) 1) setScript: CloseClock)
			)
			(50
				(gEgo posn: 266 159 ignoreControl: 4)
				(Mirror cel: (- (NumCels Mirror) 1) setScript: CloseMirror)
			)
		)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 33 1) ; "This is the back downstairs hallway of the big house. Double French doors lead out back."
		)
		(if local4
			(HandsOff)
			(= local4 0)
			(self setScript: (ScriptID 412 0)) ; Daddy
		)
		(if
			(and
				(& (gEgo onControl: 1) $0020)
				(not local1)
				(== (gEgo loop:) 3)
			)
			(HandsOff)
			(= local1 1)
			(self setScript: myDoor)
		)
		(switch (gEgo onControl: 1)
			(16
				(gCurRoom newRoom: 32)
			)
			(8
				(gCurRoom newRoom: 34)
			)
		)
		(cond
			((< (gEgo x:) 130)
				(= vertAngle 20)
			)
			((< (gEgo x:) 190)
				(= vertAngle 0)
			)
			(else
				(= vertAngle 160)
			)
		)
		(if
			(and
				(== gPrevRoomNum 4)
				(== (lDoor cel:) 0)
				(== (rDoor cel:) 0)
				(not local2)
			)
			(= local2 1)
			(lDoor stopUpd:)
			(rDoor stopUpd:)
		)
		(if (and (> (gEgo y:) 149) (< (gEgo y:) 161))
			(mirrorImage loop: 6 cel: (- 160 (gEgo y:)) forceUpd:)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 200)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (== local3 gConMusic) (!= newRoomNumber 37))
			(local3 stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 33 1) ; "This is the back downstairs hallway of the big house. Double French doors lead out back."
						)
						((Said '/door<hidden')
							(Print 33 2) ; "You don't see anything!"
						)
						((Said '/door<front')
							(Print 33 3) ; "You see the front door further down the hall."
						)
						((Said '/reflection[/mirror]')
							(localproc_0)
						)
						((Said '/door')
							(Print 33 4) ; "The French doors lead outside."
						)
						((Said '/pendulum')
							(Print 33 5) ; "The pendulum sways to and fro as time slowly ticks by."
						)
						((or (Said '/dirt') (Said '<down'))
							(Print 33 6) ; "You see numerous scratch marks on the floor near the grandfather clock."
						)
					)
				)
				((or (Said 'move/clock') (Said '(pull,press)[<open,on]/clock'))
					(HandsOff)
					(self setScript: MoveClock)
				)
				((Said 'close/clock,mirror')
					(AlreadyClosed) ; "It is already closed."
				)
				(
					(or
						(Said 'rotate,move/mirror')
						(Said '(press,pull)[<open,on]/mirror')
					)
					(HandsOff)
					(self setScript: PushMirror)
				)
				((Said 'unbar/armoire')
					(if
						(or
							(gEgo inRect: 72 106 111 121)
							(gEgo inRect: 207 106 252 121)
						)
						(Print 33 7) ; "You can't. You don't have the key."
					else
						(NotClose) ; "You're not close enough."
					)
				)
				((Said 'break/mirror')
					(Print 33 8) ; "That's seven years bad luck, you know!"
				)
			)
		)
	)
)

(instance MoveClock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					observeControl: 16
					setAvoider: (Avoid new:)
					setMotion: MoveTo 85 165 self
				)
			)
			(1
				(gEgo loop: 1 ignoreControl: 2)
				(Clock cycleSpeed: 3 setCycle: End self)
				(mySound number: 71 loop: 1 play:)
			)
			(2
				(if (== global139 0)
					(Print 33 9 #at 76 40) ; "You pull on the grandfather clock and, to your surprise, find that the whole clock opens to reveal...a secret door!"
				)
				(Clock stopUpd:)
				(gEgo setMotion: MoveTo 46 165 self)
			)
			(3
				(HandsOn)
				(gEgo setAvoider: 0)
				(client setScript: 0)
				(gCurRoom newRoom: 49)
			)
		)
	)
)

(instance CloseClock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo ignoreControl: 2 setMotion: MoveTo 85 165 self)
			)
			(1
				(Clock cycleSpeed: 3 setCycle: Beg self)
				(mySound number: 71 loop: 1 play:)
			)
			(2
				(Clock stopUpd:)
				(gEgo illegalBits: -32762)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance PushMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 256 159 self
				)
			)
			(1
				(gEgo loop: 0 cel: 1 ignoreControl: 4)
				(Mirror cycleSpeed: 3 setCycle: End self)
				(mySound number: 72 loop: 1 play:)
			)
			(2
				(if (== global140 0)
					(Print 33 10 #at 70 36) ; "You push on the oval mirror and, to your astonishment, find that the mirror opens to reveal...a secret door!"
				)
				(Mirror stopUpd:)
				(gEgo
					view: 33
					loop: 0
					cel: 0
					posn: 266 159
					setPri: 13
					setCycle: End self
				)
				(if gDetailLevel
					(mirrorImage loop: 7 cel: 0 setCycle: End)
				)
			)
			(3
				(HandsOn)
				(gEgo setAvoider: 0)
				(client setScript: 0)
				(gCurRoom newRoom: 50)
			)
		)
	)
)

(instance CloseMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 33
					loop: 2
					cel: 0
					posn: 266 159
					setPri: 13
					setCycle: End self
				)
				(if gDetailLevel
					(mirrorImage loop: 7 cel: 0 setCycle: End)
				)
			)
			(1
				(gEgo
					view: 0
					loop: 1
					cel: 0
					posn: 257 159
					setPri: -1
					setCycle: Walk
					observeControl: 4
				)
				(Mirror cycleSpeed: 3 setCycle: Beg self)
				(mySound number: 72 loop: 1 play:)
			)
			(2
				(gEgo illegalBits: -32762)
				(Mirror stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if (gEgo inRect: 155 100 165 110)
					(gEgo setMotion: MoveTo 159 115 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo loop: 3)
				(rDoor cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(lDoor cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(mySound number: 43 loop: 1 play:)
			)
			(3
				(gEgo setMotion: MoveTo 157 88)
			)
		)
	)
)

(instance ShowTime of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if gDetailLevel
					(clockFace cel: 0 setCycle: End self show:)
				else
					(clockFace cel: 5 show:)
					(= cycles 1)
				)
			)
			(1
				(hourHand
					loop: (if (> gMinute 1) 7 else 6)
					cel: (if (== gHour 12) 0 else gHour)
					show:
				)
				(minuteHand loop: (if (< gMinute 2) 2 else 5))
				(minuteHand
					cel:
						(if (& gMinute $0001)
							(- (NumCels minuteHand) 1)
						else
							0
						)
					show:
				)
				(= cycles 4)
			)
			(2
				(Print 33 11 #at 10 130) ; "The incessant ticking of the stately grandfather clock is the only sound you hear in the empty hallway."
				(= cycles 1)
			)
			(3
				(hourHand hide:)
				(minuteHand hide:)
				(if gDetailLevel
					(clockFace setCycle: Beg self)
				else
					(clockFace hide:)
					(= cycles 1)
				)
			)
			(4
				(clockFace hide:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance lamp of RPicView
	(properties
		y 189
		x 45
		view 133
		priority 14
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance phone of RPicView
	(properties
		y 189
		x 277
		view 133
		cel 1
		priority 14
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {table})
		)
	)
)

(instance Clock of Prop
	(properties
		y 160
		x 53
		view 233
		priority 12
	)

	(method (handleEvent event)
		(cond
			((Said 'look/archway')
				(if (== (Clock cel:) 1)
					(Print 33 12) ; "You can't tell what it is."
				else
					(event claimed: 1)
				)
			)
			((Said 'listen/clock')
				(Print 33 13) ; "You hear the incessant ticking of the old grandfather clock."
			)
			((Said 'open,(look<(in,in,in))/clock')
				(if (< (gEgo distanceTo: Clock) 30)
					(Print 33 14) ; "The pendulum door is locked. You can't open it."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'look<behind/clock')
				(if (< (gEgo distanceTo: Clock) 30)
					(if (== (Clock cel:) 1)
						(Print 33 15) ; "There seems to be an opening of some sort behind the grandfather clock!"
					else
						(Print 33 16) ; "You try, but can't see anything behind the grandfather clock."
					)
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'read,look[<at]/clock,time'))
				(event claimed: 1)
				(if (== (Clock cel:) 1)
					(Print 33 17) ; "What's this?! There seems to be something behind the grandfather clock!"
				else
					(self setScript: ShowTime)
				)
				(event claimed: 1)
			)
		)
	)
)

(instance Mirror of Prop
	(properties
		y 154
		x 275
		view 233
		loop 1
		priority 13
	)

	(method (handleEvent event)
		(cond
			((Said 'open/mirror')
				(Print 33 18) ; "Mirrors don't open...do they?"
			)
			((Said '(look<(in,in))/mirror')
				(localproc_0)
			)
			((Said 'look<behind/mirror')
				(if (< (gEgo distanceTo: Mirror) 30)
					(Print 33 19) ; "You try, but can't see anything behind the mirror."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look[<at]/mirror'))
				(Print 33 20) ; "An interesting oval mirror hangs on the hallway wall."
				(event claimed: 1)
			)
		)
	)
)

(instance mirrorImage of Prop
	(properties
		y 142
		x 268
		view 233
		loop 6
	)
)

(instance rDoor of Prop
	(properties
		y 100
		x 183
		view 233
		loop 2
		priority 6
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance lDoor of Prop
	(properties
		y 100
		x 133
		view 233
		loop 3
		priority 6
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance lampL of Prop
	(properties
		y 81
		x 76
		view 233
		loop 4
		cel 1
		priority 4
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/curtain<lamp'))
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lampR of Prop
	(properties
		y 81
		x 247
		view 233
		loop 5
		priority 4
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance clockFace of Prop
	(properties
		y 106
		x 47
		view 103
		loop 1
		priority 14
		signal 16400
		cycleSpeed 1
	)
)

(instance hourHand of Prop
	(properties
		y 73
		x 81
		view 103
		priority 15
		signal 16400
		cycleSpeed 1
	)
)

(instance minuteHand of Prop
	(properties
		y 73
		x 81
		view 103
		priority 15
		signal 16400
		cycleSpeed 1
	)
)

(instance Case1 of RFeature
	(properties
		nsTop 43
		nsLeft 77
		nsBottom 104
		nsRight 110
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/armoire'))
			(Print 33 21) ; "Two old-fashioned armoires flank the back door."
			(event claimed: 1)
		)
	)
)

(instance Case2 of RFeature
	(properties
		nsTop 43
		nsLeft 206
		nsBottom 104
		nsRight 244
	)

	(method (handleEvent event)
		(cond
			((Said 'open,(look<in)/drawer')
				(Print 33 22) ; "There is nothing you need in the armoire drawers."
			)
			((Said 'move/armoire')
				(Print 33 23) ; "You can't. It doesn't move."
			)
			((Said 'open,(look<in)/armoire')
				(if
					(or
						(gEgo inRect: 72 106 111 121)
						(gEgo inRect: 207 106 252 121)
					)
					(Print 33 24) ; "Too bad! The armoire is locked!"
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/armoire'))
				(Print 33 21) ; "Two old-fashioned armoires flank the back door."
				(event claimed: 1)
			)
		)
	)
)

(instance mySound of Sound
	(properties
		number 44
		priority 5
	)
)

