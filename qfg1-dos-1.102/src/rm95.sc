;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use n105)
(use n160)
(use LoadMany)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm95 0
	bDoor 1
	lDoor 2
	rDoor 3
	chandelier 4
	candelabra 5
	rope 6
	chair 7
	flames 8
	brig1 9
	brig2 10
	brig3 11
	brig4 12
	brig5 13
	brig6 14
	moe 15
	moeHead 16
	curly 17
	curlyHead 18
	larry 19
	larryHead 20
	finalEntry 21
	stars 22
	sBrigBlocked 23
	sChandFall 24
	tryOpenSpell 25
	openBDoor 26
	barFDoor 27
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 1
	local7 = 1
	local8 = 1
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
)

(instance rm95 of Rm
	(properties
		picture 95
		style 8
		horizon 80
	)

	(method (dispose)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 95 465 196 295 188 187 186 510 195 525)
		(LoadMany rsSCRIPT 156 157 158 159 160)
		(super init:)
		(self setFeatures: onDrunk onSign onRope onCandelabra onChandelier)
		(gMouseHandler add: self)
		(SolvePuzzle 706 8)
		(SL enable:)
		(NormalEgo)
		(EgoGait 0 0) ; walking
		(brigSign init: setPri: 3 addToPic:)
		(chairs init: setPri: 6 addToPic:)
		(rDoor init: stopUpd:)
		(lDoor init: stopUpd:)
		(candelabra init: stopUpd:)
		(drunk init: setPri: 12 stopUpd:)
		(chandelier init: setPri: 5 stopUpd:)
		(rope init: setPri: 3)
		(ropeHolder init: setPri: 3 addToPic:)
		(flames init: setPri: 6 setCycle: Fwd)
		(chair init: stopUpd:)
		(brig1 init: hide:)
		(brig4 init: hide:)
		(moe init:)
		((ScriptID 95 16) init:) ; moeHead
		((ScriptID 95 17) init:) ; curly
		((ScriptID 95 18) init:) ; curlyHead
		((ScriptID 95 19) init:) ; larry
		((ScriptID 95 20) init:) ; larryHead
		(bDoor init: setPri: 1 stopUpd:)
		(fDoor setCel: 1 init: setPri: 14 stopUpd:)
		(= local3 0)
		(gEgo posn: 302 194 init: setScript: egoEntersSouth)
	)

	(method (notify param1)
		(switch param1
			(0
				(= local0 1)
			)
			(1
				(if local4
					(return 1)
				else
					(return 0)
				)
			)
			(2
				(= local4 1)
			)
			(3
				(if local3
					(return 1)
				else
					(return 0)
				)
			)
			(4
				(if local2
					(return 1)
				else
					(return 0)
				)
			)
			(5
				(= local2 1)
			)
			(6
				(if local5
					(return 1)
				else
					(return 0)
				)
			)
			(7
				(= local5 0)
			)
			(8
				(= local5 1)
			)
			(9
				(if local6
					(return 1)
				else
					(return 0)
				)
			)
			(10
				(= local6 0)
			)
			(11
				(= local7 0)
			)
			(12
				(if local12
					(return 1)
				else
					(return 0)
				)
			)
			(13
				(= local12 1)
			)
			(14
				(if local11
					(return 1)
				else
					(return 0)
				)
			)
			(15
				(= local11 1)
			)
			(16
				(if local9
					(return 1)
				else
					(return 0)
				)
			)
			(17
				(= local9 1)
			)
			(18
				(if local13
					(return 1)
				else
					(return 0)
				)
			)
			(19
				(= local13 1)
			)
			(20
				(if local14
					(return 1)
				else
					(return 0)
				)
			)
			(21
				(= local14 1)
			)
			(22
				(if local15
					(return 1)
				else
					(return 0)
				)
			)
			(23
				(= local15 1)
			)
			(24
				(if local16
					(return 1)
				else
					(return 0)
				)
			)
			(25
				(= local16 1)
			)
		)
	)

	(method (doit)
		(if (and local0 (& (gEgo onControl: 1) $1000))
			(gCurRoom newRoom: 94)
		)
		(if
			(and
				local6
				(or (< (gEgo x:) 210) (< (gEgo y:) 135))
				(== (brig1 script:) 0)
			)
			(brig1 setScript: (ScriptID 157 0)) ; brigandsSouth
		)
		(if
			(and
				local7
				(not local2)
				(< (gEgo x:) 250)
				(== (brig4 script:) 0)
				(not local2)
			)
			(brig4 setScript: (ScriptID 159 2)) ; brigandsEast
		)
		(if (and local3 local2 local8)
			(= local8 0)
			(moe setScript: (ScriptID 156 0)) ; brigandsWest
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((super handleEvent: event))
					((MouseClaimed gEgo event 3)
						(HighPrint 95 0) ; "The flying Wallendas have nothing on you."
					)
				)
			)
			(evSAID
				(if (Said 'rest,nap')
					(EgoDead 95 1 80 {Z-Z-Z-Z-Z-Z-Z-Z-Z-Z} 82 800 0 0) ; "The Brigands oblige you by making your pleasant rest permanent!"
				)
				(cond
					(
						(or
							(Said 'climb,hop[/table]')
							(Said 'use,swing,get,grab/rope,chandelier')
							(Said 'get/table')
						)
						(cond
							(local16
								(HighPrint 95 2) ; "No time for that again (although it WAS fun). Just get the heck outta here."
							)
							((gEgo inRect: 100 108 217 120)
								(gEgo setScript: (ScriptID 158 1)) ; climb
							)
							(else
								(HighPrint 95 3) ; "You're not in a good spot."
							)
						)
					)
					((and local4 (not local16))
						(HighPrint 95 4) ; "It's too late for that."
						(event claimed: 1)
					)
					((not (super handleEvent: event))
						(proc160_0 event)
					)
				)
			)
		)
	)
)

