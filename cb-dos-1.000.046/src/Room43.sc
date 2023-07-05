;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room43 0
)

(synonyms
	(ignite lamp)
	(drawer dresser)
	(armoire closet)
	(room hall)
)

(local
	local0
	local1
	local2
)

(instance Room43 of Rm
	(properties
		picture 43
	)

	(method (init)
		(super init:)
		(= horizon 100)
		(= south 47)
		(= north 73)
		(LoadMany rsSOUND 43 44 71)
		(gAddToPics
			add: vase cat statueL statueR lamp phone
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures: phone lamp cat statueL statueR vase Dresser1 Dresser2
		)
		(if gDetailLevel
			(lampL setPri: 3 setCycle: Fwd init:)
			(lampR setPri: 3 setCycle: Fwd init:)
		else
			(lampL setPri: 3 init: stopUpd:)
			(lampR setPri: 3 init: stopUpd:)
		)
		(Door cel: (if (or global153 (== gPrevRoomNum 73)) 3 else 0) init: stopUpd:)
		(doorR ignoreActors: 1 init: stopUpd:)
		(doorL ignoreActors: 1 init: stopUpd:)
		(wardL
			cel: (if (== gPrevRoomNum 49) 4 else 0)
			ignoreActors: 1
			setPri: 12
			init:
			stopUpd:
		)
		(wardR
			cel: (if (== gPrevRoomNum 50) 4 else 0)
			ignoreActors: 1
			setPri: 12
			init:
			stopUpd:
		)
		(switch gPrevRoomNum
			(49
				(gEgo illegalBits: -32768 posn: 62 164)
				(wardL setScript: closing)
			)
			(50
				(gEgo illegalBits: -32768 posn: 259 161)
				(wardR setScript: closing)
			)
			(42
				(gEgo illegalBits: -32692 posn: 73 132)
			)
			(44
				(gEgo illegalBits: -32692 posn: 251 132)
			)
			(73
				(gEgo illegalBits: -32692 posn: 159 107)
				(HandsOn)
				(if (not global153)
					(= local2 1)
				)
			)
			(47
				(gEgo illegalBits: -32692)
			)
		)
		(if (== global153 0)
			(gEgo view: 0 setPri: -1 init:)
		else
			(HandsOff)
			(self setScript: leak)
		)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 43 0) ; "This is the back upstairs hallway of the mansion."
		)
		(cond
			((and (not local1) (== gPrevRoomNum 73) (== (Door cel:) 0))
				(= local1 1)
				(Door stopUpd:)
			)
			(local2
				(= local2 0)
				(Door setCycle: Beg)
				(myMusic number: 44 loop: 1 play:)
			)
		)
		(switch (gEgo onControl: 1)
			(32
				(gCurRoom newRoom: 42)
			)
			(16
				(gCurRoom newRoom: 44)
			)
			(2
				(if (and (not local0) (== (gEgo loop:) 3))
					(= local0 1)
					(self setScript: myDoor)
				)
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
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (== gAct 6) (& gMustDos $0004) (!= newRoomNumber 44))
			(SetFlag 36)
		)
		(if (and (or (IsFlag 38) (IsFlag 37)) (!= newRoomNumber 42) (!= newRoomNumber 49))
			(ClearFlag 38)
			(ClearFlag 37)
		)
		(if
			(and
				(or (== newRoomNumber 44) (== newRoomNumber 73))
				(== global203 1)
				(or (== gPrevRoomNum 44) (== gPrevRoomNum 73))
				(== [gCycleTimers 4] 1)
				(not global125)
			)
			(= [gCycleTimers 4] 50)
		)
		(if (and (!= newRoomNumber 73) (== global106 73) (== global201 200))
			(++ global201)
			(|= gCorpseFlags $0020) ; Clarence
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '[<around,at][/room]')
					(Print 43 0) ; "This is the back upstairs hallway of the mansion."
				)
				((Said '/door<hidden')
					(Print 43 1) ; "You don't see anything!"
				)
				((Said '/pedestal')
					(Print 43 2) ; "Two marble pedestals flank the bathroom door. Upon one sits a beautiful porcelain cat and upon the other, a lovely vase."
				)
				((Said '/curtain')
					(Print 43 3) ; "Two tiffiny shades cover the lamps on the tables."
				)
				((or (Said '/dirt') (Said '<down'))
					(Print 43 4) ; "You notice deep scuff marks on the floor near the two armoires."
				)
			)
		)
	)
)

