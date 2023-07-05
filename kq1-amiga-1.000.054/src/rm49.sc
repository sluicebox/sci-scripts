;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm49 0
)

(instance rm49 of Rm
	(properties
		picture 49
		north 12
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(south 8)
				)
		)
		(LoadMany rsVIEW 249 13 14 19)
		(if (IsFlag 20)
			(Load rsVIEW 61)
		)
		(LoadMany rsSOUND 14 24 9)
		((ScriptID 0 23) number: 9 loop: -1 playBed:) ; backSound
		(super init:)
		(if (IsFlag 20)
			(gAddToPics
				add:
					rope
					((Clone rope) x: 159 y: 41 yourself:)
					((Clone rope) cel: 2 x: 159 y: 62 yourself:)
					((Clone rope) cel: 0 x: 159 y: 83 yourself:)
					((Clone rope) x: 159 y: 104 yourself:)
					((Clone rope) cel: 2 x: 159 y: 125 yourself:)
					((Clone rope) cel: 0 x: 159 y: 146 yourself:)
				eachElementDo: #init
				doit:
			)
		)
		(if (and (IsFlag 21) (not (IsFlag 24)))
			(bucket setPri: 3 init: stopUpd:)
		)
		(if (IsFlag 47)
			(bucket setLoop: 4 posn: 171 180 setCycle: Fwd init:)
		)
		(switch gPrevRoomNum
			(north
				(= global130 0)
				(if (IsFlag 18)
					(gEgo posn: 159 145 init:)
				else
					(gEgo posn: 158 152 init:)
				)
			)
			(else
				((ScriptID 0 21) number: 51 loop: -1 init: play:) ; gameSound
				(gEgo
					view: 13
					illegalBits: -24576
					setStep: 1 1
					setCycle: Fwd
					setPri: -1
					posn: 158 184
					init:
				)
				(= global130 4)
			)
		)
		(water1 init:)
		(well1 init:)
		(cond
			((IsFlag 19)
				(gCurRoom setScript: climbDownRope)
				(SetScore 96 1)
				(SetScore 73 1)
			)
			((IsFlag 18)
				(gCurRoom setScript: fallInBucket)
				(SetScore 96 1)
				(SetScore 73 1)
			)
			((== gPrevRoomNum north)
				(gCurRoom setScript: fallThru)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo view:) 13)
				(if (and global136 (not (-- global136)))
					(gCurRoom setScript: drowning)
				)
			)
			(
				(= temp0
					(switch ((User alterEgo:) edgeHit:)
						(1 north)
						(3 south)
					)
				)
				(self newRoom: temp0)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'throw/dagger')
				(if (gEgo has: 0) ; Dagger
					(Print 49 0) ; "There is no need to throw the dagger, there are no enemies here."
				else
					(proc0_6) ; "You don't have anything that fits that description in your inventory."
				)
			)
			((Said 'climb,climb<down')
				(cond
					((== (gEgo view:) 61)
						(Print 49 1) ; "You can't climb down the rope any farther."
					)
					((IsFlag 18)
						(Print 49 2) ; "You are as far down as you'll get without being in the water."
					)
					(else
						(Print 49 3) ; "You can't climb down while swimming."
					)
				)
			)
			((Said 'rub/ring')
				(Print 49 4) ; "There's no point in becoming invisible here; the well is dark enough as it is."
				(event claimed: 1)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room,well,cave]')
						(cond
							((>= global130 4)
								(Print 49 5) ; "You're frantically swimming in the cold water of the well"
							)
							((IsFlag 18)
								(Print 49 6) ; "You're suspended in a bucket above the cold water below."
							)
							(else
								(Print 49 7) ; "You are hanging on a rope, above the cold well water below."
							)
						)
					)
					((Said '<up')
						(Print 49 8) ; "You can just see the opening of the well above you."
					)
					((Said '<down')
						(if (>= global130 4)
							(Print 49 9) ; "You can barely see the bottom of the well."
						else
							(Print 49 10) ; "You see the well water below you."
							(event claimed: 1)
						)
					)
					((Said '/bucket')
						(if (IsFlag 18)
							(Print 49 11) ; "You are sitting in the bucket."
						else
							(event claimed: 0)
						)
					)
					((Said '/algae,algae')
						(Print 49 12) ; "Algae and lichen cover the damp well walls."
					)
				)
			)
			((Said 'swim<stop')
				(switch (gEgo view:)
					(13
						(Print 49 13) ; "There is no reason to stop swimming. You may drown."
					)
					(else
						(Print 49 14) ; "You cannot stop something you haven't started."
					)
				)
			)
			((Said 'swim')
				(switch (gEgo view:)
					(13
						(Print 49 15) ; "You already are swimming."
					)
					(61
						(Print 49 16) ; "You have to be in the water to go swimming."
					)
					(14
						(= global130 4)
						((ScriptID 0 21) number: 51 loop: -1 play:) ; gameSound
						(gEgo
							show:
							view: 13
							illegalBits: -24576
							setStep: 1 1
							setCycle: Fwd
							setLoop: -1
							setCel: -1
							setPri: -1
							cycleSpeed: 0
						)
						(= global136 3000)
						(gCurRoom setScript: 0)
						(HandsOn)
					)
					(else
						(Print 49 17) ; "You're too busy right now."
					)
				)
			)
			((Said 'dive')
				(switch (gEgo view:)
					(13
						(SetScore 97 4)
						(gCurRoom newRoom: 52)
					)
					(else
						(Print 49 18) ; "You have to be swimming before you can go diving."
					)
				)
			)
			((Said 'climb,climb/wall')
				(switch (gEgo view:)
					(13
						(= global136 0)
						(gCurRoom setScript: climbWall)
					)
					(14
						(Print 49 19) ; "You're too busy drowning right now."
					)
					(else
						(Print 49 20) ; "You can't climb up the wall from there."
					)
				)
			)
			((Said 'get,get/rope')
				(if (not (IsFlag 20))
					(Print 49 21) ; "There is no rope here."
				else
					(Print 49 22) ; "Leave the rope where it is; you may find a use for it later."
				)
			)
			(
				(or
					(Said 'get,get,jump,climb,climb[<up]/rope')
					(Said 'climb,climb,get,get,jump[<up]//rope')
				)
				(if (not (IsFlag 20))
					(Print 49 21) ; "There is no rope here."
				else
					(switch (gEgo view:)
						(61
							(= global136 0)
							(gCurRoom setScript: climbUpRope)
						)
						(13
							(= global136 0)
							(Print 49 23) ; "You leap out of the water and grab the rope."
							(User canControl: 0)
							(gEgo
								view: 61
								ignoreHorizon: 1
								ignoreActors: 1
								setMotion: 0
								illegalBits: 0
								setLoop: 0
								setCel: 0
								posn: 158 102
								setStep: 1 2
								setCycle: Walk
								setPri: 4
							)
							(= global130 0)
							(climbDownRope start: 1)
							(gCurRoom setScript: climbDownRope)
						)
						(14
							(Print 49 24) ; "You're too busy drowning at the moment."
						)
						(else
							(Print 49 25) ; "You can't climb up the rope from there."
						)
					)
				)
			)
			((Said 'cut/rope')
				(cond
					((not (IsFlag 20))
						(Print 49 21) ; "There is no rope here."
					)
					((not (gEgo has: 0)) ; Dagger
						(Print 49 26) ; "You don't have a dagger."
					)
					(else
						(Print 49 27) ; "You can't cut the rope from here."
					)
				)
			)
			((Said 'enter,(get,get,jump,climb,climb,sit<in,onto,in)/bucket')
				(cond
					((IsFlag 21)
						(switch (gEgo view:)
							(249
								(Print 49 28) ; "You're already sitting in the bucket."
							)
							(14
								(Print 49 19) ; "You're too busy drowning right now."
							)
							(13
								(if
									(and
										(!= (bucket loop:) 4)
										(not (IsFlag 24))
									)
									(Print 49 29) ; "You leap out of the water and climb into the bucket."
									(= global136 0)
									(gCurRoom setScript: sitBucket)
								else
									(Print 49 30) ; "There's no point in sitting in there."
								)
							)
							(else
								(if (!= (bucket loop:) 4)
									(= global136 0)
									(gCurRoom setScript: sitBucket)
								else
									(Print 49 31) ; "Jumping into the bucket is not only pointless, it's dangerous."
								)
							)
						)
					)
					((IsFlag 47)
						(Print 49 32) ; "It's too late for that. You'll never get into the bucket now."
					)
					(else
						(Print 49 33) ; "There is no bucket here."
					)
				)
			)
			((Said 'climb,climb/water')
				(Print 49 34) ; "Just jump into the water if you like."
			)
			((Said 'climb,climb[<up]')
				(if (== (gEgo view:) 14)
					(Print 49 35) ; "You're busy drowning at the moment."
				else
					(= global136 0)
					(gCurRoom
						setScript:
							(switch (gEgo view:)
								(13 climbWall)
								(61 climbUpRope)
								(else climbUpRope)
							)
					)
				)
			)
			((or (Said 'get,get/water') (Said 'fill/bucket'))
				(cond
					((== (gEgo view:) 14)
						(Print 49 19) ; "You're too busy drowning right now."
					)
					((!= (gEgo view:) 13)
						(Print 49 36) ; "You are not close enough to the water."
					)
					((gEgo has: 8) ; Empty_Water_Bucket
						(if (IsFlag 9)
							(Print 49 37) ; "The bucket is already full of water."
						else
							(Print 49 38) ; "With difficulty, you fill the bucket while swimming."
							(UpdateWaterBucket 1)
						)
					)
					(else
						(Print 49 39) ; "You do not have a bucket to put the water in."
					)
				)
			)
			((or (Said 'get,get/drink') (Said 'drink/water'))
				(cond
					((== (gEgo view:) 14)
						(Print 49 19) ; "You're too busy drowning right now."
					)
					((!= (gEgo view:) 13)
						(if (and (gEgo has: 8) (IsFlag 9)) ; Empty_Water_Bucket
							(Print 49 40) ; "You drink all the water in the bucket. You must have been thirsty!"
							(UpdateWaterBucket 0)
						else
							(Print 49 36) ; "You are not close enough to the water."
						)
					)
					(else
						(Print 49 41) ; "You open your mouth and swallow some water."
					)
				)
			)
			((Said 'jump')
				(Print 49 42) ; "It's hard to jump without solid ground under your feet."
			)
			((Said 'get,get<out/bucket')
				(if (!= (gEgo view:) 249)
					(Print 49 43) ; "You are not in the bucket."
				else
					(Print 49 44) ; "Jumping will take you where you want to go."
				)
			)
			((Said 'get,get/bucket')
				(cond
					((gEgo has: 8) ; Empty_Water_Bucket
						(Print 49 45) ; "You have taken the bucket already."
					)
					((== 4 (bucket loop:))
						((ScriptID 0 21) number: 105 loop: 1 init: play:) ; gameSound
						(Print 49 46) ; "You manage to take the bucket."
						(SetScore 95 2)
						(gEgo get: 8) ; Empty_Water_Bucket
						(ClearFlag 47)
						(SetFlag 24)
						(bucket dispose:)
					)
					(else
						(Print 49 47) ; "It would be easier if the bucket wasn't attached to the rope."
					)
				)
			)
			((Said 'tie,drop,drop/bucket')
				(if (gEgo has: 8) ; Empty_Water_Bucket
					(Print 49 48) ; "The bucket will be of the most use to you if you don't let go of it."
				else
					(proc0_6) ; "You don't have anything that fits that description in your inventory."
				)
			)
		)
	)
)