(instance brigSign of View
	(properties
		y 54
		x 154
		view 95
	)
)

(instance chairs of View
	(properties
		y 76
		x 160
		view 95
		cel 1
	)
)

(instance rDoor of Prop
	(properties
		y 93
		x 290
		view 95
		loop 1
	)
)

(instance lDoor of Prop
	(properties
		y 93
		x 15
		view 95
		loop 2
	)
)

(instance bDoor of Prop
	(properties
		y 83
		x 46
		view 95
		loop 3
	)
)

(instance fDoor of Prop
	(properties
		y 178
		x 274
		view 95
		loop 8
	)
)

(instance candelabra of Prop
	(properties
		y 93
		x 239
		view 95
		loop 4
	)
)

(instance chandelier of Prop
	(properties
		y 48
		x 155
		view 95
		loop 5
	)
)

(instance rope of Prop
	(properties
		y 63
		x 211
		view 195
		loop 4
	)
)

(instance ropeHolder of Prop
	(properties
		y 48
		x 208
		view 95
		cel 2
	)
)

(instance drunk of View
	(properties
		y 138
		x 61
		view 95
		loop 9
	)
)

(instance flames of Prop
	(properties
		y 29
		x 160
		view 95
		loop 6
	)
)

(instance chair of Prop
	(properties
		y 104
		x 306
		view 95
		loop 7
		cel 1
	)
)

(instance brig1 of Act
	(properties
		view 465
	)
)

(instance brig2 of Act
	(properties
		view 465
	)
)

(instance brig3 of Act
	(properties
		view 465
	)
)

(instance brig4 of Act
	(properties
		view 465
	)
)

(instance brig5 of Act
	(properties
		view 465
	)
)

(instance brig6 of Act
	(properties
		view 465
	)
)

(instance curly of Act
	(properties
		view 196
	)
)

(instance moe of Act
	(properties
		view 196
	)
)

(instance larry of Act
	(properties
		view 196
	)
)

(instance curlyHead of Prop
	(properties
		z 29
		view 188
	)

	(method (doit)
		(self
			posn: (curly x:) (curly y:)
			setPri: (curly priority:)
			setCel: (curly cel:)
			setLoop: (curly loop:)
		)
		(super doit:)
	)
)

(instance moeHead of Prop
	(properties
		z 29
		view 187
	)

	(method (doit)
		(self
			posn: (moe x:) (moe y:)
			setPri: (moe priority:)
			setCel: (moe cel:)
			setLoop: (moe loop:)
		)
		(super doit:)
	)
)