(instance Lcloset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(doorL hide:)
				(doorR hide:)
				(if (& (gEgo onControl: 0) $0080)
					(if (== global143 0)
						(Print 43 5) ; "You pull on the armoire. Surprise! You find that the whole armoire opens to reveal...a secret door!"
					)
					(if (gEgo inRect: 81 162 83 166)
						(= cycles 1)
					else
						(gEgo setMotion: MoveTo 82 164 self)
					)
				else
					(if (== global144 0)
						(Print 43 5) ; "You pull on the armoire. Surprise! You find that the whole armoire opens to reveal...a secret door!"
					)
					(if (gEgo inRect: 240 162 243 166)
						(= cycles 1)
					else
						(gEgo setMotion: MoveTo 241 164 self)
					)
				)
			)
			(1
				(LookAt gEgo client)
				(if (& (gEgo onControl: 0) $0080)
					(gEgo ignoreControl: 4)
				else
					(gEgo ignoreControl: 8)
				)
				(client cycleSpeed: 3 setCycle: End self)
				(myMusic number: 71 loop: 1 play:)
			)
			(2
				(client stopUpd:)
				(if (& (gEgo onControl: 0) $0080)
					(gEgo setMotion: MoveTo 40 (gEgo y:) self)
				else
					(gEgo setMotion: MoveTo 283 (gEgo y:) self)
				)
			)
			(3
				(client setScript: 0)
				(if (== (gEgo loop:) 1)
					(gCurRoom newRoom: 49)
				else
					(gCurRoom newRoom: 50)
				)
			)
		)
	)
)

(instance closing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(doorR hide:)
				(doorL hide:)
				(gEgo
					setMotion:
						MoveTo
						(if (== gPrevRoomNum 49) 82 else 239)
						(gEgo y:)
						self
				)
			)
			(1
				(client setCycle: Beg self)
				(myMusic number: 71 loop: 1 play:)
			)
			(2
				(client stopUpd:)
				(gEgo illegalBits: -32692)
				(HandsOn)
				(doorR show:)
				(doorL show:)
				(client setScript: 0)
			)
		)
	)
)

(instance leak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(Door setCycle: Beg self)
				(myMusic number: 44 loop: 1 play:)
			)
			(2
				(= seconds 3)
			)
			(3
				(Print 43 6) ; "Well! Did you think this was Leisure Suit Larry?!"
				(= cycles 1)
			)
			(4
				(Door setCycle: End self)
				(myMusic number: 43 loop: 1 play:)
			)
			(5
				(gCurRoom newRoom: 73)
				(client setScript: 0)
			)
		)
	)
)

(instance Lopen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((< (gEgo x:) 160)
						(if (gEgo inRect: 80 161 82 163)
							(= cycles 1)
						else
							(gEgo setMotion: MoveTo 81 162 self)
						)
					)
					((gEgo inRect: 239 164 241 166)
						(= cycles 1)
					)
					(else
						(gEgo setMotion: MoveTo 240 165 self)
					)
				)
			)
			(1
				(LookAt gEgo client)
				(client setCycle: End self)
				(= cycles 7)
			)
			(2
				(Print 43 7) ; "Nothin' important in there."
				(= cycles 1)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(HandsOn)
				(client stopUpd:)
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
				(User canControl: 0 canInput: 0)
				(gEgo setMotion: 0 illegalBits: -32768)
				(myMusic number: 43 loop: 1 play:)
				(Door cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) (- (gEgo y:) 50))
			)
		)
	)
)

(instance vase of RPicView
	(properties
		y 106
		x 189
		view 143
		cel 3
		priority 7
	)

	(method (handleEvent event)
		(cond
			((Said 'get/vase')
				(Print 43 8) ; "The vase doesn't belong to you."
			)
			((Said 'look<in/vase')
				(Print 43 9) ; "The vase is empty."
			)
			((or (MousedOn self event 3) (Said 'look/vase'))
				(event claimed: 1)
				(Print 43 10) ; "A lovely vase rests atop a marble pedestal."
			)
		)
	)
)