(instance bucket of Actor
	(properties
		x 159
		y 165
		view 249
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'enter,(get,get,climb,climb<in,onto,in)/bucket')
				(event claimed: 0)
			)
			((Said 'look,look/bucket')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 49 49) ; "This weathered old bucket has withstood many years of use."
			)
		)
	)
)

(instance rope of PicView
	(properties
		x 159
		y 20
		view 249
		loop 1
		cel 1
		priority 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'look,look/rope')
				(self doVerb: 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 49 50) ; "The rope is thick and sturdy; it can easily support many times your weight."
			)
		)
	)
)

(instance fallThru of Script
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'dive,swim')
				(Print 49 51) ; "Though you try, the fall has knocked the wind out of you, and your lungs quickly fill with water."
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(gEgo setStep: 1 (+ (gEgo yStep:) 1))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreHorizon: 1
					ignoreActors: 1
					illegalBits: 0
					view: 14
					setLoop: 1
					setCel: 0
					posn: 158 -4
					setStep: 1 2
					setCycle: 0
					setPri: 1
					setMotion: MoveTo 158 184 self
				)
			)
			(1
				((ScriptID 0 21) number: 14 loop: 1 init: play:) ; gameSound
				(gEgo setCel: -1 ignoreActors: 0 setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				(User canInput: 1)
				((ScriptID 0 21) number: 96 play:) ; gameSound
				(gEgo cycleSpeed: 1 setLoop: 0 setCycle: End self)
			)
			(4
				(gEgo setLoop: 0 cel: 0 setCycle: End self)
			)
			(5
				(gEgo hide:)
				(= cycles 9)
			)
			(6
				(gEgo show: setLoop: 0 cel: 0 setCycle: End)
				(= seconds 3)
			)
			(7
				(EgoDead {You've sunk your chances for saving Daventry.})
			)
		)
	)
)