(instance larryHead of Prop
	(properties
		z 29
		view 186
	)

	(method (doit)
		(self
			posn: (larry x:) (larry y:)
			setPri: (larry priority:)
			setCel: (larry cel:)
			setLoop: (larry loop:)
		)
		(super doit:)
	)
)

(instance stars of Prop
	(properties
		view 295
		loop 2
	)
)

(instance onDrunk of RFeature
	(properties
		nsTop 114
		nsLeft 47
		nsBottom 138
		nsRight 72
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onDrunk event 3)
				(HighPrint 95 5) ; "He's been drinking Troll's sweat all night."
			)
		)
	)
)

(instance onSign of RFeature
	(properties
		nsTop 45
		nsLeft 104
		nsBottom 52
		nsRight 196
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onSign event 3)
				(HighPrint 95 6) ; ""Brigands over all!" Egotistical bunch, aren't they?"
			)
		)
	)
)

(instance onRope of RFeature
	(properties
		nsTop 45
		nsLeft 204
		nsBottom 61
		nsRight 213
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onRope event 3)
				(HighPrint 95 7) ; "The rope holds up the chandelier. It's used to lower the chandelier so that it can be lit."
			)
		)
	)
)

(instance onCandelabra of RFeature
	(properties
		nsTop 48
		nsLeft 233
		nsBottom 92
		nsRight 261
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onCandelabra event 3)
				(HighPrint 95 8) ; "Sturdy-looking device for holding candles."
			)
		)
	)
)

(instance onChandelier of RFeature
	(properties
		nsTop 19
		nsLeft 133
		nsBottom 41
		nsRight 174
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((MouseClaimed onChandelier event 3)
				(HighPrint 95 9) ; "Chandelier, used to hold up the rope."
			)
		)
	)
)

(instance egoEntersSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: $8000 setMotion: MoveTo 302 170 self)
			)
			(1
				((ScriptID 95 0) notify: 0) ; rm95
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openBDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bDoor setCel: 1)
				(= cycles 4)
			)
			(1
				(gEgo setPri: 2 illegalBits: 0 setMotion: MoveTo 66 79 self)
			)
			(2
				(NormalEgo)
				(gCurRoom newRoom: 96)
			)
		)
	)
)

(instance tryOpenSpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(CastOpen self self)
			)
			(2
				(client setScript: openBDoor)
			)
		)
	)
)

(instance barFDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fDoor setScript: closeFDoor self)
			)
			(1
				(HandsOff)
				(gEgo
					setPri: 14
					illegalBits: 0
					setMotion: MoveTo 295 175 self
				)
			)
			(2
				(gEgo loop: 2)
				(HighPrint 95 10) ; "You close and bar the door."
				(= cycles 1)
			)
			(3
				(NormalEgo)
				(gEgo illegalBits: $9000)
				(= local3 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeFDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setPri: 12
					illegalBits: 0
					setMotion: MoveTo 284 182 self
				)
			)
			(1
				(gEgo loop: 2 setPri: 14)
				(fDoor setPri: 15 ignoreActors: 1 setCel: 0 stopUpd:)
				(= cycles 2)
			)
			(2
				(NormalEgo)
				(gEgo illegalBits: $9000)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance finalEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 80)
			)
			(1
				(lDoor setCel: 1)
				(brig1
					show:
					setPri: 3
					posn: 31 90
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 55 90
				)
				(= cycles 4)
			)
			(2
				(brig2
					init:
					setPri: 3
					ignoreActors:
					illegalBits: 0
					posn: 31 90
					setCycle: Walk
					setMotion: MoveTo 46 92
				)
				(= cycles 3)
			)
			(3
				(brig3
					init:
					setPri: 3
					ignoreActors:
					illegalBits: 0
					posn: 31 90
					setCycle: Walk
					setMotion: MoveTo 40 94 self
				)
			)
			(4
				(EgoDead 95 11 82 516 0 9 80 {Molasses in January.}) ; "You're hopelessly outnumbered. You should have left this room when you had a chance."
			)
		)
	)
)

(instance sBrigBlocked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(client setScript: (ScriptID 158 0)) ; brigBlocked
			)
		)
	)
)

(instance sChandFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= local16 1)
				(client setScript: (ScriptID 156 1)) ; chandFall
			)
		)
	)
)