(instance cat of RPicView
	(properties
		y 106
		x 129
		view 143
		cel 2
		priority 7
	)

	(method (handleEvent event)
		(cond
			((Said 'get/cat')
				(Print 43 11) ; "The porcelain cat doesn't belong to you."
			)
			((or (MousedOn self event 3) (Said 'look/cat'))
				(event claimed: 1)
				(Print 43 12) ; "A beautiful porcelain cat sits elegantly on a marble pedestal."
			)
		)
	)
)

(instance statueL of RPicView
	(properties
		y 71
		x 98
		view 143
		priority 3
	)

	(method (handleEvent event)
		(cond
			((Said 'get,move/monument')
				(Print 43 13) ; "You don't want to carry a statue around."
			)
			((Said '(look<below),behind/monument')
				(Print 43 14) ; "There is nothing there."
			)
			((or (MousedOn self event 3) (Said 'look/monument'))
				(event claimed: 1)
				(Print 43 15) ; "Two greek statues guard both sides of the bathroom door."
			)
		)
	)
)

(instance statueR of RPicView
	(properties
		y 71
		x 220
		view 143
		cel 1
		priority 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 43 15) ; "Two greek statues guard both sides of the bathroom door."
		)
	)
)

(instance lamp of RPicView
	(properties
		y 189
		x 45
		view 143
		loop 1
		priority 14
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance phone of RPicView
	(properties
		y 189
		x 279
		view 143
		loop 1
		cel 1
		priority 14
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance doorR of Prop
	(properties
		y 161
		x 265
		view 243
		loop 4
		priority 13
	)
)

(instance doorL of Prop
	(properties
		y 161
		x 58
		view 243
		loop 3
		priority 13
	)
)

(instance wardL of Prop
	(properties
		y 158
		x 53
		view 243
		priority 13
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 43 16) ; "Two old armoires rest against the side walls."
		)
	)
)

(instance wardR of Prop
	(properties
		y 158
		x 270
		view 243
		loop 1
		priority 13
	)

	(method (handleEvent event)
		(cond
			((Said 'look<behind/armoire')
				(if
					(or
						(gEgo inRect: 41 151 70 177)
						(gEgo inRect: 248 151 272 177)
					)
					(Print 43 17) ; "You try, but can't see anything behind the armoire."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			(
				(or
					(Said 'move,pull,press/armoire')
					(Said 'open<(pull,press)/armoire')
				)
				(cond
					((& (gEgo onControl: 0) $0080)
						(wardL setScript: Lcloset)
					)
					((& (gEgo onControl: 0) $0100)
						(wardR setScript: Lcloset)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			((Said '(look<below),behind/armoire')
				(Print 43 18) ; "You try, but it's too dark to see anything there."
			)
			(
				(or
					(Said 'open/door<armoire')
					(Said 'search,open,(look<in)/armoire')
				)
				(cond
					((& (gEgo onControl: 0) $0080)
						(doorL setScript: Lopen)
					)
					((& (gEgo onControl: 0) $0100)
						(doorR setScript: Lopen)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			((or (MousedOn self event 3) (Said 'look/armoire'))
				(event claimed: 1)
				(Print 43 16) ; "Two old armoires rest against the side walls."
			)
		)
	)
)

(instance lampR of Prop
	(properties
		y 72
		x 242
		view 143
		loop 3
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance lampL of Prop
	(properties
		y 72
		x 80
		view 143
		loop 2
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {lamp})
		)
	)
)

(instance Door of Prop
	(properties
		y 101
		x 142
		view 243
		loop 2
		priority 6
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(event claimed: 1)
			(Print 43 19) ; "That's the bathroom door!"
		)
	)
)

(instance Dresser1 of RFeature
	(properties
		nsTop 79
		nsLeft 76
		nsBottom 104
		nsRight 113
	)

	(method (handleEvent event)
		(cond
			((Said 'search,open,(look<in)/drawer')
				(Print 43 20) ; "There is nothing of interest in the dresser."
			)
			((or (MousedOn self event 3) (Said 'look/drawer'))
				(event claimed: 1)
				(Print 43 21) ; "Beneath the greek statues you see two dressers."
			)
		)
	)
)

(instance Dresser2 of RFeature
	(properties
		nsTop 79
		nsLeft 189
		nsBottom 104
		nsRight 238
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 43 21) ; "Beneath the greek statues you see two dressers."
		)
	)
)

(instance myMusic of Sound
	(properties)
)