(instance climbDownRope of Script
	(properties)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'enter,(climb,climb,get,get<in,in,onto)/bucket')
				(cond
					((IsFlag 24)
						(Print 49 52) ; "You have taken the only bucket."
					)
					((IsFlag 21)
						(if (!= (bucket loop:) 4)
							(= global136 0)
							(gCurRoom setScript: sitBucket)
						else
							(Print 49 31) ; "Jumping into the bucket is not only pointless, it's dangerous."
						)
					)
					((IsFlag 47)
						(Print 49 32) ; "It's too late for that. You'll never get into the bucket now."
					)
					(else
						(Print 49 53) ; "There's no bucket here."
					)
				)
			)
			((Said 'climb,climb[<up]')
				(= global136 0)
				(gCurRoom setScript: climbUpRope)
			)
			(
				(or
					(Said 'jump')
					(Said 'exit[/bucket]')
					(Said 'free[/rope]')
					(Said 'go,enter,drop[<in][/water]')
					(and (== (gEgo view:) 61) (Said 'let//go'))
				)
				(= global136 0)
				(gCurRoom setScript: jumpInWater)
			)
			((Said 'look,look>')
				(cond
					((Said '<up')
						(event claimed: 0)
					)
					((Said '[<at,around][/room,well]')
						(Print 49 54) ; "You're climbing a rope, suspended inside a dark, damp well."
					)
					((Said '/rope')
						(Print 49 55) ; "The old rope extends into the sunlight far above you."
					)
					((Said '/water')
						(Print 49 56) ; "Below you, you see the well's cold, dark water."
					)
					((Said '/bucket')
						(if (and (IsFlag 21) (not (gEgo has: 8))) ; Empty_Water_Bucket
							(Print 49 57) ; "Just below you, there's an old, weathered bucket."
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 61
					ignoreHorizon: 1
					ignoreActors: 1
					illegalBits: 0
					setLoop: 0
					setCel: 0
					posn: 158 -4
					setPri: 4
					setStep: 1 3
					setCycle: Walk
					setMotion: MoveTo 158 102 self
				)
			)
			(1
				(HandsOn)
				(User canControl: 0)
			)
		)
	)
)

(instance climbUpRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 19)
				(ClearFlag 18)
				((ScriptID 0 21) stop:) ; gameSound
				(if (== (gEgo view:) 249)
					(bucket init:)
				)
				(HandsOff)
				(gEgo
					view: 61
					ignoreHorizon: 1
					ignoreActors: 1
					illegalBits: 0
					setLoop: 0
					setCel: 0
					posn: 158 102
					setStep: 1 2
					setCycle: Walk
					setPri: 4
					setMotion: MoveTo 158 -4 self
				)
			)
			(1
				(HandsOn)
				(= global130 0)
				(gCurRoom newRoom: 12)
			)
		)
	)
)

(instance fallInBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 24 init: play: fade:) ; gameSound
				(= cycles 3)
			)
			(1
				(gEgo
					ignoreActors:
					illegalBits: 0
					view: 249
					setLoop: 0
					setCel: 1
					setPri: 4
					cycleSpeed: 1
					setMotion: MoveTo 159 165 self
				)
			)
			(2
				(SetFlag 21)
				(= global136 0)
				(gCurRoom setScript: sitBucket)
			)
		)
	)
)

(instance sitBucket of Script
	(properties)

	(method (init)
		(ClearFlag 19)
		(super init: &rest)
		(HandsOn)
		(User canControl: 0)
		((ScriptID 0 21) stop:) ; gameSound
		(gEgo
			ignoreActors:
			illegalBits: 0
			view: 249
			setLoop: 0
			setCel: 1
			setCycle: 0
			setMotion: 0
			cycleSpeed: 0
			setPri: 4
			posn: 159 165
		)
		(= global130 0)
		(bucket dispose:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((Said 'climb,climb[<up]/rope')
				(ClearFlag 18)
				(bucket init: stopUpd:)
				(= global136 0)
				(gCurRoom setScript: climbUpRope)
			)
			(
				(or
					(Said 'jump')
					(Said 'exit[/bucket]')
					(Said 'free[/rope]')
					(Said 'go,enter,drop[<in][/water]')
					(and (== (gEgo view:) 61) (Said 'let//go'))
				)
				(bucket init: stopUpd:)
				(ClearFlag 18)
				(= global136 0)
				(gCurRoom setScript: jumpInWater)
			)
			((Said 'cut/rope')
				(if (gEgo has: 0) ; Dagger
					(bucket init: stopUpd:)
					(ClearFlag 18)
					(= global136 0)
					(ClearFlag 21)
					(gCurRoom setScript: cutOffBucket)
				else
					(Print 49 26) ; "You don't have a dagger."
				)
			)
			((Said 'stand')
				(Print 49 58) ; "You can't stand at the moment."
			)
			((Said 'look,look>')
				(cond
					((Said '<up')
						(event claimed: 0)
					)
					((Said '/rope')
						(Print 49 55) ; "The old rope extends into the sunlight far above you."
					)
					((or (Said '/water') (Said '<down'))
						(Print 49 59) ; "The bucket in which you're sitting is suspended a short distance above the well's cold, dark water."
					)
					((Said '[/around,well]')
						(Print 49 60) ; "You're sitting in a bucket, suspended inside a dark, damp well."
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance jumpInWater of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (< state 3)
			(gEgo setStep: 1 (+ (gEgo yStep:) 1))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (gEgo view:) 61)
					(ClearFlag 19)
					(gEgo posn: 164 146)
				)
				(gEgo
					ignoreHorizon: 1
					ignoreActors: 1
					illegalBits: 0
					view: 14
					setLoop: 1
					setCel: 0
					setCycle: 0
					setPri: 13
					setStep: 1 4
					moveSpeed: 0
					setMotion: MoveTo 150 186 self
				)
			)
			(1
				((ScriptID 0 21) number: 14 loop: 1 init: play:) ; gameSound
				(gEgo setCel: -1 setCycle: End self)
			)
			(2
				(= global130 4)
				(= seconds 3)
			)
			(3
				((ScriptID 0 21) number: 51 loop: -1 play:) ; gameSound
				(gEgo
					show:
					view: 13
					illegalBits: -24576
					setStep: 1 1
					setCycle: Fwd
					setLoop: -1
					setCel: -1
					setPri: -1
					cycleSpeed: 0
					ignoreActors: 0
				)
				(= global136 3000)
				(gCurRoom setScript: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance splashBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(SetFlag 47)
				(bucket
					view: 249
					setLoop: 2
					setCel: 0
					ignoreActors:
					setMotion: MoveTo 170 186 self
				)
			)
			(2
				((ScriptID 0 21) number: 14 loop: 1 init: play:) ; gameSound
				(bucket setLoop: 3 setCycle: End self)
			)
			(3
				(bucket
					setLoop: 4
					ignoreActors: 0
					setCycle: Fwd
					setMotion: MoveTo 171 180 self
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance cutOffBucket of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (< state 3)
			(gEgo setStep: 1 (+ (gEgo yStep:) 1))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bucket setScript: splashBucket)
				(gEgo
					ignoreHorizon: 1
					ignoreActors: 1
					illegalBits: 0
					view: 14
					setLoop: 1
					setCel: 0
					setCycle: 0
					setPri: 13
					setStep: 1 4
					moveSpeed: 0
					setMotion: MoveTo 150 186 self
				)
			)
			(1
				((ScriptID 0 21) number: 14 loop: 1 init: play:) ; gameSound
				(gEgo setCel: -1 ignoreActors: 0 setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				((ScriptID 0 21) number: 51 loop: -1 play:) ; gameSound
				(gEgo
					show:
					view: 13
					illegalBits: -24576
					setStep: 1 1
					setCycle: Fwd
					setLoop: -1
					setCel: -1
					setPri: -1
					cycleSpeed: 0
				)
				(= global136 3000)
				(= global130 4)
				(gCurRoom setScript: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 47)
					(Print 49 61) ; "You'll have to be holding the bucket first."
					(self dispose:)
				else
					(HandsOff)
					(gEgo
						view: 13
						setStep: 1 1
						illegalBits: 0
						setMotion: MoveTo 159 176 self
					)
				)
			)
			(1
				((ScriptID 0 21) stop:) ; gameSound
				(gEgo
					setPri: 1
					view: 19
					setLoop: 0
					posn: 159 180
					setStep: 2 2
					setCycle: Fwd
					setMotion: MoveTo 159 156 self
				)
			)
			(2
				(gEgo setCycle: 0 setMotion: MoveTo 159 180 self)
			)
			(3
				(Print 49 62) ; "Unfortunately, the walls of the well are too slick and slimy to be climbed."
				((ScriptID 0 21) number: 51 loop: -1 init: play:) ; gameSound
				(gEgo
					illegalBits: -24576
					view: 13
					setStep: 1 1
					setCel: -1
					setLoop: -1
					setCycle: Fwd
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance well1 of NewFeature
	(properties
		x 158
		y 94
		noun '/(side[<well]),wall'
		nsTop -1
		nsLeft 117
		nsBottom 189
		nsRight 200
		description {well}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The sides of the well are damp and covered with algae and lichen.}
	)
)

(instance water1 of NewFeature
	(properties
		x 158
		y 183
		noun '/water[<well]'
		nsTop 177
		nsLeft 128
		nsBottom 189
		nsRight 188
		description {water}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The well-water is cold and clear.}
	)
)

(instance drowning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				((ScriptID 0 21) number: 96 loop: 1 init: play:) ; gameSound
				(gEgo
					setMotion: 0
					setLoop: 0
					view: 14
					cel: 5
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(gEgo cel: 5 setCycle: End self)
			)
			(2
				(gEgo cel: 5 setCycle: End self)
			)
			(3
				(gEgo hide:)
				(= seconds 4)
			)
			(4
				(if (not global136)
					(EgoDead
						{After swimming for a long time, your strength ebbs and your arms and legs grow weary.  As your life swims before your eyes, you decide to...}
					)
				else
					(EgoDead
						{You splash around for awhile, but unfortunately that won't keep your head above water.  As you go down for the third time, a sense of peace washes over you...}
					)
				)
			)
		)
	)
)

